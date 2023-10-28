package com.ilhomsoliev.friendsnotes.feature.main.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ilhomsoliev.friendsnotes.feature.main.presentation.components.MainTitle
import com.ilhomsoliev.friendsnotes.feature.main.presentation.components.NoteItem
import com.ilhomsoliev.friendsnotes.shared.model.person.PersonModel

data class MainState(
    val lovely: PersonModel?,
    val friends: List<PersonModel>,
    val relatives: List<PersonModel>,
    val isLoading: Boolean,
)

interface MainCallback {
    fun onMenuClick()
    fun onSearchClick()
    fun onAddNewPerson()
    fun onItemClick(id: Int)
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MainContent(
    state: MainState,
    callback: MainCallback,
) {
    val lazyState = rememberLazyListState()
    Scaffold(
        /*topBar = {
            TopAppBar(navigationIcon = {
                IconButton(onClick = { *//*TODO*//* }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                }
            }, title = {
            }, actions = {
                IconButton(onClick = { *//*TODO*//* }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                }
            })
        }*/
        floatingActionButton = {
            FloatingActionButton(onClick = {
                callback.onAddNewPerson()
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .padding(it),
            state = lazyState,
            content = {
                state.lovely?.let { lovely ->
                    item {
                        MainTitle(modifier = Modifier.padding(horizontal = 16.dp), text = "Lovely")
                        NoteItem(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1.8f)
                                .padding(16.dp),
                            emoji = "❤",
                            text = lovely.name,
                            gradientColors = listOf(
                                Color(0xFFFFF5C9),
                                Color(0xFFFFEBEC),
                            ),
                            onClick = {
                                lovely.id?.let { it1 -> callback.onItemClick(it1) }
                            }
                        )
                    }
                }
                if (state.friends.isNotEmpty()) {
                    item {
                        MainTitle(modifier = Modifier.padding(horizontal = 16.dp), text = "Friends")
                        FlowRow(modifier = Modifier.fillMaxWidth(), maxItemsInEachRow = 2) {
                            state.friends.forEach { person ->
                                NoteItem(
                                    modifier = Modifier
                                        .weight(1f)
                                        .aspectRatio(1f)
                                        .padding(start = 16.dp, end = 8.dp)
                                        .padding(vertical = 16.dp),
                                    text = person.name,
                                    gradientColors = listOf(
                                        Color(0xFFF4EEFE),
                                        Color(0xFFE3F7FF),
                                    ),
                                    onClick = {
                                        person.id?.let { it1 -> callback.onItemClick(it1) }
                                    }
                                )
                                if (state.friends.size % 2 == 1)
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .aspectRatio(1f)
                                            .padding(start = 16.dp, end = 8.dp)
                                            .padding(vertical = 16.dp),
                                    )
                            }
                        }
                    }
                }
                if (state.relatives.isNotEmpty()) {
                    item {
                        MainTitle(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            text = "Relatives"
                        )
                        FlowRow(modifier = Modifier.fillMaxWidth(), maxItemsInEachRow = 2) {
                            state.relatives.forEach { person ->
                                NoteItem(
                                    modifier = Modifier
                                        .weight(1f)
                                        .aspectRatio(1f)
                                        .padding(start = 16.dp, end = 8.dp)
                                        .padding(vertical = 16.dp),
                                    text = person.name,
                                    gradientColors = listOf(
                                        Color(0xFFF4EEFE),
                                        Color(0xFFE3F7FF),
                                    ),
                                    onClick = {
                                        person.id?.let { it1 -> callback.onItemClick(it1) }
                                    }
                                )
                                if (state.relatives.size % 2 == 1)
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .aspectRatio(1f)
                                            .padding(start = 16.dp, end = 8.dp)
                                            .padding(vertical = 16.dp),
                                    )
                            }
                        }
                    }
                }
            })
    }

}