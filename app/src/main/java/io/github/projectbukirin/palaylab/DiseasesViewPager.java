package io.github.projectbukirin.palaylab;


import android.content.Context;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
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

    public static class DiseasesViewPager2 extends PagerAdapter {
        private Context mcontext;
        private int[] images=new int[] {R.drawable.riceblast, R.drawable.riceblast,R.drawable.riceblast,R.drawable.riceblast,R.drawable.riceblast};

        DiseasesViewPager2(Context context){
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


    public static class DiseasesViewPager3 extends PagerAdapter {
        private Context mcontext;
        private int[] images=new int[] {R.drawable.sheathblight, R.drawable.sheathblight,R.drawable.sheathblight,R.drawable.sheathblight,R.drawable.sheathblight};

        DiseasesViewPager3(Context context){
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


    public static class DiseasesViewPager4 extends PagerAdapter {
        private Context mcontext;
        private int[] images=new int[] {R.drawable.tungro, R.drawable.tungro,R.drawable.tungro,R.drawable.tungro,R.drawable.tungro};

        DiseasesViewPager4(Context context){
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
