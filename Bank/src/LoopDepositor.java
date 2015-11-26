/**
 * Created by s-gheldd on 11/24/15.
 */
public class LoopDepositor extends Thread {
    private final Account account;
    LoopDepositor(Account account){
        this.account = account;
    }

    @Override
    public void run(){
        while (!this.isInterrupted()) {
            //synchronized (account) {
                this.account.deposit(100);
        //    }
        }
    }

}
