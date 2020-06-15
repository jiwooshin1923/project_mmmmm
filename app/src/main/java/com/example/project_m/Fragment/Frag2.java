package com.example.project_m.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.project_m.R;
import com.example.project_m.search.search_frag1;
import com.example.project_m.search.search_frag2;
import com.example.project_m.search.search_frag3;
import com.example.project_m.search.search_frag4;
import com.google.android.material.tabs.TabLayout;


public class Frag2 extends Fragment {

    private search_frag1 s_frag1; //검색 탭프래그먼트
    private search_frag2 s_frag2;
    private search_frag3 s_frag3;
    private search_frag4 s_frag4;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.frag2, container, false);

        s_frag1 = new search_frag1();
        s_frag2 = new search_frag2();
        s_frag3 = new search_frag3();
        s_frag4 = new search_frag4();


        //처음 childfragment 지정
        getFragmentManager().beginTransaction().add(R.id.child_fragment_container, new search_frag1()).commit();

        //하위버튼
        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { //탭아이템선택시 이벤트

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
              switch(tab.getPosition()){
                  case 0 :
                      getFragmentManager().beginTransaction().replace(R.id.child_fragment_container, new search_frag1()).commit();
                    //  child_fragment_container      = frag2안에 있는 framelayout 아이디값.
                      break ;
                  case 1 :
                      getFragmentManager().beginTransaction().replace(R.id.child_fragment_container, new search_frag2()).commit();

                      break ;
                  case 2 :
                      getFragmentManager().beginTransaction().replace(R.id.child_fragment_container, new search_frag3()).commit();
                      break ;
                  case 3 :
                      getFragmentManager().beginTransaction().replace(R.id.child_fragment_container, new search_frag4()).commit();
                      break ;
              }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return v;
    }
    }




