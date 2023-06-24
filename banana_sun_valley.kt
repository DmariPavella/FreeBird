// package declaration
package com.example.ridesharing

// imports
import android.app.Activity
import android.widget.TextView
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.content.Intent

// main class 
class RideSharingPlatform {

	// instance variables
	private var context:Context? = null 
	private var activity:Activity? = null

	// constructor
	public RideSharingPlatform(context: Context, activity: Activity){
		this.context = context
		this.activity = activity
	}

	// method to launch the main screen of the app
	public fun launchMainScreen(){
		// launch the main screen activity
		val intent = Intent(this.context, MainScreenActivity::class.java)
		this.context!!.startActivity(intent)
	}

	// method to display UI elements on the main screen
	public fun updateMainScreenUI(){
		// get the root view
		val viewGroup = this.activity!!.findViewById<ViewGroup>(android.R.id.content)

		// inflate the main screen layout
		val inflater = LayoutInflater.from(this.context)
		val view = inflater.inflate(R.layout.main_screen_layout, viewGroup, false)

		// set the title of the activity
		val titleTextView = view.findViewById<TextView>(R.id.titleTextView)
		titleTextView.text = "Ride Sharing Platform for Short-Distance Local Rides"

		// add the view to the root view
		viewGroup.addView(view)
	}

}

// main screen activity
class MainScreenActivity : Activity() {

	override fun onCreate (savedInstanceState: Bundle) {
		super.onCreate(savedInstanceState)

		// create a new instance of RideSharingPlatform
		val rideSharingPlatform = RideSharingPlatform(this, this)

		// launch the main screen
		rideSharingPlatform.launchMainScreen()

		// update the main screen UI
		rideSharingPlatform.updateMainScreenUI()

	}

}