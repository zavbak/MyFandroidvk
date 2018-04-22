package ru.a799000.alexander.fandroidvk.rest.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import ru.a799000.alexander.fandroidvk.rest.model.response.Full;
import ru.a799000.alexander.fandroidvk.rest.model.response.VideosResponse;

public interface VideoApi {
    @GET(ApiMethods.VIDEO_GET)
    Observable<Full<VideosResponse>> get(@QueryMap Map<String, String> map);
}
