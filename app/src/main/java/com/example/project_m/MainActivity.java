package com.example.project_m;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.project_m.Fragment.Frag1;
import com.example.project_m.Fragment.Frag2;
import com.example.project_m.Fragment.Frag3;
import com.example.project_m.Fragment.Frag4;
import com.example.project_m.Fragment.Frag5;
import com.google.android.material.bottomnavigation.BottomNavigationView;


//프래그먼트1번째화면에 버튼 다 넣기

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;

 /*   private VideoView videoView;  //비디오를 실행할수있게 도와주는뷰
    private MediaController mediaController; //재생이나 정지와 같은 미디어 제어 버튼부를 담당
    private String videoURL="http://www.radiantmediaplayer.com/media/bbb-360p.mp4";*/

    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private Frag5 frag5;





    @Override
    protected void onCreate(Bundle savedInstanceState) {//앱이 첫 실행됬을때 이곳을 수행
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        frag1 =new Frag1();
        frag2 =new Frag2();
        frag3 =new Frag3();
        frag4 =new Frag4();
        frag5 =new Frag5();

// 하단
        bottomNavigationView = findViewById(R.id.bottomNavi);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){





            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
                switch(menuItem.getItemId()){
                    case R.id.action_home:
                        setFrag(0);
             // 홈일경우 사용자정의함수 호출문


                        break;
                    case R.id.action_search:
                        setFrag(1);
                        break;
                    case R.id.action_add:
                        setFrag(2);
                        break;
                        case R.id.action_alarm:
                        setFrag(3);
                        break;
                    case R.id.action_person:
                        setFrag(4);
                        break;

                }
                return true;
            }
        });

        setFrag(0);  //첫 프래그먼트 화면을 무엇으로 지정해줄지 선택




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.select_menu, menu);
        return true;
    }



    @Override
    public void onBackPressed() {
        //super.onBackPressed();
         }
    //프래그 먼트 교체가 일어나는 실행문이다.
    private void setFrag(int n){
        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();//트랜젹션
        switch (n){
            case 0:
                ft.replace(R.id.main_frame,frag1);
                ft.commit();
                break;
                case 1:
                ft.replace(R.id.main_frame, frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame ,frag3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame ,frag4);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.main_frame ,frag5);
                ft.commit();
                break;

        }

    }


}

