package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import otus.gpb.homework.fragments.databinding.FragmentABinding

class FragmentA : Fragment() {
    private var _binding: FragmentABinding? = null
    val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)

        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val count = childFragmentManager.backStackEntryCount
//                    Toast.makeText(requireContext(), "BackStack count: $count", Toast.LENGTH_SHORT)
//                        .show()
                    when {
                        count > 1 -> childFragmentManager.popBackStack()
                        count == 1 -> {
                            binding.buttonA.visibility = View.VISIBLE
                            binding.textViewA.visibility = View.VISIBLE

                            childFragmentManager.popBackStack()
                        }
                        count == 0 -> requireActivity().finish()
                        else -> {
                            isEnabled = false
                            requireActivity().onBackPressedDispatcher.onBackPressed()
                        }
                    }
                }
            })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentABinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonA.setOnClickListener {
            openFragmentAA()
        }
    }

    private fun openFragmentAA() {
        val fragmentAA = FragmentAA()
        childFragmentManager.beginTransaction()
            .replace(R.id.containerA, fragmentAA)
            .addToBackStack(null)
            .commit()

        binding.buttonA.visibility = View.GONE
        binding.textViewA.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}