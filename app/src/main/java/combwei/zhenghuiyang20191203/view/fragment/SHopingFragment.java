package combwei.zhenghuiyang20191203.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import combwei.zhenghuiyang20191203.R;
import combwei.zhenghuiyang20191203.base.BaseFragment;
import combwei.zhenghuiyang20191203.view.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopingFragment extends BaseFragment {


    private Button bt;

    @Override
    protected void initView(View inflate) {
        bt = inflate.findViewById(R.id.bt);
        MainActivity mainActivity=new MainActivity();
        mainActivity.gotoHomeFragment();

    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_shoping;
    }

    @Override
    protected void initData() {

    }
}
