package com.kewsoftware.coffeey.Screens.LoginScreen

import android.widget.Button
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kewsoftware.coffeey.R
import com.kewsoftware.coffeey.ui.theme.CoffeeyTheme
import java.nio.file.WatchEvent


@Composable
fun LoginScreen(navigateToSignUp: () -> Unit){
    var usernameOrEmail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box (modifier = Modifier.fillMaxSize())
    {
        Image(painterResource(R.drawable.coffee_bg), contentScale = ContentScale.Crop, contentDescription = null, modifier = Modifier.fillMaxSize())

        Box(modifier = Modifier.fillMaxSize().background(
            Brush.verticalGradient(
                0.0f to Color.Black.copy(alpha = 0.4f),
                0.6f to Color.Black.copy(alpha = 0.8f),
                1.0f to Color.Black.copy(alpha = 0.9f)
            )
        ))

        Column(modifier = Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            CustomOutlineTextField("Username or Email", isPassword = false, fieldValue = usernameOrEmail, onValueChange = { usernameOrEmail = it })
            Spacer(modifier = Modifier.height(3.dp))
            CustomOutlineTextField("Password", isPassword = true, fieldValue = password, onValueChange = { password = it })
            Spacer(modifier = Modifier.height(2.dp))
            TextButton(
                onClick = {  },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    text = "Forgot Password?",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Button(onClick = {}, modifier = Modifier.fillMaxWidth().height(52.dp), shape = RoundedCornerShape(12.dp)){
                Text("Login", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            }

            Spacer(modifier = Modifier.height(52.dp))


            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                HorizontalDivider(modifier = Modifier.clip(RoundedCornerShape(12.dp)).background(MaterialTheme.colorScheme.surfaceVariant).width(120.dp), thickness = 4.dp)

                Text(" OR ", color = MaterialTheme.colorScheme.onSurface, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)

                HorizontalDivider(modifier = Modifier.clip(RoundedCornerShape(12.dp)).background(MaterialTheme.colorScheme.surfaceVariant).width(120.dp), thickness = 4.dp)
            }

            Spacer(modifier = Modifier.height(52.dp))

            Button(onClick = {}, modifier = Modifier.fillMaxWidth().height(52.dp).border(
                BorderStroke(3.dp, MaterialTheme.colorScheme.primary),
                shape = RoundedCornerShape(12.dp)
            ), colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ), shape = RoundedCornerShape(12.dp)) {
                Text("Continue With Google", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(50.dp))

            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                Text("Don't have an account?", color = Color.White)
                TextButton(onClick = navigateToSignUp) {
                    Text("Sign Up", fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
                }
            }
        }
    }
}


@Composable
fun CustomOutlineTextField(
    placeholder: String,
    isPassword: Boolean,
    fieldValue: String,
    onValueChange: (String) -> Unit
){
    var isPasswordVisible by remember { mutableStateOf(false) }

    if(isPassword){
        OutlinedTextField(
            value = fieldValue,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            placeholder = { Text(placeholder, color = MaterialTheme.colorScheme.onSurface) },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onSurface,
                focusedTextColor = Color.White
            ),
            visualTransformation = if(isPasswordVisible)
                VisualTransformation.None  else
                PasswordVisualTransformation()
        )
    }else {
        OutlinedTextField(
            value = fieldValue,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            placeholder = { Text(placeholder, color = MaterialTheme.colorScheme.onSurface) },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onSurface,
                focusedTextColor = Color.White
            )
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginPreview(){
    CoffeeyTheme {
        LoginScreen({ true } )
    }
}