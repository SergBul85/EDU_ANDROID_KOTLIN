package com.cocktails

import retrofit2.http.GET

interface ApiService {
    @GET("search.php?f=a")
    suspend fun getDrinks(): DrinksResponse

}