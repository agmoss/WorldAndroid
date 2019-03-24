package com.example.worldandroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import com.example.worldandroid.adapter.CountryAdapter
import com.example.worldandroid.database.CountryDBHelper
import com.example.worldandroid.models.Country

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var countryList = CountryDBHelper(this).readAllCountries()

        val lvCountries = findViewById<ListView>(R.id.lvCountries)

        val countryAdapter = CountryAdapter(countryList, this)

        lvCountries.adapter = countryAdapter

        //Pass clicked country to the detail view
        lvCountries.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->

            val selected : Country = parent.getItemAtPosition(position) as Country

            val displayCountryDetails = Intent(this,CountryDetailActivity::class.java)

            displayCountryDetails.putExtra("selectedCountry",selected)
            startActivity(displayCountryDetails)

        }
    }
}
