# java-device-detector
java port of https://github.com/matomo-org/device-detector

# Get Start
1. download this project
2. get the latest regexes from https://github.com/matomo-org/device-detector/tree/master/regexes
3. run it
```
DeviceDetector d = new DeviceDetector();
CompositeDetectResult ret = d.parse(ua);
if(ret!=null) {
	System.out.println(ret);
}
```

# Customize
1. By default, DeviceDetector will detect bot, os, client and device
2. You can create your own DeviceDetector to customize the parsers and detect logic

# Environment
1. java8

# Performance
work in progress
1. Cache regex objects
2. Pre-match, tests the useragent against a combination of all regexes