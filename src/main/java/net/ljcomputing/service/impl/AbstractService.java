/**
           Copyright 2016, James G. Willmore

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package net.ljcomputing.service.impl;

import net.ljcomputing.exception.PersistenceException;
import net.ljcomputing.exception.ServiceException;
import net.ljcomputing.model.Model;
import net.ljcomputing.repository.impl.ModelRepository;
import net.ljcomputing.service.ModelService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Abstract Status Reporter service implementation.
 * 
 * @author James G. Willmore
 *
 */
public abstract class AbstractService<T extends Model, R extends ModelRepository<T>>
    implements ModelService<T, R> {
  
  /** SFL4J. */
  @SuppressWarnings("unused")
  private final static Logger LOGGER = LoggerFactory
      .getLogger(AbstractService.class);

  /** The repository. */
  protected transient R repository;

  /**
   * Instantiates a new abstract service.
   *
   * @throws ServiceException the service exception
   */
  public AbstractService() throws ServiceException {
    initRepository();
  }

  /**
   * Inits the repository.
   * 
   * Original code: http://stackoverflow.com/a/1095194/576681
   *
   * @throws ServiceException the service exception
   */
  @SuppressWarnings("unchecked")
  protected void initRepository() throws ServiceException {
    final ParameterizedType pt = (ParameterizedType) getClass()
        .getGenericSuperclass();

    final String parameterClassName = pt.getActualTypeArguments()[1].toString()
        .split("\\s")[1];

    try {
      repository = (R) Class.forName(parameterClassName).newInstance();
    } catch (Exception exception) {
      throw new ServiceException(exception);
    }
  }

  /**
   * @see net.ljcomputing.service.ModelService#getColumns()
   */
  public abstract String[] getColumns();

  /**
   * @see net.ljcomputing.service.ModelService#create(net.ljcomputing.model.Model)
   */
  public void create(final T model) throws ServiceException {
    create(model, getColumns());
  }

  /**
   * Creates the given model.
   *
   * @param model the model
   * @param columns the columns
   * @throws ServiceException the service exception
   */
  protected void create(final T model, final String... columns)
      throws ServiceException {
    try {
      repository.create(model, columns);
    } catch (PersistenceException exception) {
      throw new ServiceException(exception);
    }
  }

  /**
   * @see net.ljcomputing.service.ModelService#readById(java.lang.Integer)
   */
  public T readById(final Integer id) throws ServiceException {
    try {
      return repository.readById(id);
    } catch (PersistenceException exception) {
      throw new ServiceException(exception);
    }
  }

  /**
   * @see net.ljcomputing.service.ModelService#readAll()
   */
  public List<T> readAll() throws ServiceException {
    try {
      List<T> list = repository.readAll();

      return list;
    } catch (PersistenceException exception) {
      throw new ServiceException(exception);
    }
  }

  /**
   * @see net.ljcomputing.service.ModelService#update(net.ljcomputing.model.Model)
   */
  public void update(final T model) throws ServiceException {
    try {
      repository.update(model, getColumns());
    } catch (PersistenceException exception) {
      throw new ServiceException(exception);
    }
  }

  /**
   * @see net.ljcomputing.service.ModelService#delete(net.ljcomputing.model.Model)
   */
  public void delete(final T model) throws ServiceException {
    delete(((Model) model).getId());
  }

  /**
   * @see net.ljcomputing.service.ModelService#delete(java.lang.Integer)
   */
  public void delete(final Integer id) throws ServiceException {
    try {
      repository.delete(id);
    } catch (PersistenceException exception) {
      throw new ServiceException(exception);
    }
  }
}
