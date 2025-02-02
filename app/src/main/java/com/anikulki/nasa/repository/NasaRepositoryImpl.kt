package com.anikulki.nasa.repository

import com.anikulki.nasa.model.NASAImagesItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Exception

class NasaRepositoryImpl: NasaRepository{

    override fun getNasaImagesList(): List<NASAImagesItem> {
        val json =  "[\n" +
                "  {\n" +
                "    \"copyright\": \"ESA/HubbleNASA\",\n" +
                "    \"date\": \"2019-12-01\",\n" +
                "    \"explanation\": \"Why does this galaxy have a ring of bright blue stars?  Beautiful island universe Messier 94 lies a mere 15 million light-years distant in the northern constellation of the Hunting Dogs (Canes Venatici). A popular target for Earth-based astronomers, the face-on spiral galaxy is about 30,000 light-years across, with spiral arms sweeping through the outskirts of its broad disk. But this Hubble Space Telescope field of view spans about 7,000 light-years across M94's central region. The featured close-up highlights the galaxy's compact, bright nucleus, prominent inner dust lanes, and the remarkable bluish ring of young massive stars. The ring stars are all likely less than 10 million years old, indicating that M94 is a starburst galaxy that is experiencing an epoch of rapid star formation from inspiraling gas. The circular ripple of blue stars is likely a wave propagating outward, having been triggered by the gravity and rotation of a oval matter distributions. Because M94 is relatively nearby, astronomers can better explore details of its starburst ring.    Astrophysicists: Browse 2,000+ codes in the Astrophysics Source Code Library\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/M94_Hubble_1002.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"Starburst Galaxy M94 from Hubble\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/M94_Hubble_960.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"copyright\": \"Steve Mazlin\",\n" +
                "    \"date\": \"2019-12-03\",\n" +
                "    \"explanation\": \"Is this what will become of our Sun? Quite possibly.  The first hint of our Sun's future was discovered inadvertently in 1764. At that time, Charles Messier was compiling a list of diffuse objects not to be confused with comets. The 27th object on Messier's list, now known as M27 or the Dumbbell Nebula, is a planetary nebula, the type of nebula our Sun will produce when nuclear fusion stops in its core. M27 is one of the brightest planetary nebulae on the sky, and can be seen toward the constellation of the Fox (Vulpecula) with binoculars. It takes light about 1000 years to reach us from M27, featured here in colors emitted by hydrogen and oxygen. Understanding the physics and significance of M27 was well beyond 18th century science. Even today, many things remain mysterious about bipolar planetary nebula like M27, including the physical mechanism that expels a low-mass star's gaseous outer-envelope, leaving an X-ray hot white dwarf.   APOD across world languages: Arabic, Catalan, Chinese (Beijing), Chinese (Taiwan), Croatian, Czech, Dutch, Farsi, French, French, German, Hebrew, Indonesian, Japanese, Korean, Montenegrin, Polish, Russian, Serbian, Slovenian,  Spanish and Ukrainian\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/M27_Mazlin_2000.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"M27: The Dumbbell Nebula\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/M27_Mazlin_960.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"copyright\": \"Ivan Pedretti\",\n" +
                "    \"date\": \"2019-12-04\",\n" +
                "    \"explanation\": \"It may appear, at first, like the Galaxy is producing the lightning, but really it's the Earth. The featured nighttime landscape was taken from a southern tip of the Italian Island of Sardinia in early June. The foreground rocks and shrubs are near the famous Capo Spartivento Lighthouse, and the camera is pointed south toward Algeria in Africa.  In the distance, across the Mediterranean Sea, a thunderstorm is threatening, with several electric lightning strokes caught together during this 25-second wide-angle exposure.  Much farther in the distance, strewn about the sky, are hundreds of stars in the neighborhood of our Sun in the Milky Way Galaxy. Farthest away, and slanting down from the upper left, are billions of stars that together compose the central band of our Milky Way.   Free Lecture: APOD editor to speak in NYC on January 3\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/ElectricMilkyWay_Pedretti_1920.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"Electric Night\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/ElectricMilkyWay_Pedretti_1080.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"copyright\": \"Zhuokai Liu\",\n" +
                "    \"date\": \"2019-12-05\",\n" +
                "    \"explanation\": \"Beautiful spiral galaxy NGC 6744 is nearly 175,000 light-years across, larger than our own Milky Way. It lies some 30 million light-years distant in the southern constellation Pavo and appears as only a faint, extended object in small telescopes. We see the disk of the nearby island universe tilted towards our line of sight in this remarkably detailed galaxy portrait, a telescopic view that spans an area about the angular size of a full moon. In it, the giant galaxy's elongated yellowish core is dominated by the light from old, cool stars. Beyond the core, grand spiral arms are filled with young blue star clusters and speckled with pinkish star forming regions. An extended arm sweeps past a smaller satellite galaxy (NGC 6744A) at the lower right. NGC 6744's galactic companion is reminiscent of the Milky Way's satellite galaxy the Large Magellanic Cloud.\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/NGC6744_FinalLiuYuhang.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"Spiral Galaxy NGC 6744\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/NGC6744_FinalLiuYuhang1024.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"copyright\": \"Amir H. Abolfath\",\n" +
                "    \"date\": \"2019-12-06\",\n" +
                "    \"explanation\": \"This cosmic vista stretches almost 20 degrees from top to bottom, across the dusty constellation Taurus. It begins at the Pleiades and ends at the Hyades, two star clusters recognized since antiquity in Earth's night sky. At top, the compact Pleiades star cluster is about 400 light-years away. The lovely grouping of young cluster stars shine through dusty clouds that scatter blue starlight. At bottom, the V-shaped Hyades cluster looks more spread out in comparison and lies much closer, 150 light-years away. The Hyades cluster stars seem anchored by bright Aldebaran, a red giant star with a yellowish appearance. But Aldebaran actually lies only 65 light-years distant and just by chance along the line of sight to the Hyades cluster. Faint and darkly obscuring dust clouds found near the edge of the Taurus Molecular Cloud are also evident throughout the celestial scene. The wide field of view includes the dark nebula Barnard 22 at left with youthful star T Tauri and Hind's variable nebula just above Aldebaran in the frame.\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/TaurusAbolfath.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"Pleiades to Hyades\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/TaurusAbolfath1024.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"copyright\": \"Anton Komlev\",\n" +
                "    \"date\": \"2019-12-07\",\n" +
                "    \"explanation\": \"In time stars trace lines through the night sky on a rotating planet. Taken over two hours or more, these digitally added consecutive exposures were made with a camera and wide angle lens fixed to a tripod near Orel farm, Primorsky Krai, Russia, planet Earth. The stars trail in concentric arcs around the planet's south celestial pole below the scene's horizon, and north celestial pole off the frame at the upper right. Combined, the many short exposures also bring out the pretty star colours. Bluish trails are from stars hotter than Earth's Sun, while yellowish trails are from cooler stars. A long time ago this tree blossomed, but now reveals the passage of time in the wrinkled and weathered lines of its remains.\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/LinesOfTimeKomlev.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"Lines of Time\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/LinesOfTimeKomlev1100.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"copyright\": \"Yuri BeletskyCarnegieLas Campanas ObservatoryTWAN\",\n" +
                "    \"date\": \"2019-12-08\",\n" +
                "    \"explanation\": \"Are meteors streaming out from a point in the sky? Yes, in a way. When the Earth crosses a stream of Sun-orbiting meteors, these meteors appear to come from the direction of the stream -- with the directional point called the radiant.\\ufffd An example occurs every mid-December for the Geminids meteor shower, as apparent in the featured image.\\ufffd Recorded near the shower's peak in 2013, the featured  skyscape captures Gemini's shooting stars in a four-hour composite from the dark skies of the Las Campanas Observatory in Chile. In the foreground the 2.5-meter du Pont Telescope is visible as well as the 1-meter SWOPE telescope. The skies beyond the meteors are highlighted by Jupiter, seen as the bright spot near the image center, the central band of our Milky Way Galaxy, seen vertically on the image left, and the pinkish Orion Nebula on the far left.  Dust swept up from the orbit of active asteroid 3200 Phaethon, Gemini's meteors enter the atmosphere traveling at about 22 kilometers per second. The 2019 Geminid meteor shower peaks again this coming weekend.\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/geminids2013_beletsky_1081.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"Geminid Meteors over Chile\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/geminids2013_beletsky_960.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"copyright\": \"Egon Filter\",\n" +
                "    \"date\": \"2019-12-10\",\n" +
                "    \"explanation\": \"What are those streaks over the horizon? New Starlink satellites reflecting sunlight. SpaceX launched 60 Starlink communication satellites in May and 60 more in November. These satellites and thousands more are planned by communications companies in the next few years that may make streaks like these relatively common. Concern has been voiced by many in the astronomical community about how reflections from these satellites may affect future observations into space.  In the pictured composite of 33 exposures, parallel streaks from Starlink satellites are visible over southern Brazil. Sunflowers dot the foreground, while a bright meteor was caught by chance on the upper right. Satellite reflections are not new -- the constellation of 66 first-generation Iridium satellites launched starting 20 years ago produced some flares so bright that they could be seen during the day. Most of these old Iridium satellites, however, have been de-orbited over the past few years.    Infinite Loop: Create an APOD Station in your classroom or Science Center.\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/StarlinkTrails_Filter_2048.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"Starlink Satellite Trails over Brazil\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/StarlinkTrails_Filter_1080.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"date\": \"2019-12-11\",\n" +
                "    \"explanation\": \"What has this supernova left behind?  As little as 2,000 years ago, light from a massive stellar explosion in the Large Magellanic Cloud (LMC) first reached planet Earth. The LMC is a close galactic neighbor of our Milky Way Galaxy and the rampaging explosion front is now seen moving out - destroying or displacing ambient gas clouds while leaving behind relatively dense knots of gas and dust.  What remains is one of the largest supernova remnants in the LMC: N63A.  Many of the surviving dense knots have been themselves compressed and may further contract to form new stars.  Some of the resulting stars may then explode in a supernova, continuing the cycle.  Featured here is a combined image of N63A in the X-ray from the Chandra Space Telescope and in visible light by Hubble.  The prominent knot of gas and dust on the upper right -- informally dubbed the Firefox -- is very bright in visible light, while the larger supernova remnant shines most brightly in X-rays.  N63A spans over 25 light years and lies about 150,000 light years away toward the southern constellation of Dorado.\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/N63A_HubbleChandraSchmidt_1019.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"N63A: Supernova Remnant in Visible and X-ray\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/N63A_HubbleChandraSchmidt_960.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"copyright\": \"Leonardo Julio\",\n" +
                "    \"date\": \"2019-12-12\",\n" +
                "    \"explanation\": \"Bright stars, clouds of dust and glowing nebulae decorate this cosmic scene, a skyscape just north of Orion's belt. Close to the plane of our Milky Way galaxy, the wide field view spans about 5.5 degrees. Striking bluish M78, a reflection nebula, is on the right. M78's tint is due to dust preferentially reflecting the blue light of hot, young stars. In colorful contrast, the red sash of glowing hydrogen gas sweeping through the center is part of the region's faint but extensive emission nebula known as Barnard's Loop. At lower left, a dark dust cloud forms a prominent silhouette cataloged as LDN 1622. While M78 and the complex Barnard's Loop are some 1,500 light-years away, LDN 1622 is likely to be much closer, only about 500 light-years distant from our fair planet Earth.\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/m78ldn1622barnardsloopJulio.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"Decorating the Sky\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/m78ldn1622barnardsloopJulio1100.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"copyright\": \"Juan Carlos Casado\",\n" +
                "    \"date\": \"2019-12-13\",\n" +
                "    \"explanation\": \"The dependable annual Geminid meteor shower will be near its peak tonight (December 13/14) and before tomorrow's dawn. As Earth crosses through the dusty trail of active asteroid 3200 Phaethon the meteors will flash through the sky from the shower's radiant in Gemini. Gemini will be pretty easy for skygazers to find too as it won't be far from a nearly full waning gibbous Moon. You don't have look at the shower's radiant to see meteors though. The almost full moonlight won't hide the brightest of the Geminids from view either, but it will substantially reduce the rate of visible meteors for those who are counting. In fact, the 2019 Geminids should look a lot like the 2016 meteor shower. This composite image from the 2016 Geminids aligns individual short exposures to capture many of the brighter Geminid meteors, inspite of a Full Moon shining near the constellation of the Twins. Along the horizon are the Teide Observatory's Solar Laboratory (right) and the Teide volcano on the Canary Island of Tenerife.\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/gem16otjcc2500.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"Full Moon Geminids\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/gem16otjcc1100.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"date\": \"2019-12-14\",\n" +
                "    \"explanation\": \"From somewhere else in the Milky Way galaxy, Comet 2I/Borisov is just visiting the Solar System. Discovered by Crimean amateur astronomer Gennady Borisov on August 30, 2019, the first known interstellar comet is captured in these two recent Hubble Space Telescope images. On the left, a distant background galaxy near the line-of-sight to Borisov is blurred as Hubble tracked the speeding comet and dust tail about 327 million kilometers from Earth. At right, 2I/Borisov appears shortly after perihelion, its closest approach to Sun. Borisov's closest approach to our fair planet, a distance of about 290 million kilometers, will come on December 28. Even though Hubble's sharp images don't resolve the comet's nucleus, they do lead to estimates of less than 1 kilometer for its diameter.\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/borisovStsci1826.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"Interstellar Comet 2I/Borisov\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/borisovStsci1315.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"copyright\": \"Jorn Olsen Photography\",\n" +
                "    \"date\": \"2019-12-15\",\n" +
                "    \"explanation\": \"When do cloud bottoms appear like bubbles? Normally, cloud bottoms are flat. This is because moist warm air that rises and cools will condense into water droplets at a specific temperature, which usually corresponds to a very specific height.  As water droplets grow, an opaque cloud forms.  Under some conditions, however, cloud pockets can develop that contain large droplets of water or ice that fall into clear air as they evaporate.  Such pockets may occur in turbulent air near a thunderstorm.  Resulting mammatus clouds can appear especially dramatic if sunlit from the side.  The mammatus clouds pictured here were photographed over Hastings, Nebraska during 2004 June.\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/mammatus_olson_1024.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"Mammatus Clouds over Nebraska\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/mammatus_olson_960.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"date\": \"2019-12-16\",\n" +
                "    \"explanation\": \"Can magnetic fields help tell us how spiral galaxies form and evolve?  To find out, the HAWC+ instrument on NASA's airborne (747) SOFIA observatory observed nearby spiral galaxy M77. HAWC+ maps magnetism by observing polarized infrared light emitted by elongated dust grains rotating in alignment with the local magnetic field.  The HAWC+ image shows that magnetic fields do appear to trace the spiral arms in the inner regions of M77, arms that likely highlight density waves in the inflowing gas, dust and stars caused by the gravity of the galaxy's oval shape. The featured picture superposes the HAWC+ image over diffuse X-ray emission mapped by NASA's NuSTAR satellite and visible light images taken by Hubble and the SDSS. M77 is located about 47 million light years away toward the constellation of the Sea Monster (Cetus).\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/M77Bfield_NASA_1200.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"The Magnetic Fields of Spiral Galaxy M77\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/M77Bfield_NASA_960.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"copyright\": \"Mark HansonMartin PughSSROPROMPTCTIONSF\",\n" +
                "    \"date\": \"2019-12-17\",\n" +
                "    \"explanation\": \"Sculpted by stellar winds and radiation, a magnificent interstellar dust cloud by chance has assumed this recognizable shape.  Fittingly named the Horsehead Nebula, it is some 1,500 light-years distant, embedded in the vast Orion cloud complex. About five light-years \\\"tall\\\", the dark cloud is cataloged as Barnard 33 and is visible only because its obscuring dust is silhouetted against the glowing red emission nebula IC 434.  Stars are forming within the dark cloud. Contrasting blue reflection nebula NGC 2023, surrounding a hot, young star, is at the lower left of the full image.  The featured gorgeous color image combines both narrowband and broadband images recorded using several different telescopes.\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/Horsehead_Hanson_2604.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"The Horsehead Nebula\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/Horsehead_Hanson_960.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"date\": \"2019-12-18\",\n" +
                "    \"explanation\": \"What do neutron stars look like? Previously these city-sized stars were too small and too far away to resolve. Recently, however, the first maps of the locations and sizes of hotspots on a neutron star's surface have been made by carefully modeling how the rapid spin makes the star's X-ray brightness rise and fall.  Based on a leading model, an illustrative map of pulsar J0030+0451's hotspots is pictured, with the rest of the star's surface filled in with a false patchy blue.  J0030 spins once every 0.0049 seconds and is located about 1000 light years away. The map was computed from data taken by NASA's Neutron star Interior Composition ExploreR (NICER) X-ray telescope attached to the International Space Station.  The computed locations of these hotspots is surprising and not well understood. Because the gravitational lensing effect of neutron stars is so strong, J0300 displays more than half of its surface toward the Earth.  Studying the appearance of pulsars like J0030 allows accurate estimates of the neutron star's mass, radius, and the internal physics that keeps the star from imploding into a black hole.\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/J0030_NICER_1024.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"A Hotspot Map of Neutron Star J0030's Surface\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/J0030_NICER_1024.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"date\": \"2019-12-19\",\n" +
                "    \"explanation\": \"Awkward and angular looking, Apollo 17's lunar module Challenger was designed for flight in the near vacuum of space.  Digitally enhanced and reprocessed, this picture taken from Apollo 17's command module America shows Challenger's ascent stage in lunar orbit. Small reaction control thrusters are at the sides of the moonship with the bell of the ascent rocket engine underneath. The hatch allowing access to the lunar surface is seen at the front, with a round radar antenna at the top. Mission commander Gene Cernan is clearly visible through the triangular window. This spaceship performed gracefully, landing on the Moon and returning the Apollo astronauts to the orbiting command module in December of 1972. So where is Challenger now? Its descent stage remains at the Apollo 17 landing site in the Taurus-Littrow valley. The ascent stage pictured was intentionally crashed nearby after being jettisoned from the command module prior to the astronauts' return to planet Earth. Apollo 17's mission came to an end 47 years ago today. It was the sixth and last time astronauts landed on the Moon.\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/AS17-149-22859-2v2SmlWmk.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"Apollo 17's Moonship\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/AS17-149-22859-2v2SmlWmk1024.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"date\": \"2019-12-20\",\n" +
                "    \"explanation\": \"Shadows grow long near sunset in this wide panoramic view from the Curiosity rover on Mars. Made with Curiosity's navcam, the scene covers about 200 degrees from north through east to south (left to right), stitched together from frames taken by the Mars rover on sol 2616. That's just Earth date December 16. Curiosity is perched on top of a plateau on Western Butte. The distant northern rim of Gale crater is visible along the left. Near center is Central Butte, already visited by Curiosity. On the right, the shadow of the rover seems to stretch toward the base of Aeolis Mons (Mount Sharp), a future destination. The monochrome navcam frames have been colorized to approximate the colors of the late martian afternoon.\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/N2616c.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"Late Afternoon on Mars\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/N2616c_600h.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"copyright\": \"Tomas Slovinsky\",\n" +
                "    \"date\": \"2019-12-24\",\n" +
                "    \"explanation\": \"What stars shine in Earth's northern hemisphere during winter? The featured image highlights a number of bright stars visible earlier this month. The image is a 360-degree horizontal-composite panorama of 66 vertical frames taken consecutively with the same camera and from the same location at about 2:30 am. Famous stars visible in the picture include Castor & Pollux toward the southeast on the left, Sirius just over the horizon toward the south, Capella just over the arch of the Milky Way Galaxy toward the west, and Polaris toward the north on the right.  Captured by coincidence is a meteor on the far left.  In the foreground is the Museum of the Orava Village in Zuberec, Slovakia. This village recreates rural life in the region hundreds of years ago, while the image captures a timeless sky surely familar to village residents, a sky also shared with northern residents around the world.    Free Download: 2020 APOD Calendar\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/WinterStars_Slovinsky_2048.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"A Northern Winter Sky Panorama\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/WinterStars_Slovinsky_1080.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"copyright\": \"Colleen Pinski\",\n" +
                "    \"date\": \"2019-12-25\",\n" +
                "    \"explanation\": \"What is this person doing?  In 2012 an annular eclipse of the Sun was visible over a narrow path that crossed the northern Pacific Ocean and several western US states.  In an annular solar eclipse, the Moon is too far from the Earth to block out the entire Sun, leaving the Sun peeking out over the Moon's disk in a ring of fire.  To capture this unusual solar event, an industrious photographer drove from Arizona to New Mexico to find just the right vista. After setting up and just as the eclipsed Sun was setting over a ridge about 0.5 kilometers away, a person unknowingly walked right into the shot. Although grateful for the unexpected human element, the photographer never learned the identity of the silhouetted interloper. It appears likely, though, that the person is holding a circular device that would enable them to get their own view of the eclipse.  The shot was taken at sunset on 2012 May 20 at 7:36 pm local time from a park near Albuquerque, New Mexico, USA. Tomorrow another annular solar eclipse will become visible, this time along a thin path starting in Saudi Arabia and going through southern India, Singapore, and Guam.   However, almost all of Asia with a clear sky will be able to see, tomorrow, at the least, a partial solar eclipse.    Free Download: 2020 APOD Calendar\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/AnnularEclipse_Pinski_1522.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"An Annular Solar Eclipse over New Mexico\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/AnnularEclipse_Pinski_960.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"copyright\": \"Petr\\nHor\\u00e1lek\",\n" +
                "    \"date\": \"2019-12-26\",\n" +
                "    \"explanation\": \"December's New Moon brought a solar eclipse to some for the holiday season. It also gave beautiful dark night skies to skygazers around the globe, like this moonless northern winter night. In the scene, bright stars of the Winter Hexagon along the Milky Way are rising. Cosy mountain cabins in the snowy foreground are near the village of Oravska Lesna, Slovakia. The shining celestial beacons marking the well-known asterism are Aldebaran, Capella, Pollux (and Castor), Procyon, Rigel, and Sirius. This winter nightscape also reveals faint nebulae in Orion, and the lovely Pleiades star cluster. Slide your cursor over the image to trace the winter hexagon, or just follow this link.\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/Orava_Duskova_WinterHexagon_0.png\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"The Northern Winter Hexagon\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/Orava_Duskova_WinterHexagon_0.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"copyright\": \"Majid Ghohroodi\",\n" +
                "    \"date\": \"2019-12-27\",\n" +
                "    \"explanation\": \"What's happened to the Sun?  Yesterday, if you were in the right place at the right time, you could see the Sun rise partially eclipsed by the Moon. The unusual sight was captured in dramatic fashion in the featured image not only directly, in a sequence of six images, but also in reflection from Soltan Salt Lake in Iran. The almost-white Sun appears dimmer and redder near the horizon primarily because Earth's atmosphere preferentially scatters away more blue light.  Yesterday's partial solar eclipse appeared in the sky over much of Asia and Australia, but those with a clear enough sky in a thin band across the Earth's surface were treated to a more complete annular solar eclipse -- where the Moon appears completely surrounded by the Sun in what is known as a ring of fire. The next annular solar eclipse will occur in 2020 June.   Notable Images Submitted to APOD: The Partial Solar Eclipse of 2019 December\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/PartialSolar_Ghohroodi_1312.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"A Partial Solar Eclipse Sequence Reflected\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/PartialSolar_Ghohroodi_960.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"copyright\": \"Elias Chasiotis\",\n" +
                "    \"date\": \"2019-12-28\",\n" +
                "    \"explanation\": \"Yes, but have you ever seen a sunrise like this?  Here, after initial cloudiness, the Sun appeared to rise in two pieces and during partial eclipse, causing the photographer to describe it as the most stunning sunrise of his life.  The dark circle near the top of the atmospherically-reddened Sun is the Moon -- but so is the dark peak just below it.  This is because along the way, the Earth's atmosphere had an inversion layer of unusually warm air which acted like a gigantic lens and created a second image.  For a normal sunrise or sunset, this rare phenomenon of atmospheric optics is known as the Etruscan vase effect. The featured picture was captured two mornings ago from Al Wakrah, Qatar.  Some observers in a narrow band of Earth to the east were able to see a full annular solar eclipse -- where the Moon appears completely surrounded by the background Sun in a ring of fire.  The next solar eclipse, also an annular eclipse, will occur in 2020 June.    Notable Images Submitted to APOD: The Partial Solar Eclipse of 2019 December\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/DistortedSunrise_Chasiotis_2442.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"A Distorted Sunrise Eclipse\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/DistortedSunrise_Chasiotis_1080.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"date\": \"2019-12-29\",\n" +
                "    \"explanation\": \"If this is Saturn, where are the rings?  When Saturn's \\\"appendages\\\" disappeared in 1612, Galileo did not understand why.   Later that century, it became understood that Saturn's unusual protrusions were rings and that when the Earth crosses the ring plane, the edge-on rings will appear to disappear.  This is because Saturn's rings are confined to a plane many times thinner, in proportion, than a razor blade.  In modern times, the robot Cassini spacecraft orbiting Saturn frequently crossed Saturn's ring plane during its mission to Saturn, from 2004 to 2017.  A series of plane crossing images from 2005 February was dug out of the vast online Cassini raw image archive by interested Spanish amateur Fernando Garcia Navarro.  Pictured here, digitally cropped and set in representative colors, is the striking result.  Saturn's thin ring plane appears in blue, bands and clouds in Saturn's upper atmosphere appear in gold. Details of Saturn's rings can be seen in the high dark shadows across the top of this image, taken back in 2005. The moons Dione and Enceladus appear as bumps in the rings.    Free Presentation: APOD Editor to show best astronomy images of 2019 -- and the decade -- in NYC on January 3\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/saturnplane_cassini_1004.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"Cassini Spacecraft Crosses Saturn's Ring Plane\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/saturnplane_cassini_1004.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"copyright\": \"Stanislav Volskiy\",\n" +
                "    \"date\": \"2019-12-30\",\n" +
                "    \"explanation\": \"The beautiful Trifid Nebula, also known as Messier 20, is easy to find with a small telescope in the nebula rich constellation Sagittarius. About 5,000 light-years away, the colorful study in cosmic contrasts shares this well-composed, nearly 1 degree wide field with open star cluster Messier 21 (top left). Trisected by dust lanes the Trifid itself is about 40 light-years across and a mere 300,000 years old. That makes it one of the youngest star forming regions in our sky, with newborn and embryonic stars embedded in its natal dust and gas clouds. Estimates of the distance to open star cluster M21 are similar to M20's, but though they share this gorgeous telescopic skyscape there is no apparent connection between the two. In fact, M21's stars are much older, about 8 million years old.\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/M20_volskiy.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"Messier 20 and 21\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/M20_volskiy1024.jpg\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"copyright\": \"Rui Liao\",\n" +
                "    \"date\": \"2019-12-31\",\n" +
                "    \"explanation\": \"The small, northern constellation Triangulum harbors this magnificent face-on spiral galaxy, M33. Its popular names include the Pinwheel Galaxy or just the Triangulum Galaxy. M33 is over 50,000 light-years in diameter, third largest in the Local Group of galaxies after the Andromeda Galaxy (M31), and our own Milky Way. About 3 million light-years from the Milky Way, M33 is itself thought to be a satellite of the Andromeda Galaxy and astronomers in these two galaxies would likely have spectacular views of each other's grand spiral star systems. As for the view from planet Earth, this sharp image shows off M33's blue star clusters and pinkish star forming regions along the galaxy's loosely wound spiral arms. In fact, the cavernous NGC 604 is the brightest star forming region, seen here at about the 7 o'clock position from the galaxy center. Like M31, M33's population of well-measured variable stars have helped make this nearby spiral a cosmic yardstick for establishing the distance scale of the Universe.\",\n" +
                "    \"hdurl\": \"https://apod.nasa.gov/apod/image/1912/M33-HaLRGB-RayLiao.jpg\",\n" +
                "    \"media_type\": \"image\",\n" +
                "    \"service_version\": \"v1\",\n" +
                "    \"title\": \"M33: The Triangulum Galaxy\",\n" +
                "    \"url\": \"https://apod.nasa.gov/apod/image/1912/M33-HaLRGB-RayLiao1024.jpg\"\n" +
                "  }\n" +
                "]"

        return convertSampleJsonToDataClass(json)
    }

    private fun convertSampleJsonToDataClass(json: String): List<NASAImagesItem> {
        var list = mutableListOf<NASAImagesItem>()
        try{
            val classType = genericType<List<NASAImagesItem>>()
            list = Gson().fromJson(json, classType)
            return list
        }catch (e: Exception){
            e.printStackTrace()
        }

        return list
    }

    private inline fun <reified T> genericType() = object : TypeToken<T>() {}.type
}