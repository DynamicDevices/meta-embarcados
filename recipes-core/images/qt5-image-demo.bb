SUMMARY = "A Qt5 image with all examples and demos from meta-qt5"

LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += "package-management ssh-server-dropbear splash"

IMAGE_INSTALL += "\
			kernel-modules \
			packagegroup-qt5-base \
            packagegroup-qt5-fonts \
            packagegroup-qt5-graphics \
            packagegroup-qt5-web \
            packagegroup-qt5-extra \
			qtbase-examples \
			qt3d-examples \
            qtdeclarative-examples \
		    qtmultimedia-examples \
			qtsvg-examples \
			qtconnectivity-examples \
			qtlocation-examples \
			qtscript-examples \
			qtsensors-examples \
			qtsystems-examples \
			qttools-examples \
			qtxmlpatterns-examples \
			qtquickcontrols-examples \
			cinematicexperience \
			qt5everywheredemo \
			qt5ledscreen \
			qt5nmapcarousedemo \
			qt5nmapper \
			qtsmarthome \
     		quitbattery \
  		  	quitindicators \
			qsiv \
			qt5-demo-extrafiles \
            qtwebkit-examples-examples \
            gstreamer1.0-meta-base \
            gstreamer1.0-meta-video \
            gstreamer1.0-libav \
            gstreamer1.0-plugins-bad-fbdevsink \
            gstreamer1.0-plugins-bad-mpegpsdemux \
			"
