package com.example.deron.t1_MVP


interface MVPContract {
    interface View {
        fun showMessage(message: String)
    }

    interface Presenter {
        fun loadData()
    }
}

class MVPPresenter(
    val view: MVPContract.View?
) : MVPContract.Presenter {

    override fun loadData() {
        val data = getDataFromServer()
        view?.showMessage(data)
    }

    private fun getDataFromServer(): String {
        return "Get Successful"
    }
}