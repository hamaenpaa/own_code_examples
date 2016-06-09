var ViewModel = function () {
    var self = this;
    self.trains = ko.observableArray();
    self.error = ko.observable();

    var trainsUri = '/api/Trains/';

    function ajaxHelper(uri, method, data) {
        self.error(''); // Clear error message
        return $.ajax({
            type: method,
            url: uri,
            dataType: 'json',
            contentType: 'application/json',
            data: data ? JSON.stringify(data) : null
        }).fail(function (jqXHR, textStatus, errorThrown) {
            self.error(errorThrown);
        });
    }

    function getAllTrains() {
        ajaxHelper(trainsUri, 'GET').done(function (data) {
            self.trains(data);
            console.log(data);
        });
    }

    // Fetch the initial data.
    getAllTrains();
};

ko.applyBindings(new ViewModel());