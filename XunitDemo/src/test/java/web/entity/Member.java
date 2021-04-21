package web.entity;

import lombok.Data;

@Data
public class Member {
    private String nickName;
    private String telephone;
    private String mail;
    private String address;
    private String innerPostion;
    private String imagPath;
}
