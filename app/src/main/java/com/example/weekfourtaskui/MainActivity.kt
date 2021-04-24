package com.example.weekfourtaskui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ProductsFragment()

        //        call the listener to the bottom navigataion
        val bottomNavigation: BottomNavigationView = findViewById(R.id.menuBar)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        ////        Notification

        var btn = findViewById<ImageButton>(R.id.imageButton)
        //      add listener to the notification buttion
        btn.setOnClickListener{
            showNotification("Femi" ,"Notification")
        }

        openFragment(ProductsFragment())



    }



    //    Bottom navigation handler
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.menuProduct -> {
                val productsFragment = ProductsFragment()
                openFragment(productsFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.menuSupport -> {

                val supportFragment = SupportFragment()
                openFragment(supportFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.menuHistory -> {
                val historyFragment = HistoryFragment()
                openFragment(historyFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.menuPayment -> {
                val paymentsFragment = PaymentsFragment()
                openFragment(paymentsFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.menuMore -> {
                val moreFragment = MoreFragment()
                openFragment(moreFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.scrollable_main, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }






    //  To send notification
    fun showNotification(title: String, message: String) {
        val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel("YOUR_CHANNEL_ID",
                "YOUR_CHANNEL_NAME",
                NotificationManager.IMPORTANCE_DEFAULT)
            channel.description = "YOUR_NOTIFICATION_CHANNEL_DESCRIPTION"
            mNotificationManager.createNotificationChannel(channel)        }
        val mBuilder = NotificationCompat.Builder(applicationContext, "YOUR_CHANNEL_ID")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("data","Active")
        val pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        mBuilder.setContentIntent(pi)
        mNotificationManager.notify(0, mBuilder.build())
    }
}



