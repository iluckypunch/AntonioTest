package com.example.antoniotest.presentation

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.antoniotest.R

class SecondActivity: AppCompatActivity() {

    private val viewModel: SecondViewModel by lazy {
        ViewModelProvider(this)[SecondViewModel::class.java]
    }

    private lateinit var closeTextView: TextView
    private lateinit var sumTextView: TextView
    private lateinit var nameTextView: TextView
    private lateinit var ageTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        closeTextView = findViewById(R.id.close_text_view)
        sumTextView = findViewById(R.id.sum_text_view)
        nameTextView = findViewById(R.id.name_text_view)
        ageTextView = findViewById(R.id.age_text_view)

        sumTextView.text = intent.getStringExtra(SUM)
        closeTextView.setOnClickListener {
            finish()
        }

        nameTextView.text = viewModel.getNamesFromJson("name")
        ageTextView.text = viewModel.getNamesFromJson("age")
    }

    companion object {
        private const val SUM = "Sum"
    }
}