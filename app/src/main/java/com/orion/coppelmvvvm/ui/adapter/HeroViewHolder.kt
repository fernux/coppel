package com.orion.coppelmvvvm.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.orion.coppelmvvvm.R
import com.orion.coppelmvvvm.databinding.ItemHeroBinding
import com.orion.coppelmvvvm.domain.model.Hero

class HeroViewHolder (view: View) : RecyclerView.ViewHolder(view){

    val binding = ItemHeroBinding.bind(view)


    fun render(hero:Hero,onClickListener:(Hero)-> Unit){
        binding.tvHeroName.text = hero.name
        Glide.with(binding.ivHero.context).load(hero.url).into(binding.ivHero)
        itemView.setOnClickListener {
            onClickListener(hero)
        }
    }
}