package com.ilhomsoliev.friendsnotes.feature.main.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ilhomsoliev.friendsnotes.feature.main.MainTitle
import com.ilhomsoliev.friendsnotes.feature.main.NoteItem

data class MainState(
    val isLoading: Boolean,
)

interface MainCallback {
    fun onMenuClick()
    fun onSearchClick()
    fun onItemClick()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(
    state: MainState,
    callback: MainCallback,
) {
    val lazyState = rememberLazyListState()

    Scaffold(
        topBar = {
            TopAppBar(navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                }
            }, title = {
            }, actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                }
            })
        }
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .padding(it),
            state = lazyState,
            content = {
            item {
                MainTitle(modifier = Modifier.padding(horizontal = 16.dp), text = "Lovely")
                NoteItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.8f)
                        .padding(16.dp),
                    emoji = "❤",
                    text = "Любимый",
                    gradientColors = listOf(
                        Color(0xFFFFF5C9),
                        Color(0xFFFFEBEC),
                    )
                )
            }
            item {
                MainTitle(modifier = Modifier.padding(horizontal = 16.dp), text = "Friends")
                Row(modifier = Modifier.fillMaxWidth()){
                    NoteItem(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .padding(start = 16.dp, end = 8.dp)
                            .padding(vertical = 16.dp),
                        emoji = "👩‍🎨",
                        text = "Michle",
                        gradientColors = listOf(
                            Color(0xFFF4EEFE),
                            Color(0xFFE3F7FF),
                        )
                    )
                    NoteItem(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .padding(start = 8.dp, end = 16.dp)
                            .padding(vertical = 16.dp),
                        emoji = "\uD83C\uDF38",
                        text = "Aasia",
                        gradientColors = listOf(
                            Color(0xFFFFF0D4),
                            Color(0xFFF4EEFE),
                        )
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()){
                    NoteItem(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .padding(start = 16.dp, end = 8.dp)
                            .padding(vertical = 16.dp),
                        emoji = "\uD83E\uDD2A",
                        text = "Marc",
                        gradientColors = listOf(
                            Color(0xFFEAFCCF),
                            Color(0xFFFFF0D4),
                        )
                    )
                    NoteItem(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .padding(start = 8.dp, end = 16.dp)
                            .padding(vertical = 16.dp),
                        emoji = "✨",
                        text = "Ostin",
                        gradientColors = listOf(
                            Color(0xFFFFF5C9),
                            Color(0xFFFFEBEC),
                        )
                    )
                }

            /*
                LazyVerticalGrid(
                    modifier = Modifier.wrapContentHeight(),
                    columns = GridCells.Fixed(2),
                    userScrollEnabled = false,
                    content = {
                        items(
                            listOf(

                                "\uD83E\uDD2A" to "Marc",
                                "✨" to "Ostin",
                            )
                        ) {

                        }
                    })*/
            }
        })
    }

}