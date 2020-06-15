package com.example.project_m.comment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_m.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class Comment_activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    public RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
   private List<Comment_Data> commentList;
private String nick ="nick_jiwoo";

private DatabaseReference myRef;
private EditText EditText_comment;
private Button Button_send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_activity);

 Button_send =findViewById(R.id.Button_send);
 EditText_comment =findViewById(R.id.EditText_comment);

        Button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          String comment= EditText_comment.getText().toString();

          if(comment !=null){
              Comment_Data chat =new Comment_Data();
              chat.setNickname(nick);
              chat.setComment(comment);
              myRef.push().setValue(chat);
          }

            }
        });
        mRecyclerView= findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
    //리사이클러뷰 세팅


        commentList=new ArrayList<>();
        mAdapter=new Comment_Adapter(commentList, Comment_activity.this,nick);

        mRecyclerView.setAdapter(mAdapter);


        //파베 설정
               FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();


      /* Comment_Data chat =new Comment_Data();
        chat.setNickname(nick);
        chat.setComment("hi");
        myRef.setValue(chat);*/


        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.d("CHATCHAT", dataSnapshot.getValue().toString());
              Comment_Data chat =   dataSnapshot.getValue(Comment_Data.class);
                ((Comment_Adapter) mAdapter).addComment(chat);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
