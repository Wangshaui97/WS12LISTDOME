package com.bawei.ws12listdome.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.ws12listdome.Apis;
import com.bawei.ws12listdome.R;
import com.bawei.ws12listdome.adpter.LeftViewAdpter;
import com.bawei.ws12listdome.adpter.RightViewAdpter;
import com.bawei.ws12listdome.bean.ShopCarBean;
import com.bawei.ws12listdome.presonter.IPresonter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {

    private IPresonter iPresonter;
    private RecyclerView left_view;
    private LeftViewAdpter lv;
    private LinearLayoutManager layoutManager;
    private RecyclerView right_view;
    private List<ShopCarBean.DataBean> list= new ArrayList<>();
    private RightViewAdpter rp;
    private int index;
    private List<ShopCarBean.DataBean> beanData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iPresonter = new IPresonter(this);

        left_view = findViewById(R.id.left_view);
        lv = new LeftViewAdpter(this);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        left_view.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        left_view.setAdapter(lv);
        left_view.setLayoutManager(layoutManager);
        initData();

        lv.setOnClickListener(new LeftViewAdpter.OnClickListener() {

            @Override
            public void onClick(int position, String cid) {
                index = position;
                right_view = findViewById(R.id.right_view);
                rp = new RightViewAdpter(MainActivity.this);
                LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                right_view.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));
                right_view.setLayoutManager(layoutManager);
                right_view.setAdapter(rp);
                List<ShopCarBean.DataBean.ListBean> list = beanData.get(position).getList();
                rp.setData(list);
                //initData();
            }
        });



    }


    private void initData() {
        iPresonter.setRequest(Apis.SHOPCAR);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresonter.onDistuch();
    }

    @Override
    public void setRequest(Object data) {
        ShopCarBean shopCarBean = (ShopCarBean) data;
        beanData = shopCarBean.getData();
        lv.setData(beanData);
        //rp.setData(beanData.get(index).getList());
    }
}
