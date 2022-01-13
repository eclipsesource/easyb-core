# easyb 0.9.8 - patched for Java 11

## Setup

Easyb uses the build tool `gant`.
It is available as part of the Ubuntu Universe update site.
See https://ubuntu.pkgs.org/20.04/ubuntu-universe-amd64/gant_1.9.11-7_all.deb.html

    sudo apt install gant

## Build

Build jar and sources jar. Creates easyb-0.9.8.jar and easyb-0.9.8-sources.jar in `./target`.

    gant jar jar-sources

Build with custom version name:

    gant -Dversion=my-version jar jar-sources

## Notes

* The `.gant` files are actually groovy scripts.
* The Java source and target versions to build for can be configured in `default_tasks.gant`, line 207.