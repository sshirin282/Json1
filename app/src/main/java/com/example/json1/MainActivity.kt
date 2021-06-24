package com.example.json1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: Adapter
    val i:Int=0
    var list:ArrayList<DataModel> = ArrayList<DataModel>()
    val url:String="http://www.mocky.io/v2/597c41390f0000d002f4dbd1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recy)


        list=ArrayList<DataModel>()
        val request: StringRequest= StringRequest(Request.Method.GET,url, Response.Listener {
            response ->
            Log.e("responce>>",response)
            val jsonObject: JSONObject = JSONObject(response)
            val jsonArray: JSONArray =jsonObject.getJSONArray("users")
            for (i in 0 until jsonArray.length()) {
                val jsonobject1:JSONObject=jsonArray.getJSONObject(i)
                val id:String=jsonobject1.getString("id")
                val rating:String=jsonobject1.getString("name")
                val releaseYear:String=jsonobject1.getString("email")
                val genre:String=jsonobject1.getString("gender")
                val jsonobject2:JSONObject=jsonobject1.getJSONObject("contact")
                val mobile:String=jsonobject2.getString("mobile")
                val home:String=jsonobject2.getString("home")
                val office:String=jsonobject2.getString("office")
                val dataModel=DataModel()
                dataModel.id= id
                dataModel.name=rating
                dataModel.email=releaseYear
                dataModel.gender=genre
                dataModel.mobile=mobile
                dataModel.home=home
                dataModel.office=office
                list.add(dataModel)
            }
            adapter=Adapter(this,list)
            val layoutManager=LinearLayoutManager(this)
            recyclerView.layoutManager=layoutManager
            recyclerView.adapter=adapter


        },Response.ErrorListener {


        })
        val requestQueue= Volley.newRequestQueue(this)
        requestQueue?.add(request)

    }
    }
