package com.example.myquezappsh

object Constants {

    const val User_name:String="user name" // حتي اتمكن من استدعاء ال name في ال result
    const val Total_questions:String="total questions" //حتي اتمكن من استدعاء ال questions في ال result
    const val Correct_answer:String="correct answer" //حتي اتمكن من استدعاء ال answers في ال result


    fun getquestions():ArrayList<Questions>{
         val questionlist=ArrayList<Questions>()

        val que1=Questions(
            id = 1 , "ما هي الحشرة الوحيدة التي أمر الرسول صلى الله عليه وسلم بقتلها؟",
            "الذبابه ","النحله","الوزغ","الفيل",3
        )
       questionlist.add(que1)


        val que2=Questions(
            id = 2 , "من هم أهل البيت الذين خصهم الله في القرآن الكريم؟",
            "اهل بيت الرسول","المسلمين جميعا","المهاجرين","الانصار",1
        )
        questionlist.add(que2)

        val que3=Questions(
            id = 3 , "واحد من الصحابه الذين تشتاق اليهم الجنه؟",
            "علي بن أبي طالب ","عمر بن الخطاب","زيد ابن ثابت","عمرو بن المغيره",1
        )
        questionlist.add(que3)

        val que4=Questions(
            id = 4 , "ما هي البلد التي يتواجد فيها قبر النبي هود عليه السلام؟",
            "الشرافيه ","حضرموت","المحرص","مكه",2
        )
        questionlist.add(que4)

        val que5=Questions(
            id = 5 , "من هم خاصة الله وأهله؟",
            "اهل العلم ","المجاهدين","الانصار","اهل القران",4
        )
        questionlist.add(que5)

        return questionlist
    }

}