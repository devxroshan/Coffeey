package com.kewsoftware.coffeey.ui_components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kewsoftware.coffeey.R
import com.kewsoftware.coffeey.ui.theme.CoffeeyTheme

@Composable
fun CartCard(
    img: Int,
    coffeeName: String,
    coffeeDescription: String,
    coffeeCount: Int,
    increaseCount: () -> Unit,
    decreaseCount: () -> Unit
){
    Box(Modifier.fillMaxWidth().height(130.dp).padding(horizontal = 8.dp, vertical = 6.dp).border(
        width = 2.dp,
        color = MaterialTheme.colorScheme.outline,
        shape = RoundedCornerShape(24.dp)
    ).background(
        color = MaterialTheme.colorScheme.tertiaryContainer,
        shape = RoundedCornerShape(24.dp)
    )){
        Row(Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 12.dp), verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Start) {
            Image(painterResource(img), contentDescription = null, modifier = Modifier.size(100.dp).clip(RoundedCornerShape(12.dp)).shadow(elevation = 8.dp), contentScale = ContentScale.Crop)

            Spacer(Modifier.width(6.dp))

            Column(Modifier.width(150.dp)) {
                Text(coffeeName, fontWeight = FontWeight.SemiBold, fontSize = 24.sp, color = Color.White)
                Text(coffeeDescription, fontSize = 12.sp, fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.onSurface)
            }

            Box(
                Modifier.fillMaxHeight().fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Row(
                    Modifier.fillMaxWidth().background(
                        color = MaterialTheme.colorScheme.secondary,
                        shape = RoundedCornerShape(10.dp)
                    ).padding(vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Box(
                        modifier = Modifier
                            .size(24.dp) // exact size you want
                            .clickable { if(coffeeCount > 0) decreaseCount() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.minus_icon),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    Text(coffeeCount.toString(), fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color.White)

                    Box(
                        modifier = Modifier
                            .size(24.dp) // exact size you want
                            .clickable { increaseCount() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.plus_icon),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview()
fun CartCardPreview(){
    var coffeeCount by remember { mutableStateOf(0) }

    CoffeeyTheme {
        CartCard(R.drawable.coffee_bg, "Black Coffee", "Coffeee..", coffeeCount, { coffeeCount++ }, { coffeeCount-- })
    }
}