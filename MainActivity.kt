package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView:TextView
    private var firstOper = 0.0
    private var operation = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       resultTextView = this.findViewById(R.id.result)


    }
    fun numClick(clickView: View){
        if(clickView is Button){
            var result = resultTextView.text.toString()
            var buttonNumber = clickView.text.toString()

            if(result == "0"){
                result = ""
            }

            var res = result + buttonNumber
            resultTextView.text = res

        }
    }

    fun operationClick(clickView: View){
        if(clickView is Button){
            var firstNum = resultTextView.text.toString()
            if (firstNum.isNotEmpty()){
                firstOper = firstNum.toDouble()
            }
            this.operation = clickView.text.toString()
            resultTextView.text = ""
        }
    }

    fun equalClick(clickView: View){
        if(clickView is Button){
            var secNumber =  resultTextView.text.toString()
            var sn = 0.0
            if(secNumber.isNotEmpty()){
                sn = secNumber.toDouble()
            }
            when(operation){
                "+" -> resultTextView.text = (firstOper + sn).toString()
                "-" -> resultTextView.text = (firstOper - sn).toString()
                "*" -> resultTextView.text = (firstOper * sn).toString()
                "/" -> resultTextView.text = (firstOper / sn).toString()
            }
        }
    }

}