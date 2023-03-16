package com.example.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.bottom_bar.BottomBar
import com.example.bottom_bar.Tab


@Composable
fun BoxScope.HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsState()
    println("shetty = ${state.images.size}")

    UI(
        state = state,
        onEvent = viewModel::onEvent,
    )


}

@Composable
private fun BoxScope.UI(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
) {
    println("shetty verify ${state.images.size}")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color.Black,Color.DarkGray)))
    ) {
        Spacer(Modifier.height(10.dp))
        Text(
            modifier = Modifier
                .padding(start = 15.dp)
                .fillMaxWidth(),
            text = "Images",
            fontSize = 30.sp,
            color = Color.White
        )
        Spacer(Modifier.height(10.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(2)){
            items(state.images){
                ImageCard(
                    imageUrl = it.url,
                    imageTitle = it.title,
                )
            }
            item {
                Spacer(modifier = Modifier.height(70.dp))
            }
        }
    }
    BottomBar(
        selectedTab = Tab.Home,
        onHomeClick = {

        },
        onFavoritesClick = {
            onEvent(HomeEvent.FavoritesClick)
        }
    )


    if(state.loading){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularProgressIndicator(
                color = Color.Green
            )

        }
    }

}

@Composable
fun ImageCard(
    imageUrl:String,
    imageTitle: String,
    modifier:Modifier=Modifier
){
    Card(
        modifier= modifier
            .padding(start=12.dp,end=12.dp,top=12.dp,bottom=1.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Box(
            modifier=Modifier
                .height(200.dp)
        ){
            AsyncImage(
                model = imageUrl,
                contentDescription = "An Image",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier= Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ){
                Text(
                    text = imageTitle,
                    style = TextStyle(
                        color=Color.White,
                        fontSize = 16.sp
                    )
                )
            }
        }

    }

}