package dev.mehdibakhtiari.gitbrowser.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "profile_table")
data class ProfileEntity(
   @PrimaryKey
   val id: String,
   val login: String,
   val name: String?,
   val avatarUrl: String?,
   val url: String?,
   val companyName: String?,
   val location: String?,
   val email: String?,
   val public_repos: Int?,
   val followers: Int?,
   val following: Int?,
   val createdAt: String?,
   val updatedAt: String?,
   var isFavorite: Boolean = false,
)
