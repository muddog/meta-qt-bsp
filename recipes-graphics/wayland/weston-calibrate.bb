SUMMARY = "Calibrate script file for the Weston Wayland"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

SRC_URI = "file://weston-calibrate"

S = "${WORKDIR}"

do_install_append () {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/weston-calibrate ${D}${sysconfdir}/init.d/
}

inherit update-rc.d

INITSCRIPT_NAME = "weston-calibrate"
INITSCRIPT_PARAMS = "start 30 5 2 ."
