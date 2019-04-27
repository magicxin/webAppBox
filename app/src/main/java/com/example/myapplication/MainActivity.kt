package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    // 定义 webview
    private var webView: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    // 新增初始化函数，初始化 webview
    private fun init() {
        // 将 webview 和 页面中的 webview 组件绑定
        webView = findViewById(R.id.webView1)
        // 添加 webview 权限
        webView!!.getSettings().setJavaScriptEnabled(true)
        // 加载链接
        webView!!.loadUrl("http://192.168.0.3:8082")
        // webView!!.setWebViewClient(webClient)
        webView!!.webViewClient = webClient
    }
    private val webClient = object: WebViewClient() {
        // 此处 shouldOverrideUrlLoading 被删除线， 不推荐重写，是否还有其他方案？
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            return false
        }
    }
}
