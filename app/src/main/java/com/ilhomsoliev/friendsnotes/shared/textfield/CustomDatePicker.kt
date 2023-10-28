package com.ilhomsoliev.friendsnotes.shared.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilhomsoliev.friendsnotes.R

@Composable
fun CustomDatePicker(
    modifier: Modifier = Modifier,
    hint: String,
    text: String,
    onClick: () -> Unit,
) {
    val textStyle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily(Font(R.font.roboto)),
        fontWeight = FontWeight(400),
        color = Color(0xFF93979F),
        letterSpacing = 0.15.sp,
    )
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFF1F2F4))
            .clickable {
                onClick()
            }
            .padding(16.dp),
        contentAlignment = Alignment.TopStart
    ) {
        if (text.isEmpty()) {
            Text(
                text = hint,
                style = textStyle
            )
        } else {
            Text(
                text = text,
                style = textStyle.copy(color = Color(0xFF040F23))
            )
        }
    }
}