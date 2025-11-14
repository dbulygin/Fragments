package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import otus.gpb.homework.fragments.databinding.FragmentAaBinding

class FragmentAA : Fragment() {
    private var _binding: FragmentAaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAaBinding.inflate(inflater, container, false)
        val view = binding.root
        observeResult(true) { color ->
            binding.containerAA.setBackgroundColor(color)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAB.setOnClickListener {
            openFragmentAB()
        }
    }

    private fun openFragmentAB() {
        val fragmentAB = FragmentAB()
        val color = ColorGenerator.generateColor()
        fragmentAB.arguments = bundleOf("color" to color)
        childFragmentManager.beginTransaction()
            .replace(R.id.containerAA, fragmentAB)
            .addToBackStack(null)
            .commit()

        binding.buttonAB.visibility = View.GONE
        binding.textViewB.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}