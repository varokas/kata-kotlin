package com.varokas.kata

import org.junit.Test
import org.junit.Assert.*
import com.varokas.kata.State.*

class GameOfLifeTest {
    @Test fun liveCellWithFewerThanTwoNeighbourDies() {
        assertEquals(DEAD, nextCellState(LIVE, 0));
        assertEquals(DEAD, nextCellState(LIVE, 1));
    }

    @Test fun liveCellTwoThreeNeighbourLives() {
        assertEquals(LIVE, nextCellState(LIVE, 2));
        assertEquals(LIVE, nextCellState(LIVE, 3));
    }

    @Test fun liveCellMoreThanThreeNeighbourDies() {
        (4..9).forEach{ i -> assertEquals(DEAD, nextCellState(LIVE, i)); }
    }

    @Test fun deadCellWithThreeNeighbourLives() {
        assertEquals(LIVE, nextCellState(DEAD, 3));
    }

    @Test fun deadCellNotExactlyThreeNeighbourDies() {
        (0..9).filter{ it != 3 }
                .forEach{ i -> assertEquals(DEAD, nextCellState(DEAD, i )) };
    }

    @Test fun countNeighboursReturnsNumberOfNeigbours() {
        assertEquals(8,
            countNeighbours(
                setOf( Point(-1,-1), Point( 0,-1), Point(+1,-1),
                       Point(-1, 0), Point( 0, 0), Point(+1, 0),
                       Point(-1,+1), Point( 0,+1), Point(+1,+1)
                ),
                Point(0,0)
            )
        )
    }

    @Test fun countNeighboursReturnsNumberOfNeigboursEmpty() {
        assertEquals(0, countNeighbours( setOf(), Point(0,0) ))
    }

    @Test fun oneLifeGoesToDead() {
        val present = toLiveSet("x")
        val next = toLiveSet(".")

        assertEquals(next, nextState(present))
    }

    @Test fun deadWithThreeNeighboursGoesToLive() {
        val present = toLiveSet("""
        xx
        x.
        """)
        val next = toLiveSet("""
        xx
        xx
        """)
        assertEquals(next, nextState(present))
    }

    @Test fun stillLife() {
        val present = toLiveSet("""
        ....
        .xx.
        .xx.
        ....
        """)
        assertEquals(present, nextState(present))
    }

    private fun toLiveSet(s: String): Set<Point> {
       val lines = s
               .split("\n")
               .map{ it.trim() }
               .filter{ it.length > 0 }
       return lines.withIndex().flatMap{ line ->
           val y = line.index
           line.value.toCharArray().withIndex().flatMap { ch ->
               if(ch.value == 'x') setOf(Point(ch.index,y)) else setOf()
           }
       }.toSet()
    }
}