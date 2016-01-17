//initialization select
$(document).ready(function () {
    $('select').material_select();
});

//initialization datepicker
$('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 15 // Creates a dropdown of 15 years to control year
});

//initialization tooltipped
$(document).ready(function () {
    $('.tooltipped').tooltip({delay: 1});
});
      