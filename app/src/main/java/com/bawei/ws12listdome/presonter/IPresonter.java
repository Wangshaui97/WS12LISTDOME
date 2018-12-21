package com.bawei.ws12listdome.presonter;


import com.bawei.ws12listdome.model.IModel;
import com.bawei.ws12listdome.mycallback.MyCallback;
import com.bawei.ws12listdome.view.IView;

public class IPresonter implements IP {
    private IView iView;
    private IModel iModel;

    public IPresonter(IView iView) {
        this.iView = iView;
        iModel = new IModel();
    }


    @Override
    public void setRequest(String url) {
        iModel.setRequest(url, new MyCallback() {
            @Override
            public void setData(Object data) {
                iView.setRequest(data);
            }
        });

    }

    //内存泄露
    public void onDistuch() {
        if (iModel != null) {
            iModel = null;
        }
        if (iView != null) {
            iView = null;
        }
    }

}
