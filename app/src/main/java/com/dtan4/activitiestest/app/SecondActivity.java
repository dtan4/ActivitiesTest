package com.dtan4.activitiestest.app;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.TextView;

import java.util.Date;


public class SecondActivity extends Activity {
    private static String TAG = "SecondActivity";
    private String param;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        param = getIntent().getStringExtra("param");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onStart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onStart();
        Log.i(TAG, "onResume");

        TextView paramView = (TextView)findViewById(R.id.second_value_view);
        paramView.setText(param);
    }

    @Override
    protected void onPause() {
        super.onStart();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStart();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onStart();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_second, container, false);
            return rootView;
        }
    }

    public void buttonPressed(View view) {
        Log.i(TAG, "buttonPressed");
        Intent intent = new Intent(this, FirstActivity.class);
        intent.putExtra("result", new Date().toString());
        startActivity(intent);
    }
}
