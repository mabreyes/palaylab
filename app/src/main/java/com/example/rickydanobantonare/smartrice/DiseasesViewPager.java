package com.example.rickydanobantonare.smartrice;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class DiseasesViewPager extends PagerAdapter {
    private Context mcontext;
    private int[] images=new int[] {R.drawable.bacterialblight, R.drawable.bacterialblight,R.drawable.bacterialblight,R.drawable.bacterialblight,R.drawable.bacterialblight};

    DiseasesViewPager(Context context){
        mcontext=context;
    }
    @Override
    public int getCount(){
        return images.length;
    }
    @Override
    public boolean isViewFromObject(View view, Object object){
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mcontext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(images[position]);
        container.addView(imageView,0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView)object);
    }
}
