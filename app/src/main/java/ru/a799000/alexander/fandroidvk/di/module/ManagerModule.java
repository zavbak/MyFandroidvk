package ru.a799000.alexander.fandroidvk.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.a799000.alexander.fandroidvk.common.manager.MyFragmentManager;
import ru.a799000.alexander.fandroidvk.common.manager.NetworkManager;

@Module
public class ManagerModule {
    @Provides
    @Singleton
    MyFragmentManager provideMyFragmentManager() {
        return new MyFragmentManager();
    }

    @Provides
    @Singleton
    NetworkManager provideNetworkManager() {
        return new NetworkManager();
    }
}
