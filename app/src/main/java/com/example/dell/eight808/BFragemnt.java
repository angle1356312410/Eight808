package com.example.dell.eight808;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import static android.R.id.list;


/**
 * A simple {@link Fragment} subclass.
 */
public class BFragemnt extends Fragment implements View.OnClickListener {


    private EditText ed_name;
    private EditText ed_sex;
    private EditText ed_phone;
    private Button add;
    private UserDao userDao;

    private String name;
    private String sex;
    private String phone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_bfragemnt, null);

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getActivity(), "user.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
        DaoSession daoSession = daoMaster.newSession();
        userDao = daoSession.getUserDao();

        initView(view);
        return view;
    }

    private void initView(View view) {
        ed_name = (EditText) view.findViewById(R.id.ed_name);
        ed_sex = (EditText) view.findViewById(R.id.ed_sex);
        ed_phone = (EditText) view.findViewById(R.id.ed_phone);
        add = (Button) view.findViewById(R.id.add);

        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                submit();
                User user=new User(null,name,sex,phone);
                userDao.insert(user);
                Toast.makeText(getActivity(), "添加成功啦", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(),Main2Activity.class);
                startActivity(intent);
                break;
        }
    }

    private void submit() {
        // validate
        name = ed_name.getText().toString().trim();


        sex = ed_sex.getText().toString().trim();


        phone = ed_phone.getText().toString().trim();

    }
}
