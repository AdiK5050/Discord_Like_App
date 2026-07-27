
//to be used later when extending support to web

@OptIn(ExperimentalComposeUiApi::class)
actual suspend fun ClipEntry.getText(): String? {
    return tryGet {
        val item = clipboardItems[0] ?: return null

        // Check if the item supports 'text/plain'
        val hasTextPlain = item.types.toList().map {
            it.toString()
        }.any { it == "text/plain" }
        if (!hasTextPlain) return null

        // Read the Blob as text
        val blob = item.getType("text/plain".toJsString()).await<Blob>()
        blob.readAsText()
    }
}
// Helper to read text from a Blob
suspend fun Blob.readAsText() = suspendCoroutine { cont ->
    val reader = FileReader()
    reader.onload = {
        cont.resume(reader.result.toString())
    }
    reader.onerror = {
        cont.resume(null)
    }
    reader.readAsText(this)
}