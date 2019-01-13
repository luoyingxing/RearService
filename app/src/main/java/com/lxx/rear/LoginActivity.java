package com.lxx.rear;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.lxx.rear.frame.base.BaseActivity;

/**
 * <p/>
 * Created by luoyingxing on 2019/1/13.
 */
public class LoginActivity extends BaseActivity {
    private EditText accountET;
    private EditText passwordET;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        accountET = findViewById(R.id.et_login_account);
        passwordET = findViewById(R.id.et_login_password);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountET.getText().toString().trim();
                String password = passwordET.getText().toString().trim();

                if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
                    showToast("账号或者密码不能为空！");
                } else {
                    if (account.equals("tanglianhai") && password.equals("123456")) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        showToast("账号或者密码不正确，请重新输入！");
                    }
                }
            }
        });
    }
}
