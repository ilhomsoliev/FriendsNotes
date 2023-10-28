package com.ilhomsoliev.friendsnotes.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ilhomsoliev.friendsnotes.app.navigation.Navigation
import com.ilhomsoliev.friendsnotes.app.theme.FriendsNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FriendsNotesTheme {

                Navigation()
            }
        }
    }
}