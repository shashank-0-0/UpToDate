package com.example.bottom_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

enum class Tab {
    Home, Favorites
}

@Composable
fun BoxScope.BottomBar(
    selectedTab: Tab,
    modifier: Modifier = Modifier.align(Alignment.BottomCenter),
    onHomeClick: () -> Unit,
    onFavoritesClick: () -> Unit,
) {
    BottomBarRow(
        selectedTab = selectedTab,
        modifier=modifier,
        onHomeClick = onHomeClick,
        onAccountsClick = onFavoritesClick
    )

}

@Composable
private fun BottomBarRow(
    selectedTab: Tab,
    modifier: Modifier,
    onHomeClick: () -> Unit,
    onAccountsClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.DarkGray,
                shape = RoundedCornerShape(24.dp)
            )
            .border(1.dp, Color.Black, RoundedCornerShape(24.dp))
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Tab(
            text = "Home",
            selected = selectedTab == Tab.Home,
            icon = Icons.Outlined.Home,
            modifier = Modifier.weight(1f),
            onClick = onHomeClick
        )
        Spacer(Modifier.width(8.dp))
        Tab(
            text = "Favorites",
            selected = selectedTab == Tab.Favorites,
            icon = Icons.Rounded.Favorite,
            modifier = Modifier.weight(1f),
            onClick = onAccountsClick,
        )
    }
}

@Composable
private fun Tab(
    text: String,
    selected: Boolean,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        IconRes(
            icon = icon,
            tint = if (selected) Color.Blue else Color.Red,
        )
        if (selected) {
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                color = Color.White
            )
        }
    }
}

@Composable
fun IconRes(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    tint: Color = Color.White,
    contentDescription: String = "icon"
) {
    Icon(
        imageVector = icon,
        contentDescription = "Bottom Bar Image"
    )
}