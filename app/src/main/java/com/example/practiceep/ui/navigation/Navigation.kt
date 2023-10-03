package com.example.practiceep.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practiceep.ui.explorer.activities.browser.ProductBrowser


sealed class Routes(val route: String) {
    object ProductBrowser : Routes("ProductBrowser")
}

@Composable
fun Navigation() {
    val navController = rememberNavController();

    NavHost(
        navController = navController,
        startDestination = Routes.ProductBrowser.route
    ) {

        composable(Routes.ProductBrowser.route) {
            ProductBrowser();
        }

    }
}