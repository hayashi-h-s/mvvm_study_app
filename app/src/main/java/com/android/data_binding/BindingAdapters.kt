package com.android.data_binding

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("app:logoIcon")
fun logoIcon(view: ImageView, logo: LogoMark) {

    when(logo) {
        LogoMark.LOGO1 -> {
            view.setImageDrawable(ContextCompat.getDrawable(view.context, R.drawable.bat))
        }
        else -> {
            view.setImageDrawable(ContextCompat.getDrawable(view.context, R.drawable.ball))
        }
    }
}