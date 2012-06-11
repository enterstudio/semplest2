var HOST_URL = 'http://www.mapquestapi.com';
var APP_KEY = 'Fmjtd%7Cluua2q6anl%2C7s%3Do5-hzbxq';
var SAMPLE_ADVANCED_POST = HOST_URL + '/geocoding/v1/address?key=YOUR_KEY_HERE&callback=renderOptions';
var advancedOptions = '';
var outFormat = '';
var index = '';


function showOptionsURL(type, address, city, state, zip) {
    advancedOptions = SAMPLE_ADVANCED_POST;
    var location = {};
    if (city == ' ' || city == '' || city == null) {
        location.address = $('#AdModelProp_Addresses_0__Address').val();
        location.city = $('#AdModelProp_Addresses_0__City').val();
        location.state = $("#AdModelProp_Addresses_0__StateCodeFK option:selected").text();
        location.zip = $('#AdModelProp_Addresses_0__Zip').val();
    } else {
        location.address = this.$.find("input[id='" + address + "']")[0].value;
        location.city = this.$.find("input[id='" + city + "']")[0].value;
        location.state = this.$.find("select[id='" + state + "'] option:selected")[0].innerText;
        location.zip = this.$.find("input[id='" + zip + "']")[0].value;
    }
    var thumbMaps = 'true';
    var maxResults = 1;
    outFormat = 'json';
    advancedOptions += '&outFormat=' + outFormat;
    advancedOptions += '&inFormat=json';
    advancedOptions += "&json=";
    var jsonText = '{';
    jsonText += 'location:{street:"';
    jsonText += location.address;
    jsonText += ' ';
    jsonText += location.city;
    jsonText += ' ';
    jsonText += location.state;
    jsonText += ' ';
    jsonText += location.zip;
    jsonText += '"}';
    jsonText += ',options:{';
    jsonText += 'thumbMaps:' + thumbMaps;
    if (maxResults != "") {
        jsonText += ',maxResults:' + maxResults;
    }
    jsonText += '}}';
    advancedOptions += jsonText;
};

