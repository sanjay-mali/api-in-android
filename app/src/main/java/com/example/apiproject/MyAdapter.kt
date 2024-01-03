package com.example.apiproject

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(private val context: Activity, private val productArray: List<Product>) :RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(MyView: View): RecyclerView.ViewHolder(MyView) {
        val img :ShapeableImageView
        val title: TextView
        val dec: TextView
        val rating:TextView
        val price:TextView
        val category:TextView

        init {
            img = MyView.findViewById(R.id.img)
            title = MyView.findViewById(R.id.title)
            dec = MyView.findViewById(R.id.des)
            rating = MyView.findViewById(R.id.rating)
            price = MyView.findViewById(R.id.price)
            category = MyView.findViewById(R.id.category)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productArray.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = productArray[position]

        holder.title.text = data.title
        holder.dec.text = data.description
        Picasso.get().load(data.thumbnail).into(holder.img);
        holder.price.text = "Price:${data.price}"
        holder.rating.text = "Rating:"+data.rating.toString()
        holder.category.text = "Category:"+data.category

    }
}