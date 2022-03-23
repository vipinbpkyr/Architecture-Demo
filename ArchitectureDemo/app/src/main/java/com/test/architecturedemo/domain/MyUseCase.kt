package com.test.architecturedemo.domain

import javax.inject.Inject

class MyUseCase @Inject constructor(private val repository: Repository) : BaseUseCase<String, List<String>> {
    override suspend fun invoke(params: String): List<String> {
        return repository.test()
    }
}