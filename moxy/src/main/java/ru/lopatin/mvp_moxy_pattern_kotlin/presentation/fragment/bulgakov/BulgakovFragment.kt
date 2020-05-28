package ru.lopatin.mvp_moxy_pattern_kotlin.presentation.fragment.bulgakov

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_bulgakov.*
import ru.lopatin.mvp_moxy_pattern_kotlin.R

class BulgakovFragment : MvpAppCompatFragment(), BulgakovFragmentContractView {

    companion object {
        @Synchronized
        fun getInstance(): BulgakovFragment {
            return BulgakovFragment()
        }
    }


    @InjectPresenter
    lateinit var presenter: BulgakovFragmentPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_bulgakov, container, false)
    }

    override fun onStart() {
        super.onStart()
        presenter.fragmentIsStarting()

        buttonNext.setOnClickListener {
            presenter.buttonNextPageSelected()
        }
        buttonNextWriter.setOnClickListener {
            presenter.buttonBelyaevSelected()
        }
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
}