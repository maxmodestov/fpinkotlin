package com.fpinkotlin.recursion.exercise03

import java.math.BigInteger

fun fibNaive(x: Int): BigInteger =
    if (x == 0 || x == 1)
        BigInteger.ONE
    else
        fibNaive(x - 1) + fibNaive(x - 2)

fun fib(x: Int): BigInteger {
    tailrec fun fib(val1: BigInteger, val2: BigInteger, x: BigInteger): BigInteger =
            when {
                (x == BigInteger.ZERO) -> BigInteger.ONE
                (x == BigInteger.ONE) -> val1 + val2
                else -> fib(val2, val1 + val2, x - BigInteger.ONE)
            }

    return fib(BigInteger.ZERO, BigInteger.ONE, BigInteger.valueOf(x.toLong()))
}
