package ch.mse.app.logic

import scala.collection.Map

object Interpreter {
  
  type Value = Int
  type State = Map[String, Value]

  def eval(expr: BoolExpr, state: State): Boolean =
    expr match {
      case LitBExpr(value) => value
      case NegBExpr(expr) => !eval(expr, state)
      case DyaBExpr(CondAnd, op1, op2) => eval(op1, state) && eval(op2, state)
      case DyaBExpr(CondOr, op1, op2) => eval(op1, state) || eval(op2, state)
      case RelBExpr(GreaterEq, left, right) => eval(left, state) >= eval(right, state)
    }

  def eval(expr: ArithExpr, state: State): Value =
    expr match {
      case LitAExpr(value) => value
      case IdAExpr(name) => state.get(name).get
      case DyaAExpr(Plus, expr1, expr2) => eval(expr1, state) + eval(expr2, state)
      case DyaAExpr(Minus, expr1, expr2) => eval(expr1, state) - eval(expr2, state)
    }

  def eval(cmd: Cmd, state: State): State =
    cmd match {
      case SkipCmd => state
      case AssiCmd(key, expr) => state.updated(key, eval(expr, state))
      case WhileCmd(expr, commands) =>  {
        if (eval(expr, state)) {
          val newState = eval(commands, state)
          eval(WhileCmd(expr, commands), newState)
        } else {
          return state
        }
      }
      case CpsCmd(commands) => {
        if (commands.length > 1) {
          val remainingCmds = new CpsCmd(commands.tail)
          val newState = eval(commands.head, state)
          eval(remainingCmds, newState)
        } else {
          eval(commands.head, state)
        }
      }
    }
}