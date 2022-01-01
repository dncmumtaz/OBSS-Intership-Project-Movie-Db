package co.obss.tr.obsstest.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import co.obss.tr.obsstest.R
import co.obss.tr.obsstest.ui.Constants.PARAM_MAIN_FRAGMENT_VALUE_KEY

class SecondFragment: Fragment(R.layout.fragment_main) {

    companion object {

        const val PARAM_MAIN_FRAGMENT_VALUE_KEY = "key"

        fun newInstance(text: String): SecondFragment {
            val args = Bundle()
            args.putString(PARAM_MAIN_FRAGMENT_VALUE_KEY, text)
            val fragment = SecondFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val some = arguments?.getString(PARAM_MAIN_FRAGMENT_VALUE_KEY)
        view.findViewById<TextView>(R.id.text).text = "Second"
    }

    override fun onResume() {
        super.onResume()
        val some = arguments?.getString(PARAM_MAIN_FRAGMENT_VALUE_KEY)
        (requireContext() as FragmentTransactionListener).changeTitle("Second")
    }
}