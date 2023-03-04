import sys
from typing import List

class Grade:
    def __init__(self, fg: int, sg: int):
        self.fg = fg
        self.sg = sg

def main() -> None:
    T = int(sys.stdin.readline())
    result: List[int] = []
    for i in range(T):
        grade_list: List[Grade] = []
        N = int(sys.stdin.readline())
        for j in range(N):
            fg, sg = map(int, sys.stdin.readline().split())
            grade_list.append(Grade(fg, sg))

        # sort the list by first grade in ascending order
        grade_list.sort(key=lambda x: x.fg)

        # count the number of passing applicants & set the standard of the second grade
        passer_count = 1
        standard = grade_list[0].sg

        # if the rank is higher than the standard, add the applicant to the passer list and change the standard
        for x in range(1, N):
            if standard > grade_list[x].sg:
                passer_count += 1
                standard = grade_list[x].sg

        result.append(passer_count)

    for temp in result:
        print(temp)

if __name__ == '__main__':
    main()
