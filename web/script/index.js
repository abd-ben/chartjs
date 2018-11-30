/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $(window).on('load', function () {
        $.ajax({
            url: "graphFiliere",
            type: 'GET',
            cache: false,
            dataType: 'json',
            data: {},
            error: function (errorThrown) {
                console.log("Erreur");
            },
            success: function (data) {
                var code = [];
                var count = [];

                console.log(data);
                for (var i = 0; i < data.length; i++) {
                    code[i] = data[i][0];
                    count[i] = data[i][1];
                }

                var ctx = $("#myChart");
                var myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: code,
                        datasets: [{
                                label: '# of Votes',
                                data: count,
                                backgroundColor: [
                                    'rgba(255, 99, 132, 0.2)',
                                    'rgba(54, 162, 235, 0.2)',
                                    'rgba(255, 206, 86, 0.2)',
                                    'rgba(75, 192, 192, 0.2)',
                                    'rgba(153, 102, 255, 0.2)',
                                    'rgba(255, 159, 64, 0.2)'
                                ],
                                borderColor: [
                                    'rgba(255,99,132,1)',
                                    'rgba(54, 162, 235, 1)',
                                    'rgba(255, 206, 86, 1)',
                                    'rgba(75, 192, 192, 1)',
                                    'rgba(153, 102, 255, 1)',
                                    'rgba(255, 159, 64, 1)'
                                ],
                                borderWidth: 1
                            }]
                    },
                    options: {
                        scales: {
                            yAxes: [{
                                    ticks: {
                                        beginAtZero: true
                                    }
                                }]
                        }
                    }
                });
            }
        });
    });
});
