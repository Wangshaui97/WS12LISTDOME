package com.bawei.ws12listdome.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.ws12listdome.R;
import com.bawei.ws12listdome.bean.ShopCarBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RightViewAdpter extends RecyclerView.Adapter<RightViewAdpter.ViewHolder> {

    private Context context;
    private List<ShopCarBean.DataBean.ListBean> mlist;

    public RightViewAdpter(Context context) {
        this.context = context;
        mlist =new ArrayList<>();
    }
    public void setData(List<ShopCarBean.DataBean.ListBean> list) {
        this.mlist =list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RightViewAdpter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.right_item, null);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RightViewAdpter.ViewHolder viewHolder, int i) {
        viewHolder.item_title.setText(mlist.get(i).getTitle());
        viewHolder.item_price.setText(mlist.get(i).getPrice()+"");

        String url = mlist.get(i).getImages().split("\\|")[0].replace("https", "http");

        Glide.with(context).load(url).into(viewHolder.item_img);


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView item_title,item_price;
        private final ImageView item_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_title = itemView.findViewById(R.id.item_title);
            item_price = itemView.findViewById(R.id.item_price);
            item_img = itemView.findViewById(R.id.item_img);
        }
    }
}
