package galosoft.com.androiddrinkshop2.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import galosoft.com.androiddrinkshop2.Interface.IItemClickListener;
import galosoft.com.androiddrinkshop2.R;

public class DrinkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView img_product,btn_add_to_cart, btn_favorites;
    TextView txt_drink_name, txt_price;
    IItemClickListener itemClickListener;

    public void setItemClickListener(IItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public DrinkViewHolder(View itemView) {
        super(itemView);

        img_product = itemView.findViewById(R.id.image_product);
        txt_drink_name = itemView.findViewById(R.id.txt_drink_name);
        txt_price = itemView.findViewById(R.id.txt_price);
        btn_add_to_cart =  itemView.findViewById(R.id.btn_add_to_cart);
        btn_favorites =  itemView.findViewById(R.id.btn_to_favorite);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        itemClickListener.onClick(view);
    }
}

