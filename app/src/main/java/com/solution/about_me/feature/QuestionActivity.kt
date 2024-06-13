package com.solution.about_me.feature

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.solution.about_me.R
import com.solution.about_me.base.BaseDataBinding
import com.solution.about_me.databinding.ActivityQuestionBinding
import com.solution.about_me.event.CommonUIEvent
import com.solution.about_me.event.QuestionUIEvent
import com.solution.about_me.event.TitleUIEvent
import com.solution.about_me.type.EnterType
import com.solution.about_me.viewmodel.QuestionViewModel
import kotlinx.coroutines.launch

class QuestionActivity : BaseDataBinding<ActivityQuestionBinding>(R.layout.activity_question) {
    // # Variable
    private val viewModel by viewModels<QuestionViewModel>()

    // # Essential Function
    override fun init() {
        super.init()

        binding.vm = viewModel

        setType()

        initObserver()
    }

    private fun initObserver() {
        lifecycleScope.launch {
            viewModel.eventFlow.flowWithLifecycle(lifecycle).collect { uiEvent ->
                Log.d("TAG", "$uiEvent")

                when (uiEvent) {
                    is QuestionUIEvent.Next -> {
                        // TODO:
                    }

                    is QuestionUIEvent.Cancel -> {
                        // TODO()
                    }

                    is QuestionUIEvent.Repeat -> {
                        // TODO()
                    }

                    else -> Unit
                }
            }
        }
    }

    // # Definition Function
    private fun setType() {
        Log.d("TAG", "setType: ${EnterType::class.java.simpleName}")
        binding.tempType = intent.getStringExtra(EnterType::class.java.simpleName)
    }

    private fun EnterChoiceActivity() {

    }

    private fun EnterFreeformActivity() {

    }
}