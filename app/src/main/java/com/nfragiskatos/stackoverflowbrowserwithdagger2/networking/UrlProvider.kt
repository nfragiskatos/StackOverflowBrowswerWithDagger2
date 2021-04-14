package com.nfragiskatos.stackoverflowbrowserwithdagger2.networking

import com.nfragiskatos.stackoverflowbrowserwithdagger2.Constants

class UrlProvider {

    fun getBaseUrl1(): String {
        return Constants.BASE_URL
    }

    fun getBaseUrl2(): String {
        return "other_base_url"
    }
}