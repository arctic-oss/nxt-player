package com.arcticoss.nxtplayer.medialistscreen

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.arcticoss.nxtplayer.MainActivity
import org.junit.Rule
import org.junit.Test

class MediaListScreenTest {

    @get:Rule
    val videoListRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun displayNoVideoFilesFound() {
        launchMediaListScreen(videoListRule) {
            // no operation
        } verify {
            noVideoFilesFoundIsShown()
        }
    }

    @Test
    fun displayPermissionNotGranted() {
        launchMediaListScreen(videoListRule) {
            // no operation
        } verify {
            permissionNotGrantedIsShown()
        }
    }

}