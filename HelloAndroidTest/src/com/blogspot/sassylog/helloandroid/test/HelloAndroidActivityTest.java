package com.blogspot.sassylog.helloandroid.test;

import com.blogspot.sassylog.helloandroid.HelloAndroidActivity;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
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
    
    public void testButton3() throws Exception {
        final Button button = (Button)activity.findViewById(com.blogspot.sassylog.helloandroid.R.id.button);
        TouchUtils.clickView(this, button);
        assertEquals(1, activity.getX());
    }
}
