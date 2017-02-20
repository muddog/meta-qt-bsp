FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
     file://0001-Workaround-to-enable-the-imxvideoconvert_pxp-convert.patch \
     file://0002-Make-camera-demo-work-for-the-UVC-camera.patch \
"

EXTRA_QMAKEVARS_PRE_remove = "CONFIG+=done_config_gstreamer"
