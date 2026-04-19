package com.kewsoftware.coffeey.Screens.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kewsoftware.coffeey.ui.theme.CoffeeyTheme
import com.kewsoftware.coffeey.ui_components.Navbar
import com.kewsoftware.coffeey.R
import com.kewsoftware.coffeey.ui_components.CoffeeCard


data class Coffee(val coffeeName: String, val coffeeDescription: String, val price: String)

val coffeeCategory = listOf<String>("All", "Black Coffee", "Latte", "Esperosso", "Something", "Other Coffee", "Another Coffee")

val coffees = listOf<Coffee>(
    Coffee("Black Coffee", "This is a black coffee.", "9.99"),
    Coffee("Espresso", "Unknown coffee type to me.", "12.99"),
    Coffee("Just Coffee", "Ye hai just coffee.", "99.99")
)



@Composable
fun HomeScreen(){
    Scaffold(topBar = { Topbar() }, bottomBar = { Navbar() }) { innerPadding ->
        Column(Modifier.padding(innerPadding).fillMaxSize().background(
        Brush.verticalGradient(
            0.0f to Color.Black,
            0.5f to MaterialTheme.colorScheme.background
        )
    )) {
        Spacer(Modifier.height(30.dp))

//        Offer Card
        Box(Modifier.fillMaxWidth().padding(horizontal = 12.dp)){
            Box(Modifier.fillMaxWidth().height(160.dp).clip(RoundedCornerShape(18.dp)).background(
                MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(18.dp)
            )){
                Image(painterResource(R.drawable.coffee_bg), contentDescription = null, Modifier.fillMaxSize(), contentScale = ContentScale.Crop, alignment = Alignment.Center)
                Box(Modifier.fillMaxSize().background(
                    brush = Brush.horizontalGradient(
                        0.0f to Color.Black.copy(0.8f),
                        0.6f to MaterialTheme.colorScheme.background.copy(0.5f)
                    )
                )){
                    Column(Modifier.fillMaxSize().padding(horizontal = 20.dp, vertical = 12.dp), horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.SpaceBetween) {
                        Text("Promo", Modifier.background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(10.dp)).padding(horizontal = 20.dp, vertical = 4.dp), fontSize = 18.sp, fontWeight = FontWeight.SemiBold)

                        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
                            Text("Buy One Get", fontSize = 27.sp, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.height(6.dp))
                            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.Bottom) {
                                Text("One", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                                Spacer(Modifier.width(8.dp))
                                Text("Free", fontSize = 38.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.secondary)
                            }
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(18.dp))

//        Coffee Categories
        LazyRow(Modifier.fillMaxWidth().padding(horizontal = 12.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(coffeeCategory.size){ index ->
                val item = coffeeCategory[index]

                TextButton(
                    onClick = {},
                    shape = RoundedCornerShape(7.dp),
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 0.dp),
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.height(29.dp)
                ) {
                    Text(
                        item,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        Spacer(Modifier.height(18.dp))

//        Available Coffees List
        LazyColumn(Modifier.fillMaxSize().padding(bottom = 20.dp).padding(horizontal = 12.dp), verticalArrangement = Arrangement.spacedBy(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            items(coffees){ coffee ->
                CoffeeCard(
                    R.drawable.coffee_bg,
                    coffee.coffeeName,
                    coffee.coffeeDescription,
                    coffee.price
                )
            }
        }
    } }
}

@Composable
fun Topbar(){
    var searchItem by remember { mutableStateOf("") }

    Column(Modifier.fillMaxWidth().padding(top = 12.dp, start = 12.dp, end = 12.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start) {
        Column {
            Text("Location", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.SemiBold)
            Text("Parnoshree Lakh..Blahhhhhhh", color = Color.White)
        }

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = searchItem,
            onValueChange = { searchItem = it },
            modifier = Modifier
                .fillMaxWidth().height(51.dp),
            shape = RoundedCornerShape(16.dp),
            placeholder = { Text("Search...", color = MaterialTheme.colorScheme.onSurface) },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onSurface,
                focusedTextColor = Color.White,
                focusedBorderColor = MaterialTheme.colorScheme.outline,
                unfocusedBorderColor = MaterialTheme.colorScheme.outline
            ),
            singleLine = true,
            textStyle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color.White),
            trailingIcon = {
                IconButton(onClick = {}, modifier = Modifier.fillMaxHeight().width(30.dp).background(
                    MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
                )) {
                    Icon(
                        painterResource(R.drawable.search_icon), contentDescription = null, Modifier.height(20.dp).width(20.dp),
                        tint = Color.White
                    )
                }
            }
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun UIPreview(){
    CoffeeyTheme() {
        HomeScreen()
    }
}
