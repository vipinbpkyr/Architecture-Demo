package com.test.architecturedemo.data

import com.test.architecturedemo.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor() : Repository {
    override fun test() : String {
        //TODO() Implement
        return ""
    }
}