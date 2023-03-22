package com.example.rental

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MarqueAdapter(val context: Context,var data:List<Marque>):RecyclerView.Adapter<MarqueAdapter.MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_marque, parent, false))

    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.apply {
            val vm = MarqueModel()
            var item = vm.data[position]
            marque.text = data[position].marque
            marqueImage.setImageResource(R.drawable.merc)
        }
//
//        holder.itemView.setOnClickListener { view: View ->
//            val bundle = bundleOf("position" to position)
//            view.findNavController().navigate(R.id.action_mainFragment_to_detailFragment,bundle)
//        }



    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val marqueImage= view.findViewById (R.id.marqueImage) as ImageView
        val marque= view.findViewById (R.id.marque) as TextView


    }

}



