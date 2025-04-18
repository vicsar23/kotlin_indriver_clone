package com.vicsar23.indriverclone.presentation.screes.auth.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.vicsar23.indriverclone.R
import com.vicsar23.indriverclone.presentation.components.DefaulTextField
import com.vicsar23.indriverclone.presentation.components.DefaultButton
import com.vicsar23.indriverclone.presentation.navigation.screens.auth.AuthScreen

@Composable
fun LoginContent(navHostController: NavHostController, paddingValues: PaddingValues) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF083279),
                        Color(0xFF216FF3)
                    )
                )
            )
            .padding(paddingValues)
    ){
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "Login", fontWeight = FontWeight.ExtraBold,color = Color.White, fontSize = 27.sp, modifier = Modifier
                .rotate(degrees = 90f)
                .padding(top = 2.dp))
            Spacer(modifier = Modifier.height(150.dp))
            Text(text = "Registro", color = Color.White, fontSize = 27.sp,  modifier = Modifier
                .rotate(degrees = 90f)
                .padding(top = 30.dp)
                .clickable {
                    navHostController.navigate(route = AuthScreen.Register.route)
                })
            Spacer(modifier = Modifier.height(150.dp))

        }
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(start = 60.dp, bottom = 35.dp, top = 40.dp)
        .background(
            brush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF6994FF),
                    Color(0xFF1D3D8D)
                )
            ),
            shape = RoundedCornerShape(
                topStart = 35.dp,
                bottomStart = 35.dp,
            )
        )) {
        Column(modifier = Modifier
            .statusBarsPadding()
            .padding(start = 30.dp)) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Bienvenido", fontSize = 30.sp, color = Color.White, fontWeight = FontWeight.Bold)
            Text(text = "de nuevo", fontSize = 30.sp, color = Color.White, fontWeight = FontWeight.Bold)

            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp)) {
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .align(Alignment.CenterEnd),
                    painter = painterResource(id = R.drawable.car_white), contentDescription = "")

            }

            Text(text = "Log in", fontSize = 30.sp, color = Color.White, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(30.dp))
            DefaulTextField(
                modifier = Modifier,
                value = email,
                onValueChanged = { email = it},
                icon = Icons.Outlined.Email,
                keyboardType = KeyboardType.Email,
                label = "Email",
            )
            Spacer(modifier = Modifier.height(30.dp))
            DefaulTextField(
                modifier = Modifier,
                value = password,
                onValueChanged = { password = it},
                icon = Icons.Outlined.Lock,
                keyboardType = KeyboardType.Password,
                label = "Contraseña",
            )
            Spacer(modifier = Modifier.weight(1f))


            DefaultButton(
                modifier = Modifier
                    .width(200.dp)
                    .height(45.dp),
                onClick = { /*TODO*/ },
                color = Color.White,
                text = "Iniciar sesión")


            Spacer(modifier = Modifier.height(30.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Spacer(modifier = Modifier
                    .width(25.dp)
                    .height(1.dp)
                    .background(Color.White)
                )
                Text(text = " O ", fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier
                    .width(25.dp)
                    .height(1.dp)
                    .background(Color.White)
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Text(text = "¿No tienes cuenta?", fontSize = 17.sp, color = Color.White)
                Spacer(modifier = Modifier.width(10.dp))
                Text(modifier = Modifier.clickable {
                    navHostController.navigate(route = AuthScreen.Register.route)
                },text = "Regístrate", fontSize = 17.sp, color = Color.White, fontWeight = FontWeight.ExtraBold)

            }
            Spacer(modifier = Modifier.height(40.dp))
        }

    }
}