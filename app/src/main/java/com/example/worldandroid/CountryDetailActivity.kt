package com.example.worldandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.worldandroid.models.Country
import java.text.NumberFormat
import java.util.*

/*

Display details of the selected country

 */


class CountryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)

        val country = intent.extras.getSerializable("selectedCountry") as Country

        val tvContinent = findViewById<TextView>(R.id.tvContinent)
        val tvSurfaceArea = findViewById<TextView>(R.id.tvSurfaceArea)
        val tvIndepYear = findViewById<TextView>(R.id.tvIndepYear)
        val tvPopulation = findViewById<TextView>(R.id.tvPopulation)
        val tvRegion = findViewById<TextView>(R.id.tvRegion)
        val tvGNP = findViewById<TextView>(R.id.tvGNP)
        val tvGovernmentForm = findViewById<TextView>(R.id.tvGovernmentForm)
        val tvHeadOfState = findViewById<TextView>(R.id.tvHeadOfState)
        val tvLifeExpectancy = findViewById<TextView>(R.id.tvLifeExpectancy)
        val tvLocalName = findViewById<TextView>(R.id.tvLocalName)

        val actionbar = supportActionBar
        actionbar!!.title = country.name

        tvContinent.text = country.continent
        tvSurfaceArea.text = NumberFormat.getNumberInstance(Locale.US).format(country.surfaceArea.toDouble()) + " km\u00B2"
        tvIndepYear.text = country.indepYear
        tvPopulation.text = NumberFormat.getNumberInstance(Locale.US).format(country.population.toDouble())
        tvRegion.text = country.region
        tvGNP.text = NumberFormat.getNumberInstance(Locale.US).format(country.gnp.toDouble()) + " M"
        tvGovernmentForm.text = country.governmentForm
        tvHeadOfState.text = country.headOfState
        tvLifeExpectancy.text = country.liveExpectancy + " years"
        tvLocalName.text = country.localName

    }
}
