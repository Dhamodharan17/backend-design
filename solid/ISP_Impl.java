
public class LSP{
main(){
// don't make the client implement not required methods
}
}
// And segregate connection part so consumer can implement required interfaces.
 interface DAOInterface {
    public void createRecord();
    public void deleteRecord();
}

interface DBInterface {
    public void openConnection();
}

 interface FileInterface {
    public void openFile();
}


//Implemented method what is actual being operated by this.
 class DBDaoConnection implements  DAOInterface,DBInterface{
    @Override
    public void createRecord() {

    }

    @Override
    public void deleteRecord() {

    }

    @Override
    public void openConnection() {

    }
}

//Here dont need to bother about db part. - multiple inheritence
 class FileDaoConnection implements FileInterface,DAOInterface{
    @Override
    public void createRecord() {

    }

    @Override
    public void deleteRecord() {

    }

    @Override
    public void openFile() {

    }
}
