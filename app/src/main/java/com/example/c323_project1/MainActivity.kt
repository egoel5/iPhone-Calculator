package com.example.c323_project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.cos
import kotlin.math.ln
import kotlin.math.sin
import kotlin.math.tan
import android.util.Log

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
    var curNum = 0
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
                Log.v(String.toString(), "0 Button Clicked")
                buValue += "0"
            }

            but1.id -> {
                Log.v(String.toString(), "1 Button Clicked")
                buValue += "1"
            }

            but2.id -> {
                Log.v(String.toString(), "2 Button Clicked")
                buValue += "2"
            }

            but3.id -> {
                Log.v(String.toString(), "3 Button Clicked")
                buValue += "3"
            }

            but4.id -> {
                Log.v(String.toString(), "4 Button Clicked")
                buValue += "4"
            }

            but5.id -> {
                Log.v(String.toString(), "5 Button Clicked")
                buValue += "5"
            }

            but6.id -> {
                Log.v(String.toString(), "6 Button Clicked")
                buValue += "6"
            }

            but7.id -> {
                Log.v(String.toString(), "7 Button Clicked")
                buValue += "7"
            }

            but8.id -> {
                Log.v(String.toString(), "8 Button Clicked")
                buValue += "8"
            }

            but9.id -> {
                Log.v(String.toString(), "9 Button Clicked")
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
        Log.v(String.toString(), "Flip Sign Button Clicked")
        val numSign: Double = tvNumber.text.toString().toDouble() * -1
        finalNumber = numSign
        val df = DecimalFormat("#.#######")
        df.roundingMode = RoundingMode.DOWN
        val roundedFinalNumber = df.format(finalNumber)
        tvNumber.setText(roundedFinalNumber.toString())
    }

    fun OpEvent(view: View) {
        val butSelect = view as Button
        when (butSelect.id) {
            butMulti.id -> {
                Log.v(String.toString(), "Multiply Button Clicked")
                op = "*"
            }

            butDiv.id -> {
                Log.v(String.toString(), "Divide Button Clicked")
                op = "/"
            }

            butAdd.id -> {
                Log.v(String.toString(), "Add Button Clicked")
                op = "+"
            }

            butSub.id -> {
                Log.v(String.toString(), "Subtract Button Clicked")
                op = "-"
            }
        }
        oldNumber = tvNumber.text.toString()
        newOp = true
        dec = 1
    }

    fun butEquals(view: View) {
        Log.v(String.toString(), "Equals Button Clicked")
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

            "sin" -> {
                finalNumber = sin(oldNumber.toDouble())
            }

            "cos" -> {
                finalNumber = cos(oldNumber.toDouble())
            }

            "tan" -> {
                finalNumber = tan(oldNumber.toDouble())
            }

            "log10" -> {
                finalNumber = kotlin.math.log10(oldNumber.toDouble())
            }

            "natLog" -> {
                finalNumber = ln(oldNumber.toDouble())
            }

            else -> {
                finalNumber = finalNumber
            }
        }
        op = "none"
        val df = DecimalFormat("#.#####")
        df.roundingMode = RoundingMode.DOWN
        val roundedFinalNumber = df.format(finalNumber)
        tvNumber.setText(roundedFinalNumber.toString())
        dec = 1
        newOp = true
    }

    fun butPercent(view:View)
    {
        Log.v(String.toString(), "Percent Button Clicked")
        val number:Double = tvNumber.text.toString().toDouble() / 100
        finalNumber = number
        val df = DecimalFormat("#.#####")
        df.roundingMode = RoundingMode.DOWN
        val roundedFinalNumber = df.format(finalNumber)
        tvNumber.setText(roundedFinalNumber.toString())
        dec = 1
        newOp = true
    }

    fun clearText(view:View)
    {
        Log.v(String.toString(), "Clear Button Clicked")
        tvNumber.setText("0")
        dec = 1
        newOp = true
    }

    fun sine(view:View)
    {
        Log.v(String.toString(), "sin Button Clicked")
        val number:Double = tvNumber.text.toString().toDouble()
        println(number)
        finalNumber = sin(number)
        println(finalNumber)
        val df = DecimalFormat("#.#####")
        df.roundingMode = RoundingMode.DOWN
        val roundedFinalNumber = df.format(finalNumber)
        tvNumber.setText(roundedFinalNumber.toString())
        dec = 1
        newOp = true
    }

    fun cosine(view:View)
    {
        Log.v(String.toString(), "cos Button Clicked")
        val number:Double = tvNumber.text.toString().toDouble()
        println(number)
        finalNumber = cos(number)
        println(finalNumber)
        val df = DecimalFormat("#.#####")
        df.roundingMode = RoundingMode.DOWN
        val roundedFinalNumber = df.format(finalNumber)
        tvNumber.setText(roundedFinalNumber.toString())
        dec = 1
        newOp = true
    }

    fun tangent(view:View)
    {
        Log.v(String.toString(), "tan Button Clicked")
        val number:Double = tvNumber.text.toString().toDouble()
        println(number)
        finalNumber = tan(number)
        println(finalNumber)
        val df = DecimalFormat("#.#####")
        df.roundingMode = RoundingMode.DOWN
        val roundedFinalNumber = df.format(finalNumber)
        tvNumber.setText(roundedFinalNumber.toString())
        dec = 1
        newOp = true
    }

    fun log10(view:View)
    {
        Log.v(String.toString(), "log10 Button Clicked")
        val number:Double = tvNumber.text.toString().toDouble()
        println(number)
        finalNumber = kotlin.math.log10(number)
        println(finalNumber)
        val df = DecimalFormat("#.#####")
        df.roundingMode = RoundingMode.DOWN
        val roundedFinalNumber = df.format(finalNumber)
        tvNumber.setText(roundedFinalNumber.toString())
        dec = 1
        newOp = true
    }

    fun natLog(view:View) {
        Log.v(String.toString(), "ln Button Clicked")
        val number: Double = tvNumber.text.toString().toDouble()
        println(number)
        finalNumber = ln(number)
        println(finalNumber)
        val df = DecimalFormat("#.#####")
        df.roundingMode = RoundingMode.DOWN
        val roundedFinalNumber = df.format(finalNumber)
        tvNumber.setText(roundedFinalNumber.toString())
        dec = 1
        newOp = true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("curNum", tvNumber.text.toString().toInt())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        curNum = savedInstanceState!!.getInt("curNum")
        tvNumber.setText(curNum.toString())
    }
}