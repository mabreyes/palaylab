package io.github.projectbukirin.smartrice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.projectbukirin.smartrice.R;

public class PestsViewPager extends PagerAdapter {
    private Context mcontext;
    private int[] images=new int[] {R.drawable.armyworm, R.drawable.armyworm,R.drawable.armyworm,R.drawable.armyworm,R.drawable.armyworm};

    PestsViewPager(Context context){
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

    public static class PestViewPager2 extends PagerAdapter {
        private Context mcontext;
        private int[] images=new int[] {R.drawable.goldenapplesnail, R.drawable.goldenapplesnail,R.drawable.goldenapplesnail,R.drawable.goldenapplesnail,R.drawable.goldenapplesnail};

        PestViewPager2(Context context){
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


    public static class PestViewPager3 extends PagerAdapter {
        private Context mcontext;
        private int[] images=new int[] {R.drawable.greenleafhopper, R.drawable.greenleafhopper,R.drawable.greenleafhopper,R.drawable.greenleafhopper,R.drawable.greenleafhopper};

        PestViewPager3(Context context){
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


    public static class PestViewPager4 extends PagerAdapter {
        private Context mcontext;
        private int[] images=new int[] {R.drawable.riceblackbug, R.drawable.riceblackbug,R.drawable.riceblackbug,R.drawable.riceblackbug,R.drawable.riceblackbug};

        PestViewPager4(Context context){
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

    public static class PestViewPager5 extends PagerAdapter {
        private Context mcontext;
        private int[] images=new int[] {R.drawable.riceearbug, R.drawable.riceearbug,R.drawable.riceearbug,R.drawable.riceearbug,R.drawable.riceearbug};

        PestViewPager5(Context context){
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
}
