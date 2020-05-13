class Board(int:Int){

    private val colRow = int

    //Strings for PLAYER
    companion object {
        const val PLAYER = "O"
    }


    //This is our internal board
    //and for this we used a 3 by 3 array of Strings
    val board = Array(colRow) { arrayOfNulls<String>(colRow) }


    fun countBingo(colRow:Int ): Int {

        var bingo = 0

        when(colRow){
            3 ->{
                if (board[0][0] == board[1][1] &&
                    board[0][0] == board[2][2] &&
                    board[0][0] == PLAYER)
                {
                    bingo += 1
                }


                if(board[0][2] == board[1][1] &&
                    board[0][2] == board[2][0] &&
                    board[0][2] == PLAYER)
                {
                    bingo += 1
                }

                for (i in board.indices) {
                    if (board[i][0] == board[i][1] &&
                        board[i][0] == board[i][2] &&
                        board[i][0] == PLAYER){
                        bingo += 1
                    }

                    if (board[0][i] == board[1][i] &&
                        board[0][i] == board[2][i] &&
                        board[0][i] == PLAYER) {
                        bingo += 1
                    }
                }

            }
            5 ->{
                if (board[0][0] == board[1][1] &&
                    board[0][0] == board[2][2] &&
                    board[0][0] == board[3][3] &&
                    board[0][0] == board[4][4] &&
                    board[0][0] == PLAYER)
                {
                    bingo += 1
                }


                if(board[0][4] == board[1][3] &&
                   board[0][4] == board[2][2] &&
                   board[0][4] == board[3][1] &&
                   board[0][4] == board[4][0] &&
                   board[0][4] == PLAYER)
                {
                   bingo += 1
                }

                for (i in board.indices) {
                    if (board[i][0] == board[i][1] &&
                        board[i][0] == board[i][2] &&
                        board[i][0] == board[i][3] &&
                        board[i][0] == board[i][4] &&
                        board[i][0] == PLAYER){
                        bingo += 1
                    }

                    if (board[0][i] == board[1][i] &&
                        board[0][i] == board[2][i] &&
                        board[0][i] == board[3][i] &&
                        board[0][i] == board[4][i] &&
                        board[0][i] == PLAYER) {
                        bingo += 1
                    }
                }
            }
            7 ->{
                if (board[0][0] == board[1][1] &&
                    board[0][0] == board[2][2] &&
                    board[0][0] == board[3][3] &&
                    board[0][0] == board[4][4] &&
                    board[0][0] == board[5][5] &&
                    board[0][0] == board[6][6] &&
                    board[0][0] == PLAYER)
                {
                    bingo += 1
                }


                if(board[0][6] == board[1][5] &&
                    board[0][6] == board[2][4] &&
                    board[0][6] == board[3][3] &&
                    board[0][6] == board[4][2] &&
                    board[0][6] == board[5][1] &&
                    board[0][6] == board[6][0] &&
                    board[0][6] == PLAYER)
                {
                    bingo += 1
                }

                for (i in board.indices) {
                    if (board[i][0] == board[i][1] &&
                        board[i][0] == board[i][2] &&
                        board[i][0] == board[i][3] &&
                        board[i][0] == board[i][4] &&
                        board[i][0] == board[i][5] &&
                        board[i][0] == board[i][6] &&
                        board[i][0] == PLAYER){
                        bingo += 1
                    }

                    if (board[0][i] == board[1][i] &&
                        board[0][i] == board[2][i] &&
                        board[0][i] == board[3][i] &&
                        board[0][i] == board[4][i] &&
                        board[0][i] == board[5][i] &&
                        board[0][i] == board[6][i] &&
                        board[0][i] == PLAYER) {
                        bingo += 1
                    }
                }
            }
        }
        return bingo
    }


    //in this var we will store the computersMove
    var computersMove: Cell? = null

    //this function is placing a move in the given cell
    fun placeMove(cell: Cell, player: String) {
        if(board[cell.i][cell.j] == player){
            board[cell.i][cell.j] = null
        }else{
            board[cell.i][cell.j] = player
        }


    }

}