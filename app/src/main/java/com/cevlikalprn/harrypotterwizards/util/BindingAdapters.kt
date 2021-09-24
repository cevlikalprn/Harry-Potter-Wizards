package com.cevlikalprn.harrypotterwizards.util

import android.view.View
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

@BindingAdapter("app:showErrorMessageText")
fun showErrorMessageText(textView: TextView, errorMessage: String?){
    if (errorMessage != null) {
        if(errorMessage.isNotEmpty()){
            textView.text = errorMessage
            textView.visibility = View.VISIBLE
        }
    }
}

@BindingAdapter("app:showErrorMessageIcon")
fun showErrorMessageIcon(imageView: ImageView, errorMessage: String?){
    if (errorMessage != null) {
        if (errorMessage.isNotEmpty()){
            imageView.visibility = View.VISIBLE
        }
    }
}