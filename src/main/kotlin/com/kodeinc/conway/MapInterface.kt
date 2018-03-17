package com.kodeinc.conway

import com.kodeinc.conway.algorithm.CellMap
import com.kodeinc.conway.algorithm.evolveMapB3S23

const val DEF_WIDTH = 50
const val DEF_HEIGHT = 50

typealias MapEvolver = (map: CellMap) -> CellMap

abstract class MapInterface(width: Int = DEF_WIDTH,
                            height: Int = DEF_HEIGHT,
                            startingMap: CellMap? = null,
                            private val evolver: MapEvolver = ::evolveMapB3S23) {
    protected var currentMap = startingMap ?: CellMap(width, height)
    protected var generation = 0

    protected abstract fun drawMap(m: CellMap, g: Int)

    fun nextMap() {
        generation++
        drawMap(currentMap, generation)
        currentMap = evolver(currentMap)
    }

    abstract fun waitForHuman(): Boolean
}
