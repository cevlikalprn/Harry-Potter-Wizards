package com.cevlikalprn.common

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:isTheWizardAlive")
fun isTheWizardAlive(textView: TextView, state: Boolean) {
    textView.text =
        if (state) textView.context.getString(R.string.alive) else textView.context.getString(R.string.not_alive)
}

@BindingAdapter("app:setTheWizardImageUrl")
fun setTheWizardImageUrl(imageView: ImageView, imageUrl: String) {
    imageView.loadWizardImage(imageView.context, imageUrl)
}