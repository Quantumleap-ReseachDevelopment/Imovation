package vn.quantumleap.imovation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import vn.quantumleap.imovation.Adapter.SliderAdapter;

public class SliderActivity extends AppCompatActivity {
    private Button btnSkip, btnNext;
    private ViewPager sViewPager;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);
        //find view id
        initView();
        //create adapter inViewpager
        sliderAdapter = new SliderAdapter(this);
        sViewPager.setAdapter(sliderAdapter);

        sViewPager.addOnPageChangeListener(viewListener);

        addDotsIndicator(0);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = sViewPager.getCurrentItem() + 1;
//        if (current < layouts.length) {
                if (current < sliderAdapter.slide_icon.length) {
                    // move to next screen
                    sViewPager.setCurrentItem(current);
                } else {
                    launchHomeScreen();
                }

            }
        });
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = sViewPager.getCurrentItem() - 1;
//        if (current < layouts.length) {
                if (current < sliderAdapter.slide_icon.length) {
                    // move to next screen
                    sViewPager.setCurrentItem(current);
                } else {
                    sViewPager.setCurrentItem(current + 1);
                }

            }
        });

    }

    private void launchHomeScreen() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int postition) {
            addDotsIndicator(postition);
            if (postition == sliderAdapter.slide_icon.length - 1) {
                // last page
                btnNext.setText(getString(R.string.skip));
                btnSkip.setVisibility(View.VISIBLE);
                btnNext.setEnabled(true);

            } else {
                //move to next screen
                btnNext.setText(getString(R.string.next));
                btnSkip.setVisibility(View.VISIBLE);
                btnSkip.setText(getString(R.string.slide_back));

            }
            if (postition == 0) {
                btnSkip.setEnabled(true);
                btnSkip.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private void initView() {
        sViewPager = findViewById(R.id.viewPager);
        dotsLayout = findViewById(R.id.dots_change_ani);
        btnNext = findViewById(R.id.slide_button_next);
        btnSkip = findViewById(R.id.slide_button_back);
    }


    public void addDotsIndicator(int postition) {
        dots = new TextView[3];
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark_5));
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[postition].setTextColor(getResources().getColor(R.color.colorPrimaryDark_2));
        }
    }
}
