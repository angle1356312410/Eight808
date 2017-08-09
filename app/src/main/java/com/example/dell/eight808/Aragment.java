package com.example.dell.eight808;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.dell.eight808.Adapter.MyAdapter;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Aragment extends Fragment {


    private ListView listview;
    private UserDao userDao;
    private List<User> list;
    private MyAdapter adapter;
    private Button updata;
    private Button delete1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_aragment, null);

        initView(view);
        getDta();
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getActivity(), "user.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
        DaoSession daoSession = daoMaster.newSession();
        userDao = daoSession.getUserDao();
        list = userDao.queryBuilder().build().list();

        for (int i = 0; i < 10; i++) {
            User user = new User(null, "张三", "男", "15632514255");
            userDao.insert(user);
        }
        adapter = new MyAdapter(getActivity(), list);
        listview.setAdapter(adapter);


        return view;


    }

    private void getDta() {
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                View view1 = View.inflate(getActivity(), R.layout.pop, null);
                updata = (Button) view1.findViewById(R.id.updata);

                delete1 = (Button) view1.findViewById(R.id.delete1);
                PopupWindow popupWindow = new PopupWindow(view1, 200, 200);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
                popupWindow.showAtLocation(view, Gravity.CENTER, 20, 20);

                delete1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        userDao.delete(list.get(position));
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });

                updata.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getActivity(),Main3Activity.class);
                        intent.getIntExtra("position",0);
                        startActivity(intent);
                    }
                });

            }
        });

    }

    private void initView(View view) {
        listview = (ListView) view.findViewById(R.id.listview);
    }
}
