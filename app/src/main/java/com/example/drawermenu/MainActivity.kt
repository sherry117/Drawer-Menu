package com.example.drawermenu

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    lateinit var togle: ActionBarDrawerToggle
    lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



            var drawer=findViewById<DrawerLayout>(R.id.drawer)
            togle= ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
            drawer.addDrawerListener(togle)
            var nav=findViewById<NavigationView>(R.id.nv)
            togle.syncState()
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            setDrawer(nav)
    }

        fun selectItemDrawer(menuItem: MenuItem) {

            when(menuItem.itemId){
                R.id.menu->{
                    var  i= Intent(this,menuAct::class.java)
                    startActivity(i)
                }
            }
            drawer.closeDrawers()

        }

        private fun setDrawer(navigationView: NavigationView) {
            navigationView.setNavigationItemSelectedListener(object : NavigationView.OnNavigationItemSelectedListener {
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    selectItemDrawer(item)
                    return true
                }
            })
        }
}
