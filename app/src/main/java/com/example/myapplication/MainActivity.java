package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.fragment.GankMainFragment;
import com.example.myapplication.fragment.GoldMainFragment;
import com.example.myapplication.fragment.LoveFragment;
import com.example.myapplication.fragment.SettingFragment;
import com.example.myapplication.fragment.VtexMainFragment;
import com.example.myapplication.fragment.WeChatFragment;
import com.example.myapplication.fragment.ZhiHuFragment;
import com.example.myapplication.fragment.ZhiHuMainFragment;
import com.example.myapplication.fragment.ZhihuHotFragment;

//张九红  1811a
public class MainActivity extends AppCompatActivity {

    private final int ZHIHU=1;
    private final int WECHAT=2;
    private final int GANK=3;
    private final int GOLD=4;
    private final int VTEX=5;
    private final int LOVE=6;
    private final int SETTING=7;
    /**
     * 知乎日报
     */
    private TextView title;
    private Toolbar tool;
    private RelativeLayout contains;
    private NavigationView nav;
    private DrawerLayout drawer;
    private WeChatFragment weChatFragment;
    private Fragment currFragment;
    private FragmentManager manager;
    private MenuItem lastItem;
    private GankMainFragment gankMainFragment;
    private ZhiHuMainFragment zhiHuMainFragment;
    private GoldMainFragment goldMainFragment;
    private VtexMainFragment vtexMainFragment;
    private LoveFragment loveFragment;
    private SettingFragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        if (savedInstanceState!=null){
            //根据获得的类型，得到fragment对象
            int type = savedInstanceState.getInt("type");

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = manager.beginTransaction();

            //查询栈中是否有对应的fragment，这样重写开启时避免栈中对象重复创建，造成重叠（夜间模式影响）
            for (int i = 0; i < getSupportFragmentManager().getFragments().size(); i++) {
                Fragment fragment = getSupportFragmentManager().getFragments().get(i);

                if (fragment instanceof SettingFragment){
                    settingFragment= (SettingFragment) fragment;
                    fragmentTransaction.show(settingFragment);
                    currFragment=fragment;//因为设置页面是又recreat(),是最后页面，所有设置为显示
                }
                if (fragment instanceof ZhiHuMainFragment){
                    zhiHuMainFragment= (ZhiHuMainFragment) fragment;
                    fragmentTransaction.hide(zhiHuMainFragment);
                }

                if (fragment instanceof WeChatFragment){
                    weChatFragment= (WeChatFragment) fragment;
                }
                if (fragment instanceof GankMainFragment){
                    gankMainFragment= (GankMainFragment) fragment;
                }
                if (fragment instanceof GoldMainFragment){
                    goldMainFragment= (GoldMainFragment) fragment;
                }
                if (fragment instanceof VtexMainFragment){
                    vtexMainFragment= (VtexMainFragment) fragment;
                }
                if (fragment instanceof LoveFragment){
                    loveFragment= (LoveFragment) fragment;
                }
            }

            fragmentTransaction.commit();

            //设置选中状态
            nav.getMenu().findItem(R.id.zhihu).setChecked(false);
            lastItem=nav.getMenu().findItem(R.id.setting).setChecked(true);

        }

    }

//设置页面走getActivity().recreate()触发此方法;
  @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("type",SETTING);//传值给onCreate
    }

    private void initView() {
        title = (TextView) findViewById(R.id.title);
        tool = (Toolbar) findViewById(R.id.tool);
        contains = (RelativeLayout) findViewById(R.id.contains);
        nav = (NavigationView) findViewById(R.id.nav);
        drawer = (DrawerLayout) findViewById(R.id.drawer);

        tool.setTitle("");
        setSupportActionBar(tool);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, tool, R.string.app_name, R.string.app_name);
        toggle.syncState();
        drawer.addDrawerListener(toggle);

