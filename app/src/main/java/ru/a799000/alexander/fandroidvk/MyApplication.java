package ru.a799000.alexander.fandroidvk;

import android.app.Application;

import com.vk.sdk.VKSdk;

import ru.a799000.alexander.fandroidvk.consts.ApiConstants;
import ru.a799000.alexander.fandroidvk.di.component.ApplicationComponent;
import ru.a799000.alexander.fandroidvk.di.component.DaggerApplicationComponent;
import ru.a799000.alexander.fandroidvk.di.module.ApplicationModule;

public class MyApplication extends Application {


    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initComponent();
        VKSdk.initialize(this);

    }

    private void initComponent() {

        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }
}
