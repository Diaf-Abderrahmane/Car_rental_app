package com.example.rental

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarAdapter(val context: Context,var data:List<Car>):RecyclerView.Adapter<CarAdapter.MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_car, parent, false))

    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.apply {
            val vm = MarqueModel()
            var item = vm.data[position]
            item_marque.text = data[position].marque
            item_modele.text = data[position].modele
            item_car_image.setImageResource(R.drawable.tesla)
            item_logo.setImageResource(R.drawable.merc)
            item_tarif.text = data[position].tarif
        }
//
//        holder.itemView.setOnClickListener { view: View ->
//            val bundle = bundleOf("position" to position)
//            view.findNavController().navigate(R.id.action_mainFragment_to_detailFragment,bundle)
//        }



    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val item_car_image = view.findViewById (R.id.item_car_image) as ImageView
        val item_marque = view.findViewById (R.id.item_marque) as TextView
        val item_modele = view.findViewById (R.id.item_modele) as TextView
        val item_tarif = view.findViewById (R.id.item_tarif) as TextView
        val item_logo = view.findViewById(R.id.item_logo) as ImageView


    }

}



