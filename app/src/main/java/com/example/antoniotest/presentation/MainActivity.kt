package com.example.antoniotest.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.example.antoniotest.R
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private var _button: Button? = null
    private val button: Button
        get() = _button ?: throw Exception("Button = null")

    private lateinit var firstEditText: EditText
    private lateinit var secondEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstEditText = findViewById(R.id.first_et)
        secondEditText = findViewById(R.id.second_et)

        _button = findViewById(R.id.second_view_button)

        button.setOnClickListener {
            observeViewModels()
            if (
                viewModel.validateInput(firstEditText.text.toString()) &&
                viewModel.validateInput(secondEditText.text.toString())
            ) {
                viewModel.resetErrorInput()
                viewModel.getSum(firstEditText.text.toString(), secondEditText.text.toString())
                val intent = Intent(this, SecondActivity::class.java)
                    .putExtra(SUM, viewModel.sum.value)
                startActivity(intent)
            }
        }
    }

    private fun observeViewModels() {
        viewModel.errorInput.observe(this) {
            val message = if (it) {
                INVALID_INPUT
            } else {
                null
            }
        button.error = message
        }
    }

    companion object {
        const val INVALID_INPUT = "Invalid input"
        private const val SUM = "Sum"
    }
}