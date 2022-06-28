package com.example.sudokuking.feature.account

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.NativeKeyEvent
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sudokuking.R
import com.example.sudokuking.data.accountRepo
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginScreen(viewModel: AccountViewModel = viewModel(), navController: NavHostController) {
    val account by viewModel.bindUI(LocalContext.current).observeAsState()
    LoginScreenUI(account, navController, viewModel::onCheckInputs )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreenUI(account: AccountUI?, navController: NavHostController, checkInputs:(String, String)-> Unit) {
    Column(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()
        .fillMaxHeight(0.9f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.75f),
            backgroundColor = MaterialTheme.colors.secondary
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround)
            {
                Text(
                    text = "Login",
                    modifier = Modifier
                        .padding(5.dp),
                    fontSize = 30.sp,
                )

                val focusManager = LocalFocusManager.current
                var username by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text(stringResource(id = R.string.account_Username_label)) },
                    singleLine = true,
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
                
                Text(text = "Account: " + account?.name)


                var password by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    singleLine = true,
                    label = { Text(stringResource(id = R.string.account_Password_label)) },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            checkInputs(username, password)
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
    if(accountRepo.inputsWereChecked) {
        LoggInInputsWereCheckedPopUpItem(accountRepo.isLoggedIn,navController)
    }
}