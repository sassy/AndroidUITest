package com.blogspot.sassylog.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class HelloAndroidActivity extends Activity {
    private int x = 0;
    private int y = 0;
    private String selectedItem;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = 1;
            }
        });
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelloAndroidActivity.this, SecondAndroidActivity.class);
                startActivityForResult(intent, 100);
            }
        });

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.add("dog");
        adapter.add("cat");
        adapter.add("bird");
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = (String) parent.getSelectedItem();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedItem = null;
            }
        });
    }

    public void onTextUpdate(View v) {
        EditText edit = (EditText) v.getRootView().findViewById(R.id.editer);
        TextView text = (TextView) v.getRootView().findViewById(R.id.result);
        text.setText(edit.getText());
    }

    @Override
    protected void onStart() {
        super.onStart();
        y = 1;
    }

    @Override
    protected void onResume() {
        super.onResume();
        y = 2;
    }
 
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

}