package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class FinalScreen3 : AppCompatActivity() {

    private var artist:String? = ""
    private var song1:String? = ""
    private var song2:String? = ""
    private var song3:String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_screen3)

        val rock = findViewById<RadioButton>(R.id.rockBtn)
        val pop = findViewById<RadioButton>(R.id.popBtn)
        val rap = findViewById<RadioButton>(R.id.rapBtn)
        val classical = findViewById<RadioButton>(R.id.classicalBtn)
        val alt = findViewById<RadioButton>(R.id.altBtn)
        val classicRock = findViewById<RadioButton>(R.id.classicRockBtn)
        val next = findViewById<Button>(R.id.nextBtn2)


        val extras = intent.extras
        if (extras != null) {
            artist = extras.getString("artist")
            song1 = extras.getString("song1")
            song2 = extras.getString("song2")
            song3 = extras.getString("song3")
        }

        next.setOnClickListener {
            var rockChecked = ""
            var popChecked = ""
            var rapChecked = ""
            var classicalChecked = ""
            var altChecked = ""
            var classicRockChecked = ""
            
            if(rock.isChecked){
                rockChecked = rock.text.toString()
            }
            
            if(pop.isChecked){
                popChecked = pop.text.toString()
            }
            if(rap.isChecked){
                rapChecked = rap.text.toString()
            }
            if(classical.isChecked) {
                classicalChecked = classical.text.toString()
            }
            if (alt.isChecked){
                altChecked = alt.text.toString()
            }
            if (classicRock.isChecked){
                classicRockChecked = classicRock.text.toString()
            }
            val displayScreen = Intent(this@FinalScreen3, Display::class.java).apply{
                putExtra("Artist",artist)
                putExtra("song1", song1)
                putExtra("song2", song2)
                putExtra("song3", song3)
                putExtra("rockGenre", rockChecked)
                putExtra("popGenre", popChecked)
                putExtra("rapGenre", rapChecked)
                putExtra("classicalGenre", classicalChecked)
                putExtra("altGenre", altChecked)
                putExtra("classicRockGenre", classicRockChecked)
            }
            startActivity(displayScreen)
        }

    }
}
