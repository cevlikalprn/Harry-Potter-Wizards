package com.cevlikalprn.harrypotterwizards.data.repository

import com.cevlikalprn.harrypotterwizards.data.LocalDataSource
import com.cevlikalprn.harrypotterwizards.data.RemoteDataSource

class WizardRepository(
    remoteDataSource: RemoteDataSource,
    localDataSource: LocalDataSource
) {

    val remote = remoteDataSource
    val local = localDataSource
}