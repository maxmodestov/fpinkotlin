package com.fpinkotlin.recursion.exercise02

typealias FactorialFun = (Int) -> Int

object Factorial {
    val factorial: FactorialFun by lazy<FactorialFun> { { n -> if (n <= 1) n else n * factorial(n - 1) } }
}