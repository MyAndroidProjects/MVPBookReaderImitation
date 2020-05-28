package ru.lopatin.mvp_pattern_kotlin.presentation.fragment.belyaev

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.fragment_belyaev.*
import ru.lopatin.mvp_pattern_kotlin.R

class BelyaevFragment : Fragment(), BelyaevFragmentContract.View {
    companion object {
        @Synchronized
        fun getInstance(): BelyaevFragment {
            return BelyaevFragment()
        }
    }

    private var presenter: BelyaevFragmentContract.Presenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_belyaev, container, false)
    }

    override fun onStart() {
        super.onStart()
        setPresenter()
        presenter?.fragmentIsStarting()

        buttonNext.setOnClickListener {
            presenter?.buttonNextPageSelected()
        }
        buttonNextWriter.setOnClickListener {
            presenter?.buttonBulgakovSelected()
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
        showCustomProgressBar(toShow, progressBarFirstBelyaev)
    }

    override fun showProgressBarSecond(toShow: Boolean) {
        showCustomProgressBar(toShow, progressBarSecondBelyaev)
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
        presenter = BelyaevFragmentPresenter
        presenter?.setViewToPresenter(this)
    }

    private fun nullifyPresenter() {
        presenter?.setViewToPresenter(null)
        presenter = null
    }
}