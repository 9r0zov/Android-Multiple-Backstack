package com.tech.mustache.navtabbackstack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tech.mustache.navtabbackstack.fragment.TabFragment;

/**
 * Created by Kruglov on 23.01.2017.
 */

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_layout);

        getSupportActionBar().hide();

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
                .replace(R.id.container, TabFragment.getInstance(0))
                .addToBackStack(null)
                .commit();
    }
}
