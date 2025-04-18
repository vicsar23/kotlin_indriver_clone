package com.vicsar23.indriverclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vicsar23.indriverclone.presentation.navigation.graph.root.RootNavGraph
import com.vicsar23.indriverclone.presentation.screes.auth.login.LoginScreen
import com.vicsar23.indriverclone.ui.theme.IndriverCloneTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndriverCloneTheme {
                Surface {
                    navController = rememberNavController()
                    RootNavGraph(navHostController = navController)
                }
            }
        }
    }
}
