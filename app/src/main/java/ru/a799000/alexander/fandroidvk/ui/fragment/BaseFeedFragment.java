package ru.a799000.alexander.fandroidvk.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import ru.a799000.alexander.fandroidvk.R;
import ru.a799000.alexander.fandroidvk.common.BaseAdapter;
import ru.a799000.alexander.fandroidvk.common.manager.MyLinearLayoutManager;
import ru.a799000.alexander.fandroidvk.model.view.BaseViewModel;
import ru.a799000.alexander.fandroidvk.mvp.presenter.BaseFeedPresenter;
import ru.a799000.alexander.fandroidvk.mvp.view.BaseFeedView;

public abstract class BaseFeedFragment extends BaseFragment implements BaseFeedView {

    RecyclerView mRecyclerView;

    BaseAdapter mAdapter;

    protected SwipeRefreshLayout mSwipeRefreshLayout;
    protected ProgressBar mProgressBar;

    protected BaseFeedPresenter mBaseFeedPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpRecyclerView(view);
        setUpAdapter(mRecyclerView);
        setUpSwipeToRefreshLayout(view);

        mBaseFeedPresenter = onCreateFeedPresenter();
        mBaseFeedPresenter.loadStart();
    }


    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }


    private void setUpRecyclerView(View rootView) {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_list);

        MyLinearLayoutManager mLinearLayoutManager = new MyLinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                if (mLinearLayoutManager.isOnNextPagePosition()) {
                    mBaseFeedPresenter.loadNext(mAdapter.getRealItemCount());
                }
            }
        });

        ((SimpleItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }

    protected void setUpAdapter(RecyclerView rv) {
        mAdapter = new BaseAdapter();
        rv.setAdapter(mAdapter);
    }

    private void setUpSwipeToRefreshLayout(View rootView) {
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(() -> onCreateFeedPresenter().loadRefresh());
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);

        mProgressBar = getBaseActivity().getProgressBar();
    }


    @Override
    public void showRefreshing() {
    }

    @Override
    public void hideRefreshing() {
        mSwipeRefreshLayout.setRefreshing(false);
    }


    @Override
    public void showListProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideListProgress() {
        mProgressBar.setVisibility(View.GONE);
    }


    @Override
    public void showError(String message) {
        Toast.makeText(getBaseActivity(),"error" + message, Toast.LENGTH_LONG).show();
    }


    @Override
    public void setItems(List<BaseViewModel> items) {
        mAdapter.setItems(items);
    }

    @Override
    public void addItems(List<BaseViewModel> items) {
        mAdapter.addItems(items);
    }

    protected abstract BaseFeedPresenter onCreateFeedPresenter();
}