package com.example.myapplication.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.presentation.state.PlayerUiState
import com.example.myapplication.presentation.util.ext.asToast
import com.example.myapplication.presentation.util.ext.show
import com.example.myapplication.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()
    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)

        activityMainBinding.lifecycleOwner = this@MainActivity

        setupUiStateObserver()
    }

    private fun setupUiStateObserver() {
        lifecycleScope.launch {
            mainViewModel.getPlayerByIdStateFlow(0).collect {
                when (it) {
                    is PlayerUiState.Success -> {
                        with(activityMainBinding) {
                            myApplicationLayoutProgressIndicator.show(false)
                            myApplicationTextView.text = it.playerEntity.toString()
                        }
                    }
                    is PlayerUiState.Failure -> {
                        activityMainBinding.myApplicationLayoutProgressIndicator.show(false)
                        it.throwable.toString().asToast(applicationContext)
                    }
                    is PlayerUiState.Loading -> {
                        activityMainBinding.myApplicationLayoutProgressIndicator.show(true)
                    }
                }
            }
        }
    }
}
