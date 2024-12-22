package com.example.composenavigation.ui.navigation

import android.net.http.SslCertificate.saveState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.ui.navigation.MainDestinations.SNACK_DETAIL_ROUTE


//destination use in the app
object MainDestinations {
    const val HOME_ROUTE = "home"
    const val SNACK_DETAIL_ROUTE = "snack"
    const val SNACK_ID_KEY = "snackId"
    const val ORIGIN = "origin"
}

//Remember and Create an instance of [JetsnackNavController]
@Composable
fun rememberJetSnackAndNavController(
    navController: NavHostController = rememberNavController()
): JetsnackNavController = remember(navController) {
    JetsnackNavController(navController)
}


//Responsible for holding UI Navigation logic
@Stable
class JetsnackNavController(val navController: NavHostController) {

    fun upPress() {
        navController.navigateUp()
    }

    fun navigateToBottomAppBarRoute(route: String) {
        if (route != navController.currentDestination?.route) {
            navController.navigate(route) {
                launchSingleTop = true
                restoreState = true
                // Pop up backstack to the first destination and save state. This makes going back
                // to the start destination when pressing back in any other bottom tab.
                popUpTo(findStartDestination(navController.graph).id) {
                    saveState = true
                }
            }
        }
    }

    fun navigateTOSnackDetail(snackId: Long, origin:String, from: NavBackStackEntry){
        //In order to discard duplicated navigation events, we check the LifeCycle
        if (from.lifecycleIsResumed()) {
            navController.navigate("${SNACK_DETAIL_ROUTE}/$snackId?origin=$origin")
        }

    }

}

//If the lifeCycle is not resumed it means this NavBackStackEntry already processed a nav event.
// this is used to de-duplicate
private fun NavBackStackEntry.lifecycleIsResumed() = this.lifecycle.currentState == Lifecycle.State.RESUMED

private val NavGraph.startDestination: NavDestination? get() = findNode(startDestinationId)


//copied from similar function in NavigationUI
private tailrec fun findStartDestination(graph: NavDestination): NavDestination{
return if(graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}
