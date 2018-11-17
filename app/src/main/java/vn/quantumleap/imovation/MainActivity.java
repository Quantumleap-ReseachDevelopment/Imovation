package vn.quantumleap.imovation;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import vn.quantumleap.imovation.Adapter.SliderAdapter;
import vn.quantumleap.imovation.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private SliderAdapter sliderAdapter;

    private Button mNextbtn;
    private Button mBackbtn;

    private int currentPage;

    private TextView[] dost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main_activity);

        // using Frame with activity
        if (savedInstanceState == null) {
            setContentView(R.layout.main_activity);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
    }



}


