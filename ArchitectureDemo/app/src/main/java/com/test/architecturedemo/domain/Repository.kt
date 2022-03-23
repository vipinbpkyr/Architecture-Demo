package com.test.architecturedemo.domain

interface Repository {
    suspend fun test() : List<String>
}