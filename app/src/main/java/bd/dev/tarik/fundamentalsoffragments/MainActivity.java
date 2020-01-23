package bd.dev.tarik.fundamentalsoffragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.e(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();

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

        FragmentA fragmentA = new FragmentA();

        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.container, fragmentA, "fragA");
        transaction.commit();
    }

    public void removeFragmentA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if(fragmentA != null) {
            transaction.remove(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void addFragmentB(View view) {

        FragmentB fragmentB = new FragmentB();

        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.container, fragmentB, "fragB");
        transaction.commit();
    }

    public void removeFragmentB(View view) {
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");
        FragmentTransaction transaction = manager.beginTransaction();
        if(fragmentB != null) {
            transaction.remove(fragmentB);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment B not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void replaceByFragmentA(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentA, "fragA");
        transaction.commit();
    }

    public void replaceByFragmentB(View view) {
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentB, "fragB");
        transaction.commit();
    }

    public void attachFragmentA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.attach(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void detachFragmentA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.detach(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void showFragmentA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.show(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void hideFragmentA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.hide(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }
}
