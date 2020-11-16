package xyz.marcreyes.palaylab.app

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

class PestsViewPager internal constructor(private val mcontext: Context) : PagerAdapter() {
    private val images = intArrayOf(R.drawable.armyworm, R.drawable.armyworm, R.drawable.armyworm, R.drawable.armyworm, R.drawable.armyworm)
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

    class PestViewPager2 internal constructor(private val mcontext: Context) : PagerAdapter() {
        private val images = intArrayOf(R.drawable.goldenapplesnail, R.drawable.goldenapplesnail, R.drawable.goldenapplesnail, R.drawable.goldenapplesnail, R.drawable.goldenapplesnail)
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

    class PestViewPager3 internal constructor(private val mcontext: Context) : PagerAdapter() {
        private val images = intArrayOf(R.drawable.greenleafhopper, R.drawable.greenleafhopper, R.drawable.greenleafhopper, R.drawable.greenleafhopper, R.drawable.greenleafhopper)
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

    class PestViewPager4 internal constructor(private val mcontext: Context) : PagerAdapter() {
        private val images = intArrayOf(R.drawable.riceblackbug, R.drawable.riceblackbug, R.drawable.riceblackbug, R.drawable.riceblackbug, R.drawable.riceblackbug)
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

    class PestViewPager5 internal constructor(private val mcontext: Context) : PagerAdapter() {
        private val images = intArrayOf(R.drawable.riceearbug, R.drawable.riceearbug, R.drawable.riceearbug, R.drawable.riceearbug, R.drawable.riceearbug)
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