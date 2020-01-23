package bd.dev.tarik.fundamentalsoffragments.activity_to_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import bd.dev.tarik.fundamentalsoffragments.Constants;
import bd.dev.tarik.fundamentalsoffragments.R;

public class ActivityToFragmentActivity extends AppCompatActivity {
    private static final String TAG = ActivityToFragmentActivity.class.getSimpleName();
    private FragmentManager manager;
    private EditText etFirstNumber, etSecondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_to_fragment);
        manager = getSupportFragmentManager();
        etFirstNumber = findViewById(R.id.etFirstNumber);
        etSecondNumber = findViewById(R.id.etSecondNumber);
    }

    // TODO Pass Data to Fragment from Activity Using Bundle Object
    public void sendDataToFragmentUsingBundleObject(View view) {

        int firstNumber = Integer.valueOf(etFirstNumber.getText().toString().trim());
        int secondNumber = Integer.valueOf(etSecondNumber.getText().toString().trim());

        Bundle bundle = new Bundle();
        bundle.putInt(Constants.FIRST_NUM, firstNumber);
        bundle.putInt(Constants.SECOND_NUM, secondNumber);

        FragmentActivityToFragment fragment = new FragmentActivityToFragment();
        fragment.setArguments(bundle);

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerFragmentA, fragment, "fragA");
        transaction.commit();
    }
    public void sendDataToFragmentUsingFragmentObject(View view) {

        int firstNumber = Integer.valueOf(etFirstNumber.getText().toString().trim());
        int secondNumber = Integer.valueOf(etSecondNumber.getText().toString().trim());

        /*Bundle bundle = new Bundle();
        bundle.putInt(Constants.FIRST_NUM, firstNumber);
        bundle.putInt(Constants.SECOND_NUM, secondNumber);*/

        FragmentActivityToFragment fragment = new FragmentActivityToFragment();
        //fragment.setArguments(bundle);
        fragment.setData(firstNumber, secondNumber); // Passing the primitive Data Type
        fragment.setEmployeeObj(new Employee()); // Passing Non-primitive Type Data

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerFragmentA, fragment, "fragA");
        transaction.commit();
    }

    public class Employee {
        String name;
        int profId;
    }
}
