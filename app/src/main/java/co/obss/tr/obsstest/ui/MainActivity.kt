package co.obss.tr.obsstest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import co.obss.tr.obsstest.R
import co.obss.tr.obsstest.ui.Constants.PARAM_MAIN_FRAGMENT_VALUE_KEY
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity(R.layout.activity_main), FragmentTransactionListener {


    lateinit var toolbar: MaterialToolbar

    var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "navigation", Toast.LENGTH_SHORT).show()
        }
        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {

                    supportFragmentManager.commit {
                        count += 1
                        val bundle = bundleOf(PARAM_MAIN_FRAGMENT_VALUE_KEY to "hello $count")
                        setReorderingAllowed(true)
                        replace<MainFragment>(R.id.fragment_container, args = bundle)
                        addToBackStack("$count")
                    }
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

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                val fragment = MainFragment.newInstance("hello")
                add(R.id.fragment_container, fragment)
            }
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

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStackImmediate()
        } else {
            super.onBackPressed()
        }
    }

    override fun changeLog(value: Int) {
        Log.i("asdas", "asda")
    }

    override fun changeTitle(title: String?) {
        toolbar.title = title
    }

}