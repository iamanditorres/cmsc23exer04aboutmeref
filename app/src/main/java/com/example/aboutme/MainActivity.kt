package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener{addNickname(it)}
        findViewById<TextView>(R.id.nickname_text).setOnClickListener{updateNickname(it)}
    }

    private fun addNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        // set input text into TextView
        nicknameTextView.text = editText.text

        // hide PlainText
        editText.visibility = View.GONE

        // hide Button
        view.visibility = View.GONE

        // show TextView
        nicknameTextView.visibility = View.VISIBLE

        // hide Keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<Button>(R.id.done_button)

        // show PlainText
        editText.visibility = View.VISIBLE

        // show Button
        done_button.visibility = View.VISIBLE

        // hide TextView
        view.visibility = View.GONE

        // set focus to PlainText
        editText.requestFocus()

        // show the Keyboard
        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.showSoftInput(editText, 0)
    }
}
