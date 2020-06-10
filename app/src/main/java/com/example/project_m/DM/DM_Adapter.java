package com.example.project_m.DM;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project_m.R;

import java.util.List;



public class DM_Adapter extends RecyclerView.Adapter<DM_Adapter.MyViewHolder> {
   public static final int HEADER = 0;
    public static final int CHILD = 1;

    private List<DM_Data> mDataset;
    private String myNickName;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView TextView_nickname;
        public TextView TextView_msg;
        public View rootView;
  /*      //public ImageView btn_expand_toggle;
        public  DM_Data  refferalItem;  //어댑터 객체*/


        public MyViewHolder(View v) {
            super(v);
            TextView_nickname = v.findViewById(R.id.TextView_nickname);
            TextView_msg = v.findViewById(R.id.TextView_msg);

           // btn_expand_toggle = (ImageView) itemView.findViewById(R.id.btn_expand_toggle);
            //레이아웃에 이미지 추가 해야함
            rootView = v;

        }


    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public DM_Adapter(List<DM_Data> myDataset, Context context, String myNickName) {
        //{"1","2"}
        mDataset = myDataset;
        this.myNickName = myNickName;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public DM_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType){

       /*  Context context = parent.getContext();
        float dp = context.getResources().getDisplayMetrics().density;
         int subItemPaddingLeft = (int) (18 * dp);
         int subItemPaddingTopAndBottom = (int) (5 * dp);*/
        // create a new view
                LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.row_comment, parent, false);

                MyViewHolder vh = new MyViewHolder(v);


                return vh;
      /*    case CHILD:
                TextView itemTextView = new TextView(context);
                itemTextView.setPadding(subItemPaddingLeft, subItemPaddingTopAndBottom, 0, subItemPaddingTopAndBottom);
                itemTextView.setTextColor(0x88000000);
                itemTextView.setLayoutParams(
                        new ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT));
                return new DM_Adapter.MyViewHolder(itemTextView) {
                };
        }
        return null;*/
        }

    //OnCreateViewHolder()는 해당 adapter와 연결하는 recyclerView에 추가할 item의 레이아웃과 item Data를 bind함.




    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position ) {
        //onBindViewHolder()는 recyclerView 자체와 item 데이터셋을 서로 연결시켜주는 과정이다.
        final DM_Data chat = mDataset.get(position);


  /*    switch (chat.) {
            case HEADER:
                final MyViewHolder itemController = (MyViewHolder) holder;
                itemController.refferalItem = chat;
                itemController.TextView_nickname.setText(chat.text);*/
                //댓글 버튼 현황에 따른 조건문
            /*    if (chat.invisibleChildren == null) {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus);
                } else {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus);
                }*/


/*                itemController.btn_cmt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (chat.getComment() == null) {
                            chat.invisibleChildren = new ArrayList<DM_Data>();
                            int count = 0;
                            int pos = data.indexOf(itemController.refferalItem);
                            while (data.size() > pos + 1 && data.get(pos + 1).type == CHILD) {
                                item.invisibleChildren.add(data.remove(pos + 1));
                                count++;
                            }
                            notifyItemRangeRemoved(pos + 1, count);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus);
                        } else {
                            int pos = data.indexOf(itemController.refferalItem);
                            int index = pos + 1;
                            for (Item i : item.invisibleChildren) {
                                data.add(index, i);
                                index++;
                            }
                            notifyItemRangeInserted(pos + 1, index - pos - 1);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus);
                            item.invisibleChildren = null;
                        }
                    }
                });
                break;
            case CHILD:
                TextView itemTextView = (TextView) holder.itemView;
                itemTextView.setText(data.get(position).text);
                break;
        }*/

      /*  Button btn_cmt = holder.btn_cmt;
        btn_cmt.setOnClickListener(new View.OnClickListener() {
                                       @Override

                                       public void onClick(View v) {
                                           Log.d("aaaa", "버튼을 누른 아이템의 위치는 " + position);
                                       }
                                   });*/

/*        Button btn_cmt = holder.btn_cmt;
        btn_cmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("aaaa", "버튼을 누른 아이템의 위치는 " +position);
                Context context = parent.getContext();
                TextView itemTextView = new TextView(context);
                itemTextView.setPadding(subItemPaddingLeft, subItemPaddingTopAndBottom, 0, subItemPaddingTopAndBottom);
                itemTextView.setTextColor(0x88000000);
                itemTextView.setLayoutParams(
                        new ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT));
                return new DM_Adapter.MyViewHolder(itemTextView) {
                };
            }
        });*/




                holder.TextView_nickname.setText(chat.getNickname());
                holder.TextView_msg.setText(chat.getComment());

                if (chat.getNickname().equals(this.myNickName)) {  //내아이디면 오른쪽정렬
                    holder.TextView_nickname.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
           holder.TextView_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);

                } else {  //아니면 왼쪽
                      holder.TextView_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                }

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount () {//getItemCount()는 데이터셋의 데이터 개수이다.

            //삼항 연산자
            return mDataset == null ? 0 : mDataset.size();
        }

        public DM_Data getchat (int position){
            return mDataset != null ? mDataset.get(position) : null;
        }

        public void addComment (DM_Data chat){
            mDataset.add(chat);
            notifyItemInserted(mDataset.size() - 1);//갱신용
        }

    }





