package com.example.pc.tabnavigationandmenu;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar	toolbar	=	(Toolbar)	findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout	=	(TabLayout)	findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label3));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //	Using	PagerAdapter	to	manage	page	views	in	fragments. //
        // Each	page	is	represented	by	its	own	fragment.
        // 	This	is	another	example	of	the	adapter	pattern.
        final	ViewPager	viewPager	=	(ViewPager)	findViewById(R.id.pager);
        final	PagerAdapter	adapter	=	new	PagerAdapter
                (getSupportFragmentManager(),	tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        //	Setting	a	listener	for	clicks.
        viewPager.addOnPageChangeListener((new TabLayout.TabLayoutOnPageChangeListener(tabLayout)));
        tabLayout.addOnTabSelectedListener(new	TabLayout.OnTabSelectedListener()
        {
            @Override
            public	void onTabSelected(TabLayout.Tab	tab)
            {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public	void onTabUnselected(TabLayout.Tab	tab)
            {
            }
            @Override
            public	void onTabReselected(TabLayout.Tab	tab)
            {

            } });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.settings) {
            Toast.makeText(this, "Settings selected", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.language) {
            Toast.makeText(this, "language selected", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.About) {
            Toast.makeText(this, "About selected", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
