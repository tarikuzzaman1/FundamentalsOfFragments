package bd.dev.tarik.fundamentalsoffragments.back_stack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import bd.dev.tarik.fundamentalsoffragments.R;

public class BackStackMainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private static final String TAG = BackStackMainActivity.class.getSimpleName();
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_stack_main);
        manager = getSupportFragmentManager();
        manager.addOnBackStackChangedListener(this);
    }

    public void addBackstackFragmentA(View view) {
        BackStackFragmentA fragmentA = new BackStackFragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerBackStack, fragmentA, "bsfragA");
        transaction.addToBackStack("AddFragA");
        transaction.commit();
    }

    public void removeBackstackFragmentA(View view) {
        BackStackFragmentA fragmentA = (BackStackFragmentA) manager.findFragmentByTag("bsfragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.remove(fragmentA);
            transaction.addToBackStack("RemFragA");
            transaction.commit();
        } else {
            Toast.makeText(this, "BackStackFragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void addBackstackFragmentB(View view) {
        BackStackFragmentB fragmentB = new BackStackFragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerBackStack, fragmentB, "bsfragB");
        transaction.addToBackStack("AddFragB");
        transaction.commit();
    }

    public void removeBackstackFragmentB(View view) {
        BackStackFragmentB fragmentB = (BackStackFragmentB) manager.findFragmentByTag("bsfragB");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentB != null) {
            transaction.remove(fragmentB);
            transaction.addToBackStack("RemFragB");
            transaction.commit();
        } else {
            Toast.makeText(this, "Back Stack Fragment B not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void replaceByBackstackFragmentA(View view) {
        BackStackFragmentA fragmentA = new BackStackFragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerBackStack, fragmentA, "bsfragA");
        transaction.addToBackStack("RepByFragA");
        transaction.commit();
    }

    public void replaceByBackstackFragmentB(View view) {
        BackStackFragmentB fragmentB = new BackStackFragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerBackStack, fragmentB, "bsfragB");
        transaction.addToBackStack("RepByFragB");
        transaction.commit();
    }

    public void attachBackstackFragmentA(View view) {
        BackStackFragmentA fragmentA = (BackStackFragmentA) manager.findFragmentByTag("bsfragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.attach(fragmentA);
            transaction.addToBackStack("AttachFragA");
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void detachBackstackFragmentA(View view) {
        BackStackFragmentA fragmentA = (BackStackFragmentA) manager.findFragmentByTag("bsfragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.detach(fragmentA);
            transaction.addToBackStack("DetachFragA");
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void showBackstackFragmentA(View view) {
        BackStackFragmentA fragmentA = (BackStackFragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.show(fragmentA);
            transaction.addToBackStack("ShowFragA");
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void hideBackstackFragmentA(View view) {
        BackStackFragmentA fragmentA = (BackStackFragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.hide(fragmentA);
            transaction.addToBackStack("HideFragA");
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void dummyBackButtonClick(View view) {
        manager.popBackStack();
    }

    public void pop_AddFragA_Inclusive_Transaction(View view) {
        manager.popBackStack("AddFragA", FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public void pop_AddFragB_Transaction(View view) {
        manager.popBackStack("AddFragB", 0);
    }

    @Override
    public void onBackStackChanged() {
        int length = manager.getBackStackEntryCount();
        StringBuilder msg = new StringBuilder("");
        for (int i = length - 1; i >=0 ; i--) {
            msg.append("Index ").append(i).append(":");
            msg.append(manager.getBackStackEntryAt(i).getName());
            msg.append(" \n ");
        }
        Log.i(TAG, "\n" + msg.toString() + "\n");
    }

    @Override
    public void onBackPressed() {
        if (manager.getBackStackEntryCount() > 0) {
            manager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
