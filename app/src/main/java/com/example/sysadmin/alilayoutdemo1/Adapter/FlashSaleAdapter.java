package com.example.sysadmin.alilayoutdemo1.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sysadmin.alilayoutdemo1.Model.Product;
import com.example.sysadmin.alilayoutdemo1.R;

import java.util.List;

/**
 * Created by QWAN on 29/03/2017.
 */

public class FlashSaleAdapter extends RecyclerView.Adapter<FlashSaleAdapter.FlashSaleHolder> {
    private static final String TAG = "FlashSaleAdapter";
    private List<Product> datas;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public FlashSaleAdapter(Context context, List<Product> datas) {
        mContext = context;
        this.datas = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public FlashSaleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate view from row_item_song.xml
        View itemView = mLayoutInflater.inflate(R.layout.row_flashsale, parent, false);

        return new FlashSaleHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final FlashSaleHolder holder, int position) {
        //get song in mSong via position
        Product product = datas.get(position);
        //bind data to viewholder
        holder.txtName.setText(product.getName());
        holder.txtPrice.setText(product.getPrice() + "");
        holder.txtPriceDiscount.setText(product.getDiscountPrice() + "");
        holder.img.setImageDrawable(mContext.getResources().getDrawable(product.getResImg()));

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class FlashSaleHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView txtName, txtPrice, txtPriceDiscount;

        public FlashSaleHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_rowFlashSale);
            txtName = (TextView) itemView.findViewById(R.id.txt_rowNameFlashSale);
            txtPrice = (TextView) itemView.findViewById(R.id.txt_rowPriceFlashSale);
            txtPriceDiscount = (TextView) itemView.findViewById(R.id.txt_rowPriceDiscountFlashSale);
        }
    }
}