package com.fpinkotlin.functions.exercise05


class Functions

fun square(n: Int) = n * n

fun triple(n: Int) = n * 3

fun <T, U, V> compose(f: (U) -> V, g: (T) -> U): (T) -> V = { f(g(it)) }

val add: (Int) -> (Int) -> Int = { a -> { b -> a + b } }

val compose = { x: (Int) -> Int -> { y: (Int) -> Int -> { z: Int -> x(y(z)) } } }

// Define a value function composing two (Int) -> Int functions
fun <T, U, V> higherCompose(): ((U) -> T) -> ((V) -> U) -> (V) -> T = { f -> { g -> { x -> f(g(x)) } } }

