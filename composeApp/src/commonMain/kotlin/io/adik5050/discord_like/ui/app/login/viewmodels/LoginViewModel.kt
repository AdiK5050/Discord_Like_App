package io.adik5050.discord_like.ui.app.login.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.adik5050.discord_like.storage.AppDatabase
import io.adik5050.discord_like.storage.UserEntity
import kotlinx.coroutines.launch

class LoginViewModel(
    appDatabase: AppDatabase
) : ViewModel() {
    val userDao = appDatabase.getUserDao()

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

    private var userFound: UserEntity? = null
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

    suspend fun checkUsername(): Boolean {
        userFound = userDao.getUserWithName(_usernameTextFieldValue.value.text)
        if(userFound != null) return true
        _isError.value = true
        _errorMessage.value = "Username Incorrect!"
        return false
    }
    fun checkPassword(): Boolean {
        if(userFound?.password == _passwordTextFieldValue.value.text) return true
        _isError.value = true
        _errorMessage.value = "Password Incorrect!"
        return false
    }

    fun login() = viewModelScope.launch {
        if(_usernameTextFieldValue.value.text.isBlank() || _passwordTextFieldValue.value.text.isBlank()) {
            _isError.value = true
            _errorMessage.value = "Username Or Password Cannot Be Empty!"
        }
        else if(checkUsername()) {
            if(checkPassword()) {
                resetErrorStatus()
                _loginSuccessful.value = true
            }
        }
    }
    fun enableButton() {
        if(_usernameTextFieldValue.value.text.isNotBlank() && _passwordTextFieldValue.value.text.isNotBlank()) _loginButtonEnabled.value = true
        else _loginButtonEnabled.value = false
    }
    fun fillDataInDatabase() = viewModelScope.launch{
        listOfUsers.forEach { userEntity ->
            userDao.insertUser(userEntity.username, userEntity.password, userEntity.profileImage)
        }
    }
}

val listOfUsers = listOf<UserEntity>(
    UserEntity(
        username = "Adi",
        password = "Adi12345",
        profileImage = null,
    ),
    UserEntity(
        username = "Marko",
        password = "Marko12345",
        profileImage = null,
    ),
    UserEntity(
        username = "Wazei",
        password = "Wazei12345",
        profileImage = null,
    ),
    UserEntity(
        username = "Lucky",
        password = "Lucky12345",
        profileImage = null,
    ),
    UserEntity(
        username = "Yui",
        password = "Yui12345",
        profileImage = null,
    ),
    UserEntity(
        username = "Rias",
        password = "Rias12345",
        profileImage = null,
    ),
)