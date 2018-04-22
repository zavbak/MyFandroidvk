package ru.a799000.alexander.fandroidvk.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ru.a799000.alexander.fandroidvk.common.manager.NetworkManager;
import ru.a799000.alexander.fandroidvk.di.module.ApplicationModule;
import ru.a799000.alexander.fandroidvk.di.module.ManagerModule;
import ru.a799000.alexander.fandroidvk.di.module.RestModule;
import ru.a799000.alexander.fandroidvk.mvp.presenter.BoardPresenter;
import ru.a799000.alexander.fandroidvk.mvp.presenter.InfoPresenter;
import ru.a799000.alexander.fandroidvk.mvp.presenter.MainPresenter;
import ru.a799000.alexander.fandroidvk.mvp.presenter.MembersPresenter;
import ru.a799000.alexander.fandroidvk.mvp.presenter.NewsFeedPresenter;
import ru.a799000.alexander.fandroidvk.mvp.presenter.OpenedPostPresenter;
import ru.a799000.alexander.fandroidvk.ui.activity.BaseActivity;
import ru.a799000.alexander.fandroidvk.ui.activity.MainActivity;
import ru.a799000.alexander.fandroidvk.ui.fragment.NewsFeedFragment;
import ru.a799000.alexander.fandroidvk.ui.fragment.OpenedPostFragment;
import ru.a799000.alexander.fandroidvk.ui.view.holder.NewsItemBodyHolder;
import ru.a799000.alexander.fandroidvk.ui.view.holder.NewsItemFooterHolder;
import ru.a799000.alexander.fandroidvk.ui.view.holder.attachment.ImageAttachmentHolder;
import ru.a799000.alexander.fandroidvk.ui.view.holder.attachment.VideoAttachmentHolder;

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {

    //activities
    void inject(BaseActivity activity);
    void inject(MainActivity activity);

    //fragments
    void inject(NewsFeedFragment fragment);
    void inject(OpenedPostFragment fragment);

    //holder
    void inject(NewsItemBodyHolder holder);
    void inject(NewsItemFooterHolder holder);
    void inject(ImageAttachmentHolder holder);
    void inject(VideoAttachmentHolder holder);

    //presenter
    void inject(NewsFeedPresenter presenter);
    void inject(MainPresenter presenter);
    void inject(MembersPresenter presenter);
    void inject(BoardPresenter presenter);
    void inject(InfoPresenter presenter);
    void inject(OpenedPostPresenter presenter);

    //managers
    void inject(NetworkManager networkManager);



}
