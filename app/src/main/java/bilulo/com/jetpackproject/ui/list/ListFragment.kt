package bilulo.com.jetpackproject.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import bilulo.com.jetpackproject.MainActivity
import androidx.lifecycle.Observer
import bilulo.com.jetpackproject.di.App
import androidx.lifecycle.ViewModelProviders
import bilulo.com.jetpackproject.vm.ViewModelFactory
import javax.inject.Inject



class ListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var listViewModel: ListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(bilulo.com.jetpackproject.R.layout.list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        showActionBar()
        (activity!!.application as App).appComponent!!.inject(this)
        listViewModel = ViewModelProviders.of(this, viewModelFactory).get(ListViewModel::class.java)
        listViewModel.init()
        listViewModel.albumList().observe(this, Observer { albumList ->

        })
    }

    private fun showActionBar() {
        (activity as MainActivity).supportActionBar?.show()
    }

}