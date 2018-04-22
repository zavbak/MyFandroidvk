package ru.a799000.alexander.fandroidvk.ui.view.holder;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import ru.a799000.alexander.fandroidvk.model.view.BaseViewModel;

public abstract class BaseViewHolder<Item extends BaseViewModel> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindViewHolder(Item item);
    public abstract void unbindViewHolder();
}
