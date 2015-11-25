/**
 * Created by s-gheldd on 11/24/15.
 */
public class LoopWithDrawer extends Thread{
    private final Account account;
    LoopWithDrawer(Account account){
        this.account = account;
    }

    @Override
    public void run(){
        while (!this.isInterrupted()) {
            //synchronized (this) {
                this.account.withdraw(100);
        //    }
        }
    }
}
