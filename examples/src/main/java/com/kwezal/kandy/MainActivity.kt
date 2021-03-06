package com.kwezal.kandy

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import splitties.views.dsl.core.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui)
    }

    private val ui
        get() = object : Ui {
            override val ctx: Context
                get() = this@MainActivity

            override val root: View
                get() = verticalLayout {
                    addNavigationButton(R.string.activity_label_list_views, ListViewsExampleActivity::class.java)
                    addNavigationButton(R.string.activity_label_dialogs, DialogsExampleActivity::class.java)
                    addNavigationButton(R.string.activity_label_logs, LogsExampleActivity::class.java)
                }

            private fun LinearLayout.addNavigationButton(text: Int, activityClass: Class<out Activity>) =
                add(
                    button {
                        setText(text)
                        setOnClickListener { ctx.startActivity(Intent(ctx, activityClass)) }
                    }, lParams(matchParent)
                )
        }
}