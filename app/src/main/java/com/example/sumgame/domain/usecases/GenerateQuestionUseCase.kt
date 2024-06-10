package com.example.sumgame.domain.usecases

import com.example.sumgame.domain.entities.Question
import com.example.sumgame.domain.repository.GameRepository

class GenerateQuestionUseCase (private val repository: GameRepository) {

    operator fun invoke(maxSum: Int): Question {
        return repository.generateQuestion(maxSum, COUNT_OF_OPTIONS)
    }

    companion object {
        private const val COUNT_OF_OPTIONS = 6
    }
}