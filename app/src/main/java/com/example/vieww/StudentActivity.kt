package com.example.vieww

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vieww.DataStudent
import com.example.vieww.StudentAdapter
import com.example.vieww.StudentViewModel
import com.example.vieww.databinding.ActivityStudentBinding

class StudentActivity : AppCompatActivity() {

    lateinit var rvStudent : RecyclerView
    lateinit var studentVm : StudentViewModel
    lateinit var studentAdapter: StudentAdapter
    lateinit var binding: ActivityStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initStudent()
        studentVm = ViewModelProvider(this).get(StudentViewModel::class.java)

        studentVm.getStudentList()

        studentVm.studentList.observe(this, Observer {
//            studentAdapter.setDataStudent(it as ArrayList<DataStudent>)
            studentAdapter.setStudentData(it as ArrayList<DataStudent>)
        })

    }

    fun initStudent (){
//        rvStudent = findViewById(R.id.rvStudent)
        studentAdapter = StudentAdapter(ArrayList())
        binding.rvStudent.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvStudent.adapter = studentAdapter
    }

    fun setDataStudent (){

    }


}