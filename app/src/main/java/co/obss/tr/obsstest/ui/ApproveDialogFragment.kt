package co.obss.tr.obsstest.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import co.obss.tr.obsstest.R

class ApproveDialogFragment : DialogFragment(R.layout.dialog_approve) {

    companion object {
        const val TAG = "ApproveDialogFragment"
    }

    var approveListener: ApproveListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.button).setOnClickListener {
            approveListener?.onButtonClick()
            dismiss()
        }
    }

}