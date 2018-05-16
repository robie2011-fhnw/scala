package ch.mse.app.traits.warmer

trait OnOffDeviceComponent {
  val onOff: OnOffDevice		// abstract

  trait OnOffDevice {			// component type
    def on: Unit
    def off: Unit
  }
}
