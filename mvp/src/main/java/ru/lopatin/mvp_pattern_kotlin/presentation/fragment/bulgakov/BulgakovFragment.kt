package ru.lopatin.mvp_pattern_kotlin.presentation.fragment.bulgakov

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.fragment_bulgakov.*
import ru.lopatin.mvp_pattern_kotlin.R

class BulgakovFragment : Fragment(), BulgakovFragmentContract.View {

    companion object {
        @Synchronized
        fun getInstance(): BulgakovFragment {
            return BulgakovFragment()
        }
    }

    private var presenter: BulgakovFragmentContract.Presenter? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_bulgakov, container, false)
    }

    override fun onStart() {
        super.onStart()
        setPresenter()
        presenter?.fragmentIsStarting()

        buttonNext.setOnClickListener {
            presenter?.buttonNextPageSelected()
        }
        buttonNextWriter.setOnClickListener {
            presenter?.buttonBelyaevSelected()
        }
    }

    override fun onStop() {
        nullifyPresenter()
        super.onStop()
    }

    override fun setText(str: String) {
        pageText.text = str
    }

    override fun showProgressBarFirst(toShow: Boolean) {
        showCustomProgressBar(toShow, progressBarFirstBulgakov)
    }

    override fun showProgressBarSecond(toShow: Boolean) {
        showCustomProgressBar(toShow, progressBarSecondBulgakov)
    }

    private fun showCustomProgressBar(toShow: Boolean, progressBar: ProgressBar) {
        val curVisibility: Int = if (toShow) {
            View.VISIBLE
        } else {
            View.GONE
        }
        progressBar.visibility = curVisibility
    }


    private fun setPresenter() {
        presenter = BulgakovFragmentPresenter
        presenter?.setViewToPresenter(this)
    }

    private fun nullifyPresenter() {
        presenter?.setViewToPresenter(null)
        presenter = null
    }
}