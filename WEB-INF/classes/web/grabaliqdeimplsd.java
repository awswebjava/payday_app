package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabaliqdeimplsd extends GXProcedure
{
   public grabaliqdeimplsd( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabaliqdeimplsd.class ), "" );
   }

   public grabaliqdeimplsd( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        String aP10 ,
                        String aP11 ,
                        String aP12 ,
                        String aP13 ,
                        String aP14 ,
                        String aP15 ,
                        String aP16 ,
                        String aP17 ,
                        String aP18 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             String aP15 ,
                             String aP16 ,
                             String aP17 ,
                             String aP18 )
   {
      grabaliqdeimplsd.this.AV26CliCod = aP0;
      grabaliqdeimplsd.this.AV25EmpCod = aP1;
      grabaliqdeimplsd.this.AV24ImpLiqSec = aP2;
      grabaliqdeimplsd.this.AV9ImpLiqDetSCVO = aP3;
      grabaliqdeimplsd.this.AV10ImpLiqDetCCT = aP4;
      grabaliqdeimplsd.this.AV11ImpLiqDetHijos = aP5;
      grabaliqdeimplsd.this.AV12ImpLiqDetConyu = aP6;
      grabaliqdeimplsd.this.AV13ImpLiqDetSigno = aP7;
      grabaliqdeimplsd.this.AV14ImpLiqDetImp = aP8;
      grabaliqdeimplsd.this.AV15ImpLiqDetUni = aP9;
      grabaliqdeimplsd.this.AV16ImpLiqDetConCod = aP10;
      grabaliqdeimplsd.this.AV17ImpLiqDetCant = aP11;
      grabaliqdeimplsd.this.AV18ImpLiqDetCBU = aP12;
      grabaliqdeimplsd.this.AV19ImpLiqDetLegId = aP13;
      grabaliqdeimplsd.this.AV20ImpLiqDetCUIL = aP14;
      grabaliqdeimplsd.this.AV21ImpLiqDetLiqN = aP15;
      grabaliqdeimplsd.this.AV22ImpLiqDetPer = aP16;
      grabaliqdeimplsd.this.AV40ImpLiqDetLiqClase = aP17;
      grabaliqdeimplsd.this.AV41ImpLiqDetTipoCon = aP18;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV32ImpLiqDetLegSis ;
      GXv_char2[0] = AV34ImpLiqDetConSis ;
      GXv_char3[0] = AV35ImpLiqDetConSisYDes ;
      GXv_char4[0] = AV42ImpLiqConAfipCod ;
      GXv_char5[0] = AV44ImpLiqConExtDescrip ;
      GXv_char6[0] = AV8ImpLiqDetError ;
      new web.liqdetimplsd_validar(remoteHandle, context).execute( AV26CliCod, AV25EmpCod, AV24ImpLiqSec, AV16ImpLiqDetConCod, AV20ImpLiqDetCUIL, AV22ImpLiqDetPer, GXv_char1, GXv_char2, GXv_char3, GXv_char4, GXv_char5, GXv_char6) ;
      grabaliqdeimplsd.this.AV32ImpLiqDetLegSis = GXv_char1[0] ;
      grabaliqdeimplsd.this.AV34ImpLiqDetConSis = GXv_char2[0] ;
      grabaliqdeimplsd.this.AV35ImpLiqDetConSisYDes = GXv_char3[0] ;
      grabaliqdeimplsd.this.AV42ImpLiqConAfipCod = GXv_char4[0] ;
      grabaliqdeimplsd.this.AV44ImpLiqConExtDescrip = GXv_char5[0] ;
      grabaliqdeimplsd.this.AV8ImpLiqDetError = GXv_char6[0] ;
      GXv_char6[0] = AV41ImpLiqDetTipoCon ;
      new web.getafipconceptotipo(remoteHandle, context).execute( AV42ImpLiqConAfipCod, GXv_char6) ;
      grabaliqdeimplsd.this.AV41ImpLiqDetTipoCon = GXv_char6[0] ;
      /* Using cursor P00OC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV26CliCod), Short.valueOf(AV25EmpCod), Short.valueOf(AV24ImpLiqSec), AV21ImpLiqDetLiqN, AV22ImpLiqDetPer, AV20ImpLiqDetCUIL, AV16ImpLiqDetConCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A666ImpLiqDetConCod = P00OC2_A666ImpLiqDetConCod[0] ;
         A663ImpLiqDetCUIL = P00OC2_A663ImpLiqDetCUIL[0] ;
         A662ImpLiqDetLiqN = P00OC2_A662ImpLiqDetLiqN[0] ;
         A661ImpLiqDetPer = P00OC2_A661ImpLiqDetPer[0] ;
         A88ImpLiqSec = P00OC2_A88ImpLiqSec[0] ;
         A1EmpCod = P00OC2_A1EmpCod[0] ;
         A3CliCod = P00OC2_A3CliCod[0] ;
         A664ImpLiqDetLegId = P00OC2_A664ImpLiqDetLegId[0] ;
         A665ImpLiqDetCBU = P00OC2_A665ImpLiqDetCBU[0] ;
         A667ImpLiqDetCant = P00OC2_A667ImpLiqDetCant[0] ;
         A668ImpLiqDetUni = P00OC2_A668ImpLiqDetUni[0] ;
         A669ImpLiqDetImp = P00OC2_A669ImpLiqDetImp[0] ;
         A670ImpLiqDetSigno = P00OC2_A670ImpLiqDetSigno[0] ;
         A671ImpLiqDetConyu = P00OC2_A671ImpLiqDetConyu[0] ;
         A672ImpLiqDetHijos = P00OC2_A672ImpLiqDetHijos[0] ;
         A673ImpLiqDetCCT = P00OC2_A673ImpLiqDetCCT[0] ;
         A674ImpLiqDetSCVO = P00OC2_A674ImpLiqDetSCVO[0] ;
         A709ImpLiqDetError = P00OC2_A709ImpLiqDetError[0] ;
         A712ImpLiqDetLegSis = P00OC2_A712ImpLiqDetLegSis[0] ;
         A713ImpLiqDetConSis = P00OC2_A713ImpLiqDetConSis[0] ;
         A714ImpLiqDetConSisYDes = P00OC2_A714ImpLiqDetConSisYDes[0] ;
         A715ImpLiqDetCantNum = P00OC2_A715ImpLiqDetCantNum[0] ;
         A716ImpLiqDetImpNum = P00OC2_A716ImpLiqDetImpNum[0] ;
         A718ImpLiqDetLiqClase = P00OC2_A718ImpLiqDetLiqClase[0] ;
         A2184ImpLiqDetTipoCon = P00OC2_A2184ImpLiqDetTipoCon[0] ;
         A2188ImpLiqDetConYDes = P00OC2_A2188ImpLiqDetConYDes[0] ;
         A90ImpLiqDetSec = P00OC2_A90ImpLiqDetSec[0] ;
         A664ImpLiqDetLegId = AV19ImpLiqDetLegId ;
         A665ImpLiqDetCBU = AV18ImpLiqDetCBU ;
         A667ImpLiqDetCant = AV17ImpLiqDetCant ;
         A668ImpLiqDetUni = AV15ImpLiqDetUni ;
         A669ImpLiqDetImp = AV14ImpLiqDetImp ;
         A670ImpLiqDetSigno = AV13ImpLiqDetSigno ;
         A671ImpLiqDetConyu = AV12ImpLiqDetConyu ;
         A672ImpLiqDetHijos = AV11ImpLiqDetHijos ;
         A673ImpLiqDetCCT = AV10ImpLiqDetCCT ;
         A674ImpLiqDetSCVO = AV9ImpLiqDetSCVO ;
         A709ImpLiqDetError = AV8ImpLiqDetError ;
         A712ImpLiqDetLegSis = AV32ImpLiqDetLegSis ;
         A713ImpLiqDetConSis = GXutil.trim( AV34ImpLiqDetConSis) ;
         A714ImpLiqDetConSisYDes = AV35ImpLiqDetConSisYDes ;
         GXt_decimal7 = A715ImpLiqDetCantNum ;
         GXv_decimal8[0] = GXt_decimal7 ;
         new web.planoadecimales(remoteHandle, context).execute( A667ImpLiqDetCant, GXv_decimal8) ;
         grabaliqdeimplsd.this.GXt_decimal7 = GXv_decimal8[0] ;
         A715ImpLiqDetCantNum = GXt_decimal7 ;
         GXt_decimal7 = A716ImpLiqDetImpNum ;
         GXv_decimal8[0] = GXt_decimal7 ;
         new web.planoadecimales(remoteHandle, context).execute( A669ImpLiqDetImp, GXv_decimal8) ;
         grabaliqdeimplsd.this.GXt_decimal7 = GXv_decimal8[0] ;
         A716ImpLiqDetImpNum = GXt_decimal7 ;
         A718ImpLiqDetLiqClase = AV40ImpLiqDetLiqClase ;
         A2184ImpLiqDetTipoCon = AV41ImpLiqDetTipoCon ;
         A2188ImpLiqDetConYDes = GXutil.trim( AV16ImpLiqDetConCod) + " - " + GXutil.trim( AV44ImpLiqConExtDescrip) ;
         AV31actualizo = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P00OC3 */
         pr_default.execute(1, new Object[] {A664ImpLiqDetLegId, A665ImpLiqDetCBU, A667ImpLiqDetCant, A668ImpLiqDetUni, A669ImpLiqDetImp, A670ImpLiqDetSigno, A671ImpLiqDetConyu, A672ImpLiqDetHijos, A673ImpLiqDetCCT, A674ImpLiqDetSCVO, A709ImpLiqDetError, A712ImpLiqDetLegSis, A713ImpLiqDetConSis, A714ImpLiqDetConSisYDes, A715ImpLiqDetCantNum, A716ImpLiqDetImpNum, A718ImpLiqDetLiqClase, A2184ImpLiqDetTipoCon, A2188ImpLiqDetConYDes, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A90ImpLiqDetSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_detalle");
         if (true) break;
         /* Using cursor P00OC4 */
         pr_default.execute(2, new Object[] {A664ImpLiqDetLegId, A665ImpLiqDetCBU, A667ImpLiqDetCant, A668ImpLiqDetUni, A669ImpLiqDetImp, A670ImpLiqDetSigno, A671ImpLiqDetConyu, A672ImpLiqDetHijos, A673ImpLiqDetCCT, A674ImpLiqDetSCVO, A709ImpLiqDetError, A712ImpLiqDetLegSis, A713ImpLiqDetConSis, A714ImpLiqDetConSisYDes, A715ImpLiqDetCantNum, A716ImpLiqDetImpNum, A718ImpLiqDetLiqClase, A2184ImpLiqDetTipoCon, A2188ImpLiqDetConYDes, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A90ImpLiqDetSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_detalle");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( ! AV31actualizo )
      {
         AV23ImpLiqDetSec = (short)(0) ;
         /* Using cursor P00OC5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(AV26CliCod), Short.valueOf(AV25EmpCod), Short.valueOf(AV24ImpLiqSec)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A3CliCod = P00OC5_A3CliCod[0] ;
            A1EmpCod = P00OC5_A1EmpCod[0] ;
            A88ImpLiqSec = P00OC5_A88ImpLiqSec[0] ;
            A90ImpLiqDetSec = P00OC5_A90ImpLiqDetSec[0] ;
            AV23ImpLiqDetSec = A90ImpLiqDetSec ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(3);
         }
         pr_default.close(3);
         AV23ImpLiqDetSec = (short)(AV23ImpLiqDetSec+1) ;
         /*
            INSERT RECORD ON TABLE importacion_liquidacion_detalle

         */
         A3CliCod = AV26CliCod ;
         A1EmpCod = AV25EmpCod ;
         A88ImpLiqSec = AV24ImpLiqSec ;
         A90ImpLiqDetSec = AV23ImpLiqDetSec ;
         A661ImpLiqDetPer = AV22ImpLiqDetPer ;
         A662ImpLiqDetLiqN = AV21ImpLiqDetLiqN ;
         A663ImpLiqDetCUIL = AV20ImpLiqDetCUIL ;
         A664ImpLiqDetLegId = AV19ImpLiqDetLegId ;
         A665ImpLiqDetCBU = AV18ImpLiqDetCBU ;
         A666ImpLiqDetConCod = AV16ImpLiqDetConCod ;
         A2188ImpLiqDetConYDes = GXutil.trim( AV16ImpLiqDetConCod) + " - " + GXutil.trim( AV44ImpLiqConExtDescrip) ;
         A667ImpLiqDetCant = AV17ImpLiqDetCant ;
         A668ImpLiqDetUni = AV15ImpLiqDetUni ;
         A669ImpLiqDetImp = AV14ImpLiqDetImp ;
         A670ImpLiqDetSigno = AV13ImpLiqDetSigno ;
         A671ImpLiqDetConyu = AV12ImpLiqDetConyu ;
         A672ImpLiqDetHijos = AV11ImpLiqDetHijos ;
         A673ImpLiqDetCCT = AV10ImpLiqDetCCT ;
         A674ImpLiqDetSCVO = AV9ImpLiqDetSCVO ;
         A709ImpLiqDetError = AV8ImpLiqDetError ;
         A712ImpLiqDetLegSis = AV32ImpLiqDetLegSis ;
         A713ImpLiqDetConSis = AV34ImpLiqDetConSis ;
         A714ImpLiqDetConSisYDes = AV35ImpLiqDetConSisYDes ;
         GXt_decimal7 = A715ImpLiqDetCantNum ;
         GXv_decimal8[0] = GXt_decimal7 ;
         new web.planoadecimales(remoteHandle, context).execute( A667ImpLiqDetCant, GXv_decimal8) ;
         grabaliqdeimplsd.this.GXt_decimal7 = GXv_decimal8[0] ;
         A715ImpLiqDetCantNum = GXt_decimal7 ;
         GXt_decimal7 = A716ImpLiqDetImpNum ;
         GXv_decimal8[0] = GXt_decimal7 ;
         new web.planoadecimales(remoteHandle, context).execute( A669ImpLiqDetImp, GXv_decimal8) ;
         grabaliqdeimplsd.this.GXt_decimal7 = GXv_decimal8[0] ;
         A716ImpLiqDetImpNum = GXt_decimal7 ;
         A718ImpLiqDetLiqClase = AV40ImpLiqDetLiqClase ;
         A2184ImpLiqDetTipoCon = AV41ImpLiqDetTipoCon ;
         /* Using cursor P00OC6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A90ImpLiqDetSec), A661ImpLiqDetPer, A662ImpLiqDetLiqN, A663ImpLiqDetCUIL, A664ImpLiqDetLegId, A665ImpLiqDetCBU, A666ImpLiqDetConCod, A667ImpLiqDetCant, A668ImpLiqDetUni, A669ImpLiqDetImp, A670ImpLiqDetSigno, A671ImpLiqDetConyu, A672ImpLiqDetHijos, A673ImpLiqDetCCT, A674ImpLiqDetSCVO, A709ImpLiqDetError, A712ImpLiqDetLegSis, A713ImpLiqDetConSis, A714ImpLiqDetConSisYDes, A715ImpLiqDetCantNum, A716ImpLiqDetImpNum, A718ImpLiqDetLiqClase, A2188ImpLiqDetConYDes, A2184ImpLiqDetTipoCon});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_detalle");
         if ( (pr_default.getStatus(4) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "grabaliqdeimplsd");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV32ImpLiqDetLegSis = "" ;
      GXv_char1 = new String[1] ;
      AV34ImpLiqDetConSis = "" ;
      GXv_char2 = new String[1] ;
      AV35ImpLiqDetConSisYDes = "" ;
      GXv_char3 = new String[1] ;
      AV42ImpLiqConAfipCod = "" ;
      GXv_char4 = new String[1] ;
      AV44ImpLiqConExtDescrip = "" ;
      GXv_char5 = new String[1] ;
      AV8ImpLiqDetError = "" ;
      GXv_char6 = new String[1] ;
      scmdbuf = "" ;
      P00OC2_A666ImpLiqDetConCod = new String[] {""} ;
      P00OC2_A663ImpLiqDetCUIL = new String[] {""} ;
      P00OC2_A662ImpLiqDetLiqN = new String[] {""} ;
      P00OC2_A661ImpLiqDetPer = new String[] {""} ;
      P00OC2_A88ImpLiqSec = new short[1] ;
      P00OC2_A1EmpCod = new short[1] ;
      P00OC2_A3CliCod = new int[1] ;
      P00OC2_A664ImpLiqDetLegId = new String[] {""} ;
      P00OC2_A665ImpLiqDetCBU = new String[] {""} ;
      P00OC2_A667ImpLiqDetCant = new String[] {""} ;
      P00OC2_A668ImpLiqDetUni = new String[] {""} ;
      P00OC2_A669ImpLiqDetImp = new String[] {""} ;
      P00OC2_A670ImpLiqDetSigno = new String[] {""} ;
      P00OC2_A671ImpLiqDetConyu = new String[] {""} ;
      P00OC2_A672ImpLiqDetHijos = new String[] {""} ;
      P00OC2_A673ImpLiqDetCCT = new String[] {""} ;
      P00OC2_A674ImpLiqDetSCVO = new String[] {""} ;
      P00OC2_A709ImpLiqDetError = new String[] {""} ;
      P00OC2_A712ImpLiqDetLegSis = new String[] {""} ;
      P00OC2_A713ImpLiqDetConSis = new String[] {""} ;
      P00OC2_A714ImpLiqDetConSisYDes = new String[] {""} ;
      P00OC2_A715ImpLiqDetCantNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00OC2_A716ImpLiqDetImpNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00OC2_A718ImpLiqDetLiqClase = new String[] {""} ;
      P00OC2_A2184ImpLiqDetTipoCon = new String[] {""} ;
      P00OC2_A2188ImpLiqDetConYDes = new String[] {""} ;
      P00OC2_A90ImpLiqDetSec = new short[1] ;
      A666ImpLiqDetConCod = "" ;
      A663ImpLiqDetCUIL = "" ;
      A662ImpLiqDetLiqN = "" ;
      A661ImpLiqDetPer = "" ;
      A664ImpLiqDetLegId = "" ;
      A665ImpLiqDetCBU = "" ;
      A667ImpLiqDetCant = "" ;
      A668ImpLiqDetUni = "" ;
      A669ImpLiqDetImp = "" ;
      A670ImpLiqDetSigno = "" ;
      A671ImpLiqDetConyu = "" ;
      A672ImpLiqDetHijos = "" ;
      A673ImpLiqDetCCT = "" ;
      A674ImpLiqDetSCVO = "" ;
      A709ImpLiqDetError = "" ;
      A712ImpLiqDetLegSis = "" ;
      A713ImpLiqDetConSis = "" ;
      A714ImpLiqDetConSisYDes = "" ;
      A715ImpLiqDetCantNum = DecimalUtil.ZERO ;
      A716ImpLiqDetImpNum = DecimalUtil.ZERO ;
      A718ImpLiqDetLiqClase = "" ;
      A2184ImpLiqDetTipoCon = "" ;
      A2188ImpLiqDetConYDes = "" ;
      P00OC5_A3CliCod = new int[1] ;
      P00OC5_A1EmpCod = new short[1] ;
      P00OC5_A88ImpLiqSec = new short[1] ;
      P00OC5_A90ImpLiqDetSec = new short[1] ;
      GXt_decimal7 = DecimalUtil.ZERO ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabaliqdeimplsd__default(),
         new Object[] {
             new Object[] {
            P00OC2_A666ImpLiqDetConCod, P00OC2_A663ImpLiqDetCUIL, P00OC2_A662ImpLiqDetLiqN, P00OC2_A661ImpLiqDetPer, P00OC2_A88ImpLiqSec, P00OC2_A1EmpCod, P00OC2_A3CliCod, P00OC2_A664ImpLiqDetLegId, P00OC2_A665ImpLiqDetCBU, P00OC2_A667ImpLiqDetCant,
            P00OC2_A668ImpLiqDetUni, P00OC2_A669ImpLiqDetImp, P00OC2_A670ImpLiqDetSigno, P00OC2_A671ImpLiqDetConyu, P00OC2_A672ImpLiqDetHijos, P00OC2_A673ImpLiqDetCCT, P00OC2_A674ImpLiqDetSCVO, P00OC2_A709ImpLiqDetError, P00OC2_A712ImpLiqDetLegSis, P00OC2_A713ImpLiqDetConSis,
            P00OC2_A714ImpLiqDetConSisYDes, P00OC2_A715ImpLiqDetCantNum, P00OC2_A716ImpLiqDetImpNum, P00OC2_A718ImpLiqDetLiqClase, P00OC2_A2184ImpLiqDetTipoCon, P00OC2_A2188ImpLiqDetConYDes, P00OC2_A90ImpLiqDetSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P00OC5_A3CliCod, P00OC5_A1EmpCod, P00OC5_A88ImpLiqSec, P00OC5_A90ImpLiqDetSec
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV25EmpCod ;
   private short AV24ImpLiqSec ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short A90ImpLiqDetSec ;
   private short AV23ImpLiqDetSec ;
   private short Gx_err ;
   private int AV26CliCod ;
   private int A3CliCod ;
   private int GX_INS78 ;
   private java.math.BigDecimal A715ImpLiqDetCantNum ;
   private java.math.BigDecimal A716ImpLiqDetImpNum ;
   private java.math.BigDecimal GXt_decimal7 ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private String AV9ImpLiqDetSCVO ;
   private String AV10ImpLiqDetCCT ;
   private String AV11ImpLiqDetHijos ;
   private String AV12ImpLiqDetConyu ;
   private String AV13ImpLiqDetSigno ;
   private String AV14ImpLiqDetImp ;
   private String AV15ImpLiqDetUni ;
   private String AV16ImpLiqDetConCod ;
   private String AV17ImpLiqDetCant ;
   private String AV19ImpLiqDetLegId ;
   private String AV20ImpLiqDetCUIL ;
   private String AV21ImpLiqDetLiqN ;
   private String AV22ImpLiqDetPer ;
   private String AV40ImpLiqDetLiqClase ;
   private String AV41ImpLiqDetTipoCon ;
   private String GXv_char1[] ;
   private String AV34ImpLiqDetConSis ;
   private String GXv_char2[] ;
   private String GXv_char3[] ;
   private String AV42ImpLiqConAfipCod ;
   private String GXv_char4[] ;
   private String GXv_char5[] ;
   private String GXv_char6[] ;
   private String scmdbuf ;
   private String A666ImpLiqDetConCod ;
   private String A663ImpLiqDetCUIL ;
   private String A662ImpLiqDetLiqN ;
   private String A661ImpLiqDetPer ;
   private String A664ImpLiqDetLegId ;
   private String A667ImpLiqDetCant ;
   private String A668ImpLiqDetUni ;
   private String A669ImpLiqDetImp ;
   private String A670ImpLiqDetSigno ;
   private String A671ImpLiqDetConyu ;
   private String A672ImpLiqDetHijos ;
   private String A673ImpLiqDetCCT ;
   private String A674ImpLiqDetSCVO ;
   private String A713ImpLiqDetConSis ;
   private String A718ImpLiqDetLiqClase ;
   private String A2184ImpLiqDetTipoCon ;
   private String Gx_emsg ;
   private boolean AV31actualizo ;
   private String AV18ImpLiqDetCBU ;
   private String AV32ImpLiqDetLegSis ;
   private String AV35ImpLiqDetConSisYDes ;
   private String AV44ImpLiqConExtDescrip ;
   private String AV8ImpLiqDetError ;
   private String A665ImpLiqDetCBU ;
   private String A709ImpLiqDetError ;
   private String A712ImpLiqDetLegSis ;
   private String A714ImpLiqDetConSisYDes ;
   private String A2188ImpLiqDetConYDes ;
   private IDataStoreProvider pr_default ;
   private String[] P00OC2_A666ImpLiqDetConCod ;
   private String[] P00OC2_A663ImpLiqDetCUIL ;
   private String[] P00OC2_A662ImpLiqDetLiqN ;
   private String[] P00OC2_A661ImpLiqDetPer ;
   private short[] P00OC2_A88ImpLiqSec ;
   private short[] P00OC2_A1EmpCod ;
   private int[] P00OC2_A3CliCod ;
   private String[] P00OC2_A664ImpLiqDetLegId ;
   private String[] P00OC2_A665ImpLiqDetCBU ;
   private String[] P00OC2_A667ImpLiqDetCant ;
   private String[] P00OC2_A668ImpLiqDetUni ;
   private String[] P00OC2_A669ImpLiqDetImp ;
   private String[] P00OC2_A670ImpLiqDetSigno ;
   private String[] P00OC2_A671ImpLiqDetConyu ;
   private String[] P00OC2_A672ImpLiqDetHijos ;
   private String[] P00OC2_A673ImpLiqDetCCT ;
   private String[] P00OC2_A674ImpLiqDetSCVO ;
   private String[] P00OC2_A709ImpLiqDetError ;
   private String[] P00OC2_A712ImpLiqDetLegSis ;
   private String[] P00OC2_A713ImpLiqDetConSis ;
   private String[] P00OC2_A714ImpLiqDetConSisYDes ;
   private java.math.BigDecimal[] P00OC2_A715ImpLiqDetCantNum ;
   private java.math.BigDecimal[] P00OC2_A716ImpLiqDetImpNum ;
   private String[] P00OC2_A718ImpLiqDetLiqClase ;
   private String[] P00OC2_A2184ImpLiqDetTipoCon ;
   private String[] P00OC2_A2188ImpLiqDetConYDes ;
   private short[] P00OC2_A90ImpLiqDetSec ;
   private int[] P00OC5_A3CliCod ;
   private short[] P00OC5_A1EmpCod ;
   private short[] P00OC5_A88ImpLiqSec ;
   private short[] P00OC5_A90ImpLiqDetSec ;
}

final  class grabaliqdeimplsd__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00OC2", "SELECT ImpLiqDetConCod, ImpLiqDetCUIL, ImpLiqDetLiqN, ImpLiqDetPer, ImpLiqSec, EmpCod, CliCod, ImpLiqDetLegId, ImpLiqDetCBU, ImpLiqDetCant, ImpLiqDetUni, ImpLiqDetImp, ImpLiqDetSigno, ImpLiqDetConyu, ImpLiqDetHijos, ImpLiqDetCCT, ImpLiqDetSCVO, ImpLiqDetError, ImpLiqDetLegSis, ImpLiqDetConSis, ImpLiqDetConSisYDes, ImpLiqDetCantNum, ImpLiqDetImpNum, ImpLiqDetLiqClase, ImpLiqDetTipoCon, ImpLiqDetConYDes, ImpLiqDetSec FROM importacion_liquidacion_detalle WHERE (CliCod = ? and EmpCod = ? and ImpLiqSec = ? and ImpLiqDetLiqN = ( ?)) AND (ImpLiqDetPer = ( ?)) AND (ImpLiqDetCUIL = ( ?)) AND (ImpLiqDetConCod = ( ?)) ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqDetLiqN  LIMIT 1 FOR UPDATE OF importacion_liquidacion_detalle",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00OC3", "SAVEPOINT gxupdate;UPDATE importacion_liquidacion_detalle SET ImpLiqDetLegId=?, ImpLiqDetCBU=?, ImpLiqDetCant=?, ImpLiqDetUni=?, ImpLiqDetImp=?, ImpLiqDetSigno=?, ImpLiqDetConyu=?, ImpLiqDetHijos=?, ImpLiqDetCCT=?, ImpLiqDetSCVO=?, ImpLiqDetError=?, ImpLiqDetLegSis=?, ImpLiqDetConSis=?, ImpLiqDetConSisYDes=?, ImpLiqDetCantNum=?, ImpLiqDetImpNum=?, ImpLiqDetLiqClase=?, ImpLiqDetTipoCon=?, ImpLiqDetConYDes=?  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqDetSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00OC4", "SAVEPOINT gxupdate;UPDATE importacion_liquidacion_detalle SET ImpLiqDetLegId=?, ImpLiqDetCBU=?, ImpLiqDetCant=?, ImpLiqDetUni=?, ImpLiqDetImp=?, ImpLiqDetSigno=?, ImpLiqDetConyu=?, ImpLiqDetHijos=?, ImpLiqDetCCT=?, ImpLiqDetSCVO=?, ImpLiqDetError=?, ImpLiqDetLegSis=?, ImpLiqDetConSis=?, ImpLiqDetConSisYDes=?, ImpLiqDetCantNum=?, ImpLiqDetImpNum=?, ImpLiqDetLiqClase=?, ImpLiqDetTipoCon=?, ImpLiqDetConYDes=?  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqDetSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00OC5", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec FROM importacion_liquidacion_detalle WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00OC6", "SAVEPOINT gxupdate;INSERT INTO importacion_liquidacion_detalle(CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec, ImpLiqDetPer, ImpLiqDetLiqN, ImpLiqDetCUIL, ImpLiqDetLegId, ImpLiqDetCBU, ImpLiqDetConCod, ImpLiqDetCant, ImpLiqDetUni, ImpLiqDetImp, ImpLiqDetSigno, ImpLiqDetConyu, ImpLiqDetHijos, ImpLiqDetCCT, ImpLiqDetSCVO, ImpLiqDetError, ImpLiqDetLegSis, ImpLiqDetConSis, ImpLiqDetConSisYDes, ImpLiqDetCantNum, ImpLiqDetImpNum, ImpLiqDetLiqClase, ImpLiqDetConYDes, ImpLiqDetTipoCon) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getString(2, 11);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 10);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 5);
               ((String[]) buf[10])[0] = rslt.getString(11, 1);
               ((String[]) buf[11])[0] = rslt.getString(12, 15);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((String[]) buf[13])[0] = rslt.getString(14, 1);
               ((String[]) buf[14])[0] = rslt.getString(15, 2);
               ((String[]) buf[15])[0] = rslt.getString(16, 1);
               ((String[]) buf[16])[0] = rslt.getString(17, 1);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getString(20, 10);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(23,2);
               ((String[]) buf[23])[0] = rslt.getString(24, 1);
               ((String[]) buf[24])[0] = rslt.getString(25, 20);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((short[]) buf[26])[0] = rslt.getShort(27);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 5);
               stmt.setString(5, (String)parms[4], 6);
               stmt.setString(6, (String)parms[5], 11);
               stmt.setString(7, (String)parms[6], 10);
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 10);
               stmt.setVarchar(2, (String)parms[1], 22, false);
               stmt.setString(3, (String)parms[2], 5);
               stmt.setString(4, (String)parms[3], 1);
               stmt.setString(5, (String)parms[4], 15);
               stmt.setString(6, (String)parms[5], 1);
               stmt.setString(7, (String)parms[6], 1);
               stmt.setString(8, (String)parms[7], 2);
               stmt.setString(9, (String)parms[8], 1);
               stmt.setString(10, (String)parms[9], 1);
               stmt.setVarchar(11, (String)parms[10], 400, false);
               stmt.setVarchar(12, (String)parms[11], 400, false);
               stmt.setString(13, (String)parms[12], 10);
               stmt.setVarchar(14, (String)parms[13], 400, false);
               stmt.setBigDecimal(15, (java.math.BigDecimal)parms[14], 2);
               stmt.setBigDecimal(16, (java.math.BigDecimal)parms[15], 2);
               stmt.setString(17, (String)parms[16], 1);
               stmt.setString(18, (String)parms[17], 20);
               stmt.setVarchar(19, (String)parms[18], 400, false);
               stmt.setInt(20, ((Number) parms[19]).intValue());
               stmt.setShort(21, ((Number) parms[20]).shortValue());
               stmt.setShort(22, ((Number) parms[21]).shortValue());
               stmt.setShort(23, ((Number) parms[22]).shortValue());
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 10);
               stmt.setVarchar(2, (String)parms[1], 22, false);
               stmt.setString(3, (String)parms[2], 5);
               stmt.setString(4, (String)parms[3], 1);
               stmt.setString(5, (String)parms[4], 15);
               stmt.setString(6, (String)parms[5], 1);
               stmt.setString(7, (String)parms[6], 1);
               stmt.setString(8, (String)parms[7], 2);
               stmt.setString(9, (String)parms[8], 1);
               stmt.setString(10, (String)parms[9], 1);
               stmt.setVarchar(11, (String)parms[10], 400, false);
               stmt.setVarchar(12, (String)parms[11], 400, false);
               stmt.setString(13, (String)parms[12], 10);
               stmt.setVarchar(14, (String)parms[13], 400, false);
               stmt.setBigDecimal(15, (java.math.BigDecimal)parms[14], 2);
               stmt.setBigDecimal(16, (java.math.BigDecimal)parms[15], 2);
               stmt.setString(17, (String)parms[16], 1);
               stmt.setString(18, (String)parms[17], 20);
               stmt.setVarchar(19, (String)parms[18], 400, false);
               stmt.setInt(20, ((Number) parms[19]).intValue());
               stmt.setShort(21, ((Number) parms[20]).shortValue());
               stmt.setShort(22, ((Number) parms[21]).shortValue());
               stmt.setShort(23, ((Number) parms[22]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 6);
               stmt.setString(6, (String)parms[5], 5);
               stmt.setString(7, (String)parms[6], 11);
               stmt.setString(8, (String)parms[7], 10);
               stmt.setVarchar(9, (String)parms[8], 22, false);
               stmt.setString(10, (String)parms[9], 10);
               stmt.setString(11, (String)parms[10], 5);
               stmt.setString(12, (String)parms[11], 1);
               stmt.setString(13, (String)parms[12], 15);
               stmt.setString(14, (String)parms[13], 1);
               stmt.setString(15, (String)parms[14], 1);
               stmt.setString(16, (String)parms[15], 2);
               stmt.setString(17, (String)parms[16], 1);
               stmt.setString(18, (String)parms[17], 1);
               stmt.setVarchar(19, (String)parms[18], 400, false);
               stmt.setVarchar(20, (String)parms[19], 400, false);
               stmt.setString(21, (String)parms[20], 10);
               stmt.setVarchar(22, (String)parms[21], 400, false);
               stmt.setBigDecimal(23, (java.math.BigDecimal)parms[22], 2);
               stmt.setBigDecimal(24, (java.math.BigDecimal)parms[23], 2);
               stmt.setString(25, (String)parms[24], 1);
               stmt.setVarchar(26, (String)parms[25], 400, false);
               stmt.setString(27, (String)parms[26], 20);
               return;
      }
   }

}

