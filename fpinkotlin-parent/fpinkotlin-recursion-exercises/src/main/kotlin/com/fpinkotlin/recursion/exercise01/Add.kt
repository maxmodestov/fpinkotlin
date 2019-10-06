package com.fpinkotlin.recursion.exercise01


fun addLong(a: Int, b: Int): Int {
    tailrec fun addInternal(result: Int, counter: Int, addFinal: Int): Int =
            if (counter == addFinal) result else addInternal(inc(result), inc(counter), addFinal)
    return addInternal(a, 0, b)
}

tailrec fun add(a: Int, b: Int): Int = if (b == 0) a else add(inc(a), dec(b))

fun inc(n: Int) = n + 1
fun dec(n: Int) = n - 1

