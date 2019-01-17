package always.remember.maple.xuhuang;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private static Context mContext;//全局上下文对象

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

    }

    public static Context getContext() {
        return mContext;
    }


}
