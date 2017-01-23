package com.tech.mustache.navtabbackstack;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by Kruglov on 23.01.2017.
 */

public class NavActivity extends ActivityGroup {

    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(getLocalActivityManager());

        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator(getString(R.string.tab_1_name));

        tabSpec.setContent(new Intent(this, AnotherActivity.class));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator(getString(R.string.tab_2_name));

        tabSpec.setContent(new Intent(this, AnotherActivity.class));
        tabHost.addTab(tabSpec);
    }
}
