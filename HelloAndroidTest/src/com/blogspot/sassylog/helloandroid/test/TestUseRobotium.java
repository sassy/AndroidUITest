package com.blogspot.sassylog.helloandroid.test;

import com.blogspot.sassylog.helloandroid.HelloAndroidActivity;
import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

public class TestUseRobotium extends ActivityInstrumentationTestCase2<HelloAndroidActivity> {

    private Solo solo;

    public TestUseRobotium() {
        super("com.blogspot.sassylog.helloandroid", HelloAndroidActivity.class);
    }
    
    @Override
    protected void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }
    
    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
    
    public void test_init() throws Exception {
        solo.assertCurrentActivity("current Activity", "HelloAndroidActivity");
        assertTrue(solo.searchText("Hello World, HelloAndroidActivity!"));
    }
    
    public void test_Button() throws Exception {
        solo.clickOnButton(1);
        assertEquals(1, getActivity().getX());
    }
    
    public void test_EditText() throws Exception {
        solo.enterText(0, "Animal");
        assertTrue(solo.searchText("Animal"));
    }
}
