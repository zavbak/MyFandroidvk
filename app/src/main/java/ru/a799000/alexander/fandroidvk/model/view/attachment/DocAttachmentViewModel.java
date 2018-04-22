package ru.a799000.alexander.fandroidvk.model.view.attachment;

import android.view.View;

import java.io.File;

import ru.a799000.alexander.fandroidvk.common.Utils;
import ru.a799000.alexander.fandroidvk.model.attachment.doc.Doc;

import ru.a799000.alexander.fandroidvk.model.view.BaseViewModel;
import ru.a799000.alexander.fandroidvk.ui.view.holder.BaseViewHolder;
import ru.a799000.alexander.fandroidvk.ui.view.holder.attachment.DocAttachmentHolder;

public class DocAttachmentViewModel extends BaseViewModel {

    private String mUrl;

    private File mFile;

    private String mTitle;
    private String mSize;
    private String mExt;

    public boolean needClick = true;


    public DocAttachmentViewModel(Doc doc) {
        if (doc.getTitle().equals("")) {
            mTitle = "Document";
        } else {
            mTitle = Utils.removeExtFromText(doc.getTitle());
        }

        mUrl = doc.getUrl();

        mSize = Utils.formatSize(doc.getSize());

        mExt = "." + doc.getExt();
    }

    public DocAttachmentViewModel(File file) {
        String filename = file.getName();
        String filenameArray[] = filename.split("\\.");
        String extension = filenameArray[filenameArray.length-1];

        mFile = file;
        mTitle = file.getName();

        mSize = Utils.formatSize(file.length());

        mExt = "." + extension;

        needClick = false;
    }


    @Override
    public LayoutTypes getType() {
        return LayoutTypes.AttachmentDoc;
    }

    @Override
    public DocAttachmentHolder onCreateViewHolder(View view) {
        return new DocAttachmentHolder(view);
    }


    public String getTitle() {
        return mTitle;
    }

    public String getSize() {
        return mSize;
    }

    public String getExt() {
        return mExt;
    }

    public File getmFile() {
        return mFile;
    }

    public String getmUrl() {
        return mUrl;
    }
}
