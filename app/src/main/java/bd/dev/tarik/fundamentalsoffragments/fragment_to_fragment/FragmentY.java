package bd.dev.tarik.fundamentalsoffragments.fragment_to_fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bd.dev.tarik.fundamentalsoffragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentY extends Fragment {

    private static final String TAG = FragmentY.class.getSimpleName();
    private TextView txvXResult;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_y, container, false);
        txvXResult = view.findViewById(R.id.txvXResult);
        return view;
    }

    public void addTwoNumbersInFragmentX(int a, int b) {
        int result = a + b;
        txvXResult.setText("Result : " +result);
    }
}
