package acer.ruwan.com;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

public class MyApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(MyApp.this, getString(R.string.admob_ad_id));
    }
}
