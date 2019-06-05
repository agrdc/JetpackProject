package bilulo.com.jetpackproject.ui.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import bilulo.com.jetpackproject.MainActivity
import androidx.lifecycle.Observer
import bilulo.com.jetpackproject.di.App
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import bilulo.com.jetpackproject.ui.list.viewmodel.ListViewModel
import bilulo.com.jetpackproject.vm.ViewModelFactory
import kotlinx.android.synthetic.main.list_fragment.*
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
        albunsRecyclerView.layoutManager = LinearLayoutManager(activity)
        val listAdapter = bilulo.com.jetpackproject.ui.list.adapter.ListAdapter()
        albunsRecyclerView.adapter = listAdapter
        albunsRecyclerView.addItemDecoration(ListItemMarginDecoration(16))
        listViewModel = ViewModelProviders.of(this, viewModelFactory).get(ListViewModel::class.java)
        listViewModel.init()
        listViewModel.albumList().observe(this, Observer { albumList ->
            listAdapter.setData(albumList)
        })
    }

    private fun showActionBar() {
        (activity as MainActivity).supportActionBar?.show()
    }

}