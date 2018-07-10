package com.example.zvonimir.popquiz

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import java.util.*

class QuestionActivity: AppCompatActivity(){
    var questionText: TextView?=null
    var btnA: Button?=null
    var btnB: Button?=null
    var btnC: Button?=null
    var btnD: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        questionText=findViewById(R.id.questionView)
        btnA=findViewById(R.id.A)
        btnB=findViewById(R.id.B)
        btnC=findViewById(R.id.C)
        btnD=findViewById(R.id.D)
        DisplayInit()
        btnA?.setOnClickListener{click->
            DisplayInit()
        }
        btnB?.setOnClickListener{click->
            DisplayInit()
        }
        btnC?.setOnClickListener{click->
            DisplayInit()
        }
        btnD?.setOnClickListener{click->
            DisplayInit()
        }
    }

    fun ClosedRange<Int>.random()= Random().nextInt((endInclusive-1)-start)+start

    fun DisplayInit(){
        val i=(0 until QuestionArray.questions!!.size).random()
        questionText?.text=QuestionArray.questions?.get(i)?.question
        btnA?.text=QuestionArray.questions?.get(i)?.answer
        btnB?.text=QuestionArray.questions?.get(i+1)?.answer
        btnC?.text=QuestionArray.questions?.get(i+2)?.answer
        btnD?.text=QuestionArray.questions?.get(i+3)?.answer
    }
}