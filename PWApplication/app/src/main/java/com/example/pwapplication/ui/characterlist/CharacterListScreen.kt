package com.example.pwapplication.ui.characterlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.pwapplication.data.model.Character

@Composable
fun CharacterListScreen(viewModel: CharacterListViewModel, navController: NavHostController) {
    val characters by viewModel.characters.collectAsState()

    LazyColumn(
        contentPadding = PaddingValues(16.dp),

        verticalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        items(characters.size) { index ->
            CharacterListItem(character = characters[index]) {
                navController.navigate("characterDetail/${characters[index].id}")
            }
        }
    }
}




