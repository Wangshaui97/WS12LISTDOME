package com.bawei.ws12listdome.model;


import com.bawei.ws12listdome.bean.ShopCarBean;
import com.bawei.ws12listdome.mycallback.MyCallback;
import com.bawei.ws12listdome.okhttputil.Httputil;
import com.bawei.ws12listdome.okhttputil.ICallBack;

public class IModel implements IM {

    @Override
    public void setRequest(String url, final MyCallback myCallback) {
        Httputil.getInstance().getEnqueue(url, ShopCarBean.class, new ICallBack() {
            @Override
            public void success(Object obj) {
                myCallback.setData(obj);
            }

            @Override
            public void failed(Exception e) {

            }
        });
    }
}
