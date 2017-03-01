package com.example.hunanliu.autotest;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiWatcher;

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
    public void UiWatchTest(){UiWatcher watcher=new UiWatcher() {
        @Override
        public boolean checkForCondition() {
            UiObject2 smallscreen = device.findObject(By.res("android:id/title"));
            UiObject2 fullscreen = device.findObject(By.res("glow_pad_view"));
            if (smallscreen != null) {
                smallscreen.click();
                try {
                    sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                UiObject2 endcall = device.findObject(By.res("com.android.dialer:id/floating_end_call_action_button"));
                endcall.click();
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return true;
            }

            return false;
        }

        @Before
        public void steup() throws InterruptedException {
            device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
            device.pressBack();
            sleep(1000);
            device.pressBack();
            sleep(1000);
            device.pressHome();
            sleep(3000);

        }

        ;


        @Test
        public void TestComiingCall() throws InterruptedException {
            UiObject2 phone = device.findObject(By.desc("Phone"));
//        System.out.println(phone.getText());
            while (true) {
                device.pressBack();
                sleep(500);
                device.pressBack();
                sleep(500);
                device.pressHome();
                sleep(2000);
                phone.click();
                sleep(3000);
                UiObject2 one = device.findObject(By.res("com.android.dialer:id/dialpad_key_number"));
                one.click();

            }
        }

        public void sleep(int time) throws InterruptedException {
            Thread.sleep(time);
        }
    }