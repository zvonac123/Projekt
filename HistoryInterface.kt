package com.example.zvonimir.popquiz

import io.reactivex.Observable
import retrofit2.http.GET

interface HistoryInterface {

    @GET("/api/clues?category=530") fun getQuestionList(): Observable<Array<Question>>
}