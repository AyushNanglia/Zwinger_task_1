package com.example.groceryapp_zwinger


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

/**
 * A simple [Fragment] subclass.
 */
class frag_userpage : Fragment() {

    lateinit var recycler_frag_userpage:RecyclerView
    lateinit var txt_currentlist:TextView
    lateinit var layout_manager:RecyclerView.LayoutManager
    /*var tasklist= arrayListOf<model_item>()*/
    lateinit var reff:DatabaseReference
    var tasklist= mutableListOf<model_item>(
        model_item("1","Choco biscuits"),
        model_item("2","Ketchup"),
        model_item("3","Flour"),
        model_item("4","Hair Oil"),
        model_item("5","Soft Drink"),
        model_item("6","Powdered Milk"),
        model_item("7","Noodles")
    )

    lateinit var recycler_adapter:adapter_userpage

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_userpage, container, false)
      recycler_frag_userpage=view.findViewById(R.id.recycler_frag_userpage)
      /*txt_currentlist=view.findViewById(R.id.txt_currentlist)*/
        layout_manager=LinearLayoutManager(activity)

        recycler_adapter=adapter_userpage(activity as Context,tasklist)


        reff=FirebaseDatabase.getInstance().getReference().child("model_item")

        reff.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists())
                {
                    /*tasklist.clear()*/
                    for(i in p0.children){
                        val item=i.getValue(model_item::class.java)
                        tasklist.add(item!!)
                    }
                    recycler_adapter=adapter_userpage(activity as Context,tasklist)
                    recycler_frag_userpage.adapter=recycler_adapter
                    recycler_frag_userpage.layoutManager=layout_manager
                }
            }

        }
        )



        return view
    }


}
