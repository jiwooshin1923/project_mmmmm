package com.example.project_m;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    EditText register_name,register_age,register_email,register_password;
    Button register_join_ok,register_join_cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register_name = findViewById(R.id.register_name); //edit text 이름
        register_age = findViewById(R.id.register_age);//edit text 나이
        register_email = findViewById(R.id.register_email);//edit text 이메일
        register_password = findViewById(R.id.register_password);//edit text 비밀번호

        register_join_ok = findViewById(R.id.register_join_ok);//버튼 회원가입 등록
        register_join_cancel = findViewById(R.id.register_join_cancel);//버튼 회원가입 취소

        register_join_ok.setOnClickListener(new View.OnClickListener() {
            // 등록버튼 수행
            @Override
            public void onClick(View view) {
                String email = register_email.getText().toString();
                String age = register_age.getText().toString();
                String name = register_name.getText().toString();
                String password = register_password.getText().toString();

                if(TextUtils.isEmpty(email)){
                    register_email.setError("이메일을 입력하세요");
                }if(TextUtils.isEmpty(password)){
                    register_email.setError("비밀번호을 입력하세요");
                }if(TextUtils.isEmpty(age)){
                    register_email.setError("나이를 입력하세요");
                }if(TextUtils.isEmpty(name)){
                    register_email.setError("성함을 입력하세요");
                }if(password.length()<=6) {
                    register_password.setError("비밀번호가 짧습니다 최소 6자리 이상");
                }
                    else{
                        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "가입 성공", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(register.this, Login.class); //인텐트를 이용한 화면넘기기
                                    startActivity(intent); //실행
                                } else {
                                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                }
            }
        });

        register_join_cancel.setOnClickListener(new View.OnClickListener() {
            //취소 로그인화면으로 돌리기
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(register.this, Login.class); //인텐트를 이용한 화면넘기기
                startActivity(intent); //실행

            }
        });
    }
}