var HOST_URL = 'http://www.mapquestapi.com';
var APP_KEY = 'Fmjtd%7Cluua2q6anl%2C7s%3Do5-hzbxq';
var SAMPLE_ADVANCED_POST = HOST_URL + '/geocoding/v1/address?key=YOUR_KEY_HERE&callback=renderOptions';
var advancedOptions = '';
var outFormat = '';
var index = '';


function showOptionsURL(type, address, city, state, zip, proximity) {
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
    
        if (miles > 0  && miles <= 1  ) return 13;
        if (miles > 1  && miles <= 1.5) return 12;
        if (miles > 1.5 && miles <= 3.0) return 11;
        if (miles > 3.0  && miles <= 6.0  ) return 10;
        if (miles > 6.0  && miles <= 14  ) return 9;
        if (miles > 14  && miles <= 32  ) return 8;
        if (miles > 32  && miles <= 50  ) return 7;
        if (miles > 50  && miles <= 100  ) return 6;
        if (miles > 100  && miles <= 200  ) return 5;
        if (miles > 200  && miles <= 400  ) return 4;
        if (miles > 400  && miles <= 800  ) return 3;
        if (miles > 800  ) return 2;
        

}

function renderOptions(response) {
    var cloudmadeUrl = 'http://{s}.tile.cloudmade.com/BC9A493B41014CAABB98F0471D759707/997/256/{z}/{x}/{y}.png',
            cloudmadeAttribution = '',
            cloudmade = new L.TileLayer(cloudmadeUrl, { maxZoom: 18, attribution: cloudmadeAttribution });
    if (outFormat == "json") {
        var locations = response.results[0].locations;
        var location = locations[0];
        var map;
        var markerLocation;
        var marker;
        var circleLocation;
        var circleOptions;
        var circle;

        if (index != 0) {

            //$('#map_' + index.split('_')[1])[0]._leaflet = null;
            if (map == null) {
                map = new L.Map('map_' + index.split('_')[1], { zoomControl: false, doubleClickZoom: false, attributionControl: false });
            }
            var proxVal = this.$.find("input[id='AdModelProp_Addresses_" + index.split('_')[1] + "__ProximityRadius']")[0].value;
            if (proxVal == null || proxVal == "")
                proxVal = 0;
            var zoomval = getCustomZoom(proxVal);
            if (zoomval == null)
                zoomval = 13;
            var lng = location.latLng.lng;
            var lat = location.latLng.lat;
            if (lng > -98)
                map.setView(new L.LatLng(lat, lng), zoomval, true).addLayer(cloudmade);
            else
                map.setView(new L.LatLng(lat, lng), 3, true).addLayer(cloudmade);
                
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
            this.$.find("input[id='AdModelProp_Addresses_" + index.split('_')[1] + "__Latitude']")[0].value = location.latLng.lat;
            this.$.find("input[id='AdModelProp_Addresses_" + index.split('_')[1] + "__Longitude']")[0].value = location.latLng.lng;
        } else {
            //this is first map
            //$('#map')[0]._leaflet = null;
            if (map == null) {
                map = new L.Map('map', { zoomControl: false, doubleClickZoom: false, attributionControl: false, trackResize: false });
            }
            var proxValElse = $('#AdModelProp_Addresses_0__ProximityRadius').val();
            if (proxValElse == null || proxValElse == "")
                proxValElse = 0;
            var zoomvalElse = getCustomZoom(proxValElse);
            if (zoomvalElse == null)
                zoomvalElse = 3;
            map.setView(new L.LatLng(location.latLng.lat, location.latLng.lng), zoomvalElse, true).addLayer(cloudmade);
            markerLocation = new L.LatLng(location.latLng.lat, location.latLng.lng);
            marker = new L.Marker(markerLocation);
            map.addLayer(marker);
            if (proxValElse > 0) {
                circleLocation = new L.LatLng(location.latLng.lat, location.latLng.lng);
                circleOptions = { color: '#f03', opacity: 0.7 };
                circle = new L.Circle(circleLocation, $('#AdModelProp_Addresses_0__ProximityRadius').val() * 1609.344, circleOptions);
                map.addLayer(circle);
            }
        bounds = new L.LatLngBounds(map.getBounds()._northEast, map.getBounds()._southWest);

            //map.fitBounds(new L.LatLngBounds(new L.LatLng(location.latLng.lat, location.latLng.lng)));
            //map.fitBounds(circle.getBounds());

            $('#AdModelProp_Addresses_0__Latitude').val(location.latLng.lat);
            $('#AdModelProp_Addresses_0__Longitude').val(location.latLng.lng);
        }
        return;
    }
}

function doOptions(address, city, state, zip, proximity) {
    //alert('in doOptions');
    if (city != null) {
        index = city.toString().replace('Addresses', '');
        index = index.replace('City', '');
        index = index.replace('_', '');
        index = index.replace('__', '');
        $('map_' + index).html('Pending...');
    } else {
        $('#map').html('Pending...');
    }
    var script = document.createElement('script');
    script.type = 'text/javascript';
    showOptionsURL('buttonClick', address, city, state, zip, proximity);
    var newUrl = advancedOptions.replace('YOUR_KEY_HERE', APP_KEY);
    script.src = newUrl;
    document.body.appendChild(script);
};
