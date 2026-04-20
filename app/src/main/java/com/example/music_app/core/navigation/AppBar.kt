package com.example.music_app.core.navigation
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.music_app.R
import com.example.music_app.feature.home.MainScreen
import com.example.music_app.feature.profile.ProfileScreen
import com.example.music_app.feature.splash.SplashScreen


@Composable
fun AppNav(){
    val navController = rememberNavController()
    val backStack by navController.currentBackStackEntryAsState()
    val currentRoute = backStack?.destination?.route
    val showBottomBar = currentRoute in bottomDestination.map { it.route }

    Scaffold(
        containerColor = Color.White,
        contentWindowInsets = WindowInsets(0),
        bottomBar = {
            if (showBottomBar) {
                BottomBar(navController = navController)
            }
        }
    ) {inner ->
        Box(Modifier.fillMaxWidth()
            .padding(inner)){
            NavHost(
                navController = navController,
                startDestination = "splash",
                modifier = Modifier.fillMaxWidth()

            ){
                composable("splash"){
                    SplashScreen (onStartClick = {
                        navController.navigate(Screen.Home.route){
                            popUpTo("splash"){inclusive = true}
                            launchSingleTop = true
                            restoreState = true
                        }
                    })

                }
                composable(Screen.Home.route){ MainScreen() }
                composable(Screen.Explorer.route){ PlaceholderScreen("Explorer") }
                composable(Screen.Bookmark.route){ PlaceholderScreen("Bookmark") }
                composable (Screen.Profile.route){ ProfileScreen(navController) }



            }
        }


    }


}

@Composable
fun PlaceholderScreen(name: String) {
    Box(modifier = Modifier.fillMaxSize().background(Color.White), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "$name Screen", color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "No data are available yet", color = Color.Gray)
        }
    }
}


sealed class Screen(val route: String, val icon: Int){
    data object Home:
            Screen("home", R.drawable.bottom_btn1)
    data object Explorer:
        Screen("explorer", R.drawable.bottom_btn2)
    data object Bookmark:
        Screen("bookmark", R.drawable.bottom_btn3)
    data object Profile:
        Screen("profile", R.drawable.bottom_btn4)
}


private val bottomDestination = listOf(
    Screen.Home,
    Screen.Explorer,
    Screen.Bookmark,
    Screen.Profile
)


@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
){
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentDest = backStackEntry?.destination
    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(4.dp)
          .clip(RoundedCornerShape(50.dp)),

    containerColor = colorResource(R.color.black),

        contentColor = Color.Transparent,
        tonalElevation = 0.dp

    ) {
        bottomDestination.forEach { screen ->
            val selected = currentDest?.hierarchy?.any{it.route == screen.route} == true
            NavigationBarItem(
                selected = selected,
                onClick = {navController.navigate(screen.route){
                    popUpTo(navController.graph.findStartDestination().id){ saveState  = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },icon = {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .background(if (selected) colorResource(R.color.blue) else Color.Transparent),
                        contentAlignment = Alignment.Center
                    ){
                        Image(
                            painter = painterResource(screen.icon),
                            contentDescription = null,
                            modifier= Modifier.size(20.dp)
                        )

                    }
                },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = Color.Unspecified,
                    unselectedIconColor = Color.Unspecified

                )
            )
        }
    }

}

@Preview
@Composable
fun BottomBarPreview(){
    val navController = rememberNavController()
    BottomBar(navController = navController)
}
