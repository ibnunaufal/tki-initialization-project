package id.co.psplauncher.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.co.psplauncher.Utils.handleApiError
import id.co.psplauncher.data.network.Resource
import id.co.psplauncher.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.loginResponse.observe(this) {
            // use Resource.Loading to know current state
            if (it is Resource.Success) {
                // do something
            } else if (it is Resource.Failure) {
                handleApiError(binding.root, it)
            }
        }
    }

    fun example() {
        viewModel.login("username", "password")
    }
}