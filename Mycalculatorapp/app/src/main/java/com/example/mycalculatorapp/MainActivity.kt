package com.example.mycalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var tvcalcspace:TextView?=null
            var Lastnumeric:Boolean=false
            var lastdot:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvcalcspace=findViewById(R.id.tvcalcspace)



    }
          /* fun equal */
    fun onequal(view: View){
        if (Lastnumeric){
            var tvValue=tvcalcspace?.text.toString()
            var prefix=""
            try {
                /* لتصحيح القيمه السالبه التي لا يقبلها البرنامج وجعلها قيمه موجبه */
                if (tvValue.startsWith("-")){
                    prefix="-"
                    // "substring(1)" - اي انه يتخطي العنصر الاول وهو
                    tvValue=tvValue.substring(1)
                }

                /* operations code */
                if (tvValue.contains("-")) {
                    val splitvalue = tvValue.split("-")
                    var one = splitvalue[0]
                    var two = splitvalue[1]

                    /* لاكمال اكثر من عمليه حسابيه واحده والاكمال علي القيمه الجديده */
                    if (prefix.isNotEmpty()){
                        prefix=one+two
                    }

                    //var result=one.toDouble() - two.toDouble()
                    tvcalcspace?.text = removezeroafterdot((one.toDouble() - two.toDouble()).toString())
                }
                // end operatios code
                else if (tvValue.contains("+")) {
                    val splitvalue = tvValue.split("+")
                    var one = splitvalue[0]
                    var two = splitvalue[1]

                    /* لاكمال اكثر من عمليه حسابيه واحده والاكمال علي القيمه الجديده */
                    if (prefix.isNotEmpty()){
                        prefix=one+two
                    }

                    //var result=one.toDouble() - two.toDouble()
                    tvcalcspace?.text =removezeroafterdot((one.toDouble() + two.toDouble()).toString())
                } // end operatios code

                else if (tvValue.contains("×")) {
                    val splitvalue = tvValue.split("×")
                    var one = splitvalue[0]
                    var two = splitvalue[1]

                    /* لاكمال اكثر من عمليه حسابيه واحده والاكمال علي القيمه الجديده */
                    if (prefix.isNotEmpty()){
                        prefix=one+two
                    }

                    //var result=one.toDouble() - two.toDouble()
                    tvcalcspace?.text = removezeroafterdot((one.toDouble() * two.toDouble()).toString())
                } // end operatios code

                else if (tvValue.contains("÷")) {
                    val splitvalue = tvValue.split("÷")
                    var one = splitvalue[0]
                    var two = splitvalue[1]

                    /* لاكمال اكثر من عمليه حسابيه واحده والاكمال علي القيمه الجديده */
                    if (prefix.isNotEmpty()){
                        prefix=one+two
                    }

                    //var result=one.toDouble() - two.toDouble()
                    tvcalcspace?.text = removezeroafterdot((one.toDouble() / two.toDouble()).toString())
                } // end operatios code

                else if (tvValue.contains("%")) {
                    val splitvalue = tvValue.split("%")
                    var one = splitvalue[0]
                    var two = splitvalue[1]

                    /* لاكمال اكثر من عمليه حسابيه واحده والاكمال علي القيمه الجديده */
                    if (prefix.isNotEmpty()){
                        prefix=one+two
                    }

                    //var result=one.toDouble() - two.toDouble()
                    tvcalcspace?.text =removezeroafterdot ((one.toDouble() % two.toDouble()).toString())
                } // end operatios code

            }catch (e: ArithmeticException){
                e.printStackTrace()
            }
        }

    }

    fun onDigit(view: View){
        tvcalcspace?.append((view as Button).text)  // "append" this is methode if you need add text when press button
        //((view as Button).text)  اكتب النص الخاص بهذا الزر

        Lastnumeric=true
        lastdot=false

    }
    fun hello(view: View){
        Toast.makeText(this, "thank you !!", Toast.LENGTH_SHORT).show()
    }

    fun onclear(view: View){
        tvcalcspace?.text=""
    }
    fun ondecimalpoint(view: View){
        if (Lastnumeric && !lastdot){
            tvcalcspace?.append(".")
            Lastnumeric=false
            lastdot=true

        }
    }
    /*  لتنسيق العوامل ومنع كتابتها بشكل خاطئ او كتابة عاملين متتاليين  */
    // and lemit the operations
    fun onOperator(view: View){
        tvcalcspace?.text?.let {
            if(Lastnumeric && !isoperatorsdded(it.toString()))
            {
                tvcalcspace?.append((view as Button).text)
                Lastnumeric =false
                lastdot=false
            }
        }




    }
private fun removezeroafterdot(result: String):String{
    var value=result
    if (result.contains(".0"))
        value = result.substring(0, result.length - 2)
        //  value=result.substring(0 /* index started */,result.length-2)
    //. , 0 تتعامل معه علي انه حروف وتنقص اثنين هما

    return value
}
    private fun isoperatorsdded(value: String):Boolean {
        return if(value.startsWith("-")){
          false
        }else{
            value.contains("×") ||
                    value.contains("÷")||
                    value.contains("+") ||
                    value.contains("%")||
                    value.contains("-")
        }
    }
}