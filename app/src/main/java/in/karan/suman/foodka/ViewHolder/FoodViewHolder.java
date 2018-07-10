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

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView food_name,food_price;
    public ImageView food_image,share_image,fav_image,quick_cart;


    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public FoodViewHolder(View itemView)
    {
        super(itemView);
        food_image=(ImageView) itemView.findViewById(R.id.food_image);
        food_name=(TextView) itemView.findViewById(R.id.food_name);
      //  share_image=(ImageView)itemView.findViewById(R.id.btnShare);
        food_price=(TextView)itemView.findViewById(R.id.food_price);
        quick_cart=(ImageView)itemView.findViewById(R.id.quick_cart);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
