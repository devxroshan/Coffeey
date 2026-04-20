package com.kewsoftware.coffeey

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.kewsoftware.coffeey.Screens.HomeScreen.HomeScreen
import com.kewsoftware.coffeey.Screens.LoginScreen.LoginScreen
import com.kewsoftware.coffeey.Screens.SignUpScreen.SignUpScreen
import com.kewsoftware.coffeey.ui.theme.CoffeeyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeeyTheme {
                App()
            }
        }
    }
}

enum class EScreen {
    LOGIN_SCREEN,
    SIGNUP_SCREEN,
    HOME_SCREEN,
    CART_SCREEN,
    WISHLIST_SCREEN,
    PROFILE_SCREEN
}

@Composable
fun App(){
    var screen by remember { mutableStateOf<EScreen>(EScreen.LOGIN_SCREEN) }

    when(screen){
        EScreen.LOGIN_SCREEN -> LoginScreen({ screen = EScreen.SIGNUP_SCREEN }, { screen = EScreen.HOME_SCREEN })
        EScreen.SIGNUP_SCREEN -> SignUpScreen({ screen = EScreen.LOGIN_SCREEN }, { screen = EScreen.HOME_SCREEN })
        EScreen.HOME_SCREEN -> HomeScreen()
        EScreen.PROFILE_SCREEN -> "Yet to be created."
        EScreen.CART_SCREEN -> "Yet to be created."
        EScreen.WISHLIST_SCREEN -> "Yet to be created."
    }
}

@Preview(showSystemUi = true)
@Composable
fun UIPreview(){
    CoffeeyTheme {
        App()
    }
}