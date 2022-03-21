package com.test.architecturedemo.domain

import javax.inject.Inject

class MyUseCase @Inject constructor(private val repository: Repository) : BaseUseCase<String, String> {
    override suspend fun invoke(params: String): String {
        return repository.test()
    }
}