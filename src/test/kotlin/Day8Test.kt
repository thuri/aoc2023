import net.lueckonline.aoc2023.kotlin.Day8
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class Day8Test {
  lateinit private var day: Day8

  @BeforeEach
  fun setUp() {
    day = Day8()
  }

  @ParameterizedTest
  @MethodSource("part1Arguments")
  fun shouldCalculateSteps(input : List<String>, expectedResult : Long) {
    assertThat(day.part1(input), `is`(expectedResult))
  }

  companion object {

    @JvmStatic
    fun part1Arguments() : Stream<Arguments> {
      return Stream.of(
        Pair(example1,  2),
        Pair(example2,  6),
        Pair(input,     12361L)
      ).map { Arguments.of(it.first.split("\n").filter(String::isNotBlank).toList(), it.second)}
    }

    private val example1 = """
      RL

      AAA = (BBB, CCC)
      BBB = (DDD, EEE)
      CCC = (ZZZ, GGG)
      DDD = (DDD, DDD)
      EEE = (EEE, EEE)
      GGG = (GGG, GGG)
      ZZZ = (ZZZ, ZZZ)
    """.trimIndent()

    private val example2 = """
      LLR

      AAA = (BBB, BBB)
      BBB = (AAA, ZZZ)
      ZZZ = (ZZZ, ZZZ)
    """.trimIndent()

    private val input = """
      LLRRRLLRRRLRRRLRLRLLRRLRRRLLLRLRRRLRRRLRLLRRLRRRLLRRLRRLRLRRRLRRLLRLRRLRRRLRRLLRRRLRLLLRLRRRLRRLLLLRRRLRRRLRRRLRLRRLRRLRLRRLLRLLRRRLRRLRLLRRLRRLLRLLRLRRRLRLRLRRRLRRLLLRLRRRLLRLLRRRLRLRLRRRLLRLLLLRRRLRRRLRLRRRLRRLRRLLRLRLRRRLRRRLRLRRLLLLRLRRRLRRRLRLRRRLRLRRLRLRRRR

      BQV = (HFG, GDR)
      VQT = (JLQ, TNJ)
      SGR = (TLQ, FGP)
      BXN = (TTQ, HJH)
      FXV = (RDS, NGH)
      MXR = (BXN, PXF)
      MJN = (RSQ, LBL)
      PTG = (GSC, SFM)
      TPD = (CXX, TCD)
      FXD = (NDP, PVL)
      GSB = (SVM, RHH)
      LPX = (GSS, RHC)
      JCS = (RKT, XHN)
      TTQ = (MDT, BNX)
      NXP = (QSK, JXB)
      PRK = (TCT, JGS)
      BDL = (PXH, RJH)
      RGS = (MRL, VTT)
      VFR = (VHS, QDB)
      KFL = (PGM, KNL)
      KJP = (QCQ, TKC)
      NDN = (CLT, FKK)
      FPG = (JJT, JJT)
      XNH = (LSH, SQQ)
      PBM = (GCD, VTD)
      XGD = (FDN, XHT)
      HQR = (KDD, RTX)
      KQH = (BMQ, GLQ)
      HLH = (GHM, FQL)
      LGP = (RNT, DHG)
      BCV = (VFL, XNC)
      GSS = (DJT, PND)
      VRM = (CPT, RGH)
      LJX = (RXR, LNC)
      FSB = (XJG, TFG)
      XSJ = (DXJ, HBD)
      FHB = (MBN, TPD)
      NVR = (MLR, LMQ)
      PCM = (CMS, XCH)
      TDJ = (BBT, BMS)
      GCD = (KHC, BDL)
      NLM = (XSM, LML)
      CKP = (NKS, PXJ)
      CXD = (XGK, JLR)
      FMS = (DNC, VJN)
      XCV = (LML, XSM)
      MBN = (TCD, CXX)
      SDQ = (GRQ, CBJ)
      KKF = (PRG, NCQ)
      GJL = (RSQ, LBL)
      MPV = (VTD, GCD)
      NBQ = (MCG, RBN)
      QQS = (RRQ, HJB)
      QGS = (MXB, BFG)
      NGB = (HRV, FCN)
      VNP = (LDF, DJB)
      XXQ = (QPJ, STL)
      BLJ = (KCL, TXD)
      QFV = (RFF, FFL)
      FKS = (QQV, BTH)
      DKX = (VXQ, RDX)
      LVF = (LBH, QFT)
      QQT = (CVJ, KNQ)
      TRJ = (GRC, BHN)
      MTC = (TKV, VTM)
      SCV = (MHT, MHT)
      FNT = (HRF, RDR)
      FQS = (QVQ, LDX)
      CMS = (GSK, LNQ)
      HKH = (MHD, NRV)
      MPQ = (FMS, LHR)
      MFS = (KXL, KXL)
      XXN = (SJQ, DBF)
      RQG = (NQV, QFV)
      SML = (HLD, MGG)
      KVM = (SGJ, RBB)
      XNC = (PMG, FXD)
      TQB = (XND, NGX)
      QRG = (GXR, XCB)
      BNV = (PJJ, NLH)
      KMK = (KJP, VSM)
      CML = (PJK, HQB)
      RBM = (HFK, JBH)
      ZZZ = (NTL, GVD)
      PGM = (HQK, LPG)
      TSH = (NVK, JXD)
      FXZ = (NGX, XND)
      VNT = (JPB, VHM)
      BFF = (HDD, CXP)
      QRR = (FJP, NXN)
      XLC = (KPR, FSB)
      RNM = (PBM, MPV)
      CMG = (VCK, GXX)
      MPC = (FVT, JMM)
      NMC = (TPC, TRF)
      BBS = (PDP, PHC)
      FCN = (QNF, MDM)
      HPG = (MTC, MJB)
      TCH = (BXH, FHH)
      PPK = (DSQ, DSQ)
      PMS = (FFV, TTG)
      BML = (FXS, RKP)
      QNF = (KTP, LTV)
      PBQ = (TLQ, FGP)
      BKP = (BMQ, GLQ)
      LBL = (RDG, HLB)
      BKL = (LJX, VCM)
      LLS = (FXQ, CHG)
      HFD = (CMS, XCH)
      SJQ = (QBG, CGS)
      TKC = (JXV, HRJ)
      DKL = (HHP, SCK)
      DPS = (RNP, RQG)
      GMG = (PFN, LLV)
      DNS = (SCV, TDD)
      RDG = (XSP, QQT)
      MHT = (TQB, TQB)
      RKX = (DKX, DKX)
      MJC = (KGT, CRJ)
      LTV = (GKT, LVJ)
      PLM = (MPS, NLC)
      PHC = (FXV, VMD)
      QLN = (QPJ, STL)
      FTX = (PFM, SDQ)
      XSP = (CVJ, KNQ)
      XND = (BBS, TTF)
      LSQ = (LCM, NJF)
      HDV = (BBX, RKH)
      DJG = (JBH, HFK)
      XPM = (NNM, KNX)
      FGP = (LVN, JMB)
      QBG = (XBC, SGD)
      HQK = (NVR, NKQ)
      GMN = (SBP, KHJ)
      NDR = (VHQ, MGN)
      RQQ = (QVQ, LDX)
      XFD = (BKX, QRG)
      FCH = (SMF, BHJ)
      JMM = (LVT, BCV)
      SBR = (LBD, RGS)
      NLH = (FPG, QVF)
      TPC = (HFD, PCM)
      GGP = (TPD, MBN)
      LDF = (PMX, NMP)
      TQP = (MQH, PJD)
      SMD = (FCH, CCF)
      HJB = (RFL, RMH)
      JCJ = (BNV, RCM)
      DJD = (LVS, HQD)
      XHT = (CRH, NTS)
      KXL = (XPT, XPT)
      MCK = (PRG, NCQ)
      TVQ = (XHN, RKT)
      PGN = (GDR, HFG)
      KTD = (VML, HLN)
      RKH = (XNH, TJK)
      VPC = (FDS, DPS)
      HBD = (CCR, XGP)
      FQL = (BCN, KBS)
      QJN = (MJN, GJL)
      KSV = (NBQ, GTR)
      CBT = (PCN, DTB)
      KJR = (TDH, HBJ)
      PND = (JGM, PFL)
      MFM = (XMD, QRP)
      VBB = (HVH, SFP)
      JKM = (SQP, LSQ)
      SCP = (JPC, SML)
      DFQ = (GRC, BHN)
      RSQ = (HLB, RDG)
      NCB = (CPS, KCG)
      LVJ = (FLG, KXQ)
      FQB = (RKX, RKX)
      XPT = (GVD, NTL)
      XGP = (LNK, XKG)
      CBG = (LDF, DJB)
      XFH = (LLV, PFN)
      GGJ = (PXF, BXN)
      LTJ = (CPS, KCG)
      CPS = (DMN, QGD)
      LRR = (DRN, NCJ)
      XFS = (BKL, LXM)
      NDP = (PQF, SVL)
      BCN = (XGS, BJF)
      GVK = (FXQ, CHG)
      JKB = (LPX, MPH)
      JBD = (MKH, XGD)
      CNM = (KMG, CKD)
      NSS = (MQL, RHX)
      VCM = (LNC, RXR)
      TTL = (FLD, DBS)
      BJS = (TVC, FLF)
      DNR = (KCP, BJS)
      XSH = (JDF, QKN)
      HHZ = (GVK, LLS)
      RRC = (TSK, DNK)
      SQP = (NJF, LCM)
      QXR = (JHC, MXQ)
      BKH = (VHS, QDB)
      KJV = (KTT, LVD)
      DHK = (FPV, NLS)
      NMP = (NGB, PBF)
      GJH = (VCN, CPP)
      FBB = (MJC, VMF)
      CMK = (LGP, GKD)
      VTM = (XST, SRS)
      DHG = (LRR, SNF)
      DBS = (RVX, DCQ)
      GSL = (NBX, JNN)
      XSM = (BHS, HRT)
      JBH = (NSS, FTN)
      DXJ = (XGP, CCR)
      JGS = (JKS, HHZ)
      NTS = (GMG, XFH)
      FHH = (BPG, KRM)
      LBS = (KNL, PGM)
      MQH = (FQB, FQB)
      QVF = (JJT, PRK)
      KSM = (PMS, LLF)
      XQM = (JLC, KTD)
      SXQ = (JXD, NVK)
      GHC = (MGN, VHQ)
      PJK = (CXG, DNR)
      HHP = (NXC, KVM)
      NHK = (XSJ, NHB)
      SLP = (TNJ, JLQ)
      HNK = (XSN, NHK)
      KQX = (DHK, SQV)
      XRX = (BGR, PVS)
      MGH = (RLQ, TBJ)
      FSV = (LKK, DNS)
      NJP = (BGR, PVS)
      PFM = (GRQ, CBJ)
      LCF = (HBJ, TDH)
      CPC = (JLC, KTD)
      CXK = (JGP, JGP)
      LJJ = (SQP, LSQ)
      LNC = (BML, TNN)
      VCN = (TBT, PLK)
      NPF = (FBH, JPD)
      LHR = (VJN, DNC)
      BXJ = (VKV, BLJ)
      KMB = (FSB, KPR)
      CJQ = (QRG, BKX)
      XVK = (PBX, DKQ)
      GTL = (VKF, VJD)
      BXH = (BPG, KRM)
      NGX = (BBS, TTF)
      JXT = (RHH, SVM)
      DMN = (MFS, MFS)
      BKX = (GXR, XCB)
      KTP = (GKT, LVJ)
      LXS = (JHC, MXQ)
      LCM = (KKF, MCK)
      VVL = (FGD, FNT)
      CRC = (DKV, JKG)
      HRJ = (KJF, QTD)
      TSF = (HMJ, CMG)
      HLN = (PCB, HHC)
      VSM = (QCQ, TKC)
      TKV = (XST, SRS)
      PCL = (VCF, VLX)
      QQV = (TRP, QBL)
      FLF = (FJB, RGC)
      MCL = (SCK, HHP)
      GRQ = (VGV, GTL)
      TCT = (JKS, JKS)
      DMQ = (NMC, PDV)
      LMQ = (SXX, FKS)
      XPK = (FKK, CLT)
      CDK = (FRX, BRM)
      JLR = (KGR, TCC)
      TDH = (KFL, LBS)
      XXP = (CML, CLM)
      KCG = (DMN, QGD)
      LTL = (RQH, PTX)
      QVR = (VPC, KXT)
      DRN = (LCC, NLQ)
      NQV = (RFF, FFL)
      PLS = (LQJ, QVR)
      DBF = (QBG, CGS)
      KTT = (HNK, LRN)
      MRL = (HFH, HFT)
      BJG = (PTG, XJX)
      FTQ = (PCD, RMP)
      XQP = (TSC, QQS)
      QCQ = (HRJ, JXV)
      NJX = (XFL, XFX)
      BNJ = (MGB, TGT)
      CKD = (NTT, TBD)
      NKS = (SDB, KQX)
      NRQ = (PLR, NJX)
      MBX = (MXR, GGJ)
      LVS = (GHC, NDR)
      KJF = (DKL, MCL)
      NRV = (DFQ, TRJ)
      DPA = (NBQ, GTR)
      XCH = (LNQ, GSK)
      RHC = (DJT, PND)
      SVM = (XLC, KMB)
      GRF = (VTF, HDR)
      LLF = (TTG, FFV)
      PHV = (FSG, VRJ)
      SGD = (NND, CMK)
      SSP = (GJL, MJN)
      PVL = (PQF, SVL)
      FVT = (BCV, LVT)
      BNX = (SSM, HQR)
      XSV = (JCS, TVQ)
      MCJ = (RGM, GPV)
      XXL = (SCP, XKM)
      XST = (JKB, JFB)
      GSK = (VRM, TCR)
      NKQ = (MLR, LMQ)
      VXQ = (SXQ, TSH)
      GPV = (MVT, VKR)
      RNL = (CQF, KQL)
      VBR = (BFG, MXB)
      MRR = (BKH, VFR)
      GDR = (MMB, HKH)
      MGS = (KMK, NGJ)
      MLQ = (KNX, NNM)
      NGH = (SQR, MGF)
      QRP = (NBR, TCS)
      MKH = (FDN, XHT)
      JLQ = (DTL, PHD)
      JBM = (MJB, MTC)
      DNC = (HJF, GJH)
      QRV = (CCF, FCH)
      TJQ = (XRF, FRB)
      VKR = (FTX, BCG)
      SRS = (JFB, JKB)
      TSK = (CJQ, XFD)
      TGT = (BQX, CNM)
      MDN = (XGD, MKH)
      TVC = (FJB, RGC)
      KCP = (FLF, TVC)
      PMG = (PVL, NDP)
      JHC = (LCF, KJR)
      FMP = (KTL, JCN)
      RBB = (DJD, JLG)
      KQV = (QKN, JDF)
      PFH = (GLP, STP)
      CXP = (VNP, CBG)
      MVG = (TSK, DNK)
      PCN = (QJN, SSP)
      HDR = (CGR, XLF)
      KQL = (BDV, QPF)
      BHJ = (TDJ, XVJ)
      PJD = (FQB, GBN)
      TRF = (HFD, PCM)
      GKT = (FLG, KXQ)
      KRF = (NPF, RVD)
      RMP = (VVL, GXF)
      NBR = (MDN, JBD)
      QBL = (DMQ, QDD)
      VGV = (VKF, VJD)
      XHN = (PBQ, SGR)
      CXG = (BJS, KCP)
      VTD = (KHC, BDL)
      HFK = (FTN, NSS)
      MHD = (DFQ, TRJ)
      RNP = (NQV, QFV)
      QLA = (VXQ, RDX)
      LVD = (LRN, HNK)
      GLQ = (RQK, KJV)
      FPP = (MNG, RNM)
      LXM = (LJX, VCM)
      SSJ = (MKR, SGH)
      JMB = (KPN, CTM)
      JPB = (PNM, DNF)
      XFL = (GKB, XXN)
      HBJ = (LBS, KFL)
      SRM = (KBJ, HLH)
      CRH = (GMG, XFH)
      VFL = (FXD, PMG)
      KCL = (QRR, PNN)
      DNK = (CJQ, XFD)
      RQV = (NLC, MPS)
      TCD = (GMN, RDH)
      BMS = (DTV, VJC)
      BMQ = (KJV, RQK)
      PNM = (MSJ, SBK)
      XSN = (XSJ, NHB)
      JJN = (NBV, DJM)
      TBJ = (GLD, HDV)
      MSJ = (SBV, PJF)
      MFD = (LXM, BKL)
      BCG = (PFM, SDQ)
      BGR = (FXF, KVB)
      KVK = (QSK, JXB)
      LBH = (MPC, PFB)
      QFT = (MPC, PFB)
      BPG = (BJG, MGX)
      XKM = (SML, JPC)
      HMS = (BKR, TJQ)
      MQL = (RQV, PLM)
      SGH = (XXV, RJV)
      GRC = (PLS, NFT)
      NCQ = (FTQ, KCC)
      MKF = (XRX, NJP)
      KGR = (DJG, RBM)
      HJF = (VCN, CPP)
      CGR = (TSF, HDB)
      JFF = (MQH, PJD)
      PXJ = (KQX, SDB)
      DKQ = (MVG, RRC)
      RDH = (KHJ, SBP)
      PVS = (KVB, FXF)
      HTM = (NTJ, MPQ)
      TKF = (PPK, PPK)
      KPB = (PMS, LLF)
      FKK = (PDS, CDK)
      BKR = (XRF, FRB)
      PNN = (NXN, FJP)
      VQK = (JNN, NBX)
      KMG = (TBD, NTT)
      XMZ = (RDX, VXQ)
      BBT = (DTV, VJC)
      GXX = (BKP, KQH)
      FGS = (MXR, GGJ)
      FFV = (SRM, FDJ)
      MQK = (XQP, JHF)
      NHB = (HBD, DXJ)
      SNF = (NCJ, DRN)
      RTH = (JGP, FRG)
      LRN = (XSN, NHK)
      JCN = (DQV, LTL)
      RBT = (HDR, VTF)
      LDC = (TJQ, BKR)
      FJP = (BFF, FML)
      GKD = (RNT, DHG)
      CSD = (NPF, RVD)
      GTR = (RBN, MCG)
      FSG = (XSV, GTH)
      HLB = (XSP, QQT)
      BHN = (PLS, NFT)
      NGJ = (KJP, VSM)
      PJX = (PPK, SKN)
      KPR = (TFG, XJG)
      SFP = (HNG, PHV)
      CGS = (SGD, XBC)
      FLG = (KQV, XSH)
      FDN = (NTS, CRH)
      CLT = (PDS, CDK)
      KRM = (MGX, BJG)
      DTL = (HDM, RNL)
      QDB = (MBK, PCL)
      QDD = (PDV, NMC)
      FXQ = (GFT, HTM)
      TBD = (NTF, FBB)
      RDX = (TSH, SXQ)
      MGX = (PTG, XJX)
      CCF = (BHJ, SMF)
      MVT = (BCG, FTX)
      LVC = (KPB, KSM)
      NFT = (LQJ, QVR)
      MDC = (JFF, TQP)
      SCK = (NXC, KVM)
      FML = (CXP, HDD)
      QCM = (TPJ, MDC)
      VJA = (SCP, XKM)
      PXH = (QGS, VBR)
      KNL = (LPG, HQK)
      MMB = (NRV, MHD)
      HFG = (HKH, MMB)
      LML = (BHS, HRT)
      DPR = (TPJ, MDC)
      GKB = (SJQ, DBF)
      BTC = (SFP, HVH)
      DJT = (PFL, JGM)
      VCK = (KQH, BKP)
      KVB = (NHT, HTX)
      LRJ = (DBS, FLD)
      CCR = (XKG, LNK)
      MGB = (CNM, BQX)
      SDB = (DHK, SQV)
      KMP = (VNT, HBM)
      JGP = (XXL, XXL)
      CLM = (HQB, PJK)
      JKS = (LLS, GVK)
      TBT = (GGP, FHB)
      NTT = (NTF, FBB)
      HRT = (MCJ, LBF)
      BMX = (SGH, MKR)
      HJH = (MDT, BNX)
      DJB = (PMX, NMP)
      CRJ = (MFM, HQQ)
      XXV = (SLP, VQT)
      MXB = (LVF, KKP)
      LXN = (VNT, HBM)
      RMH = (NJG, BKD)
      MLR = (SXX, FKS)
      SQV = (NLS, FPV)
      XKG = (MFD, XFS)
      LVN = (CTM, KPN)
      NTR = (QCM, DPR)
      NTF = (VMF, MJC)
      MGN = (FMP, DLQ)
      PLR = (XFL, XFX)
      SSM = (RTX, KDD)
      GBB = (RLQ, TBJ)
      VTF = (XLF, CGR)
      SHQ = (JLR, XGK)
      CXX = (GMN, RDH)
      FLD = (DCQ, RVX)
      QPF = (CXD, SHQ)
      RDR = (TCH, QKP)
      GSC = (MGS, DRQ)
      GTA = (XND, NGX)
      VHQ = (FMP, DLQ)
      MRF = (VKV, BLJ)
      XCB = (SMD, QRV)
      NBV = (MKF, GGB)
      SBK = (PJF, SBV)
      XRF = (CBT, SMB)
      TPJ = (JFF, TQP)
      KDD = (BGD, MQK)
      DKV = (KFM, NTR)
      FBH = (MBX, FGS)
      RGH = (PGN, BQV)
      FXS = (RJC, JJN)
      SVL = (LKD, XXP)
      JXS = (NKS, PXJ)
      SMX = (LKK, DNS)
      QTD = (DKL, MCL)
      CPT = (PGN, BQV)
      BDV = (CXD, SHQ)
      BFG = (KKP, LVF)
      PSM = (DKJ, XVK)
      CBJ = (GTL, VGV)
      XJG = (LXN, KMP)
      MPH = (GSS, RHC)
      KFM = (DPR, QCM)
      SQR = (XPK, NDN)
      VJC = (VFB, JCJ)
      DQV = (PTX, RQH)
      FJB = (VVJ, PSM)
      RQK = (KTT, LVD)
      PDV = (TRF, TPC)
      KNQ = (TKF, PJX)
      HHC = (XPM, MLQ)
      RHX = (PLM, RQV)
      GXR = (SMD, QRV)
      HMJ = (VCK, GXX)
      JJT = (TCT, TCT)
      XLF = (HDB, TSF)
      RFF = (XXQ, QLN)
      GFT = (NTJ, MPQ)
      LQK = (KSM, KPB)
      TXD = (PNN, QRR)
      KBS = (XGS, BJF)
      NLS = (GRF, RBT)
      RFL = (BKD, NJG)
      MPS = (LRJ, TTL)
      DCQ = (PFH, GNX)
      FXF = (HTX, NHT)
      BGD = (JHF, XQP)
      NBX = (MRF, BXJ)
      LKD = (CML, CLM)
      VJN = (GJH, HJF)
      TCC = (RBM, DJG)
      NXN = (BFF, FML)
      DTB = (SSP, QJN)
      HRV = (MDM, QNF)
      LNK = (XFS, MFD)
      KHJ = (FPP, RLV)
      MKR = (XXV, RJV)
      LQJ = (KXT, VPC)
      HDM = (KQL, CQF)
      PTX = (LQK, LVC)
      PJF = (JBM, HPG)
      RNT = (LRR, SNF)
      RKP = (JJN, RJC)
      JCH = (SBR, XVT)
      MJF = (XPT, ZZZ)
      DXN = (TGT, MGB)
      VST = (NXP, KVK)
      NJF = (MCK, KKF)
      KGT = (HQQ, MFM)
      SXX = (BTH, QQV)
      PCD = (GXF, VVL)
      PXF = (TTQ, HJH)
      FPV = (RBT, GRF)
      LKK = (SCV, SCV)
      KTL = (LTL, DQV)
      QKP = (FHH, BXH)
      TLQ = (JMB, LVN)
      MNG = (PBM, MPV)
      AAA = (GVD, NTL)
      JFB = (MPH, LPX)
      VTT = (HFH, HFT)
      RDS = (MGF, SQR)
      FGD = (RDR, HRF)
      CQF = (QPF, BDV)
      TCR = (CPT, RGH)
      HVH = (PHV, HNG)
      DNF = (MSJ, SBK)
      MGG = (RQQ, FQS)
      GGB = (XRX, NJP)
      FFL = (XXQ, QLN)
      VCF = (GSB, JXT)
      TNN = (RKP, FXS)
      LLV = (LTJ, NCB)
      HQQ = (XMD, QRP)
      LQG = (MRR, RKM)
      GHM = (KBS, BCN)
      JXD = (CSD, KRF)
      RKT = (PBQ, SGR)
      QKL = (CKP, JXS)
      BKD = (LJJ, JKM)
      SBP = (FPP, RLV)
      SKN = (DSQ, JHM)
      JLC = (HLN, VML)
      JPD = (MBX, FGS)
      JLG = (HQD, LVS)
      NJG = (LJJ, JKM)
      TCS = (MDN, JBD)
      VKV = (KCL, TXD)
      MCG = (MGH, GBB)
      BJF = (HRC, QNX)
      PHD = (HDM, RNL)
      MHF = (JXS, CKP)
      FTN = (MQL, RHX)
      PLG = (NJX, PLR)
      RLV = (MNG, RNM)
      XJX = (GSC, SFM)
      GVD = (BMX, SSJ)
      JHF = (QQS, TSC)
      NVK = (KRF, CSD)
      RVX = (PFH, GNX)
      HNG = (FSG, VRJ)
      MDT = (SSM, HQR)
      TFG = (LXN, KMP)
      DSQ = (KSV, KSV)
      RXR = (TNN, BML)
      KCC = (PCD, RMP)
      TTG = (SRM, FDJ)
      VML = (HHC, PCB)
      HDB = (HMJ, CMG)
      PFN = (NCB, LTJ)
      JXB = (JCH, HHB)
      XVJ = (BBT, BMS)
      FDS = (RQG, RNP)
      RJH = (VBR, QGS)
      GLD = (RKH, BBX)
      PLK = (FHB, GGP)
      RCM = (PJJ, NLH)
      HRC = (RFN, CRC)
      RGM = (MVT, VKR)
      DLQ = (JCN, KTL)
      NTL = (SSJ, BMX)
      KKP = (LBH, QFT)
      RQH = (LQK, LVC)
      CTM = (QKL, MHF)
      FRG = (XXL, GLZ)
      VLX = (GSB, JXT)
      QGD = (MFS, RLL)
      LCC = (CPC, XQM)
      TSC = (HJB, RRQ)
      JGM = (PLG, NRQ)
      KPN = (QKL, MHF)
      VMF = (CRJ, KGT)
      STP = (DXN, BNJ)
      LPG = (NVR, NKQ)
      VFB = (RCM, BNV)
      HLD = (RQQ, FQS)
      VHM = (PNM, DNF)
      PFB = (JMM, FVT)
      RKM = (BKH, VFR)
      CVJ = (TKF, PJX)
      NCJ = (NLQ, LCC)
      LBD = (MRL, VTT)
      HHB = (XVT, SBR)
      JDF = (LXS, QXR)
      BTH = (QBL, TRP)
      QDP = (DKX, XMZ)
      DKJ = (PBX, DKQ)
      PDS = (FRX, BRM)
      DJM = (MKF, GGB)
      HFH = (VQK, GSL)
      QNX = (RFN, CRC)
      RFN = (DKV, JKG)
      LDX = (VST, QKJ)
      TJK = (SQQ, LSH)
      NLQ = (XQM, CPC)
      LVT = (XNC, VFL)
      PJJ = (FPG, QVF)
      XGS = (QNX, HRC)
      GTH = (JCS, TVQ)
      SMB = (PCN, DTB)
      SBV = (JBM, HPG)
      MBK = (VLX, VCF)
      STL = (CXK, RTH)
      PQF = (LKD, XXP)
      KNX = (NLM, XCV)
      XBC = (NND, CMK)
      VHS = (PCL, MBK)
      GLZ = (XKM, SCP)
      NHT = (SMX, FSV)
      HTX = (SMX, FSV)
      MDM = (LTV, KTP)
      BHS = (MCJ, LBF)
      PDP = (VMD, FXV)
      SFM = (DRQ, MGS)
      HDD = (CBG, VNP)
      RVD = (JPD, FBH)
      DTV = (VFB, JCJ)
      PMX = (NGB, PBF)
      RLL = (KXL, MJF)
      PCB = (MLQ, XPM)
      PBF = (HRV, FCN)
      VRJ = (XSV, GTH)
      QSK = (JCH, HHB)
      RRQ = (RMH, RFL)
      KBJ = (GHM, FQL)
      FRB = (CBT, SMB)
      KHC = (PXH, RJH)
      JNN = (MRF, BXJ)
      BRM = (VBB, BTC)
      FRX = (VBB, BTC)
      NXC = (SGJ, RBB)
      NTJ = (FMS, LHR)
      QVQ = (QKJ, VST)
      BBX = (TJK, XNH)
      VKF = (HMS, LDC)
      HQB = (CXG, DNR)
      RJC = (DJM, NBV)
      NND = (LGP, GKD)
      VVJ = (DKJ, XVK)
      LBF = (GPV, RGM)
      RHH = (KMB, XLC)
      HQD = (GHC, NDR)
      VMD = (NGH, RDS)
      JKG = (KFM, NTR)
      XGK = (TCC, KGR)
      VJD = (LDC, HMS)
      FDJ = (HLH, KBJ)
      KXQ = (XSH, KQV)
      GLP = (BNJ, DXN)
      SGJ = (JLG, DJD)
      JPC = (MGG, HLD)
      XFX = (XXN, GKB)
      PBX = (RRC, MVG)
      GBN = (RKX, QDP)
      PRG = (KCC, FTQ)
      RJV = (VQT, SLP)
      HBM = (VHM, JPB)
      XVT = (RGS, LBD)
      CPP = (TBT, PLK)
      QKN = (LXS, QXR)
      MJB = (TKV, VTM)
      BQX = (KMG, CKD)
      MXQ = (LCF, KJR)
      KXT = (FDS, DPS)
      XQA = (LLS, GVK)
      TRP = (DMQ, QDD)
      TTF = (PDP, PHC)
      SMF = (TDJ, XVJ)
      CHG = (GFT, HTM)
      LSH = (LQG, BQF)
      JXV = (KJF, QTD)
      RLQ = (HDV, GLD)
      GXF = (FNT, FGD)
      PFL = (NRQ, PLG)
      HFT = (VQK, GSL)
      JHM = (KSV, NGZ)
      NNM = (XCV, NLM)
      RTX = (MQK, BGD)
      RGC = (VVJ, PSM)
      LNQ = (VRM, TCR)
      GNX = (STP, GLP)
      MGF = (XPK, NDN)
      SQQ = (BQF, LQG)
      TNJ = (DTL, PHD)
      TDD = (MHT, TMT)
      BQF = (MRR, RKM)
      DRQ = (NGJ, KMK)
      HRF = (TCH, QKP)
      NLC = (TTL, LRJ)
      RBN = (MGH, GBB)
      NGZ = (GTR, NBQ)
      QPJ = (CXK, CXK)
      XMD = (NBR, TCS)
      TMT = (TQB, FXZ)
      QKJ = (NXP, KVK)
    """.trimIndent()

  }
}