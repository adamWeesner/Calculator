package com.weesnerdevelopment.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonBack.setOnClickListener {
            textViewFormula.text = textViewFormula.text.substring(0, textViewFormula.text.lastIndex)
            showAnswer()
        }
    }

    fun numberClicked(view: View) {
        textViewFormula.text = textViewFormula.text.toString() + (view as Button).text.toString()
        showAnswer()

    }

    fun operatorClicked(view: View) {
        textViewFormula.text = textViewFormula.text.toString() + (view as Button).text.toString()
    }

    fun showAnswer() {
        if (textViewFormula.text.toString().contains(Regex("(?=[/*+-])|(?<=[/*+-])")) &&
            !textViewFormula.text[textViewFormula.text.lastIndex].toString().contains(Regex("(?=[/*+-])|(?<=[/*+-])"))
        ) {
            val op = Operation(textViewFormula.text.toString())
            textViewAnswer.text = op.answer.toString()
        } else {
            textViewAnswer.text = ""

        }
    }
}
