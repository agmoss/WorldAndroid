package com.example.worldandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.worldandroid.models.Country

/*

Display details of the selected country

 */


class CountryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)

        val actionbar = supportActionBar

        val country = intent.extras.getSerializable("selectedCountry") as Country

        val tvContinent = findViewById<TextView>(R.id.tvContinent)
        val tvSurfaceArea = findViewById<TextView>(R.id.tvSurfaceArea)
        val tvIndepYear = findViewById<TextView>(R.id.tvIndepYear)
        val tvPopulation = findViewById<TextView>(R.id.tvPopulation)
        val tvRegion = findViewById<TextView>(R.id.tvRegion)
        val tvGNP = findViewById<TextView>(R.id.tvGNP)
        val tvGovernmentForm = findViewById<TextView>(R.id.tvGovernmentForm)
        val tvHeadOfState = findViewById<TextView>(R.id.tvHeadOfState)
        val tvCapital = findViewById<TextView>(R.id.tvCapital)
        val tvLifeExpectancy = findViewById<TextView>(R.id.tvLifeExpectancy)
        val tvLocalName = findViewById<TextView>(R.id.tvLocalName)

        actionbar!!.title = country.name

        tvContinent.text = country.continent
        tvSurfaceArea.text = country.surfaceArea
        tvIndepYear.text = country.indepYear
        tvPopulation.text = country.population
        tvRegion.text = country.region
        tvGNP.text = country.gnp
        tvGovernmentForm.text = country.governmentForm
        tvHeadOfState.text = country.headOfState
        tvCapital.text = country.capital
        tvLifeExpectancy.text = country.liveExpectancy
        tvLocalName.text = country.localName

    }
}
