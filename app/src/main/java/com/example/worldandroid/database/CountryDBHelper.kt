package com.example.worldandroid.database

import android.content.Context
import android.content.SharedPreferences
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import com.example.worldandroid.models.Country
import java.io.File
import java.io.FileOutputStream
import java.util.ArrayList


/*

Reads in the existing world database and install it in the application.

Provides functionality to query this database.

 */


class CountryDBHelper(val context: Context) : SQLiteOpenHelper(context,
    DATABASE_NAME, null,
    DATABASE_VERSION
) {

    private val preferences: SharedPreferences = context.getSharedPreferences(
        "${context.packageName}.database_versions",
        Context.MODE_PRIVATE
    )

    private fun installedDatabaseIsOutdated(): Boolean {
        return preferences.getInt(DATABASE_NAME, 0) < DATABASE_VERSION
    }

    private fun writeDatabaseVersionInPreferences() {
        preferences.edit().apply {
            putInt(
                DATABASE_NAME,
                DATABASE_VERSION
            )
            apply()
        }
    }

    private fun installDatabaseFromAssets() {
        val inputStream = context.assets.open("$ASSETS_PATH/$DATABASE_NAME.sqlite")

        try {
            val outputFile = File(context.getDatabasePath(DATABASE_NAME).path)
            val outputStream = FileOutputStream(outputFile)

            inputStream.copyTo(outputStream)
            inputStream.close()

            outputStream.flush()
            outputStream.close()
        } catch (exception: Throwable) {
            throw RuntimeException("The $DATABASE_NAME database couldn't be installed.", exception)
        }
    }

    @Synchronized
    private fun installOrUpdateIfNecessary() {
        if (installedDatabaseIsOutdated()) {
            context.deleteDatabase(DATABASE_NAME)
            installDatabaseFromAssets()
            writeDatabaseVersionInPreferences()
        }
    }

    override fun getWritableDatabase(): SQLiteDatabase {
        throw RuntimeException("The $DATABASE_NAME database is not writable.")
    }

    override fun getReadableDatabase(): SQLiteDatabase {
        installOrUpdateIfNecessary()
        return super.getReadableDatabase()
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // Nothing to do
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Nothing to do
    }

    companion object {
        const val ASSETS_PATH = "databases"
        const val DATABASE_NAME = "world"
        const val DATABASE_VERSION = 1
    }


    fun readAllCountries(): ArrayList<Country> {
        val countries = ArrayList<Country>()
        val db = readableDatabase  // This should probably be writable...
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from " + DBContract.CountryEntry.TABLE_NAME, null)
        } catch (e: SQLiteException) {

            return ArrayList()
        }

        var countryCode : String
        var name: String
        var continent: String
        var region: String
        var surfaceArea : String
        var indepYear : String
        var population: String
        var lifeExpectancy: String
        var gnp : String
        var gnpOld : String
        var localName: String
        var governmentForm : String
        var headOfState : String
        var capital : String
        var code2 : String

        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {

                countryCode = cursor.getString(cursor.getColumnIndex(DBContract.CountryEntry.COLUMN_COUNTRY_CODE))
                name = cursor.getString(cursor.getColumnIndex(DBContract.CountryEntry.COLUMN_NAME))
                continent = cursor.getString(cursor.getColumnIndex(DBContract.CountryEntry.COLUMN_CONTINENT))
                region = cursor.getString(cursor.getColumnIndex(DBContract.CountryEntry.COLUMN_REGION))
                surfaceArea  = cursor.getString(cursor.getColumnIndex(DBContract.CountryEntry.COLUMN_SURFACEAREA))
                indepYear = cursor.getString(cursor.getColumnIndex(DBContract.CountryEntry.COLUMN_INDEPYEAR))
                population  = cursor.getString(cursor.getColumnIndex(DBContract.CountryEntry.COLUMN_POPULATION))
                lifeExpectancy  = cursor.getString(cursor.getColumnIndex(DBContract.CountryEntry.COLUMN_LIFEEXPECTANCY))
                gnp  = cursor.getString(cursor.getColumnIndex(DBContract.CountryEntry.COLUMN_GNP))
                gnpOld  = cursor.getString(cursor.getColumnIndex(DBContract.CountryEntry.COLUMN_GNPOLD))
                localName  = cursor.getString(cursor.getColumnIndex(DBContract.CountryEntry.COLUMN_LOCALNAME))
                governmentForm  = cursor.getString(cursor.getColumnIndex(DBContract.CountryEntry.COLUMN_GOVERNMENTFORM))
                headOfState  = cursor.getString(cursor.getColumnIndex(DBContract.CountryEntry.COLUMN_HEADOFSTATE))
                capital  = cursor.getString(cursor.getColumnIndex(DBContract.CountryEntry.COLUMN_CAPITAL))
                code2  = cursor.getString(cursor.getColumnIndex(DBContract.CountryEntry.COLUMN_CODE2))

                countries.add(
                    Country(
                        countryCode, name, continent, region, surfaceArea, indepYear, population, lifeExpectancy,
                        gnp, gnpOld, localName, governmentForm, headOfState, capital, code2
                    )
                )
                cursor.moveToNext()
            }
        }

        return countries
    }
}