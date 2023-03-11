package dev.mehdibakhtiari.gitbrowser.utils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import dev.mehdibakhtiari.gitbrowser.R.*

import java.util.*

@BindingAdapter("setGlide")
fun setGlide(view: ImageView, imageUrl: String?) =
    imageUrl?.let { view.loadImageFromGlide(it) }
        ?: run { view.setImageResource(drawable.ic_baseline_image_error) }





