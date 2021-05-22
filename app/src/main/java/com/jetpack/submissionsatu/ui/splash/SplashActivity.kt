package com.jetpack.submissionsatu.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatDelegate
import com.jetpack.submissionsatu.R
import com.jetpack.submissionsatu.databinding.ActivitySplashBinding
import com.jetpack.submissionsatu.ui.home.MainActivity

class SplashActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val animation = AnimationUtils.loadAnimation(this, R.anim.stb)

        binding.appLogo.startAnimation(animation)

        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }, 3000)
    }
}