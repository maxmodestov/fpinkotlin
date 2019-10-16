package com.fpinkotlin.recursion.exercise05

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
    tailrec fun foldLeft(input: List<T>, res: U): U =
            if (input.isEmpty())
                res
            else
                foldLeft(input.tail(), f(res, input.head()))
    return foldLeft(list, z)
}

fun sum(list: List<Int>): Int = foldLeft(list, 0, Int::plus)

fun string(list: List<Char>): String = foldLeft(list, "", String::plus)

fun <T> makeString(list: List<T>, delim: String) =
//        foldLeft(list, "") { s, t -> if (s.isEmpty()) "$t" else "$s$delim$t" }
        if (list.isEmpty())
            ""
        else
            foldLeft(list.tail(), "${list.head()}", { res, v -> "$res$delim$v" })
