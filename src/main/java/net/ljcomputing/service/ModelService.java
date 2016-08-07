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


package net.ljcomputing.service;

import net.ljcomputing.exception.ServiceException;
import net.ljcomputing.model.Model;
import net.ljcomputing.repository.impl.ModelRepository;

import java.util.List;

/**
 * Service interface shared by all services.
 *
 * @author James G. Willmore
 * @param <T> the Model associated with the service
 * @param <R> the ModelRepository associated with the service
 */
public interface ModelService< T extends Model, R extends ModelRepository<T>> {
  
  /**
   * Gets all the columns of the model.
   *
   * @return the columns
   */
  String[] getColumns();
  
  /**
   * Creates a model.
   *
   * @param model the model
   * @throws ServiceException the service exception
   */
  void create(T model) throws ServiceException;
  
  /**
   * Read a model by id.
   *
   * @param id the id
   * @return the model
   * @throws ServiceException the service exception
   */
  T readById(Integer id) throws ServiceException;
  
  /**
   * Read all models.
   *
   * @return the list
   * @throws ServiceException the service exception
   */
  List<T> readAll() throws ServiceException;
  
  /**
   * Update the give model.
   *
   * @param model the model
   * @throws ServiceException the service exception
   */
  void update(T model) throws ServiceException;
  
  /**
   * Delete model by id.
   *
   * @param id the id
   * @throws ServiceException the service exception
   */
  void delete(Integer id) throws ServiceException;
  
  /**
   * Delete the given model.
   *
   * @param model the model
   * @throws ServiceException the service exception
   */
  void delete(T model) throws ServiceException;
}
