package com.fpinkotlin.recursion.exercise18

import java.math.BigInteger


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

fun <T, U> foldLeft(list: List<T>, z: U, f: (U, T) -> U): U {
    tailrec fun foldLeft_(list: List<T>, acc: U, f: (U, T) -> U): U =
        if (list.isEmpty())
            acc
        else
            foldLeft_(list.tail(), f(acc, list.head()), f)
    return foldLeft_(list, z, f)
}

fun <T, U> map(list: List<T>, f: (T) -> U): List<U> =
    foldLeft(list, listOf()) { acc, elem -> acc + f(elem)}

fun <T> iterate(seed: T, f: (T) -> T, n: Int): List<T> {
    tailrec fun iterate_(acc: List<T>, seed: T): List<T> =
        if (acc.size < n)
            iterate_(acc + seed, f(seed))
        else
            acc
    return iterate_(listOf(), seed)
}

fun <T> makeString(list: List<T>, separator: String): String =
    when {
        list.isEmpty() -> ""
        list.tail().isEmpty() -> list.head().toString()
        else -> list.head().toString() + // <4>
            foldLeft(list.tail(), "") { x, y -> x + separator + y}
    }

fun fiboCorecursive(number: Int): String =
        makeString(map(iterate(
                Pair(BigInteger.ONE, BigInteger.ZERO),
                {Pair(it.first + it.second, it.first)},
                number)) {it.first}, ", ")


fun fiboCorecursiveBook(number: Int): String {
    val seed = Pair(BigInteger.ZERO, BigInteger.ONE)
    val f = { x: Pair<BigInteger, BigInteger> -> Pair(x.second, x.first + x.second) }
    val listOfPairs = iterate(seed, f, number)
    val list = map(listOfPairs) { p -> p.second }
    return makeString(list, ", ")
}


fun fibo(number: Int): String {
    tailrec fun fibo(acc: List<BigInteger>, acc1: BigInteger,
                     acc2: BigInteger, x: BigInteger): List<BigInteger> =
            when (x) {
                BigInteger.ZERO -> acc
                BigInteger.ONE -> acc + (acc1 + acc2)
                else -> fibo(acc + (acc1 + acc2), acc2, acc1 + acc2,
                        x - BigInteger.ONE)
            }
    val list = fibo(listOf(),
            BigInteger.ONE, BigInteger.ZERO, BigInteger.valueOf(number.toLong()))
    return makeString(list, ", ")
}
