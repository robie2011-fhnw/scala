package ch.mse.app.logic

abstract class BoolOperator 
case object CondAnd extends BoolOperator 
case object CondOr extends BoolOperator

abstract class RelOperator
case object GreaterEq extends RelOperator

abstract class ArithOperator
case object Plus extends ArithOperator
case object Minus extends ArithOperator

abstract class BoolExpr
case class LitBExpr(value: Boolean) extends BoolExpr
case class NegBExpr(expr: BoolExpr) extends BoolExpr
case class DyaBExpr(operator: BoolOperator, op1: BoolExpr, op2: BoolExpr) extends BoolExpr
case class RelBExpr(operator: RelOperator, left: ArithExpr, right: ArithExpr) extends BoolExpr

abstract class ArithExpr
case class LitAExpr(value: Int) extends ArithExpr
case class IdAExpr(name: String) extends ArithExpr
case class DyaAExpr(operator: ArithOperator, expr1: ArithExpr, expr2: ArithExpr) extends ArithExpr

abstract class Cmd
case object SkipCmd extends Cmd
case class CpsCmd(commands: List[Cmd]) extends Cmd
case class AssiCmd(key: String, expr: ArithExpr) extends Cmd
case class WhileCmd(expr: BoolExpr, commands: CpsCmd) extends Cmd