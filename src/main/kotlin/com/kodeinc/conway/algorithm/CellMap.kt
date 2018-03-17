package com.kodeinc.conway.algorithm

private fun emptyMapFun(x: Int, y: Int, map: CellMap? = null) = DEAD_CELL

internal enum class CellDirection {
    NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST;
}

data class Coord(val x: Int, val y: Int)

class CellMap(val w: Int, val h: Int, oldMap: CellMap? = null, mapFiller: MapFiller = ::emptyMapFun) {

    constructor(oldMap: CellMap, mapFiller: MapFiller): this(oldMap.w, oldMap.h, oldMap, mapFiller)

    private val grid = Array(w, { x -> Array(h) { y-> mapFiller(x, y, oldMap) } })

    private fun safeX(x: Int) = x in 0..(w - 1)

    private fun safeY(y: Int) = y in 0..(h - 1)

    private fun safeCoord(x: Int, y: Int) = safeX(x) && safeY(y)

    fun cell(x: Int, y: Int) = if (safeCoord(x, y)) { grid[x][y] } else {
        DEAD_CELL
    }

    fun cell(coord: Coord) = cell(coord.x, coord.y)

    fun setCell(x: Int, y: Int, c: Cell) {
        if (safeCoord(x, y)) {
            grid[x][y] = c
        }
    }

    fun setCell(coord: Coord, c: Cell) = setCell(coord.x, coord.y, c)

    private fun interrogateNeighborLiveness(coord: Coord, direction: CellDirection, map: CellMap): Boolean {
        return interrogateNeighborLiveness(coord.x, coord.y, direction, map)
    }

    private fun interrogateNeighborLiveness(x: Int, y: Int, direction: CellDirection, map: CellMap): Boolean {
        return when (direction) {
            CellDirection.NORTH -> map.cell(x, y - 1)
            CellDirection.NORTHEAST -> map.cell(x + 1, y - 1)
            CellDirection.EAST -> map.cell(x + 1, y)
            CellDirection.SOUTHEAST -> map.cell(x + 1, y + 1)
            CellDirection.SOUTH -> map.cell(x, y + 1)
            CellDirection.SOUTHWEST -> map.cell(x - 1, y + 1)
            CellDirection.WEST -> map.cell(x - 1, y)
            CellDirection.NORTHWEST -> map.cell(x - 1, y - 1)
        }
    }

    fun countCellNeighbors(x: Int, y: Int): Int {
        return CellDirection.values().count { interrogateNeighborLiveness(x, y, it, this) }
    }
}

internal fun evolveMap(map: CellMap, evolver: MapFiller): CellMap {
    return CellMap(map, evolver)
}
