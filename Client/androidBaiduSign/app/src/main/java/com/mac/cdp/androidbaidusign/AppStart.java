package com.mac.cdp.androidbaidusign;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.mac.cdp.androidbaidusign.bean.BaiduUser;
import com.mac.cdp.androidbaidusign.dao.BaiduUserDao;
import com.mac.cdp.androidbaidusign.dao.Master;
import com.mac.cdp.androidbaidusign.dao.Session;

import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

//import com.mac.cdp.androidbaidusign.myService.updateAppService;

public class AppStart extends Activity {

//    public void  greenmethone1(){
//        Master.DevOpenHelper dbhelp=new Master.DevOpenHelper(this,"dbname",null);
//        SQLiteDatabase db=dbhelp.getWritableDatabase();
//        DaoConfig dc=new DaoConfig(db,BaiduUserDao.class);
//        BaiduUserDao dao=new BaiduUserDao(dc);
//        BaiduUser baiduUser=new BaiduUser(null,"tel","name1","pwd","mail");
//        dao.insert(baiduUser);
//    }
//    public void  greenmethone2(){
//        Master.DevOpenHelper dbhelp=new Master.DevOpenHelper(this,"dbname",null);
//        SQLiteDatabase db=dbhelp.getWritableDatabase();
//        Master master=new Master(db,200);
//        //todo 不清楚master有啥用
//
////        master.registerDao(BaiduUserDao.class);
//        Session session=master.newSession();
//
//        DaoConfig dc=new DaoConfig(db,BaiduUserDao.class);
//        session.registerDao(BaiduUser.class,new BaiduUserDao(dc));
////        BaiduUserDao dao=new BaiduUserDao(dc);
//        BaiduUser baiduUser=new BaiduUser(null,"tel","name  session no master","pwd","mail");
//        session.insert(baiduUser);
//        Log.e("gree baidu end ","name2");
//
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //methon1

//        greenmethone2();
//        session.
        setContentView(R.layout.activity_app_start);
        Boolean autoupdate= getSharedPreferences("config",Context.MODE_PRIVATE).getBoolean("config", true);
        if(autoupdate){
//            Intent intent=new Intent(this,updateAppService.class);
//            startService(intent);
        }
        iniConfigAndSave();
        redirctToMain();
//        SharedPreferences sharedPref = context.getSharedPreferences(
//        getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    }

    private  void iniConfigAndSave(){
        SharedPreferences.Editor edit= getSharedPreferences("config",Context.MODE_PRIVATE).edit();
        edit.putBoolean("autoupadte",true);
        edit.commit();
    }
    private void redirctToMain(){
        Intent intent=new Intent(this,MainActivity.class);
//        Intent intent=new Intent(this,tabtest.class);
        startActivity(intent);
        //出栈
        finish();
    }

}
