package com.example.android.lab_3

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.android.lab_3.data.Item
import com.example.android.lab_3.model.Adapter
import kotlin.random.Random

class Lab1Activity : AppCompatActivity(), AdapterView.OnItemClickListener {

    lateinit var arrayList: ArrayList<Item>
    lateinit var gridView: GridView
    lateinit var adapter: Adapter
    lateinit var itemDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab1)



        gridView = findViewById(R.id.gvItems)
        arrayList = setDataList()
        adapter = Adapter(
            applicationContext,
            arrayList
        )
        gridView.adapter = adapter
        gridView.onItemClickListener = this


    }

    private fun setDataList(): ArrayList<Item> {
        var arrayList: ArrayList<Item> = ArrayList()

        for (i in 0..11) {
            arrayList.add(
                Item(
                    (Random.nextInt(0, 100)).toString(), Color.argb(
                        255,
                        Random.nextInt(256),
                        Random.nextInt(256),
                        Random.nextInt(256)
                    )
                )
            )
        }

        return arrayList
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var item: Item = arrayList.get(position)
        itemDialog = AlertDialog.Builder(this)
            .setTitle("Item")
            .setMessage("You picked ${item.number}")
            .setPositiveButton("Ok") { _, _ ->
            }.create()
        itemDialog.show()
    }
}