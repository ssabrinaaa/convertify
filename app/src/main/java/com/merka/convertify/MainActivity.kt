package com.merka.convertify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText


private const val kmToCm = 100000.0
private const val meterToCm = 100.0
private const val cmToInch = 0.39
private const val cmToFeet = 0.033
private const val feetTocm = 30.48
private const val inchToCm = 2.54
class MainActivity : AppCompatActivity() {
    private lateinit var kmText: EditText
    private lateinit var meterText: EditText
    private lateinit var cmText: EditText
    private lateinit var feetText: EditText
    private lateinit var inchText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        kmText = findViewById(R.id.kmText)
        meterText = findViewById(R.id.meterText)
        cmText = findViewById(R.id.cmText)
        feetText = findViewById(R.id.feetText)
        inchText = findViewById(R.id.inchText)

        kmText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {

                if (kmText.hasFocus()) {
                    val km = kmText.text.toString().toDouble()
                    kmText.clearFocus()

                    if (!p0.isNullOrEmpty()) {
                        computeFromUnit(km, kmToCm)

                    } else {
                        kmText.setText(0.toString())
                        val km = kmText.text.toString().toDouble()
                        computeFromUnit(km, kmToCm)
                    }

                    kmText.requestFocus()
                }
            }
        })

        meterText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {

                if (meterText.hasFocus()) {
                    val meter = meterText.text.toString().toDouble()
                    meterText.clearFocus()

                    if (!p0.isNullOrEmpty()) {
                        computeFromUnit(meter, meterToCm)

                    } else {
                        meterText.setText(0.toString())
                        val meter = meterText.text.toString().toDouble()
                        computeFromUnit(meter, meterToCm)
                    }

                    meterText.requestFocus()
                }
            }
        })

        cmText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {

                if (cmText.hasFocus()) {
                    val cm = cmText.text.toString().toDouble()
                    cmText.clearFocus()

                    if (!p0.isNullOrEmpty()) {
                        computeFromUnit(cm, 1.0)

                    } else {
                        cmText.setText(0.toString())
                        val cm = cmText.text.toString().toDouble()
                        computeFromUnit(cm, 1.0)

                    }
                    cmText.requestFocus()
                }
            }
        })

        feetText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {

                if (feetText.hasFocus()) {
                    val feet = feetText.text.toString().toDouble()
                    feetText.clearFocus()

                    if (!p0.isNullOrEmpty()) {
                        computeFromUnit(feet, feetTocm)

                    } else {
                        feetText.setText(0.toString())
                        val feet = feetText.text.toString().toDouble()
                        computeFromUnit(feet, feetTocm)

                    }
                    feetText.requestFocus()
                }
            }
        })

        inchText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {

                if (inchText.hasFocus()) {
                    val inch = inchText.text.toString().toDouble()
                    inchText.clearFocus()

                    if (!p0.isNullOrEmpty()) {
                        computeFromUnit(inch, inchToCm)

                    } else {
                        inchText.setText(0.toString())
                        val inch = inchText.text.toString().toDouble()
                        computeFromUnit(inch, inchToCm)
                    }
                    inchText.requestFocus()
                }
            }
        })
    }
    private fun getText(): Array<Double> {
        val meter = meterText.text.toString().toDouble()
        val km = kmText.text.toString().toDouble()
        val cm = cmText.text.toString().toDouble()
        val inch = inchText.text.toString().toDouble()
        val feet = feetText.text.toString().toDouble()
        return arrayOf(km, meter, cm, inch, feet)
    }
    private fun computeFromUnit(value: Double, factor: Double) {
        val cm = value * factor
        val (prevKm, prevMeter, prevCm, prevInch, prevFeet) = getText()
        val km = cm * (1 / kmToCm)
        val meter = cm * (1 / meterToCm)
        val inch = cm * cmToInch
        val feet = (cm * cmToFeet)

        if (prevKm != km) {
            kmText.setText(km.toString())
        }
        meterText.setText(meter.toString())
        cmText.setText(cm.toString())
        inchText.setText(inch.toString())
        feetText.setText(feet.toString())
    }
}

