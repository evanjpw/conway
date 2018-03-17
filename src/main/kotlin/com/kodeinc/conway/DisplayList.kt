package com.kodeinc.conway

import com.kodeinc.conway.algorithm.*

fun displayList(width: Int = DEF_WIDTH, height: Int = DEF_HEIGHT, getCoords: () -> List<Coord>): CellMap {
    val coords = getCoords()

    fun mapFiller(x: Int, y: Int, map: CellMap?): Cell {
        val coord = Coord(x, y)
        return if (coord in coords) LIVE_CELL else DEAD_CELL
    }

    return CellMap(width, height, mapFiller = ::mapFiller)
}
