package com.example.worldandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var countryList = CountryDBHelper(this).readAllCountries()

        val lvCountries = findViewById<ListView>(R.id.lvCountries)

        val itemsAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countryList)

        lvCountries.adapter = itemsAdapter

    }
}
