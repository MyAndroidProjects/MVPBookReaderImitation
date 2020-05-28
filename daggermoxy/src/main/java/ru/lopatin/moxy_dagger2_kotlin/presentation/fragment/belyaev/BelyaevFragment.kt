package ru.lopatin.moxy_dagger2_kotlin.presentation.fragment.belyaev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_belyaev.*
import ru.lopatin.moxy_dagger2_kotlin.R

class BelyaevFragment : MvpAppCompatFragment(), BelyaevFragmentContractView {
    companion object {
        @Synchronized
        fun getInstance(): BelyaevFragment {
            return BelyaevFragment()
        }
    }

    @InjectPresenter
    lateinit var presenter: BelyaevFragmentPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_belyaev, container, false)
    }

    override fun onStart() {
        super.onStart()
        presenter.fragmentIsStarting()

        buttonNext.setOnClickListener {
            presenter.buttonNextPageSelected()
        }
        buttonNextWriter.setOnClickListener {
            presenter.buttonBulgakovSelected()
        }
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

}