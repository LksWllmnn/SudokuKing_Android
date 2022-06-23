package com.example.sudokuking.data
//
//import androidx.datastore.core.DataStore
//import androidx.datastore.preferences.core.Preferences
//import androidx.datastore.preferences.core.booleanPreferencesKey
//import androidx.datastore.preferences.core.edit
//import androidx.datastore.preferences.core.stringPreferencesKey
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.first
//import kotlinx.coroutines.flow.map

//class UserSettingsRepository(private val dataStore: DataStore<Preferences>,) {
//    suspend fun getSettings(): UserSettings = dataStore.data.map(::settingsFromPreferences).first()
//
//    /** Emits the current user settings. */
//    fun observeSettings(): Flow<UserSettings> = dataStore.data.map(::settingsFromPreferences)
//
//    /**
//     * Updates the current user settings and returns the new settings.
//     * @param f Invoked with the current settings; The settings returned from this function will replace the current ones.
//     */
//    suspend fun updateSettings(f: (UserSettings) -> UserSettings): UserSettings {
//        val prefs = dataStore.edit {
//            val newSettings = f(settingsFromPreferences(it))
//            it[KEY_STAT_ID] = ""
//            when (val loginState = newSettings.loginState) {
//                is LoginState.LoggedIn -> {
//                    it.remove(KEY_IS_LOGGING_IN)
//                    it[KEY_CREDENTIALS] = loginState.credentials
//                }
//                LoginState.LoggedOut -> {
//                    it.remove(KEY_CREDENTIALS)
//                    it.remove(KEY_IS_LOGGING_IN)
//                }
//                is LoginState.LoggingIn -> {
//                    it[KEY_CREDENTIALS] = loginState.credentials
//                    it[KEY_IS_LOGGING_IN] = true
//                }
//            }
//        }
//        return settingsFromPreferences(prefs)
//    }
//
//    private fun settingsFromPreferences(prefs: Preferences) = UserSettings(
//        none = "hi",
//        loginState = prefs[KEY_CREDENTIALS]?.let { credentials ->
//            if (prefs[KEY_IS_LOGGING_IN] == true) {
//                LoginState.LoggingIn(credentials)
//            } else {
//                LoginState.LoggedIn(credentials)
//            }
//        } ?: LoginState.LoggedOut,
//    )
//
//    private companion object {
//        private val KEY_STAT_ID = stringPreferencesKey("statisticId")
//        private val KEY_CREDENTIALS = stringPreferencesKey("credentials")
//        private val KEY_IS_LOGGING_IN = booleanPreferencesKey("isLoggingIn")
//    }
//}
//
//data class UserSettings(
//    /** The ID of the shopping cart used by this user. */
//    val none: String,
//
//    /** The current login state. */
//    val loginState: LoginState,
//)
//
///** Describes the different states of a user logging in. */
//sealed class LoginState {
//    /** No user is logged in. */
//    object LoggedOut : LoginState()
//
//    /**
//     * A user is currently in the process of logging in.
//     * @param credentials Credentials to authenticate against the backend.
//     */
//    class LoggingIn(val credentials: String) : LoginState()
//
//    /**
//     * A user is currently logged in.
//     * @param credentials Credentials to authenticate against the backend.
//     */
//    class LoggedIn(val credentials: String) : LoginState()
//}