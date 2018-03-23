package com.softrixz.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText todoInput;
    Button submit;
    ListView listView;
    static ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoInput = findViewById(R.id.todoInput);
        submit = findViewById(R.id.submit);
        listView = findViewById(R.id.todolist);

        final TodoAdapter adapter = new TodoAdapter(this, list);
        listView.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = todoInput.getText().toString();

                if (!text.isEmpty()) {
                    list.add(text);
                    todoInput.setText("");
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Input is empty!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                list.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

    }
}
