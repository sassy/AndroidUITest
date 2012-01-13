package com.example.atec.ui.test;

import com.example.atec.ui.HelloAndroidActivity;
import com.example.atec.ui.SecondAndroidActivity;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;

public class HelloAndroidActivityTest2 extends ActivityUnitTestCase<HelloAndroidActivity> {

    public HelloAndroidActivityTest2() {
        super(HelloAndroidActivity.class);
    }

    public void testLifeCycle() throws Exception {
        Intent intent = new Intent();
        HelloAndroidActivity target = startActivity(intent, null, null);
        assertEquals(0, target.getY());
        getInstrumentation().callActivityOnStart(target);
        assertEquals(1, target.getY());
        getInstrumentation().callActivityOnResume(target);
        assertEquals(2, target.getY());
    }
    
    public void testButton() throws Exception {
        Intent intent = new Intent();
        HelloAndroidActivity activity = startActivity(intent, null, null);
        final Button button = (Button)activity.findViewById(com.example.atec.ui.R.id.button2);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button.performClick();
            }
        });
        getInstrumentation().waitForIdleSync();
        
        Intent target = getStartedActivityIntent();
        String ret = target.getComponent().getClassName();
        assertEquals(SecondAndroidActivity.class.getName(), ret);
        
        int request_code = getStartedActivityRequest();
        assertEquals(100, request_code);
    }
}
