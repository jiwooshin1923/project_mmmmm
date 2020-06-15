package com.example.project_m;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
    TextView text;
    TextInputEditText TextInputEditText_email, TextInputEditText_password;
    RelativeLayout RelativeLayout_login;

    @Override

   public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputEditText_email = findViewById(R.id.TextInputEditText_email);
        TextInputEditText_password = findViewById(R.id.TextInputEditText_password);
        RelativeLayout_login = findViewById(R.id.RelativeLayout_login);


        RelativeLayout_login.setClickable(true); //버튼 활성화
        text = (TextView) findViewById(R.id.register);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 회원가입 클릭될 시 할 코드작성 textview
                Intent intent = new Intent(Login.this, register.class); //인텐트를 이용한 화면넘기기
                startActivity(intent); //실행
            }
        });

        RelativeLayout_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                String email = TextInputEditText_email.getText().toString();
                String password = TextInputEditText_password.getText().toString();

                if (TextInputEditText_email.getText().toString().equals("1234") && TextInputEditText_password.getText().toString().equals("1234")) {//로그인 성공
                    Intent intent = new Intent(Login.this, MainActivity.class); //인텐트를 이용한 화면넘기기
                    startActivity(intent); //실행
                } else


                    Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();


            }
        });
    }
}
