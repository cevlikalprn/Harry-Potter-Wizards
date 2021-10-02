package com.cevlikalprn.harrypotterwizards.util

import android.view.View
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
    Picasso.get()
        .load(str)
        .placeholder(R.drawable.loading_animation)
        .error(R.drawable.broken_image)
        .into(imageView)
}

@BindingAdapter("app:showErrorMessageText")
fun showErrorMessageText(textView: TextView, errorMessage: String?) {
    if (!errorMessage.isNullOrEmpty()) {
        textView.text = errorMessage
        textView.visibility = View.VISIBLE
    }
}

@BindingAdapter("app:showErrorMessageIcon")
fun showErrorMessageIcon(imageView: ImageView, errorMessage: String?) {
    if (!errorMessage.isNullOrEmpty()) {
        imageView.visibility = View.VISIBLE
    }
}