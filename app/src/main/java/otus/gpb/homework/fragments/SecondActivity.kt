package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private var binding: ActivitySecondBinding? = null
    private lateinit var fragmentB: FragmentB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        if (savedInstanceState == null) {
            fragmentB = FragmentB()
        } else {
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentB_container, fragmentB)
            .commit()
    }
}