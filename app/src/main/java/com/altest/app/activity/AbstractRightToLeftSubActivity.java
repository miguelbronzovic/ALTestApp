package com.altest.app.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

import com.altest.R;

/**
 * Abstract activity for all the subactivities in the app that require the following features:
 * <ul>
 * <li>Home indicator as back button</li>
 * <li>Logging TAG</li>
 * </ul>
 * 
 * The activities enter from <b>right to left, and pops from left to right</b>. <br/>
 * 
 * @author Miguel Bronzovic
 */
public abstract class AbstractRightToLeftSubActivity extends ActionBarActivity {
	
	/**
     * Initialize this activity. <br/>
     * 
     * @param the saved state bundle
     */
    @SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        overridePendingTransition(R.anim.slide_right, R.anim.slide_left);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setHomeButtonEnabled(true);
        
    }
    
    /**
     * Handle the Home Up button. <br/>
     * 
     * @param the selected menu item
     * @return true if handled, false otherwise
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (android.R.id.home == item.getItemId()) {        	        	
            onBackPressed();
            
            return true;
        }
        
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public void onBackPressed() {
    	super.onBackPressed();
    	
    	overridePendingTransition(R.anim.slide_left_pop, R.anim.slide_right_pop);
    }
}
