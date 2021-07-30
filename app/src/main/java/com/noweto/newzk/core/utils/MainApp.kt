package com.noweto.newzk.core.utils

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//~~ definition of our application class
//~~ make hilt work in all app as a DI

@HiltAndroidApp
class MainApp : Application(){
    //~~ Define main app in mainFest ..

}