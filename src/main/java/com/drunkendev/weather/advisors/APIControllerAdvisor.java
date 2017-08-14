/*
 * APIControllerAdvisor.java    Aug 15 2017, 08:32
 *
 * Copyright 2017 Drunken Dev.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.drunkendev.weather.advisors;

import com.drunkendev.web.ApiError;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;


/**
 * Advisor for API endpoints to return an {@link ApiError} response.
 *
 * @author  Brett Ryan
 */
@RestControllerAdvice(annotations = {RestController.class})
public class APIControllerAdvisor {

    private static final Logger log = LoggerFactory.getLogger(APIControllerAdvisor.class);

    private final boolean showTrace;

    public APIControllerAdvisor() {
        this.showTrace = true;
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiError> exception(Throwable exception,
                                              WebRequest request,
                                              HttpServletRequest req) {
        if (!exception.getClass().isAnnotationPresent(ResponseStatus.class) &&
            !(exception instanceof HttpStatusCodeException) &&
            !(exception instanceof AccessDeniedException)) {
            StringBuilder msg = new StringBuilder();
            msg.append("non recognized exception handled for ReST endpoint.");
            msg.append(System.getProperty("line.separator"));
            msg.append(" - User=").append(request.getRemoteUser());
            msg.append(System.getProperty("line.separator"));
            msg.append(" - URL=").append(req.getRequestURL().toString());
            msg.append(System.getProperty("line.separator"));
            msg.append(" - Exception : ").append(exception.getMessage());
            log.error(msg.toString(), exception);
        }
        ApiError err = new ApiError(req.getRequestURI(), exception, showTrace);
        return new ResponseEntity<>(err, err.getStatus());
    }

}
