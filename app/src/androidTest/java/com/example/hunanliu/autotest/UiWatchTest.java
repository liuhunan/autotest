package com.example.hunanliu.autotest;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiWatcher;
import android.util.Log;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by hunan.liu on 2017/2/28.
 */
@RunWith(AndroidJUnit4.class)
public class UiWatchTest {
    Instrumentation instrumentation;
    UiDevice device;
    public void sleep(int time) throws InterruptedException {
        Thread.sleep(time);
    }

        @Before
        public void steup() throws InterruptedException {
            device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        }

        ;


        @Test

        public void TestComiingCall() throws InterruptedException {
            UiObject2 phone = device.findObject(By.text("Phone"));
//        System.out.println(phone.getText());
            while (true) {
                String TAG="liuhunan";


                device.pressBack();
                sleep(500);
                device.pressBack();
                sleep(500);
                device.pressHome();
                sleep(3000);

                phone.click();
                sleep(3000);
                UiObject2 one = device.findObject(By.res("com.android.dialer:id/dialpad_key_number"));
                one.click();

            }
        }


    }