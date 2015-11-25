import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {
        ArrayList<LoopWithDrawer> withDrawers = new ArrayList<>();
        ArrayList<LoopDepositor> depositors = new ArrayList<>();
        Account unsyncedAccount = new UnsyncedAccount();

        for(int i = 0; i < 5; i++){
            withDrawers.add(new LoopWithDrawer(unsyncedAccount));
            withDrawers.add(new LoopWithDrawer(unsyncedAccount));
            depositors.add(new LoopDepositor(unsyncedAccount));
        }

        withDrawers.stream().parallel().forEach(LoopWithDrawer::start);
        depositors.stream().parallel().forEach(LoopDepositor::start);


        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        depositors.stream().forEach(LoopDepositor::interrupt);
        withDrawers.stream().forEach(LoopWithDrawer::interrupt);

        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("\n\n*************************************************\n****************** second run  ******************\n*************************************************\n\n");

        Account syncedAccount = new SyncedAccount();
        withDrawers = new ArrayList<>();
        depositors = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            withDrawers.add(new LoopWithDrawer(syncedAccount));
            withDrawers.add(new LoopWithDrawer(syncedAccount));
            depositors.add(new LoopDepositor(syncedAccount));
        }

        withDrawers.stream().parallel().forEach(LoopWithDrawer::start);
        depositors.stream().parallel().forEach(LoopDepositor::start);


        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        depositors.stream().forEach(LoopDepositor::interrupt);
        withDrawers.stream().forEach(LoopWithDrawer::interrupt);



    }
}
