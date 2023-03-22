package com.example.rental

import androidx.lifecycle.ViewModel

class MarqueModel:ViewModel() {
    val data = loadData()
    fun loadData():List<Marque> {
        val data = mutableListOf<Marque>()
        data.add(Marque(R.drawable.merc, "Mercedes"))
        data.add(Marque(R.drawable.merc, "Mercedes"))
        data.add(Marque(R.drawable.merc, "Mercedes"))
        data.add(Marque(R.drawable.merc, "Mercedes"))
        data.add(Marque(R.drawable.merc, "Mercedes"))
        data.add(Marque(R.drawable.merc, "Mercedes"))
        data.add(Marque(R.drawable.merc, "Mercedes"))
        return data
    }
}