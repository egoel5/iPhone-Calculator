package com.example.c323_project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    lateinit var tvNumber:TextView
    lateinit var butC:Button
    lateinit var butSign:Button
    lateinit var butPerc:Button
    lateinit var butDiv:Button
    lateinit var butMulti:Button
    lateinit var butSub:Button
    lateinit var butAdd:Button
    lateinit var butEquals:Button
    lateinit var butPoint:Button
    lateinit var but0:Button
    lateinit var but7:Button
    lateinit var but8:Button
    lateinit var but9:Button
    lateinit var but4:Button
    lateinit var but5:Button
    lateinit var but6:Button
    lateinit var but1:Button
    lateinit var but2:Button
    lateinit var but3:Button
    var finalNumber = 0.0
    var op = "none"
    var oldNumber = "0"
    var newOp = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvNumber = findViewById(R.id.tvNumber)
        butC = findViewById(R.id.buttonC)
        butSign = findViewById(R.id.buttonFlipSign)
        butPerc = findViewById(R.id.buttonPercent)
        butDiv = findViewById(R.id.buttonSlash)
        butMulti = findViewById(R.id.buttonMultiply)
        butSub = findViewById(R.id.buttonSubtract)
        butAdd = findViewById(R.id.buttonAdd)
        butEquals = findViewById(R.id.buttonEquals)
        butPoint = findViewById(R.id.buttonPoint)
        but0 = findViewById(R.id.button0)
        but7 = findViewById(R.id.button7)
        but8 = findViewById(R.id.button8)
        but9 = findViewById(R.id.button9)
        but4 = findViewById(R.id.button4)
        but5 = findViewById(R.id.button5)
        but6 = findViewById(R.id.button6)
        but1 = findViewById(R.id.button1)
        but2 = findViewById(R.id.button2)
        but3 = findViewById(R.id.button3)
    }

    var dec = 1
    fun NumberEvent(view: View) {
        if (newOp) {
            tvNumber.setText("")
            dec = 1
        }
        newOp = false
        val buSelect = view as Button
        var buValue: String = tvNumber.text.toString()


        when (buSelect.id) {
            but0.id -> {
                buValue += "0"
            }

            but1.id -> {
                buValue += "1"
            }

            but2.id -> {
                buValue += "2"
            }

            but3.id -> {
                buValue += "3"
            }

            but4.id -> {
                buValue += "4"
            }

            but5.id -> {
                buValue += "5"
            }

            but6.id -> {
                buValue += "6"
            }

            but7.id -> {
                buValue += "7"
            }

            but8.id -> {
                buValue += "8"
            }

            but9.id -> {
                buValue += "9"
            }

            butPoint.id -> {
                if (dec == 1) {
                    if (buValue == "") {
                        buValue = "0."
                    } else {
                        buValue += "."
                    }
                    dec = 0
                }
            }
        }
        tvNumber.setText(buValue)
        finalNumber = buValue.toDouble()
    }

    fun flipSign(view: View) {
        val numSign: Double = tvNumber.text.toString().toDouble() * -1
        tvNumber.setText(numSign.toString())
        finalNumber = numSign
    }

    fun OpEvent(view: View) {
        val butSelect = view as Button
        when (butSelect.id) {
            butMulti.id -> {
                op = "*"
            }

            butDiv.id -> {
                op = "/"
            }

            butAdd.id -> {
                op = "+"
            }

            butSub.id -> {
                op = "-"
            }
        }
        oldNumber = tvNumber.text.toString()
        newOp = true
        dec = 1
    }

    fun butEquals(view: View) {
        if (tvNumber.text.toString() == ".") {
            tvNumber.setText("0")
        }
        val newNumber = tvNumber.text.toString()
        when (op) {
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }

            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }

            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }

            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }

            else -> {
                finalNumber = finalNumber
            }
        }
        op = "none"
        val df = DecimalFormat("#.#######")
        df.roundingMode = RoundingMode.DOWN
        val roundedFinalNumber = df.format(finalNumber)
        tvNumber.setText(roundedFinalNumber.toString())
        dec = 1
        newOp = true
    }

    fun butPercent(view:View)
    {
        val number:Double = tvNumber.text.toString().toDouble() / 100
        finalNumber = number
        tvNumber.setText(number.toString())
        dec = 1
        newOp = true
    }

    fun clearText(view:View)
    {
        tvNumber.setText("0")
        dec = 1
        newOp = true
    }
}