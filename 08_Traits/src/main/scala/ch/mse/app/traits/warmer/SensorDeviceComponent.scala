package ch.mse.app.traits.warmer

trait SensorDeviceComponent {
  val sensor: SensorDevice		 // abstract

  trait SensorDevice {			 // component type
    def isCoffeePresent: Boolean
  }
}
