package com.test.architecturedemo.di

import com.test.architecturedemo.domain.Repository
import com.test.architecturedemo.data.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(
        testRepositoryImpl: RepositoryImpl
    ): Repository

}