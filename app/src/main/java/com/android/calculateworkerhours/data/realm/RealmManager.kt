package com.android.calculateworkerhours.data.realm

import com.android.calculateworkerhours.data.model.User
import io.realm.Realm
import io.realm.RealmModel

class RealmManager private constructor() {

    fun insertUser(user: User) {
        var realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.insertOrUpdate(user)
        realm.commitTransaction()
    }

    fun delete(clazz: Class<out RealmModel>) {
        var realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.delete(clazz)
        realm.commitTransaction()
    }

    fun getUser(id: Long): User? {
        var realm = Realm.getDefaultInstance()
        val temp = realm.where(User::class.java).equalTo("id", id).findFirst()
        return if (temp != null) realm.copyFromRealm(temp) else null
    }

    companion object {
        private var instant: RealmManager? = null
        fun getInstance(): RealmManager {
            if (instant == null)
                instant = RealmManager()
            return instant!!
        }
    }

}

