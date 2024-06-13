package com.solution.about_me.feature


import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.solution.about_me.R
import com.solution.about_me.base.BaseDataBinding
import com.solution.about_me.databinding.ActivityTitleBinding
import com.solution.about_me.event.TitleUIEvent
import com.solution.about_me.viewmodel.TitleViewModel
import kotlinx.coroutines.launch


class TitleActivity : BaseDataBinding<ActivityTitleBinding>(R.layout.activity_title) {
    private val viewModel by viewModels<TitleViewModel>()

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
                        Log.d("TAG", "initObservers: $uiEvent")
                    }

                    is TitleUIEvent.EnterFreeformType -> {
                        Log.d("TAG", "initObservers: $uiEvent")
                    }

                    else -> Unit
                }
            }
        }
    }
}