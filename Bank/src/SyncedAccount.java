/**
 * Created by s-gheldd on 11/24/15.
 */
public class SyncedAccount extends UnsyncedAccount {


    @Override
    synchronized public void deposit(final long amount){
        super.deposit(amount);
    }

    @Override
    synchronized public void withdraw(final long amount){
        super.withdraw(amount);
    }

    @Override
    synchronized public long getBalance(){
        return super.getBalance();
    }
}
