public class Cell {
    private CellStatus status = CellStatus.EMPTY;

    public void setStatus(CellStatus status) {
        this.status = status;
    }

    public CellStatus getStatus() {
        return status;
    }

    public void printCell(){
        switch (status){
            case EMPTY:
                System.out.print("[ ]");
                break;
            case O:
                System.out.print("[O]");
                break;
            case X:
                System.out.print("[X]");
                break;
        }
    }
}
