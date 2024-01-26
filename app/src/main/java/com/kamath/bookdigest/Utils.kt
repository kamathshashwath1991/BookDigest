package com.kamath.bookdigest

fun Int.toStarRepresentation():String{
    return "★".repeat(this) + "☆".repeat(5 - this)
}