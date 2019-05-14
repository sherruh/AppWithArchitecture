package com.geektech.core;

import io.realm.Realm;

public abstract class CoreRealmDataSource {

    protected Realm getRealmInstance(){
        return Realm.getDefaultInstance();
    }

    protected void executeTransaction(Realm.Transaction transaction){

        Realm realm = null;

        try {
            realm = getRealmInstance();
            realm.executeTransaction(transaction);
        }catch (Exception e){
            Logger.d(e.getMessage());
        }finally {
            if(realm != null){
                realm.close();
            }
        }

    }

    protected long getNextId(Class c){
        Realm realm = null;

        try {
            realm = getRealmInstance();
            String primaryKeyField= realm.getSchema().get(c.getSimpleName())
                    .getPrimaryKey();

            if(realm.where(c).max(primaryKeyField) == null){
                return 1;
            }

            int value=realm.where(c).max(primaryKeyField).intValue();
            return value+1;
        }catch (Exception e){
            Logger.d(e.getMessage());
            return -1;
        }finally {
            if(realm != null){
                realm.close();
            }
        }
    }
}
