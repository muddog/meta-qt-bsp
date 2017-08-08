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
    tools-profile \
    splash \
    nfs-server \
    tools-debug \
    ssh-server-openssh \
    hwcodecs \
"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    packagegroup-tools-bluetooth \
    packagegroup-fsl-tools-audio \
    packagegroup-fsl-tools-benchmark \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
    weston-init \
    weston-calibrate \
    qrscanner \
"

QT5_IMAGE_INSTALL = " \
    packagegroup-qt5-toolchain-target \
    packagegroup-qt5-qtcreator-debug \
    packagegroup-qt5-demos \
    qtwayland \
    qtwayland-plugins \  
    qtbase qtbase-fonts qtbase-plugins \
"

QT5_IMAGE_INSTALL_remove = "packagegroup-qt5-webengine qtbase-examples"

IMAGE_INSTALL += " \
    ${QT5_IMAGE_INSTALL} \
"
