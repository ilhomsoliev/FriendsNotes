package com.ilhomsoliev.friendsnotes.feature.person_details.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilhomsoliev.friendsnotes.R
import com.ilhomsoliev.friendsnotes.shared.textfield.CustomTextField
import com.ilhomsoliev.friendsnotes.shared.textfield.CustomTextFieldMultipleLines

@Composable
fun PersonDetailsDataItem(
    title: String,
    value: String,
    isMultipleLines: Boolean = false,
    onClick: () -> Unit,
) {
    Text(
        text = title,
        style = TextStyle(
            fontSize = 24.sp,
            lineHeight = 32.sp,
            fontFamily = FontFamily(Font(R.font.inter)),
            fontWeight = FontWeight(900),
            fontStyle = FontStyle.Italic,
            color = Color(0xFF212123),
        )
    )

    Spacer(modifier = Modifier.height(16.dp))
    if (!isMultipleLines)
        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            hint = "",
            text = value,
            onValueChange = {},
            isReadOnly = true,
            onClick = {
                onClick()
            })
    else CustomTextFieldMultipleLines(modifier = Modifier.fillMaxWidth(),
        hint = "",
        text = value,
        onValueChange = {},
        isReadOnly = true,
        onClick = {
            onClick()
        })
}