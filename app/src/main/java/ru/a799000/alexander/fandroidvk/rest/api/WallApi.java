package ru.a799000.alexander.fandroidvk.rest.api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import ru.a799000.alexander.fandroidvk.rest.model.response.BaseItemResponse;
import ru.a799000.alexander.fandroidvk.rest.model.response.Full;
import ru.a799000.alexander.fandroidvk.rest.model.response.WallGetResponse;

public interface WallApi {
    @GET(ApiMethods.WALL_GET)
    Call<WallGetResponse> get(@QueryMap Map<String, String> map);
}
