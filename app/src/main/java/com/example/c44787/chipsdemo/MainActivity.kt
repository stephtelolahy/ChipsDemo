package com.example.c44787.chipsdemo

import android.content.Context
import android.os.Bundle
import android.support.design.chip.Chip
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textArray = arrayOf("Lorem Ipsum", "Reader", "here", "are", "many", "variations of passages of Lorem Ipsum available")
        textArray.forEach { addChipText(it) }

        add_button.setOnClickListener {
            addChipText(edit_text.text.toString())
            edit_text.text.clear()
            hideKeyboard()
        }
    }

    private fun addChipText(text: String) {
        val chip = layoutInflater.inflate(R.layout.chip_group_item, chip_group, false) as Chip
        chip.chipText = text
        chip_group.addView(chip)

        chip.setOnCloseIconClickListener {
            // TODO: handle index
            chip_group.removeView(chip)
        }
    }

    private fun hideKeyboard() {
        currentFocus?.let {
            val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(it.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }
}
