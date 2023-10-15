package com.gtech.prodialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gtech.pro_dialog.ProDialog
import com.gtech.prodialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLayout()
    }

    private fun initLayout() {

        binding.successDialog.setOnClickListener {
            ProDialog.build(this)
                .type(ProDialog.TYPE.SUCCESS)
                .title("Success Dialog")
                .position(ProDialog.POSITIONS.CENTER)
                .description("Your task was completed successfully.")
                .onPositive("OK") {
                    // Positive button action
                }
                .show()

        }

        binding.errorDialog.setOnClickListener {
            ProDialog.build(this)
                .type(ProDialog.TYPE.ERROR)
                .title("Success Dialog")
                .position(ProDialog.POSITIONS.CENTER)
                .description("Your task was completed successfully.")
                .onPositive("OK") {
                    // Positive button action
                }
                .show()

        }

        binding.infoDialog.setOnClickListener {
            ProDialog.build(this)
                .type(ProDialog.TYPE.INFO)
                .title("Success Dialog")
                .position(ProDialog.POSITIONS.CENTER)
                .description("Your task was completed successfully.")
                .onPositive("OK") {
                    // Positive button action
                }
                .show()

        }

        binding.alertDialog.setOnClickListener {
            ProDialog.build(this)
                .type(ProDialog.TYPE.ALERT)
                .title("Success Dialog")
                .position(ProDialog.POSITIONS.CENTER)
                .description("Your task was completed successfully.")
                .onPositive("OK") {
                    // Positive button action
                }
                .show()

        }

    }

}