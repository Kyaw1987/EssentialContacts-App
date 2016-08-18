package com.freelance.android.practiceEC;

import android.app.Application;
import android.content.Context;

import com.freelance.android.practiceEC.manager.DataManager;

/**
 * Created by Administrator on 06/09/2016.
 */
public class EContactsApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        DataManager.getObjInstance().loadEContactsList();
    }

    public static Context getContext(){
        return context;
    }
}
