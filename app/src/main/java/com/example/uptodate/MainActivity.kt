package com.example.uptodate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.favourites.FavoritesScreen
import com.example.home.HomeScreen
import com.example.navigation.NavigationRoot
import com.example.navigation.Navigator
import com.example.uptodate.ui.theme.UpToDateTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("shetty ${navigator}")

        setContent {
            Surface(modifier = Modifier.fillMaxSize()) {
                BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
                    NavigationRoot(
                        navigator = navigator,
                        home = {
                            HomeScreen()
                        },
                        favorites = {
                            FavoritesScreen()
                        }
                    )
                }
            }

        }
    }

}