//--------------------------------toolbar-----------------------------------------------

        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();


        if (weChatFragment==null){
            weChatFragment = new WeChatFragment();
        }
        if (gankMainFragment==null){
            gankMainFragment = new GankMainFragment();
        }
        if (goldMainFragment==null){
            goldMainFragment = new GoldMainFragment();
        }
        if (vtexMainFragment==null){
            vtexMainFragment = new VtexMainFragment();
        }
        if (loveFragment==null){
            loveFragment = new LoveFragment();
        }
        if (settingFragment==null){
            settingFragment = new SettingFragment();
        }

        boolean isHasZhiHu=false;
        for (int i = 0; i < getSupportFragmentManager().getFragments().size(); i++) {
            Fragment fragment = getSupportFragmentManager().getFragments().get(i);
            if (fragment instanceof ZhiHuMainFragment){
                isHasZhiHu=true;

            }
        }

        if (!isHasZhiHu&&zhiHuMainFragment==null){
            zhiHuMainFragment = new ZhiHuMainFragment();
            transaction.add(R.id.contains,zhiHuMainFragment);
            transaction.show(zhiHuMainFragment);
            transaction.commit();
            currFragment=zhiHuMainFragment;
        }



        //设置知乎为默认选中
        lastItem = nav.getMenu().findItem(R.id.zhihu).setChecked(true);
        //动态添加fragment
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.zhihu:
                        title.setText(menuItem.getTitle());
                        Fragment targetFragment1 = getFragment(ZHIHU);
                        getSwitchFragment(targetFragment1);
                        break;
                    case R.id.wechat:
                        title.setText(menuItem.getTitle());
                        Fragment targetFragment2 = getFragment(WECHAT);
                        getSwitchFragment(targetFragment2);
                        break;
                    case R.id.gank:
                        title.setText(menuItem.getTitle());
                        Fragment targetFragment3 = getFragment(GANK);
                        getSwitchFragment(targetFragment3);
                        break;
                    case R.id.gold:
                        title.setText(menuItem.getTitle());
                        Fragment targetFragment4 = getFragment(GOLD);
                        getSwitchFragment(targetFragment4);
                        break;
                    case R.id.v2ex:
                        title.setText(menuItem.getTitle());
                        Fragment targetFragment5 = getFragment(VTEX);
                        getSwitchFragment(targetFragment5);
                        break;
                    case R.id.love:
                        title.setText(menuItem.getTitle());
                        Fragment targetFragment6 = getFragment(LOVE);
                        getSwitchFragment(targetFragment6);
                        break;
                    case R.id.setting:
                        title.setText(menuItem.getTitle());
                        Fragment targetFragment7 = getFragment(SETTING);
                        getSwitchFragment(targetFragment7);
                        break;
                }

                drawer.closeDrawer(Gravity.LEFT);//关闭侧滑

                if (lastItem !=menuItem){//切换条目背景色
                    menuItem.setChecked(true);
                    lastItem.setChecked(false);
                    lastItem =menuItem;
                }
                return true;
            }
        });
    }

    //动态添加fragment
    public void getSwitchFragment(Fragment targetFragment){
        FragmentTransaction transaction = manager.beginTransaction();
        if (currFragment==targetFragment){//重复点击一个条目，显示须次代码
            transaction.show(targetFragment);
        }else {
            if (targetFragment.isAdded()){//判断是否添加
                transaction.show(targetFragment);
                transaction.hide(currFragment);
            }else {
                transaction.add(R.id.contains,targetFragment);
                transaction.show(targetFragment);
                transaction.hide(currFragment);
            }
        }
        currFragment=targetFragment;
        transaction.commit();
    }

    //获取fragment对象
    public Fragment getFragment(int type){
        switch (type){
            case ZHIHU:
                return zhiHuMainFragment;
            case WECHAT:
                return weChatFragment;
            case GANK:
                return gankMainFragment;
            case GOLD:
                return goldMainFragment;
            case VTEX:
                return vtexMainFragment;
            case LOVE:
                return loveFragment;
            case SETTING:
                return settingFragment;
        }
        return zhiHuMainFragment;//默认
    }
}
