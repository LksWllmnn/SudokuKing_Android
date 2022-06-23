package com.example.sudokuking.feature.account

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.NativeKeyEvent
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sudokuking.data.accountRepo

@Composable
fun RegisterScreen(navController: NavHostController, viewModel: AccountViewModel = viewModel()) {
    val account by viewModel.bindUI(LocalContext.current).observeAsState()
    RegisterScreenUI(account, navController, viewModel::onRegister, viewModel::onCloseRegisterPopUp)
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegisterScreenUI(account: AccountUI?, navController: NavHostController, register:(String, String) -> Unit, closePopUp: () -> Unit) {
    Column(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()
        .fillMaxHeight()
    ) {
        Card(modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()) {
            Column {
                Text(
                    text = "Register",
                    modifier = Modifier
                        .padding(5.dp)
                )

                val focusManager = LocalFocusManager.current
                var username by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    singleLine = true,
                    label = { Text("Username") },
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    ),
                    modifier = Modifier.onKeyEvent {
                        if(it.nativeKeyEvent.keyCode == NativeKeyEvent.KEYCODE_ENTER) {
                            focusManager.clearFocus()
                            true
                        }
                        false
                    }
                )

                var password by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    singleLine = true,
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            register(username, password)
                            focusManager.clearFocus()
                        }
                    ),
                    modifier = Modifier.onKeyEvent {
                        if(it.nativeKeyEvent.keyCode == NativeKeyEvent.KEYCODE_ENTER) {

                            focusManager.clearFocus()
                            true
                        }
                        false
                    }
                )
            }
        }
    }
    Column() {
        if(accountRepo.accountIsRegistered) {
            RegisterWasCheckedPopUpItem(navController, closePupUp = closePopUp)
        }
    }
}