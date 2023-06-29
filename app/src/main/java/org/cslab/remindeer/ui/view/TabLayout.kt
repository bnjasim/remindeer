package org.cslab.remindeer.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import org.cslab.remindeer.MainViewModel

@Composable
fun TabLayout(viewModel: MainViewModel) {
    val tabIndex = viewModel.tabIndex.observeAsState()
    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = tabIndex.value!!) {
            viewModel.tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title) },
                    selected = tabIndex.value!! == index,
                    onClick = { viewModel.updateTabIndex(index) },
                    icon = {
                        when (index) {
                            0 -> Icon(imageVector = Icons.Default.Notifications, contentDescription = null)
                            1 -> Icon(imageVector = Icons.Default.Add, contentDescription = null)
                            2 -> Icon(imageVector = Icons.Default.Edit, contentDescription = null)
                            3 -> Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                            4 -> Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
                        }
                    }
                )
            }
        }

        when (tabIndex.value) {
            0 -> NotificationScreen(viewModel = viewModel)
            1 -> HomeScreen(viewModel = viewModel)
            2 -> UpcomingScreen(viewModel = viewModel)
            3 -> NoteScreen(viewModel = viewModel)
            4 -> QuoteScreen(viewModel = viewModel)
        }
    }
}