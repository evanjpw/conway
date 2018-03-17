# Conway

A dumb little implementation of Conway's Game of Life.

It was written because:
* I have asked interview candidates to write the core algorithm for me on the whiteboard, but it has been a while since I wrote my own implementation
* I am teaching myself Kotlin and this was a circumscribed project
* I felt like it

It is designed to have pluggable rules, with the normal B3S23 provided
as the default.

Currently it has a charming, old school (lazy) character mode UI. But
that is also pluggable and I may expand things.

In general, long exposure to Java causes me to proliferate packages
and files that are less ideal for Kotlin. I am working on that.

As written, the Cell type is just a typealias for Boolean, for efficiency.
I used constants and a function that does nothing to abstract this.
