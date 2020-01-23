package bd.dev.tarik.fundamentalsoffragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SendDataFromActivityToFragment extends AppCompatActivity {
    private static final String TAG = SendDataFromActivityToFragment.class.getSimpleName();
    private FragmentManager manager;
    private EditText etFirstNumber, etSecondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_data_from_activity_fragment);
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

        ActivityToFragment fragment = new ActivityToFragment();
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

        ActivityToFragment fragment = new ActivityToFragment();
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
