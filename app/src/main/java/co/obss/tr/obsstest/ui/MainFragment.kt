package co.obss.tr.obsstest.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import co.obss.tr.obsstest.R
import co.obss.tr.obsstest.ui.Constants.PARAM_MAIN_FRAGMENT_VALUE_KEY

class MainFragment : Fragment(R.layout.fragment_main) {

    companion object {

        const val PARAM_MAIN_FRAGMENT_VALUE_KEY = "key"

        fun newInstance(text: String): MainFragment {
            val args = Bundle()
            args.putString(PARAM_MAIN_FRAGMENT_VALUE_KEY, text)
            val fragment = MainFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val some = arguments?.getString(PARAM_MAIN_FRAGMENT_VALUE_KEY)
        //view.findViewById<TextView>(R.id.text).text = some
        view.findViewById<TextView>(R.id.text).setOnClickListener {
            findNavController().navigate(R.id.action_to_list)
        }
    }

    override fun onResume() {
        super.onResume()
        val some = arguments?.getString(PARAM_MAIN_FRAGMENT_VALUE_KEY)
        //(requireContext() as FragmentTransactionListener).changeTitle(some)
    }
}