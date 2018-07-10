package in.karan.suman.foodka.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import in.karan.suman.foodka.R;

/**
 * Created by Suman on 24-Apr-18.
 */



public class OfferViewHolder extends RecyclerView.ViewHolder{

    public TextView head,detail;

    public OfferViewHolder(View itemView) {
        super(itemView);

        head=itemView.findViewById(R.id.head);
        detail=itemView.findViewById(R.id.detail);

    }




}
