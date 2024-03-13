package com.tirexmurina.singleton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tirexmurina.singleton.screen.EditScreen
import com.tirexmurina.singleton.screen.HomeScreen
import com.tirexmurina.singleton.ui.theme.SingletonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SingletonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SingletonApp()
                }
            }
        }
    }
}

@Composable
fun SingletonApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "notes"){
        composable("notes"){
            HomeScreen(
                onNoteClick = {noteId -> navController.navigate("note/${noteId}")}
            )
        }

        composable("note/{noteId}", arguments = listOf(navArgument("noteId"){
            type = NavType.StringType
        })){
            val noteId = remember {
                it.arguments?.getString("noteId")
            }
            EditScreen(
                id = noteId,
                backNavigation = {navController.navigate("notes")}
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SingletonTheme {
        //
    }
}