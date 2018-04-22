package ru.a799000.alexander.fandroidvk.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmObject;
import ru.a799000.alexander.fandroidvk.CurrentUser;
import ru.a799000.alexander.fandroidvk.MyApplication;
import ru.a799000.alexander.fandroidvk.common.manager.MyFragmentManager;
import ru.a799000.alexander.fandroidvk.common.manager.NetworkManager;
import ru.a799000.alexander.fandroidvk.model.Profile;
import ru.a799000.alexander.fandroidvk.mvp.view.MainView;
import ru.a799000.alexander.fandroidvk.rest.api.UsersApi;
import ru.a799000.alexander.fandroidvk.rest.model.request.UsersGetRequestModel;
import ru.a799000.alexander.fandroidvk.ui.fragment.BaseFragment;
import ru.a799000.alexander.fandroidvk.ui.fragment.BoardFragment;
import ru.a799000.alexander.fandroidvk.ui.fragment.InfoFragment;
import ru.a799000.alexander.fandroidvk.ui.fragment.MembersFragment;
import ru.a799000.alexander.fandroidvk.ui.fragment.MyPostsFragment;
import ru.a799000.alexander.fandroidvk.ui.fragment.NewsFeedFragment;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    UsersApi mUserApi;

    @Inject
    NetworkManager mNetworkManager;

    @Inject
    MyFragmentManager myFragmentManager;

    public MainPresenter() {
        MyApplication.getApplicationComponent().inject(this);
    }


    public void drawerItemClick(int id) {
        BaseFragment fragment = null;

        switch (id) {
            case 1:
                fragment = new NewsFeedFragment();
                break;
            case 2:

                fragment = new MyPostsFragment();
                break;
            case 4:
                fragment = new MembersFragment();
                break;
            case 5:
                fragment = new BoardFragment();
                break;
            case 6:
                fragment = new InfoFragment();
                break;
        }

        if (fragment != null && !myFragmentManager.isAlreadyContains(fragment)) {
            getViewState().showFragmentFromDrawer(fragment);
        }
    }

    public void checkAuth() {
        if (!CurrentUser.isAuthorized()) {
            getViewState().startSignIn();
        } else {
            getCurrentUser();
            getViewState().signedIn();
        }
    }

    public Observable<Profile> getProfileFromNetwork() {
        return mUserApi.get(new UsersGetRequestModel(CurrentUser.getId()).toMap())
                .flatMap(listFull -> Observable.fromIterable(listFull.response))
                .doOnNext(this::saveToDb);
    }

    private Observable<Profile> getProfileFromDb() {
        return Observable.fromCallable(getListFromRealmCallable());
    }

    public void saveToDb(RealmObject item) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(item));
    }

    public Callable<Profile> getListFromRealmCallable() {
        return () -> {
            Realm realm = Realm.getDefaultInstance();
            Profile realmResults = realm.where(Profile.class)
                    .equalTo("id", Integer.parseInt(CurrentUser.getId()))
                    .findFirst();
            return realm.copyFromRealm(realmResults);
        };
    }

    private void getCurrentUser() {
        mNetworkManager.getNetworkObservable()
                .flatMap(aBoolean -> {
                    if (!CurrentUser.isAuthorized()) {
                        getViewState().startSignIn();
                    }

                    return aBoolean
                            ? getProfileFromNetwork()
                            : getProfileFromDb();
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(profile -> {
                    getViewState().showCurrentUser(profile);
                }, error -> {
                    error.printStackTrace();
                });
    }

}