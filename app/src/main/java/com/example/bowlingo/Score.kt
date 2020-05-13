import java.util.*

class Score() {

    val scoreData = arrayOf(
        arrayOf("G/0", "G/1", "G/2", "G/3", "G/4", "G/5", "G/6", "G/7", "G/8", "G/9", "G/◢"),
        arrayOf("1/-", "1/1", "1/2", "1/3", "1/4", "1/5", "1/6", "1/7", "1/8", "1/◢"),
        arrayOf("2/-", "2/1", "2/2", "2/3", "2/4", "2/5", "2/6", "2/7", "2/◢"),
        arrayOf("3/-", "3/1", "3/2", "3/3", "3/4", "3/5", "3/6", "3/◢"),
        arrayOf("4/-", "4/1", "4/2", "4/3", "4/4", "4/5", "4/◢"),
        arrayOf("5/-", "5/1", "5/2", "5/3", "5/4", "5/◢"),
        arrayOf("6/-", "6/1", "6/2", "6/3", "6/◢"),
        arrayOf("7/-", "7/1", "7/2", "7/◢"),
        arrayOf("8/-", "8/1", "8/◢"),
        arrayOf("9/-", "9/◢"),
        arrayOf("☒"),
        arrayOf("FREE")
    )

    fun setTempArray(strike: Int, gutter: Int, foul: Int): ArrayList<String> {

        // 新しいArrayListを準備
        val tmpArray = ArrayList<String>()

        var i = gutter
        var j = foul

        while(i < scoreData.size - strike - 1) {
            while(j < scoreData[i].size) {

                // クイズデータを追加
                tmpArray.add(scoreData[i][j])

                j += 1
            }
            j = foul
            i += 1
        }

        return tmpArray
    }
}