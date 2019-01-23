package org.jiage.srpc.api.message.service;

import org.jiage.srpc.api.message.vo.ProtocolVO;
import org.jiage.srpc.api.message.vo.TransferVO;

public interface Transfer {

    ProtocolVO transfer(TransferVO transfer) throws Exception;

    void transferImmediate(TransferVO transfer) throws Exception;
}
