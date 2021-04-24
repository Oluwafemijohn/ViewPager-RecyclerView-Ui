package com.example.weekfourtaskui.datasource

import com.example.weekfourtaskui.datamode.RecyclerModel

class RecyclerViewDataSource {
    companion object{
        fun createDataSet(): List<RecyclerModel>  {
            return listOf(
                RecyclerModel("AliExpress", "4", "Clothes and shoes"),
                RecyclerModel("AliExpress", "4", "Clothes and shoes"),
                RecyclerModel("Aviasales", "4.4", "Booking and sales"),
                RecyclerModel("Jumial", "4.6", "Phones and tabs"),
                RecyclerModel("Konga", "4.7", "Electronics and generator"),
                RecyclerModel("HDL", "3.9", "Home deliveries"),
                RecyclerModel("Cheki.com", "4.5", "Used appliances")
            )
        }
    }
}