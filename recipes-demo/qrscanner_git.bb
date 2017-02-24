SUMMARY = "QR code scanner Application on QT"
DESCRIPTION = "This application is used to demo the QZXing QR decoder \
in a simple QT application. The image source is from gstreamer appsink \
to get from UVC camera. Also preview is enabled "
LICENSE = "APACHE"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

DEPENDS = "qtbase qtquickcontrols gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad"

SRC_URI = "git://github.com/muddog/QRScanner.git \
	   file://qrscanner.png \
	   file://weston.ini \
	   file://weston \
"
SRCREV = "2089a84386ff4907176dd7c5e85e46ab1c8c933a"
S = "${WORKDIR}/git"

do_install_append() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/QRScanner ${D}${bindir}
    install -d ${D}${datadir}/weston
    install ${WORKDIR}/qrscanner.png ${D}${datadir}/weston/
    install -d ${D}${sysconfdir}
    install ${WORKDIR}/weston.ini ${D}${sysconfdir}
    install -d ${D}${sysconfdir}/default
    install ${WORKDIR}/weston ${D}${sysconfdir}/default/
}

FILES_${PN} += "${bindir}/QRScanner \
		${datadir}/weston/qrscanner.png \
		${sysconfdir}/weston.ini \
		${sysconfdir}/default/weston \
"

inherit qmake5
