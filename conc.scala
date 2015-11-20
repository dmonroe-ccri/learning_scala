val hello = new Thread(new Runnable {
  def run(): Unit = {
    println("Allo")
  }
})

hello.start