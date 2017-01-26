# Copyright (C) 2017 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Freescale Image for i.MX 6UL/ULL machines with QT5. \
This image contains everything used to test i.MX machines including GUI, \
demos and lots of applications. This creates a very large image, not \
suitable for production."
LICENSE = "MIT"

inherit core-image
inherit distro_features_check

CONFLICT_DISTRO_FEATURES = "directfb"

## Select Image Features
IMAGE_FEATURES += " \
    debug-tweaks \
    splash \
    hwcodecs \
"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    packagegroup-tools-bluetooth \
    packagegroup-fsl-tools-audio \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
    weston-init \
"

QT5_IMAGE_INSTALL = ""
QT5_IMAGE_INSTALL_mx6ul = " \
    qtwayland qtwayland-tools \
    qtwayland-plugins \  
    qtbase qtbase-fonts qtbase-plugins \
    qtsensors qtserialport qtsvg qtwebsockets qtwebchannel \
    qtconnectivity qtlocation qtimageformats qtmultimedia \
    qtsystems qttools qttranslations qtxmlpatterns \
    qtquickcontrols qtscript \
"

QT5_IMAGE_INSTALL_remove = "packagegroup-qt5-webengine qtbase-examples"

IMAGE_INSTALL += " \
    ${QT5_IMAGE_INSTALL} \
"
