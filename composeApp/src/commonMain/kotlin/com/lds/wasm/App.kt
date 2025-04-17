package com.lds.wasm

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text

import kotlinx.coroutines.launch
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.core.module.Module

import org.koin.dsl.module

import wasm.composeapp.generated.resources.Res
import wasm.composeapp.generated.resources.compose_multiplatform




fun providePlatformModules(): Module = module {
//    single {
//        Greeting()
//    }
}

@Composable
@Preview
fun App() {

//    PreComposeApp {
//        val navigator = rememberNavigator()
//        MaterialTheme {
//            NavHost(
//                navigator = navigator,
//                initialRoute = "/home"
//            ) {
//                scene(route = "/home") {
//                    val homeViewModel = viewModel {
//                        HomeViewModel()
//                    }
//                    val name by homeViewModel.name.observeAsState()
//                    Column(
//                        modifier = Modifier.fillMaxSize(),
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.Center
//                    ) {
//                        Text(
//                            text = "Greet Me!",
//                            style = MaterialTheme.typography.h6
//                        )
//                        Spacer(modifier = Modifier.height(30.dp))
//                        TextField(
//                            value = name,
//                            maxLines = 1,
//                            label = { Text(text = "Enter your name") },
//                            onValueChange = {
//                                homeViewModel.setName(it)
//                            }
//                        )
//                        Spacer(modifier = Modifier.height(30.dp))
//                        Button(
//                            onClick = {
//                                navigator.navigate(route = "/greeting/$name")
//                            }
//                        ) {
//                            Text(text = "GO!")
//                        }
//                    }
//                }
//                scene(route = "/greeting/{name}") { backStackEntry ->
//                    backStackEntry.path<String>("name")?.let { name ->
//                        Column(
//                            modifier = Modifier.fillMaxSize(),
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            verticalArrangement = Arrangement.Center
//                        ) {
//                            Text(
//                                text = name,
//                                style = MaterialTheme.typography.h6
//                            )
//                            Spacer(modifier = Modifier.height(30.dp))
//                            Button(onClick = { navigator.goBack() }) {
//                                Text(text = "GO BACK!")
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }

    PreComposeApp {


//        KoinApplication(application = {
//            val androidModule = module {
////                single<Context> {
////                    applicationContext
////                }
////                single { GeolocationHelper(this@MainActivity) }
//            }
//            modules(androidModule + providePlatformModules())
//        }) {
//
//        }
        test1()
    }


}

@Composable fun test1() {
    MaterialTheme {


        var greeting = remember { "" }
        val scope = rememberCoroutineScope()

        LaunchedEffect(Unit) {
            scope.launch {
                greeting = Greeting().greet()
            }
        }

        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {

                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}

class HomeViewModel : ViewModel() {
//    val name = LiveData("")
//    fun setName(value: String) {
//        name.value = value
//    }
}