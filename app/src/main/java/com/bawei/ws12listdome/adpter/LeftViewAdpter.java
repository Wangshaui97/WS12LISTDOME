package com.bawei.ws12listdome.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.ws12listdome.R;
import com.bawei.ws12listdome.bean.ShopCarBean;

import java.util.ArrayList;
import java.util.List;

public class LeftViewAdpter extends RecyclerView.Adapter<LeftViewAdpter.ViewHolder> {
    private Context context;
    private List<ShopCarBean.DataBean> mlist;

    public LeftViewAdpter(Context context) {
        this.context = context;
        mlist = new ArrayList<>();
    }

    @NonNull
    @Override
    public LeftViewAdpter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.left_item, null);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull LeftViewAdpter.ViewHolder viewHolder, final int i) {
        viewHolder.left_title.setText(mlist.get(i).getSellerName());


        viewHolder.left_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnClickListener!=null){
                    mOnClickListener.onClick(i,mlist.get(i).getSellerid());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void setData(List<ShopCarBean.DataBean> beanData) {
        this.mlist = beanData;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView left_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            left_title = itemView.findViewById(R.id.left_title);
        }
    }


    private OnClickListener mOnClickListener;

    public void setOnClickListener(OnClickListener listener) {
        this.mOnClickListener = listener;
    }

    public interface OnClickListener {
        void onClick(int position, String cid);
    }
}
