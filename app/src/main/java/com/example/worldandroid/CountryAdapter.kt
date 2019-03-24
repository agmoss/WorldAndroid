package com.example.worldandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.util.ArrayList


class CountryAdapter(

    var countries : ArrayList<Country>,
    var c:Context,
    val mInflater: LayoutInflater = c.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

) : BaseAdapter() {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {


        var v : View = mInflater.inflate(R.layout.lv_country,null)

        var tvCountryName = v.findViewById<TextView>(R.id.tvCountryName)
        var tvCountryCode = v.findViewById<TextView>(R.id.tvCountryCode)

        var countryName: String = countries[position].name
        var countryCode: String = countries[position]._id

        tvCountryName.text = countryName
        tvCountryCode.text = countryCode

        return v

    }

    override fun getItem(position: Int): Any {

        return countries[position]
    }

    override fun getItemId(position: Int): Long {

        return position.toLong()

    }

    override fun getCount(): Int {

        return countries.size
    }
}