require u-boot-common_${PV}.inc
require u-boot.inc

DEPENDS += "bc-native dtc-native"

UBOOT_URL = "git://github.com/OneKiwiPublic/uboot-renesas-rz.git"
BRANCH = "onekiwi-bsp-3.0.3-v2021.10/rz"

SRC_URI = "${UBOOT_URL};branch=${BRANCH}"
SRCREV = "99468ea4af0dab19c65a47ab9f5ad95ad3edc2d3"
PV = "v2021.10+git${SRCPV}"
