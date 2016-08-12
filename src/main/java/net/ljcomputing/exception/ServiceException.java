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


package net.ljcomputing.exception;

/**
 * Service Exception
 * 
 * @author James G. Willmore
 */
public class ServiceException extends Exception {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -2367458235902185791L;

  /**
   * Instantiates a new service exception.
   */
  public ServiceException() {
    super();
  }

  /**
   * Instantiates a new service exception.
   *
   * @param message the message
   */
  public ServiceException(String message) {
    super(message);
  }

  /**
   * Instantiates a new service exception.
   *
   * @param cause the cause
   */
  public ServiceException(final Throwable cause) {
    super(cause);
  }

  /**
   * Instantiates a new service exception.
   *
   * @param message the message
   * @param cause the cause
   */
  public ServiceException(final String message, final Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiates a new service exception.
   *
   * @param message the message
   * @param cause the cause
   * @param suppress the suppress
   * @param stackTrace the stack trace
   */
  public ServiceException(final String message, final Throwable cause,
      final boolean suppress, final boolean stackTrace) {
    super(message, cause, suppress, stackTrace);
  }
}
