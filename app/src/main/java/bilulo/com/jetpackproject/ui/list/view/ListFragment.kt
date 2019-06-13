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
import android.text.Spannable
import android.text.style.TypefaceSpan
import android.text.SpannableString
import android.view.animation.AnimationUtils.loadLayoutAnimation
import bilulo.com.jetpackproject.R


class ListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var listViewModel: ListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity!!.application as App).appComponent!!.inject(this)
        configureActionBar()
        configureRecyclerView()
        initializeRecyclerViewData()
    }

    private fun initializeRecyclerViewData() {
        val listAdapter = bilulo.com.jetpackproject.ui.list.adapter.ListAdapter()
        albunsRecyclerView.adapter = listAdapter
        listViewModel = ViewModelProviders.of(this, viewModelFactory).get(ListViewModel::class.java)
        listViewModel.init()
        listViewModel.albumList().observe(this, Observer { albumList ->
            progressBar.visibility = View.GONE
            albunsRecyclerView.visibility = View.VISIBLE
            listAdapter.setData(albumList)
            albunsRecyclerView.scheduleLayoutAnimation()
        })
    }

    private fun configureRecyclerView() {
        albunsRecyclerView.layoutManager = LinearLayoutManager(activity)
        albunsRecyclerView.addItemDecoration(ListItemMarginDecoration(16))
        val resId = R.anim.layout_anim_up_to_down
        val animationController = loadLayoutAnimation(context, resId)
        albunsRecyclerView.layoutAnimation = animationController
    }

    private fun configureActionBar() {
        val supportActionBar = (activity as MainActivity).supportActionBar
        supportActionBar?.show()
        val title = SpannableString(ListFragment::class.simpleName)
        val span = TypefaceSpan("neuton_regular.ttf")
        title.setSpan(span, 0, title.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        supportActionBar?.title = title
    }

}