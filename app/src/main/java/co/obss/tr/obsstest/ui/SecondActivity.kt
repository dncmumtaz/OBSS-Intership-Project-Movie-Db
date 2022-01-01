package co.obss.tr.obsstest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import co.obss.tr.obsstest.R
import com.google.android.material.appbar.MaterialToolbar

class SecondActivity : AppCompatActivity() {

    lateinit var toolbar: MaterialToolbar
    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val currentIntent = intent
        val key = currentIntent.getStringExtra("key")
        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("result", "Sonuc")
            setResult(1, resultIntent)
            setResult(2, resultIntent)
            onBackPressed()
        }
        text = findViewById(R.id.text)
        text.text = key
    }

}