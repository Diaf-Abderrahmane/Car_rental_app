package com.example.rental

data class Car (val marque:String,
                val modele:String,
                var carImage:Int=0,
                var logo:Int=0,
                val tarif:String,
                val disponibilite:Boolean,)