package bd.dev.tarik.fundamentalsoffragments.fragment_to_fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import bd.dev.tarik.fundamentalsoffragments.R;

public class FragmentX extends Fragment {

    private static final String TAG = FragmentX.class.getSimpleName();
    private Button btnSendData;
    private EditText etFirstNumber, etSecondNumber;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_x, container, false);
        etFirstNumber = view.findViewById(R.id.etFirstNumberX);
        etSecondNumber = view.findViewById(R.id.etSecondNumberX);
        btnSendData = view.findViewById(R.id.btnSendData);
        btnSendData.setOnClickListener(new View.OnClickListener() {
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
