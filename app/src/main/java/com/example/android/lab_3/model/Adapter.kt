package com.example.android.lab_3.model

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.android.lab_3.R
import com.example.android.lab_3.data.Item

class Adapter(var context: Context, var arrayList: ArrayList<Item>) :
    BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View = View.inflate(
            context,
            R.layout.item, null
        )
        var listItem: Item = arrayList.get(position)
        var tvNumber: TextView = view.findViewById(R.id.tvNumber)

        tvNumber.text = listItem.number
        val backgroundDrawable = tvNumber.background as Drawable
        backgroundDrawable.run {
            mutate()
            setTint(listItem.color)
        }

        return view
    }

    override fun getItem(position: Int): Any {
        return arrayList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }
}