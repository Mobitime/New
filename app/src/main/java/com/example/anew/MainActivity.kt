package com.example.anew

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var inputField: EditText
    private lateinit var outputField: TextView
    private lateinit var saveButton: Button
    private lateinit var deleteButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        inputField = findViewById(R.id.inputField)
        outputField = findViewById(R.id.outputField)
        saveButton = findViewById(R.id.saveButton)
        deleteButton = findViewById(R.id.deleteButton)

        saveButton.setOnClickListener{
            val inputText = inputField.text.toString()
            outputField.text = inputText
        }
        deleteButton.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Подтвердите удаление")
            builder.setMessage("Вы уверены, что хотите удалить данные")

            builder.setPositiveButton("Удалить"){_,_->
                outputField.text = ""
                Snackbar.make(outputField, "Данные удалены", Snackbar.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("Отмена"){dialog,_ ->
                dialog.dismiss()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }


        }
    }
