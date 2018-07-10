package com.example.zvonimir.popquiz

import io.reactivex.Observable
import retrofit2.http.GET

interface GeographyInterface {

    @GET("/api/clues?category=1290") fun getQuestionList(): Observable<Array<Question>>
}