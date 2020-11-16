package xyz.marcreyes.palaylab.app

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomListView(private val context: Activity, private val name: Array<String?>, private val desc: Array<String?>, private val imgid: Array<Int?>) : ArrayAdapter<String?>(context, R.layout.customlayout, name) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var r = convertView
        var viewHolder: ViewHolder? = null
        if (r == null) {
            val layoutInflater = context.layoutInflater
            r = layoutInflater.inflate(R.layout.customlayout, null, true)
            viewHolder = ViewHolder(r)
            r.tag = viewHolder
        } else {
            viewHolder = r.tag as ViewHolder
        }
        imgid[position]?.let { viewHolder.ivw.setImageResource(it) }
        viewHolder.tvw1.text = name[position]
        viewHolder.tvw2.text = desc[position]
        return r!!
    }

    internal inner class ViewHolder(v: View?) {
        var tvw1: TextView
        var tvw2: TextView
        var ivw: ImageView

        init {
            tvw1 = v!!.findViewById<View>(R.id.tvname) as TextView
            tvw2 = v.findViewById<View>(R.id.tvdescription) as TextView
            ivw = v.findViewById<View>(R.id.imageView) as ImageView
        }
    }
}