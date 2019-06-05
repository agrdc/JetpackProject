package bilulo.com.jetpackproject.di

import dagger.Module
import androidx.lifecycle.ViewModelProvider
import bilulo.com.jetpackproject.vm.ViewModelFactory
import dagger.Binds
import androidx.lifecycle.ViewModel
import bilulo.com.jetpackproject.ui.list.viewmodel.ListViewModel
import dagger.multibindings.IntoMap



@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    internal abstract fun listViewModel(listViewModel: ListViewModel): ViewModel
}