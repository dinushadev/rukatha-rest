package com.rukatha.rest.dao;

import org.springframework.stereotype.Repository;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.rukatha.rest.entity.UserEntity;

@Repository
public class UserEntityManagerImpl extends RukathaEntityManager<UserEntity> implements UserEntityManager{

	protected UserEntityManagerImpl() {
		super(UserEntity.class);
	}
	
	public Key createDemoUserKey(String userId) {
		    return KeyFactory.createKey(getKind(), userId);
	}

	@Override
	protected UserEntity fromParentKey(Key parentKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected UserEntity fromEntity(Entity entity) {
		return new UserEntity(entity);
	}

	@Override
	 public UserEntity newUser(String userId) {
		
	    return new UserEntity(getKind(), userId);
	}

	@Override
	public UserEntity getUser(String userId) {
		return getEntity(createDemoUserKey(userId));
	}

	public UserEntity getUserByEmail(String email) {
		
		Query query = new Query(getKind());
		Query.Filter filter = new  Query.FilterPredicate(UserEntity.FIELD_NAME_EMAIL,FilterOperator.EQUAL,email);
		query.setFilter(filter);
		FetchOptions fetchOptions = FetchOptions.Builder.withDefaults();
		Iterable<UserEntity> userList = queryEntities(query, fetchOptions);
		
		if(userList!= null ){
			for (UserEntity user : userList) {
				return user;
			}
		}
		
		return null;
	}
}
