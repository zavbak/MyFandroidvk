package ru.a799000.alexander.fandroidvk.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.a799000.alexander.fandroidvk.MyApplication;
import ru.a799000.alexander.fandroidvk.R;
import ru.a799000.alexander.fandroidvk.common.utils.VkListHelper;
import ru.a799000.alexander.fandroidvk.model.WallItem;
import ru.a799000.alexander.fandroidvk.model.view.BaseViewModel;
import ru.a799000.alexander.fandroidvk.model.view.NewsItemBodyViewModel;
import ru.a799000.alexander.fandroidvk.model.view.NewsItemFooterViewModel;
import ru.a799000.alexander.fandroidvk.model.view.NewsItemHeaderViewModel;
import ru.a799000.alexander.fandroidvk.rest.api.WallApi;
import ru.a799000.alexander.fandroidvk.rest.model.request.WallGetRequestModel;
import ru.a799000.alexander.fandroidvk.rest.model.response.GetWallResponse;

public class NewsFeedFragment extends BaseFeedFragment {

    @Inject
    WallApi mWallApi;



    public NewsFeedFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mWallApi.get(new WallGetRequestModel(-73476).toMap()).enqueue(new Callback<GetWallResponse>() {
            @Override
            public void onResponse(Call<GetWallResponse> call, Response<GetWallResponse> response) {
                List<WallItem> wallItems = VkListHelper.getWallList(response.body().response);
                List<BaseViewModel> list = new ArrayList<>();

                for (WallItem item : wallItems) {
                    list.add(new NewsItemHeaderViewModel(item));
                    list.add(new NewsItemBodyViewModel(item));
                    list.add(new NewsItemFooterViewModel(item));
                }
                mAdapter.addItems(list);
                Toast.makeText(getActivity(), "Likes: " + response.body().response.getItems().get(0).getLikes().getCount(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<GetWallResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }





    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }
}