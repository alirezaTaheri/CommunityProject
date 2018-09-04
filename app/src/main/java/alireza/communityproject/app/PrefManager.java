package alireza.communityproject.app;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by alireza321 on 24/01/2018.
 */

public class PrefManager {
    SharedPreferences pref;

    public SharedPreferences.Editor editor;

    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "CommunityProject";

    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_HAS_NOTIFICATION = "notification";
    public PrefManager(Context context) {
        this._context = context;
        pref = CommunityApplication.getAppContext().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public void createLogin(String name, String email, String phone) {
        editor.putString(KEY_USERNAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PHONE, phone);
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.commit();
    }
    public void setHasNotification(boolean hasNotification){
        editor.putBoolean(KEY_HAS_NOTIFICATION,hasNotification);
        editor.commit();
    }
    public boolean hasNotification(){
        return pref.getBoolean(KEY_HAS_NOTIFICATION,false);
    }
    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false);
    }
    public void clearSession() {
        editor.clear();
        editor.commit();
    }

}
