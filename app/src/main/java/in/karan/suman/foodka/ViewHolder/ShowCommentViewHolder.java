package in.karan.suman.foodka.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import in.karan.suman.foodka.R;

/**
 * Created by Suman on 14-Feb-18.
 */

public class ShowCommentViewHolder extends RecyclerView.ViewHolder{

    public TextView txtUserPhone,txtComment;
    public RatingBar ratingBar;



    public ShowCommentViewHolder(View itemView) {
        super(itemView);
        txtComment=itemView.findViewById(R.id.txtComment);
        txtUserPhone=itemView.findViewById(R.id.txtUserPhone);
        ratingBar=itemView.findViewById(R.id.ratingBar);
    }
}
