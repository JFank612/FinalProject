package com.example.finalproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

public class FinalScreen2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_screen2)


        val artist = findViewById<EditText>(R.id.artistInput)
        val song1 = findViewById<EditText>(R.id.songInput1)
        val song2 = findViewById<EditText>(R.id.songInput2)
        val song3 = findViewById<EditText>(R.id.songInput3)
        val nextBtn = findViewById<Button>(R.id.idNextBtn)


        song1.requestFocus()

        nextBtn.setOnClickListener{
            if(checkData()) {
                var verify = ""
                verify = artist.text.toString() + "\n" + song1.text.toString() + "\n" + song2.text.toString() + "\n" + song3.text.toString()

                val nextScreen = Intent(this@FinalScreen2, FinalScreen3::class.java)
                nextScreen.putExtra("Artist",artist.text.toString())
                nextScreen.putExtra("Song",song1.text.toString())
                nextScreen.putExtra("Song",song2.text.toString())
                nextScreen.putExtra("Song",song3.text.toString())
                nextScreen.putExtra("Accepted", verify)

                startActivity(nextScreen)
            }
        }


    }

    private fun checkData(): Boolean {
        val artist = findViewById<EditText>(R.id.songInput1)
        val song1 = findViewById<EditText>(R.id.artistInput)

        if (artist.text.toString().isEmpty()) {
            artist.error = "Please Enter Artist/Band"
            artist.requestFocus()
            return false
        }

        if (song1.text.toString().isEmpty()) {
            song1.error = "Please Enter a song title"
            song1.requestFocus()
            return false
        }

        return true

    }

    fun onSave(view: View) {

        val artist = findViewById<EditText>(R.id.artistInput)
        val song1 = findViewById<EditText>(R.id.songInput1)
        val song2 = findViewById<EditText>(R.id.songInput2)
        val song3 = findViewById<EditText>(R.id.songInput3)

        val pref = getSharedPreferences("Music",Context.MODE_PRIVATE)
        val editor = pref.edit()

        editor.putString("Song1", song1.text.toString())
        editor.putString("Song2", song2.text.toString())
        editor.putString("Song3", song3.text.toString())
        editor.putString("Artist", artist.text.toString())
        editor.apply()

        val toast = Toast.makeText(applicationContext,"Saved", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.BOTTOM, 0, 140)
        toast.show()
    }

}
