package com.example.groceryapp_zwinger

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*


class UserpageActivity: AppCompatActivity() {
    lateinit var previtembut:ImageButton
    lateinit var additembut:ImageButton
    lateinit var edittxt_additem:EditText
    lateinit var user_framelay:FrameLayout
    lateinit var reff:DatabaseReference
    var itemlist= mutableListOf<add_item>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.userpage_act)

        supportFragmentManager.beginTransaction()
            .replace(R.id.user_framelay,frag_userpage())
            .addToBackStack("Userpage")
            .commit()
        supportActionBar?.title="Current List"

    previtembut=findViewById(R.id.previtembut)
    additembut=findViewById(R.id.additembut)
    edittxt_additem=findViewById(R.id.edittxt_additem)
    user_framelay=findViewById(R.id.user_framelay)


       previtembut.setOnClickListener {
            val intent=Intent(this@UserpageActivity,PrevItemActivity::class.java)
            startActivity(intent)
            }
       additembut.setOnClickListener {
           reff= FirebaseDatabase.getInstance().getReference("Items in list")
           val itemname=edittxt_additem.text.toString().trim()
           val itemid: String? =reff.push().key
if(itemname.isEmpty())
{
    edittxt_additem.error="Blank Entry !"
    return@setOnClickListener
}

           val item=add_item(itemid,itemname)

           if (itemid != null) {
               reff.child(itemid).setValue(item).addOnCompleteListener{

                   Toast.makeText(this@UserpageActivity,"Item Added",Toast.LENGTH_SHORT).show()
               }
           }


       }

        /*reff.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if(p0!!.exists())
                {
                    for(i in p0.children){
                        val item=i.getValue(add_item::class.java)
                        itemlist.add(item!!)
                    }
                }
            }

        }
        )*/


    }

}