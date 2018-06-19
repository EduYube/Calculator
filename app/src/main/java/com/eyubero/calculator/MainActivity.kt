package com.eyubero.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var value: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberSelected(view: View) {

        val number = view as Button

        when (number.id) {
            one.id -> {
                value = "1"
            }
            two.id -> {
                value = "2"
            }
            three.id -> {
                value = "3"
            }
            four.id -> {
                value = "4"
            }
            five.id -> {
                value = "5"
            }
            six.id -> {
                value = "6"
            }
            seven.id -> {
                value = "7"
            }
            eight.id -> {
                value = "8"
            }
            nine.id -> {
                value = "9"
            }
            zero.id -> {
                value = "0"
            }
        }
        if (valueCell.text == "0")
            valueCell.text = value
        else
            valueCell.text = valueCell.text.toString() + value
    }

    fun clear(view: View) {
        val bt = view as Button

        if (bt.id == clear.id) {
            value = "0"
        }
        valueCell.text = value
    }
}
