package com.example.sto2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.sto2.R
import com.example.sto2.objects.STO
import com.example.sto2.retrofit.Common
import com.example.sto2.utils.TransPic
import com.squareup.picasso.Picasso

class StoListAdapter(stoList:List<STO>): RecyclerView.Adapter<StoListAdapter.MyViewHolder>() {

    private val stoList: List<STO> = stoList

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.card_image)
        val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
        val txtLocation: TextView = itemView.findViewById(R.id.txtLocation)
        val ratingBar: RatingBar = itemView.findViewById(R.id.rating)

        fun bind(listItem: STO) {

            itemView.setOnClickListener {
                val navController = Navigation.findNavController(itemView)
                navController.navigate(R.id.action_STOListFragment_to_STOInfoFragment)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = stoList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = stoList[position]

        if(listItem.image?.isNotEmpty() == true) {
            Picasso.get().load(Common.BASE_URL + "media/" + listItem.image!![0]).transform(TransPic()).into(holder.image)
        }

        holder.txtTitle.text = listItem.name
        holder.txtLocation.text = listItem.location
        holder.ratingBar.rating = listItem.rating

        holder.bind(listItem)

    }
}