package com.blogspot.sassylog.helloandroid.test;

import com.blogspot.sassylog.helloandroid.HelloAndroidActivity;

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
        super("com.blogspot.sassylog.helloandroid", HelloAndroidActivity.class);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
        instrumentation = getInstrumentation();
    }

    public void testText() throws Exception {
        TextView view = (TextView) activity.findViewById(com.blogspot.sassylog.helloandroid.R.id.textView);
        String resourceString = activity.getString(com.blogspot.sassylog.helloandroid.R.string.hello);
        assertNotNull(resourceString, view.getText().toString());
    }
    
    public void testButton1() throws Exception {
        assertEquals(0, activity.getX());
    }
    
    public void testButton2() throws Exception {
        final Button button = (Button)activity.findViewById(com.blogspot.sassylog.helloandroid.R.id.button);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button.performClick();
            }
        });
        instrumentation.waitForIdleSync();
        assertEquals(1, activity.getX());
        
    }

    /* use touchUtils */
    public void testButton3() throws Exception {
        Button button = (Button)activity.findViewById(com.blogspot.sassylog.helloandroid.R.id.button);
        TouchUtils.clickView(this, button);
        assertEquals(1, activity.getX());
    }

    public void testSpinner0() throws Exception {
        Spinner spinner = (Spinner)activity.findViewById(com.blogspot.sassylog.helloandroid.R.id.spinner);
        assertTrue(spinner.getOnItemSelectedListener() != null);
        assertTrue(spinner.getAdapter() != null);
        assertEquals(3, spinner.getAdapter().getCount());
    }
    
    public void testSpinner1() throws Exception {
        final Spinner spinner = (Spinner)activity.findViewById(com.blogspot.sassylog.helloandroid.R.id.spinner);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                spinner.requestFocus();
            } 
        });
        instrumentation.waitForIdleSync();
        assertEquals("dog", spinner.getSelectedItem());
        assertEquals("dog", spinner.getItemAtPosition(spinner.getSelectedItemPosition()));
        assertEquals("dog", activity.getSelectedItem());

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                spinner.requestFocus();
                spinner.setSelection(1);
            } 
        });
        instrumentation.waitForIdleSync();
        assertEquals("cat", spinner.getSelectedItem());
        assertEquals("cat", spinner.getItemAtPosition(spinner.getSelectedItemPosition()));
        assertEquals("cat", activity.getSelectedItem());

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                spinner.requestFocus();
                spinner.setSelection(2);
            } 
        });
        instrumentation.waitForIdleSync();
        assertEquals("bird", spinner.getSelectedItem());
        assertEquals("bird", spinner.getItemAtPosition(spinner.getSelectedItemPosition()));
        assertEquals("bird", activity.getSelectedItem());
    }

    public void testSpinner2() throws Exception {
        final Spinner spinner = (Spinner)activity.findViewById(com.blogspot.sassylog.helloandroid.R.id.spinner);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                spinner.requestFocus();
            }
        });
        sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
        sendKeys(KeyEvent.KEYCODE_DPAD_DOWN);
        sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
        assertEquals("cat", spinner.getSelectedItem());
        assertEquals(spinner.getSelectedItem(), activity.getSelectedItem());
    }

    /* use TouchUtils */
    public void testSpinner3() throws Exception {
        Spinner spinner = (Spinner)activity.findViewById(com.blogspot.sassylog.helloandroid.R.id.spinner);
        TouchUtils.clickView(this, spinner);
        sendKeys(KeyEvent.KEYCODE_DPAD_DOWN);
        sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
        assertEquals(spinner.getSelectedItem(), activity.getSelectedItem());
    }

    public void testEditText0() throws Exception {
        EditText edit = (EditText)activity.findViewById(com.blogspot.sassylog.helloandroid.R.id.editer);
        assertTrue(edit.getText().toString().equals(""));
        assertNull(activity.getSendData());
    }

    public void testEditText1() throws Exception {
        final EditText edit = (EditText)activity.findViewById(com.blogspot.sassylog.helloandroid.R.id.editer);
        final Button button = (Button)activity.findViewById(com.blogspot.sassylog.helloandroid.R.id.send);
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
        assertEquals("fox", activity.getSendData());
    }

    /* use TouchUtils */
    public void testEditText2() throws Exception {
        EditText edit = (EditText)activity.findViewById(com.blogspot.sassylog.helloandroid.R.id.editer);
        Button button = (Button)activity.findViewById(com.blogspot.sassylog.helloandroid.R.id.send);
        TouchUtils.clickView(this, edit);
        sendKeys(KeyEvent.KEYCODE_C);
        sendKeys(KeyEvent.KEYCODE_O);
        sendKeys(KeyEvent.KEYCODE_W);
        TouchUtils.clickView(this, button);
        assertEquals("cow", activity.getSendData());
    }

}
