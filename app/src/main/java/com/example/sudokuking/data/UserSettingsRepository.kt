package com.example.sudokuking

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class UserSettingsRepository(private val dataStore: DataStore<Preferences>,) {
    suspend fun getSettings(): UserSettings = dataStore.data.map(::settingsFromPreferences).first()

    /**
     * Updates the current user settings and returns the new settings.
     * @param f Invoked with the current settings; The settings returned from this function will replace the current ones.
     */
    suspend fun updateSettings(f: (UserSettings) -> UserSettings): UserSettings {
        val prefs = dataStore.edit {
            val newSettings = f(settingsFromPreferences(it))
            it[KEY_CART_ID] = newSettings.none
        }
        return settingsFromPreferences(prefs)
    }

    private fun settingsFromPreferences(prefs: Preferences) = UserSettings(
        none = "hi",
    )

    private companion object {
        private val KEY_CART_ID = stringPreferencesKey("shoppingCartId")
    }
}

data class UserSettings(
    /** The ID of the shopping cart used by this user. */
    val none: String,
)