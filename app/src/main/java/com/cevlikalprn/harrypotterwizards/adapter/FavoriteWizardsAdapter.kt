package com.cevlikalprn.harrypotterwizards.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.cevlikalprn.harrypotterwizards.R
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.databinding.WizardsRowLayoutBinding
import com.squareup.picasso.Picasso

class FavoriteWizardsAdapter(
    private val updateWizard: (WizardEntity) -> Unit,
    private val onItemClicked: (WizardEntity) -> Unit
) : RecyclerView.Adapter<FavoriteWizardsAdapter.ViewHolder>() {

    var favoriteWizards = listOf<WizardEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder(private val binding: WizardsRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

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
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = WizardsRowLayoutBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = favoriteWizards[position]
        holder.bind(item)

        holder.itemView.setOnClickListener { onItemClicked(item) }

        val favoriteImage = holder.itemView.findViewById<ImageView>(R.id.favorite_image_view)
        setFavoriteStatus(favoriteImage, item)
    }

    override fun getItemCount(): Int = favoriteWizards.size

    private fun setFavoriteStatus(favoriteImage: ImageView, wizard: WizardEntity) {
        favoriteImage.setOnClickListener {
            if (wizard.isFavorite) {
                wizard.isFavorite = false
                updateWizard(wizard)
                favoriteImage.setImageResource(R.drawable.empty_star)
            } else {
                wizard.isFavorite = true
                updateWizard(wizard)
                favoriteImage.setImageResource(R.drawable.star)
            }
        }
    }
}