package sudoku


fun isValidSudoku(board: List<CharArray>): Boolean {

    return (!checkSymbolsAndZero(board)
            &&!checkImpty(board)&&
            !checkRow(board)&&
            !checkColumn(board)&&
            !checkSunbGrid(board)&&
            !checkSize(board))
}




fun checkRow(board: List<CharArray>):Boolean{

    for(row in board){

        var set= mutableSetOf<Char>()
        for(j in row){

            if(j!='_'&&j in set)return true

            set.add(j)
        }
    }
    return false

}

fun checkColumn(board: List<CharArray>):Boolean{

    for (column in board[0].indices){
        var set = mutableSetOf<Char>()

        for(row in board.indices){

            var cell=board[row][column]
            if(cell!='_'&& cell in set)return true
            set.add(cell)

        }
    }
    return false
}

fun checkImpty(board: List<CharArray>):Boolean{

    return board.isEmpty()
}

fun checkSymbolsAndZero(board: List<CharArray>):Boolean{

    for(row in board.indices) {
        for(column in board[row].indices){
            if(board[row][column]!='_'&&board[row][column] !in '1'..'9')
                return true
        }
    }
    return false
}

fun checkSunbGrid(board: List<CharArray>): Boolean {
    for (boxRow in 0 until 3) {
        for (boxCol in 0 until 3) {

            val set = mutableSetOf<Char>()

            for (i in 0 until 3) {
                for (j in 0 until 3) {
                    val row = boxRow * 3 + i
                    val col = boxCol * 3 + j
                    val cell = board[row][col]
                    if (cell != '_' && cell in set) return true
                    set.add(cell)
                }
            }
        }
    }
    return false
}

fun checkSize(board: List<CharArray>): Boolean {
    if (board.size != 9) return true
    for (row in board) {
        if (row.size != 9) return true
    }
    return false
}

fun main(){

    val board = mutableListOf<CharArray>()

    println("Enter Sudoku board (9 rows, use '_' for empty cells")

    repeat(9) {
        val line = readln().trim()
        board.add(line.toCharArray())
    }



    if (isValidSudoku(board)) {
        println("Sudoku board is valid.")
    } else {
        println("Sudoku board is invalid.")
    }
}









