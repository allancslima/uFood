package br.ufal.ic.ufood.presentation.shared.mvp

import java.lang.ref.WeakReference

open class Presenter<View>(viewClass: Class<View>) {

    private lateinit var viewReference: WeakReference<View>
    protected val view: View
        get() = viewReference.get()!!

    init {
        if (!viewClass.isInterface) {
            throw IllegalArgumentException("The class ${viewClass.name} must be an interface.")
        }
    }

    fun attachView(view: View) {
        viewReference = WeakReference(view)
    }

    fun detachView() {
        viewReference.clear()
    }

}
