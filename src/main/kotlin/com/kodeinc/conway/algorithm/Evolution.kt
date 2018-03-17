package com.kodeinc.conway.algorithm

/*

"B3/S23":
* Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
* Any live cell with two or three live neighbours lives on to the next generation.
* Any live cell with more than three live neighbours dies, as if by overpopulation.
* Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

 */

typealias MapFiller = (x: Int, y: Int, map: CellMap?) -> Cell

private fun evolveCellB3S23(x: Int, y: Int, map: CellMap?): Cell {
    return if (map == null) {
        DEAD_CELL
    } else {
        when (map.countCellNeighbors(x, y)) {
            3 -> LIVE_CELL
            2 -> map.cell(x, y)
            else -> DEAD_CELL
        }
    }
}

fun evolveMapB3S23(map: CellMap) = evolveMap(map, ::evolveCellB3S23)
