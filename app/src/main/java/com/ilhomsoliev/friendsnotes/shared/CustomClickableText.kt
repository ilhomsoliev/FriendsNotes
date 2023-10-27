package com.ilhomsoliev.friendsnotes.shared

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign

data class TextWithStyle(
    val text: String,
    val style: SpanStyle,
    val isClickable: Boolean = false,
    val tag: String? = null,
    val onClick: (() -> Unit)? = null,
)

@Composable
fun CustomClickableText(
    modifier: Modifier = Modifier,
    texts: List<TextWithStyle>,
    textAlign: TextAlign = TextAlign.Center,
) {

    val annotatedString = buildAnnotatedString {
        val text = texts.joinToString(separator = "") { it.text }
        var prevSize = 0
        append(
            AnnotatedString(
                text,
            )
        )
        texts.forEach {
            addStyle(
                style = it.style,
                start = prevSize,
                end = prevSize + it.text.length,
            )
            if (it.isClickable && it.tag != null) {
                addStringAnnotation(
                    tag = it.tag,
                    annotation = it.tag, // TODO change url
                    start = prevSize,
                    end = prevSize + it.text.length,
                )
            }
            prevSize += it.text.length
        }
    }
    ClickableText(
        modifier = modifier,
        text = annotatedString,
        style = TextStyle(textAlign = textAlign),
        onClick = { position ->
            // find annotations by tag and current position
            texts.forEach { text ->
                if (text.isClickable && text.tag != null && text.onClick?.equals(null) == false) {
                    val annotations = annotatedString.getStringAnnotations(
                        text.tag,
                        start = position,
                        end = position
                    )
                    annotations.firstOrNull()?.let {
                        text.onClick.invoke()
                    }
                }
            }
        },
    )
}