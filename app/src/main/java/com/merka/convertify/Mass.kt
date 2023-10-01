package com.merka.convertify

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

private const val kgTog = 1000.0
private const val lbTog = 453.592
private const val ozTog = 28.349500000294

class Mass : AppCompatActivity() {
    private lateinit var kgText: EditText
    private lateinit var gText: EditText
    private lateinit var poundText: EditText
    private lateinit var ozText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mass)
        kgText = findViewById(R.id.kgText)
        gText = findViewById(R.id.gramText)
        poundText = findViewById(R.id.poundText)
        ozText = findViewById(R.id.ounceText)

        kgText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                if (kgText.hasFocus()) {
                    val kg = kgText.text.toString().toDouble()
                    kgText.clearFocus()

                    if (!p0.isNullOrEmpty()) {
                        computeFromUnit(kg, kgTog)
                    } else {
                        kgText.setText(0.toString())
                        val kg = kgText.text.toString().toDouble()
                        computeFromUnit(kg, kgTog)
                    }
                    kgText.requestFocus()
                }
            }
        })

        gText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                if (gText.hasFocus()) {
                    val g = gText.text.toString().toDouble()
                    gText.clearFocus()

                    if (!p0.isNullOrEmpty()) {
                        computeFromUnit(g, 1.0)
                    } else {
                        gText.setText(0.toString())
                        val g = gText.text.toString().toDouble()
                        computeFromUnit(g, 1.0)
                    }
                    gText.requestFocus()
                }
            }
        })

        poundText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                if (poundText.hasFocus()) {
                    val lb = poundText.text.toString().toDouble()
                    poundText.clearFocus()

                    if (!p0.isNullOrEmpty()) {
                        computeFromUnit(lb, lbTog)
                    } else {
                        poundText.setText(0.toString())
                        val lb = poundText.text.toString().toDouble()
                        computeFromUnit(lb, lbTog)
                    }
                    poundText.requestFocus()
                }
            }
        })

        ozText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                if (ozText.hasFocus()) {
                    val oz = ozText.text.toString().toDouble()
                    ozText.clearFocus()

                    if (!p0.isNullOrEmpty()) {
                        computeFromUnit(oz, ozTog)
                    } else {
                        ozText.setText(0.toString())
                        val oz = ozText.text.toString().toDouble()
                        computeFromUnit(oz, ozTog)
                    }
                    ozText.requestFocus()
                }
            }
        })
    }

    private fun getText(): Array<Double> {
        val gram = gText.text.toString().toDouble()
        val kg = kgText.text.toString().toDouble()
        val pound = poundText.text.toString().toDouble()
        val ounce = ozText.text.toString().toDouble()

        return arrayOf(kg, gram, pound, ounce)
    }

    private fun computeFromUnit(value: Double, factor: Double) {
        val gram = value * factor
        val (prevKg, _, _, _) = getText()
        val kg = gram * (1 / kgTog)
        val pound = gram * (1 / lbTog)
        val ounce = gram * (1 / ozTog)

        if (prevKg != kg) {
            kgText.setText(kg.toString())
        }

        gText.setText(gram.toString())
        poundText.setText(pound.toString())
        ozText.setText(ounce.toString())
    }
}
