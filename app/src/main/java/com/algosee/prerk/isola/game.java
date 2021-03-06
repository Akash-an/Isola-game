package com.algosee.prerk.isola;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class game extends ActionBarActivity {

    private DrawerLayout mDrawerLayout;
    private RecyclerView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mOptions;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mTitle = mDrawerTitle = getTitle();
        mOptions = getResources().getStringArray(R.array.options_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (RecyclerView) findViewById(R.id.left_drawer);

        mDrawerList.setHasFixedSize(true);
        mDrawerList.setLayoutManager(new LinearLayoutManager(this));

        // set up the drawer's list view with items and click listener
        mDrawerList.setAdapter(new NavDrawerAdapter(mOptions, this));
        // enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                //R.drawable.,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }

    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
//        menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void onClick(View view, int position) {
        selectItem(position);
    }

    private void selectItem(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();

        switch (position) {
            case 0:
                //fragment = new FilterFragment();
                //ft.replace(R.id.content_frame, fragment);
                //ft.commit();
                break;

            case 1:
                /*if(Splash.SUPER_FLAG == 0) {
                    fragment = new myAccount();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }
                else{
                    fragment = new Upload();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }*/
                break;

            case 2:
                /*if(Splash.SUPER_FLAG == 0) {
                    fragment = new my_copies();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }
                else
                {
                    fragment = new credit();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }*/
                break;

            case 3:
                /*if(Splash.SUPER_FLAG == 0) {
                    Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                    SharedPreferences credentialsSharedPref = getSharedPreferences(Login.PREFS_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor credentialsEditor = credentialsSharedPref.edit();
                    credentialsEditor.clear();
                    credentialsEditor.commit();
                    Intent i = new Intent(this, Login.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    fragment = new pending_copies();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }*/
                break;

            case 4:
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                /*SharedPreferences credentialsSharedPref = getSharedPreferences(Login.PREFS_NAME, MODE_PRIVATE);
                SharedPreferences.Editor credentialsEditor = credentialsSharedPref.edit();
                credentialsEditor.clear();
                credentialsEditor.commit();
                Intent i = new Intent(this, Login.class);
                startActivity(i);
                finish();*/
                break;
        }


        // update selected item title, then close the drawer
        setTitle(mOptions[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }




}
