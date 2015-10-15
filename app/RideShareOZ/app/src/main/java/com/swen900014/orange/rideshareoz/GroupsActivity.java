package com.swen900014.orange.rideshareoz;

/**
 * Created by Geroge on 6/09/2015.
 * Display a list of rides relevant to the current user,
 * or a list of search results
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class GroupsActivity extends AppCompatActivity
{

    private  GroupFragment groupFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        if (savedInstanceState == null)
        {
            groupFragment = new GroupFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, (groupFragment))
                    .commit();
        }

        getIntent();
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            //startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRestart(){
        super.onRestart();
        groupFragment.sendGetGroupsRequest();
    }
}
