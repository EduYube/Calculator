package com.eyubero.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var value: String = ""
    var result = false
    var op = -1


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
            firstCell.text = ""
            result = false
        }
        valueCell.text = value
    }

    fun plusMinus(view: View) {

        val bt = view as Button

        if (bt.id == plusMinus.id) {
            value = (valueCell.text.toString().toInt() * -1).toString()
        }
        valueCell.text = value
    }

    fun mathFunctions(view: View) {
        val math = view as Button

        var num = valueCell.text.toString()

        if(!result) {
            when (math.id){
                percent.id -> {
                    firstCell.text = num + " %"
                    valueCell.text = "0"
                    result = true
                    op = 0
                }
                divider.id -> {
                    firstCell.text = num + " /"
                    valueCell.text = "0"
                    result = true
                    op = 1
                }
                multiplicate.id -> {
                    firstCell.text = num + " *"
                    valueCell.text = "0"
                    result = true
                    op = 2
                }
                resta.id -> {
                    firstCell.text = num + " -"
                    valueCell.text = "0"
                    result = true
                    op = 3
                }
                sume.id -> {
                    firstCell.text = num + " +"
                    valueCell.text = "0"
                    result = true
                    op = 4
                }
            }
        } else {
            var x:String = firstCell.text.toString().substringBefore(" ")
            when (math.id){
                percent.id -> {
                    per(x.toInt(),valueCell.text.toString().toInt())
                    result = false
                }
                divider.id -> {
                    div(x.toInt(),valueCell.text.toString().toInt())
                    result = false
                }
                multiplicate.id -> {
                    mult(x.toInt(),valueCell.text.toString().toInt())
                    result = false
                }
                resta.id -> {
                    rest(x.toInt(),valueCell.text.toString().toInt())
                    result = false
                }
                sume.id -> {
                    sum(x.toInt(),valueCell.text.toString().toInt())
                    result = false
                }
                equal.id -> {
                    result = false
                    when (op){
                        0 -> {
                            per(x.toInt(),valueCell.text.toString().toInt())
                        }
                        1 -> {
                            div(x.toInt(),valueCell.text.toString().toInt())
                        }
                        2 -> {
                            mult(x.toInt(),valueCell.text.toString().toInt())
                        }
                        3 -> {
                            rest(x.toInt(),valueCell.text.toString().toInt())
                        }
                        4 -> {
                            sum(x.toInt(),valueCell.text.toString().toInt())
                        }
                    }
                }
            }
        }
    }

    private fun per(x: Int, y: Int) {
        firstCell.text = ""
        valueCell.text = (x*(y/100)).toString()
    }

    private fun div(x: Int, y: Int) {
        firstCell.text = ""
        if(y != 0){
            valueCell.text = (x/y).toString()
        } else {
            valueCell.text = "Math error"
        }
    }

    private fun mult(x: Int, y: Int) {
        firstCell.text = ""
        valueCell.text = (x*y).toString()
    }

    private fun rest(x: Int, y: Int) {
        firstCell.text = ""
        valueCell.text = (x-y).toString()
    }

    private fun sum(x: Int, y: Int) {
        firstCell.text = ""
        valueCell.text = (x+y).toString()
    }
}
