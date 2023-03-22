package com.example.rental

import androidx.lifecycle.ViewModel

class CarModel: ViewModel() {
    val data = loadData()
    fun loadData():List<Car> {
        val data = mutableListOf<Car>()
        data.add(Car("Tesla","Model S", R.drawable.tesla, R.drawable.merc, "100$", true))
        data.add(Car("Tesla","Model S", R.drawable.tesla, R.drawable.merc, "100$", true))
        data.add(Car("Tesla","Model S", R.drawable.tesla, R.drawable.merc, "100$", true))
        data.add(Car("Tesla","Model S", R.drawable.tesla, R.drawable.merc, "100$", true))
        data.add(Car("Tesla","Model S", R.drawable.tesla, R.drawable.merc, "100$", true))
        return data
    }
}