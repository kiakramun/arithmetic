enum ArithmeticExpression {
  case Num(value: Int) extends ArithmeticExpression
  case Minus(expression: ArithmeticExpression) extends ArithmeticExpression
  case Plus(left: ArithmeticExpression, right: ArithmeticExpression) extends ArithmeticExpression
  case Mult(left: ArithmeticExpression, right: ArithmeticExpression) extends ArithmeticExpression
  case Div(left: ArithmeticExpression, right: ArithmeticExpression) extends ArithmeticExpression
  case Pow(base: ArithmeticExpression, exponent: ArithmeticExpression) extends ArithmeticExpression
}

object ArithmeticExpression {
  def evaluate(expression: ArithmeticExpression): Double = expression match {
    case Num(value) => value.toDouble
    case Minus(expr) => -evaluate(expr)
    case Plus(left, right) => evaluate(left) + evaluate(right)
    case Mult(left, right) => evaluate(left) * evaluate(right)
    case Div(left, right) => evaluate(left) / evaluate(right)
    case Pow(base, exponent) if evaluate(exponent) > 0
      => evaluate(base) * Math.pow(evaluate(base), evaluate(exponent) - 1)
    case Pow(base, exponent) if evaluate(exponent) < 0
      => (1 / evaluate(base)) * Math.pow(evaluate(base), evaluate(exponent) + 1)
  }
  def pretty(expression: ArithmeticExpression): String = expression match {
    case Num(value) => value.toString
    case Minus(expr) => s"(-${pretty(expr)})"
    case Plus(left, right) => s"(${pretty(left)} + ${pretty(right)})"
    case Mult(left, right) => s"(${pretty(left)} * ${pretty(right)})"
    case Div(left, right) => s"(${pretty(left)} / ${pretty(right)})"
    case Pow(base, exponent) => s"${pretty(base)} ^ ${pretty(exponent)}"
  
   
  }
}
