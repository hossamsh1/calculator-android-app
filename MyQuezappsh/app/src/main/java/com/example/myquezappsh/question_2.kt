package com.example.myquezappsh

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class question_2 : AppCompatActivity() ,View.OnClickListener {

    private var mcurrentposition:Int=1
    private var mquestionslist:ArrayList<Questions>?=null
    private var mselectedquistions :Int=0
    private var musername:String?=null
    private var mCorrectanswer:Int=0

    private var progressBar: ProgressBar? = null
    private var tvprogress:TextView?=null
    private var tvquestion:TextView?=null

    private var tvoptionone:TextView?=null
    private var tvoptiontwo:TextView?=null
    private var tvoptionthree:TextView?=null
    private var tvoptionfour:TextView?=null
    private var btnsubmet: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question2)

        // inishialize text view and buttoms
        musername=intent.getStringExtra(Constants.User_name)
        progressBar=findViewById(R.id.progresspar)
        tvprogress=findViewById(R.id.tv_progres)
        tvquestion=findViewById(R.id.tv_Question)
        tvoptionone = findViewById(R.id.option_one)
        tvoptiontwo = findViewById(R.id.option_two)
        tvoptionthree = findViewById(R.id.option_three)
        tvoptionfour = findViewById(R.id.option_fore)
        btnsubmet=findViewById(R.id.but_submit)

        // cleck buttons
        tvoptionone?.setOnClickListener(this)
        tvoptiontwo?.setOnClickListener(this)
        tvoptionthree?.setOnClickListener(this)
        tvoptionfour?.setOnClickListener(this)
        btnsubmet?.setOnClickListener(this)


        mquestionslist=Constants.getquestions()

        setQuestions()
        defultoptionsvew()


    }

    private fun defultoptionsvew(){
        val options=ArrayList<TextView>()
        tvoptionone?.let {
            options.add(0 ,it)
        }

        tvoptiontwo?.let {
            options.add(1 ,it)
        }

        tvoptionthree?.let {
            options.add(2 ,it)
        }

        tvoptionfour?.let {
            options.add(3 ,it)
        }
        for (option in options){
            option.setTextColor(Color.parseColor("#131416"))
            option.typeface=Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this ,R.drawable.droable_png)
        }
    }

    private fun setQuestions() {
        defultoptionsvew()
        val question: Questions = mquestionslist!![mcurrentposition - 1]
        progressBar?.progress = mcurrentposition
        tvprogress?.text = "$mcurrentposition / ${progressBar?.max}"
        tvquestion?.text = question.questions
        tvoptionone?.text = question.optionone
        tvoptiontwo?.text = question.optiontwo
        tvoptionthree?.text = question.optionthree
        tvoptionfour?.text = question.optionfore

        if (mcurrentposition==mquestionslist!!.size){
            btnsubmet?.text="FINISH"
        }else{
            btnsubmet?.text="SUBMIT"
        }
    }

    private fun selectedoptionview(tv:TextView , selectedoptionnum:Int){
        defultoptionsvew()
        mselectedquistions=selectedoptionnum
        tv.setTextColor(Color.parseColor("#648490"))
        tv.setTypeface(tv.typeface ,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this ,R.drawable.selection_option_oder_pg)

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option_one ->{
                tvoptionone?.let { selectedoptionview(it ,1) }
            }
            R.id.option_two ->{
                tvoptiontwo?.let { selectedoptionview(it ,2) }
            }
            R.id.option_three ->{
                tvoptionthree?.let { selectedoptionview(it ,3) }
            }
            R.id.option_fore ->{
                tvoptionfour?.let { selectedoptionview(it ,4) }
            }
            R.id.but_submit ->{
               if(mselectedquistions==0){
                   mcurrentposition++

                   when{
                       mcurrentposition<=mquestionslist!!.size ->{
                           setQuestions()
                       } else ->{

                       val intent=Intent(this,resultbage::class.java)
                       intent.putExtra(Constants.User_name,musername)
                       intent.putExtra(Constants.Correct_answer,mCorrectanswer)
                       intent.putExtra(Constants.Total_questions,mquestionslist?.size)
                       startActivity(intent)
                       finish()

                       Toast.makeText(this, "Quiz Finished! Thank you!!", Toast.LENGTH_SHORT).show()

                   }
                   }
               }else {
                   val question=mquestionslist?.get(mcurrentposition-1)
                   if (question!!.correctanswer!=mselectedquistions){
                       answerview(mselectedquistions ,R.drawable.defult_option_oder_pg)
                   }else{
                       mCorrectanswer = mCorrectanswer!! + 1
                   }
                   answerview(question.correctanswer,R.drawable.correct_option_oder_pg)

                   if(mcurrentposition==mquestionslist?.size){
                       btnsubmet?.text="FINISH"
                   }else{
                       btnsubmet?.text="GO TO NEXT QUESTION"
                   }
                   mselectedquistions=0
               }
            }
        }
    }

    private fun answerview(answer:Int ,drwableview:Int){
        when(answer){
            1 ->{
                tvoptionone?.background=ContextCompat.getDrawable(this , drwableview)
            }
            2 ->{
                tvoptiontwo?.background=ContextCompat.getDrawable(this , drwableview)
            }
            3 ->{
                tvoptionthree?.background=ContextCompat.getDrawable(this , drwableview)
            }
            4 ->{
                tvoptionfour?.background=ContextCompat.getDrawable(this , drwableview)
            }
        }
    }
}



