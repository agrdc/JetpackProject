package bilulo.com.jetpackproject.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import bilulo.com.jetpackproject.MainActivity
import bilulo.com.jetpackproject.R
import kotlinx.android.synthetic.main.welcome_fragment.*

class WelcomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.welcome_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        hideActionBar()
        initListeners()
    }

    private fun hideActionBar() {
        (activity as MainActivity).supportActionBar?.hide()
    }

    private fun initListeners() {
        continueButton.setOnClickListener {
           Navigation.findNavController(view!!).navigate(R.id.action_welcomeFragment_to_listFragment)
        }
    }
}