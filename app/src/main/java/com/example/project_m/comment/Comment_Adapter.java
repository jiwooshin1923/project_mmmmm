package com.example.project_m.comment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project_m.R;

import java.util.List;



public class Comment_Adapter extends RecyclerView.Adapter<Comment_Adapter.MyViewHolder> {
    private List<Comment_Data> mDataset;
    private String myNickName;

    public Comment_Adapter(List<com.example.project_m.comment.Comment_Data> commentList, com.example.project_m.comment.Comment_activity context, String nick) {
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView TextView_nickname;
        public TextView TextView_msg;
        public View rootView;
        public MyViewHolder(View v) {
            super(v);
            TextView_nickname = v.findViewById(R.id.TextView_nickname);
            TextView_msg = v.findViewById(R.id.TextView_msg);
            rootView = v;

        }


    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public Comment_Adapter(List<Comment_Data> myDataset, Context context, String myNickName) {
        //{"1","2"}
        mDataset = myDataset;
        this.myNickName = myNickName;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public Comment_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
      LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_comment, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }//OnCreateViewHolder()는 해당 adapter와 연결하는 recyclerView에 추가할 item의 레이아웃과 item Data를 bind함.

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //onBindViewHolder()는 recyclerView 자체와 item 데이터셋을 서로 연결시켜주는 과정이다.


        Comment_Data chat = mDataset.get(position);

        holder.TextView_nickname.setText(chat.getNickname());
        holder.TextView_msg.setText(chat.getComment());

        if(chat.getNickname().equals(this.myNickName)) {  //내아이디면 오른쪽정렬
//            holder.TextView_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        }
        else {  //아니면 왼쪽
          //  holder.TextView_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {//getItemCount()는 데이터셋의 데이터 개수이다.

        //삼항 연산자
        return mDataset == null ? 0 :  mDataset.size();
    }

    public Comment_Data getchat(int position) {
        return mDataset != null ? mDataset.get(position) : null;
    }

    public void addComment(Comment_Data chat){
        mDataset.add(chat);
        notifyItemInserted(mDataset.size()-1);//갱신용
    }
}