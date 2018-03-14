package com.malei.virtualapkpro;

import android.app.Application;
import android.content.Context;

import com.didi.virtualapk.PluginManager;

/**
 * @author by malei on 2018/3/12.
 */

public class MyApplication extends Application{

    @Override
    protected void attachBaseContext(Context context)  {
        super.attachBaseContext(context);
        PluginManager.getInstance(context).init();
    }
}
