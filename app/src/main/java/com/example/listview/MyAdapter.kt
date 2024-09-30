package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.listview.databinding.ItemComidaBinding
import com.squareup.picasso.Picasso

class MyAdapter(private val context: Context, private val arrayList: java.util.ArrayList<Comidas>): BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var binding = ItemComidaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        var convertView = convertView
        convertView = binding.root

        binding.txtTitle.text = arrayList[position].title
        binding.txtPais.text = "${arrayList[position].pais}"
        if (arrayList[position].image != null){ Picasso.get().load(arrayList[position].image).into(binding.imageView);}



        return convertView


    }
}