package com.tirexmurina.nonsingleton

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
import com.tirexmurina.nonsingleton.screen.EditScreen
import com.tirexmurina.nonsingleton.screen.HomeScreen
import com.tirexmurina.nonsingleton.ui.theme.NonSingletonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NonSingletonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NonSingletonApp()
                }
            }
        }
    }
}

@Composable
fun NonSingletonApp(){
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
