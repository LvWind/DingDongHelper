package com.jiayou.shanghai

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.jiayou.shanghai.databinding.ActivityScrollingBinding


class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title
        binding.fab.setOnClickListener { view ->
            //openAccessibility(view)
            openDingDong()
        }
    }

    private fun openDingDong() {
        var intent = packageManager.getLaunchIntentForPackage("com.yaya.zone")
        if (intent == null) {
            intent = Intent(Intent.ACTION_MAIN)
            intent.component =
                ComponentName("com.yaya.zone", "com.yaya.zone.home.HomeActivity")
        }
        startActivity(intent)
    }

    fun openAccessibility(view: View?) {
        try {
            val accessibleIntent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
            startActivity(accessibleIntent)
        } catch (e: Exception) {
            view?.let {
                Snackbar.make(view, "跳转失败，请前往系统设置>无障碍服务>叮咚助手", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }
    }
}