package ch.mse.app.traits

object TraitTest1 {
	
	trait C1 {
		println(">>C1")
		def m = List("C1")
	}
	
	trait T1 extends C1 {
		println(">>T1")
		override def m = { "T1" :: super.m }
	}

	trait T2 extends C1 {
		println(">>T2")
		override def m = { "T2" :: super.m } 
	}

	trait T3 extends C1 {
		println(">>T3")
		override def m = { "T3" :: super.m }// super[C1].m
	}

	class C2 extends T2 {
		println(">>C2")
		override def m = { "C2" :: super.m }
	}
	
	class C3 extends C2 with T1 with T2 with T3 {
		println(">>C3")
		override def m = { "C3" :: super[T1].m }// super[T1].m
	}
	
	def main(args: Array[String]): Unit = {
		val c = new C3
		println(c.m)
	}
}