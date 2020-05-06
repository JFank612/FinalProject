package com.example.finalproject

import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_display.*

class Display : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)


        val display = findViewById<Button>(R.id.displayBtn)


        display.setOnClickListener {
            retrieveData()
            val extras = intent.extras
            if(extras !=null) {
                var rock = extras.getString("rockGenre")
                var pop = extras.getString("popGenre")
                var rap = extras.getString("rapGenre")
                var classical = extras.getString("classicalGenre")
                var alt = extras.getString("altGenre")
                var classicRock = extras.getString("classicRockGenre")

                val checked = StringBuilder(100)
                if (rock != ""){
                    checked.append(rock)
                }
                if (pop != ""){
                    checked.append(pop)
                }
                if (rap != ""){
                    checked.append(rap)
                }
                if (classical != ""){
                    checked.append(classical)
                }
                if (alt != ""){
                    checked.append(alt)
                }
                if (classicRock != ""){
                    checked.append(classicRock)
                }
                genreDisplay.text = checked
                }

            }

        }
    private fun retrieveData() {

        val pref = getSharedPreferences("Music",Context.MODE_PRIVATE)
        val artist =  pref.getString("Artist", "")
        val song1 = pref.getString("Song1", "")
        val song2 = pref.getString("Song2", "")
        val song3 = pref.getString("Song3", "")

        artistDisplay.text = artist
        song1Display.text = song1
        song2Display.text = song2
        song3Display.text = song3
    }
}
