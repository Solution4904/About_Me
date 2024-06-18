package com.solution.about_me.type

sealed class EnterType {
    object Choice : EnterType()
    object Freeform : EnterType()
}