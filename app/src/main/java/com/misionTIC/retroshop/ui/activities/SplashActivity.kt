package com.misionTIC.retroshop.ui.activities

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.misionTIC.retroshop.data.models.Comment
import com.misionTIC.retroshop.data.models.Product
import com.misionTIC.retroshop.data.models.StoreInfo
import com.misionTIC.retroshop.databinding.ActivitySplashBinding
import com.misionTIC.retroshop.ui.viewmodels.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val splashViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        events()
    }

    private fun init(){
        splashViewModel.loadinformation(
            StoreInfo(
                "1",
                "RetroShop",
                "https://i.postimg.cc/T1sN5Bb6/logo.png",
                "Cra. tal # tal - tal",
                "Nuestros contactos: +57 300 XXX XXXX 01 8000 23 53",
                "Nacimos en 2015 con el propósito de llevar lo que tu deseas a tu hogar"

            ),
            listOf(
                Comment("1","buen producto", "Fulano", "https://st.depositphotos.com/2069323/2156/i/950/depositphotos_21568785-stock-photo-man-pointing.jpg", "2020-05-01"),
                Comment("2","buen producto", "Fulano", "https://st.depositphotos.com/2069323/2156/i/950/depositphotos_21568785-stock-photo-man-pointing.jpg", "2021-05-01")
            ),
            listOf(
                Product("1","Product 1","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
                Product("2","Product 2","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
                Product("3","Product 3","Texto de prueba","http://lysisgroupdiag.blob.core.windows.net/image/arete.jpg","200000"),
                Product("4","Product 4","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
                Product("5","Product 5","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
                Product("6","Product 6","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
                Product("7","Product 7","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
                Product("8","Product 8","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
                Product("9","Product 9","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000"),
                Product("10","Product 10","Texto de prueba","https://www.enter.co/wp-content/uploads/2018/10/43854307335_edf588592f_o.jpg","200000")
            )

        )
        binding.splashAnimation.imageAssetsFolder = "images"
        binding.splashAnimation.playAnimation()
    }

    private fun events(){
        binding.splashAnimation.addAnimatorListener(object: Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator?) {
            }

            override fun onAnimationEnd(p0: Animator?) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationRepeat(p0: Animator?) {
            }
        })

    }
}