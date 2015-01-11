ENV['VAGRANT_DEFAULT_PROVIDER'] = 'docker'

Vagrant.configure("2") do |config|
  config.vm.define "unit4" do |a|
    a.vm.provider "docker" do |d|
      d.build_dir = "."
      d.build_args = ["-t=unit4dev"]
      d.ports = ["8080:8080"]
      d.name = "unit4dev"
      d.remains_running = true
      d.cmd = ["mvn", "exec:java"]
    end
  end
end