package com.cocktails

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder().baseUrl("www.thecocktaildb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create()).build()

val cocktailService = retrofit.create(ApiService::class.java)

interface ApiService {
    @GET("search.php?f=a")
    suspend fun getDrinks(): DrinksResponse
}