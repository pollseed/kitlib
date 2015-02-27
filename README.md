# kitlib
[![Build Status](https://travis-ci.org/pollseed/kitlib.svg?branch=master)](https://travis-ci.org/pollseed/kitlib)
##Environment
* java 1.7
* gradle 2.1

##Summary
Java Auxiliary Library

##Getting Started

```
$ gradle build
$ gradle eclipse
```

##Dependencies

* org.apache.commons:commons-lang3:3.3.2
* commons-io:commons-io:2.4
* org.hamcrest, name: 'hamcrest-core', version: '1.3'
* junit, name: 'junit-dep', version: '4.10'
* org.hamcrest, name: 'hamcrest-library', version: '1.3'
* org.mockito, name: 'mockito-core', version: '1.9.+'

##Extension

1. Please make 'Class name + Test' class in 'src/test/java/pollseed/tools/helper', write test code to the file.
2. Please run the following command.

```
$ gradle test
```
