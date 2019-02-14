package bilulo.com.jetpackproject.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import bilulo.com.jetpackproject.MainActivity
import androidx.lifecycle.Observer
import javax.inject.Inject
import bilulo.com.jetpackproject.di.App







class ListFragment : Fragment() {

    @Inject
    lateinit var listViewModel: ListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(bilulo.com.jetpackproject.R.layout.list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        showActionBar()
        (activity!!.application as App).appComponent!!.inject(this)
        listViewModel.init()
        listViewModel.albumList().observe(this, Observer { albumList ->
            //update UI
        })

    }

    private fun showActionBar() {
        (activity as MainActivity).supportActionBar?.show()
    }

}