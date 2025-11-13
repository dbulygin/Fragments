package otus.gpb.homework.fragments

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import otus.gpb.homework.fragments.databinding.ActivityThirdBinding

class ThirdActivity : FragmentActivity() {
    private var binding: ActivityThirdBinding? = null
    private lateinit var fragmentBA: FragmentBA
    private lateinit var fragmentBB: FragmentBB
    private var isTablet = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        determinePaneLayout()

        fragmentBA = supportFragmentManager.findFragmentByTag("FragmentBA") as? FragmentBA ?: FragmentBA()
        fragmentBB = supportFragmentManager.findFragmentByTag("FragmentBB") as? FragmentBB ?: FragmentBB()

        if (isTablet) {
            if (supportFragmentManager.findFragmentByTag("FragmentBB")?.view?.parent == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment1, fragmentBB, "FragmentBB")
                    .commit()
            }
            if (supportFragmentManager.findFragmentByTag("FragmentBA")?.view?.parent == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.containerBA, fragmentBA, "FragmentBA")
                    .commit()
            }
        } else {
            if (supportFragmentManager.findFragmentByTag("FragmentBA")?.view?.parent == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentC_container, fragmentBA, "FragmentBA")
                    .commit()
            }
        }
    }

    private fun determinePaneLayout() {
        val containerBA = binding?.root?.findViewById<android.view.View>(R.id.containerBA)
        val fragment1 = binding?.root?.findViewById<android.view.View>(R.id.fragment1)
        isTablet = containerBA != null && fragment1 != null
        Toast.makeText(this, "isTablet: $isTablet", Toast.LENGTH_SHORT).show()
    }
}