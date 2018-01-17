package com.example.base.presenter;

import com.example.base.presenter.api.ResponsInfoAPI;
import com.example.base.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 业务层公共部分代码封装
 */

public class BasePresenter {

    public static ResponsInfoAPI responsInfoAPI;
    //数据库

    //网络

    public BasePresenter() {

        if(responsInfoAPI==null){
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.baseUrl(Constant.BASEURL);
            //Gson解析
            builder.addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.build();

            responsInfoAPI = retrofit.create(ResponsInfoAPI.class);
        }

    }
}
