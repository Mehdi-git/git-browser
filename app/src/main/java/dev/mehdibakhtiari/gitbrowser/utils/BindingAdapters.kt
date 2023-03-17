package dev.mehdibakhtiari.gitbrowser.utils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.google.android.material.imageview.ShapeableImageView
import dev.mehdibakhtiari.gitbrowser.R.*

import java.util.*

@BindingAdapter("setGlide")
fun setGlide(view: ImageView, imageUrl: String?) =
    imageUrl?.let { view.loadImageFromGlide(it) }
        ?: run {
            view.setImageResource(drawable.ic_baseline_image_error)
        }

@BindingAdapter("app:setFavouriteCondition")
fun setFavouriteCondition(imageView: ShapeableImageView, isFavourite: Boolean) {
    if (isFavourite) {
        imageView.setImageResource(drawable.ic_baseline_favorite_24)
    } else {
        imageView.setImageResource(drawable.ic_baseline_favorite_border_24)
    }
}







