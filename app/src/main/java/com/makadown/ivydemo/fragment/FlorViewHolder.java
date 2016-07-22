package com.makadown.ivydemo.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.makadown.ivydemo.R;

public class FlorViewHolder extends RecyclerView.ViewHolder {


    public TextView nameflor_TextView;
    public TextView isoflor_TextView;



    public FlorViewHolder(View itemView) {
        super(itemView);
        itemView.setClickable(true);
        nameflor_TextView = (TextView) itemView.findViewById(R.id.floreria_name );
        isoflor_TextView = (TextView) itemView.findViewById(R.id.floreria_iso);

    }

    public void bind(ItemModel itemModel)
    {
        if (itemModel != null)
        {
            if ( nameflor_TextView == null )
            {
                nameflor_TextView = (TextView) itemView.findViewById(R.id.flor_name );
            }
            nameflor_TextView.setText(itemModel.getName());

            if ( isoflor_TextView == null )
            {
                isoflor_TextView = (TextView) itemView.findViewById(R.id.flor_iso);
            }
            isoflor_TextView.setText(itemModel.getisoCode());
        }
    }


}
