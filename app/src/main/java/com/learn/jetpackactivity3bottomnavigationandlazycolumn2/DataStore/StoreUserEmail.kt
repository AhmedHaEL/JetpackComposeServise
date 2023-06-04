package com.learn.jetpackactivity3bottomnavigationandlazycolumn2.DataStore

import android.content.Context
import android.net.Uri
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreUserEmail(private val context: Context) {

    // to make sure there is only one instance
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("UserEmail")
        val USER_EMAIL_KEY = stringPreferencesKey("user_email")
        val USER_IMAGES_KEY = stringPreferencesKey("user_image")
        val USER_DITAILS_LOCATION_KEY = stringPreferencesKey("Details_Location")
        val USER_PHONE_KEY = stringPreferencesKey("phone")
    }

    // to get the email
    val getDetails: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_EMAIL_KEY] ?: ""
        }

    // to save the email
    suspend fun saveDetails(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_EMAIL_KEY] = name
        }
    }

    // to get the email
    val getImages: Flow<List<Uri?>> = context.dataStore.data
        .map { preferences ->
//            val uriSet =  preferences[USER_IMAGES_KEY]?: emptySet<Uri>()
            preferences[USER_IMAGES_KEY]?: emptySet<Uri>()
//            uriSet.map { Uri.parse(it) }.toList()
        } as Flow<List<Uri?>>

    // to save the email
    suspend fun saveImages(name: List<Uri?>) {
        context.dataStore.edit { preferences ->
            preferences[USER_IMAGES_KEY] = name.toString()
        }
    }

    // to get the email
    val getDetailsLocation: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_EMAIL_KEY] ?: ""
        }

    // to save the email
    suspend fun saveDetailsLocation(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_EMAIL_KEY] = name
        }
    }
    // to get the email
    val getPhone: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_EMAIL_KEY] ?: ""
        }

    // to save the email
    suspend fun savePhone(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_EMAIL_KEY] = name
        }
    }
}