package ru.a799000.alexander.fandroidvk.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
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
import ru.a799000.alexander.fandroidvk.mvp.presenter.BaseFeedPresenter;
import ru.a799000.alexander.fandroidvk.mvp.presenter.NewsFeedPresenter;
import ru.a799000.alexander.fandroidvk.rest.api.WallApi;
import ru.a799000.alexander.fandroidvk.rest.model.request.WallGetRequestModel;
import ru.a799000.alexander.fandroidvk.rest.model.response.GetWallResponse;

public class NewsFeedFragment extends BaseFeedFragment {

    @InjectPresenter
    NewsFeedPresenter mPresenter;

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
    }





    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }

    @Override
    protected BaseFeedPresenter onCreateFeedPresenter() {
        return mPresenter;
    }
}