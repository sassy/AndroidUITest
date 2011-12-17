package com.blogspot.sassylog.helloandroid.test;

import com.blogspot.sassylog.helloandroid.HelloAndroidActivity;

import android.content.Intent;
import android.test.ActivityUnitTestCase;

public class HelloAndroidActivityTest2 extends ActivityUnitTestCase<HelloAndroidActivity> {

    public HelloAndroidActivityTest2() {
        super(HelloAndroidActivity.class);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    public void testButton1() throws Exception {
        Intent intent = new Intent();
        HelloAndroidActivity target = startActivity(intent, null, null);
        assertEquals(0, target.getY());
        getInstrumentation().callActivityOnStart(target);
        assertEquals(1, target.getY());
        getInstrumentation().callActivityOnResume(target);
        assertEquals(2, target.getY());
    }
    

}
