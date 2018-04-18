package ru.a799000.alexander.fandroidvk.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import ru.a799000.alexander.fandroidvk.R;

public class MyPostsFragment extends NewsFeedFragment {
    public MyPostsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.setEnableIdFiltering(true);
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_my_posts;
    }
}
