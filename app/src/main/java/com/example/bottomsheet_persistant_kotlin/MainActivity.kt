package com.example.bottomsheet_persistant_kotlin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.bottomsheet_persistant_kotlin.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var bottomSheetDialog:BottomSheetDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bottomSheetLayout:LinearLayout=findViewById(R.id.bottomSheet)
        val bottomSheetBehavior=BottomSheetBehavior.from(bottomSheetLayout)
        /*bottomSheetBehavior.state=BottomSheetBehavior.STATE_COLLAPSED
        bottomSheetBehavior.state=BottomSheetBehavior.STATE_EXPANDED
        bottomSheetBehavior.state=BottomSheetBehavior.STATE_HIDDEN*/

        //visible part of bottom sheet
        //bottomSheetBehavior.peekHeight = 50
        //initial state hide_able or not
        //bottomSheetBehavior.isHideable=false

        binding.buttonId.setOnClickListener {
           // bottomSheetBehavior.peekHeight = 200
          //  bottomSheetBehavior.isHideable=false
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            else
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

     /*   var bottomSheetBehaviorCallback =
            object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    bottomSheet.visibility=View.INVISIBLE
                }
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    bottomSheetBehavior.peekHeight = 0
                    bottomSheet.visibility=View.VISIBLE
                }
            }*/
        bottomSheetBehavior.addBottomSheetCallback(object :
                BottomSheetBehavior.BottomSheetCallback() {

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // handle onSlide

            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> Toast.makeText(this@MainActivity, "STATE_COLLAPSED", Toast.LENGTH_SHORT).show()
                    BottomSheetBehavior.STATE_EXPANDED -> Toast.makeText(this@MainActivity, "STATE_EXPANDED", Toast.LENGTH_SHORT).show()
                    BottomSheetBehavior.STATE_DRAGGING -> Toast.makeText(this@MainActivity, "STATE_DRAGGING", Toast.LENGTH_SHORT).show()
                    BottomSheetBehavior.STATE_SETTLING -> Toast.makeText(this@MainActivity, "STATE_SETTLING", Toast.LENGTH_SHORT).show()
                    BottomSheetBehavior.STATE_HIDDEN -> Toast.makeText(this@MainActivity, "STATE_HIDDEN", Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(this@MainActivity, "OTHER_STATE", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}

