package com.ilhomsoliev.friendsnotes.feature.add_person.presentation.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun LoadingAddPersonScreen(
    onAnimationFinished: () -> Unit
) {
    val duration = 3000L

    var sizeState by remember { mutableStateOf(100.dp) }

    LaunchedEffect(key1 = Unit, block = {
        delay(80L)
        sizeState = 1500.dp
    })

    val animatedSize by animateDpAsState(
        targetValue = sizeState,
        label = "size",
        animationSpec = tween(durationMillis = duration.toInt(), easing = FastOutSlowInEasing)
    )

    LaunchedEffect(Unit) {
        delay(duration)
        onAnimationFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.HeartBroken,
            contentDescription = null,
            modifier = Modifier.size(animatedSize)
        )
    }
}