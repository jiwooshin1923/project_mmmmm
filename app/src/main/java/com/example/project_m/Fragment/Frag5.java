package com.example.project_m.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.project_m.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Frag5 extends Fragment {
    private static final String TAG = "Frag5";
    public Frag5() {
        // Required empty public constructor
    }

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag5, container, false);

        final ImageView profileImageView = view.findViewById(R.id.imageView2);
        final TextView nameTextView = view.findViewById(R.id.nametext);
        final TextView introductionTextView = view.findViewById(R.id.textView5);
        final TextView likeTextView = view.findViewById(R.id.textView6);
        final TextView followerTextView = view.findViewById(R.id.textView7);
        final TextView followingTextView = view.findViewById(R.id.textView8);

        DocumentReference documentReference = FirebaseFirestore.getInstance().collection("Frag5").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null) {
                        if (document.exists()) {
                            Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                            if(document.getData().get("profile") != null){
                                Glide.with(getActivity()).load(document.getData().get("profile")).centerCrop().override(500).into(profileImageView);
                            }
                            nameTextView.setText(document.getData().get("name").toString());
                            introductionTextView.setText(document.getData().get("introduction").toString());
                            likeTextView.setText(document.getData().get("like").toString());
                            followerTextView.setText(document.getData().get("follower").toString());
                            followingTextView.setText(document.getData().get("following").toString());
                        } else {
                            Log.d(TAG, "No such document");
                        }
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
     /*   //for create home button

        //       툴바 셋팅
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        MainActivity activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
//        actionBar.set
        View viewToolbar = getActivity().getLayoutInflater().inflate(R.layout.frag5, null);
      //커스터마이증하고싶은 툴바 레이아웃

        //클릭이벤트 예시
        *//*Button btn = (Button)viewToolbar.findViewById(R.id.toolbar_btn_mark);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).getToolbarFragment(MainActivity.FRAGMENT_MARKED);
            *//*


        actionBar.setCustomView(viewToolbar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));*/
        return view;
    }
}
