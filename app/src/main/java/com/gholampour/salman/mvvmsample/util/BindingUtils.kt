package com.gholampour.salman.mvvmsample.util

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.gholampour.salman.mvvmsample.R
import com.squareup.picasso.Picasso


@BindingAdapter("content")
fun loadImage(view: ImageView, url: String?) {
    url?.let {
        Picasso.get().load(url).into(view)
    } ?: run {
        view.setImageDrawable(ContextCompat.getDrawable(view.context, R.drawable.profile_default))

    }


}