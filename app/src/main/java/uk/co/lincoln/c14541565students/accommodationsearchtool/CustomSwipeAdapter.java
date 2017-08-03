package uk.co.lincoln.c14541565students.accommodationsearchtool;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Chelsey on 09/03/2016.
 */
public class CustomSwipeAdapter extends PagerAdapter{

    private int[] image_resources = {R.drawable.accommodationoncampus, R.drawable.bathroom, R.drawable.diningroom,
                                     R.drawable.kitchen, R.drawable.lounge, R.drawable.studentroom, R.drawable.studentvillage, R.drawable.waterfront};

    private Context ctx;

    private LayoutInflater layoutInflater;

    public CustomSwipeAdapter (Context ctx){
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view ==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem (ViewGroup container, int position){
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView slideshow_imageView = (ImageView) item_view.findViewById(R.id.slideshow_imageView);
        slideshow_imageView.setImageResource(image_resources[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem (ViewGroup container, int position, Object object){
        container.removeView((LinearLayout)object);
    }
}

