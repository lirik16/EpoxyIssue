package com.epoxy.issue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.epoxy.issue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var itemList = List(4) { Item(it + 1) }

    private lateinit var binding: ActivityMainBinding

    private val mainController by lazy {
        MainController(
            valueClickListener = { value ->
                Toast.makeText(this@MainActivity, value.toString(), Toast.LENGTH_SHORT).show()
                updateControllerData()
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.list.setController(mainController)
        updateControllerData()
    }

    private fun updateControllerData() {
        mainController.setData(itemList)
        itemList = itemList.map { it.copy(value = it.value * 2) }
    }
}
