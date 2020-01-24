package bd.dev.tarik.fundamentalsoffragments.screen_rotation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import bd.dev.tarik.fundamentalsoffragments.R;

public class ScreenRotationMainActivity extends AppCompatActivity {

    private static final String TAG = ScreenRotationMainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_rotation_main);
    }
}
