package com.fpinkotlin.functions.exercise02


fun square(n: Int) = n * n

fun triple(n: Int) = n * 3

// Define a generic compose. The exercise dos not consist in writing the implementation, but the signature.
fun <A, B, C> compose(first: (B) -> C, second: (A) -> B): (A) -> C = { first(second(it)) }
