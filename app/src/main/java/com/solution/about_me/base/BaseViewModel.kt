package com.solution.about_me.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solution.about_me.event.UIEvent
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    private val _eventFlow = MutableSharedFlow<UIEvent>(
        extraBufferCapacity = 10,
        replay = 0,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val eventFlow: SharedFlow<UIEvent> = _eventFlow

    fun sendEvent(uiEvent: UIEvent) {
        viewModelScope.launch {
            Log.d("TEST", "sendEvent: ${uiEvent}")
            _eventFlow.emit(uiEvent)
        }
    }
}