package org.cslab.remindeer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import org.cslab.remindeer.ui.theme.RemindeerTheme
import org.cslab.remindeer.ui.view.TabLayout

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
              RemindeerTheme{
                  // A surface container using the 'background' color from the theme
                  Surface(
                      modifier = Modifier.fillMaxSize(),
                      color = MaterialTheme.colors.background
                  ) {
                      TabLayout(viewModel = viewModel)
                  }
              }
        }
    }
}

