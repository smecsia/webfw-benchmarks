require "kemal"

class NoLog < Kemal::BaseLogHandler
  def call(context)
    call_next context
  end

  def write(message)
  end
end
Kemal.config.logger = NoLog.new

get "/" do
  "Hello World!"
end

Kemal.config.port = 8080
Kemal.run
