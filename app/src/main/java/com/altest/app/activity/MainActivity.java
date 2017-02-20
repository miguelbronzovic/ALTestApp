package com.altest.app.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;

import com.altest.R;
import com.altest.app.fragment.ImageListFragment;

/**
 * Entry point Activity for the Application. </br>
 *
 * Created by Miguel Bronzovic.
 */
public final class MainActivity extends ActionBarActivity {
    private final static String FRAGMENT_STATE = "fragment_state";

    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);

        if (savedInstanceState != null) {
            getSupportFragmentManager().getFragment(savedInstanceState, FRAGMENT_STATE);
        } else {
            currentFragment = ImageListFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_content, currentFragment, "current")
                    .commit();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        getSupportFragmentManager().putFragment(outState, FRAGMENT_STATE, currentFragment);
    }
}
