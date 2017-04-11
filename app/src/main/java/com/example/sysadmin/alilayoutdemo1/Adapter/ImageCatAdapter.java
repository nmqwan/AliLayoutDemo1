package com.example.sysadmin.alilayoutdemo1.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sysadmin.alilayoutdemo1.Model.Category;
import com.example.sysadmin.alilayoutdemo1.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by QWAN on 29/03/2017.
 */

public class ImageCatAdapter extends RecyclerView.Adapter<ImageCatAdapter.CatHolder> {
    private static final String TAG = "AdapterChat1";
    private List<Category> datas;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public ImageCatAdapter(Context context, List<Category> datas) {
        mContext = context;
        this.datas = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public CatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate view from row_item_song.xml
        View itemView = mLayoutInflater.inflate(R.layout.row_cat_img, parent, false);
        return new CatHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CatHolder holder, int position) {
        //get song in mSong via position
        Category cat = datas.get(position);

        //bind data to viewholder
        holder.txtCat.setText(cat.getName());
        holder.imgCat.setImageDrawable(mContext.getResources().getDrawable(cat.getResImg()));

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class CatHolder extends RecyclerView.ViewHolder {
        private CircleImageView imgCat;
        private TextView txtCat;

        public CatHolder(View itemView) {
            super(itemView);
            imgCat = (CircleImageView) itemView.findViewById(R.id.imgCat);
            txtCat = (TextView) itemView.findViewById(R.id.txtNameCat);
        }
    }
}