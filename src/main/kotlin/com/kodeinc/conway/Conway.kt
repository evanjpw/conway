package com.kodeinc.conway

import com.kodeinc.conway.ascii.AsciiMapDrawer

fun main(args: Array<String>) {
    val drawer = AsciiMapDrawer()

    do {
        drawer.nextMap()
    } while (drawer.waitForHuman())
}