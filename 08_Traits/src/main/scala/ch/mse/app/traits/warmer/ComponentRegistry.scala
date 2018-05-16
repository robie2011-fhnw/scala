package ch.mse.app.traits.warmer

object ComponentRegistry extends
  OnOffDeviceComponentImpl with
  SensorDeviceComponentImpl with
  WarmerComponentImpl {

  val onOff = new Heater
  val sensor = new PotSensor
  val warmer = new Warmer

  def main(args: Array[String]): Unit = {
    val warmer = ComponentRegistry.warmer
    warmer.trigger
    warmer.trigger
  }
}
