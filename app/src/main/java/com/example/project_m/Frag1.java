package com.example.project_m;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import com.example.project_m.R;

public class Frag1 extends Fragment {

    private Button button1;
    private Button comment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.frag1,container,false)  ;


         final Button button1 =rootView.findViewById(R.id.button1);
        final Button comment =rootView.findViewById(R.id.comment);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setSelected(!v.isSelected());//버튼 선택여부 반전
                // if (v.isSelected()) {//현재 눌린상태

                if (button1.isSelected()) {
                    button1.setSelected(true);
                }
                else{
                    button1.setSelected(false);
                }
                // button1.callOnClick();


   /*      //현재 좋아요 개수 파악 +1 재설정
         int count = Integer.parseInt(좋아요개수변수.getText().toString());
         좋아요변수.setText(Integer.toString(++count));
     }
     else{
         //현재 좋아요 개수 파악 -1 값으로 재설정
         int count = Integer.parseInt(좋아요개수변수.getText().toString());
         좋아요개수변수.setText(Integer.toString(--count));
     }*/

            }

        });


        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),comment_main.class);
                startActivity(intent);
            }
        });
     /*   public void oncreateoptionsMenu(Menu menu){
            super.onCreateOptionsMenu(menu, inflater);
        }
        ActionBar actionBar=((MainActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("연습용액션바");
        actionBar.setDisplayHomeAsUpEnabled(false);//뒤로가기 버튼*/
         return rootView;
    }

}
