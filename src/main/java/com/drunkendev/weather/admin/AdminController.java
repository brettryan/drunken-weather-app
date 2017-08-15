/*
 * AdminController.java    Aug 15 2017, 11:19
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

package com.drunkendev.weather.admin;

import com.drunkendev.weather.api.VendorCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author  Brett Ryan
 */
@Controller
public class AdminController {

    private final VendorCityService vendorCityService;

    @Autowired
    public AdminController(VendorCityService vendorCityService) {
        this.vendorCityService = vendorCityService;
    }

    @RequestMapping("/admin/cities")
    public ModelAndView administerCities() {
        ModelAndView mav = new ModelAndView("admin/cities");
        return mav;
    }

}
