package com.example.todo_app.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

@Suppress("UNCHECKED_CAST")
abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    abstract val bindingInflater: (LayoutInflater) -> VB
    abstract val viewModel: BaseViewModel

    /**
     * Set this value to false if the fragment is not part of the navigation graph
     * in order to keep it from crashing when the user presses the back button
     */
    open var shouldAddBackPress: Boolean = true
    val binding: VB
        get() = mViewBinding as VB
    private var mViewBinding: ViewBinding? = null
    private var mLayoutIsCreated = false
    private var mLayoutView: View? = null

    abstract fun initObservers()
    abstract fun initViews()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (mLayoutView == null) {
            mViewBinding = bindingInflater.invoke(inflater)
            mLayoutView = requireNotNull(mViewBinding).root
        } else {
            (mLayoutView?.parent as? ViewGroup)?.removeView(mLayoutView)
        }
        return mLayoutView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()

        if (shouldAddBackPress) {
            setBackNavigation {
                findNavController().navigateUp()
            }
        }

        if (mLayoutIsCreated) {
            initViews()
            mLayoutIsCreated = true
        }
    }

    private fun setBackNavigation(onBackPressed: () -> Unit) {
        requireActivity().onBackPressedDispatcher.addCallback {
            onBackPressed.invoke()
        }
    }

}