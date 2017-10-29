package com.example.jimmo__.square;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ViewPager pager;
    private Fragment Fragment1;
    private Fragment Fragment2;


    private PieChart mChart;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment1 = new Fragment1();
        Fragment2 = new Fragment2();

        pager = (ViewPager) findViewById(R.id.view_pager);

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        adapter.addFragment(Fragment1, "1");
        adapter.addFragment(Fragment2, "2");
        pager.setAdapter(adapter);


        mChart = (PieChart) findViewById(R.id.chart1);
        mChart.setUsePercentValues(true);
        mChart.getDescription().setEnabled(false);
//        mChart.setExtraOffsets(5, 10, 5, 5);


        mChart.setDragDecelerationFrictionCoef(0.95f);


        mChart.setCenterText("100%");

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.WHITE);

//        mChart.setTransparentCircleColor(Color.WHITE);
//        mChart.setTransparentCircleAlpha(110);

        mChart.setHoleRadius(70f);
//        mChart.setTransparentCircleRadius(61f);

        mChart.setDrawCenterText(true);


        mChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        mChart.setRotationEnabled(true);
        mChart.setHighlightPerTapEnabled(true);

        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);
        mChart.setDrawSlicesUnderHole(false);
        // add a selection listener


        mChart.getLegend().setEnabled(false);







        setData(1, 98);

        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        //mChart.spin(2000, 0, 360);


        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);

        final ImageView img1 = new ImageView(this);
        img1.setBackground((getDrawable(R.drawable.dev_click)));
        tabLayout.getTabAt(0).setCustomView(img1);

        final ImageView img2 = new ImageView(this);
        img2.setBackground((getDrawable(R.drawable.timeline_unclick)));
        tabLayout.getTabAt(1).setCustomView(img2);


        tabLayout.setOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(pager) {

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
                        if (tab == tabLayout.getTabAt(1)) {
                            img2.setBackground((getDrawable(R.drawable.timeline_click)));
                            tabLayout.getTabAt(1).setCustomView(img2);
                        } else {
                            img1.setBackground((getDrawable(R.drawable.dev_click)));
                            tabLayout.getTabAt(0).setCustomView(img1);
                        }
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);
                        if (tab == tabLayout.getTabAt(1)) {
                            img2.setBackground((getDrawable(R.drawable.timeline_unclick)));
                            tabLayout.getTabAt(1).setCustomView(img2);
                        } else {
                            img1.setBackground((getDrawable(R.drawable.dev_unclick)));
                            tabLayout.getTabAt(0).setCustomView(img1);
                        }

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        super.onTabReselected(tab);
                    }
                }
        );


    }


    private void setData(int count, float range) {
        String[] mParties = new String[]{
                "", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H",
                "Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P",
                "Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X",
                "Party Y", "Party Z"
        };

        float mult = range;

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < count; i++) {
            entries.add(new PieEntry((float) ((Math.random() * mult) + mult / 5),
                    mParties[i % mParties.length],
                    getResources().getDrawable(R.mipmap.ic_launcher)));
        }

        PieDataSet dataSet = new PieDataSet(entries, "Election Results");

        dataSet.setDrawIcons(false);

        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();

//        for (int c : ColorTemplate.VORDIPLOM_COLORS)
//            colors.add(c);
//
//        for (int c : ColorTemplate.JOYFUL_COLORS)
//            colors.add(c);
//
//        for (int c : ColorTemplate.COLORFUL_COLORS)
//            colors.add(c);
//
//        for (int c : ColorTemplate.LIBERTY_COLORS)
//            colors.add(c);

//        for (int c : ColorTemplate.PASTEL_COLORS)
//            colors.add(c);
        colors.add(Color.rgb(249, 178, 51));

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(0f);
        data.setValueTextColor(Color.WHITE);
        mChart.setData(data);

        // undo all highlights
        mChart.highlightValues(null);

        mChart.invalidate();
    }


    public class MyAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        public MyAdapter() {
            super(new FragmentManager() {
                @Override
                public FragmentTransaction beginTransaction() {
                    return null;
                }

                @Override
                public boolean executePendingTransactions() {
                    return false;
                }

                @Override
                public Fragment findFragmentById(@IdRes int id) {
                    return null;
                }

                @Override
                public Fragment findFragmentByTag(String tag) {
                    return null;
                }

                @Override
                public void popBackStack() {

                }

                @Override
                public boolean popBackStackImmediate() {
                    return false;
                }

                @Override
                public void popBackStack(String name, int flags) {

                }

                @Override
                public boolean popBackStackImmediate(String name, int flags) {
                    return false;
                }

                @Override
                public void popBackStack(int id, int flags) {

                }

                @Override
                public boolean popBackStackImmediate(int id, int flags) {
                    return false;
                }

                @Override
                public int getBackStackEntryCount() {
                    return 0;
                }

                @Override
                public BackStackEntry getBackStackEntryAt(int index) {
                    return null;
                }

                @Override
                public void addOnBackStackChangedListener(OnBackStackChangedListener listener) {

                }

                @Override
                public void removeOnBackStackChangedListener(OnBackStackChangedListener listener) {

                }

                @Override
                public void putFragment(Bundle bundle, String key, Fragment fragment) {

                }

                @Override
                public Fragment getFragment(Bundle bundle, String key) {
                    return null;
                }

                @Override
                public List<Fragment> getFragments() {
                    return null;
                }

                @Override
                public Fragment.SavedState saveFragmentInstanceState(Fragment f) {
                    return null;
                }

                @Override
                public boolean isDestroyed() {
                    return false;
                }

                @Override
                public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks cb, boolean recursive) {

                }

                @Override
                public void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks cb) {

                }

                @Override
                public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {

                }
            });
        }


        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Fragment1();
                case 1:
                    return new Fragment2();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }

        public void addItem(String name, String content) {
            item mitem = new item();
            mitem.setName(name);
            mitem.setContents(content);
        }
    }


}

