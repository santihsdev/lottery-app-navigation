package orb.bo.temperature.converter.lotteryappnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import orb.bo.temperature.converter.lotteryappnavigation.databinding.FragmentHomeBinding
import kotlin.random.Random


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.button.setOnClickListener {
            val bundle = bundleOf(
                "name" to binding.editTextText.text.toString(),
                "numbers" to generateRandomNumbers(6, 10, 50).joinToString(" ")
            )
            it.findNavController().navigate(
                R.id.action_homeFragment_to_secondFragment, bundle
            )
        }

        return binding.root
    }

    private fun generateRandomNumbers(count: Int, rangeStart: Int, rangeEnd: Int): List<Int> {
        return List(count) { Random.nextInt(rangeStart, rangeEnd) }
    }

}