package com.example.sumgame.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameResult(
    val winner: Boolean,
    val countOfRightAnswers: Int,
    val countOfQuestions: Int,
    val gameSettings: GameSettings
): Parcelable {
    val scorePercentage: Int
        get() = (countOfRightAnswers / countOfQuestions.toDouble() * 100).toInt()
}
