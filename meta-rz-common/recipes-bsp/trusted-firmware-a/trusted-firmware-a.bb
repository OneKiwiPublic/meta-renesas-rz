DESCRIPTION = "Trusted Firmware-A for Renesas RZ"

LICENSE = "BSD-3-Clause & MIT & Apache-2.0"
LIC_FILES_CHKSUM = " \
	file://${WORKDIR}/git/docs/license.rst;md5=b2c740efedc159745b9b31f88ff03dde \
	file://${WORKDIR}/mbedtls/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit deploy

S = "${WORKDIR}/git"

BRANCH = "onekiwi-bsp-3.0.3-v2.7/rz"
BRANCH_mbedtls = "mbedtls-2.28"

SRC_URI = " \
	git://github.com/OneKiwiPublic/atf-renesas-rz.git;branch=${BRANCH};protocol=https \
	git://github.com/ARMmbed/mbedtls.git;branch=${BRANCH_mbedtls};name=mbedtls;destsuffix=mbedtls \
"

SRCREV = "ca15d76fce9dc7800998d39c728ddce8567afa2b"
SRCREV_mbedtls = "dd79db10014d85b26d11fe57218431f2e5ede6f2"

PV = "v2.7+git"

COMPATIBLE_MACHINE_rzg2h = "(ek874|hihope-rzg2m|hihope-rzg2n|hihope-rzg2h)"
COMPATIBLE_MACHINE_rzg2l = "(smarc-rzg2l|rzg2l-dev|smarc-rzg2lc|rzg2lc-dev|smarc-rzg2ul|rzg2ul-dev|smarc-rzv2l|rzv2l-dev|renesas-rzg2l-evk)"

PLATFORM ?= "rzg"

# requires CROSS_COMPILE set by hand as there is no configure script
export CROSS_COMPILE="${TARGET_PREFIX}"

# Let the Makefile handle setting up the CFLAGS and LDFLAGS as it is a standalone application
CFLAGS[unexport] = "1"
LDFLAGS[unexport] = "1"
AS[unexport] = "1"
LD[unexport] = "1"

do_deploy() {
    # Create deploy folder
    install -d ${DEPLOYDIR}

    # Copy IPL to deploy folder
    install -m 0644 ${S}/build/${PLATFORM}/release/bl2/bl2.elf ${DEPLOYDIR}/bl2-${MACHINE}.elf
    install -m 0644 ${S}/build/${PLATFORM}/release/bl2.bin ${DEPLOYDIR}/bl2-${MACHINE}.bin
    install -m 0644 ${S}/build/${PLATFORM}/release/bl31/bl31.elf ${DEPLOYDIR}/bl31-${MACHINE}.elf
    install -m 0644 ${S}/build/${PLATFORM}/release/bl31.bin ${DEPLOYDIR}/bl31-${MACHINE}.bin
}

addtask deploy before do_build after do_compile
