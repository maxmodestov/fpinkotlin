package com.fpinkotlin.recursion.exercise04

fun <T> makeString(list: List<T>, delim: String): String {
    tailrec fun makeString(res: String, values: List<T>): String =
            when {
                values.isEmpty() -> res
                res.isEmpty() -> makeString("${list.head()}", list.tail())
                else -> makeString("$res$delim${values.head()}", values.tail())
            }
    return makeString("", list)
}

fun <T> List<T>.head(): T =
        if (this.isEmpty())
            throw IllegalArgumentException("head called on empty list")
        else
            this[0]

fun <T> List<T>.tail(): List<T> =
        if (this.isEmpty())
            throw IllegalArgumentException("tail called on empty list")
        else
            this.subList(1, this.size)
