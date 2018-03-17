package com.kodeinc.conway

import com.kodeinc.conway.algorithm.Coord
import com.kodeinc.conway.ascii.AsciiMapDrawer

const val DEF_WIDTH = 50
const val DEF_HEIGHT = 49

val glider = displayList {
    listOf(Coord(1,0),
            Coord(2,1),
            Coord(0,2),
            Coord(1,2),
            Coord(2,2))
}

fun main(args: Array<String>) {
    val drawer = AsciiMapDrawer(glider)

    do {
        drawer.nextMap()
    } while (drawer.waitForHuman())
}