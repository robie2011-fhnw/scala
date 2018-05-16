package ch.mse.app.traits

trait Logger {
  def log(msg: String)
}

trait Cloneable {
  protected def clone(): Object
}

trait ConsoleLogger {
  def log(msg: String) { println(msg) }
}

object Test {
  def main(args: Array[String]) {
    val a = new DebitAccount
    a.deposit(100)
    a.withdraw(200)

    val s = new SavingsAccount
    s.deposit(100)
    s.withdraw(200)
  }
}

class Account {
  val id = Account.newUniqueNumber()
  var balance = 0.0 // error: private
  def deposit(amount: Double) { balance += amount }
  //...
}
object Account { // The companion object
  private var lastNumber = 0
  private def newUniqueNumber() = { lastNumber += 1; lastNumber }
}

class SavingsAccount extends Account with ConsoleLogger {
  def withdraw(amount: Double) {
    if (amount > balance) log("insufficent funds")
    else balance -= amount
  }
}

class DebitAccount extends Account with ConsoleLogger {
  def withdraw(amount: Double) {
    log(s"withdraw($amount) called")
    balance -= amount
  }
  override def log(msg: String) { super.log("DebitAccount." + msg) }
}

