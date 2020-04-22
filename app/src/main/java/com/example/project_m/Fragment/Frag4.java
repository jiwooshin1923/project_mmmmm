package com.example.project_m.Fragment;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.project_m.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Set;

public class Frag4 extends Fragment {

    private View view;
    private com.google.android.material.navigation.NavigationView NavigationView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.frag4, container, false);

/*
       NavigationView = view.findViewById(R.id.a_navi);
      NavigationView.setOnClickListener(new NavigationView.OnNavigationItemSelectedListener());{

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
                switch(menuItem.getItemId()){
                    case 0:
                        break;

                    case R.id.alarm_follower:

                        // 홈일경우 사용자정의함수 호출문


                        break;
                    case R.id.action_search:

                        break;
                    case R.id.alarm_heart:

                        break;
                    case R.id.alarm_tag:

                        break;
                    case R.id.alarm_comment:

                        break;

                }
                return true;
            }
        });*/

        return rootView;
    }


}
