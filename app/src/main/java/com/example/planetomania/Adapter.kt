package com.example.planetomania

import android.content.Intent
import android.view.LayoutInflater

import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import com.example.planetomania.databinding.ViewsBinding



class Adapter(var planet:List<PlanetData>): RecyclerView.Adapter<Adapter.myViewHolder>() {

    class myViewHolder(val binding: ViewsBinding) : RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
       return myViewHolder(ViewsBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun getItemCount(): Int {
        return planet.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var dummyImage:Int?=null
        holder.binding.title.text=planet[position].title
        holder.binding.distance.text=planet[position].distance + "m km"
        holder.binding.galaxy.text=planet[position].galaxy
        holder.binding.gravity.text=planet[position].gravity + "m/ss"
        holder.itemView.setOnClickListener{
            val intent=Intent(holder.itemView.context,PlanetDetail::class.java)
            intent.putExtra("planet",planet[position])
            intent.putExtra("planetImage",dummyImage)


            holder.itemView.context.startActivity(intent)
        }
//

        when (planet[position].title!!.lowercase()) {
            "mars" -> {
                dummyImage = R.drawable.mars
            }
            "neptune" -> {
                dummyImage = R.drawable.neptune
            }
            "earth" -> {
                dummyImage = R.drawable.earth
            }
            "moon" -> {
                dummyImage = R.drawable.moon
            }
            "venus" -> {
                dummyImage = R.drawable.venus
            }
            "jupiter" -> {
                dummyImage = R.drawable.jupiter
            }
            "saturn" -> {
                dummyImage = R.drawable.saturn
            }
            "uranus" -> {
                dummyImage = R.drawable.uranus
            }
            "mercury" -> {
                dummyImage = R.drawable.mercury
            }
            "sun" -> {
                dummyImage = R.drawable.sun
            }
        }
        holder.binding.planetImg.setImageResource(dummyImage!!)

    }
}
