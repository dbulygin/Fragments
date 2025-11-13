package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private var binding: ActivityFirstBinding? = null
    private lateinit var fragmentA: FragmentA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        if (savedInstanceState == null) {
            fragmentA = FragmentA()
        } else {
            fragmentA = supportFragmentManager.findFragmentByTag("FragmentA") as FragmentA
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentA_container, fragmentA, "FragmentA")
            .addToBackStack(null)
            .commit()
    }
}