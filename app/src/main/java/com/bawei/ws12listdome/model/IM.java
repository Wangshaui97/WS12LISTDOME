package com.bawei.ws12listdome.model;


import com.bawei.ws12listdome.mycallback.MyCallback;

public interface IM {
    void setRequest(String url, MyCallback myCallback);
}
