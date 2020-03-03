<?xml version="1.0"?>
<recipe>

    <instantiate from="root/src/app_package/Activity.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${className}Activity.kt" />
    <instantiate from="root/src/app_package/ActivityModule.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${className}ActivityModule.kt" />
    <instantiate from="root/src/app_package/ViewModel.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${className}ViewModel.kt" />
    <instantiate from="root/src/app_package/View.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${className}View.kt" />

    <instantiate from="root/res/layout/activity.xml.ftl"
        to="${escapeXmlAttribute(resOut)}/layout/${resourceName}_activity.xml" />
    <instantiate from="root/res/layout/view.xml.ftl"
        to="${escapeXmlAttribute(resOut)}/layout/${resourceName}_view.xml" />

</recipe>
