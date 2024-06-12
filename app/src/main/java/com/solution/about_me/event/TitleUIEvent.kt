package com.solution.about_me.event

sealed class TitleUIEvent : UIEvent {
    object EnterRandomType : TitleUIEvent()
    object EnterChoiceType : TitleUIEvent()
    object EnterFreeformType : TitleUIEvent()
}