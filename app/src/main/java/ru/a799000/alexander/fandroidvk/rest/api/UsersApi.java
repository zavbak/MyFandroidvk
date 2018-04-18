package ru.a799000.alexander.fandroidvk.rest.api;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import ru.a799000.alexander.fandroidvk.model.Profile;
import ru.a799000.alexander.fandroidvk.rest.model.response.Full;

public interface UsersApi {
    @GET(ApiMethods.USERS_GET)
    Observable<Full<List<Profile>>> get(@QueryMap Map<String, String> map);
}