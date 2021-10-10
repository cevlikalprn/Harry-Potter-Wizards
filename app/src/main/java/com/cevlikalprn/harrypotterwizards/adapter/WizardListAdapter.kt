package com.cevlikalprn.harrypotterwizards.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.cevlikalprn.harrypotterwizards.R
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.databinding.WizardsRowLayoutBinding
import com.squareup.picasso.Picasso

class WizardListAdapter(
    private val adapterClickListener: AdapterClickListener
) : RecyclerView.Adapter<WizardListAdapter.MyViewHolder>() {

    var wizards = listOf<WizardEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class MyViewHolder(
        private val binding: WizardsRowLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private var imageString: String? = null

        fun bind(item: WizardEntity) {
            binding.apply {
                wizardNameTextView.text = item.name
                yearOfBirthTextView.text = item.yearOfBirth
                houseTextView.text = item.house

                imageString = if (item.image.isNotEmpty()) item.image else null
                Picasso.get().load(imageString).placeholder(R.drawable.loading_animation)
                    .error(R.drawable.broken_image).into(wizardImageView)

                if (item.isFavorite) favoriteImageView.setImageResource(R.drawable.star) else favoriteImageView.setImageResource(
                    R.drawable.empty_star
                )
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
        val item = wizards[position]
        holder.bind(item)

        holder.itemView.setOnClickListener {
            adapterClickListener.onItemClicked(item)
        }

        val favoriteImage = holder.itemView.findViewById<ImageView>(R.id.favorite_image_view)
        setFavoriteStatus(favoriteImage, item)

    }

    override fun getItemCount(): Int = wizards.size

    private fun setFavoriteStatus(favoriteImage: ImageView, item: WizardEntity) {
        favoriteImage.setOnClickListener {
            if (item.isFavorite) {
                item.isFavorite = false
                adapterClickListener.updateWizard(item)
                favoriteImage.setImageResource(R.drawable.empty_star)
            } else {
                item.isFavorite = true
                adapterClickListener.updateWizard(item)
                favoriteImage.setImageResource(R.drawable.star)
            }
        }
    }
}