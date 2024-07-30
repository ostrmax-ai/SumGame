package com.example.sumgame.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.sumgame.R
import com.example.sumgame.databinding.FragmentGameFinishedBinding
import com.example.sumgame.domain.entities.GameResult

class GameFinishedFragment : Fragment() {

    private val args by navArgs<GameFinishedFragmentArgs>()

    private val gameResult by lazy {
        args.gameResult
    }

    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding ?: throw RuntimeException("FragmentGameFinishedBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()
        setRetryClickListener()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setRetryClickListener() {
        binding.buttonRetry.setOnClickListener {
            retryGame()
        }
    }

    private fun bindViews() {
        with (binding) {
            emojiResult.setImageResource(getSmileId())
            tvRequiredAnswers.text = String.format(
                getString(R.string.required_score),
                gameResult.gameSettings.minCountOfRightAnswers
            )
            tvRequiredPercentage.text = String.format(
                getString(R.string.required_percentage),
                gameResult.gameSettings.minPercentOfRightAnswers
            )
            tvScoreAnswers.text = String.format(
                getString(R.string.score_answers),
                gameResult.countOfRightAnswers
            )
            tvScorePercentage.text = String.format(
                getString(R.string.score_percentage),
                gameResult.scorePercentage
            )
        }
    }

    private fun getSmileId(): Int {
        return if (gameResult.winner) R.drawable.ic_smile else R.drawable.ic_sad
    }

    private fun retryGame() {
        findNavController().popBackStack()
    }
}