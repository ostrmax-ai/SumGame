package com.example.sumgame.domain.usecases

import com.example.sumgame.domain.entities.GameSettings
import com.example.sumgame.domain.entities.Level
import com.example.sumgame.domain.repository.GameRepository

class GetGameSettingsUseCase (private val repository: GameRepository) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}