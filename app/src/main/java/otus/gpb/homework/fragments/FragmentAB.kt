package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentAbBinding

class FragmentAB : Fragment() {
    private var _binding: FragmentAbBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAbBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.containerAB.setBackgroundColor(ColorGenerator.generateColor())
        return view
    }
}