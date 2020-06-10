package com.example.project_m.DM;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project_m.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class DM_activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    public RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
   private List<DM_Data> commentList;

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
              DM_Data chat =new DM_Data();
              chat.setNickname(nick);
              chat.setComment(comment);
              myRef.push().setValue(chat);
              EditText_comment.setText("");
          }

            }
        });
        mRecyclerView= findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager=new LinearLayoutManager(this);  //레이아웃 설정
        mRecyclerView.setLayoutManager(mLayoutManager);
    //리사이클러뷰 세팅


        commentList=new ArrayList<>(); //DM_Data 객체 (닉네임,댓글)넣기


        //adapter 생성
        mAdapter=new DM_Adapter(commentList, DM_activity.this,nick);
        mRecyclerView.setAdapter(mAdapter);

     ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener(){

                 @Override
               public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                              Toast.makeText(DM_activity.this, "클릭한 아이템의 이름은 " + commentList.get(position).getComment(), Toast.LENGTH_SHORT).show();
                 }
              });

        ItemClickSupport.addTo(mRecyclerView).setOnItemLongClickListener(new ItemClickSupport.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClicked(RecyclerView recyclerView, int position, View v) {
                Toast.makeText(DM_activity.this, "길게 눌렀구나 " + commentList.get(position).getComment(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });




        //파베 설정
        FirebaseDatabase database = FirebaseDatabase.getInstance();
         myRef = database.getReference();


      /* DM_Data chat =new DM_Data();
        chat.setNickname(nick);
        chat.setComment("hi");
        myRef.setValue(chat);*/

  //파베
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.d("CHATCHAT", dataSnapshot.getValue().toString());
              DM_Data chat=   dataSnapshot.getValue(DM_Data.class);
                ((DM_Adapter) mAdapter).addComment(chat);

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
