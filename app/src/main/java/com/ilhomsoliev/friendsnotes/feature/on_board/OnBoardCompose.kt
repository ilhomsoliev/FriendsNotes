package com.ilhomsoliev.friendsnotes.feature.on_board

import androidx.compose.runtime.Composable

interface OnBoardCallback {
    fun onStartClick()
}
@Composable
fun OnBoardContent(
    callback: OnBoardCallback
) {


}