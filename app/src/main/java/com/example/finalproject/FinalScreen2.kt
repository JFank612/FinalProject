package com.example.finalproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_final_screen2.*

public class FinalScreen2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_screen2)


        val artist = findViewById<EditText>(R.id.idArtistInput)
        val song = findViewById<EditText>(R.id.idSongInput)
        val genre = findViewById<Spinner>(R.id.idGenreSpn)
        val nextBtn = findViewById<Button>(R.id.idNextBtn)


        artist.requestFocus()

        nextBtn.setOnClickListener{
            if(checkData()) {
                var verify = ""
                verify = artist.text.toString() + "\n" + song.text.toString() + "\n" + genre.selectedItem.toString()

                val nextScreen = Intent(this@FinalScreen2, FinalScreen3::class.java)
                nextScreen.putExtra("Artist",artist.text.toString())
                nextScreen.putExtra("Song",song.text.toString())
                nextScreen.putExtra("Genre",genre.selectedItem.toString())
                nextScreen.putExtra("Accepted", verify)

                startActivity(nextScreen)
            }
        }


    }

    private fun checkData(): Boolean {
        val artist = findViewById<EditText>(R.id.idArtistInput)
        val song = findViewById<EditText>(R.id.idSongInput)

        if (artist.text.toString().isEmpty()) {
            artist.error = "Please Enter Artist/Band"
            artist.requestFocus()
            return false
        }

        if (song.text.toString().isEmpty()) {
            song.error = "Please Enter Song"
            song.requestFocus()
            return false
        }

        return true

    }
}
