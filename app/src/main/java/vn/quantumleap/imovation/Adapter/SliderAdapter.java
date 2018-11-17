package vn.quantumleap.imovation.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import vn.quantumleap.imovation.R;


public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }


    // Arrays
    public int[] slide_icon = {
            R.drawable.group10,
            R.drawable.group11,
            R.drawable.group12
    };

    public String[] slide_headings = {
            "EAT", "SLEEP", "CODE"
    };
    public String[] slide_titles = {
            "EAT for Good", "Sleep is Good", "Code is good"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.walkthrough_layout, container, false);
        ImageView slideImageView = view.findViewById(R.id.slide_image);
        TextView slideHeading = view.findViewById(R.id.slide_head);
        TextView slideContent = view.findViewById(R.id.slide_content);

        slideImageView.setImageResource(slide_icon[position]);
        slideHeading.setText(slide_headings[position]);
        slideContent.setText(slide_titles[position]);

        container.addView(view);

        //return super.instantiateItem(container, position);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((ConstraintLayout) object);
    }
}
