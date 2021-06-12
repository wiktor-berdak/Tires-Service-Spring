$(function() {
    $("#datetimepicker1").datetimepicker({
        format: 'DD/MM/YYYY HH:mm',
        daysOfWeekDisabled: [0, 6],
        minDate: new Date(),
        stepping: 30,
        enabledHours: [8, 9, 10, 11, 12, 13, 14, 15, 16, 17],
        disabledDates: [
            ("11/01/2021"),
            ("11/11/2021")
        ]
    });
});


