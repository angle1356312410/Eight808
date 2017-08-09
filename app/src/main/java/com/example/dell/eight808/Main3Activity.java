package com.example.dell.eight808;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import static android.R.id.list;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText ed_name;
    private EditText ed_sex;
    private EditText ed_phone;
    private Button updata;
    private String name;
    private String sex;
    private String phone;
    private UserDao userDao;
    private List<User> list;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(Main3Activity.this, "user.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
        DaoSession daoSession = daoMaster.newSession();
        userDao = daoSession.getUserDao();
        list = userDao.queryBuilder().build().list();

        position = getIntent().getIntExtra("position", 0);
        initView();
    }

    private void initView() {
        ed_name = (EditText) findViewById(R.id.ed_name);
        ed_sex = (EditText) findViewById(R.id.ed_sex);
        ed_phone = (EditText) findViewById(R.id.ed_phone);
        updata = (Button) findViewById(R.id.updata);

        updata.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.updata:
                submit();


                Toast.makeText(this, "修改成功啦", Toast.LENGTH_SHORT).show();
                List<User> list = userDao.queryBuilder().build().list();
                User user = list.get(position);

                user.setName(name);
                user.setSex(sex);
                user.setPhone(phone);

                userDao.update(user);
                startActivity(new Intent(Main3Activity.this, Main2Activity.class));

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
