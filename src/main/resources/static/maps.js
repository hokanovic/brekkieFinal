
function initMap() {

    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 3,
        center: {
            lat: 55.604981,
            lng: 13.003822000000014
        }
    });

    var labels = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';

    var markers = locations.map(function(location, i) {
        return new google.maps.Marker({
            position: location,
            label: labels[i % labels.length]
        });
    });

    var markerCluster = new MarkerClusterer(map, markers, {
        imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'
    });
}
var locations = [{
    lat: 59.9138688,
    lng: 10.752245399999993
}, {
    lat: 55.604981,
    lng: 13.003822000000014
}, {
    lat: 58.9699756,
    lng: 5.733107399999994
}, {
    lat: 55.6760968,
    lng: 12.568337199999974
}, {
    lat: 60.16985569999999,
    lng: 24.93837910000002
},{
    lat: 50.0755381,
    lng: 14.43780049999998
},{
    lat: 56.9496487,
    lng: 24.105186499999945
}]

