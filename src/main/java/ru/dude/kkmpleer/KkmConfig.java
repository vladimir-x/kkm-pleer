package ru.dude.kkmpleer;

public class KkmConfig {

    String type;

    String comPort;
    String comSpeed;

    String ip;
    String port;


    public KkmConfig(String type, String com_port_speed, String ip_port) {
        this.type = type;
        if (com_port_speed != null) {
            String[] c = com_port_speed.split(":");
            this.comPort = c[0];
            this.comSpeed = c[1];
        }

        if (ip_port != null) {
            String[] c = ip_port.split(":");
            this.ip = c[0];
            this.port = c[1];
        }

        if (isIpConnection() && isComPortConnection()) {
            throw new IllegalArgumentException("ComPort and IP connection can't use at the same time");
        }
    }



    public String getType() {
        return type;
    }

    public String getComPort() {
        return comPort;
    }

    public String getComSpeed() {
        return comSpeed;
    }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    public boolean isIpConnection() {
        return ip != null && ip.length() > 0;
    }

    public boolean isComPortConnection() {
        return comPort != null && comPort.length() > 0;
    }

    @Override
    public String toString() {
        return "KkmConfig{" +
                "type='" + type + '\'' +
                ", comPort='" + comPort + '\'' +
                ", comSpeed='" + comSpeed + '\'' +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
