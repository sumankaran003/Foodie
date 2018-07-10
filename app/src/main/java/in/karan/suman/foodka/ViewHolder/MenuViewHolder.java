package in.karan.suman.foodka.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import in.karan.suman.foodka.Interface.ItemClickListener;
import in.karan.suman.foodka.R;

/**
 * Created by Suman on 12-Dec-17.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


    public TextView txtMenuName;
    public ImageView imageView;


    private ItemClickListener itemClickListener;

    public MenuViewHolder(View itemView) {
        super(itemView);
        imageView=(ImageView) itemView.findViewById(R.id.menu_image);
        txtMenuName=(TextView) itemView.findViewById(R.id.menu_name);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {

        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}

