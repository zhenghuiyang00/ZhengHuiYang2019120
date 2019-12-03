package combwei.zhenghuiyang20191203.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;

import combwei.zhenghuiyang20191203.R;
import combwei.zhenghuiyang20191203.base.BaseFragment;
import combwei.zhenghuiyang20191203.entity.EntityBean;
import combwei.zhenghuiyang20191203.moedl.Utils.NetUtlis;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {


    private GridView gv;
    private RelativeLayout rl;

    @Override
    protected void initView(View inflate) {
        rl = inflate.findViewById(R.id.rl);
        gv = inflate.findViewById(R.id.gv);



    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {

        if (NetUtlis.getInstance().hasNet(getActivity())){
            rl.setVisibility(View.GONE);
            gv.setVisibility(View.VISIBLE);


            String httpUrl="";

            NetUtlis.getInstance().getJson(httpUrl, new NetUtlis.Mycallback() {
                @Override
                public void getJson(String json) {
                    Gson gson = new Gson();
                    EntityBean entityBean = gson.fromJson(json, EntityBean.class);

                }
            });


        }else {
            rl.setVisibility(View.VISIBLE);
            gv.setVisibility(View.GONE);
        }




    }
}
