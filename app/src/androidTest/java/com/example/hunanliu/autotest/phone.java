package com.example.hunanliu.autotest;

import android.app.Instrumentation;
import android.content.Context;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.base.IdlingResourceRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by hunan.liu on 2017/2/5.
 */
@RunWith(AndroidJUnit4.class)
public class phone {
    Instrumentation instrumentation;
    UiDevice device;
    Context context;

    @Before
    public void setup() throws RemoteException {
        device= UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        //context=InstrumentationRegistry.getTargetContext();
        device.wakeUp();
       sleep(2000);
        int width=device.getDisplayWidth();
        int hight=device.getDisplayHeight();
        device.swipe(width/2,hight,width/2,15*hight/20,5);

        device.pressBack();
        sleep(500);
        device.pressBack();
        sleep(500);
        device.pressHome();
        sleep(1500);}
    @Test
    //第一次进入电话
    public  void  firstintophone() throws UiObjectNotFoundException {
        UiObject2 phone = device.findObject(By.text("Phone"));
        phone.click();
        sleep(1500);
        UiObject2 dialer=device.findObject(By.desc("dial"));
       Assert.assertNotNull(dialer);
    }
  public static void sleep(int msecond){
      try {
          Thread.sleep(msecond);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }

    //退出电话应用
    @Test
    public void backexitphone(){

        device.pressBack();
        sleep(500);
        device.pressBack();
        sleep(500);
        UiObject2 dialer=device.findObject(By.desc("dial"));
        Assert.assertNull(dialer);
    }
    public void homeexitphone() throws UiObjectNotFoundException {
        firstintophone();
        device.pressHome();
        sleep(1000);
        UiObject2 dialer=device.findObject(By.desc("dial"));
        Assert.assertNull(dialer);
    }
    @Test
    public void nocalllog() throws UiObjectNotFoundException {
        firstintophone();
        sleep(1000);
        UiObject2 recents=device.findObject(By.text("Recents"));
        UiObject2 contacts=device.findObject(By.text("Contacts"));
        UiObject2 empty=device.findObject(By.res("com.android.dialer:id/emptyListViewMessage"));
        UiObject2 one=device.findObject(By.res("com.android.dialer:id/one"));
        UiObject2 two=device.findObject(By.res("com.android.dialer:id/two"));
        UiObject2 three=device.findObject(By.res("com.android.dialer:id/three"));
        UiObject2 four=device.findObject(By.res("com.android.dialer:id/four"));
        UiObject2 five=device.findObject(By.res("com.android.dialer:id/five"));
        UiObject2 six=device.findObject(By.res("com.android.dialer:id/six"));
        UiObject2 seven=device.findObject(By.res("com.android.dialer:id/seven"));
        UiObject2 eight=device.findObject(By.res("com.android.dialer:id/eight"));
        UiObject2 nine=device.findObject(By.res("com.android.dialer:id/nine"));
        UiObject2 zero=device.findObject(By.res("com.android.dialer:id/zero"));
        UiObject2 star=device.findObject(By.res("com.android.dialer:id/star"));
        UiObject2 pound=device.findObject(By.res("com.android.dialer:id/pound"));
        UiObject2 dialer=device.findObject(By.res("com.android.dialer:id/dialpad_floating_action_button"));
        UiObject2 dialpad=device.findObject(By.res("com.android.dialer:id/talpa_hide_dialpad"));
        Assert.assertNotNull(one);
        Assert.assertNotNull(two);
        Assert.assertNotNull(three);
        Assert.assertNotNull(four);
        Assert.assertNotNull(five);
        Assert.assertNotNull(six);
        Assert.assertNotNull(seven);
        Assert.assertNotNull(eight);
        Assert.assertNotNull(nine);
        Assert.assertNotNull(zero);
        Assert.assertNotNull(star);
        Assert.assertNotNull(pound);
        Assert.assertNotNull(dialer);
        Assert.assertNotNull(dialpad);}
    @Test
    public void inputnumber() throws UiObjectNotFoundException {
        firstintophone();
        sleep(1500);
        device.findObject(By.res("com.android.dialer:id/one")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/two")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/three")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/four")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/five")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/six")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/seven")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/eight")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/nine")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/zero")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/star")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/pound")).click();
        sleep(500);
        UiObject2 digits=device.findObject(By.res("com.android.dialer:id/digits"));
        String inputcontent= digits.getText().toString();
        inputcontent.equals("1234567890*#");
        UiObject2 del=device.findObject(By.res("com.android.dialer:id/deleteButton"));
        del.longClick();


    }
    @Test
    public void matchcontacts() throws UiObjectNotFoundException {
        firstintophone();
        device.findObject(By.res("com.android.dialer:id/one")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/five")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/eight")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/one")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/eight")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/three")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/nine")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/nine")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/zero")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/four")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/one")).click();
        sleep(500);
        UiObject2 name=device.findObject(By.text("liuhunan"));
        Assert.assertNotNull(name);
    }
    @Test
    public void addcontact() throws UiObjectNotFoundException {
        firstintophone();
        device.findObject(By.res("com.android.dialer:id/seven")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/seven")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/seven")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/seven")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/seven")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/seven")).click();
        sleep(500);
        device.findObject(By.res("com.android.dialer:id/seven")).click();
        sleep(500);
        UiObject2 addbutton=device.findObject(By.res("com.android.dialer:id/lists_pager_header_rl"));
        Assert.assertNotNull(addbutton);
        addbutton.click();
        sleep(500);
        UiObject2 creatnewcontact=device.findObject(By.text("Create new contact"));
        UiObject2 addtoexistcontact=device.findObject(By.text("Create new contact"));
        Assert.assertNotNull(creatnewcontact);
        Assert.assertNotNull(addtoexistcontact);

    }
    @Test
    //检查双卡拨号
    public void checkdoublesim() throws UiObjectNotFoundException, RemoteException {
        setup();
        device.pressBack();
        device.pressBack();
        UiObject2 apps=device.findObject(By.desc("Apps"));
        apps.click();
        sleep(500);
        UiObject2 settings=device.findObject(By.text("Settings"));
        settings.click();
        sleep(500);
        UiObject2 simcards=device.findObject(By.text("SIM cards"));
        simcards.click();
        sleep(500);
        UiObject2 calls=device.findObject(By.text("Calls"));
        calls.click();
        sleep(500);
        UiObject2 ask=device.findObject(By.text("Ask every time"));
        ask.click();
        sleep(500);
        device.pressBack();
        sleep(500);
        device.pressBack();
        sleep(500);
        device.pressBack();
        sleep(500);
        UiObject2 phone = device.findObject(By.text("Phone"));
        phone.click();
        sleep(1500);
        UiObject2 doublesimdialer=device.findObject(By.res("com.android.dialer:id/talpa_select_outgoing_phone_ll"));
        Assert.assertNotNull(doublesimdialer);
    }
    @Test
    public void checksingledialer1() throws RemoteException {
        setup();
        UiObject2 apps=device.findObject(By.desc("Apps"));
        apps.click();
        sleep(700);
        UiObject2 settings=device.findObject(By.text("Settings"));
        settings.click();
        sleep(700);
        UiObject2 simcards=device.findObject(By.text("SIM cards"));
        simcards.click();
        sleep(700);
        UiObject2 calls=device.findObject(By.text("Calls"));
        calls.click();
        sleep(700);
        UiObject2 sim1=device.findObject(By.text("SIM slot 1"));
        sim1.click();
        sleep(700);
        device.pressBack();
        sleep(700);
        device.pressBack();
        sleep(500);
        device.pressBack();
        sleep(500);
        UiObject2 phone = device.findObject(By.text("Phone"));
        phone.click();
        sleep(1500);
        UiObject2 dialer=device.findObject(By.desc("dial"));
        Assert.assertNotNull(dialer);

    }
    @Test
    //双卡设置卡2默认卡
    public void checksingledialer2() throws RemoteException {
        setup();
        UiObject2 apps=device.findObject(By.desc("Apps"));
        apps.click();
        sleep(500);
        UiObject2 settings=device.findObject(By.text("Settings"));
        settings.click();
        sleep(500);
        UiObject2 simcards=device.findObject(By.text("SIM cards"));
        simcards.click();
        sleep(600);
        UiObject2 calls=device.findObject(By.text("Calls"));
        calls.click();
        sleep(500);
        UiObject2 sim1=device.findObject(By.text("SIM slot 2"));
        sim1.click();
        sleep(500);
        device.pressBack();
        sleep(500);
        device.pressBack();
        sleep(500);
        device.pressBack();
        sleep(500);
        UiObject2 phone = device.findObject(By.text("Phone"));
        phone.click();
        sleep(1500);
        UiObject2 dialer=device.findObject(By.desc("dial"));
        Assert.assertNotNull(dialer);
    }

}

