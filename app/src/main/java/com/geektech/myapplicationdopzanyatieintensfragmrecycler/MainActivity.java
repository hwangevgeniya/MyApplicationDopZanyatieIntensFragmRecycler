package com.geektech.myapplicationdopzanyatieintensfragmrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Adapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<Person> list = new ArrayList<>();

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_click);
        editText = findViewById(R.id.et_edittext);
        adapter = new Adapter();
        recyclerView = findViewById(R.id.rv_recycler);
        createList();
        adapter.setList(list); //отправляем лист данными
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


        button.setOnClickListener(v->{
            if(editText != null){

                Intent intent = new Intent(this, MainActivity2.class);
                intent.putExtra("key", editText.getText().toString());
                startActivity(intent);
            }
        });

    }

    private void createList() {
        for (int i = 0; i < 10; i++) {
            list.add(new Person("A", "AA"));
        }
        list.add(new Person("end", "end"));
    }


}