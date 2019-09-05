package com.fpinkotlin.functions.exercise04


class Functions

fun square(n: Int) = n * n

fun triple(n: Int) = n * 3

//fun <T, U, V> compose(f: (U) -> V, g: (T) -> U): (T) -> V = { f(g(it)) }

typealias IntUnaryOp = (Int) -> Int

val add: (Int) -> (Int) -> Int = { a -> { b -> a + b } }

// Define a value function composing two (Int) -> Int functions
val compose: (IntUnaryOp) -> (IntUnaryOp) -> IntUnaryOp = { a -> { b -> { x -> a(b(x)) } } }

val squareVal: (Int) -> Int = { it * it }
val tripleVal: (Int) -> Int = {it*3}
val squareOfTriple = compose(squareVal)(tripleVal)