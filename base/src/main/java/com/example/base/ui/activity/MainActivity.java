package com.example.base.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.base.R;
import com.example.base.ui.fragment.BaseFragment;
import com.example.base.utils.FragmentFactory;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends FragmentActivity {

    @InjectView(R.id.main_fragment_container)
    FrameLayout mainFragmentContainer;
    //底部切换TAB
    @InjectView(R.id.main_bottome_switcher_container)
    LinearLayout mainBottomeSwitcherContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        //默认选择第一页
        onClickListener.onClick(mainBottomeSwitcherContainer.getChildAt(0));
        setListener();

    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int index = mainBottomeSwitcherContainer.indexOfChild(v);
            changeUI(index);
            changerFragment(index);

        }
    };

    /**
     * 根据底部按钮切换fragment
     * @param index
     */
    private void changerFragment(int index) {
        BaseFragment newFragment = FragmentFactory.creatFragment(index);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container,newFragment)
                .commit();
    }

    /**
     * 改变按钮控件状态
     */
    private void changeUI(int index) {
        int childCount = mainBottomeSwitcherContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (index == i) {
                //更改控件内子元素状态
                setEnable(mainBottomeSwitcherContainer.getChildAt(i),false);
            } else {
                setEnable(mainBottomeSwitcherContainer.getChildAt(i),true);
            }
        }
    }

    /**
     * 递归更改所有元素控件状态
     * @param item
     * @param b
     */
    private void setEnable(View item, boolean b) {
        item.setEnabled(b);

        if(item instanceof ViewGroup){
            int childCount = ((ViewGroup) item).getChildCount();
            for (int i =0 ;i<childCount ;i++){
                setEnable(((ViewGroup) item).getChildAt(i),b);
            }
        }

    }


    /**
     * 底部按钮监听
     */
    private void setListener() {
        int childCount = mainBottomeSwitcherContainer.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View childAt = mainBottomeSwitcherContainer.getChildAt(i);
            childAt.setOnClickListener(onClickListener);
        }

    }
}
