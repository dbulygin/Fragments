package otus.gpb.homework.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.setFragmentResultListener
import otus.gpb.homework.fragments.databinding.FragmentBABinding

class FragmentBA : Fragment() {
    private var _binding: FragmentBABinding? = null
    private val binding get() = _binding!!
    private var isTablet = false

    override fun onAttach(context: Context) {
        super.onAttach(context)

        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val count = childFragmentManager.backStackEntryCount
                    Toast.makeText(requireContext(), "BackStack count: $count", Toast.LENGTH_SHORT)
                        .show()
                    when {
                        count > 1 -> childFragmentManager.popBackStack()
                        count == 1 -> {
                            binding.buttonBA.visibility = View.VISIBLE
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
        _binding = FragmentBABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isTablet = requireActivity().findViewById<View>(R.id.fragment1) != null

        observeResult(isTablet) { color ->
            binding.containerBA.setBackgroundColor(color)
        }

        if (isTablet) {
            binding.buttonBA.visibility = View.GONE
        }

        binding.buttonBA.setOnClickListener {
            openFragmentBB()
        }
    }

    private fun openFragmentBB() {
        val fragmentBB = FragmentBB()
        parentFragmentManager.beginTransaction()
            .replace(R.id.containerBA, fragmentBB, "FragmentBB")
            .addToBackStack(null)
            .commit()

        binding.buttonBA.visibility = View.GONE
    }

    fun showButtonBA() {
        binding.buttonBA.visibility = View.VISIBLE
    }
}