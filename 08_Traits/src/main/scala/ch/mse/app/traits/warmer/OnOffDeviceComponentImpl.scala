package ch.mse.app.traits.warmer

trait OnOffDeviceComponentImpl extends OnOffDeviceComponent {
  class Heater extends OnOffDevice {
    trait State
    case object On extends State
    case object Off extends State
    private var state: State = Off
    def on = { if(state == Off) println("turn heater on"); state = On }
    def off = { if(state == On) println("turn heater off"); state = Off }
  }
}
