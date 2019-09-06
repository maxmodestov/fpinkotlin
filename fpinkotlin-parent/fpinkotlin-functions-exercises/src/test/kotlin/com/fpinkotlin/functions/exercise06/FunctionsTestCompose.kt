package com.fpinkotlin.functions.exercise06


import org.junit.Test

class FunctionsTestCompose {
    @Test
    fun testHigherCompose() {
        val f: (Double) -> Int = { a -> (a * 3).toInt() }
        val g: (Long) -> Double = { a -> a + 2.0 }
        assert(Integer.valueOf(9) == f(g(1L)))
        assert(Integer.valueOf(9) == higherCompose<Long, Double, Int>()(f)(g)(1L))
    }

    @Test
    fun testHigherComposeAndThen() {
        val f: (Int) -> Long = { a -> (a * 3).toLong() }
        val g: (Long) -> Double = { a -> a + 2.0 }
        assert(5.0 == g(f(1)))
        assert(5.0 == higherAndThen<Int, Long, Double>()(f)(g)(1))
    }
}

