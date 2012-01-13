package com.example.atec.ui;

import com.example.atec.ui.R;

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
        Button button2 = (Button)findViewById(R.id.button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelloAndroidActivity.this, SecondAndroidActivity.class);
                startActivityForResult(intent, 100);
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