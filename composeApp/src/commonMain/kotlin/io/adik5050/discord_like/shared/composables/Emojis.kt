package me.trysurpass.util

/**
 * Auto-generated from Unicode emoji-test.txt, Version 17.0.
 *
 * Contains the RGI emoji set from emoji-test.txt: all fully-qualified emoji
 * sequences plus standalone emoji components. No package is declared so this
 * file can be dropped into any Kotlin/JVM, Android, or multiplatform source set.
 */
object Emojis {
    const val UNICODE_EMOJI_VERSION: String = "17.0"
    const val COUNT: Int = 3953

    data class Emoji(
        val emoji: String,
        val name: String,
        val codepoints: String,
        val group: String,
        val subgroup: String,
        val status: String
    )

    val DEFAULT_REACTIONS: List<Emoji> by lazy(LazyThreadSafetyMode.PUBLICATION) {
        val whatsappReactionNames = setOf(
            "thumbs up",
            "red heart",
            "face with tears of joy",
            "face with open mouth",
            "crying face",
            "folded hands",
            "party popper"
        )

        ALL.filter { it.name in whatsappReactionNames }
    }

    /** Full RGI emoji records, parsed lazily to keep the generated class compiler-friendly. */
    val ALL: List<Emoji> by lazy(LazyThreadSafetyMode.PUBLICATION) {
        RAW.asSequence()
            .flatMap { it.lineSequence() }
            .filter { it.isNotBlank() }
            .map { line ->
                val parts = line.split('	')
                Emoji(
                    emoji = parts[0],
                    name = parts[1],
                    codepoints = parts[2],
                    group = parts[3],
                    subgroup = parts[4],
                    status = parts[5]
                )
            }
            .toList()
    }

    /** Just the emoji strings, in Unicode order. */
    val CHARACTERS: List<String> by lazy(LazyThreadSafetyMode.PUBLICATION) {
        ALL.map { it.emoji }
    }

    /** Lookup by the Unicode emoji name, e.g. "grinning face". */
    val BY_NAME: Map<String, Emoji> by lazy(LazyThreadSafetyMode.PUBLICATION) {
        ALL.associateBy { it.name }
    }

    private val RAW: Array<String> = arrayOf(
        """
😀	grinning face	1F600	Smileys & Emotion	face-smiling	fully-qualified
😃	grinning face with big eyes	1F603	Smileys & Emotion	face-smiling	fully-qualified
😄	grinning face with smiling eyes	1F604	Smileys & Emotion	face-smiling	fully-qualified
😁	beaming face with smiling eyes	1F601	Smileys & Emotion	face-smiling	fully-qualified
😆	grinning squinting face	1F606	Smileys & Emotion	face-smiling	fully-qualified
😅	grinning face with sweat	1F605	Smileys & Emotion	face-smiling	fully-qualified
🤣	rolling on the floor laughing	1F923	Smileys & Emotion	face-smiling	fully-qualified
😂	face with tears of joy	1F602	Smileys & Emotion	face-smiling	fully-qualified
🙂	slightly smiling face	1F642	Smileys & Emotion	face-smiling	fully-qualified
🙃	upside-down face	1F643	Smileys & Emotion	face-smiling	fully-qualified
🫠	melting face	1FAE0	Smileys & Emotion	face-smiling	fully-qualified
😉	winking face	1F609	Smileys & Emotion	face-smiling	fully-qualified
😊	smiling face with smiling eyes	1F60A	Smileys & Emotion	face-smiling	fully-qualified
😇	smiling face with halo	1F607	Smileys & Emotion	face-smiling	fully-qualified
🥰	smiling face with hearts	1F970	Smileys & Emotion	face-affection	fully-qualified
😍	smiling face with heart-eyes	1F60D	Smileys & Emotion	face-affection	fully-qualified
🤩	star-struck	1F929	Smileys & Emotion	face-affection	fully-qualified
😘	face blowing a kiss	1F618	Smileys & Emotion	face-affection	fully-qualified
😗	kissing face	1F617	Smileys & Emotion	face-affection	fully-qualified
☺️	smiling face	263A FE0F	Smileys & Emotion	face-affection	fully-qualified
😚	kissing face with closed eyes	1F61A	Smileys & Emotion	face-affection	fully-qualified
😙	kissing face with smiling eyes	1F619	Smileys & Emotion	face-affection	fully-qualified
🥲	smiling face with tear	1F972	Smileys & Emotion	face-affection	fully-qualified
😋	face savoring food	1F60B	Smileys & Emotion	face-tongue	fully-qualified
😛	face with tongue	1F61B	Smileys & Emotion	face-tongue	fully-qualified
😜	winking face with tongue	1F61C	Smileys & Emotion	face-tongue	fully-qualified
🤪	zany face	1F92A	Smileys & Emotion	face-tongue	fully-qualified
😝	squinting face with tongue	1F61D	Smileys & Emotion	face-tongue	fully-qualified
🤑	money-mouth face	1F911	Smileys & Emotion	face-tongue	fully-qualified
🤗	smiling face with open hands	1F917	Smileys & Emotion	face-hand	fully-qualified
🤭	face with hand over mouth	1F92D	Smileys & Emotion	face-hand	fully-qualified
🫢	face with open eyes and hand over mouth	1FAE2	Smileys & Emotion	face-hand	fully-qualified
🫣	face with peeking eye	1FAE3	Smileys & Emotion	face-hand	fully-qualified
🤫	shushing face	1F92B	Smileys & Emotion	face-hand	fully-qualified
🤔	thinking face	1F914	Smileys & Emotion	face-hand	fully-qualified
🫡	saluting face	1FAE1	Smileys & Emotion	face-hand	fully-qualified
🤐	zipper-mouth face	1F910	Smileys & Emotion	face-neutral-skeptical	fully-qualified
🤨	face with raised eyebrow	1F928	Smileys & Emotion	face-neutral-skeptical	fully-qualified
😐	neutral face	1F610	Smileys & Emotion	face-neutral-skeptical	fully-qualified
😑	expressionless face	1F611	Smileys & Emotion	face-neutral-skeptical	fully-qualified
😶	face without mouth	1F636	Smileys & Emotion	face-neutral-skeptical	fully-qualified
🫥	dotted line face	1FAE5	Smileys & Emotion	face-neutral-skeptical	fully-qualified
😶‍🌫️	face in clouds	1F636 200D 1F32B FE0F	Smileys & Emotion	face-neutral-skeptical	fully-qualified
😏	smirking face	1F60F	Smileys & Emotion	face-neutral-skeptical	fully-qualified
😒	unamused face	1F612	Smileys & Emotion	face-neutral-skeptical	fully-qualified
🙄	face with rolling eyes	1F644	Smileys & Emotion	face-neutral-skeptical	fully-qualified
😬	grimacing face	1F62C	Smileys & Emotion	face-neutral-skeptical	fully-qualified
😮‍💨	face exhaling	1F62E 200D 1F4A8	Smileys & Emotion	face-neutral-skeptical	fully-qualified
🤥	lying face	1F925	Smileys & Emotion	face-neutral-skeptical	fully-qualified
🫨	shaking face	1FAE8	Smileys & Emotion	face-neutral-skeptical	fully-qualified
🙂‍↔️	head shaking horizontally	1F642 200D 2194 FE0F	Smileys & Emotion	face-neutral-skeptical	fully-qualified
🙂‍↕️	head shaking vertically	1F642 200D 2195 FE0F	Smileys & Emotion	face-neutral-skeptical	fully-qualified
😌	relieved face	1F60C	Smileys & Emotion	face-sleepy	fully-qualified
😔	pensive face	1F614	Smileys & Emotion	face-sleepy	fully-qualified
😪	sleepy face	1F62A	Smileys & Emotion	face-sleepy	fully-qualified
🤤	drooling face	1F924	Smileys & Emotion	face-sleepy	fully-qualified
😴	sleeping face	1F634	Smileys & Emotion	face-sleepy	fully-qualified
🫩	face with bags under eyes	1FAE9	Smileys & Emotion	face-sleepy	fully-qualified
😷	face with medical mask	1F637	Smileys & Emotion	face-unwell	fully-qualified
🤒	face with thermometer	1F912	Smileys & Emotion	face-unwell	fully-qualified
🤕	face with head-bandage	1F915	Smileys & Emotion	face-unwell	fully-qualified
🤢	nauseated face	1F922	Smileys & Emotion	face-unwell	fully-qualified
🤮	face vomiting	1F92E	Smileys & Emotion	face-unwell	fully-qualified
🤧	sneezing face	1F927	Smileys & Emotion	face-unwell	fully-qualified
🥵	hot face	1F975	Smileys & Emotion	face-unwell	fully-qualified
🥶	cold face	1F976	Smileys & Emotion	face-unwell	fully-qualified
🥴	woozy face	1F974	Smileys & Emotion	face-unwell	fully-qualified
😵	face with crossed-out eyes	1F635	Smileys & Emotion	face-unwell	fully-qualified
😵‍💫	face with spiral eyes	1F635 200D 1F4AB	Smileys & Emotion	face-unwell	fully-qualified
🤯	exploding head	1F92F	Smileys & Emotion	face-unwell	fully-qualified
🤠	cowboy hat face	1F920	Smileys & Emotion	face-hat	fully-qualified
🥳	partying face	1F973	Smileys & Emotion	face-hat	fully-qualified
🥸	disguised face	1F978	Smileys & Emotion	face-hat	fully-qualified
😎	smiling face with sunglasses	1F60E	Smileys & Emotion	face-glasses	fully-qualified
🤓	nerd face	1F913	Smileys & Emotion	face-glasses	fully-qualified
🧐	face with monocle	1F9D0	Smileys & Emotion	face-glasses	fully-qualified
😕	confused face	1F615	Smileys & Emotion	face-concerned	fully-qualified
🫤	face with diagonal mouth	1FAE4	Smileys & Emotion	face-concerned	fully-qualified
😟	worried face	1F61F	Smileys & Emotion	face-concerned	fully-qualified
🙁	slightly frowning face	1F641	Smileys & Emotion	face-concerned	fully-qualified
☹️	frowning face	2639 FE0F	Smileys & Emotion	face-concerned	fully-qualified
😮	face with open mouth	1F62E	Smileys & Emotion	face-concerned	fully-qualified
😯	hushed face	1F62F	Smileys & Emotion	face-concerned	fully-qualified
😲	astonished face	1F632	Smileys & Emotion	face-concerned	fully-qualified
😳	flushed face	1F633	Smileys & Emotion	face-concerned	fully-qualified
🫪	distorted face	1FAEA	Smileys & Emotion	face-concerned	fully-qualified
🥺	pleading face	1F97A	Smileys & Emotion	face-concerned	fully-qualified
🥹	face holding back tears	1F979	Smileys & Emotion	face-concerned	fully-qualified
😦	frowning face with open mouth	1F626	Smileys & Emotion	face-concerned	fully-qualified
😧	anguished face	1F627	Smileys & Emotion	face-concerned	fully-qualified
😨	fearful face	1F628	Smileys & Emotion	face-concerned	fully-qualified
😰	anxious face with sweat	1F630	Smileys & Emotion	face-concerned	fully-qualified
😥	sad but relieved face	1F625	Smileys & Emotion	face-concerned	fully-qualified
😢	crying face	1F622	Smileys & Emotion	face-concerned	fully-qualified
😭	loudly crying face	1F62D	Smileys & Emotion	face-concerned	fully-qualified
😱	face screaming in fear	1F631	Smileys & Emotion	face-concerned	fully-qualified
😖	confounded face	1F616	Smileys & Emotion	face-concerned	fully-qualified
😣	persevering face	1F623	Smileys & Emotion	face-concerned	fully-qualified
😞	disappointed face	1F61E	Smileys & Emotion	face-concerned	fully-qualified
😓	downcast face with sweat	1F613	Smileys & Emotion	face-concerned	fully-qualified
😩	weary face	1F629	Smileys & Emotion	face-concerned	fully-qualified
😫	tired face	1F62B	Smileys & Emotion	face-concerned	fully-qualified
🥱	yawning face	1F971	Smileys & Emotion	face-concerned	fully-qualified
😤	face with steam from nose	1F624	Smileys & Emotion	face-negative	fully-qualified
😡	enraged face	1F621	Smileys & Emotion	face-negative	fully-qualified
😠	angry face	1F620	Smileys & Emotion	face-negative	fully-qualified
🤬	face with symbols on mouth	1F92C	Smileys & Emotion	face-negative	fully-qualified
😈	smiling face with horns	1F608	Smileys & Emotion	face-negative	fully-qualified
👿	angry face with horns	1F47F	Smileys & Emotion	face-negative	fully-qualified
💀	skull	1F480	Smileys & Emotion	face-negative	fully-qualified
☠️	skull and crossbones	2620 FE0F	Smileys & Emotion	face-negative	fully-qualified
💩	pile of poo	1F4A9	Smileys & Emotion	face-costume	fully-qualified
🤡	clown face	1F921	Smileys & Emotion	face-costume	fully-qualified
👹	ogre	1F479	Smileys & Emotion	face-costume	fully-qualified
👺	goblin	1F47A	Smileys & Emotion	face-costume	fully-qualified
👻	ghost	1F47B	Smileys & Emotion	face-costume	fully-qualified
👽	alien	1F47D	Smileys & Emotion	face-costume	fully-qualified
👾	alien monster	1F47E	Smileys & Emotion	face-costume	fully-qualified
🤖	robot	1F916	Smileys & Emotion	face-costume	fully-qualified
😺	grinning cat	1F63A	Smileys & Emotion	cat-face	fully-qualified
😸	grinning cat with smiling eyes	1F638	Smileys & Emotion	cat-face	fully-qualified
😹	cat with tears of joy	1F639	Smileys & Emotion	cat-face	fully-qualified
😻	smiling cat with heart-eyes	1F63B	Smileys & Emotion	cat-face	fully-qualified
😼	cat with wry smile	1F63C	Smileys & Emotion	cat-face	fully-qualified
😽	kissing cat	1F63D	Smileys & Emotion	cat-face	fully-qualified
🙀	weary cat	1F640	Smileys & Emotion	cat-face	fully-qualified
😿	crying cat	1F63F	Smileys & Emotion	cat-face	fully-qualified
😾	pouting cat	1F63E	Smileys & Emotion	cat-face	fully-qualified
🙈	see-no-evil monkey	1F648	Smileys & Emotion	monkey-face	fully-qualified
🙉	hear-no-evil monkey	1F649	Smileys & Emotion	monkey-face	fully-qualified
🙊	speak-no-evil monkey	1F64A	Smileys & Emotion	monkey-face	fully-qualified
💌	love letter	1F48C	Smileys & Emotion	heart	fully-qualified
💘	heart with arrow	1F498	Smileys & Emotion	heart	fully-qualified
💝	heart with ribbon	1F49D	Smileys & Emotion	heart	fully-qualified
💖	sparkling heart	1F496	Smileys & Emotion	heart	fully-qualified
💗	growing heart	1F497	Smileys & Emotion	heart	fully-qualified
💓	beating heart	1F493	Smileys & Emotion	heart	fully-qualified
💞	revolving hearts	1F49E	Smileys & Emotion	heart	fully-qualified
💕	two hearts	1F495	Smileys & Emotion	heart	fully-qualified
💟	heart decoration	1F49F	Smileys & Emotion	heart	fully-qualified
❣️	heart exclamation	2763 FE0F	Smileys & Emotion	heart	fully-qualified
💔	broken heart	1F494	Smileys & Emotion	heart	fully-qualified
❤️‍🔥	heart on fire	2764 FE0F 200D 1F525	Smileys & Emotion	heart	fully-qualified
❤️‍🩹	mending heart	2764 FE0F 200D 1FA79	Smileys & Emotion	heart	fully-qualified
❤️	red heart	2764 FE0F	Smileys & Emotion	heart	fully-qualified
🩷	pink heart	1FA77	Smileys & Emotion	heart	fully-qualified
🧡	orange heart	1F9E1	Smileys & Emotion	heart	fully-qualified
💛	yellow heart	1F49B	Smileys & Emotion	heart	fully-qualified
💚	green heart	1F49A	Smileys & Emotion	heart	fully-qualified
💙	blue heart	1F499	Smileys & Emotion	heart	fully-qualified
🩵	light blue heart	1FA75	Smileys & Emotion	heart	fully-qualified
💜	purple heart	1F49C	Smileys & Emotion	heart	fully-qualified
🤎	brown heart	1F90E	Smileys & Emotion	heart	fully-qualified
🖤	black heart	1F5A4	Smileys & Emotion	heart	fully-qualified
🩶	grey heart	1FA76	Smileys & Emotion	heart	fully-qualified
🤍	white heart	1F90D	Smileys & Emotion	heart	fully-qualified
💋	kiss mark	1F48B	Smileys & Emotion	emotion	fully-qualified
💯	hundred points	1F4AF	Smileys & Emotion	emotion	fully-qualified
💢	anger symbol	1F4A2	Smileys & Emotion	emotion	fully-qualified
🫯	fight cloud	1FAEF	Smileys & Emotion	emotion	fully-qualified
💥	collision	1F4A5	Smileys & Emotion	emotion	fully-qualified
💫	dizzy	1F4AB	Smileys & Emotion	emotion	fully-qualified
💦	sweat droplets	1F4A6	Smileys & Emotion	emotion	fully-qualified
💨	dashing away	1F4A8	Smileys & Emotion	emotion	fully-qualified
🕳️	hole	1F573 FE0F	Smileys & Emotion	emotion	fully-qualified
💬	speech balloon	1F4AC	Smileys & Emotion	emotion	fully-qualified
👁️‍🗨️	eye in speech bubble	1F441 FE0F 200D 1F5E8 FE0F	Smileys & Emotion	emotion	fully-qualified
🗨️	left speech bubble	1F5E8 FE0F	Smileys & Emotion	emotion	fully-qualified
🗯️	right anger bubble	1F5EF FE0F	Smileys & Emotion	emotion	fully-qualified
💭	thought balloon	1F4AD	Smileys & Emotion	emotion	fully-qualified
💤	ZZZ	1F4A4	Smileys & Emotion	emotion	fully-qualified
👋	waving hand	1F44B	People & Body	hand-fingers-open	fully-qualified
👋🏻	waving hand: light skin tone	1F44B 1F3FB	People & Body	hand-fingers-open	fully-qualified
👋🏼	waving hand: medium-light skin tone	1F44B 1F3FC	People & Body	hand-fingers-open	fully-qualified
👋🏽	waving hand: medium skin tone	1F44B 1F3FD	People & Body	hand-fingers-open	fully-qualified
👋🏾	waving hand: medium-dark skin tone	1F44B 1F3FE	People & Body	hand-fingers-open	fully-qualified
👋🏿	waving hand: dark skin tone	1F44B 1F3FF	People & Body	hand-fingers-open	fully-qualified
🤚	raised back of hand	1F91A	People & Body	hand-fingers-open	fully-qualified
🤚🏻	raised back of hand: light skin tone	1F91A 1F3FB	People & Body	hand-fingers-open	fully-qualified
🤚🏼	raised back of hand: medium-light skin tone	1F91A 1F3FC	People & Body	hand-fingers-open	fully-qualified
🤚🏽	raised back of hand: medium skin tone	1F91A 1F3FD	People & Body	hand-fingers-open	fully-qualified
🤚🏾	raised back of hand: medium-dark skin tone	1F91A 1F3FE	People & Body	hand-fingers-open	fully-qualified
🤚🏿	raised back of hand: dark skin tone	1F91A 1F3FF	People & Body	hand-fingers-open	fully-qualified
🖐️	hand with fingers splayed	1F590 FE0F	People & Body	hand-fingers-open	fully-qualified
🖐🏻	hand with fingers splayed: light skin tone	1F590 1F3FB	People & Body	hand-fingers-open	fully-qualified
🖐🏼	hand with fingers splayed: medium-light skin tone	1F590 1F3FC	People & Body	hand-fingers-open	fully-qualified
🖐🏽	hand with fingers splayed: medium skin tone	1F590 1F3FD	People & Body	hand-fingers-open	fully-qualified
🖐🏾	hand with fingers splayed: medium-dark skin tone	1F590 1F3FE	People & Body	hand-fingers-open	fully-qualified
🖐🏿	hand with fingers splayed: dark skin tone	1F590 1F3FF	People & Body	hand-fingers-open	fully-qualified
✋	raised hand	270B	People & Body	hand-fingers-open	fully-qualified
✋🏻	raised hand: light skin tone	270B 1F3FB	People & Body	hand-fingers-open	fully-qualified
✋🏼	raised hand: medium-light skin tone	270B 1F3FC	People & Body	hand-fingers-open	fully-qualified
✋🏽	raised hand: medium skin tone	270B 1F3FD	People & Body	hand-fingers-open	fully-qualified
✋🏾	raised hand: medium-dark skin tone	270B 1F3FE	People & Body	hand-fingers-open	fully-qualified
✋🏿	raised hand: dark skin tone	270B 1F3FF	People & Body	hand-fingers-open	fully-qualified
🖖	vulcan salute	1F596	People & Body	hand-fingers-open	fully-qualified
🖖🏻	vulcan salute: light skin tone	1F596 1F3FB	People & Body	hand-fingers-open	fully-qualified
🖖🏼	vulcan salute: medium-light skin tone	1F596 1F3FC	People & Body	hand-fingers-open	fully-qualified
🖖🏽	vulcan salute: medium skin tone	1F596 1F3FD	People & Body	hand-fingers-open	fully-qualified
🖖🏾	vulcan salute: medium-dark skin tone	1F596 1F3FE	People & Body	hand-fingers-open	fully-qualified
🖖🏿	vulcan salute: dark skin tone	1F596 1F3FF	People & Body	hand-fingers-open	fully-qualified
🫱	rightwards hand	1FAF1	People & Body	hand-fingers-open	fully-qualified
🫱🏻	rightwards hand: light skin tone	1FAF1 1F3FB	People & Body	hand-fingers-open	fully-qualified
🫱🏼	rightwards hand: medium-light skin tone	1FAF1 1F3FC	People & Body	hand-fingers-open	fully-qualified
🫱🏽	rightwards hand: medium skin tone	1FAF1 1F3FD	People & Body	hand-fingers-open	fully-qualified
🫱🏾	rightwards hand: medium-dark skin tone	1FAF1 1F3FE	People & Body	hand-fingers-open	fully-qualified
🫱🏿	rightwards hand: dark skin tone	1FAF1 1F3FF	People & Body	hand-fingers-open	fully-qualified
🫲	leftwards hand	1FAF2	People & Body	hand-fingers-open	fully-qualified
🫲🏻	leftwards hand: light skin tone	1FAF2 1F3FB	People & Body	hand-fingers-open	fully-qualified
🫲🏼	leftwards hand: medium-light skin tone	1FAF2 1F3FC	People & Body	hand-fingers-open	fully-qualified
🫲🏽	leftwards hand: medium skin tone	1FAF2 1F3FD	People & Body	hand-fingers-open	fully-qualified
🫲🏾	leftwards hand: medium-dark skin tone	1FAF2 1F3FE	People & Body	hand-fingers-open	fully-qualified
🫲🏿	leftwards hand: dark skin tone	1FAF2 1F3FF	People & Body	hand-fingers-open	fully-qualified
🫳	palm down hand	1FAF3	People & Body	hand-fingers-open	fully-qualified
🫳🏻	palm down hand: light skin tone	1FAF3 1F3FB	People & Body	hand-fingers-open	fully-qualified
🫳🏼	palm down hand: medium-light skin tone	1FAF3 1F3FC	People & Body	hand-fingers-open	fully-qualified
🫳🏽	palm down hand: medium skin tone	1FAF3 1F3FD	People & Body	hand-fingers-open	fully-qualified
🫳🏾	palm down hand: medium-dark skin tone	1FAF3 1F3FE	People & Body	hand-fingers-open	fully-qualified
🫳🏿	palm down hand: dark skin tone	1FAF3 1F3FF	People & Body	hand-fingers-open	fully-qualified
🫴	palm up hand	1FAF4	People & Body	hand-fingers-open	fully-qualified
🫴🏻	palm up hand: light skin tone	1FAF4 1F3FB	People & Body	hand-fingers-open	fully-qualified
🫴🏼	palm up hand: medium-light skin tone	1FAF4 1F3FC	People & Body	hand-fingers-open	fully-qualified
🫴🏽	palm up hand: medium skin tone	1FAF4 1F3FD	People & Body	hand-fingers-open	fully-qualified
🫴🏾	palm up hand: medium-dark skin tone	1FAF4 1F3FE	People & Body	hand-fingers-open	fully-qualified
🫴🏿	palm up hand: dark skin tone	1FAF4 1F3FF	People & Body	hand-fingers-open	fully-qualified
🫷	leftwards pushing hand	1FAF7	People & Body	hand-fingers-open	fully-qualified
🫷🏻	leftwards pushing hand: light skin tone	1FAF7 1F3FB	People & Body	hand-fingers-open	fully-qualified
🫷🏼	leftwards pushing hand: medium-light skin tone	1FAF7 1F3FC	People & Body	hand-fingers-open	fully-qualified
🫷🏽	leftwards pushing hand: medium skin tone	1FAF7 1F3FD	People & Body	hand-fingers-open	fully-qualified
🫷🏾	leftwards pushing hand: medium-dark skin tone	1FAF7 1F3FE	People & Body	hand-fingers-open	fully-qualified
🫷🏿	leftwards pushing hand: dark skin tone	1FAF7 1F3FF	People & Body	hand-fingers-open	fully-qualified
🫸	rightwards pushing hand	1FAF8	People & Body	hand-fingers-open	fully-qualified
🫸🏻	rightwards pushing hand: light skin tone	1FAF8 1F3FB	People & Body	hand-fingers-open	fully-qualified
🫸🏼	rightwards pushing hand: medium-light skin tone	1FAF8 1F3FC	People & Body	hand-fingers-open	fully-qualified
🫸🏽	rightwards pushing hand: medium skin tone	1FAF8 1F3FD	People & Body	hand-fingers-open	fully-qualified
🫸🏾	rightwards pushing hand: medium-dark skin tone	1FAF8 1F3FE	People & Body	hand-fingers-open	fully-qualified
🫸🏿	rightwards pushing hand: dark skin tone	1FAF8 1F3FF	People & Body	hand-fingers-open	fully-qualified
👌	OK hand	1F44C	People & Body	hand-fingers-partial	fully-qualified
👌🏻	OK hand: light skin tone	1F44C 1F3FB	People & Body	hand-fingers-partial	fully-qualified
👌🏼	OK hand: medium-light skin tone	1F44C 1F3FC	People & Body	hand-fingers-partial	fully-qualified
👌🏽	OK hand: medium skin tone	1F44C 1F3FD	People & Body	hand-fingers-partial	fully-qualified
👌🏾	OK hand: medium-dark skin tone	1F44C 1F3FE	People & Body	hand-fingers-partial	fully-qualified
👌🏿	OK hand: dark skin tone	1F44C 1F3FF	People & Body	hand-fingers-partial	fully-qualified
🤌	pinched fingers	1F90C	People & Body	hand-fingers-partial	fully-qualified
🤌🏻	pinched fingers: light skin tone	1F90C 1F3FB	People & Body	hand-fingers-partial	fully-qualified
🤌🏼	pinched fingers: medium-light skin tone	1F90C 1F3FC	People & Body	hand-fingers-partial	fully-qualified
🤌🏽	pinched fingers: medium skin tone	1F90C 1F3FD	People & Body	hand-fingers-partial	fully-qualified
🤌🏾	pinched fingers: medium-dark skin tone	1F90C 1F3FE	People & Body	hand-fingers-partial	fully-qualified
🤌🏿	pinched fingers: dark skin tone	1F90C 1F3FF	People & Body	hand-fingers-partial	fully-qualified
🤏	pinching hand	1F90F	People & Body	hand-fingers-partial	fully-qualified
🤏🏻	pinching hand: light skin tone	1F90F 1F3FB	People & Body	hand-fingers-partial	fully-qualified
🤏🏼	pinching hand: medium-light skin tone	1F90F 1F3FC	People & Body	hand-fingers-partial	fully-qualified
🤏🏽	pinching hand: medium skin tone	1F90F 1F3FD	People & Body	hand-fingers-partial	fully-qualified
🤏🏾	pinching hand: medium-dark skin tone	1F90F 1F3FE	People & Body	hand-fingers-partial	fully-qualified
🤏🏿	pinching hand: dark skin tone	1F90F 1F3FF	People & Body	hand-fingers-partial	fully-qualified
✌️	victory hand	270C FE0F	People & Body	hand-fingers-partial	fully-qualified
✌🏻	victory hand: light skin tone	270C 1F3FB	People & Body	hand-fingers-partial	fully-qualified
✌🏼	victory hand: medium-light skin tone	270C 1F3FC	People & Body	hand-fingers-partial	fully-qualified
✌🏽	victory hand: medium skin tone	270C 1F3FD	People & Body	hand-fingers-partial	fully-qualified
✌🏾	victory hand: medium-dark skin tone	270C 1F3FE	People & Body	hand-fingers-partial	fully-qualified
✌🏿	victory hand: dark skin tone	270C 1F3FF	People & Body	hand-fingers-partial	fully-qualified
🤞	crossed fingers	1F91E	People & Body	hand-fingers-partial	fully-qualified
🤞🏻	crossed fingers: light skin tone	1F91E 1F3FB	People & Body	hand-fingers-partial	fully-qualified
🤞🏼	crossed fingers: medium-light skin tone	1F91E 1F3FC	People & Body	hand-fingers-partial	fully-qualified
🤞🏽	crossed fingers: medium skin tone	1F91E 1F3FD	People & Body	hand-fingers-partial	fully-qualified
🤞🏾	crossed fingers: medium-dark skin tone	1F91E 1F3FE	People & Body	hand-fingers-partial	fully-qualified
🤞🏿	crossed fingers: dark skin tone	1F91E 1F3FF	People & Body	hand-fingers-partial	fully-qualified
🫰	hand with index finger and thumb crossed	1FAF0	People & Body	hand-fingers-partial	fully-qualified
🫰🏻	hand with index finger and thumb crossed: light skin tone	1FAF0 1F3FB	People & Body	hand-fingers-partial	fully-qualified
🫰🏼	hand with index finger and thumb crossed: medium-light skin tone	1FAF0 1F3FC	People & Body	hand-fingers-partial	fully-qualified
🫰🏽	hand with index finger and thumb crossed: medium skin tone	1FAF0 1F3FD	People & Body	hand-fingers-partial	fully-qualified
🫰🏾	hand with index finger and thumb crossed: medium-dark skin tone	1FAF0 1F3FE	People & Body	hand-fingers-partial	fully-qualified
🫰🏿	hand with index finger and thumb crossed: dark skin tone	1FAF0 1F3FF	People & Body	hand-fingers-partial	fully-qualified
🤟	love-you gesture	1F91F	People & Body	hand-fingers-partial	fully-qualified
🤟🏻	love-you gesture: light skin tone	1F91F 1F3FB	People & Body	hand-fingers-partial	fully-qualified
🤟🏼	love-you gesture: medium-light skin tone	1F91F 1F3FC	People & Body	hand-fingers-partial	fully-qualified
🤟🏽	love-you gesture: medium skin tone	1F91F 1F3FD	People & Body	hand-fingers-partial	fully-qualified
🤟🏾	love-you gesture: medium-dark skin tone	1F91F 1F3FE	People & Body	hand-fingers-partial	fully-qualified
🤟🏿	love-you gesture: dark skin tone	1F91F 1F3FF	People & Body	hand-fingers-partial	fully-qualified
🤘	sign of the horns	1F918	People & Body	hand-fingers-partial	fully-qualified
🤘🏻	sign of the horns: light skin tone	1F918 1F3FB	People & Body	hand-fingers-partial	fully-qualified
🤘🏼	sign of the horns: medium-light skin tone	1F918 1F3FC	People & Body	hand-fingers-partial	fully-qualified
🤘🏽	sign of the horns: medium skin tone	1F918 1F3FD	People & Body	hand-fingers-partial	fully-qualified
🤘🏾	sign of the horns: medium-dark skin tone	1F918 1F3FE	People & Body	hand-fingers-partial	fully-qualified
🤘🏿	sign of the horns: dark skin tone	1F918 1F3FF	People & Body	hand-fingers-partial	fully-qualified
🤙	call me hand	1F919	People & Body	hand-fingers-partial	fully-qualified
🤙🏻	call me hand: light skin tone	1F919 1F3FB	People & Body	hand-fingers-partial	fully-qualified
🤙🏼	call me hand: medium-light skin tone	1F919 1F3FC	People & Body	hand-fingers-partial	fully-qualified
🤙🏽	call me hand: medium skin tone	1F919 1F3FD	People & Body	hand-fingers-partial	fully-qualified
🤙🏾	call me hand: medium-dark skin tone	1F919 1F3FE	People & Body	hand-fingers-partial	fully-qualified
🤙🏿	call me hand: dark skin tone	1F919 1F3FF	People & Body	hand-fingers-partial	fully-qualified
👈	backhand index pointing left	1F448	People & Body	hand-single-finger	fully-qualified
👈🏻	backhand index pointing left: light skin tone	1F448 1F3FB	People & Body	hand-single-finger	fully-qualified
👈🏼	backhand index pointing left: medium-light skin tone	1F448 1F3FC	People & Body	hand-single-finger	fully-qualified
👈🏽	backhand index pointing left: medium skin tone	1F448 1F3FD	People & Body	hand-single-finger	fully-qualified
👈🏾	backhand index pointing left: medium-dark skin tone	1F448 1F3FE	People & Body	hand-single-finger	fully-qualified
👈🏿	backhand index pointing left: dark skin tone	1F448 1F3FF	People & Body	hand-single-finger	fully-qualified
👉	backhand index pointing right	1F449	People & Body	hand-single-finger	fully-qualified
👉🏻	backhand index pointing right: light skin tone	1F449 1F3FB	People & Body	hand-single-finger	fully-qualified
👉🏼	backhand index pointing right: medium-light skin tone	1F449 1F3FC	People & Body	hand-single-finger	fully-qualified
👉🏽	backhand index pointing right: medium skin tone	1F449 1F3FD	People & Body	hand-single-finger	fully-qualified
👉🏾	backhand index pointing right: medium-dark skin tone	1F449 1F3FE	People & Body	hand-single-finger	fully-qualified
👉🏿	backhand index pointing right: dark skin tone	1F449 1F3FF	People & Body	hand-single-finger	fully-qualified
👆	backhand index pointing up	1F446	People & Body	hand-single-finger	fully-qualified
👆🏻	backhand index pointing up: light skin tone	1F446 1F3FB	People & Body	hand-single-finger	fully-qualified
👆🏼	backhand index pointing up: medium-light skin tone	1F446 1F3FC	People & Body	hand-single-finger	fully-qualified
👆🏽	backhand index pointing up: medium skin tone	1F446 1F3FD	People & Body	hand-single-finger	fully-qualified
👆🏾	backhand index pointing up: medium-dark skin tone	1F446 1F3FE	People & Body	hand-single-finger	fully-qualified
👆🏿	backhand index pointing up: dark skin tone	1F446 1F3FF	People & Body	hand-single-finger	fully-qualified
🖕	middle finger	1F595	People & Body	hand-single-finger	fully-qualified
🖕🏻	middle finger: light skin tone	1F595 1F3FB	People & Body	hand-single-finger	fully-qualified
🖕🏼	middle finger: medium-light skin tone	1F595 1F3FC	People & Body	hand-single-finger	fully-qualified
🖕🏽	middle finger: medium skin tone	1F595 1F3FD	People & Body	hand-single-finger	fully-qualified
🖕🏾	middle finger: medium-dark skin tone	1F595 1F3FE	People & Body	hand-single-finger	fully-qualified
🖕🏿	middle finger: dark skin tone	1F595 1F3FF	People & Body	hand-single-finger	fully-qualified
👇	backhand index pointing down	1F447	People & Body	hand-single-finger	fully-qualified
👇🏻	backhand index pointing down: light skin tone	1F447 1F3FB	People & Body	hand-single-finger	fully-qualified
👇🏼	backhand index pointing down: medium-light skin tone	1F447 1F3FC	People & Body	hand-single-finger	fully-qualified
👇🏽	backhand index pointing down: medium skin tone	1F447 1F3FD	People & Body	hand-single-finger	fully-qualified
👇🏾	backhand index pointing down: medium-dark skin tone	1F447 1F3FE	People & Body	hand-single-finger	fully-qualified
👇🏿	backhand index pointing down: dark skin tone	1F447 1F3FF	People & Body	hand-single-finger	fully-qualified
☝️	index pointing up	261D FE0F	People & Body	hand-single-finger	fully-qualified
☝🏻	index pointing up: light skin tone	261D 1F3FB	People & Body	hand-single-finger	fully-qualified
☝🏼	index pointing up: medium-light skin tone	261D 1F3FC	People & Body	hand-single-finger	fully-qualified
☝🏽	index pointing up: medium skin tone	261D 1F3FD	People & Body	hand-single-finger	fully-qualified
☝🏾	index pointing up: medium-dark skin tone	261D 1F3FE	People & Body	hand-single-finger	fully-qualified
☝🏿	index pointing up: dark skin tone	261D 1F3FF	People & Body	hand-single-finger	fully-qualified
🫵	index pointing at the viewer	1FAF5	People & Body	hand-single-finger	fully-qualified
🫵🏻	index pointing at the viewer: light skin tone	1FAF5 1F3FB	People & Body	hand-single-finger	fully-qualified
🫵🏼	index pointing at the viewer: medium-light skin tone	1FAF5 1F3FC	People & Body	hand-single-finger	fully-qualified
🫵🏽	index pointing at the viewer: medium skin tone	1FAF5 1F3FD	People & Body	hand-single-finger	fully-qualified
🫵🏾	index pointing at the viewer: medium-dark skin tone	1FAF5 1F3FE	People & Body	hand-single-finger	fully-qualified
🫵🏿	index pointing at the viewer: dark skin tone	1FAF5 1F3FF	People & Body	hand-single-finger	fully-qualified
👍	thumbs up	1F44D	People & Body	hand-fingers-closed	fully-qualified
👍🏻	thumbs up: light skin tone	1F44D 1F3FB	People & Body	hand-fingers-closed	fully-qualified
👍🏼	thumbs up: medium-light skin tone	1F44D 1F3FC	People & Body	hand-fingers-closed	fully-qualified
👍🏽	thumbs up: medium skin tone	1F44D 1F3FD	People & Body	hand-fingers-closed	fully-qualified
👍🏾	thumbs up: medium-dark skin tone	1F44D 1F3FE	People & Body	hand-fingers-closed	fully-qualified
👍🏿	thumbs up: dark skin tone	1F44D 1F3FF	People & Body	hand-fingers-closed	fully-qualified
👎	thumbs down	1F44E	People & Body	hand-fingers-closed	fully-qualified
👎🏻	thumbs down: light skin tone	1F44E 1F3FB	People & Body	hand-fingers-closed	fully-qualified
👎🏼	thumbs down: medium-light skin tone	1F44E 1F3FC	People & Body	hand-fingers-closed	fully-qualified
👎🏽	thumbs down: medium skin tone	1F44E 1F3FD	People & Body	hand-fingers-closed	fully-qualified
👎🏾	thumbs down: medium-dark skin tone	1F44E 1F3FE	People & Body	hand-fingers-closed	fully-qualified
👎🏿	thumbs down: dark skin tone	1F44E 1F3FF	People & Body	hand-fingers-closed	fully-qualified
✊	raised fist	270A	People & Body	hand-fingers-closed	fully-qualified
✊🏻	raised fist: light skin tone	270A 1F3FB	People & Body	hand-fingers-closed	fully-qualified
✊🏼	raised fist: medium-light skin tone	270A 1F3FC	People & Body	hand-fingers-closed	fully-qualified
✊🏽	raised fist: medium skin tone	270A 1F3FD	People & Body	hand-fingers-closed	fully-qualified
✊🏾	raised fist: medium-dark skin tone	270A 1F3FE	People & Body	hand-fingers-closed	fully-qualified
✊🏿	raised fist: dark skin tone	270A 1F3FF	People & Body	hand-fingers-closed	fully-qualified
👊	oncoming fist	1F44A	People & Body	hand-fingers-closed	fully-qualified
👊🏻	oncoming fist: light skin tone	1F44A 1F3FB	People & Body	hand-fingers-closed	fully-qualified
👊🏼	oncoming fist: medium-light skin tone	1F44A 1F3FC	People & Body	hand-fingers-closed	fully-qualified
👊🏽	oncoming fist: medium skin tone	1F44A 1F3FD	People & Body	hand-fingers-closed	fully-qualified
👊🏾	oncoming fist: medium-dark skin tone	1F44A 1F3FE	People & Body	hand-fingers-closed	fully-qualified
👊🏿	oncoming fist: dark skin tone	1F44A 1F3FF	People & Body	hand-fingers-closed	fully-qualified
🤛	left-facing fist	1F91B	People & Body	hand-fingers-closed	fully-qualified
🤛🏻	left-facing fist: light skin tone	1F91B 1F3FB	People & Body	hand-fingers-closed	fully-qualified
🤛🏼	left-facing fist: medium-light skin tone	1F91B 1F3FC	People & Body	hand-fingers-closed	fully-qualified
🤛🏽	left-facing fist: medium skin tone	1F91B 1F3FD	People & Body	hand-fingers-closed	fully-qualified
🤛🏾	left-facing fist: medium-dark skin tone	1F91B 1F3FE	People & Body	hand-fingers-closed	fully-qualified
🤛🏿	left-facing fist: dark skin tone	1F91B 1F3FF	People & Body	hand-fingers-closed	fully-qualified
🤜	right-facing fist	1F91C	People & Body	hand-fingers-closed	fully-qualified
🤜🏻	right-facing fist: light skin tone	1F91C 1F3FB	People & Body	hand-fingers-closed	fully-qualified
🤜🏼	right-facing fist: medium-light skin tone	1F91C 1F3FC	People & Body	hand-fingers-closed	fully-qualified
🤜🏽	right-facing fist: medium skin tone	1F91C 1F3FD	People & Body	hand-fingers-closed	fully-qualified
🤜🏾	right-facing fist: medium-dark skin tone	1F91C 1F3FE	People & Body	hand-fingers-closed	fully-qualified
🤜🏿	right-facing fist: dark skin tone	1F91C 1F3FF	People & Body	hand-fingers-closed	fully-qualified
👏	clapping hands	1F44F	People & Body	hands	fully-qualified
👏🏻	clapping hands: light skin tone	1F44F 1F3FB	People & Body	hands	fully-qualified
👏🏼	clapping hands: medium-light skin tone	1F44F 1F3FC	People & Body	hands	fully-qualified
👏🏽	clapping hands: medium skin tone	1F44F 1F3FD	People & Body	hands	fully-qualified
👏🏾	clapping hands: medium-dark skin tone	1F44F 1F3FE	People & Body	hands	fully-qualified
👏🏿	clapping hands: dark skin tone	1F44F 1F3FF	People & Body	hands	fully-qualified
🙌	raising hands	1F64C	People & Body	hands	fully-qualified
🙌🏻	raising hands: light skin tone	1F64C 1F3FB	People & Body	hands	fully-qualified
🙌🏼	raising hands: medium-light skin tone	1F64C 1F3FC	People & Body	hands	fully-qualified
🙌🏽	raising hands: medium skin tone	1F64C 1F3FD	People & Body	hands	fully-qualified
🙌🏾	raising hands: medium-dark skin tone	1F64C 1F3FE	People & Body	hands	fully-qualified
🙌🏿	raising hands: dark skin tone	1F64C 1F3FF	People & Body	hands	fully-qualified
🫶	heart hands	1FAF6	People & Body	hands	fully-qualified
🫶🏻	heart hands: light skin tone	1FAF6 1F3FB	People & Body	hands	fully-qualified
🫶🏼	heart hands: medium-light skin tone	1FAF6 1F3FC	People & Body	hands	fully-qualified
🫶🏽	heart hands: medium skin tone	1FAF6 1F3FD	People & Body	hands	fully-qualified
🫶🏾	heart hands: medium-dark skin tone	1FAF6 1F3FE	People & Body	hands	fully-qualified
🫶🏿	heart hands: dark skin tone	1FAF6 1F3FF	People & Body	hands	fully-qualified
👐	open hands	1F450	People & Body	hands	fully-qualified
👐🏻	open hands: light skin tone	1F450 1F3FB	People & Body	hands	fully-qualified
👐🏼	open hands: medium-light skin tone	1F450 1F3FC	People & Body	hands	fully-qualified
👐🏽	open hands: medium skin tone	1F450 1F3FD	People & Body	hands	fully-qualified
👐🏾	open hands: medium-dark skin tone	1F450 1F3FE	People & Body	hands	fully-qualified
👐🏿	open hands: dark skin tone	1F450 1F3FF	People & Body	hands	fully-qualified
🤲	palms up together	1F932	People & Body	hands	fully-qualified
🤲🏻	palms up together: light skin tone	1F932 1F3FB	People & Body	hands	fully-qualified
🤲🏼	palms up together: medium-light skin tone	1F932 1F3FC	People & Body	hands	fully-qualified
🤲🏽	palms up together: medium skin tone	1F932 1F3FD	People & Body	hands	fully-qualified
🤲🏾	palms up together: medium-dark skin tone	1F932 1F3FE	People & Body	hands	fully-qualified
🤲🏿	palms up together: dark skin tone	1F932 1F3FF	People & Body	hands	fully-qualified
🤝	handshake	1F91D	People & Body	hands	fully-qualified
🤝🏻	handshake: light skin tone	1F91D 1F3FB	People & Body	hands	fully-qualified
🤝🏼	handshake: medium-light skin tone	1F91D 1F3FC	People & Body	hands	fully-qualified
🤝🏽	handshake: medium skin tone	1F91D 1F3FD	People & Body	hands	fully-qualified
🤝🏾	handshake: medium-dark skin tone	1F91D 1F3FE	People & Body	hands	fully-qualified
🤝🏿	handshake: dark skin tone	1F91D 1F3FF	People & Body	hands	fully-qualified
🫱🏻‍🫲🏼	handshake: light skin tone, medium-light skin tone	1FAF1 1F3FB 200D 1FAF2 1F3FC	People & Body	hands	fully-qualified
🫱🏻‍🫲🏽	handshake: light skin tone, medium skin tone	1FAF1 1F3FB 200D 1FAF2 1F3FD	People & Body	hands	fully-qualified
🫱🏻‍🫲🏾	handshake: light skin tone, medium-dark skin tone	1FAF1 1F3FB 200D 1FAF2 1F3FE	People & Body	hands	fully-qualified
🫱🏻‍🫲🏿	handshake: light skin tone, dark skin tone	1FAF1 1F3FB 200D 1FAF2 1F3FF	People & Body	hands	fully-qualified
🫱🏼‍🫲🏻	handshake: medium-light skin tone, light skin tone	1FAF1 1F3FC 200D 1FAF2 1F3FB	People & Body	hands	fully-qualified
🫱🏼‍🫲🏽	handshake: medium-light skin tone, medium skin tone	1FAF1 1F3FC 200D 1FAF2 1F3FD	People & Body	hands	fully-qualified
🫱🏼‍🫲🏾	handshake: medium-light skin tone, medium-dark skin tone	1FAF1 1F3FC 200D 1FAF2 1F3FE	People & Body	hands	fully-qualified
🫱🏼‍🫲🏿	handshake: medium-light skin tone, dark skin tone	1FAF1 1F3FC 200D 1FAF2 1F3FF	People & Body	hands	fully-qualified
🫱🏽‍🫲🏻	handshake: medium skin tone, light skin tone	1FAF1 1F3FD 200D 1FAF2 1F3FB	People & Body	hands	fully-qualified
🫱🏽‍🫲🏼	handshake: medium skin tone, medium-light skin tone	1FAF1 1F3FD 200D 1FAF2 1F3FC	People & Body	hands	fully-qualified
🫱🏽‍🫲🏾	handshake: medium skin tone, medium-dark skin tone	1FAF1 1F3FD 200D 1FAF2 1F3FE	People & Body	hands	fully-qualified
🫱🏽‍🫲🏿	handshake: medium skin tone, dark skin tone	1FAF1 1F3FD 200D 1FAF2 1F3FF	People & Body	hands	fully-qualified
🫱🏾‍🫲🏻	handshake: medium-dark skin tone, light skin tone	1FAF1 1F3FE 200D 1FAF2 1F3FB	People & Body	hands	fully-qualified
🫱🏾‍🫲🏼	handshake: medium-dark skin tone, medium-light skin tone	1FAF1 1F3FE 200D 1FAF2 1F3FC	People & Body	hands	fully-qualified
🫱🏾‍🫲🏽	handshake: medium-dark skin tone, medium skin tone	1FAF1 1F3FE 200D 1FAF2 1F3FD	People & Body	hands	fully-qualified
🫱🏾‍🫲🏿	handshake: medium-dark skin tone, dark skin tone	1FAF1 1F3FE 200D 1FAF2 1F3FF	People & Body	hands	fully-qualified
🫱🏿‍🫲🏻	handshake: dark skin tone, light skin tone	1FAF1 1F3FF 200D 1FAF2 1F3FB	People & Body	hands	fully-qualified
🫱🏿‍🫲🏼	handshake: dark skin tone, medium-light skin tone	1FAF1 1F3FF 200D 1FAF2 1F3FC	People & Body	hands	fully-qualified
🫱🏿‍🫲🏽	handshake: dark skin tone, medium skin tone	1FAF1 1F3FF 200D 1FAF2 1F3FD	People & Body	hands	fully-qualified
🫱🏿‍🫲🏾	handshake: dark skin tone, medium-dark skin tone	1FAF1 1F3FF 200D 1FAF2 1F3FE	People & Body	hands	fully-qualified
🙏	folded hands	1F64F	People & Body	hands	fully-qualified
🙏🏻	folded hands: light skin tone	1F64F 1F3FB	People & Body	hands	fully-qualified
🙏🏼	folded hands: medium-light skin tone	1F64F 1F3FC	People & Body	hands	fully-qualified
🙏🏽	folded hands: medium skin tone	1F64F 1F3FD	People & Body	hands	fully-qualified
🙏🏾	folded hands: medium-dark skin tone	1F64F 1F3FE	People & Body	hands	fully-qualified
🙏🏿	folded hands: dark skin tone	1F64F 1F3FF	People & Body	hands	fully-qualified
✍️	writing hand	270D FE0F	People & Body	hand-prop	fully-qualified
✍🏻	writing hand: light skin tone	270D 1F3FB	People & Body	hand-prop	fully-qualified
✍🏼	writing hand: medium-light skin tone	270D 1F3FC	People & Body	hand-prop	fully-qualified
✍🏽	writing hand: medium skin tone	270D 1F3FD	People & Body	hand-prop	fully-qualified
✍🏾	writing hand: medium-dark skin tone	270D 1F3FE	People & Body	hand-prop	fully-qualified
✍🏿	writing hand: dark skin tone	270D 1F3FF	People & Body	hand-prop	fully-qualified
💅	nail polish	1F485	People & Body	hand-prop	fully-qualified
💅🏻	nail polish: light skin tone	1F485 1F3FB	People & Body	hand-prop	fully-qualified
💅🏼	nail polish: medium-light skin tone	1F485 1F3FC	People & Body	hand-prop	fully-qualified
💅🏽	nail polish: medium skin tone	1F485 1F3FD	People & Body	hand-prop	fully-qualified
💅🏾	nail polish: medium-dark skin tone	1F485 1F3FE	People & Body	hand-prop	fully-qualified
💅🏿	nail polish: dark skin tone	1F485 1F3FF	People & Body	hand-prop	fully-qualified
🤳	selfie	1F933	People & Body	hand-prop	fully-qualified
🤳🏻	selfie: light skin tone	1F933 1F3FB	People & Body	hand-prop	fully-qualified
🤳🏼	selfie: medium-light skin tone	1F933 1F3FC	People & Body	hand-prop	fully-qualified
🤳🏽	selfie: medium skin tone	1F933 1F3FD	People & Body	hand-prop	fully-qualified
🤳🏾	selfie: medium-dark skin tone	1F933 1F3FE	People & Body	hand-prop	fully-qualified
🤳🏿	selfie: dark skin tone	1F933 1F3FF	People & Body	hand-prop	fully-qualified
💪	flexed biceps	1F4AA	People & Body	body-parts	fully-qualified
💪🏻	flexed biceps: light skin tone	1F4AA 1F3FB	People & Body	body-parts	fully-qualified
💪🏼	flexed biceps: medium-light skin tone	1F4AA 1F3FC	People & Body	body-parts	fully-qualified
💪🏽	flexed biceps: medium skin tone	1F4AA 1F3FD	People & Body	body-parts	fully-qualified
💪🏾	flexed biceps: medium-dark skin tone	1F4AA 1F3FE	People & Body	body-parts	fully-qualified
💪🏿	flexed biceps: dark skin tone	1F4AA 1F3FF	People & Body	body-parts	fully-qualified
🦾	mechanical arm	1F9BE	People & Body	body-parts	fully-qualified
🦿	mechanical leg	1F9BF	People & Body	body-parts	fully-qualified
🦵	leg	1F9B5	People & Body	body-parts	fully-qualified
🦵🏻	leg: light skin tone	1F9B5 1F3FB	People & Body	body-parts	fully-qualified
🦵🏼	leg: medium-light skin tone	1F9B5 1F3FC	People & Body	body-parts	fully-qualified
🦵🏽	leg: medium skin tone	1F9B5 1F3FD	People & Body	body-parts	fully-qualified
🦵🏾	leg: medium-dark skin tone	1F9B5 1F3FE	People & Body	body-parts	fully-qualified
🦵🏿	leg: dark skin tone	1F9B5 1F3FF	People & Body	body-parts	fully-qualified
🦶	foot	1F9B6	People & Body	body-parts	fully-qualified
🦶🏻	foot: light skin tone	1F9B6 1F3FB	People & Body	body-parts	fully-qualified
🦶🏼	foot: medium-light skin tone	1F9B6 1F3FC	People & Body	body-parts	fully-qualified
🦶🏽	foot: medium skin tone	1F9B6 1F3FD	People & Body	body-parts	fully-qualified
🦶🏾	foot: medium-dark skin tone	1F9B6 1F3FE	People & Body	body-parts	fully-qualified
🦶🏿	foot: dark skin tone	1F9B6 1F3FF	People & Body	body-parts	fully-qualified
👂	ear	1F442	People & Body	body-parts	fully-qualified
👂🏻	ear: light skin tone	1F442 1F3FB	People & Body	body-parts	fully-qualified
👂🏼	ear: medium-light skin tone	1F442 1F3FC	People & Body	body-parts	fully-qualified
👂🏽	ear: medium skin tone	1F442 1F3FD	People & Body	body-parts	fully-qualified
👂🏾	ear: medium-dark skin tone	1F442 1F3FE	People & Body	body-parts	fully-qualified
👂🏿	ear: dark skin tone	1F442 1F3FF	People & Body	body-parts	fully-qualified
🦻	ear with hearing aid	1F9BB	People & Body	body-parts	fully-qualified
🦻🏻	ear with hearing aid: light skin tone	1F9BB 1F3FB	People & Body	body-parts	fully-qualified
🦻🏼	ear with hearing aid: medium-light skin tone	1F9BB 1F3FC	People & Body	body-parts	fully-qualified
🦻🏽	ear with hearing aid: medium skin tone	1F9BB 1F3FD	People & Body	body-parts	fully-qualified
🦻🏾	ear with hearing aid: medium-dark skin tone	1F9BB 1F3FE	People & Body	body-parts	fully-qualified
🦻🏿	ear with hearing aid: dark skin tone	1F9BB 1F3FF	People & Body	body-parts	fully-qualified
👃	nose	1F443	People & Body	body-parts	fully-qualified
👃🏻	nose: light skin tone	1F443 1F3FB	People & Body	body-parts	fully-qualified
👃🏼	nose: medium-light skin tone	1F443 1F3FC	People & Body	body-parts	fully-qualified
👃🏽	nose: medium skin tone	1F443 1F3FD	People & Body	body-parts	fully-qualified
👃🏾	nose: medium-dark skin tone	1F443 1F3FE	People & Body	body-parts	fully-qualified
👃🏿	nose: dark skin tone	1F443 1F3FF	People & Body	body-parts	fully-qualified
🧠	brain	1F9E0	People & Body	body-parts	fully-qualified
🫀	anatomical heart	1FAC0	People & Body	body-parts	fully-qualified
🫁	lungs	1FAC1	People & Body	body-parts	fully-qualified
🦷	tooth	1F9B7	People & Body	body-parts	fully-qualified
🦴	bone	1F9B4	People & Body	body-parts	fully-qualified
👀	eyes	1F440	People & Body	body-parts	fully-qualified
👁️	eye	1F441 FE0F	People & Body	body-parts	fully-qualified
👅	tongue	1F445	People & Body	body-parts	fully-qualified
👄	mouth	1F444	People & Body	body-parts	fully-qualified
🫦	biting lip	1FAE6	People & Body	body-parts	fully-qualified
👶	baby	1F476	People & Body	person	fully-qualified
👶🏻	baby: light skin tone	1F476 1F3FB	People & Body	person	fully-qualified
👶🏼	baby: medium-light skin tone	1F476 1F3FC	People & Body	person	fully-qualified
👶🏽	baby: medium skin tone	1F476 1F3FD	People & Body	person	fully-qualified
👶🏾	baby: medium-dark skin tone	1F476 1F3FE	People & Body	person	fully-qualified
👶🏿	baby: dark skin tone	1F476 1F3FF	People & Body	person	fully-qualified
🧒	child	1F9D2	People & Body	person	fully-qualified
🧒🏻	child: light skin tone	1F9D2 1F3FB	People & Body	person	fully-qualified
🧒🏼	child: medium-light skin tone	1F9D2 1F3FC	People & Body	person	fully-qualified
🧒🏽	child: medium skin tone	1F9D2 1F3FD	People & Body	person	fully-qualified
🧒🏾	child: medium-dark skin tone	1F9D2 1F3FE	People & Body	person	fully-qualified
🧒🏿	child: dark skin tone	1F9D2 1F3FF	People & Body	person	fully-qualified
👦	boy	1F466	People & Body	person	fully-qualified
👦🏻	boy: light skin tone	1F466 1F3FB	People & Body	person	fully-qualified
👦🏼	boy: medium-light skin tone	1F466 1F3FC	People & Body	person	fully-qualified
👦🏽	boy: medium skin tone	1F466 1F3FD	People & Body	person	fully-qualified
👦🏾	boy: medium-dark skin tone	1F466 1F3FE	People & Body	person	fully-qualified
👦🏿	boy: dark skin tone	1F466 1F3FF	People & Body	person	fully-qualified
👧	girl	1F467	People & Body	person	fully-qualified
👧🏻	girl: light skin tone	1F467 1F3FB	People & Body	person	fully-qualified
👧🏼	girl: medium-light skin tone	1F467 1F3FC	People & Body	person	fully-qualified
👧🏽	girl: medium skin tone	1F467 1F3FD	People & Body	person	fully-qualified
👧🏾	girl: medium-dark skin tone	1F467 1F3FE	People & Body	person	fully-qualified
👧🏿	girl: dark skin tone	1F467 1F3FF	People & Body	person	fully-qualified
🧑	person	1F9D1	People & Body	person	fully-qualified
🧑🏻	person: light skin tone	1F9D1 1F3FB	People & Body	person	fully-qualified
🧑🏼	person: medium-light skin tone	1F9D1 1F3FC	People & Body	person	fully-qualified
🧑🏽	person: medium skin tone	1F9D1 1F3FD	People & Body	person	fully-qualified
🧑🏾	person: medium-dark skin tone	1F9D1 1F3FE	People & Body	person	fully-qualified
🧑🏿	person: dark skin tone	1F9D1 1F3FF	People & Body	person	fully-qualified
👱	person: blond hair	1F471	People & Body	person	fully-qualified
👱🏻	person: light skin tone, blond hair	1F471 1F3FB	People & Body	person	fully-qualified
👱🏼	person: medium-light skin tone, blond hair	1F471 1F3FC	People & Body	person	fully-qualified
👱🏽	person: medium skin tone, blond hair	1F471 1F3FD	People & Body	person	fully-qualified
👱🏾	person: medium-dark skin tone, blond hair	1F471 1F3FE	People & Body	person	fully-qualified
👱🏿	person: dark skin tone, blond hair	1F471 1F3FF	People & Body	person	fully-qualified
👨	man	1F468	People & Body	person	fully-qualified
👨🏻	man: light skin tone	1F468 1F3FB	People & Body	person	fully-qualified
👨🏼	man: medium-light skin tone	1F468 1F3FC	People & Body	person	fully-qualified
👨🏽	man: medium skin tone	1F468 1F3FD	People & Body	person	fully-qualified
👨🏾	man: medium-dark skin tone	1F468 1F3FE	People & Body	person	fully-qualified
👨🏿	man: dark skin tone	1F468 1F3FF	People & Body	person	fully-qualified
🧔	person: beard	1F9D4	People & Body	person	fully-qualified
🧔🏻	person: light skin tone, beard	1F9D4 1F3FB	People & Body	person	fully-qualified
🧔🏼	person: medium-light skin tone, beard	1F9D4 1F3FC	People & Body	person	fully-qualified
🧔🏽	person: medium skin tone, beard	1F9D4 1F3FD	People & Body	person	fully-qualified
🧔🏾	person: medium-dark skin tone, beard	1F9D4 1F3FE	People & Body	person	fully-qualified
🧔🏿	person: dark skin tone, beard	1F9D4 1F3FF	People & Body	person	fully-qualified
🧔‍♂️	man: beard	1F9D4 200D 2642 FE0F	People & Body	person	fully-qualified
🧔🏻‍♂️	man: light skin tone, beard	1F9D4 1F3FB 200D 2642 FE0F	People & Body	person	fully-qualified
🧔🏼‍♂️	man: medium-light skin tone, beard	1F9D4 1F3FC 200D 2642 FE0F	People & Body	person	fully-qualified
🧔🏽‍♂️	man: medium skin tone, beard	1F9D4 1F3FD 200D 2642 FE0F	People & Body	person	fully-qualified
🧔🏾‍♂️	man: medium-dark skin tone, beard	1F9D4 1F3FE 200D 2642 FE0F	People & Body	person	fully-qualified
🧔🏿‍♂️	man: dark skin tone, beard	1F9D4 1F3FF 200D 2642 FE0F	People & Body	person	fully-qualified
🧔‍♀️	woman: beard	1F9D4 200D 2640 FE0F	People & Body	person	fully-qualified
🧔🏻‍♀️	woman: light skin tone, beard	1F9D4 1F3FB 200D 2640 FE0F	People & Body	person	fully-qualified
🧔🏼‍♀️	woman: medium-light skin tone, beard	1F9D4 1F3FC 200D 2640 FE0F	People & Body	person	fully-qualified
🧔🏽‍♀️	woman: medium skin tone, beard	1F9D4 1F3FD 200D 2640 FE0F	People & Body	person	fully-qualified
🧔🏾‍♀️	woman: medium-dark skin tone, beard	1F9D4 1F3FE 200D 2640 FE0F	People & Body	person	fully-qualified
🧔🏿‍♀️	woman: dark skin tone, beard	1F9D4 1F3FF 200D 2640 FE0F	People & Body	person	fully-qualified
👨‍🦰	man: red hair	1F468 200D 1F9B0	People & Body	person	fully-qualified
👨🏻‍🦰	man: light skin tone, red hair	1F468 1F3FB 200D 1F9B0	People & Body	person	fully-qualified
👨🏼‍🦰	man: medium-light skin tone, red hair	1F468 1F3FC 200D 1F9B0	People & Body	person	fully-qualified
👨🏽‍🦰	man: medium skin tone, red hair	1F468 1F3FD 200D 1F9B0	People & Body	person	fully-qualified
👨🏾‍🦰	man: medium-dark skin tone, red hair	1F468 1F3FE 200D 1F9B0	People & Body	person	fully-qualified
👨🏿‍🦰	man: dark skin tone, red hair	1F468 1F3FF 200D 1F9B0	People & Body	person	fully-qualified
👨‍🦱	man: curly hair	1F468 200D 1F9B1	People & Body	person	fully-qualified
👨🏻‍🦱	man: light skin tone, curly hair	1F468 1F3FB 200D 1F9B1	People & Body	person	fully-qualified
👨🏼‍🦱	man: medium-light skin tone, curly hair	1F468 1F3FC 200D 1F9B1	People & Body	person	fully-qualified
👨🏽‍🦱	man: medium skin tone, curly hair	1F468 1F3FD 200D 1F9B1	People & Body	person	fully-qualified
👨🏾‍🦱	man: medium-dark skin tone, curly hair	1F468 1F3FE 200D 1F9B1	People & Body	person	fully-qualified
👨🏿‍🦱	man: dark skin tone, curly hair	1F468 1F3FF 200D 1F9B1	People & Body	person	fully-qualified
👨‍🦳	man: white hair	1F468 200D 1F9B3	People & Body	person	fully-qualified
👨🏻‍🦳	man: light skin tone, white hair	1F468 1F3FB 200D 1F9B3	People & Body	person	fully-qualified
👨🏼‍🦳	man: medium-light skin tone, white hair	1F468 1F3FC 200D 1F9B3	People & Body	person	fully-qualified
👨🏽‍🦳	man: medium skin tone, white hair	1F468 1F3FD 200D 1F9B3	People & Body	person	fully-qualified
👨🏾‍🦳	man: medium-dark skin tone, white hair	1F468 1F3FE 200D 1F9B3	People & Body	person	fully-qualified
👨🏿‍🦳	man: dark skin tone, white hair	1F468 1F3FF 200D 1F9B3	People & Body	person	fully-qualified
👨‍🦲	man: bald	1F468 200D 1F9B2	People & Body	person	fully-qualified
👨🏻‍🦲	man: light skin tone, bald	1F468 1F3FB 200D 1F9B2	People & Body	person	fully-qualified
👨🏼‍🦲	man: medium-light skin tone, bald	1F468 1F3FC 200D 1F9B2	People & Body	person	fully-qualified
👨🏽‍🦲	man: medium skin tone, bald	1F468 1F3FD 200D 1F9B2	People & Body	person	fully-qualified
👨🏾‍🦲	man: medium-dark skin tone, bald	1F468 1F3FE 200D 1F9B2	People & Body	person	fully-qualified
👨🏿‍🦲	man: dark skin tone, bald	1F468 1F3FF 200D 1F9B2	People & Body	person	fully-qualified
👩	woman	1F469	People & Body	person	fully-qualified
👩🏻	woman: light skin tone	1F469 1F3FB	People & Body	person	fully-qualified
👩🏼	woman: medium-light skin tone	1F469 1F3FC	People & Body	person	fully-qualified
👩🏽	woman: medium skin tone	1F469 1F3FD	People & Body	person	fully-qualified
👩🏾	woman: medium-dark skin tone	1F469 1F3FE	People & Body	person	fully-qualified
👩🏿	woman: dark skin tone	1F469 1F3FF	People & Body	person	fully-qualified
👩‍🦰	woman: red hair	1F469 200D 1F9B0	People & Body	person	fully-qualified
👩🏻‍🦰	woman: light skin tone, red hair	1F469 1F3FB 200D 1F9B0	People & Body	person	fully-qualified
👩🏼‍🦰	woman: medium-light skin tone, red hair	1F469 1F3FC 200D 1F9B0	People & Body	person	fully-qualified
👩🏽‍🦰	woman: medium skin tone, red hair	1F469 1F3FD 200D 1F9B0	People & Body	person	fully-qualified
👩🏾‍🦰	woman: medium-dark skin tone, red hair	1F469 1F3FE 200D 1F9B0	People & Body	person	fully-qualified
👩🏿‍🦰	woman: dark skin tone, red hair	1F469 1F3FF 200D 1F9B0	People & Body	person	fully-qualified
🧑‍🦰	person: red hair	1F9D1 200D 1F9B0	People & Body	person	fully-qualified
🧑🏻‍🦰	person: light skin tone, red hair	1F9D1 1F3FB 200D 1F9B0	People & Body	person	fully-qualified
🧑🏼‍🦰	person: medium-light skin tone, red hair	1F9D1 1F3FC 200D 1F9B0	People & Body	person	fully-qualified
🧑🏽‍🦰	person: medium skin tone, red hair	1F9D1 1F3FD 200D 1F9B0	People & Body	person	fully-qualified
🧑🏾‍🦰	person: medium-dark skin tone, red hair	1F9D1 1F3FE 200D 1F9B0	People & Body	person	fully-qualified
🧑🏿‍🦰	person: dark skin tone, red hair	1F9D1 1F3FF 200D 1F9B0	People & Body	person	fully-qualified
👩‍🦱	woman: curly hair	1F469 200D 1F9B1	People & Body	person	fully-qualified
👩🏻‍🦱	woman: light skin tone, curly hair	1F469 1F3FB 200D 1F9B1	People & Body	person	fully-qualified
👩🏼‍🦱	woman: medium-light skin tone, curly hair	1F469 1F3FC 200D 1F9B1	People & Body	person	fully-qualified
👩🏽‍🦱	woman: medium skin tone, curly hair	1F469 1F3FD 200D 1F9B1	People & Body	person	fully-qualified
        """.trimIndent(),

        """
👩🏾‍🦱	woman: medium-dark skin tone, curly hair	1F469 1F3FE 200D 1F9B1	People & Body	person	fully-qualified
👩🏿‍🦱	woman: dark skin tone, curly hair	1F469 1F3FF 200D 1F9B1	People & Body	person	fully-qualified
🧑‍🦱	person: curly hair	1F9D1 200D 1F9B1	People & Body	person	fully-qualified
🧑🏻‍🦱	person: light skin tone, curly hair	1F9D1 1F3FB 200D 1F9B1	People & Body	person	fully-qualified
🧑🏼‍🦱	person: medium-light skin tone, curly hair	1F9D1 1F3FC 200D 1F9B1	People & Body	person	fully-qualified
🧑🏽‍🦱	person: medium skin tone, curly hair	1F9D1 1F3FD 200D 1F9B1	People & Body	person	fully-qualified
🧑🏾‍🦱	person: medium-dark skin tone, curly hair	1F9D1 1F3FE 200D 1F9B1	People & Body	person	fully-qualified
🧑🏿‍🦱	person: dark skin tone, curly hair	1F9D1 1F3FF 200D 1F9B1	People & Body	person	fully-qualified
👩‍🦳	woman: white hair	1F469 200D 1F9B3	People & Body	person	fully-qualified
👩🏻‍🦳	woman: light skin tone, white hair	1F469 1F3FB 200D 1F9B3	People & Body	person	fully-qualified
👩🏼‍🦳	woman: medium-light skin tone, white hair	1F469 1F3FC 200D 1F9B3	People & Body	person	fully-qualified
👩🏽‍🦳	woman: medium skin tone, white hair	1F469 1F3FD 200D 1F9B3	People & Body	person	fully-qualified
👩🏾‍🦳	woman: medium-dark skin tone, white hair	1F469 1F3FE 200D 1F9B3	People & Body	person	fully-qualified
👩🏿‍🦳	woman: dark skin tone, white hair	1F469 1F3FF 200D 1F9B3	People & Body	person	fully-qualified
🧑‍🦳	person: white hair	1F9D1 200D 1F9B3	People & Body	person	fully-qualified
🧑🏻‍🦳	person: light skin tone, white hair	1F9D1 1F3FB 200D 1F9B3	People & Body	person	fully-qualified
🧑🏼‍🦳	person: medium-light skin tone, white hair	1F9D1 1F3FC 200D 1F9B3	People & Body	person	fully-qualified
🧑🏽‍🦳	person: medium skin tone, white hair	1F9D1 1F3FD 200D 1F9B3	People & Body	person	fully-qualified
🧑🏾‍🦳	person: medium-dark skin tone, white hair	1F9D1 1F3FE 200D 1F9B3	People & Body	person	fully-qualified
🧑🏿‍🦳	person: dark skin tone, white hair	1F9D1 1F3FF 200D 1F9B3	People & Body	person	fully-qualified
👩‍🦲	woman: bald	1F469 200D 1F9B2	People & Body	person	fully-qualified
👩🏻‍🦲	woman: light skin tone, bald	1F469 1F3FB 200D 1F9B2	People & Body	person	fully-qualified
👩🏼‍🦲	woman: medium-light skin tone, bald	1F469 1F3FC 200D 1F9B2	People & Body	person	fully-qualified
👩🏽‍🦲	woman: medium skin tone, bald	1F469 1F3FD 200D 1F9B2	People & Body	person	fully-qualified
👩🏾‍🦲	woman: medium-dark skin tone, bald	1F469 1F3FE 200D 1F9B2	People & Body	person	fully-qualified
👩🏿‍🦲	woman: dark skin tone, bald	1F469 1F3FF 200D 1F9B2	People & Body	person	fully-qualified
🧑‍🦲	person: bald	1F9D1 200D 1F9B2	People & Body	person	fully-qualified
🧑🏻‍🦲	person: light skin tone, bald	1F9D1 1F3FB 200D 1F9B2	People & Body	person	fully-qualified
🧑🏼‍🦲	person: medium-light skin tone, bald	1F9D1 1F3FC 200D 1F9B2	People & Body	person	fully-qualified
🧑🏽‍🦲	person: medium skin tone, bald	1F9D1 1F3FD 200D 1F9B2	People & Body	person	fully-qualified
🧑🏾‍🦲	person: medium-dark skin tone, bald	1F9D1 1F3FE 200D 1F9B2	People & Body	person	fully-qualified
🧑🏿‍🦲	person: dark skin tone, bald	1F9D1 1F3FF 200D 1F9B2	People & Body	person	fully-qualified
👱‍♀️	woman: blond hair	1F471 200D 2640 FE0F	People & Body	person	fully-qualified
👱🏻‍♀️	woman: light skin tone, blond hair	1F471 1F3FB 200D 2640 FE0F	People & Body	person	fully-qualified
👱🏼‍♀️	woman: medium-light skin tone, blond hair	1F471 1F3FC 200D 2640 FE0F	People & Body	person	fully-qualified
👱🏽‍♀️	woman: medium skin tone, blond hair	1F471 1F3FD 200D 2640 FE0F	People & Body	person	fully-qualified
👱🏾‍♀️	woman: medium-dark skin tone, blond hair	1F471 1F3FE 200D 2640 FE0F	People & Body	person	fully-qualified
👱🏿‍♀️	woman: dark skin tone, blond hair	1F471 1F3FF 200D 2640 FE0F	People & Body	person	fully-qualified
👱‍♂️	man: blond hair	1F471 200D 2642 FE0F	People & Body	person	fully-qualified
👱🏻‍♂️	man: light skin tone, blond hair	1F471 1F3FB 200D 2642 FE0F	People & Body	person	fully-qualified
👱🏼‍♂️	man: medium-light skin tone, blond hair	1F471 1F3FC 200D 2642 FE0F	People & Body	person	fully-qualified
👱🏽‍♂️	man: medium skin tone, blond hair	1F471 1F3FD 200D 2642 FE0F	People & Body	person	fully-qualified
👱🏾‍♂️	man: medium-dark skin tone, blond hair	1F471 1F3FE 200D 2642 FE0F	People & Body	person	fully-qualified
👱🏿‍♂️	man: dark skin tone, blond hair	1F471 1F3FF 200D 2642 FE0F	People & Body	person	fully-qualified
🧓	older person	1F9D3	People & Body	person	fully-qualified
🧓🏻	older person: light skin tone	1F9D3 1F3FB	People & Body	person	fully-qualified
🧓🏼	older person: medium-light skin tone	1F9D3 1F3FC	People & Body	person	fully-qualified
🧓🏽	older person: medium skin tone	1F9D3 1F3FD	People & Body	person	fully-qualified
🧓🏾	older person: medium-dark skin tone	1F9D3 1F3FE	People & Body	person	fully-qualified
🧓🏿	older person: dark skin tone	1F9D3 1F3FF	People & Body	person	fully-qualified
👴	old man	1F474	People & Body	person	fully-qualified
👴🏻	old man: light skin tone	1F474 1F3FB	People & Body	person	fully-qualified
👴🏼	old man: medium-light skin tone	1F474 1F3FC	People & Body	person	fully-qualified
👴🏽	old man: medium skin tone	1F474 1F3FD	People & Body	person	fully-qualified
👴🏾	old man: medium-dark skin tone	1F474 1F3FE	People & Body	person	fully-qualified
👴🏿	old man: dark skin tone	1F474 1F3FF	People & Body	person	fully-qualified
👵	old woman	1F475	People & Body	person	fully-qualified
👵🏻	old woman: light skin tone	1F475 1F3FB	People & Body	person	fully-qualified
👵🏼	old woman: medium-light skin tone	1F475 1F3FC	People & Body	person	fully-qualified
👵🏽	old woman: medium skin tone	1F475 1F3FD	People & Body	person	fully-qualified
👵🏾	old woman: medium-dark skin tone	1F475 1F3FE	People & Body	person	fully-qualified
👵🏿	old woman: dark skin tone	1F475 1F3FF	People & Body	person	fully-qualified
🙍	person frowning	1F64D	People & Body	person-gesture	fully-qualified
🙍🏻	person frowning: light skin tone	1F64D 1F3FB	People & Body	person-gesture	fully-qualified
🙍🏼	person frowning: medium-light skin tone	1F64D 1F3FC	People & Body	person-gesture	fully-qualified
🙍🏽	person frowning: medium skin tone	1F64D 1F3FD	People & Body	person-gesture	fully-qualified
🙍🏾	person frowning: medium-dark skin tone	1F64D 1F3FE	People & Body	person-gesture	fully-qualified
🙍🏿	person frowning: dark skin tone	1F64D 1F3FF	People & Body	person-gesture	fully-qualified
🙍‍♂️	man frowning	1F64D 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙍🏻‍♂️	man frowning: light skin tone	1F64D 1F3FB 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙍🏼‍♂️	man frowning: medium-light skin tone	1F64D 1F3FC 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙍🏽‍♂️	man frowning: medium skin tone	1F64D 1F3FD 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙍🏾‍♂️	man frowning: medium-dark skin tone	1F64D 1F3FE 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙍🏿‍♂️	man frowning: dark skin tone	1F64D 1F3FF 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙍‍♀️	woman frowning	1F64D 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙍🏻‍♀️	woman frowning: light skin tone	1F64D 1F3FB 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙍🏼‍♀️	woman frowning: medium-light skin tone	1F64D 1F3FC 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙍🏽‍♀️	woman frowning: medium skin tone	1F64D 1F3FD 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙍🏾‍♀️	woman frowning: medium-dark skin tone	1F64D 1F3FE 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙍🏿‍♀️	woman frowning: dark skin tone	1F64D 1F3FF 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙎	person pouting	1F64E	People & Body	person-gesture	fully-qualified
🙎🏻	person pouting: light skin tone	1F64E 1F3FB	People & Body	person-gesture	fully-qualified
🙎🏼	person pouting: medium-light skin tone	1F64E 1F3FC	People & Body	person-gesture	fully-qualified
🙎🏽	person pouting: medium skin tone	1F64E 1F3FD	People & Body	person-gesture	fully-qualified
🙎🏾	person pouting: medium-dark skin tone	1F64E 1F3FE	People & Body	person-gesture	fully-qualified
🙎🏿	person pouting: dark skin tone	1F64E 1F3FF	People & Body	person-gesture	fully-qualified
🙎‍♂️	man pouting	1F64E 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙎🏻‍♂️	man pouting: light skin tone	1F64E 1F3FB 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙎🏼‍♂️	man pouting: medium-light skin tone	1F64E 1F3FC 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙎🏽‍♂️	man pouting: medium skin tone	1F64E 1F3FD 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙎🏾‍♂️	man pouting: medium-dark skin tone	1F64E 1F3FE 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙎🏿‍♂️	man pouting: dark skin tone	1F64E 1F3FF 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙎‍♀️	woman pouting	1F64E 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙎🏻‍♀️	woman pouting: light skin tone	1F64E 1F3FB 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙎🏼‍♀️	woman pouting: medium-light skin tone	1F64E 1F3FC 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙎🏽‍♀️	woman pouting: medium skin tone	1F64E 1F3FD 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙎🏾‍♀️	woman pouting: medium-dark skin tone	1F64E 1F3FE 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙎🏿‍♀️	woman pouting: dark skin tone	1F64E 1F3FF 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙅	person gesturing NO	1F645	People & Body	person-gesture	fully-qualified
🙅🏻	person gesturing NO: light skin tone	1F645 1F3FB	People & Body	person-gesture	fully-qualified
🙅🏼	person gesturing NO: medium-light skin tone	1F645 1F3FC	People & Body	person-gesture	fully-qualified
🙅🏽	person gesturing NO: medium skin tone	1F645 1F3FD	People & Body	person-gesture	fully-qualified
🙅🏾	person gesturing NO: medium-dark skin tone	1F645 1F3FE	People & Body	person-gesture	fully-qualified
🙅🏿	person gesturing NO: dark skin tone	1F645 1F3FF	People & Body	person-gesture	fully-qualified
🙅‍♂️	man gesturing NO	1F645 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙅🏻‍♂️	man gesturing NO: light skin tone	1F645 1F3FB 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙅🏼‍♂️	man gesturing NO: medium-light skin tone	1F645 1F3FC 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙅🏽‍♂️	man gesturing NO: medium skin tone	1F645 1F3FD 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙅🏾‍♂️	man gesturing NO: medium-dark skin tone	1F645 1F3FE 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙅🏿‍♂️	man gesturing NO: dark skin tone	1F645 1F3FF 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙅‍♀️	woman gesturing NO	1F645 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙅🏻‍♀️	woman gesturing NO: light skin tone	1F645 1F3FB 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙅🏼‍♀️	woman gesturing NO: medium-light skin tone	1F645 1F3FC 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙅🏽‍♀️	woman gesturing NO: medium skin tone	1F645 1F3FD 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙅🏾‍♀️	woman gesturing NO: medium-dark skin tone	1F645 1F3FE 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙅🏿‍♀️	woman gesturing NO: dark skin tone	1F645 1F3FF 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙆	person gesturing OK	1F646	People & Body	person-gesture	fully-qualified
🙆🏻	person gesturing OK: light skin tone	1F646 1F3FB	People & Body	person-gesture	fully-qualified
🙆🏼	person gesturing OK: medium-light skin tone	1F646 1F3FC	People & Body	person-gesture	fully-qualified
🙆🏽	person gesturing OK: medium skin tone	1F646 1F3FD	People & Body	person-gesture	fully-qualified
🙆🏾	person gesturing OK: medium-dark skin tone	1F646 1F3FE	People & Body	person-gesture	fully-qualified
🙆🏿	person gesturing OK: dark skin tone	1F646 1F3FF	People & Body	person-gesture	fully-qualified
🙆‍♂️	man gesturing OK	1F646 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙆🏻‍♂️	man gesturing OK: light skin tone	1F646 1F3FB 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙆🏼‍♂️	man gesturing OK: medium-light skin tone	1F646 1F3FC 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙆🏽‍♂️	man gesturing OK: medium skin tone	1F646 1F3FD 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙆🏾‍♂️	man gesturing OK: medium-dark skin tone	1F646 1F3FE 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙆🏿‍♂️	man gesturing OK: dark skin tone	1F646 1F3FF 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙆‍♀️	woman gesturing OK	1F646 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙆🏻‍♀️	woman gesturing OK: light skin tone	1F646 1F3FB 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙆🏼‍♀️	woman gesturing OK: medium-light skin tone	1F646 1F3FC 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙆🏽‍♀️	woman gesturing OK: medium skin tone	1F646 1F3FD 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙆🏾‍♀️	woman gesturing OK: medium-dark skin tone	1F646 1F3FE 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙆🏿‍♀️	woman gesturing OK: dark skin tone	1F646 1F3FF 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
💁	person tipping hand	1F481	People & Body	person-gesture	fully-qualified
💁🏻	person tipping hand: light skin tone	1F481 1F3FB	People & Body	person-gesture	fully-qualified
💁🏼	person tipping hand: medium-light skin tone	1F481 1F3FC	People & Body	person-gesture	fully-qualified
💁🏽	person tipping hand: medium skin tone	1F481 1F3FD	People & Body	person-gesture	fully-qualified
💁🏾	person tipping hand: medium-dark skin tone	1F481 1F3FE	People & Body	person-gesture	fully-qualified
💁🏿	person tipping hand: dark skin tone	1F481 1F3FF	People & Body	person-gesture	fully-qualified
💁‍♂️	man tipping hand	1F481 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
💁🏻‍♂️	man tipping hand: light skin tone	1F481 1F3FB 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
💁🏼‍♂️	man tipping hand: medium-light skin tone	1F481 1F3FC 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
💁🏽‍♂️	man tipping hand: medium skin tone	1F481 1F3FD 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
💁🏾‍♂️	man tipping hand: medium-dark skin tone	1F481 1F3FE 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
💁🏿‍♂️	man tipping hand: dark skin tone	1F481 1F3FF 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
💁‍♀️	woman tipping hand	1F481 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
💁🏻‍♀️	woman tipping hand: light skin tone	1F481 1F3FB 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
💁🏼‍♀️	woman tipping hand: medium-light skin tone	1F481 1F3FC 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
💁🏽‍♀️	woman tipping hand: medium skin tone	1F481 1F3FD 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
💁🏾‍♀️	woman tipping hand: medium-dark skin tone	1F481 1F3FE 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
💁🏿‍♀️	woman tipping hand: dark skin tone	1F481 1F3FF 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙋	person raising hand	1F64B	People & Body	person-gesture	fully-qualified
🙋🏻	person raising hand: light skin tone	1F64B 1F3FB	People & Body	person-gesture	fully-qualified
🙋🏼	person raising hand: medium-light skin tone	1F64B 1F3FC	People & Body	person-gesture	fully-qualified
🙋🏽	person raising hand: medium skin tone	1F64B 1F3FD	People & Body	person-gesture	fully-qualified
🙋🏾	person raising hand: medium-dark skin tone	1F64B 1F3FE	People & Body	person-gesture	fully-qualified
🙋🏿	person raising hand: dark skin tone	1F64B 1F3FF	People & Body	person-gesture	fully-qualified
🙋‍♂️	man raising hand	1F64B 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙋🏻‍♂️	man raising hand: light skin tone	1F64B 1F3FB 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙋🏼‍♂️	man raising hand: medium-light skin tone	1F64B 1F3FC 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙋🏽‍♂️	man raising hand: medium skin tone	1F64B 1F3FD 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙋🏾‍♂️	man raising hand: medium-dark skin tone	1F64B 1F3FE 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙋🏿‍♂️	man raising hand: dark skin tone	1F64B 1F3FF 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙋‍♀️	woman raising hand	1F64B 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙋🏻‍♀️	woman raising hand: light skin tone	1F64B 1F3FB 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙋🏼‍♀️	woman raising hand: medium-light skin tone	1F64B 1F3FC 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙋🏽‍♀️	woman raising hand: medium skin tone	1F64B 1F3FD 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙋🏾‍♀️	woman raising hand: medium-dark skin tone	1F64B 1F3FE 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙋🏿‍♀️	woman raising hand: dark skin tone	1F64B 1F3FF 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🧏	deaf person	1F9CF	People & Body	person-gesture	fully-qualified
🧏🏻	deaf person: light skin tone	1F9CF 1F3FB	People & Body	person-gesture	fully-qualified
🧏🏼	deaf person: medium-light skin tone	1F9CF 1F3FC	People & Body	person-gesture	fully-qualified
🧏🏽	deaf person: medium skin tone	1F9CF 1F3FD	People & Body	person-gesture	fully-qualified
🧏🏾	deaf person: medium-dark skin tone	1F9CF 1F3FE	People & Body	person-gesture	fully-qualified
🧏🏿	deaf person: dark skin tone	1F9CF 1F3FF	People & Body	person-gesture	fully-qualified
🧏‍♂️	deaf man	1F9CF 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🧏🏻‍♂️	deaf man: light skin tone	1F9CF 1F3FB 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🧏🏼‍♂️	deaf man: medium-light skin tone	1F9CF 1F3FC 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🧏🏽‍♂️	deaf man: medium skin tone	1F9CF 1F3FD 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🧏🏾‍♂️	deaf man: medium-dark skin tone	1F9CF 1F3FE 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🧏🏿‍♂️	deaf man: dark skin tone	1F9CF 1F3FF 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🧏‍♀️	deaf woman	1F9CF 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🧏🏻‍♀️	deaf woman: light skin tone	1F9CF 1F3FB 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🧏🏼‍♀️	deaf woman: medium-light skin tone	1F9CF 1F3FC 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🧏🏽‍♀️	deaf woman: medium skin tone	1F9CF 1F3FD 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🧏🏾‍♀️	deaf woman: medium-dark skin tone	1F9CF 1F3FE 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🧏🏿‍♀️	deaf woman: dark skin tone	1F9CF 1F3FF 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙇	person bowing	1F647	People & Body	person-gesture	fully-qualified
🙇🏻	person bowing: light skin tone	1F647 1F3FB	People & Body	person-gesture	fully-qualified
🙇🏼	person bowing: medium-light skin tone	1F647 1F3FC	People & Body	person-gesture	fully-qualified
🙇🏽	person bowing: medium skin tone	1F647 1F3FD	People & Body	person-gesture	fully-qualified
🙇🏾	person bowing: medium-dark skin tone	1F647 1F3FE	People & Body	person-gesture	fully-qualified
🙇🏿	person bowing: dark skin tone	1F647 1F3FF	People & Body	person-gesture	fully-qualified
🙇‍♂️	man bowing	1F647 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙇🏻‍♂️	man bowing: light skin tone	1F647 1F3FB 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙇🏼‍♂️	man bowing: medium-light skin tone	1F647 1F3FC 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙇🏽‍♂️	man bowing: medium skin tone	1F647 1F3FD 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙇🏾‍♂️	man bowing: medium-dark skin tone	1F647 1F3FE 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙇🏿‍♂️	man bowing: dark skin tone	1F647 1F3FF 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🙇‍♀️	woman bowing	1F647 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙇🏻‍♀️	woman bowing: light skin tone	1F647 1F3FB 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙇🏼‍♀️	woman bowing: medium-light skin tone	1F647 1F3FC 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙇🏽‍♀️	woman bowing: medium skin tone	1F647 1F3FD 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙇🏾‍♀️	woman bowing: medium-dark skin tone	1F647 1F3FE 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🙇🏿‍♀️	woman bowing: dark skin tone	1F647 1F3FF 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🤦	person facepalming	1F926	People & Body	person-gesture	fully-qualified
🤦🏻	person facepalming: light skin tone	1F926 1F3FB	People & Body	person-gesture	fully-qualified
🤦🏼	person facepalming: medium-light skin tone	1F926 1F3FC	People & Body	person-gesture	fully-qualified
🤦🏽	person facepalming: medium skin tone	1F926 1F3FD	People & Body	person-gesture	fully-qualified
🤦🏾	person facepalming: medium-dark skin tone	1F926 1F3FE	People & Body	person-gesture	fully-qualified
🤦🏿	person facepalming: dark skin tone	1F926 1F3FF	People & Body	person-gesture	fully-qualified
🤦‍♂️	man facepalming	1F926 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🤦🏻‍♂️	man facepalming: light skin tone	1F926 1F3FB 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🤦🏼‍♂️	man facepalming: medium-light skin tone	1F926 1F3FC 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🤦🏽‍♂️	man facepalming: medium skin tone	1F926 1F3FD 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🤦🏾‍♂️	man facepalming: medium-dark skin tone	1F926 1F3FE 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🤦🏿‍♂️	man facepalming: dark skin tone	1F926 1F3FF 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🤦‍♀️	woman facepalming	1F926 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🤦🏻‍♀️	woman facepalming: light skin tone	1F926 1F3FB 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🤦🏼‍♀️	woman facepalming: medium-light skin tone	1F926 1F3FC 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🤦🏽‍♀️	woman facepalming: medium skin tone	1F926 1F3FD 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🤦🏾‍♀️	woman facepalming: medium-dark skin tone	1F926 1F3FE 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🤦🏿‍♀️	woman facepalming: dark skin tone	1F926 1F3FF 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🤷	person shrugging	1F937	People & Body	person-gesture	fully-qualified
🤷🏻	person shrugging: light skin tone	1F937 1F3FB	People & Body	person-gesture	fully-qualified
🤷🏼	person shrugging: medium-light skin tone	1F937 1F3FC	People & Body	person-gesture	fully-qualified
🤷🏽	person shrugging: medium skin tone	1F937 1F3FD	People & Body	person-gesture	fully-qualified
🤷🏾	person shrugging: medium-dark skin tone	1F937 1F3FE	People & Body	person-gesture	fully-qualified
🤷🏿	person shrugging: dark skin tone	1F937 1F3FF	People & Body	person-gesture	fully-qualified
🤷‍♂️	man shrugging	1F937 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🤷🏻‍♂️	man shrugging: light skin tone	1F937 1F3FB 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🤷🏼‍♂️	man shrugging: medium-light skin tone	1F937 1F3FC 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🤷🏽‍♂️	man shrugging: medium skin tone	1F937 1F3FD 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🤷🏾‍♂️	man shrugging: medium-dark skin tone	1F937 1F3FE 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🤷🏿‍♂️	man shrugging: dark skin tone	1F937 1F3FF 200D 2642 FE0F	People & Body	person-gesture	fully-qualified
🤷‍♀️	woman shrugging	1F937 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🤷🏻‍♀️	woman shrugging: light skin tone	1F937 1F3FB 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🤷🏼‍♀️	woman shrugging: medium-light skin tone	1F937 1F3FC 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🤷🏽‍♀️	woman shrugging: medium skin tone	1F937 1F3FD 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🤷🏾‍♀️	woman shrugging: medium-dark skin tone	1F937 1F3FE 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🤷🏿‍♀️	woman shrugging: dark skin tone	1F937 1F3FF 200D 2640 FE0F	People & Body	person-gesture	fully-qualified
🧑‍⚕️	health worker	1F9D1 200D 2695 FE0F	People & Body	person-role	fully-qualified
🧑🏻‍⚕️	health worker: light skin tone	1F9D1 1F3FB 200D 2695 FE0F	People & Body	person-role	fully-qualified
🧑🏼‍⚕️	health worker: medium-light skin tone	1F9D1 1F3FC 200D 2695 FE0F	People & Body	person-role	fully-qualified
🧑🏽‍⚕️	health worker: medium skin tone	1F9D1 1F3FD 200D 2695 FE0F	People & Body	person-role	fully-qualified
🧑🏾‍⚕️	health worker: medium-dark skin tone	1F9D1 1F3FE 200D 2695 FE0F	People & Body	person-role	fully-qualified
🧑🏿‍⚕️	health worker: dark skin tone	1F9D1 1F3FF 200D 2695 FE0F	People & Body	person-role	fully-qualified
👨‍⚕️	man health worker	1F468 200D 2695 FE0F	People & Body	person-role	fully-qualified
👨🏻‍⚕️	man health worker: light skin tone	1F468 1F3FB 200D 2695 FE0F	People & Body	person-role	fully-qualified
👨🏼‍⚕️	man health worker: medium-light skin tone	1F468 1F3FC 200D 2695 FE0F	People & Body	person-role	fully-qualified
👨🏽‍⚕️	man health worker: medium skin tone	1F468 1F3FD 200D 2695 FE0F	People & Body	person-role	fully-qualified
👨🏾‍⚕️	man health worker: medium-dark skin tone	1F468 1F3FE 200D 2695 FE0F	People & Body	person-role	fully-qualified
👨🏿‍⚕️	man health worker: dark skin tone	1F468 1F3FF 200D 2695 FE0F	People & Body	person-role	fully-qualified
👩‍⚕️	woman health worker	1F469 200D 2695 FE0F	People & Body	person-role	fully-qualified
👩🏻‍⚕️	woman health worker: light skin tone	1F469 1F3FB 200D 2695 FE0F	People & Body	person-role	fully-qualified
👩🏼‍⚕️	woman health worker: medium-light skin tone	1F469 1F3FC 200D 2695 FE0F	People & Body	person-role	fully-qualified
👩🏽‍⚕️	woman health worker: medium skin tone	1F469 1F3FD 200D 2695 FE0F	People & Body	person-role	fully-qualified
👩🏾‍⚕️	woman health worker: medium-dark skin tone	1F469 1F3FE 200D 2695 FE0F	People & Body	person-role	fully-qualified
👩🏿‍⚕️	woman health worker: dark skin tone	1F469 1F3FF 200D 2695 FE0F	People & Body	person-role	fully-qualified
🧑‍🎓	student	1F9D1 200D 1F393	People & Body	person-role	fully-qualified
🧑🏻‍🎓	student: light skin tone	1F9D1 1F3FB 200D 1F393	People & Body	person-role	fully-qualified
🧑🏼‍🎓	student: medium-light skin tone	1F9D1 1F3FC 200D 1F393	People & Body	person-role	fully-qualified
🧑🏽‍🎓	student: medium skin tone	1F9D1 1F3FD 200D 1F393	People & Body	person-role	fully-qualified
🧑🏾‍🎓	student: medium-dark skin tone	1F9D1 1F3FE 200D 1F393	People & Body	person-role	fully-qualified
🧑🏿‍🎓	student: dark skin tone	1F9D1 1F3FF 200D 1F393	People & Body	person-role	fully-qualified
👨‍🎓	man student	1F468 200D 1F393	People & Body	person-role	fully-qualified
👨🏻‍🎓	man student: light skin tone	1F468 1F3FB 200D 1F393	People & Body	person-role	fully-qualified
👨🏼‍🎓	man student: medium-light skin tone	1F468 1F3FC 200D 1F393	People & Body	person-role	fully-qualified
👨🏽‍🎓	man student: medium skin tone	1F468 1F3FD 200D 1F393	People & Body	person-role	fully-qualified
👨🏾‍🎓	man student: medium-dark skin tone	1F468 1F3FE 200D 1F393	People & Body	person-role	fully-qualified
👨🏿‍🎓	man student: dark skin tone	1F468 1F3FF 200D 1F393	People & Body	person-role	fully-qualified
👩‍🎓	woman student	1F469 200D 1F393	People & Body	person-role	fully-qualified
👩🏻‍🎓	woman student: light skin tone	1F469 1F3FB 200D 1F393	People & Body	person-role	fully-qualified
👩🏼‍🎓	woman student: medium-light skin tone	1F469 1F3FC 200D 1F393	People & Body	person-role	fully-qualified
👩🏽‍🎓	woman student: medium skin tone	1F469 1F3FD 200D 1F393	People & Body	person-role	fully-qualified
👩🏾‍🎓	woman student: medium-dark skin tone	1F469 1F3FE 200D 1F393	People & Body	person-role	fully-qualified
👩🏿‍🎓	woman student: dark skin tone	1F469 1F3FF 200D 1F393	People & Body	person-role	fully-qualified
🧑‍🏫	teacher	1F9D1 200D 1F3EB	People & Body	person-role	fully-qualified
🧑🏻‍🏫	teacher: light skin tone	1F9D1 1F3FB 200D 1F3EB	People & Body	person-role	fully-qualified
🧑🏼‍🏫	teacher: medium-light skin tone	1F9D1 1F3FC 200D 1F3EB	People & Body	person-role	fully-qualified
🧑🏽‍🏫	teacher: medium skin tone	1F9D1 1F3FD 200D 1F3EB	People & Body	person-role	fully-qualified
🧑🏾‍🏫	teacher: medium-dark skin tone	1F9D1 1F3FE 200D 1F3EB	People & Body	person-role	fully-qualified
🧑🏿‍🏫	teacher: dark skin tone	1F9D1 1F3FF 200D 1F3EB	People & Body	person-role	fully-qualified
👨‍🏫	man teacher	1F468 200D 1F3EB	People & Body	person-role	fully-qualified
👨🏻‍🏫	man teacher: light skin tone	1F468 1F3FB 200D 1F3EB	People & Body	person-role	fully-qualified
👨🏼‍🏫	man teacher: medium-light skin tone	1F468 1F3FC 200D 1F3EB	People & Body	person-role	fully-qualified
👨🏽‍🏫	man teacher: medium skin tone	1F468 1F3FD 200D 1F3EB	People & Body	person-role	fully-qualified
👨🏾‍🏫	man teacher: medium-dark skin tone	1F468 1F3FE 200D 1F3EB	People & Body	person-role	fully-qualified
👨🏿‍🏫	man teacher: dark skin tone	1F468 1F3FF 200D 1F3EB	People & Body	person-role	fully-qualified
👩‍🏫	woman teacher	1F469 200D 1F3EB	People & Body	person-role	fully-qualified
👩🏻‍🏫	woman teacher: light skin tone	1F469 1F3FB 200D 1F3EB	People & Body	person-role	fully-qualified
👩🏼‍🏫	woman teacher: medium-light skin tone	1F469 1F3FC 200D 1F3EB	People & Body	person-role	fully-qualified
👩🏽‍🏫	woman teacher: medium skin tone	1F469 1F3FD 200D 1F3EB	People & Body	person-role	fully-qualified
👩🏾‍🏫	woman teacher: medium-dark skin tone	1F469 1F3FE 200D 1F3EB	People & Body	person-role	fully-qualified
👩🏿‍🏫	woman teacher: dark skin tone	1F469 1F3FF 200D 1F3EB	People & Body	person-role	fully-qualified
🧑‍⚖️	judge	1F9D1 200D 2696 FE0F	People & Body	person-role	fully-qualified
🧑🏻‍⚖️	judge: light skin tone	1F9D1 1F3FB 200D 2696 FE0F	People & Body	person-role	fully-qualified
🧑🏼‍⚖️	judge: medium-light skin tone	1F9D1 1F3FC 200D 2696 FE0F	People & Body	person-role	fully-qualified
🧑🏽‍⚖️	judge: medium skin tone	1F9D1 1F3FD 200D 2696 FE0F	People & Body	person-role	fully-qualified
🧑🏾‍⚖️	judge: medium-dark skin tone	1F9D1 1F3FE 200D 2696 FE0F	People & Body	person-role	fully-qualified
🧑🏿‍⚖️	judge: dark skin tone	1F9D1 1F3FF 200D 2696 FE0F	People & Body	person-role	fully-qualified
👨‍⚖️	man judge	1F468 200D 2696 FE0F	People & Body	person-role	fully-qualified
👨🏻‍⚖️	man judge: light skin tone	1F468 1F3FB 200D 2696 FE0F	People & Body	person-role	fully-qualified
👨🏼‍⚖️	man judge: medium-light skin tone	1F468 1F3FC 200D 2696 FE0F	People & Body	person-role	fully-qualified
👨🏽‍⚖️	man judge: medium skin tone	1F468 1F3FD 200D 2696 FE0F	People & Body	person-role	fully-qualified
👨🏾‍⚖️	man judge: medium-dark skin tone	1F468 1F3FE 200D 2696 FE0F	People & Body	person-role	fully-qualified
👨🏿‍⚖️	man judge: dark skin tone	1F468 1F3FF 200D 2696 FE0F	People & Body	person-role	fully-qualified
👩‍⚖️	woman judge	1F469 200D 2696 FE0F	People & Body	person-role	fully-qualified
👩🏻‍⚖️	woman judge: light skin tone	1F469 1F3FB 200D 2696 FE0F	People & Body	person-role	fully-qualified
👩🏼‍⚖️	woman judge: medium-light skin tone	1F469 1F3FC 200D 2696 FE0F	People & Body	person-role	fully-qualified
👩🏽‍⚖️	woman judge: medium skin tone	1F469 1F3FD 200D 2696 FE0F	People & Body	person-role	fully-qualified
👩🏾‍⚖️	woman judge: medium-dark skin tone	1F469 1F3FE 200D 2696 FE0F	People & Body	person-role	fully-qualified
👩🏿‍⚖️	woman judge: dark skin tone	1F469 1F3FF 200D 2696 FE0F	People & Body	person-role	fully-qualified
🧑‍🌾	farmer	1F9D1 200D 1F33E	People & Body	person-role	fully-qualified
🧑🏻‍🌾	farmer: light skin tone	1F9D1 1F3FB 200D 1F33E	People & Body	person-role	fully-qualified
🧑🏼‍🌾	farmer: medium-light skin tone	1F9D1 1F3FC 200D 1F33E	People & Body	person-role	fully-qualified
🧑🏽‍🌾	farmer: medium skin tone	1F9D1 1F3FD 200D 1F33E	People & Body	person-role	fully-qualified
🧑🏾‍🌾	farmer: medium-dark skin tone	1F9D1 1F3FE 200D 1F33E	People & Body	person-role	fully-qualified
🧑🏿‍🌾	farmer: dark skin tone	1F9D1 1F3FF 200D 1F33E	People & Body	person-role	fully-qualified
👨‍🌾	man farmer	1F468 200D 1F33E	People & Body	person-role	fully-qualified
👨🏻‍🌾	man farmer: light skin tone	1F468 1F3FB 200D 1F33E	People & Body	person-role	fully-qualified
👨🏼‍🌾	man farmer: medium-light skin tone	1F468 1F3FC 200D 1F33E	People & Body	person-role	fully-qualified
👨🏽‍🌾	man farmer: medium skin tone	1F468 1F3FD 200D 1F33E	People & Body	person-role	fully-qualified
👨🏾‍🌾	man farmer: medium-dark skin tone	1F468 1F3FE 200D 1F33E	People & Body	person-role	fully-qualified
👨🏿‍🌾	man farmer: dark skin tone	1F468 1F3FF 200D 1F33E	People & Body	person-role	fully-qualified
👩‍🌾	woman farmer	1F469 200D 1F33E	People & Body	person-role	fully-qualified
👩🏻‍🌾	woman farmer: light skin tone	1F469 1F3FB 200D 1F33E	People & Body	person-role	fully-qualified
👩🏼‍🌾	woman farmer: medium-light skin tone	1F469 1F3FC 200D 1F33E	People & Body	person-role	fully-qualified
👩🏽‍🌾	woman farmer: medium skin tone	1F469 1F3FD 200D 1F33E	People & Body	person-role	fully-qualified
👩🏾‍🌾	woman farmer: medium-dark skin tone	1F469 1F3FE 200D 1F33E	People & Body	person-role	fully-qualified
👩🏿‍🌾	woman farmer: dark skin tone	1F469 1F3FF 200D 1F33E	People & Body	person-role	fully-qualified
🧑‍🍳	cook	1F9D1 200D 1F373	People & Body	person-role	fully-qualified
🧑🏻‍🍳	cook: light skin tone	1F9D1 1F3FB 200D 1F373	People & Body	person-role	fully-qualified
🧑🏼‍🍳	cook: medium-light skin tone	1F9D1 1F3FC 200D 1F373	People & Body	person-role	fully-qualified
🧑🏽‍🍳	cook: medium skin tone	1F9D1 1F3FD 200D 1F373	People & Body	person-role	fully-qualified
🧑🏾‍🍳	cook: medium-dark skin tone	1F9D1 1F3FE 200D 1F373	People & Body	person-role	fully-qualified
🧑🏿‍🍳	cook: dark skin tone	1F9D1 1F3FF 200D 1F373	People & Body	person-role	fully-qualified
👨‍🍳	man cook	1F468 200D 1F373	People & Body	person-role	fully-qualified
👨🏻‍🍳	man cook: light skin tone	1F468 1F3FB 200D 1F373	People & Body	person-role	fully-qualified
👨🏼‍🍳	man cook: medium-light skin tone	1F468 1F3FC 200D 1F373	People & Body	person-role	fully-qualified
👨🏽‍🍳	man cook: medium skin tone	1F468 1F3FD 200D 1F373	People & Body	person-role	fully-qualified
👨🏾‍🍳	man cook: medium-dark skin tone	1F468 1F3FE 200D 1F373	People & Body	person-role	fully-qualified
👨🏿‍🍳	man cook: dark skin tone	1F468 1F3FF 200D 1F373	People & Body	person-role	fully-qualified
👩‍🍳	woman cook	1F469 200D 1F373	People & Body	person-role	fully-qualified
👩🏻‍🍳	woman cook: light skin tone	1F469 1F3FB 200D 1F373	People & Body	person-role	fully-qualified
👩🏼‍🍳	woman cook: medium-light skin tone	1F469 1F3FC 200D 1F373	People & Body	person-role	fully-qualified
👩🏽‍🍳	woman cook: medium skin tone	1F469 1F3FD 200D 1F373	People & Body	person-role	fully-qualified
👩🏾‍🍳	woman cook: medium-dark skin tone	1F469 1F3FE 200D 1F373	People & Body	person-role	fully-qualified
👩🏿‍🍳	woman cook: dark skin tone	1F469 1F3FF 200D 1F373	People & Body	person-role	fully-qualified
🧑‍🔧	mechanic	1F9D1 200D 1F527	People & Body	person-role	fully-qualified
🧑🏻‍🔧	mechanic: light skin tone	1F9D1 1F3FB 200D 1F527	People & Body	person-role	fully-qualified
🧑🏼‍🔧	mechanic: medium-light skin tone	1F9D1 1F3FC 200D 1F527	People & Body	person-role	fully-qualified
🧑🏽‍🔧	mechanic: medium skin tone	1F9D1 1F3FD 200D 1F527	People & Body	person-role	fully-qualified
🧑🏾‍🔧	mechanic: medium-dark skin tone	1F9D1 1F3FE 200D 1F527	People & Body	person-role	fully-qualified
🧑🏿‍🔧	mechanic: dark skin tone	1F9D1 1F3FF 200D 1F527	People & Body	person-role	fully-qualified
👨‍🔧	man mechanic	1F468 200D 1F527	People & Body	person-role	fully-qualified
👨🏻‍🔧	man mechanic: light skin tone	1F468 1F3FB 200D 1F527	People & Body	person-role	fully-qualified
👨🏼‍🔧	man mechanic: medium-light skin tone	1F468 1F3FC 200D 1F527	People & Body	person-role	fully-qualified
👨🏽‍🔧	man mechanic: medium skin tone	1F468 1F3FD 200D 1F527	People & Body	person-role	fully-qualified
👨🏾‍🔧	man mechanic: medium-dark skin tone	1F468 1F3FE 200D 1F527	People & Body	person-role	fully-qualified
👨🏿‍🔧	man mechanic: dark skin tone	1F468 1F3FF 200D 1F527	People & Body	person-role	fully-qualified
👩‍🔧	woman mechanic	1F469 200D 1F527	People & Body	person-role	fully-qualified
👩🏻‍🔧	woman mechanic: light skin tone	1F469 1F3FB 200D 1F527	People & Body	person-role	fully-qualified
👩🏼‍🔧	woman mechanic: medium-light skin tone	1F469 1F3FC 200D 1F527	People & Body	person-role	fully-qualified
👩🏽‍🔧	woman mechanic: medium skin tone	1F469 1F3FD 200D 1F527	People & Body	person-role	fully-qualified
👩🏾‍🔧	woman mechanic: medium-dark skin tone	1F469 1F3FE 200D 1F527	People & Body	person-role	fully-qualified
👩🏿‍🔧	woman mechanic: dark skin tone	1F469 1F3FF 200D 1F527	People & Body	person-role	fully-qualified
🧑‍🏭	factory worker	1F9D1 200D 1F3ED	People & Body	person-role	fully-qualified
🧑🏻‍🏭	factory worker: light skin tone	1F9D1 1F3FB 200D 1F3ED	People & Body	person-role	fully-qualified
🧑🏼‍🏭	factory worker: medium-light skin tone	1F9D1 1F3FC 200D 1F3ED	People & Body	person-role	fully-qualified
🧑🏽‍🏭	factory worker: medium skin tone	1F9D1 1F3FD 200D 1F3ED	People & Body	person-role	fully-qualified
🧑🏾‍🏭	factory worker: medium-dark skin tone	1F9D1 1F3FE 200D 1F3ED	People & Body	person-role	fully-qualified
🧑🏿‍🏭	factory worker: dark skin tone	1F9D1 1F3FF 200D 1F3ED	People & Body	person-role	fully-qualified
👨‍🏭	man factory worker	1F468 200D 1F3ED	People & Body	person-role	fully-qualified
👨🏻‍🏭	man factory worker: light skin tone	1F468 1F3FB 200D 1F3ED	People & Body	person-role	fully-qualified
👨🏼‍🏭	man factory worker: medium-light skin tone	1F468 1F3FC 200D 1F3ED	People & Body	person-role	fully-qualified
👨🏽‍🏭	man factory worker: medium skin tone	1F468 1F3FD 200D 1F3ED	People & Body	person-role	fully-qualified
👨🏾‍🏭	man factory worker: medium-dark skin tone	1F468 1F3FE 200D 1F3ED	People & Body	person-role	fully-qualified
👨🏿‍🏭	man factory worker: dark skin tone	1F468 1F3FF 200D 1F3ED	People & Body	person-role	fully-qualified
👩‍🏭	woman factory worker	1F469 200D 1F3ED	People & Body	person-role	fully-qualified
👩🏻‍🏭	woman factory worker: light skin tone	1F469 1F3FB 200D 1F3ED	People & Body	person-role	fully-qualified
👩🏼‍🏭	woman factory worker: medium-light skin tone	1F469 1F3FC 200D 1F3ED	People & Body	person-role	fully-qualified
👩🏽‍🏭	woman factory worker: medium skin tone	1F469 1F3FD 200D 1F3ED	People & Body	person-role	fully-qualified
👩🏾‍🏭	woman factory worker: medium-dark skin tone	1F469 1F3FE 200D 1F3ED	People & Body	person-role	fully-qualified
👩🏿‍🏭	woman factory worker: dark skin tone	1F469 1F3FF 200D 1F3ED	People & Body	person-role	fully-qualified
🧑‍💼	office worker	1F9D1 200D 1F4BC	People & Body	person-role	fully-qualified
🧑🏻‍💼	office worker: light skin tone	1F9D1 1F3FB 200D 1F4BC	People & Body	person-role	fully-qualified
🧑🏼‍💼	office worker: medium-light skin tone	1F9D1 1F3FC 200D 1F4BC	People & Body	person-role	fully-qualified
🧑🏽‍💼	office worker: medium skin tone	1F9D1 1F3FD 200D 1F4BC	People & Body	person-role	fully-qualified
🧑🏾‍💼	office worker: medium-dark skin tone	1F9D1 1F3FE 200D 1F4BC	People & Body	person-role	fully-qualified
🧑🏿‍💼	office worker: dark skin tone	1F9D1 1F3FF 200D 1F4BC	People & Body	person-role	fully-qualified
👨‍💼	man office worker	1F468 200D 1F4BC	People & Body	person-role	fully-qualified
👨🏻‍💼	man office worker: light skin tone	1F468 1F3FB 200D 1F4BC	People & Body	person-role	fully-qualified
👨🏼‍💼	man office worker: medium-light skin tone	1F468 1F3FC 200D 1F4BC	People & Body	person-role	fully-qualified
👨🏽‍💼	man office worker: medium skin tone	1F468 1F3FD 200D 1F4BC	People & Body	person-role	fully-qualified
👨🏾‍💼	man office worker: medium-dark skin tone	1F468 1F3FE 200D 1F4BC	People & Body	person-role	fully-qualified
👨🏿‍💼	man office worker: dark skin tone	1F468 1F3FF 200D 1F4BC	People & Body	person-role	fully-qualified
👩‍💼	woman office worker	1F469 200D 1F4BC	People & Body	person-role	fully-qualified
👩🏻‍💼	woman office worker: light skin tone	1F469 1F3FB 200D 1F4BC	People & Body	person-role	fully-qualified
👩🏼‍💼	woman office worker: medium-light skin tone	1F469 1F3FC 200D 1F4BC	People & Body	person-role	fully-qualified
👩🏽‍💼	woman office worker: medium skin tone	1F469 1F3FD 200D 1F4BC	People & Body	person-role	fully-qualified
👩🏾‍💼	woman office worker: medium-dark skin tone	1F469 1F3FE 200D 1F4BC	People & Body	person-role	fully-qualified
👩🏿‍💼	woman office worker: dark skin tone	1F469 1F3FF 200D 1F4BC	People & Body	person-role	fully-qualified
🧑‍🔬	scientist	1F9D1 200D 1F52C	People & Body	person-role	fully-qualified
🧑🏻‍🔬	scientist: light skin tone	1F9D1 1F3FB 200D 1F52C	People & Body	person-role	fully-qualified
🧑🏼‍🔬	scientist: medium-light skin tone	1F9D1 1F3FC 200D 1F52C	People & Body	person-role	fully-qualified
🧑🏽‍🔬	scientist: medium skin tone	1F9D1 1F3FD 200D 1F52C	People & Body	person-role	fully-qualified
🧑🏾‍🔬	scientist: medium-dark skin tone	1F9D1 1F3FE 200D 1F52C	People & Body	person-role	fully-qualified
🧑🏿‍🔬	scientist: dark skin tone	1F9D1 1F3FF 200D 1F52C	People & Body	person-role	fully-qualified
👨‍🔬	man scientist	1F468 200D 1F52C	People & Body	person-role	fully-qualified
👨🏻‍🔬	man scientist: light skin tone	1F468 1F3FB 200D 1F52C	People & Body	person-role	fully-qualified
👨🏼‍🔬	man scientist: medium-light skin tone	1F468 1F3FC 200D 1F52C	People & Body	person-role	fully-qualified
👨🏽‍🔬	man scientist: medium skin tone	1F468 1F3FD 200D 1F52C	People & Body	person-role	fully-qualified
👨🏾‍🔬	man scientist: medium-dark skin tone	1F468 1F3FE 200D 1F52C	People & Body	person-role	fully-qualified
👨🏿‍🔬	man scientist: dark skin tone	1F468 1F3FF 200D 1F52C	People & Body	person-role	fully-qualified
👩‍🔬	woman scientist	1F469 200D 1F52C	People & Body	person-role	fully-qualified
👩🏻‍🔬	woman scientist: light skin tone	1F469 1F3FB 200D 1F52C	People & Body	person-role	fully-qualified
👩🏼‍🔬	woman scientist: medium-light skin tone	1F469 1F3FC 200D 1F52C	People & Body	person-role	fully-qualified
👩🏽‍🔬	woman scientist: medium skin tone	1F469 1F3FD 200D 1F52C	People & Body	person-role	fully-qualified
👩🏾‍🔬	woman scientist: medium-dark skin tone	1F469 1F3FE 200D 1F52C	People & Body	person-role	fully-qualified
👩🏿‍🔬	woman scientist: dark skin tone	1F469 1F3FF 200D 1F52C	People & Body	person-role	fully-qualified
🧑‍💻	technologist	1F9D1 200D 1F4BB	People & Body	person-role	fully-qualified
🧑🏻‍💻	technologist: light skin tone	1F9D1 1F3FB 200D 1F4BB	People & Body	person-role	fully-qualified
🧑🏼‍💻	technologist: medium-light skin tone	1F9D1 1F3FC 200D 1F4BB	People & Body	person-role	fully-qualified
🧑🏽‍💻	technologist: medium skin tone	1F9D1 1F3FD 200D 1F4BB	People & Body	person-role	fully-qualified
🧑🏾‍💻	technologist: medium-dark skin tone	1F9D1 1F3FE 200D 1F4BB	People & Body	person-role	fully-qualified
🧑🏿‍💻	technologist: dark skin tone	1F9D1 1F3FF 200D 1F4BB	People & Body	person-role	fully-qualified
👨‍💻	man technologist	1F468 200D 1F4BB	People & Body	person-role	fully-qualified
👨🏻‍💻	man technologist: light skin tone	1F468 1F3FB 200D 1F4BB	People & Body	person-role	fully-qualified
👨🏼‍💻	man technologist: medium-light skin tone	1F468 1F3FC 200D 1F4BB	People & Body	person-role	fully-qualified
👨🏽‍💻	man technologist: medium skin tone	1F468 1F3FD 200D 1F4BB	People & Body	person-role	fully-qualified
👨🏾‍💻	man technologist: medium-dark skin tone	1F468 1F3FE 200D 1F4BB	People & Body	person-role	fully-qualified
👨🏿‍💻	man technologist: dark skin tone	1F468 1F3FF 200D 1F4BB	People & Body	person-role	fully-qualified
👩‍💻	woman technologist	1F469 200D 1F4BB	People & Body	person-role	fully-qualified
👩🏻‍💻	woman technologist: light skin tone	1F469 1F3FB 200D 1F4BB	People & Body	person-role	fully-qualified
👩🏼‍💻	woman technologist: medium-light skin tone	1F469 1F3FC 200D 1F4BB	People & Body	person-role	fully-qualified
👩🏽‍💻	woman technologist: medium skin tone	1F469 1F3FD 200D 1F4BB	People & Body	person-role	fully-qualified
👩🏾‍💻	woman technologist: medium-dark skin tone	1F469 1F3FE 200D 1F4BB	People & Body	person-role	fully-qualified
👩🏿‍💻	woman technologist: dark skin tone	1F469 1F3FF 200D 1F4BB	People & Body	person-role	fully-qualified
🧑‍🎤	singer	1F9D1 200D 1F3A4	People & Body	person-role	fully-qualified
🧑🏻‍🎤	singer: light skin tone	1F9D1 1F3FB 200D 1F3A4	People & Body	person-role	fully-qualified
🧑🏼‍🎤	singer: medium-light skin tone	1F9D1 1F3FC 200D 1F3A4	People & Body	person-role	fully-qualified
🧑🏽‍🎤	singer: medium skin tone	1F9D1 1F3FD 200D 1F3A4	People & Body	person-role	fully-qualified
🧑🏾‍🎤	singer: medium-dark skin tone	1F9D1 1F3FE 200D 1F3A4	People & Body	person-role	fully-qualified
🧑🏿‍🎤	singer: dark skin tone	1F9D1 1F3FF 200D 1F3A4	People & Body	person-role	fully-qualified
👨‍🎤	man singer	1F468 200D 1F3A4	People & Body	person-role	fully-qualified
👨🏻‍🎤	man singer: light skin tone	1F468 1F3FB 200D 1F3A4	People & Body	person-role	fully-qualified
👨🏼‍🎤	man singer: medium-light skin tone	1F468 1F3FC 200D 1F3A4	People & Body	person-role	fully-qualified
👨🏽‍🎤	man singer: medium skin tone	1F468 1F3FD 200D 1F3A4	People & Body	person-role	fully-qualified
👨🏾‍🎤	man singer: medium-dark skin tone	1F468 1F3FE 200D 1F3A4	People & Body	person-role	fully-qualified
👨🏿‍🎤	man singer: dark skin tone	1F468 1F3FF 200D 1F3A4	People & Body	person-role	fully-qualified
👩‍🎤	woman singer	1F469 200D 1F3A4	People & Body	person-role	fully-qualified
👩🏻‍🎤	woman singer: light skin tone	1F469 1F3FB 200D 1F3A4	People & Body	person-role	fully-qualified
👩🏼‍🎤	woman singer: medium-light skin tone	1F469 1F3FC 200D 1F3A4	People & Body	person-role	fully-qualified
👩🏽‍🎤	woman singer: medium skin tone	1F469 1F3FD 200D 1F3A4	People & Body	person-role	fully-qualified
👩🏾‍🎤	woman singer: medium-dark skin tone	1F469 1F3FE 200D 1F3A4	People & Body	person-role	fully-qualified
👩🏿‍🎤	woman singer: dark skin tone	1F469 1F3FF 200D 1F3A4	People & Body	person-role	fully-qualified
🧑‍🎨	artist	1F9D1 200D 1F3A8	People & Body	person-role	fully-qualified
🧑🏻‍🎨	artist: light skin tone	1F9D1 1F3FB 200D 1F3A8	People & Body	person-role	fully-qualified
🧑🏼‍🎨	artist: medium-light skin tone	1F9D1 1F3FC 200D 1F3A8	People & Body	person-role	fully-qualified
🧑🏽‍🎨	artist: medium skin tone	1F9D1 1F3FD 200D 1F3A8	People & Body	person-role	fully-qualified
🧑🏾‍🎨	artist: medium-dark skin tone	1F9D1 1F3FE 200D 1F3A8	People & Body	person-role	fully-qualified
🧑🏿‍🎨	artist: dark skin tone	1F9D1 1F3FF 200D 1F3A8	People & Body	person-role	fully-qualified
👨‍🎨	man artist	1F468 200D 1F3A8	People & Body	person-role	fully-qualified
👨🏻‍🎨	man artist: light skin tone	1F468 1F3FB 200D 1F3A8	People & Body	person-role	fully-qualified
👨🏼‍🎨	man artist: medium-light skin tone	1F468 1F3FC 200D 1F3A8	People & Body	person-role	fully-qualified
👨🏽‍🎨	man artist: medium skin tone	1F468 1F3FD 200D 1F3A8	People & Body	person-role	fully-qualified
👨🏾‍🎨	man artist: medium-dark skin tone	1F468 1F3FE 200D 1F3A8	People & Body	person-role	fully-qualified
👨🏿‍🎨	man artist: dark skin tone	1F468 1F3FF 200D 1F3A8	People & Body	person-role	fully-qualified
👩‍🎨	woman artist	1F469 200D 1F3A8	People & Body	person-role	fully-qualified
👩🏻‍🎨	woman artist: light skin tone	1F469 1F3FB 200D 1F3A8	People & Body	person-role	fully-qualified
👩🏼‍🎨	woman artist: medium-light skin tone	1F469 1F3FC 200D 1F3A8	People & Body	person-role	fully-qualified
👩🏽‍🎨	woman artist: medium skin tone	1F469 1F3FD 200D 1F3A8	People & Body	person-role	fully-qualified
👩🏾‍🎨	woman artist: medium-dark skin tone	1F469 1F3FE 200D 1F3A8	People & Body	person-role	fully-qualified
👩🏿‍🎨	woman artist: dark skin tone	1F469 1F3FF 200D 1F3A8	People & Body	person-role	fully-qualified
🧑‍✈️	pilot	1F9D1 200D 2708 FE0F	People & Body	person-role	fully-qualified
🧑🏻‍✈️	pilot: light skin tone	1F9D1 1F3FB 200D 2708 FE0F	People & Body	person-role	fully-qualified
🧑🏼‍✈️	pilot: medium-light skin tone	1F9D1 1F3FC 200D 2708 FE0F	People & Body	person-role	fully-qualified
🧑🏽‍✈️	pilot: medium skin tone	1F9D1 1F3FD 200D 2708 FE0F	People & Body	person-role	fully-qualified
🧑🏾‍✈️	pilot: medium-dark skin tone	1F9D1 1F3FE 200D 2708 FE0F	People & Body	person-role	fully-qualified
🧑🏿‍✈️	pilot: dark skin tone	1F9D1 1F3FF 200D 2708 FE0F	People & Body	person-role	fully-qualified
👨‍✈️	man pilot	1F468 200D 2708 FE0F	People & Body	person-role	fully-qualified
👨🏻‍✈️	man pilot: light skin tone	1F468 1F3FB 200D 2708 FE0F	People & Body	person-role	fully-qualified
👨🏼‍✈️	man pilot: medium-light skin tone	1F468 1F3FC 200D 2708 FE0F	People & Body	person-role	fully-qualified
👨🏽‍✈️	man pilot: medium skin tone	1F468 1F3FD 200D 2708 FE0F	People & Body	person-role	fully-qualified
👨🏾‍✈️	man pilot: medium-dark skin tone	1F468 1F3FE 200D 2708 FE0F	People & Body	person-role	fully-qualified
👨🏿‍✈️	man pilot: dark skin tone	1F468 1F3FF 200D 2708 FE0F	People & Body	person-role	fully-qualified
👩‍✈️	woman pilot	1F469 200D 2708 FE0F	People & Body	person-role	fully-qualified
👩🏻‍✈️	woman pilot: light skin tone	1F469 1F3FB 200D 2708 FE0F	People & Body	person-role	fully-qualified
👩🏼‍✈️	woman pilot: medium-light skin tone	1F469 1F3FC 200D 2708 FE0F	People & Body	person-role	fully-qualified
👩🏽‍✈️	woman pilot: medium skin tone	1F469 1F3FD 200D 2708 FE0F	People & Body	person-role	fully-qualified
👩🏾‍✈️	woman pilot: medium-dark skin tone	1F469 1F3FE 200D 2708 FE0F	People & Body	person-role	fully-qualified
👩🏿‍✈️	woman pilot: dark skin tone	1F469 1F3FF 200D 2708 FE0F	People & Body	person-role	fully-qualified
🧑‍🚀	astronaut	1F9D1 200D 1F680	People & Body	person-role	fully-qualified
🧑🏻‍🚀	astronaut: light skin tone	1F9D1 1F3FB 200D 1F680	People & Body	person-role	fully-qualified
🧑🏼‍🚀	astronaut: medium-light skin tone	1F9D1 1F3FC 200D 1F680	People & Body	person-role	fully-qualified
🧑🏽‍🚀	astronaut: medium skin tone	1F9D1 1F3FD 200D 1F680	People & Body	person-role	fully-qualified
🧑🏾‍🚀	astronaut: medium-dark skin tone	1F9D1 1F3FE 200D 1F680	People & Body	person-role	fully-qualified
🧑🏿‍🚀	astronaut: dark skin tone	1F9D1 1F3FF 200D 1F680	People & Body	person-role	fully-qualified
👨‍🚀	man astronaut	1F468 200D 1F680	People & Body	person-role	fully-qualified
👨🏻‍🚀	man astronaut: light skin tone	1F468 1F3FB 200D 1F680	People & Body	person-role	fully-qualified
        """.trimIndent(),

        """
👨🏼‍🚀	man astronaut: medium-light skin tone	1F468 1F3FC 200D 1F680	People & Body	person-role	fully-qualified
👨🏽‍🚀	man astronaut: medium skin tone	1F468 1F3FD 200D 1F680	People & Body	person-role	fully-qualified
👨🏾‍🚀	man astronaut: medium-dark skin tone	1F468 1F3FE 200D 1F680	People & Body	person-role	fully-qualified
👨🏿‍🚀	man astronaut: dark skin tone	1F468 1F3FF 200D 1F680	People & Body	person-role	fully-qualified
👩‍🚀	woman astronaut	1F469 200D 1F680	People & Body	person-role	fully-qualified
👩🏻‍🚀	woman astronaut: light skin tone	1F469 1F3FB 200D 1F680	People & Body	person-role	fully-qualified
👩🏼‍🚀	woman astronaut: medium-light skin tone	1F469 1F3FC 200D 1F680	People & Body	person-role	fully-qualified
👩🏽‍🚀	woman astronaut: medium skin tone	1F469 1F3FD 200D 1F680	People & Body	person-role	fully-qualified
👩🏾‍🚀	woman astronaut: medium-dark skin tone	1F469 1F3FE 200D 1F680	People & Body	person-role	fully-qualified
👩🏿‍🚀	woman astronaut: dark skin tone	1F469 1F3FF 200D 1F680	People & Body	person-role	fully-qualified
🧑‍🚒	firefighter	1F9D1 200D 1F692	People & Body	person-role	fully-qualified
🧑🏻‍🚒	firefighter: light skin tone	1F9D1 1F3FB 200D 1F692	People & Body	person-role	fully-qualified
🧑🏼‍🚒	firefighter: medium-light skin tone	1F9D1 1F3FC 200D 1F692	People & Body	person-role	fully-qualified
🧑🏽‍🚒	firefighter: medium skin tone	1F9D1 1F3FD 200D 1F692	People & Body	person-role	fully-qualified
🧑🏾‍🚒	firefighter: medium-dark skin tone	1F9D1 1F3FE 200D 1F692	People & Body	person-role	fully-qualified
🧑🏿‍🚒	firefighter: dark skin tone	1F9D1 1F3FF 200D 1F692	People & Body	person-role	fully-qualified
👨‍🚒	man firefighter	1F468 200D 1F692	People & Body	person-role	fully-qualified
👨🏻‍🚒	man firefighter: light skin tone	1F468 1F3FB 200D 1F692	People & Body	person-role	fully-qualified
👨🏼‍🚒	man firefighter: medium-light skin tone	1F468 1F3FC 200D 1F692	People & Body	person-role	fully-qualified
👨🏽‍🚒	man firefighter: medium skin tone	1F468 1F3FD 200D 1F692	People & Body	person-role	fully-qualified
👨🏾‍🚒	man firefighter: medium-dark skin tone	1F468 1F3FE 200D 1F692	People & Body	person-role	fully-qualified
👨🏿‍🚒	man firefighter: dark skin tone	1F468 1F3FF 200D 1F692	People & Body	person-role	fully-qualified
👩‍🚒	woman firefighter	1F469 200D 1F692	People & Body	person-role	fully-qualified
👩🏻‍🚒	woman firefighter: light skin tone	1F469 1F3FB 200D 1F692	People & Body	person-role	fully-qualified
👩🏼‍🚒	woman firefighter: medium-light skin tone	1F469 1F3FC 200D 1F692	People & Body	person-role	fully-qualified
👩🏽‍🚒	woman firefighter: medium skin tone	1F469 1F3FD 200D 1F692	People & Body	person-role	fully-qualified
👩🏾‍🚒	woman firefighter: medium-dark skin tone	1F469 1F3FE 200D 1F692	People & Body	person-role	fully-qualified
👩🏿‍🚒	woman firefighter: dark skin tone	1F469 1F3FF 200D 1F692	People & Body	person-role	fully-qualified
👮	police officer	1F46E	People & Body	person-role	fully-qualified
👮🏻	police officer: light skin tone	1F46E 1F3FB	People & Body	person-role	fully-qualified
👮🏼	police officer: medium-light skin tone	1F46E 1F3FC	People & Body	person-role	fully-qualified
👮🏽	police officer: medium skin tone	1F46E 1F3FD	People & Body	person-role	fully-qualified
👮🏾	police officer: medium-dark skin tone	1F46E 1F3FE	People & Body	person-role	fully-qualified
👮🏿	police officer: dark skin tone	1F46E 1F3FF	People & Body	person-role	fully-qualified
👮‍♂️	man police officer	1F46E 200D 2642 FE0F	People & Body	person-role	fully-qualified
👮🏻‍♂️	man police officer: light skin tone	1F46E 1F3FB 200D 2642 FE0F	People & Body	person-role	fully-qualified
👮🏼‍♂️	man police officer: medium-light skin tone	1F46E 1F3FC 200D 2642 FE0F	People & Body	person-role	fully-qualified
👮🏽‍♂️	man police officer: medium skin tone	1F46E 1F3FD 200D 2642 FE0F	People & Body	person-role	fully-qualified
👮🏾‍♂️	man police officer: medium-dark skin tone	1F46E 1F3FE 200D 2642 FE0F	People & Body	person-role	fully-qualified
👮🏿‍♂️	man police officer: dark skin tone	1F46E 1F3FF 200D 2642 FE0F	People & Body	person-role	fully-qualified
👮‍♀️	woman police officer	1F46E 200D 2640 FE0F	People & Body	person-role	fully-qualified
👮🏻‍♀️	woman police officer: light skin tone	1F46E 1F3FB 200D 2640 FE0F	People & Body	person-role	fully-qualified
👮🏼‍♀️	woman police officer: medium-light skin tone	1F46E 1F3FC 200D 2640 FE0F	People & Body	person-role	fully-qualified
👮🏽‍♀️	woman police officer: medium skin tone	1F46E 1F3FD 200D 2640 FE0F	People & Body	person-role	fully-qualified
👮🏾‍♀️	woman police officer: medium-dark skin tone	1F46E 1F3FE 200D 2640 FE0F	People & Body	person-role	fully-qualified
👮🏿‍♀️	woman police officer: dark skin tone	1F46E 1F3FF 200D 2640 FE0F	People & Body	person-role	fully-qualified
🕵️	detective	1F575 FE0F	People & Body	person-role	fully-qualified
🕵🏻	detective: light skin tone	1F575 1F3FB	People & Body	person-role	fully-qualified
🕵🏼	detective: medium-light skin tone	1F575 1F3FC	People & Body	person-role	fully-qualified
🕵🏽	detective: medium skin tone	1F575 1F3FD	People & Body	person-role	fully-qualified
🕵🏾	detective: medium-dark skin tone	1F575 1F3FE	People & Body	person-role	fully-qualified
🕵🏿	detective: dark skin tone	1F575 1F3FF	People & Body	person-role	fully-qualified
🕵️‍♂️	man detective	1F575 FE0F 200D 2642 FE0F	People & Body	person-role	fully-qualified
🕵🏻‍♂️	man detective: light skin tone	1F575 1F3FB 200D 2642 FE0F	People & Body	person-role	fully-qualified
🕵🏼‍♂️	man detective: medium-light skin tone	1F575 1F3FC 200D 2642 FE0F	People & Body	person-role	fully-qualified
🕵🏽‍♂️	man detective: medium skin tone	1F575 1F3FD 200D 2642 FE0F	People & Body	person-role	fully-qualified
🕵🏾‍♂️	man detective: medium-dark skin tone	1F575 1F3FE 200D 2642 FE0F	People & Body	person-role	fully-qualified
🕵🏿‍♂️	man detective: dark skin tone	1F575 1F3FF 200D 2642 FE0F	People & Body	person-role	fully-qualified
🕵️‍♀️	woman detective	1F575 FE0F 200D 2640 FE0F	People & Body	person-role	fully-qualified
🕵🏻‍♀️	woman detective: light skin tone	1F575 1F3FB 200D 2640 FE0F	People & Body	person-role	fully-qualified
🕵🏼‍♀️	woman detective: medium-light skin tone	1F575 1F3FC 200D 2640 FE0F	People & Body	person-role	fully-qualified
🕵🏽‍♀️	woman detective: medium skin tone	1F575 1F3FD 200D 2640 FE0F	People & Body	person-role	fully-qualified
🕵🏾‍♀️	woman detective: medium-dark skin tone	1F575 1F3FE 200D 2640 FE0F	People & Body	person-role	fully-qualified
🕵🏿‍♀️	woman detective: dark skin tone	1F575 1F3FF 200D 2640 FE0F	People & Body	person-role	fully-qualified
💂	guard	1F482	People & Body	person-role	fully-qualified
💂🏻	guard: light skin tone	1F482 1F3FB	People & Body	person-role	fully-qualified
💂🏼	guard: medium-light skin tone	1F482 1F3FC	People & Body	person-role	fully-qualified
💂🏽	guard: medium skin tone	1F482 1F3FD	People & Body	person-role	fully-qualified
💂🏾	guard: medium-dark skin tone	1F482 1F3FE	People & Body	person-role	fully-qualified
💂🏿	guard: dark skin tone	1F482 1F3FF	People & Body	person-role	fully-qualified
💂‍♂️	man guard	1F482 200D 2642 FE0F	People & Body	person-role	fully-qualified
💂🏻‍♂️	man guard: light skin tone	1F482 1F3FB 200D 2642 FE0F	People & Body	person-role	fully-qualified
💂🏼‍♂️	man guard: medium-light skin tone	1F482 1F3FC 200D 2642 FE0F	People & Body	person-role	fully-qualified
💂🏽‍♂️	man guard: medium skin tone	1F482 1F3FD 200D 2642 FE0F	People & Body	person-role	fully-qualified
💂🏾‍♂️	man guard: medium-dark skin tone	1F482 1F3FE 200D 2642 FE0F	People & Body	person-role	fully-qualified
💂🏿‍♂️	man guard: dark skin tone	1F482 1F3FF 200D 2642 FE0F	People & Body	person-role	fully-qualified
💂‍♀️	woman guard	1F482 200D 2640 FE0F	People & Body	person-role	fully-qualified
💂🏻‍♀️	woman guard: light skin tone	1F482 1F3FB 200D 2640 FE0F	People & Body	person-role	fully-qualified
💂🏼‍♀️	woman guard: medium-light skin tone	1F482 1F3FC 200D 2640 FE0F	People & Body	person-role	fully-qualified
💂🏽‍♀️	woman guard: medium skin tone	1F482 1F3FD 200D 2640 FE0F	People & Body	person-role	fully-qualified
💂🏾‍♀️	woman guard: medium-dark skin tone	1F482 1F3FE 200D 2640 FE0F	People & Body	person-role	fully-qualified
💂🏿‍♀️	woman guard: dark skin tone	1F482 1F3FF 200D 2640 FE0F	People & Body	person-role	fully-qualified
🥷	ninja	1F977	People & Body	person-role	fully-qualified
🥷🏻	ninja: light skin tone	1F977 1F3FB	People & Body	person-role	fully-qualified
🥷🏼	ninja: medium-light skin tone	1F977 1F3FC	People & Body	person-role	fully-qualified
🥷🏽	ninja: medium skin tone	1F977 1F3FD	People & Body	person-role	fully-qualified
🥷🏾	ninja: medium-dark skin tone	1F977 1F3FE	People & Body	person-role	fully-qualified
🥷🏿	ninja: dark skin tone	1F977 1F3FF	People & Body	person-role	fully-qualified
👷	construction worker	1F477	People & Body	person-role	fully-qualified
👷🏻	construction worker: light skin tone	1F477 1F3FB	People & Body	person-role	fully-qualified
👷🏼	construction worker: medium-light skin tone	1F477 1F3FC	People & Body	person-role	fully-qualified
👷🏽	construction worker: medium skin tone	1F477 1F3FD	People & Body	person-role	fully-qualified
👷🏾	construction worker: medium-dark skin tone	1F477 1F3FE	People & Body	person-role	fully-qualified
👷🏿	construction worker: dark skin tone	1F477 1F3FF	People & Body	person-role	fully-qualified
👷‍♂️	man construction worker	1F477 200D 2642 FE0F	People & Body	person-role	fully-qualified
👷🏻‍♂️	man construction worker: light skin tone	1F477 1F3FB 200D 2642 FE0F	People & Body	person-role	fully-qualified
👷🏼‍♂️	man construction worker: medium-light skin tone	1F477 1F3FC 200D 2642 FE0F	People & Body	person-role	fully-qualified
👷🏽‍♂️	man construction worker: medium skin tone	1F477 1F3FD 200D 2642 FE0F	People & Body	person-role	fully-qualified
👷🏾‍♂️	man construction worker: medium-dark skin tone	1F477 1F3FE 200D 2642 FE0F	People & Body	person-role	fully-qualified
👷🏿‍♂️	man construction worker: dark skin tone	1F477 1F3FF 200D 2642 FE0F	People & Body	person-role	fully-qualified
👷‍♀️	woman construction worker	1F477 200D 2640 FE0F	People & Body	person-role	fully-qualified
👷🏻‍♀️	woman construction worker: light skin tone	1F477 1F3FB 200D 2640 FE0F	People & Body	person-role	fully-qualified
👷🏼‍♀️	woman construction worker: medium-light skin tone	1F477 1F3FC 200D 2640 FE0F	People & Body	person-role	fully-qualified
👷🏽‍♀️	woman construction worker: medium skin tone	1F477 1F3FD 200D 2640 FE0F	People & Body	person-role	fully-qualified
👷🏾‍♀️	woman construction worker: medium-dark skin tone	1F477 1F3FE 200D 2640 FE0F	People & Body	person-role	fully-qualified
👷🏿‍♀️	woman construction worker: dark skin tone	1F477 1F3FF 200D 2640 FE0F	People & Body	person-role	fully-qualified
🫅	person with crown	1FAC5	People & Body	person-role	fully-qualified
🫅🏻	person with crown: light skin tone	1FAC5 1F3FB	People & Body	person-role	fully-qualified
🫅🏼	person with crown: medium-light skin tone	1FAC5 1F3FC	People & Body	person-role	fully-qualified
🫅🏽	person with crown: medium skin tone	1FAC5 1F3FD	People & Body	person-role	fully-qualified
🫅🏾	person with crown: medium-dark skin tone	1FAC5 1F3FE	People & Body	person-role	fully-qualified
🫅🏿	person with crown: dark skin tone	1FAC5 1F3FF	People & Body	person-role	fully-qualified
🤴	prince	1F934	People & Body	person-role	fully-qualified
🤴🏻	prince: light skin tone	1F934 1F3FB	People & Body	person-role	fully-qualified
🤴🏼	prince: medium-light skin tone	1F934 1F3FC	People & Body	person-role	fully-qualified
🤴🏽	prince: medium skin tone	1F934 1F3FD	People & Body	person-role	fully-qualified
🤴🏾	prince: medium-dark skin tone	1F934 1F3FE	People & Body	person-role	fully-qualified
🤴🏿	prince: dark skin tone	1F934 1F3FF	People & Body	person-role	fully-qualified
👸	princess	1F478	People & Body	person-role	fully-qualified
👸🏻	princess: light skin tone	1F478 1F3FB	People & Body	person-role	fully-qualified
👸🏼	princess: medium-light skin tone	1F478 1F3FC	People & Body	person-role	fully-qualified
👸🏽	princess: medium skin tone	1F478 1F3FD	People & Body	person-role	fully-qualified
👸🏾	princess: medium-dark skin tone	1F478 1F3FE	People & Body	person-role	fully-qualified
👸🏿	princess: dark skin tone	1F478 1F3FF	People & Body	person-role	fully-qualified
👳	person wearing turban	1F473	People & Body	person-role	fully-qualified
👳🏻	person wearing turban: light skin tone	1F473 1F3FB	People & Body	person-role	fully-qualified
👳🏼	person wearing turban: medium-light skin tone	1F473 1F3FC	People & Body	person-role	fully-qualified
👳🏽	person wearing turban: medium skin tone	1F473 1F3FD	People & Body	person-role	fully-qualified
👳🏾	person wearing turban: medium-dark skin tone	1F473 1F3FE	People & Body	person-role	fully-qualified
👳🏿	person wearing turban: dark skin tone	1F473 1F3FF	People & Body	person-role	fully-qualified
👳‍♂️	man wearing turban	1F473 200D 2642 FE0F	People & Body	person-role	fully-qualified
👳🏻‍♂️	man wearing turban: light skin tone	1F473 1F3FB 200D 2642 FE0F	People & Body	person-role	fully-qualified
👳🏼‍♂️	man wearing turban: medium-light skin tone	1F473 1F3FC 200D 2642 FE0F	People & Body	person-role	fully-qualified
👳🏽‍♂️	man wearing turban: medium skin tone	1F473 1F3FD 200D 2642 FE0F	People & Body	person-role	fully-qualified
👳🏾‍♂️	man wearing turban: medium-dark skin tone	1F473 1F3FE 200D 2642 FE0F	People & Body	person-role	fully-qualified
👳🏿‍♂️	man wearing turban: dark skin tone	1F473 1F3FF 200D 2642 FE0F	People & Body	person-role	fully-qualified
👳‍♀️	woman wearing turban	1F473 200D 2640 FE0F	People & Body	person-role	fully-qualified
👳🏻‍♀️	woman wearing turban: light skin tone	1F473 1F3FB 200D 2640 FE0F	People & Body	person-role	fully-qualified
👳🏼‍♀️	woman wearing turban: medium-light skin tone	1F473 1F3FC 200D 2640 FE0F	People & Body	person-role	fully-qualified
👳🏽‍♀️	woman wearing turban: medium skin tone	1F473 1F3FD 200D 2640 FE0F	People & Body	person-role	fully-qualified
👳🏾‍♀️	woman wearing turban: medium-dark skin tone	1F473 1F3FE 200D 2640 FE0F	People & Body	person-role	fully-qualified
👳🏿‍♀️	woman wearing turban: dark skin tone	1F473 1F3FF 200D 2640 FE0F	People & Body	person-role	fully-qualified
👲	person with skullcap	1F472	People & Body	person-role	fully-qualified
👲🏻	person with skullcap: light skin tone	1F472 1F3FB	People & Body	person-role	fully-qualified
👲🏼	person with skullcap: medium-light skin tone	1F472 1F3FC	People & Body	person-role	fully-qualified
👲🏽	person with skullcap: medium skin tone	1F472 1F3FD	People & Body	person-role	fully-qualified
👲🏾	person with skullcap: medium-dark skin tone	1F472 1F3FE	People & Body	person-role	fully-qualified
👲🏿	person with skullcap: dark skin tone	1F472 1F3FF	People & Body	person-role	fully-qualified
🧕	woman with headscarf	1F9D5	People & Body	person-role	fully-qualified
🧕🏻	woman with headscarf: light skin tone	1F9D5 1F3FB	People & Body	person-role	fully-qualified
🧕🏼	woman with headscarf: medium-light skin tone	1F9D5 1F3FC	People & Body	person-role	fully-qualified
🧕🏽	woman with headscarf: medium skin tone	1F9D5 1F3FD	People & Body	person-role	fully-qualified
🧕🏾	woman with headscarf: medium-dark skin tone	1F9D5 1F3FE	People & Body	person-role	fully-qualified
🧕🏿	woman with headscarf: dark skin tone	1F9D5 1F3FF	People & Body	person-role	fully-qualified
🤵	person in tuxedo	1F935	People & Body	person-role	fully-qualified
🤵🏻	person in tuxedo: light skin tone	1F935 1F3FB	People & Body	person-role	fully-qualified
🤵🏼	person in tuxedo: medium-light skin tone	1F935 1F3FC	People & Body	person-role	fully-qualified
🤵🏽	person in tuxedo: medium skin tone	1F935 1F3FD	People & Body	person-role	fully-qualified
🤵🏾	person in tuxedo: medium-dark skin tone	1F935 1F3FE	People & Body	person-role	fully-qualified
🤵🏿	person in tuxedo: dark skin tone	1F935 1F3FF	People & Body	person-role	fully-qualified
🤵‍♂️	man in tuxedo	1F935 200D 2642 FE0F	People & Body	person-role	fully-qualified
🤵🏻‍♂️	man in tuxedo: light skin tone	1F935 1F3FB 200D 2642 FE0F	People & Body	person-role	fully-qualified
🤵🏼‍♂️	man in tuxedo: medium-light skin tone	1F935 1F3FC 200D 2642 FE0F	People & Body	person-role	fully-qualified
🤵🏽‍♂️	man in tuxedo: medium skin tone	1F935 1F3FD 200D 2642 FE0F	People & Body	person-role	fully-qualified
🤵🏾‍♂️	man in tuxedo: medium-dark skin tone	1F935 1F3FE 200D 2642 FE0F	People & Body	person-role	fully-qualified
🤵🏿‍♂️	man in tuxedo: dark skin tone	1F935 1F3FF 200D 2642 FE0F	People & Body	person-role	fully-qualified
🤵‍♀️	woman in tuxedo	1F935 200D 2640 FE0F	People & Body	person-role	fully-qualified
🤵🏻‍♀️	woman in tuxedo: light skin tone	1F935 1F3FB 200D 2640 FE0F	People & Body	person-role	fully-qualified
🤵🏼‍♀️	woman in tuxedo: medium-light skin tone	1F935 1F3FC 200D 2640 FE0F	People & Body	person-role	fully-qualified
🤵🏽‍♀️	woman in tuxedo: medium skin tone	1F935 1F3FD 200D 2640 FE0F	People & Body	person-role	fully-qualified
🤵🏾‍♀️	woman in tuxedo: medium-dark skin tone	1F935 1F3FE 200D 2640 FE0F	People & Body	person-role	fully-qualified
🤵🏿‍♀️	woman in tuxedo: dark skin tone	1F935 1F3FF 200D 2640 FE0F	People & Body	person-role	fully-qualified
👰	person with veil	1F470	People & Body	person-role	fully-qualified
👰🏻	person with veil: light skin tone	1F470 1F3FB	People & Body	person-role	fully-qualified
👰🏼	person with veil: medium-light skin tone	1F470 1F3FC	People & Body	person-role	fully-qualified
👰🏽	person with veil: medium skin tone	1F470 1F3FD	People & Body	person-role	fully-qualified
👰🏾	person with veil: medium-dark skin tone	1F470 1F3FE	People & Body	person-role	fully-qualified
👰🏿	person with veil: dark skin tone	1F470 1F3FF	People & Body	person-role	fully-qualified
👰‍♂️	man with veil	1F470 200D 2642 FE0F	People & Body	person-role	fully-qualified
👰🏻‍♂️	man with veil: light skin tone	1F470 1F3FB 200D 2642 FE0F	People & Body	person-role	fully-qualified
👰🏼‍♂️	man with veil: medium-light skin tone	1F470 1F3FC 200D 2642 FE0F	People & Body	person-role	fully-qualified
👰🏽‍♂️	man with veil: medium skin tone	1F470 1F3FD 200D 2642 FE0F	People & Body	person-role	fully-qualified
👰🏾‍♂️	man with veil: medium-dark skin tone	1F470 1F3FE 200D 2642 FE0F	People & Body	person-role	fully-qualified
👰🏿‍♂️	man with veil: dark skin tone	1F470 1F3FF 200D 2642 FE0F	People & Body	person-role	fully-qualified
👰‍♀️	woman with veil	1F470 200D 2640 FE0F	People & Body	person-role	fully-qualified
👰🏻‍♀️	woman with veil: light skin tone	1F470 1F3FB 200D 2640 FE0F	People & Body	person-role	fully-qualified
👰🏼‍♀️	woman with veil: medium-light skin tone	1F470 1F3FC 200D 2640 FE0F	People & Body	person-role	fully-qualified
👰🏽‍♀️	woman with veil: medium skin tone	1F470 1F3FD 200D 2640 FE0F	People & Body	person-role	fully-qualified
👰🏾‍♀️	woman with veil: medium-dark skin tone	1F470 1F3FE 200D 2640 FE0F	People & Body	person-role	fully-qualified
👰🏿‍♀️	woman with veil: dark skin tone	1F470 1F3FF 200D 2640 FE0F	People & Body	person-role	fully-qualified
🤰	pregnant woman	1F930	People & Body	person-role	fully-qualified
🤰🏻	pregnant woman: light skin tone	1F930 1F3FB	People & Body	person-role	fully-qualified
🤰🏼	pregnant woman: medium-light skin tone	1F930 1F3FC	People & Body	person-role	fully-qualified
🤰🏽	pregnant woman: medium skin tone	1F930 1F3FD	People & Body	person-role	fully-qualified
🤰🏾	pregnant woman: medium-dark skin tone	1F930 1F3FE	People & Body	person-role	fully-qualified
🤰🏿	pregnant woman: dark skin tone	1F930 1F3FF	People & Body	person-role	fully-qualified
🫃	pregnant man	1FAC3	People & Body	person-role	fully-qualified
🫃🏻	pregnant man: light skin tone	1FAC3 1F3FB	People & Body	person-role	fully-qualified
🫃🏼	pregnant man: medium-light skin tone	1FAC3 1F3FC	People & Body	person-role	fully-qualified
🫃🏽	pregnant man: medium skin tone	1FAC3 1F3FD	People & Body	person-role	fully-qualified
🫃🏾	pregnant man: medium-dark skin tone	1FAC3 1F3FE	People & Body	person-role	fully-qualified
🫃🏿	pregnant man: dark skin tone	1FAC3 1F3FF	People & Body	person-role	fully-qualified
🫄	pregnant person	1FAC4	People & Body	person-role	fully-qualified
🫄🏻	pregnant person: light skin tone	1FAC4 1F3FB	People & Body	person-role	fully-qualified
🫄🏼	pregnant person: medium-light skin tone	1FAC4 1F3FC	People & Body	person-role	fully-qualified
🫄🏽	pregnant person: medium skin tone	1FAC4 1F3FD	People & Body	person-role	fully-qualified
🫄🏾	pregnant person: medium-dark skin tone	1FAC4 1F3FE	People & Body	person-role	fully-qualified
🫄🏿	pregnant person: dark skin tone	1FAC4 1F3FF	People & Body	person-role	fully-qualified
🤱	breast-feeding	1F931	People & Body	person-role	fully-qualified
🤱🏻	breast-feeding: light skin tone	1F931 1F3FB	People & Body	person-role	fully-qualified
🤱🏼	breast-feeding: medium-light skin tone	1F931 1F3FC	People & Body	person-role	fully-qualified
🤱🏽	breast-feeding: medium skin tone	1F931 1F3FD	People & Body	person-role	fully-qualified
🤱🏾	breast-feeding: medium-dark skin tone	1F931 1F3FE	People & Body	person-role	fully-qualified
🤱🏿	breast-feeding: dark skin tone	1F931 1F3FF	People & Body	person-role	fully-qualified
👩‍🍼	woman feeding baby	1F469 200D 1F37C	People & Body	person-role	fully-qualified
👩🏻‍🍼	woman feeding baby: light skin tone	1F469 1F3FB 200D 1F37C	People & Body	person-role	fully-qualified
👩🏼‍🍼	woman feeding baby: medium-light skin tone	1F469 1F3FC 200D 1F37C	People & Body	person-role	fully-qualified
👩🏽‍🍼	woman feeding baby: medium skin tone	1F469 1F3FD 200D 1F37C	People & Body	person-role	fully-qualified
👩🏾‍🍼	woman feeding baby: medium-dark skin tone	1F469 1F3FE 200D 1F37C	People & Body	person-role	fully-qualified
👩🏿‍🍼	woman feeding baby: dark skin tone	1F469 1F3FF 200D 1F37C	People & Body	person-role	fully-qualified
👨‍🍼	man feeding baby	1F468 200D 1F37C	People & Body	person-role	fully-qualified
👨🏻‍🍼	man feeding baby: light skin tone	1F468 1F3FB 200D 1F37C	People & Body	person-role	fully-qualified
👨🏼‍🍼	man feeding baby: medium-light skin tone	1F468 1F3FC 200D 1F37C	People & Body	person-role	fully-qualified
👨🏽‍🍼	man feeding baby: medium skin tone	1F468 1F3FD 200D 1F37C	People & Body	person-role	fully-qualified
👨🏾‍🍼	man feeding baby: medium-dark skin tone	1F468 1F3FE 200D 1F37C	People & Body	person-role	fully-qualified
👨🏿‍🍼	man feeding baby: dark skin tone	1F468 1F3FF 200D 1F37C	People & Body	person-role	fully-qualified
🧑‍🍼	person feeding baby	1F9D1 200D 1F37C	People & Body	person-role	fully-qualified
🧑🏻‍🍼	person feeding baby: light skin tone	1F9D1 1F3FB 200D 1F37C	People & Body	person-role	fully-qualified
🧑🏼‍🍼	person feeding baby: medium-light skin tone	1F9D1 1F3FC 200D 1F37C	People & Body	person-role	fully-qualified
🧑🏽‍🍼	person feeding baby: medium skin tone	1F9D1 1F3FD 200D 1F37C	People & Body	person-role	fully-qualified
🧑🏾‍🍼	person feeding baby: medium-dark skin tone	1F9D1 1F3FE 200D 1F37C	People & Body	person-role	fully-qualified
🧑🏿‍🍼	person feeding baby: dark skin tone	1F9D1 1F3FF 200D 1F37C	People & Body	person-role	fully-qualified
👼	baby angel	1F47C	People & Body	person-fantasy	fully-qualified
👼🏻	baby angel: light skin tone	1F47C 1F3FB	People & Body	person-fantasy	fully-qualified
👼🏼	baby angel: medium-light skin tone	1F47C 1F3FC	People & Body	person-fantasy	fully-qualified
👼🏽	baby angel: medium skin tone	1F47C 1F3FD	People & Body	person-fantasy	fully-qualified
👼🏾	baby angel: medium-dark skin tone	1F47C 1F3FE	People & Body	person-fantasy	fully-qualified
👼🏿	baby angel: dark skin tone	1F47C 1F3FF	People & Body	person-fantasy	fully-qualified
🎅	Santa Claus	1F385	People & Body	person-fantasy	fully-qualified
🎅🏻	Santa Claus: light skin tone	1F385 1F3FB	People & Body	person-fantasy	fully-qualified
🎅🏼	Santa Claus: medium-light skin tone	1F385 1F3FC	People & Body	person-fantasy	fully-qualified
🎅🏽	Santa Claus: medium skin tone	1F385 1F3FD	People & Body	person-fantasy	fully-qualified
🎅🏾	Santa Claus: medium-dark skin tone	1F385 1F3FE	People & Body	person-fantasy	fully-qualified
🎅🏿	Santa Claus: dark skin tone	1F385 1F3FF	People & Body	person-fantasy	fully-qualified
🤶	Mrs. Claus	1F936	People & Body	person-fantasy	fully-qualified
🤶🏻	Mrs. Claus: light skin tone	1F936 1F3FB	People & Body	person-fantasy	fully-qualified
🤶🏼	Mrs. Claus: medium-light skin tone	1F936 1F3FC	People & Body	person-fantasy	fully-qualified
🤶🏽	Mrs. Claus: medium skin tone	1F936 1F3FD	People & Body	person-fantasy	fully-qualified
🤶🏾	Mrs. Claus: medium-dark skin tone	1F936 1F3FE	People & Body	person-fantasy	fully-qualified
🤶🏿	Mrs. Claus: dark skin tone	1F936 1F3FF	People & Body	person-fantasy	fully-qualified
🧑‍🎄	Mx Claus	1F9D1 200D 1F384	People & Body	person-fantasy	fully-qualified
🧑🏻‍🎄	Mx Claus: light skin tone	1F9D1 1F3FB 200D 1F384	People & Body	person-fantasy	fully-qualified
🧑🏼‍🎄	Mx Claus: medium-light skin tone	1F9D1 1F3FC 200D 1F384	People & Body	person-fantasy	fully-qualified
🧑🏽‍🎄	Mx Claus: medium skin tone	1F9D1 1F3FD 200D 1F384	People & Body	person-fantasy	fully-qualified
🧑🏾‍🎄	Mx Claus: medium-dark skin tone	1F9D1 1F3FE 200D 1F384	People & Body	person-fantasy	fully-qualified
🧑🏿‍🎄	Mx Claus: dark skin tone	1F9D1 1F3FF 200D 1F384	People & Body	person-fantasy	fully-qualified
🦸	superhero	1F9B8	People & Body	person-fantasy	fully-qualified
🦸🏻	superhero: light skin tone	1F9B8 1F3FB	People & Body	person-fantasy	fully-qualified
🦸🏼	superhero: medium-light skin tone	1F9B8 1F3FC	People & Body	person-fantasy	fully-qualified
🦸🏽	superhero: medium skin tone	1F9B8 1F3FD	People & Body	person-fantasy	fully-qualified
🦸🏾	superhero: medium-dark skin tone	1F9B8 1F3FE	People & Body	person-fantasy	fully-qualified
🦸🏿	superhero: dark skin tone	1F9B8 1F3FF	People & Body	person-fantasy	fully-qualified
🦸‍♂️	man superhero	1F9B8 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🦸🏻‍♂️	man superhero: light skin tone	1F9B8 1F3FB 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🦸🏼‍♂️	man superhero: medium-light skin tone	1F9B8 1F3FC 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🦸🏽‍♂️	man superhero: medium skin tone	1F9B8 1F3FD 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🦸🏾‍♂️	man superhero: medium-dark skin tone	1F9B8 1F3FE 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🦸🏿‍♂️	man superhero: dark skin tone	1F9B8 1F3FF 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🦸‍♀️	woman superhero	1F9B8 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🦸🏻‍♀️	woman superhero: light skin tone	1F9B8 1F3FB 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🦸🏼‍♀️	woman superhero: medium-light skin tone	1F9B8 1F3FC 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🦸🏽‍♀️	woman superhero: medium skin tone	1F9B8 1F3FD 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🦸🏾‍♀️	woman superhero: medium-dark skin tone	1F9B8 1F3FE 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🦸🏿‍♀️	woman superhero: dark skin tone	1F9B8 1F3FF 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🦹	supervillain	1F9B9	People & Body	person-fantasy	fully-qualified
🦹🏻	supervillain: light skin tone	1F9B9 1F3FB	People & Body	person-fantasy	fully-qualified
🦹🏼	supervillain: medium-light skin tone	1F9B9 1F3FC	People & Body	person-fantasy	fully-qualified
🦹🏽	supervillain: medium skin tone	1F9B9 1F3FD	People & Body	person-fantasy	fully-qualified
🦹🏾	supervillain: medium-dark skin tone	1F9B9 1F3FE	People & Body	person-fantasy	fully-qualified
🦹🏿	supervillain: dark skin tone	1F9B9 1F3FF	People & Body	person-fantasy	fully-qualified
🦹‍♂️	man supervillain	1F9B9 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🦹🏻‍♂️	man supervillain: light skin tone	1F9B9 1F3FB 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🦹🏼‍♂️	man supervillain: medium-light skin tone	1F9B9 1F3FC 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🦹🏽‍♂️	man supervillain: medium skin tone	1F9B9 1F3FD 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🦹🏾‍♂️	man supervillain: medium-dark skin tone	1F9B9 1F3FE 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🦹🏿‍♂️	man supervillain: dark skin tone	1F9B9 1F3FF 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🦹‍♀️	woman supervillain	1F9B9 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🦹🏻‍♀️	woman supervillain: light skin tone	1F9B9 1F3FB 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🦹🏼‍♀️	woman supervillain: medium-light skin tone	1F9B9 1F3FC 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🦹🏽‍♀️	woman supervillain: medium skin tone	1F9B9 1F3FD 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🦹🏾‍♀️	woman supervillain: medium-dark skin tone	1F9B9 1F3FE 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🦹🏿‍♀️	woman supervillain: dark skin tone	1F9B9 1F3FF 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧙	mage	1F9D9	People & Body	person-fantasy	fully-qualified
🧙🏻	mage: light skin tone	1F9D9 1F3FB	People & Body	person-fantasy	fully-qualified
🧙🏼	mage: medium-light skin tone	1F9D9 1F3FC	People & Body	person-fantasy	fully-qualified
🧙🏽	mage: medium skin tone	1F9D9 1F3FD	People & Body	person-fantasy	fully-qualified
🧙🏾	mage: medium-dark skin tone	1F9D9 1F3FE	People & Body	person-fantasy	fully-qualified
🧙🏿	mage: dark skin tone	1F9D9 1F3FF	People & Body	person-fantasy	fully-qualified
🧙‍♂️	man mage	1F9D9 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧙🏻‍♂️	man mage: light skin tone	1F9D9 1F3FB 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧙🏼‍♂️	man mage: medium-light skin tone	1F9D9 1F3FC 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧙🏽‍♂️	man mage: medium skin tone	1F9D9 1F3FD 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧙🏾‍♂️	man mage: medium-dark skin tone	1F9D9 1F3FE 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧙🏿‍♂️	man mage: dark skin tone	1F9D9 1F3FF 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧙‍♀️	woman mage	1F9D9 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧙🏻‍♀️	woman mage: light skin tone	1F9D9 1F3FB 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧙🏼‍♀️	woman mage: medium-light skin tone	1F9D9 1F3FC 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧙🏽‍♀️	woman mage: medium skin tone	1F9D9 1F3FD 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧙🏾‍♀️	woman mage: medium-dark skin tone	1F9D9 1F3FE 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧙🏿‍♀️	woman mage: dark skin tone	1F9D9 1F3FF 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧚	fairy	1F9DA	People & Body	person-fantasy	fully-qualified
🧚🏻	fairy: light skin tone	1F9DA 1F3FB	People & Body	person-fantasy	fully-qualified
🧚🏼	fairy: medium-light skin tone	1F9DA 1F3FC	People & Body	person-fantasy	fully-qualified
🧚🏽	fairy: medium skin tone	1F9DA 1F3FD	People & Body	person-fantasy	fully-qualified
🧚🏾	fairy: medium-dark skin tone	1F9DA 1F3FE	People & Body	person-fantasy	fully-qualified
🧚🏿	fairy: dark skin tone	1F9DA 1F3FF	People & Body	person-fantasy	fully-qualified
🧚‍♂️	man fairy	1F9DA 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧚🏻‍♂️	man fairy: light skin tone	1F9DA 1F3FB 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧚🏼‍♂️	man fairy: medium-light skin tone	1F9DA 1F3FC 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧚🏽‍♂️	man fairy: medium skin tone	1F9DA 1F3FD 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧚🏾‍♂️	man fairy: medium-dark skin tone	1F9DA 1F3FE 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧚🏿‍♂️	man fairy: dark skin tone	1F9DA 1F3FF 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧚‍♀️	woman fairy	1F9DA 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧚🏻‍♀️	woman fairy: light skin tone	1F9DA 1F3FB 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧚🏼‍♀️	woman fairy: medium-light skin tone	1F9DA 1F3FC 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧚🏽‍♀️	woman fairy: medium skin tone	1F9DA 1F3FD 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧚🏾‍♀️	woman fairy: medium-dark skin tone	1F9DA 1F3FE 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧚🏿‍♀️	woman fairy: dark skin tone	1F9DA 1F3FF 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧛	vampire	1F9DB	People & Body	person-fantasy	fully-qualified
🧛🏻	vampire: light skin tone	1F9DB 1F3FB	People & Body	person-fantasy	fully-qualified
🧛🏼	vampire: medium-light skin tone	1F9DB 1F3FC	People & Body	person-fantasy	fully-qualified
🧛🏽	vampire: medium skin tone	1F9DB 1F3FD	People & Body	person-fantasy	fully-qualified
🧛🏾	vampire: medium-dark skin tone	1F9DB 1F3FE	People & Body	person-fantasy	fully-qualified
🧛🏿	vampire: dark skin tone	1F9DB 1F3FF	People & Body	person-fantasy	fully-qualified
🧛‍♂️	man vampire	1F9DB 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧛🏻‍♂️	man vampire: light skin tone	1F9DB 1F3FB 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧛🏼‍♂️	man vampire: medium-light skin tone	1F9DB 1F3FC 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧛🏽‍♂️	man vampire: medium skin tone	1F9DB 1F3FD 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧛🏾‍♂️	man vampire: medium-dark skin tone	1F9DB 1F3FE 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧛🏿‍♂️	man vampire: dark skin tone	1F9DB 1F3FF 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧛‍♀️	woman vampire	1F9DB 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧛🏻‍♀️	woman vampire: light skin tone	1F9DB 1F3FB 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧛🏼‍♀️	woman vampire: medium-light skin tone	1F9DB 1F3FC 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧛🏽‍♀️	woman vampire: medium skin tone	1F9DB 1F3FD 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧛🏾‍♀️	woman vampire: medium-dark skin tone	1F9DB 1F3FE 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧛🏿‍♀️	woman vampire: dark skin tone	1F9DB 1F3FF 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧜	merperson	1F9DC	People & Body	person-fantasy	fully-qualified
🧜🏻	merperson: light skin tone	1F9DC 1F3FB	People & Body	person-fantasy	fully-qualified
🧜🏼	merperson: medium-light skin tone	1F9DC 1F3FC	People & Body	person-fantasy	fully-qualified
🧜🏽	merperson: medium skin tone	1F9DC 1F3FD	People & Body	person-fantasy	fully-qualified
🧜🏾	merperson: medium-dark skin tone	1F9DC 1F3FE	People & Body	person-fantasy	fully-qualified
🧜🏿	merperson: dark skin tone	1F9DC 1F3FF	People & Body	person-fantasy	fully-qualified
🧜‍♂️	merman	1F9DC 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧜🏻‍♂️	merman: light skin tone	1F9DC 1F3FB 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧜🏼‍♂️	merman: medium-light skin tone	1F9DC 1F3FC 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧜🏽‍♂️	merman: medium skin tone	1F9DC 1F3FD 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧜🏾‍♂️	merman: medium-dark skin tone	1F9DC 1F3FE 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧜🏿‍♂️	merman: dark skin tone	1F9DC 1F3FF 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧜‍♀️	mermaid	1F9DC 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧜🏻‍♀️	mermaid: light skin tone	1F9DC 1F3FB 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧜🏼‍♀️	mermaid: medium-light skin tone	1F9DC 1F3FC 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧜🏽‍♀️	mermaid: medium skin tone	1F9DC 1F3FD 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧜🏾‍♀️	mermaid: medium-dark skin tone	1F9DC 1F3FE 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧜🏿‍♀️	mermaid: dark skin tone	1F9DC 1F3FF 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧝	elf	1F9DD	People & Body	person-fantasy	fully-qualified
🧝🏻	elf: light skin tone	1F9DD 1F3FB	People & Body	person-fantasy	fully-qualified
🧝🏼	elf: medium-light skin tone	1F9DD 1F3FC	People & Body	person-fantasy	fully-qualified
🧝🏽	elf: medium skin tone	1F9DD 1F3FD	People & Body	person-fantasy	fully-qualified
🧝🏾	elf: medium-dark skin tone	1F9DD 1F3FE	People & Body	person-fantasy	fully-qualified
🧝🏿	elf: dark skin tone	1F9DD 1F3FF	People & Body	person-fantasy	fully-qualified
🧝‍♂️	man elf	1F9DD 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧝🏻‍♂️	man elf: light skin tone	1F9DD 1F3FB 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧝🏼‍♂️	man elf: medium-light skin tone	1F9DD 1F3FC 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧝🏽‍♂️	man elf: medium skin tone	1F9DD 1F3FD 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧝🏾‍♂️	man elf: medium-dark skin tone	1F9DD 1F3FE 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧝🏿‍♂️	man elf: dark skin tone	1F9DD 1F3FF 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧝‍♀️	woman elf	1F9DD 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧝🏻‍♀️	woman elf: light skin tone	1F9DD 1F3FB 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧝🏼‍♀️	woman elf: medium-light skin tone	1F9DD 1F3FC 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧝🏽‍♀️	woman elf: medium skin tone	1F9DD 1F3FD 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧝🏾‍♀️	woman elf: medium-dark skin tone	1F9DD 1F3FE 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧝🏿‍♀️	woman elf: dark skin tone	1F9DD 1F3FF 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧞	genie	1F9DE	People & Body	person-fantasy	fully-qualified
🧞‍♂️	man genie	1F9DE 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧞‍♀️	woman genie	1F9DE 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧟	zombie	1F9DF	People & Body	person-fantasy	fully-qualified
🧟‍♂️	man zombie	1F9DF 200D 2642 FE0F	People & Body	person-fantasy	fully-qualified
🧟‍♀️	woman zombie	1F9DF 200D 2640 FE0F	People & Body	person-fantasy	fully-qualified
🧌	troll	1F9CC	People & Body	person-fantasy	fully-qualified
🫈	hairy creature	1FAC8	People & Body	person-fantasy	fully-qualified
💆	person getting massage	1F486	People & Body	person-activity	fully-qualified
💆🏻	person getting massage: light skin tone	1F486 1F3FB	People & Body	person-activity	fully-qualified
💆🏼	person getting massage: medium-light skin tone	1F486 1F3FC	People & Body	person-activity	fully-qualified
💆🏽	person getting massage: medium skin tone	1F486 1F3FD	People & Body	person-activity	fully-qualified
💆🏾	person getting massage: medium-dark skin tone	1F486 1F3FE	People & Body	person-activity	fully-qualified
💆🏿	person getting massage: dark skin tone	1F486 1F3FF	People & Body	person-activity	fully-qualified
💆‍♂️	man getting massage	1F486 200D 2642 FE0F	People & Body	person-activity	fully-qualified
💆🏻‍♂️	man getting massage: light skin tone	1F486 1F3FB 200D 2642 FE0F	People & Body	person-activity	fully-qualified
💆🏼‍♂️	man getting massage: medium-light skin tone	1F486 1F3FC 200D 2642 FE0F	People & Body	person-activity	fully-qualified
💆🏽‍♂️	man getting massage: medium skin tone	1F486 1F3FD 200D 2642 FE0F	People & Body	person-activity	fully-qualified
💆🏾‍♂️	man getting massage: medium-dark skin tone	1F486 1F3FE 200D 2642 FE0F	People & Body	person-activity	fully-qualified
💆🏿‍♂️	man getting massage: dark skin tone	1F486 1F3FF 200D 2642 FE0F	People & Body	person-activity	fully-qualified
💆‍♀️	woman getting massage	1F486 200D 2640 FE0F	People & Body	person-activity	fully-qualified
💆🏻‍♀️	woman getting massage: light skin tone	1F486 1F3FB 200D 2640 FE0F	People & Body	person-activity	fully-qualified
💆🏼‍♀️	woman getting massage: medium-light skin tone	1F486 1F3FC 200D 2640 FE0F	People & Body	person-activity	fully-qualified
💆🏽‍♀️	woman getting massage: medium skin tone	1F486 1F3FD 200D 2640 FE0F	People & Body	person-activity	fully-qualified
💆🏾‍♀️	woman getting massage: medium-dark skin tone	1F486 1F3FE 200D 2640 FE0F	People & Body	person-activity	fully-qualified
💆🏿‍♀️	woman getting massage: dark skin tone	1F486 1F3FF 200D 2640 FE0F	People & Body	person-activity	fully-qualified
💇	person getting haircut	1F487	People & Body	person-activity	fully-qualified
💇🏻	person getting haircut: light skin tone	1F487 1F3FB	People & Body	person-activity	fully-qualified
💇🏼	person getting haircut: medium-light skin tone	1F487 1F3FC	People & Body	person-activity	fully-qualified
💇🏽	person getting haircut: medium skin tone	1F487 1F3FD	People & Body	person-activity	fully-qualified
💇🏾	person getting haircut: medium-dark skin tone	1F487 1F3FE	People & Body	person-activity	fully-qualified
💇🏿	person getting haircut: dark skin tone	1F487 1F3FF	People & Body	person-activity	fully-qualified
💇‍♂️	man getting haircut	1F487 200D 2642 FE0F	People & Body	person-activity	fully-qualified
💇🏻‍♂️	man getting haircut: light skin tone	1F487 1F3FB 200D 2642 FE0F	People & Body	person-activity	fully-qualified
💇🏼‍♂️	man getting haircut: medium-light skin tone	1F487 1F3FC 200D 2642 FE0F	People & Body	person-activity	fully-qualified
💇🏽‍♂️	man getting haircut: medium skin tone	1F487 1F3FD 200D 2642 FE0F	People & Body	person-activity	fully-qualified
💇🏾‍♂️	man getting haircut: medium-dark skin tone	1F487 1F3FE 200D 2642 FE0F	People & Body	person-activity	fully-qualified
💇🏿‍♂️	man getting haircut: dark skin tone	1F487 1F3FF 200D 2642 FE0F	People & Body	person-activity	fully-qualified
💇‍♀️	woman getting haircut	1F487 200D 2640 FE0F	People & Body	person-activity	fully-qualified
💇🏻‍♀️	woman getting haircut: light skin tone	1F487 1F3FB 200D 2640 FE0F	People & Body	person-activity	fully-qualified
💇🏼‍♀️	woman getting haircut: medium-light skin tone	1F487 1F3FC 200D 2640 FE0F	People & Body	person-activity	fully-qualified
💇🏽‍♀️	woman getting haircut: medium skin tone	1F487 1F3FD 200D 2640 FE0F	People & Body	person-activity	fully-qualified
💇🏾‍♀️	woman getting haircut: medium-dark skin tone	1F487 1F3FE 200D 2640 FE0F	People & Body	person-activity	fully-qualified
💇🏿‍♀️	woman getting haircut: dark skin tone	1F487 1F3FF 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🚶	person walking	1F6B6	People & Body	person-activity	fully-qualified
🚶🏻	person walking: light skin tone	1F6B6 1F3FB	People & Body	person-activity	fully-qualified
🚶🏼	person walking: medium-light skin tone	1F6B6 1F3FC	People & Body	person-activity	fully-qualified
🚶🏽	person walking: medium skin tone	1F6B6 1F3FD	People & Body	person-activity	fully-qualified
🚶🏾	person walking: medium-dark skin tone	1F6B6 1F3FE	People & Body	person-activity	fully-qualified
🚶🏿	person walking: dark skin tone	1F6B6 1F3FF	People & Body	person-activity	fully-qualified
🚶‍♂️	man walking	1F6B6 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🚶🏻‍♂️	man walking: light skin tone	1F6B6 1F3FB 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🚶🏼‍♂️	man walking: medium-light skin tone	1F6B6 1F3FC 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🚶🏽‍♂️	man walking: medium skin tone	1F6B6 1F3FD 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🚶🏾‍♂️	man walking: medium-dark skin tone	1F6B6 1F3FE 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🚶🏿‍♂️	man walking: dark skin tone	1F6B6 1F3FF 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🚶‍♀️	woman walking	1F6B6 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🚶🏻‍♀️	woman walking: light skin tone	1F6B6 1F3FB 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🚶🏼‍♀️	woman walking: medium-light skin tone	1F6B6 1F3FC 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🚶🏽‍♀️	woman walking: medium skin tone	1F6B6 1F3FD 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🚶🏾‍♀️	woman walking: medium-dark skin tone	1F6B6 1F3FE 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🚶🏿‍♀️	woman walking: dark skin tone	1F6B6 1F3FF 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🚶‍➡️	person walking facing right	1F6B6 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🚶🏻‍➡️	person walking facing right: light skin tone	1F6B6 1F3FB 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🚶🏼‍➡️	person walking facing right: medium-light skin tone	1F6B6 1F3FC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🚶🏽‍➡️	person walking facing right: medium skin tone	1F6B6 1F3FD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🚶🏾‍➡️	person walking facing right: medium-dark skin tone	1F6B6 1F3FE 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🚶🏿‍➡️	person walking facing right: dark skin tone	1F6B6 1F3FF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🚶‍♀️‍➡️	woman walking facing right	1F6B6 200D 2640 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🚶🏻‍♀️‍➡️	woman walking facing right: light skin tone	1F6B6 1F3FB 200D 2640 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🚶🏼‍♀️‍➡️	woman walking facing right: medium-light skin tone	1F6B6 1F3FC 200D 2640 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🚶🏽‍♀️‍➡️	woman walking facing right: medium skin tone	1F6B6 1F3FD 200D 2640 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🚶🏾‍♀️‍➡️	woman walking facing right: medium-dark skin tone	1F6B6 1F3FE 200D 2640 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🚶🏿‍♀️‍➡️	woman walking facing right: dark skin tone	1F6B6 1F3FF 200D 2640 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🚶‍♂️‍➡️	man walking facing right	1F6B6 200D 2642 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🚶🏻‍♂️‍➡️	man walking facing right: light skin tone	1F6B6 1F3FB 200D 2642 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🚶🏼‍♂️‍➡️	man walking facing right: medium-light skin tone	1F6B6 1F3FC 200D 2642 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🚶🏽‍♂️‍➡️	man walking facing right: medium skin tone	1F6B6 1F3FD 200D 2642 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🚶🏾‍♂️‍➡️	man walking facing right: medium-dark skin tone	1F6B6 1F3FE 200D 2642 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🚶🏿‍♂️‍➡️	man walking facing right: dark skin tone	1F6B6 1F3FF 200D 2642 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧍	person standing	1F9CD	People & Body	person-activity	fully-qualified
🧍🏻	person standing: light skin tone	1F9CD 1F3FB	People & Body	person-activity	fully-qualified
🧍🏼	person standing: medium-light skin tone	1F9CD 1F3FC	People & Body	person-activity	fully-qualified
🧍🏽	person standing: medium skin tone	1F9CD 1F3FD	People & Body	person-activity	fully-qualified
🧍🏾	person standing: medium-dark skin tone	1F9CD 1F3FE	People & Body	person-activity	fully-qualified
🧍🏿	person standing: dark skin tone	1F9CD 1F3FF	People & Body	person-activity	fully-qualified
🧍‍♂️	man standing	1F9CD 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧍🏻‍♂️	man standing: light skin tone	1F9CD 1F3FB 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧍🏼‍♂️	man standing: medium-light skin tone	1F9CD 1F3FC 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧍🏽‍♂️	man standing: medium skin tone	1F9CD 1F3FD 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧍🏾‍♂️	man standing: medium-dark skin tone	1F9CD 1F3FE 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧍🏿‍♂️	man standing: dark skin tone	1F9CD 1F3FF 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧍‍♀️	woman standing	1F9CD 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧍🏻‍♀️	woman standing: light skin tone	1F9CD 1F3FB 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧍🏼‍♀️	woman standing: medium-light skin tone	1F9CD 1F3FC 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧍🏽‍♀️	woman standing: medium skin tone	1F9CD 1F3FD 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧍🏾‍♀️	woman standing: medium-dark skin tone	1F9CD 1F3FE 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧍🏿‍♀️	woman standing: dark skin tone	1F9CD 1F3FF 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧎	person kneeling	1F9CE	People & Body	person-activity	fully-qualified
🧎🏻	person kneeling: light skin tone	1F9CE 1F3FB	People & Body	person-activity	fully-qualified
🧎🏼	person kneeling: medium-light skin tone	1F9CE 1F3FC	People & Body	person-activity	fully-qualified
🧎🏽	person kneeling: medium skin tone	1F9CE 1F3FD	People & Body	person-activity	fully-qualified
🧎🏾	person kneeling: medium-dark skin tone	1F9CE 1F3FE	People & Body	person-activity	fully-qualified
🧎🏿	person kneeling: dark skin tone	1F9CE 1F3FF	People & Body	person-activity	fully-qualified
🧎‍♂️	man kneeling	1F9CE 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧎🏻‍♂️	man kneeling: light skin tone	1F9CE 1F3FB 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧎🏼‍♂️	man kneeling: medium-light skin tone	1F9CE 1F3FC 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧎🏽‍♂️	man kneeling: medium skin tone	1F9CE 1F3FD 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧎🏾‍♂️	man kneeling: medium-dark skin tone	1F9CE 1F3FE 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧎🏿‍♂️	man kneeling: dark skin tone	1F9CE 1F3FF 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧎‍♀️	woman kneeling	1F9CE 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧎🏻‍♀️	woman kneeling: light skin tone	1F9CE 1F3FB 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧎🏼‍♀️	woman kneeling: medium-light skin tone	1F9CE 1F3FC 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧎🏽‍♀️	woman kneeling: medium skin tone	1F9CE 1F3FD 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧎🏾‍♀️	woman kneeling: medium-dark skin tone	1F9CE 1F3FE 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧎🏿‍♀️	woman kneeling: dark skin tone	1F9CE 1F3FF 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧎‍➡️	person kneeling facing right	1F9CE 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧎🏻‍➡️	person kneeling facing right: light skin tone	1F9CE 1F3FB 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧎🏼‍➡️	person kneeling facing right: medium-light skin tone	1F9CE 1F3FC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧎🏽‍➡️	person kneeling facing right: medium skin tone	1F9CE 1F3FD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧎🏾‍➡️	person kneeling facing right: medium-dark skin tone	1F9CE 1F3FE 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧎🏿‍➡️	person kneeling facing right: dark skin tone	1F9CE 1F3FF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
        """.trimIndent(),

        """
🧎‍♀️‍➡️	woman kneeling facing right	1F9CE 200D 2640 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧎🏻‍♀️‍➡️	woman kneeling facing right: light skin tone	1F9CE 1F3FB 200D 2640 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧎🏼‍♀️‍➡️	woman kneeling facing right: medium-light skin tone	1F9CE 1F3FC 200D 2640 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧎🏽‍♀️‍➡️	woman kneeling facing right: medium skin tone	1F9CE 1F3FD 200D 2640 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧎🏾‍♀️‍➡️	woman kneeling facing right: medium-dark skin tone	1F9CE 1F3FE 200D 2640 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧎🏿‍♀️‍➡️	woman kneeling facing right: dark skin tone	1F9CE 1F3FF 200D 2640 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧎‍♂️‍➡️	man kneeling facing right	1F9CE 200D 2642 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧎🏻‍♂️‍➡️	man kneeling facing right: light skin tone	1F9CE 1F3FB 200D 2642 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧎🏼‍♂️‍➡️	man kneeling facing right: medium-light skin tone	1F9CE 1F3FC 200D 2642 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧎🏽‍♂️‍➡️	man kneeling facing right: medium skin tone	1F9CE 1F3FD 200D 2642 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧎🏾‍♂️‍➡️	man kneeling facing right: medium-dark skin tone	1F9CE 1F3FE 200D 2642 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧎🏿‍♂️‍➡️	man kneeling facing right: dark skin tone	1F9CE 1F3FF 200D 2642 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑‍🦯	person with white cane	1F9D1 200D 1F9AF	People & Body	person-activity	fully-qualified
🧑🏻‍🦯	person with white cane: light skin tone	1F9D1 1F3FB 200D 1F9AF	People & Body	person-activity	fully-qualified
🧑🏼‍🦯	person with white cane: medium-light skin tone	1F9D1 1F3FC 200D 1F9AF	People & Body	person-activity	fully-qualified
🧑🏽‍🦯	person with white cane: medium skin tone	1F9D1 1F3FD 200D 1F9AF	People & Body	person-activity	fully-qualified
🧑🏾‍🦯	person with white cane: medium-dark skin tone	1F9D1 1F3FE 200D 1F9AF	People & Body	person-activity	fully-qualified
🧑🏿‍🦯	person with white cane: dark skin tone	1F9D1 1F3FF 200D 1F9AF	People & Body	person-activity	fully-qualified
🧑‍🦯‍➡️	person with white cane facing right	1F9D1 200D 1F9AF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑🏻‍🦯‍➡️	person with white cane facing right: light skin tone	1F9D1 1F3FB 200D 1F9AF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑🏼‍🦯‍➡️	person with white cane facing right: medium-light skin tone	1F9D1 1F3FC 200D 1F9AF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑🏽‍🦯‍➡️	person with white cane facing right: medium skin tone	1F9D1 1F3FD 200D 1F9AF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑🏾‍🦯‍➡️	person with white cane facing right: medium-dark skin tone	1F9D1 1F3FE 200D 1F9AF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑🏿‍🦯‍➡️	person with white cane facing right: dark skin tone	1F9D1 1F3FF 200D 1F9AF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👨‍🦯	man with white cane	1F468 200D 1F9AF	People & Body	person-activity	fully-qualified
👨🏻‍🦯	man with white cane: light skin tone	1F468 1F3FB 200D 1F9AF	People & Body	person-activity	fully-qualified
👨🏼‍🦯	man with white cane: medium-light skin tone	1F468 1F3FC 200D 1F9AF	People & Body	person-activity	fully-qualified
👨🏽‍🦯	man with white cane: medium skin tone	1F468 1F3FD 200D 1F9AF	People & Body	person-activity	fully-qualified
👨🏾‍🦯	man with white cane: medium-dark skin tone	1F468 1F3FE 200D 1F9AF	People & Body	person-activity	fully-qualified
👨🏿‍🦯	man with white cane: dark skin tone	1F468 1F3FF 200D 1F9AF	People & Body	person-activity	fully-qualified
👨‍🦯‍➡️	man with white cane facing right	1F468 200D 1F9AF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👨🏻‍🦯‍➡️	man with white cane facing right: light skin tone	1F468 1F3FB 200D 1F9AF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👨🏼‍🦯‍➡️	man with white cane facing right: medium-light skin tone	1F468 1F3FC 200D 1F9AF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👨🏽‍🦯‍➡️	man with white cane facing right: medium skin tone	1F468 1F3FD 200D 1F9AF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👨🏾‍🦯‍➡️	man with white cane facing right: medium-dark skin tone	1F468 1F3FE 200D 1F9AF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👨🏿‍🦯‍➡️	man with white cane facing right: dark skin tone	1F468 1F3FF 200D 1F9AF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👩‍🦯	woman with white cane	1F469 200D 1F9AF	People & Body	person-activity	fully-qualified
👩🏻‍🦯	woman with white cane: light skin tone	1F469 1F3FB 200D 1F9AF	People & Body	person-activity	fully-qualified
👩🏼‍🦯	woman with white cane: medium-light skin tone	1F469 1F3FC 200D 1F9AF	People & Body	person-activity	fully-qualified
👩🏽‍🦯	woman with white cane: medium skin tone	1F469 1F3FD 200D 1F9AF	People & Body	person-activity	fully-qualified
👩🏾‍🦯	woman with white cane: medium-dark skin tone	1F469 1F3FE 200D 1F9AF	People & Body	person-activity	fully-qualified
👩🏿‍🦯	woman with white cane: dark skin tone	1F469 1F3FF 200D 1F9AF	People & Body	person-activity	fully-qualified
👩‍🦯‍➡️	woman with white cane facing right	1F469 200D 1F9AF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👩🏻‍🦯‍➡️	woman with white cane facing right: light skin tone	1F469 1F3FB 200D 1F9AF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👩🏼‍🦯‍➡️	woman with white cane facing right: medium-light skin tone	1F469 1F3FC 200D 1F9AF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👩🏽‍🦯‍➡️	woman with white cane facing right: medium skin tone	1F469 1F3FD 200D 1F9AF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👩🏾‍🦯‍➡️	woman with white cane facing right: medium-dark skin tone	1F469 1F3FE 200D 1F9AF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👩🏿‍🦯‍➡️	woman with white cane facing right: dark skin tone	1F469 1F3FF 200D 1F9AF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑‍🦼	person in motorized wheelchair	1F9D1 200D 1F9BC	People & Body	person-activity	fully-qualified
🧑🏻‍🦼	person in motorized wheelchair: light skin tone	1F9D1 1F3FB 200D 1F9BC	People & Body	person-activity	fully-qualified
🧑🏼‍🦼	person in motorized wheelchair: medium-light skin tone	1F9D1 1F3FC 200D 1F9BC	People & Body	person-activity	fully-qualified
🧑🏽‍🦼	person in motorized wheelchair: medium skin tone	1F9D1 1F3FD 200D 1F9BC	People & Body	person-activity	fully-qualified
🧑🏾‍🦼	person in motorized wheelchair: medium-dark skin tone	1F9D1 1F3FE 200D 1F9BC	People & Body	person-activity	fully-qualified
🧑🏿‍🦼	person in motorized wheelchair: dark skin tone	1F9D1 1F3FF 200D 1F9BC	People & Body	person-activity	fully-qualified
🧑‍🦼‍➡️	person in motorized wheelchair facing right	1F9D1 200D 1F9BC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑🏻‍🦼‍➡️	person in motorized wheelchair facing right: light skin tone	1F9D1 1F3FB 200D 1F9BC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑🏼‍🦼‍➡️	person in motorized wheelchair facing right: medium-light skin tone	1F9D1 1F3FC 200D 1F9BC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑🏽‍🦼‍➡️	person in motorized wheelchair facing right: medium skin tone	1F9D1 1F3FD 200D 1F9BC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑🏾‍🦼‍➡️	person in motorized wheelchair facing right: medium-dark skin tone	1F9D1 1F3FE 200D 1F9BC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑🏿‍🦼‍➡️	person in motorized wheelchair facing right: dark skin tone	1F9D1 1F3FF 200D 1F9BC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👨‍🦼	man in motorized wheelchair	1F468 200D 1F9BC	People & Body	person-activity	fully-qualified
👨🏻‍🦼	man in motorized wheelchair: light skin tone	1F468 1F3FB 200D 1F9BC	People & Body	person-activity	fully-qualified
👨🏼‍🦼	man in motorized wheelchair: medium-light skin tone	1F468 1F3FC 200D 1F9BC	People & Body	person-activity	fully-qualified
👨🏽‍🦼	man in motorized wheelchair: medium skin tone	1F468 1F3FD 200D 1F9BC	People & Body	person-activity	fully-qualified
👨🏾‍🦼	man in motorized wheelchair: medium-dark skin tone	1F468 1F3FE 200D 1F9BC	People & Body	person-activity	fully-qualified
👨🏿‍🦼	man in motorized wheelchair: dark skin tone	1F468 1F3FF 200D 1F9BC	People & Body	person-activity	fully-qualified
👨‍🦼‍➡️	man in motorized wheelchair facing right	1F468 200D 1F9BC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👨🏻‍🦼‍➡️	man in motorized wheelchair facing right: light skin tone	1F468 1F3FB 200D 1F9BC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👨🏼‍🦼‍➡️	man in motorized wheelchair facing right: medium-light skin tone	1F468 1F3FC 200D 1F9BC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👨🏽‍🦼‍➡️	man in motorized wheelchair facing right: medium skin tone	1F468 1F3FD 200D 1F9BC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👨🏾‍🦼‍➡️	man in motorized wheelchair facing right: medium-dark skin tone	1F468 1F3FE 200D 1F9BC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👨🏿‍🦼‍➡️	man in motorized wheelchair facing right: dark skin tone	1F468 1F3FF 200D 1F9BC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👩‍🦼	woman in motorized wheelchair	1F469 200D 1F9BC	People & Body	person-activity	fully-qualified
👩🏻‍🦼	woman in motorized wheelchair: light skin tone	1F469 1F3FB 200D 1F9BC	People & Body	person-activity	fully-qualified
👩🏼‍🦼	woman in motorized wheelchair: medium-light skin tone	1F469 1F3FC 200D 1F9BC	People & Body	person-activity	fully-qualified
👩🏽‍🦼	woman in motorized wheelchair: medium skin tone	1F469 1F3FD 200D 1F9BC	People & Body	person-activity	fully-qualified
👩🏾‍🦼	woman in motorized wheelchair: medium-dark skin tone	1F469 1F3FE 200D 1F9BC	People & Body	person-activity	fully-qualified
👩🏿‍🦼	woman in motorized wheelchair: dark skin tone	1F469 1F3FF 200D 1F9BC	People & Body	person-activity	fully-qualified
👩‍🦼‍➡️	woman in motorized wheelchair facing right	1F469 200D 1F9BC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👩🏻‍🦼‍➡️	woman in motorized wheelchair facing right: light skin tone	1F469 1F3FB 200D 1F9BC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👩🏼‍🦼‍➡️	woman in motorized wheelchair facing right: medium-light skin tone	1F469 1F3FC 200D 1F9BC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👩🏽‍🦼‍➡️	woman in motorized wheelchair facing right: medium skin tone	1F469 1F3FD 200D 1F9BC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👩🏾‍🦼‍➡️	woman in motorized wheelchair facing right: medium-dark skin tone	1F469 1F3FE 200D 1F9BC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👩🏿‍🦼‍➡️	woman in motorized wheelchair facing right: dark skin tone	1F469 1F3FF 200D 1F9BC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑‍🦽	person in manual wheelchair	1F9D1 200D 1F9BD	People & Body	person-activity	fully-qualified
🧑🏻‍🦽	person in manual wheelchair: light skin tone	1F9D1 1F3FB 200D 1F9BD	People & Body	person-activity	fully-qualified
🧑🏼‍🦽	person in manual wheelchair: medium-light skin tone	1F9D1 1F3FC 200D 1F9BD	People & Body	person-activity	fully-qualified
🧑🏽‍🦽	person in manual wheelchair: medium skin tone	1F9D1 1F3FD 200D 1F9BD	People & Body	person-activity	fully-qualified
🧑🏾‍🦽	person in manual wheelchair: medium-dark skin tone	1F9D1 1F3FE 200D 1F9BD	People & Body	person-activity	fully-qualified
🧑🏿‍🦽	person in manual wheelchair: dark skin tone	1F9D1 1F3FF 200D 1F9BD	People & Body	person-activity	fully-qualified
🧑‍🦽‍➡️	person in manual wheelchair facing right	1F9D1 200D 1F9BD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑🏻‍🦽‍➡️	person in manual wheelchair facing right: light skin tone	1F9D1 1F3FB 200D 1F9BD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑🏼‍🦽‍➡️	person in manual wheelchair facing right: medium-light skin tone	1F9D1 1F3FC 200D 1F9BD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑🏽‍🦽‍➡️	person in manual wheelchair facing right: medium skin tone	1F9D1 1F3FD 200D 1F9BD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑🏾‍🦽‍➡️	person in manual wheelchair facing right: medium-dark skin tone	1F9D1 1F3FE 200D 1F9BD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑🏿‍🦽‍➡️	person in manual wheelchair facing right: dark skin tone	1F9D1 1F3FF 200D 1F9BD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👨‍🦽	man in manual wheelchair	1F468 200D 1F9BD	People & Body	person-activity	fully-qualified
👨🏻‍🦽	man in manual wheelchair: light skin tone	1F468 1F3FB 200D 1F9BD	People & Body	person-activity	fully-qualified
👨🏼‍🦽	man in manual wheelchair: medium-light skin tone	1F468 1F3FC 200D 1F9BD	People & Body	person-activity	fully-qualified
👨🏽‍🦽	man in manual wheelchair: medium skin tone	1F468 1F3FD 200D 1F9BD	People & Body	person-activity	fully-qualified
👨🏾‍🦽	man in manual wheelchair: medium-dark skin tone	1F468 1F3FE 200D 1F9BD	People & Body	person-activity	fully-qualified
👨🏿‍🦽	man in manual wheelchair: dark skin tone	1F468 1F3FF 200D 1F9BD	People & Body	person-activity	fully-qualified
👨‍🦽‍➡️	man in manual wheelchair facing right	1F468 200D 1F9BD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👨🏻‍🦽‍➡️	man in manual wheelchair facing right: light skin tone	1F468 1F3FB 200D 1F9BD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👨🏼‍🦽‍➡️	man in manual wheelchair facing right: medium-light skin tone	1F468 1F3FC 200D 1F9BD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👨🏽‍🦽‍➡️	man in manual wheelchair facing right: medium skin tone	1F468 1F3FD 200D 1F9BD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👨🏾‍🦽‍➡️	man in manual wheelchair facing right: medium-dark skin tone	1F468 1F3FE 200D 1F9BD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👨🏿‍🦽‍➡️	man in manual wheelchair facing right: dark skin tone	1F468 1F3FF 200D 1F9BD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👩‍🦽	woman in manual wheelchair	1F469 200D 1F9BD	People & Body	person-activity	fully-qualified
👩🏻‍🦽	woman in manual wheelchair: light skin tone	1F469 1F3FB 200D 1F9BD	People & Body	person-activity	fully-qualified
👩🏼‍🦽	woman in manual wheelchair: medium-light skin tone	1F469 1F3FC 200D 1F9BD	People & Body	person-activity	fully-qualified
👩🏽‍🦽	woman in manual wheelchair: medium skin tone	1F469 1F3FD 200D 1F9BD	People & Body	person-activity	fully-qualified
👩🏾‍🦽	woman in manual wheelchair: medium-dark skin tone	1F469 1F3FE 200D 1F9BD	People & Body	person-activity	fully-qualified
👩🏿‍🦽	woman in manual wheelchair: dark skin tone	1F469 1F3FF 200D 1F9BD	People & Body	person-activity	fully-qualified
👩‍🦽‍➡️	woman in manual wheelchair facing right	1F469 200D 1F9BD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👩🏻‍🦽‍➡️	woman in manual wheelchair facing right: light skin tone	1F469 1F3FB 200D 1F9BD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👩🏼‍🦽‍➡️	woman in manual wheelchair facing right: medium-light skin tone	1F469 1F3FC 200D 1F9BD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👩🏽‍🦽‍➡️	woman in manual wheelchair facing right: medium skin tone	1F469 1F3FD 200D 1F9BD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👩🏾‍🦽‍➡️	woman in manual wheelchair facing right: medium-dark skin tone	1F469 1F3FE 200D 1F9BD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
👩🏿‍🦽‍➡️	woman in manual wheelchair facing right: dark skin tone	1F469 1F3FF 200D 1F9BD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🏃	person running	1F3C3	People & Body	person-activity	fully-qualified
🏃🏻	person running: light skin tone	1F3C3 1F3FB	People & Body	person-activity	fully-qualified
🏃🏼	person running: medium-light skin tone	1F3C3 1F3FC	People & Body	person-activity	fully-qualified
🏃🏽	person running: medium skin tone	1F3C3 1F3FD	People & Body	person-activity	fully-qualified
🏃🏾	person running: medium-dark skin tone	1F3C3 1F3FE	People & Body	person-activity	fully-qualified
🏃🏿	person running: dark skin tone	1F3C3 1F3FF	People & Body	person-activity	fully-qualified
🏃‍♂️	man running	1F3C3 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🏃🏻‍♂️	man running: light skin tone	1F3C3 1F3FB 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🏃🏼‍♂️	man running: medium-light skin tone	1F3C3 1F3FC 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🏃🏽‍♂️	man running: medium skin tone	1F3C3 1F3FD 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🏃🏾‍♂️	man running: medium-dark skin tone	1F3C3 1F3FE 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🏃🏿‍♂️	man running: dark skin tone	1F3C3 1F3FF 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🏃‍♀️	woman running	1F3C3 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🏃🏻‍♀️	woman running: light skin tone	1F3C3 1F3FB 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🏃🏼‍♀️	woman running: medium-light skin tone	1F3C3 1F3FC 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🏃🏽‍♀️	woman running: medium skin tone	1F3C3 1F3FD 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🏃🏾‍♀️	woman running: medium-dark skin tone	1F3C3 1F3FE 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🏃🏿‍♀️	woman running: dark skin tone	1F3C3 1F3FF 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🏃‍➡️	person running facing right	1F3C3 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🏃🏻‍➡️	person running facing right: light skin tone	1F3C3 1F3FB 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🏃🏼‍➡️	person running facing right: medium-light skin tone	1F3C3 1F3FC 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🏃🏽‍➡️	person running facing right: medium skin tone	1F3C3 1F3FD 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🏃🏾‍➡️	person running facing right: medium-dark skin tone	1F3C3 1F3FE 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🏃🏿‍➡️	person running facing right: dark skin tone	1F3C3 1F3FF 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🏃‍♀️‍➡️	woman running facing right	1F3C3 200D 2640 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🏃🏻‍♀️‍➡️	woman running facing right: light skin tone	1F3C3 1F3FB 200D 2640 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🏃🏼‍♀️‍➡️	woman running facing right: medium-light skin tone	1F3C3 1F3FC 200D 2640 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🏃🏽‍♀️‍➡️	woman running facing right: medium skin tone	1F3C3 1F3FD 200D 2640 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🏃🏾‍♀️‍➡️	woman running facing right: medium-dark skin tone	1F3C3 1F3FE 200D 2640 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🏃🏿‍♀️‍➡️	woman running facing right: dark skin tone	1F3C3 1F3FF 200D 2640 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🏃‍♂️‍➡️	man running facing right	1F3C3 200D 2642 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🏃🏻‍♂️‍➡️	man running facing right: light skin tone	1F3C3 1F3FB 200D 2642 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🏃🏼‍♂️‍➡️	man running facing right: medium-light skin tone	1F3C3 1F3FC 200D 2642 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🏃🏽‍♂️‍➡️	man running facing right: medium skin tone	1F3C3 1F3FD 200D 2642 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🏃🏾‍♂️‍➡️	man running facing right: medium-dark skin tone	1F3C3 1F3FE 200D 2642 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🏃🏿‍♂️‍➡️	man running facing right: dark skin tone	1F3C3 1F3FF 200D 2642 FE0F 200D 27A1 FE0F	People & Body	person-activity	fully-qualified
🧑‍🩰	ballet dancer	1F9D1 200D 1FA70	People & Body	person-activity	fully-qualified
🧑🏻‍🩰	ballet dancer: light skin tone	1F9D1 1F3FB 200D 1FA70	People & Body	person-activity	fully-qualified
🧑🏼‍🩰	ballet dancer: medium-light skin tone	1F9D1 1F3FC 200D 1FA70	People & Body	person-activity	fully-qualified
🧑🏽‍🩰	ballet dancer: medium skin tone	1F9D1 1F3FD 200D 1FA70	People & Body	person-activity	fully-qualified
🧑🏾‍🩰	ballet dancer: medium-dark skin tone	1F9D1 1F3FE 200D 1FA70	People & Body	person-activity	fully-qualified
🧑🏿‍🩰	ballet dancer: dark skin tone	1F9D1 1F3FF 200D 1FA70	People & Body	person-activity	fully-qualified
💃	woman dancing	1F483	People & Body	person-activity	fully-qualified
💃🏻	woman dancing: light skin tone	1F483 1F3FB	People & Body	person-activity	fully-qualified
💃🏼	woman dancing: medium-light skin tone	1F483 1F3FC	People & Body	person-activity	fully-qualified
💃🏽	woman dancing: medium skin tone	1F483 1F3FD	People & Body	person-activity	fully-qualified
💃🏾	woman dancing: medium-dark skin tone	1F483 1F3FE	People & Body	person-activity	fully-qualified
💃🏿	woman dancing: dark skin tone	1F483 1F3FF	People & Body	person-activity	fully-qualified
🕺	man dancing	1F57A	People & Body	person-activity	fully-qualified
🕺🏻	man dancing: light skin tone	1F57A 1F3FB	People & Body	person-activity	fully-qualified
🕺🏼	man dancing: medium-light skin tone	1F57A 1F3FC	People & Body	person-activity	fully-qualified
🕺🏽	man dancing: medium skin tone	1F57A 1F3FD	People & Body	person-activity	fully-qualified
🕺🏾	man dancing: medium-dark skin tone	1F57A 1F3FE	People & Body	person-activity	fully-qualified
🕺🏿	man dancing: dark skin tone	1F57A 1F3FF	People & Body	person-activity	fully-qualified
🕴️	person in suit levitating	1F574 FE0F	People & Body	person-activity	fully-qualified
🕴🏻	person in suit levitating: light skin tone	1F574 1F3FB	People & Body	person-activity	fully-qualified
🕴🏼	person in suit levitating: medium-light skin tone	1F574 1F3FC	People & Body	person-activity	fully-qualified
🕴🏽	person in suit levitating: medium skin tone	1F574 1F3FD	People & Body	person-activity	fully-qualified
🕴🏾	person in suit levitating: medium-dark skin tone	1F574 1F3FE	People & Body	person-activity	fully-qualified
🕴🏿	person in suit levitating: dark skin tone	1F574 1F3FF	People & Body	person-activity	fully-qualified
👯	people with bunny ears	1F46F	People & Body	person-activity	fully-qualified
👯🏻	people with bunny ears: light skin tone	1F46F 1F3FB	People & Body	person-activity	fully-qualified
👯🏼	people with bunny ears: medium-light skin tone	1F46F 1F3FC	People & Body	person-activity	fully-qualified
👯🏽	people with bunny ears: medium skin tone	1F46F 1F3FD	People & Body	person-activity	fully-qualified
👯🏾	people with bunny ears: medium-dark skin tone	1F46F 1F3FE	People & Body	person-activity	fully-qualified
👯🏿	people with bunny ears: dark skin tone	1F46F 1F3FF	People & Body	person-activity	fully-qualified
👯‍♂️	men with bunny ears	1F46F 200D 2642 FE0F	People & Body	person-activity	fully-qualified
👯🏻‍♂️	men with bunny ears: light skin tone	1F46F 1F3FB 200D 2642 FE0F	People & Body	person-activity	fully-qualified
👯🏼‍♂️	men with bunny ears: medium-light skin tone	1F46F 1F3FC 200D 2642 FE0F	People & Body	person-activity	fully-qualified
👯🏽‍♂️	men with bunny ears: medium skin tone	1F46F 1F3FD 200D 2642 FE0F	People & Body	person-activity	fully-qualified
👯🏾‍♂️	men with bunny ears: medium-dark skin tone	1F46F 1F3FE 200D 2642 FE0F	People & Body	person-activity	fully-qualified
👯🏿‍♂️	men with bunny ears: dark skin tone	1F46F 1F3FF 200D 2642 FE0F	People & Body	person-activity	fully-qualified
👯‍♀️	women with bunny ears	1F46F 200D 2640 FE0F	People & Body	person-activity	fully-qualified
👯🏻‍♀️	women with bunny ears: light skin tone	1F46F 1F3FB 200D 2640 FE0F	People & Body	person-activity	fully-qualified
👯🏼‍♀️	women with bunny ears: medium-light skin tone	1F46F 1F3FC 200D 2640 FE0F	People & Body	person-activity	fully-qualified
👯🏽‍♀️	women with bunny ears: medium skin tone	1F46F 1F3FD 200D 2640 FE0F	People & Body	person-activity	fully-qualified
👯🏾‍♀️	women with bunny ears: medium-dark skin tone	1F46F 1F3FE 200D 2640 FE0F	People & Body	person-activity	fully-qualified
👯🏿‍♀️	women with bunny ears: dark skin tone	1F46F 1F3FF 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧑🏻‍🐰‍🧑🏼	people with bunny ears: light skin tone, medium-light skin tone	1F9D1 1F3FB 200D 1F430 200D 1F9D1 1F3FC	People & Body	person-activity	fully-qualified
🧑🏻‍🐰‍🧑🏽	people with bunny ears: light skin tone, medium skin tone	1F9D1 1F3FB 200D 1F430 200D 1F9D1 1F3FD	People & Body	person-activity	fully-qualified
🧑🏻‍🐰‍🧑🏾	people with bunny ears: light skin tone, medium-dark skin tone	1F9D1 1F3FB 200D 1F430 200D 1F9D1 1F3FE	People & Body	person-activity	fully-qualified
🧑🏻‍🐰‍🧑🏿	people with bunny ears: light skin tone, dark skin tone	1F9D1 1F3FB 200D 1F430 200D 1F9D1 1F3FF	People & Body	person-activity	fully-qualified
🧑🏼‍🐰‍🧑🏻	people with bunny ears: medium-light skin tone, light skin tone	1F9D1 1F3FC 200D 1F430 200D 1F9D1 1F3FB	People & Body	person-activity	fully-qualified
🧑🏼‍🐰‍🧑🏽	people with bunny ears: medium-light skin tone, medium skin tone	1F9D1 1F3FC 200D 1F430 200D 1F9D1 1F3FD	People & Body	person-activity	fully-qualified
🧑🏼‍🐰‍🧑🏾	people with bunny ears: medium-light skin tone, medium-dark skin tone	1F9D1 1F3FC 200D 1F430 200D 1F9D1 1F3FE	People & Body	person-activity	fully-qualified
🧑🏼‍🐰‍🧑🏿	people with bunny ears: medium-light skin tone, dark skin tone	1F9D1 1F3FC 200D 1F430 200D 1F9D1 1F3FF	People & Body	person-activity	fully-qualified
🧑🏽‍🐰‍🧑🏻	people with bunny ears: medium skin tone, light skin tone	1F9D1 1F3FD 200D 1F430 200D 1F9D1 1F3FB	People & Body	person-activity	fully-qualified
🧑🏽‍🐰‍🧑🏼	people with bunny ears: medium skin tone, medium-light skin tone	1F9D1 1F3FD 200D 1F430 200D 1F9D1 1F3FC	People & Body	person-activity	fully-qualified
🧑🏽‍🐰‍🧑🏾	people with bunny ears: medium skin tone, medium-dark skin tone	1F9D1 1F3FD 200D 1F430 200D 1F9D1 1F3FE	People & Body	person-activity	fully-qualified
🧑🏽‍🐰‍🧑🏿	people with bunny ears: medium skin tone, dark skin tone	1F9D1 1F3FD 200D 1F430 200D 1F9D1 1F3FF	People & Body	person-activity	fully-qualified
🧑🏾‍🐰‍🧑🏻	people with bunny ears: medium-dark skin tone, light skin tone	1F9D1 1F3FE 200D 1F430 200D 1F9D1 1F3FB	People & Body	person-activity	fully-qualified
🧑🏾‍🐰‍🧑🏼	people with bunny ears: medium-dark skin tone, medium-light skin tone	1F9D1 1F3FE 200D 1F430 200D 1F9D1 1F3FC	People & Body	person-activity	fully-qualified
🧑🏾‍🐰‍🧑🏽	people with bunny ears: medium-dark skin tone, medium skin tone	1F9D1 1F3FE 200D 1F430 200D 1F9D1 1F3FD	People & Body	person-activity	fully-qualified
🧑🏾‍🐰‍🧑🏿	people with bunny ears: medium-dark skin tone, dark skin tone	1F9D1 1F3FE 200D 1F430 200D 1F9D1 1F3FF	People & Body	person-activity	fully-qualified
🧑🏿‍🐰‍🧑🏻	people with bunny ears: dark skin tone, light skin tone	1F9D1 1F3FF 200D 1F430 200D 1F9D1 1F3FB	People & Body	person-activity	fully-qualified
🧑🏿‍🐰‍🧑🏼	people with bunny ears: dark skin tone, medium-light skin tone	1F9D1 1F3FF 200D 1F430 200D 1F9D1 1F3FC	People & Body	person-activity	fully-qualified
🧑🏿‍🐰‍🧑🏽	people with bunny ears: dark skin tone, medium skin tone	1F9D1 1F3FF 200D 1F430 200D 1F9D1 1F3FD	People & Body	person-activity	fully-qualified
🧑🏿‍🐰‍🧑🏾	people with bunny ears: dark skin tone, medium-dark skin tone	1F9D1 1F3FF 200D 1F430 200D 1F9D1 1F3FE	People & Body	person-activity	fully-qualified
👨🏻‍🐰‍👨🏼	men with bunny ears: light skin tone, medium-light skin tone	1F468 1F3FB 200D 1F430 200D 1F468 1F3FC	People & Body	person-activity	fully-qualified
👨🏻‍🐰‍👨🏽	men with bunny ears: light skin tone, medium skin tone	1F468 1F3FB 200D 1F430 200D 1F468 1F3FD	People & Body	person-activity	fully-qualified
👨🏻‍🐰‍👨🏾	men with bunny ears: light skin tone, medium-dark skin tone	1F468 1F3FB 200D 1F430 200D 1F468 1F3FE	People & Body	person-activity	fully-qualified
👨🏻‍🐰‍👨🏿	men with bunny ears: light skin tone, dark skin tone	1F468 1F3FB 200D 1F430 200D 1F468 1F3FF	People & Body	person-activity	fully-qualified
👨🏼‍🐰‍👨🏻	men with bunny ears: medium-light skin tone, light skin tone	1F468 1F3FC 200D 1F430 200D 1F468 1F3FB	People & Body	person-activity	fully-qualified
👨🏼‍🐰‍👨🏽	men with bunny ears: medium-light skin tone, medium skin tone	1F468 1F3FC 200D 1F430 200D 1F468 1F3FD	People & Body	person-activity	fully-qualified
👨🏼‍🐰‍👨🏾	men with bunny ears: medium-light skin tone, medium-dark skin tone	1F468 1F3FC 200D 1F430 200D 1F468 1F3FE	People & Body	person-activity	fully-qualified
👨🏼‍🐰‍👨🏿	men with bunny ears: medium-light skin tone, dark skin tone	1F468 1F3FC 200D 1F430 200D 1F468 1F3FF	People & Body	person-activity	fully-qualified
👨🏽‍🐰‍👨🏻	men with bunny ears: medium skin tone, light skin tone	1F468 1F3FD 200D 1F430 200D 1F468 1F3FB	People & Body	person-activity	fully-qualified
👨🏽‍🐰‍👨🏼	men with bunny ears: medium skin tone, medium-light skin tone	1F468 1F3FD 200D 1F430 200D 1F468 1F3FC	People & Body	person-activity	fully-qualified
👨🏽‍🐰‍👨🏾	men with bunny ears: medium skin tone, medium-dark skin tone	1F468 1F3FD 200D 1F430 200D 1F468 1F3FE	People & Body	person-activity	fully-qualified
👨🏽‍🐰‍👨🏿	men with bunny ears: medium skin tone, dark skin tone	1F468 1F3FD 200D 1F430 200D 1F468 1F3FF	People & Body	person-activity	fully-qualified
👨🏾‍🐰‍👨🏻	men with bunny ears: medium-dark skin tone, light skin tone	1F468 1F3FE 200D 1F430 200D 1F468 1F3FB	People & Body	person-activity	fully-qualified
👨🏾‍🐰‍👨🏼	men with bunny ears: medium-dark skin tone, medium-light skin tone	1F468 1F3FE 200D 1F430 200D 1F468 1F3FC	People & Body	person-activity	fully-qualified
👨🏾‍🐰‍👨🏽	men with bunny ears: medium-dark skin tone, medium skin tone	1F468 1F3FE 200D 1F430 200D 1F468 1F3FD	People & Body	person-activity	fully-qualified
👨🏾‍🐰‍👨🏿	men with bunny ears: medium-dark skin tone, dark skin tone	1F468 1F3FE 200D 1F430 200D 1F468 1F3FF	People & Body	person-activity	fully-qualified
👨🏿‍🐰‍👨🏻	men with bunny ears: dark skin tone, light skin tone	1F468 1F3FF 200D 1F430 200D 1F468 1F3FB	People & Body	person-activity	fully-qualified
👨🏿‍🐰‍👨🏼	men with bunny ears: dark skin tone, medium-light skin tone	1F468 1F3FF 200D 1F430 200D 1F468 1F3FC	People & Body	person-activity	fully-qualified
👨🏿‍🐰‍👨🏽	men with bunny ears: dark skin tone, medium skin tone	1F468 1F3FF 200D 1F430 200D 1F468 1F3FD	People & Body	person-activity	fully-qualified
👨🏿‍🐰‍👨🏾	men with bunny ears: dark skin tone, medium-dark skin tone	1F468 1F3FF 200D 1F430 200D 1F468 1F3FE	People & Body	person-activity	fully-qualified
👩🏻‍🐰‍👩🏼	women with bunny ears: light skin tone, medium-light skin tone	1F469 1F3FB 200D 1F430 200D 1F469 1F3FC	People & Body	person-activity	fully-qualified
👩🏻‍🐰‍👩🏽	women with bunny ears: light skin tone, medium skin tone	1F469 1F3FB 200D 1F430 200D 1F469 1F3FD	People & Body	person-activity	fully-qualified
👩🏻‍🐰‍👩🏾	women with bunny ears: light skin tone, medium-dark skin tone	1F469 1F3FB 200D 1F430 200D 1F469 1F3FE	People & Body	person-activity	fully-qualified
👩🏻‍🐰‍👩🏿	women with bunny ears: light skin tone, dark skin tone	1F469 1F3FB 200D 1F430 200D 1F469 1F3FF	People & Body	person-activity	fully-qualified
👩🏼‍🐰‍👩🏻	women with bunny ears: medium-light skin tone, light skin tone	1F469 1F3FC 200D 1F430 200D 1F469 1F3FB	People & Body	person-activity	fully-qualified
👩🏼‍🐰‍👩🏽	women with bunny ears: medium-light skin tone, medium skin tone	1F469 1F3FC 200D 1F430 200D 1F469 1F3FD	People & Body	person-activity	fully-qualified
👩🏼‍🐰‍👩🏾	women with bunny ears: medium-light skin tone, medium-dark skin tone	1F469 1F3FC 200D 1F430 200D 1F469 1F3FE	People & Body	person-activity	fully-qualified
👩🏼‍🐰‍👩🏿	women with bunny ears: medium-light skin tone, dark skin tone	1F469 1F3FC 200D 1F430 200D 1F469 1F3FF	People & Body	person-activity	fully-qualified
👩🏽‍🐰‍👩🏻	women with bunny ears: medium skin tone, light skin tone	1F469 1F3FD 200D 1F430 200D 1F469 1F3FB	People & Body	person-activity	fully-qualified
👩🏽‍🐰‍👩🏼	women with bunny ears: medium skin tone, medium-light skin tone	1F469 1F3FD 200D 1F430 200D 1F469 1F3FC	People & Body	person-activity	fully-qualified
👩🏽‍🐰‍👩🏾	women with bunny ears: medium skin tone, medium-dark skin tone	1F469 1F3FD 200D 1F430 200D 1F469 1F3FE	People & Body	person-activity	fully-qualified
👩🏽‍🐰‍👩🏿	women with bunny ears: medium skin tone, dark skin tone	1F469 1F3FD 200D 1F430 200D 1F469 1F3FF	People & Body	person-activity	fully-qualified
👩🏾‍🐰‍👩🏻	women with bunny ears: medium-dark skin tone, light skin tone	1F469 1F3FE 200D 1F430 200D 1F469 1F3FB	People & Body	person-activity	fully-qualified
👩🏾‍🐰‍👩🏼	women with bunny ears: medium-dark skin tone, medium-light skin tone	1F469 1F3FE 200D 1F430 200D 1F469 1F3FC	People & Body	person-activity	fully-qualified
👩🏾‍🐰‍👩🏽	women with bunny ears: medium-dark skin tone, medium skin tone	1F469 1F3FE 200D 1F430 200D 1F469 1F3FD	People & Body	person-activity	fully-qualified
👩🏾‍🐰‍👩🏿	women with bunny ears: medium-dark skin tone, dark skin tone	1F469 1F3FE 200D 1F430 200D 1F469 1F3FF	People & Body	person-activity	fully-qualified
👩🏿‍🐰‍👩🏻	women with bunny ears: dark skin tone, light skin tone	1F469 1F3FF 200D 1F430 200D 1F469 1F3FB	People & Body	person-activity	fully-qualified
👩🏿‍🐰‍👩🏼	women with bunny ears: dark skin tone, medium-light skin tone	1F469 1F3FF 200D 1F430 200D 1F469 1F3FC	People & Body	person-activity	fully-qualified
👩🏿‍🐰‍👩🏽	women with bunny ears: dark skin tone, medium skin tone	1F469 1F3FF 200D 1F430 200D 1F469 1F3FD	People & Body	person-activity	fully-qualified
👩🏿‍🐰‍👩🏾	women with bunny ears: dark skin tone, medium-dark skin tone	1F469 1F3FF 200D 1F430 200D 1F469 1F3FE	People & Body	person-activity	fully-qualified
🧖	person in steamy room	1F9D6	People & Body	person-activity	fully-qualified
🧖🏻	person in steamy room: light skin tone	1F9D6 1F3FB	People & Body	person-activity	fully-qualified
🧖🏼	person in steamy room: medium-light skin tone	1F9D6 1F3FC	People & Body	person-activity	fully-qualified
🧖🏽	person in steamy room: medium skin tone	1F9D6 1F3FD	People & Body	person-activity	fully-qualified
🧖🏾	person in steamy room: medium-dark skin tone	1F9D6 1F3FE	People & Body	person-activity	fully-qualified
🧖🏿	person in steamy room: dark skin tone	1F9D6 1F3FF	People & Body	person-activity	fully-qualified
🧖‍♂️	man in steamy room	1F9D6 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧖🏻‍♂️	man in steamy room: light skin tone	1F9D6 1F3FB 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧖🏼‍♂️	man in steamy room: medium-light skin tone	1F9D6 1F3FC 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧖🏽‍♂️	man in steamy room: medium skin tone	1F9D6 1F3FD 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧖🏾‍♂️	man in steamy room: medium-dark skin tone	1F9D6 1F3FE 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧖🏿‍♂️	man in steamy room: dark skin tone	1F9D6 1F3FF 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧖‍♀️	woman in steamy room	1F9D6 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧖🏻‍♀️	woman in steamy room: light skin tone	1F9D6 1F3FB 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧖🏼‍♀️	woman in steamy room: medium-light skin tone	1F9D6 1F3FC 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧖🏽‍♀️	woman in steamy room: medium skin tone	1F9D6 1F3FD 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧖🏾‍♀️	woman in steamy room: medium-dark skin tone	1F9D6 1F3FE 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧖🏿‍♀️	woman in steamy room: dark skin tone	1F9D6 1F3FF 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧗	person climbing	1F9D7	People & Body	person-activity	fully-qualified
🧗🏻	person climbing: light skin tone	1F9D7 1F3FB	People & Body	person-activity	fully-qualified
🧗🏼	person climbing: medium-light skin tone	1F9D7 1F3FC	People & Body	person-activity	fully-qualified
🧗🏽	person climbing: medium skin tone	1F9D7 1F3FD	People & Body	person-activity	fully-qualified
🧗🏾	person climbing: medium-dark skin tone	1F9D7 1F3FE	People & Body	person-activity	fully-qualified
🧗🏿	person climbing: dark skin tone	1F9D7 1F3FF	People & Body	person-activity	fully-qualified
🧗‍♂️	man climbing	1F9D7 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧗🏻‍♂️	man climbing: light skin tone	1F9D7 1F3FB 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧗🏼‍♂️	man climbing: medium-light skin tone	1F9D7 1F3FC 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧗🏽‍♂️	man climbing: medium skin tone	1F9D7 1F3FD 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧗🏾‍♂️	man climbing: medium-dark skin tone	1F9D7 1F3FE 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧗🏿‍♂️	man climbing: dark skin tone	1F9D7 1F3FF 200D 2642 FE0F	People & Body	person-activity	fully-qualified
🧗‍♀️	woman climbing	1F9D7 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧗🏻‍♀️	woman climbing: light skin tone	1F9D7 1F3FB 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧗🏼‍♀️	woman climbing: medium-light skin tone	1F9D7 1F3FC 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧗🏽‍♀️	woman climbing: medium skin tone	1F9D7 1F3FD 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧗🏾‍♀️	woman climbing: medium-dark skin tone	1F9D7 1F3FE 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🧗🏿‍♀️	woman climbing: dark skin tone	1F9D7 1F3FF 200D 2640 FE0F	People & Body	person-activity	fully-qualified
🤺	person fencing	1F93A	People & Body	person-sport	fully-qualified
🏇	horse racing	1F3C7	People & Body	person-sport	fully-qualified
🏇🏻	horse racing: light skin tone	1F3C7 1F3FB	People & Body	person-sport	fully-qualified
🏇🏼	horse racing: medium-light skin tone	1F3C7 1F3FC	People & Body	person-sport	fully-qualified
🏇🏽	horse racing: medium skin tone	1F3C7 1F3FD	People & Body	person-sport	fully-qualified
🏇🏾	horse racing: medium-dark skin tone	1F3C7 1F3FE	People & Body	person-sport	fully-qualified
🏇🏿	horse racing: dark skin tone	1F3C7 1F3FF	People & Body	person-sport	fully-qualified
⛷️	skier	26F7 FE0F	People & Body	person-sport	fully-qualified
🏂	snowboarder	1F3C2	People & Body	person-sport	fully-qualified
🏂🏻	snowboarder: light skin tone	1F3C2 1F3FB	People & Body	person-sport	fully-qualified
🏂🏼	snowboarder: medium-light skin tone	1F3C2 1F3FC	People & Body	person-sport	fully-qualified
🏂🏽	snowboarder: medium skin tone	1F3C2 1F3FD	People & Body	person-sport	fully-qualified
🏂🏾	snowboarder: medium-dark skin tone	1F3C2 1F3FE	People & Body	person-sport	fully-qualified
🏂🏿	snowboarder: dark skin tone	1F3C2 1F3FF	People & Body	person-sport	fully-qualified
🏌️	person golfing	1F3CC FE0F	People & Body	person-sport	fully-qualified
🏌🏻	person golfing: light skin tone	1F3CC 1F3FB	People & Body	person-sport	fully-qualified
🏌🏼	person golfing: medium-light skin tone	1F3CC 1F3FC	People & Body	person-sport	fully-qualified
🏌🏽	person golfing: medium skin tone	1F3CC 1F3FD	People & Body	person-sport	fully-qualified
🏌🏾	person golfing: medium-dark skin tone	1F3CC 1F3FE	People & Body	person-sport	fully-qualified
🏌🏿	person golfing: dark skin tone	1F3CC 1F3FF	People & Body	person-sport	fully-qualified
🏌️‍♂️	man golfing	1F3CC FE0F 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏌🏻‍♂️	man golfing: light skin tone	1F3CC 1F3FB 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏌🏼‍♂️	man golfing: medium-light skin tone	1F3CC 1F3FC 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏌🏽‍♂️	man golfing: medium skin tone	1F3CC 1F3FD 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏌🏾‍♂️	man golfing: medium-dark skin tone	1F3CC 1F3FE 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏌🏿‍♂️	man golfing: dark skin tone	1F3CC 1F3FF 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏌️‍♀️	woman golfing	1F3CC FE0F 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏌🏻‍♀️	woman golfing: light skin tone	1F3CC 1F3FB 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏌🏼‍♀️	woman golfing: medium-light skin tone	1F3CC 1F3FC 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏌🏽‍♀️	woman golfing: medium skin tone	1F3CC 1F3FD 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏌🏾‍♀️	woman golfing: medium-dark skin tone	1F3CC 1F3FE 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏌🏿‍♀️	woman golfing: dark skin tone	1F3CC 1F3FF 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏄	person surfing	1F3C4	People & Body	person-sport	fully-qualified
🏄🏻	person surfing: light skin tone	1F3C4 1F3FB	People & Body	person-sport	fully-qualified
🏄🏼	person surfing: medium-light skin tone	1F3C4 1F3FC	People & Body	person-sport	fully-qualified
🏄🏽	person surfing: medium skin tone	1F3C4 1F3FD	People & Body	person-sport	fully-qualified
🏄🏾	person surfing: medium-dark skin tone	1F3C4 1F3FE	People & Body	person-sport	fully-qualified
🏄🏿	person surfing: dark skin tone	1F3C4 1F3FF	People & Body	person-sport	fully-qualified
🏄‍♂️	man surfing	1F3C4 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏄🏻‍♂️	man surfing: light skin tone	1F3C4 1F3FB 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏄🏼‍♂️	man surfing: medium-light skin tone	1F3C4 1F3FC 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏄🏽‍♂️	man surfing: medium skin tone	1F3C4 1F3FD 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏄🏾‍♂️	man surfing: medium-dark skin tone	1F3C4 1F3FE 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏄🏿‍♂️	man surfing: dark skin tone	1F3C4 1F3FF 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏄‍♀️	woman surfing	1F3C4 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏄🏻‍♀️	woman surfing: light skin tone	1F3C4 1F3FB 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏄🏼‍♀️	woman surfing: medium-light skin tone	1F3C4 1F3FC 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏄🏽‍♀️	woman surfing: medium skin tone	1F3C4 1F3FD 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏄🏾‍♀️	woman surfing: medium-dark skin tone	1F3C4 1F3FE 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏄🏿‍♀️	woman surfing: dark skin tone	1F3C4 1F3FF 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🚣	person rowing boat	1F6A3	People & Body	person-sport	fully-qualified
🚣🏻	person rowing boat: light skin tone	1F6A3 1F3FB	People & Body	person-sport	fully-qualified
🚣🏼	person rowing boat: medium-light skin tone	1F6A3 1F3FC	People & Body	person-sport	fully-qualified
🚣🏽	person rowing boat: medium skin tone	1F6A3 1F3FD	People & Body	person-sport	fully-qualified
🚣🏾	person rowing boat: medium-dark skin tone	1F6A3 1F3FE	People & Body	person-sport	fully-qualified
🚣🏿	person rowing boat: dark skin tone	1F6A3 1F3FF	People & Body	person-sport	fully-qualified
🚣‍♂️	man rowing boat	1F6A3 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🚣🏻‍♂️	man rowing boat: light skin tone	1F6A3 1F3FB 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🚣🏼‍♂️	man rowing boat: medium-light skin tone	1F6A3 1F3FC 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🚣🏽‍♂️	man rowing boat: medium skin tone	1F6A3 1F3FD 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🚣🏾‍♂️	man rowing boat: medium-dark skin tone	1F6A3 1F3FE 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🚣🏿‍♂️	man rowing boat: dark skin tone	1F6A3 1F3FF 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🚣‍♀️	woman rowing boat	1F6A3 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🚣🏻‍♀️	woman rowing boat: light skin tone	1F6A3 1F3FB 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🚣🏼‍♀️	woman rowing boat: medium-light skin tone	1F6A3 1F3FC 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🚣🏽‍♀️	woman rowing boat: medium skin tone	1F6A3 1F3FD 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🚣🏾‍♀️	woman rowing boat: medium-dark skin tone	1F6A3 1F3FE 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🚣🏿‍♀️	woman rowing boat: dark skin tone	1F6A3 1F3FF 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏊	person swimming	1F3CA	People & Body	person-sport	fully-qualified
🏊🏻	person swimming: light skin tone	1F3CA 1F3FB	People & Body	person-sport	fully-qualified
🏊🏼	person swimming: medium-light skin tone	1F3CA 1F3FC	People & Body	person-sport	fully-qualified
🏊🏽	person swimming: medium skin tone	1F3CA 1F3FD	People & Body	person-sport	fully-qualified
🏊🏾	person swimming: medium-dark skin tone	1F3CA 1F3FE	People & Body	person-sport	fully-qualified
🏊🏿	person swimming: dark skin tone	1F3CA 1F3FF	People & Body	person-sport	fully-qualified
🏊‍♂️	man swimming	1F3CA 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏊🏻‍♂️	man swimming: light skin tone	1F3CA 1F3FB 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏊🏼‍♂️	man swimming: medium-light skin tone	1F3CA 1F3FC 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏊🏽‍♂️	man swimming: medium skin tone	1F3CA 1F3FD 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏊🏾‍♂️	man swimming: medium-dark skin tone	1F3CA 1F3FE 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏊🏿‍♂️	man swimming: dark skin tone	1F3CA 1F3FF 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏊‍♀️	woman swimming	1F3CA 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏊🏻‍♀️	woman swimming: light skin tone	1F3CA 1F3FB 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏊🏼‍♀️	woman swimming: medium-light skin tone	1F3CA 1F3FC 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏊🏽‍♀️	woman swimming: medium skin tone	1F3CA 1F3FD 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏊🏾‍♀️	woman swimming: medium-dark skin tone	1F3CA 1F3FE 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏊🏿‍♀️	woman swimming: dark skin tone	1F3CA 1F3FF 200D 2640 FE0F	People & Body	person-sport	fully-qualified
⛹️	person bouncing ball	26F9 FE0F	People & Body	person-sport	fully-qualified
⛹🏻	person bouncing ball: light skin tone	26F9 1F3FB	People & Body	person-sport	fully-qualified
⛹🏼	person bouncing ball: medium-light skin tone	26F9 1F3FC	People & Body	person-sport	fully-qualified
⛹🏽	person bouncing ball: medium skin tone	26F9 1F3FD	People & Body	person-sport	fully-qualified
⛹🏾	person bouncing ball: medium-dark skin tone	26F9 1F3FE	People & Body	person-sport	fully-qualified
⛹🏿	person bouncing ball: dark skin tone	26F9 1F3FF	People & Body	person-sport	fully-qualified
⛹️‍♂️	man bouncing ball	26F9 FE0F 200D 2642 FE0F	People & Body	person-sport	fully-qualified
⛹🏻‍♂️	man bouncing ball: light skin tone	26F9 1F3FB 200D 2642 FE0F	People & Body	person-sport	fully-qualified
⛹🏼‍♂️	man bouncing ball: medium-light skin tone	26F9 1F3FC 200D 2642 FE0F	People & Body	person-sport	fully-qualified
⛹🏽‍♂️	man bouncing ball: medium skin tone	26F9 1F3FD 200D 2642 FE0F	People & Body	person-sport	fully-qualified
⛹🏾‍♂️	man bouncing ball: medium-dark skin tone	26F9 1F3FE 200D 2642 FE0F	People & Body	person-sport	fully-qualified
⛹🏿‍♂️	man bouncing ball: dark skin tone	26F9 1F3FF 200D 2642 FE0F	People & Body	person-sport	fully-qualified
⛹️‍♀️	woman bouncing ball	26F9 FE0F 200D 2640 FE0F	People & Body	person-sport	fully-qualified
⛹🏻‍♀️	woman bouncing ball: light skin tone	26F9 1F3FB 200D 2640 FE0F	People & Body	person-sport	fully-qualified
⛹🏼‍♀️	woman bouncing ball: medium-light skin tone	26F9 1F3FC 200D 2640 FE0F	People & Body	person-sport	fully-qualified
⛹🏽‍♀️	woman bouncing ball: medium skin tone	26F9 1F3FD 200D 2640 FE0F	People & Body	person-sport	fully-qualified
⛹🏾‍♀️	woman bouncing ball: medium-dark skin tone	26F9 1F3FE 200D 2640 FE0F	People & Body	person-sport	fully-qualified
⛹🏿‍♀️	woman bouncing ball: dark skin tone	26F9 1F3FF 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏋️	person lifting weights	1F3CB FE0F	People & Body	person-sport	fully-qualified
🏋🏻	person lifting weights: light skin tone	1F3CB 1F3FB	People & Body	person-sport	fully-qualified
🏋🏼	person lifting weights: medium-light skin tone	1F3CB 1F3FC	People & Body	person-sport	fully-qualified
🏋🏽	person lifting weights: medium skin tone	1F3CB 1F3FD	People & Body	person-sport	fully-qualified
🏋🏾	person lifting weights: medium-dark skin tone	1F3CB 1F3FE	People & Body	person-sport	fully-qualified
🏋🏿	person lifting weights: dark skin tone	1F3CB 1F3FF	People & Body	person-sport	fully-qualified
🏋️‍♂️	man lifting weights	1F3CB FE0F 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏋🏻‍♂️	man lifting weights: light skin tone	1F3CB 1F3FB 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏋🏼‍♂️	man lifting weights: medium-light skin tone	1F3CB 1F3FC 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏋🏽‍♂️	man lifting weights: medium skin tone	1F3CB 1F3FD 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏋🏾‍♂️	man lifting weights: medium-dark skin tone	1F3CB 1F3FE 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏋🏿‍♂️	man lifting weights: dark skin tone	1F3CB 1F3FF 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🏋️‍♀️	woman lifting weights	1F3CB FE0F 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏋🏻‍♀️	woman lifting weights: light skin tone	1F3CB 1F3FB 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏋🏼‍♀️	woman lifting weights: medium-light skin tone	1F3CB 1F3FC 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏋🏽‍♀️	woman lifting weights: medium skin tone	1F3CB 1F3FD 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏋🏾‍♀️	woman lifting weights: medium-dark skin tone	1F3CB 1F3FE 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🏋🏿‍♀️	woman lifting weights: dark skin tone	1F3CB 1F3FF 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🚴	person biking	1F6B4	People & Body	person-sport	fully-qualified
🚴🏻	person biking: light skin tone	1F6B4 1F3FB	People & Body	person-sport	fully-qualified
🚴🏼	person biking: medium-light skin tone	1F6B4 1F3FC	People & Body	person-sport	fully-qualified
🚴🏽	person biking: medium skin tone	1F6B4 1F3FD	People & Body	person-sport	fully-qualified
        """.trimIndent(),

        """
🚴🏾	person biking: medium-dark skin tone	1F6B4 1F3FE	People & Body	person-sport	fully-qualified
🚴🏿	person biking: dark skin tone	1F6B4 1F3FF	People & Body	person-sport	fully-qualified
🚴‍♂️	man biking	1F6B4 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🚴🏻‍♂️	man biking: light skin tone	1F6B4 1F3FB 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🚴🏼‍♂️	man biking: medium-light skin tone	1F6B4 1F3FC 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🚴🏽‍♂️	man biking: medium skin tone	1F6B4 1F3FD 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🚴🏾‍♂️	man biking: medium-dark skin tone	1F6B4 1F3FE 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🚴🏿‍♂️	man biking: dark skin tone	1F6B4 1F3FF 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🚴‍♀️	woman biking	1F6B4 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🚴🏻‍♀️	woman biking: light skin tone	1F6B4 1F3FB 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🚴🏼‍♀️	woman biking: medium-light skin tone	1F6B4 1F3FC 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🚴🏽‍♀️	woman biking: medium skin tone	1F6B4 1F3FD 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🚴🏾‍♀️	woman biking: medium-dark skin tone	1F6B4 1F3FE 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🚴🏿‍♀️	woman biking: dark skin tone	1F6B4 1F3FF 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🚵	person mountain biking	1F6B5	People & Body	person-sport	fully-qualified
🚵🏻	person mountain biking: light skin tone	1F6B5 1F3FB	People & Body	person-sport	fully-qualified
🚵🏼	person mountain biking: medium-light skin tone	1F6B5 1F3FC	People & Body	person-sport	fully-qualified
🚵🏽	person mountain biking: medium skin tone	1F6B5 1F3FD	People & Body	person-sport	fully-qualified
🚵🏾	person mountain biking: medium-dark skin tone	1F6B5 1F3FE	People & Body	person-sport	fully-qualified
🚵🏿	person mountain biking: dark skin tone	1F6B5 1F3FF	People & Body	person-sport	fully-qualified
🚵‍♂️	man mountain biking	1F6B5 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🚵🏻‍♂️	man mountain biking: light skin tone	1F6B5 1F3FB 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🚵🏼‍♂️	man mountain biking: medium-light skin tone	1F6B5 1F3FC 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🚵🏽‍♂️	man mountain biking: medium skin tone	1F6B5 1F3FD 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🚵🏾‍♂️	man mountain biking: medium-dark skin tone	1F6B5 1F3FE 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🚵🏿‍♂️	man mountain biking: dark skin tone	1F6B5 1F3FF 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🚵‍♀️	woman mountain biking	1F6B5 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🚵🏻‍♀️	woman mountain biking: light skin tone	1F6B5 1F3FB 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🚵🏼‍♀️	woman mountain biking: medium-light skin tone	1F6B5 1F3FC 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🚵🏽‍♀️	woman mountain biking: medium skin tone	1F6B5 1F3FD 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🚵🏾‍♀️	woman mountain biking: medium-dark skin tone	1F6B5 1F3FE 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🚵🏿‍♀️	woman mountain biking: dark skin tone	1F6B5 1F3FF 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤸	person cartwheeling	1F938	People & Body	person-sport	fully-qualified
🤸🏻	person cartwheeling: light skin tone	1F938 1F3FB	People & Body	person-sport	fully-qualified
🤸🏼	person cartwheeling: medium-light skin tone	1F938 1F3FC	People & Body	person-sport	fully-qualified
🤸🏽	person cartwheeling: medium skin tone	1F938 1F3FD	People & Body	person-sport	fully-qualified
🤸🏾	person cartwheeling: medium-dark skin tone	1F938 1F3FE	People & Body	person-sport	fully-qualified
🤸🏿	person cartwheeling: dark skin tone	1F938 1F3FF	People & Body	person-sport	fully-qualified
🤸‍♂️	man cartwheeling	1F938 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤸🏻‍♂️	man cartwheeling: light skin tone	1F938 1F3FB 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤸🏼‍♂️	man cartwheeling: medium-light skin tone	1F938 1F3FC 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤸🏽‍♂️	man cartwheeling: medium skin tone	1F938 1F3FD 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤸🏾‍♂️	man cartwheeling: medium-dark skin tone	1F938 1F3FE 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤸🏿‍♂️	man cartwheeling: dark skin tone	1F938 1F3FF 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤸‍♀️	woman cartwheeling	1F938 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤸🏻‍♀️	woman cartwheeling: light skin tone	1F938 1F3FB 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤸🏼‍♀️	woman cartwheeling: medium-light skin tone	1F938 1F3FC 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤸🏽‍♀️	woman cartwheeling: medium skin tone	1F938 1F3FD 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤸🏾‍♀️	woman cartwheeling: medium-dark skin tone	1F938 1F3FE 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤸🏿‍♀️	woman cartwheeling: dark skin tone	1F938 1F3FF 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤼	people wrestling	1F93C	People & Body	person-sport	fully-qualified
🤼🏻	people wrestling: light skin tone	1F93C 1F3FB	People & Body	person-sport	fully-qualified
🤼🏼	people wrestling: medium-light skin tone	1F93C 1F3FC	People & Body	person-sport	fully-qualified
🤼🏽	people wrestling: medium skin tone	1F93C 1F3FD	People & Body	person-sport	fully-qualified
🤼🏾	people wrestling: medium-dark skin tone	1F93C 1F3FE	People & Body	person-sport	fully-qualified
🤼🏿	people wrestling: dark skin tone	1F93C 1F3FF	People & Body	person-sport	fully-qualified
🤼‍♂️	men wrestling	1F93C 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤼🏻‍♂️	men wrestling: light skin tone	1F93C 1F3FB 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤼🏼‍♂️	men wrestling: medium-light skin tone	1F93C 1F3FC 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤼🏽‍♂️	men wrestling: medium skin tone	1F93C 1F3FD 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤼🏾‍♂️	men wrestling: medium-dark skin tone	1F93C 1F3FE 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤼🏿‍♂️	men wrestling: dark skin tone	1F93C 1F3FF 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤼‍♀️	women wrestling	1F93C 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤼🏻‍♀️	women wrestling: light skin tone	1F93C 1F3FB 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤼🏼‍♀️	women wrestling: medium-light skin tone	1F93C 1F3FC 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤼🏽‍♀️	women wrestling: medium skin tone	1F93C 1F3FD 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤼🏾‍♀️	women wrestling: medium-dark skin tone	1F93C 1F3FE 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤼🏿‍♀️	women wrestling: dark skin tone	1F93C 1F3FF 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🧑🏻‍🫯‍🧑🏼	people wrestling: light skin tone, medium-light skin tone	1F9D1 1F3FB 200D 1FAEF 200D 1F9D1 1F3FC	People & Body	person-sport	fully-qualified
🧑🏻‍🫯‍🧑🏽	people wrestling: light skin tone, medium skin tone	1F9D1 1F3FB 200D 1FAEF 200D 1F9D1 1F3FD	People & Body	person-sport	fully-qualified
🧑🏻‍🫯‍🧑🏾	people wrestling: light skin tone, medium-dark skin tone	1F9D1 1F3FB 200D 1FAEF 200D 1F9D1 1F3FE	People & Body	person-sport	fully-qualified
🧑🏻‍🫯‍🧑🏿	people wrestling: light skin tone, dark skin tone	1F9D1 1F3FB 200D 1FAEF 200D 1F9D1 1F3FF	People & Body	person-sport	fully-qualified
🧑🏼‍🫯‍🧑🏻	people wrestling: medium-light skin tone, light skin tone	1F9D1 1F3FC 200D 1FAEF 200D 1F9D1 1F3FB	People & Body	person-sport	fully-qualified
🧑🏼‍🫯‍🧑🏽	people wrestling: medium-light skin tone, medium skin tone	1F9D1 1F3FC 200D 1FAEF 200D 1F9D1 1F3FD	People & Body	person-sport	fully-qualified
🧑🏼‍🫯‍🧑🏾	people wrestling: medium-light skin tone, medium-dark skin tone	1F9D1 1F3FC 200D 1FAEF 200D 1F9D1 1F3FE	People & Body	person-sport	fully-qualified
🧑🏼‍🫯‍🧑🏿	people wrestling: medium-light skin tone, dark skin tone	1F9D1 1F3FC 200D 1FAEF 200D 1F9D1 1F3FF	People & Body	person-sport	fully-qualified
🧑🏽‍🫯‍🧑🏻	people wrestling: medium skin tone, light skin tone	1F9D1 1F3FD 200D 1FAEF 200D 1F9D1 1F3FB	People & Body	person-sport	fully-qualified
🧑🏽‍🫯‍🧑🏼	people wrestling: medium skin tone, medium-light skin tone	1F9D1 1F3FD 200D 1FAEF 200D 1F9D1 1F3FC	People & Body	person-sport	fully-qualified
🧑🏽‍🫯‍🧑🏾	people wrestling: medium skin tone, medium-dark skin tone	1F9D1 1F3FD 200D 1FAEF 200D 1F9D1 1F3FE	People & Body	person-sport	fully-qualified
🧑🏽‍🫯‍🧑🏿	people wrestling: medium skin tone, dark skin tone	1F9D1 1F3FD 200D 1FAEF 200D 1F9D1 1F3FF	People & Body	person-sport	fully-qualified
🧑🏾‍🫯‍🧑🏻	people wrestling: medium-dark skin tone, light skin tone	1F9D1 1F3FE 200D 1FAEF 200D 1F9D1 1F3FB	People & Body	person-sport	fully-qualified
🧑🏾‍🫯‍🧑🏼	people wrestling: medium-dark skin tone, medium-light skin tone	1F9D1 1F3FE 200D 1FAEF 200D 1F9D1 1F3FC	People & Body	person-sport	fully-qualified
🧑🏾‍🫯‍🧑🏽	people wrestling: medium-dark skin tone, medium skin tone	1F9D1 1F3FE 200D 1FAEF 200D 1F9D1 1F3FD	People & Body	person-sport	fully-qualified
🧑🏾‍🫯‍🧑🏿	people wrestling: medium-dark skin tone, dark skin tone	1F9D1 1F3FE 200D 1FAEF 200D 1F9D1 1F3FF	People & Body	person-sport	fully-qualified
🧑🏿‍🫯‍🧑🏻	people wrestling: dark skin tone, light skin tone	1F9D1 1F3FF 200D 1FAEF 200D 1F9D1 1F3FB	People & Body	person-sport	fully-qualified
🧑🏿‍🫯‍🧑🏼	people wrestling: dark skin tone, medium-light skin tone	1F9D1 1F3FF 200D 1FAEF 200D 1F9D1 1F3FC	People & Body	person-sport	fully-qualified
🧑🏿‍🫯‍🧑🏽	people wrestling: dark skin tone, medium skin tone	1F9D1 1F3FF 200D 1FAEF 200D 1F9D1 1F3FD	People & Body	person-sport	fully-qualified
🧑🏿‍🫯‍🧑🏾	people wrestling: dark skin tone, medium-dark skin tone	1F9D1 1F3FF 200D 1FAEF 200D 1F9D1 1F3FE	People & Body	person-sport	fully-qualified
👨🏻‍🫯‍👨🏼	men wrestling: light skin tone, medium-light skin tone	1F468 1F3FB 200D 1FAEF 200D 1F468 1F3FC	People & Body	person-sport	fully-qualified
👨🏻‍🫯‍👨🏽	men wrestling: light skin tone, medium skin tone	1F468 1F3FB 200D 1FAEF 200D 1F468 1F3FD	People & Body	person-sport	fully-qualified
👨🏻‍🫯‍👨🏾	men wrestling: light skin tone, medium-dark skin tone	1F468 1F3FB 200D 1FAEF 200D 1F468 1F3FE	People & Body	person-sport	fully-qualified
👨🏻‍🫯‍👨🏿	men wrestling: light skin tone, dark skin tone	1F468 1F3FB 200D 1FAEF 200D 1F468 1F3FF	People & Body	person-sport	fully-qualified
👨🏼‍🫯‍👨🏻	men wrestling: medium-light skin tone, light skin tone	1F468 1F3FC 200D 1FAEF 200D 1F468 1F3FB	People & Body	person-sport	fully-qualified
👨🏼‍🫯‍👨🏽	men wrestling: medium-light skin tone, medium skin tone	1F468 1F3FC 200D 1FAEF 200D 1F468 1F3FD	People & Body	person-sport	fully-qualified
👨🏼‍🫯‍👨🏾	men wrestling: medium-light skin tone, medium-dark skin tone	1F468 1F3FC 200D 1FAEF 200D 1F468 1F3FE	People & Body	person-sport	fully-qualified
👨🏼‍🫯‍👨🏿	men wrestling: medium-light skin tone, dark skin tone	1F468 1F3FC 200D 1FAEF 200D 1F468 1F3FF	People & Body	person-sport	fully-qualified
👨🏽‍🫯‍👨🏻	men wrestling: medium skin tone, light skin tone	1F468 1F3FD 200D 1FAEF 200D 1F468 1F3FB	People & Body	person-sport	fully-qualified
👨🏽‍🫯‍👨🏼	men wrestling: medium skin tone, medium-light skin tone	1F468 1F3FD 200D 1FAEF 200D 1F468 1F3FC	People & Body	person-sport	fully-qualified
👨🏽‍🫯‍👨🏾	men wrestling: medium skin tone, medium-dark skin tone	1F468 1F3FD 200D 1FAEF 200D 1F468 1F3FE	People & Body	person-sport	fully-qualified
👨🏽‍🫯‍👨🏿	men wrestling: medium skin tone, dark skin tone	1F468 1F3FD 200D 1FAEF 200D 1F468 1F3FF	People & Body	person-sport	fully-qualified
👨🏾‍🫯‍👨🏻	men wrestling: medium-dark skin tone, light skin tone	1F468 1F3FE 200D 1FAEF 200D 1F468 1F3FB	People & Body	person-sport	fully-qualified
👨🏾‍🫯‍👨🏼	men wrestling: medium-dark skin tone, medium-light skin tone	1F468 1F3FE 200D 1FAEF 200D 1F468 1F3FC	People & Body	person-sport	fully-qualified
👨🏾‍🫯‍👨🏽	men wrestling: medium-dark skin tone, medium skin tone	1F468 1F3FE 200D 1FAEF 200D 1F468 1F3FD	People & Body	person-sport	fully-qualified
👨🏾‍🫯‍👨🏿	men wrestling: medium-dark skin tone, dark skin tone	1F468 1F3FE 200D 1FAEF 200D 1F468 1F3FF	People & Body	person-sport	fully-qualified
👨🏿‍🫯‍👨🏻	men wrestling: dark skin tone, light skin tone	1F468 1F3FF 200D 1FAEF 200D 1F468 1F3FB	People & Body	person-sport	fully-qualified
👨🏿‍🫯‍👨🏼	men wrestling: dark skin tone, medium-light skin tone	1F468 1F3FF 200D 1FAEF 200D 1F468 1F3FC	People & Body	person-sport	fully-qualified
👨🏿‍🫯‍👨🏽	men wrestling: dark skin tone, medium skin tone	1F468 1F3FF 200D 1FAEF 200D 1F468 1F3FD	People & Body	person-sport	fully-qualified
👨🏿‍🫯‍👨🏾	men wrestling: dark skin tone, medium-dark skin tone	1F468 1F3FF 200D 1FAEF 200D 1F468 1F3FE	People & Body	person-sport	fully-qualified
👩🏻‍🫯‍👩🏼	women wrestling: light skin tone, medium-light skin tone	1F469 1F3FB 200D 1FAEF 200D 1F469 1F3FC	People & Body	person-sport	fully-qualified
👩🏻‍🫯‍👩🏽	women wrestling: light skin tone, medium skin tone	1F469 1F3FB 200D 1FAEF 200D 1F469 1F3FD	People & Body	person-sport	fully-qualified
👩🏻‍🫯‍👩🏾	women wrestling: light skin tone, medium-dark skin tone	1F469 1F3FB 200D 1FAEF 200D 1F469 1F3FE	People & Body	person-sport	fully-qualified
👩🏻‍🫯‍👩🏿	women wrestling: light skin tone, dark skin tone	1F469 1F3FB 200D 1FAEF 200D 1F469 1F3FF	People & Body	person-sport	fully-qualified
👩🏼‍🫯‍👩🏻	women wrestling: medium-light skin tone, light skin tone	1F469 1F3FC 200D 1FAEF 200D 1F469 1F3FB	People & Body	person-sport	fully-qualified
👩🏼‍🫯‍👩🏽	women wrestling: medium-light skin tone, medium skin tone	1F469 1F3FC 200D 1FAEF 200D 1F469 1F3FD	People & Body	person-sport	fully-qualified
👩🏼‍🫯‍👩🏾	women wrestling: medium-light skin tone, medium-dark skin tone	1F469 1F3FC 200D 1FAEF 200D 1F469 1F3FE	People & Body	person-sport	fully-qualified
👩🏼‍🫯‍👩🏿	women wrestling: medium-light skin tone, dark skin tone	1F469 1F3FC 200D 1FAEF 200D 1F469 1F3FF	People & Body	person-sport	fully-qualified
👩🏽‍🫯‍👩🏻	women wrestling: medium skin tone, light skin tone	1F469 1F3FD 200D 1FAEF 200D 1F469 1F3FB	People & Body	person-sport	fully-qualified
👩🏽‍🫯‍👩🏼	women wrestling: medium skin tone, medium-light skin tone	1F469 1F3FD 200D 1FAEF 200D 1F469 1F3FC	People & Body	person-sport	fully-qualified
👩🏽‍🫯‍👩🏾	women wrestling: medium skin tone, medium-dark skin tone	1F469 1F3FD 200D 1FAEF 200D 1F469 1F3FE	People & Body	person-sport	fully-qualified
👩🏽‍🫯‍👩🏿	women wrestling: medium skin tone, dark skin tone	1F469 1F3FD 200D 1FAEF 200D 1F469 1F3FF	People & Body	person-sport	fully-qualified
👩🏾‍🫯‍👩🏻	women wrestling: medium-dark skin tone, light skin tone	1F469 1F3FE 200D 1FAEF 200D 1F469 1F3FB	People & Body	person-sport	fully-qualified
👩🏾‍🫯‍👩🏼	women wrestling: medium-dark skin tone, medium-light skin tone	1F469 1F3FE 200D 1FAEF 200D 1F469 1F3FC	People & Body	person-sport	fully-qualified
👩🏾‍🫯‍👩🏽	women wrestling: medium-dark skin tone, medium skin tone	1F469 1F3FE 200D 1FAEF 200D 1F469 1F3FD	People & Body	person-sport	fully-qualified
👩🏾‍🫯‍👩🏿	women wrestling: medium-dark skin tone, dark skin tone	1F469 1F3FE 200D 1FAEF 200D 1F469 1F3FF	People & Body	person-sport	fully-qualified
👩🏿‍🫯‍👩🏻	women wrestling: dark skin tone, light skin tone	1F469 1F3FF 200D 1FAEF 200D 1F469 1F3FB	People & Body	person-sport	fully-qualified
👩🏿‍🫯‍👩🏼	women wrestling: dark skin tone, medium-light skin tone	1F469 1F3FF 200D 1FAEF 200D 1F469 1F3FC	People & Body	person-sport	fully-qualified
👩🏿‍🫯‍👩🏽	women wrestling: dark skin tone, medium skin tone	1F469 1F3FF 200D 1FAEF 200D 1F469 1F3FD	People & Body	person-sport	fully-qualified
👩🏿‍🫯‍👩🏾	women wrestling: dark skin tone, medium-dark skin tone	1F469 1F3FF 200D 1FAEF 200D 1F469 1F3FE	People & Body	person-sport	fully-qualified
🤽	person playing water polo	1F93D	People & Body	person-sport	fully-qualified
🤽🏻	person playing water polo: light skin tone	1F93D 1F3FB	People & Body	person-sport	fully-qualified
🤽🏼	person playing water polo: medium-light skin tone	1F93D 1F3FC	People & Body	person-sport	fully-qualified
🤽🏽	person playing water polo: medium skin tone	1F93D 1F3FD	People & Body	person-sport	fully-qualified
🤽🏾	person playing water polo: medium-dark skin tone	1F93D 1F3FE	People & Body	person-sport	fully-qualified
🤽🏿	person playing water polo: dark skin tone	1F93D 1F3FF	People & Body	person-sport	fully-qualified
🤽‍♂️	man playing water polo	1F93D 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤽🏻‍♂️	man playing water polo: light skin tone	1F93D 1F3FB 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤽🏼‍♂️	man playing water polo: medium-light skin tone	1F93D 1F3FC 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤽🏽‍♂️	man playing water polo: medium skin tone	1F93D 1F3FD 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤽🏾‍♂️	man playing water polo: medium-dark skin tone	1F93D 1F3FE 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤽🏿‍♂️	man playing water polo: dark skin tone	1F93D 1F3FF 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤽‍♀️	woman playing water polo	1F93D 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤽🏻‍♀️	woman playing water polo: light skin tone	1F93D 1F3FB 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤽🏼‍♀️	woman playing water polo: medium-light skin tone	1F93D 1F3FC 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤽🏽‍♀️	woman playing water polo: medium skin tone	1F93D 1F3FD 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤽🏾‍♀️	woman playing water polo: medium-dark skin tone	1F93D 1F3FE 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤽🏿‍♀️	woman playing water polo: dark skin tone	1F93D 1F3FF 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤾	person playing handball	1F93E	People & Body	person-sport	fully-qualified
🤾🏻	person playing handball: light skin tone	1F93E 1F3FB	People & Body	person-sport	fully-qualified
🤾🏼	person playing handball: medium-light skin tone	1F93E 1F3FC	People & Body	person-sport	fully-qualified
🤾🏽	person playing handball: medium skin tone	1F93E 1F3FD	People & Body	person-sport	fully-qualified
🤾🏾	person playing handball: medium-dark skin tone	1F93E 1F3FE	People & Body	person-sport	fully-qualified
🤾🏿	person playing handball: dark skin tone	1F93E 1F3FF	People & Body	person-sport	fully-qualified
🤾‍♂️	man playing handball	1F93E 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤾🏻‍♂️	man playing handball: light skin tone	1F93E 1F3FB 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤾🏼‍♂️	man playing handball: medium-light skin tone	1F93E 1F3FC 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤾🏽‍♂️	man playing handball: medium skin tone	1F93E 1F3FD 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤾🏾‍♂️	man playing handball: medium-dark skin tone	1F93E 1F3FE 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤾🏿‍♂️	man playing handball: dark skin tone	1F93E 1F3FF 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤾‍♀️	woman playing handball	1F93E 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤾🏻‍♀️	woman playing handball: light skin tone	1F93E 1F3FB 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤾🏼‍♀️	woman playing handball: medium-light skin tone	1F93E 1F3FC 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤾🏽‍♀️	woman playing handball: medium skin tone	1F93E 1F3FD 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤾🏾‍♀️	woman playing handball: medium-dark skin tone	1F93E 1F3FE 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤾🏿‍♀️	woman playing handball: dark skin tone	1F93E 1F3FF 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤹	person juggling	1F939	People & Body	person-sport	fully-qualified
🤹🏻	person juggling: light skin tone	1F939 1F3FB	People & Body	person-sport	fully-qualified
🤹🏼	person juggling: medium-light skin tone	1F939 1F3FC	People & Body	person-sport	fully-qualified
🤹🏽	person juggling: medium skin tone	1F939 1F3FD	People & Body	person-sport	fully-qualified
🤹🏾	person juggling: medium-dark skin tone	1F939 1F3FE	People & Body	person-sport	fully-qualified
🤹🏿	person juggling: dark skin tone	1F939 1F3FF	People & Body	person-sport	fully-qualified
🤹‍♂️	man juggling	1F939 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤹🏻‍♂️	man juggling: light skin tone	1F939 1F3FB 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤹🏼‍♂️	man juggling: medium-light skin tone	1F939 1F3FC 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤹🏽‍♂️	man juggling: medium skin tone	1F939 1F3FD 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤹🏾‍♂️	man juggling: medium-dark skin tone	1F939 1F3FE 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤹🏿‍♂️	man juggling: dark skin tone	1F939 1F3FF 200D 2642 FE0F	People & Body	person-sport	fully-qualified
🤹‍♀️	woman juggling	1F939 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤹🏻‍♀️	woman juggling: light skin tone	1F939 1F3FB 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤹🏼‍♀️	woman juggling: medium-light skin tone	1F939 1F3FC 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤹🏽‍♀️	woman juggling: medium skin tone	1F939 1F3FD 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤹🏾‍♀️	woman juggling: medium-dark skin tone	1F939 1F3FE 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🤹🏿‍♀️	woman juggling: dark skin tone	1F939 1F3FF 200D 2640 FE0F	People & Body	person-sport	fully-qualified
🧘	person in lotus position	1F9D8	People & Body	person-resting	fully-qualified
🧘🏻	person in lotus position: light skin tone	1F9D8 1F3FB	People & Body	person-resting	fully-qualified
🧘🏼	person in lotus position: medium-light skin tone	1F9D8 1F3FC	People & Body	person-resting	fully-qualified
🧘🏽	person in lotus position: medium skin tone	1F9D8 1F3FD	People & Body	person-resting	fully-qualified
🧘🏾	person in lotus position: medium-dark skin tone	1F9D8 1F3FE	People & Body	person-resting	fully-qualified
🧘🏿	person in lotus position: dark skin tone	1F9D8 1F3FF	People & Body	person-resting	fully-qualified
🧘‍♂️	man in lotus position	1F9D8 200D 2642 FE0F	People & Body	person-resting	fully-qualified
🧘🏻‍♂️	man in lotus position: light skin tone	1F9D8 1F3FB 200D 2642 FE0F	People & Body	person-resting	fully-qualified
🧘🏼‍♂️	man in lotus position: medium-light skin tone	1F9D8 1F3FC 200D 2642 FE0F	People & Body	person-resting	fully-qualified
🧘🏽‍♂️	man in lotus position: medium skin tone	1F9D8 1F3FD 200D 2642 FE0F	People & Body	person-resting	fully-qualified
🧘🏾‍♂️	man in lotus position: medium-dark skin tone	1F9D8 1F3FE 200D 2642 FE0F	People & Body	person-resting	fully-qualified
🧘🏿‍♂️	man in lotus position: dark skin tone	1F9D8 1F3FF 200D 2642 FE0F	People & Body	person-resting	fully-qualified
🧘‍♀️	woman in lotus position	1F9D8 200D 2640 FE0F	People & Body	person-resting	fully-qualified
🧘🏻‍♀️	woman in lotus position: light skin tone	1F9D8 1F3FB 200D 2640 FE0F	People & Body	person-resting	fully-qualified
🧘🏼‍♀️	woman in lotus position: medium-light skin tone	1F9D8 1F3FC 200D 2640 FE0F	People & Body	person-resting	fully-qualified
🧘🏽‍♀️	woman in lotus position: medium skin tone	1F9D8 1F3FD 200D 2640 FE0F	People & Body	person-resting	fully-qualified
🧘🏾‍♀️	woman in lotus position: medium-dark skin tone	1F9D8 1F3FE 200D 2640 FE0F	People & Body	person-resting	fully-qualified
🧘🏿‍♀️	woman in lotus position: dark skin tone	1F9D8 1F3FF 200D 2640 FE0F	People & Body	person-resting	fully-qualified
🛀	person taking bath	1F6C0	People & Body	person-resting	fully-qualified
🛀🏻	person taking bath: light skin tone	1F6C0 1F3FB	People & Body	person-resting	fully-qualified
🛀🏼	person taking bath: medium-light skin tone	1F6C0 1F3FC	People & Body	person-resting	fully-qualified
🛀🏽	person taking bath: medium skin tone	1F6C0 1F3FD	People & Body	person-resting	fully-qualified
🛀🏾	person taking bath: medium-dark skin tone	1F6C0 1F3FE	People & Body	person-resting	fully-qualified
🛀🏿	person taking bath: dark skin tone	1F6C0 1F3FF	People & Body	person-resting	fully-qualified
🛌	person in bed	1F6CC	People & Body	person-resting	fully-qualified
🛌🏻	person in bed: light skin tone	1F6CC 1F3FB	People & Body	person-resting	fully-qualified
🛌🏼	person in bed: medium-light skin tone	1F6CC 1F3FC	People & Body	person-resting	fully-qualified
🛌🏽	person in bed: medium skin tone	1F6CC 1F3FD	People & Body	person-resting	fully-qualified
🛌🏾	person in bed: medium-dark skin tone	1F6CC 1F3FE	People & Body	person-resting	fully-qualified
🛌🏿	person in bed: dark skin tone	1F6CC 1F3FF	People & Body	person-resting	fully-qualified
🧑‍🤝‍🧑	people holding hands	1F9D1 200D 1F91D 200D 1F9D1	People & Body	family	fully-qualified
🧑🏻‍🤝‍🧑🏻	people holding hands: light skin tone	1F9D1 1F3FB 200D 1F91D 200D 1F9D1 1F3FB	People & Body	family	fully-qualified
🧑🏻‍🤝‍🧑🏼	people holding hands: light skin tone, medium-light skin tone	1F9D1 1F3FB 200D 1F91D 200D 1F9D1 1F3FC	People & Body	family	fully-qualified
🧑🏻‍🤝‍🧑🏽	people holding hands: light skin tone, medium skin tone	1F9D1 1F3FB 200D 1F91D 200D 1F9D1 1F3FD	People & Body	family	fully-qualified
🧑🏻‍🤝‍🧑🏾	people holding hands: light skin tone, medium-dark skin tone	1F9D1 1F3FB 200D 1F91D 200D 1F9D1 1F3FE	People & Body	family	fully-qualified
🧑🏻‍🤝‍🧑🏿	people holding hands: light skin tone, dark skin tone	1F9D1 1F3FB 200D 1F91D 200D 1F9D1 1F3FF	People & Body	family	fully-qualified
🧑🏼‍🤝‍🧑🏻	people holding hands: medium-light skin tone, light skin tone	1F9D1 1F3FC 200D 1F91D 200D 1F9D1 1F3FB	People & Body	family	fully-qualified
🧑🏼‍🤝‍🧑🏼	people holding hands: medium-light skin tone	1F9D1 1F3FC 200D 1F91D 200D 1F9D1 1F3FC	People & Body	family	fully-qualified
🧑🏼‍🤝‍🧑🏽	people holding hands: medium-light skin tone, medium skin tone	1F9D1 1F3FC 200D 1F91D 200D 1F9D1 1F3FD	People & Body	family	fully-qualified
🧑🏼‍🤝‍🧑🏾	people holding hands: medium-light skin tone, medium-dark skin tone	1F9D1 1F3FC 200D 1F91D 200D 1F9D1 1F3FE	People & Body	family	fully-qualified
🧑🏼‍🤝‍🧑🏿	people holding hands: medium-light skin tone, dark skin tone	1F9D1 1F3FC 200D 1F91D 200D 1F9D1 1F3FF	People & Body	family	fully-qualified
🧑🏽‍🤝‍🧑🏻	people holding hands: medium skin tone, light skin tone	1F9D1 1F3FD 200D 1F91D 200D 1F9D1 1F3FB	People & Body	family	fully-qualified
🧑🏽‍🤝‍🧑🏼	people holding hands: medium skin tone, medium-light skin tone	1F9D1 1F3FD 200D 1F91D 200D 1F9D1 1F3FC	People & Body	family	fully-qualified
🧑🏽‍🤝‍🧑🏽	people holding hands: medium skin tone	1F9D1 1F3FD 200D 1F91D 200D 1F9D1 1F3FD	People & Body	family	fully-qualified
🧑🏽‍🤝‍🧑🏾	people holding hands: medium skin tone, medium-dark skin tone	1F9D1 1F3FD 200D 1F91D 200D 1F9D1 1F3FE	People & Body	family	fully-qualified
🧑🏽‍🤝‍🧑🏿	people holding hands: medium skin tone, dark skin tone	1F9D1 1F3FD 200D 1F91D 200D 1F9D1 1F3FF	People & Body	family	fully-qualified
🧑🏾‍🤝‍🧑🏻	people holding hands: medium-dark skin tone, light skin tone	1F9D1 1F3FE 200D 1F91D 200D 1F9D1 1F3FB	People & Body	family	fully-qualified
🧑🏾‍🤝‍🧑🏼	people holding hands: medium-dark skin tone, medium-light skin tone	1F9D1 1F3FE 200D 1F91D 200D 1F9D1 1F3FC	People & Body	family	fully-qualified
🧑🏾‍🤝‍🧑🏽	people holding hands: medium-dark skin tone, medium skin tone	1F9D1 1F3FE 200D 1F91D 200D 1F9D1 1F3FD	People & Body	family	fully-qualified
🧑🏾‍🤝‍🧑🏾	people holding hands: medium-dark skin tone	1F9D1 1F3FE 200D 1F91D 200D 1F9D1 1F3FE	People & Body	family	fully-qualified
🧑🏾‍🤝‍🧑🏿	people holding hands: medium-dark skin tone, dark skin tone	1F9D1 1F3FE 200D 1F91D 200D 1F9D1 1F3FF	People & Body	family	fully-qualified
🧑🏿‍🤝‍🧑🏻	people holding hands: dark skin tone, light skin tone	1F9D1 1F3FF 200D 1F91D 200D 1F9D1 1F3FB	People & Body	family	fully-qualified
🧑🏿‍🤝‍🧑🏼	people holding hands: dark skin tone, medium-light skin tone	1F9D1 1F3FF 200D 1F91D 200D 1F9D1 1F3FC	People & Body	family	fully-qualified
🧑🏿‍🤝‍🧑🏽	people holding hands: dark skin tone, medium skin tone	1F9D1 1F3FF 200D 1F91D 200D 1F9D1 1F3FD	People & Body	family	fully-qualified
🧑🏿‍🤝‍🧑🏾	people holding hands: dark skin tone, medium-dark skin tone	1F9D1 1F3FF 200D 1F91D 200D 1F9D1 1F3FE	People & Body	family	fully-qualified
🧑🏿‍🤝‍🧑🏿	people holding hands: dark skin tone	1F9D1 1F3FF 200D 1F91D 200D 1F9D1 1F3FF	People & Body	family	fully-qualified
👭	women holding hands	1F46D	People & Body	family	fully-qualified
👭🏻	women holding hands: light skin tone	1F46D 1F3FB	People & Body	family	fully-qualified
👩🏻‍🤝‍👩🏼	women holding hands: light skin tone, medium-light skin tone	1F469 1F3FB 200D 1F91D 200D 1F469 1F3FC	People & Body	family	fully-qualified
👩🏻‍🤝‍👩🏽	women holding hands: light skin tone, medium skin tone	1F469 1F3FB 200D 1F91D 200D 1F469 1F3FD	People & Body	family	fully-qualified
👩🏻‍🤝‍👩🏾	women holding hands: light skin tone, medium-dark skin tone	1F469 1F3FB 200D 1F91D 200D 1F469 1F3FE	People & Body	family	fully-qualified
👩🏻‍🤝‍👩🏿	women holding hands: light skin tone, dark skin tone	1F469 1F3FB 200D 1F91D 200D 1F469 1F3FF	People & Body	family	fully-qualified
👩🏼‍🤝‍👩🏻	women holding hands: medium-light skin tone, light skin tone	1F469 1F3FC 200D 1F91D 200D 1F469 1F3FB	People & Body	family	fully-qualified
👭🏼	women holding hands: medium-light skin tone	1F46D 1F3FC	People & Body	family	fully-qualified
👩🏼‍🤝‍👩🏽	women holding hands: medium-light skin tone, medium skin tone	1F469 1F3FC 200D 1F91D 200D 1F469 1F3FD	People & Body	family	fully-qualified
👩🏼‍🤝‍👩🏾	women holding hands: medium-light skin tone, medium-dark skin tone	1F469 1F3FC 200D 1F91D 200D 1F469 1F3FE	People & Body	family	fully-qualified
👩🏼‍🤝‍👩🏿	women holding hands: medium-light skin tone, dark skin tone	1F469 1F3FC 200D 1F91D 200D 1F469 1F3FF	People & Body	family	fully-qualified
👩🏽‍🤝‍👩🏻	women holding hands: medium skin tone, light skin tone	1F469 1F3FD 200D 1F91D 200D 1F469 1F3FB	People & Body	family	fully-qualified
👩🏽‍🤝‍👩🏼	women holding hands: medium skin tone, medium-light skin tone	1F469 1F3FD 200D 1F91D 200D 1F469 1F3FC	People & Body	family	fully-qualified
👭🏽	women holding hands: medium skin tone	1F46D 1F3FD	People & Body	family	fully-qualified
👩🏽‍🤝‍👩🏾	women holding hands: medium skin tone, medium-dark skin tone	1F469 1F3FD 200D 1F91D 200D 1F469 1F3FE	People & Body	family	fully-qualified
👩🏽‍🤝‍👩🏿	women holding hands: medium skin tone, dark skin tone	1F469 1F3FD 200D 1F91D 200D 1F469 1F3FF	People & Body	family	fully-qualified
👩🏾‍🤝‍👩🏻	women holding hands: medium-dark skin tone, light skin tone	1F469 1F3FE 200D 1F91D 200D 1F469 1F3FB	People & Body	family	fully-qualified
👩🏾‍🤝‍👩🏼	women holding hands: medium-dark skin tone, medium-light skin tone	1F469 1F3FE 200D 1F91D 200D 1F469 1F3FC	People & Body	family	fully-qualified
👩🏾‍🤝‍👩🏽	women holding hands: medium-dark skin tone, medium skin tone	1F469 1F3FE 200D 1F91D 200D 1F469 1F3FD	People & Body	family	fully-qualified
👭🏾	women holding hands: medium-dark skin tone	1F46D 1F3FE	People & Body	family	fully-qualified
👩🏾‍🤝‍👩🏿	women holding hands: medium-dark skin tone, dark skin tone	1F469 1F3FE 200D 1F91D 200D 1F469 1F3FF	People & Body	family	fully-qualified
👩🏿‍🤝‍👩🏻	women holding hands: dark skin tone, light skin tone	1F469 1F3FF 200D 1F91D 200D 1F469 1F3FB	People & Body	family	fully-qualified
👩🏿‍🤝‍👩🏼	women holding hands: dark skin tone, medium-light skin tone	1F469 1F3FF 200D 1F91D 200D 1F469 1F3FC	People & Body	family	fully-qualified
👩🏿‍🤝‍👩🏽	women holding hands: dark skin tone, medium skin tone	1F469 1F3FF 200D 1F91D 200D 1F469 1F3FD	People & Body	family	fully-qualified
👩🏿‍🤝‍👩🏾	women holding hands: dark skin tone, medium-dark skin tone	1F469 1F3FF 200D 1F91D 200D 1F469 1F3FE	People & Body	family	fully-qualified
👭🏿	women holding hands: dark skin tone	1F46D 1F3FF	People & Body	family	fully-qualified
👫	woman and man holding hands	1F46B	People & Body	family	fully-qualified
👫🏻	woman and man holding hands: light skin tone	1F46B 1F3FB	People & Body	family	fully-qualified
👩🏻‍🤝‍👨🏼	woman and man holding hands: light skin tone, medium-light skin tone	1F469 1F3FB 200D 1F91D 200D 1F468 1F3FC	People & Body	family	fully-qualified
👩🏻‍🤝‍👨🏽	woman and man holding hands: light skin tone, medium skin tone	1F469 1F3FB 200D 1F91D 200D 1F468 1F3FD	People & Body	family	fully-qualified
👩🏻‍🤝‍👨🏾	woman and man holding hands: light skin tone, medium-dark skin tone	1F469 1F3FB 200D 1F91D 200D 1F468 1F3FE	People & Body	family	fully-qualified
👩🏻‍🤝‍👨🏿	woman and man holding hands: light skin tone, dark skin tone	1F469 1F3FB 200D 1F91D 200D 1F468 1F3FF	People & Body	family	fully-qualified
👩🏼‍🤝‍👨🏻	woman and man holding hands: medium-light skin tone, light skin tone	1F469 1F3FC 200D 1F91D 200D 1F468 1F3FB	People & Body	family	fully-qualified
👫🏼	woman and man holding hands: medium-light skin tone	1F46B 1F3FC	People & Body	family	fully-qualified
👩🏼‍🤝‍👨🏽	woman and man holding hands: medium-light skin tone, medium skin tone	1F469 1F3FC 200D 1F91D 200D 1F468 1F3FD	People & Body	family	fully-qualified
👩🏼‍🤝‍👨🏾	woman and man holding hands: medium-light skin tone, medium-dark skin tone	1F469 1F3FC 200D 1F91D 200D 1F468 1F3FE	People & Body	family	fully-qualified
👩🏼‍🤝‍👨🏿	woman and man holding hands: medium-light skin tone, dark skin tone	1F469 1F3FC 200D 1F91D 200D 1F468 1F3FF	People & Body	family	fully-qualified
👩🏽‍🤝‍👨🏻	woman and man holding hands: medium skin tone, light skin tone	1F469 1F3FD 200D 1F91D 200D 1F468 1F3FB	People & Body	family	fully-qualified
👩🏽‍🤝‍👨🏼	woman and man holding hands: medium skin tone, medium-light skin tone	1F469 1F3FD 200D 1F91D 200D 1F468 1F3FC	People & Body	family	fully-qualified
👫🏽	woman and man holding hands: medium skin tone	1F46B 1F3FD	People & Body	family	fully-qualified
👩🏽‍🤝‍👨🏾	woman and man holding hands: medium skin tone, medium-dark skin tone	1F469 1F3FD 200D 1F91D 200D 1F468 1F3FE	People & Body	family	fully-qualified
👩🏽‍🤝‍👨🏿	woman and man holding hands: medium skin tone, dark skin tone	1F469 1F3FD 200D 1F91D 200D 1F468 1F3FF	People & Body	family	fully-qualified
👩🏾‍🤝‍👨🏻	woman and man holding hands: medium-dark skin tone, light skin tone	1F469 1F3FE 200D 1F91D 200D 1F468 1F3FB	People & Body	family	fully-qualified
👩🏾‍🤝‍👨🏼	woman and man holding hands: medium-dark skin tone, medium-light skin tone	1F469 1F3FE 200D 1F91D 200D 1F468 1F3FC	People & Body	family	fully-qualified
👩🏾‍🤝‍👨🏽	woman and man holding hands: medium-dark skin tone, medium skin tone	1F469 1F3FE 200D 1F91D 200D 1F468 1F3FD	People & Body	family	fully-qualified
👫🏾	woman and man holding hands: medium-dark skin tone	1F46B 1F3FE	People & Body	family	fully-qualified
👩🏾‍🤝‍👨🏿	woman and man holding hands: medium-dark skin tone, dark skin tone	1F469 1F3FE 200D 1F91D 200D 1F468 1F3FF	People & Body	family	fully-qualified
👩🏿‍🤝‍👨🏻	woman and man holding hands: dark skin tone, light skin tone	1F469 1F3FF 200D 1F91D 200D 1F468 1F3FB	People & Body	family	fully-qualified
👩🏿‍🤝‍👨🏼	woman and man holding hands: dark skin tone, medium-light skin tone	1F469 1F3FF 200D 1F91D 200D 1F468 1F3FC	People & Body	family	fully-qualified
👩🏿‍🤝‍👨🏽	woman and man holding hands: dark skin tone, medium skin tone	1F469 1F3FF 200D 1F91D 200D 1F468 1F3FD	People & Body	family	fully-qualified
👩🏿‍🤝‍👨🏾	woman and man holding hands: dark skin tone, medium-dark skin tone	1F469 1F3FF 200D 1F91D 200D 1F468 1F3FE	People & Body	family	fully-qualified
👫🏿	woman and man holding hands: dark skin tone	1F46B 1F3FF	People & Body	family	fully-qualified
👬	men holding hands	1F46C	People & Body	family	fully-qualified
👬🏻	men holding hands: light skin tone	1F46C 1F3FB	People & Body	family	fully-qualified
👨🏻‍🤝‍👨🏼	men holding hands: light skin tone, medium-light skin tone	1F468 1F3FB 200D 1F91D 200D 1F468 1F3FC	People & Body	family	fully-qualified
👨🏻‍🤝‍👨🏽	men holding hands: light skin tone, medium skin tone	1F468 1F3FB 200D 1F91D 200D 1F468 1F3FD	People & Body	family	fully-qualified
👨🏻‍🤝‍👨🏾	men holding hands: light skin tone, medium-dark skin tone	1F468 1F3FB 200D 1F91D 200D 1F468 1F3FE	People & Body	family	fully-qualified
👨🏻‍🤝‍👨🏿	men holding hands: light skin tone, dark skin tone	1F468 1F3FB 200D 1F91D 200D 1F468 1F3FF	People & Body	family	fully-qualified
👨🏼‍🤝‍👨🏻	men holding hands: medium-light skin tone, light skin tone	1F468 1F3FC 200D 1F91D 200D 1F468 1F3FB	People & Body	family	fully-qualified
👬🏼	men holding hands: medium-light skin tone	1F46C 1F3FC	People & Body	family	fully-qualified
👨🏼‍🤝‍👨🏽	men holding hands: medium-light skin tone, medium skin tone	1F468 1F3FC 200D 1F91D 200D 1F468 1F3FD	People & Body	family	fully-qualified
👨🏼‍🤝‍👨🏾	men holding hands: medium-light skin tone, medium-dark skin tone	1F468 1F3FC 200D 1F91D 200D 1F468 1F3FE	People & Body	family	fully-qualified
👨🏼‍🤝‍👨🏿	men holding hands: medium-light skin tone, dark skin tone	1F468 1F3FC 200D 1F91D 200D 1F468 1F3FF	People & Body	family	fully-qualified
👨🏽‍🤝‍👨🏻	men holding hands: medium skin tone, light skin tone	1F468 1F3FD 200D 1F91D 200D 1F468 1F3FB	People & Body	family	fully-qualified
👨🏽‍🤝‍👨🏼	men holding hands: medium skin tone, medium-light skin tone	1F468 1F3FD 200D 1F91D 200D 1F468 1F3FC	People & Body	family	fully-qualified
👬🏽	men holding hands: medium skin tone	1F46C 1F3FD	People & Body	family	fully-qualified
👨🏽‍🤝‍👨🏾	men holding hands: medium skin tone, medium-dark skin tone	1F468 1F3FD 200D 1F91D 200D 1F468 1F3FE	People & Body	family	fully-qualified
👨🏽‍🤝‍👨🏿	men holding hands: medium skin tone, dark skin tone	1F468 1F3FD 200D 1F91D 200D 1F468 1F3FF	People & Body	family	fully-qualified
👨🏾‍🤝‍👨🏻	men holding hands: medium-dark skin tone, light skin tone	1F468 1F3FE 200D 1F91D 200D 1F468 1F3FB	People & Body	family	fully-qualified
👨🏾‍🤝‍👨🏼	men holding hands: medium-dark skin tone, medium-light skin tone	1F468 1F3FE 200D 1F91D 200D 1F468 1F3FC	People & Body	family	fully-qualified
👨🏾‍🤝‍👨🏽	men holding hands: medium-dark skin tone, medium skin tone	1F468 1F3FE 200D 1F91D 200D 1F468 1F3FD	People & Body	family	fully-qualified
👬🏾	men holding hands: medium-dark skin tone	1F46C 1F3FE	People & Body	family	fully-qualified
👨🏾‍🤝‍👨🏿	men holding hands: medium-dark skin tone, dark skin tone	1F468 1F3FE 200D 1F91D 200D 1F468 1F3FF	People & Body	family	fully-qualified
👨🏿‍🤝‍👨🏻	men holding hands: dark skin tone, light skin tone	1F468 1F3FF 200D 1F91D 200D 1F468 1F3FB	People & Body	family	fully-qualified
👨🏿‍🤝‍👨🏼	men holding hands: dark skin tone, medium-light skin tone	1F468 1F3FF 200D 1F91D 200D 1F468 1F3FC	People & Body	family	fully-qualified
👨🏿‍🤝‍👨🏽	men holding hands: dark skin tone, medium skin tone	1F468 1F3FF 200D 1F91D 200D 1F468 1F3FD	People & Body	family	fully-qualified
👨🏿‍🤝‍👨🏾	men holding hands: dark skin tone, medium-dark skin tone	1F468 1F3FF 200D 1F91D 200D 1F468 1F3FE	People & Body	family	fully-qualified
👬🏿	men holding hands: dark skin tone	1F46C 1F3FF	People & Body	family	fully-qualified
💏	kiss	1F48F	People & Body	family	fully-qualified
💏🏻	kiss: light skin tone	1F48F 1F3FB	People & Body	family	fully-qualified
💏🏼	kiss: medium-light skin tone	1F48F 1F3FC	People & Body	family	fully-qualified
💏🏽	kiss: medium skin tone	1F48F 1F3FD	People & Body	family	fully-qualified
💏🏾	kiss: medium-dark skin tone	1F48F 1F3FE	People & Body	family	fully-qualified
💏🏿	kiss: dark skin tone	1F48F 1F3FF	People & Body	family	fully-qualified
🧑🏻‍❤️‍💋‍🧑🏼	kiss: person, person, light skin tone, medium-light skin tone	1F9D1 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FC	People & Body	family	fully-qualified
🧑🏻‍❤️‍💋‍🧑🏽	kiss: person, person, light skin tone, medium skin tone	1F9D1 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FD	People & Body	family	fully-qualified
🧑🏻‍❤️‍💋‍🧑🏾	kiss: person, person, light skin tone, medium-dark skin tone	1F9D1 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FE	People & Body	family	fully-qualified
🧑🏻‍❤️‍💋‍🧑🏿	kiss: person, person, light skin tone, dark skin tone	1F9D1 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FF	People & Body	family	fully-qualified
🧑🏼‍❤️‍💋‍🧑🏻	kiss: person, person, medium-light skin tone, light skin tone	1F9D1 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FB	People & Body	family	fully-qualified
🧑🏼‍❤️‍💋‍🧑🏽	kiss: person, person, medium-light skin tone, medium skin tone	1F9D1 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FD	People & Body	family	fully-qualified
🧑🏼‍❤️‍💋‍🧑🏾	kiss: person, person, medium-light skin tone, medium-dark skin tone	1F9D1 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FE	People & Body	family	fully-qualified
🧑🏼‍❤️‍💋‍🧑🏿	kiss: person, person, medium-light skin tone, dark skin tone	1F9D1 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FF	People & Body	family	fully-qualified
🧑🏽‍❤️‍💋‍🧑🏻	kiss: person, person, medium skin tone, light skin tone	1F9D1 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FB	People & Body	family	fully-qualified
🧑🏽‍❤️‍💋‍🧑🏼	kiss: person, person, medium skin tone, medium-light skin tone	1F9D1 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FC	People & Body	family	fully-qualified
🧑🏽‍❤️‍💋‍🧑🏾	kiss: person, person, medium skin tone, medium-dark skin tone	1F9D1 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FE	People & Body	family	fully-qualified
🧑🏽‍❤️‍💋‍🧑🏿	kiss: person, person, medium skin tone, dark skin tone	1F9D1 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FF	People & Body	family	fully-qualified
🧑🏾‍❤️‍💋‍🧑🏻	kiss: person, person, medium-dark skin tone, light skin tone	1F9D1 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FB	People & Body	family	fully-qualified
🧑🏾‍❤️‍💋‍🧑🏼	kiss: person, person, medium-dark skin tone, medium-light skin tone	1F9D1 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FC	People & Body	family	fully-qualified
🧑🏾‍❤️‍💋‍🧑🏽	kiss: person, person, medium-dark skin tone, medium skin tone	1F9D1 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FD	People & Body	family	fully-qualified
🧑🏾‍❤️‍💋‍🧑🏿	kiss: person, person, medium-dark skin tone, dark skin tone	1F9D1 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FF	People & Body	family	fully-qualified
🧑🏿‍❤️‍💋‍🧑🏻	kiss: person, person, dark skin tone, light skin tone	1F9D1 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FB	People & Body	family	fully-qualified
🧑🏿‍❤️‍💋‍🧑🏼	kiss: person, person, dark skin tone, medium-light skin tone	1F9D1 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FC	People & Body	family	fully-qualified
🧑🏿‍❤️‍💋‍🧑🏽	kiss: person, person, dark skin tone, medium skin tone	1F9D1 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FD	People & Body	family	fully-qualified
🧑🏿‍❤️‍💋‍🧑🏾	kiss: person, person, dark skin tone, medium-dark skin tone	1F9D1 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F9D1 1F3FE	People & Body	family	fully-qualified
👩‍❤️‍💋‍👨	kiss: woman, man	1F469 200D 2764 FE0F 200D 1F48B 200D 1F468	People & Body	family	fully-qualified
👩🏻‍❤️‍💋‍👨🏻	kiss: woman, man, light skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FB	People & Body	family	fully-qualified
👩🏻‍❤️‍💋‍👨🏼	kiss: woman, man, light skin tone, medium-light skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FC	People & Body	family	fully-qualified
👩🏻‍❤️‍💋‍👨🏽	kiss: woman, man, light skin tone, medium skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FD	People & Body	family	fully-qualified
👩🏻‍❤️‍💋‍👨🏾	kiss: woman, man, light skin tone, medium-dark skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FE	People & Body	family	fully-qualified
👩🏻‍❤️‍💋‍👨🏿	kiss: woman, man, light skin tone, dark skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FF	People & Body	family	fully-qualified
👩🏼‍❤️‍💋‍👨🏻	kiss: woman, man, medium-light skin tone, light skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FB	People & Body	family	fully-qualified
👩🏼‍❤️‍💋‍👨🏼	kiss: woman, man, medium-light skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FC	People & Body	family	fully-qualified
👩🏼‍❤️‍💋‍👨🏽	kiss: woman, man, medium-light skin tone, medium skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FD	People & Body	family	fully-qualified
👩🏼‍❤️‍💋‍👨🏾	kiss: woman, man, medium-light skin tone, medium-dark skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FE	People & Body	family	fully-qualified
👩🏼‍❤️‍💋‍👨🏿	kiss: woman, man, medium-light skin tone, dark skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FF	People & Body	family	fully-qualified
👩🏽‍❤️‍💋‍👨🏻	kiss: woman, man, medium skin tone, light skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FB	People & Body	family	fully-qualified
👩🏽‍❤️‍💋‍👨🏼	kiss: woman, man, medium skin tone, medium-light skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FC	People & Body	family	fully-qualified
👩🏽‍❤️‍💋‍👨🏽	kiss: woman, man, medium skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FD	People & Body	family	fully-qualified
👩🏽‍❤️‍💋‍👨🏾	kiss: woman, man, medium skin tone, medium-dark skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FE	People & Body	family	fully-qualified
👩🏽‍❤️‍💋‍👨🏿	kiss: woman, man, medium skin tone, dark skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FF	People & Body	family	fully-qualified
👩🏾‍❤️‍💋‍👨🏻	kiss: woman, man, medium-dark skin tone, light skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FB	People & Body	family	fully-qualified
👩🏾‍❤️‍💋‍👨🏼	kiss: woman, man, medium-dark skin tone, medium-light skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FC	People & Body	family	fully-qualified
👩🏾‍❤️‍💋‍👨🏽	kiss: woman, man, medium-dark skin tone, medium skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FD	People & Body	family	fully-qualified
👩🏾‍❤️‍💋‍👨🏾	kiss: woman, man, medium-dark skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FE	People & Body	family	fully-qualified
👩🏾‍❤️‍💋‍👨🏿	kiss: woman, man, medium-dark skin tone, dark skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FF	People & Body	family	fully-qualified
👩🏿‍❤️‍💋‍👨🏻	kiss: woman, man, dark skin tone, light skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FB	People & Body	family	fully-qualified
👩🏿‍❤️‍💋‍👨🏼	kiss: woman, man, dark skin tone, medium-light skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FC	People & Body	family	fully-qualified
👩🏿‍❤️‍💋‍👨🏽	kiss: woman, man, dark skin tone, medium skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FD	People & Body	family	fully-qualified
👩🏿‍❤️‍💋‍👨🏾	kiss: woman, man, dark skin tone, medium-dark skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FE	People & Body	family	fully-qualified
👩🏿‍❤️‍💋‍👨🏿	kiss: woman, man, dark skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FF	People & Body	family	fully-qualified
👨‍❤️‍💋‍👨	kiss: man, man	1F468 200D 2764 FE0F 200D 1F48B 200D 1F468	People & Body	family	fully-qualified
👨🏻‍❤️‍💋‍👨🏻	kiss: man, man, light skin tone	1F468 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FB	People & Body	family	fully-qualified
👨🏻‍❤️‍💋‍👨🏼	kiss: man, man, light skin tone, medium-light skin tone	1F468 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FC	People & Body	family	fully-qualified
👨🏻‍❤️‍💋‍👨🏽	kiss: man, man, light skin tone, medium skin tone	1F468 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FD	People & Body	family	fully-qualified
👨🏻‍❤️‍💋‍👨🏾	kiss: man, man, light skin tone, medium-dark skin tone	1F468 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FE	People & Body	family	fully-qualified
👨🏻‍❤️‍💋‍👨🏿	kiss: man, man, light skin tone, dark skin tone	1F468 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FF	People & Body	family	fully-qualified
👨🏼‍❤️‍💋‍👨🏻	kiss: man, man, medium-light skin tone, light skin tone	1F468 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FB	People & Body	family	fully-qualified
👨🏼‍❤️‍💋‍👨🏼	kiss: man, man, medium-light skin tone	1F468 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FC	People & Body	family	fully-qualified
👨🏼‍❤️‍💋‍👨🏽	kiss: man, man, medium-light skin tone, medium skin tone	1F468 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FD	People & Body	family	fully-qualified
👨🏼‍❤️‍💋‍👨🏾	kiss: man, man, medium-light skin tone, medium-dark skin tone	1F468 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FE	People & Body	family	fully-qualified
👨🏼‍❤️‍💋‍👨🏿	kiss: man, man, medium-light skin tone, dark skin tone	1F468 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FF	People & Body	family	fully-qualified
👨🏽‍❤️‍💋‍👨🏻	kiss: man, man, medium skin tone, light skin tone	1F468 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FB	People & Body	family	fully-qualified
👨🏽‍❤️‍💋‍👨🏼	kiss: man, man, medium skin tone, medium-light skin tone	1F468 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FC	People & Body	family	fully-qualified
👨🏽‍❤️‍💋‍👨🏽	kiss: man, man, medium skin tone	1F468 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FD	People & Body	family	fully-qualified
👨🏽‍❤️‍💋‍👨🏾	kiss: man, man, medium skin tone, medium-dark skin tone	1F468 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FE	People & Body	family	fully-qualified
👨🏽‍❤️‍💋‍👨🏿	kiss: man, man, medium skin tone, dark skin tone	1F468 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FF	People & Body	family	fully-qualified
👨🏾‍❤️‍💋‍👨🏻	kiss: man, man, medium-dark skin tone, light skin tone	1F468 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FB	People & Body	family	fully-qualified
👨🏾‍❤️‍💋‍👨🏼	kiss: man, man, medium-dark skin tone, medium-light skin tone	1F468 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FC	People & Body	family	fully-qualified
        """.trimIndent(),

        """
👨🏾‍❤️‍💋‍👨🏽	kiss: man, man, medium-dark skin tone, medium skin tone	1F468 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FD	People & Body	family	fully-qualified
👨🏾‍❤️‍💋‍👨🏾	kiss: man, man, medium-dark skin tone	1F468 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FE	People & Body	family	fully-qualified
👨🏾‍❤️‍💋‍👨🏿	kiss: man, man, medium-dark skin tone, dark skin tone	1F468 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FF	People & Body	family	fully-qualified
👨🏿‍❤️‍💋‍👨🏻	kiss: man, man, dark skin tone, light skin tone	1F468 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FB	People & Body	family	fully-qualified
👨🏿‍❤️‍💋‍👨🏼	kiss: man, man, dark skin tone, medium-light skin tone	1F468 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FC	People & Body	family	fully-qualified
👨🏿‍❤️‍💋‍👨🏽	kiss: man, man, dark skin tone, medium skin tone	1F468 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FD	People & Body	family	fully-qualified
👨🏿‍❤️‍💋‍👨🏾	kiss: man, man, dark skin tone, medium-dark skin tone	1F468 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FE	People & Body	family	fully-qualified
👨🏿‍❤️‍💋‍👨🏿	kiss: man, man, dark skin tone	1F468 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F468 1F3FF	People & Body	family	fully-qualified
👩‍❤️‍💋‍👩	kiss: woman, woman	1F469 200D 2764 FE0F 200D 1F48B 200D 1F469	People & Body	family	fully-qualified
👩🏻‍❤️‍💋‍👩🏻	kiss: woman, woman, light skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FB	People & Body	family	fully-qualified
👩🏻‍❤️‍💋‍👩🏼	kiss: woman, woman, light skin tone, medium-light skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FC	People & Body	family	fully-qualified
👩🏻‍❤️‍💋‍👩🏽	kiss: woman, woman, light skin tone, medium skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FD	People & Body	family	fully-qualified
👩🏻‍❤️‍💋‍👩🏾	kiss: woman, woman, light skin tone, medium-dark skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FE	People & Body	family	fully-qualified
👩🏻‍❤️‍💋‍👩🏿	kiss: woman, woman, light skin tone, dark skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FF	People & Body	family	fully-qualified
👩🏼‍❤️‍💋‍👩🏻	kiss: woman, woman, medium-light skin tone, light skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FB	People & Body	family	fully-qualified
👩🏼‍❤️‍💋‍👩🏼	kiss: woman, woman, medium-light skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FC	People & Body	family	fully-qualified
👩🏼‍❤️‍💋‍👩🏽	kiss: woman, woman, medium-light skin tone, medium skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FD	People & Body	family	fully-qualified
👩🏼‍❤️‍💋‍👩🏾	kiss: woman, woman, medium-light skin tone, medium-dark skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FE	People & Body	family	fully-qualified
👩🏼‍❤️‍💋‍👩🏿	kiss: woman, woman, medium-light skin tone, dark skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FF	People & Body	family	fully-qualified
👩🏽‍❤️‍💋‍👩🏻	kiss: woman, woman, medium skin tone, light skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FB	People & Body	family	fully-qualified
👩🏽‍❤️‍💋‍👩🏼	kiss: woman, woman, medium skin tone, medium-light skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FC	People & Body	family	fully-qualified
👩🏽‍❤️‍💋‍👩🏽	kiss: woman, woman, medium skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FD	People & Body	family	fully-qualified
👩🏽‍❤️‍💋‍👩🏾	kiss: woman, woman, medium skin tone, medium-dark skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FE	People & Body	family	fully-qualified
👩🏽‍❤️‍💋‍👩🏿	kiss: woman, woman, medium skin tone, dark skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FF	People & Body	family	fully-qualified
👩🏾‍❤️‍💋‍👩🏻	kiss: woman, woman, medium-dark skin tone, light skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FB	People & Body	family	fully-qualified
👩🏾‍❤️‍💋‍👩🏼	kiss: woman, woman, medium-dark skin tone, medium-light skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FC	People & Body	family	fully-qualified
👩🏾‍❤️‍💋‍👩🏽	kiss: woman, woman, medium-dark skin tone, medium skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FD	People & Body	family	fully-qualified
👩🏾‍❤️‍💋‍👩🏾	kiss: woman, woman, medium-dark skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FE	People & Body	family	fully-qualified
👩🏾‍❤️‍💋‍👩🏿	kiss: woman, woman, medium-dark skin tone, dark skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FF	People & Body	family	fully-qualified
👩🏿‍❤️‍💋‍👩🏻	kiss: woman, woman, dark skin tone, light skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FB	People & Body	family	fully-qualified
👩🏿‍❤️‍💋‍👩🏼	kiss: woman, woman, dark skin tone, medium-light skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FC	People & Body	family	fully-qualified
👩🏿‍❤️‍💋‍👩🏽	kiss: woman, woman, dark skin tone, medium skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FD	People & Body	family	fully-qualified
👩🏿‍❤️‍💋‍👩🏾	kiss: woman, woman, dark skin tone, medium-dark skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FE	People & Body	family	fully-qualified
👩🏿‍❤️‍💋‍👩🏿	kiss: woman, woman, dark skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F48B 200D 1F469 1F3FF	People & Body	family	fully-qualified
💑	couple with heart	1F491	People & Body	family	fully-qualified
💑🏻	couple with heart: light skin tone	1F491 1F3FB	People & Body	family	fully-qualified
💑🏼	couple with heart: medium-light skin tone	1F491 1F3FC	People & Body	family	fully-qualified
💑🏽	couple with heart: medium skin tone	1F491 1F3FD	People & Body	family	fully-qualified
💑🏾	couple with heart: medium-dark skin tone	1F491 1F3FE	People & Body	family	fully-qualified
💑🏿	couple with heart: dark skin tone	1F491 1F3FF	People & Body	family	fully-qualified
🧑🏻‍❤️‍🧑🏼	couple with heart: person, person, light skin tone, medium-light skin tone	1F9D1 1F3FB 200D 2764 FE0F 200D 1F9D1 1F3FC	People & Body	family	fully-qualified
🧑🏻‍❤️‍🧑🏽	couple with heart: person, person, light skin tone, medium skin tone	1F9D1 1F3FB 200D 2764 FE0F 200D 1F9D1 1F3FD	People & Body	family	fully-qualified
🧑🏻‍❤️‍🧑🏾	couple with heart: person, person, light skin tone, medium-dark skin tone	1F9D1 1F3FB 200D 2764 FE0F 200D 1F9D1 1F3FE	People & Body	family	fully-qualified
🧑🏻‍❤️‍🧑🏿	couple with heart: person, person, light skin tone, dark skin tone	1F9D1 1F3FB 200D 2764 FE0F 200D 1F9D1 1F3FF	People & Body	family	fully-qualified
🧑🏼‍❤️‍🧑🏻	couple with heart: person, person, medium-light skin tone, light skin tone	1F9D1 1F3FC 200D 2764 FE0F 200D 1F9D1 1F3FB	People & Body	family	fully-qualified
🧑🏼‍❤️‍🧑🏽	couple with heart: person, person, medium-light skin tone, medium skin tone	1F9D1 1F3FC 200D 2764 FE0F 200D 1F9D1 1F3FD	People & Body	family	fully-qualified
🧑🏼‍❤️‍🧑🏾	couple with heart: person, person, medium-light skin tone, medium-dark skin tone	1F9D1 1F3FC 200D 2764 FE0F 200D 1F9D1 1F3FE	People & Body	family	fully-qualified
🧑🏼‍❤️‍🧑🏿	couple with heart: person, person, medium-light skin tone, dark skin tone	1F9D1 1F3FC 200D 2764 FE0F 200D 1F9D1 1F3FF	People & Body	family	fully-qualified
🧑🏽‍❤️‍🧑🏻	couple with heart: person, person, medium skin tone, light skin tone	1F9D1 1F3FD 200D 2764 FE0F 200D 1F9D1 1F3FB	People & Body	family	fully-qualified
🧑🏽‍❤️‍🧑🏼	couple with heart: person, person, medium skin tone, medium-light skin tone	1F9D1 1F3FD 200D 2764 FE0F 200D 1F9D1 1F3FC	People & Body	family	fully-qualified
🧑🏽‍❤️‍🧑🏾	couple with heart: person, person, medium skin tone, medium-dark skin tone	1F9D1 1F3FD 200D 2764 FE0F 200D 1F9D1 1F3FE	People & Body	family	fully-qualified
🧑🏽‍❤️‍🧑🏿	couple with heart: person, person, medium skin tone, dark skin tone	1F9D1 1F3FD 200D 2764 FE0F 200D 1F9D1 1F3FF	People & Body	family	fully-qualified
🧑🏾‍❤️‍🧑🏻	couple with heart: person, person, medium-dark skin tone, light skin tone	1F9D1 1F3FE 200D 2764 FE0F 200D 1F9D1 1F3FB	People & Body	family	fully-qualified
🧑🏾‍❤️‍🧑🏼	couple with heart: person, person, medium-dark skin tone, medium-light skin tone	1F9D1 1F3FE 200D 2764 FE0F 200D 1F9D1 1F3FC	People & Body	family	fully-qualified
🧑🏾‍❤️‍🧑🏽	couple with heart: person, person, medium-dark skin tone, medium skin tone	1F9D1 1F3FE 200D 2764 FE0F 200D 1F9D1 1F3FD	People & Body	family	fully-qualified
🧑🏾‍❤️‍🧑🏿	couple with heart: person, person, medium-dark skin tone, dark skin tone	1F9D1 1F3FE 200D 2764 FE0F 200D 1F9D1 1F3FF	People & Body	family	fully-qualified
🧑🏿‍❤️‍🧑🏻	couple with heart: person, person, dark skin tone, light skin tone	1F9D1 1F3FF 200D 2764 FE0F 200D 1F9D1 1F3FB	People & Body	family	fully-qualified
🧑🏿‍❤️‍🧑🏼	couple with heart: person, person, dark skin tone, medium-light skin tone	1F9D1 1F3FF 200D 2764 FE0F 200D 1F9D1 1F3FC	People & Body	family	fully-qualified
🧑🏿‍❤️‍🧑🏽	couple with heart: person, person, dark skin tone, medium skin tone	1F9D1 1F3FF 200D 2764 FE0F 200D 1F9D1 1F3FD	People & Body	family	fully-qualified
🧑🏿‍❤️‍🧑🏾	couple with heart: person, person, dark skin tone, medium-dark skin tone	1F9D1 1F3FF 200D 2764 FE0F 200D 1F9D1 1F3FE	People & Body	family	fully-qualified
👩‍❤️‍👨	couple with heart: woman, man	1F469 200D 2764 FE0F 200D 1F468	People & Body	family	fully-qualified
👩🏻‍❤️‍👨🏻	couple with heart: woman, man, light skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F468 1F3FB	People & Body	family	fully-qualified
👩🏻‍❤️‍👨🏼	couple with heart: woman, man, light skin tone, medium-light skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F468 1F3FC	People & Body	family	fully-qualified
👩🏻‍❤️‍👨🏽	couple with heart: woman, man, light skin tone, medium skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F468 1F3FD	People & Body	family	fully-qualified
👩🏻‍❤️‍👨🏾	couple with heart: woman, man, light skin tone, medium-dark skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F468 1F3FE	People & Body	family	fully-qualified
👩🏻‍❤️‍👨🏿	couple with heart: woman, man, light skin tone, dark skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F468 1F3FF	People & Body	family	fully-qualified
👩🏼‍❤️‍👨🏻	couple with heart: woman, man, medium-light skin tone, light skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F468 1F3FB	People & Body	family	fully-qualified
👩🏼‍❤️‍👨🏼	couple with heart: woman, man, medium-light skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F468 1F3FC	People & Body	family	fully-qualified
👩🏼‍❤️‍👨🏽	couple with heart: woman, man, medium-light skin tone, medium skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F468 1F3FD	People & Body	family	fully-qualified
👩🏼‍❤️‍👨🏾	couple with heart: woman, man, medium-light skin tone, medium-dark skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F468 1F3FE	People & Body	family	fully-qualified
👩🏼‍❤️‍👨🏿	couple with heart: woman, man, medium-light skin tone, dark skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F468 1F3FF	People & Body	family	fully-qualified
👩🏽‍❤️‍👨🏻	couple with heart: woman, man, medium skin tone, light skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F468 1F3FB	People & Body	family	fully-qualified
👩🏽‍❤️‍👨🏼	couple with heart: woman, man, medium skin tone, medium-light skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F468 1F3FC	People & Body	family	fully-qualified
👩🏽‍❤️‍👨🏽	couple with heart: woman, man, medium skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F468 1F3FD	People & Body	family	fully-qualified
👩🏽‍❤️‍👨🏾	couple with heart: woman, man, medium skin tone, medium-dark skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F468 1F3FE	People & Body	family	fully-qualified
👩🏽‍❤️‍👨🏿	couple with heart: woman, man, medium skin tone, dark skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F468 1F3FF	People & Body	family	fully-qualified
👩🏾‍❤️‍👨🏻	couple with heart: woman, man, medium-dark skin tone, light skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F468 1F3FB	People & Body	family	fully-qualified
👩🏾‍❤️‍👨🏼	couple with heart: woman, man, medium-dark skin tone, medium-light skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F468 1F3FC	People & Body	family	fully-qualified
👩🏾‍❤️‍👨🏽	couple with heart: woman, man, medium-dark skin tone, medium skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F468 1F3FD	People & Body	family	fully-qualified
👩🏾‍❤️‍👨🏾	couple with heart: woman, man, medium-dark skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F468 1F3FE	People & Body	family	fully-qualified
👩🏾‍❤️‍👨🏿	couple with heart: woman, man, medium-dark skin tone, dark skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F468 1F3FF	People & Body	family	fully-qualified
👩🏿‍❤️‍👨🏻	couple with heart: woman, man, dark skin tone, light skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F468 1F3FB	People & Body	family	fully-qualified
👩🏿‍❤️‍👨🏼	couple with heart: woman, man, dark skin tone, medium-light skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F468 1F3FC	People & Body	family	fully-qualified
👩🏿‍❤️‍👨🏽	couple with heart: woman, man, dark skin tone, medium skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F468 1F3FD	People & Body	family	fully-qualified
👩🏿‍❤️‍👨🏾	couple with heart: woman, man, dark skin tone, medium-dark skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F468 1F3FE	People & Body	family	fully-qualified
👩🏿‍❤️‍👨🏿	couple with heart: woman, man, dark skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F468 1F3FF	People & Body	family	fully-qualified
👨‍❤️‍👨	couple with heart: man, man	1F468 200D 2764 FE0F 200D 1F468	People & Body	family	fully-qualified
👨🏻‍❤️‍👨🏻	couple with heart: man, man, light skin tone	1F468 1F3FB 200D 2764 FE0F 200D 1F468 1F3FB	People & Body	family	fully-qualified
👨🏻‍❤️‍👨🏼	couple with heart: man, man, light skin tone, medium-light skin tone	1F468 1F3FB 200D 2764 FE0F 200D 1F468 1F3FC	People & Body	family	fully-qualified
👨🏻‍❤️‍👨🏽	couple with heart: man, man, light skin tone, medium skin tone	1F468 1F3FB 200D 2764 FE0F 200D 1F468 1F3FD	People & Body	family	fully-qualified
👨🏻‍❤️‍👨🏾	couple with heart: man, man, light skin tone, medium-dark skin tone	1F468 1F3FB 200D 2764 FE0F 200D 1F468 1F3FE	People & Body	family	fully-qualified
👨🏻‍❤️‍👨🏿	couple with heart: man, man, light skin tone, dark skin tone	1F468 1F3FB 200D 2764 FE0F 200D 1F468 1F3FF	People & Body	family	fully-qualified
👨🏼‍❤️‍👨🏻	couple with heart: man, man, medium-light skin tone, light skin tone	1F468 1F3FC 200D 2764 FE0F 200D 1F468 1F3FB	People & Body	family	fully-qualified
👨🏼‍❤️‍👨🏼	couple with heart: man, man, medium-light skin tone	1F468 1F3FC 200D 2764 FE0F 200D 1F468 1F3FC	People & Body	family	fully-qualified
👨🏼‍❤️‍👨🏽	couple with heart: man, man, medium-light skin tone, medium skin tone	1F468 1F3FC 200D 2764 FE0F 200D 1F468 1F3FD	People & Body	family	fully-qualified
👨🏼‍❤️‍👨🏾	couple with heart: man, man, medium-light skin tone, medium-dark skin tone	1F468 1F3FC 200D 2764 FE0F 200D 1F468 1F3FE	People & Body	family	fully-qualified
👨🏼‍❤️‍👨🏿	couple with heart: man, man, medium-light skin tone, dark skin tone	1F468 1F3FC 200D 2764 FE0F 200D 1F468 1F3FF	People & Body	family	fully-qualified
👨🏽‍❤️‍👨🏻	couple with heart: man, man, medium skin tone, light skin tone	1F468 1F3FD 200D 2764 FE0F 200D 1F468 1F3FB	People & Body	family	fully-qualified
👨🏽‍❤️‍👨🏼	couple with heart: man, man, medium skin tone, medium-light skin tone	1F468 1F3FD 200D 2764 FE0F 200D 1F468 1F3FC	People & Body	family	fully-qualified
👨🏽‍❤️‍👨🏽	couple with heart: man, man, medium skin tone	1F468 1F3FD 200D 2764 FE0F 200D 1F468 1F3FD	People & Body	family	fully-qualified
👨🏽‍❤️‍👨🏾	couple with heart: man, man, medium skin tone, medium-dark skin tone	1F468 1F3FD 200D 2764 FE0F 200D 1F468 1F3FE	People & Body	family	fully-qualified
👨🏽‍❤️‍👨🏿	couple with heart: man, man, medium skin tone, dark skin tone	1F468 1F3FD 200D 2764 FE0F 200D 1F468 1F3FF	People & Body	family	fully-qualified
👨🏾‍❤️‍👨🏻	couple with heart: man, man, medium-dark skin tone, light skin tone	1F468 1F3FE 200D 2764 FE0F 200D 1F468 1F3FB	People & Body	family	fully-qualified
👨🏾‍❤️‍👨🏼	couple with heart: man, man, medium-dark skin tone, medium-light skin tone	1F468 1F3FE 200D 2764 FE0F 200D 1F468 1F3FC	People & Body	family	fully-qualified
👨🏾‍❤️‍👨🏽	couple with heart: man, man, medium-dark skin tone, medium skin tone	1F468 1F3FE 200D 2764 FE0F 200D 1F468 1F3FD	People & Body	family	fully-qualified
👨🏾‍❤️‍👨🏾	couple with heart: man, man, medium-dark skin tone	1F468 1F3FE 200D 2764 FE0F 200D 1F468 1F3FE	People & Body	family	fully-qualified
👨🏾‍❤️‍👨🏿	couple with heart: man, man, medium-dark skin tone, dark skin tone	1F468 1F3FE 200D 2764 FE0F 200D 1F468 1F3FF	People & Body	family	fully-qualified
👨🏿‍❤️‍👨🏻	couple with heart: man, man, dark skin tone, light skin tone	1F468 1F3FF 200D 2764 FE0F 200D 1F468 1F3FB	People & Body	family	fully-qualified
👨🏿‍❤️‍👨🏼	couple with heart: man, man, dark skin tone, medium-light skin tone	1F468 1F3FF 200D 2764 FE0F 200D 1F468 1F3FC	People & Body	family	fully-qualified
👨🏿‍❤️‍👨🏽	couple with heart: man, man, dark skin tone, medium skin tone	1F468 1F3FF 200D 2764 FE0F 200D 1F468 1F3FD	People & Body	family	fully-qualified
👨🏿‍❤️‍👨🏾	couple with heart: man, man, dark skin tone, medium-dark skin tone	1F468 1F3FF 200D 2764 FE0F 200D 1F468 1F3FE	People & Body	family	fully-qualified
👨🏿‍❤️‍👨🏿	couple with heart: man, man, dark skin tone	1F468 1F3FF 200D 2764 FE0F 200D 1F468 1F3FF	People & Body	family	fully-qualified
👩‍❤️‍👩	couple with heart: woman, woman	1F469 200D 2764 FE0F 200D 1F469	People & Body	family	fully-qualified
👩🏻‍❤️‍👩🏻	couple with heart: woman, woman, light skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F469 1F3FB	People & Body	family	fully-qualified
👩🏻‍❤️‍👩🏼	couple with heart: woman, woman, light skin tone, medium-light skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F469 1F3FC	People & Body	family	fully-qualified
👩🏻‍❤️‍👩🏽	couple with heart: woman, woman, light skin tone, medium skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F469 1F3FD	People & Body	family	fully-qualified
👩🏻‍❤️‍👩🏾	couple with heart: woman, woman, light skin tone, medium-dark skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F469 1F3FE	People & Body	family	fully-qualified
👩🏻‍❤️‍👩🏿	couple with heart: woman, woman, light skin tone, dark skin tone	1F469 1F3FB 200D 2764 FE0F 200D 1F469 1F3FF	People & Body	family	fully-qualified
👩🏼‍❤️‍👩🏻	couple with heart: woman, woman, medium-light skin tone, light skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F469 1F3FB	People & Body	family	fully-qualified
👩🏼‍❤️‍👩🏼	couple with heart: woman, woman, medium-light skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F469 1F3FC	People & Body	family	fully-qualified
👩🏼‍❤️‍👩🏽	couple with heart: woman, woman, medium-light skin tone, medium skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F469 1F3FD	People & Body	family	fully-qualified
👩🏼‍❤️‍👩🏾	couple with heart: woman, woman, medium-light skin tone, medium-dark skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F469 1F3FE	People & Body	family	fully-qualified
👩🏼‍❤️‍👩🏿	couple with heart: woman, woman, medium-light skin tone, dark skin tone	1F469 1F3FC 200D 2764 FE0F 200D 1F469 1F3FF	People & Body	family	fully-qualified
👩🏽‍❤️‍👩🏻	couple with heart: woman, woman, medium skin tone, light skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F469 1F3FB	People & Body	family	fully-qualified
👩🏽‍❤️‍👩🏼	couple with heart: woman, woman, medium skin tone, medium-light skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F469 1F3FC	People & Body	family	fully-qualified
👩🏽‍❤️‍👩🏽	couple with heart: woman, woman, medium skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F469 1F3FD	People & Body	family	fully-qualified
👩🏽‍❤️‍👩🏾	couple with heart: woman, woman, medium skin tone, medium-dark skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F469 1F3FE	People & Body	family	fully-qualified
👩🏽‍❤️‍👩🏿	couple with heart: woman, woman, medium skin tone, dark skin tone	1F469 1F3FD 200D 2764 FE0F 200D 1F469 1F3FF	People & Body	family	fully-qualified
👩🏾‍❤️‍👩🏻	couple with heart: woman, woman, medium-dark skin tone, light skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F469 1F3FB	People & Body	family	fully-qualified
👩🏾‍❤️‍👩🏼	couple with heart: woman, woman, medium-dark skin tone, medium-light skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F469 1F3FC	People & Body	family	fully-qualified
👩🏾‍❤️‍👩🏽	couple with heart: woman, woman, medium-dark skin tone, medium skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F469 1F3FD	People & Body	family	fully-qualified
👩🏾‍❤️‍👩🏾	couple with heart: woman, woman, medium-dark skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F469 1F3FE	People & Body	family	fully-qualified
👩🏾‍❤️‍👩🏿	couple with heart: woman, woman, medium-dark skin tone, dark skin tone	1F469 1F3FE 200D 2764 FE0F 200D 1F469 1F3FF	People & Body	family	fully-qualified
👩🏿‍❤️‍👩🏻	couple with heart: woman, woman, dark skin tone, light skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F469 1F3FB	People & Body	family	fully-qualified
👩🏿‍❤️‍👩🏼	couple with heart: woman, woman, dark skin tone, medium-light skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F469 1F3FC	People & Body	family	fully-qualified
👩🏿‍❤️‍👩🏽	couple with heart: woman, woman, dark skin tone, medium skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F469 1F3FD	People & Body	family	fully-qualified
👩🏿‍❤️‍👩🏾	couple with heart: woman, woman, dark skin tone, medium-dark skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F469 1F3FE	People & Body	family	fully-qualified
👩🏿‍❤️‍👩🏿	couple with heart: woman, woman, dark skin tone	1F469 1F3FF 200D 2764 FE0F 200D 1F469 1F3FF	People & Body	family	fully-qualified
👨‍👩‍👦	family: man, woman, boy	1F468 200D 1F469 200D 1F466	People & Body	family	fully-qualified
👨‍👩‍👧	family: man, woman, girl	1F468 200D 1F469 200D 1F467	People & Body	family	fully-qualified
👨‍👩‍👧‍👦	family: man, woman, girl, boy	1F468 200D 1F469 200D 1F467 200D 1F466	People & Body	family	fully-qualified
👨‍👩‍👦‍👦	family: man, woman, boy, boy	1F468 200D 1F469 200D 1F466 200D 1F466	People & Body	family	fully-qualified
👨‍👩‍👧‍👧	family: man, woman, girl, girl	1F468 200D 1F469 200D 1F467 200D 1F467	People & Body	family	fully-qualified
👨‍👨‍👦	family: man, man, boy	1F468 200D 1F468 200D 1F466	People & Body	family	fully-qualified
👨‍👨‍👧	family: man, man, girl	1F468 200D 1F468 200D 1F467	People & Body	family	fully-qualified
👨‍👨‍👧‍👦	family: man, man, girl, boy	1F468 200D 1F468 200D 1F467 200D 1F466	People & Body	family	fully-qualified
👨‍👨‍👦‍👦	family: man, man, boy, boy	1F468 200D 1F468 200D 1F466 200D 1F466	People & Body	family	fully-qualified
👨‍👨‍👧‍👧	family: man, man, girl, girl	1F468 200D 1F468 200D 1F467 200D 1F467	People & Body	family	fully-qualified
👩‍👩‍👦	family: woman, woman, boy	1F469 200D 1F469 200D 1F466	People & Body	family	fully-qualified
👩‍👩‍👧	family: woman, woman, girl	1F469 200D 1F469 200D 1F467	People & Body	family	fully-qualified
👩‍👩‍👧‍👦	family: woman, woman, girl, boy	1F469 200D 1F469 200D 1F467 200D 1F466	People & Body	family	fully-qualified
👩‍👩‍👦‍👦	family: woman, woman, boy, boy	1F469 200D 1F469 200D 1F466 200D 1F466	People & Body	family	fully-qualified
👩‍👩‍👧‍👧	family: woman, woman, girl, girl	1F469 200D 1F469 200D 1F467 200D 1F467	People & Body	family	fully-qualified
👨‍👦	family: man, boy	1F468 200D 1F466	People & Body	family	fully-qualified
👨‍👦‍👦	family: man, boy, boy	1F468 200D 1F466 200D 1F466	People & Body	family	fully-qualified
👨‍👧	family: man, girl	1F468 200D 1F467	People & Body	family	fully-qualified
👨‍👧‍👦	family: man, girl, boy	1F468 200D 1F467 200D 1F466	People & Body	family	fully-qualified
👨‍👧‍👧	family: man, girl, girl	1F468 200D 1F467 200D 1F467	People & Body	family	fully-qualified
👩‍👦	family: woman, boy	1F469 200D 1F466	People & Body	family	fully-qualified
👩‍👦‍👦	family: woman, boy, boy	1F469 200D 1F466 200D 1F466	People & Body	family	fully-qualified
👩‍👧	family: woman, girl	1F469 200D 1F467	People & Body	family	fully-qualified
👩‍👧‍👦	family: woman, girl, boy	1F469 200D 1F467 200D 1F466	People & Body	family	fully-qualified
👩‍👧‍👧	family: woman, girl, girl	1F469 200D 1F467 200D 1F467	People & Body	family	fully-qualified
🗣️	speaking head	1F5E3 FE0F	People & Body	person-symbol	fully-qualified
👤	bust in silhouette	1F464	People & Body	person-symbol	fully-qualified
👥	busts in silhouette	1F465	People & Body	person-symbol	fully-qualified
🫂	people hugging	1FAC2	People & Body	person-symbol	fully-qualified
👪	family	1F46A	People & Body	person-symbol	fully-qualified
🧑‍🧑‍🧒	family: adult, adult, child	1F9D1 200D 1F9D1 200D 1F9D2	People & Body	person-symbol	fully-qualified
🧑‍🧑‍🧒‍🧒	family: adult, adult, child, child	1F9D1 200D 1F9D1 200D 1F9D2 200D 1F9D2	People & Body	person-symbol	fully-qualified
🧑‍🧒	family: adult, child	1F9D1 200D 1F9D2	People & Body	person-symbol	fully-qualified
🧑‍🧒‍🧒	family: adult, child, child	1F9D1 200D 1F9D2 200D 1F9D2	People & Body	person-symbol	fully-qualified
👣	footprints	1F463	People & Body	person-symbol	fully-qualified
🫆	fingerprint	1FAC6	People & Body	person-symbol	fully-qualified
🏻	light skin tone	1F3FB	Component	skin-tone	component
🏼	medium-light skin tone	1F3FC	Component	skin-tone	component
🏽	medium skin tone	1F3FD	Component	skin-tone	component
🏾	medium-dark skin tone	1F3FE	Component	skin-tone	component
🏿	dark skin tone	1F3FF	Component	skin-tone	component
🦰	red hair	1F9B0	Component	hair-style	component
🦱	curly hair	1F9B1	Component	hair-style	component
🦳	white hair	1F9B3	Component	hair-style	component
🦲	bald	1F9B2	Component	hair-style	component
🐵	monkey face	1F435	Animals & Nature	animal-mammal	fully-qualified
🐒	monkey	1F412	Animals & Nature	animal-mammal	fully-qualified
🦍	gorilla	1F98D	Animals & Nature	animal-mammal	fully-qualified
🦧	orangutan	1F9A7	Animals & Nature	animal-mammal	fully-qualified
🐶	dog face	1F436	Animals & Nature	animal-mammal	fully-qualified
🐕	dog	1F415	Animals & Nature	animal-mammal	fully-qualified
🦮	guide dog	1F9AE	Animals & Nature	animal-mammal	fully-qualified
🐕‍🦺	service dog	1F415 200D 1F9BA	Animals & Nature	animal-mammal	fully-qualified
🐩	poodle	1F429	Animals & Nature	animal-mammal	fully-qualified
🐺	wolf	1F43A	Animals & Nature	animal-mammal	fully-qualified
🦊	fox	1F98A	Animals & Nature	animal-mammal	fully-qualified
🦝	raccoon	1F99D	Animals & Nature	animal-mammal	fully-qualified
🐱	cat face	1F431	Animals & Nature	animal-mammal	fully-qualified
🐈	cat	1F408	Animals & Nature	animal-mammal	fully-qualified
🐈‍⬛	black cat	1F408 200D 2B1B	Animals & Nature	animal-mammal	fully-qualified
🦁	lion	1F981	Animals & Nature	animal-mammal	fully-qualified
🐯	tiger face	1F42F	Animals & Nature	animal-mammal	fully-qualified
🐅	tiger	1F405	Animals & Nature	animal-mammal	fully-qualified
🐆	leopard	1F406	Animals & Nature	animal-mammal	fully-qualified
🐴	horse face	1F434	Animals & Nature	animal-mammal	fully-qualified
🫎	moose	1FACE	Animals & Nature	animal-mammal	fully-qualified
🫏	donkey	1FACF	Animals & Nature	animal-mammal	fully-qualified
🐎	horse	1F40E	Animals & Nature	animal-mammal	fully-qualified
🦄	unicorn	1F984	Animals & Nature	animal-mammal	fully-qualified
🦓	zebra	1F993	Animals & Nature	animal-mammal	fully-qualified
🦌	deer	1F98C	Animals & Nature	animal-mammal	fully-qualified
🦬	bison	1F9AC	Animals & Nature	animal-mammal	fully-qualified
🐮	cow face	1F42E	Animals & Nature	animal-mammal	fully-qualified
🐂	ox	1F402	Animals & Nature	animal-mammal	fully-qualified
🐃	water buffalo	1F403	Animals & Nature	animal-mammal	fully-qualified
🐄	cow	1F404	Animals & Nature	animal-mammal	fully-qualified
🐷	pig face	1F437	Animals & Nature	animal-mammal	fully-qualified
🐖	pig	1F416	Animals & Nature	animal-mammal	fully-qualified
🐗	boar	1F417	Animals & Nature	animal-mammal	fully-qualified
🐽	pig nose	1F43D	Animals & Nature	animal-mammal	fully-qualified
🐏	ram	1F40F	Animals & Nature	animal-mammal	fully-qualified
🐑	ewe	1F411	Animals & Nature	animal-mammal	fully-qualified
🐐	goat	1F410	Animals & Nature	animal-mammal	fully-qualified
🐪	camel	1F42A	Animals & Nature	animal-mammal	fully-qualified
🐫	two-hump camel	1F42B	Animals & Nature	animal-mammal	fully-qualified
🦙	llama	1F999	Animals & Nature	animal-mammal	fully-qualified
🦒	giraffe	1F992	Animals & Nature	animal-mammal	fully-qualified
🐘	elephant	1F418	Animals & Nature	animal-mammal	fully-qualified
🦣	mammoth	1F9A3	Animals & Nature	animal-mammal	fully-qualified
🦏	rhinoceros	1F98F	Animals & Nature	animal-mammal	fully-qualified
🦛	hippopotamus	1F99B	Animals & Nature	animal-mammal	fully-qualified
🐭	mouse face	1F42D	Animals & Nature	animal-mammal	fully-qualified
🐁	mouse	1F401	Animals & Nature	animal-mammal	fully-qualified
🐀	rat	1F400	Animals & Nature	animal-mammal	fully-qualified
🐹	hamster	1F439	Animals & Nature	animal-mammal	fully-qualified
🐰	rabbit face	1F430	Animals & Nature	animal-mammal	fully-qualified
🐇	rabbit	1F407	Animals & Nature	animal-mammal	fully-qualified
🐿️	chipmunk	1F43F FE0F	Animals & Nature	animal-mammal	fully-qualified
🦫	beaver	1F9AB	Animals & Nature	animal-mammal	fully-qualified
🦔	hedgehog	1F994	Animals & Nature	animal-mammal	fully-qualified
🦇	bat	1F987	Animals & Nature	animal-mammal	fully-qualified
🐻	bear	1F43B	Animals & Nature	animal-mammal	fully-qualified
🐻‍❄️	polar bear	1F43B 200D 2744 FE0F	Animals & Nature	animal-mammal	fully-qualified
🐨	koala	1F428	Animals & Nature	animal-mammal	fully-qualified
🐼	panda	1F43C	Animals & Nature	animal-mammal	fully-qualified
🦥	sloth	1F9A5	Animals & Nature	animal-mammal	fully-qualified
🦦	otter	1F9A6	Animals & Nature	animal-mammal	fully-qualified
🦨	skunk	1F9A8	Animals & Nature	animal-mammal	fully-qualified
🦘	kangaroo	1F998	Animals & Nature	animal-mammal	fully-qualified
🦡	badger	1F9A1	Animals & Nature	animal-mammal	fully-qualified
🐾	paw prints	1F43E	Animals & Nature	animal-mammal	fully-qualified
🦃	turkey	1F983	Animals & Nature	animal-bird	fully-qualified
🐔	chicken	1F414	Animals & Nature	animal-bird	fully-qualified
🐓	rooster	1F413	Animals & Nature	animal-bird	fully-qualified
🐣	hatching chick	1F423	Animals & Nature	animal-bird	fully-qualified
🐤	baby chick	1F424	Animals & Nature	animal-bird	fully-qualified
🐥	front-facing baby chick	1F425	Animals & Nature	animal-bird	fully-qualified
🐦	bird	1F426	Animals & Nature	animal-bird	fully-qualified
🐧	penguin	1F427	Animals & Nature	animal-bird	fully-qualified
🕊️	dove	1F54A FE0F	Animals & Nature	animal-bird	fully-qualified
🦅	eagle	1F985	Animals & Nature	animal-bird	fully-qualified
🦆	duck	1F986	Animals & Nature	animal-bird	fully-qualified
🦢	swan	1F9A2	Animals & Nature	animal-bird	fully-qualified
🦉	owl	1F989	Animals & Nature	animal-bird	fully-qualified
🦤	dodo	1F9A4	Animals & Nature	animal-bird	fully-qualified
🪶	feather	1FAB6	Animals & Nature	animal-bird	fully-qualified
🦩	flamingo	1F9A9	Animals & Nature	animal-bird	fully-qualified
🦚	peacock	1F99A	Animals & Nature	animal-bird	fully-qualified
🦜	parrot	1F99C	Animals & Nature	animal-bird	fully-qualified
🪽	wing	1FABD	Animals & Nature	animal-bird	fully-qualified
🐦‍⬛	black bird	1F426 200D 2B1B	Animals & Nature	animal-bird	fully-qualified
🪿	goose	1FABF	Animals & Nature	animal-bird	fully-qualified
🐦‍🔥	phoenix	1F426 200D 1F525	Animals & Nature	animal-bird	fully-qualified
🐸	frog	1F438	Animals & Nature	animal-amphibian	fully-qualified
🐊	crocodile	1F40A	Animals & Nature	animal-reptile	fully-qualified
🐢	turtle	1F422	Animals & Nature	animal-reptile	fully-qualified
🦎	lizard	1F98E	Animals & Nature	animal-reptile	fully-qualified
🐍	snake	1F40D	Animals & Nature	animal-reptile	fully-qualified
🐲	dragon face	1F432	Animals & Nature	animal-reptile	fully-qualified
🐉	dragon	1F409	Animals & Nature	animal-reptile	fully-qualified
🦕	sauropod	1F995	Animals & Nature	animal-reptile	fully-qualified
🦖	T-Rex	1F996	Animals & Nature	animal-reptile	fully-qualified
🐳	spouting whale	1F433	Animals & Nature	animal-marine	fully-qualified
🐋	whale	1F40B	Animals & Nature	animal-marine	fully-qualified
🐬	dolphin	1F42C	Animals & Nature	animal-marine	fully-qualified
🫍	orca	1FACD	Animals & Nature	animal-marine	fully-qualified
🦭	seal	1F9AD	Animals & Nature	animal-marine	fully-qualified
🐟	fish	1F41F	Animals & Nature	animal-marine	fully-qualified
🐠	tropical fish	1F420	Animals & Nature	animal-marine	fully-qualified
🐡	blowfish	1F421	Animals & Nature	animal-marine	fully-qualified
🦈	shark	1F988	Animals & Nature	animal-marine	fully-qualified
🐙	octopus	1F419	Animals & Nature	animal-marine	fully-qualified
🐚	spiral shell	1F41A	Animals & Nature	animal-marine	fully-qualified
🪸	coral	1FAB8	Animals & Nature	animal-marine	fully-qualified
🪼	jellyfish	1FABC	Animals & Nature	animal-marine	fully-qualified
🦀	crab	1F980	Animals & Nature	animal-marine	fully-qualified
🦞	lobster	1F99E	Animals & Nature	animal-marine	fully-qualified
🦐	shrimp	1F990	Animals & Nature	animal-marine	fully-qualified
🦑	squid	1F991	Animals & Nature	animal-marine	fully-qualified
🦪	oyster	1F9AA	Animals & Nature	animal-marine	fully-qualified
🐌	snail	1F40C	Animals & Nature	animal-bug	fully-qualified
🦋	butterfly	1F98B	Animals & Nature	animal-bug	fully-qualified
🐛	bug	1F41B	Animals & Nature	animal-bug	fully-qualified
🐜	ant	1F41C	Animals & Nature	animal-bug	fully-qualified
🐝	honeybee	1F41D	Animals & Nature	animal-bug	fully-qualified
🪲	beetle	1FAB2	Animals & Nature	animal-bug	fully-qualified
🐞	lady beetle	1F41E	Animals & Nature	animal-bug	fully-qualified
🦗	cricket	1F997	Animals & Nature	animal-bug	fully-qualified
🪳	cockroach	1FAB3	Animals & Nature	animal-bug	fully-qualified
🕷️	spider	1F577 FE0F	Animals & Nature	animal-bug	fully-qualified
🕸️	spider web	1F578 FE0F	Animals & Nature	animal-bug	fully-qualified
🦂	scorpion	1F982	Animals & Nature	animal-bug	fully-qualified
🦟	mosquito	1F99F	Animals & Nature	animal-bug	fully-qualified
🪰	fly	1FAB0	Animals & Nature	animal-bug	fully-qualified
🪱	worm	1FAB1	Animals & Nature	animal-bug	fully-qualified
🦠	microbe	1F9A0	Animals & Nature	animal-bug	fully-qualified
💐	bouquet	1F490	Animals & Nature	plant-flower	fully-qualified
🌸	cherry blossom	1F338	Animals & Nature	plant-flower	fully-qualified
💮	white flower	1F4AE	Animals & Nature	plant-flower	fully-qualified
🪷	lotus	1FAB7	Animals & Nature	plant-flower	fully-qualified
🏵️	rosette	1F3F5 FE0F	Animals & Nature	plant-flower	fully-qualified
🌹	rose	1F339	Animals & Nature	plant-flower	fully-qualified
🥀	wilted flower	1F940	Animals & Nature	plant-flower	fully-qualified
🌺	hibiscus	1F33A	Animals & Nature	plant-flower	fully-qualified
🌻	sunflower	1F33B	Animals & Nature	plant-flower	fully-qualified
🌼	blossom	1F33C	Animals & Nature	plant-flower	fully-qualified
🌷	tulip	1F337	Animals & Nature	plant-flower	fully-qualified
🪻	hyacinth	1FABB	Animals & Nature	plant-flower	fully-qualified
🌱	seedling	1F331	Animals & Nature	plant-other	fully-qualified
🪴	potted plant	1FAB4	Animals & Nature	plant-other	fully-qualified
🌲	evergreen tree	1F332	Animals & Nature	plant-other	fully-qualified
🌳	deciduous tree	1F333	Animals & Nature	plant-other	fully-qualified
🌴	palm tree	1F334	Animals & Nature	plant-other	fully-qualified
🌵	cactus	1F335	Animals & Nature	plant-other	fully-qualified
🌾	sheaf of rice	1F33E	Animals & Nature	plant-other	fully-qualified
🌿	herb	1F33F	Animals & Nature	plant-other	fully-qualified
☘️	shamrock	2618 FE0F	Animals & Nature	plant-other	fully-qualified
🍀	four leaf clover	1F340	Animals & Nature	plant-other	fully-qualified
🍁	maple leaf	1F341	Animals & Nature	plant-other	fully-qualified
🍂	fallen leaf	1F342	Animals & Nature	plant-other	fully-qualified
🍃	leaf fluttering in wind	1F343	Animals & Nature	plant-other	fully-qualified
🪹	empty nest	1FAB9	Animals & Nature	plant-other	fully-qualified
🪺	nest with eggs	1FABA	Animals & Nature	plant-other	fully-qualified
🍄	mushroom	1F344	Animals & Nature	plant-other	fully-qualified
🪾	leafless tree	1FABE	Animals & Nature	plant-other	fully-qualified
🍇	grapes	1F347	Food & Drink	food-fruit	fully-qualified
🍈	melon	1F348	Food & Drink	food-fruit	fully-qualified
🍉	watermelon	1F349	Food & Drink	food-fruit	fully-qualified
🍊	tangerine	1F34A	Food & Drink	food-fruit	fully-qualified
🍋	lemon	1F34B	Food & Drink	food-fruit	fully-qualified
🍋‍🟩	lime	1F34B 200D 1F7E9	Food & Drink	food-fruit	fully-qualified
🍌	banana	1F34C	Food & Drink	food-fruit	fully-qualified
🍍	pineapple	1F34D	Food & Drink	food-fruit	fully-qualified
🥭	mango	1F96D	Food & Drink	food-fruit	fully-qualified
🍎	red apple	1F34E	Food & Drink	food-fruit	fully-qualified
🍏	green apple	1F34F	Food & Drink	food-fruit	fully-qualified
🍐	pear	1F350	Food & Drink	food-fruit	fully-qualified
🍑	peach	1F351	Food & Drink	food-fruit	fully-qualified
🍒	cherries	1F352	Food & Drink	food-fruit	fully-qualified
🍓	strawberry	1F353	Food & Drink	food-fruit	fully-qualified
🫐	blueberries	1FAD0	Food & Drink	food-fruit	fully-qualified
🥝	kiwi fruit	1F95D	Food & Drink	food-fruit	fully-qualified
🍅	tomato	1F345	Food & Drink	food-fruit	fully-qualified
🫒	olive	1FAD2	Food & Drink	food-fruit	fully-qualified
🥥	coconut	1F965	Food & Drink	food-fruit	fully-qualified
🥑	avocado	1F951	Food & Drink	food-vegetable	fully-qualified
🍆	eggplant	1F346	Food & Drink	food-vegetable	fully-qualified
🥔	potato	1F954	Food & Drink	food-vegetable	fully-qualified
🥕	carrot	1F955	Food & Drink	food-vegetable	fully-qualified
🌽	ear of corn	1F33D	Food & Drink	food-vegetable	fully-qualified
🌶️	hot pepper	1F336 FE0F	Food & Drink	food-vegetable	fully-qualified
🫑	bell pepper	1FAD1	Food & Drink	food-vegetable	fully-qualified
🥒	cucumber	1F952	Food & Drink	food-vegetable	fully-qualified
🥬	leafy green	1F96C	Food & Drink	food-vegetable	fully-qualified
🥦	broccoli	1F966	Food & Drink	food-vegetable	fully-qualified
🧄	garlic	1F9C4	Food & Drink	food-vegetable	fully-qualified
🧅	onion	1F9C5	Food & Drink	food-vegetable	fully-qualified
🥜	peanuts	1F95C	Food & Drink	food-vegetable	fully-qualified
🫘	beans	1FAD8	Food & Drink	food-vegetable	fully-qualified
🌰	chestnut	1F330	Food & Drink	food-vegetable	fully-qualified
🫚	ginger root	1FADA	Food & Drink	food-vegetable	fully-qualified
🫛	pea pod	1FADB	Food & Drink	food-vegetable	fully-qualified
🍄‍🟫	brown mushroom	1F344 200D 1F7EB	Food & Drink	food-vegetable	fully-qualified
🫜	root vegetable	1FADC	Food & Drink	food-vegetable	fully-qualified
🍞	bread	1F35E	Food & Drink	food-prepared	fully-qualified
🥐	croissant	1F950	Food & Drink	food-prepared	fully-qualified
🥖	baguette bread	1F956	Food & Drink	food-prepared	fully-qualified
🫓	flatbread	1FAD3	Food & Drink	food-prepared	fully-qualified
🥨	pretzel	1F968	Food & Drink	food-prepared	fully-qualified
🥯	bagel	1F96F	Food & Drink	food-prepared	fully-qualified
🥞	pancakes	1F95E	Food & Drink	food-prepared	fully-qualified
🧇	waffle	1F9C7	Food & Drink	food-prepared	fully-qualified
🧀	cheese wedge	1F9C0	Food & Drink	food-prepared	fully-qualified
🍖	meat on bone	1F356	Food & Drink	food-prepared	fully-qualified
🍗	poultry leg	1F357	Food & Drink	food-prepared	fully-qualified
🥩	cut of meat	1F969	Food & Drink	food-prepared	fully-qualified
🥓	bacon	1F953	Food & Drink	food-prepared	fully-qualified
🍔	hamburger	1F354	Food & Drink	food-prepared	fully-qualified
🍟	french fries	1F35F	Food & Drink	food-prepared	fully-qualified
🍕	pizza	1F355	Food & Drink	food-prepared	fully-qualified
🌭	hot dog	1F32D	Food & Drink	food-prepared	fully-qualified
🥪	sandwich	1F96A	Food & Drink	food-prepared	fully-qualified
🌮	taco	1F32E	Food & Drink	food-prepared	fully-qualified
🌯	burrito	1F32F	Food & Drink	food-prepared	fully-qualified
🫔	tamale	1FAD4	Food & Drink	food-prepared	fully-qualified
🥙	stuffed flatbread	1F959	Food & Drink	food-prepared	fully-qualified
🧆	falafel	1F9C6	Food & Drink	food-prepared	fully-qualified
🥚	egg	1F95A	Food & Drink	food-prepared	fully-qualified
🍳	cooking	1F373	Food & Drink	food-prepared	fully-qualified
🥘	shallow pan of food	1F958	Food & Drink	food-prepared	fully-qualified
🍲	pot of food	1F372	Food & Drink	food-prepared	fully-qualified
🫕	fondue	1FAD5	Food & Drink	food-prepared	fully-qualified
🥣	bowl with spoon	1F963	Food & Drink	food-prepared	fully-qualified
🥗	green salad	1F957	Food & Drink	food-prepared	fully-qualified
🍿	popcorn	1F37F	Food & Drink	food-prepared	fully-qualified
🧈	butter	1F9C8	Food & Drink	food-prepared	fully-qualified
🧂	salt	1F9C2	Food & Drink	food-prepared	fully-qualified
🥫	canned food	1F96B	Food & Drink	food-prepared	fully-qualified
🍱	bento box	1F371	Food & Drink	food-asian	fully-qualified
🍘	rice cracker	1F358	Food & Drink	food-asian	fully-qualified
🍙	rice ball	1F359	Food & Drink	food-asian	fully-qualified
🍚	cooked rice	1F35A	Food & Drink	food-asian	fully-qualified
🍛	curry rice	1F35B	Food & Drink	food-asian	fully-qualified
🍜	steaming bowl	1F35C	Food & Drink	food-asian	fully-qualified
🍝	spaghetti	1F35D	Food & Drink	food-asian	fully-qualified
🍠	roasted sweet potato	1F360	Food & Drink	food-asian	fully-qualified
🍢	oden	1F362	Food & Drink	food-asian	fully-qualified
🍣	sushi	1F363	Food & Drink	food-asian	fully-qualified
🍤	fried shrimp	1F364	Food & Drink	food-asian	fully-qualified
🍥	fish cake with swirl	1F365	Food & Drink	food-asian	fully-qualified
🥮	moon cake	1F96E	Food & Drink	food-asian	fully-qualified
🍡	dango	1F361	Food & Drink	food-asian	fully-qualified
🥟	dumpling	1F95F	Food & Drink	food-asian	fully-qualified
🥠	fortune cookie	1F960	Food & Drink	food-asian	fully-qualified
🥡	takeout box	1F961	Food & Drink	food-asian	fully-qualified
🍦	soft ice cream	1F366	Food & Drink	food-sweet	fully-qualified
🍧	shaved ice	1F367	Food & Drink	food-sweet	fully-qualified
🍨	ice cream	1F368	Food & Drink	food-sweet	fully-qualified
🍩	doughnut	1F369	Food & Drink	food-sweet	fully-qualified
🍪	cookie	1F36A	Food & Drink	food-sweet	fully-qualified
🎂	birthday cake	1F382	Food & Drink	food-sweet	fully-qualified
🍰	shortcake	1F370	Food & Drink	food-sweet	fully-qualified
🧁	cupcake	1F9C1	Food & Drink	food-sweet	fully-qualified
🥧	pie	1F967	Food & Drink	food-sweet	fully-qualified
🍫	chocolate bar	1F36B	Food & Drink	food-sweet	fully-qualified
🍬	candy	1F36C	Food & Drink	food-sweet	fully-qualified
🍭	lollipop	1F36D	Food & Drink	food-sweet	fully-qualified
🍮	custard	1F36E	Food & Drink	food-sweet	fully-qualified
🍯	honey pot	1F36F	Food & Drink	food-sweet	fully-qualified
🍼	baby bottle	1F37C	Food & Drink	drink	fully-qualified
🥛	glass of milk	1F95B	Food & Drink	drink	fully-qualified
☕	hot beverage	2615	Food & Drink	drink	fully-qualified
🫖	teapot	1FAD6	Food & Drink	drink	fully-qualified
🍵	teacup without handle	1F375	Food & Drink	drink	fully-qualified
🍶	sake	1F376	Food & Drink	drink	fully-qualified
🍾	bottle with popping cork	1F37E	Food & Drink	drink	fully-qualified
🍷	wine glass	1F377	Food & Drink	drink	fully-qualified
🍸	cocktail glass	1F378	Food & Drink	drink	fully-qualified
🍹	tropical drink	1F379	Food & Drink	drink	fully-qualified
🍺	beer mug	1F37A	Food & Drink	drink	fully-qualified
🍻	clinking beer mugs	1F37B	Food & Drink	drink	fully-qualified
🥂	clinking glasses	1F942	Food & Drink	drink	fully-qualified
🥃	tumbler glass	1F943	Food & Drink	drink	fully-qualified
🫗	pouring liquid	1FAD7	Food & Drink	drink	fully-qualified
🥤	cup with straw	1F964	Food & Drink	drink	fully-qualified
🧋	bubble tea	1F9CB	Food & Drink	drink	fully-qualified
🧃	beverage box	1F9C3	Food & Drink	drink	fully-qualified
🧉	mate	1F9C9	Food & Drink	drink	fully-qualified
🧊	ice	1F9CA	Food & Drink	drink	fully-qualified
🥢	chopsticks	1F962	Food & Drink	dishware	fully-qualified
🍽️	fork and knife with plate	1F37D FE0F	Food & Drink	dishware	fully-qualified
🍴	fork and knife	1F374	Food & Drink	dishware	fully-qualified
🥄	spoon	1F944	Food & Drink	dishware	fully-qualified
🔪	kitchen knife	1F52A	Food & Drink	dishware	fully-qualified
🫙	jar	1FAD9	Food & Drink	dishware	fully-qualified
🏺	amphora	1F3FA	Food & Drink	dishware	fully-qualified
🌍	globe showing Europe-Africa	1F30D	Travel & Places	place-map	fully-qualified
🌎	globe showing Americas	1F30E	Travel & Places	place-map	fully-qualified
🌏	globe showing Asia-Australia	1F30F	Travel & Places	place-map	fully-qualified
🌐	globe with meridians	1F310	Travel & Places	place-map	fully-qualified
🗺️	world map	1F5FA FE0F	Travel & Places	place-map	fully-qualified
🗾	map of Japan	1F5FE	Travel & Places	place-map	fully-qualified
🧭	compass	1F9ED	Travel & Places	place-map	fully-qualified
🏔️	snow-capped mountain	1F3D4 FE0F	Travel & Places	place-geographic	fully-qualified
⛰️	mountain	26F0 FE0F	Travel & Places	place-geographic	fully-qualified
🛘	landslide	1F6D8	Travel & Places	place-geographic	fully-qualified
🌋	volcano	1F30B	Travel & Places	place-geographic	fully-qualified
🗻	mount fuji	1F5FB	Travel & Places	place-geographic	fully-qualified
🏕️	camping	1F3D5 FE0F	Travel & Places	place-geographic	fully-qualified
🏖️	beach with umbrella	1F3D6 FE0F	Travel & Places	place-geographic	fully-qualified
🏜️	desert	1F3DC FE0F	Travel & Places	place-geographic	fully-qualified
🏝️	desert island	1F3DD FE0F	Travel & Places	place-geographic	fully-qualified
🏞️	national park	1F3DE FE0F	Travel & Places	place-geographic	fully-qualified
🏟️	stadium	1F3DF FE0F	Travel & Places	place-building	fully-qualified
🏛️	classical building	1F3DB FE0F	Travel & Places	place-building	fully-qualified
🏗️	building construction	1F3D7 FE0F	Travel & Places	place-building	fully-qualified
🧱	brick	1F9F1	Travel & Places	place-building	fully-qualified
🪨	rock	1FAA8	Travel & Places	place-building	fully-qualified
🪵	wood	1FAB5	Travel & Places	place-building	fully-qualified
🛖	hut	1F6D6	Travel & Places	place-building	fully-qualified
🏘️	houses	1F3D8 FE0F	Travel & Places	place-building	fully-qualified
🏚️	derelict house	1F3DA FE0F	Travel & Places	place-building	fully-qualified
🏠	house	1F3E0	Travel & Places	place-building	fully-qualified
🏡	house with garden	1F3E1	Travel & Places	place-building	fully-qualified
🏢	office building	1F3E2	Travel & Places	place-building	fully-qualified
🏣	Japanese post office	1F3E3	Travel & Places	place-building	fully-qualified
🏤	post office	1F3E4	Travel & Places	place-building	fully-qualified
🏥	hospital	1F3E5	Travel & Places	place-building	fully-qualified
🏦	bank	1F3E6	Travel & Places	place-building	fully-qualified
🏨	hotel	1F3E8	Travel & Places	place-building	fully-qualified
🏩	love hotel	1F3E9	Travel & Places	place-building	fully-qualified
🏪	convenience store	1F3EA	Travel & Places	place-building	fully-qualified
🏫	school	1F3EB	Travel & Places	place-building	fully-qualified
🏬	department store	1F3EC	Travel & Places	place-building	fully-qualified
🏭	factory	1F3ED	Travel & Places	place-building	fully-qualified
🏯	Japanese castle	1F3EF	Travel & Places	place-building	fully-qualified
🏰	castle	1F3F0	Travel & Places	place-building	fully-qualified
💒	wedding	1F492	Travel & Places	place-building	fully-qualified
🗼	Tokyo tower	1F5FC	Travel & Places	place-building	fully-qualified
🗽	Statue of Liberty	1F5FD	Travel & Places	place-building	fully-qualified
⛪	church	26EA	Travel & Places	place-religious	fully-qualified
🕌	mosque	1F54C	Travel & Places	place-religious	fully-qualified
🛕	hindu temple	1F6D5	Travel & Places	place-religious	fully-qualified
🕍	synagogue	1F54D	Travel & Places	place-religious	fully-qualified
⛩️	shinto shrine	26E9 FE0F	Travel & Places	place-religious	fully-qualified
🕋	kaaba	1F54B	Travel & Places	place-religious	fully-qualified
⛲	fountain	26F2	Travel & Places	place-other	fully-qualified
⛺	tent	26FA	Travel & Places	place-other	fully-qualified
🌁	foggy	1F301	Travel & Places	place-other	fully-qualified
🌃	night with stars	1F303	Travel & Places	place-other	fully-qualified
🏙️	cityscape	1F3D9 FE0F	Travel & Places	place-other	fully-qualified
🌄	sunrise over mountains	1F304	Travel & Places	place-other	fully-qualified
🌅	sunrise	1F305	Travel & Places	place-other	fully-qualified
🌆	cityscape at dusk	1F306	Travel & Places	place-other	fully-qualified
🌇	sunset	1F307	Travel & Places	place-other	fully-qualified
🌉	bridge at night	1F309	Travel & Places	place-other	fully-qualified
♨️	hot springs	2668 FE0F	Travel & Places	place-other	fully-qualified
🎠	carousel horse	1F3A0	Travel & Places	place-other	fully-qualified
🛝	playground slide	1F6DD	Travel & Places	place-other	fully-qualified
🎡	ferris wheel	1F3A1	Travel & Places	place-other	fully-qualified
🎢	roller coaster	1F3A2	Travel & Places	place-other	fully-qualified
💈	barber pole	1F488	Travel & Places	place-other	fully-qualified
🎪	circus tent	1F3AA	Travel & Places	place-other	fully-qualified
🚂	locomotive	1F682	Travel & Places	transport-ground	fully-qualified
🚃	railway car	1F683	Travel & Places	transport-ground	fully-qualified
🚄	high-speed train	1F684	Travel & Places	transport-ground	fully-qualified
🚅	bullet train	1F685	Travel & Places	transport-ground	fully-qualified
🚆	train	1F686	Travel & Places	transport-ground	fully-qualified
🚇	metro	1F687	Travel & Places	transport-ground	fully-qualified
🚈	light rail	1F688	Travel & Places	transport-ground	fully-qualified
🚉	station	1F689	Travel & Places	transport-ground	fully-qualified
🚊	tram	1F68A	Travel & Places	transport-ground	fully-qualified
🚝	monorail	1F69D	Travel & Places	transport-ground	fully-qualified
🚞	mountain railway	1F69E	Travel & Places	transport-ground	fully-qualified
🚋	tram car	1F68B	Travel & Places	transport-ground	fully-qualified
🚌	bus	1F68C	Travel & Places	transport-ground	fully-qualified
🚍	oncoming bus	1F68D	Travel & Places	transport-ground	fully-qualified
🚎	trolleybus	1F68E	Travel & Places	transport-ground	fully-qualified
🚐	minibus	1F690	Travel & Places	transport-ground	fully-qualified
🚑	ambulance	1F691	Travel & Places	transport-ground	fully-qualified
🚒	fire engine	1F692	Travel & Places	transport-ground	fully-qualified
🚓	police car	1F693	Travel & Places	transport-ground	fully-qualified
🚔	oncoming police car	1F694	Travel & Places	transport-ground	fully-qualified
🚕	taxi	1F695	Travel & Places	transport-ground	fully-qualified
🚖	oncoming taxi	1F696	Travel & Places	transport-ground	fully-qualified
🚗	automobile	1F697	Travel & Places	transport-ground	fully-qualified
🚘	oncoming automobile	1F698	Travel & Places	transport-ground	fully-qualified
🚙	sport utility vehicle	1F699	Travel & Places	transport-ground	fully-qualified
🛻	pickup truck	1F6FB	Travel & Places	transport-ground	fully-qualified
🚚	delivery truck	1F69A	Travel & Places	transport-ground	fully-qualified
🚛	articulated lorry	1F69B	Travel & Places	transport-ground	fully-qualified
🚜	tractor	1F69C	Travel & Places	transport-ground	fully-qualified
🏎️	racing car	1F3CE FE0F	Travel & Places	transport-ground	fully-qualified
🏍️	motorcycle	1F3CD FE0F	Travel & Places	transport-ground	fully-qualified
🛵	motor scooter	1F6F5	Travel & Places	transport-ground	fully-qualified
🦽	manual wheelchair	1F9BD	Travel & Places	transport-ground	fully-qualified
🦼	motorized wheelchair	1F9BC	Travel & Places	transport-ground	fully-qualified
🛺	auto rickshaw	1F6FA	Travel & Places	transport-ground	fully-qualified
🚲	bicycle	1F6B2	Travel & Places	transport-ground	fully-qualified
🛴	kick scooter	1F6F4	Travel & Places	transport-ground	fully-qualified
🛹	skateboard	1F6F9	Travel & Places	transport-ground	fully-qualified
🛼	roller skate	1F6FC	Travel & Places	transport-ground	fully-qualified
🚏	bus stop	1F68F	Travel & Places	transport-ground	fully-qualified
🛣️	motorway	1F6E3 FE0F	Travel & Places	transport-ground	fully-qualified
🛤️	railway track	1F6E4 FE0F	Travel & Places	transport-ground	fully-qualified
🛢️	oil drum	1F6E2 FE0F	Travel & Places	transport-ground	fully-qualified
⛽	fuel pump	26FD	Travel & Places	transport-ground	fully-qualified
🛞	wheel	1F6DE	Travel & Places	transport-ground	fully-qualified
🚨	police car light	1F6A8	Travel & Places	transport-ground	fully-qualified
        """.trimIndent(),

        """
🚥	horizontal traffic light	1F6A5	Travel & Places	transport-ground	fully-qualified
🚦	vertical traffic light	1F6A6	Travel & Places	transport-ground	fully-qualified
🛑	stop sign	1F6D1	Travel & Places	transport-ground	fully-qualified
🚧	construction	1F6A7	Travel & Places	transport-ground	fully-qualified
⚓	anchor	2693	Travel & Places	transport-water	fully-qualified
🛟	ring buoy	1F6DF	Travel & Places	transport-water	fully-qualified
⛵	sailboat	26F5	Travel & Places	transport-water	fully-qualified
🛶	canoe	1F6F6	Travel & Places	transport-water	fully-qualified
🚤	speedboat	1F6A4	Travel & Places	transport-water	fully-qualified
🛳️	passenger ship	1F6F3 FE0F	Travel & Places	transport-water	fully-qualified
⛴️	ferry	26F4 FE0F	Travel & Places	transport-water	fully-qualified
🛥️	motor boat	1F6E5 FE0F	Travel & Places	transport-water	fully-qualified
🚢	ship	1F6A2	Travel & Places	transport-water	fully-qualified
✈️	airplane	2708 FE0F	Travel & Places	transport-air	fully-qualified
🛩️	small airplane	1F6E9 FE0F	Travel & Places	transport-air	fully-qualified
🛫	airplane departure	1F6EB	Travel & Places	transport-air	fully-qualified
🛬	airplane arrival	1F6EC	Travel & Places	transport-air	fully-qualified
🪂	parachute	1FA82	Travel & Places	transport-air	fully-qualified
💺	seat	1F4BA	Travel & Places	transport-air	fully-qualified
🚁	helicopter	1F681	Travel & Places	transport-air	fully-qualified
🚟	suspension railway	1F69F	Travel & Places	transport-air	fully-qualified
🚠	mountain cableway	1F6A0	Travel & Places	transport-air	fully-qualified
🚡	aerial tramway	1F6A1	Travel & Places	transport-air	fully-qualified
🛰️	satellite	1F6F0 FE0F	Travel & Places	transport-air	fully-qualified
🚀	rocket	1F680	Travel & Places	transport-air	fully-qualified
🛸	flying saucer	1F6F8	Travel & Places	transport-air	fully-qualified
🛎️	bellhop bell	1F6CE FE0F	Travel & Places	hotel	fully-qualified
🧳	luggage	1F9F3	Travel & Places	hotel	fully-qualified
⌛	hourglass done	231B	Travel & Places	time	fully-qualified
⏳	hourglass not done	23F3	Travel & Places	time	fully-qualified
⌚	watch	231A	Travel & Places	time	fully-qualified
⏰	alarm clock	23F0	Travel & Places	time	fully-qualified
⏱️	stopwatch	23F1 FE0F	Travel & Places	time	fully-qualified
⏲️	timer clock	23F2 FE0F	Travel & Places	time	fully-qualified
🕰️	mantelpiece clock	1F570 FE0F	Travel & Places	time	fully-qualified
🕛	twelve o’clock	1F55B	Travel & Places	time	fully-qualified
🕧	twelve-thirty	1F567	Travel & Places	time	fully-qualified
🕐	one o’clock	1F550	Travel & Places	time	fully-qualified
🕜	one-thirty	1F55C	Travel & Places	time	fully-qualified
🕑	two o’clock	1F551	Travel & Places	time	fully-qualified
🕝	two-thirty	1F55D	Travel & Places	time	fully-qualified
🕒	three o’clock	1F552	Travel & Places	time	fully-qualified
🕞	three-thirty	1F55E	Travel & Places	time	fully-qualified
🕓	four o’clock	1F553	Travel & Places	time	fully-qualified
🕟	four-thirty	1F55F	Travel & Places	time	fully-qualified
🕔	five o’clock	1F554	Travel & Places	time	fully-qualified
🕠	five-thirty	1F560	Travel & Places	time	fully-qualified
🕕	six o’clock	1F555	Travel & Places	time	fully-qualified
🕡	six-thirty	1F561	Travel & Places	time	fully-qualified
🕖	seven o’clock	1F556	Travel & Places	time	fully-qualified
🕢	seven-thirty	1F562	Travel & Places	time	fully-qualified
🕗	eight o’clock	1F557	Travel & Places	time	fully-qualified
🕣	eight-thirty	1F563	Travel & Places	time	fully-qualified
🕘	nine o’clock	1F558	Travel & Places	time	fully-qualified
🕤	nine-thirty	1F564	Travel & Places	time	fully-qualified
🕙	ten o’clock	1F559	Travel & Places	time	fully-qualified
🕥	ten-thirty	1F565	Travel & Places	time	fully-qualified
🕚	eleven o’clock	1F55A	Travel & Places	time	fully-qualified
🕦	eleven-thirty	1F566	Travel & Places	time	fully-qualified
🌑	new moon	1F311	Travel & Places	sky & weather	fully-qualified
🌒	waxing crescent moon	1F312	Travel & Places	sky & weather	fully-qualified
🌓	first quarter moon	1F313	Travel & Places	sky & weather	fully-qualified
🌔	waxing gibbous moon	1F314	Travel & Places	sky & weather	fully-qualified
🌕	full moon	1F315	Travel & Places	sky & weather	fully-qualified
🌖	waning gibbous moon	1F316	Travel & Places	sky & weather	fully-qualified
🌗	last quarter moon	1F317	Travel & Places	sky & weather	fully-qualified
🌘	waning crescent moon	1F318	Travel & Places	sky & weather	fully-qualified
🌙	crescent moon	1F319	Travel & Places	sky & weather	fully-qualified
🌚	new moon face	1F31A	Travel & Places	sky & weather	fully-qualified
🌛	first quarter moon face	1F31B	Travel & Places	sky & weather	fully-qualified
🌜	last quarter moon face	1F31C	Travel & Places	sky & weather	fully-qualified
🌡️	thermometer	1F321 FE0F	Travel & Places	sky & weather	fully-qualified
☀️	sun	2600 FE0F	Travel & Places	sky & weather	fully-qualified
🌝	full moon face	1F31D	Travel & Places	sky & weather	fully-qualified
🌞	sun with face	1F31E	Travel & Places	sky & weather	fully-qualified
🪐	ringed planet	1FA90	Travel & Places	sky & weather	fully-qualified
⭐	star	2B50	Travel & Places	sky & weather	fully-qualified
🌟	glowing star	1F31F	Travel & Places	sky & weather	fully-qualified
🌠	shooting star	1F320	Travel & Places	sky & weather	fully-qualified
🌌	milky way	1F30C	Travel & Places	sky & weather	fully-qualified
☁️	cloud	2601 FE0F	Travel & Places	sky & weather	fully-qualified
⛅	sun behind cloud	26C5	Travel & Places	sky & weather	fully-qualified
⛈️	cloud with lightning and rain	26C8 FE0F	Travel & Places	sky & weather	fully-qualified
🌤️	sun behind small cloud	1F324 FE0F	Travel & Places	sky & weather	fully-qualified
🌥️	sun behind large cloud	1F325 FE0F	Travel & Places	sky & weather	fully-qualified
🌦️	sun behind rain cloud	1F326 FE0F	Travel & Places	sky & weather	fully-qualified
🌧️	cloud with rain	1F327 FE0F	Travel & Places	sky & weather	fully-qualified
🌨️	cloud with snow	1F328 FE0F	Travel & Places	sky & weather	fully-qualified
🌩️	cloud with lightning	1F329 FE0F	Travel & Places	sky & weather	fully-qualified
🌪️	tornado	1F32A FE0F	Travel & Places	sky & weather	fully-qualified
🌫️	fog	1F32B FE0F	Travel & Places	sky & weather	fully-qualified
🌬️	wind face	1F32C FE0F	Travel & Places	sky & weather	fully-qualified
🌀	cyclone	1F300	Travel & Places	sky & weather	fully-qualified
🌈	rainbow	1F308	Travel & Places	sky & weather	fully-qualified
🌂	closed umbrella	1F302	Travel & Places	sky & weather	fully-qualified
☂️	umbrella	2602 FE0F	Travel & Places	sky & weather	fully-qualified
☔	umbrella with rain drops	2614	Travel & Places	sky & weather	fully-qualified
⛱️	umbrella on ground	26F1 FE0F	Travel & Places	sky & weather	fully-qualified
⚡	high voltage	26A1	Travel & Places	sky & weather	fully-qualified
❄️	snowflake	2744 FE0F	Travel & Places	sky & weather	fully-qualified
☃️	snowman	2603 FE0F	Travel & Places	sky & weather	fully-qualified
⛄	snowman without snow	26C4	Travel & Places	sky & weather	fully-qualified
☄️	comet	2604 FE0F	Travel & Places	sky & weather	fully-qualified
🔥	fire	1F525	Travel & Places	sky & weather	fully-qualified
💧	droplet	1F4A7	Travel & Places	sky & weather	fully-qualified
🌊	water wave	1F30A	Travel & Places	sky & weather	fully-qualified
🎃	jack-o-lantern	1F383	Activities	event	fully-qualified
🎄	Christmas tree	1F384	Activities	event	fully-qualified
🎆	fireworks	1F386	Activities	event	fully-qualified
🎇	sparkler	1F387	Activities	event	fully-qualified
🧨	firecracker	1F9E8	Activities	event	fully-qualified
✨	sparkles	2728	Activities	event	fully-qualified
🎈	balloon	1F388	Activities	event	fully-qualified
🎉	party popper	1F389	Activities	event	fully-qualified
🎊	confetti ball	1F38A	Activities	event	fully-qualified
🎋	tanabata tree	1F38B	Activities	event	fully-qualified
🎍	pine decoration	1F38D	Activities	event	fully-qualified
🎎	Japanese dolls	1F38E	Activities	event	fully-qualified
🎏	carp streamer	1F38F	Activities	event	fully-qualified
🎐	wind chime	1F390	Activities	event	fully-qualified
🎑	moon viewing ceremony	1F391	Activities	event	fully-qualified
🧧	red envelope	1F9E7	Activities	event	fully-qualified
🎀	ribbon	1F380	Activities	event	fully-qualified
🎁	wrapped gift	1F381	Activities	event	fully-qualified
🎗️	reminder ribbon	1F397 FE0F	Activities	event	fully-qualified
🎟️	admission tickets	1F39F FE0F	Activities	event	fully-qualified
🎫	ticket	1F3AB	Activities	event	fully-qualified
🎖️	military medal	1F396 FE0F	Activities	award-medal	fully-qualified
🏆	trophy	1F3C6	Activities	award-medal	fully-qualified
🏅	sports medal	1F3C5	Activities	award-medal	fully-qualified
🥇	1st place medal	1F947	Activities	award-medal	fully-qualified
🥈	2nd place medal	1F948	Activities	award-medal	fully-qualified
🥉	3rd place medal	1F949	Activities	award-medal	fully-qualified
⚽	soccer ball	26BD	Activities	sport	fully-qualified
⚾	baseball	26BE	Activities	sport	fully-qualified
🥎	softball	1F94E	Activities	sport	fully-qualified
🏀	basketball	1F3C0	Activities	sport	fully-qualified
🏐	volleyball	1F3D0	Activities	sport	fully-qualified
🏈	american football	1F3C8	Activities	sport	fully-qualified
🏉	rugby football	1F3C9	Activities	sport	fully-qualified
🎾	tennis	1F3BE	Activities	sport	fully-qualified
🥏	flying disc	1F94F	Activities	sport	fully-qualified
🎳	bowling	1F3B3	Activities	sport	fully-qualified
🏏	cricket game	1F3CF	Activities	sport	fully-qualified
🏑	field hockey	1F3D1	Activities	sport	fully-qualified
🏒	ice hockey	1F3D2	Activities	sport	fully-qualified
🥍	lacrosse	1F94D	Activities	sport	fully-qualified
🏓	ping pong	1F3D3	Activities	sport	fully-qualified
🏸	badminton	1F3F8	Activities	sport	fully-qualified
🥊	boxing glove	1F94A	Activities	sport	fully-qualified
🥋	martial arts uniform	1F94B	Activities	sport	fully-qualified
🥅	goal net	1F945	Activities	sport	fully-qualified
⛳	flag in hole	26F3	Activities	sport	fully-qualified
⛸️	ice skate	26F8 FE0F	Activities	sport	fully-qualified
🎣	fishing pole	1F3A3	Activities	sport	fully-qualified
🤿	diving mask	1F93F	Activities	sport	fully-qualified
🎽	running shirt	1F3BD	Activities	sport	fully-qualified
🎿	skis	1F3BF	Activities	sport	fully-qualified
🛷	sled	1F6F7	Activities	sport	fully-qualified
🥌	curling stone	1F94C	Activities	sport	fully-qualified
🎯	bullseye	1F3AF	Activities	game	fully-qualified
🪀	yo-yo	1FA80	Activities	game	fully-qualified
🪁	kite	1FA81	Activities	game	fully-qualified
🔫	water pistol	1F52B	Activities	game	fully-qualified
🎱	pool 8 ball	1F3B1	Activities	game	fully-qualified
🔮	crystal ball	1F52E	Activities	game	fully-qualified
🪄	magic wand	1FA84	Activities	game	fully-qualified
🎮	video game	1F3AE	Activities	game	fully-qualified
🕹️	joystick	1F579 FE0F	Activities	game	fully-qualified
🎰	slot machine	1F3B0	Activities	game	fully-qualified
🎲	game die	1F3B2	Activities	game	fully-qualified
🧩	puzzle piece	1F9E9	Activities	game	fully-qualified
🧸	teddy bear	1F9F8	Activities	game	fully-qualified
🪅	piñata	1FA85	Activities	game	fully-qualified
🪩	mirror ball	1FAA9	Activities	game	fully-qualified
🪆	nesting dolls	1FA86	Activities	game	fully-qualified
♠️	spade suit	2660 FE0F	Activities	game	fully-qualified
♥️	heart suit	2665 FE0F	Activities	game	fully-qualified
♦️	diamond suit	2666 FE0F	Activities	game	fully-qualified
♣️	club suit	2663 FE0F	Activities	game	fully-qualified
♟️	chess pawn	265F FE0F	Activities	game	fully-qualified
🃏	joker	1F0CF	Activities	game	fully-qualified
🀄	mahjong red dragon	1F004	Activities	game	fully-qualified
🎴	flower playing cards	1F3B4	Activities	game	fully-qualified
🎭	performing arts	1F3AD	Activities	arts & crafts	fully-qualified
🖼️	framed picture	1F5BC FE0F	Activities	arts & crafts	fully-qualified
🎨	artist palette	1F3A8	Activities	arts & crafts	fully-qualified
🧵	thread	1F9F5	Activities	arts & crafts	fully-qualified
🪡	sewing needle	1FAA1	Activities	arts & crafts	fully-qualified
🧶	yarn	1F9F6	Activities	arts & crafts	fully-qualified
🪢	knot	1FAA2	Activities	arts & crafts	fully-qualified
👓	glasses	1F453	Objects	clothing	fully-qualified
🕶️	sunglasses	1F576 FE0F	Objects	clothing	fully-qualified
🥽	goggles	1F97D	Objects	clothing	fully-qualified
🥼	lab coat	1F97C	Objects	clothing	fully-qualified
🦺	safety vest	1F9BA	Objects	clothing	fully-qualified
👔	necktie	1F454	Objects	clothing	fully-qualified
👕	t-shirt	1F455	Objects	clothing	fully-qualified
👖	jeans	1F456	Objects	clothing	fully-qualified
🧣	scarf	1F9E3	Objects	clothing	fully-qualified
🧤	gloves	1F9E4	Objects	clothing	fully-qualified
🧥	coat	1F9E5	Objects	clothing	fully-qualified
🧦	socks	1F9E6	Objects	clothing	fully-qualified
👗	dress	1F457	Objects	clothing	fully-qualified
👘	kimono	1F458	Objects	clothing	fully-qualified
🥻	sari	1F97B	Objects	clothing	fully-qualified
🩱	one-piece swimsuit	1FA71	Objects	clothing	fully-qualified
🩲	briefs	1FA72	Objects	clothing	fully-qualified
🩳	shorts	1FA73	Objects	clothing	fully-qualified
👙	bikini	1F459	Objects	clothing	fully-qualified
👚	woman’s clothes	1F45A	Objects	clothing	fully-qualified
🪭	folding hand fan	1FAAD	Objects	clothing	fully-qualified
👛	purse	1F45B	Objects	clothing	fully-qualified
👜	handbag	1F45C	Objects	clothing	fully-qualified
👝	clutch bag	1F45D	Objects	clothing	fully-qualified
🛍️	shopping bags	1F6CD FE0F	Objects	clothing	fully-qualified
🎒	backpack	1F392	Objects	clothing	fully-qualified
🩴	thong sandal	1FA74	Objects	clothing	fully-qualified
👞	man’s shoe	1F45E	Objects	clothing	fully-qualified
👟	running shoe	1F45F	Objects	clothing	fully-qualified
🥾	hiking boot	1F97E	Objects	clothing	fully-qualified
🥿	flat shoe	1F97F	Objects	clothing	fully-qualified
👠	high-heeled shoe	1F460	Objects	clothing	fully-qualified
👡	woman’s sandal	1F461	Objects	clothing	fully-qualified
🩰	ballet shoes	1FA70	Objects	clothing	fully-qualified
👢	woman’s boot	1F462	Objects	clothing	fully-qualified
🪮	hair pick	1FAAE	Objects	clothing	fully-qualified
👑	crown	1F451	Objects	clothing	fully-qualified
👒	woman’s hat	1F452	Objects	clothing	fully-qualified
🎩	top hat	1F3A9	Objects	clothing	fully-qualified
🎓	graduation cap	1F393	Objects	clothing	fully-qualified
🧢	billed cap	1F9E2	Objects	clothing	fully-qualified
🪖	military helmet	1FA96	Objects	clothing	fully-qualified
⛑️	rescue worker’s helmet	26D1 FE0F	Objects	clothing	fully-qualified
📿	prayer beads	1F4FF	Objects	clothing	fully-qualified
💄	lipstick	1F484	Objects	clothing	fully-qualified
💍	ring	1F48D	Objects	clothing	fully-qualified
💎	gem stone	1F48E	Objects	clothing	fully-qualified
🔇	muted speaker	1F507	Objects	sound	fully-qualified
🔈	speaker low volume	1F508	Objects	sound	fully-qualified
🔉	speaker medium volume	1F509	Objects	sound	fully-qualified
🔊	speaker high volume	1F50A	Objects	sound	fully-qualified
📢	loudspeaker	1F4E2	Objects	sound	fully-qualified
📣	megaphone	1F4E3	Objects	sound	fully-qualified
📯	postal horn	1F4EF	Objects	sound	fully-qualified
🔔	bell	1F514	Objects	sound	fully-qualified
🔕	bell with slash	1F515	Objects	sound	fully-qualified
🎼	musical score	1F3BC	Objects	music	fully-qualified
🎵	musical note	1F3B5	Objects	music	fully-qualified
🎶	musical notes	1F3B6	Objects	music	fully-qualified
🎙️	studio microphone	1F399 FE0F	Objects	music	fully-qualified
🎚️	level slider	1F39A FE0F	Objects	music	fully-qualified
🎛️	control knobs	1F39B FE0F	Objects	music	fully-qualified
🎤	microphone	1F3A4	Objects	music	fully-qualified
🎧	headphone	1F3A7	Objects	music	fully-qualified
📻	radio	1F4FB	Objects	music	fully-qualified
🎷	saxophone	1F3B7	Objects	musical-instrument	fully-qualified
🎺	trumpet	1F3BA	Objects	musical-instrument	fully-qualified
🪊	trombone	1FA8A	Objects	musical-instrument	fully-qualified
🪗	accordion	1FA97	Objects	musical-instrument	fully-qualified
🎸	guitar	1F3B8	Objects	musical-instrument	fully-qualified
🎹	musical keyboard	1F3B9	Objects	musical-instrument	fully-qualified
🎻	violin	1F3BB	Objects	musical-instrument	fully-qualified
🪕	banjo	1FA95	Objects	musical-instrument	fully-qualified
🥁	drum	1F941	Objects	musical-instrument	fully-qualified
🪘	long drum	1FA98	Objects	musical-instrument	fully-qualified
🪇	maracas	1FA87	Objects	musical-instrument	fully-qualified
🪈	flute	1FA88	Objects	musical-instrument	fully-qualified
🪉	harp	1FA89	Objects	musical-instrument	fully-qualified
📱	mobile phone	1F4F1	Objects	phone	fully-qualified
📲	mobile phone with arrow	1F4F2	Objects	phone	fully-qualified
☎️	telephone	260E FE0F	Objects	phone	fully-qualified
📞	telephone receiver	1F4DE	Objects	phone	fully-qualified
📟	pager	1F4DF	Objects	phone	fully-qualified
📠	fax machine	1F4E0	Objects	phone	fully-qualified
🔋	battery	1F50B	Objects	computer	fully-qualified
🪫	low battery	1FAAB	Objects	computer	fully-qualified
🔌	electric plug	1F50C	Objects	computer	fully-qualified
💻	laptop	1F4BB	Objects	computer	fully-qualified
🖥️	desktop computer	1F5A5 FE0F	Objects	computer	fully-qualified
🖨️	printer	1F5A8 FE0F	Objects	computer	fully-qualified
⌨️	keyboard	2328 FE0F	Objects	computer	fully-qualified
🖱️	computer mouse	1F5B1 FE0F	Objects	computer	fully-qualified
🖲️	trackball	1F5B2 FE0F	Objects	computer	fully-qualified
💽	computer disk	1F4BD	Objects	computer	fully-qualified
💾	floppy disk	1F4BE	Objects	computer	fully-qualified
💿	optical disk	1F4BF	Objects	computer	fully-qualified
📀	dvd	1F4C0	Objects	computer	fully-qualified
🧮	abacus	1F9EE	Objects	computer	fully-qualified
🎥	movie camera	1F3A5	Objects	light & video	fully-qualified
🎞️	film frames	1F39E FE0F	Objects	light & video	fully-qualified
📽️	film projector	1F4FD FE0F	Objects	light & video	fully-qualified
🎬	clapper board	1F3AC	Objects	light & video	fully-qualified
📺	television	1F4FA	Objects	light & video	fully-qualified
📷	camera	1F4F7	Objects	light & video	fully-qualified
📸	camera with flash	1F4F8	Objects	light & video	fully-qualified
📹	video camera	1F4F9	Objects	light & video	fully-qualified
📼	videocassette	1F4FC	Objects	light & video	fully-qualified
🔍	magnifying glass tilted left	1F50D	Objects	light & video	fully-qualified
🔎	magnifying glass tilted right	1F50E	Objects	light & video	fully-qualified
🕯️	candle	1F56F FE0F	Objects	light & video	fully-qualified
💡	light bulb	1F4A1	Objects	light & video	fully-qualified
🔦	flashlight	1F526	Objects	light & video	fully-qualified
🏮	red paper lantern	1F3EE	Objects	light & video	fully-qualified
🪔	diya lamp	1FA94	Objects	light & video	fully-qualified
📔	notebook with decorative cover	1F4D4	Objects	book-paper	fully-qualified
📕	closed book	1F4D5	Objects	book-paper	fully-qualified
📖	open book	1F4D6	Objects	book-paper	fully-qualified
📗	green book	1F4D7	Objects	book-paper	fully-qualified
📘	blue book	1F4D8	Objects	book-paper	fully-qualified
📙	orange book	1F4D9	Objects	book-paper	fully-qualified
📚	books	1F4DA	Objects	book-paper	fully-qualified
📓	notebook	1F4D3	Objects	book-paper	fully-qualified
📒	ledger	1F4D2	Objects	book-paper	fully-qualified
📃	page with curl	1F4C3	Objects	book-paper	fully-qualified
📜	scroll	1F4DC	Objects	book-paper	fully-qualified
📄	page facing up	1F4C4	Objects	book-paper	fully-qualified
📰	newspaper	1F4F0	Objects	book-paper	fully-qualified
🗞️	rolled-up newspaper	1F5DE FE0F	Objects	book-paper	fully-qualified
📑	bookmark tabs	1F4D1	Objects	book-paper	fully-qualified
🔖	bookmark	1F516	Objects	book-paper	fully-qualified
🏷️	label	1F3F7 FE0F	Objects	book-paper	fully-qualified
🪙	coin	1FA99	Objects	money	fully-qualified
💰	money bag	1F4B0	Objects	money	fully-qualified
🪎	treasure chest	1FA8E	Objects	money	fully-qualified
💴	yen banknote	1F4B4	Objects	money	fully-qualified
💵	dollar banknote	1F4B5	Objects	money	fully-qualified
💶	euro banknote	1F4B6	Objects	money	fully-qualified
💷	pound banknote	1F4B7	Objects	money	fully-qualified
💸	money with wings	1F4B8	Objects	money	fully-qualified
💳	credit card	1F4B3	Objects	money	fully-qualified
🧾	receipt	1F9FE	Objects	money	fully-qualified
💹	chart increasing with yen	1F4B9	Objects	money	fully-qualified
✉️	envelope	2709 FE0F	Objects	mail	fully-qualified
📧	e-mail	1F4E7	Objects	mail	fully-qualified
📨	incoming envelope	1F4E8	Objects	mail	fully-qualified
📩	envelope with arrow	1F4E9	Objects	mail	fully-qualified
📤	outbox tray	1F4E4	Objects	mail	fully-qualified
📥	inbox tray	1F4E5	Objects	mail	fully-qualified
📦	package	1F4E6	Objects	mail	fully-qualified
📫	closed mailbox with raised flag	1F4EB	Objects	mail	fully-qualified
📪	closed mailbox with lowered flag	1F4EA	Objects	mail	fully-qualified
📬	open mailbox with raised flag	1F4EC	Objects	mail	fully-qualified
📭	open mailbox with lowered flag	1F4ED	Objects	mail	fully-qualified
📮	postbox	1F4EE	Objects	mail	fully-qualified
🗳️	ballot box with ballot	1F5F3 FE0F	Objects	mail	fully-qualified
✏️	pencil	270F FE0F	Objects	writing	fully-qualified
✒️	black nib	2712 FE0F	Objects	writing	fully-qualified
🖋️	fountain pen	1F58B FE0F	Objects	writing	fully-qualified
🖊️	pen	1F58A FE0F	Objects	writing	fully-qualified
🖌️	paintbrush	1F58C FE0F	Objects	writing	fully-qualified
🖍️	crayon	1F58D FE0F	Objects	writing	fully-qualified
📝	memo	1F4DD	Objects	writing	fully-qualified
💼	briefcase	1F4BC	Objects	office	fully-qualified
📁	file folder	1F4C1	Objects	office	fully-qualified
📂	open file folder	1F4C2	Objects	office	fully-qualified
🗂️	card index dividers	1F5C2 FE0F	Objects	office	fully-qualified
📅	calendar	1F4C5	Objects	office	fully-qualified
📆	tear-off calendar	1F4C6	Objects	office	fully-qualified
🗒️	spiral notepad	1F5D2 FE0F	Objects	office	fully-qualified
🗓️	spiral calendar	1F5D3 FE0F	Objects	office	fully-qualified
📇	card index	1F4C7	Objects	office	fully-qualified
📈	chart increasing	1F4C8	Objects	office	fully-qualified
📉	chart decreasing	1F4C9	Objects	office	fully-qualified
📊	bar chart	1F4CA	Objects	office	fully-qualified
📋	clipboard	1F4CB	Objects	office	fully-qualified
📌	pushpin	1F4CC	Objects	office	fully-qualified
📍	round pushpin	1F4CD	Objects	office	fully-qualified
📎	paperclip	1F4CE	Objects	office	fully-qualified
🖇️	linked paperclips	1F587 FE0F	Objects	office	fully-qualified
📏	straight ruler	1F4CF	Objects	office	fully-qualified
📐	triangular ruler	1F4D0	Objects	office	fully-qualified
✂️	scissors	2702 FE0F	Objects	office	fully-qualified
🗃️	card file box	1F5C3 FE0F	Objects	office	fully-qualified
🗄️	file cabinet	1F5C4 FE0F	Objects	office	fully-qualified
🗑️	wastebasket	1F5D1 FE0F	Objects	office	fully-qualified
🔒	locked	1F512	Objects	lock	fully-qualified
🔓	unlocked	1F513	Objects	lock	fully-qualified
🔏	locked with pen	1F50F	Objects	lock	fully-qualified
🔐	locked with key	1F510	Objects	lock	fully-qualified
🔑	key	1F511	Objects	lock	fully-qualified
🗝️	old key	1F5DD FE0F	Objects	lock	fully-qualified
🔨	hammer	1F528	Objects	tool	fully-qualified
🪓	axe	1FA93	Objects	tool	fully-qualified
⛏️	pick	26CF FE0F	Objects	tool	fully-qualified
⚒️	hammer and pick	2692 FE0F	Objects	tool	fully-qualified
🛠️	hammer and wrench	1F6E0 FE0F	Objects	tool	fully-qualified
🗡️	dagger	1F5E1 FE0F	Objects	tool	fully-qualified
⚔️	crossed swords	2694 FE0F	Objects	tool	fully-qualified
💣	bomb	1F4A3	Objects	tool	fully-qualified
🪃	boomerang	1FA83	Objects	tool	fully-qualified
🏹	bow and arrow	1F3F9	Objects	tool	fully-qualified
🛡️	shield	1F6E1 FE0F	Objects	tool	fully-qualified
🪚	carpentry saw	1FA9A	Objects	tool	fully-qualified
🔧	wrench	1F527	Objects	tool	fully-qualified
🪛	screwdriver	1FA9B	Objects	tool	fully-qualified
🔩	nut and bolt	1F529	Objects	tool	fully-qualified
⚙️	gear	2699 FE0F	Objects	tool	fully-qualified
🗜️	clamp	1F5DC FE0F	Objects	tool	fully-qualified
⚖️	balance scale	2696 FE0F	Objects	tool	fully-qualified
🦯	white cane	1F9AF	Objects	tool	fully-qualified
🔗	link	1F517	Objects	tool	fully-qualified
⛓️‍💥	broken chain	26D3 FE0F 200D 1F4A5	Objects	tool	fully-qualified
⛓️	chains	26D3 FE0F	Objects	tool	fully-qualified
🪝	hook	1FA9D	Objects	tool	fully-qualified
🧰	toolbox	1F9F0	Objects	tool	fully-qualified
🧲	magnet	1F9F2	Objects	tool	fully-qualified
🪜	ladder	1FA9C	Objects	tool	fully-qualified
🪏	shovel	1FA8F	Objects	tool	fully-qualified
⚗️	alembic	2697 FE0F	Objects	science	fully-qualified
🧪	test tube	1F9EA	Objects	science	fully-qualified
🧫	petri dish	1F9EB	Objects	science	fully-qualified
🧬	dna	1F9EC	Objects	science	fully-qualified
🔬	microscope	1F52C	Objects	science	fully-qualified
🔭	telescope	1F52D	Objects	science	fully-qualified
📡	satellite antenna	1F4E1	Objects	science	fully-qualified
💉	syringe	1F489	Objects	medical	fully-qualified
🩸	drop of blood	1FA78	Objects	medical	fully-qualified
💊	pill	1F48A	Objects	medical	fully-qualified
🩹	adhesive bandage	1FA79	Objects	medical	fully-qualified
🩼	crutch	1FA7C	Objects	medical	fully-qualified
🩺	stethoscope	1FA7A	Objects	medical	fully-qualified
🩻	x-ray	1FA7B	Objects	medical	fully-qualified
🚪	door	1F6AA	Objects	household	fully-qualified
🛗	elevator	1F6D7	Objects	household	fully-qualified
🪞	mirror	1FA9E	Objects	household	fully-qualified
🪟	window	1FA9F	Objects	household	fully-qualified
🛏️	bed	1F6CF FE0F	Objects	household	fully-qualified
🛋️	couch and lamp	1F6CB FE0F	Objects	household	fully-qualified
🪑	chair	1FA91	Objects	household	fully-qualified
🚽	toilet	1F6BD	Objects	household	fully-qualified
🪠	plunger	1FAA0	Objects	household	fully-qualified
🚿	shower	1F6BF	Objects	household	fully-qualified
🛁	bathtub	1F6C1	Objects	household	fully-qualified
🪤	mouse trap	1FAA4	Objects	household	fully-qualified
🪒	razor	1FA92	Objects	household	fully-qualified
🧴	lotion bottle	1F9F4	Objects	household	fully-qualified
🧷	safety pin	1F9F7	Objects	household	fully-qualified
🧹	broom	1F9F9	Objects	household	fully-qualified
🧺	basket	1F9FA	Objects	household	fully-qualified
🧻	roll of paper	1F9FB	Objects	household	fully-qualified
🪣	bucket	1FAA3	Objects	household	fully-qualified
🧼	soap	1F9FC	Objects	household	fully-qualified
🫧	bubbles	1FAE7	Objects	household	fully-qualified
🪥	toothbrush	1FAA5	Objects	household	fully-qualified
🧽	sponge	1F9FD	Objects	household	fully-qualified
🧯	fire extinguisher	1F9EF	Objects	household	fully-qualified
🛒	shopping cart	1F6D2	Objects	household	fully-qualified
🚬	cigarette	1F6AC	Objects	other-object	fully-qualified
⚰️	coffin	26B0 FE0F	Objects	other-object	fully-qualified
🪦	headstone	1FAA6	Objects	other-object	fully-qualified
⚱️	funeral urn	26B1 FE0F	Objects	other-object	fully-qualified
🧿	nazar amulet	1F9FF	Objects	other-object	fully-qualified
🪬	hamsa	1FAAC	Objects	other-object	fully-qualified
🗿	moai	1F5FF	Objects	other-object	fully-qualified
🪧	placard	1FAA7	Objects	other-object	fully-qualified
🪪	identification card	1FAAA	Objects	other-object	fully-qualified
🏧	ATM sign	1F3E7	Symbols	transport-sign	fully-qualified
🚮	litter in bin sign	1F6AE	Symbols	transport-sign	fully-qualified
🚰	potable water	1F6B0	Symbols	transport-sign	fully-qualified
♿	wheelchair symbol	267F	Symbols	transport-sign	fully-qualified
🚹	men’s room	1F6B9	Symbols	transport-sign	fully-qualified
🚺	women’s room	1F6BA	Symbols	transport-sign	fully-qualified
🚻	restroom	1F6BB	Symbols	transport-sign	fully-qualified
🚼	baby symbol	1F6BC	Symbols	transport-sign	fully-qualified
🚾	water closet	1F6BE	Symbols	transport-sign	fully-qualified
🛂	passport control	1F6C2	Symbols	transport-sign	fully-qualified
🛃	customs	1F6C3	Symbols	transport-sign	fully-qualified
🛄	baggage claim	1F6C4	Symbols	transport-sign	fully-qualified
🛅	left luggage	1F6C5	Symbols	transport-sign	fully-qualified
⚠️	warning	26A0 FE0F	Symbols	warning	fully-qualified
🚸	children crossing	1F6B8	Symbols	warning	fully-qualified
⛔	no entry	26D4	Symbols	warning	fully-qualified
🚫	prohibited	1F6AB	Symbols	warning	fully-qualified
🚳	no bicycles	1F6B3	Symbols	warning	fully-qualified
🚭	no smoking	1F6AD	Symbols	warning	fully-qualified
🚯	no littering	1F6AF	Symbols	warning	fully-qualified
🚱	non-potable water	1F6B1	Symbols	warning	fully-qualified
🚷	no pedestrians	1F6B7	Symbols	warning	fully-qualified
📵	no mobile phones	1F4F5	Symbols	warning	fully-qualified
🔞	no one under eighteen	1F51E	Symbols	warning	fully-qualified
☢️	radioactive	2622 FE0F	Symbols	warning	fully-qualified
☣️	biohazard	2623 FE0F	Symbols	warning	fully-qualified
⬆️	up arrow	2B06 FE0F	Symbols	arrow	fully-qualified
↗️	up-right arrow	2197 FE0F	Symbols	arrow	fully-qualified
➡️	right arrow	27A1 FE0F	Symbols	arrow	fully-qualified
↘️	down-right arrow	2198 FE0F	Symbols	arrow	fully-qualified
⬇️	down arrow	2B07 FE0F	Symbols	arrow	fully-qualified
↙️	down-left arrow	2199 FE0F	Symbols	arrow	fully-qualified
⬅️	left arrow	2B05 FE0F	Symbols	arrow	fully-qualified
↖️	up-left arrow	2196 FE0F	Symbols	arrow	fully-qualified
↕️	up-down arrow	2195 FE0F	Symbols	arrow	fully-qualified
↔️	left-right arrow	2194 FE0F	Symbols	arrow	fully-qualified
↩️	right arrow curving left	21A9 FE0F	Symbols	arrow	fully-qualified
↪️	left arrow curving right	21AA FE0F	Symbols	arrow	fully-qualified
⤴️	right arrow curving up	2934 FE0F	Symbols	arrow	fully-qualified
⤵️	right arrow curving down	2935 FE0F	Symbols	arrow	fully-qualified
🔃	clockwise vertical arrows	1F503	Symbols	arrow	fully-qualified
🔄	counterclockwise arrows button	1F504	Symbols	arrow	fully-qualified
🔙	BACK arrow	1F519	Symbols	arrow	fully-qualified
🔚	END arrow	1F51A	Symbols	arrow	fully-qualified
🔛	ON! arrow	1F51B	Symbols	arrow	fully-qualified
🔜	SOON arrow	1F51C	Symbols	arrow	fully-qualified
🔝	TOP arrow	1F51D	Symbols	arrow	fully-qualified
🛐	place of worship	1F6D0	Symbols	religion	fully-qualified
⚛️	atom symbol	269B FE0F	Symbols	religion	fully-qualified
🕉️	om	1F549 FE0F	Symbols	religion	fully-qualified
✡️	star of David	2721 FE0F	Symbols	religion	fully-qualified
☸️	wheel of dharma	2638 FE0F	Symbols	religion	fully-qualified
☯️	yin yang	262F FE0F	Symbols	religion	fully-qualified
✝️	latin cross	271D FE0F	Symbols	religion	fully-qualified
☦️	orthodox cross	2626 FE0F	Symbols	religion	fully-qualified
☪️	star and crescent	262A FE0F	Symbols	religion	fully-qualified
☮️	peace symbol	262E FE0F	Symbols	religion	fully-qualified
🕎	menorah	1F54E	Symbols	religion	fully-qualified
🔯	dotted six-pointed star	1F52F	Symbols	religion	fully-qualified
🪯	khanda	1FAAF	Symbols	religion	fully-qualified
♈	Aries	2648	Symbols	zodiac	fully-qualified
♉	Taurus	2649	Symbols	zodiac	fully-qualified
♊	Gemini	264A	Symbols	zodiac	fully-qualified
♋	Cancer	264B	Symbols	zodiac	fully-qualified
♌	Leo	264C	Symbols	zodiac	fully-qualified
♍	Virgo	264D	Symbols	zodiac	fully-qualified
♎	Libra	264E	Symbols	zodiac	fully-qualified
♏	Scorpio	264F	Symbols	zodiac	fully-qualified
♐	Sagittarius	2650	Symbols	zodiac	fully-qualified
♑	Capricorn	2651	Symbols	zodiac	fully-qualified
♒	Aquarius	2652	Symbols	zodiac	fully-qualified
♓	Pisces	2653	Symbols	zodiac	fully-qualified
⛎	Ophiuchus	26CE	Symbols	zodiac	fully-qualified
🔀	shuffle tracks button	1F500	Symbols	av-symbol	fully-qualified
🔁	repeat button	1F501	Symbols	av-symbol	fully-qualified
🔂	repeat single button	1F502	Symbols	av-symbol	fully-qualified
▶️	play button	25B6 FE0F	Symbols	av-symbol	fully-qualified
⏩	fast-forward button	23E9	Symbols	av-symbol	fully-qualified
⏭️	next track button	23ED FE0F	Symbols	av-symbol	fully-qualified
⏯️	play or pause button	23EF FE0F	Symbols	av-symbol	fully-qualified
◀️	reverse button	25C0 FE0F	Symbols	av-symbol	fully-qualified
⏪	fast reverse button	23EA	Symbols	av-symbol	fully-qualified
⏮️	last track button	23EE FE0F	Symbols	av-symbol	fully-qualified
🔼	upwards button	1F53C	Symbols	av-symbol	fully-qualified
⏫	fast up button	23EB	Symbols	av-symbol	fully-qualified
🔽	downwards button	1F53D	Symbols	av-symbol	fully-qualified
⏬	fast down button	23EC	Symbols	av-symbol	fully-qualified
⏸️	pause button	23F8 FE0F	Symbols	av-symbol	fully-qualified
⏹️	stop button	23F9 FE0F	Symbols	av-symbol	fully-qualified
⏺️	record button	23FA FE0F	Symbols	av-symbol	fully-qualified
⏏️	eject button	23CF FE0F	Symbols	av-symbol	fully-qualified
🎦	cinema	1F3A6	Symbols	av-symbol	fully-qualified
🔅	dim button	1F505	Symbols	av-symbol	fully-qualified
🔆	bright button	1F506	Symbols	av-symbol	fully-qualified
📶	antenna bars	1F4F6	Symbols	av-symbol	fully-qualified
🛜	wireless	1F6DC	Symbols	av-symbol	fully-qualified
📳	vibration mode	1F4F3	Symbols	av-symbol	fully-qualified
📴	mobile phone off	1F4F4	Symbols	av-symbol	fully-qualified
♀️	female sign	2640 FE0F	Symbols	gender	fully-qualified
♂️	male sign	2642 FE0F	Symbols	gender	fully-qualified
⚧️	transgender symbol	26A7 FE0F	Symbols	gender	fully-qualified
✖️	multiply	2716 FE0F	Symbols	math	fully-qualified
➕	plus	2795	Symbols	math	fully-qualified
➖	minus	2796	Symbols	math	fully-qualified
➗	divide	2797	Symbols	math	fully-qualified
🟰	heavy equals sign	1F7F0	Symbols	math	fully-qualified
♾️	infinity	267E FE0F	Symbols	math	fully-qualified
‼️	double exclamation mark	203C FE0F	Symbols	punctuation	fully-qualified
⁉️	exclamation question mark	2049 FE0F	Symbols	punctuation	fully-qualified
❓	red question mark	2753	Symbols	punctuation	fully-qualified
❔	white question mark	2754	Symbols	punctuation	fully-qualified
❕	white exclamation mark	2755	Symbols	punctuation	fully-qualified
❗	red exclamation mark	2757	Symbols	punctuation	fully-qualified
〰️	wavy dash	3030 FE0F	Symbols	punctuation	fully-qualified
💱	currency exchange	1F4B1	Symbols	currency	fully-qualified
💲	heavy dollar sign	1F4B2	Symbols	currency	fully-qualified
⚕️	medical symbol	2695 FE0F	Symbols	other-symbol	fully-qualified
♻️	recycling symbol	267B FE0F	Symbols	other-symbol	fully-qualified
⚜️	fleur-de-lis	269C FE0F	Symbols	other-symbol	fully-qualified
🔱	trident emblem	1F531	Symbols	other-symbol	fully-qualified
📛	name badge	1F4DB	Symbols	other-symbol	fully-qualified
🔰	Japanese symbol for beginner	1F530	Symbols	other-symbol	fully-qualified
⭕	hollow red circle	2B55	Symbols	other-symbol	fully-qualified
✅	check mark button	2705	Symbols	other-symbol	fully-qualified
☑️	check box with check	2611 FE0F	Symbols	other-symbol	fully-qualified
✔️	check mark	2714 FE0F	Symbols	other-symbol	fully-qualified
❌	cross mark	274C	Symbols	other-symbol	fully-qualified
❎	cross mark button	274E	Symbols	other-symbol	fully-qualified
➰	curly loop	27B0	Symbols	other-symbol	fully-qualified
➿	double curly loop	27BF	Symbols	other-symbol	fully-qualified
〽️	part alternation mark	303D FE0F	Symbols	other-symbol	fully-qualified
✳️	eight-spoked asterisk	2733 FE0F	Symbols	other-symbol	fully-qualified
✴️	eight-pointed star	2734 FE0F	Symbols	other-symbol	fully-qualified
❇️	sparkle	2747 FE0F	Symbols	other-symbol	fully-qualified
©️	copyright	00A9 FE0F	Symbols	other-symbol	fully-qualified
®️	registered	00AE FE0F	Symbols	other-symbol	fully-qualified
™️	trade mark	2122 FE0F	Symbols	other-symbol	fully-qualified
🫟	splatter	1FADF	Symbols	other-symbol	fully-qualified
#️⃣	keycap: #	0023 FE0F 20E3	Symbols	keycap	fully-qualified
*️⃣	keycap: *	002A FE0F 20E3	Symbols	keycap	fully-qualified
0️⃣	keycap: 0	0030 FE0F 20E3	Symbols	keycap	fully-qualified
1️⃣	keycap: 1	0031 FE0F 20E3	Symbols	keycap	fully-qualified
2️⃣	keycap: 2	0032 FE0F 20E3	Symbols	keycap	fully-qualified
3️⃣	keycap: 3	0033 FE0F 20E3	Symbols	keycap	fully-qualified
4️⃣	keycap: 4	0034 FE0F 20E3	Symbols	keycap	fully-qualified
5️⃣	keycap: 5	0035 FE0F 20E3	Symbols	keycap	fully-qualified
6️⃣	keycap: 6	0036 FE0F 20E3	Symbols	keycap	fully-qualified
7️⃣	keycap: 7	0037 FE0F 20E3	Symbols	keycap	fully-qualified
8️⃣	keycap: 8	0038 FE0F 20E3	Symbols	keycap	fully-qualified
9️⃣	keycap: 9	0039 FE0F 20E3	Symbols	keycap	fully-qualified
🔟	keycap: 10	1F51F	Symbols	keycap	fully-qualified
🔠	input latin uppercase	1F520	Symbols	alphanum	fully-qualified
🔡	input latin lowercase	1F521	Symbols	alphanum	fully-qualified
🔢	input numbers	1F522	Symbols	alphanum	fully-qualified
🔣	input symbols	1F523	Symbols	alphanum	fully-qualified
🔤	input latin letters	1F524	Symbols	alphanum	fully-qualified
🅰️	A button (blood type)	1F170 FE0F	Symbols	alphanum	fully-qualified
🆎	AB button (blood type)	1F18E	Symbols	alphanum	fully-qualified
🅱️	B button (blood type)	1F171 FE0F	Symbols	alphanum	fully-qualified
🆑	CL button	1F191	Symbols	alphanum	fully-qualified
🆒	COOL button	1F192	Symbols	alphanum	fully-qualified
🆓	FREE button	1F193	Symbols	alphanum	fully-qualified
ℹ️	information	2139 FE0F	Symbols	alphanum	fully-qualified
🆔	ID button	1F194	Symbols	alphanum	fully-qualified
Ⓜ️	circled M	24C2 FE0F	Symbols	alphanum	fully-qualified
🆕	NEW button	1F195	Symbols	alphanum	fully-qualified
🆖	NG button	1F196	Symbols	alphanum	fully-qualified
🅾️	O button (blood type)	1F17E FE0F	Symbols	alphanum	fully-qualified
🆗	OK button	1F197	Symbols	alphanum	fully-qualified
🅿️	P button	1F17F FE0F	Symbols	alphanum	fully-qualified
🆘	SOS button	1F198	Symbols	alphanum	fully-qualified
🆙	UP! button	1F199	Symbols	alphanum	fully-qualified
🆚	VS button	1F19A	Symbols	alphanum	fully-qualified
🈁	Japanese “here” button	1F201	Symbols	alphanum	fully-qualified
🈂️	Japanese “service charge” button	1F202 FE0F	Symbols	alphanum	fully-qualified
🈷️	Japanese “monthly amount” button	1F237 FE0F	Symbols	alphanum	fully-qualified
🈶	Japanese “not free of charge” button	1F236	Symbols	alphanum	fully-qualified
🈯	Japanese “reserved” button	1F22F	Symbols	alphanum	fully-qualified
🉐	Japanese “bargain” button	1F250	Symbols	alphanum	fully-qualified
🈹	Japanese “discount” button	1F239	Symbols	alphanum	fully-qualified
🈚	Japanese “free of charge” button	1F21A	Symbols	alphanum	fully-qualified
🈲	Japanese “prohibited” button	1F232	Symbols	alphanum	fully-qualified
🉑	Japanese “acceptable” button	1F251	Symbols	alphanum	fully-qualified
🈸	Japanese “application” button	1F238	Symbols	alphanum	fully-qualified
🈴	Japanese “passing grade” button	1F234	Symbols	alphanum	fully-qualified
🈳	Japanese “vacancy” button	1F233	Symbols	alphanum	fully-qualified
㊗️	Japanese “congratulations” button	3297 FE0F	Symbols	alphanum	fully-qualified
㊙️	Japanese “secret” button	3299 FE0F	Symbols	alphanum	fully-qualified
🈺	Japanese “open for business” button	1F23A	Symbols	alphanum	fully-qualified
🈵	Japanese “no vacancy” button	1F235	Symbols	alphanum	fully-qualified
🔴	red circle	1F534	Symbols	geometric	fully-qualified
🟠	orange circle	1F7E0	Symbols	geometric	fully-qualified
🟡	yellow circle	1F7E1	Symbols	geometric	fully-qualified
🟢	green circle	1F7E2	Symbols	geometric	fully-qualified
🔵	blue circle	1F535	Symbols	geometric	fully-qualified
🟣	purple circle	1F7E3	Symbols	geometric	fully-qualified
🟤	brown circle	1F7E4	Symbols	geometric	fully-qualified
⚫	black circle	26AB	Symbols	geometric	fully-qualified
⚪	white circle	26AA	Symbols	geometric	fully-qualified
🟥	red square	1F7E5	Symbols	geometric	fully-qualified
🟧	orange square	1F7E7	Symbols	geometric	fully-qualified
🟨	yellow square	1F7E8	Symbols	geometric	fully-qualified
🟩	green square	1F7E9	Symbols	geometric	fully-qualified
🟦	blue square	1F7E6	Symbols	geometric	fully-qualified
🟪	purple square	1F7EA	Symbols	geometric	fully-qualified
🟫	brown square	1F7EB	Symbols	geometric	fully-qualified
⬛	black large square	2B1B	Symbols	geometric	fully-qualified
⬜	white large square	2B1C	Symbols	geometric	fully-qualified
◼️	black medium square	25FC FE0F	Symbols	geometric	fully-qualified
◻️	white medium square	25FB FE0F	Symbols	geometric	fully-qualified
◾	black medium-small square	25FE	Symbols	geometric	fully-qualified
◽	white medium-small square	25FD	Symbols	geometric	fully-qualified
▪️	black small square	25AA FE0F	Symbols	geometric	fully-qualified
▫️	white small square	25AB FE0F	Symbols	geometric	fully-qualified
🔶	large orange diamond	1F536	Symbols	geometric	fully-qualified
🔷	large blue diamond	1F537	Symbols	geometric	fully-qualified
🔸	small orange diamond	1F538	Symbols	geometric	fully-qualified
🔹	small blue diamond	1F539	Symbols	geometric	fully-qualified
🔺	red triangle pointed up	1F53A	Symbols	geometric	fully-qualified
🔻	red triangle pointed down	1F53B	Symbols	geometric	fully-qualified
💠	diamond with a dot	1F4A0	Symbols	geometric	fully-qualified
🔘	radio button	1F518	Symbols	geometric	fully-qualified
🔳	white square button	1F533	Symbols	geometric	fully-qualified
🔲	black square button	1F532	Symbols	geometric	fully-qualified
🏁	chequered flag	1F3C1	Flags	flag	fully-qualified
🚩	triangular flag	1F6A9	Flags	flag	fully-qualified
🎌	crossed flags	1F38C	Flags	flag	fully-qualified
🏴	black flag	1F3F4	Flags	flag	fully-qualified
🏳️	white flag	1F3F3 FE0F	Flags	flag	fully-qualified
🏳️‍🌈	rainbow flag	1F3F3 FE0F 200D 1F308	Flags	flag	fully-qualified
🏳️‍⚧️	transgender flag	1F3F3 FE0F 200D 26A7 FE0F	Flags	flag	fully-qualified
🏴‍☠️	pirate flag	1F3F4 200D 2620 FE0F	Flags	flag	fully-qualified
🇦🇨	flag: Ascension Island	1F1E6 1F1E8	Flags	country-flag	fully-qualified
🇦🇩	flag: Andorra	1F1E6 1F1E9	Flags	country-flag	fully-qualified
🇦🇪	flag: United Arab Emirates	1F1E6 1F1EA	Flags	country-flag	fully-qualified
🇦🇫	flag: Afghanistan	1F1E6 1F1EB	Flags	country-flag	fully-qualified
🇦🇬	flag: Antigua & Barbuda	1F1E6 1F1EC	Flags	country-flag	fully-qualified
🇦🇮	flag: Anguilla	1F1E6 1F1EE	Flags	country-flag	fully-qualified
🇦🇱	flag: Albania	1F1E6 1F1F1	Flags	country-flag	fully-qualified
🇦🇲	flag: Armenia	1F1E6 1F1F2	Flags	country-flag	fully-qualified
🇦🇴	flag: Angola	1F1E6 1F1F4	Flags	country-flag	fully-qualified
🇦🇶	flag: Antarctica	1F1E6 1F1F6	Flags	country-flag	fully-qualified
🇦🇷	flag: Argentina	1F1E6 1F1F7	Flags	country-flag	fully-qualified
🇦🇸	flag: American Samoa	1F1E6 1F1F8	Flags	country-flag	fully-qualified
🇦🇹	flag: Austria	1F1E6 1F1F9	Flags	country-flag	fully-qualified
🇦🇺	flag: Australia	1F1E6 1F1FA	Flags	country-flag	fully-qualified
🇦🇼	flag: Aruba	1F1E6 1F1FC	Flags	country-flag	fully-qualified
🇦🇽	flag: Åland Islands	1F1E6 1F1FD	Flags	country-flag	fully-qualified
🇦🇿	flag: Azerbaijan	1F1E6 1F1FF	Flags	country-flag	fully-qualified
🇧🇦	flag: Bosnia & Herzegovina	1F1E7 1F1E6	Flags	country-flag	fully-qualified
🇧🇧	flag: Barbados	1F1E7 1F1E7	Flags	country-flag	fully-qualified
🇧🇩	flag: Bangladesh	1F1E7 1F1E9	Flags	country-flag	fully-qualified
🇧🇪	flag: Belgium	1F1E7 1F1EA	Flags	country-flag	fully-qualified
🇧🇫	flag: Burkina Faso	1F1E7 1F1EB	Flags	country-flag	fully-qualified
🇧🇬	flag: Bulgaria	1F1E7 1F1EC	Flags	country-flag	fully-qualified
🇧🇭	flag: Bahrain	1F1E7 1F1ED	Flags	country-flag	fully-qualified
🇧🇮	flag: Burundi	1F1E7 1F1EE	Flags	country-flag	fully-qualified
🇧🇯	flag: Benin	1F1E7 1F1EF	Flags	country-flag	fully-qualified
🇧🇱	flag: St. Barthélemy	1F1E7 1F1F1	Flags	country-flag	fully-qualified
🇧🇲	flag: Bermuda	1F1E7 1F1F2	Flags	country-flag	fully-qualified
🇧🇳	flag: Brunei	1F1E7 1F1F3	Flags	country-flag	fully-qualified
🇧🇴	flag: Bolivia	1F1E7 1F1F4	Flags	country-flag	fully-qualified
🇧🇶	flag: Caribbean Netherlands	1F1E7 1F1F6	Flags	country-flag	fully-qualified
🇧🇷	flag: Brazil	1F1E7 1F1F7	Flags	country-flag	fully-qualified
🇧🇸	flag: Bahamas	1F1E7 1F1F8	Flags	country-flag	fully-qualified
🇧🇹	flag: Bhutan	1F1E7 1F1F9	Flags	country-flag	fully-qualified
🇧🇻	flag: Bouvet Island	1F1E7 1F1FB	Flags	country-flag	fully-qualified
🇧🇼	flag: Botswana	1F1E7 1F1FC	Flags	country-flag	fully-qualified
🇧🇾	flag: Belarus	1F1E7 1F1FE	Flags	country-flag	fully-qualified
🇧🇿	flag: Belize	1F1E7 1F1FF	Flags	country-flag	fully-qualified
🇨🇦	flag: Canada	1F1E8 1F1E6	Flags	country-flag	fully-qualified
🇨🇨	flag: Cocos (Keeling) Islands	1F1E8 1F1E8	Flags	country-flag	fully-qualified
🇨🇩	flag: Congo - Kinshasa	1F1E8 1F1E9	Flags	country-flag	fully-qualified
🇨🇫	flag: Central African Republic	1F1E8 1F1EB	Flags	country-flag	fully-qualified
🇨🇬	flag: Congo - Brazzaville	1F1E8 1F1EC	Flags	country-flag	fully-qualified
🇨🇭	flag: Switzerland	1F1E8 1F1ED	Flags	country-flag	fully-qualified
🇨🇮	flag: Côte d’Ivoire	1F1E8 1F1EE	Flags	country-flag	fully-qualified
🇨🇰	flag: Cook Islands	1F1E8 1F1F0	Flags	country-flag	fully-qualified
🇨🇱	flag: Chile	1F1E8 1F1F1	Flags	country-flag	fully-qualified
🇨🇲	flag: Cameroon	1F1E8 1F1F2	Flags	country-flag	fully-qualified
🇨🇳	flag: China	1F1E8 1F1F3	Flags	country-flag	fully-qualified
🇨🇴	flag: Colombia	1F1E8 1F1F4	Flags	country-flag	fully-qualified
🇨🇵	flag: Clipperton Island	1F1E8 1F1F5	Flags	country-flag	fully-qualified
🇨🇶	flag: Sark	1F1E8 1F1F6	Flags	country-flag	fully-qualified
🇨🇷	flag: Costa Rica	1F1E8 1F1F7	Flags	country-flag	fully-qualified
🇨🇺	flag: Cuba	1F1E8 1F1FA	Flags	country-flag	fully-qualified
🇨🇻	flag: Cape Verde	1F1E8 1F1FB	Flags	country-flag	fully-qualified
🇨🇼	flag: Curaçao	1F1E8 1F1FC	Flags	country-flag	fully-qualified
🇨🇽	flag: Christmas Island	1F1E8 1F1FD	Flags	country-flag	fully-qualified
🇨🇾	flag: Cyprus	1F1E8 1F1FE	Flags	country-flag	fully-qualified
🇨🇿	flag: Czechia	1F1E8 1F1FF	Flags	country-flag	fully-qualified
🇩🇪	flag: Germany	1F1E9 1F1EA	Flags	country-flag	fully-qualified
🇩🇬	flag: Diego Garcia	1F1E9 1F1EC	Flags	country-flag	fully-qualified
🇩🇯	flag: Djibouti	1F1E9 1F1EF	Flags	country-flag	fully-qualified
🇩🇰	flag: Denmark	1F1E9 1F1F0	Flags	country-flag	fully-qualified
🇩🇲	flag: Dominica	1F1E9 1F1F2	Flags	country-flag	fully-qualified
🇩🇴	flag: Dominican Republic	1F1E9 1F1F4	Flags	country-flag	fully-qualified
🇩🇿	flag: Algeria	1F1E9 1F1FF	Flags	country-flag	fully-qualified
🇪🇦	flag: Ceuta & Melilla	1F1EA 1F1E6	Flags	country-flag	fully-qualified
🇪🇨	flag: Ecuador	1F1EA 1F1E8	Flags	country-flag	fully-qualified
🇪🇪	flag: Estonia	1F1EA 1F1EA	Flags	country-flag	fully-qualified
🇪🇬	flag: Egypt	1F1EA 1F1EC	Flags	country-flag	fully-qualified
🇪🇭	flag: Western Sahara	1F1EA 1F1ED	Flags	country-flag	fully-qualified
🇪🇷	flag: Eritrea	1F1EA 1F1F7	Flags	country-flag	fully-qualified
🇪🇸	flag: Spain	1F1EA 1F1F8	Flags	country-flag	fully-qualified
🇪🇹	flag: Ethiopia	1F1EA 1F1F9	Flags	country-flag	fully-qualified
🇪🇺	flag: European Union	1F1EA 1F1FA	Flags	country-flag	fully-qualified
🇫🇮	flag: Finland	1F1EB 1F1EE	Flags	country-flag	fully-qualified
🇫🇯	flag: Fiji	1F1EB 1F1EF	Flags	country-flag	fully-qualified
🇫🇰	flag: Falkland Islands	1F1EB 1F1F0	Flags	country-flag	fully-qualified
🇫🇲	flag: Micronesia	1F1EB 1F1F2	Flags	country-flag	fully-qualified
🇫🇴	flag: Faroe Islands	1F1EB 1F1F4	Flags	country-flag	fully-qualified
🇫🇷	flag: France	1F1EB 1F1F7	Flags	country-flag	fully-qualified
🇬🇦	flag: Gabon	1F1EC 1F1E6	Flags	country-flag	fully-qualified
🇬🇧	flag: United Kingdom	1F1EC 1F1E7	Flags	country-flag	fully-qualified
🇬🇩	flag: Grenada	1F1EC 1F1E9	Flags	country-flag	fully-qualified
🇬🇪	flag: Georgia	1F1EC 1F1EA	Flags	country-flag	fully-qualified
🇬🇫	flag: French Guiana	1F1EC 1F1EB	Flags	country-flag	fully-qualified
🇬🇬	flag: Guernsey	1F1EC 1F1EC	Flags	country-flag	fully-qualified
🇬🇭	flag: Ghana	1F1EC 1F1ED	Flags	country-flag	fully-qualified
🇬🇮	flag: Gibraltar	1F1EC 1F1EE	Flags	country-flag	fully-qualified
🇬🇱	flag: Greenland	1F1EC 1F1F1	Flags	country-flag	fully-qualified
🇬🇲	flag: Gambia	1F1EC 1F1F2	Flags	country-flag	fully-qualified
🇬🇳	flag: Guinea	1F1EC 1F1F3	Flags	country-flag	fully-qualified
🇬🇵	flag: Guadeloupe	1F1EC 1F1F5	Flags	country-flag	fully-qualified
🇬🇶	flag: Equatorial Guinea	1F1EC 1F1F6	Flags	country-flag	fully-qualified
🇬🇷	flag: Greece	1F1EC 1F1F7	Flags	country-flag	fully-qualified
🇬🇸	flag: South Georgia & South Sandwich Islands	1F1EC 1F1F8	Flags	country-flag	fully-qualified
🇬🇹	flag: Guatemala	1F1EC 1F1F9	Flags	country-flag	fully-qualified
🇬🇺	flag: Guam	1F1EC 1F1FA	Flags	country-flag	fully-qualified
🇬🇼	flag: Guinea-Bissau	1F1EC 1F1FC	Flags	country-flag	fully-qualified
🇬🇾	flag: Guyana	1F1EC 1F1FE	Flags	country-flag	fully-qualified
🇭🇰	flag: Hong Kong SAR China	1F1ED 1F1F0	Flags	country-flag	fully-qualified
🇭🇲	flag: Heard & McDonald Islands	1F1ED 1F1F2	Flags	country-flag	fully-qualified
🇭🇳	flag: Honduras	1F1ED 1F1F3	Flags	country-flag	fully-qualified
🇭🇷	flag: Croatia	1F1ED 1F1F7	Flags	country-flag	fully-qualified
🇭🇹	flag: Haiti	1F1ED 1F1F9	Flags	country-flag	fully-qualified
🇭🇺	flag: Hungary	1F1ED 1F1FA	Flags	country-flag	fully-qualified
🇮🇨	flag: Canary Islands	1F1EE 1F1E8	Flags	country-flag	fully-qualified
🇮🇩	flag: Indonesia	1F1EE 1F1E9	Flags	country-flag	fully-qualified
🇮🇪	flag: Ireland	1F1EE 1F1EA	Flags	country-flag	fully-qualified
🇮🇱	flag: Israel	1F1EE 1F1F1	Flags	country-flag	fully-qualified
🇮🇲	flag: Isle of Man	1F1EE 1F1F2	Flags	country-flag	fully-qualified
🇮🇳	flag: India	1F1EE 1F1F3	Flags	country-flag	fully-qualified
🇮🇴	flag: British Indian Ocean Territory	1F1EE 1F1F4	Flags	country-flag	fully-qualified
🇮🇶	flag: Iraq	1F1EE 1F1F6	Flags	country-flag	fully-qualified
🇮🇷	flag: Iran	1F1EE 1F1F7	Flags	country-flag	fully-qualified
🇮🇸	flag: Iceland	1F1EE 1F1F8	Flags	country-flag	fully-qualified
🇮🇹	flag: Italy	1F1EE 1F1F9	Flags	country-flag	fully-qualified
🇯🇪	flag: Jersey	1F1EF 1F1EA	Flags	country-flag	fully-qualified
🇯🇲	flag: Jamaica	1F1EF 1F1F2	Flags	country-flag	fully-qualified
🇯🇴	flag: Jordan	1F1EF 1F1F4	Flags	country-flag	fully-qualified
🇯🇵	flag: Japan	1F1EF 1F1F5	Flags	country-flag	fully-qualified
🇰🇪	flag: Kenya	1F1F0 1F1EA	Flags	country-flag	fully-qualified
🇰🇬	flag: Kyrgyzstan	1F1F0 1F1EC	Flags	country-flag	fully-qualified
🇰🇭	flag: Cambodia	1F1F0 1F1ED	Flags	country-flag	fully-qualified
🇰🇮	flag: Kiribati	1F1F0 1F1EE	Flags	country-flag	fully-qualified
🇰🇲	flag: Comoros	1F1F0 1F1F2	Flags	country-flag	fully-qualified
🇰🇳	flag: St. Kitts & Nevis	1F1F0 1F1F3	Flags	country-flag	fully-qualified
🇰🇵	flag: North Korea	1F1F0 1F1F5	Flags	country-flag	fully-qualified
🇰🇷	flag: South Korea	1F1F0 1F1F7	Flags	country-flag	fully-qualified
🇰🇼	flag: Kuwait	1F1F0 1F1FC	Flags	country-flag	fully-qualified
🇰🇾	flag: Cayman Islands	1F1F0 1F1FE	Flags	country-flag	fully-qualified
🇰🇿	flag: Kazakhstan	1F1F0 1F1FF	Flags	country-flag	fully-qualified
🇱🇦	flag: Laos	1F1F1 1F1E6	Flags	country-flag	fully-qualified
🇱🇧	flag: Lebanon	1F1F1 1F1E7	Flags	country-flag	fully-qualified
🇱🇨	flag: St. Lucia	1F1F1 1F1E8	Flags	country-flag	fully-qualified
🇱🇮	flag: Liechtenstein	1F1F1 1F1EE	Flags	country-flag	fully-qualified
🇱🇰	flag: Sri Lanka	1F1F1 1F1F0	Flags	country-flag	fully-qualified
🇱🇷	flag: Liberia	1F1F1 1F1F7	Flags	country-flag	fully-qualified
🇱🇸	flag: Lesotho	1F1F1 1F1F8	Flags	country-flag	fully-qualified
🇱🇹	flag: Lithuania	1F1F1 1F1F9	Flags	country-flag	fully-qualified
🇱🇺	flag: Luxembourg	1F1F1 1F1FA	Flags	country-flag	fully-qualified
🇱🇻	flag: Latvia	1F1F1 1F1FB	Flags	country-flag	fully-qualified
🇱🇾	flag: Libya	1F1F1 1F1FE	Flags	country-flag	fully-qualified
🇲🇦	flag: Morocco	1F1F2 1F1E6	Flags	country-flag	fully-qualified
🇲🇨	flag: Monaco	1F1F2 1F1E8	Flags	country-flag	fully-qualified
🇲🇩	flag: Moldova	1F1F2 1F1E9	Flags	country-flag	fully-qualified
🇲🇪	flag: Montenegro	1F1F2 1F1EA	Flags	country-flag	fully-qualified
🇲🇫	flag: St. Martin	1F1F2 1F1EB	Flags	country-flag	fully-qualified
🇲🇬	flag: Madagascar	1F1F2 1F1EC	Flags	country-flag	fully-qualified
🇲🇭	flag: Marshall Islands	1F1F2 1F1ED	Flags	country-flag	fully-qualified
🇲🇰	flag: North Macedonia	1F1F2 1F1F0	Flags	country-flag	fully-qualified
🇲🇱	flag: Mali	1F1F2 1F1F1	Flags	country-flag	fully-qualified
🇲🇲	flag: Myanmar (Burma)	1F1F2 1F1F2	Flags	country-flag	fully-qualified
🇲🇳	flag: Mongolia	1F1F2 1F1F3	Flags	country-flag	fully-qualified
🇲🇴	flag: Macao SAR China	1F1F2 1F1F4	Flags	country-flag	fully-qualified
🇲🇵	flag: Northern Mariana Islands	1F1F2 1F1F5	Flags	country-flag	fully-qualified
🇲🇶	flag: Martinique	1F1F2 1F1F6	Flags	country-flag	fully-qualified
🇲🇷	flag: Mauritania	1F1F2 1F1F7	Flags	country-flag	fully-qualified
🇲🇸	flag: Montserrat	1F1F2 1F1F8	Flags	country-flag	fully-qualified
🇲🇹	flag: Malta	1F1F2 1F1F9	Flags	country-flag	fully-qualified
🇲🇺	flag: Mauritius	1F1F2 1F1FA	Flags	country-flag	fully-qualified
🇲🇻	flag: Maldives	1F1F2 1F1FB	Flags	country-flag	fully-qualified
🇲🇼	flag: Malawi	1F1F2 1F1FC	Flags	country-flag	fully-qualified
🇲🇽	flag: Mexico	1F1F2 1F1FD	Flags	country-flag	fully-qualified
🇲🇾	flag: Malaysia	1F1F2 1F1FE	Flags	country-flag	fully-qualified
🇲🇿	flag: Mozambique	1F1F2 1F1FF	Flags	country-flag	fully-qualified
🇳🇦	flag: Namibia	1F1F3 1F1E6	Flags	country-flag	fully-qualified
🇳🇨	flag: New Caledonia	1F1F3 1F1E8	Flags	country-flag	fully-qualified
🇳🇪	flag: Niger	1F1F3 1F1EA	Flags	country-flag	fully-qualified
🇳🇫	flag: Norfolk Island	1F1F3 1F1EB	Flags	country-flag	fully-qualified
🇳🇬	flag: Nigeria	1F1F3 1F1EC	Flags	country-flag	fully-qualified
🇳🇮	flag: Nicaragua	1F1F3 1F1EE	Flags	country-flag	fully-qualified
🇳🇱	flag: Netherlands	1F1F3 1F1F1	Flags	country-flag	fully-qualified
🇳🇴	flag: Norway	1F1F3 1F1F4	Flags	country-flag	fully-qualified
🇳🇵	flag: Nepal	1F1F3 1F1F5	Flags	country-flag	fully-qualified
🇳🇷	flag: Nauru	1F1F3 1F1F7	Flags	country-flag	fully-qualified
🇳🇺	flag: Niue	1F1F3 1F1FA	Flags	country-flag	fully-qualified
🇳🇿	flag: New Zealand	1F1F3 1F1FF	Flags	country-flag	fully-qualified
🇴🇲	flag: Oman	1F1F4 1F1F2	Flags	country-flag	fully-qualified
🇵🇦	flag: Panama	1F1F5 1F1E6	Flags	country-flag	fully-qualified
🇵🇪	flag: Peru	1F1F5 1F1EA	Flags	country-flag	fully-qualified
        """.trimIndent(),

        """
🇵🇫	flag: French Polynesia	1F1F5 1F1EB	Flags	country-flag	fully-qualified
🇵🇬	flag: Papua New Guinea	1F1F5 1F1EC	Flags	country-flag	fully-qualified
🇵🇭	flag: Philippines	1F1F5 1F1ED	Flags	country-flag	fully-qualified
🇵🇰	flag: Pakistan	1F1F5 1F1F0	Flags	country-flag	fully-qualified
🇵🇱	flag: Poland	1F1F5 1F1F1	Flags	country-flag	fully-qualified
🇵🇲	flag: St. Pierre & Miquelon	1F1F5 1F1F2	Flags	country-flag	fully-qualified
🇵🇳	flag: Pitcairn Islands	1F1F5 1F1F3	Flags	country-flag	fully-qualified
🇵🇷	flag: Puerto Rico	1F1F5 1F1F7	Flags	country-flag	fully-qualified
🇵🇸	flag: Palestinian Territories	1F1F5 1F1F8	Flags	country-flag	fully-qualified
🇵🇹	flag: Portugal	1F1F5 1F1F9	Flags	country-flag	fully-qualified
🇵🇼	flag: Palau	1F1F5 1F1FC	Flags	country-flag	fully-qualified
🇵🇾	flag: Paraguay	1F1F5 1F1FE	Flags	country-flag	fully-qualified
🇶🇦	flag: Qatar	1F1F6 1F1E6	Flags	country-flag	fully-qualified
🇷🇪	flag: Réunion	1F1F7 1F1EA	Flags	country-flag	fully-qualified
🇷🇴	flag: Romania	1F1F7 1F1F4	Flags	country-flag	fully-qualified
🇷🇸	flag: Serbia	1F1F7 1F1F8	Flags	country-flag	fully-qualified
🇷🇺	flag: Russia	1F1F7 1F1FA	Flags	country-flag	fully-qualified
🇷🇼	flag: Rwanda	1F1F7 1F1FC	Flags	country-flag	fully-qualified
🇸🇦	flag: Saudi Arabia	1F1F8 1F1E6	Flags	country-flag	fully-qualified
🇸🇧	flag: Solomon Islands	1F1F8 1F1E7	Flags	country-flag	fully-qualified
🇸🇨	flag: Seychelles	1F1F8 1F1E8	Flags	country-flag	fully-qualified
🇸🇩	flag: Sudan	1F1F8 1F1E9	Flags	country-flag	fully-qualified
🇸🇪	flag: Sweden	1F1F8 1F1EA	Flags	country-flag	fully-qualified
🇸🇬	flag: Singapore	1F1F8 1F1EC	Flags	country-flag	fully-qualified
🇸🇭	flag: St. Helena	1F1F8 1F1ED	Flags	country-flag	fully-qualified
🇸🇮	flag: Slovenia	1F1F8 1F1EE	Flags	country-flag	fully-qualified
🇸🇯	flag: Svalbard & Jan Mayen	1F1F8 1F1EF	Flags	country-flag	fully-qualified
🇸🇰	flag: Slovakia	1F1F8 1F1F0	Flags	country-flag	fully-qualified
🇸🇱	flag: Sierra Leone	1F1F8 1F1F1	Flags	country-flag	fully-qualified
🇸🇲	flag: San Marino	1F1F8 1F1F2	Flags	country-flag	fully-qualified
🇸🇳	flag: Senegal	1F1F8 1F1F3	Flags	country-flag	fully-qualified
🇸🇴	flag: Somalia	1F1F8 1F1F4	Flags	country-flag	fully-qualified
🇸🇷	flag: Suriname	1F1F8 1F1F7	Flags	country-flag	fully-qualified
🇸🇸	flag: South Sudan	1F1F8 1F1F8	Flags	country-flag	fully-qualified
🇸🇹	flag: São Tomé & Príncipe	1F1F8 1F1F9	Flags	country-flag	fully-qualified
🇸🇻	flag: El Salvador	1F1F8 1F1FB	Flags	country-flag	fully-qualified
🇸🇽	flag: Sint Maarten	1F1F8 1F1FD	Flags	country-flag	fully-qualified
🇸🇾	flag: Syria	1F1F8 1F1FE	Flags	country-flag	fully-qualified
🇸🇿	flag: Eswatini	1F1F8 1F1FF	Flags	country-flag	fully-qualified
🇹🇦	flag: Tristan da Cunha	1F1F9 1F1E6	Flags	country-flag	fully-qualified
🇹🇨	flag: Turks & Caicos Islands	1F1F9 1F1E8	Flags	country-flag	fully-qualified
🇹🇩	flag: Chad	1F1F9 1F1E9	Flags	country-flag	fully-qualified
🇹🇫	flag: French Southern Territories	1F1F9 1F1EB	Flags	country-flag	fully-qualified
🇹🇬	flag: Togo	1F1F9 1F1EC	Flags	country-flag	fully-qualified
🇹🇭	flag: Thailand	1F1F9 1F1ED	Flags	country-flag	fully-qualified
🇹🇯	flag: Tajikistan	1F1F9 1F1EF	Flags	country-flag	fully-qualified
🇹🇰	flag: Tokelau	1F1F9 1F1F0	Flags	country-flag	fully-qualified
🇹🇱	flag: Timor-Leste	1F1F9 1F1F1	Flags	country-flag	fully-qualified
🇹🇲	flag: Turkmenistan	1F1F9 1F1F2	Flags	country-flag	fully-qualified
🇹🇳	flag: Tunisia	1F1F9 1F1F3	Flags	country-flag	fully-qualified
🇹🇴	flag: Tonga	1F1F9 1F1F4	Flags	country-flag	fully-qualified
🇹🇷	flag: Türkiye	1F1F9 1F1F7	Flags	country-flag	fully-qualified
🇹🇹	flag: Trinidad & Tobago	1F1F9 1F1F9	Flags	country-flag	fully-qualified
🇹🇻	flag: Tuvalu	1F1F9 1F1FB	Flags	country-flag	fully-qualified
🇹🇼	flag: Taiwan	1F1F9 1F1FC	Flags	country-flag	fully-qualified
🇹🇿	flag: Tanzania	1F1F9 1F1FF	Flags	country-flag	fully-qualified
🇺🇦	flag: Ukraine	1F1FA 1F1E6	Flags	country-flag	fully-qualified
🇺🇬	flag: Uganda	1F1FA 1F1EC	Flags	country-flag	fully-qualified
🇺🇲	flag: U.S. Outlying Islands	1F1FA 1F1F2	Flags	country-flag	fully-qualified
🇺🇳	flag: United Nations	1F1FA 1F1F3	Flags	country-flag	fully-qualified
🇺🇸	flag: United States	1F1FA 1F1F8	Flags	country-flag	fully-qualified
🇺🇾	flag: Uruguay	1F1FA 1F1FE	Flags	country-flag	fully-qualified
🇺🇿	flag: Uzbekistan	1F1FA 1F1FF	Flags	country-flag	fully-qualified
🇻🇦	flag: Vatican City	1F1FB 1F1E6	Flags	country-flag	fully-qualified
🇻🇨	flag: St. Vincent & Grenadines	1F1FB 1F1E8	Flags	country-flag	fully-qualified
🇻🇪	flag: Venezuela	1F1FB 1F1EA	Flags	country-flag	fully-qualified
🇻🇬	flag: British Virgin Islands	1F1FB 1F1EC	Flags	country-flag	fully-qualified
🇻🇮	flag: U.S. Virgin Islands	1F1FB 1F1EE	Flags	country-flag	fully-qualified
🇻🇳	flag: Vietnam	1F1FB 1F1F3	Flags	country-flag	fully-qualified
🇻🇺	flag: Vanuatu	1F1FB 1F1FA	Flags	country-flag	fully-qualified
🇼🇫	flag: Wallis & Futuna	1F1FC 1F1EB	Flags	country-flag	fully-qualified
🇼🇸	flag: Samoa	1F1FC 1F1F8	Flags	country-flag	fully-qualified
🇽🇰	flag: Kosovo	1F1FD 1F1F0	Flags	country-flag	fully-qualified
🇾🇪	flag: Yemen	1F1FE 1F1EA	Flags	country-flag	fully-qualified
🇾🇹	flag: Mayotte	1F1FE 1F1F9	Flags	country-flag	fully-qualified
🇿🇦	flag: South Africa	1F1FF 1F1E6	Flags	country-flag	fully-qualified
🇿🇲	flag: Zambia	1F1FF 1F1F2	Flags	country-flag	fully-qualified
🇿🇼	flag: Zimbabwe	1F1FF 1F1FC	Flags	country-flag	fully-qualified
🏴󠁧󠁢󠁥󠁮󠁧󠁿	flag: England	1F3F4 E0067 E0062 E0065 E006E E0067 E007F	Flags	subdivision-flag	fully-qualified
🏴󠁧󠁢󠁳󠁣󠁴󠁿	flag: Scotland	1F3F4 E0067 E0062 E0073 E0063 E0074 E007F	Flags	subdivision-flag	fully-qualified
🏴󠁧󠁢󠁷󠁬󠁳󠁿	flag: Wales	1F3F4 E0067 E0062 E0077 E006C E0073 E007F	Flags	subdivision-flag	fully-qualified
        """.trimIndent()
    )
}
