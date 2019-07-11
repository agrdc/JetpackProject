package bilulo.com.jetpackproject.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule (private val application: Application) {
    @Provides
    @Singleton
    fun provideContext(): Context {
        return application.applicationContext
    }

    /*@Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
    } */
}

