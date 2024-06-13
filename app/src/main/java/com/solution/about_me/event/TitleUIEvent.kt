package com.solution.about_me.event

sealed class TitleUIEvent : UIEvent {
    object EnterChoiceType : TitleUIEvent()
    object EnterFreeformType : TitleUIEvent()
}