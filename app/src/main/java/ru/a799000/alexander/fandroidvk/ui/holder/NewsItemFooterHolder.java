package ru.a799000.alexander.fandroidvk.ui.holder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import ru.a799000.alexander.fandroidvk.MyApplication;
import ru.a799000.alexander.fandroidvk.R;
import ru.a799000.alexander.fandroidvk.common.Utils;
import ru.a799000.alexander.fandroidvk.model.view.NewsItemFooterViewModel;
import ru.a799000.alexander.fandroidvk.model.view.counter.CommentCounterViewModel;
import ru.a799000.alexander.fandroidvk.model.view.counter.LikeCounterViewModel;
import ru.a799000.alexander.fandroidvk.model.view.counter.RepostCounterViewModel;

public class NewsItemFooterHolder extends BaseViewHolder<NewsItemFooterViewModel>{

    private TextView tvDate;

    private TextView tvLikesCount;
    private TextView tvLikesIcon;
    private TextView tvCommentsIcon;
    private TextView tvCommentsCount;
    private TextView tvRepostIcon;
    private TextView tvRepostsCount;

    @Inject
    Typeface mGoogleFontTypeface;

    private Resources mResources;
    private Context mContext;

    public NewsItemFooterHolder(View itemView) {
        super(itemView);
        MyApplication.getApplicationComponent().inject(this);

        mContext = itemView.getContext();
        mResources = mContext.getResources();

        tvDate = (TextView) itemView.findViewById(R.id.tv_date);
        tvLikesIcon = (TextView) itemView.findViewById(R.id.tv_likes_icon);
        tvLikesCount = (TextView) itemView.findViewById(R.id.tv_likes_count);
        tvCommentsIcon = (TextView) itemView.findViewById(R.id.tv_comments_icon);
        tvCommentsCount = (TextView) itemView.findViewById(R.id.tv_comments_count);
        tvRepostIcon = (TextView) itemView.findViewById(R.id.tv_reposts_icon);
        tvRepostsCount= (TextView) itemView.findViewById(R.id.tv_reposts_count);

        tvLikesIcon.setTypeface(mGoogleFontTypeface);
        tvCommentsIcon.setTypeface(mGoogleFontTypeface);
        tvRepostIcon.setTypeface(mGoogleFontTypeface);

    }


    @Override
    public void bindViewHolder(NewsItemFooterViewModel item) {
        tvDate.setText(Utils.parseDate(item.getDateLong(), mContext));

        bindLikes(item.getLikes());
        bindComments(item.getComments());
        bindReposts(item.getReposts());

    }

    private void bindLikes(LikeCounterViewModel likes) {
        tvLikesCount.setText(String.valueOf(likes.getCount()));
        tvLikesCount.setTextColor(mResources.getColor(likes.getTextColor()));
        tvLikesIcon.setTextColor(mResources.getColor(likes.getIconColor()));

    }
    private void bindComments(CommentCounterViewModel comments) {
        tvCommentsCount.setText(String.valueOf(comments.getCount()));
        tvCommentsCount.setTextColor(mResources.getColor(comments.getTextColor()));
        tvCommentsIcon.setTextColor(mResources.getColor(comments.getIconColor()));

    }
    private void bindReposts(RepostCounterViewModel reposts) {
        tvRepostsCount.setText(String.valueOf(reposts.getCount()));
        tvRepostsCount.setTextColor(mResources.getColor(reposts.getTextColor()));
        tvRepostIcon.setTextColor(mResources.getColor(reposts.getIconColor()));

    }


    @Override
    public void unbindViewHolder() {

        tvDate.setText(null);
        tvLikesCount.setText(null);
        tvCommentsCount.setText(null);
        tvRepostsCount.setText(null);

    }
}
