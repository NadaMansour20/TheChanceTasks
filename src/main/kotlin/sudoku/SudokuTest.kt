package sudoku


fun TestSudoku(
    name:String,
    result:Boolean,
    correctResult:Boolean
){
    if(correctResult==result){
        println("Success :$name")
    }
    else{
        println("Failed :$name")
    }

}

fun main(){

    TestSudoku(
        name = "valid Sudoku 1",
        result = isValidSudoku(
            listOf(
                charArrayOf('5','3','_','_','7','_','_','_','_'),
                charArrayOf('6','_','_','1','9','5','_','_','_'),
                charArrayOf('_','9','8','_','_','_','_','6','_'),
                charArrayOf('8','_','_','_','6','_','_','_','3'),
                charArrayOf('4','_','_','8','_','3','_','_','1'),
                charArrayOf('7','_','_','_','2','_','_','_','6'),
                charArrayOf('_','6','_','_','_','_','2','8','_'),
                charArrayOf('_','_','_','4','1','9','_','_','5'),
                charArrayOf('_','_','_','_','8','_','_','7','9')
            )
        ),
        correctResult = true
    )
    TestSudoku(
        name = "valid Sudoku 2",
        result = isValidSudoku(
            listOf(
                charArrayOf('_','_','_','_','_','_','_','_','_'),
                charArrayOf('_','_','_','_','_','_','_','_','_'),
                charArrayOf('_','_','_','_','_','_','_','_','_'),
                charArrayOf('_','_','_','_','_','_','_','_','_'),
                charArrayOf('_','_','_','_','_','_','_','_','_'),
                charArrayOf('_','_','_','_','_','_','_','_','_'),
                charArrayOf('_','_','_','_','_','_','_','_','_'),
                charArrayOf('_','_','_','_','_','_','_','_','_'),
                charArrayOf('_','_','_','_','_','_','_','_','_')
            )
        ),
        correctResult = true
    )
    //////////////////////////////////////////////////////////////////

    TestSudoku(
        name = "Any row in the board contains a duplicate number",
        result = isValidSudoku(
            listOf(
                charArrayOf('5','3','3','_','7','_','_','_','_'), // duplicate 3
                charArrayOf('6','_','_','1','9','5','_','_','_'),
                charArrayOf('_','9','8','_','_','_','_','6','_'),
                charArrayOf('8','_','_','_','6','_','_','_','3'),
                charArrayOf('4','_','_','8','_','3','_','_','1'),
                charArrayOf('7','_','_','_','2','_','_','_','6'),
                charArrayOf('_','6','_','_','_','_','2','8','_'),
                charArrayOf('_','_','_','4','1','9','_','_','5'),
                charArrayOf('_','_','_','_','8','_','_','7','9')
            )),
        correctResult = false
    )
    TestSudoku(
        name = "Any column in the board contains a duplicate number",
        result = isValidSudoku(
            listOf(
                charArrayOf('5','3','_','_','7','_','_','_','_'),
                charArrayOf('6','_','_','1','9','5','_','_','_'),
                charArrayOf('5','9','8','_','_','_','_','6','_'), // duplicate 5 in column
                charArrayOf('8','_','_','_','6','_','_','_','6'),
                charArrayOf('4','_','_','8','_','3','_','_','1'),
                charArrayOf('7','_','_','_','2','_','_','_','6'),
                charArrayOf('_','6','_','_','_','_','2','8','_'),
                charArrayOf('_','_','_','4','1','9','_','_','5'),
                charArrayOf('_','_','_','_','8','_','_','7','9')
            )),
        correctResult = false
    )
    TestSudoku(
        name = "Duplicate number found in a 3x3 subgrid",
        result = isValidSudoku(
            listOf(
                charArrayOf('5','3','_','_','7','_','_','_','_'),
                charArrayOf('6','_','3','1','9','5','_','_','_'), // duplicate 3 in top-left box
                charArrayOf('_','9','8','_','_','_','_','6','_'),
                charArrayOf('8','_','_','_','6','_','_','_','3'),
                charArrayOf('4','_','_','8','_','3','_','_','1'),
                charArrayOf('7','_','_','_','2','_','_','_','6'),
                charArrayOf('_','6','_','_','_','_','2','8','_'),
                charArrayOf('_','_','_','4','1','9','_','_','5'),
                charArrayOf('_','_','_','_','8','_','_','7','9')
            )),
        correctResult = false
    )
    TestSudoku(
        name = "The board contains symbols",
        result = isValidSudoku(
            listOf(
                charArrayOf('5','3','_','_','7','_','_','_','_'),
                charArrayOf('6','_','_','1','9','5','_','_','_'),
                charArrayOf('_','p','8','_','_','_','_','6','_'),
                charArrayOf('8','_','_','_','6','_','_','_','3'),
                charArrayOf('4','_','_','8','@','3','_','_','1'), // @ is invalid
                charArrayOf('7','_','_','_','2','_','_','_','6'),
                charArrayOf('_','6','_','_','_','_','2','8','_'),
                charArrayOf('_','_','_','4','1','9','_','_','5'),
                charArrayOf('_','_','_','_','8','_','_','7','9')
            )),
        correctResult = false
    )
    TestSudoku(
        name = "In a 9x9 board: contains invalid numbers (values outside the range 1–9)",
        result = isValidSudoku(
            listOf(
                charArrayOf('5','3','_','_','A','_','_','_','_'),
                charArrayOf('6','_','_','1','9','1','_','_','_'),
                charArrayOf('_','9','8','_','_','_','_','6','_'),
                charArrayOf('8','_','_','_','6','_','_','_','3'),
                charArrayOf('4','_','_','8','0','3','_','_','1'), // 0 is invalid
                charArrayOf('7','_','_','_','2','_','_','_','6'),
                charArrayOf('_','6','_','_','_','_','2','8','_'),
                charArrayOf('_','_','_','4','1','9','_','_','5'),
                charArrayOf('_','_','_','_','8','_','_','7','9')
            )),
        correctResult = false
    )

    TestSudoku(
        name = "Board has less OR more than size of(rows*column)",
        result = isValidSudoku(
            listOf(
                charArrayOf('5','3','_','_','7','_','_','_','_'),
                charArrayOf('6','_','_','1','9','5','_','_'),
                charArrayOf('4','8','_','_','7','_','_','_','_','_'),

            )
        ),
        correctResult = false
    )





}