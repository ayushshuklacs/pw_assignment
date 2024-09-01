package com.example.pwapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.pwapplication.data.network.RetrofitInstance
import com.example.pwapplication.data.repository.CharacterRepository
import com.example.pwapplication.ui.characterdetail.CharacterDetailScreen
import com.example.pwapplication.ui.characterdetail.CharacterDetailViewModel
import com.example.pwapplication.ui.characterlist.CharacterListViewModel

import com.example.pwapplication.ui.characterlist.CharacterListScreen
import com.example.pwapplication.ui.theme.PWApplicationTheme

class MainActivity : ComponentActivity() {


    private lateinit var characterViewModelFactory: CharacterViewModelFactory

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {



            PWApplicationTheme {
                val repository = CharacterRepository(RetrofitInstance.apiService)
                characterViewModelFactory = CharacterViewModelFactory(repository)

                setContent {
                    val navController = rememberNavController()

                    NavHost(navController, startDestination = "characterList") {
                        composable("characterList") {
                            val viewModel = ViewModelProvider(this@MainActivity, characterViewModelFactory)
                                .get(CharacterListViewModel::class.java)

                            Scaffold(
                                topBar = {
                                    TopAppBar(
                                        title = { Text("Rick and Morty Characters") },
                                        colors = TopAppBarDefaults.smallTopAppBarColors(
                                            containerColor = MaterialTheme.colorScheme.primary,
                                            titleContentColor = Color.White
                                        )
                                    )
                                }
                            ) {
                                CharacterListScreen(viewModel, navController)
                            }
                        }
                        composable("characterDetail/{characterId}") { backStackEntry ->
                            val characterId = backStackEntry.arguments?.getString("characterId")?.toInt()
                            val viewModel = ViewModelProvider(this@MainActivity, characterViewModelFactory)
                                .get(CharacterDetailViewModel::class.java)

                            Scaffold(
                                topBar = {
                                    TopAppBar(
                                        title = { Text("Character Details") },
                                        navigationIcon = {
                                            IconButton(onClick = { navController.popBackStack() }) {
                                                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                                            }
                                        },
                                        colors = TopAppBarDefaults.smallTopAppBarColors(
                                            containerColor = MaterialTheme.colorScheme.primary,
                                            titleContentColor = Color.White,
                                            navigationIconContentColor = Color.White
                                        )
                                    )
                                }
                            ) {
                                characterId?.let { CharacterDetailScreen(viewModel, it,) }
                            }
                        }
                    }
                }
            }


        }}}
