package bd.dev.tarik.fundamentalsoffragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.e(TAG, "onCreate");
        setContentView(R.layout.activity_main);


        /*HelloFragment helloFragment = new HelloFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction(); // Transaction should be completed with a commit call, which will be our last step after performing the transaction.

        //transaction.add(R.id.relativeLayout, helloFragment, "helloFragment");
        transaction.add(R.id.container, helloFragment, "helloFragment");
        transaction.commit();*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Log.e(TAG, "onStart");
    }

    @Override
    protected void onResume()  {
        super.onResume();
        //Log.e(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Log.e(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Log.e(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Log.e(TAG, "onDestroy");
    }

    public void addFragmentA(View view) {
    }

    public void removeFragmentA(View view) {
    }

    public void addFragmentB(View view) {
    }

    public void removeFragmentB(View view) {
    }
}
