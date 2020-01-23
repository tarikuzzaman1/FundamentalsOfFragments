package bd.dev.tarik.fundamentalsoffragments.fragment_to_activity;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import bd.dev.tarik.fundamentalsoffragments.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFragmentToActivity extends Fragment {


    private Button btnSend;
    private EditText etFirstNumber, etSecondNumber;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_to_activity, container, false);

        etFirstNumber = view.findViewById(R.id.etFirstNumber);
        etSecondNumber = view.findViewById(R.id.etSecondNumber);
        btnSend = view.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
        return view;
    }

    private void sendData() {
        int firstNumber = Integer.valueOf(etFirstNumber.getText().toString().trim());
        int secondNumber = Integer.valueOf(etSecondNumber.getText().toString().trim());
        MyListener myListener = (MyListener) getActivity();
        myListener.addTwoNumber(firstNumber, secondNumber);
    }

}
