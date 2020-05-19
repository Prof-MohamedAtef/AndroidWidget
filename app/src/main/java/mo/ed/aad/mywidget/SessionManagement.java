package mo.ed.aad.mywidget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by Prof-Mohamed Atef on 12/28/2018.
 */

public class SessionManagement {
    public static SharedPreferences pref;
    public static SharedPreferences.Editor editor;
    public static Context _context;
    int PRIVATE_MODE = 0;
    public static final String PREFS_Logger = "LoggerFile";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_Profile_Pic = "profile_picture";
    public static final String KEY_idToken= "idToken";
    public static final String KEY_userID= "userID";
    public static final String KEY_LoginType= "LoginType";
    public static final String KEY_Urgent="Urgent";
    public static final String KEY_AD1="ADVICE1";
    public static final String KEY_AD2="ADVICE2";
    public static final String KEY_AD3="ADVICE3";


    public SessionManagement(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREFS_Logger, PRIVATE_MODE);
        editor = pref.edit();
    }



    public void createLoginSessionType(String type){
        editor.putString(KEY_LoginType, type);
        editor.commit();
    }

    public HashMap<String, String> getLoginType(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_LoginType, pref.getString(KEY_LoginType, null));
        return user;
    }


    public void createLoginSession(String name, String email, String AccountPhoto, String idToken, String userID){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_Profile_Pic, AccountPhoto);
        editor.putString(KEY_idToken, idToken);
        editor.putString(KEY_userID, userID);
        editor.commit();
    }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        user.put(KEY_Profile_Pic, pref.getString(KEY_Profile_Pic, null));
        user.put(KEY_idToken, pref.getString(KEY_idToken, null));
        return user;
    }

    public void createUrgentIntoPrefs(String Urgent){
        editor.putString(KEY_Urgent, Urgent);
        editor.putString(KEY_Urgent, Urgent);
        editor.apply();
    }

    public HashMap<String, String> getUrgentFromPrefs(){
        HashMap<String, String> Urgent=new HashMap<>();
        Urgent.put(KEY_Urgent, pref.getString(KEY_Urgent,null));
        return Urgent;
    }

    public void setCOVIDData(String advice1, String advice2, String advice3) {
        editor.putString(KEY_AD1,advice1);
        editor.putString(KEY_AD2,advice2);
        editor.putString(KEY_AD3,advice3);
        editor.apply();
    }
}
