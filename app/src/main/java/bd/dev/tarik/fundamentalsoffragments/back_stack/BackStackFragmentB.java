package bd.dev.tarik.fundamentalsoffragments.back_stack;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bd.dev.tarik.fundamentalsoffragments.R;

import com.google.android.gms.plus.PlusOneButton;

public class BackStackFragmentB extends Fragment {

    private static final String TAG = BackStackFragmentB.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_back_stack_b, container, false);

        return view;
    }

}
