package com.example.sto2.objects

data class STO(var name: String,
               var UID: String,
               var description: String,
               var about: String,
               var location: String,
               var reviews: List<Review>?,
               var rating:Float,
               var image: List<String>?)
