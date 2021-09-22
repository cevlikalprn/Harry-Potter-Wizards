package com.cevlikalprn.harrypotterwizards.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.cevlikalprn.harrypotterwizards.R
import com.cevlikalprn.harrypotterwizards.databinding.WizardsRowLayoutBinding
import com.cevlikalprn.harrypotterwizards.models.WizardItem
import com.cevlikalprn.harrypotterwizards.ui.fragments.WizardListFragmentDirections
import com.squareup.picasso.Picasso

class WizardAdapter() : RecyclerView.Adapter<WizardAdapter.MyViewHolder>() {

    var data = listOf<WizardItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(
            R.layout.wizards_row_layout,
            parent,
            false
        )
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = data[position]
        val image = holder.itemView.findViewById(R.id.wizard_image_view) as ImageView
        val wizardName = holder.itemView.findViewById(R.id.wizard_name_text_view) as TextView
        val yearOfBirth = holder.itemView.findViewById(R.id.year_of_birth_text_view) as TextView
        val houseName = holder.itemView.findViewById(R.id.house_text_view) as TextView
        Picasso.get().load(item.image).into(image)
        wizardName.text = item.name
        yearOfBirth.text = item.yearOfBirth
        houseName.text = item.house
        
        holder.itemView.setOnClickListener { view ->
            view.findNavController().navigate(WizardListFragmentDirections.actionWizardsFragmentToWizardDetailsFragment(item))
        }

    }

    override fun getItemCount(): Int = data.size
}