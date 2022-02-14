package com.example.hw6_1

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
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
    lateinit var edit:SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        gone()

        pref=getPreferences(Context.MODE_PRIVATE)


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


                edit=pref.edit()
                edit.putString("FullName",fullName)
                edit.putString("UserName",userName)
                edit.putString("Email",email)
                edit.putString("Password",password)
                edit.putString("Gender",gender)
                edit.apply()
                Toast.makeText(this,"ذخیره اطلاعات انجام شد" , Toast.LENGTH_LONG).show()
            }


        }

        binding.showInfo.setOnClickListener {
            binding.textViewFullName.text=pref.getString("FullName",null)
            binding.textViewUserName.text=pref.getString("UserName","")
            binding.textViewEmail.text=pref.getString("Email","")
            binding.textViewPassword.text=pref.getString("Password","")
            binding.textViewGender.text=pref.getString("Gender","")
            visible()
        }

        binding.buttonHideInfo.setOnClickListener {
            gone()
        }

    }

    private fun visible() {
        binding.textViewFullName.visibility= View.VISIBLE
        binding.textViewUserName.visibility= View.VISIBLE
        binding.textViewEmail.visibility= View.VISIBLE
        binding.textViewPassword.visibility=View.VISIBLE
        binding.textViewGender.visibility=View.VISIBLE
        binding.buttonHideInfo.visibility= View.VISIBLE
    }

    private fun gone() {
        binding.textViewFullName.visibility= View.GONE
        binding.textViewUserName.visibility= View.GONE
        binding.textViewEmail.visibility= View.GONE
        binding.textViewPassword.visibility=View.GONE
        binding.textViewGender.visibility=View.GONE
        binding.buttonHideInfo.visibility= View.GONE
    }

}