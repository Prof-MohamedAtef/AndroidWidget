package mo.ed.aad.mywidget.service;

import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.Nullable;

import java.util.HashMap;

import mo.ed.aad.mywidget.Config;
import mo.ed.aad.mywidget.SessionManagement;
import mo.ed.aad.mywidget.Widget.UrgentWidgetProvider;

/**
 * Created by Prof-Mohamed Atef on 1/27/2019.
 */

public class UrgentWidgetService extends IntentService {

    SessionManagement sessionManagement;
    HashMap<String, String> Urgent;

    public UrgentWidgetService(){
        super("DisplayUrgentService");
    }

    public static final String ACTION_Urgent=
            "mo.ed.aad.mywidget.covid19";

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent!=null){
            final String action=intent.getAction();
            if (ACTION_Urgent.equals(action)){
                handleActionUrgent();
            }
        }
    }

    private void handleActionUrgent() {
        sessionManagement=new SessionManagement(Config.mContext);
        Urgent=sessionManagement.getUrgentFromPrefs();
        if (Urgent!=null){
            String UrgentStr= Urgent.get(sessionManagement.KEY_Urgent);
            AppWidgetManager appWidgetManager= AppWidgetManager.getInstance(this);
            int[] appWidgetIds=appWidgetManager.getAppWidgetIds(new ComponentName(this, UrgentWidgetProvider.class));
            UrgentWidgetProvider.updateAppWidget(this,UrgentStr, appWidgetManager,appWidgetIds);
        }
    }

    public static void startActionFillWidget(Context context){
        Intent intent = new Intent(context, UrgentWidgetService.class);
        Config.mContext=context;
        intent.setAction(ACTION_Urgent);
        context.startService(intent);
    }
}