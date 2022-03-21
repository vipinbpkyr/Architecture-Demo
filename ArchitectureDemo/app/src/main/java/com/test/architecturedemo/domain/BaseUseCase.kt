package com.test.architecturedemo.domain

interface BaseUseCase<in Parameter, out Result> {
    suspend operator fun invoke(params: Parameter): Result
}