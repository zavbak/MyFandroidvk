package ru.a799000.alexander.fandroidvk.rest.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import ru.a799000.alexander.fandroidvk.model.Topic;
import ru.a799000.alexander.fandroidvk.rest.model.response.BaseItemResponse;
import ru.a799000.alexander.fandroidvk.rest.model.response.Full;

public interface BoardApi {
    @GET(ApiMethods.BOARD_GET_TOPICS)
    Observable<Full<BaseItemResponse<Topic>>> getTopics(@QueryMap Map<String, String> map);
}