package bilulo.com.jetpackproject.di

import android.app.Application

class App : Application() {
        public var appComponent: AppComponent? = null

        override fun onCreate() {
            super.onCreate()
            appComponent = DaggerAppComponent.create()
        }
}