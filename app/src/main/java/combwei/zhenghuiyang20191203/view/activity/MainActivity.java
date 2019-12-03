package combwei.zhenghuiyang20191203.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import java.util.ArrayList;

import combwei.zhenghuiyang20191203.R;
import combwei.zhenghuiyang20191203.base.BaseActivity;
import combwei.zhenghuiyang20191203.view.fragment.HomeFragment;
import combwei.zhenghuiyang20191203.view.fragment.OtherFragment;
import combwei.zhenghuiyang20191203.view.fragment.ShopingFragment;

public class MainActivity extends BaseActivity{


    private ViewPager vp;
    private RadioGroup rg;
    private ArrayList<Fragment> list;

    @Override
    protected void initData() {
        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new OtherFragment());
        list.add(new ShopingFragment());

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });



    }

    @Override
    protected void initView() {
        vp = findViewById(R.id.vp);
        rg = findViewById(R.id.rg);

        rg.check(rg.getChildAt(0).getId());
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb_type:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb_find:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.rb_shoping:
                        vp.setCurrentItem(3);
                        break;
                    case R.id.rb_my:
                        vp.setCurrentItem(4);
                        break;
                }
            }
        });


    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    public void gotoHomeFragment(){

    }

}
