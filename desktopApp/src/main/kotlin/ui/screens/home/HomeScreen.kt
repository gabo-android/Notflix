package ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.vickikbt.shared.presentation.viewmodels.SharedHomeViewModel
import koin
import ui.components.ItemNowPlayingMovies

@Composable
fun HomeScreen() {

    val viewModel = koin.get<SharedHomeViewModel>()
    val nowPlayingMovies = viewModel.nowPlayingMovies.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        println("Now playing movies: ${nowPlayingMovies.value}")

        if (!nowPlayingMovies.value.isNullOrEmpty()) {
            ItemNowPlayingMovies(modifier = Modifier, movie = nowPlayingMovies.value!![0]) {
                println("Clicked movie: ${it.title}")
            }
        }
    }
}
