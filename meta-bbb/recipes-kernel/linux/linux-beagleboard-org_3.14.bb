SECTION = "kernel"
DESCRIPTION = "Linux kernel from Beagleboard.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc


# Look in the generic major.minor directory for files
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-3.14:"

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

# Add a run-time dependency for the PM firmware to be installed
# on the target file system.
RDEPENDS_kernel-base_append_ti33x = " am33x-cm3"

KERNEL_DEVICETREE_CAPES = " am335x-bone-4dcape-43.dtb \
                            am335x-bone-4dcape-43t.dtb \
                            am335x-bone-4dcape-70.dtb \
                            am335x-bone-4dcape-70t.dtb \
                            am335x-bone-audio-reva.dtb \
                            am335x-bone-audio-revb.dtb \
                            am335x-bone-base.dtb \
                            am335x-bone-bb-view-43.dtb \
                            am335x-bone-bbb-exp-c.dtb \
                            am335x-bone-can1.dtb \
                            am335x-bone-cape-bone-argus.dtb \
                            am335x-bone-crypto-00a0.dtb \
                            am335x-bone-lcd3-01-00a2.dtb \
                            am335x-bone-lcd4-01-00a1.dtb \
                            am335x-bone-lcd7-01-00a2.dtb \
                            am335x-bone-lcd7-01-00a3.dtb \
                            am335x-bone-rtc-01-00a1.dtb \
                            am335x-bone-ttyO1.dtb \
                            am335x-bone-ttyO2.dtb \
                            am335x-bone-ttyO4.dtb \
                            am335x-bone-ttyO5.dtb \
                            am335x-boneblack-4dcape-43.dtb \
                            am335x-boneblack-4dcape-43t.dtb \
                            am335x-boneblack-4dcape-70.dtb \
                            am335x-boneblack-4dcape-70t.dtb \
                            am335x-boneblack-audio-reva.dtb \
                            am335x-boneblack-audio-revb.dtb \
                            am335x-boneblack-base.dtb \
                            am335x-boneblack-bb-view-43.dtb \
                            am335x-boneblack-bbb-exp-c.dtb \
                            am335x-boneblack-can1.dtb \
                            am335x-boneblack-cape-bone-argus.dtb \
                            am335x-boneblack-crypto-00a0.dtb \
                            am335x-boneblack-lcd3-01-00a2.dtb \
                            am335x-boneblack-lcd4-01-00a1.dtb \
                            am335x-boneblack-lcd7-01-00a2.dtb \
                            am335x-boneblack-lcd7-01-00a3.dtb \
                            am335x-boneblack-rtc-01-00a1.dtb \
                            am335x-boneblack-ttyO1.dtb \
                            am335x-boneblack-ttyO2.dtb \
                            am335x-boneblack-ttyO4.dtb \
                            am335x-boneblack-ttyO5.dtb \
                            am335x-boneblack-wl1835mod.dtb \
                          "

# Default is to package all dtb files for ti33x devices unless building
# for the specific beaglebone machine.
KERNEL_DEVICETREE_beaglebone = "am335x-bone.dtb am335x-boneblack.dtb am335x-bonegreen.dtb ${KERNEL_DEVICETREE_CAPES}"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

COMPATIBLE_MACHINE = "ti33x"

S = "${WORKDIR}/git"

BRANCH = "3.14"

# Corresponds to tag 3.14.43-ti-r66
SRCREV = "2e28c16dbfd8a8c8ff74b0ca9bc29d8317eee825"
PV = "3.14.43"

# Append to the MACHINE_KERNEL_PR so that a new SRCREV will cause a rebuild
MACHINE_KERNEL_PR_append = "-ti-r66-${SRCPV}"
PR = "${MACHINE_KERNEL_PR}"

#KERNEL_CONFIG_FRAGMENTS_append_ti33x = " ${WORKDIR}/remove-extra-firmware.cfg"

KERNEL_GIT_URI = "git://github.com/beagleboard/linux.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI += "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig \
           "

#file://remove-extra-firmware.cfg           
#do_configure_append() {
#    rm -rf ${S}/firmware/am335x-pm-firmware.*
#}

INSANE_SKIP_kernel-dev += "debug-files"
