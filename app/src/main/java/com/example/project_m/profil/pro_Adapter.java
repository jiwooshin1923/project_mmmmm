package com.example.project_m.profil;

<<<<<<< HEAD
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

=======
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
>>>>>>> enho
import com.example.project_m.R;

import java.util.ArrayList;

<<<<<<< HEAD
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






=======
public class pro_Adapter extends RecyclerView.Adapter<pro_Adapter.MainViewHolder>  {

    private ArrayList<Item> mDataset;
    private Activity activity;

    static class MainViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        MainViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public pro_Adapter(Activity activity, ArrayList<Item> myDataset) {
        this.mDataset = myDataset;
        this.activity = activity;
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }

    @NonNull
    @Override
    public pro_Adapter.MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.search_frag1, parent, false);
        final MainViewHolder mainViewHolder = new MainViewHolder(cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MainViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        ImageView photoImageVIew = cardView.findViewById(R.id.imageView2);
        TextView nameTextView = cardView.findViewById(R.id.nametext);
        TextView addressTextView = cardView.findViewById(R.id.textView5);

        Item userInfo = mDataset.get(position);
        if(mDataset.get(position).getProfile() != null){
            Glide.with(activity).load(mDataset.get(position).getProfile()).centerCrop().override(500).into(photoImageVIew);
        }
        nameTextView.setText(userInfo.getName());
        addressTextView.setText(userInfo.getFollowing());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
>>>>>>> enho
}
