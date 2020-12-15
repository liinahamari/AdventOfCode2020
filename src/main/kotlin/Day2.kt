private const val INPUT = """
1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc
"""

object Day2 {
    @JvmStatic
    fun main(args: Array<String>) {
        day2section1()
        day2Section2()
    }

    private fun day2section1() {
        val list = INPUT.split("\n").filterNot { it.isEmpty() }.map { singleInput ->
            val args = "^(\\d+)-(\\d+)\\s+(\\w):\\s+(\\w+)$".toRegex().find(singleInput)!!.groups.map { it!!.value.trim() }.drop(1).toList()
            PolicyAndPassword(args[0].toInt(), args[1].toInt(), args[2][0], args[3])
        }
        println(list.filter { it.password.toCharArray().filter { char -> char == it.letter }.size in it.min..it.max }.size)
    }
}