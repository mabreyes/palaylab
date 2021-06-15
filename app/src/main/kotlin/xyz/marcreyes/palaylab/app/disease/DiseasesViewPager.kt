package xyz.marcreyes.palaylab.app.disease

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import xyz.marcreyes.palaylab.app.R

class DiseasesViewPager internal constructor(private val mcontext: Context) : PagerAdapter() {
    private val images = intArrayOf(R.drawable.bacterialblight, R.drawable.bacterialblight, R.drawable.bacterialblight, R.drawable.bacterialblight, R.drawable.bacterialblight)
    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(mcontext)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        imageView.setImageResource(images[position])
        container.addView(imageView, 0)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ImageView)
    }

    class DiseasesViewPager2 internal constructor(private val mcontext: Context) : PagerAdapter() {
        private val images = intArrayOf(R.drawable.riceblast, R.drawable.riceblast, R.drawable.riceblast, R.drawable.riceblast, R.drawable.riceblast)
        override fun getCount(): Int {
            return images.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val imageView = ImageView(mcontext)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setImageResource(images[position])
            container.addView(imageView, 0)
            return imageView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as ImageView)
        }
    }

    class DiseasesViewPager3 internal constructor(private val mcontext: Context) : PagerAdapter() {
        private val images = intArrayOf(R.drawable.sheathblight, R.drawable.sheathblight, R.drawable.sheathblight, R.drawable.sheathblight, R.drawable.sheathblight)
        override fun getCount(): Int {
            return images.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val imageView = ImageView(mcontext)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setImageResource(images[position])
            container.addView(imageView, 0)
            return imageView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as ImageView)
        }
    }

    class DiseasesViewPager4 internal constructor(private val mcontext: Context) : PagerAdapter() {
        private val images = intArrayOf(R.drawable.tungro, R.drawable.tungro, R.drawable.tungro, R.drawable.tungro, R.drawable.tungro)
        override fun getCount(): Int {
            return images.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val imageView = ImageView(mcontext)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setImageResource(images[position])
            container.addView(imageView, 0)
            return imageView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as ImageView)
        }
    }
}