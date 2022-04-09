package com.example.tasbhi

import android.content.Context
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import com.example.tasbhi.databinding.ActivityMainBinding
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {
    private var count=0
    private lateinit var binding:ActivityMainBinding
    private var totalMala=0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvCount.setOnClickListener {
            val vibe = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            val effect = VibrationEffect.createOneShot(150, VibrationEffect.DEFAULT_AMPLITUDE)
            vibe.vibrate(effect)

            clicked()
            setCount()
        }
        binding.tvClear.setOnClickListener {
        count=0
            setCount()
        }
    }
    override fun onResume(){
        super.onResume()
        count= SharedPreferences(this).getCount()!!
        totalMala= SharedPreferences(this).getTotalCount()!!
        setCount()
    }
    override fun onPause(){
            super.onPause()
           SharedPreferences(this).saveCount(binding.tvCount.text.toString().toInt())
           SharedPreferences(this).saveTotalCount(binding.tvTotalMala.text.toString().toInt())
    }
    private fun clicked(){
    if(count == 108){
        totalMala++
        count=0
        binding.tvTotalMala.text=totalMala.toString()
    }
        count++
}
    private fun setCount(){
        binding.tvCount.text= count.toString()
        binding.tvTotalMala.text=totalMala.toString()
    }
}