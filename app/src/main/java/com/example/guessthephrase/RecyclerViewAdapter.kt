package com.example.guessthephrase

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RecyclerViewAdapter(val context: Context, val messages: ArrayList<String>): RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = messages[position]

        holder.itemView.apply {
            tvItemsEntered.text = item
            if(item.startsWith("Found")){
                tvItemsEntered.setTextColor(Color.GREEN)
            }else if(item.startsWith("No")||item.startsWith("Wrong")){
                tvItemsEntered.setTextColor(Color.RED)
            }else{
                tvItemsEntered.setTextColor(Color.BLACK)
            }
        }
    }

    override fun getItemCount() = messages.size
}