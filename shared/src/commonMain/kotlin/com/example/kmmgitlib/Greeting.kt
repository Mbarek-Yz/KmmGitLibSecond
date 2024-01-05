package com.example.kmmgitlib

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    fun showHelloWorldToast(message : String , context : Any?) {
        getToast(message,context)
    }
    fun showDialog(messageButtonPositive: String,messageButtonNegative: String,message: String,title: String, context: Any?){
        getDialog(messageButtonPositive,messageButtonNegative,message,title,context)
    }
    fun showNotification(title: String, message: String, context :Any?, drawable :Int){
        NotificationManager(title, message, context, drawable)
    }
}