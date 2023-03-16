package com.example.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry

typealias DestinationRoute = String

interface NavNode {
    val route: String
    val arguments: List<NamedNavArgument>
}
interface NavDestination<Arg> {
    fun destination(arg: Arg): DestinationRoute
    fun parse(entry: NavBackStackEntry): Arg
}
abstract class NoArgsScreen : NavNode, NavDestination<Unit> {
    override val arguments: List<NamedNavArgument> = emptyList()
    override fun destination(arg: Unit): DestinationRoute = route
    override fun parse(entry: NavBackStackEntry) {}
}