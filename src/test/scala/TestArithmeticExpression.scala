import org.scalatest.funsuite.AnyFunSuite

class TestArithmeticExpression extends AnyFunSuite {

  test("evaluate method should calculate the correct result") {
    val expr0 = ArithmeticExpression.Num(42)
    val expr1 = ArithmeticExpression.Minus(ArithmeticExpression.Num(42))
    val expr2 = ArithmeticExpression.Plus(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4))
    val expr3 = ArithmeticExpression.Mult(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4))
    val expr4 = ArithmeticExpression.Div(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4))

    assert(ArithmeticExpression.evaluate(expr0) == 42.0)
    assert(ArithmeticExpression.evaluate(expr1) == -42.0)
    assert(ArithmeticExpression.evaluate(expr2) == 6.0)
    assert(ArithmeticExpression.evaluate(expr3) == 8.0)
    assert(ArithmeticExpression.evaluate(expr4) == 0.5)
  }

  test("pretty method should format the expression in infix notation") {
    val expr0 = ArithmeticExpression.Num(42)
    val expr1 = ArithmeticExpression.Minus(ArithmeticExpression.Num(42))
    val expr2 = ArithmeticExpression.Plus(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4))
    val expr3 = ArithmeticExpression.Mult(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4))
    val expr4 = ArithmeticExpression.Div(ArithmeticExpression.Num(2), ArithmeticExpression.Num(4))

    assert(ArithmeticExpression.pretty(expr0) == "42")
    assert(ArithmeticExpression.pretty(expr1) == "(-42)")
    assert(ArithmeticExpression.pretty(expr2) == "(2 + 4)")
    assert(ArithmeticExpression.pretty(expr3) == "(2 * 4)")
    assert(ArithmeticExpression.pretty(expr4) == "(2 / 4)")
  }
}
