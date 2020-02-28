package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Andi Torres")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener{addNickname()}
        findViewById<TextView>(R.id.nickname_text).setOnClickListener{updateNickname()}
    }

    private fun addNickname(){
        binding.apply {
            // set input text into TextView
            myName?.nickname= nicknameEdit.text.toString()
            invalidateAll()

            // hide PlainText
            binding.nicknameEdit.visibility = View.GONE

            // hide Button
            binding.doneButton.visibility = View.GONE

            // show TextView
            binding.nicknameText.visibility = View.VISIBLE

        }

        // hide Keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.doneButton.windowToken, 0)
    }

    private fun updateNickname(){
        // show PlainText
        binding.nicknameEdit.visibility = View.VISIBLE

        // show Button
        binding.doneButton.visibility = View.VISIBLE

        // hide TextView
        binding.nicknameText.visibility = View.GONE

        // set focus to PlainText
        binding.nicknameEdit.requestFocus()

        // show the Keyboard
        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.showSoftInput(binding.nicknameEdit, 0)
    }
}
