package com.example.base.ui.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.base.MyApplication;

/**
 * Created by mengshirui on 2018/1/18 0018.
 */

public abstract class BaseFragment extends Fragment {
    private View view;
    public Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = MyApplication.getContext();
    }

    /**
     * 初始化View
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = initView(inflater);
        return view;
    }

    /**
     * 初始化数据
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        //初始化数据
        initDate(savedInstanceState);
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 初始化数据
     * @param savedInstanceState
     */
    protected abstract void initDate(Bundle savedInstanceState);

    /**
     * 初始化view
     * @param inflater
     * @return
     */
    protected abstract View initView(LayoutInflater inflater);
}
