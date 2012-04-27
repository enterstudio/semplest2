var HOST_URL = 'http://www.mapquestapi.com'
var APP_KEY = 'Fmjtd%7Cluua2q6anl%2C7s%3Do5-hzbxq'
var SAMPLE_ADVANCED_POST = HOST_URL + '/geocoding/v1/address?key=YOUR_KEY_HERE&callback=renderOptions';
var advancedOptions = '';
var outFormat = '';
var index = ''
function showOptionsURL(type, elementName) {
    advancedOptions = SAMPLE_ADVANCED_POST;
    var location = '';
    if (elementName != null) {
        location = document.getElementById(elementName).value;
    }
    else {
        location = document.getElementById('Addresses_0__Address1').value;
    }
    var thumbMaps = 'true';
    var maxResults = 1;
    var delimiter = '';

    var inFormat = 'json';
    outFormat = 'json'; //TODO: document.getElementById('outFormat').value;
    advancedOptions += '&outFormat=' + outFormat;
    advancedOptions += '&inFormat=json';
    advancedOptions += "&json=";
    var jsonText = '{';
    jsonText += 'location:{street:"';
    if (location.length > 0) {
        jsonText += location;
    }
    jsonText += '"}';
    jsonText += ',options:{';
    jsonText += 'thumbMaps:' + thumbMaps;
    if (maxResults != "") {
        jsonText += ',maxResults:' + maxResults;
    }
    jsonText += '}}';
    advancedOptions += jsonText;

    var safe = advancedOptions;
};

function renderOptions(response) {
    var html = '';
    var i = 0;
    var j = 0;

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
        if (locations.length > 1) { // Location ambiguities!
            html = "<p>Ambiguous addresses found in request:</p><table>";
            for (i = 0; i < locations.length; i++) {
                var location = locations[i];

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
                document.getElementById('optionsNarrative_' + index).innerHTML = html;
            else
                document.getElementById('optionsNarrative').innerHTML = html;
            return;
        }

        if (locations.length == 1) {
            //html = "<p>Location:</p>";
            var location = locations[0];
            //            html += 'Country: ' + location.adminArea1;
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
            html += '<img src="' + location.mapUrl + '"/>';
            if (index != '')
                document.getElementById('optionsNarrative_' + index).innerHTML = html;
            else
                document.getElementById('optionsNarrative').innerHTML = html;
            return;
        }
    }
    else if (outFormat == "geojson") {

    }
    else {

    }

    document.getElementById('optionsNarrative_' + index).innerHTML = html;
}

function doOptions(elementName) {
    if (elementName != null) {
        index = elementName.toString().replace('Addresses', '');
        index = index.replace('Address1', '');
        index = index.replace('_', '');
        index = index.replace('__', '');
        document.getElementById('optionsNarrative_' + index).innerHTML = 'Pending...';
    }
    else {
        $('#optionsNarrative').html('Pending...');
    }
    var script = document.createElement('script');
    script.type = 'text/javascript';
    showOptionsURL('buttonClick', elementName);
    var newURL = advancedOptions.replace('YOUR_KEY_HERE', APP_KEY);
    script.src = newURL;
    document.body.appendChild(script);
};