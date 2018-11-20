$(".error-fresh").click(function() {
    location.reload()
}),
$(".error-index").click(function() {
    $(location).attr("href", PROJECT_PATH + "/course/queryList.do")
});