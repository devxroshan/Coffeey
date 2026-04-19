package com.kewsoftware.coffeey.ui_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kewsoftware.coffeey.ui.theme.CoffeeyTheme

data class NavigationItem(
    val name: String,
    val icon: ImageVector,
    val activeIcon: ImageVector
)

@Composable
fun Navbar(){
    val navigationItemsList = arrayListOf<NavigationItem>(
        NavigationItem("Home", Icons.Outlined.Home, Icons.Filled.Home),
        NavigationItem("Cart", Icons.Outlined.ShoppingCart, Icons.Filled.ShoppingCart),
        NavigationItem("Wishlist", Icons.Outlined.FavoriteBorder, Icons.Filled.Favorite),
        NavigationItem("Profile", Icons.Outlined.AccountCircle, Icons.Filled.AccountCircle)
    )

    var selectedItem by remember { mutableIntStateOf(0) }

    Box(Modifier.fillMaxWidth().padding(bottom = 20.dp), contentAlignment = Alignment.Center){
        Box(Modifier.width(360.dp).height(54.dp).background(
            MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(10.dp)
        ).border(
            BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
            shape = RoundedCornerShape(10.dp)
        )){
            Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {

                navigationItemsList.forEachIndexed { index, item ->
                    val isSelected = selectedItem == index

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .clickable { selectedItem = index },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = if (isSelected) item.activeIcon else item.icon,
                            contentDescription = item.name,
                            tint = if (isSelected) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                        if(isSelected) Text(
                            text = item.name,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun UIPreview(){
    CoffeeyTheme {
        Navbar()
    }
}