package com.example.easiercompose

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.easiercompose.destinations.ExitScreenDestination
import com.example.easiercompose.destinations.ProfileScreenDestination
import com.example.easiercompose.destinations.SettingScreenDestination
import com.example.easiercompose.ui.theme.EasierComposeTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasierComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    DestinationsNavHost(navGraph = NavGraphs.root)

                }
            }
        }
    }
}

@Destination(start = true)
@Composable
fun WelcomeScreen(
    navigator: DestinationsNavigator,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Button(onClick = {
            navigator.navigate(
                ProfileScreenDestination(
                    User(
                        name = "John",
                        uid = "56", created = LocalDateTime.now()
                    )
                )
            )
        }) {
            Text(text = "Welcome")

        }
    }
}


@Destination
@Composable
fun ProfileScreen(
    navigator: DestinationsNavigator,
    user: User,
) {
    Text(text = "Welcome to the Home Page")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Button(onClick = {
            navigator.navigate(
                SettingScreenDestination(
                    User(
                        name = "John",
                        uid = "56", created = LocalDateTime.now()
                    )
                )
            )
        }) {
            Image(painter = painterResource(id = R.drawable.next), contentDescription = null)
            Text(text = "Go to Screen Next")

        }
    }
}


@Destination
@Composable
fun SettingScreen(
    navigator: DestinationsNavigator,
    user: User,
) {
    Text(text = "Modify your settings here")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Button(onClick = {
            navigator.navigate(ExitScreenDestination())
        }) {
            Text(text = "Welcome")
            Image(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = null
            )

        }
    }
}


@Destination
@Composable
fun ExitScreen(
    navigator: DestinationsNavigator,
    showOnlyPostByUser: Boolean = false,
) {
    Text(text = "Personal Details")
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(onClick = {

        }) {
            Text(text = "Go back,$showOnlyPostByUser")
            Image(
                painter = painterResource(id = R.drawable.navigatebefore),
                contentDescription = null
            )
        }
    }
}