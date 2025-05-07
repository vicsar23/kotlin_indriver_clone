package com.vicsar23.indriverclone.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun DefaulOutlinedTextField(
    modifier: Modifier,
    label: String,
    value:String,
    icon: ImageVector,
    onValueChanged:(value: String) -> Unit,
    keyboardType:KeyboardType = KeyboardType.Text,
    hideText:Boolean = false)
{
    Box(modifier = modifier
        .height(65.dp)
        .background(
            color = Color.Transparent,
            shape = RoundedCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
        )
    ) {
        OutlinedTextField(
            /*colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),*/
            value = value,
            onValueChange = {
            text -> onValueChanged(text)
        },
            label = {
                Text(text = label)
            },
            leadingIcon = {
                Row() {
                    Icon(imageVector = icon, contentDescription = "")
                    Spacer(modifier = Modifier.width(8.dp))
                    Spacer(modifier = Modifier
                        .height(20.dp)
                        .width(1.dp)
                        .background(color = Color.Gray))
                }

            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = if(hideText) PasswordVisualTransformation() else VisualTransformation.None
        )
    }
}