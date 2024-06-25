package orb.bo.temperature.converter.lotteryappnavigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import orb.bo.temperature.converter.lotteryappnavigation.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_second, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        val lotteryNumbers = requireArguments().getString("numbers")
        val name = requireArguments().getString("name")

        binding.textView.text = lotteryNumbers

        binding.button2.setOnClickListener() {
            val share = Intent.createChooser(Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "$name's lottery numbers are: $lotteryNumbers")
                type = "text/plain"
            }, null)
            startActivity(share)
        }


        return binding.root
    }
}