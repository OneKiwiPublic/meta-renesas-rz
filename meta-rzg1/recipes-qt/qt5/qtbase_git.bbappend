

# switch to GLES 2 support
PACKAGECONFIG_GL = "${@base_contains('DISTRO_FEATURES', 'opengl', 'gles2', '', d)}"

DEP = " ${@base_contains('DISTRO_FEATURES', 'opengl', 'gles-user-module', '', d)} \
	mtdev libxkbcommon freetype fontconfig libinput libproxy"
RDEPENDS_${PN} += "${DEP}"
RDEPENDS_${PN}-plugins += "${DEP}"
RDEPENDS_${PN}-examples += "${DEP}"

# add necessary packages
PACKAGECONFIG_append = " sql-sqlite sql-sqlite2 openssl icu accessibility examples alsa"