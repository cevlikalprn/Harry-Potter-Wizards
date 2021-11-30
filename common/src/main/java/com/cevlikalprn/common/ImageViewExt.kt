package com.cevlikalprn.common

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadWizardImage(context: Context, url: String) {
    Glide.with(context).load(url).placeholder(R.drawable.loading_animation)
        .error(R.drawable.broken_image).into(this)
}

