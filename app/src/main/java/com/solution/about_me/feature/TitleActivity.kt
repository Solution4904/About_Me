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

    /* 2024-06-03
    * TODO: 이벤트는 정상이였다... xml에서 include로 사용 중인 버튼에 이벤트가 안 걸리는 문제였는데 개 헛고생했다. include로 넣은 버튼에 클릭 이벤트 거는 방법 알아내서 적용시킬 것
    */
    private fun initObservers() {
        lifecycleScope.launch {
            viewModel.eventFlow.flowWithLifecycle(lifecycle).collect { uiEvent ->
                Log.d("TAG", "$uiEvent")
                when (uiEvent) {
                    is TitleUIEvent.ClickTest -> {
                        Log.d("TAG", "initObservers: $uiEvent")
                    }

                    else -> Unit
                }
            }
        }
    }
}