package bd.dev.tarik.fundamentalsoffragments.fragment_to_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import bd.dev.tarik.fundamentalsoffragments.Constants;
import bd.dev.tarik.fundamentalsoffragments.R;

public class FragmentToActivityActivity extends AppCompatActivity implements MyListener {

    private static final String TAG = FragmentToActivityActivity.class.getSimpleName();
    private FragmentManager manager;
    private TextView txvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_to_activity);
        txvResult = findViewById(R.id.txvResult);

        manager = getSupportFragmentManager();
        addFragment();
    }

    private void addFragment() {
        FragmentFragmentToActivity fragment = new FragmentFragmentToActivity();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerFragmentActivityToFragment, fragment, Constants.TAGActivityToFragment);
        transaction.commit();
    }

    @Override
    public void addTwoNumber(int firstNumber, int secondNumber) {
        int result = firstNumber + secondNumber;
        txvResult.setText("Result: " + result);
    }
}


interface MyListener {
    void addTwoNumber(int firstNumber, int secondNumber);
}
