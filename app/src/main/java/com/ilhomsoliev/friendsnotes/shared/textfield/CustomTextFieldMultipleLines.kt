package com.ilhomsoliev.friendsnotes.shared.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
fun CustomTextFieldMultipleLines(
    modifier: Modifier = Modifier,
    hint: String,
    text: String,
    onValueChange: (String) -> Unit,
) {
    val textStyle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily(Font(R.font.roboto)),
        fontWeight = FontWeight(400),
        color = Color(0xFF93979F),
        letterSpacing = 0.15.sp,
    )
    BasicTextField(value = text, onValueChange = {
        onValueChange(it)
    }, textStyle = textStyle.copy(color = Color(0xFF151618))) { innerTextField ->
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFF1F2F4))
                .height(300.dp)
                .padding(16.dp),
            contentAlignment = Alignment.TopStart
        ) {
            if (text.isEmpty()) {
                Text(
                    text = hint,
                    style = textStyle
                )
            }
            innerTextField()

        }
    }
}