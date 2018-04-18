package ru.a799000.alexander.fandroidvk.mvp.view;

import com.arellomobile.mvp.MvpView;

import ru.a799000.alexander.fandroidvk.model.Profile;
import ru.a799000.alexander.fandroidvk.ui.fragment.BaseFragment;

public interface MainView extends MvpView {
    void startSignIn();
    void signedIn();
    void showCurrentUser(Profile profile);
    void showFragmentFromDrawer(BaseFragment baseFragment);
}
