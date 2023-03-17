package dev.mehdibakhtiari.gitbrowser.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.mehdibakhtiari.gitbrowser.data.models.ProfileEntity
import dev.mehdibakhtiari.gitbrowser.data.models.ReposEntity

@Database(entities = [ReposEntity::class, ProfileEntity::class], version = GitBrowserDatabase.VERSION)
abstract class GitBrowserDatabase : RoomDatabase() {

    abstract fun reposDao(): ReposDao
    abstract fun profileDao(): ProfileDao


    companion object {
         const val DB_NAME = "git_browser"
         const val VERSION = 1
        }
}
