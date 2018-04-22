package ru.a799000.alexander.fandroidvk.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import ru.a799000.alexander.fandroidvk.MyApplication;
import ru.a799000.alexander.fandroidvk.consts.ApiConstants;
import ru.a799000.alexander.fandroidvk.model.Member;
import ru.a799000.alexander.fandroidvk.model.Topic;
import ru.a799000.alexander.fandroidvk.model.view.BaseViewModel;
import ru.a799000.alexander.fandroidvk.model.view.TopicViewModel;
import ru.a799000.alexander.fandroidvk.mvp.view.BaseFeedView;
import ru.a799000.alexander.fandroidvk.rest.api.BoardApi;
import ru.a799000.alexander.fandroidvk.rest.model.request.BoardGetTopicsRequestModel;

@InjectViewState
public class BoardPresenter extends BaseFeedPresenter<BaseFeedView> {
    @Inject
    BoardApi mBoardApi;

    public BoardPresenter() {
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public Observable<BaseViewModel> onCreateLoadDataObservable(int count, int offset) {
        return mBoardApi.getTopics(new BoardGetTopicsRequestModel(
                ApiConstants.MY_GROUP_ID, count, offset).toMap())
                .flatMap(baseItemResponseFull -> Observable.fromIterable(baseItemResponseFull.response.getItems()))
                .doOnNext(topic -> topic.setGroupId(ApiConstants.MY_GROUP_ID))
                .doOnNext(this::saveToDb)
                .map(TopicViewModel::new);
    }

    @Override
    public Observable<BaseViewModel> onCreateRestoreDataObservable() {
        return Observable.fromCallable(getListFromRealmCallable())
                .flatMap(Observable::fromIterable)
                .map(TopicViewModel::new);
    }


    public Callable<List<Topic>> getListFromRealmCallable() {
        return () -> {
            String[] sortFields = {Member.ID};
            Sort[] sortOrder = {Sort.DESCENDING};

            Realm realm = Realm.getDefaultInstance();
            RealmResults<Topic> results = realm.where(Topic.class)
                    .equalTo("groupId", ApiConstants.MY_GROUP_ID)
                    .findAllSorted(sortFields, sortOrder);

            return realm.copyFromRealm(results);
        };
    }
}
