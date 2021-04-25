var baseUrl = "http://localhost:9999/api";
export default {
    // user
    userAdd: baseUrl + "/user/addUser",
    userGetById: baseUrl + "/user/getUserById",
    userGetByName: baseUrl + "/user/getUserByName",
    login: baseUrl + "/user/login",
    // session 
    sessionCheck: baseUrl + "/session/check",
    // member
    memberList: baseUrl + "/member/listMemberByPage",
    addMember: baseUrl+"/member/addMember",
    deleteMemberByIds: baseUrl +"/member/deleteMemberByIds",
    updateMemberPass: baseUrl +"/member/updateMemberPass",
}