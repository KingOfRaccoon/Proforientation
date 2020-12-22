package com.kingofraccoon.proforientation

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.kingofraccoon.proforientation.ml.Model
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager2 : ViewPager2 = findViewById(R.id.viewpager2)
        val testAdapter = TestAdapter().apply { listTests = AllTests.mutableListTests }
        viewPager2.adapter = testAdapter
        AllTests.mutableLiveData.observe(this, Observer {
            if (it) {
                if (viewPager2.currentItem != 29)
                    viewPager2.currentItem += 1
                AllTests.setValueBool(false)
            }
        })

        val model = Model.newInstance(this)
        val input = TensorBuffer.createFixedSize(intArrayOf(1, 28), DataType.FLOAT32)
        input.loadArray(floatArrayOf(1f,1f,2f,1f,2f,1f,0f,1f,0f,0f,0f,0f,0f,2f,1f,0f,1f,0f,0f,0f,2f,0f,2f,2f,0f,0f,0f,2f))

        val outputs = model.process(input)
        val outputsFea = outputs.outputFeature0AsTensorBuffer
        outputsFea.floatArray.forEach {
        Log.d("Test", it.toString())
        }
        model.close()
    }

}