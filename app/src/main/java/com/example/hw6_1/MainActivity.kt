package com.example.hw6_1

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hw6_1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var pref:SharedPreferences
    var fullName=""
    var userName=""
    var email=""
    var password=""
    var gender=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.register.setOnClickListener {

            if (binding.editTextFullName.text.isBlank()||binding.editTextUserName.text.isBlank()
                || binding.editTextEmailAddress.text.isBlank() || binding.editTextPassword.text.isBlank()
                || binding.editTextReTypePassword.text.isBlank()){
                    binding.editTextFullName.error="همه فیلدها را پر کنید"
                Toast.makeText(this,"همه فیلدها را پر کنید", Toast.LENGTH_LONG).show()

            }else if(binding.editTextPassword.text.toString()!= binding.editTextReTypePassword.text.toString()) {
                binding.editTextReTypePassword.error = "پسوردهای وارد شده یکی نیستند"

            }else if (!binding.Female.isChecked && !binding.Male.isChecked) {
                binding.Male.error = "یک گزینه را انتخاب کنید"
            }else{
                if (binding.Female.isChecked){
                    gender="Female"
                }else if (binding.Male.isChecked){
                    gender="Male"
                }
                fullName = binding.editTextFullName.text.toString()
                userName=binding.editTextUserName.text.toString()
                email=binding.editTextEmailAddress.text.toString()
                password=binding.editTextPassword.text.toString()
            }


        }

        binding.showInfo.setOnClickListener {
            binding.textViewFullName.text=fullName
            binding.textViewUserName.text=userName
            binding.textViewEmail.text=email
            binding.textViewPassword.text=password
            binding.textViewGender.text=gender
        }

    }

}