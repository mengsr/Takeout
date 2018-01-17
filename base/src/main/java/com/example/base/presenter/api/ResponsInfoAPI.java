package com.example.base.presenter.api;

import com.example.base.model.net.bean.ResponseInfo;
import com.example.base.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mengshirui on 2017/12/25 0025.
 */

public interface ResponsInfoAPI {

    @GET(Constant.LOGIN)
    Call<ResponseInfo> login(
            @Query("username")String username,@Query("password")String password);

}
