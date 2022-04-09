package com.example.sto2.retrofit

import com.example.sto2.objects.STO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {

    @GET("main_map_restaurants_api")
    fun getStartSTOList(): Call<List<STO>>

    @GET("search_results_view_api")
    fun search(@Query("search") search : String): Call<List<STO>>

    @GET("restaurants_card_api")
    fun getInfoAboutSTO(@Query ("rest_id")id:Int):Call<STO>
}