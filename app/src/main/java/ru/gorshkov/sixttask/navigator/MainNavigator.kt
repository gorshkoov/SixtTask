package ru.gorshkov.sixttask.navigator

import android.text.TextUtils
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import ru.gorshkov.sixttask.R
import ru.gorshkov.sixttask.di.scopes.ActivityScope
import ru.gorshkov.sixttask.features.list.ListFragment
import ru.gorshkov.sixttask.features.main.MainActivity
import ru.gorshkov.sixttask.features.map.MapFragment
import javax.inject.Inject

@ActivityScope
class MainNavigator @Inject constructor(
    private val activity: MainActivity
) : BottomNavigationView.OnNavigationItemSelectedListener {
    companion object {
        private const val MAP_TAG = "map_tag"
        private const val LIST_TAG = "list_tag"
    }

    private val fragments = HashMap<String, Fragment>()
    private var current: Fragment? = null

    fun init() {
        createFragments()
        addFragments()
        showInitial(fragments[MAP_TAG]!!)
        activity.bottom_navigation.setOnNavigationItemSelectedListener(this)
    }

    private fun createFragments() {
        fragments.apply {
            put(MAP_TAG, MapFragment())
            put(LIST_TAG, ListFragment())
        }
    }

    private fun addFragments() {
        val fm = activity.supportFragmentManager
        val transaction = fm.beginTransaction()

        for ((tag, fragment) in fragments) {
            transaction
                .add(R.id.nav_host_fragment, fragment, tag)
                .hide(fragment)
        }
        transaction.commit()
    }

    private fun showInitial(fragment: Fragment) {
        activity.supportFragmentManager
            .beginTransaction()
            .show(fragment)
            .commit()

        current = fragment
    }

    private fun swapFragments(fragment: Fragment) {
        if (TextUtils.equals(fragment.tag, current?.tag))
            return
        activity.supportFragmentManager.beginTransaction()
            .show(fragment)
            .hide(current!!)
            .commit()

        current = fragment
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mapFragment -> {
                swapFragments(fragments[MAP_TAG]!!)
                true
            }
            R.id.listFragment -> {
                swapFragments(fragments[LIST_TAG]!!)
                true
            }
            else -> false
        }
    }
}