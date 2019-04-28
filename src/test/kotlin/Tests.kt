import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.assertThrows
import java.lang.RuntimeException

class Tests {
    @Test fun numbers() {
        val a: Int = 1000
        assertEquals(/* true or false */,a == a)

        val boxedA: Int? = a
        val anotherBoxedA: Int? = a

        assertEquals(/* true or false */,boxedA == anotherBoxedA)

        assertEquals(/* true or false */,boxedA === anotherBoxedA)
    }

    @Test fun `bit operations`() {
        val x = /* (1 << 2) & 0x01 */

        assertEquals(0, x)
    }

    @Test fun arrays() {
        val a = /* create array with values [0, 1, 2] */

        assertEquals(3, a.size)

        val b = /* create array with values [0, 2, 4, .... , 1998] */

        assertEquals(1000, b.size)
        assertEquals(/* get second value of array b */, 2)
        assertEquals(2, b[1])
    }

    @Test fun strings() {
        val s = "string"

        assertEquals('t', /* get second letter of string */)

        var sum = 0
        // get sum of chars in s

        assertEquals(663, sum)

        val rawString = /* multiline string without \n */

        assertEquals("line 1\nline 2", rawString)

        val n1 = 1
        val n2 = 2

        val sumString = /* create sum string without '+' */
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
        val age = /* your age */
        val status = /* "young" if age is under 30, otherwise "old" */

        assertEquals("old", status)
    }

    @Test fun `for loops`() {
        val sList = arrayOf("a", "b", "c")

        // iterate

        // iterate with indices

        // iterate with indices and values

        // 1 ~ 10

        // 1 3 5 7 9

        // 9 6 3
    }

    @Test fun `when expression`() {
        val age = 34

        val status = /* 25~26(very young), 27~29(young), 30(normal), 31~49(old), 50~(wise) */

        assertEquals("old", status)
    }

    @Test fun `break and continue labels`() {
        var cnt = 0

        for (i in 1..10) {
            for (j in 1..10) {
                cnt++

                if (i == 1 && j == 1) {
                    // finish
                }
            }
        }

        assertEquals(1, cnt)
    }

    @Test fun `return at labels`() {
        assertThrows<RuntimeException> {
            listOf(1, 2, 3).forEach {
                if (it == 1) {
                    /* return */
                    assert(false)
                }
            }


            listOf(1, 2, 3).forEach {
                if (it == 1) {
                    /* return */
                }
                assert(false)
            }

            throw RuntimeException()
        }
    }
}