package com.kodeinc.conway.ascii

import com.kodeinc.conway.MapInterface
import com.kodeinc.conway.algorithm.CellMap
import com.kodeinc.conway.algorithm.isAlive
import java.io.BufferedReader
import java.io.InputStreamReader

private fun drawMap(map: CellMap, prefix: String = "     ", spacingH: Int = 1, spacingV: Int = 1): String {
    val sb = StringBuilder()
    val spaceStringH = " ".repeat(spacingH)
    val spaceStringV = "\n".repeat(spacingV)
    with(sb) {
        for (y in 0..(map.h - 1)) {
            for (x in 0..(map.w - 1)) {
                append(if (x == 0) prefix else spaceStringH)
                append(if (isAlive(map.cell(x, y))) '*' else '.')
            }
            append(if (y < (map.h - 1)) spaceStringV else "\n")
        }
    }
    return sb.toString()
}

private fun drawHeader(generation: Int, map: CellMap, prefix: String = "     ", spacingH: Int = 1): String {
    val prefixString = "$prefix::: Conway "
    val suffixString = " generation $generation :::"
    val centerWidth = (map.w * (spacingH + 1)) - (prefixString.length + suffixString.length)
    val centerString = if (centerWidth > 0) "-".repeat(centerWidth) else ""
    return "$prefixString$centerString$suffixString\n\n"
}

fun drawScreen(cellMap: CellMap, generation: Int) {
    print("\u000C")
    print(drawHeader(generation, cellMap))
    print(drawMap(cellMap))
}

class AsciiMapDrawer(startingMap: CellMap? = null): MapInterface(startingMap = startingMap) {

    private val console: BufferedReader = BufferedReader(System.console()?.reader() ?: InputStreamReader(System.`in`))

    override fun drawMap(m: CellMap, g: Int) {
        drawScreen(m, g)
    }

    override fun waitForHuman(): Boolean {
        print("? ")
        return console.readLine() != "q"
    }
}