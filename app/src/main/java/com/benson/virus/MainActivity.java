package com.benson.virus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;

import com.benson.Activity.XXFragment.ContentMainFragment;
import com.benson.Activity.XXFragment.WeatherFragment;
import com.benson.Activity.XXFragment.BannerFragment;
import com.benson.Activity.XXFragment.wipeRefreshFragment;
import com.benson.Tools.Login.LoginSignInActivity;
import com.benson.Tools.UpdateApp.UpdateManager;
import com.benson.game.AgileBuddy.Splash;
import com.benson.game.NumberGame.NumberActivity.SudokuActivity;
import com.benson.Tools.JPush.JPushUtil;
import com.benson.views.ViewPager.AdapterFragment;
import com.benson.views.ViewPager.AdapterViewpager;
import com.benson.views.ViewPager.DepthPageTransformer;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,OnClickListener{


    private static final String TAG = "Virus_MainActivity";
    private Context self;
    //极光调试
    public static boolean isForeground = false;

    //极光调试 end

    // OK http调试
    private int level = 1;


    private View view1, view2, view3;//需要滑动的页卡
    private ViewPager viewPager;//viewpager
    private PagerTitleStrip pagerTitleStrip;//viewpager的标题
    private PagerTabStrip pagerTabStrip;//一个viewpager的指示器，效果就是一个横的粗的下划线
    private List<View> viewList;//把需要滑动的页卡添加到这个list中
    private List<String> titleList;//viewpager的标题
    private Button weibo_button;//button对象，一会用来进入第二个Viewpager的示例


    // OK http调试 end

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //极光调试


        //极光调试 end
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //检测App更新
        checkUpdateApp(this);
        self = this;
        //调试
        initView();
        //调试 end

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            default:
                break;
        }


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Log.i(TAG, "注册/登录...... ");

            Intent intent = new Intent(MainActivity.this,LoginSignInActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_game) {
            Log.i(TAG, "nav_game");
//            setContentView(new SudokuView(this));
            //新建一个显式意图，第一个参数为当前Activity类对象，第二个参数为你要打开的Activity类
            Intent intent = new Intent(MainActivity.this, Splash.class);
            startActivity(intent);

        } else if (id == R.id.nav_send) {
//            Intent intent = new Intent(MainActivity.this,SudukuActivity.class);
            Intent intent = new Intent(MainActivity.this,SudokuActivity.class);

            intent.putExtra("level", ""+level);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    protected void onResume() {

        isForeground = true;

        super.onResume();
    }

    @Override
    protected void onPause() {

        isForeground = false;
        super.onPause();
    }


    //for receive customer msg from jpush server
    private MessageReceiver mMessageReceiver;
    public static final String MESSAGE_RECEIVED_ACTION = "com.benson.virus.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_TITLE = "title";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";

    public void registerMessageReceiver() {
        mMessageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        filter.addAction(MESSAGE_RECEIVED_ACTION);
        registerReceiver(mMessageReceiver, filter);
    }





    public class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (MESSAGE_RECEIVED_ACTION.equals(intent.getAction())) {
                String messge = intent.getStringExtra(KEY_MESSAGE);
                String extras = intent.getStringExtra(KEY_EXTRAS);
                StringBuilder showMsg = new StringBuilder();
                showMsg.append(KEY_MESSAGE + " : " + messge + "\n");
                if (!JPushUtil.isEmpty(extras)) {
                    showMsg.append(KEY_EXTRAS + " : " + extras + "\n");
                }
                setCostomMsg(showMsg.toString());
            }
        }
    }

    /**
     * 检测App更新 add by Benson
     * @param context
     */
    private void checkUpdateApp(Context context){
        Log.i(TAG,"检测App更新...");

        UpdateManager updateManager = new UpdateManager(context);
        updateManager.getAppInfocheckUpdate();
    }

    private void setCostomMsg(String msg){

        Log.i(TAG, "setCostomMsg: " + msg);

//        if (null != msgText) {
//            msgText.setText(msg);
//            msgText.setVisibility(android.view.View.VISIBLE);
//        }
    }



    private void initViewPagers() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        //pagerTitleStrip = (PagerTitleStrip) findViewById(R.id.pagertitle);
//        pagerTabStrip=(PagerTabStrip) findViewById(R.id.pagertab);
//        pagerTabStrip.setTabIndicatorColor(getResources().getColor(R.color.white));
//        pagerTabStrip.setDrawFullUnderline(false);
//        pagerTabStrip.setBackgroundColor(getResources().getColor(R.color.yellow));
//        pagerTabStrip.setTextSpacing(50);

        LayoutInflater lf = getLayoutInflater().from(this);
        view1 = lf.inflate(R.layout.layout1, null);
        view2 = lf.inflate(R.layout.layout2, null);
        view3 = lf.inflate(R.layout.layout3, null);

        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        titleList = new ArrayList<String>();// 每个页面的Title数据
        titleList.add("wp");
        titleList.add("jy");
        titleList.add("jh");

        AdapterViewpager pagerAdapter = new AdapterViewpager(viewList,titleList);
        viewPager.setAdapter(pagerAdapter);
    }


    private void initView(){
        //构造适配器
        List<Fragment> fragments=new ArrayList<Fragment>();

        fragments.add(new ContentMainFragment());
        fragments.add(new WeatherFragment());
        fragments.add(new BannerFragment());
        fragments.add(new wipeRefreshFragment());

        AdapterFragment adapter = new AdapterFragment(getSupportFragmentManager(), fragments);

        //设定适配器
        ViewPager vp = (ViewPager)findViewById(R.id.viewpager);
        vp.setAdapter(adapter);
        vp.setPageTransformer(true, new DepthPageTransformer());
    }


}
