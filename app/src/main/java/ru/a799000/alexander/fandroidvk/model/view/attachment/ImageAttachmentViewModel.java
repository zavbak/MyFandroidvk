package ru.a799000.alexander.fandroidvk.model.view.attachment;

import android.view.View;

import ru.a799000.alexander.fandroidvk.model.attachment.Photo;
import ru.a799000.alexander.fandroidvk.model.view.BaseViewModel;
import ru.a799000.alexander.fandroidvk.ui.view.holder.BaseViewHolder;
import ru.a799000.alexander.fandroidvk.ui.view.holder.attachment.ImageAttachmentHolder;

public class ImageAttachmentViewModel extends BaseViewModel {

    private String mPhotoUrl;
    public boolean needClick = true;

    public ImageAttachmentViewModel(String url) {
        mPhotoUrl = url;

        needClick = false;
    }

    public ImageAttachmentViewModel(Photo photo) {
        mPhotoUrl = photo.getPhoto604();
    }


    @Override
    public LayoutTypes getType() {
        return LayoutTypes.AttachmentImage;
    }

    @Override
    public ImageAttachmentHolder onCreateViewHolder(View view) {
        return new ImageAttachmentHolder(view);
    }


    public String getPhotoUrl() {
        return mPhotoUrl;
    }
}