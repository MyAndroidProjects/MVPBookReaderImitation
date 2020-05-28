package ru.lopatin.mvp_moxy_pattern_kotlin.presentation.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_main.*
import ru.lopatin.mvp_moxy_pattern_kotlin.R
import ru.lopatin.mvp_moxy_pattern_kotlin.presentation.fragment.belyaev.BelyaevFragment
import ru.lopatin.mvp_moxy_pattern_kotlin.presentation.fragment.bulgakov.BulgakovFragment

class MainActivity : MvpAppCompatActivity(), MainActivityContractView {

    //   standard
    //   private var presenter: MainActivityContract.Presenter? = null

    // moxy
    @InjectPresenter
    lateinit var presenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.activityIsCreating()
    }

    override fun onStart() {
        super.onStart()
        presenter.activityIsStarting()
        buttonReadBelyaev.setOnClickListener {
            presenter.buttonBelyaevSelected()
        }
        buttonReadBulgakov.setOnClickListener {
            presenter.buttonBulgakovSelected()
        }
    }

    override fun createBelyaevFragment() {
        createFragment(BelyaevFragment.getInstance())
    }

    override fun createBulgakovFragment() {
        createFragment(BulgakovFragment.getInstance())
    }

    override fun setBulgakovData() {
        setBulgakovTitle()
        buttonReadBelyaev.visibility = VISIBLE
        buttonReadBulgakov.visibility = GONE
    }

    override fun setBelyaevData() {
        setBelyaevTitle()
        buttonReadBelyaev.visibility = GONE
        buttonReadBulgakov.visibility = VISIBLE
    }

    private fun createFragment(fragment: Fragment) {
        Log.d("myLog", " createFragment fragment:$fragment")
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        Log.d("myLog", " transaction.replace ")
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun setBulgakovTitle() {
        writerSurnameText.text = getString(R.string.bulgakov_surname)
        writerNameText.text = getString(R.string.bulgakov_name)
        writerPatronymicText.text = getString(R.string.bulgakov_patronymic)
    }

    private fun setBelyaevTitle() {
        writerSurnameText.text = getString(R.string.belyaev_surname)
        writerNameText.text = getString(R.string.belyaev_name)
        writerPatronymicText.text = getString(R.string.belyaev_patronymic)
    }
}
