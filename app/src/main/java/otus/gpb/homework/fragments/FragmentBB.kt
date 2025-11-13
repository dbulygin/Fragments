package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import otus.gpb.homework.fragments.databinding.FragmentBBBinding

class FragmentBB : Fragment() {
    private var _binding: FragmentBBBinding? = null
    private val binding get() = _binding!!
    private var isTablet = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isTablet = requireActivity().findViewById<View>(R.id.fragment1) != null

        binding.buttonSendColorToBA.setOnClickListener {
            val color = ColorGenerator.generateColor()
            if (isTablet) {
                sendResult(color, true)
            } else {
                sendResult(color)
                openFragmentBA()
            }
        }
    }

    private fun openFragmentBA() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.containerBA, FragmentBA())
            .addToBackStack(null)
            .commit()
    }

}


