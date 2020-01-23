package bd.dev.tarik.fundamentalsoffragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class ActivityToFragment extends Fragment {

    private static final String TAG = ActivityToFragment.class.getSimpleName();

    private Button btnAdd;
    private TextView txvResult;

    private int firstNumber = 0, secondNumber = 0;
    private SendDataFromActivityToFragment.Employee employee;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        if (bundle != null) {
            firstNumber = bundle.getInt(Constants.FIRST_NUM, 0);
            secondNumber = bundle.getInt(Constants.SECOND_NUM, 0);
        }
        View view = inflater.inflate(R.layout.fragment_show_passed_data_activity_to_fragment, container, false);
        txvResult = view.findViewById(R.id.txvResult);
        btnAdd = view.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTwoNumbers(firstNumber, secondNumber);
            }
        });
        return view;
    }

    private void addTwoNumbers(int firstNum, int secondNum) {
        int result = firstNum + secondNum;
        txvResult.setText("Result: " + result);
    }

    public void setData(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public void setEmployeeObj(SendDataFromActivityToFragment.Employee employee) {
        this.employee = employee;
    }
}
