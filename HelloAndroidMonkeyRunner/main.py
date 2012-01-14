from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

device = MonkeyRunner.waitForConnection()

device.startActivity('com.blogspot.sassylog.helloandroid.HelloAndroidActivity')

result = device.takeSnapshot()
result.writeToFile('./shot1.png', 'png')
