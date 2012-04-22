﻿var HOST_URL = 'http://www.mapquestapi.com';
var APP_KEY = 'Fmjtd%7Cluua2q6anl%2C7s%3Do5-hzbxq';
var SAMPLE_ADVANCED_POST = HOST_URL + '/geocoding/v1/address?key=YOUR_KEY_HERE&callback=renderOptions';
var advancedOptions = '';
var outFormat = '';
var index = '';

function showOptionsURL(type, city, state, zip, proximity) {
    advancedOptions = SAMPLE_ADVANCED_POST;
    var location = {};
    if (city == ' ' || city == '' || city == null) {
        location.city = $('#Addresses_0__City').val();
        location.state = $('#Addresses_0__StateCodeFK').val();
        location.zip = $('#Addresses_0__Zip').val();
    } else {
        location.city = $('#' + city).val();
        location.state = $('#' + state).val();
        location.zip = $('#' + zip).val();
    }
    var thumbMaps = 'true';
    var maxResults = 1;
    outFormat = 'json'; 
    advancedOptions += '&outFormat=' + outFormat;
    advancedOptions += '&inFormat=json';
    advancedOptions += "&json=";
    var jsonText = '{';
    jsonText += 'location:{city:"';
    jsonText += location.city;
    jsonText += '",state:"';
    jsonText += location.state;
    jsonText += '"}';

    jsonText += ',options:{';
    jsonText += 'thumbMaps:' + thumbMaps;
    if (maxResults != "") {
        jsonText += ',maxResults:' + maxResults;
    }
    jsonText += '}}';
    alert(jsonText);
    advancedOptions += jsonText;
};

function renderOptions(response) {
    var html = '';
    var i;

    if (outFormat == "json") {
        if (response.info.statuscode && (response.info.statuscode != 200)) {
            var text = "Whoops!  There was an error during the request:\n";
            if (response.info.messages) {
                for (i = 0; i < response.info.messages.length; i++) {
                    text += response.info.messages[i] + "\n";
                }
            }
            if (index != '')
                document.getElementById('optionsNarrative_' + index).innerHTML = text;
            else
                document.getElementById('optionsNarrative').innerHTML = text;
            return;
        }

        var locations = response.results[0].locations;
        var location;
        if (locations.length > 1) { // Location ambiguities!
            html = "<p>Ambiguous addresses found in request:</p><table>";
            for (i = 0; i < locations.length; i++) {
                location = locations[i];
                html += '<tr><td>';
                html += ' ' + (location.adminArea5 || ' ');
                html += ' ' + (location.adminArea4 || ' ');
                html += ' ' + (location.adminArea3 || ' ');
                html += ' ' + (location.adminArea2 || ' ');
                html += ' ' + (location.adminArea1 || ' ');
                html += '</td>';
                if (location.mapUrl) {
                    html += '<td>';
                    html += '<img src="' + location.mapUrl + '"/>';
                    html += '</td>';
                }
                html += '</tr>';
            }
            html += '</table>';
            if (index != '')
                $('#optionsNarrative_' + index).html(html);
            else
                $('#optionsNarrative').html(html);
            return;
        }

        //html = "<p>Location:</p>";
        location = locations[0]; //            html += 'Country: ' + location.adminArea1;
        //            html += '<br/>';
        //            html += 'State: ' + location.adminArea3;
        //            html += '<br/>';
        //            html += 'County: ' + location.adminArea4;
        //            html += '<br/>';
        //            html += 'City: ' + location.adminArea5;
        //            html += '<br/>';
        //            html += 'Response Code:' + location.geocodeQualityCode;
        //            html += '<br/>';
        //            html += 'Lat: ' + location.latLng.lat + "   Lng: " + location.latLng.lng;
        //            html += '<br/>';
        //html += 'Static Map: ' + '<img src="' + location.mapUrl + '"/>';
        html += '<img src="' + location.mapUrl + '" style="height: 160px; width:160px;"/>';
        alert(index);
        if (index != 0)
            $('#optionsNarrative_' + index).html(html);
        else
            $('#optionsNarrative').html(html);
        return;
    }
    $('#optionsNarrative_' + index).html(html);
}

function doOptions(city, state, zip, proximity) {
    if (city != null) {
        index = city.toString().replace('Addresses', '');
        index = index.replace('City', '');
        index = index.replace('_', '');
        index = index.replace('__', '');
        $('optionsNarrative_' + index).html('Pending...');
    } else {
        $('#optionsNarrative').html('Pending...');
    }
    var script = document.createElement('script');
    script.type = 'text/javascript';
    showOptionsURL('buttonClick', city, state, zip, proximity);
    var newUrl = advancedOptions.replace('YOUR_KEY_HERE', APP_KEY);
    script.src = newUrl;
    document.body.appendChild(script);
};