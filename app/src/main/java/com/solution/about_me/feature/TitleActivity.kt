package com.solution.about_me.feature


import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.solution.about_me.R
import com.solution.about_me.base.BaseDataBinding
import com.solution.about_me.databinding.ActivityTitleBinding
import com.solution.about_me.event.TitleUIEvent
import com.solution.about_me.type.EnterType
import com.solution.about_me.viewmodel.TitleViewModel
import kotlinx.coroutines.launch


class TitleActivity : BaseDataBinding<ActivityTitleBinding>(R.layout.activity_title) {
    // # Variable
    private val viewModel by viewModels<TitleViewModel>()

    // # Essential Function
    override fun init() {
        super.init()

        binding.vm = viewModel

        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            viewModel.eventFlow.flowWithLifecycle(lifecycle).collect { uiEvent ->
                Log.d("TAG", "$uiEvent")
                when (uiEvent) {
                    is TitleUIEvent.EnterChoiceType -> {
                        moveToQuestion(EnterType::class.java.simpleName, EnterType.Choice)
                    }

                    is TitleUIEvent.EnterFreeformType -> {
                        moveToQuestion(EnterType::class.java.simpleName, EnterType.Freeform)
                    }

                    else -> Unit
                }
            }
        }
    }

    // # Definition Function
    private fun moveToQuestion(key: String, type: EnterType) {
        val intent = Intent(this@TitleActivity, QuestionActivity::class.java)
        intent.putExtra(key, type::class.java.simpleName)
        startActivity(intent)
    }
}