package com.omelchenkoaleks.animals.screens.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omelchenkoaleks.animals.R
import com.omelchenkoaleks.animals.databinding.AnimalItemBinding
import com.omelchenkoaleks.animals.models.Animal
import com.omelchenkoaleks.animals.utils.APP_ACTIVITY

class AnimalsAdapter : RecyclerView.Adapter<AnimalsAdapter.AnimalsHolder>() {

    private var animals = emptyList<Animal>()

    class AnimalsHolder(val binding: AnimalItemBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : AnimalsHolder {
        return AnimalsHolder(
            AnimalItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AnimalsHolder, position: Int) {
        holder.binding.tvNameItem.text =
            "${APP_ACTIVITY.resources.getString(R.string.sort_by_name)} ${animals[position].name}"
        holder.binding.tvAgeItem.text =
            "${APP_ACTIVITY.resources.getString(R.string.sort_by_age)} ${animals[position].age}"
        holder.binding.tvBreedItem.text =
            "${APP_ACTIVITY.resources.getString(R.string.sort_by_breed)} ${animals[position].breed}"
    }

    override fun getItemCount(): Int = animals.size


    @SuppressLint("NotifyDataSetChanged")
    fun setAnimals(animals: List<Animal>) {
        this.animals = animals
        notifyDataSetChanged()
    }

}