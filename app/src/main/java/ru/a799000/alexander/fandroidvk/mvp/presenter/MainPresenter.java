package ru.a799000.alexander.fandroidvk.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.a799000.alexander.fandroidvk.CurrentUser;
import ru.a799000.alexander.fandroidvk.mvp.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    public void checkAuth() {
        if (!CurrentUser.isAuthorized()) {
            getViewState().startSignIn();
        } else {
            getViewState().signedIn();
        }
    }
}