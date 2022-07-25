package com.wangxingxing.homepageanim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wangxingxing.homepageanim.databinding.ActivityAppWidgetBinding

class AppWidgetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppWidgetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAppWidgetBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}