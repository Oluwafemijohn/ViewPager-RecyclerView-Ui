package com.example.weekfourtaskui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weekfourtaskui.R
import com.example.weekfourtaskui.datamode.RecyclerModel
import com.example.weekfourtaskui.datasource.RecyclerViewDataSource

class RecyclerAdapter:RecyclerView.Adapter<RecyclerAdapter.CardViewHolder>() {
    private  var items: List<RecyclerModel> = RecyclerViewDataSource.createDataSet()

    class CardViewHolder constructor(itemView : View):RecyclerView.ViewHolder(itemView){
        private val company: TextView = itemView.findViewById(R.id.company_name)
        private val  rate = itemView.findViewById<TextView>(R.id.rate)
        private val product  = itemView.findViewById<TextView>(R.id.products)
        //Binding the data with the view
        fun  bind(recyclerModel: RecyclerModel){
            company.text = recyclerModel.company
            rate.text = recyclerModel.rate
            product.text = recyclerModel.product

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_card_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(items[position])
    }
    override fun getItemCount(): Int {
        return items.size
    }
}