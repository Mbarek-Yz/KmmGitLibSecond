package com.example.kmmgitlib

import platform.UIKit.UIAlertAction
import platform.UIKit.UIAlertActionStyleCancel
import platform.UIKit.UIAlertActionStyleDefault
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyleAlert
import platform.UIKit.UIViewController

actual fun getDialog(messageButtonPositive: String,messageButtonNegative: String,message: String,title : String ,context: Any?) {
    print("ModuleKmm: Fun getToast iOS")
    val view = context as? UIViewController
    val alertController = UIAlertController.alertControllerWithTitle(
        title = title,
        message = message,
        preferredStyle = UIAlertControllerStyleAlert
    )

    val okAction = UIAlertAction.actionWithTitle(
        title = messageButtonPositive,
        style = UIAlertActionStyleDefault,
        handler = null
    )
    val cancelAction = UIAlertAction.actionWithTitle(
        title = messageButtonNegative,
        style = UIAlertActionStyleCancel,
        handler = null
    )

    alertController.addAction(okAction)
    alertController.addAction(cancelAction)
    view?.presentViewController(alertController, animated = true, completion = null)
}