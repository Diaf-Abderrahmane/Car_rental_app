package com.example.rental

data class User(

    val username:String,
    val email:String,
    val password:String,
    val ifLogged:Boolean,
    val phonenumber:Int,
    val permis:Int,
    val credit_card:Int,
    val token:String


)
    : java.io.Serializable
