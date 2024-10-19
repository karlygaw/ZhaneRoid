package kz.narxoz.android1

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyApp(onRouteChange: (String) -> Unit) {
    val navController = rememberNavController()

    navController.addOnDestinationChangedListener { _, destination, _ ->
        onRouteChange(destination.route ?: "")
    }

    NavHost(navController, startDestination = "list") {
        composable("list") {
            MedicalStyleList(navController = navController)
        }
        composable("detail/{title}/{description}/{date}") { backStackEntry ->
            DetailScreen(
                title = backStackEntry.arguments?.getString("title") ?: "",
                description = backStackEntry.arguments?.getString("description") ?: "",
                date = backStackEntry.arguments?.getString("date") ?: ""
            )
        }
    }
}

