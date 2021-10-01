package com.cevlikalprn.harrypotterwizards.data.repository

import com.cevlikalprn.harrypotterwizards.data.RemoteDataSource

class WizardRepository(
    remoteDataSource: RemoteDataSource
) {

    val remote = remoteDataSource
}