import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import Foo
import org.junit.jupiter.api.assertThrows
import java.lang.RuntimeException
import Foo as Bar

class Tests {
    @Test fun numbers() {
        val a: Int = 1000
        // assertEquals(//expected, a == a)
        assertEquals(true, a == a)

        val boxedA: Int? = a
        val anotherBoxedA: Int? = a

        assertEquals(true, boxedA == anotherBoxedA)
        assertEquals(false, boxedA === anotherBoxedA)
    }

    @Test fun `bit operations`() {
        // val x = (1 << 2) & 0x01
        val x = (1 shl 2) and 0x01

        assertEquals(0, x)
    }

    @Test fun arrays() {
        // val a = // create array with values [0, 1, 2]
        val a = arrayOf(0, 1, 2)

        assertEquals(3, a.size)

        // val b = create array with values [0, 2, 4, .... , 1998]
        val b = Array(1000) { it * 2 }

        assertEquals(1000, b.size)
        // assertEquals(/* get second value of array b */, 2)
        assertEquals(2, b[1])
    }

    @Test fun strings() {
        val s = "string"

        // assertEquals('t', /* get second letter of string */)
        assertEquals('t', s[1])

        var sum = 0
        // get sum of chars in s
        for (c in s) { sum += c.toInt() }

        assertEquals(663, sum)

        // val rawString = /* multiline string without \n */
        val rawString = """
        |line 1
        |line 2
        """.trimMargin()

        assertEquals("line 1\nline 2", rawString)

        val n1 = 1
        val n2 = 2
        // val sumString = /* create sum string without '+' */
        val sumString = "$n1 + $n2 = ${n1 + n2}"
        assertEquals("1 + 2 = 3", sumString)
    }

    @Test fun imports() {
        val f = Foo()
        assertEquals(3, f.getThree())

        // val b = /* Use Foo with a name Bar */
        val b = Bar()
        assertEquals(3, b.getThree())
    }

    @Test fun `if expression`() {
        // val age = /* your age */
        val age = 34
        // val status = /* "young" if age is under 30, otherwise "old"
        val status = if (age > 30) "old" else "young"

        assertEquals("old", status)
    }

    @Test fun `for loops`() {
        val sList = arrayOf("a", "b", "c")

        // iterate
        for (s in sList) {
            println(s)
        }

        // iterate with indices
        for (i in sList.indices) {
            println(sList[i])
        }

        // iterate with indices and values
        for ((i, s) in sList.withIndex()) {
            println("$i = $s")
        }

        // 1 ~ 10
        for (i in 1..10) {
            println(i)
        }

        // 1 3 5 7 9
        for (i in 1 until 10 step 2) {
            println(i)
        }

        // 9 6 3
        for (i in 9 downTo 3 step 3) {
            println(i)
        }
    }

    @Test fun `when expression`() {
        val age = 34

        // val status = /* 25~26(very young), 27~29(young), 30(normal), 31~49(old), 50~(wise) /   */
        val status = when (age) {
            25, 26 -> "very young"
            in 27..29 -> "young"
            30 -> "normal"
            in 31 until 50 -> "old"
            else -> when {
                age >= 50 -> "wise"
                else -> "unknown"
            }
        }

        assertEquals("old", status)
    }

    @Test fun `break and continue labels`() {
        var cnt = 0

        loop@ for (i in 1..10) {
            for (j in 1..10) {
                cnt++

                if (i == 1 && j == 1) {
                    // finish
                    break@loop
                }
            }
        }

        assertEquals(1, cnt)
    }

    @Test fun `return at labels`() {
        assertThrows<RuntimeException> {
            listOf(1, 2, 3).forEach lit@{
                if (it == 1) {
                    /* return */
                    return@lit
                    assert(false)
                }
            }

            run block@{
                listOf(1, 2, 3).forEach {
                    if (it == 1) {
                        /* return */
                        return@block
                    }
                    assert(false)
                }
            }

            throw RuntimeException()
        }
    }
}