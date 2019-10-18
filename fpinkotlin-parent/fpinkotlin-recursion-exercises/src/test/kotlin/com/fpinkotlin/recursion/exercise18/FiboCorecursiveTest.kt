package com.fpinkotlin.recursion.exercise18

import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class FiboCorecursiveTest : StringSpec() {

    init {

        "fibonacci" {
            forAll(100, Gen.choose(3, 300)) { n ->
                fiboCorecursive(n - 1) == fiboCorecursive(n).substringBeforeLast(",")
            }
        }

        "fibonacci proper test" {
            forAll(100, Gen.choose(3, 300)) { n ->
                fiboCorecursive(n) == fibo(n)
            }
        }

        "fibonacci compare with book" {
            forAll(100, Gen.choose(3, 300)) { n ->
                fiboCorecursive(n) == fiboCorecursiveBook(n)
            }
        }

        "fibonacci compare book with book" {
            forAll(100, Gen.choose(3, 300)) { n ->
                fiboCorecursiveBook(n) == fibo(n)
            }
        }
    }
}