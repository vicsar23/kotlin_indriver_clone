package com.vicsar23.indriverclone.presentation.screes.auth.register.components

import android.widget.Toast
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.vicsar23.indriverclone.R
import com.vicsar23.indriverclone.presentation.components.DefaulOutlinedTextField
import com.vicsar23.indriverclone.presentation.components.DefaultButton
import com.vicsar23.indriverclone.presentation.screes.auth.login.LoginViewModel
import com.vicsar23.indriverclone.presentation.screes.auth.register.RegisterViewModel

@Composable
fun RegisterContent(navHostController: NavHostController, paddingValues: PaddingValues,
                    vm: RegisterViewModel = hiltViewModel()
) {
    val state = vm.state
    val scrollState = rememberScrollState()

    val context = LocalContext.current
    LaunchedEffect(key1 = vm.errorMessage) {
        if(vm.errorMessage.isNotEmpty()){
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_LONG).show()
        }
    }
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
            Text(text = "Login",color = Color.White, fontSize = 27.sp, modifier = Modifier
                .rotate(degrees = 90f)
                .padding(top = 2.dp)
                .clickable {
                    navHostController.popBackStack()
                })
            Spacer(modifier = Modifier.height(150.dp))
            Text(text = "Registro", fontWeight = FontWeight.ExtraBold, color = Color.White, fontSize = 27.sp,  modifier = Modifier
                .rotate(degrees = 90f)
                .padding(top = 30.dp)
            )
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
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(end = 16.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp)) {
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.car_white), contentDescription = "")

            }

            Spacer(modifier = Modifier.height(10.dp))
            DefaulOutlinedTextField(
                modifier = Modifier,
                value = state.name,
                onValueChanged = { vm.onNameInput(it)},
                icon = Icons.Outlined.Person,
                keyboardType = KeyboardType.Text,
                label = "Nombre",
            )
            Spacer(modifier = Modifier.height(20.dp))
            DefaulOutlinedTextField(
                modifier = Modifier,
                value = state.lastName,
                onValueChanged = { vm.onLastNameInput(it)},
                icon = Icons.Outlined.Person,
                keyboardType = KeyboardType.Text,
                label = "Apellido",
            )
            Spacer(modifier = Modifier.height(20.dp))
            DefaulOutlinedTextField(
                modifier = Modifier,
                value = state.email,
                onValueChanged = { vm.onEmailInput(it)},
                icon = Icons.Outlined.Email,
                keyboardType = KeyboardType.Email,
                label = "Email",
            )
            Spacer(modifier = Modifier.height(20.dp))
            DefaulOutlinedTextField(
                modifier = Modifier,
                value = state.phone,
                onValueChanged = { vm.onPhoneInput(it)},
                icon = Icons.Outlined.Phone,
                keyboardType = KeyboardType.Number,
                label = "Teléfono",
            )
            Spacer(modifier = Modifier.height(20.dp))
            DefaulOutlinedTextField(
                modifier = Modifier,
                value = state.password,
                onValueChanged = { vm.onPasswordInput(it)},
                icon = Icons.Outlined.Lock,
                hideText = true,
                keyboardType = KeyboardType.Password,
                label = "Contraseña",
            )
            Spacer(modifier = Modifier.height(20.dp))
            DefaulOutlinedTextField(
                modifier = Modifier,
                hideText = true,
                value = state.confirmPassword,
                onValueChanged = { vm.onConfirmPasswordInput(it)},
                icon = Icons.Outlined.Lock,
                keyboardType = KeyboardType.Text,
                label = "Confirmar Contraseña",
            )
            Spacer(modifier = Modifier.height(40.dp))

            DefaultButton(
                modifier = Modifier
                    .width(200.dp)
                    .height(45.dp),
                onClick = { vm.loginSubmit()},
                color = Color.White,
                text = "Crear usuario")
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
                Text(text = "¿Ya tienes cuenta?", fontSize = 17.sp, color = Color.White)
                Spacer(modifier = Modifier.width(10.dp))
                Text(modifier = Modifier.clickable {
                    navHostController.popBackStack()
                },text = "Iniciar sesión", fontSize = 17.sp, color = Color.White, fontWeight = FontWeight.ExtraBold)

            }
            Spacer(modifier = Modifier.height(40.dp))
        }

    }
}