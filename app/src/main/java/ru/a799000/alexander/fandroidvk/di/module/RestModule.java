package ru.a799000.alexander.fandroidvk.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.a799000.alexander.fandroidvk.rest.RestClient;
import ru.a799000.alexander.fandroidvk.rest.api.WallApi;

@Module
public class RestModule {
    private RestClient mRestClient;


    public RestModule() {
        mRestClient = new RestClient();
    }


    @Provides
    @Singleton
    public RestClient provideRestClient() {
        return mRestClient;
    }

    @Provides

    @Singleton

    public WallApi provideWallApi() {

        return mRestClient.createService(WallApi.class);

    }
}
