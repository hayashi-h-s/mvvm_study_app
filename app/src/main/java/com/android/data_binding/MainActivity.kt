package com.android.data_binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.android.data_binding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_main)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        // ViewBindingテスト
        activityMainBinding.buttonViewBinding.text = "こんちわ"

        // ViewModelのインスタンスを作成
        // ViewModelProviders is deprecated になっているので、ViewModelProviderを使う
        // https://qiita.com/higuuu/items/893be8f60ce71a06d30a

        // val viewModel: UserViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)


        /**
         *  ViewModelProvider
         */
        // 大抵はViewModelに引数があるので、Factoryクラスをつくる
//        val viewModel :UserViewModel by lazy { ViewModelProvider.NewInstanceFactory().create(UserViewModel::class.java) }
//        val userViewModel: UserViewModel by lazy { ViewModelProvider(this, UserViewModelFactory(45)).get(UserViewModel::class.java) }

         val userViewModel: UserViewModel by viewModels(){ UserViewModelFactory(45) }


//        // DataBindingのインスタンスを作成（onCreateの外でもよい）
//        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // ViewModelのインスタンスを作成を設定
        activityMainBinding.viewModel = userViewModel
        // ライフサイクル所有者を設定
        activityMainBinding.lifecycleOwner = this
    }
}