<%@ page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<p>Select a city from the available drop-down to show weather conditions.</p>

<div class="row">
  <div class="col-sm-offset-3 col-sm-6">
    <div class="row">
      <div class="col-xs-5">City</div>
      <div class="col-xs-7">
        <select class="input" data-bind="options: cities, optionsText: 'cityName', value: selectedCity"></select>
      </div>
    </div>
    <div class="row">
      <div class="col-xs-5">Updated</div>
      <div class="col-xs-7" data-bind="text: selectedConditions() && moment(selectedConditions().updated).format('MMMM Do YYYY, h:mm a')"></div>
    </div>
    <div class="row">
      <div class="col-xs-5">Conditions</div>
      <div class="col-xs-7" data-bind="text: selectedConditions() && selectedConditions().conditions"></div>
    </div>
    <div class="row">
      <div class="col-xs-5">Temperature</div>
      <div class="col-xs-7" data-bind="text: selectedConditions() && selectedConditions().temperature + '&#176;C'"></div>
    </div>
    <div class="row">
      <div class="col-xs-5">Wind</div>
      <div class="col-xs-7" data-bind="text: selectedConditions() && selectedConditions().windSpeed + ' kph from the ' + selectedConditions().windDirection"></div>
    </div>
  </div>
</div>
<script>
  $(function () {
    function ViewModel () {
      var self = this;
      self.city = ko.observable();
      self.cities = ko.observableArray();

      self.selectedCity = ko.observable();
      self.selectedConditions = ko.observable();

      ko.computed(function () {
        if (self.selectedCity()) {
          var args = {cityId: self.selectedCity().id};
          $.getJSON('<c:url value="/api/v1/weather"/>', args, self.selectedConditions);
        }
      });

      ko.computed(function() {
        $.getJSON('<c:url value="/api/v1/cities"/>', self.cities);
      });
    }

    ko.applyBindings(new ViewModel());
  });
</script>

