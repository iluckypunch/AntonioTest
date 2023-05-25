package com.example.antoniotest.domain

class GetSumUseCase(val repository: Repository) {
    fun getSum(a: String, b: String): String {
        return repository.getSum(a, b)
    }
}