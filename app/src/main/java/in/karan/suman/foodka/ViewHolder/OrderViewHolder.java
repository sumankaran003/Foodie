package in.karan.suman.foodka.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import in.karan.suman.foodka.R;


public class OrderViewHolder extends RecyclerView.ViewHolder {

   public TextView txtOrderId,txtOrderStatus,txtOrderPhone,txtOrderAddress;
   public Button btnDetail;

   //private ItemClickListener itemClickListener;

    public OrderViewHolder(View itemView)
    {
        super(itemView);

        txtOrderAddress=itemView.findViewById(R.id.order_address);
        txtOrderId=itemView.findViewById(R.id.order_id);
        txtOrderPhone=itemView.findViewById(R.id.order_phone);
        txtOrderStatus=itemView.findViewById(R.id.order_status);

        btnDetail=itemView.findViewById(R.id.btnDetail);



    }


}
