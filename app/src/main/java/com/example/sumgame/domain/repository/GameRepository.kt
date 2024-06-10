package com.example.sumgame.domain.repository

import com.example.sumgame.domain.entities.GameSettings
import com.example.sumgame.domain.entities.Level
import com.example.sumgame.domain.entities.Question

interface GameRepository {

    fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question

    fun getGameSettings(level: Level): GameSettings
}