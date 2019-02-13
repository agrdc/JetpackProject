package bilulo.com.jetpackproject.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import bilulo.com.jetpackproject.MainActivity
import bilulo.com.jetpackproject.R
import androidx.lifecycle.Observer


class ListFragment : Fragment() {

    private lateinit var listViewModel: ListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        showActionBar()
        listViewModel = ViewModelProviders.of(activity!!).get(ListViewModel::class.java)
        listViewModel.init()
        listViewModel.albumList().observe(this, Observer { albumList ->
            //update UI
        })

    }

    private fun showActionBar() {
        (activity as MainActivity).supportActionBar?.show()
    }

}