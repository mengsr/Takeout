package com.example.base.utils;

import com.example.base.ui.fragment.BaseFragment;
import com.example.base.ui.fragment.HomeFragment;
import com.example.base.ui.fragment.MeFragment;
import com.example.base.ui.fragment.MoreFragment;
import com.example.base.ui.fragment.OrderFragment;

import java.util.HashMap;

/**
 * Created by mengshirui on 2018/1/18 0018.
 */

public class FragmentFactory {

    private final static int TAB_HOME = 0;
    private final static int TAB_ME = 1;
    private final static int TAB_MORE = 2;
    private final static int TAB_ORDER = 3;

    //初始化fragment缓存对象
    private static HashMap<Integer, BaseFragment> mFragments = new HashMap<Integer, BaseFragment>();

    public static BaseFragment creatFragment(int position) {
// 首先从内存获取。如果内存里面没有。那么直接new出来，如果有那么直接使用内存里面的fragment
        BaseFragment fragment = mFragments.get(position);
        if (fragment == null) {
            switch (position) {
                case TAB_HOME:
                    fragment = new HomeFragment();
                    break;
                case TAB_ME:
                    fragment = new MeFragment();
                    break;
                case TAB_MORE:
                    fragment = new MoreFragment();
                    break;
                case TAB_ORDER:
                    fragment = new OrderFragment();
                    break;
            }
            //添加到内存
            mFragments.put(position, fragment);
        }
        return fragment;

    }

}
