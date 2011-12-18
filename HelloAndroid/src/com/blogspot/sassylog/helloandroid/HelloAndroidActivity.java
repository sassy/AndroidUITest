package com.blogspot.sassylog.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelloAndroidActivity extends Activity {
    private int x = 0;
    private int y = 0;
    
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
    }
    
    @Override
    protected void onStart() {
        y = 1;
        super.onStart();
    }
    
    @Override
    protected void onResume() {
        y = 2;
        super.onResume();
    }
 
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}