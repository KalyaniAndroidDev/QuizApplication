package com.example.quizapplication.gamewithnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.quizapplication.R
import com.example.quizapplication.databinding.GameWithNavigationFragmentBinding

class GameWithNavigationFragment : Fragment() {

    data class GameQuestionAnswers(
        var question: String,
        var optionList: List<String>,
        var correctAnswer: Int
    )

    lateinit var random: GameQuestionAnswers
    private lateinit var binding: GameWithNavigationFragmentBinding
    private lateinit var questions: MutableList<GameQuestionAnswers>
    private var questionCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.game_with_navigation_fragment,
            container,
            false
        )
        createQuestionAnswerList()
        random = setDataToRadioGroup()
        // Bind this fragment class to the layout
        binding.game = this
        binding.submitButton.setOnClickListener(OnClickListener {
            val radioButtonID: Int = binding.questionRadioGroup.checkedRadioButtonId
            val radioButton: View = binding.questionRadioGroup.findViewById(radioButtonID)
            val idx: Int = binding.questionRadioGroup.indexOfChild(radioButton)

            if (questionCount <= 2) {
                if (idx == random.correctAnswer) {
                    Toast.makeText(activity, "Your answer is right", Toast.LENGTH_SHORT).show()
                    questionCount += 1
                    binding.invalidateAll()
                    random = setDataToRadioGroup()
                } else {
                    Toast.makeText(activity, "Your answer is wrong", Toast.LENGTH_SHORT).show()
                    // Game over! A wrong answer sends us to the gameOverFragment.
                    view?.findNavController()
                        ?.navigate(R.id.action_gameFragment_to_gameOverFragment)
                }
            } else {
                // We've won!  Navigate to the gameWonFragment.
                view?.findNavController()
                    ?.navigate(R.id.action_gameFragment_to_gameWonFragment)
            }
        })
        return binding.root
    }

    private fun setDataToRadioGroup(): GameQuestionAnswers {
        binding.invalidateAll()
        binding.questionRadioGroup.clearCheck()
        return questions.random()
    }

    fun createQuestionAnswerList() {
        questions = mutableListOf(
            GameQuestionAnswers(
                question = "What is Android Jetpack?",
                optionList = listOf("All of these", "Tools", "Documentation", "Libraries"),
                correctAnswer = 1
            ),
            GameQuestionAnswers(
                question = "What is the base class for layouts?",
                optionList = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot"),
                correctAnswer = 2
            ),
            GameQuestionAnswers(
                question = "What layout do you use for complex screens?",
                optionList = listOf(
                    "ConstraintLayout",
                    "GridLayout",
                    "LinearLayout",
                    "FrameLayout"
                ), correctAnswer = 3
            ),
            GameQuestionAnswers(
                question = "What do you use to push structured data into a layout?",
                optionList = listOf(
                    "Data binding",
                    "Data pushing",
                    "Set text",
                    "An OnClick method"
                ), correctAnswer = 2
            ),
            GameQuestionAnswers(
                question = "What method do you use to inflate layouts in fragments?",
                optionList = listOf(
                    "onCreateView()",
                    "onActivityCreated()",
                    "onCreateLayout()",
                    "onInflateLayout()"
                ), correctAnswer = 2
            ),
            GameQuestionAnswers(
                question = "What's the build system for Android?",
                optionList = listOf("Gradle", "Doddle", "Grodle", "Groyle"), correctAnswer = 2
            ),
            GameQuestionAnswers(
                question = "Which class do you use to create a vector drawable?",
                optionList = listOf(
                    "VectorDrawable",
                    "AndroidVectorDrawable",
                    "DrawableVector",
                    "AndroidVector"
                ), correctAnswer = 1
            ),
            GameQuestionAnswers(
                question = "Which one of these is an Android navigation component?",
                optionList = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher"),
                correctAnswer = 2
            ),
            GameQuestionAnswers(
                question = "Which XML element lets you register an activity with the launcher activity?",
                optionList = listOf(
                    "intent-filter",
                    "app-registry",
                    "launcher-registry",
                    "app-launcher"
                ), correctAnswer = 3
            ),
            GameQuestionAnswers(
                question = "What do you use to mark a layout for data binding?",
                optionList = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>"),
                correctAnswer = 1
            )
        )
    }

    companion object {
        fun newInstance() = GameWithNavigationFragment()
    }
}