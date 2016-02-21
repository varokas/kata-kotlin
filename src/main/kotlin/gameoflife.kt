package com.varokas.kata

import com.varokas.kata.State.*

enum class State { LIVE, DEAD }

data class Point(val x:Int, val y:Int)
data class Cell(val point:Point, val state:State)

private fun isLive(state: State) = (state == LIVE)

private fun neighbours(point: Point) = neighbours(point.x, point.y)
private fun neighbours(x:Int, y:Int) = listOf(
    Point(x-1, y-1), Point(x  , y-1), Point(x+1, y-1),
    Point(x-1, y  ),                  Point(x+1, y  ),
    Point(x-1, y+1), Point(x  , y+1), Point(x+1, y+1)
)

fun countNeighbours(lives: Set<Point>, point: Point): Int {
    return neighbours(point)
            .filter { lives.contains(it) }
            .count()
}

fun nextCellState(state: State, neighbours: Int): State = when(state) {
    LIVE -> when(neighbours) {
        2,3  -> LIVE
        else -> DEAD
    }
    DEAD -> when(neighbours) {
        3    -> LIVE
        else -> DEAD
    }
}


fun nextState(present: Set<Point>):Set<Point> {
    val cellsToCompute = present.flatMap{ p ->
        neighbours(p)
            .filter{ p -> !present.contains(p) }
            .map{ p -> Cell(p, DEAD) }
            .plus(Cell(p, LIVE))
    }

    return cellsToCompute
        .filter{ c ->
            isLive(
                nextCellState(c.state, countNeighbours(present, c.point))
            )
        }
        .map{ c -> c.point }
        .toSet()
}