package br.com.customviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import br.com.customviewkotlin.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding:ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initProgressButton()
    }

    private fun initProgressButton() {
        binding.run {
            with(progressButton) {
                setOnClickListener {
                    setLoading()
                    lifecycleScope.launch {
                        delay(3000)
                        setNormal()
                    }
                }
            }
        }
    }
}