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


public class FirstActivity extends Activity {
    private static String TAG = "FirstActivity";
    private static final int myRequest = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.activity_first);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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
        getMenuInflater().inflate(R.menu.first, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_first, container, false);
            return rootView;
        }
    }

    public void buttonPressed(View view) {
        Log.i(TAG, "buttonPressed");
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("param", new Date().toString());
        startActivityForResult(intent, myRequest);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG, "onActivityResult");

        switch (requestCode) {
            case myRequest:
                if (resultCode == RESULT_OK) {
                    String result = data.getStringExtra("result");
                    TextView resultView = (TextView)findViewById(R.id.first_value_view);
                    resultView.setText(result);
                }

                break;
        }
    }
}
