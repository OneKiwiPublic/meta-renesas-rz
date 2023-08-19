require u-boot-common_${PV}.inc
require u-boot.inc

DEPENDS += "bc-native dtc-native"

UBOOT_URL = "git://github.com/OneKiwiPublic/uboot-renesas-rz.git"
BRANCH = "onekiwi-bsp-3.0.3-v2021.10/rz"

SRC_URI = "${UBOOT_URL};branch=${BRANCH}"
SRCREV = "93e6b3c98e929441b132bbd76cabed5cda8a44d5"
PV = "v2021.10+git${SRCPV}"
