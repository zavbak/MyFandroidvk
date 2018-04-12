package ru.a799000.alexander.fandroidvk.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ru.a799000.alexander.fandroidvk.di.module.ApplicationModule;
import ru.a799000.alexander.fandroidvk.di.module.ManagerModule;
import ru.a799000.alexander.fandroidvk.di.module.RestModule;
import ru.a799000.alexander.fandroidvk.mvp.presenter.NewsFeedPresenter;
import ru.a799000.alexander.fandroidvk.ui.activity.BaseActivity;
import ru.a799000.alexander.fandroidvk.ui.activity.MainActivity;
import ru.a799000.alexander.fandroidvk.ui.fragment.NewsFeedFragment;
import ru.a799000.alexander.fandroidvk.ui.holder.NewsItemBodyHolder;
import ru.a799000.alexander.fandroidvk.ui.holder.NewsItemFooterHolder;

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {

    //activities
    void inject(BaseActivity activity);
    void inject(MainActivity activity);

    //fragments
    void inject(NewsFeedFragment fragment);

    //holder
    void inject(NewsItemBodyHolder holder);
    void inject(NewsItemFooterHolder holder);

    //presenter
    void inject(NewsFeedPresenter newsFeedPresenter);
}
