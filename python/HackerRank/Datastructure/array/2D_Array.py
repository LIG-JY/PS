def hourglassSum(arr):
        max = -70
        for i in range(1, 5):
            for j in range(1, 5):
                pivot = arr[i][j]
                hourglass = pivot + arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1] + arr[i + 1][j - 1] + arr[i + 1][
                    j] + arr[i + 1][j + 1]
                if hourglass > max:
                    max = hourglass
        return max

