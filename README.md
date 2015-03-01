# kitlib

[![Join the chat at https://gitter.im/pollseed/kitlib](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/pollseed/kitlib?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Circle CI](https://circleci.com/gh/pollseed/kitlib.svg?style=svg)](https://circleci.com/gh/pollseed/kitlib)
[![Build Status](https://travis-ci.org/pollseed/kitlib.svg?branch=master)](https://travis-ci.org/pollseed/kitlib)
[![Apache LISENCE](https://img.shields.io/badge/lisence-Apache%202.0-yellowgreen.svg)](https://github.com/pollseed/kitlib/blob/master/LISENCE)
[![Coverage Status](https://coveralls.io/repos/pollseed/kitlib/badge.svg)](https://coveralls.io/r/pollseed/kitlib)

##Environment
* java 1.7.0_72
* gradle 2.2.1

##Summary
'kitlib' is Kit's Library, Java Auxiliary Library

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

##Directory Structure

```
.
├── LISENCE
├── README.md
├── bin
├── build
├── build.gradle
└── src
    ├── main
    │   ├── java
    │   │   └── pollseed
    │   │       └── tools
    │   │           ├── helper
    │   │           └── util
    │   └── resources
    └── test
        ├── java
        │   └── pollseed
        │       └── tools
        │           ├── helper
        │           └── util
        └── resources
            └── pollseed
                └── tools
                    ├── helper
                    └── util
```

##Domain
src/main/java/pollseed

###tools
Auxiliary source that will be called.

####helper
* Collection of instance functions.
* Or a local feature, many processes, such as run out creating an instance.

####util
* Collection of static functions.
* A high degree of influence on the frequency-range both to be used.
