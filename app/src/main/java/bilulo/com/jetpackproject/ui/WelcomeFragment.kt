package bilulo.com.jetpackproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import bilulo.com.jetpackproject.MainActivity
import bilulo.com.jetpackproject.R

class WelcomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.welcome_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        hideActionBar()
    }

    private fun hideActionBar() {
        (activity as MainActivity).supportActionBar?.hide()
    }
}