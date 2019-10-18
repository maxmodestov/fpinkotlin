package com.fpinkotlin.recursion.exercise16


fun <T> iterateMy(seed: T, f: (T) -> T, n: Int): List<T> {
    tailrec fun go(acc: List<T>, v: T, i: Int): List<T> =
            when {
                i <= 0 -> acc
                else -> {
                    val nextV = f(v)
                    go(acc + nextV, nextV, i - 1)
                }
            }
    return go(listOf(seed), seed, n - 1)
}

fun <T> iterate(seed: T, f: (T) -> T, n: Int): List<T> {
    tailrec fun go(acc: List<T>, seed: T): List<T> =
            if (acc.size < n)
                go(acc + seed, f(seed))
            else
                acc
    return go(emptyList(), seed)
}