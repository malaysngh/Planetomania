package com.example.planetomania

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.planetomania.databinding.ActivityPlanetDetailBinding

class PlanetDetail : AppCompatActivity() {
    private var binding:ActivityPlanetDetailBinding?=null
    private lateinit var obj:PlanetData
    private var planetImg:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityPlanetDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)
        window.decorView.apply { systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION }
        obj= intent.getParcelableExtra("planet")!!
        planetImg=intent.getIntExtra("planetImage",-1)
        setData(obj, planetImg!!)

        binding?.buttonInfo?.setOnClickListener{
            val intent= Intent(this,finalActivity::class.java)
            startActivity(intent)
        }
    }
    private fun setData(obj:PlanetData,planetImg:Int)
    {
        binding?.titleInfo?.text=obj.title
        binding?.distanceInfo?.text=obj.distance+"m km"
        binding?.gravityInfo?.text=obj.gravity+" m/ss"
        binding?.overviewInfo?.text=obj.overview
        binding?.gravityInfo?.text=obj.galaxy
        binding?.planetImgInfo?.setImageResource(planetImg)
    }
}