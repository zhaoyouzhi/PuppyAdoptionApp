/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import android.os.Bundle
import androidx.annotation.MainThread
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.core.os.bundleOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Putty
import com.example.androiddevchallenge.ui.ScreenName.DETAIL
import com.example.androiddevchallenge.ui.ScreenName.PUTTY
import com.example.androiddevchallenge.utils.getMutableStateOf

enum class ScreenName { PUTTY, DETAIL }

sealed class Screen(val id: ScreenName) {
    object PuttyS : Screen(PUTTY)
    data class DetailS(val putty: Putty) : Screen(DETAIL)
}

private const val SIS_SCREEN = "sis_screen"
private const val SIS_NAME = "screen_name"
private const val SIS_POST = "post"

private fun Screen.toBundle(): Bundle {
    return bundleOf(SIS_NAME to id.name).also {
        if (this is Screen.DetailS) {
            it.putParcelable(SIS_POST, putty)
        }
    }
}

private fun Bundle.toScreen(): Screen {
    val screenName = ScreenName.valueOf(getStringOrThrow(SIS_NAME))
    return when (screenName) {
        PUTTY -> Screen.PuttyS
        DETAIL -> {
            val putty = getParcelableOr(SIS_POST)
            Screen.DetailS(putty as Putty)
        }
    }
}

private fun Bundle.getStringOrThrow(key: String) =
    requireNotNull(getString(key)) { "Missing key '$key' in $this" }

private fun Bundle.getParcelableOr(key: String) =
    requireNotNull(getParcelable(key))

class NavigationViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    var currentScreen: Screen by savedStateHandle.getMutableStateOf<Screen>(
        key = SIS_SCREEN,
        default = Screen.PuttyS,
        save = { it.toBundle() },
        restore = { it.toScreen() }
    )

    @MainThread
    fun navigateTo(screen: Screen) {
        currentScreen = screen
    }

    @MainThread
    fun onBack(): Boolean {
        val wasHandled = currentScreen != Screen.PuttyS
        currentScreen = Screen.PuttyS
        return wasHandled
    }
}
