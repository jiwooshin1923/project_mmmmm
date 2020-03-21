package com.example.project_m;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class comment_main extends AppCompatActivity {
    private ListView listview ;
    private ArrayAdapter adapter ;
    private ArrayList<String> items = new ArrayList<String>() ;
    private final String fileName = "items.list";


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.comment_main,container,false);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_main);

        //리스트뷰와 어댑터 초기화
        listview = (ListView) findViewById(R.id.listview1) ;
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, items) ;

        listview.setAdapter(adapter) ;

        //파일에서 데이터를 읽어들임  // 밑부분
        loadItemsFromFile() ;
        adapter.notifyDataSetChanged();

//추가버튼 이벤트
        Button buttonAdd = (Button) findViewById(R.id.buttonAdd) ;
        buttonAdd.setEnabled(false) ; // 초기 버튼 상태 비활성 상태로 지정.
        buttonAdd.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextNew = (EditText) findViewById(R.id.editTextNew) ;
                String strNew = (String) editTextNew.getText().toString() ;

                if (strNew.length() > 0) {
                    // 리스트에 문자열 추가.
                    items.add(strNew);

                    // 에디트텍스트 내용 초기화.
                    editTextNew.setText("") ;

                    // 리스트뷰 갱신
                    adapter.notifyDataSetChanged();

                    // 리스트뷰 아이템들을 파일에 저장.
                    saveItemsToFile() ;
                }
            }
        });

        //edit 내용 변경시 추가버튼 상태변경
        EditText editTextNew = (EditText) findViewById(R.id.editTextNew) ;
        editTextNew.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {
                Button buttonAdd = (Button) findViewById(R.id.buttonAdd) ;
                if (edit.toString().length() > 0) {
                    // 버튼 상태 활성화.
                    buttonAdd.setEnabled(true) ;
                } else {
                    // 버튼 상태 비활성화.
                    buttonAdd.setEnabled(false) ;
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        }) ;

        //삭제버튼
        Button buttonDel = (Button) findViewById(R.id.buttonDel) ;
        buttonDel.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count ;
                int checkedIndex ;

                count = adapter.getCount() ;

                if (count > 0) {
                    // 리스트뷰에서 선택된 아이템 인덱스 얻어오기.
                    checkedIndex = listview.getCheckedItemPosition();
                    if (checkedIndex > -1 && checkedIndex < count) {
                        // 아이템 삭제
                        items.remove(checkedIndex) ;

                        // 리스트뷰 선택 초기화.
                        listview.clearChoices();

                        // 리스트뷰 갱신
                        adapter.notifyDataSetChanged();

                        // 리스트뷰 아이템들을 파일에 저장.
                        saveItemsToFile() ;
                    }
                }
            }
        });


    }
    //리스트뷰 아이템을 파일에 저장하는 함수 작성.
    private void saveItemsToFile() {
        File file = new File(getFilesDir(), fileName) ;
        FileWriter fw = null ;
        BufferedWriter bufwr = null ;

        try {
            // 파일열기
            fw = new FileWriter(file) ;
            bufwr = new BufferedWriter(fw) ;

            for (String str : items) {
                bufwr.write(str) ;
                bufwr.newLine() ;
            }

            // 파일에 값입력
            bufwr.flush() ;

        } catch (Exception e) {
            e.printStackTrace() ;
        }

        try {
            // 파일닫기
            if (bufwr != null) {
                bufwr.close();
            }

            if (fw != null) {
                fw.close();
            }
        } catch (Exception e) {
            e.printStackTrace() ;
        }
    }

//리스트뷰 아이템을 파일로부터 읽어들이는 함수 .
    private void loadItemsFromFile() {
        File file = new File(getFilesDir(), fileName) ;
        FileReader fr = null ;
        BufferedReader bufrd = null ;
        String str ;

        if (file.exists()) {
            try {
                // open file.
                fr = new FileReader(file) ;
                bufrd = new BufferedReader(fr) ;

                while ((str = bufrd.readLine()) != null) {
                    items.add(str) ;
                }

                bufrd.close() ;
                fr.close() ;
            } catch (Exception e) {
                e.printStackTrace() ;
            }
        }
    }
}
