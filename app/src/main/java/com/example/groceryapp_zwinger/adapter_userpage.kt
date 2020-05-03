package com.example.groceryapp_zwinger

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter_userpage(val context:Context, val list: MutableList<model_item>):RecyclerView.Adapter<adapter_userpage.userpageViewHolder>() {

    class userpageViewHolder(view: View):RecyclerView.ViewHolder(view){
        val txt_model_frag_userpage:TextView=view.findViewById(R.id.txt_model_frag_userpage)
        val but_model_frag_userpage:ImageButton=view.findViewById(R.id.but_model_frag_userpage)
        val but_model_check_frag_userpage:ImageButton=view.findViewById(R.id.but_model_check_frag_userpage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userpageViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.model_frag_userpage,parent,false)


        return userpageViewHolder(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: userpageViewHolder, position: Int) {
        val model_item=list[position]
        holder.txt_model_frag_userpage.text=model_item.Item_name
        holder.but_model_frag_userpage
        holder.but_model_check_frag_userpage

    }

}