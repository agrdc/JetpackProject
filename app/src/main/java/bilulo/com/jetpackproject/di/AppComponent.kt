package bilulo.com.jetpackproject.di

import bilulo.com.jetpackproject.ui.list.view.ListFragment
import dagger.Component
import javax.inject.Singleton

@Component (modules = [ViewModelModule::class])
@Singleton
interface AppComponent {
    fun inject (listFragment: ListFragment)
}