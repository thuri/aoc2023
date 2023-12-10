import net.lueckonline.aoc2023.kotlin.Day9
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Named
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Day9Test {

  @ParameterizedTest
  @MethodSource("testInput")
  fun shouldSumExtrapolateValues(input : String, expectedSum : Long) {
    assertThat(Day9(input).part1(), `is`(expectedSum))
  }

  companion object {
    @JvmStatic
    fun testInput() : Stream<Arguments> {
      return Stream.of(
        Arguments.of(Named.of("single", singleLine), -702052L),
        Arguments.of(Named.of("example", example), 114L),
        Arguments.of(Named.of("puzzleInput", input), 1853145119L)
      )
    }

    private val singleLine = """
      13  28  45  59  57   23   -46   -115  -83   238   1123    2895    5825    9945    14744    18713   18701     9040      -19607      -81725       -198807
        15  17  14  -2  -34  -69   -69    32   321   885    1772    2930    4120    4799     3969     -12     -9661    -28647      -62118      -117082
          2   -3  -16  -32 -35   0    101    289   564   887    1158    1190    679     -830     -3981   -9649     -18986    -33471      -54964
            -5  -13  -16  -3  -35  101    188   365   323   
           
    """.trimIndent()

    private val example = """
      0 3 6 9 12 15
      1 3 6 10 15 21
      10 13 16 21 30 45
    """.trimIndent()

    private val input = """
      10 20 37 71 136 258 493 972 2001 4255 9116 19216 39257 77191 145854 265159 464964 788742 1298191 2078933 3247462
      28 53 92 163 312 639 1336 2734 5353 9946 17525 29354 46891 71658 105015 147811 199882 259363 321778 378869 417122
      10 18 38 85 184 373 706 1256 2118 3412 5286 7919 11524 16351 22690 30874 41282 54342 70534 90393 114512
      13 28 45 59 57 23 -46 -115 -83 238 1123 2895 5825 9945 14744 18713 18701 9040 -19607 -81725 -198807
      9 5 1 -3 -7 -11 -15 -19 -23 -27 -31 -35 -39 -43 -47 -51 -55 -59 -63 -67 -71
      26 53 100 185 338 598 1021 1712 2894 5027 8990 16339 29654 52988 92431 156802 258482 414401 647192 986525 1470634
      -4 -3 6 21 48 113 274 633 1348 2645 4830 8301 13560 21225 32042 46897 66828 93037 126902 169989 224064
      -1 6 26 68 147 297 599 1238 2613 5546 11682 24255 49539 99573 197307 386506 751211 1454366 2814050 5451042 10566571
      2 9 29 70 152 319 651 1276 2382 4229 7161 11618 18148 27419 40231 57528 80410 110145 148181 196158 255920
      15 31 62 122 234 426 729 1198 1998 3624 7357 16097 35759 77469 160854 318783 603985 1098045 1923360 3258724 5359304
      3 4 -4 -16 -18 27 213 757 2116 5181 11581 24137 47513 89118 160320 278040 466801 761314 1209690 1877374 2851904
      15 27 41 61 100 186 371 743 1441 2673 4737 8045 13150 20776 31851 47543 69299 98887 138441 190509 258104
      21 29 33 34 38 64 171 522 1518 4057 10016 23160 50945 108288 225665 466447 963131 1990517 4108079 8426882 17092752
      -7 -5 2 14 31 53 80 112 149 191 238 290 347 409 476 548 625 707 794 886 983
      10 17 27 56 134 313 694 1483 3095 6345 12801 25432 49772 95968 182400 342397 637759 1188072 2236418 4295587 8463149
      16 26 36 46 56 66 76 86 96 106 116 126 136 146 156 166 176 186 196 206 216
      22 32 38 47 92 253 688 1684 3744 7738 15173 28689 52972 96396 173887 311842 556735 991041 1764922 3162971 5748235
      10 20 37 70 137 283 611 1333 2870 6079 12774 26866 56747 120143 253858 533128 1109490 2283314 4639099 9290554 18311365
      13 15 18 37 104 283 699 1588 3387 6912 13742 27077 53633 107690 219414 451350 930029 1904693 3853286 7668565 14976442
      11 32 72 156 326 653 1254 2309 4071 6863 11062 17095 25560 37842 58254 100287 202979 470554 1162628 2889018 7011602
      13 22 47 109 238 475 888 1618 2992 5779 11726 24597 52051 108836 221945 438576 837959 1548356 2770801 4811421 8124460
      25 46 86 154 255 397 609 970 1649 2956 5404 9782 17239 29379 48367 77046 119065 179018 262594 376738 529823
      18 27 36 45 54 63 72 81 90 99 108 117 126 135 144 153 162 171 180 189 198
      -5 -6 0 20 66 157 314 553 892 1400 2324 4324 8811 18299 36524 67821 114849 173174 220416 196588 -29152
      4 3 2 1 0 -1 -2 -3 -4 -5 -6 -7 -8 -9 -10 -11 -12 -13 -14 -15 -16
      7 22 56 133 292 603 1198 2319 4389 8129 14795 26724 48601 90277 172780 340808 688379 1411160 2912394 6014571 12374722
      11 15 21 27 46 129 409 1190 3131 7622 17519 38503 81470 166580 329955 634616 1188227 2171761 3885569 6822835 11785430
      12 14 25 56 118 222 379 600 896 1278 1757 2344 3050 3886 4863 5992 7284 8750 10401 12248 14302
      -4 3 24 64 128 221 348 514 724 983 1296 1668 2104 2609 3188 3846 4588 5419 6344 7368 8496
      12 20 21 22 45 128 336 807 1868 4276 9692 21622 47322 101659 214780 446844 915248 1843016 3641675 7048442 13346399
      -5 10 50 128 271 527 974 1750 3140 5775 11022 21689 43277 86280 170677 335205 657045 1293576 2569118 5149622 10382351
      7 17 56 145 325 674 1334 2562 4822 8938 16348 29563 53093 95469 173831 324424 626309 1253519 2585836 5435109 11489697
      3 15 55 133 252 421 679 1127 1970 3591 6720 12824 24925 49143 97346 191350 369125 693399 1262877 2225967 3796386
      9 19 42 86 170 328 625 1195 2311 4497 8692 16476 30368 54206 93619 156601 254197 401311 617646 928786 1367430
      11 8 15 39 82 147 265 563 1406 3673 9274 22088 49607 105714 215210 420942 794677 1453222 2581713 4466493 7540576
      13 25 60 142 312 634 1201 2141 3623 5863 9130 13752 20122 28704 40039 54751 73553 97253 126760 163090 207372
      1 21 57 109 187 319 553 951 1573 2457 3621 5159 7620 13150 28536 72642 193269 502929 1250405 2956629 6661117
      8 18 41 89 189 388 758 1401 2454 4094 6543 10073 15011 21744 30724 42473 57588 76746 100709 130329 166553
      5 11 20 30 38 47 94 314 1059 3095 7904 18122 38148 74963 139202 246526 419345 688947 1098092 1704134 2582738
      -1 3 22 66 155 331 675 1326 2510 4617 8422 15649 30253 61086 127078 266782 555205 1132403 2250514 4348928 8171371
      -4 -2 22 82 187 346 595 1054 2020 4106 8451 17059 33400 63594 118963 221791 418320 807190 1598984 3235088 6614221
      9 22 33 37 44 99 313 926 2436 5853 13200 28533 60068 124593 256341 524077 1062567 2128324 4195503 8117873 15400320
      3 18 55 125 238 405 638 947 1349 1939 3136 6317 15199 38537 95011 221698 488630 1024559 2065280 4049948 7820703
      8 19 48 98 180 324 600 1170 2414 5212 11523 25479 55303 116480 236856 465039 885489 1648974 3039687 5628017 10614711
      11 11 20 52 134 316 697 1475 3027 6023 11576 21428 38170 65492 108457 173791 270179 408555 602372 867836 1224086
      22 42 67 102 173 352 807 1899 4367 9671 20601 42320 84138 162616 307259 571364 1052956 1934724 3558159 6556542 12085011
      -4 -10 -17 -23 -19 32 226 754 1950 4391 9151 18410 36763 73771 148554 297553 586992 1132060 2125415 3878295 6878313
      6 22 55 123 258 511 969 1803 3369 6386 12216 23268 43543 79353 140352 241358 406296 677422 1136557 1951553 3472424
      7 16 25 34 43 52 61 70 79 88 97 106 115 124 133 142 151 160 169 178 187
      -2 9 30 61 102 153 214 285 366 457 558 669 790 921 1062 1213 1374 1545 1726 1917 2118
      9 22 53 115 233 444 802 1412 2547 4947 10459 23252 51931 112979 236076 471979 903797 1662660 2948961 5060545 8429429
      -2 5 13 32 102 304 771 1700 3358 6058 10048 15209 20419 22461 14525 -15185 -83286 -206365 -385589 -570762 -587760
      4 22 49 93 172 319 591 1085 1975 3616 6831 13631 28857 63639 142229 314805 680422 1426610 2895445 5690561 10845906
      26 44 64 87 118 165 252 470 1101 2877 7490 18561 43416 96222 203359 412496 808058 1538356 2864986 5255597 9560768
      15 19 20 17 9 -5 -26 -55 -93 -141 -200 -271 -355 -453 -566 -695 -841 -1005 -1188 -1391 -1615
      6 8 15 27 44 66 93 125 162 204 251 303 360 422 489 561 638 720 807 899 996
      -7 0 33 109 246 465 796 1288 2023 3134 4827 7407 11308 17127 25662 37954 55333 79468 112421 156705 215346
      5 8 12 9 -9 -48 -102 -126 15 626 2294 6033 13461 27006 50136 87606 145713 232548 358232 535121 777963
      15 33 70 143 279 516 904 1506 2399 3675 5442 7825 10967 15030 20196 26668 34671 44453 56286 70467 87319
      16 30 61 122 232 418 710 1132 1700 2459 3638 6093 12383 29173 72363 177741 422644 969084 2147691 4617244 9660542
      7 32 68 127 237 444 814 1435 2419 3904 6056 9071 13177 18636 25746 34843 46303 60544 78028 99263 124805
      3 7 18 40 67 92 136 311 947 2838 7697 18956 43105 91835 185335 357193 661467 1182625 2049204 3452208 5669455
      25 44 65 99 177 365 789 1670 3369 6442 11705 20309 33825 54339 84557 127920 188729 272280 385009 534647 730385
      19 26 31 46 102 256 602 1285 2509 4524 7573 11775 16914 22110 25414 23633 13518 -2249 5102 148485 777449
      15 16 13 14 42 143 399 954 2069 4233 8369 16197 30897 58483 111035 214682 428973 891784 1918347 4209978 9277526
      13 20 20 21 47 157 480 1283 3104 6997 14951 30560 60036 113672 207877 367920 631535 1053554 1711750 2714087 4207589
      15 29 58 105 176 297 542 1073 2208 4560 9342 19048 38969 80502 168149 353813 745089 1559867 3229842 6594307 13259578
      22 48 101 193 341 580 985 1718 3129 5953 11658 23012 44950 85835 159220 286231 498704 843222 1386211 2220267 3471899
      17 43 84 150 266 493 964 1937 3876 7604 14642 27966 53588 103601 201621 391904 753799 1423597 2626220 4719522 8254194
      3 8 15 25 42 73 128 220 365 582 893 1323 1900 2655 3622 4838 6343 8180 10395 13037 16158
      0 4 13 36 107 306 786 1820 3910 8047 16280 32843 66199 132483 260953 502177 939780 1706630 3006335 5140830 8544627
      17 31 52 89 164 317 613 1155 2114 3805 6884 12838 25117 51549 109127 232908 491671 1014203 2031684 3943695 7417954
      0 12 47 126 277 535 942 1547 2406 3582 5145 7172 9747 12961 16912 21705 27452 34272 42291 51642 62465
      24 28 36 69 160 357 738 1451 2795 5371 10378 20257 40197 81697 170733 365567 793490 1722634 3695420 7765381 15900254
      15 29 46 65 85 116 195 406 914 2047 4502 9816 21336 46048 97789 202573 407017 791161 1487342 2707211 4779479
      -8 -8 11 63 162 322 557 881 1308 1852 2527 3347 4326 5478 6817 8357 10112 12096 14323 16807 19562
      2 15 44 97 202 427 917 1969 4181 8742 17987 36448 72841 143834 281192 545212 1049548 2005985 3802966 7139347 13245732
      20 40 70 115 180 270 390 545 740 980 1270 1615 2020 2490 3030 3645 4340 5120 5990 6955 8020
      17 34 63 115 211 381 662 1102 1796 3008 5476 11072 24124 53941 119465 257567 537379 1084294 2118965 4018897 7413169
      21 27 33 39 45 51 57 63 69 75 81 87 93 99 105 111 117 123 129 135 141
      24 51 101 179 288 430 608 833 1151 1727 3056 6413 14699 33885 75332 159512 322466 628597 1198855 2275141 4364978
      -4 -5 -8 -16 -25 -22 23 181 625 1782 4704 11929 29352 70027 161429 358584 766698 1578565 3134200 6012926 11171653
      23 52 96 166 280 474 835 1562 3062 6107 12130 23838 46483 90373 175539 339916 652961 1237334 2302124 4192126 7458882
      9 34 74 145 277 521 975 1849 3602 7201 14572 29335 57938 111328 207319 373837 653239 1107916 1827398 2937181 4609491
      3 12 32 72 163 375 843 1805 3666 7121 13388 24604 44408 78687 136500 231653 387061 648502 1124596 2090896 4236081
      9 18 28 44 80 159 313 583 1019 1680 2634 3958 5738 8069 11055 14809 19453 25118 31944 40080 49684
      11 7 -4 -26 -63 -119 -198 -304 -441 -613 -824 -1078 -1379 -1731 -2138 -2604 -3133 -3729 -4396 -5138 -5959
      4 -1 5 47 169 441 977 1989 3928 7803 15823 32575 67033 135789 268007 512725 949268 1701687 2958305 4997631 8222097
      23 40 81 164 307 524 817 1162 1488 1660 1511 1035 964 4118 18149 60609 167669 408312 906429 1873974 3659193
      6 21 41 66 96 131 171 216 266 321 381 446 516 591 671 756 846 941 1041 1146 1256
      6 12 31 73 149 281 522 989 1914 3722 7156 13492 24927 45285 81275 144656 255822 449520 783661 1352483 2305681
      24 50 98 177 293 443 619 852 1355 2873 7429 19789 50192 119274 266804 567130 1156623 2282814 4392942 8294246 15445454
      16 33 50 60 67 115 334 1019 2771 6753 15172 32234 66103 132923 264851 525427 1037598 2032417 3929906 7467776 13898495
      16 42 79 127 186 256 337 429 532 646 771 907 1054 1212 1381 1561 1752 1954 2167 2391 2626
      1 19 47 92 174 329 612 1100 1895 3127 4957 7580 11228 16173 22730 31260 42173 55931 73051 94108 119738
      19 47 99 179 283 403 541 749 1221 2466 5598 12825 28378 60532 126285 262133 548051 1158840 2470367 5273260 11192757
      8 27 65 145 302 583 1047 1765 2820 4307 6333 9017 12490 16895 22387 29133 37312 47115 58745 72417 88358
      5 12 20 23 7 -39 -89 -18 489 2054 5742 13205 26819 49795 86241 141148 220269 329856 476216 665043 900479
      5 0 -5 -10 -15 -20 -25 -30 -35 -40 -45 -50 -55 -60 -65 -70 -75 -80 -85 -90 -95
      11 21 33 64 139 295 591 1124 2051 3617 6189 10296 16675 26323 40555 61068 90011 130061 184505 257328 353307
      13 38 84 164 296 503 813 1259 1879 2716 3818 5238 7034 9269 12011 15333 19313 24034 29584 36056 43548
      22 34 46 58 70 82 94 106 118 130 142 154 166 178 190 202 214 226 238 250 262
      -7 -15 -14 22 139 406 918 1803 3246 5560 9359 15921 27870 50355 92961 172652 318119 575987 1019424 1759792 2962085
      2 13 30 53 82 117 158 205 258 317 382 453 530 613 702 797 898 1005 1118 1237 1362
      6 6 1 0 26 115 324 767 1719 3872 8903 20631 47207 105007 225192 464270 920452 1758146 3243589 5795386 10054616
      13 34 67 112 169 238 319 412 517 634 763 904 1057 1222 1399 1588 1789 2002 2227 2464 2713
      7 17 32 56 110 241 546 1240 2827 6492 14946 34166 76844 169001 362308 756457 1538847 3053479 5918108 11219488 20832434
      18 40 84 171 344 680 1314 2490 4654 8604 15712 28233 49716 85532 143534 234864 374922 584512 891180 1330759 1949136
      4 13 26 54 124 283 606 1212 2302 4257 7882 14972 29534 60259 125242 260546 535056 1075237 2104970 4007674 7420520
      0 12 35 77 163 350 760 1659 3624 7855 16705 34518 68883 132431 245322 438590 758536 1272382 2075423 3299939 5126155
      9 4 11 45 124 269 504 856 1355 2034 2929 4079 5526 7315 9494 12114 15229 18896 23175 28129 33824
      15 24 39 67 126 267 602 1352 2953 6292 13185 27255 55430 110392 214551 406675 753543 1371592 2468747 4426635 7961898
      4 2 0 -2 -4 -6 -8 -10 -12 -14 -16 -18 -20 -22 -24 -26 -28 -30 -32 -34 -36
      26 47 84 156 301 596 1196 2405 4805 9500 18596 36156 70078 135716 262733 507871 978412 1874633 3565304 6719300 12530091
      12 24 54 110 200 332 514 754 1060 1440 1902 2454 3104 3860 4730 5722 6844 8104 9510 11070 12792
      12 28 56 101 169 267 403 586 826 1134 1522 2003 2591 3301 4149 5152 6328 7696 9276 11089 13157
      26 52 85 120 152 176 187 180 150 92 1 -128 -300 -520 -793 -1124 -1518 -1980 -2515 -3128 -3824
      10 11 8 0 -6 25 199 766 2230 5506 12142 24639 46926 85082 148445 251311 415506 674213 1077556 1700586 2654482
      13 34 70 139 269 498 874 1455 2309 3514 5158 7339 10165 13754 18234 23743 30429 38450 47974 59179 72253
      -1 9 35 79 133 188 257 412 835 1883 4167 8645 16729 30406 52373 86186 136423 208861 310667 450603 639245
      17 41 74 122 199 327 536 864 1357 2069 3062 4406 6179 8467 11364 14972 19401 24769 31202 38834 47807
      9 21 48 101 216 477 1048 2227 4562 9109 17963 35253 68859 133181 253365 471467 855111 1509269 2591858 4333909 7065114
      12 23 35 43 42 27 -7 -65 -152 -273 -433 -637 -890 -1197 -1563 -1993 -2492 -3065 -3717 -4453 -5278
      4 27 78 174 340 626 1138 2085 3844 7045 12678 22224 37812 62404 100010 155935 237060 352159 512254 731010 1025172
      4 13 33 84 210 495 1090 2263 4498 8699 16620 31771 61284 119630 235790 466776 922862 1814771 3542949 6869036 13249340
      8 26 59 113 190 287 395 498 572 584 491 239 -238 -1019 -2197 -3880 -6192 -9274 -13285 -18403 -24826
      -4 -4 -6 -7 8 74 268 757 1878 4240 8802 16809 29338 45989 61923 62014 10540 -164690 -591588 -1463327 -2996076
      17 35 75 159 330 661 1269 2347 4236 7573 13583 24661 45568 85944 165612 325670 651297 1317646 2679888 5444771 10986614
      8 -2 -14 -16 13 102 287 607 1096 1773 2643 3768 5613 10260 24999 71777 209912 586780 1543972 3827672 8985725
      7 20 44 95 205 420 797 1413 2418 4193 7728 15447 32933 72430 159738 347326 738365 1529174 3081576 6042235 11533609
      26 39 57 85 129 200 336 656 1465 3434 7888 17274 36026 72463 143365 285005 578508 1204697 2555819 5451107 11533191
      13 23 46 100 220 466 952 1924 3923 8072 16530 33168 64554 121421 221041 391634 681829 1182870 2081976 3788119 7217192
      8 11 23 55 118 223 381 603 900 1283 1763 2351 3058 3895 4873 6003 7296 8763 10415 12263 14318
      11 10 8 11 38 144 467 1318 3345 7830 17249 36378 74510 149815 297604 585376 1139263 2189254 4145086 7722105 14148550
      14 31 65 122 215 371 647 1163 2167 4173 8268 16793 34833 73459 156777 337172 727776 1569946 3369277 7160753 15008435
      3 -1 -3 7 44 140 368 882 1988 4274 8838 17656 34129 63877 116032 205914 361679 641582 1177435 2278540 4667900
      22 36 50 64 78 92 106 120 134 148 162 176 190 204 218 232 246 260 274 288 302
      21 41 69 102 149 248 496 1113 2570 5824 12727 26725 54076 106085 203462 385178 726643 1376443 2628377 5057688 9769271
      5 6 22 82 242 602 1340 2789 5609 11145 22109 43772 85890 165603 311535 569326 1009005 1735416 2905408 4761994 7710738
      -4 -1 11 43 116 278 635 1401 2989 6204 12670 25736 52271 105985 213212 422472 819602 1550821 2856781 5121465 8940734
      1 17 53 124 251 466 819 1396 2371 4129 7511 14246 27649 53678 102457 190386 342973 598537 1012945 1665560 2666591
      5 3 7 34 110 265 529 928 1485 2248 3394 5503 10195 21572 49525 117419 279897 663345 1555197 3594368 8162992
      -3 0 9 44 154 430 1025 2202 4457 8817 17521 35497 73406 153605 321269 664205 1346701 2665206 5136873 9636170 17600042
      26 36 40 34 26 45 141 382 865 1779 3612 7712 17628 42003 100292 233247 520944 1112098 2269468 4437210 8336970
      11 22 48 104 213 415 797 1559 3131 6356 12754 24882 46805 84693 147559 248153 404027 638786 983540 1478572 2175237
      3 -2 2 27 85 187 342 556 831 1164 1546 1961 2385 2785 3118 3330 3355 3114 2514 1447 -211
      7 25 46 76 146 338 823 1924 4245 8950 18334 36901 73252 143189 274559 514495 939859 1671855 2895958 4888498 8051446
      11 23 43 88 196 447 998 2154 4523 9340 19093 38643 77100 150798 287804 534499 964883 1693381 2892063 4813338 7819340
      28 43 55 67 91 152 298 618 1281 2635 5444 11390 24026 50442 104017 208809 406434 766779 1404685 2505957 4367877
      16 20 32 73 188 451 975 1947 3724 7055 13547 26593 53172 107293 216507 434016 860656 1683594 3242022 6134261 11384820
      0 9 27 51 91 193 474 1179 2781 6159 12904 25827 49806 93284 171184 311119 567389 1053195 2014554 3997163 8214564
      9 4 -4 -15 -28 -43 -55 -35 106 576 1795 4541 10179 21017 40850 75773 135367 234388 395118 650569 1048766
      12 16 12 -1 -12 20 195 716 1960 4606 9889 20130 39850 78077 153037 301569 597876 1190624 2375630 4736161 9408360
      17 32 55 86 125 172 227 290 361 440 527 622 725 836 955 1082 1217 1360 1511 1670 1837
      11 32 76 159 308 575 1062 1968 3678 6923 13049 24442 45165 81872 145073 250833 422997 696042 1118666 1758233 2706202
      24 29 36 62 142 335 742 1545 3076 5935 11208 20908 38898 72785 137634 262883 504592 966185 1832204 3421354 6267350
      24 40 70 124 206 308 399 407 207 -337 -1167 -1462 1623 15403 55992 155459 373042 811978 1643872 3142928 5732796
      7 19 38 66 100 127 119 28 -219 -725 -1628 -3106 -5382 -8729 -13475 -20008 -28781 -40317 -55214 -74150 -97888
      11 16 21 41 118 330 795 1665 3115 5354 8722 13992 23069 40361 75173 145540 284055 546816 1028571 1892639 3437572
      3 3 -2 -12 -27 -47 -72 -102 -137 -177 -222 -272 -327 -387 -452 -522 -597 -677 -762 -852 -947
      4 -3 -11 -4 45 183 495 1134 2380 4781 9514 19292 40529 88215 196295 438677 969908 2100949 4435671 9109592 18196677
      16 23 43 83 144 225 340 564 1146 2762 7029 17462 41130 91354 191890 383153 731164 1340041 2369007 4055053 6742572
      9 37 82 143 223 349 600 1135 2224 4314 8207 15490 29468 57117 113263 229863 476947 1009231 2166432 4680165 10082197
      23 28 24 8 -13 -7 99 437 1237 2931 6400 13489 27984 57361 115840 229729 446943 854290 1609180 2997634 5538965
      18 30 46 76 135 243 425 711 1136 1740 2568 3670 5101 6921 9195 11993 15390 19466 24306 30000 36643
      -6 -3 6 20 44 109 307 843 2116 4861 10416 21237 41910 81180 156069 300223 580630 1130545 2213210 4343166 8513688
      -2 10 33 60 92 154 317 735 1719 3884 8419 17551 35329 69021 131897 249438 474097 920744 1849917 3856561 8281901
      9 34 84 174 323 554 894 1374 2029 2898 4024 5454 7239 9434 12098 15294 19089 23554 28764 34798 41739
      14 32 61 103 160 234 327 441 578 740 929 1147 1396 1678 1995 2349 2742 3176 3653 4175 4744
      1 12 37 94 219 471 941 1779 3279 6110 11868 24276 51611 111333 238484 500277 1020477 2018768 3872391 7210026 13051283
      -7 -12 -14 -8 20 105 331 900 2294 5618 13252 29979 64789 133581 262991 495559 896407 1561528 2627678 4283714 6783026
      11 9 21 68 173 357 638 1040 1619 2508 3970 6421 10335 15858 21823 23655 9363 -47589 -200285 -547702 -1264783
      17 37 80 150 242 344 442 535 687 1172 2806 7616 20106 49634 114991 253483 539149 1118923 2282576 4593514 9124730
      15 31 44 57 81 135 246 449 787 1311 2080 3161 4629 6567 9066 12225 16151 20959 26772 33721 41945
      2 9 31 93 230 487 919 1591 2578 3965 5847 8329 11526 15563 20575 26707 34114 42961 53423 65685 79942
      11 27 70 153 298 547 990 1825 3465 6707 12978 24673 45600 81547 140986 235929 382951 604395 929774 1397385 2056150
      13 15 24 45 96 229 574 1420 3353 7486 15856 32157 63182 121779 233032 447242 866998 1702750 3384409 6779726 13609905
      16 33 62 112 196 346 646 1291 2686 5616 11552 23221 45683 88364 168851 319849 601648 1123903 2082686 3821866 6932202
      2 12 35 83 176 349 671 1291 2536 5091 10290 20539 39876 74648 134250 231825 384766 614790 947269 1409403 2026704
      18 36 63 104 176 311 572 1103 2243 4745 10154 21413 43783 86182 163069 297022 522184 888778 1468921 2363998 3713890
      10 13 11 4 6 60 256 752 1798 3763 7165 12704 21298 34122 52650 78700 114482 162649 226351 309292 415790
      2 5 13 46 139 350 779 1613 3219 6320 12325 23978 46703 91450 180668 360614 726382 1472666 2997362 6114810 12496419
      5 3 -7 -16 -4 62 236 614 1396 3052 6707 14932 33227 72632 154177 316480 629191 1218157 2315097 4358776 8202246
      17 27 34 35 23 -9 -47 4 448 2037 6408 16914 40280 89988 193197 404630 833640 1695246 3403399 6737208 13132694
      19 26 41 72 124 210 370 696 1360 2641 4946 8819 14931 24043 36933 54277 76473 103396 134071 166250 195878
      20 40 80 161 326 665 1364 2797 5693 11429 22534 43559 82610 154115 283904 518588 942764 1710019 3097257 5596451 10062858
      9 3 -9 -32 -60 -50 125 769 2548 6845 16420 36621 77610 158483 314918 613299 1176493 2230289 4186508 7792707 14407912
      21 27 27 18 0 -17 -3 105 419 1119 2475 4872 8838 15075 24493 38247 57777 84851 121611 170622 234924
      -1 14 56 151 337 672 1249 2217 3807 6362 10370 16499 25633 38908 57747 83893 119439 166854 229004 309167 411041
      -4 8 34 72 119 171 223 269 302 314 296 238 129 -43 -291 -629 -1072 -1636 -2338 -3196 -4229
      3 14 39 86 168 306 546 999 1920 3868 8040 16959 35853 75373 156928 323138 658121 1326054 2642273 5199676 10084758
      17 29 40 59 116 282 693 1585 3355 6669 12642 23117 41070 71166 120487 199447 322901 511445 792892 1203895 1791672
      -4 -5 -6 -1 37 176 562 1488 3524 7755 16191 32431 62700 117479 214198 382001 670632 1167335 2028724 3539411 6216491
      -4 -7 -10 -13 -16 -19 -22 -25 -28 -31 -34 -37 -40 -43 -46 -49 -52 -55 -58 -61 -64
      7 34 90 185 334 580 1028 1886 3516 6512 11838 21069 36776 63087 106474 176971 290626 475802 790737 1371275 2553159
      3 10 24 47 81 128 190 269 367 486 628 795 989 1212 1466 1753 2075 2434 2832 3271 3753
      -4 -4 2 23 83 237 596 1361 2866 5630 10418 18311 30785 49799 77892 118289 175016 253024 358322 498119 680975
      1 15 40 90 198 421 845 1590 2815 4723 7566 11650 17340 25065 35323 48686 65805 87415 114340 147498 187906
      1 7 20 34 47 84 234 705 1910 4608 10140 20830 40680 76597 140576 253559 452135 799885 1406060 2455466 4254981
      8 31 64 116 217 422 807 1458 2462 3920 6016 9193 14507 24253 42983 79065 146964 270461 487064 853906 1455469
    """.trimIndent()
  }
}