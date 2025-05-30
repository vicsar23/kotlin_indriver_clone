package com.vicsar23.indriverclone.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DefaultButton(modifier: Modifier,
                  text: String,
                  height: Dp =45.dp,
                  with: Dp = 200.dp,
                  onClick:()-> Unit,
                  color: Color =  Color.Black) {

    Box(Modifier.fillMaxWidth()) {
        Button(modifier = modifier
            .align(Alignment.Center)
            .width(height)
            .height(with), onClick = onClick, colors = ButtonDefaults.buttonColors(color)) {
            Text(text = text, fontSize = 18.sp, style = TextStyle(color =  Color.Black))
        }
    }
}