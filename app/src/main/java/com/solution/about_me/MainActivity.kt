package com.solution.about_me

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.solution.about_me.feature.QuestionChoiceActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        ButtonEvents()
    }

    private fun ButtonEvents() {
        findViewById<Button>(R.id.AAA).setOnClickListener { _ -> startActivity(Intent(this, TitleActivity::class.java)) }
        findViewById<Button>(R.id.BBB).setOnClickListener { _ -> startActivity(Intent(this, QuestionChoiceActivity::class.java)) }
        findViewById<Button>(R.id.CCC).setOnClickListener { _ -> startActivity(Intent(this, QuestionAndAnswerActivity::class.java)) }
        findViewById<Button>(R.id.DDD).setOnClickListener { _ -> startActivity(Intent(this, ResultActivity::class.java)) }
    }
}