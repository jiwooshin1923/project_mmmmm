package com.example.project_m.Fragment;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import com.example.project_m.R;
import com.example.project_m.comment.Comment_activity;
import com.example.project_m.comment_main;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class Frag1 extends Fragment {

    private Button button1;
    private Button comment;
    private  Button vids_size;
    private  Button button3;
    private String subject = "메시지 제목";
    private String text = "메시지 내용은 \n다음줄에서...";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.frag1,container,false)  ;




         final Button button1 =rootView.findViewById(R.id.button1);
        final Button comment =rootView.findViewById(R.id.comment);
        final Button vids_size =rootView.findViewById(R.id.vids_size);
        final Button button3 = rootView.findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setSelected(!v.isSelected());//버튼 선택여부 반전
               //  if (v.isSelected()) {//현재 눌린상태

                if (button1.isSelected()) {
                    button1.setSelected(true);
                }
                else{
                    button1.setSelected(false);
                }
               //  button1.callOnClick();


     /*   //현재 좋아요 개수 파악 +1 재설정
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
                Intent intent = new Intent(getActivity(), Comment_activity.class);
                startActivity(intent);
            }
        });

        vids_size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setSelected(!v.isSelected());//버튼 선택여부 반전
                // if (v.isSelected()) {//현재 눌린상태

                if (vids_size.isSelected()) {
                    vids_size.setSelected(true);
                } else {
                    vids_size.setSelected(false);
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
  //공유버튼

            public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,text);
            Intent chooser = Intent.createChooser(intent,"타이틀");
            startActivity(chooser);
            }
        });




         return rootView;
    }

}
