package bilulo.com.jetpackproject.di

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class App : Application() {
        public var appComponent: AppComponent? = null

        override fun onCreate() {
            super.onCreate()
            AndroidThreeTen.init(this)
            appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        }
}