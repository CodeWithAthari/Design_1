package com.atrii.design_1

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.transition.Explode
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.atrii.design_1.databinding.ActivitySplashBinding


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    private val DELAY = 2000
    val activity = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        with(window){
            enterTransition = Explode()
            exitTransition = Explode()
            enterTransition.duration = 1000
            exitTransition.duration = 1000
        }
        setContentView(binding.root)
        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(
                Intent(this@SplashActivity, MainActivity::class.java),
                ActivityOptions.makeSceneTransitionAnimation(activity).toBundle()
            )

        }, DELAY.toLong())


    }


}