package com.example.mycamera

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.example.mycamera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val REQUEST_PREVIEW = 1

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.preview ->
                    binding.cameraButton.text = binding.preview.text
                R.id.takePicture ->
                    binding.cameraButton.text = binding.takePicture.text
            }
        }

        binding.cameraButton.setOnClickListener {
            when (binding.radioGroup.checkedRadioButtonId) {
                R.id.preview -> preview()
                R.id.takePicture ->takePicture()
            }
        }
    }

    private fun preview() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { intent ->
            intent.resolveActivity(packageManager)?.also {
                startActivityForResult(intent, REQUEST_PREVIEW)
            }
        }
    }
    private fun takePicture() {}
}