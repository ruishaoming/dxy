package com.dxy.happy.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseFragment;
import com.dxy.happy.utils.CommonUtils;
import com.dxy.happy.view.ShowingPage;

/**
 * 社区
 * Created by 芮靖林
 * on 2016/12/28 12:00.
 */

public class Community_Fragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener, View.OnClickListener {

    private ViewPager view_pager;
    private RadioGroup rg_community;
    private ImageView image_email;

    @Override
    protected void onLoad() {
        this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
    }

    @Override
    protected View createSuccessView() {
        View rootView = CommonUtils.inflate(R.layout.community_fragment);
        view_pager = (ViewPager) rootView.findViewById(R.id.viewPager_community);
        rg_community = (RadioGroup) rootView.findViewById(R.id.rg_community);
        image_email = (ImageView) rootView.findViewById(R.id.image_email);
        image_email.setOnClickListener(this);
        rg_community.setOnCheckedChangeListener(this);
        view_pager.setOnPageChangeListener(this);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        view_pager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new Community_Forum_Fragment();
                        break;
                    case 1:
                        fragment = new Community_Choiceness_Fragment();
                        break;
                    case 2:
                        fragment = new Community_All_Fragment();
                        break;

                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        view_pager.setCurrentItem(1);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 0; i < 3; i++) {
            if (rg_community.getChildAt(i).getId() == checkedId) {

                view_pager.setCurrentItem(i);
            }

        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < 3; i++) {
            RadioButton rb = (RadioButton) rg_community.getChildAt(i);
            if (i == position) {
                rb.setChecked(true);
            } else {
                rb.setChecked(false);
            }
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_email:

            break;
        }
    }
}
