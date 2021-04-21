package com.example.weekfourtaskui.datasource

import android.graphics.Color
import com.example.weekfourtaskui.R
import com.example.weekfourtaskui.datamode.RecyclerModel
import com.example.weekfourtaskui.datamode.ViewPagerMode

class ViewPagerDataSource {
    companion object{
        fun createDataSet(): ArrayList<ViewPagerMode>  {
            val list = ArrayList<ViewPagerMode>()
            list.add(ViewPagerMode("Darot", "23,481,000.00", Color.RED))
            list.add(ViewPagerMode("Olalekan", "33,481,000.00", Color.BLUE))
            list.add(ViewPagerMode("Oluwafemi", "93,481,000.00", Color.DKGRAY))
            list.add(ViewPagerMode("Abdulrazaaq", "43,481,000.00", Color.MAGENTA))
            list.add(ViewPagerMode("Samuel", "23,481,000.00", Color.GREEN))
            return list
        }
    }
}