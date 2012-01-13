package com.example.atec.ui.test;

import com.example.atec.ui.HelloAndroidActivity;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class HelloAndroidActivityTest extends ActivityInstrumentationTestCase2<HelloAndroidActivity> {

    private HelloAndroidActivity activity;
    private Instrumentation instrumentation;
 
    public HelloAndroidActivityTest() {
        super("com.example.atec.ui", HelloAndroidActivity.class);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
        instrumentation = getInstrumentation();
    }

    public void testEditText_initialize() throws Exception {
        EditText edit = (EditText)activity.findViewById(com.example.atec.ui.R.id.editer);
        TextView text = (TextView)activity.findViewById(com.example.atec.ui.R.id.result);
        assertEquals("", edit.getText().toString());
        assertEquals("", text.getText());
    }

    public void testEditText_checkInput() throws Exception {
        final EditText edit = (EditText)activity.findViewById(com.example.atec.ui.R.id.editer);
        final Button button = (Button)activity.findViewById(com.example.atec.ui.R.id.send);
        TextView result = (TextView)activity.findViewById(com.example.atec.ui.R.id.result);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                edit.requestFocus();
            }
        });
        instrumentation.waitForIdleSync();
        sendKeys(KeyEvent.KEYCODE_F);
        sendKeys(KeyEvent.KEYCODE_O);
        sendKeys(KeyEvent.KEYCODE_X);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button.performClick();
            }
        });
        instrumentation.waitForIdleSync();
        assertEquals("入力された値のチェック","fox", result.getText().toString());
    }

    /* use TouchUtils */
    public void testEditText_checkButtonClick() throws Exception {
        EditText edit = (EditText)activity.findViewById(com.example.atec.ui.R.id.editer);
        Button button = (Button)activity.findViewById(com.example.atec.ui.R.id.send);
        TextView result = (TextView)activity.findViewById(com.example.atec.ui.R.id.result);
        TouchUtils.clickView(this, edit);
        sendKeys(KeyEvent.KEYCODE_C);
        sendKeys(KeyEvent.KEYCODE_O);
        sendKeys(KeyEvent.KEYCODE_W);
        TouchUtils.clickView(this, button);
        assertEquals("ボタンがクリックされた時の値のチェック", "cow", result.getText().toString());
    }

}
