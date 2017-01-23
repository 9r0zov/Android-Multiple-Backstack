package com.tech.mustache.navtabbackstack.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tech.mustache.navtabbackstack.R;

/**
 * Created by Kruglov on 23.01.2017.
 */

public class TabFragment extends Fragment {

    public static final String FRAGMENT_ID = "FRAGMENT_ID";

    Button btnNext;
    TextView tvFragmentId;
    int fragmentId;

    public static TabFragment getInstance(int id) {
        TabFragment tabFragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(FRAGMENT_ID, id);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnNext = (Button) view.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
                        .replace(R.id.container, TabFragment.getInstance(++fragmentId))
                        .addToBackStack(null)
                        .commit();
            }
        });

        tvFragmentId = (TextView) view.findViewById(R.id.tv_fragment_id);
        if (getArguments() != null) {
            fragmentId = getArguments().getInt(FRAGMENT_ID, 0);
            tvFragmentId.setText(String.valueOf(fragmentId));
        }
    }
}
