/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
            angular.module('ATP_PLAYERS', ['ngWebSocket'])
                    .factory('ATP', function ($websocket) {
                        // Open a WebSocket connection
                        var url = "ws://localhost:8080/JEAOpnieuw/kwetterSocket";
                        console.log(url);
                        var ws;
                        var timeline = document.getElementById("goof");

                        var atp = [];
                        console.log('start connecting');
                        ws = $websocket(url);
                        ws.onMessage(function (event) {
                            console.log('message: ', event.data);
                            var response;
                            try {
                                response = angular.fromJson(event.data);
                                var tweetContent = document.createElement("a");
                                tweetContent.innerHTML = response.text;
                                var newTweetDiv = document.createElement("div");
                                newTweetDiv.className = "tweets";
                                newTweetDiv.appendChild(tweetContent);
                                timeline.insertBefore(newTweetDiv, timeline.firstChild);
                            } catch (e) {
                                console.log(e);
                            }
                        });
                        ws.onError(function (event) {
                            console.log('connection Error', event);
                        });
                        ws.onClose(function (event) {
                            console.log('connection closed', event);
                        });
                        ws.onOpen(function () {
                            console.log('connection open');
                        });

                        return {
                            atp: atp,
                            startConnecting: function (username) {

                            },
                            status: function () {
                                return ws.readyState;
                            },
                            send: function (message) {
                                console.log('sending message');
                                if (angular.isString(message)) {
                                    ws.send(message);
                                } else if (angular.isObject(message)) {
                                    ws.send(JSON.stringify(message));
                                }
                            }
                        };
                    })
                    .controller('atpController', function ($scope, ATP) {
                        $scope.ATP = ATP;
                        $scope.submit = function () {
                            var tweetMessage = { text: $scope.tweet , Gebruiker : "#{user.username}"};
                            ATP.send(tweetMessage);
                        };                                               
                    });
//                    