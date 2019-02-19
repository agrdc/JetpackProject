package bilulo.com.jetpackproject.di

import bilulo.com.jetpackproject.data.api.AlbumsService
import bilulo.com.jetpackproject.repository.AlbumRepository
import bilulo.com.jetpackproject.ui.list.ListFragment
import bilulo.com.jetpackproject.vm.ViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Component (modules = [ViewModelModule::class])
@Singleton
interface AppComponent {
    fun inject (listFragment: ListFragment)
    fun inject(albumRepository: AlbumRepository)
    fun inject (albumsService: AlbumsService)
}