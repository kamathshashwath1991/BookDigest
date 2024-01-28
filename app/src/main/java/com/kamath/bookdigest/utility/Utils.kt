package com.kamath.bookdigest.utility

fun Int.toStarRepresentation():String{
    return "★".repeat(this) + "☆".repeat(5 - this)
}