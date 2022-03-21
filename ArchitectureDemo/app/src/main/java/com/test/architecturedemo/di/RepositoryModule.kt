package com.test.architecturedemo.di

import com.test.architecturedemo.domain.Repository
import com.test.architecturedemo.data.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTestRepository(
        testRepositoryImpl: RepositoryImpl
    ): Repository

}