package com.atrii.design_1.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atrii.design_1.Data.MainData
import com.atrii.design_1.databinding.SampleHomeLayoutBinding

class MainAdapter(var list: ArrayList<MainData>, val context: Context) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(val binding: SampleHomeLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SampleHomeLayoutBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]
        val binding = holder.binding

        binding.mIcon.setImageResource(model.icon)
        binding.mTitle.text = model.title


    }

    override fun getItemCount() = list.size

}