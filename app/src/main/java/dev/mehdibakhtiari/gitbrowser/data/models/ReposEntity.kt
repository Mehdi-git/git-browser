package dev.mehdibakhtiari.gitbrowser.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repos_table")
data class ReposEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String?,
    val language: String?,
    var isFavorite: Boolean = false
)
