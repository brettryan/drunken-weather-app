/*
 * VendorCity.java    Aug 15 2017, 12:01
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

package com.drunkendev.weather.api;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import static com.drunkendev.jdbc.JdbcHelper.singletonExtractor;


/**
 *
 * @author  Brett Ryan
 */
public class VendorCity {

    public static final RowMapper<VendorCity> MAPPER = (rs, i)
            -> new VendorCity(rs.getLong("id"),
                              rs.getString("vendor_code"),
                              rs.getString("lookup_code"),
                              rs.getString("city_name"));
    public static final ResultSetExtractor<VendorCity> EXTRACTOR
            = singletonExtractor(MAPPER);

    private final long id;
    private final String vendorCode;
    private final String lookupCode;
    private final String cityName;

    public VendorCity(long id, String vendorId, String lookupCode, String cityName) {
        this.id = id;
        this.vendorCode = vendorId;
        this.lookupCode = lookupCode;
        this.cityName = cityName;
    }

    public long getId() {
        return id;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public String getLookupCode() {
        return lookupCode;
    }

    public String getCityName() {
        return cityName;
    }

}
