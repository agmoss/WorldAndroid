package com.example.worldandroid

import java.io.Serializable

class Country(val _id:String, val name:String,val continent:String,val region:String,
              val surfaceArea:String, val indepYear:String, val population:String,
              val liveExpectancy:String, val gnp:String, val gnpOld:String,
              val localName:String, val governmentForm:String,
              val headOfState: String, val capital:String, val code2:String) : Serializable{


    override fun toString(): String {
        return "Country(_id='$_id', name='$name', continent='$continent', region='$region', surfaceArea='$surfaceArea', indepYear='$indepYear', population='$population', liveExpectancy='$liveExpectancy', gnp='$gnp', gnpOld='$gnpOld', localName='$localName', governmentForm='$governmentForm', headOfState='$headOfState', capital='$capital', code2='$code2')"
    }
}