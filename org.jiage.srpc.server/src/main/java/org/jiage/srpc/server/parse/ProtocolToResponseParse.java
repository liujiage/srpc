package org.jiage.srpc.server.parse;


import org.jiage.srpc.api.message.parse.Parse;
import org.jiage.srpc.api.message.vo.ResponseVO;
import org.jiage.srpc.api.message.constant.MsgFormatConst;
import org.jiage.srpc.api.message.vo.ProtocolVO;

public class ProtocolToResponseParse implements Parse<ResponseVO,ProtocolVO> {

    @Override
    public ResponseVO convert(ProtocolVO protocol) throws Exception {
        switch(protocol.getFormat()){
            case MsgFormatConst.STRING_VALUE:
                return new ResponseVO(new String(protocol.getMessage()));
            default:
                throw new Exception("Not found support the format of message in protocol! ");
        }
    }
}
