
drop table vendor_city;

create table if not exists vendor_city (
  id              bigint identity primary key,
  vendor_code     varchar_ignorecase(500),
  lookup_code     varchar_ignorecase(100),
  city_name       varchar_ignorecase(50),
  constraint uq_app_entries_name unique (vendor_code, lookup_code)
);


merge into vendor_city (vendor_code, lookup_code, city_name) key(vendor_code, lookup_code) values ('com.drunkendev.weather.api.openweathermap.OpenWeatherMapWeatherService', '7839805', 'Melbourne');
merge into vendor_city (vendor_code, lookup_code, city_name) key(vendor_code, lookup_code) values ('com.drunkendev.weather.api.openweathermap.OpenWeatherMapWeatherService', '2147714', 'Sydney');
merge into vendor_city (vendor_code, lookup_code, city_name) key(vendor_code, lookup_code) values ('com.drunkendev.weather.api.openweathermap.OpenWeatherMapWeatherService', '7839791', 'Wollongong');
