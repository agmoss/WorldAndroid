package com.example.worldandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CountryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)

        val country = intent.extras.getSerializable("selectedCountry") as Country

        val tvContinent = findViewById<TextView>(R.id.tvContinent)
        val tvSurfaceArea = findViewById<TextView>(R.id.tvSurfaceArea)

        tvContinent.text = country.continent
        tvSurfaceArea.text = country.surfaceArea

    }
}
