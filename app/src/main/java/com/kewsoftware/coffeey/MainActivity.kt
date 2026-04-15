package com.kewsoftware.coffeey

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.kewsoftware.coffeey.Screens.LoginScreen.LoginScreen
import com.kewsoftware.coffeey.Screens.SignUpScreen.SignUpScreen
import com.kewsoftware.coffeey.ui.theme.CoffeeyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeeyTheme {
                Authentication()
            }
        }
    }
}

@Composable
fun Authentication(){
    var isSignUpScreen by remember { mutableStateOf(true) }

    if(isSignUpScreen){
        SignUpScreen(){ isSignUpScreen = false }
    }else {
        LoginScreen(){ isSignUpScreen = true }
    }
}

@Preview(showSystemUi = true)
@Composable
fun UIPreview(){
    CoffeeyTheme {
        Authentication()
    }
}