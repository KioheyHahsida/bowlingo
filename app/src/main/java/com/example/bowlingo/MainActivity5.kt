package com.example.bowlingo

import Board
import Cell
import Score
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.ceil


class MainActivity5 : AppCompatActivity() {

    var colRow =5

    private val boardCells = Array(colRow) { arrayOfNulls<Button>(colRow) }
    val center = ceil(boardCells.size / 2.0 ).toInt() -1

    var board = Board(colRow)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadBoard()

        button_restart.setOnClickListener {
            board = Board(colRow)
            text_view_result.text = ""
            mapBoardToUi()
        }
    }

    private fun mapBoardToUi() {
        for (i in board.board.indices)
            for (j in board.board.indices) {
                when (board.board[i][j]) {
                    Board.PLAYER -> {
                        boardCells[i][j]?.setBackgroundResource(R.drawable.circle)
                        boardCells[i][j]?.isEnabled = true
                    }
                    else -> {
                        boardCells[i][j]?.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary))
                        boardCells[i][j]?.isEnabled = true
                    }
                }
            }
    }



    private fun loadBoard() {

        val strike = intent.getIntExtra(EXTRA_STRIKE,0)
        val gutter = intent.getIntExtra(EXTRA_GUTTER,0)
        val foul = intent.getIntExtra(EXTRA_FOUL,0)


        val score = Score()

        val tempArray = score.setTempArray(strike, gutter,foul)

        tempArray.shuffle()



        var num = 0

        for (i in boardCells.indices) {
            for (j in boardCells.indices) {
                boardCells[i][j] = Button(this)
                boardCells[i][j]?.layoutParams = GridLayout.LayoutParams().apply {
                    rowSpec = GridLayout.spec(i)
                    columnSpec = GridLayout.spec(j)
                    width = 285 - (21*colRow)
                    height = 285 - (21*colRow)
                    bottomMargin = 5
                    topMargin = 5
                    leftMargin = 5
                    rightMargin = 5
                }
                if (i == center && j == center){
                    boardCells[i][j]?.text= score.scoreData[(11 -strike)][0]
                }else {
                    boardCells[i][j]?.text = tempArray[num]

                    num += 1
                }

                layout_board.addView(boardCells[i][j])
                boardCells[i][j]?.setOnClickListener(CellClickListener1(i, j))
                boardCells[i][j]?.setBackgroundColor(
                        ContextCompat.getColor(
                                this,
                                R.color.colorPrimary
                        )
                )
            }
        }
    }



    inner class CellClickListener1(
            private val i: Int,
            private val j: Int
    ) : View.OnClickListener {

        override fun onClick(p0: View?) {

            val cell = Cell(i, j)
            board.placeMove(cell, Board.PLAYER)

            mapBoardToUi()

            when {
                board.countBingo(colRow) >0 -> {
                    var bingoNum = board.countBingo(colRow).toString() + "Bingo"
                    text_view_result.text = bingoNum
                }
                board.countBingo(colRow) ==0 -> {
                    text_view_result.text = ""
                }
            }
        }
    }
}


