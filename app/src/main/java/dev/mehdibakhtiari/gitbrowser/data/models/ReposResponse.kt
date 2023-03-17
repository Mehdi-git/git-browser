package dev.mehdibakhtiari.gitbrowser.data.models

import com.google.gson.annotations.SerializedName

data class ReposResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("clone_url") val clone_url: String,
    @SerializedName("created_at") val created_at: String,
    @SerializedName("description") val description: String?,
    @SerializedName("fork") val fork: Boolean,
    @SerializedName("forks") val forks: Int,
    @SerializedName("forks_count") val forks_count: Int,
    @SerializedName("full_name") val full_name: String,
    @SerializedName("git_url") val git_url: String,
    @SerializedName("has_issues") val has_issues: Boolean,
    @SerializedName("keys_url") val keys_url: String,
    @SerializedName("labels_url") val labels_url: String,
    @SerializedName("language") val language: String?,
    @SerializedName("languages_url") val languages_url: String,
    @SerializedName("license") val license: License?,
    @SerializedName("name") val name: String,
    @SerializedName("open_issues") val open_issues: Int,
    @SerializedName("open_issues_count") val open_issues_count: Int,
    @SerializedName("reposOwner") val reposOwner: ReposOwner,
    @SerializedName("private") val private: Boolean,
    @SerializedName("tags_url") val tags_url: String,
    @SerializedName("updated_at") val updated_at: String,
    @SerializedName("url") val url: String,
    @SerializedName("visibility") val visibility: String,
    @SerializedName("watchers_count") val watchers_count: Int,
)

fun ReposResponse.toReposEntity() = ReposEntity (
    id = id,
    name = name,
    description = description,
    language = language,

)