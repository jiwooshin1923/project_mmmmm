package com.example.project_m.profil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_m.R;

import java.util.ArrayList;

public class pro_Adapter extends RecyclerView.Adapter<pro_Adapter.MyViewHolder>  {


    private ArrayList<Item> mList;
    private LayoutInflater mInflate;
    private Context mContext;

    public pro_Adapter(Context context, ArrayList<Item> list) {
        this.mList = list;
        this.mContext = context;
        this.mInflate = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflate.inflate(R.layout.activity_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //포스터만 출력하자.

        holder.quote.setText("\"" + mList.get(position).getQuote()+ "\"");
        holder.quthor.setText("-" + mList.get(position).getAuthor());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ;
        public TextView quote;
        public TextView quthor;

        public MyViewHolder(View itemView) {
            super(itemView);

            quote = (TextView) itemView.findViewById(R.id.textView);
            quthor = (TextView) itemView.findViewById(R.id.textView5);
        }
    }






}
