var baseUrl = "http://localhost:9999/api";
export default {
    // user
    userAdd: baseUrl + "/user/addUser",
    userGetById: baseUrl + "/user/getUserById",
    userGetByName: baseUrl + "/user/getUserByName",
    login: baseUrl + "/user/login",
    getAllUsers: baseUrl + "/user/getAllUsers",
    deleteUserByIds: baseUrl + "/user/deleteUserByIds",
    updateUserAuthority: baseUrl + "/user/updateUserAuthority",
    //role
    roleList: baseUrl + "/user/roleList",
    // session 
    sessionCheck: baseUrl + "/session/check",
    // auth check
    authorityCheck: baseUrl + "/user/checkAuthority",
    // member
    memberList: baseUrl + "/member/listMemberByPage",
    addMember: baseUrl + "/member/addMember",
    deleteMemberByIds: baseUrl + "/member/deleteMemberByIds",
    updateMemberPass: baseUrl + "/member/updateMemberPass",
    // item
    itemList: baseUrl + "/item/listItemByPage",
    addItem: baseUrl + "/item/addItem",
    deleteItemByIds: baseUrl + "/item/deleteItemByIds",
    updateItemById: baseUrl + "/item/updateItemById",
    // storage
    storageList: baseUrl + "/storage/listStorageByPage",
    addStorage: baseUrl + "/storage/addStorage",
    deleteStorageByIds: baseUrl + "/storage/deleteStorageByIds",
    updateStorageById: baseUrl + "/storage/updateStorageById",
    // storage item operation
    putItemInStorage: baseUrl + "/storage/putItemInStorage",
    getItemFromStorage: baseUrl + "/storage/getItemFromStorage",
    getItemFromStorageByPage: baseUrl + "/storage/getItemFromStorageByPage",
    deleteItemFromStorage: baseUrl + "/storage/deleteItemFromStorage",
    updateItemInfo: baseUrl + "/storage/updateItemInfo",
    itemListAndinventory: baseUrl + "/storage/itemListAndinventory",
    // account
    accountList: baseUrl + "/account/listAccountByPage",
    addAccount: baseUrl + "/account/addAccount",
    deleteAccountByIds: baseUrl + "/account/deleteAccountByIds",
    updateAccountById: baseUrl + "/account/updateAccountById",
    activeAccountById: baseUrl + "/account/activeAccountById",
    // purchase order
    purchaseList: baseUrl + "/purchase/listOrderByPage",
    sellingList: baseUrl + "/purchase/listSellOrderByPage",
    deleteByTicketCode: baseUrl + "/purchase/deleteByTicketCode",
    addOrder: baseUrl + "/purchase/addOrder",
    addSellingOrder: baseUrl + "/purchase/addSellingOrder",
    // retail order
    listRetailOrderByPage: baseUrl + "/retail/listRetailOrderByPage",
    deleteByRetailCode: baseUrl + "/retail/deleteByRetailCode",
    addRetailOrder: baseUrl + "/retail/addRetailOrder",
    // data statistics
    memberStatus: baseUrl + "/statistics/memberStatus",
    retailStatus: baseUrl + "/statistics/retailStatus",
    accountStatus: baseUrl + "/statistics/accountStatus",
    purchaseStatus: baseUrl + "/statistics/purchaseStatus",
    totalNumberStatus: baseUrl + "/statistics/totalNumberStatus",

}