package com.ilhomsoliev.friendsnotes.feature.add_person.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
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
fun AddPersonTopBar(
    currentStep: Int,
    onBack: () -> Unit,
) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = { onBack() }) {
            Icon(imageVector = Icons.Default.ArrowBackIos, contentDescription = null)
        }
        ProgressBar(
            modifier = Modifier
                .weight(1f)
                .padding(end = 12.dp),
            maxSteps = 5,
            currentSteps = currentStep
        )
        Text(
            modifier = Modifier.padding(end = 16.dp),
            text = "step $currentStep of 5",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(400),
                color = Color(0xFF151618),
            )
        )
    }
}

@Composable
private fun ProgressBar(
    modifier: Modifier = Modifier, maxSteps: Int, currentSteps: Int
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(6.dp)
            .clip(CircleShape)
            .background(Color(0xFFF3F6FA))

    ) {
        val fillPercentage = (currentSteps.toFloat() / maxSteps.toFloat()).coerceIn(0f, 1f)
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .fillMaxWidth(fillPercentage)
                .fillMaxHeight()
                .background(Color.Black)
        )
    }
}