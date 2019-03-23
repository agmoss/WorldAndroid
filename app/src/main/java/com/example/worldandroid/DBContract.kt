package com.example.worldandroid

import android.provider.BaseColumns

object DBContract {

    /* Inner class that defines the table contents */
    class CountryEntry : BaseColumns {
        companion object {
            val TABLE_NAME = "country"
            val COLUMN_COUNTRY_CODE = "_id"
            val COLUMN_NAME = "Name"
            val COLUMN_CONTINENT = "Continent"
            val COLUMN_REGION = "Region"
            val COLUMN_SURFACEAREA = "SurfaceArea"
            val COLUMN_INDEPYEAR = "IndepYear"
            val COLUMN_POPULATION = "Population"
            val COLUMN_LIFEEXPECTANCY = "LifeExpectancy"
            val COLUMN_GNP = "GNP"
            val COLUMN_GNPOLD = "GNPOld"
            val COLUMN_LOCALNAME = "LocalName"
            val COLUMN_GOVERNMENTFORM = "GovernmentForm"
            val COLUMN_HEADOFSTATE = "HeadOfState"
            val COLUMN_CAPITAL = "Capital"
            val COLUMN_CODE2 = "Code2"
          }

    }

}
