package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class deduccionessolapa_bc extends GXWebPanel implements IGxSilentTrn
{
   public deduccionessolapa_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public deduccionessolapa_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( deduccionessolapa_bc.class ));
   }

   public deduccionessolapa_bc( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow2572( ) ;
      standaloneNotModal( ) ;
      initializeNonKey2572( ) ;
      standaloneModal( ) ;
      addRow2572( ) ;
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
         /* Execute user event: After Trn */
         e11252 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z6LegNumero = A6LegNumero ;
            Z83LegDedSec = A83LegDedSec ;
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

   public void confirm_250( )
   {
      beforeValidate2572( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls2572( ) ;
         }
         else
         {
            checkExtendedTable2572( ) ;
            if ( AnyError == 0 )
            {
               zm2572( 10) ;
               zm2572( 11) ;
            }
            closeExtendedTableCursors2572( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e12252( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext1[0] = AV11WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV11WWPContext = GXv_SdtWWPContext1[0] ;
      AV12IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWdeduccionesSolapa_Insert", GXv_boolean3) ;
         deduccionessolapa_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWdeduccionesSolapa_Update", GXv_boolean3) ;
         deduccionessolapa_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWdeduccionesSolapa_Delete", GXv_boolean3) ;
         deduccionessolapa_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV28Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV14TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV28Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV29GXV1 = 1 ;
         while ( AV29GXV1 <= AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV17TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV29GXV1));
            if ( GXutil.strcmp(AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegDedConCodigo") == 0 )
            {
               AV16Insert_LegDedConCodigo = AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            AV29GXV1 = (int)(AV29GXV1+1) ;
         }
      }
      GXt_char4 = AV27SubTipoConCod1 ;
      GXv_char5[0] = GXt_char4 ;
      new web.subtipocalculogananciasded1(remoteHandle, context).execute( GXv_char5) ;
      deduccionessolapa_bc.this.GXt_char4 = GXv_char5[0] ;
      AV27SubTipoConCod1 = GXt_char4 ;
   }

   public void e11252( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm2572( int GX_JID )
   {
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         Z556LegDedFchDes = A556LegDedFchDes ;
         Z557LegDedFchHas = A557LegDedFchHas ;
         Z560LegDedImporte = A560LegDedImporte ;
         Z568LegDedDescrip = A568LegDedDescrip ;
         Z84LegDedConCodigo = A84LegDedConCodigo ;
         Z570LegDedConCodYDesc = A570LegDedConCodYDesc ;
      }
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         Z250LegIdNomApe = A250LegIdNomApe ;
         Z251LegNombre = A251LegNombre ;
         Z230LegApellido = A230LegApellido ;
         Z93LegId = A93LegId ;
         Z93LegId = A93LegId ;
         Z230LegApellido = A230LegApellido ;
         Z251LegNombre = A251LegNombre ;
         Z570LegDedConCodYDesc = A570LegDedConCodYDesc ;
      }
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
         Z559LegDedConDescrip = A559LegDedConDescrip ;
         Z570LegDedConCodYDesc = A570LegDedConCodYDesc ;
      }
      if ( GX_JID == -9 )
      {
         Z83LegDedSec = A83LegDedSec ;
         Z556LegDedFchDes = A556LegDedFchDes ;
         Z557LegDedFchHas = A557LegDedFchHas ;
         Z560LegDedImporte = A560LegDedImporte ;
         Z568LegDedDescrip = A568LegDedDescrip ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z84LegDedConCodigo = A84LegDedConCodigo ;
         Z250LegIdNomApe = A250LegIdNomApe ;
         Z251LegNombre = A251LegNombre ;
         Z230LegApellido = A230LegApellido ;
         Z93LegId = A93LegId ;
         Z559LegDedConDescrip = A559LegDedConDescrip ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int6 = A3CliCod ;
         GXv_int7[0] = GXt_int6 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int7) ;
         deduccionessolapa_bc.this.GXt_int6 = GXv_int7[0] ;
         A3CliCod = GXt_int6 ;
      }
   }

   public void standaloneModal( )
   {
   }

   public void load2572( )
   {
      /* Using cursor BC00256 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A83LegDedSec), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound72 = (short)(1) ;
         A250LegIdNomApe = BC00256_A250LegIdNomApe[0] ;
         A556LegDedFchDes = BC00256_A556LegDedFchDes[0] ;
         A557LegDedFchHas = BC00256_A557LegDedFchHas[0] ;
         A559LegDedConDescrip = BC00256_A559LegDedConDescrip[0] ;
         A560LegDedImporte = BC00256_A560LegDedImporte[0] ;
         A568LegDedDescrip = BC00256_A568LegDedDescrip[0] ;
         A251LegNombre = BC00256_A251LegNombre[0] ;
         A230LegApellido = BC00256_A230LegApellido[0] ;
         A93LegId = BC00256_A93LegId[0] ;
         n93LegId = BC00256_n93LegId[0] ;
         A84LegDedConCodigo = BC00256_A84LegDedConCodigo[0] ;
         zm2572( -9) ;
      }
      pr_default.close(4);
      onLoadActions2572( ) ;
   }

   public void onLoadActions2572( )
   {
      AV28Pgmname = "deduccionesSolapa_BC" ;
      A570LegDedConCodYDesc = GXutil.trim( A84LegDedConCodigo) + " - " + GXutil.trim( A559LegDedConDescrip) ;
   }

   public void checkExtendedTable2572( )
   {
      nIsDirty_72 = (short)(0) ;
      standaloneModal( ) ;
      AV28Pgmname = "deduccionesSolapa_BC" ;
      /* Using cursor BC00257 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A84LegDedConCodigo});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Deduccion Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGDEDCONCODIGO");
         AnyError = (short)(1) ;
      }
      A559LegDedConDescrip = BC00257_A559LegDedConDescrip[0] ;
      pr_default.close(5);
      nIsDirty_72 = (short)(1) ;
      A570LegDedConCodYDesc = GXutil.trim( A84LegDedConCodigo) + " - " + GXutil.trim( A559LegDedConDescrip) ;
      /* Using cursor BC00258 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
      }
      A250LegIdNomApe = BC00258_A250LegIdNomApe[0] ;
      A251LegNombre = BC00258_A251LegNombre[0] ;
      A251LegNombre = BC00258_A251LegNombre[0] ;
      A230LegApellido = BC00258_A230LegApellido[0] ;
      A230LegApellido = BC00258_A230LegApellido[0] ;
      A93LegId = BC00258_A93LegId[0] ;
      n93LegId = BC00258_n93LegId[0] ;
      A93LegId = BC00258_A93LegId[0] ;
      n93LegId = BC00258_n93LegId[0] ;
      pr_default.close(6);
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A556LegDedFchDes)) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Desde", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A557LegDedFchHas)) && GXutil.resetTime(A556LegDedFchDes).after( GXutil.resetTime( A557LegDedFchHas )) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "La fecha hasta debe ser posterior a la fecha desde", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( (GXutil.strcmp("", A84LegDedConCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, A560LegDedImporte)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Importe", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors2572( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey2572( )
   {
      /* Using cursor BC00259 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A83LegDedSec)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound72 = (short)(1) ;
      }
      else
      {
         RcdFound72 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC002510 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A83LegDedSec)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm2572( 9) ;
         RcdFound72 = (short)(1) ;
         A83LegDedSec = BC002510_A83LegDedSec[0] ;
         A556LegDedFchDes = BC002510_A556LegDedFchDes[0] ;
         A557LegDedFchHas = BC002510_A557LegDedFchHas[0] ;
         A560LegDedImporte = BC002510_A560LegDedImporte[0] ;
         A568LegDedDescrip = BC002510_A568LegDedDescrip[0] ;
         A3CliCod = BC002510_A3CliCod[0] ;
         A1EmpCod = BC002510_A1EmpCod[0] ;
         A6LegNumero = BC002510_A6LegNumero[0] ;
         A84LegDedConCodigo = BC002510_A84LegDedConCodigo[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z83LegDedSec = A83LegDedSec ;
         sMode72 = Gx_mode ;
         Gx_mode = "DSP" ;
         load2572( ) ;
         if ( AnyError == 1 )
         {
            RcdFound72 = (short)(0) ;
            initializeNonKey2572( ) ;
         }
         Gx_mode = sMode72 ;
      }
      else
      {
         RcdFound72 = (short)(0) ;
         initializeNonKey2572( ) ;
         sMode72 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode72 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey2572( ) ;
      if ( RcdFound72 == 0 )
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
      confirm_250( ) ;
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

   public void checkOptimisticConcurrency2572( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC002511 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A83LegDedSec)});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"legajo_deducciones"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(9) == 101) || !( GXutil.dateCompare(GXutil.resetTime(Z556LegDedFchDes), GXutil.resetTime(BC002511_A556LegDedFchDes[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z557LegDedFchHas), GXutil.resetTime(BC002511_A557LegDedFchHas[0])) ) || ( DecimalUtil.compareTo(Z560LegDedImporte, BC002511_A560LegDedImporte[0]) != 0 ) || ( GXutil.strcmp(Z568LegDedDescrip, BC002511_A568LegDedDescrip[0]) != 0 ) || ( GXutil.strcmp(Z84LegDedConCodigo, BC002511_A84LegDedConCodigo[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"legajo_deducciones"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2572( )
   {
      beforeValidate2572( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2572( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2572( 0) ;
         checkOptimisticConcurrency2572( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2572( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2572( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002512 */
                  pr_default.execute(10, new Object[] {Integer.valueOf(A83LegDedSec), A556LegDedFchDes, A557LegDedFchHas, A560LegDedImporte, A568LegDedDescrip, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A84LegDedConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_deducciones");
                  if ( (pr_default.getStatus(10) == 1) )
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
            load2572( ) ;
         }
         endLevel2572( ) ;
      }
      closeExtendedTableCursors2572( ) ;
   }

   public void update2572( )
   {
      beforeValidate2572( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2572( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2572( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2572( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2572( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002513 */
                  pr_default.execute(11, new Object[] {A556LegDedFchDes, A557LegDedFchHas, A560LegDedImporte, A568LegDedDescrip, A84LegDedConCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A83LegDedSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_deducciones");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"legajo_deducciones"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2572( ) ;
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
         endLevel2572( ) ;
      }
      closeExtendedTableCursors2572( ) ;
   }

   public void deferredUpdate2572( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate2572( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2572( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2572( ) ;
         afterConfirm2572( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2572( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC002514 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A83LegDedSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_deducciones");
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
      sMode72 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel2572( ) ;
      Gx_mode = sMode72 ;
   }

   public void onDeleteControls2572( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV28Pgmname = "deduccionesSolapa_BC" ;
         /* Using cursor BC002515 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         A250LegIdNomApe = BC002515_A250LegIdNomApe[0] ;
         A251LegNombre = BC002515_A251LegNombre[0] ;
         A251LegNombre = BC002515_A251LegNombre[0] ;
         A230LegApellido = BC002515_A230LegApellido[0] ;
         A230LegApellido = BC002515_A230LegApellido[0] ;
         A93LegId = BC002515_A93LegId[0] ;
         n93LegId = BC002515_n93LegId[0] ;
         A93LegId = BC002515_A93LegId[0] ;
         n93LegId = BC002515_n93LegId[0] ;
         pr_default.close(13);
         /* Using cursor BC002516 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), A84LegDedConCodigo});
         A559LegDedConDescrip = BC002516_A559LegDedConDescrip[0] ;
         pr_default.close(14);
         A570LegDedConCodYDesc = GXutil.trim( A84LegDedConCodigo) + " - " + GXutil.trim( A559LegDedConDescrip) ;
      }
   }

   public void endLevel2572( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2572( ) ;
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

   public void scanKeyStart2572( )
   {
      /* Scan By routine */
      /* Using cursor BC002517 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A83LegDedSec), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      RcdFound72 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound72 = (short)(1) ;
         A250LegIdNomApe = BC002517_A250LegIdNomApe[0] ;
         A83LegDedSec = BC002517_A83LegDedSec[0] ;
         A556LegDedFchDes = BC002517_A556LegDedFchDes[0] ;
         A557LegDedFchHas = BC002517_A557LegDedFchHas[0] ;
         A559LegDedConDescrip = BC002517_A559LegDedConDescrip[0] ;
         A560LegDedImporte = BC002517_A560LegDedImporte[0] ;
         A568LegDedDescrip = BC002517_A568LegDedDescrip[0] ;
         A251LegNombre = BC002517_A251LegNombre[0] ;
         A230LegApellido = BC002517_A230LegApellido[0] ;
         A93LegId = BC002517_A93LegId[0] ;
         n93LegId = BC002517_n93LegId[0] ;
         A3CliCod = BC002517_A3CliCod[0] ;
         A1EmpCod = BC002517_A1EmpCod[0] ;
         A6LegNumero = BC002517_A6LegNumero[0] ;
         A84LegDedConCodigo = BC002517_A84LegDedConCodigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext2572( )
   {
      /* Scan next routine */
      pr_default.readNext(15);
      RcdFound72 = (short)(0) ;
      scanKeyLoad2572( ) ;
   }

   public void scanKeyLoad2572( )
   {
      sMode72 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound72 = (short)(1) ;
         A250LegIdNomApe = BC002517_A250LegIdNomApe[0] ;
         A83LegDedSec = BC002517_A83LegDedSec[0] ;
         A556LegDedFchDes = BC002517_A556LegDedFchDes[0] ;
         A557LegDedFchHas = BC002517_A557LegDedFchHas[0] ;
         A559LegDedConDescrip = BC002517_A559LegDedConDescrip[0] ;
         A560LegDedImporte = BC002517_A560LegDedImporte[0] ;
         A568LegDedDescrip = BC002517_A568LegDedDescrip[0] ;
         A251LegNombre = BC002517_A251LegNombre[0] ;
         A230LegApellido = BC002517_A230LegApellido[0] ;
         A93LegId = BC002517_A93LegId[0] ;
         n93LegId = BC002517_n93LegId[0] ;
         A3CliCod = BC002517_A3CliCod[0] ;
         A1EmpCod = BC002517_A1EmpCod[0] ;
         A6LegNumero = BC002517_A6LegNumero[0] ;
         A84LegDedConCodigo = BC002517_A84LegDedConCodigo[0] ;
      }
      Gx_mode = sMode72 ;
   }

   public void scanKeyEnd2572( )
   {
      pr_default.close(15);
   }

   public void afterConfirm2572( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2572( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2572( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2572( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2572( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2572( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2572( )
   {
   }

   public void send_integrity_lvl_hashes2572( )
   {
   }

   public void addRow2572( )
   {
      VarsToRow72( bcdeduccionesSolapa) ;
   }

   public void readRow2572( )
   {
      RowToVars72( bcdeduccionesSolapa, 1) ;
   }

   public void initializeNonKey2572( )
   {
      A556LegDedFchDes = GXutil.nullDate() ;
      A557LegDedFchHas = GXutil.nullDate() ;
      A84LegDedConCodigo = "" ;
      A559LegDedConDescrip = "" ;
      A250LegIdNomApe = "" ;
      A560LegDedImporte = DecimalUtil.ZERO ;
      A568LegDedDescrip = "" ;
      A570LegDedConCodYDesc = "" ;
      A251LegNombre = "" ;
      A230LegApellido = "" ;
      A93LegId = "" ;
      n93LegId = false ;
      Z556LegDedFchDes = GXutil.nullDate() ;
      Z557LegDedFchHas = GXutil.nullDate() ;
      Z560LegDedImporte = DecimalUtil.ZERO ;
      Z568LegDedDescrip = "" ;
      Z84LegDedConCodigo = "" ;
   }

   public void initAll2572( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A6LegNumero = 0 ;
      A83LegDedSec = 0 ;
      initializeNonKey2572( ) ;
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

   public void VarsToRow72( web.SdtdeduccionesSolapa obj72 )
   {
      obj72.setgxTv_SdtdeduccionesSolapa_Mode( Gx_mode );
      obj72.setgxTv_SdtdeduccionesSolapa_Legdedfchdes( A556LegDedFchDes );
      obj72.setgxTv_SdtdeduccionesSolapa_Legdedfchhas( A557LegDedFchHas );
      obj72.setgxTv_SdtdeduccionesSolapa_Legdedconcodigo( A84LegDedConCodigo );
      obj72.setgxTv_SdtdeduccionesSolapa_Legdedcondescrip( A559LegDedConDescrip );
      obj72.setgxTv_SdtdeduccionesSolapa_Legidnomape( A250LegIdNomApe );
      obj72.setgxTv_SdtdeduccionesSolapa_Legdedimporte( A560LegDedImporte );
      obj72.setgxTv_SdtdeduccionesSolapa_Legdeddescrip( A568LegDedDescrip );
      obj72.setgxTv_SdtdeduccionesSolapa_Legdedconcodydesc( A570LegDedConCodYDesc );
      obj72.setgxTv_SdtdeduccionesSolapa_Clicod( A3CliCod );
      obj72.setgxTv_SdtdeduccionesSolapa_Empcod( A1EmpCod );
      obj72.setgxTv_SdtdeduccionesSolapa_Legnumero( A6LegNumero );
      obj72.setgxTv_SdtdeduccionesSolapa_Legdedsec( A83LegDedSec );
      obj72.setgxTv_SdtdeduccionesSolapa_Clicod_Z( Z3CliCod );
      obj72.setgxTv_SdtdeduccionesSolapa_Empcod_Z( Z1EmpCod );
      obj72.setgxTv_SdtdeduccionesSolapa_Legnumero_Z( Z6LegNumero );
      obj72.setgxTv_SdtdeduccionesSolapa_Legdedsec_Z( Z83LegDedSec );
      obj72.setgxTv_SdtdeduccionesSolapa_Legdedfchdes_Z( Z556LegDedFchDes );
      obj72.setgxTv_SdtdeduccionesSolapa_Legdedfchhas_Z( Z557LegDedFchHas );
      obj72.setgxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z( Z84LegDedConCodigo );
      obj72.setgxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z( Z559LegDedConDescrip );
      obj72.setgxTv_SdtdeduccionesSolapa_Legidnomape_Z( Z250LegIdNomApe );
      obj72.setgxTv_SdtdeduccionesSolapa_Legdedimporte_Z( Z560LegDedImporte );
      obj72.setgxTv_SdtdeduccionesSolapa_Legdeddescrip_Z( Z568LegDedDescrip );
      obj72.setgxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z( Z570LegDedConCodYDesc );
      obj72.setgxTv_SdtdeduccionesSolapa_Mode( Gx_mode );
   }

   public void KeyVarsToRow72( web.SdtdeduccionesSolapa obj72 )
   {
      obj72.setgxTv_SdtdeduccionesSolapa_Clicod( A3CliCod );
      obj72.setgxTv_SdtdeduccionesSolapa_Empcod( A1EmpCod );
      obj72.setgxTv_SdtdeduccionesSolapa_Legnumero( A6LegNumero );
      obj72.setgxTv_SdtdeduccionesSolapa_Legdedsec( A83LegDedSec );
   }

   public void RowToVars72( web.SdtdeduccionesSolapa obj72 ,
                            int forceLoad )
   {
      Gx_mode = obj72.getgxTv_SdtdeduccionesSolapa_Mode() ;
      A556LegDedFchDes = obj72.getgxTv_SdtdeduccionesSolapa_Legdedfchdes() ;
      A557LegDedFchHas = obj72.getgxTv_SdtdeduccionesSolapa_Legdedfchhas() ;
      A84LegDedConCodigo = obj72.getgxTv_SdtdeduccionesSolapa_Legdedconcodigo() ;
      A559LegDedConDescrip = obj72.getgxTv_SdtdeduccionesSolapa_Legdedcondescrip() ;
      A250LegIdNomApe = obj72.getgxTv_SdtdeduccionesSolapa_Legidnomape() ;
      A560LegDedImporte = obj72.getgxTv_SdtdeduccionesSolapa_Legdedimporte() ;
      A568LegDedDescrip = obj72.getgxTv_SdtdeduccionesSolapa_Legdeddescrip() ;
      A570LegDedConCodYDesc = obj72.getgxTv_SdtdeduccionesSolapa_Legdedconcodydesc() ;
      A3CliCod = obj72.getgxTv_SdtdeduccionesSolapa_Clicod() ;
      A1EmpCod = obj72.getgxTv_SdtdeduccionesSolapa_Empcod() ;
      A6LegNumero = obj72.getgxTv_SdtdeduccionesSolapa_Legnumero() ;
      A83LegDedSec = obj72.getgxTv_SdtdeduccionesSolapa_Legdedsec() ;
      Z3CliCod = obj72.getgxTv_SdtdeduccionesSolapa_Clicod_Z() ;
      Z1EmpCod = obj72.getgxTv_SdtdeduccionesSolapa_Empcod_Z() ;
      Z6LegNumero = obj72.getgxTv_SdtdeduccionesSolapa_Legnumero_Z() ;
      Z83LegDedSec = obj72.getgxTv_SdtdeduccionesSolapa_Legdedsec_Z() ;
      Z556LegDedFchDes = obj72.getgxTv_SdtdeduccionesSolapa_Legdedfchdes_Z() ;
      Z557LegDedFchHas = obj72.getgxTv_SdtdeduccionesSolapa_Legdedfchhas_Z() ;
      Z84LegDedConCodigo = obj72.getgxTv_SdtdeduccionesSolapa_Legdedconcodigo_Z() ;
      Z559LegDedConDescrip = obj72.getgxTv_SdtdeduccionesSolapa_Legdedcondescrip_Z() ;
      Z250LegIdNomApe = obj72.getgxTv_SdtdeduccionesSolapa_Legidnomape_Z() ;
      Z560LegDedImporte = obj72.getgxTv_SdtdeduccionesSolapa_Legdedimporte_Z() ;
      Z568LegDedDescrip = obj72.getgxTv_SdtdeduccionesSolapa_Legdeddescrip_Z() ;
      Z570LegDedConCodYDesc = obj72.getgxTv_SdtdeduccionesSolapa_Legdedconcodydesc_Z() ;
      Gx_mode = obj72.getgxTv_SdtdeduccionesSolapa_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A6LegNumero = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.INT)).intValue() ;
      A83LegDedSec = ((Number) GXutil.testNumericType( getParm(obj,3), TypeConstants.INT)).intValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey2572( ) ;
      scanKeyStart2572( ) ;
      if ( RcdFound72 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC002518 */
         pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(16) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
         }
         A250LegIdNomApe = BC002518_A250LegIdNomApe[0] ;
         A251LegNombre = BC002518_A251LegNombre[0] ;
         A251LegNombre = BC002518_A251LegNombre[0] ;
         A230LegApellido = BC002518_A230LegApellido[0] ;
         A230LegApellido = BC002518_A230LegApellido[0] ;
         A93LegId = BC002518_A93LegId[0] ;
         n93LegId = BC002518_n93LegId[0] ;
         A93LegId = BC002518_A93LegId[0] ;
         n93LegId = BC002518_n93LegId[0] ;
         pr_default.close(16);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z83LegDedSec = A83LegDedSec ;
      }
      zm2572( -9) ;
      onLoadActions2572( ) ;
      addRow2572( ) ;
      scanKeyEnd2572( ) ;
      if ( RcdFound72 == 0 )
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
      RowToVars72( bcdeduccionesSolapa, 0) ;
      scanKeyStart2572( ) ;
      if ( RcdFound72 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC002519 */
         pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(17) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
         }
         A250LegIdNomApe = BC002519_A250LegIdNomApe[0] ;
         A251LegNombre = BC002519_A251LegNombre[0] ;
         A251LegNombre = BC002519_A251LegNombre[0] ;
         A230LegApellido = BC002519_A230LegApellido[0] ;
         A230LegApellido = BC002519_A230LegApellido[0] ;
         A93LegId = BC002519_A93LegId[0] ;
         n93LegId = BC002519_n93LegId[0] ;
         A93LegId = BC002519_A93LegId[0] ;
         n93LegId = BC002519_n93LegId[0] ;
         pr_default.close(17);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z83LegDedSec = A83LegDedSec ;
      }
      zm2572( -9) ;
      onLoadActions2572( ) ;
      addRow2572( ) ;
      scanKeyEnd2572( ) ;
      if ( RcdFound72 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2572( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert2572( ) ;
      }
      else
      {
         if ( RcdFound72 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A83LegDedSec != Z83LegDedSec ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A6LegNumero = Z6LegNumero ;
               A83LegDedSec = Z83LegDedSec ;
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
               update2572( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A83LegDedSec != Z83LegDedSec ) )
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
                     insert2572( ) ;
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
                     insert2572( ) ;
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
      RowToVars72( bcdeduccionesSolapa, 1) ;
      saveImpl( ) ;
      VarsToRow72( bcdeduccionesSolapa) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars72( bcdeduccionesSolapa, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert2572( ) ;
      afterTrn( ) ;
      VarsToRow72( bcdeduccionesSolapa) ;
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
         web.SdtdeduccionesSolapa auxBC = new web.SdtdeduccionesSolapa( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A6LegNumero, A83LegDedSec);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcdeduccionesSolapa);
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
      RowToVars72( bcdeduccionesSolapa, 1) ;
      updateImpl( ) ;
      VarsToRow72( bcdeduccionesSolapa) ;
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
      RowToVars72( bcdeduccionesSolapa, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert2572( ) ;
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
      VarsToRow72( bcdeduccionesSolapa) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars72( bcdeduccionesSolapa, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey2572( ) ;
      if ( RcdFound72 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A83LegDedSec != Z83LegDedSec ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A6LegNumero = Z6LegNumero ;
            A83LegDedSec = Z83LegDedSec ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A83LegDedSec != Z83LegDedSec ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "deduccionessolapa_bc");
      VarsToRow72( bcdeduccionesSolapa) ;
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
      Gx_mode = bcdeduccionesSolapa.getgxTv_SdtdeduccionesSolapa_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcdeduccionesSolapa.setgxTv_SdtdeduccionesSolapa_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtdeduccionesSolapa sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcdeduccionesSolapa )
      {
         bcdeduccionesSolapa = sdt ;
         if ( GXutil.strcmp(bcdeduccionesSolapa.getgxTv_SdtdeduccionesSolapa_Mode(), "") == 0 )
         {
            bcdeduccionesSolapa.setgxTv_SdtdeduccionesSolapa_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow72( bcdeduccionesSolapa) ;
         }
         else
         {
            RowToVars72( bcdeduccionesSolapa, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcdeduccionesSolapa.getgxTv_SdtdeduccionesSolapa_Mode(), "") == 0 )
         {
            bcdeduccionesSolapa.setgxTv_SdtdeduccionesSolapa_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars72( bcdeduccionesSolapa, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtdeduccionesSolapa getdeduccionesSolapa_BC( )
   {
      return bcdeduccionesSolapa ;
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
      AV11WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV28Pgmname = "" ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      AV17TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV16Insert_LegDedConCodigo = "" ;
      AV27SubTipoConCod1 = "" ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      Z556LegDedFchDes = GXutil.nullDate() ;
      A556LegDedFchDes = GXutil.nullDate() ;
      Z557LegDedFchHas = GXutil.nullDate() ;
      A557LegDedFchHas = GXutil.nullDate() ;
      Z560LegDedImporte = DecimalUtil.ZERO ;
      A560LegDedImporte = DecimalUtil.ZERO ;
      Z568LegDedDescrip = "" ;
      A568LegDedDescrip = "" ;
      Z84LegDedConCodigo = "" ;
      A84LegDedConCodigo = "" ;
      Z570LegDedConCodYDesc = "" ;
      A570LegDedConCodYDesc = "" ;
      Z250LegIdNomApe = "" ;
      A250LegIdNomApe = "" ;
      Z251LegNombre = "" ;
      A251LegNombre = "" ;
      Z230LegApellido = "" ;
      A230LegApellido = "" ;
      Z93LegId = "" ;
      A93LegId = "" ;
      Z559LegDedConDescrip = "" ;
      A559LegDedConDescrip = "" ;
      GXv_int7 = new int[1] ;
      BC00256_A250LegIdNomApe = new String[] {""} ;
      BC00256_A83LegDedSec = new int[1] ;
      BC00256_A556LegDedFchDes = new java.util.Date[] {GXutil.nullDate()} ;
      BC00256_A557LegDedFchHas = new java.util.Date[] {GXutil.nullDate()} ;
      BC00256_A559LegDedConDescrip = new String[] {""} ;
      BC00256_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC00256_A568LegDedDescrip = new String[] {""} ;
      BC00256_A251LegNombre = new String[] {""} ;
      BC00256_A230LegApellido = new String[] {""} ;
      BC00256_A93LegId = new String[] {""} ;
      BC00256_n93LegId = new boolean[] {false} ;
      BC00256_A3CliCod = new int[1] ;
      BC00256_A1EmpCod = new short[1] ;
      BC00256_A6LegNumero = new int[1] ;
      BC00256_A84LegDedConCodigo = new String[] {""} ;
      BC00257_A559LegDedConDescrip = new String[] {""} ;
      BC00258_A250LegIdNomApe = new String[] {""} ;
      BC00258_A251LegNombre = new String[] {""} ;
      BC00258_A230LegApellido = new String[] {""} ;
      BC00258_A93LegId = new String[] {""} ;
      BC00258_n93LegId = new boolean[] {false} ;
      BC00259_A3CliCod = new int[1] ;
      BC00259_A1EmpCod = new short[1] ;
      BC00259_A6LegNumero = new int[1] ;
      BC00259_A83LegDedSec = new int[1] ;
      BC002510_A83LegDedSec = new int[1] ;
      BC002510_A556LegDedFchDes = new java.util.Date[] {GXutil.nullDate()} ;
      BC002510_A557LegDedFchHas = new java.util.Date[] {GXutil.nullDate()} ;
      BC002510_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002510_A568LegDedDescrip = new String[] {""} ;
      BC002510_A3CliCod = new int[1] ;
      BC002510_A1EmpCod = new short[1] ;
      BC002510_A6LegNumero = new int[1] ;
      BC002510_A84LegDedConCodigo = new String[] {""} ;
      sMode72 = "" ;
      BC002511_A83LegDedSec = new int[1] ;
      BC002511_A556LegDedFchDes = new java.util.Date[] {GXutil.nullDate()} ;
      BC002511_A557LegDedFchHas = new java.util.Date[] {GXutil.nullDate()} ;
      BC002511_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002511_A568LegDedDescrip = new String[] {""} ;
      BC002511_A3CliCod = new int[1] ;
      BC002511_A1EmpCod = new short[1] ;
      BC002511_A6LegNumero = new int[1] ;
      BC002511_A84LegDedConCodigo = new String[] {""} ;
      BC002515_A250LegIdNomApe = new String[] {""} ;
      BC002515_A251LegNombre = new String[] {""} ;
      BC002515_A230LegApellido = new String[] {""} ;
      BC002515_A93LegId = new String[] {""} ;
      BC002515_n93LegId = new boolean[] {false} ;
      BC002516_A559LegDedConDescrip = new String[] {""} ;
      BC002517_A250LegIdNomApe = new String[] {""} ;
      BC002517_A83LegDedSec = new int[1] ;
      BC002517_A556LegDedFchDes = new java.util.Date[] {GXutil.nullDate()} ;
      BC002517_A557LegDedFchHas = new java.util.Date[] {GXutil.nullDate()} ;
      BC002517_A559LegDedConDescrip = new String[] {""} ;
      BC002517_A560LegDedImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002517_A568LegDedDescrip = new String[] {""} ;
      BC002517_A251LegNombre = new String[] {""} ;
      BC002517_A230LegApellido = new String[] {""} ;
      BC002517_A93LegId = new String[] {""} ;
      BC002517_n93LegId = new boolean[] {false} ;
      BC002517_A3CliCod = new int[1] ;
      BC002517_A1EmpCod = new short[1] ;
      BC002517_A6LegNumero = new int[1] ;
      BC002517_A84LegDedConCodigo = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC002518_A250LegIdNomApe = new String[] {""} ;
      BC002518_A251LegNombre = new String[] {""} ;
      BC002518_A230LegApellido = new String[] {""} ;
      BC002518_A93LegId = new String[] {""} ;
      BC002518_n93LegId = new boolean[] {false} ;
      BC002519_A250LegIdNomApe = new String[] {""} ;
      BC002519_A251LegNombre = new String[] {""} ;
      BC002519_A230LegApellido = new String[] {""} ;
      BC002519_A93LegId = new String[] {""} ;
      BC002519_n93LegId = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.deduccionessolapa_bc__default(),
         new Object[] {
             new Object[] {
            BC00252_A83LegDedSec, BC00252_A556LegDedFchDes, BC00252_A557LegDedFchHas, BC00252_A560LegDedImporte, BC00252_A568LegDedDescrip, BC00252_A3CliCod, BC00252_A1EmpCod, BC00252_A6LegNumero, BC00252_A84LegDedConCodigo
            }
            , new Object[] {
            BC00253_A83LegDedSec, BC00253_A556LegDedFchDes, BC00253_A557LegDedFchHas, BC00253_A560LegDedImporte, BC00253_A568LegDedDescrip, BC00253_A3CliCod, BC00253_A1EmpCod, BC00253_A6LegNumero, BC00253_A84LegDedConCodigo
            }
            , new Object[] {
            BC00254_A250LegIdNomApe, BC00254_A251LegNombre, BC00254_A230LegApellido, BC00254_A93LegId, BC00254_n93LegId
            }
            , new Object[] {
            BC00255_A559LegDedConDescrip
            }
            , new Object[] {
            BC00256_A250LegIdNomApe, BC00256_A83LegDedSec, BC00256_A556LegDedFchDes, BC00256_A557LegDedFchHas, BC00256_A559LegDedConDescrip, BC00256_A560LegDedImporte, BC00256_A568LegDedDescrip, BC00256_A251LegNombre, BC00256_A230LegApellido, BC00256_A93LegId,
            BC00256_n93LegId, BC00256_A3CliCod, BC00256_A1EmpCod, BC00256_A6LegNumero, BC00256_A84LegDedConCodigo
            }
            , new Object[] {
            BC00257_A559LegDedConDescrip
            }
            , new Object[] {
            BC00258_A250LegIdNomApe, BC00258_A251LegNombre, BC00258_A230LegApellido, BC00258_A93LegId, BC00258_n93LegId
            }
            , new Object[] {
            BC00259_A3CliCod, BC00259_A1EmpCod, BC00259_A6LegNumero, BC00259_A83LegDedSec
            }
            , new Object[] {
            BC002510_A83LegDedSec, BC002510_A556LegDedFchDes, BC002510_A557LegDedFchHas, BC002510_A560LegDedImporte, BC002510_A568LegDedDescrip, BC002510_A3CliCod, BC002510_A1EmpCod, BC002510_A6LegNumero, BC002510_A84LegDedConCodigo
            }
            , new Object[] {
            BC002511_A83LegDedSec, BC002511_A556LegDedFchDes, BC002511_A557LegDedFchHas, BC002511_A560LegDedImporte, BC002511_A568LegDedDescrip, BC002511_A3CliCod, BC002511_A1EmpCod, BC002511_A6LegNumero, BC002511_A84LegDedConCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC002515_A250LegIdNomApe, BC002515_A251LegNombre, BC002515_A230LegApellido, BC002515_A93LegId, BC002515_n93LegId
            }
            , new Object[] {
            BC002516_A559LegDedConDescrip
            }
            , new Object[] {
            BC002517_A250LegIdNomApe, BC002517_A83LegDedSec, BC002517_A556LegDedFchDes, BC002517_A557LegDedFchHas, BC002517_A559LegDedConDescrip, BC002517_A560LegDedImporte, BC002517_A568LegDedDescrip, BC002517_A251LegNombre, BC002517_A230LegApellido, BC002517_A93LegId,
            BC002517_n93LegId, BC002517_A3CliCod, BC002517_A1EmpCod, BC002517_A6LegNumero, BC002517_A84LegDedConCodigo
            }
            , new Object[] {
            BC002518_A250LegIdNomApe, BC002518_A251LegNombre, BC002518_A230LegApellido, BC002518_A93LegId, BC002518_n93LegId
            }
            , new Object[] {
            BC002519_A250LegIdNomApe, BC002519_A251LegNombre, BC002519_A230LegApellido, BC002519_A93LegId, BC002519_n93LegId
            }
         }
      );
      AV28Pgmname = "deduccionesSolapa_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12252 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short RcdFound72 ;
   private short nIsDirty_72 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int Z6LegNumero ;
   private int A6LegNumero ;
   private int Z83LegDedSec ;
   private int A83LegDedSec ;
   private int AV29GXV1 ;
   private int GX_JID ;
   private int GXt_int6 ;
   private int GXv_int7[] ;
   private java.math.BigDecimal Z560LegDedImporte ;
   private java.math.BigDecimal A560LegDedImporte ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV28Pgmname ;
   private String AV16Insert_LegDedConCodigo ;
   private String AV27SubTipoConCod1 ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private String Z84LegDedConCodigo ;
   private String A84LegDedConCodigo ;
   private String Z93LegId ;
   private String A93LegId ;
   private String sMode72 ;
   private java.util.Date Z556LegDedFchDes ;
   private java.util.Date A556LegDedFchDes ;
   private java.util.Date Z557LegDedFchHas ;
   private java.util.Date A557LegDedFchHas ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean n93LegId ;
   private boolean mustCommit ;
   private String Z568LegDedDescrip ;
   private String A568LegDedDescrip ;
   private String Z570LegDedConCodYDesc ;
   private String A570LegDedConCodYDesc ;
   private String Z250LegIdNomApe ;
   private String A250LegIdNomApe ;
   private String Z251LegNombre ;
   private String A251LegNombre ;
   private String Z230LegApellido ;
   private String A230LegApellido ;
   private String Z559LegDedConDescrip ;
   private String A559LegDedConDescrip ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private web.SdtdeduccionesSolapa bcdeduccionesSolapa ;
   private IDataStoreProvider pr_default ;
   private String[] BC00256_A250LegIdNomApe ;
   private int[] BC00256_A83LegDedSec ;
   private java.util.Date[] BC00256_A556LegDedFchDes ;
   private java.util.Date[] BC00256_A557LegDedFchHas ;
   private String[] BC00256_A559LegDedConDescrip ;
   private java.math.BigDecimal[] BC00256_A560LegDedImporte ;
   private String[] BC00256_A568LegDedDescrip ;
   private String[] BC00256_A251LegNombre ;
   private String[] BC00256_A230LegApellido ;
   private String[] BC00256_A93LegId ;
   private boolean[] BC00256_n93LegId ;
   private int[] BC00256_A3CliCod ;
   private short[] BC00256_A1EmpCod ;
   private int[] BC00256_A6LegNumero ;
   private String[] BC00256_A84LegDedConCodigo ;
   private String[] BC00257_A559LegDedConDescrip ;
   private String[] BC00258_A250LegIdNomApe ;
   private String[] BC00258_A251LegNombre ;
   private String[] BC00258_A230LegApellido ;
   private String[] BC00258_A93LegId ;
   private boolean[] BC00258_n93LegId ;
   private int[] BC00259_A3CliCod ;
   private short[] BC00259_A1EmpCod ;
   private int[] BC00259_A6LegNumero ;
   private int[] BC00259_A83LegDedSec ;
   private int[] BC002510_A83LegDedSec ;
   private java.util.Date[] BC002510_A556LegDedFchDes ;
   private java.util.Date[] BC002510_A557LegDedFchHas ;
   private java.math.BigDecimal[] BC002510_A560LegDedImporte ;
   private String[] BC002510_A568LegDedDescrip ;
   private int[] BC002510_A3CliCod ;
   private short[] BC002510_A1EmpCod ;
   private int[] BC002510_A6LegNumero ;
   private String[] BC002510_A84LegDedConCodigo ;
   private int[] BC002511_A83LegDedSec ;
   private java.util.Date[] BC002511_A556LegDedFchDes ;
   private java.util.Date[] BC002511_A557LegDedFchHas ;
   private java.math.BigDecimal[] BC002511_A560LegDedImporte ;
   private String[] BC002511_A568LegDedDescrip ;
   private int[] BC002511_A3CliCod ;
   private short[] BC002511_A1EmpCod ;
   private int[] BC002511_A6LegNumero ;
   private String[] BC002511_A84LegDedConCodigo ;
   private String[] BC002515_A250LegIdNomApe ;
   private String[] BC002515_A251LegNombre ;
   private String[] BC002515_A230LegApellido ;
   private String[] BC002515_A93LegId ;
   private boolean[] BC002515_n93LegId ;
   private String[] BC002516_A559LegDedConDescrip ;
   private String[] BC002517_A250LegIdNomApe ;
   private int[] BC002517_A83LegDedSec ;
   private java.util.Date[] BC002517_A556LegDedFchDes ;
   private java.util.Date[] BC002517_A557LegDedFchHas ;
   private String[] BC002517_A559LegDedConDescrip ;
   private java.math.BigDecimal[] BC002517_A560LegDedImporte ;
   private String[] BC002517_A568LegDedDescrip ;
   private String[] BC002517_A251LegNombre ;
   private String[] BC002517_A230LegApellido ;
   private String[] BC002517_A93LegId ;
   private boolean[] BC002517_n93LegId ;
   private int[] BC002517_A3CliCod ;
   private short[] BC002517_A1EmpCod ;
   private int[] BC002517_A6LegNumero ;
   private String[] BC002517_A84LegDedConCodigo ;
   private String[] BC002518_A250LegIdNomApe ;
   private String[] BC002518_A251LegNombre ;
   private String[] BC002518_A230LegApellido ;
   private String[] BC002518_A93LegId ;
   private boolean[] BC002518_n93LegId ;
   private String[] BC002519_A250LegIdNomApe ;
   private String[] BC002519_A251LegNombre ;
   private String[] BC002519_A230LegApellido ;
   private String[] BC002519_A93LegId ;
   private boolean[] BC002519_n93LegId ;
   private int[] BC00252_A83LegDedSec ;
   private java.util.Date[] BC00252_A556LegDedFchDes ;
   private java.util.Date[] BC00252_A557LegDedFchHas ;
   private java.math.BigDecimal[] BC00252_A560LegDedImporte ;
   private String[] BC00252_A568LegDedDescrip ;
   private int[] BC00252_A3CliCod ;
   private short[] BC00252_A1EmpCod ;
   private int[] BC00252_A6LegNumero ;
   private String[] BC00252_A84LegDedConCodigo ;
   private int[] BC00253_A83LegDedSec ;
   private java.util.Date[] BC00253_A556LegDedFchDes ;
   private java.util.Date[] BC00253_A557LegDedFchHas ;
   private java.math.BigDecimal[] BC00253_A560LegDedImporte ;
   private String[] BC00253_A568LegDedDescrip ;
   private int[] BC00253_A3CliCod ;
   private short[] BC00253_A1EmpCod ;
   private int[] BC00253_A6LegNumero ;
   private String[] BC00253_A84LegDedConCodigo ;
   private String[] BC00254_A250LegIdNomApe ;
   private String[] BC00254_A251LegNombre ;
   private String[] BC00254_A230LegApellido ;
   private String[] BC00254_A93LegId ;
   private String[] BC00255_A559LegDedConDescrip ;
   private boolean[] BC00254_n93LegId ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV17TrnContextAtt ;
}

final  class deduccionessolapa_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00252", "SELECT LegDedSec, LegDedFchDes, LegDedFchHas, LegDedImporte, LegDedDescrip, CliCod, EmpCod, LegNumero, LegDedConCodigo FROM legajo_deducciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ?  FOR UPDATE OF legajo_deducciones",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00253", "SELECT LegDedSec, LegDedFchDes, LegDedFchHas, LegDedImporte, LegDedDescrip, CliCod, EmpCod, LegNumero, LegDedConCodigo FROM legajo_deducciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00254", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00255", "SELECT ConDescrip AS LegDedConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00256", "SELECT T2.LegIdNomApe, TM1.LegDedSec, TM1.LegDedFchDes, TM1.LegDedFchHas, T3.ConDescrip AS LegDedConDescrip, TM1.LegDedImporte, TM1.LegDedDescrip, T2.LegNombre, T2.LegApellido, T2.LegId, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegDedConCodigo AS LegDedConCodigo FROM ((legajo_deducciones TM1 INNER JOIN Legajo T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod AND T2.LegNumero = TM1.LegNumero) INNER JOIN Concepto T3 ON T3.CliCod = TM1.CliCod AND T3.ConCodigo = TM1.LegDedConCodigo) WHERE TM1.LegDedSec = ? and TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegDedSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00257", "SELECT ConDescrip AS LegDedConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00258", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00259", "SELECT CliCod, EmpCod, LegNumero, LegDedSec FROM legajo_deducciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002510", "SELECT LegDedSec, LegDedFchDes, LegDedFchHas, LegDedImporte, LegDedDescrip, CliCod, EmpCod, LegNumero, LegDedConCodigo FROM legajo_deducciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002511", "SELECT LegDedSec, LegDedFchDes, LegDedFchHas, LegDedImporte, LegDedDescrip, CliCod, EmpCod, LegNumero, LegDedConCodigo FROM legajo_deducciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ?  FOR UPDATE OF legajo_deducciones",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC002512", "SAVEPOINT gxupdate;INSERT INTO legajo_deducciones(LegDedSec, LegDedFchDes, LegDedFchHas, LegDedImporte, LegDedDescrip, CliCod, EmpCod, LegNumero, LegDedConCodigo, LegDedMes, LegDedAnio, LegDedCodSiradig, LegDedCodMot, LegDedUsado, LegDedNroLiq, LegDedTipo, LegDedFile, LegDedFileNom, LegDedFileExt) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0, 0, '', 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002513", "SAVEPOINT gxupdate;UPDATE legajo_deducciones SET LegDedFchDes=?, LegDedFchHas=?, LegDedImporte=?, LegDedDescrip=?, LegDedConCodigo=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002514", "SAVEPOINT gxupdate;DELETE FROM legajo_deducciones  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC002515", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002516", "SELECT ConDescrip AS LegDedConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002517", "SELECT T2.LegIdNomApe, TM1.LegDedSec, TM1.LegDedFchDes, TM1.LegDedFchHas, T3.ConDescrip AS LegDedConDescrip, TM1.LegDedImporte, TM1.LegDedDescrip, T2.LegNombre, T2.LegApellido, T2.LegId, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegDedConCodigo AS LegDedConCodigo FROM ((legajo_deducciones TM1 INNER JOIN Legajo T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod AND T2.LegNumero = TM1.LegNumero) INNER JOIN Concepto T3 ON T3.CliCod = TM1.CliCod AND T3.ConCodigo = TM1.LegDedConCodigo) WHERE TM1.LegDedSec = ? and TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegDedSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002518", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002519", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 10);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 10);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((int[]) buf[11])[0] = rslt.getInt(11);
               ((short[]) buf[12])[0] = rslt.getShort(12);
               ((int[]) buf[13])[0] = rslt.getInt(13);
               ((String[]) buf[14])[0] = rslt.getString(14, 10);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 10);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 10);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((int[]) buf[11])[0] = rslt.getInt(11);
               ((short[]) buf[12])[0] = rslt.getShort(12);
               ((int[]) buf[13])[0] = rslt.getInt(13);
               ((String[]) buf[14])[0] = rslt.getString(14, 10);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 10);
               return;
            case 11 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setString(5, (String)parms[4], 10);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

