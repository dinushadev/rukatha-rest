
package com.rukatha.rest.entity;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

/**
 * Base entity class for NoSQL.
 *
 */
public abstract class BaseEntity {
  protected final Entity entity;

  protected BaseEntity(Entity entity) {
    this.entity = entity;
  }

  protected BaseEntity(Key parentKey, String kind) {
    this.entity = new Entity(kind, parentKey);
  }

  protected BaseEntity(String kind, String keyName) {
    this.entity = new Entity(kind, keyName);
  }

  public Entity getEntity() {
    return entity;
  }
}
