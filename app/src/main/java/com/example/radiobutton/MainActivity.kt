package com.example.radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inisialisasi ID untuk radio group
        val tvfood = findViewById<TextView>(R.id.tv_food)
        val rgfood = findViewById<RadioGroup>(R.id.rg_food)

        //Inisalisasi ID untuk checkbox
        val tvdrink = findViewById<TextView>(R.id.tv_drink)
        val cbmatchalatte = findViewById<CheckBox>(R.id.cb_ml)
        val cbstrawberrymilkshake = findViewById<CheckBox>(R.id.cb_sm)
        val cbicetarolatte = findViewById<CheckBox>(R.id.cb_itl)

        //Inisialisasi ID button order
        val btnorder = findViewById<Button>(R.id.btn_order)
        val bill = findViewById<TextView>(R.id.tv_bill)

        //Inisialisasi ID dari sebuah layout
        val actoast = findViewById<ConstraintLayout>(R.id.act_ctoast)

        //Fungsi keetika button di klik
        btnorder.setOnClickListener {
            val checkFoodRadioButtonId = rgfood.checkedRadioButtonId
            val food = findViewById<RadioButton>(checkFoodRadioButtonId)

            val matchalatte = cbmatchalatte.isChecked
            val strawberrymilkshake = cbstrawberrymilkshake.isChecked
            val icetarolatte = cbicetarolatte.isChecked

            val resultBill = "Anda Memesan : \n" +
                    "${food.text}" +
                    (if (matchalatte) "\nMatcha Latte" else "") +
                    (if (strawberrymilkshake) "\nStrawberry Milkshake" else "") +
                    (if (icetarolatte) "\nIce Taro Latte" else "")

            bill.text = resultBill

//            Toast.makeText(this, "Terimakasih",Toast.LENGTH_LONG).show()

            //Fungsi untuk toast ketika Button Order di klik
            Toast(this).apply {
                duration = Toast.LENGTH_LONG
                view =layoutInflater.inflate(R.layout.activity_ctoast, actoast)
                show()
            }
        }
    }
}