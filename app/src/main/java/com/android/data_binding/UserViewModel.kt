package com.android.data_binding

import android.util.Log
import androidx.lifecycle.*


class UserViewModel(testInt: Int) : ViewModel() {

    // LiveViewを作成
    val user: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }

    // 初期値を設定
    init {
        user.value = User("SUZUKI", testInt)
    }

    // ボタンクリック時の値を変更する関数
    fun change() {

        Log.d("TAG"," = LogoMark.LOGO1 =" +LogoMark.LOGO1)


        if (user.value?.age == 45) {
            user.value = User("OHTANI", 25)
        } else {
            user.value = User("SUZUKI", 45)
        }

    }

    // LiveDataの更新を他のLiveDataの更新に依存させる
    val logo: LiveData<LogoMark> = Transformations.map(user) {
        when {
            user.value!!.age > 40 -> LogoMark.LOGO1
            else -> LogoMark.LOGO2
        }
    }
}

enum class LogoMark {
    LOGO1,
    LOGO2
}

/**
 *
 *
 * 引数は、ViewModelのものを使う
 */
class UserViewModelFactory(private val test: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")


            return UserViewModel(test) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}