function getCustomZoom(miles) {

    if (miles > 0 && miles <= 1) return 13;
    if (miles > 1 && miles <= 1.5) return 12;
    if (miles > 1.5 && miles <= 3.0) return 11;
    if (miles > 3.0 && miles <= 6.0) return 10;
    if (miles > 6.0 && miles <= 14) return 9;
    if (miles > 14 && miles <= 32) return 8;
    if (miles > 32 && miles <= 50) return 7;
    if (miles > 50 && miles <= 100) return 6;
    if (miles > 100 && miles <= 200) return 5;
    if (miles > 200 && miles <= 400) return 4;
    if (miles > 400 && miles <= 800) return 3;
    if (miles > 800) return 2;
    return 13;
}
var map;
var markerLocation;
var marker;
var circleLocation;
var circleOptions;
var circle;
var mapArray = new Array();
function renderOptions(response) {
    var cloudmadeUrl = 'http://{s}.tile.cloudmade.com/BC9A493B41014CAABB98F0471D759707/997/256/{z}/{x}/{y}.png',
            cloudmadeAttribution = '',
            cloudmade = new L.TileLayer(cloudmadeUrl, { maxZoom: 18, attribution: cloudmadeAttribution });
    if (outFormat == "json") {
        var locations = response.results[0].locations;
        var location = locations[0];
       
       
        var localIndex = index.toString().indexOf('AdModelProp') > -1 ? index.split('_')[1] : index;
        if (localIndex >0) {
            map = new L.Map('map_' + localIndex, { zoomControl: false, doubleClickZoom: false, attributionControl: false });
        } else {
            map = new L.Map('map', { zoomControl: false, doubleClickZoom: false, attributionControl: false, trackResize: false });
        }
        var proxVal = this.$.find("input[id='AdModelProp_Addresses_" + localIndex + "__ProximityRadius']")[0].value;
        if (proxVal == null || proxVal == "")
            proxVal = 0;
        var zoomval = getCustomZoom(proxVal);
        if (zoomval == null)
            zoomval = 13;
        var lng = location.latLng.lng;
        var lat = location.latLng.lat;
        if (lng > -98)
            map.setView(new L.LatLng(lat, lng), zoomval).addLayer(cloudmade);
        else
            map.setView(new L.LatLng(lat, lng), 3).addLayer(cloudmade);

        markerLocation = new L.LatLng(location.latLng.lat, location.latLng.lng);
        marker = new L.Marker(markerLocation);
        map.addLayer(marker);
        if (proxVal > 0) {
            var cirProx = proxVal * 1609.344;
            circleLocation = new L.LatLng(location.latLng.lat, location.latLng.lng);
            circleOptions = { color: '#f03', opacity: 0.7 };
            circle = new L.Circle(circleLocation, cirProx, circleOptions);
            map.addLayer(circle);
        }
        this.$.find("input[id='AdModelProp_Addresses_" + localIndex + "__Latitude']")[0].value = location.latLng.lat;
        this.$.find("input[id='AdModelProp_Addresses_" + localIndex + "__Longitude']")[0].value = location.latLng.lng;
        if (list != null) {
            var nextIndex = list.pop();
            if (nextIndex != null)
                doOptions1('AdModelProp_Addresses_' + nextIndex + '__Address', 'AdModelProp_Addresses_' + nextIndex + '__City', 'AdModelProp_Addresses_' + nextIndex + '__StateCodeFK', 'AdModelProp_Addresses_' + nextIndex + '__Zip', 'AdModelProp_Addresses_' + nextIndex + '__ProximityRadius', nextIndex);
        }
        mapArray.push(map);
        return;
    }
}
function doOptions(address, city, state, zip, proximity) {
    if (city != null) {
        index = city.toString().replace('Addresses', '');
        index = index.replace('City', '');
        index = index.replace('_', '');
        index = index.replace('__', '');
        $('map_' + index).html('Pending...');
        var script = document.createElement('script');
        script.type = 'text/javascript';
        showOptionsURL('buttonClick', address, city, state, zip, proximity);
        var newUrl = advancedOptions.replace('YOUR_KEY_HERE', APP_KEY);
        script.src = newUrl;
        document.body.appendChild(script);
    } else {
        $('.address').each(function (index) {
            var addressAttr = $(this).find('input').attr('id').substring(22, 23);
            var mapdiv = $(this).find('div.map');
            if (index > 0) {
                mapdiv.attr("id", "map_" + addressAttr);
                list.push(index);

            } else {
                mapdiv.attr("id", "map");
                list.push(index);
            }
        });
        var nextIndex = list.pop();
        doOptions1('AdModelProp_Addresses_' + nextIndex + '__Address', 'AdModelProp_Addresses_' + nextIndex + '__City', 'AdModelProp_Addresses_' + nextIndex + '__StateCodeFK', 'AdModelProp_Addresses_' + nextIndex + '__Zip', 'AdModelProp_Addresses_' + nextIndex + '__ProximityRadius', nextIndex);
        $('#map').html('Pending...');
    }

};
var list = new Array();
function doOptions1(address, city, state, zip, proximity, index1) {
    var script;
    var newUrl;
    if (index1 != null) {
        $('map_' + index1).html('Pending...');
        index = index1;
        script = document.createElement('script');
        script.type = 'text/javascript';
        showOptionsURL('buttonClick', address, city, state, zip, proximity, index1);
        newUrl = advancedOptions.replace('YOUR_KEY_HERE', APP_KEY);
        script.src = newUrl;
        document.body.appendChild(script);
    }
    else {
        address = address.replace('undefined', 0);
        city = city.replace('undefined', 0);
        state = state.replace('undefined', 0);
        zip = zip.replace('undefined', 0);
        proximity = proximity.replace('undefined', 0);
        index = city.toString().replace('Addresses', '');
        index = index.replace('City', '');
        index = index.replace('_', '');
        index = index.replace('__', '');
        $('map_' + index).html('Pending...');
        script = document.createElement('script');
        script.type = 'text/javascript';
        showOptionsURL('buttonClick', address, city, state, zip, proximity);
        newUrl = advancedOptions.replace('YOUR_KEY_HERE', APP_KEY);
        script.src = newUrl;
        document.body.appendChild(script);
    }
}