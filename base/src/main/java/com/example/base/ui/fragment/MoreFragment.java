package com.example.base.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by mengshirui on 2018/1/18 0018.
 */

public class MoreFragment extends BaseFragment {


    @Override
    protected View initView(LayoutInflater inflater) {
        TextView tv = new TextView(context);
        tv.setText("MoreFragment");
        return tv;
    }

    @Override
    protected void initDate(Bundle savedInstanceState) {

    }


}
