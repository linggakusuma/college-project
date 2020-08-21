package com.academy.stikompoltek.ui.login

import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.academy.stikompoltek.ui.home.MainActivity
import com.academy.stikompoltek.R
import com.academy.stikompoltek.data.base.BaseActivity
import com.academy.stikompoltek.databinding.ActivityLoginBinding
import com.academy.stikompoltek.utils.ext.checkIsNotEmpty
import com.academy.stikompoltek.utils.ext.observe
import com.academy.stikompoltek.utils.ext.setTransparentStatusBarBlack
import com.academy.stikompoltek.utils.ext.toast
import javax.inject.Inject

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: LoginViewModel by viewModels { viewModelFactory }

    override fun subscribeUi() {
        super.subscribeUi()
        setTransparentStatusBarBlack()
        observe(viewModel.successLogin) { navigateToHome() }
        observe(viewModel.errorMessage) { toast(it) }
    }

    override fun initBinding() {
        super.initBinding()
        binding.apply {
            viewmodel = viewModel
            buttonLogin.setOnClickListener {
                if (inputPassword.checkIsNotEmpty() && inputNrp.checkIsNotEmpty()) viewModel.login()
            }
        }
    }

    private fun navigateToHome() {
        val intent = Intent(this, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(intent)
        finish()
    }
}
