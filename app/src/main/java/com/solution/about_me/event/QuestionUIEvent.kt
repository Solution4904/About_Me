package com.solution.about_me.event

sealed class QuestionUIEvent : UIEvent {
    object Next : QuestionUIEvent()
    object Cancel : QuestionUIEvent()
    object Repeat : QuestionUIEvent()
}