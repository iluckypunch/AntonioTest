package com.example.antoniotest.domain

import org.json.JSONArray

interface Repository {
    fun getSum(a: String, b: String): String

    fun getJson(): JSONArray
}