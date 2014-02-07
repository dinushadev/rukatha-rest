
package com.rukatha.rest.dao;

import static com.google.appengine.api.datastore.DatastoreServiceFactory.getDatastoreService;

import java.util.Iterator;
import java.util.logging.Logger;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Transaction;
import com.rukatha.rest.entity.BaseEntity;

/**
 * Base class for entity managers for NoSQL implementation.
 *
 *
 * @param <T> type extends {@code DemoEntity}
 */
public abstract class RukathaEntityManager<T extends BaseEntity>  {
  private static final Logger logger =
      Logger.getLogger(RukathaEntityManager.class.getCanonicalName());
  private final Class<T> entityClass;

  protected RukathaEntityManager(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  public Iterable<T> getEntities() {
    Query query = new Query(getKind());
    FetchOptions options = FetchOptions.Builder.withDefaults();
    return queryEntities(query, options);
  }

  public T deleteEntity(T demoEntity) {
   DatastoreService ds = getDatastoreService();
    Transaction txn = ds.beginTransaction();
    try {
      if (checkEntityForDelete(ds, demoEntity)) {
        ds.delete(demoEntity.getEntity().getKey());
        txn.commit();
        logger.info("entity deleted.");
        return demoEntity;
      }
    } catch (Exception e) {
      logger.severe("Failed to delete entity from datastore:" + e.getMessage());
    } finally {
      if (txn.isActive()) {
        txn.rollback();
      }
    }
    return null;
  }

 
  public T persistEntity(T baseEntity) {
    DatastoreService ds = getDatastoreService();
    Entity entity = baseEntity.getEntity();
    ds.put(entity);
    return baseEntity;
  }

  /**
   * Gets the entity class.
   *
   * @return entity class.
   */
  protected Class<T> getEntityClass() {
    return this.entityClass;
  }

  /**
   * Gets the entity kind as a string.
   *
   * @return the entity kind string.
   */
  protected String getKind() {
    return entityClass.getSimpleName();
  }

  /**
   * Looks up a demo entity by key.
   *
   * @param key the entity key.
   * @return the demo entity; null if the key could not be found.
   */
  protected T getEntity(Key key) {
    DatastoreService ds = getDatastoreService();
    Entity entity = getDatastoreEntity(ds, key);
    if (entity != null) {
      return fromEntity(entity);
    }
    return null;
  }

  /**
   * Looks up an entity by key.
   *
   * @param ds the datastore service objct.
   * @param key the entity key.
   * @return the entity; null if the key could not be found.
   */
  protected Entity getDatastoreEntity(DatastoreService ds, Key key) {
    try {
      return ds.get(key);
    } catch (EntityNotFoundException e) {
      logger.fine("No entity found:" + key.toString());
    }
    return null;
  }
  /**
   * Queries the datastore for an {@code Iterable} collection of entities.
   *
   * @param query datastore query object.
   * @param options query options.
   *
   * @return an {@code Iterable} collection of datastore entities.
   */
  protected Iterable<T> queryEntities(Query query, FetchOptions options) {
    PreparedQuery preparedQuery = getDatastoreService().prepare(query);
    final Iterable<Entity> iterable = preparedQuery.asIterable();
    Iterable<T> iterableWrapper = new Iterable<T>() {
      @Override
      public Iterator<T> iterator() {
        final Iterator<Entity> iterator = iterable.iterator();
        return new Iterator<T>() {
          @Override
          public void remove() {
            iterator.remove();
          }

          @Override
          public T next() {
            return fromEntity(iterator.next());
          }

          @Override
          public boolean hasNext() {
            return iterator.hasNext();
          }
        };
      }
    };
    return iterableWrapper;
  }



  /**
   * Callback before entity is deleted. Checks if the entity exists.
   *
   * @param ds the datastore service object.
   * @param demoEntity the entity to be deleted.
   *
   * @return true if the entity should be deleted; otherwise, false.
   */
  protected boolean checkEntityForDelete(DatastoreService ds, BaseEntity demoEntity) {
    if (demoEntity != null) {
      Entity entity = demoEntity.getEntity();
      if (entity != null) {
        return getDatastoreEntity(ds, entity.getKey()) != null;
      }
    }
    return false;
  }

  /**
   * Creates a model entity based on parent key.
   *
   * @param parentKey the parent key.
   *
   * @return an model entity.
   */
  protected abstract T fromParentKey(Key parentKey);

  /**
   * Creates a model the entity based on datastore entity.
   *
   * @param entity datastore entity.
   *
   * @return an model entity.
   */
  protected abstract T fromEntity(Entity entity);
}
