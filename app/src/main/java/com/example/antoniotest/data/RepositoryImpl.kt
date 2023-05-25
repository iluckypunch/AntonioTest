package com.example.antoniotest.data

import com.example.antoniotest.domain.Repository
import org.json.JSONArray

object RepositoryImpl: Repository {
    override fun getSum(a: String, b: String): String {
        val sum = a.toInt() + b.toInt()
        return sum.toString()
    }

    override fun getJson(): JSONArray {
        return JSONArray("[   {     \"name\": \"Misha\",     \"age\": \"20\"   },   {     \"name\": \"Dmitry\",     \"age\": \"21\"   },   {     \"name\": \"Elena\",     \"age\": \"18\"   },   {     \"name\": \"Pavel\",     \"age\": \"25\"   } ]")
    }
}