package com.example.myapplication.app.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.app.MainActivity;
import com.example.myapplication.app.R;

import junit.runner.Version;

/**
 * Created by daisuke-ozaki on 2014/06/20.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity mActivity;
    TextView tv;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mActivity = getActivity();
        tv = (TextView)mActivity.findViewById(R.id.hello);
    }

    public void testGetMessage() throws Exception {
        String expected = "Hello";
        String actual = mActivity.getMessage();
        assertEquals(expected, actual);
    }

    public void testAdd() throws Exception {
        int expected = 2;
        int actual = mActivity.add(1, 1);
        assertEquals(expected, actual);
    }

    @UiThreadTest
    public void testGetVersion() throws Exception {
        String ver = Version.id();
        if (ver.length() > 0) {
            assertTrue(true);
            Toast.makeText(mActivity,ver, Toast.LENGTH_LONG).show();
            tv.setText(Version.id());
        } else {
            fail();
        }
    }

}
