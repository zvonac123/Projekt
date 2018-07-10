package com.example.zvonimir.popquiz

import retrofit2.http.GET

interface SportsInterface {
    @GET("/api/clues?category=42") fun getQuestionList(): io.reactivex.Observable<Array<Question>>
}