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
    // item
    itemList: baseUrl + "/item/listItemByPage",
    addItem: baseUrl+"/item/addItem",
    deleteItemByIds: baseUrl +"/item/deleteItemByIds",
    updateItemById: baseUrl +"/item/updateItemById",
    // storage
    storageList: baseUrl + "/storage/listStorageByPage",
    addStorage: baseUrl+"/storage/addStorage",
    deleteStorageByIds: baseUrl +"/storage/deleteStorageByIds",
    updateStorageById: baseUrl +"/storage/updateStorageById",
}