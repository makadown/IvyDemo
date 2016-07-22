package com.makadown.ivydemo.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.makadown.ivydemo.R;

public class FloreriaViewHolder extends RecyclerView.ViewHolder {

    public TextView namefloreria_TextView;
    public TextView isofloreria_TextView;


    public FloreriaViewHolder(View itemView) {
        super(itemView);
        itemView.setClickable(true);
        namefloreria_TextView = (TextView) itemView.findViewById(R.id.floreria_name );
        isofloreria_TextView = (TextView) itemView.findViewById(R.id.floreria_iso);


    }

    public void bind(ItemModel itemModel)
    {
        if (itemModel != null) {

            if( namefloreria_TextView == null )
            {namefloreria_TextView = (TextView) itemView.findViewById(R.id.floreria_name );  }
            if (isofloreria_TextView == null)
            {isofloreria_TextView = (TextView) itemView.findViewById(R.id.floreria_iso);}
            namefloreria_TextView.setText(itemModel.getName());
            isofloreria_TextView.setText(itemModel.getisoCode());

        }
    }


}
