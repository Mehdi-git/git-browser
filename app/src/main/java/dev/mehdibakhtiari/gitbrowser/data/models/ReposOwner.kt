package dev.mehdibakhtiari.gitbrowser.data.models

import com.google.gson.annotations.SerializedName

data class ReposOwner(
    @SerializedName("id")val id: Int,
    @SerializedName("avatar_url") val avatarUrl: String?,
    @SerializedName("login")val login: String?,
    @SerializedName("url")val url: String
)
