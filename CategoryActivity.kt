package com.example.zvonimir.popquiz

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CategoryActivity: AppCompatActivity() {
    var history: Button?=null
    var geography: Button?=null
    var sports: Button?=null
    val gson= GsonBuilder().setLenient().create()
    val retrofit: Retrofit = Retrofit.Builder().baseUrl("http://jservice.io").addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()

    override fun onCreate(savedInstanceState: Bundle?) { //izbor kategorije za igru
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        history=findViewById(R.id.History)
        geography=findViewById(R.id.Geography)
        sports=findViewById(R.id.Sports)
        history?.setOnClickListener{click ->
            val rest=retrofit.create(HistoryInterface::class.java)
            rest.getQuestionList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({
                QuestionArray.questions=it
                startQuestionActivity()
            },{
                throw it
            })
        }
        geography?.setOnClickListener{ click ->
            val rest=retrofit.create(GeographyInterface::class.java)
            rest.getQuestionList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({
                QuestionArray.questions=it
                startQuestionActivity()
            },{
                throw it
            })
        }
        sports?.setOnClickListener{click ->
            val rest=retrofit.create(SportsInterface::class.java)
            rest.getQuestionList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({
                QuestionArray.questions=it
                startQuestionActivity()
            },{
                throw it
            })
        }
    }

    fun startQuestionActivity(){
        val qActivity=Intent(this,QuestionActivity::class.java)
        startActivity(qActivity)
    }
}