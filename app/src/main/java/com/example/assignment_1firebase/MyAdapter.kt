package com.example.assignment_1firebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(private val userList: ArrayList<Users>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.name.text = userList[position].name
        holder.number.text = userList[position].number
        holder.address.text = userList[position].address
            }


    override fun getItemCount(): Int {
        return userList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val name : TextView = itemView.findViewById(R.id.tvName)
        val number : TextView = itemView.findViewById(R.id.tvNumber)
        val address : TextView = itemView.findViewById(R.id.tvAddress)

    }

}