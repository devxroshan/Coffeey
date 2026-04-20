package com.kewsoftware.coffeey.ui_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kewsoftware.coffeey.R
import com.kewsoftware.coffeey.ui.theme.CoffeeyTheme

@Composable
fun CoffeeCard(Img: Int, coffeeName: String, coffeeDescription:String, price: String){
    Box(Modifier
        .fillMaxWidth()
        .height(160.dp)
        .clip(RoundedCornerShape(16.dp))
        .border(
            width = 2.dp,
            color = MaterialTheme.colorScheme.outline,
            shape = RoundedCornerShape(16.dp)
        )
        .background(
            color = MaterialTheme.colorScheme.tertiaryContainer,
            shape = RoundedCornerShape(18.dp)
        )){
        Row(Modifier.fillMaxSize().padding(horizontal = 9.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Image(painterResource(R.drawable.coffee_bg), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.height(150.dp).width(150.dp).shadow(elevation = 6.dp).clip(
                RoundedCornerShape(12.dp)))

            Column(Modifier.fillMaxWidth().fillMaxHeight().padding(top = 12.dp), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top) {
                Row(Modifier.fillMaxWidth().height(32.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(coffeeName, fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White)

                    IconButton(onClick = {}) {
                        Icon(painterResource(R.drawable.add_to_wishlist_icon), contentDescription = null, Modifier.size(18.dp), tint = MaterialTheme.colorScheme.primary)
                    }
                }

                Text(coffeeDescription, color = MaterialTheme.colorScheme.onSurface, fontSize = 12.sp, fontWeight = FontWeight.Medium)


                    Text("$ $price", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)

                Spacer(Modifier.height(8.dp))

                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    TextButton(
                        onClick = {},
                        shape = RoundedCornerShape(6.dp),
                        contentPadding = PaddingValues(vertical = 0.dp, horizontal = 12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = Color.White
                        ),
                        modifier = Modifier.height(32.dp)
                    ) {
                        Text(
                            "Order Now",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 12.sp
                        )
                    }

                    TextButton(
                        onClick = {},
                        shape = RoundedCornerShape(6.dp),
                        contentPadding = PaddingValues(vertical = 0.dp, horizontal = 12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = MaterialTheme.colorScheme.primary
                        ),
                        modifier = Modifier.border(
                            width = 1.2.dp,
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(6.dp)
                        ).height(32.dp)
                    ) {
                        Text(
                            "Add to Cart",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CoffeeCardPreview(){
    CoffeeyTheme {
        CoffeeCard(R.drawable.coffee_bg, "Black Coffee", "Something about coffee", "9.99")
    }
}