package com.cevlikalprn.harrypotterwizards.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("app:isTheWizardAlive")
fun isTheWizardAlive(textView: TextView, state: Boolean){
    textView.text = if (state) "Alive" else "Not Alive"
}

@BindingAdapter("app:setTheWizardImageUrl")
fun setTheWizardImageUrl(imageView: ImageView, str: String){
    Picasso.get().load(str).into(imageView)
}