package bd.dev.tarik.fundamentalsoffragments.fragment_to_fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import bd.dev.tarik.fundamentalsoffragments.Constants;
import bd.dev.tarik.fundamentalsoffragments.R;

public class FragmentTOFragmentActivity extends AppCompatActivity implements MyListener {

    private static final String TAG = FragmentTOFragmentActivity.class.getSimpleName();
    private FragmentManager manager;
    private int firstNum, secondNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_to_fragment);

        manager = getSupportFragmentManager();

        addFragmentX();
        addFragmentY();
    }

    private void addFragmentX() {
        FragmentX fragment = new FragmentX();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerFragmentX, fragment, Constants.TAGAFragmentX);
        transaction.commit();
    }
    private void addFragmentY() {
        FragmentY fragment = new FragmentY();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerFragmentY, fragment, Constants.TAGAFragmentY);
        transaction.commit();
    }

    @Override
    public void addTwoNumber(int firstNumber, int secondNumber) {
        this.firstNum = firstNumber;
        this.secondNum = secondNumber;
        Toast.makeText(this, "Numbers received in Activity : " + firstNum + " , " + secondNum, Toast.LENGTH_LONG).show();
    }

    public void sendDataToFragmentY(View view) {
        FragmentY fragmentY = (FragmentY) manager.findFragmentByTag(Constants.TAGAFragmentY);
        fragmentY.addTwoNumbersInFragmentX(firstNum, secondNum);
    }
}


interface MyListener {
    void addTwoNumber(int firstNumber, int secondNumber);
}

