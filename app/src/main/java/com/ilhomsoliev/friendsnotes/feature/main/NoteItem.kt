package com.ilhomsoliev.friendsnotes.feature.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NoteItem(
    modifier: Modifier = Modifier,
    gradientColors: List<Color>,
    emoji: String,
    text: String,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(Brush.linearGradient(gradientColors)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.padding(bottom = 12.dp),
                text = emoji,
                fontSize = 44.sp
            )
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 32.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF212123),
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}

@Composable
fun MainTitle(
    modifier: Modifier,
    text: String,
) {
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontSize = 72.sp,
            lineHeight = 104.sp,
            fontWeight = FontWeight(900),
            color = Color(0xFF212123),
            textAlign = TextAlign.Center,
        )
    )
}