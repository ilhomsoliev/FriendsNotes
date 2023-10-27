package com.ilhomsoliev.friendsnotes.shared.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilhomsoliev.friendsnotes.R

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 18.sp,
    isActive: Boolean = true,
    isLoading: Boolean = false,
    shape: Shape = CircleShape,
    innerPadding: PaddingValues = PaddingValues(vertical = 14.dp),
    onClick: () -> Unit,
) {
    val background = Modifier.background(if (isActive) Color(0xFF151618) else Color(0xFFF1F2F4))

    Box(
        modifier = modifier
            .height(56.dp)
            .clip(shape)
            .then(background)
            .clickable {
                onClick()
            }, contentAlignment = Alignment.Center
    ) {

        Text(
            modifier = Modifier/*.padding(innerPadding)*/,
            text = if (isLoading) " " else text,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(500),
                color = if (isActive) Color(0xFFFFFFFF) else Color(0x3D040F23),
                letterSpacing = 0.15.sp,
            )
        )
        if (isLoading)
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(innerPadding)
                    .size(fontSize.value.dp.minus(2.dp)),
            )
        /*if (!isActive)
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color(0xAAFFFFFF))
            )*/
    }
}