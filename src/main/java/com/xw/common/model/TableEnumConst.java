package com.xw.common.model;

public class TableEnumConst {
    public enum User_status {
        //-1-删除，0-通过，2-回退，3-删除
        DELETE(-1), FREEZE(0), NORMAL(1);
        public int val;
        User_status(int val) {
            this.val = val;
        }
        public static User_status getByVal(int target) {
            for (User_status type : User_status.values()) {
                if (type.val == target) {
                    return type;
                }
            }
            throw new RuntimeException("无效的枚举值");
        }
    }

    public enum Admin_status {
        //-1-删除，0-通过，2-回退，3-删除
        DELETE(-1), FREEZE(0), NORMAL(1);
        public int val;
        Admin_status(int val) {
            this.val = val;
        }
        public static Admin_status getByVal(int target) {
            for (Admin_status type : Admin_status.values()) {
                if (type.val == target) {
                    return type;
                }
            }
            throw new RuntimeException("无效的枚举值");
        }
    }
}
