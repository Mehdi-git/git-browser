package dev.mehdibakhtiari.gitbrowser.data.models

import com.google.gson.annotations.SerializedName

data class ProfileModel (
    @SerializedName("id") val id: String? = null,
    @SerializedName("login") val login: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("avatar_url") val avatarUrl: String? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("company") val companyName: String? = null,
    @SerializedName("location") val location: String? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("public_repos") val public_repos: Int? = null,
    @SerializedName("followers") val followers: Int? = null,
    @SerializedName("following") val following: Int? = null,
    @SerializedName("created_at") val createdAt: String? = null,
    @SerializedName("updated_at") val updatedAt: String? = null,
)