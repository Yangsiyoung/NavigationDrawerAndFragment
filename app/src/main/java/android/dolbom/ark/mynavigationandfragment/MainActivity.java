package android.dolbom.ark.mynavigationandfragment;

import android.content.res.Configuration;
import android.dolbom.ark.mynavigationandfragment.adapter.ToolBarTabPagerAdapter;
import android.dolbom.ark.mynavigationandfragment.listener.MyOnclickListener;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;

    private Button btnShowNavigationDrawer;

    private Button btnNavigationDrawerFirstButton;
    private Button btnNavigationDrawerSecondtButton;

    private ActionBarDrawerToggle actionBarDrawerToggle;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ToolBarTabPagerAdapter toolBarTabPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbarInclude);
        setSupportActionBar(toolbar);

        btnShowNavigationDrawer = (Button) findViewById(R.id.btnShowNavigationDrawer);
        btnShowNavigationDrawer.setOnClickListener(onClickListener);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = setUpActionBarToggle();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        navigationView = (NavigationView) findViewById(R.id.navigationView);
        btnNavigationDrawerFirstButton = (Button) navigationView.findViewById(R.id.btnNavigationDrawerFistButton);
        btnNavigationDrawerSecondtButton = (Button) navigationView.findViewById(R.id.btnNavigationDrawerSecondButton);

        MyOnclickListener myOnClickListener = new MyOnclickListener(MainActivity.this);

        btnNavigationDrawerFirstButton.setOnClickListener(myOnClickListener);
        btnNavigationDrawerSecondtButton.setOnClickListener(myOnClickListener);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("1"));
        tabLayout.addTab(tabLayout.newTab().setText("2"));
        tabLayout.addTab(tabLayout.newTab().setText("3"));
        tabLayout.addTab(tabLayout.newTab().setText("4"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        toolBarTabPagerAdapter = new ToolBarTabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(toolBarTabPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });






    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnShowNavigationDrawer:
                    drawerLayout.openDrawer(GravityCompat.START);
                    break;
            }
        }
    };

    private ActionBarDrawerToggle setUpActionBarToggle(){
        return new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    }
}
