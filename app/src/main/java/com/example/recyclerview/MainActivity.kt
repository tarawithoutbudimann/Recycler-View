package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.databinding.ItemDisasterBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapterDisaster = DisasterAdapter(generateDummy()){disaster ->
            Toast.makeText(
                this@MainActivity,
                "You Clicked on ${disaster.nameDisaster}", Toast.LENGTH_SHORT
            ).show()
        }
        with(binding){
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }
    fun generateDummy():List<Disaster>{
        return listOf(
            Disaster(nameDisaster = "winwin", disasterType = "Natural" ),
            Disaster(nameDisaster = "Jaemin", disasterType = "Meledak" ),
            Disaster(nameDisaster = "Tsunami", disasterType = "Natural"),
            Disaster(nameDisaster = "Volcanic Eruption", disasterType = "Natural"),
            Disaster(nameDisaster = "Earthquake", disasterType = "Natural"),
            Disaster(nameDisaster = "Flood", disasterType = "Natural"),
            Disaster(nameDisaster = "Fire", disasterType = "Natural"),
            Disaster(nameDisaster = "Nuclear Accident", disasterType = "Man-made"),
            Disaster(nameDisaster = "Terrorist Attack", disasterType = "Man-made"),
            Disaster(nameDisaster = "War", disasterType = "Man-made"),
        )
    }
}