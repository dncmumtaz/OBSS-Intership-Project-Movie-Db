package co.obss.tr.obsstest.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.findNavController
import co.obss.tr.obsstest.R
import co.obss.tr.obsstest.ui.Constants.PARAM_MAIN_FRAGMENT_VALUE_KEY
import com.google.android.material.appbar.MaterialToolbar

class NavigationActivity : AppCompatActivity(R.layout.activity_navigation), FragmentTransactionListener, ApproveListener {

    lateinit var toolbar: MaterialToolbar

    var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            val dialog = ApproveDialogFragment()
            dialog.approveListener = this
            dialog.show(supportFragmentManager, ApproveDialogFragment.TAG)
        }
        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    findNavController(R.id.nav_controller).navigate(R.id.sadasd)
                }
                R.id.favoritee -> {
                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("key", "Deneme")
                    intent.putExtra("key2", "Deneme2")
                    startActivityForResult(intent, 100)
                }
            }
            true
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) {
            if (resultCode == 1) {
                val result = data?.getStringExtra("result")
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun changeLog(value: Int) {
        Log.i("asdas", "asda")
    }

    override fun changeTitle(title: String?) {
        toolbar.title = title
    }

    override fun onButtonClick() {
        Toast.makeText(this@NavigationActivity, "Tıklandı", Toast.LENGTH_SHORT).show()
    }

}