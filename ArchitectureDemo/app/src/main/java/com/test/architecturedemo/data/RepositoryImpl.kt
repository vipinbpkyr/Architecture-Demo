package com.test.architecturedemo.data

import com.test.architecturedemo.domain.Repository
import kotlinx.coroutines.delay
import javax.inject.Inject

class RepositoryImpl @Inject constructor() : Repository {
    override suspend fun test(): List<String> {
        //Simulate loading
        delay(4 * 1000)
        return listOf(
            "One", "Two", "Three", "Two", "Three", "Two",
            "Three", "Two", "Three", "Two", "Three", "Two", "Three"
        )
    }
}