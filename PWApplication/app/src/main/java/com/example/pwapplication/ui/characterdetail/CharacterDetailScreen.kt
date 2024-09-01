package com.example.pwapplication.ui.characterdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(viewModel: CharacterDetailViewModel, characterId: Int) {
    viewModel.loadCharacterDetail(characterId)
    val characterDetail by viewModel.characterDetail.collectAsState()

    characterDetail?.let { detail ->

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(detail.name) },
                    navigationIcon = {
                        IconButton(onClick = {  }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(8.dp),
                   // elevation = 4.dp
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = rememberImagePainter(detail.image),
                                contentDescription = null,
                                modifier = Modifier.size(128.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text(
                                    text = detail.name,
                                    style = MaterialTheme.typography.headlineMedium
                                )
                                Text(
                                    text = "Status: ${detail.status}",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(
                                    text = "Species: ${detail.species}",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(
                                    text = "Gender: ${detail.gender}",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(
                                    text = "Origin: ${detail.origin.name}",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}