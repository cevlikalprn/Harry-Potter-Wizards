package com.cevlikalprn.harrypotterwizards.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.cevlikalprn.harrypotterwizards.R
import com.squareup.picasso.Picasso

@BindingAdapter("app:isTheWizardAlive")
fun isTheWizardAlive(textView: TextView, state: Boolean) {
    textView.text =
        if (state) textView.context.getString(R.string.alive) else textView.context.getString(R.string.not_alive)
}

@BindingAdapter("app:setTheWizardImageUrl")
fun setTheWizardImageUrl(imageView: ImageView, str: String) {
    val imageString: String? = if (str.isNotEmpty()) str else null
    Picasso.get()
        .load(imageString)
        .placeholder(R.drawable.loading_animation)
        .error(R.drawable.broken_image)
        .into(imageView)
}