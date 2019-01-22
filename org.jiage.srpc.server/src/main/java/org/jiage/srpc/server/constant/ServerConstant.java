package org.jiage.srpc.server.constant;

public interface ServerConstant extends TcpConstant {

    /*
      Http tcp/ip listen backlog used to init server quest
      Such as use OS net.core.somaxconn and make sure SO allow open number of files
      Such as used OS command unlimit -n
    */
    int SO_BACKLOG = 100;
    //Allow multi process used the same port
    boolean SO_REUSEADDR = true;
    //TCP Nagle
    boolean TCP_NODELAY = false;
    /*
       TCP send data buffer size  such as SNDBUF = 1000Mb/s * 1ms = 128KB
     */
    int SO_SNDBUF = 128;
    int SO_RCVBUF = 128;


}
