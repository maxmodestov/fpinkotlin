package com.fpinkotlin.recursion.exercise04

fun string(list: List<Char>): String {
    tailrec fun string(res: String, chars: List<Char>): String =
            when {
                chars.isEmpty() -> res
                else -> string(res + chars.head(), chars.drop(1))
            }
    return string("", list)
}
