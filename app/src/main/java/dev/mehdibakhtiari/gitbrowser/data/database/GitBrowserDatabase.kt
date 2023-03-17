package dev.mehdibakhtiari.gitbrowser.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.mehdibakhtiari.gitbrowser.data.models.ReposEntity

@Database(entities = [ReposEntity::class], version = GitBrowserDatabase.VERSION)
abstract class GitBrowserDatabase : RoomDatabase() {

    abstract fun reposDao(): ReposDao

    companion object {
         const val DB_NAME = "git_browser"
         const val VERSION = 1
        }
}
