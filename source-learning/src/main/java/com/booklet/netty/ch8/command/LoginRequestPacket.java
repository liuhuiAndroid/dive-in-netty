package com.booklet.netty.ch8.command;

import lombok.Data;

import static com.booklet.netty.ch8.command.Command.LOGIN_REQUEST;

@Data
public class LoginRequestPacket extends Packet {

    private Integer userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }

}
