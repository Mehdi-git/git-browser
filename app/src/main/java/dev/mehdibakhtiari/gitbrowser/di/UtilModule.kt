package dev.mehdibakhtiari.gitbrowser.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.mehdibakhtiari.gitbrowser.utils.conectivity.ConnectionManager
import dev.mehdibakhtiari.gitbrowser.utils.conectivity.ConnectionManagerImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class UtilModule {

    @Binds
    abstract fun bindMyDependency(impl: ConnectionManagerImpl): ConnectionManager
}