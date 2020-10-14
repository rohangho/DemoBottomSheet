package com.demosample.demobottomsheet

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback


class MainActivity : AppCompatActivity() {
    var sheetBehavior: BottomSheetBehavior<*>? = null
    lateinit var layoutBottomSheet: ConstraintLayout
    lateinit var abc: Button
    lateinit var card: CardView
    lateinit var img: ImageView
    lateinit var textEng: TextView
    lateinit var textHind: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layoutBottomSheet = findViewById(R.id.bcks)
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet)
        card = findViewById(R.id.card)
        img = findViewById(R.id.imageView2)
        textEng = findViewById(R.id.neaningEng)
        textHind = findViewById(R.id.meaningHindi)
        sheetBehavior!!.setBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(view: View, i: Int) {
                if (BottomSheetBehavior.STATE_EXPANDED == i) {
                    img.visibility = View.GONE
                    textHind.visibility = View.GONE
                    textEng.visibility = View.GONE
                    card.visibility = View.VISIBLE
                }
                if (BottomSheetBehavior.STATE_COLLAPSED == i) {
                    card.visibility = View.GONE
                    img.visibility = View.VISIBLE
                    textHind.visibility = View.VISIBLE
                    textEng.visibility = View.VISIBLE
                }
                if (BottomSheetBehavior.STATE_HIDDEN == i) {

                }
            }

            override fun onSlide(view: View, v: Float) {}
        })
        abc = findViewById(R.id.showMe);
        abc.setOnClickListener{
            if(layoutBottomSheet.visibility == View.GONE)
                layoutBottomSheet.visibility = View.VISIBLE
            else
                layoutBottomSheet.visibility = View.GONE
        }


    }




}