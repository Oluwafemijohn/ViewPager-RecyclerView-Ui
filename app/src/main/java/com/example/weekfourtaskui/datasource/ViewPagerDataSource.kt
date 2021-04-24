package com.example.weekfourtaskui.datasource

import android.graphics.Color
import com.example.weekfourtaskui.R
import com.example.weekfourtaskui.datamode.RecyclerModel
import com.example.weekfourtaskui.datamode.ViewPagerMode

class ViewPagerDataSource {
    companion object{
        fun createDataSet(): List<ViewPagerMode>  {
            return listOf(ViewPagerMode("Darot", "23,481,000.00", Color.RED),
                ViewPagerMode("Olalekan", "33,481,000.00", Color.BLUE),
                ViewPagerMode("Oluwafemi", "93,481,000.00", Color.DKGRAY),
                ViewPagerMode("Abdulrazaaq", "43,481,000.00", Color.MAGENTA),
                ViewPagerMode("Samuel", "23,481,000.00", Color.rgb(0,0,0))
            )
        }
    }
}