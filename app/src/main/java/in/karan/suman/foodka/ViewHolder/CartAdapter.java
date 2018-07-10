package in.karan.suman.foodka.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import in.karan.suman.foodka.Cart;
import in.karan.suman.foodka.Common.Common;
import in.karan.suman.foodka.Database.Database;
import in.karan.suman.foodka.Interface.ItemClickListener;
import in.karan.suman.foodka.Model.Order;
import in.karan.suman.foodka.R;

/**
 * Created by Suman on 13-Dec-17.
 */


class CartViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener,View.OnCreateContextMenuListener{


    public TextView txt_cart_name,txt_price;
    public ElegantNumberButton btn_quantity;
    public ImageView cart_image;

    private ItemClickListener itemClickListener;

    public void setTxt_cart_name(TextView txt_cart_name) {
        this.txt_cart_name = txt_cart_name;
    }

    public CartViewHolder(View itemView) {
        super(itemView);

        txt_cart_name=(TextView)itemView.findViewById(R.id.cart_item_name);
        txt_price=(TextView)itemView.findViewById(R.id.cart_item_price);
        btn_quantity=(ElegantNumberButton) itemView.findViewById(R.id.btn_quantity);
        cart_image=(ImageView) itemView.findViewById(R.id.cart_image);

        itemView.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.setHeaderTitle("Select Action");
        menu.add(0,0,getAdapterPosition(), Common.DELETE);
    }
}


 public class CartAdapter extends RecyclerView.Adapter<CartViewHolder>{

    private List<Order> listData=new ArrayList<>();
    private Cart cart;

     public CartAdapter(List<Order> listData, Cart cart) {
         this.listData = listData;
         this.cart = cart;
     }

     @Override
     public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         LayoutInflater inflater = LayoutInflater.from(cart);
         View itemView=inflater.inflate(R.layout.cart_layout,parent,false);
        return new CartViewHolder(itemView);

     }

     @Override
     public void onBindViewHolder(CartViewHolder holder, final int position) {

       //  TextDrawable drawable =TextDrawable.builder()
       //          .buildRound(""+listData.get(position).getQuantity(), Color.CYAN);

      //   holder.btn_quantity.setImageDrawable(drawable);

         Picasso.with(cart.getBaseContext())
                 .load(listData.get(position).getImage())
                 .resize(70,70)
                 .centerCrop()
                 .into(holder.cart_image);

         holder.btn_quantity.setNumber(listData.get(position).getQuantity());
         holder.btn_quantity.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
             @Override
             public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {

                 Order order=listData.get(position);
                 order.setQuantity(String.valueOf(newValue));
                 new Database(cart).updateCart(order);

                 int total=0;
                 List<Order>orders=new Database(cart).getCarts(Common.currentUser.getPhone());
                 for(Order item:orders)
                     total+=(Integer.parseInt(order.getPrice()))*(Integer.parseInt(item.getQuantity()));

                 Locale locale=new Locale("en","IND");
                 NumberFormat fnt =NumberFormat.getCurrencyInstance(locale);


                 cart.txtTotalPrice.setText(fnt.format(total));
             }
         });

         Locale locale=new Locale("en","IND");
         NumberFormat fnt =NumberFormat.getCurrencyInstance(locale);


         int price=(Integer.parseInt(listData.get(position).getPrice()))*(Integer.parseInt(listData.get(position).getQuantity()));
         holder.txt_price.setText(fnt.format(price));

         holder.txt_cart_name.setText(listData.get(position).getProductName());






     }

     @Override
     public int getItemCount() {
         return listData.size();
     }
 }
