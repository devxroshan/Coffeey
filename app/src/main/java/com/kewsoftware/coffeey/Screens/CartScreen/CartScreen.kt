package com.kewsoftware.coffeey.Screens.CartScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kewsoftware.coffeey.Screens.HomeScreen.Topbar
import com.kewsoftware.coffeey.ui.theme.CoffeeyTheme
import com.kewsoftware.coffeey.ui_components.Navbar
import com.kewsoftware.coffeey.R
import com.kewsoftware.coffeey.ui_components.CartCard

data class Coffee(val img: Int, val coffeeName: String, val coffeeDescription: String, var coffeeCount: Int)

val coffees = listOf<Coffee>(
    Coffee(R.drawable.coffee_bg, "Black Coffee", "Coffeee..", 0),
    Coffee(R.drawable.coffee_bg, "Black Coffee", "Coffeee..", 0),
    Coffee(R.drawable.coffee_bg, "Black Coffee", "Coffeee..", 0),
    Coffee(R.drawable.coffee_bg, "Black Coffee", "Coffeee..", 0)
)


@Composable
fun CartScreen(){
    Scaffold(
        bottomBar = { Navbar() }
    ) { innerPadding ->
        Column(Modifier.padding(innerPadding).padding(horizontal = 12.dp)) {
            Text("Cart", fontWeight = FontWeight.Bold, fontSize = 50.sp)

            Spacer(Modifier.height(8.dp))

            LazyColumn(Modifier.fillMaxWidth()) {
                items(coffees){ coffee ->
                    CartCard(coffee.img, coffee.coffeeName, coffee.coffeeDescription, coffee.coffeeCount, { coffee.coffeeCount++ }, { coffee.coffeeCount-- })
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun CartScreenPreview(){
    CoffeeyTheme {
        CartScreen()
    }
}

