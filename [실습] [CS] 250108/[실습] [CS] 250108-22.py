import unittest
from mymodule import *

class TestMathFunctions(unittest.TestCase):
    def test_add(self):
        self.assertEqual(add(1,2), 3)
    def test_subtract(self):
        self.assertEqual(subtract(5,3), 2)
    def test_add_negative(self):
        self.assertEqual(add(-1,-2), -3)
    def test_subtract_negative(self):
        self.assertEqual(subtract(-5, -3),-2)


if __name__ == '__main__':
    unittest.main()