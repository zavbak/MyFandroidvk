package ru.a799000.alexander.fandroidvk.model.view;

import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.a799000.alexander.fandroidvk.R;
import ru.a799000.alexander.fandroidvk.ui.view.holder.BaseViewHolder;

public class InfoLinksViewModel extends BaseViewModel {

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.InfoLinks;
    }

    @Override
    public InfoLinksViewHolder onCreateViewHolder(View view) {
        return new InfoLinksViewHolder(view);
    }


    static class InfoLinksViewHolder extends BaseViewHolder<InfoLinksViewModel> {


        @BindView(R.id.rv_links)
        RelativeLayout rvLinks;

        public InfoLinksViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindViewHolder(InfoLinksViewModel infoLinksViewModel) {

        }

        @Override
        public void unbindViewHolder() {

        }
    }
}
