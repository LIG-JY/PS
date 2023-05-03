package lv1

class Babbling2 {
    companion object {
        val pronunciations = arrayOf("aya", "ye", "woo", "ma")
    }

    fun solution(babbling: Array<String>): Int {
        return babbling.count { isValid(it, "") }
    }

    private fun isValid(babbling: String, previousPronunciation: String): Boolean {
        if (babbling.isEmpty()) return true

        for (i in pronunciations.indices) {
            val currentPronunciation = pronunciations[i]
            if (currentPronunciation != previousPronunciation && babbling.startsWith(currentPronunciation)) {
                return isValid(babbling.substring(currentPronunciation.length), currentPronunciation)
            }
        }
        return false
    }
}