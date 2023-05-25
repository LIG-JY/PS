class FoodFightCompetition {
    fun solution(food: IntArray): String {
        val sb = StringBuilder();
        for (i in 1 until food.size) {
            sb.append(i.toString().repeat(food[i] / 2))
        }
        val reverseSb = StringBuilder(sb).reverse();
        return sb.append(0).append(reverseSb).toString();
    }
}