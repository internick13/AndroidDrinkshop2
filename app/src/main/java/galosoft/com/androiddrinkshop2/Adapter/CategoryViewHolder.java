package galosoft.com.androiddrinkshop2.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import galosoft.com.androiddrinkshop2.Interface.IItemClickListener;
import galosoft.com.androiddrinkshop2.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

    ImageView img_product;
    TextView txt_menu_name;

    IItemClickListener itemClickListener;

    public void setItemClickListener(IItemClickListener itemClickListener) {
       this.itemClickListener = itemClickListener;
    }

    public CategoryViewHolder(View itemView) {
        super(itemView);

        img_product = itemView.findViewById(R.id.image_product);
        txt_menu_name = itemView.findViewById(R.id.txt_menu_name);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view);
    }
}
