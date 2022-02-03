package com.example.animations28012022

import android.graphics.PorterDuff
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.RequiresApi
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.tabs.TabLayout
import me.relex.circleindicator.CircleIndicator3
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var viewPager2: ViewPager2
    lateinit var fragmentAdapter: FragmentAdapter
    lateinit var lottieAnimationView: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()


    }

    private fun initViews() {
        viewPager2 = findViewById(R.id.viewPager2)
        lottieAnimationView = findViewById(R.id.lottieAnim)
        fragmentAdapter = FragmentAdapter(supportFragmentManager, lifecycle)
        viewPager2.adapter = fragmentAdapter

        val circleIndicator3 = findViewById<CircleIndicator3>(R.id.circleIndicator)

        circleIndicator3.setViewPager(viewPager2)


        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val anim = AnimationUtils.loadAnimation(applicationContext, R.anim.transition)
                lottieAnimationView.startAnimation(anim)

                when (position) {
                    0 -> lottieAnimationView.setAnimation(R.raw.telegram_icon)
                    1 -> lottieAnimationView.setAnimation(R.raw.speedometer)
                    2 -> lottieAnimationView.setAnimation(R.raw.gift_reward_animation)
                    3 -> lottieAnimationView.setAnimation(R.raw.infinity_spaghetti_loader)
                    4 -> lottieAnimationView.setAnimation(R.raw.security_check_mark)
                    5 -> lottieAnimationView.setAnimation(R.raw.cloud1)
                }

                lottieAnimationView.playAnimation()

            }
        })
    }
}