package com.example.sudokuking.feature.account

sealed class AccountNavigationItem {
    abstract val routeName: String

    object NotLoggedIn : AccountNavigationItem() {
        override val routeName = "NotLoggedIn"
    }

    object Login : AccountNavigationItem() {
        override val routeName = "Login"
    }

    object Register : AccountNavigationItem() {
        override val routeName = "Register"
    }

    object LoggedIn : AccountNavigationItem() {
        override val routeName = "LoggedIn"
    }
}