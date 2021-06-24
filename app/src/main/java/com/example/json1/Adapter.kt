package com.example.json1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (val context: Context, val list:ArrayList<DataModel>)
    :RecyclerView.Adapter<Adapter.ViewHolder>(){
    private val inflater: LayoutInflater
    =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val textView1: TextView =view.findViewById(R.id.text1)
        val textView2:TextView=view.findViewById(R.id.text2)
        val textView3:TextView=view.findViewById(R.id.text3)
        val textView4:TextView=view.findViewById(R.id.text4)
        val textView5:TextView=view.findViewById(R.id.text5)
        val textView6:TextView=view.findViewById(R.id.text6)
        val textView7:TextView=view.findViewById(R.id.text7)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val rowList=inflater.inflate(R.layout.list,parent,false)
        return ViewHolder(rowList)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
       holder.textView1.text=list.get(position).id
        holder.textView2.text=list.get(position).name
        holder.textView3.text=list.get(position).email
        holder.textView4.text=list.get(position).gender
        holder.textView5.text=list.get(position).mobile
        holder.textView6.text=list.get(position).home
        holder.textView7.text=list.get(position).office
    }

}