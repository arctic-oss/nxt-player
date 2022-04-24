package com.arcticoss.nxtplayer.medialistscreen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.arcticoss.nxtplayer.MainActivity
import com.arcticoss.nxtplayer.R


fun launchMediaListScreen(
    rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
    block: MediaListRobot.() -> Unit
): MediaListRobot {
    return MediaListRobot(rule).apply(block)
}

class MediaListRobot(
    private val rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>
) {

    infix fun verify(
        block: MediaListVerification.() -> Unit
    ): MediaListVerification {
        return MediaListVerification(rule).apply(block)
    }
}

class MediaListVerification(
    private val rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>
) {
    fun noVideoFilesFoundIsShown() {
        val noVideoFiles = rule.activity.getString(R.string.noVideoFilesFound)
        rule.onNodeWithText(noVideoFiles).assertIsDisplayed()
    }

    fun permissionNotGrantedIsShown() {
        val permissionNotGranted = rule.activity.getString(R.string.permissionNotGranted)
        rule.onNodeWithText(permissionNotGranted).assertIsDisplayed()
    }
}
