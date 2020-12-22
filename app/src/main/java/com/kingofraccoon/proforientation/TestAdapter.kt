package com.kingofraccoon.proforientation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class TestAdapter(): RecyclerView.Adapter<TestAdapter.Companion.TestViewHolder>(), ItemTouchHelperAdapter {
    var listTests = mutableListOf<Test>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        return TestViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.test_recycler, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.bind(listTests[position], position)
    }

    override fun getItemCount(): Int = listTests.size

    companion object{
        class TestViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val textView : TextView = view.findViewById(R.id.text)
            val radioFirst : RadioButton = view.findViewById(R.id.answer1)
            val radioSecond : RadioButton = view.findViewById(R.id.answer2)
            val radioThird : RadioButton = view.findViewById(R.id.answer3)
            fun bind(test: Test, position: Int){
                radioThird.isChecked = false
                radioSecond.isChecked = false
                radioFirst.isChecked = false
                textView.text = test.text
                radioSecond.text = "Затрудняюсь ответить"
                when(position){
                    18 -> {
                        radioFirst.text = "Логичность текста"
                        radioThird.text = "Образность изложения"
                    }
                    21 -> {
                        radioFirst.text = "Обеспечивала меня нужной порцией адреналина"
                        radioThird.text = "Давала бы мне ощущение спокойствия и надежности"
                    }
                    29 -> {
                        radioFirst.text = "Терпеливо стараюсь найти решение"
                        radioThird.text = "Начинаю нервничать и злиться"
                    }
                    else ->{
                        radioFirst.text = "Да"
                        radioThird.text = "Нет"
                    }
                }
                radioFirst.setOnClickListener {
                    radioThird.isChecked = false
                    radioSecond.isChecked = false
                    AllTests.setValueBool(true)
                }
                radioSecond.setOnClickListener {
                    radioThird.isChecked = false
                    radioFirst.isChecked = false
                    AllTests.setValueBool(true)
                }
                radioThird.setOnClickListener {
                    radioFirst.isChecked = false
                    radioSecond.isChecked = false
                    AllTests.setValueBool(true)
                }
            }
        }
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition)
            Log.d("Item", "Yes")
        else
            Log.d("Item", "No")
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        listTests.removeAt(position)
        notifyItemRemoved(position)
    }
}