public class LSP{

  main(){
    // LSP - applies for both class and interface
    // ISP - only for interface
  }
  
}

//interaface have both interfaces for file operation db operation, so db clients are forced to implement file operation which is not needed.
interface BadDAOInterface {
    public void openConnection();
    public void createRecord();
    public void openFile();
    public void deleteRecord();
}

// data connection class
class BadDBDaoConnection implements BadDAOInterface {
    @Override
    public void openConnection() {
        //Connection logic
    }

    @Override
    public void createRecord() {
        //Create record logic
    }

    @Override
    public void openFile() {
        // We are in DB Connection so no need to support open file
        throw new UnsupportedOperationException("Open file Not supported");
    }

    @Override
    public void deleteRecord() {
        // This is fine
    }
}

//file connection class
class BadFileDaoConnection implements BadDAOInterface{
    @Override
    public void openConnection() {
        //We can't open connection in file system
    }

    @Override
    public void createRecord() {

    }

    @Override
    public void openFile() {

    }

    @Override
    public void deleteRecord() {

    }
}
