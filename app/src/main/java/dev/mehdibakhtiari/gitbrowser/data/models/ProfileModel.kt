package dev.mehdibakhtiari.gitbrowser.data.models

import com.google.gson.annotations.SerializedName

data class ProfileModel (
    @SerializedName("id") val id: String?,
    @SerializedName("login") val login: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("avatar_url") val avatarUrl: String?,
    @SerializedName("url") val url: String?,
    @SerializedName("company") val companyName: String?,
    @SerializedName("location") val location: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("public_repos") val public_repos: Int?,
    @SerializedName("followers") val followers: Int?,
    @SerializedName("following") val following: Int?,
    @SerializedName("created_at") val createdAt: String?,
    @SerializedName("updated_at") val updatedAt: String?,
)