package bd.dev.tarik.fundamentalsoffragments.screen_rotation;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import bd.dev.tarik.fundamentalsoffragments.R;

public class ScreenRotationFragmentA extends Fragment {

    private static final String TAG = ScreenRotationFragmentA.class.getSimpleName();

    private Button button;
    private TextView textView;
    int score;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");
        //score = 0;
        if (savedInstanceState != null) {
            score = savedInstanceState.getInt("score_key", 0);
        }
        Toast.makeText(getActivity(), "Score value : " + score, Toast.LENGTH_LONG).show();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen_rotation_a, container, false);
        Log.i(TAG, "onCreateView()");
        button = view.findViewById(R.id.button);
        textView = view.findViewById(R.id.textView);

        if (savedInstanceState != null) {
            button.setText(savedInstanceState.getString("btn_key", "LOGIN"));
            textView.setText(savedInstanceState.getString("txv_key"));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Dummy Text");
                button.setText("LOGOUT");
                score = 47;
                Toast.makeText(getActivity(), "Score value: " + score, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState()");
        outState.putInt("score_key", score);
        outState.putString("txv_key", textView.getText().toString());
        outState.putString("btn_key", button.getText().toString());
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach()");
    }
}
