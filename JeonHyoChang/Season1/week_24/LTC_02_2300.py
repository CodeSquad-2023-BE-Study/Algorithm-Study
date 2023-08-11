class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        pairs = []
        potions.sort()

        for spell in spells:
            left, right = 0, len(potions) - 1

            while left <= right:
                mid = (left + right) // 2
                if potions[mid] * spell < success:
                    left = mid + 1
                else:
                    right = mid - 1
            pairs.append(len(potions) - left)

        return pairs
