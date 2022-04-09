package com.example.tasbhi

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(context: Context) {

    val PREF_NAME:String="tasbhi_app"
    val COUNT:String="COUNT"
    val TOTAL:String="TOTAL"
    val sharedPreferences: SharedPreferences? =context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)

    fun saveCount(count:Int){
        val editor=sharedPreferences?.edit()
        editor?.putInt(COUNT,count)
        editor?.apply()
    }
    fun saveTotalCount(total:Int){
        val editor=sharedPreferences?.edit()
        editor?.putInt(TOTAL,total)
        editor?.apply()
    }


    fun getCount(): Int? = sharedPreferences?.getInt(COUNT,0)
    fun getTotalCount(): Int? = sharedPreferences?.getInt(TOTAL,0)


}
