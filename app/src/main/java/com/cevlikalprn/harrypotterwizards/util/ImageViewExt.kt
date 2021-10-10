package com.cevlikalprn.harrypotterwizards.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.cevlikalprn.harrypotterwizards.R


fun ImageView.loadWizardImage(context: Context, url: String) {
    Glide.with(context).load(url).placeholder(R.drawable.loading_animation)
        .error(R.drawable.broken_image).into(this)
}

