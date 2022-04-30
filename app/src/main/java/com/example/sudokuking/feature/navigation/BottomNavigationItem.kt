package com.example.sudokuking.feature.navigation

import com.example.sudokuking.R

sealed class BottomNavigationItem {
    abstract val routeName: String
    abstract val title: Int
    abstract val icon: Int

    object Statistics : BottomNavigationItem() {
        override val routeName = "statistics"
        override val title = R.string.statistics_title_navigation
        override val icon = R.drawable.ic_baseline_bar_chart_24
    }

    object Game : BottomNavigationItem() {
        override val title = R.string.game_title_navigation
        override val icon = R.drawable.ic_baseline_play_circle_filled_24
        override val routeName = "game"
    }
    object Account : BottomNavigationItem() {
        override val title = R.string.account_title_navigation
        override val icon = R.drawable.ic_baseline_account_circle_24
        override val routeName = "account"
    }
}