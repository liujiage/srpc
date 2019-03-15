package org.jiage.srpc.server.service;

import org.jiage.srpc.api.message.constant.TransferConst;
import org.jiage.srpc.api.message.service.Server;
import org.jiage.srpc.api.message.transfer.Transfer;
import org.jiage.srpc.api.message.vo.TransferVO;
import org.jiage.srpc.server.transfer.ServerTransfer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerService implements Server,Runnable {

    private Transfer transfer = new ServerTransfer();
    private ExecutorService exec = Executors.newSingleThreadExecutor();

    public ServerService(){

    }

    public ServerService(Transfer transfer){
        this.transfer = transfer;
    }

    @Override
    public void start() throws Exception {
        exec.execute(this);
    }

    @Override
    public void stop() {
        try {
            this.transfer.disconnect();
            this.exec.shutdown();
        }catch (Exception e){
            /*do nothing*/
        }
    }

    @Override
    public void run() {
        try {
            transfer.transferImmediate(new TransferVO(TransferConst.PORT));
        }catch(Exception e){
            e.printStackTrace();
            /*do noting*/
        }
    }
}
