package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importacion_liquidacion_detalle_bc extends GXWebPanel implements IGxSilentTrn
{
   public importacion_liquidacion_detalle_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importacion_liquidacion_detalle_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importacion_liquidacion_detalle_bc.class ));
   }

   public importacion_liquidacion_detalle_bc( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow2A78( ) ;
      standaloneNotModal( ) ;
      initializeNonKey2A78( ) ;
      standaloneModal( ) ;
      addRow2A78( ) ;
      Gx_mode = "INS" ;
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z88ImpLiqSec = A88ImpLiqSec ;
            Z90ImpLiqDetSec = A90ImpLiqDetSec ;
            SetMode( "UPD") ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public boolean Reindex( )
   {
      return true ;
   }

   public void confirm_2A0( )
   {
      beforeValidate2A78( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls2A78( ) ;
         }
         else
         {
            checkExtendedTable2A78( ) ;
            if ( AnyError == 0 )
            {
               zm2A78( 3) ;
            }
            closeExtendedTableCursors2A78( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm2A78( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z661ImpLiqDetPer = A661ImpLiqDetPer ;
         Z662ImpLiqDetLiqN = A662ImpLiqDetLiqN ;
         Z663ImpLiqDetCUIL = A663ImpLiqDetCUIL ;
         Z664ImpLiqDetLegId = A664ImpLiqDetLegId ;
         Z665ImpLiqDetCBU = A665ImpLiqDetCBU ;
         Z666ImpLiqDetConCod = A666ImpLiqDetConCod ;
         Z2188ImpLiqDetConYDes = A2188ImpLiqDetConYDes ;
         Z667ImpLiqDetCant = A667ImpLiqDetCant ;
         Z668ImpLiqDetUni = A668ImpLiqDetUni ;
         Z669ImpLiqDetImp = A669ImpLiqDetImp ;
         Z670ImpLiqDetSigno = A670ImpLiqDetSigno ;
         Z671ImpLiqDetConyu = A671ImpLiqDetConyu ;
         Z672ImpLiqDetHijos = A672ImpLiqDetHijos ;
         Z673ImpLiqDetCCT = A673ImpLiqDetCCT ;
         Z674ImpLiqDetSCVO = A674ImpLiqDetSCVO ;
         Z709ImpLiqDetError = A709ImpLiqDetError ;
         Z712ImpLiqDetLegSis = A712ImpLiqDetLegSis ;
         Z713ImpLiqDetConSis = A713ImpLiqDetConSis ;
         Z714ImpLiqDetConSisYDes = A714ImpLiqDetConSisYDes ;
         Z715ImpLiqDetCantNum = A715ImpLiqDetCantNum ;
         Z716ImpLiqDetImpNum = A716ImpLiqDetImpNum ;
         Z718ImpLiqDetLiqClase = A718ImpLiqDetLiqClase ;
         Z2184ImpLiqDetTipoCon = A2184ImpLiqDetTipoCon ;
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -2 )
      {
         Z90ImpLiqDetSec = A90ImpLiqDetSec ;
         Z661ImpLiqDetPer = A661ImpLiqDetPer ;
         Z662ImpLiqDetLiqN = A662ImpLiqDetLiqN ;
         Z663ImpLiqDetCUIL = A663ImpLiqDetCUIL ;
         Z664ImpLiqDetLegId = A664ImpLiqDetLegId ;
         Z665ImpLiqDetCBU = A665ImpLiqDetCBU ;
         Z666ImpLiqDetConCod = A666ImpLiqDetConCod ;
         Z2188ImpLiqDetConYDes = A2188ImpLiqDetConYDes ;
         Z667ImpLiqDetCant = A667ImpLiqDetCant ;
         Z668ImpLiqDetUni = A668ImpLiqDetUni ;
         Z669ImpLiqDetImp = A669ImpLiqDetImp ;
         Z670ImpLiqDetSigno = A670ImpLiqDetSigno ;
         Z671ImpLiqDetConyu = A671ImpLiqDetConyu ;
         Z672ImpLiqDetHijos = A672ImpLiqDetHijos ;
         Z673ImpLiqDetCCT = A673ImpLiqDetCCT ;
         Z674ImpLiqDetSCVO = A674ImpLiqDetSCVO ;
         Z709ImpLiqDetError = A709ImpLiqDetError ;
         Z712ImpLiqDetLegSis = A712ImpLiqDetLegSis ;
         Z713ImpLiqDetConSis = A713ImpLiqDetConSis ;
         Z714ImpLiqDetConSisYDes = A714ImpLiqDetConSisYDes ;
         Z715ImpLiqDetCantNum = A715ImpLiqDetCantNum ;
         Z716ImpLiqDetImpNum = A716ImpLiqDetImpNum ;
         Z718ImpLiqDetLiqClase = A718ImpLiqDetLiqClase ;
         Z2184ImpLiqDetTipoCon = A2184ImpLiqDetTipoCon ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load2A78( )
   {
      /* Using cursor BC002A5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A90ImpLiqDetSec)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound78 = (short)(1) ;
         A661ImpLiqDetPer = BC002A5_A661ImpLiqDetPer[0] ;
         A662ImpLiqDetLiqN = BC002A5_A662ImpLiqDetLiqN[0] ;
         A663ImpLiqDetCUIL = BC002A5_A663ImpLiqDetCUIL[0] ;
         A664ImpLiqDetLegId = BC002A5_A664ImpLiqDetLegId[0] ;
         A665ImpLiqDetCBU = BC002A5_A665ImpLiqDetCBU[0] ;
         A666ImpLiqDetConCod = BC002A5_A666ImpLiqDetConCod[0] ;
         A2188ImpLiqDetConYDes = BC002A5_A2188ImpLiqDetConYDes[0] ;
         A667ImpLiqDetCant = BC002A5_A667ImpLiqDetCant[0] ;
         A668ImpLiqDetUni = BC002A5_A668ImpLiqDetUni[0] ;
         A669ImpLiqDetImp = BC002A5_A669ImpLiqDetImp[0] ;
         A670ImpLiqDetSigno = BC002A5_A670ImpLiqDetSigno[0] ;
         A671ImpLiqDetConyu = BC002A5_A671ImpLiqDetConyu[0] ;
         A672ImpLiqDetHijos = BC002A5_A672ImpLiqDetHijos[0] ;
         A673ImpLiqDetCCT = BC002A5_A673ImpLiqDetCCT[0] ;
         A674ImpLiqDetSCVO = BC002A5_A674ImpLiqDetSCVO[0] ;
         A709ImpLiqDetError = BC002A5_A709ImpLiqDetError[0] ;
         A712ImpLiqDetLegSis = BC002A5_A712ImpLiqDetLegSis[0] ;
         A713ImpLiqDetConSis = BC002A5_A713ImpLiqDetConSis[0] ;
         A714ImpLiqDetConSisYDes = BC002A5_A714ImpLiqDetConSisYDes[0] ;
         A715ImpLiqDetCantNum = BC002A5_A715ImpLiqDetCantNum[0] ;
         A716ImpLiqDetImpNum = BC002A5_A716ImpLiqDetImpNum[0] ;
         A718ImpLiqDetLiqClase = BC002A5_A718ImpLiqDetLiqClase[0] ;
         A2184ImpLiqDetTipoCon = BC002A5_A2184ImpLiqDetTipoCon[0] ;
         zm2A78( -2) ;
      }
      pr_default.close(3);
      onLoadActions2A78( ) ;
   }

   public void onLoadActions2A78( )
   {
   }

   public void checkExtendedTable2A78( )
   {
      nIsDirty_78 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC002A6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_liquidaciones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPLIQSEC");
         AnyError = (short)(1) ;
      }
      pr_default.close(4);
      if ( ! ( ( GXutil.strcmp(A2184ImpLiqDetTipoCon, "REM_ARG") == 0 ) || ( GXutil.strcmp(A2184ImpLiqDetTipoCon, "NRE_ARG") == 0 ) || ( GXutil.strcmp(A2184ImpLiqDetTipoCon, "DES_ARG") == 0 ) || ( GXutil.strcmp(A2184ImpLiqDetTipoCon, "CAL_ARG") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors2A78( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey2A78( )
   {
      /* Using cursor BC002A7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A90ImpLiqDetSec)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound78 = (short)(1) ;
      }
      else
      {
         RcdFound78 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC002A8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A90ImpLiqDetSec)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm2A78( 2) ;
         RcdFound78 = (short)(1) ;
         A90ImpLiqDetSec = BC002A8_A90ImpLiqDetSec[0] ;
         A661ImpLiqDetPer = BC002A8_A661ImpLiqDetPer[0] ;
         A662ImpLiqDetLiqN = BC002A8_A662ImpLiqDetLiqN[0] ;
         A663ImpLiqDetCUIL = BC002A8_A663ImpLiqDetCUIL[0] ;
         A664ImpLiqDetLegId = BC002A8_A664ImpLiqDetLegId[0] ;
         A665ImpLiqDetCBU = BC002A8_A665ImpLiqDetCBU[0] ;
         A666ImpLiqDetConCod = BC002A8_A666ImpLiqDetConCod[0] ;
         A2188ImpLiqDetConYDes = BC002A8_A2188ImpLiqDetConYDes[0] ;
         A667ImpLiqDetCant = BC002A8_A667ImpLiqDetCant[0] ;
         A668ImpLiqDetUni = BC002A8_A668ImpLiqDetUni[0] ;
         A669ImpLiqDetImp = BC002A8_A669ImpLiqDetImp[0] ;
         A670ImpLiqDetSigno = BC002A8_A670ImpLiqDetSigno[0] ;
         A671ImpLiqDetConyu = BC002A8_A671ImpLiqDetConyu[0] ;
         A672ImpLiqDetHijos = BC002A8_A672ImpLiqDetHijos[0] ;
         A673ImpLiqDetCCT = BC002A8_A673ImpLiqDetCCT[0] ;
         A674ImpLiqDetSCVO = BC002A8_A674ImpLiqDetSCVO[0] ;
         A709ImpLiqDetError = BC002A8_A709ImpLiqDetError[0] ;
         A712ImpLiqDetLegSis = BC002A8_A712ImpLiqDetLegSis[0] ;
         A713ImpLiqDetConSis = BC002A8_A713ImpLiqDetConSis[0] ;
         A714ImpLiqDetConSisYDes = BC002A8_A714ImpLiqDetConSisYDes[0] ;
         A715ImpLiqDetCantNum = BC002A8_A715ImpLiqDetCantNum[0] ;
         A716ImpLiqDetImpNum = BC002A8_A716ImpLiqDetImpNum[0] ;
         A718ImpLiqDetLiqClase = BC002A8_A718ImpLiqDetLiqClase[0] ;
         A2184ImpLiqDetTipoCon = BC002A8_A2184ImpLiqDetTipoCon[0] ;
         A3CliCod = BC002A8_A3CliCod[0] ;
         A1EmpCod = BC002A8_A1EmpCod[0] ;
         A88ImpLiqSec = BC002A8_A88ImpLiqSec[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
         Z90ImpLiqDetSec = A90ImpLiqDetSec ;
         sMode78 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load2A78( ) ;
         if ( AnyError == 1 )
         {
            RcdFound78 = (short)(0) ;
            initializeNonKey2A78( ) ;
         }
         Gx_mode = sMode78 ;
      }
      else
      {
         RcdFound78 = (short)(0) ;
         initializeNonKey2A78( ) ;
         sMode78 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode78 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey2A78( ) ;
      if ( RcdFound78 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
      }
      getByPrimaryKey( ) ;
   }

   public void insert_check( )
   {
      confirm_2A0( ) ;
      IsConfirmed = (short)(0) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency2A78( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC002A9 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A90ImpLiqDetSec)});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_liquidacion_detalle"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(7) == 101) || ( GXutil.strcmp(Z661ImpLiqDetPer, BC002A9_A661ImpLiqDetPer[0]) != 0 ) || ( GXutil.strcmp(Z662ImpLiqDetLiqN, BC002A9_A662ImpLiqDetLiqN[0]) != 0 ) || ( GXutil.strcmp(Z663ImpLiqDetCUIL, BC002A9_A663ImpLiqDetCUIL[0]) != 0 ) || ( GXutil.strcmp(Z664ImpLiqDetLegId, BC002A9_A664ImpLiqDetLegId[0]) != 0 ) || ( GXutil.strcmp(Z665ImpLiqDetCBU, BC002A9_A665ImpLiqDetCBU[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z666ImpLiqDetConCod, BC002A9_A666ImpLiqDetConCod[0]) != 0 ) || ( GXutil.strcmp(Z2188ImpLiqDetConYDes, BC002A9_A2188ImpLiqDetConYDes[0]) != 0 ) || ( GXutil.strcmp(Z667ImpLiqDetCant, BC002A9_A667ImpLiqDetCant[0]) != 0 ) || ( GXutil.strcmp(Z668ImpLiqDetUni, BC002A9_A668ImpLiqDetUni[0]) != 0 ) || ( GXutil.strcmp(Z669ImpLiqDetImp, BC002A9_A669ImpLiqDetImp[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z670ImpLiqDetSigno, BC002A9_A670ImpLiqDetSigno[0]) != 0 ) || ( GXutil.strcmp(Z671ImpLiqDetConyu, BC002A9_A671ImpLiqDetConyu[0]) != 0 ) || ( GXutil.strcmp(Z672ImpLiqDetHijos, BC002A9_A672ImpLiqDetHijos[0]) != 0 ) || ( GXutil.strcmp(Z673ImpLiqDetCCT, BC002A9_A673ImpLiqDetCCT[0]) != 0 ) || ( GXutil.strcmp(Z674ImpLiqDetSCVO, BC002A9_A674ImpLiqDetSCVO[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z709ImpLiqDetError, BC002A9_A709ImpLiqDetError[0]) != 0 ) || ( GXutil.strcmp(Z712ImpLiqDetLegSis, BC002A9_A712ImpLiqDetLegSis[0]) != 0 ) || ( GXutil.strcmp(Z713ImpLiqDetConSis, BC002A9_A713ImpLiqDetConSis[0]) != 0 ) || ( GXutil.strcmp(Z714ImpLiqDetConSisYDes, BC002A9_A714ImpLiqDetConSisYDes[0]) != 0 ) || ( DecimalUtil.compareTo(Z715ImpLiqDetCantNum, BC002A9_A715ImpLiqDetCantNum[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z716ImpLiqDetImpNum, BC002A9_A716ImpLiqDetImpNum[0]) != 0 ) || ( GXutil.strcmp(Z718ImpLiqDetLiqClase, BC002A9_A718ImpLiqDetLiqClase[0]) != 0 ) || ( GXutil.strcmp(Z2184ImpLiqDetTipoCon, BC002A9_A2184ImpLiqDetTipoCon[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"importacion_liquidacion_detalle"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2A78( )
   {
      beforeValidate2A78( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2A78( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2A78( 0) ;
         checkOptimisticConcurrency2A78( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2A78( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2A78( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002A10 */
                  pr_default.execute(8, new Object[] {Short.valueOf(A90ImpLiqDetSec), A661ImpLiqDetPer, A662ImpLiqDetLiqN, A663ImpLiqDetCUIL, A664ImpLiqDetLegId, A665ImpLiqDetCBU, A666ImpLiqDetConCod, A2188ImpLiqDetConYDes, A667ImpLiqDetCant, A668ImpLiqDetUni, A669ImpLiqDetImp, A670ImpLiqDetSigno, A671ImpLiqDetConyu, A672ImpLiqDetHijos, A673ImpLiqDetCCT, A674ImpLiqDetSCVO, A709ImpLiqDetError, A712ImpLiqDetLegSis, A713ImpLiqDetConSis, A714ImpLiqDetConSisYDes, A715ImpLiqDetCantNum, A716ImpLiqDetImpNum, A718ImpLiqDetLiqClase, A2184ImpLiqDetTipoCon, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_detalle");
                  if ( (pr_default.getStatus(8) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load2A78( ) ;
         }
         endLevel2A78( ) ;
      }
      closeExtendedTableCursors2A78( ) ;
   }

   public void update2A78( )
   {
      beforeValidate2A78( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2A78( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2A78( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2A78( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2A78( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002A11 */
                  pr_default.execute(9, new Object[] {A661ImpLiqDetPer, A662ImpLiqDetLiqN, A663ImpLiqDetCUIL, A664ImpLiqDetLegId, A665ImpLiqDetCBU, A666ImpLiqDetConCod, A2188ImpLiqDetConYDes, A667ImpLiqDetCant, A668ImpLiqDetUni, A669ImpLiqDetImp, A670ImpLiqDetSigno, A671ImpLiqDetConyu, A672ImpLiqDetHijos, A673ImpLiqDetCCT, A674ImpLiqDetSCVO, A709ImpLiqDetError, A712ImpLiqDetLegSis, A713ImpLiqDetConSis, A714ImpLiqDetConSisYDes, A715ImpLiqDetCantNum, A716ImpLiqDetImpNum, A718ImpLiqDetLiqClase, A2184ImpLiqDetTipoCon, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A90ImpLiqDetSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_detalle");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_liquidacion_detalle"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2A78( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel2A78( ) ;
      }
      closeExtendedTableCursors2A78( ) ;
   }

   public void deferredUpdate2A78( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate2A78( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2A78( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2A78( ) ;
         afterConfirm2A78( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2A78( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC002A12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A90ImpLiqDetSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_detalle");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode78 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel2A78( ) ;
      Gx_mode = sMode78 ;
   }

   public void onDeleteControls2A78( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel2A78( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2A78( ) ;
      }
      if ( AnyError == 0 )
      {
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart2A78( )
   {
      /* Using cursor BC002A13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A90ImpLiqDetSec)});
      RcdFound78 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound78 = (short)(1) ;
         A90ImpLiqDetSec = BC002A13_A90ImpLiqDetSec[0] ;
         A661ImpLiqDetPer = BC002A13_A661ImpLiqDetPer[0] ;
         A662ImpLiqDetLiqN = BC002A13_A662ImpLiqDetLiqN[0] ;
         A663ImpLiqDetCUIL = BC002A13_A663ImpLiqDetCUIL[0] ;
         A664ImpLiqDetLegId = BC002A13_A664ImpLiqDetLegId[0] ;
         A665ImpLiqDetCBU = BC002A13_A665ImpLiqDetCBU[0] ;
         A666ImpLiqDetConCod = BC002A13_A666ImpLiqDetConCod[0] ;
         A2188ImpLiqDetConYDes = BC002A13_A2188ImpLiqDetConYDes[0] ;
         A667ImpLiqDetCant = BC002A13_A667ImpLiqDetCant[0] ;
         A668ImpLiqDetUni = BC002A13_A668ImpLiqDetUni[0] ;
         A669ImpLiqDetImp = BC002A13_A669ImpLiqDetImp[0] ;
         A670ImpLiqDetSigno = BC002A13_A670ImpLiqDetSigno[0] ;
         A671ImpLiqDetConyu = BC002A13_A671ImpLiqDetConyu[0] ;
         A672ImpLiqDetHijos = BC002A13_A672ImpLiqDetHijos[0] ;
         A673ImpLiqDetCCT = BC002A13_A673ImpLiqDetCCT[0] ;
         A674ImpLiqDetSCVO = BC002A13_A674ImpLiqDetSCVO[0] ;
         A709ImpLiqDetError = BC002A13_A709ImpLiqDetError[0] ;
         A712ImpLiqDetLegSis = BC002A13_A712ImpLiqDetLegSis[0] ;
         A713ImpLiqDetConSis = BC002A13_A713ImpLiqDetConSis[0] ;
         A714ImpLiqDetConSisYDes = BC002A13_A714ImpLiqDetConSisYDes[0] ;
         A715ImpLiqDetCantNum = BC002A13_A715ImpLiqDetCantNum[0] ;
         A716ImpLiqDetImpNum = BC002A13_A716ImpLiqDetImpNum[0] ;
         A718ImpLiqDetLiqClase = BC002A13_A718ImpLiqDetLiqClase[0] ;
         A2184ImpLiqDetTipoCon = BC002A13_A2184ImpLiqDetTipoCon[0] ;
         A3CliCod = BC002A13_A3CliCod[0] ;
         A1EmpCod = BC002A13_A1EmpCod[0] ;
         A88ImpLiqSec = BC002A13_A88ImpLiqSec[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext2A78( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound78 = (short)(0) ;
      scanKeyLoad2A78( ) ;
   }

   public void scanKeyLoad2A78( )
   {
      sMode78 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound78 = (short)(1) ;
         A90ImpLiqDetSec = BC002A13_A90ImpLiqDetSec[0] ;
         A661ImpLiqDetPer = BC002A13_A661ImpLiqDetPer[0] ;
         A662ImpLiqDetLiqN = BC002A13_A662ImpLiqDetLiqN[0] ;
         A663ImpLiqDetCUIL = BC002A13_A663ImpLiqDetCUIL[0] ;
         A664ImpLiqDetLegId = BC002A13_A664ImpLiqDetLegId[0] ;
         A665ImpLiqDetCBU = BC002A13_A665ImpLiqDetCBU[0] ;
         A666ImpLiqDetConCod = BC002A13_A666ImpLiqDetConCod[0] ;
         A2188ImpLiqDetConYDes = BC002A13_A2188ImpLiqDetConYDes[0] ;
         A667ImpLiqDetCant = BC002A13_A667ImpLiqDetCant[0] ;
         A668ImpLiqDetUni = BC002A13_A668ImpLiqDetUni[0] ;
         A669ImpLiqDetImp = BC002A13_A669ImpLiqDetImp[0] ;
         A670ImpLiqDetSigno = BC002A13_A670ImpLiqDetSigno[0] ;
         A671ImpLiqDetConyu = BC002A13_A671ImpLiqDetConyu[0] ;
         A672ImpLiqDetHijos = BC002A13_A672ImpLiqDetHijos[0] ;
         A673ImpLiqDetCCT = BC002A13_A673ImpLiqDetCCT[0] ;
         A674ImpLiqDetSCVO = BC002A13_A674ImpLiqDetSCVO[0] ;
         A709ImpLiqDetError = BC002A13_A709ImpLiqDetError[0] ;
         A712ImpLiqDetLegSis = BC002A13_A712ImpLiqDetLegSis[0] ;
         A713ImpLiqDetConSis = BC002A13_A713ImpLiqDetConSis[0] ;
         A714ImpLiqDetConSisYDes = BC002A13_A714ImpLiqDetConSisYDes[0] ;
         A715ImpLiqDetCantNum = BC002A13_A715ImpLiqDetCantNum[0] ;
         A716ImpLiqDetImpNum = BC002A13_A716ImpLiqDetImpNum[0] ;
         A718ImpLiqDetLiqClase = BC002A13_A718ImpLiqDetLiqClase[0] ;
         A2184ImpLiqDetTipoCon = BC002A13_A2184ImpLiqDetTipoCon[0] ;
         A3CliCod = BC002A13_A3CliCod[0] ;
         A1EmpCod = BC002A13_A1EmpCod[0] ;
         A88ImpLiqSec = BC002A13_A88ImpLiqSec[0] ;
      }
      Gx_mode = sMode78 ;
   }

   public void scanKeyEnd2A78( )
   {
      pr_default.close(11);
   }

   public void afterConfirm2A78( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2A78( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2A78( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2A78( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2A78( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2A78( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2A78( )
   {
   }

   public void send_integrity_lvl_hashes2A78( )
   {
   }

   public void addRow2A78( )
   {
      VarsToRow78( bcimportacion_liquidacion_detalle) ;
   }

   public void readRow2A78( )
   {
      RowToVars78( bcimportacion_liquidacion_detalle, 1) ;
   }

   public void initializeNonKey2A78( )
   {
      A661ImpLiqDetPer = "" ;
      A662ImpLiqDetLiqN = "" ;
      A663ImpLiqDetCUIL = "" ;
      A664ImpLiqDetLegId = "" ;
      A665ImpLiqDetCBU = "" ;
      A666ImpLiqDetConCod = "" ;
      A2188ImpLiqDetConYDes = "" ;
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
      Z661ImpLiqDetPer = "" ;
      Z662ImpLiqDetLiqN = "" ;
      Z663ImpLiqDetCUIL = "" ;
      Z664ImpLiqDetLegId = "" ;
      Z665ImpLiqDetCBU = "" ;
      Z666ImpLiqDetConCod = "" ;
      Z2188ImpLiqDetConYDes = "" ;
      Z667ImpLiqDetCant = "" ;
      Z668ImpLiqDetUni = "" ;
      Z669ImpLiqDetImp = "" ;
      Z670ImpLiqDetSigno = "" ;
      Z671ImpLiqDetConyu = "" ;
      Z672ImpLiqDetHijos = "" ;
      Z673ImpLiqDetCCT = "" ;
      Z674ImpLiqDetSCVO = "" ;
      Z709ImpLiqDetError = "" ;
      Z712ImpLiqDetLegSis = "" ;
      Z713ImpLiqDetConSis = "" ;
      Z714ImpLiqDetConSisYDes = "" ;
      Z715ImpLiqDetCantNum = DecimalUtil.ZERO ;
      Z716ImpLiqDetImpNum = DecimalUtil.ZERO ;
      Z718ImpLiqDetLiqClase = "" ;
      Z2184ImpLiqDetTipoCon = "" ;
   }

   public void initAll2A78( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A88ImpLiqSec = (short)(0) ;
      A90ImpLiqDetSec = (short)(0) ;
      initializeNonKey2A78( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void VarsToRow78( web.Sdtimportacion_liquidacion_detalle obj78 )
   {
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Mode( Gx_mode );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper( A661ImpLiqDetPer );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn( A662ImpLiqDetLiqN );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil( A663ImpLiqDetCUIL );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid( A664ImpLiqDetLegId );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu( A665ImpLiqDetCBU );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod( A666ImpLiqDetConCod );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes( A2188ImpLiqDetConYDes );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant( A667ImpLiqDetCant );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni( A668ImpLiqDetUni );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp( A669ImpLiqDetImp );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno( A670ImpLiqDetSigno );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu( A671ImpLiqDetConyu );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos( A672ImpLiqDetHijos );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct( A673ImpLiqDetCCT );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo( A674ImpLiqDetSCVO );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror( A709ImpLiqDetError );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis( A712ImpLiqDetLegSis );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis( A713ImpLiqDetConSis );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes( A714ImpLiqDetConSisYDes );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum( A715ImpLiqDetCantNum );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum( A716ImpLiqDetImpNum );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase( A718ImpLiqDetLiqClase );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon( A2184ImpLiqDetTipoCon );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Clicod( A3CliCod );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Empcod( A1EmpCod );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec( A88ImpLiqSec );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec( A90ImpLiqDetSec );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z( Z3CliCod );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z( Z1EmpCod );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z( Z88ImpLiqSec );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z( Z90ImpLiqDetSec );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z( Z661ImpLiqDetPer );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z( Z662ImpLiqDetLiqN );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z( Z663ImpLiqDetCUIL );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z( Z664ImpLiqDetLegId );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z( Z665ImpLiqDetCBU );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z( Z666ImpLiqDetConCod );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z( Z2188ImpLiqDetConYDes );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z( Z667ImpLiqDetCant );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z( Z668ImpLiqDetUni );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z( Z669ImpLiqDetImp );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z( Z670ImpLiqDetSigno );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z( Z671ImpLiqDetConyu );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z( Z672ImpLiqDetHijos );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z( Z673ImpLiqDetCCT );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z( Z674ImpLiqDetSCVO );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z( Z709ImpLiqDetError );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z( Z712ImpLiqDetLegSis );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z( Z713ImpLiqDetConSis );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z( Z714ImpLiqDetConSisYDes );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z( Z715ImpLiqDetCantNum );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z( Z716ImpLiqDetImpNum );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z( Z718ImpLiqDetLiqClase );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z( Z2184ImpLiqDetTipoCon );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Mode( Gx_mode );
   }

   public void KeyVarsToRow78( web.Sdtimportacion_liquidacion_detalle obj78 )
   {
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Clicod( A3CliCod );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Empcod( A1EmpCod );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec( A88ImpLiqSec );
      obj78.setgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec( A90ImpLiqDetSec );
   }

   public void RowToVars78( web.Sdtimportacion_liquidacion_detalle obj78 ,
                            int forceLoad )
   {
      Gx_mode = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Mode() ;
      A661ImpLiqDetPer = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper() ;
      A662ImpLiqDetLiqN = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn() ;
      A663ImpLiqDetCUIL = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil() ;
      A664ImpLiqDetLegId = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid() ;
      A665ImpLiqDetCBU = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu() ;
      A666ImpLiqDetConCod = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod() ;
      A2188ImpLiqDetConYDes = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes() ;
      A667ImpLiqDetCant = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant() ;
      A668ImpLiqDetUni = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni() ;
      A669ImpLiqDetImp = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp() ;
      A670ImpLiqDetSigno = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno() ;
      A671ImpLiqDetConyu = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu() ;
      A672ImpLiqDetHijos = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos() ;
      A673ImpLiqDetCCT = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct() ;
      A674ImpLiqDetSCVO = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo() ;
      A709ImpLiqDetError = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror() ;
      A712ImpLiqDetLegSis = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis() ;
      A713ImpLiqDetConSis = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis() ;
      A714ImpLiqDetConSisYDes = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes() ;
      A715ImpLiqDetCantNum = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum() ;
      A716ImpLiqDetImpNum = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum() ;
      A718ImpLiqDetLiqClase = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase() ;
      A2184ImpLiqDetTipoCon = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon() ;
      A3CliCod = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Clicod() ;
      A1EmpCod = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Empcod() ;
      A88ImpLiqSec = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec() ;
      A90ImpLiqDetSec = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec() ;
      Z3CliCod = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Clicod_Z() ;
      Z1EmpCod = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Empcod_Z() ;
      Z88ImpLiqSec = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqsec_Z() ;
      Z90ImpLiqDetSec = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsec_Z() ;
      Z661ImpLiqDetPer = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetper_Z() ;
      Z662ImpLiqDetLiqN = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqn_Z() ;
      Z663ImpLiqDetCUIL = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcuil_Z() ;
      Z664ImpLiqDetLegId = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegid_Z() ;
      Z665ImpLiqDetCBU = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcbu_Z() ;
      Z666ImpLiqDetConCod = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconcod_Z() ;
      Z2188ImpLiqDetConYDes = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconydes_Z() ;
      Z667ImpLiqDetCant = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcant_Z() ;
      Z668ImpLiqDetUni = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetuni_Z() ;
      Z669ImpLiqDetImp = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimp_Z() ;
      Z670ImpLiqDetSigno = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetsigno_Z() ;
      Z671ImpLiqDetConyu = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconyu_Z() ;
      Z672ImpLiqDetHijos = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdethijos_Z() ;
      Z673ImpLiqDetCCT = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcct_Z() ;
      Z674ImpLiqDetSCVO = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetscvo_Z() ;
      Z709ImpLiqDetError = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdeterror_Z() ;
      Z712ImpLiqDetLegSis = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetlegsis_Z() ;
      Z713ImpLiqDetConSis = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsis_Z() ;
      Z714ImpLiqDetConSisYDes = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetconsisydes_Z() ;
      Z715ImpLiqDetCantNum = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetcantnum_Z() ;
      Z716ImpLiqDetImpNum = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetimpnum_Z() ;
      Z718ImpLiqDetLiqClase = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdetliqclase_Z() ;
      Z2184ImpLiqDetTipoCon = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Impliqdettipocon_Z() ;
      Gx_mode = obj78.getgxTv_Sdtimportacion_liquidacion_detalle_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A88ImpLiqSec = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.SHORT)).shortValue() ;
      A90ImpLiqDetSec = ((Number) GXutil.testNumericType( getParm(obj,3), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey2A78( ) ;
      scanKeyStart2A78( ) ;
      if ( RcdFound78 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC002A14 */
         pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
         if ( (pr_default.getStatus(12) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_liquidaciones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPLIQSEC");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
         Z90ImpLiqDetSec = A90ImpLiqDetSec ;
      }
      zm2A78( -2) ;
      onLoadActions2A78( ) ;
      addRow2A78( ) ;
      scanKeyEnd2A78( ) ;
      if ( RcdFound78 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void Load( )
   {
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      RowToVars78( bcimportacion_liquidacion_detalle, 0) ;
      scanKeyStart2A78( ) ;
      if ( RcdFound78 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC002A15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
         if ( (pr_default.getStatus(13) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_liquidaciones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPLIQSEC");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
         Z90ImpLiqDetSec = A90ImpLiqDetSec ;
      }
      zm2A78( -2) ;
      onLoadActions2A78( ) ;
      addRow2A78( ) ;
      scanKeyEnd2A78( ) ;
      if ( RcdFound78 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2A78( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert2A78( ) ;
      }
      else
      {
         if ( RcdFound78 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( A90ImpLiqDetSec != Z90ImpLiqDetSec ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A88ImpLiqSec = Z88ImpLiqSec ;
               A90ImpLiqDetSec = Z90ImpLiqDetSec ;
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               /* Update record */
               update2A78( ) ;
            }
         }
         else
         {
            if ( isDlt( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( A90ImpLiqDetSec != Z90ImpLiqDetSec ) )
               {
                  if ( isUpd( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert2A78( ) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert2A78( ) ;
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void Save( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars78( bcimportacion_liquidacion_detalle, 1) ;
      saveImpl( ) ;
      VarsToRow78( bcimportacion_liquidacion_detalle) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars78( bcimportacion_liquidacion_detalle, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert2A78( ) ;
      afterTrn( ) ;
      VarsToRow78( bcimportacion_liquidacion_detalle) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
      }
      else
      {
         web.Sdtimportacion_liquidacion_detalle auxBC = new web.Sdtimportacion_liquidacion_detalle( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A88ImpLiqSec, A90ImpLiqDetSec);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcimportacion_liquidacion_detalle);
            auxBC.Save();
         }
         LclMsgLst = auxTrn.GetMessages() ;
         AnyError = (short)(auxTrn.Errors()) ;
         httpContext.GX_msglist = LclMsgLst ;
         if ( auxTrn.Errors() == 0 )
         {
            Gx_mode = auxTrn.GetMode() ;
            afterTrn( ) ;
         }
      }
   }

   public boolean Update( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars78( bcimportacion_liquidacion_detalle, 1) ;
      updateImpl( ) ;
      VarsToRow78( bcimportacion_liquidacion_detalle) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public boolean InsertOrUpdate( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars78( bcimportacion_liquidacion_detalle, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert2A78( ) ;
      if ( AnyError == 1 )
      {
         if ( GXutil.strcmp(httpContext.GX_msglist.getItemValue((short)(1)), "DuplicatePrimaryKey") == 0 )
         {
            AnyError = (short)(0) ;
            httpContext.GX_msglist.removeAllItems();
            updateImpl( ) ;
         }
      }
      else
      {
         afterTrn( ) ;
      }
      VarsToRow78( bcimportacion_liquidacion_detalle) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars78( bcimportacion_liquidacion_detalle, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey2A78( ) ;
      if ( RcdFound78 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( A90ImpLiqDetSec != Z90ImpLiqDetSec ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A88ImpLiqSec = Z88ImpLiqSec ;
            A90ImpLiqDetSec = Z90ImpLiqDetSec ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( isDlt( ) )
         {
            delete_check( ) ;
         }
         else
         {
            Gx_mode = "UPD" ;
            update_check( ) ;
         }
      }
      else
      {
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( A90ImpLiqDetSec != Z90ImpLiqDetSec ) )
         {
            Gx_mode = "INS" ;
            insert_check( ) ;
         }
         else
         {
            if ( isUpd( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               Gx_mode = "INS" ;
               insert_check( ) ;
            }
         }
      }
      Application.rollbackDataStores(context, remoteHandle, pr_default, "importacion_liquidacion_detalle_bc");
      VarsToRow78( bcimportacion_liquidacion_detalle) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public int Errors( )
   {
      if ( AnyError == 0 )
      {
         return 0 ;
      }
      return 1 ;
   }

   public com.genexus.internet.MsgList GetMessages( )
   {
      return LclMsgLst ;
   }

   public String GetMode( )
   {
      Gx_mode = bcimportacion_liquidacion_detalle.getgxTv_Sdtimportacion_liquidacion_detalle_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcimportacion_liquidacion_detalle.setgxTv_Sdtimportacion_liquidacion_detalle_Mode( Gx_mode );
   }

   public void SetSDT( web.Sdtimportacion_liquidacion_detalle sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcimportacion_liquidacion_detalle )
      {
         bcimportacion_liquidacion_detalle = sdt ;
         if ( GXutil.strcmp(bcimportacion_liquidacion_detalle.getgxTv_Sdtimportacion_liquidacion_detalle_Mode(), "") == 0 )
         {
            bcimportacion_liquidacion_detalle.setgxTv_Sdtimportacion_liquidacion_detalle_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow78( bcimportacion_liquidacion_detalle) ;
         }
         else
         {
            RowToVars78( bcimportacion_liquidacion_detalle, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcimportacion_liquidacion_detalle.getgxTv_Sdtimportacion_liquidacion_detalle_Mode(), "") == 0 )
         {
            bcimportacion_liquidacion_detalle.setgxTv_Sdtimportacion_liquidacion_detalle_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars78( bcimportacion_liquidacion_detalle, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public Sdtimportacion_liquidacion_detalle getimportacion_liquidacion_detalle_BC( )
   {
      return bcimportacion_liquidacion_detalle ;
   }


   public void webExecute( )
   {
   }

   protected void createObjects( )
   {
   }

   protected void Process( )
   {
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Gx_mode = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      Z661ImpLiqDetPer = "" ;
      A661ImpLiqDetPer = "" ;
      Z662ImpLiqDetLiqN = "" ;
      A662ImpLiqDetLiqN = "" ;
      Z663ImpLiqDetCUIL = "" ;
      A663ImpLiqDetCUIL = "" ;
      Z664ImpLiqDetLegId = "" ;
      A664ImpLiqDetLegId = "" ;
      Z665ImpLiqDetCBU = "" ;
      A665ImpLiqDetCBU = "" ;
      Z666ImpLiqDetConCod = "" ;
      A666ImpLiqDetConCod = "" ;
      Z2188ImpLiqDetConYDes = "" ;
      A2188ImpLiqDetConYDes = "" ;
      Z667ImpLiqDetCant = "" ;
      A667ImpLiqDetCant = "" ;
      Z668ImpLiqDetUni = "" ;
      A668ImpLiqDetUni = "" ;
      Z669ImpLiqDetImp = "" ;
      A669ImpLiqDetImp = "" ;
      Z670ImpLiqDetSigno = "" ;
      A670ImpLiqDetSigno = "" ;
      Z671ImpLiqDetConyu = "" ;
      A671ImpLiqDetConyu = "" ;
      Z672ImpLiqDetHijos = "" ;
      A672ImpLiqDetHijos = "" ;
      Z673ImpLiqDetCCT = "" ;
      A673ImpLiqDetCCT = "" ;
      Z674ImpLiqDetSCVO = "" ;
      A674ImpLiqDetSCVO = "" ;
      Z709ImpLiqDetError = "" ;
      A709ImpLiqDetError = "" ;
      Z712ImpLiqDetLegSis = "" ;
      A712ImpLiqDetLegSis = "" ;
      Z713ImpLiqDetConSis = "" ;
      A713ImpLiqDetConSis = "" ;
      Z714ImpLiqDetConSisYDes = "" ;
      A714ImpLiqDetConSisYDes = "" ;
      Z715ImpLiqDetCantNum = DecimalUtil.ZERO ;
      A715ImpLiqDetCantNum = DecimalUtil.ZERO ;
      Z716ImpLiqDetImpNum = DecimalUtil.ZERO ;
      A716ImpLiqDetImpNum = DecimalUtil.ZERO ;
      Z718ImpLiqDetLiqClase = "" ;
      A718ImpLiqDetLiqClase = "" ;
      Z2184ImpLiqDetTipoCon = "" ;
      A2184ImpLiqDetTipoCon = "" ;
      BC002A5_A90ImpLiqDetSec = new short[1] ;
      BC002A5_A661ImpLiqDetPer = new String[] {""} ;
      BC002A5_A662ImpLiqDetLiqN = new String[] {""} ;
      BC002A5_A663ImpLiqDetCUIL = new String[] {""} ;
      BC002A5_A664ImpLiqDetLegId = new String[] {""} ;
      BC002A5_A665ImpLiqDetCBU = new String[] {""} ;
      BC002A5_A666ImpLiqDetConCod = new String[] {""} ;
      BC002A5_A2188ImpLiqDetConYDes = new String[] {""} ;
      BC002A5_A667ImpLiqDetCant = new String[] {""} ;
      BC002A5_A668ImpLiqDetUni = new String[] {""} ;
      BC002A5_A669ImpLiqDetImp = new String[] {""} ;
      BC002A5_A670ImpLiqDetSigno = new String[] {""} ;
      BC002A5_A671ImpLiqDetConyu = new String[] {""} ;
      BC002A5_A672ImpLiqDetHijos = new String[] {""} ;
      BC002A5_A673ImpLiqDetCCT = new String[] {""} ;
      BC002A5_A674ImpLiqDetSCVO = new String[] {""} ;
      BC002A5_A709ImpLiqDetError = new String[] {""} ;
      BC002A5_A712ImpLiqDetLegSis = new String[] {""} ;
      BC002A5_A713ImpLiqDetConSis = new String[] {""} ;
      BC002A5_A714ImpLiqDetConSisYDes = new String[] {""} ;
      BC002A5_A715ImpLiqDetCantNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002A5_A716ImpLiqDetImpNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002A5_A718ImpLiqDetLiqClase = new String[] {""} ;
      BC002A5_A2184ImpLiqDetTipoCon = new String[] {""} ;
      BC002A5_A3CliCod = new int[1] ;
      BC002A5_A1EmpCod = new short[1] ;
      BC002A5_A88ImpLiqSec = new short[1] ;
      BC002A6_A3CliCod = new int[1] ;
      BC002A7_A3CliCod = new int[1] ;
      BC002A7_A1EmpCod = new short[1] ;
      BC002A7_A88ImpLiqSec = new short[1] ;
      BC002A7_A90ImpLiqDetSec = new short[1] ;
      BC002A8_A90ImpLiqDetSec = new short[1] ;
      BC002A8_A661ImpLiqDetPer = new String[] {""} ;
      BC002A8_A662ImpLiqDetLiqN = new String[] {""} ;
      BC002A8_A663ImpLiqDetCUIL = new String[] {""} ;
      BC002A8_A664ImpLiqDetLegId = new String[] {""} ;
      BC002A8_A665ImpLiqDetCBU = new String[] {""} ;
      BC002A8_A666ImpLiqDetConCod = new String[] {""} ;
      BC002A8_A2188ImpLiqDetConYDes = new String[] {""} ;
      BC002A8_A667ImpLiqDetCant = new String[] {""} ;
      BC002A8_A668ImpLiqDetUni = new String[] {""} ;
      BC002A8_A669ImpLiqDetImp = new String[] {""} ;
      BC002A8_A670ImpLiqDetSigno = new String[] {""} ;
      BC002A8_A671ImpLiqDetConyu = new String[] {""} ;
      BC002A8_A672ImpLiqDetHijos = new String[] {""} ;
      BC002A8_A673ImpLiqDetCCT = new String[] {""} ;
      BC002A8_A674ImpLiqDetSCVO = new String[] {""} ;
      BC002A8_A709ImpLiqDetError = new String[] {""} ;
      BC002A8_A712ImpLiqDetLegSis = new String[] {""} ;
      BC002A8_A713ImpLiqDetConSis = new String[] {""} ;
      BC002A8_A714ImpLiqDetConSisYDes = new String[] {""} ;
      BC002A8_A715ImpLiqDetCantNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002A8_A716ImpLiqDetImpNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002A8_A718ImpLiqDetLiqClase = new String[] {""} ;
      BC002A8_A2184ImpLiqDetTipoCon = new String[] {""} ;
      BC002A8_A3CliCod = new int[1] ;
      BC002A8_A1EmpCod = new short[1] ;
      BC002A8_A88ImpLiqSec = new short[1] ;
      sMode78 = "" ;
      BC002A9_A90ImpLiqDetSec = new short[1] ;
      BC002A9_A661ImpLiqDetPer = new String[] {""} ;
      BC002A9_A662ImpLiqDetLiqN = new String[] {""} ;
      BC002A9_A663ImpLiqDetCUIL = new String[] {""} ;
      BC002A9_A664ImpLiqDetLegId = new String[] {""} ;
      BC002A9_A665ImpLiqDetCBU = new String[] {""} ;
      BC002A9_A666ImpLiqDetConCod = new String[] {""} ;
      BC002A9_A2188ImpLiqDetConYDes = new String[] {""} ;
      BC002A9_A667ImpLiqDetCant = new String[] {""} ;
      BC002A9_A668ImpLiqDetUni = new String[] {""} ;
      BC002A9_A669ImpLiqDetImp = new String[] {""} ;
      BC002A9_A670ImpLiqDetSigno = new String[] {""} ;
      BC002A9_A671ImpLiqDetConyu = new String[] {""} ;
      BC002A9_A672ImpLiqDetHijos = new String[] {""} ;
      BC002A9_A673ImpLiqDetCCT = new String[] {""} ;
      BC002A9_A674ImpLiqDetSCVO = new String[] {""} ;
      BC002A9_A709ImpLiqDetError = new String[] {""} ;
      BC002A9_A712ImpLiqDetLegSis = new String[] {""} ;
      BC002A9_A713ImpLiqDetConSis = new String[] {""} ;
      BC002A9_A714ImpLiqDetConSisYDes = new String[] {""} ;
      BC002A9_A715ImpLiqDetCantNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002A9_A716ImpLiqDetImpNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002A9_A718ImpLiqDetLiqClase = new String[] {""} ;
      BC002A9_A2184ImpLiqDetTipoCon = new String[] {""} ;
      BC002A9_A3CliCod = new int[1] ;
      BC002A9_A1EmpCod = new short[1] ;
      BC002A9_A88ImpLiqSec = new short[1] ;
      BC002A13_A90ImpLiqDetSec = new short[1] ;
      BC002A13_A661ImpLiqDetPer = new String[] {""} ;
      BC002A13_A662ImpLiqDetLiqN = new String[] {""} ;
      BC002A13_A663ImpLiqDetCUIL = new String[] {""} ;
      BC002A13_A664ImpLiqDetLegId = new String[] {""} ;
      BC002A13_A665ImpLiqDetCBU = new String[] {""} ;
      BC002A13_A666ImpLiqDetConCod = new String[] {""} ;
      BC002A13_A2188ImpLiqDetConYDes = new String[] {""} ;
      BC002A13_A667ImpLiqDetCant = new String[] {""} ;
      BC002A13_A668ImpLiqDetUni = new String[] {""} ;
      BC002A13_A669ImpLiqDetImp = new String[] {""} ;
      BC002A13_A670ImpLiqDetSigno = new String[] {""} ;
      BC002A13_A671ImpLiqDetConyu = new String[] {""} ;
      BC002A13_A672ImpLiqDetHijos = new String[] {""} ;
      BC002A13_A673ImpLiqDetCCT = new String[] {""} ;
      BC002A13_A674ImpLiqDetSCVO = new String[] {""} ;
      BC002A13_A709ImpLiqDetError = new String[] {""} ;
      BC002A13_A712ImpLiqDetLegSis = new String[] {""} ;
      BC002A13_A713ImpLiqDetConSis = new String[] {""} ;
      BC002A13_A714ImpLiqDetConSisYDes = new String[] {""} ;
      BC002A13_A715ImpLiqDetCantNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002A13_A716ImpLiqDetImpNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002A13_A718ImpLiqDetLiqClase = new String[] {""} ;
      BC002A13_A2184ImpLiqDetTipoCon = new String[] {""} ;
      BC002A13_A3CliCod = new int[1] ;
      BC002A13_A1EmpCod = new short[1] ;
      BC002A13_A88ImpLiqSec = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC002A14_A3CliCod = new int[1] ;
      BC002A15_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importacion_liquidacion_detalle_bc__default(),
         new Object[] {
             new Object[] {
            BC002A2_A90ImpLiqDetSec, BC002A2_A661ImpLiqDetPer, BC002A2_A662ImpLiqDetLiqN, BC002A2_A663ImpLiqDetCUIL, BC002A2_A664ImpLiqDetLegId, BC002A2_A665ImpLiqDetCBU, BC002A2_A666ImpLiqDetConCod, BC002A2_A2188ImpLiqDetConYDes, BC002A2_A667ImpLiqDetCant, BC002A2_A668ImpLiqDetUni,
            BC002A2_A669ImpLiqDetImp, BC002A2_A670ImpLiqDetSigno, BC002A2_A671ImpLiqDetConyu, BC002A2_A672ImpLiqDetHijos, BC002A2_A673ImpLiqDetCCT, BC002A2_A674ImpLiqDetSCVO, BC002A2_A709ImpLiqDetError, BC002A2_A712ImpLiqDetLegSis, BC002A2_A713ImpLiqDetConSis, BC002A2_A714ImpLiqDetConSisYDes,
            BC002A2_A715ImpLiqDetCantNum, BC002A2_A716ImpLiqDetImpNum, BC002A2_A718ImpLiqDetLiqClase, BC002A2_A2184ImpLiqDetTipoCon, BC002A2_A3CliCod, BC002A2_A1EmpCod, BC002A2_A88ImpLiqSec
            }
            , new Object[] {
            BC002A3_A90ImpLiqDetSec, BC002A3_A661ImpLiqDetPer, BC002A3_A662ImpLiqDetLiqN, BC002A3_A663ImpLiqDetCUIL, BC002A3_A664ImpLiqDetLegId, BC002A3_A665ImpLiqDetCBU, BC002A3_A666ImpLiqDetConCod, BC002A3_A2188ImpLiqDetConYDes, BC002A3_A667ImpLiqDetCant, BC002A3_A668ImpLiqDetUni,
            BC002A3_A669ImpLiqDetImp, BC002A3_A670ImpLiqDetSigno, BC002A3_A671ImpLiqDetConyu, BC002A3_A672ImpLiqDetHijos, BC002A3_A673ImpLiqDetCCT, BC002A3_A674ImpLiqDetSCVO, BC002A3_A709ImpLiqDetError, BC002A3_A712ImpLiqDetLegSis, BC002A3_A713ImpLiqDetConSis, BC002A3_A714ImpLiqDetConSisYDes,
            BC002A3_A715ImpLiqDetCantNum, BC002A3_A716ImpLiqDetImpNum, BC002A3_A718ImpLiqDetLiqClase, BC002A3_A2184ImpLiqDetTipoCon, BC002A3_A3CliCod, BC002A3_A1EmpCod, BC002A3_A88ImpLiqSec
            }
            , new Object[] {
            BC002A4_A3CliCod
            }
            , new Object[] {
            BC002A5_A90ImpLiqDetSec, BC002A5_A661ImpLiqDetPer, BC002A5_A662ImpLiqDetLiqN, BC002A5_A663ImpLiqDetCUIL, BC002A5_A664ImpLiqDetLegId, BC002A5_A665ImpLiqDetCBU, BC002A5_A666ImpLiqDetConCod, BC002A5_A2188ImpLiqDetConYDes, BC002A5_A667ImpLiqDetCant, BC002A5_A668ImpLiqDetUni,
            BC002A5_A669ImpLiqDetImp, BC002A5_A670ImpLiqDetSigno, BC002A5_A671ImpLiqDetConyu, BC002A5_A672ImpLiqDetHijos, BC002A5_A673ImpLiqDetCCT, BC002A5_A674ImpLiqDetSCVO, BC002A5_A709ImpLiqDetError, BC002A5_A712ImpLiqDetLegSis, BC002A5_A713ImpLiqDetConSis, BC002A5_A714ImpLiqDetConSisYDes,
            BC002A5_A715ImpLiqDetCantNum, BC002A5_A716ImpLiqDetImpNum, BC002A5_A718ImpLiqDetLiqClase, BC002A5_A2184ImpLiqDetTipoCon, BC002A5_A3CliCod, BC002A5_A1EmpCod, BC002A5_A88ImpLiqSec
            }
            , new Object[] {
            BC002A6_A3CliCod
            }
            , new Object[] {
            BC002A7_A3CliCod, BC002A7_A1EmpCod, BC002A7_A88ImpLiqSec, BC002A7_A90ImpLiqDetSec
            }
            , new Object[] {
            BC002A8_A90ImpLiqDetSec, BC002A8_A661ImpLiqDetPer, BC002A8_A662ImpLiqDetLiqN, BC002A8_A663ImpLiqDetCUIL, BC002A8_A664ImpLiqDetLegId, BC002A8_A665ImpLiqDetCBU, BC002A8_A666ImpLiqDetConCod, BC002A8_A2188ImpLiqDetConYDes, BC002A8_A667ImpLiqDetCant, BC002A8_A668ImpLiqDetUni,
            BC002A8_A669ImpLiqDetImp, BC002A8_A670ImpLiqDetSigno, BC002A8_A671ImpLiqDetConyu, BC002A8_A672ImpLiqDetHijos, BC002A8_A673ImpLiqDetCCT, BC002A8_A674ImpLiqDetSCVO, BC002A8_A709ImpLiqDetError, BC002A8_A712ImpLiqDetLegSis, BC002A8_A713ImpLiqDetConSis, BC002A8_A714ImpLiqDetConSisYDes,
            BC002A8_A715ImpLiqDetCantNum, BC002A8_A716ImpLiqDetImpNum, BC002A8_A718ImpLiqDetLiqClase, BC002A8_A2184ImpLiqDetTipoCon, BC002A8_A3CliCod, BC002A8_A1EmpCod, BC002A8_A88ImpLiqSec
            }
            , new Object[] {
            BC002A9_A90ImpLiqDetSec, BC002A9_A661ImpLiqDetPer, BC002A9_A662ImpLiqDetLiqN, BC002A9_A663ImpLiqDetCUIL, BC002A9_A664ImpLiqDetLegId, BC002A9_A665ImpLiqDetCBU, BC002A9_A666ImpLiqDetConCod, BC002A9_A2188ImpLiqDetConYDes, BC002A9_A667ImpLiqDetCant, BC002A9_A668ImpLiqDetUni,
            BC002A9_A669ImpLiqDetImp, BC002A9_A670ImpLiqDetSigno, BC002A9_A671ImpLiqDetConyu, BC002A9_A672ImpLiqDetHijos, BC002A9_A673ImpLiqDetCCT, BC002A9_A674ImpLiqDetSCVO, BC002A9_A709ImpLiqDetError, BC002A9_A712ImpLiqDetLegSis, BC002A9_A713ImpLiqDetConSis, BC002A9_A714ImpLiqDetConSisYDes,
            BC002A9_A715ImpLiqDetCantNum, BC002A9_A716ImpLiqDetImpNum, BC002A9_A718ImpLiqDetLiqClase, BC002A9_A2184ImpLiqDetTipoCon, BC002A9_A3CliCod, BC002A9_A1EmpCod, BC002A9_A88ImpLiqSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC002A13_A90ImpLiqDetSec, BC002A13_A661ImpLiqDetPer, BC002A13_A662ImpLiqDetLiqN, BC002A13_A663ImpLiqDetCUIL, BC002A13_A664ImpLiqDetLegId, BC002A13_A665ImpLiqDetCBU, BC002A13_A666ImpLiqDetConCod, BC002A13_A2188ImpLiqDetConYDes, BC002A13_A667ImpLiqDetCant, BC002A13_A668ImpLiqDetUni,
            BC002A13_A669ImpLiqDetImp, BC002A13_A670ImpLiqDetSigno, BC002A13_A671ImpLiqDetConyu, BC002A13_A672ImpLiqDetHijos, BC002A13_A673ImpLiqDetCCT, BC002A13_A674ImpLiqDetSCVO, BC002A13_A709ImpLiqDetError, BC002A13_A712ImpLiqDetLegSis, BC002A13_A713ImpLiqDetConSis, BC002A13_A714ImpLiqDetConSisYDes,
            BC002A13_A715ImpLiqDetCantNum, BC002A13_A716ImpLiqDetImpNum, BC002A13_A718ImpLiqDetLiqClase, BC002A13_A2184ImpLiqDetTipoCon, BC002A13_A3CliCod, BC002A13_A1EmpCod, BC002A13_A88ImpLiqSec
            }
            , new Object[] {
            BC002A14_A3CliCod
            }
            , new Object[] {
            BC002A15_A3CliCod
            }
         }
      );
      /* Execute Start event if defined. */
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short Z88ImpLiqSec ;
   private short A88ImpLiqSec ;
   private short Z90ImpLiqDetSec ;
   private short A90ImpLiqDetSec ;
   private short RcdFound78 ;
   private short nIsDirty_78 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int GX_JID ;
   private java.math.BigDecimal Z715ImpLiqDetCantNum ;
   private java.math.BigDecimal A715ImpLiqDetCantNum ;
   private java.math.BigDecimal Z716ImpLiqDetImpNum ;
   private java.math.BigDecimal A716ImpLiqDetImpNum ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z661ImpLiqDetPer ;
   private String A661ImpLiqDetPer ;
   private String Z662ImpLiqDetLiqN ;
   private String A662ImpLiqDetLiqN ;
   private String Z663ImpLiqDetCUIL ;
   private String A663ImpLiqDetCUIL ;
   private String Z664ImpLiqDetLegId ;
   private String A664ImpLiqDetLegId ;
   private String Z666ImpLiqDetConCod ;
   private String A666ImpLiqDetConCod ;
   private String Z667ImpLiqDetCant ;
   private String A667ImpLiqDetCant ;
   private String Z668ImpLiqDetUni ;
   private String A668ImpLiqDetUni ;
   private String Z669ImpLiqDetImp ;
   private String A669ImpLiqDetImp ;
   private String Z670ImpLiqDetSigno ;
   private String A670ImpLiqDetSigno ;
   private String Z671ImpLiqDetConyu ;
   private String A671ImpLiqDetConyu ;
   private String Z672ImpLiqDetHijos ;
   private String A672ImpLiqDetHijos ;
   private String Z673ImpLiqDetCCT ;
   private String A673ImpLiqDetCCT ;
   private String Z674ImpLiqDetSCVO ;
   private String A674ImpLiqDetSCVO ;
   private String Z713ImpLiqDetConSis ;
   private String A713ImpLiqDetConSis ;
   private String Z718ImpLiqDetLiqClase ;
   private String A718ImpLiqDetLiqClase ;
   private String Z2184ImpLiqDetTipoCon ;
   private String A2184ImpLiqDetTipoCon ;
   private String sMode78 ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z665ImpLiqDetCBU ;
   private String A665ImpLiqDetCBU ;
   private String Z2188ImpLiqDetConYDes ;
   private String A2188ImpLiqDetConYDes ;
   private String Z709ImpLiqDetError ;
   private String A709ImpLiqDetError ;
   private String Z712ImpLiqDetLegSis ;
   private String A712ImpLiqDetLegSis ;
   private String Z714ImpLiqDetConSisYDes ;
   private String A714ImpLiqDetConSisYDes ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private web.Sdtimportacion_liquidacion_detalle bcimportacion_liquidacion_detalle ;
   private IDataStoreProvider pr_default ;
   private short[] BC002A5_A90ImpLiqDetSec ;
   private String[] BC002A5_A661ImpLiqDetPer ;
   private String[] BC002A5_A662ImpLiqDetLiqN ;
   private String[] BC002A5_A663ImpLiqDetCUIL ;
   private String[] BC002A5_A664ImpLiqDetLegId ;
   private String[] BC002A5_A665ImpLiqDetCBU ;
   private String[] BC002A5_A666ImpLiqDetConCod ;
   private String[] BC002A5_A2188ImpLiqDetConYDes ;
   private String[] BC002A5_A667ImpLiqDetCant ;
   private String[] BC002A5_A668ImpLiqDetUni ;
   private String[] BC002A5_A669ImpLiqDetImp ;
   private String[] BC002A5_A670ImpLiqDetSigno ;
   private String[] BC002A5_A671ImpLiqDetConyu ;
   private String[] BC002A5_A672ImpLiqDetHijos ;
   private String[] BC002A5_A673ImpLiqDetCCT ;
   private String[] BC002A5_A674ImpLiqDetSCVO ;
   private String[] BC002A5_A709ImpLiqDetError ;
   private String[] BC002A5_A712ImpLiqDetLegSis ;
   private String[] BC002A5_A713ImpLiqDetConSis ;
   private String[] BC002A5_A714ImpLiqDetConSisYDes ;
   private java.math.BigDecimal[] BC002A5_A715ImpLiqDetCantNum ;
   private java.math.BigDecimal[] BC002A5_A716ImpLiqDetImpNum ;
   private String[] BC002A5_A718ImpLiqDetLiqClase ;
   private String[] BC002A5_A2184ImpLiqDetTipoCon ;
   private int[] BC002A5_A3CliCod ;
   private short[] BC002A5_A1EmpCod ;
   private short[] BC002A5_A88ImpLiqSec ;
   private int[] BC002A6_A3CliCod ;
   private int[] BC002A7_A3CliCod ;
   private short[] BC002A7_A1EmpCod ;
   private short[] BC002A7_A88ImpLiqSec ;
   private short[] BC002A7_A90ImpLiqDetSec ;
   private short[] BC002A8_A90ImpLiqDetSec ;
   private String[] BC002A8_A661ImpLiqDetPer ;
   private String[] BC002A8_A662ImpLiqDetLiqN ;
   private String[] BC002A8_A663ImpLiqDetCUIL ;
   private String[] BC002A8_A664ImpLiqDetLegId ;
   private String[] BC002A8_A665ImpLiqDetCBU ;
   private String[] BC002A8_A666ImpLiqDetConCod ;
   private String[] BC002A8_A2188ImpLiqDetConYDes ;
   private String[] BC002A8_A667ImpLiqDetCant ;
   private String[] BC002A8_A668ImpLiqDetUni ;
   private String[] BC002A8_A669ImpLiqDetImp ;
   private String[] BC002A8_A670ImpLiqDetSigno ;
   private String[] BC002A8_A671ImpLiqDetConyu ;
   private String[] BC002A8_A672ImpLiqDetHijos ;
   private String[] BC002A8_A673ImpLiqDetCCT ;
   private String[] BC002A8_A674ImpLiqDetSCVO ;
   private String[] BC002A8_A709ImpLiqDetError ;
   private String[] BC002A8_A712ImpLiqDetLegSis ;
   private String[] BC002A8_A713ImpLiqDetConSis ;
   private String[] BC002A8_A714ImpLiqDetConSisYDes ;
   private java.math.BigDecimal[] BC002A8_A715ImpLiqDetCantNum ;
   private java.math.BigDecimal[] BC002A8_A716ImpLiqDetImpNum ;
   private String[] BC002A8_A718ImpLiqDetLiqClase ;
   private String[] BC002A8_A2184ImpLiqDetTipoCon ;
   private int[] BC002A8_A3CliCod ;
   private short[] BC002A8_A1EmpCod ;
   private short[] BC002A8_A88ImpLiqSec ;
   private short[] BC002A9_A90ImpLiqDetSec ;
   private String[] BC002A9_A661ImpLiqDetPer ;
   private String[] BC002A9_A662ImpLiqDetLiqN ;
   private String[] BC002A9_A663ImpLiqDetCUIL ;
   private String[] BC002A9_A664ImpLiqDetLegId ;
   private String[] BC002A9_A665ImpLiqDetCBU ;
   private String[] BC002A9_A666ImpLiqDetConCod ;
   private String[] BC002A9_A2188ImpLiqDetConYDes ;
   private String[] BC002A9_A667ImpLiqDetCant ;
   private String[] BC002A9_A668ImpLiqDetUni ;
   private String[] BC002A9_A669ImpLiqDetImp ;
   private String[] BC002A9_A670ImpLiqDetSigno ;
   private String[] BC002A9_A671ImpLiqDetConyu ;
   private String[] BC002A9_A672ImpLiqDetHijos ;
   private String[] BC002A9_A673ImpLiqDetCCT ;
   private String[] BC002A9_A674ImpLiqDetSCVO ;
   private String[] BC002A9_A709ImpLiqDetError ;
   private String[] BC002A9_A712ImpLiqDetLegSis ;
   private String[] BC002A9_A713ImpLiqDetConSis ;
   private String[] BC002A9_A714ImpLiqDetConSisYDes ;
   private java.math.BigDecimal[] BC002A9_A715ImpLiqDetCantNum ;
   private java.math.BigDecimal[] BC002A9_A716ImpLiqDetImpNum ;
   private String[] BC002A9_A718ImpLiqDetLiqClase ;
   private String[] BC002A9_A2184ImpLiqDetTipoCon ;
   private int[] BC002A9_A3CliCod ;
   private short[] BC002A9_A1EmpCod ;
   private short[] BC002A9_A88ImpLiqSec ;
   private short[] BC002A13_A90ImpLiqDetSec ;
   private String[] BC002A13_A661ImpLiqDetPer ;
   private String[] BC002A13_A662ImpLiqDetLiqN ;
   private String[] BC002A13_A663ImpLiqDetCUIL ;
   private String[] BC002A13_A664ImpLiqDetLegId ;
   private String[] BC002A13_A665ImpLiqDetCBU ;
   private String[] BC002A13_A666ImpLiqDetConCod ;
   private String[] BC002A13_A2188ImpLiqDetConYDes ;
   private String[] BC002A13_A667ImpLiqDetCant ;
   private String[] BC002A13_A668ImpLiqDetUni ;
   private String[] BC002A13_A669ImpLiqDetImp ;
   private String[] BC002A13_A670ImpLiqDetSigno ;
   private String[] BC002A13_A671ImpLiqDetConyu ;
   private String[] BC002A13_A672ImpLiqDetHijos ;
   private String[] BC002A13_A673ImpLiqDetCCT ;
   private String[] BC002A13_A674ImpLiqDetSCVO ;
   private String[] BC002A13_A709ImpLiqDetError ;
   private String[] BC002A13_A712ImpLiqDetLegSis ;
   private String[] BC002A13_A713ImpLiqDetConSis ;
   private String[] BC002A13_A714ImpLiqDetConSisYDes ;
   private java.math.BigDecimal[] BC002A13_A715ImpLiqDetCantNum ;
   private java.math.BigDecimal[] BC002A13_A716ImpLiqDetImpNum ;
   private String[] BC002A13_A718ImpLiqDetLiqClase ;
   private String[] BC002A13_A2184ImpLiqDetTipoCon ;
   private int[] BC002A13_A3CliCod ;
   private short[] BC002A13_A1EmpCod ;
   private short[] BC002A13_A88ImpLiqSec ;
   private int[] BC002A14_A3CliCod ;
   private int[] BC002A15_A3CliCod ;
   private short[] BC002A2_A90ImpLiqDetSec ;
   private String[] BC002A2_A661ImpLiqDetPer ;
   private String[] BC002A2_A662ImpLiqDetLiqN ;
   private String[] BC002A2_A663ImpLiqDetCUIL ;
   private String[] BC002A2_A664ImpLiqDetLegId ;
   private String[] BC002A2_A665ImpLiqDetCBU ;
   private String[] BC002A2_A666ImpLiqDetConCod ;
   private String[] BC002A2_A2188ImpLiqDetConYDes ;
   private String[] BC002A2_A667ImpLiqDetCant ;
   private String[] BC002A2_A668ImpLiqDetUni ;
   private String[] BC002A2_A669ImpLiqDetImp ;
   private String[] BC002A2_A670ImpLiqDetSigno ;
   private String[] BC002A2_A671ImpLiqDetConyu ;
   private String[] BC002A2_A672ImpLiqDetHijos ;
   private String[] BC002A2_A673ImpLiqDetCCT ;
   private String[] BC002A2_A674ImpLiqDetSCVO ;
   private String[] BC002A2_A709ImpLiqDetError ;
   private String[] BC002A2_A712ImpLiqDetLegSis ;
   private String[] BC002A2_A713ImpLiqDetConSis ;
   private String[] BC002A2_A714ImpLiqDetConSisYDes ;
   private java.math.BigDecimal[] BC002A2_A715ImpLiqDetCantNum ;
   private java.math.BigDecimal[] BC002A2_A716ImpLiqDetImpNum ;
   private String[] BC002A2_A718ImpLiqDetLiqClase ;
   private String[] BC002A2_A2184ImpLiqDetTipoCon ;
   private int[] BC002A2_A3CliCod ;
   private short[] BC002A2_A1EmpCod ;
   private short[] BC002A2_A88ImpLiqSec ;
   private short[] BC002A3_A90ImpLiqDetSec ;
   private String[] BC002A3_A661ImpLiqDetPer ;
   private String[] BC002A3_A662ImpLiqDetLiqN ;
   private String[] BC002A3_A663ImpLiqDetCUIL ;
   private String[] BC002A3_A664ImpLiqDetLegId ;
   private String[] BC002A3_A665ImpLiqDetCBU ;
   private String[] BC002A3_A666ImpLiqDetConCod ;
   private String[] BC002A3_A2188ImpLiqDetConYDes ;
   private String[] BC002A3_A667ImpLiqDetCant ;
   private String[] BC002A3_A668ImpLiqDetUni ;
   private String[] BC002A3_A669ImpLiqDetImp ;
   private String[] BC002A3_A670ImpLiqDetSigno ;
   private String[] BC002A3_A671ImpLiqDetConyu ;
   private String[] BC002A3_A672ImpLiqDetHijos ;
   private String[] BC002A3_A673ImpLiqDetCCT ;
   private String[] BC002A3_A674ImpLiqDetSCVO ;
   private String[] BC002A3_A709ImpLiqDetError ;
   private String[] BC002A3_A712ImpLiqDetLegSis ;
   private String[] BC002A3_A713ImpLiqDetConSis ;
   private String[] BC002A3_A714ImpLiqDetConSisYDes ;
   private java.math.BigDecimal[] BC002A3_A715ImpLiqDetCantNum ;
   private java.math.BigDecimal[] BC002A3_A716ImpLiqDetImpNum ;
   private String[] BC002A3_A718ImpLiqDetLiqClase ;
   private String[] BC002A3_A2184ImpLiqDetTipoCon ;
   private int[] BC002A3_A3CliCod ;
   private short[] BC002A3_A1EmpCod ;
   private short[] BC002A3_A88ImpLiqSec ;
   private int[] BC002A4_A3CliCod ;
}

final  class importacion_liquidacion_detalle_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC002A2", "SELECT ImpLiqDetSec, ImpLiqDetPer, ImpLiqDetLiqN, ImpLiqDetCUIL, ImpLiqDetLegId, ImpLiqDetCBU, ImpLiqDetConCod, ImpLiqDetConYDes, ImpLiqDetCant, ImpLiqDetUni, ImpLiqDetImp, ImpLiqDetSigno, ImpLiqDetConyu, ImpLiqDetHijos, ImpLiqDetCCT, ImpLiqDetSCVO, ImpLiqDetError, ImpLiqDetLegSis, ImpLiqDetConSis, ImpLiqDetConSisYDes, ImpLiqDetCantNum, ImpLiqDetImpNum, ImpLiqDetLiqClase, ImpLiqDetTipoCon, CliCod, EmpCod, ImpLiqSec FROM importacion_liquidacion_detalle WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqDetSec = ?  FOR UPDATE OF importacion_liquidacion_detalle",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002A3", "SELECT ImpLiqDetSec, ImpLiqDetPer, ImpLiqDetLiqN, ImpLiqDetCUIL, ImpLiqDetLegId, ImpLiqDetCBU, ImpLiqDetConCod, ImpLiqDetConYDes, ImpLiqDetCant, ImpLiqDetUni, ImpLiqDetImp, ImpLiqDetSigno, ImpLiqDetConyu, ImpLiqDetHijos, ImpLiqDetCCT, ImpLiqDetSCVO, ImpLiqDetError, ImpLiqDetLegSis, ImpLiqDetConSis, ImpLiqDetConSisYDes, ImpLiqDetCantNum, ImpLiqDetImpNum, ImpLiqDetLiqClase, ImpLiqDetTipoCon, CliCod, EmpCod, ImpLiqSec FROM importacion_liquidacion_detalle WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqDetSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002A4", "SELECT CliCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002A5", "SELECT TM1.ImpLiqDetSec, TM1.ImpLiqDetPer, TM1.ImpLiqDetLiqN, TM1.ImpLiqDetCUIL, TM1.ImpLiqDetLegId, TM1.ImpLiqDetCBU, TM1.ImpLiqDetConCod, TM1.ImpLiqDetConYDes, TM1.ImpLiqDetCant, TM1.ImpLiqDetUni, TM1.ImpLiqDetImp, TM1.ImpLiqDetSigno, TM1.ImpLiqDetConyu, TM1.ImpLiqDetHijos, TM1.ImpLiqDetCCT, TM1.ImpLiqDetSCVO, TM1.ImpLiqDetError, TM1.ImpLiqDetLegSis, TM1.ImpLiqDetConSis, TM1.ImpLiqDetConSisYDes, TM1.ImpLiqDetCantNum, TM1.ImpLiqDetImpNum, TM1.ImpLiqDetLiqClase, TM1.ImpLiqDetTipoCon, TM1.CliCod, TM1.EmpCod, TM1.ImpLiqSec FROM importacion_liquidacion_detalle TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.ImpLiqSec = ? and TM1.ImpLiqDetSec = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.ImpLiqSec, TM1.ImpLiqDetSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002A6", "SELECT CliCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002A7", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec FROM importacion_liquidacion_detalle WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqDetSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002A8", "SELECT ImpLiqDetSec, ImpLiqDetPer, ImpLiqDetLiqN, ImpLiqDetCUIL, ImpLiqDetLegId, ImpLiqDetCBU, ImpLiqDetConCod, ImpLiqDetConYDes, ImpLiqDetCant, ImpLiqDetUni, ImpLiqDetImp, ImpLiqDetSigno, ImpLiqDetConyu, ImpLiqDetHijos, ImpLiqDetCCT, ImpLiqDetSCVO, ImpLiqDetError, ImpLiqDetLegSis, ImpLiqDetConSis, ImpLiqDetConSisYDes, ImpLiqDetCantNum, ImpLiqDetImpNum, ImpLiqDetLiqClase, ImpLiqDetTipoCon, CliCod, EmpCod, ImpLiqSec FROM importacion_liquidacion_detalle WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqDetSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002A9", "SELECT ImpLiqDetSec, ImpLiqDetPer, ImpLiqDetLiqN, ImpLiqDetCUIL, ImpLiqDetLegId, ImpLiqDetCBU, ImpLiqDetConCod, ImpLiqDetConYDes, ImpLiqDetCant, ImpLiqDetUni, ImpLiqDetImp, ImpLiqDetSigno, ImpLiqDetConyu, ImpLiqDetHijos, ImpLiqDetCCT, ImpLiqDetSCVO, ImpLiqDetError, ImpLiqDetLegSis, ImpLiqDetConSis, ImpLiqDetConSisYDes, ImpLiqDetCantNum, ImpLiqDetImpNum, ImpLiqDetLiqClase, ImpLiqDetTipoCon, CliCod, EmpCod, ImpLiqSec FROM importacion_liquidacion_detalle WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqDetSec = ?  FOR UPDATE OF importacion_liquidacion_detalle",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC002A10", "SAVEPOINT gxupdate;INSERT INTO importacion_liquidacion_detalle(ImpLiqDetSec, ImpLiqDetPer, ImpLiqDetLiqN, ImpLiqDetCUIL, ImpLiqDetLegId, ImpLiqDetCBU, ImpLiqDetConCod, ImpLiqDetConYDes, ImpLiqDetCant, ImpLiqDetUni, ImpLiqDetImp, ImpLiqDetSigno, ImpLiqDetConyu, ImpLiqDetHijos, ImpLiqDetCCT, ImpLiqDetSCVO, ImpLiqDetError, ImpLiqDetLegSis, ImpLiqDetConSis, ImpLiqDetConSisYDes, ImpLiqDetCantNum, ImpLiqDetImpNum, ImpLiqDetLiqClase, ImpLiqDetTipoCon, CliCod, EmpCod, ImpLiqSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002A11", "SAVEPOINT gxupdate;UPDATE importacion_liquidacion_detalle SET ImpLiqDetPer=?, ImpLiqDetLiqN=?, ImpLiqDetCUIL=?, ImpLiqDetLegId=?, ImpLiqDetCBU=?, ImpLiqDetConCod=?, ImpLiqDetConYDes=?, ImpLiqDetCant=?, ImpLiqDetUni=?, ImpLiqDetImp=?, ImpLiqDetSigno=?, ImpLiqDetConyu=?, ImpLiqDetHijos=?, ImpLiqDetCCT=?, ImpLiqDetSCVO=?, ImpLiqDetError=?, ImpLiqDetLegSis=?, ImpLiqDetConSis=?, ImpLiqDetConSisYDes=?, ImpLiqDetCantNum=?, ImpLiqDetImpNum=?, ImpLiqDetLiqClase=?, ImpLiqDetTipoCon=?  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqDetSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002A12", "SAVEPOINT gxupdate;DELETE FROM importacion_liquidacion_detalle  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqDetSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC002A13", "SELECT TM1.ImpLiqDetSec, TM1.ImpLiqDetPer, TM1.ImpLiqDetLiqN, TM1.ImpLiqDetCUIL, TM1.ImpLiqDetLegId, TM1.ImpLiqDetCBU, TM1.ImpLiqDetConCod, TM1.ImpLiqDetConYDes, TM1.ImpLiqDetCant, TM1.ImpLiqDetUni, TM1.ImpLiqDetImp, TM1.ImpLiqDetSigno, TM1.ImpLiqDetConyu, TM1.ImpLiqDetHijos, TM1.ImpLiqDetCCT, TM1.ImpLiqDetSCVO, TM1.ImpLiqDetError, TM1.ImpLiqDetLegSis, TM1.ImpLiqDetConSis, TM1.ImpLiqDetConSisYDes, TM1.ImpLiqDetCantNum, TM1.ImpLiqDetImpNum, TM1.ImpLiqDetLiqClase, TM1.ImpLiqDetTipoCon, TM1.CliCod, TM1.EmpCod, TM1.ImpLiqSec FROM importacion_liquidacion_detalle TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.ImpLiqSec = ? and TM1.ImpLiqDetSec = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.ImpLiqSec, TM1.ImpLiqDetSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002A14", "SELECT CliCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002A15", "SELECT CliCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((String[]) buf[3])[0] = rslt.getString(4, 11);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 5);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 15);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((String[]) buf[13])[0] = rslt.getString(14, 2);
               ((String[]) buf[14])[0] = rslt.getString(15, 1);
               ((String[]) buf[15])[0] = rslt.getString(16, 1);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 10);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,2);
               ((String[]) buf[22])[0] = rslt.getString(23, 1);
               ((String[]) buf[23])[0] = rslt.getString(24, 20);
               ((int[]) buf[24])[0] = rslt.getInt(25);
               ((short[]) buf[25])[0] = rslt.getShort(26);
               ((short[]) buf[26])[0] = rslt.getShort(27);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((String[]) buf[3])[0] = rslt.getString(4, 11);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 5);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 15);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((String[]) buf[13])[0] = rslt.getString(14, 2);
               ((String[]) buf[14])[0] = rslt.getString(15, 1);
               ((String[]) buf[15])[0] = rslt.getString(16, 1);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 10);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,2);
               ((String[]) buf[22])[0] = rslt.getString(23, 1);
               ((String[]) buf[23])[0] = rslt.getString(24, 20);
               ((int[]) buf[24])[0] = rslt.getInt(25);
               ((short[]) buf[25])[0] = rslt.getShort(26);
               ((short[]) buf[26])[0] = rslt.getShort(27);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((String[]) buf[3])[0] = rslt.getString(4, 11);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 5);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 15);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((String[]) buf[13])[0] = rslt.getString(14, 2);
               ((String[]) buf[14])[0] = rslt.getString(15, 1);
               ((String[]) buf[15])[0] = rslt.getString(16, 1);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 10);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,2);
               ((String[]) buf[22])[0] = rslt.getString(23, 1);
               ((String[]) buf[23])[0] = rslt.getString(24, 20);
               ((int[]) buf[24])[0] = rslt.getInt(25);
               ((short[]) buf[25])[0] = rslt.getShort(26);
               ((short[]) buf[26])[0] = rslt.getShort(27);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((String[]) buf[3])[0] = rslt.getString(4, 11);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 5);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 15);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((String[]) buf[13])[0] = rslt.getString(14, 2);
               ((String[]) buf[14])[0] = rslt.getString(15, 1);
               ((String[]) buf[15])[0] = rslt.getString(16, 1);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 10);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,2);
               ((String[]) buf[22])[0] = rslt.getString(23, 1);
               ((String[]) buf[23])[0] = rslt.getString(24, 20);
               ((int[]) buf[24])[0] = rslt.getInt(25);
               ((short[]) buf[25])[0] = rslt.getShort(26);
               ((short[]) buf[26])[0] = rslt.getShort(27);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((String[]) buf[3])[0] = rslt.getString(4, 11);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 5);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 15);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((String[]) buf[13])[0] = rslt.getString(14, 2);
               ((String[]) buf[14])[0] = rslt.getString(15, 1);
               ((String[]) buf[15])[0] = rslt.getString(16, 1);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 10);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,2);
               ((String[]) buf[22])[0] = rslt.getString(23, 1);
               ((String[]) buf[23])[0] = rslt.getString(24, 20);
               ((int[]) buf[24])[0] = rslt.getInt(25);
               ((short[]) buf[25])[0] = rslt.getShort(26);
               ((short[]) buf[26])[0] = rslt.getShort(27);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((String[]) buf[3])[0] = rslt.getString(4, 11);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 5);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 15);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((String[]) buf[13])[0] = rslt.getString(14, 2);
               ((String[]) buf[14])[0] = rslt.getString(15, 1);
               ((String[]) buf[15])[0] = rslt.getString(16, 1);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getString(19, 10);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,2);
               ((String[]) buf[22])[0] = rslt.getString(23, 1);
               ((String[]) buf[23])[0] = rslt.getString(24, 20);
               ((int[]) buf[24])[0] = rslt.getInt(25);
               ((short[]) buf[25])[0] = rslt.getShort(26);
               ((short[]) buf[26])[0] = rslt.getShort(27);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 6);
               stmt.setString(3, (String)parms[2], 5);
               stmt.setString(4, (String)parms[3], 11);
               stmt.setString(5, (String)parms[4], 10);
               stmt.setVarchar(6, (String)parms[5], 22, false);
               stmt.setString(7, (String)parms[6], 10);
               stmt.setVarchar(8, (String)parms[7], 400, false);
               stmt.setString(9, (String)parms[8], 5);
               stmt.setString(10, (String)parms[9], 1);
               stmt.setString(11, (String)parms[10], 15);
               stmt.setString(12, (String)parms[11], 1);
               stmt.setString(13, (String)parms[12], 1);
               stmt.setString(14, (String)parms[13], 2);
               stmt.setString(15, (String)parms[14], 1);
               stmt.setString(16, (String)parms[15], 1);
               stmt.setVarchar(17, (String)parms[16], 400, false);
               stmt.setVarchar(18, (String)parms[17], 400, false);
               stmt.setString(19, (String)parms[18], 10);
               stmt.setVarchar(20, (String)parms[19], 400, false);
               stmt.setBigDecimal(21, (java.math.BigDecimal)parms[20], 2);
               stmt.setBigDecimal(22, (java.math.BigDecimal)parms[21], 2);
               stmt.setString(23, (String)parms[22], 1);
               stmt.setString(24, (String)parms[23], 20);
               stmt.setInt(25, ((Number) parms[24]).intValue());
               stmt.setShort(26, ((Number) parms[25]).shortValue());
               stmt.setShort(27, ((Number) parms[26]).shortValue());
               return;
            case 9 :
               stmt.setString(1, (String)parms[0], 6);
               stmt.setString(2, (String)parms[1], 5);
               stmt.setString(3, (String)parms[2], 11);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setVarchar(5, (String)parms[4], 22, false);
               stmt.setString(6, (String)parms[5], 10);
               stmt.setVarchar(7, (String)parms[6], 400, false);
               stmt.setString(8, (String)parms[7], 5);
               stmt.setString(9, (String)parms[8], 1);
               stmt.setString(10, (String)parms[9], 15);
               stmt.setString(11, (String)parms[10], 1);
               stmt.setString(12, (String)parms[11], 1);
               stmt.setString(13, (String)parms[12], 2);
               stmt.setString(14, (String)parms[13], 1);
               stmt.setString(15, (String)parms[14], 1);
               stmt.setVarchar(16, (String)parms[15], 400, false);
               stmt.setVarchar(17, (String)parms[16], 400, false);
               stmt.setString(18, (String)parms[17], 10);
               stmt.setVarchar(19, (String)parms[18], 400, false);
               stmt.setBigDecimal(20, (java.math.BigDecimal)parms[19], 2);
               stmt.setBigDecimal(21, (java.math.BigDecimal)parms[20], 2);
               stmt.setString(22, (String)parms[21], 1);
               stmt.setString(23, (String)parms[22], 20);
               stmt.setInt(24, ((Number) parms[23]).intValue());
               stmt.setShort(25, ((Number) parms[24]).shortValue());
               stmt.setShort(26, ((Number) parms[25]).shortValue());
               stmt.setShort(27, ((Number) parms[26]).shortValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

