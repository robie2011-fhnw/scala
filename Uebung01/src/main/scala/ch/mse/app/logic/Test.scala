package ch.mse.app.logic

import Interpreter.eval

import scala.collection.Map
import scala.collection.immutable.HashMap

object Test {

  def main(args: Array[String]) {
    val bExpr = DyaBExpr(CondAnd, LitBExpr(true), LitBExpr(false));
    println(eval(bExpr, new HashMap[String, Int]()));

    println("Scala Übung 1")
    val intDiv = CpsCmd(List(
      AssiCmd("q", LitAExpr(0)),
      AssiCmd("r", IdAExpr("m")),
      WhileCmd(
        RelBExpr(GreaterEq, IdAExpr("r"), IdAExpr("n")),
        CpsCmd(List(
          AssiCmd("q", DyaAExpr(Plus, IdAExpr("q"), LitAExpr(1))),
          AssiCmd("r", DyaAExpr(Minus, IdAExpr("r"), IdAExpr("n")))))),
      SkipCmd));

    val map = Map[String, Int]("m" -> 5, "n" -> 2)
    println("map = " + map)
    println("res = " + Interpreter.eval(intDiv, map))
  }

}