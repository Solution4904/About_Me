package com.solution.about_me.event

sealed class CommonUIEvent : UIEvent {
    object backToMain : CommonUIEvent()
}