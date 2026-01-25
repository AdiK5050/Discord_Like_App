package io.adik5050.discord_like.ui.app.login.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.adik5050.discord_like.storage.AppDatabase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class LoginViewModel(
    appDatabase: AppDatabase
) : ViewModel() {
    val userDao = appDatabase.getUserDao()

    val userList = userDao.getAllUsersAsFlow()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    private var _loginSuccessful = mutableStateOf(false)
    val loginSuccessful = _loginSuccessful
    private var _usernameTextFieldValue = mutableStateOf(TextFieldValue(""))
    val usernameTextFieldValue = _usernameTextFieldValue
    private var _passwordTextFieldValue = mutableStateOf(TextFieldValue(""))
    val passwordTextFieldValue = _passwordTextFieldValue

    private var _loginButtonEnabled = mutableStateOf(false)
    val loginButtonEnabled = _loginButtonEnabled

    private var _isError = mutableStateOf(false)
    val isError = _isError

    private var _errorMessage = mutableStateOf("")
    val errorMessage = _errorMessage
    fun updateUsername(newValue: TextFieldValue) {
        _usernameTextFieldValue.value = newValue
    }

    fun updatePassword(newValue: TextFieldValue) {
        _passwordTextFieldValue.value = newValue
    }

    fun resetErrorStatus() {
        _isError.value = false
        _errorMessage.value = ""
    }

    fun checkUsername(): Boolean {
        userList.value.forEach { user ->
            if(user.username.equals(_usernameTextFieldValue)) return true
        }
        return false
    }
    fun checkPassword(): Boolean {
        userList.value.forEach { user ->
            if(user.password.equals(_passwordTextFieldValue)) return true
        }
        return false
    }

    fun login() {
//        if(_usernameTextFieldValue.value.text.isBlank() || _passwordTextFieldValue.value.text.isBlank()) {
//            _isError.value = true
//            _errorMessage.value = "Username Or Password Cannot Be Empty!"
//            return
//        }
//        else if(!checkPassword() || !checkUsername()) {
//            _isError.value = true
//            _errorMessage.value = "Username Or Password Incorrect!"
//            return
//        }
//        _loginSuccessful.value = true
        _loginSuccessful.value = true
    }
    fun enableButton() {
        if(_usernameTextFieldValue.value.text.isNotBlank() && _passwordTextFieldValue.value.text.isNotBlank()) _loginButtonEnabled.value = true
        else _loginButtonEnabled.value = false
    }
}