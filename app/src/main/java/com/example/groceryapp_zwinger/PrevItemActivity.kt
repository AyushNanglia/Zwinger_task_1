package com.example.groceryapp_zwinger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PrevItemActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.previtem_act)

        supportFragmentManager.beginTransaction()
            .replace(R.id.previtem_framelay,frag_prev_items())
            .addToBackStack("Prev Item")
            .commit()
        supportActionBar?.title="Previously Added Items"

    }
}