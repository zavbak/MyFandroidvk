package ru.a799000.alexander.fandroidvk.rest.api;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import ru.a799000.alexander.fandroidvk.model.CommentItem;
import ru.a799000.alexander.fandroidvk.rest.model.response.Full;
import ru.a799000.alexander.fandroidvk.rest.model.response.GetWallByIdResponse;
import ru.a799000.alexander.fandroidvk.rest.model.response.GetWallResponse;
import ru.a799000.alexander.fandroidvk.rest.model.response.ItemWithSendersResponse;

public interface WallApi {

    @GET(ApiMethods.WALL_GET)
    Observable<GetWallResponse> get(@QueryMap Map<String, String> map);

    @GET(ApiMethods.WALL_GET_BY_ID)
    Observable<GetWallByIdResponse> getById(@QueryMap Map<String, String> map);

    @GET(ApiMethods.WALL_GET_COMMENTS)
    Observable<Full<ItemWithSendersResponse<CommentItem>>> getComments(@QueryMap Map<String, String> map);

}
