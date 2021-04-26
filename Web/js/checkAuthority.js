import urlInfo from '../baseURL.js'

var checkAuth = (userId, auth,done) => {
    $.ajaxSettings.async = false;
    $.get(urlInfo.authorityCheck, {
        userId: userId,
        auth: auth
    }, function (data, status) {
        if (data == -1) {
            layer.msg('user cannot operate ' + auth);
            console.log("auth failed");
            return -1;
        } else {
            console.log("auth succeed");
            done();
            return 1;
        }
    });
    $.ajaxSettings.async = true;
}

export { checkAuth }