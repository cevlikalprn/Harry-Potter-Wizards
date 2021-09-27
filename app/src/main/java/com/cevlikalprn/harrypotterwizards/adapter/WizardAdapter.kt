package com.cevlikalprn.harrypotterwizards.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.cevlikalprn.harrypotterwizards.databinding.WizardsRowLayoutBinding
import com.cevlikalprn.harrypotterwizards.model.Wizard
import com.cevlikalprn.harrypotterwizards.list.WizardListFragmentDirections
import com.squareup.picasso.Picasso

class WizardAdapter() : RecyclerView.Adapter<WizardAdapter.MyViewHolder>() {

    var data = listOf<Wizard>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class MyViewHolder(private val binding: WizardsRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Wizard) {

            binding.apply {
                wizardNameTextView.text = item.name
                yearOfBirthTextView.text = item.yearOfBirth
                houseTextView.text = item.house
                Picasso.get().load(item.image).into(wizardImageView)
            }
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = WizardsRowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)

        holder.itemView.setOnClickListener { view ->
            view.findNavController().navigate(
                WizardListFragmentDirections.actionWizardsFragmentToWizardDetailsFragment(item)
            )
        }
    }

    override fun getItemCount(): Int = data.size
}