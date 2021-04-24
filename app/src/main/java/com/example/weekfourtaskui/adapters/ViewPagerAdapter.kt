package com.example.weekfourtaskui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.weekfourtaskui.R
import com.example.weekfourtaskui.datamode.ViewPagerMode
import com.example.weekfourtaskui.datasource.ViewPagerDataSource


class ViewPagerAdapter:RecyclerView.Adapter<ViewPagerAdapter.ViewPagerCardViewHolder>() {
    private  var items: List<ViewPagerMode> = ViewPagerDataSource.createDataSet()

    class ViewPagerCardViewHolder constructor(itemView : View):RecyclerView.ViewHolder(itemView){
        private val cardName: TextView = itemView.findViewById(R.id.card_name)
        private val  cardAmunt = itemView.findViewById<TextView>(R.id.amount)
        private val color  = itemView.findViewById<CardView>(R.id.card_view)

        //Bind data with the view
        fun  bind(viewPagerMode: ViewPagerMode){
            cardName.text = viewPagerMode.name
            cardAmunt.text = viewPagerMode.balance
            color.setCardBackgroundColor(viewPagerMode.color)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerCardViewHolder {
        return ViewPagerCardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.viewpager_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewPagerCardViewHolder, position: Int) {
        //calling the function
        holder.bind(items[position])
    }
    override fun getItemCount(): Int {

        return items.size
    }


}
