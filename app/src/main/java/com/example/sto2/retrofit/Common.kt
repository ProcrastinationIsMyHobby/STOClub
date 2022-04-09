package com.example.sto2.retrofit


object Common {
    const val BASE_URL = "http://6bceadf3e257.ngrok.io/"
    val retrofitService: RetrofitServices
        get() = Client.getClient(BASE_URL).create(RetrofitServices::class.java)
}