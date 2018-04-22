package ru.a799000.alexander.fandroidvk.mvp.view;

import ru.a799000.alexander.fandroidvk.model.view.NewsItemFooterViewModel;

public interface OpenedPostView extends BaseFeedView {
    void setFooter(NewsItemFooterViewModel viewModel);
}
