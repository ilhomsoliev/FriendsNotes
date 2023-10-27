package com.ilhomsoliev.friendsnotes.shared.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 18.sp,
    isActive: Boolean = true,
    isLoading: Boolean = false,
    shape: Shape = RoundedCornerShape(24.dp),
    innerPadding: PaddingValues = PaddingValues(vertical = 14.dp),
    onClick: () -> Unit,
) {
    val background = Modifier.background(Color(0xFF278DD2))

    Box(
        modifier = modifier
            .clip(shape)
            .then(background)
            .clickable {
                onClick()
            }, contentAlignment = Alignment.Center
    ) {

        Text(
            modifier = Modifier.padding(innerPadding),
            text = if (isLoading) " " else text,
            style = MaterialTheme.typography.labelMedium.copy(
                fontSize = fontSize,
                // fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(600),
                textAlign = TextAlign.Center,
                color = Color.White
            )
        )
        if (isLoading)
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(innerPadding)
                    .size(fontSize.value.dp.minus(2.dp)),
            )
        if (!isActive)
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color(0xAAFFFFFF))
            )
    }
}