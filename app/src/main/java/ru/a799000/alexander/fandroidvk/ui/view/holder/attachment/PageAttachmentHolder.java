package ru.a799000.alexander.fandroidvk.ui.view.holder.attachment;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.a799000.alexander.fandroidvk.R;
import ru.a799000.alexander.fandroidvk.common.Utils;
import ru.a799000.alexander.fandroidvk.model.view.attachment.PageAttachmentViewModel;
import ru.a799000.alexander.fandroidvk.ui.view.holder.BaseViewHolder;

public class PageAttachmentHolder extends BaseViewHolder<PageAttachmentViewModel> {
    @BindView(R.id.tv_title)
    public TextView title;

    public PageAttachmentHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindViewHolder(PageAttachmentViewModel pageAttachmentViewModel) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.openUrlInActionView(pageAttachmentViewModel.getmUrl(), view.getContext());
            }
        });
        title.setText(pageAttachmentViewModel.getTitle());
    }

    @Override
    public void unbindViewHolder() {
        itemView.setOnClickListener(null);
        title.setText(null);
    }


}