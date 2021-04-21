package com.example.weekfourtaskui.datasource

import com.example.weekfourtaskui.datamode.RecyclerModel

class RecyclerViewDataSource {
    companion object{
        fun createDataSet(): ArrayList<RecyclerModel>  {
            val list = ArrayList<RecyclerModel>()
            list.add(RecyclerModel("AliExpress", "4", "Clothes and shoes"))
            list.add(RecyclerModel("Aviasales", "4.4", "Booking and sales"))
            list.add(RecyclerModel("Jumial", "4.6", "Phones and tabs"))
            list.add(RecyclerModel("Konga", "4.7", "Electronics and generator"))
            list.add(RecyclerModel("HDL", "3.9", "Home deliveries"))
            list.add(RecyclerModel("Cheki.com", "4.5", "Used appliances"))
            return list
        }
    }
}