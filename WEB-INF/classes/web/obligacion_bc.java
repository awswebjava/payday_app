package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class obligacion_bc extends GXWebPanel implements IGxSilentTrn
{
   public obligacion_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public obligacion_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obligacion_bc.class ));
   }

   public obligacion_bc( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow3D134( ) ;
      standaloneNotModal( ) ;
      initializeNonKey3D134( ) ;
      standaloneModal( ) ;
      addRow3D134( ) ;
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
         e113D2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z6LegNumero = A6LegNumero ;
            Z1172OblSecuencial = A1172OblSecuencial ;
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

   public void confirm_3D0( )
   {
      beforeValidate3D134( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls3D134( ) ;
         }
         else
         {
            checkExtendedTable3D134( ) ;
            if ( AnyError == 0 )
            {
               zm3D134( 17) ;
               zm3D134( 18) ;
               zm3D134( 19) ;
               zm3D134( 20) ;
               zm3D134( 21) ;
               zm3D134( 22) ;
            }
            closeExtendedTableCursors3D134( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode134 = Gx_mode ;
         confirm_3D138( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode134 ;
            IsConfirmed = (short)(1) ;
         }
         /* Restore parent mode. */
         Gx_mode = sMode134 ;
      }
   }

   public void confirm_3D138( )
   {
      nGXsfl_138_idx = 0 ;
      while ( nGXsfl_138_idx < bcObligacion.getgxTv_SdtObligacion_Excepciones().size() )
      {
         readRow3D138( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound138 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_138 != 0 ) )
         {
            getKey3D138( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound138 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate3D138( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable3D138( ) ;
                     if ( AnyError == 0 )
                     {
                        zm3D138( 24) ;
                     }
                     closeExtendedTableCursors3D138( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                  AnyError = (short)(1) ;
               }
            }
            else
            {
               if ( RcdFound138 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey3D138( ) ;
                     load3D138( ) ;
                     beforeValidate3D138( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls3D138( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_138 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate3D138( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable3D138( ) ;
                           if ( AnyError == 0 )
                           {
                              zm3D138( 24) ;
                           }
                           closeExtendedTableCursors3D138( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( ! isDlt( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
            VarsToRow138( ((web.SdtObligacion_Excepciones)bcObligacion.getgxTv_SdtObligacion_Excepciones().elementAt(-1+nGXsfl_138_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void e123D2( )
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObligacion_Insert", GXv_boolean3) ;
         obligacion_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObligacion_Update", GXv_boolean3) ;
         obligacion_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWObligacion_Delete", GXv_boolean3) ;
         obligacion_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV52Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(10);
         pr_default.close(9);
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV14TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV52Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV53GXV1 = 1 ;
         while ( AV53GXV1 <= AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV18TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV53GXV1));
            if ( GXutil.strcmp(AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "TipoOblSec") == 0 )
            {
               AV16Insert_TipoOblSec = (short)(GXutil.lval( AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "OblConCodigo") == 0 )
            {
               AV17Insert_OblConCodigo = AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "OblLiqNro") == 0 )
            {
               AV35Insert_OblLiqNro = (int)(GXutil.lval( AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "OblConcepto") == 0 )
            {
               AV46Insert_OblConcepto = AV18TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            AV53GXV1 = (int)(AV53GXV1+1) ;
         }
      }
      GXt_int4 = AV36PaiCod ;
      GXv_int5[0] = GXt_int4 ;
      new web.clientegetpais(remoteHandle, context).execute( AV7CliCod, GXv_int5) ;
      obligacion_bc.this.GXt_int4 = GXv_int5[0] ;
      AV36PaiCod = GXt_int4 ;
      GXt_int4 = AV42anticipoTipoOblSec ;
      GXv_int5[0] = GXt_int4 ;
      new web.gettipoobligacionanticipo(remoteHandle, context).execute( AV7CliCod, GXv_int5) ;
      obligacion_bc.this.GXt_int4 = GXv_int5[0] ;
      AV42anticipoTipoOblSec = GXt_int4 ;
      GXt_char6 = AV43anticipoSubTipoConCod1 ;
      GXv_char7[0] = GXt_char6 ;
      new web.subtipoanticipocuotas(remoteHandle, context).execute( GXv_char7) ;
      obligacion_bc.this.GXt_char6 = GXv_char7[0] ;
      AV43anticipoSubTipoConCod1 = GXt_char6 ;
      GXt_char6 = AV44desdeDTipoConCod ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettipoconcepto(remoteHandle, context).execute( AV36PaiCod, "NRE", GXv_char7) ;
      obligacion_bc.this.GXt_char6 = GXv_char7[0] ;
      AV44desdeDTipoConCod = GXt_char6 ;
      GXt_char6 = AV45hastaDTipoConCod ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettipoconcepto(remoteHandle, context).execute( AV36PaiCod, "REM", GXv_char7) ;
      obligacion_bc.this.GXt_char6 = GXv_char7[0] ;
      AV45hastaDTipoConCod = GXt_char6 ;
   }

   public void e113D2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.recalcularlegsuelbasicaporlegupd(remoteHandle, context).execute( (short)(0), AV7CliCod, AV8EmpCod, A6LegNumero, httpContext.getMessage( "OBLIGACIONES", "")) ;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
   }

   public void zm3D134( int GX_JID )
   {
      if ( ( GX_JID == 16 ) || ( GX_JID == 0 ) )
      {
         Z2345OblTipoMov = A2345OblTipoMov ;
         Z1173OblEstado = A1173OblEstado ;
         Z1175OblOriPer = A1175OblOriPer ;
         Z1176OblTotal = A1176OblTotal ;
         Z1177OblCanCuo = A1177OblCanCuo ;
         Z1178OblImpFij = A1178OblImpFij ;
         Z1179OblPorc = A1179OblPorc ;
         Z1181OblNoRemu = A1181OblNoRemu ;
         Z1182OblDescu = A1182OblDescu ;
         Z1196OblAntiRelaLiq = A1196OblAntiRelaLiq ;
         Z2343OblConcepto = A2343OblConcepto ;
         Z1195OblLiqNro = A1195OblLiqNro ;
         Z1169OblConCodigo = A1169OblConCodigo ;
         Z1163TipoOblSec = A1163TipoOblSec ;
      }
      if ( ( GX_JID == 17 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 18 ) || ( GX_JID == 0 ) )
      {
         Z250LegIdNomApe = A250LegIdNomApe ;
         Z251LegNombre = A251LegNombre ;
         Z230LegApellido = A230LegApellido ;
         Z93LegId = A93LegId ;
         Z93LegId = A93LegId ;
         Z230LegApellido = A230LegApellido ;
         Z251LegNombre = A251LegNombre ;
      }
      if ( ( GX_JID == 19 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 20 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 21 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 22 ) || ( GX_JID == 0 ) )
      {
         Z1165TipoOblDescrip = A1165TipoOblDescrip ;
         Z1164TipoOblCodigo = A1164TipoOblCodigo ;
         Z1168TipoOblTotTipo = A1168TipoOblTotTipo ;
         Z2346TipoOblSoloDescu = A2346TipoOblSoloDescu ;
         Z1161EmbargaSec = A1161EmbargaSec ;
      }
      if ( GX_JID == -16 )
      {
         Z1172OblSecuencial = A1172OblSecuencial ;
         Z2345OblTipoMov = A2345OblTipoMov ;
         Z1173OblEstado = A1173OblEstado ;
         Z1174OblObs = A1174OblObs ;
         Z1175OblOriPer = A1175OblOriPer ;
         Z1176OblTotal = A1176OblTotal ;
         Z1177OblCanCuo = A1177OblCanCuo ;
         Z1178OblImpFij = A1178OblImpFij ;
         Z1179OblPorc = A1179OblPorc ;
         Z1181OblNoRemu = A1181OblNoRemu ;
         Z1182OblDescu = A1182OblDescu ;
         Z1196OblAntiRelaLiq = A1196OblAntiRelaLiq ;
         Z3CliCod = A3CliCod ;
         Z2343OblConcepto = A2343OblConcepto ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1195OblLiqNro = A1195OblLiqNro ;
         Z1169OblConCodigo = A1169OblConCodigo ;
         Z1163TipoOblSec = A1163TipoOblSec ;
         Z250LegIdNomApe = A250LegIdNomApe ;
         Z251LegNombre = A251LegNombre ;
         Z230LegApellido = A230LegApellido ;
         Z93LegId = A93LegId ;
         Z1165TipoOblDescrip = A1165TipoOblDescrip ;
         Z1164TipoOblCodigo = A1164TipoOblCodigo ;
         Z1168TipoOblTotTipo = A1168TipoOblTotTipo ;
         Z2346TipoOblSoloDescu = A2346TipoOblSoloDescu ;
         Z1161EmbargaSec = A1161EmbargaSec ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int8 = A3CliCod ;
         GXv_int9[0] = GXt_int8 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int9) ;
         obligacion_bc.this.GXt_int8 = GXv_int9[0] ;
         A3CliCod = GXt_int8 ;
      }
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && (0==A1173OblEstado) && ( Gx_BScreen == 0 ) )
      {
         A1173OblEstado = (byte)(1) ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load3D134( )
   {
      /* Using cursor BC003D13 */
      pr_default.execute(11, new Object[] {Short.valueOf(A1172OblSecuencial), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound134 = (short)(1) ;
         A250LegIdNomApe = BC003D13_A250LegIdNomApe[0] ;
         A2345OblTipoMov = BC003D13_A2345OblTipoMov[0] ;
         A1165TipoOblDescrip = BC003D13_A1165TipoOblDescrip[0] ;
         A1164TipoOblCodigo = BC003D13_A1164TipoOblCodigo[0] ;
         A1173OblEstado = BC003D13_A1173OblEstado[0] ;
         A1174OblObs = BC003D13_A1174OblObs[0] ;
         A1175OblOriPer = BC003D13_A1175OblOriPer[0] ;
         A1168TipoOblTotTipo = BC003D13_A1168TipoOblTotTipo[0] ;
         A1176OblTotal = BC003D13_A1176OblTotal[0] ;
         A1177OblCanCuo = BC003D13_A1177OblCanCuo[0] ;
         A1178OblImpFij = BC003D13_A1178OblImpFij[0] ;
         A1179OblPorc = BC003D13_A1179OblPorc[0] ;
         A1181OblNoRemu = BC003D13_A1181OblNoRemu[0] ;
         A1182OblDescu = BC003D13_A1182OblDescu[0] ;
         A1196OblAntiRelaLiq = BC003D13_A1196OblAntiRelaLiq[0] ;
         A2346TipoOblSoloDescu = BC003D13_A2346TipoOblSoloDescu[0] ;
         A251LegNombre = BC003D13_A251LegNombre[0] ;
         A230LegApellido = BC003D13_A230LegApellido[0] ;
         A93LegId = BC003D13_A93LegId[0] ;
         n93LegId = BC003D13_n93LegId[0] ;
         A2343OblConcepto = BC003D13_A2343OblConcepto[0] ;
         A1195OblLiqNro = BC003D13_A1195OblLiqNro[0] ;
         n1195OblLiqNro = BC003D13_n1195OblLiqNro[0] ;
         A1169OblConCodigo = BC003D13_A1169OblConCodigo[0] ;
         n1169OblConCodigo = BC003D13_n1169OblConCodigo[0] ;
         A1163TipoOblSec = BC003D13_A1163TipoOblSec[0] ;
         A1161EmbargaSec = BC003D13_A1161EmbargaSec[0] ;
         n1161EmbargaSec = BC003D13_n1161EmbargaSec[0] ;
         zm3D134( -16) ;
      }
      pr_default.close(11);
      onLoadActions3D134( ) ;
   }

   public void onLoadActions3D134( )
   {
      AV52Pgmname = "Obligacion_BC" ;
      if ( isIns( )  && (GXutil.strcmp("", A2345OblTipoMov)==0) && ( Gx_BScreen == 0 ) )
      {
         A2345OblTipoMov = "Descuento" ;
      }
      else
      {
         if ( A2346TipoOblSoloDescu )
         {
            A2345OblTipoMov = "Descuento" ;
         }
      }
   }

   public void checkExtendedTable3D134( )
   {
      nIsDirty_134 = (short)(0) ;
      standaloneModal( ) ;
      AV52Pgmname = "Obligacion_BC" ;
      if ( ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) && (0==A1195OblLiqNro) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liq Nro", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( ( ( A1163TipoOblSec == AV42anticipoTipoOblSec ) ) && (GXutil.strcmp("", A1169OblConCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Origen concepto", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC003D14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), A2343OblConcepto});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Obligacion Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OBLCONCEPTO");
         AnyError = (short)(1) ;
      }
      pr_default.close(12);
      /* Using cursor BC003D15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n1169OblConCodigo), A1169OblConCodigo});
      if ( (pr_default.getStatus(13) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A1169OblConCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Obl Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OBLCONCODIGO");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(13);
      /* Using cursor BC003D16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n1195OblLiqNro), Integer.valueOf(A1195OblLiqNro)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A1195OblLiqNro) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Anticipo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OBLLIQNRO");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(14);
      /* Using cursor BC003D17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
      }
      A250LegIdNomApe = BC003D17_A250LegIdNomApe[0] ;
      A251LegNombre = BC003D17_A251LegNombre[0] ;
      A251LegNombre = BC003D17_A251LegNombre[0] ;
      A230LegApellido = BC003D17_A230LegApellido[0] ;
      A230LegApellido = BC003D17_A230LegApellido[0] ;
      A93LegId = BC003D17_A93LegId[0] ;
      n93LegId = BC003D17_n93LegId[0] ;
      A93LegId = BC003D17_A93LegId[0] ;
      n93LegId = BC003D17_n93LegId[0] ;
      pr_default.close(15);
      /* Using cursor BC003D18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n1195OblLiqNro), Integer.valueOf(A1195OblLiqNro), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A1195OblLiqNro) || (0==A6LegNumero) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(16);
      if ( (0==A6LegNumero) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC003D19 */
      pr_default.execute(17, new Object[] {Short.valueOf(A1163TipoOblSec)});
      if ( (pr_default.getStatus(17) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "tipo_obligacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOOBLSEC");
         AnyError = (short)(1) ;
      }
      A1165TipoOblDescrip = BC003D19_A1165TipoOblDescrip[0] ;
      A1164TipoOblCodigo = BC003D19_A1164TipoOblCodigo[0] ;
      A1168TipoOblTotTipo = BC003D19_A1168TipoOblTotTipo[0] ;
      A2346TipoOblSoloDescu = BC003D19_A2346TipoOblSoloDescu[0] ;
      A1161EmbargaSec = BC003D19_A1161EmbargaSec[0] ;
      n1161EmbargaSec = BC003D19_n1161EmbargaSec[0] ;
      pr_default.close(17);
      if ( (0==A1163TipoOblSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1173OblEstado == 0 ) || ( A1173OblEstado == 1 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Estado", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1175OblOriPer == 1 ) || ( A1175OblOriPer == 2 ) || ( A1175OblOriPer == 3 ) || ( A1175OblOriPer == 4 ) || ( A1175OblOriPer == 5 ) || ( A1175OblOriPer == 6 ) || ( A1175OblOriPer == 7 ) || ( A1175OblOriPer == 8 ) || ( A1175OblOriPer == 9 ) || ( A1175OblOriPer == 10 ) || ( A1175OblOriPer == 11 ) || ( A1175OblOriPer == 12 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Origen Periodo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( A1179OblPorc.doubleValue() >= 1 )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "El porcentaje debe estar entre los valores 0 y 1", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( (GXutil.strcmp("", A2343OblConcepto)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( isIns( )  && (GXutil.strcmp("", A2345OblTipoMov)==0) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_134 = (short)(1) ;
         A2345OblTipoMov = "Descuento" ;
      }
      else
      {
         if ( A2346TipoOblSoloDescu )
         {
            nIsDirty_134 = (short)(1) ;
            A2345OblTipoMov = "Descuento" ;
         }
      }
      if ( ! ( ( GXutil.strcmp(A2345OblTipoMov, "Descuento") == 0 ) || ( GXutil.strcmp(A2345OblTipoMov, "Acreditacion") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors3D134( )
   {
      pr_default.close(12);
      pr_default.close(13);
      pr_default.close(14);
      pr_default.close(15);
      pr_default.close(16);
      pr_default.close(17);
   }

   public void enableDisable( )
   {
   }

   public void getKey3D134( )
   {
      /* Using cursor BC003D20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound134 = (short)(1) ;
      }
      else
      {
         RcdFound134 = (short)(0) ;
      }
      pr_default.close(18);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC003D21 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
      if ( (pr_default.getStatus(19) != 101) )
      {
         zm3D134( 16) ;
         RcdFound134 = (short)(1) ;
         A1172OblSecuencial = BC003D21_A1172OblSecuencial[0] ;
         A2345OblTipoMov = BC003D21_A2345OblTipoMov[0] ;
         A1173OblEstado = BC003D21_A1173OblEstado[0] ;
         A1174OblObs = BC003D21_A1174OblObs[0] ;
         A1175OblOriPer = BC003D21_A1175OblOriPer[0] ;
         A1176OblTotal = BC003D21_A1176OblTotal[0] ;
         A1177OblCanCuo = BC003D21_A1177OblCanCuo[0] ;
         A1178OblImpFij = BC003D21_A1178OblImpFij[0] ;
         A1179OblPorc = BC003D21_A1179OblPorc[0] ;
         A1181OblNoRemu = BC003D21_A1181OblNoRemu[0] ;
         A1182OblDescu = BC003D21_A1182OblDescu[0] ;
         A1196OblAntiRelaLiq = BC003D21_A1196OblAntiRelaLiq[0] ;
         A3CliCod = BC003D21_A3CliCod[0] ;
         A2343OblConcepto = BC003D21_A2343OblConcepto[0] ;
         A1EmpCod = BC003D21_A1EmpCod[0] ;
         A6LegNumero = BC003D21_A6LegNumero[0] ;
         A1195OblLiqNro = BC003D21_A1195OblLiqNro[0] ;
         n1195OblLiqNro = BC003D21_n1195OblLiqNro[0] ;
         A1169OblConCodigo = BC003D21_A1169OblConCodigo[0] ;
         n1169OblConCodigo = BC003D21_n1169OblConCodigo[0] ;
         A1163TipoOblSec = BC003D21_A1163TipoOblSec[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1172OblSecuencial = A1172OblSecuencial ;
         sMode134 = Gx_mode ;
         Gx_mode = "DSP" ;
         load3D134( ) ;
         if ( AnyError == 1 )
         {
            RcdFound134 = (short)(0) ;
            initializeNonKey3D134( ) ;
         }
         Gx_mode = sMode134 ;
      }
      else
      {
         RcdFound134 = (short)(0) ;
         initializeNonKey3D134( ) ;
         sMode134 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode134 ;
      }
      pr_default.close(19);
   }

   public void getEqualNoModal( )
   {
      getKey3D134( ) ;
      if ( RcdFound134 == 0 )
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
      confirm_3D0( ) ;
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

   public void checkOptimisticConcurrency3D134( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC003D22 */
         pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
         if ( (pr_default.getStatus(20) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Obligacion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(20) == 101) || ( GXutil.strcmp(Z2345OblTipoMov, BC003D22_A2345OblTipoMov[0]) != 0 ) || ( Z1173OblEstado != BC003D22_A1173OblEstado[0] ) || ( Z1175OblOriPer != BC003D22_A1175OblOriPer[0] ) || ( DecimalUtil.compareTo(Z1176OblTotal, BC003D22_A1176OblTotal[0]) != 0 ) || ( Z1177OblCanCuo != BC003D22_A1177OblCanCuo[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1178OblImpFij, BC003D22_A1178OblImpFij[0]) != 0 ) || ( DecimalUtil.compareTo(Z1179OblPorc, BC003D22_A1179OblPorc[0]) != 0 ) || ( Z1181OblNoRemu != BC003D22_A1181OblNoRemu[0] ) || ( Z1182OblDescu != BC003D22_A1182OblDescu[0] ) || ( Z1196OblAntiRelaLiq != BC003D22_A1196OblAntiRelaLiq[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2343OblConcepto, BC003D22_A2343OblConcepto[0]) != 0 ) || ( Z1195OblLiqNro != BC003D22_A1195OblLiqNro[0] ) || ( GXutil.strcmp(Z1169OblConCodigo, BC003D22_A1169OblConCodigo[0]) != 0 ) || ( Z1163TipoOblSec != BC003D22_A1163TipoOblSec[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Obligacion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert3D134( )
   {
      beforeValidate3D134( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3D134( ) ;
      }
      if ( AnyError == 0 )
      {
         zm3D134( 0) ;
         checkOptimisticConcurrency3D134( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3D134( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert3D134( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC003D23 */
                  pr_default.execute(21, new Object[] {Short.valueOf(A1172OblSecuencial), A2345OblTipoMov, Byte.valueOf(A1173OblEstado), A1174OblObs, Byte.valueOf(A1175OblOriPer), A1176OblTotal, Short.valueOf(A1177OblCanCuo), A1178OblImpFij, A1179OblPorc, Boolean.valueOf(A1181OblNoRemu), Boolean.valueOf(A1182OblDescu), Boolean.valueOf(A1196OblAntiRelaLiq), Integer.valueOf(A3CliCod), A2343OblConcepto, Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Boolean.valueOf(n1195OblLiqNro), Integer.valueOf(A1195OblLiqNro), Boolean.valueOf(n1169OblConCodigo), A1169OblConCodigo, Short.valueOf(A1163TipoOblSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Obligacion");
                  if ( (pr_default.getStatus(21) == 1) )
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
                        processLevel3D134( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                        }
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
            load3D134( ) ;
         }
         endLevel3D134( ) ;
      }
      closeExtendedTableCursors3D134( ) ;
   }

   public void update3D134( )
   {
      beforeValidate3D134( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3D134( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3D134( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3D134( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate3D134( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC003D24 */
                  pr_default.execute(22, new Object[] {A2345OblTipoMov, Byte.valueOf(A1173OblEstado), A1174OblObs, Byte.valueOf(A1175OblOriPer), A1176OblTotal, Short.valueOf(A1177OblCanCuo), A1178OblImpFij, A1179OblPorc, Boolean.valueOf(A1181OblNoRemu), Boolean.valueOf(A1182OblDescu), Boolean.valueOf(A1196OblAntiRelaLiq), A2343OblConcepto, Boolean.valueOf(n1195OblLiqNro), Integer.valueOf(A1195OblLiqNro), Boolean.valueOf(n1169OblConCodigo), A1169OblConCodigo, Short.valueOf(A1163TipoOblSec), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Obligacion");
                  if ( (pr_default.getStatus(22) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Obligacion"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate3D134( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel3D134( ) ;
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey( ) ;
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                           endTrnMsgCod = "SuccessfullyUpdated" ;
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
         }
         endLevel3D134( ) ;
      }
      closeExtendedTableCursors3D134( ) ;
   }

   public void deferredUpdate3D134( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate3D134( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3D134( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls3D134( ) ;
         afterConfirm3D134( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete3D134( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart3D138( ) ;
               while ( RcdFound138 != 0 )
               {
                  getByPrimaryKey3D138( ) ;
                  delete3D138( ) ;
                  scanKeyNext3D138( ) ;
               }
               scanKeyEnd3D138( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC003D25 */
                  pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Obligacion");
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
      }
      sMode134 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel3D134( ) ;
      Gx_mode = sMode134 ;
   }

   public void onDeleteControls3D134( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV52Pgmname = "Obligacion_BC" ;
         /* Using cursor BC003D26 */
         pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         A250LegIdNomApe = BC003D26_A250LegIdNomApe[0] ;
         A251LegNombre = BC003D26_A251LegNombre[0] ;
         A251LegNombre = BC003D26_A251LegNombre[0] ;
         A230LegApellido = BC003D26_A230LegApellido[0] ;
         A230LegApellido = BC003D26_A230LegApellido[0] ;
         A93LegId = BC003D26_A93LegId[0] ;
         n93LegId = BC003D26_n93LegId[0] ;
         A93LegId = BC003D26_A93LegId[0] ;
         n93LegId = BC003D26_n93LegId[0] ;
         pr_default.close(24);
         /* Using cursor BC003D27 */
         pr_default.execute(25, new Object[] {Short.valueOf(A1163TipoOblSec)});
         A1165TipoOblDescrip = BC003D27_A1165TipoOblDescrip[0] ;
         A1164TipoOblCodigo = BC003D27_A1164TipoOblCodigo[0] ;
         A1168TipoOblTotTipo = BC003D27_A1168TipoOblTotTipo[0] ;
         A2346TipoOblSoloDescu = BC003D27_A2346TipoOblSoloDescu[0] ;
         A1161EmbargaSec = BC003D27_A1161EmbargaSec[0] ;
         n1161EmbargaSec = BC003D27_n1161EmbargaSec[0] ;
         pr_default.close(25);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC003D28 */
         pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
         if ( (pr_default.getStatus(26) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Obligacion Cuenta", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(26);
      }
   }

   public void processNestedLevel3D138( )
   {
      nGXsfl_138_idx = 0 ;
      while ( nGXsfl_138_idx < bcObligacion.getgxTv_SdtObligacion_Excepciones().size() )
      {
         readRow3D138( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound138 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_138 != 0 ) )
         {
            standaloneNotModal3D138( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert3D138( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete3D138( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update3D138( ) ;
               }
            }
         }
         KeyVarsToRow138( ((web.SdtObligacion_Excepciones)bcObligacion.getgxTv_SdtObligacion_Excepciones().elementAt(-1+nGXsfl_138_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_138_idx = 0 ;
         while ( nGXsfl_138_idx < bcObligacion.getgxTv_SdtObligacion_Excepciones().size() )
         {
            readRow3D138( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound138 == 0 )
               {
                  Gx_mode = "INS" ;
               }
               else
               {
                  Gx_mode = "UPD" ;
               }
            }
            /* Update SDT row */
            if ( isDlt( ) )
            {
               bcObligacion.getgxTv_SdtObligacion_Excepciones().removeElement(nGXsfl_138_idx);
               nGXsfl_138_idx = (int)(nGXsfl_138_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey3D138( ) ;
               VarsToRow138( ((web.SdtObligacion_Excepciones)bcObligacion.getgxTv_SdtObligacion_Excepciones().elementAt(-1+nGXsfl_138_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll3D138( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_138 = (short)(0) ;
      nIsMod_138 = (short)(0) ;
      Gxremove138 = (byte)(0) ;
   }

   public void processLevel3D134( )
   {
      /* Save parent mode. */
      sMode134 = Gx_mode ;
      processNestedLevel3D138( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode134 ;
      /* ' Update level parameters */
   }

   public void endLevel3D134( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(20);
      }
      if ( AnyError == 0 )
      {
         beforeComplete3D134( ) ;
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

   public void scanKeyStart3D134( )
   {
      /* Scan By routine */
      /* Using cursor BC003D29 */
      pr_default.execute(27, new Object[] {Short.valueOf(A1172OblSecuencial), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      RcdFound134 = (short)(0) ;
      if ( (pr_default.getStatus(27) != 101) )
      {
         RcdFound134 = (short)(1) ;
         A250LegIdNomApe = BC003D29_A250LegIdNomApe[0] ;
         A1172OblSecuencial = BC003D29_A1172OblSecuencial[0] ;
         A2345OblTipoMov = BC003D29_A2345OblTipoMov[0] ;
         A1165TipoOblDescrip = BC003D29_A1165TipoOblDescrip[0] ;
         A1164TipoOblCodigo = BC003D29_A1164TipoOblCodigo[0] ;
         A1173OblEstado = BC003D29_A1173OblEstado[0] ;
         A1174OblObs = BC003D29_A1174OblObs[0] ;
         A1175OblOriPer = BC003D29_A1175OblOriPer[0] ;
         A1168TipoOblTotTipo = BC003D29_A1168TipoOblTotTipo[0] ;
         A1176OblTotal = BC003D29_A1176OblTotal[0] ;
         A1177OblCanCuo = BC003D29_A1177OblCanCuo[0] ;
         A1178OblImpFij = BC003D29_A1178OblImpFij[0] ;
         A1179OblPorc = BC003D29_A1179OblPorc[0] ;
         A1181OblNoRemu = BC003D29_A1181OblNoRemu[0] ;
         A1182OblDescu = BC003D29_A1182OblDescu[0] ;
         A1196OblAntiRelaLiq = BC003D29_A1196OblAntiRelaLiq[0] ;
         A2346TipoOblSoloDescu = BC003D29_A2346TipoOblSoloDescu[0] ;
         A251LegNombre = BC003D29_A251LegNombre[0] ;
         A230LegApellido = BC003D29_A230LegApellido[0] ;
         A93LegId = BC003D29_A93LegId[0] ;
         n93LegId = BC003D29_n93LegId[0] ;
         A3CliCod = BC003D29_A3CliCod[0] ;
         A2343OblConcepto = BC003D29_A2343OblConcepto[0] ;
         A1EmpCod = BC003D29_A1EmpCod[0] ;
         A6LegNumero = BC003D29_A6LegNumero[0] ;
         A1195OblLiqNro = BC003D29_A1195OblLiqNro[0] ;
         n1195OblLiqNro = BC003D29_n1195OblLiqNro[0] ;
         A1169OblConCodigo = BC003D29_A1169OblConCodigo[0] ;
         n1169OblConCodigo = BC003D29_n1169OblConCodigo[0] ;
         A1163TipoOblSec = BC003D29_A1163TipoOblSec[0] ;
         A1161EmbargaSec = BC003D29_A1161EmbargaSec[0] ;
         n1161EmbargaSec = BC003D29_n1161EmbargaSec[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext3D134( )
   {
      /* Scan next routine */
      pr_default.readNext(27);
      RcdFound134 = (short)(0) ;
      scanKeyLoad3D134( ) ;
   }

   public void scanKeyLoad3D134( )
   {
      sMode134 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(27) != 101) )
      {
         RcdFound134 = (short)(1) ;
         A250LegIdNomApe = BC003D29_A250LegIdNomApe[0] ;
         A1172OblSecuencial = BC003D29_A1172OblSecuencial[0] ;
         A2345OblTipoMov = BC003D29_A2345OblTipoMov[0] ;
         A1165TipoOblDescrip = BC003D29_A1165TipoOblDescrip[0] ;
         A1164TipoOblCodigo = BC003D29_A1164TipoOblCodigo[0] ;
         A1173OblEstado = BC003D29_A1173OblEstado[0] ;
         A1174OblObs = BC003D29_A1174OblObs[0] ;
         A1175OblOriPer = BC003D29_A1175OblOriPer[0] ;
         A1168TipoOblTotTipo = BC003D29_A1168TipoOblTotTipo[0] ;
         A1176OblTotal = BC003D29_A1176OblTotal[0] ;
         A1177OblCanCuo = BC003D29_A1177OblCanCuo[0] ;
         A1178OblImpFij = BC003D29_A1178OblImpFij[0] ;
         A1179OblPorc = BC003D29_A1179OblPorc[0] ;
         A1181OblNoRemu = BC003D29_A1181OblNoRemu[0] ;
         A1182OblDescu = BC003D29_A1182OblDescu[0] ;
         A1196OblAntiRelaLiq = BC003D29_A1196OblAntiRelaLiq[0] ;
         A2346TipoOblSoloDescu = BC003D29_A2346TipoOblSoloDescu[0] ;
         A251LegNombre = BC003D29_A251LegNombre[0] ;
         A230LegApellido = BC003D29_A230LegApellido[0] ;
         A93LegId = BC003D29_A93LegId[0] ;
         n93LegId = BC003D29_n93LegId[0] ;
         A3CliCod = BC003D29_A3CliCod[0] ;
         A2343OblConcepto = BC003D29_A2343OblConcepto[0] ;
         A1EmpCod = BC003D29_A1EmpCod[0] ;
         A6LegNumero = BC003D29_A6LegNumero[0] ;
         A1195OblLiqNro = BC003D29_A1195OblLiqNro[0] ;
         n1195OblLiqNro = BC003D29_n1195OblLiqNro[0] ;
         A1169OblConCodigo = BC003D29_A1169OblConCodigo[0] ;
         n1169OblConCodigo = BC003D29_n1169OblConCodigo[0] ;
         A1163TipoOblSec = BC003D29_A1163TipoOblSec[0] ;
         A1161EmbargaSec = BC003D29_A1161EmbargaSec[0] ;
         n1161EmbargaSec = BC003D29_n1161EmbargaSec[0] ;
      }
      Gx_mode = sMode134 ;
   }

   public void scanKeyEnd3D134( )
   {
      pr_default.close(27);
   }

   public void afterConfirm3D134( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert3D134( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate3D134( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete3D134( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete3D134( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate3D134( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes3D134( )
   {
   }

   public void zm3D138( int GX_JID )
   {
      if ( ( GX_JID == 23 ) || ( GX_JID == 0 ) )
      {
         Z1183OblExcTipo = A1183OblExcTipo ;
      }
      if ( ( GX_JID == 24 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -23 )
      {
         Z1183OblExcTipo = A1183OblExcTipo ;
         Z3CliCod = A3CliCod ;
         Z1170OblExcConCOdigo = A1170OblExcConCOdigo ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1172OblSecuencial = A1172OblSecuencial ;
      }
   }

   public void standaloneNotModal3D138( )
   {
   }

   public void standaloneModal3D138( )
   {
   }

   public void load3D138( )
   {
      /* Using cursor BC003D30 */
      pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), A1170OblExcConCOdigo});
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound138 = (short)(1) ;
         A1183OblExcTipo = BC003D30_A1183OblExcTipo[0] ;
         zm3D138( -23) ;
      }
      pr_default.close(28);
      onLoadActions3D138( ) ;
   }

   public void onLoadActions3D138( )
   {
   }

   public void checkExtendedTable3D138( )
   {
      nIsDirty_138 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal3D138( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC003D31 */
      pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), A1170OblExcConCOdigo});
      if ( (pr_default.getStatus(29) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Obl Excp Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OBLEXCCONCODIGO");
         AnyError = (short)(1) ;
      }
      pr_default.close(29);
   }

   public void closeExtendedTableCursors3D138( )
   {
      pr_default.close(29);
   }

   public void enableDisable3D138( )
   {
   }

   public void getKey3D138( )
   {
      /* Using cursor BC003D32 */
      pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), A1170OblExcConCOdigo});
      if ( (pr_default.getStatus(30) != 101) )
      {
         RcdFound138 = (short)(1) ;
      }
      else
      {
         RcdFound138 = (short)(0) ;
      }
      pr_default.close(30);
   }

   public void getByPrimaryKey3D138( )
   {
      /* Using cursor BC003D33 */
      pr_default.execute(31, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), A1170OblExcConCOdigo});
      if ( (pr_default.getStatus(31) != 101) )
      {
         zm3D138( 23) ;
         RcdFound138 = (short)(1) ;
         initializeNonKey3D138( ) ;
         A1183OblExcTipo = BC003D33_A1183OblExcTipo[0] ;
         A1170OblExcConCOdigo = BC003D33_A1170OblExcConCOdigo[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1172OblSecuencial = A1172OblSecuencial ;
         Z1170OblExcConCOdigo = A1170OblExcConCOdigo ;
         sMode138 = Gx_mode ;
         Gx_mode = "DSP" ;
         load3D138( ) ;
         Gx_mode = sMode138 ;
      }
      else
      {
         RcdFound138 = (short)(0) ;
         initializeNonKey3D138( ) ;
         sMode138 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal3D138( ) ;
         Gx_mode = sMode138 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes3D138( ) ;
      }
      pr_default.close(31);
   }

   public void checkOptimisticConcurrency3D138( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC003D34 */
         pr_default.execute(32, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), A1170OblExcConCOdigo});
         if ( (pr_default.getStatus(32) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ObligacionExcepciones"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(32) == 101) || ( GXutil.strcmp(Z1183OblExcTipo, BC003D34_A1183OblExcTipo[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ObligacionExcepciones"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert3D138( )
   {
      beforeValidate3D138( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3D138( ) ;
      }
      if ( AnyError == 0 )
      {
         zm3D138( 0) ;
         checkOptimisticConcurrency3D138( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3D138( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert3D138( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC003D35 */
                  pr_default.execute(33, new Object[] {A1183OblExcTipo, Integer.valueOf(A3CliCod), A1170OblExcConCOdigo, Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ObligacionExcepciones");
                  if ( (pr_default.getStatus(33) == 1) )
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
            load3D138( ) ;
         }
         endLevel3D138( ) ;
      }
      closeExtendedTableCursors3D138( ) ;
   }

   public void update3D138( )
   {
      beforeValidate3D138( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3D138( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3D138( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3D138( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate3D138( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC003D36 */
                  pr_default.execute(34, new Object[] {A1183OblExcTipo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), A1170OblExcConCOdigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ObligacionExcepciones");
                  if ( (pr_default.getStatus(34) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ObligacionExcepciones"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate3D138( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey3D138( ) ;
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
         endLevel3D138( ) ;
      }
      closeExtendedTableCursors3D138( ) ;
   }

   public void deferredUpdate3D138( )
   {
   }

   public void delete3D138( )
   {
      Gx_mode = "DLT" ;
      beforeValidate3D138( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3D138( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls3D138( ) ;
         afterConfirm3D138( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete3D138( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC003D37 */
               pr_default.execute(35, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), A1170OblExcConCOdigo});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ObligacionExcepciones");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode138 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel3D138( ) ;
      Gx_mode = sMode138 ;
   }

   public void onDeleteControls3D138( )
   {
      standaloneModal3D138( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel3D138( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(32);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart3D138( )
   {
      /* Scan By routine */
      /* Using cursor BC003D38 */
      pr_default.execute(36, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial)});
      RcdFound138 = (short)(0) ;
      if ( (pr_default.getStatus(36) != 101) )
      {
         RcdFound138 = (short)(1) ;
         A1183OblExcTipo = BC003D38_A1183OblExcTipo[0] ;
         A1170OblExcConCOdigo = BC003D38_A1170OblExcConCOdigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext3D138( )
   {
      /* Scan next routine */
      pr_default.readNext(36);
      RcdFound138 = (short)(0) ;
      scanKeyLoad3D138( ) ;
   }

   public void scanKeyLoad3D138( )
   {
      sMode138 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(36) != 101) )
      {
         RcdFound138 = (short)(1) ;
         A1183OblExcTipo = BC003D38_A1183OblExcTipo[0] ;
         A1170OblExcConCOdigo = BC003D38_A1170OblExcConCOdigo[0] ;
      }
      Gx_mode = sMode138 ;
   }

   public void scanKeyEnd3D138( )
   {
      pr_default.close(36);
   }

   public void afterConfirm3D138( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert3D138( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate3D138( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete3D138( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete3D138( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate3D138( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes3D138( )
   {
   }

   public void send_integrity_lvl_hashes3D138( )
   {
   }

   public void send_integrity_lvl_hashes3D134( )
   {
   }

   public void addRow3D134( )
   {
      VarsToRow134( bcObligacion) ;
   }

   public void readRow3D134( )
   {
      RowToVars134( bcObligacion, 1) ;
   }

   public void addRow3D138( )
   {
      web.SdtObligacion_Excepciones obj138;
      obj138 = new web.SdtObligacion_Excepciones(remoteHandle);
      VarsToRow138( obj138) ;
      bcObligacion.getgxTv_SdtObligacion_Excepciones().add(obj138, 0);
      obj138.setgxTv_SdtObligacion_Excepciones_Mode( "UPD" );
      obj138.setgxTv_SdtObligacion_Excepciones_Modified( (short)(0) );
   }

   public void readRow3D138( )
   {
      nGXsfl_138_idx = (int)(nGXsfl_138_idx+1) ;
      RowToVars138( ((web.SdtObligacion_Excepciones)bcObligacion.getgxTv_SdtObligacion_Excepciones().elementAt(-1+nGXsfl_138_idx)), 1) ;
   }

   public void initializeNonKey3D134( )
   {
      A31LiqNro = 0 ;
      A250LegIdNomApe = "" ;
      A1163TipoOblSec = (short)(0) ;
      A1165TipoOblDescrip = "" ;
      A1164TipoOblCodigo = "" ;
      A1174OblObs = "" ;
      A1175OblOriPer = (byte)(0) ;
      A1168TipoOblTotTipo = (byte)(0) ;
      A1161EmbargaSec = (short)(0) ;
      n1161EmbargaSec = false ;
      A1169OblConCodigo = "" ;
      n1169OblConCodigo = false ;
      A1176OblTotal = DecimalUtil.ZERO ;
      A1177OblCanCuo = (short)(0) ;
      A1178OblImpFij = DecimalUtil.ZERO ;
      A1179OblPorc = DecimalUtil.ZERO ;
      A1181OblNoRemu = false ;
      A1182OblDescu = false ;
      A1195OblLiqNro = 0 ;
      n1195OblLiqNro = false ;
      A1196OblAntiRelaLiq = false ;
      A2343OblConcepto = "" ;
      A2346TipoOblSoloDescu = false ;
      A251LegNombre = "" ;
      A230LegApellido = "" ;
      A93LegId = "" ;
      n93LegId = false ;
      A2345OblTipoMov = "Descuento" ;
      A1173OblEstado = (byte)(1) ;
      Z2345OblTipoMov = "" ;
      Z1173OblEstado = (byte)(0) ;
      Z1175OblOriPer = (byte)(0) ;
      Z1176OblTotal = DecimalUtil.ZERO ;
      Z1177OblCanCuo = (short)(0) ;
      Z1178OblImpFij = DecimalUtil.ZERO ;
      Z1179OblPorc = DecimalUtil.ZERO ;
      Z1181OblNoRemu = false ;
      Z1182OblDescu = false ;
      Z1196OblAntiRelaLiq = false ;
      Z2343OblConcepto = "" ;
      Z1195OblLiqNro = 0 ;
      Z1169OblConCodigo = "" ;
      Z1163TipoOblSec = (short)(0) ;
   }

   public void initAll3D134( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A6LegNumero = 0 ;
      A1172OblSecuencial = (short)(0) ;
      initializeNonKey3D134( ) ;
   }

   public void standaloneModalInsert( )
   {
      A1173OblEstado = i1173OblEstado ;
   }

   public void initializeNonKey3D138( )
   {
      A1183OblExcTipo = "" ;
      Z1183OblExcTipo = "" ;
   }

   public void initAll3D138( )
   {
      A1170OblExcConCOdigo = "" ;
      initializeNonKey3D138( ) ;
   }

   public void standaloneModalInsert3D138( )
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

   public void VarsToRow134( web.SdtObligacion obj134 )
   {
      obj134.setgxTv_SdtObligacion_Mode( Gx_mode );
      obj134.setgxTv_SdtObligacion_Legidnomape( A250LegIdNomApe );
      obj134.setgxTv_SdtObligacion_Tipooblsec( A1163TipoOblSec );
      obj134.setgxTv_SdtObligacion_Tipoobldescrip( A1165TipoOblDescrip );
      obj134.setgxTv_SdtObligacion_Tipooblcodigo( A1164TipoOblCodigo );
      obj134.setgxTv_SdtObligacion_Oblobs( A1174OblObs );
      obj134.setgxTv_SdtObligacion_Obloriper( A1175OblOriPer );
      obj134.setgxTv_SdtObligacion_Tipoobltottipo( A1168TipoOblTotTipo );
      obj134.setgxTv_SdtObligacion_Embargasec( A1161EmbargaSec );
      obj134.setgxTv_SdtObligacion_Oblconcodigo( A1169OblConCodigo );
      obj134.setgxTv_SdtObligacion_Obltotal( A1176OblTotal );
      obj134.setgxTv_SdtObligacion_Oblcancuo( A1177OblCanCuo );
      obj134.setgxTv_SdtObligacion_Oblimpfij( A1178OblImpFij );
      obj134.setgxTv_SdtObligacion_Oblporc( A1179OblPorc );
      obj134.setgxTv_SdtObligacion_Oblnoremu( A1181OblNoRemu );
      obj134.setgxTv_SdtObligacion_Obldescu( A1182OblDescu );
      obj134.setgxTv_SdtObligacion_Oblliqnro( A1195OblLiqNro );
      obj134.setgxTv_SdtObligacion_Oblantirelaliq( A1196OblAntiRelaLiq );
      obj134.setgxTv_SdtObligacion_Oblconcepto( A2343OblConcepto );
      obj134.setgxTv_SdtObligacion_Tipooblsolodescu( A2346TipoOblSoloDescu );
      obj134.setgxTv_SdtObligacion_Obltipomov( A2345OblTipoMov );
      obj134.setgxTv_SdtObligacion_Oblestado( A1173OblEstado );
      obj134.setgxTv_SdtObligacion_Clicod( A3CliCod );
      obj134.setgxTv_SdtObligacion_Empcod( A1EmpCod );
      obj134.setgxTv_SdtObligacion_Legnumero( A6LegNumero );
      obj134.setgxTv_SdtObligacion_Oblsecuencial( A1172OblSecuencial );
      obj134.setgxTv_SdtObligacion_Clicod_Z( Z3CliCod );
      obj134.setgxTv_SdtObligacion_Empcod_Z( Z1EmpCod );
      obj134.setgxTv_SdtObligacion_Legnumero_Z( Z6LegNumero );
      obj134.setgxTv_SdtObligacion_Oblsecuencial_Z( Z1172OblSecuencial );
      obj134.setgxTv_SdtObligacion_Legidnomape_Z( Z250LegIdNomApe );
      obj134.setgxTv_SdtObligacion_Tipooblsec_Z( Z1163TipoOblSec );
      obj134.setgxTv_SdtObligacion_Tipoobldescrip_Z( Z1165TipoOblDescrip );
      obj134.setgxTv_SdtObligacion_Tipooblcodigo_Z( Z1164TipoOblCodigo );
      obj134.setgxTv_SdtObligacion_Oblestado_Z( Z1173OblEstado );
      obj134.setgxTv_SdtObligacion_Obloriper_Z( Z1175OblOriPer );
      obj134.setgxTv_SdtObligacion_Tipoobltottipo_Z( Z1168TipoOblTotTipo );
      obj134.setgxTv_SdtObligacion_Embargasec_Z( Z1161EmbargaSec );
      obj134.setgxTv_SdtObligacion_Oblconcodigo_Z( Z1169OblConCodigo );
      obj134.setgxTv_SdtObligacion_Obltotal_Z( Z1176OblTotal );
      obj134.setgxTv_SdtObligacion_Oblcancuo_Z( Z1177OblCanCuo );
      obj134.setgxTv_SdtObligacion_Oblimpfij_Z( Z1178OblImpFij );
      obj134.setgxTv_SdtObligacion_Oblporc_Z( Z1179OblPorc );
      obj134.setgxTv_SdtObligacion_Oblnoremu_Z( Z1181OblNoRemu );
      obj134.setgxTv_SdtObligacion_Obldescu_Z( Z1182OblDescu );
      obj134.setgxTv_SdtObligacion_Oblliqnro_Z( Z1195OblLiqNro );
      obj134.setgxTv_SdtObligacion_Oblantirelaliq_Z( Z1196OblAntiRelaLiq );
      obj134.setgxTv_SdtObligacion_Oblconcepto_Z( Z2343OblConcepto );
      obj134.setgxTv_SdtObligacion_Obltipomov_Z( Z2345OblTipoMov );
      obj134.setgxTv_SdtObligacion_Tipooblsolodescu_Z( Z2346TipoOblSoloDescu );
      obj134.setgxTv_SdtObligacion_Embargasec_N( (byte)((byte)((n1161EmbargaSec)?1:0)) );
      obj134.setgxTv_SdtObligacion_Oblconcodigo_N( (byte)((byte)((n1169OblConCodigo)?1:0)) );
      obj134.setgxTv_SdtObligacion_Oblliqnro_N( (byte)((byte)((n1195OblLiqNro)?1:0)) );
      obj134.setgxTv_SdtObligacion_Mode( Gx_mode );
   }

   public void KeyVarsToRow134( web.SdtObligacion obj134 )
   {
      obj134.setgxTv_SdtObligacion_Clicod( A3CliCod );
      obj134.setgxTv_SdtObligacion_Empcod( A1EmpCod );
      obj134.setgxTv_SdtObligacion_Legnumero( A6LegNumero );
      obj134.setgxTv_SdtObligacion_Oblsecuencial( A1172OblSecuencial );
   }

   public void RowToVars134( web.SdtObligacion obj134 ,
                             int forceLoad )
   {
      Gx_mode = obj134.getgxTv_SdtObligacion_Mode() ;
      A250LegIdNomApe = obj134.getgxTv_SdtObligacion_Legidnomape() ;
      A1163TipoOblSec = obj134.getgxTv_SdtObligacion_Tipooblsec() ;
      A1165TipoOblDescrip = obj134.getgxTv_SdtObligacion_Tipoobldescrip() ;
      A1164TipoOblCodigo = obj134.getgxTv_SdtObligacion_Tipooblcodigo() ;
      A1174OblObs = obj134.getgxTv_SdtObligacion_Oblobs() ;
      A1175OblOriPer = obj134.getgxTv_SdtObligacion_Obloriper() ;
      A1168TipoOblTotTipo = obj134.getgxTv_SdtObligacion_Tipoobltottipo() ;
      A1161EmbargaSec = obj134.getgxTv_SdtObligacion_Embargasec() ;
      n1161EmbargaSec = false ;
      A1169OblConCodigo = obj134.getgxTv_SdtObligacion_Oblconcodigo() ;
      n1169OblConCodigo = false ;
      A1176OblTotal = obj134.getgxTv_SdtObligacion_Obltotal() ;
      A1177OblCanCuo = obj134.getgxTv_SdtObligacion_Oblcancuo() ;
      A1178OblImpFij = obj134.getgxTv_SdtObligacion_Oblimpfij() ;
      A1179OblPorc = obj134.getgxTv_SdtObligacion_Oblporc() ;
      A1181OblNoRemu = obj134.getgxTv_SdtObligacion_Oblnoremu() ;
      A1182OblDescu = obj134.getgxTv_SdtObligacion_Obldescu() ;
      A1195OblLiqNro = obj134.getgxTv_SdtObligacion_Oblliqnro() ;
      n1195OblLiqNro = false ;
      A1196OblAntiRelaLiq = obj134.getgxTv_SdtObligacion_Oblantirelaliq() ;
      A2343OblConcepto = obj134.getgxTv_SdtObligacion_Oblconcepto() ;
      A2346TipoOblSoloDescu = obj134.getgxTv_SdtObligacion_Tipooblsolodescu() ;
      if ( ! ( ( obj134.getgxTv_SdtObligacion_Tipooblsolodescu() ) ) || ( forceLoad == 1 ) )
      {
         A2345OblTipoMov = obj134.getgxTv_SdtObligacion_Obltipomov() ;
      }
      A1173OblEstado = obj134.getgxTv_SdtObligacion_Oblestado() ;
      A3CliCod = obj134.getgxTv_SdtObligacion_Clicod() ;
      A1EmpCod = obj134.getgxTv_SdtObligacion_Empcod() ;
      A6LegNumero = obj134.getgxTv_SdtObligacion_Legnumero() ;
      A1172OblSecuencial = obj134.getgxTv_SdtObligacion_Oblsecuencial() ;
      Z3CliCod = obj134.getgxTv_SdtObligacion_Clicod_Z() ;
      Z1EmpCod = obj134.getgxTv_SdtObligacion_Empcod_Z() ;
      Z6LegNumero = obj134.getgxTv_SdtObligacion_Legnumero_Z() ;
      Z1172OblSecuencial = obj134.getgxTv_SdtObligacion_Oblsecuencial_Z() ;
      Z250LegIdNomApe = obj134.getgxTv_SdtObligacion_Legidnomape_Z() ;
      Z1163TipoOblSec = obj134.getgxTv_SdtObligacion_Tipooblsec_Z() ;
      Z1165TipoOblDescrip = obj134.getgxTv_SdtObligacion_Tipoobldescrip_Z() ;
      Z1164TipoOblCodigo = obj134.getgxTv_SdtObligacion_Tipooblcodigo_Z() ;
      Z1173OblEstado = obj134.getgxTv_SdtObligacion_Oblestado_Z() ;
      Z1175OblOriPer = obj134.getgxTv_SdtObligacion_Obloriper_Z() ;
      Z1168TipoOblTotTipo = obj134.getgxTv_SdtObligacion_Tipoobltottipo_Z() ;
      Z1161EmbargaSec = obj134.getgxTv_SdtObligacion_Embargasec_Z() ;
      Z1169OblConCodigo = obj134.getgxTv_SdtObligacion_Oblconcodigo_Z() ;
      Z1176OblTotal = obj134.getgxTv_SdtObligacion_Obltotal_Z() ;
      Z1177OblCanCuo = obj134.getgxTv_SdtObligacion_Oblcancuo_Z() ;
      Z1178OblImpFij = obj134.getgxTv_SdtObligacion_Oblimpfij_Z() ;
      Z1179OblPorc = obj134.getgxTv_SdtObligacion_Oblporc_Z() ;
      Z1181OblNoRemu = obj134.getgxTv_SdtObligacion_Oblnoremu_Z() ;
      Z1182OblDescu = obj134.getgxTv_SdtObligacion_Obldescu_Z() ;
      Z1195OblLiqNro = obj134.getgxTv_SdtObligacion_Oblliqnro_Z() ;
      Z1196OblAntiRelaLiq = obj134.getgxTv_SdtObligacion_Oblantirelaliq_Z() ;
      Z2343OblConcepto = obj134.getgxTv_SdtObligacion_Oblconcepto_Z() ;
      Z2345OblTipoMov = obj134.getgxTv_SdtObligacion_Obltipomov_Z() ;
      Z2346TipoOblSoloDescu = obj134.getgxTv_SdtObligacion_Tipooblsolodescu_Z() ;
      n1161EmbargaSec = (boolean)((obj134.getgxTv_SdtObligacion_Embargasec_N()==0)?false:true) ;
      n1169OblConCodigo = (boolean)((obj134.getgxTv_SdtObligacion_Oblconcodigo_N()==0)?false:true) ;
      n1195OblLiqNro = (boolean)((obj134.getgxTv_SdtObligacion_Oblliqnro_N()==0)?false:true) ;
      Gx_mode = obj134.getgxTv_SdtObligacion_Mode() ;
   }

   public void VarsToRow138( web.SdtObligacion_Excepciones obj138 )
   {
      obj138.setgxTv_SdtObligacion_Excepciones_Mode( Gx_mode );
      obj138.setgxTv_SdtObligacion_Excepciones_Oblexctipo( A1183OblExcTipo );
      obj138.setgxTv_SdtObligacion_Excepciones_Oblexcconcodigo( A1170OblExcConCOdigo );
      obj138.setgxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z( Z1170OblExcConCOdigo );
      obj138.setgxTv_SdtObligacion_Excepciones_Oblexctipo_Z( Z1183OblExcTipo );
      obj138.setgxTv_SdtObligacion_Excepciones_Modified( nIsMod_138 );
   }

   public void KeyVarsToRow138( web.SdtObligacion_Excepciones obj138 )
   {
      obj138.setgxTv_SdtObligacion_Excepciones_Oblexcconcodigo( A1170OblExcConCOdigo );
   }

   public void RowToVars138( web.SdtObligacion_Excepciones obj138 ,
                             int forceLoad )
   {
      Gx_mode = obj138.getgxTv_SdtObligacion_Excepciones_Mode() ;
      A1183OblExcTipo = obj138.getgxTv_SdtObligacion_Excepciones_Oblexctipo() ;
      A1170OblExcConCOdigo = obj138.getgxTv_SdtObligacion_Excepciones_Oblexcconcodigo() ;
      Z1170OblExcConCOdigo = obj138.getgxTv_SdtObligacion_Excepciones_Oblexcconcodigo_Z() ;
      Z1183OblExcTipo = obj138.getgxTv_SdtObligacion_Excepciones_Oblexctipo_Z() ;
      nIsMod_138 = obj138.getgxTv_SdtObligacion_Excepciones_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A6LegNumero = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.INT)).intValue() ;
      A1172OblSecuencial = ((Number) GXutil.testNumericType( getParm(obj,3), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey3D134( ) ;
      scanKeyStart3D134( ) ;
      if ( RcdFound134 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC003D39 */
         pr_default.execute(37, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(37) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
         }
         A250LegIdNomApe = BC003D39_A250LegIdNomApe[0] ;
         A251LegNombre = BC003D39_A251LegNombre[0] ;
         A251LegNombre = BC003D39_A251LegNombre[0] ;
         A230LegApellido = BC003D39_A230LegApellido[0] ;
         A230LegApellido = BC003D39_A230LegApellido[0] ;
         A93LegId = BC003D39_A93LegId[0] ;
         n93LegId = BC003D39_n93LegId[0] ;
         A93LegId = BC003D39_A93LegId[0] ;
         n93LegId = BC003D39_n93LegId[0] ;
         pr_default.close(37);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1172OblSecuencial = A1172OblSecuencial ;
      }
      zm3D134( -16) ;
      onLoadActions3D134( ) ;
      addRow3D134( ) ;
      bcObligacion.getgxTv_SdtObligacion_Excepciones().clearCollection();
      if ( RcdFound134 == 1 )
      {
         scanKeyStart3D138( ) ;
         nGXsfl_138_idx = 1 ;
         while ( RcdFound138 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z6LegNumero = A6LegNumero ;
            Z1172OblSecuencial = A1172OblSecuencial ;
            Z1170OblExcConCOdigo = A1170OblExcConCOdigo ;
            zm3D138( -23) ;
            onLoadActions3D138( ) ;
            nRcdExists_138 = (short)(1) ;
            nIsMod_138 = (short)(0) ;
            addRow3D138( ) ;
            nGXsfl_138_idx = (int)(nGXsfl_138_idx+1) ;
            scanKeyNext3D138( ) ;
         }
         scanKeyEnd3D138( ) ;
      }
      scanKeyEnd3D134( ) ;
      if ( RcdFound134 == 0 )
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
      RowToVars134( bcObligacion, 0) ;
      scanKeyStart3D134( ) ;
      if ( RcdFound134 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC003D40 */
         pr_default.execute(38, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(38) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
         }
         A250LegIdNomApe = BC003D40_A250LegIdNomApe[0] ;
         A251LegNombre = BC003D40_A251LegNombre[0] ;
         A251LegNombre = BC003D40_A251LegNombre[0] ;
         A230LegApellido = BC003D40_A230LegApellido[0] ;
         A230LegApellido = BC003D40_A230LegApellido[0] ;
         A93LegId = BC003D40_A93LegId[0] ;
         n93LegId = BC003D40_n93LegId[0] ;
         A93LegId = BC003D40_A93LegId[0] ;
         n93LegId = BC003D40_n93LegId[0] ;
         pr_default.close(38);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z1172OblSecuencial = A1172OblSecuencial ;
      }
      zm3D134( -16) ;
      onLoadActions3D134( ) ;
      addRow3D134( ) ;
      bcObligacion.getgxTv_SdtObligacion_Excepciones().clearCollection();
      if ( RcdFound134 == 1 )
      {
         scanKeyStart3D138( ) ;
         nGXsfl_138_idx = 1 ;
         while ( RcdFound138 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z6LegNumero = A6LegNumero ;
            Z1172OblSecuencial = A1172OblSecuencial ;
            Z1170OblExcConCOdigo = A1170OblExcConCOdigo ;
            zm3D138( -23) ;
            onLoadActions3D138( ) ;
            nRcdExists_138 = (short)(1) ;
            nIsMod_138 = (short)(0) ;
            addRow3D138( ) ;
            nGXsfl_138_idx = (int)(nGXsfl_138_idx+1) ;
            scanKeyNext3D138( ) ;
         }
         scanKeyEnd3D138( ) ;
      }
      scanKeyEnd3D134( ) ;
      if ( RcdFound134 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey3D134( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert3D134( ) ;
      }
      else
      {
         if ( RcdFound134 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A1172OblSecuencial != Z1172OblSecuencial ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A6LegNumero = Z6LegNumero ;
               A1172OblSecuencial = Z1172OblSecuencial ;
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
               update3D134( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A1172OblSecuencial != Z1172OblSecuencial ) )
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
                     insert3D134( ) ;
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
                     insert3D134( ) ;
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
      RowToVars134( bcObligacion, 1) ;
      saveImpl( ) ;
      VarsToRow134( bcObligacion) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars134( bcObligacion, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert3D134( ) ;
      afterTrn( ) ;
      VarsToRow134( bcObligacion) ;
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
         web.SdtObligacion auxBC = new web.SdtObligacion( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A6LegNumero, A1172OblSecuencial);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcObligacion);
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
      RowToVars134( bcObligacion, 1) ;
      updateImpl( ) ;
      VarsToRow134( bcObligacion) ;
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
      RowToVars134( bcObligacion, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert3D134( ) ;
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
      VarsToRow134( bcObligacion) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars134( bcObligacion, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey3D134( ) ;
      if ( RcdFound134 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A1172OblSecuencial != Z1172OblSecuencial ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A6LegNumero = Z6LegNumero ;
            A1172OblSecuencial = Z1172OblSecuencial ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A1172OblSecuencial != Z1172OblSecuencial ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "obligacion_bc");
      VarsToRow134( bcObligacion) ;
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
      Gx_mode = bcObligacion.getgxTv_SdtObligacion_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcObligacion.setgxTv_SdtObligacion_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtObligacion sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcObligacion )
      {
         bcObligacion = sdt ;
         if ( GXutil.strcmp(bcObligacion.getgxTv_SdtObligacion_Mode(), "") == 0 )
         {
            bcObligacion.setgxTv_SdtObligacion_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow134( bcObligacion) ;
         }
         else
         {
            RowToVars134( bcObligacion, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcObligacion.getgxTv_SdtObligacion_Mode(), "") == 0 )
         {
            bcObligacion.setgxTv_SdtObligacion_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars134( bcObligacion, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtObligacion getObligacion_BC( )
   {
      return bcObligacion ;
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
      sMode134 = "" ;
      AV11WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV52Pgmname = "" ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      AV18TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV17Insert_OblConCodigo = "" ;
      AV46Insert_OblConcepto = "" ;
      GXv_int5 = new short[1] ;
      AV43anticipoSubTipoConCod1 = "" ;
      AV44desdeDTipoConCod = "" ;
      AV45hastaDTipoConCod = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      Z2345OblTipoMov = "" ;
      A2345OblTipoMov = "" ;
      Z1176OblTotal = DecimalUtil.ZERO ;
      A1176OblTotal = DecimalUtil.ZERO ;
      Z1178OblImpFij = DecimalUtil.ZERO ;
      A1178OblImpFij = DecimalUtil.ZERO ;
      Z1179OblPorc = DecimalUtil.ZERO ;
      A1179OblPorc = DecimalUtil.ZERO ;
      Z2343OblConcepto = "" ;
      A2343OblConcepto = "" ;
      Z1169OblConCodigo = "" ;
      A1169OblConCodigo = "" ;
      Z250LegIdNomApe = "" ;
      A250LegIdNomApe = "" ;
      Z251LegNombre = "" ;
      A251LegNombre = "" ;
      Z230LegApellido = "" ;
      A230LegApellido = "" ;
      Z93LegId = "" ;
      A93LegId = "" ;
      Z1165TipoOblDescrip = "" ;
      A1165TipoOblDescrip = "" ;
      Z1164TipoOblCodigo = "" ;
      A1164TipoOblCodigo = "" ;
      Z1174OblObs = "" ;
      A1174OblObs = "" ;
      GXv_int9 = new int[1] ;
      BC003D13_A250LegIdNomApe = new String[] {""} ;
      BC003D13_A1172OblSecuencial = new short[1] ;
      BC003D13_A2345OblTipoMov = new String[] {""} ;
      BC003D13_A1165TipoOblDescrip = new String[] {""} ;
      BC003D13_A1164TipoOblCodigo = new String[] {""} ;
      BC003D13_A1173OblEstado = new byte[1] ;
      BC003D13_A1174OblObs = new String[] {""} ;
      BC003D13_A1175OblOriPer = new byte[1] ;
      BC003D13_A1168TipoOblTotTipo = new byte[1] ;
      BC003D13_A1176OblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC003D13_A1177OblCanCuo = new short[1] ;
      BC003D13_A1178OblImpFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC003D13_A1179OblPorc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC003D13_A1181OblNoRemu = new boolean[] {false} ;
      BC003D13_A1182OblDescu = new boolean[] {false} ;
      BC003D13_A1196OblAntiRelaLiq = new boolean[] {false} ;
      BC003D13_A2346TipoOblSoloDescu = new boolean[] {false} ;
      BC003D13_A251LegNombre = new String[] {""} ;
      BC003D13_A230LegApellido = new String[] {""} ;
      BC003D13_A93LegId = new String[] {""} ;
      BC003D13_n93LegId = new boolean[] {false} ;
      BC003D13_A3CliCod = new int[1] ;
      BC003D13_A2343OblConcepto = new String[] {""} ;
      BC003D13_A1EmpCod = new short[1] ;
      BC003D13_A6LegNumero = new int[1] ;
      BC003D13_A1195OblLiqNro = new int[1] ;
      BC003D13_n1195OblLiqNro = new boolean[] {false} ;
      BC003D13_A1169OblConCodigo = new String[] {""} ;
      BC003D13_n1169OblConCodigo = new boolean[] {false} ;
      BC003D13_A1163TipoOblSec = new short[1] ;
      BC003D13_A1161EmbargaSec = new short[1] ;
      BC003D13_n1161EmbargaSec = new boolean[] {false} ;
      BC003D14_A3CliCod = new int[1] ;
      BC003D15_A3CliCod = new int[1] ;
      BC003D16_A3CliCod = new int[1] ;
      BC003D17_A250LegIdNomApe = new String[] {""} ;
      BC003D17_A251LegNombre = new String[] {""} ;
      BC003D17_A230LegApellido = new String[] {""} ;
      BC003D17_A93LegId = new String[] {""} ;
      BC003D17_n93LegId = new boolean[] {false} ;
      BC003D18_A31LiqNro = new int[1] ;
      BC003D19_A1165TipoOblDescrip = new String[] {""} ;
      BC003D19_A1164TipoOblCodigo = new String[] {""} ;
      BC003D19_A1168TipoOblTotTipo = new byte[1] ;
      BC003D19_A2346TipoOblSoloDescu = new boolean[] {false} ;
      BC003D19_A1161EmbargaSec = new short[1] ;
      BC003D19_n1161EmbargaSec = new boolean[] {false} ;
      BC003D20_A3CliCod = new int[1] ;
      BC003D20_A1EmpCod = new short[1] ;
      BC003D20_A6LegNumero = new int[1] ;
      BC003D20_A1172OblSecuencial = new short[1] ;
      BC003D21_A1172OblSecuencial = new short[1] ;
      BC003D21_A2345OblTipoMov = new String[] {""} ;
      BC003D21_A1173OblEstado = new byte[1] ;
      BC003D21_A1174OblObs = new String[] {""} ;
      BC003D21_A1175OblOriPer = new byte[1] ;
      BC003D21_A1176OblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC003D21_A1177OblCanCuo = new short[1] ;
      BC003D21_A1178OblImpFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC003D21_A1179OblPorc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC003D21_A1181OblNoRemu = new boolean[] {false} ;
      BC003D21_A1182OblDescu = new boolean[] {false} ;
      BC003D21_A1196OblAntiRelaLiq = new boolean[] {false} ;
      BC003D21_A3CliCod = new int[1] ;
      BC003D21_A2343OblConcepto = new String[] {""} ;
      BC003D21_A1EmpCod = new short[1] ;
      BC003D21_A6LegNumero = new int[1] ;
      BC003D21_A1195OblLiqNro = new int[1] ;
      BC003D21_n1195OblLiqNro = new boolean[] {false} ;
      BC003D21_A1169OblConCodigo = new String[] {""} ;
      BC003D21_n1169OblConCodigo = new boolean[] {false} ;
      BC003D21_A1163TipoOblSec = new short[1] ;
      BC003D22_A1172OblSecuencial = new short[1] ;
      BC003D22_A2345OblTipoMov = new String[] {""} ;
      BC003D22_A1173OblEstado = new byte[1] ;
      BC003D22_A1174OblObs = new String[] {""} ;
      BC003D22_A1175OblOriPer = new byte[1] ;
      BC003D22_A1176OblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC003D22_A1177OblCanCuo = new short[1] ;
      BC003D22_A1178OblImpFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC003D22_A1179OblPorc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC003D22_A1181OblNoRemu = new boolean[] {false} ;
      BC003D22_A1182OblDescu = new boolean[] {false} ;
      BC003D22_A1196OblAntiRelaLiq = new boolean[] {false} ;
      BC003D22_A3CliCod = new int[1] ;
      BC003D22_A2343OblConcepto = new String[] {""} ;
      BC003D22_A1EmpCod = new short[1] ;
      BC003D22_A6LegNumero = new int[1] ;
      BC003D22_A1195OblLiqNro = new int[1] ;
      BC003D22_n1195OblLiqNro = new boolean[] {false} ;
      BC003D22_A1169OblConCodigo = new String[] {""} ;
      BC003D22_n1169OblConCodigo = new boolean[] {false} ;
      BC003D22_A1163TipoOblSec = new short[1] ;
      BC003D26_A250LegIdNomApe = new String[] {""} ;
      BC003D26_A251LegNombre = new String[] {""} ;
      BC003D26_A230LegApellido = new String[] {""} ;
      BC003D26_A93LegId = new String[] {""} ;
      BC003D26_n93LegId = new boolean[] {false} ;
      BC003D27_A1165TipoOblDescrip = new String[] {""} ;
      BC003D27_A1164TipoOblCodigo = new String[] {""} ;
      BC003D27_A1168TipoOblTotTipo = new byte[1] ;
      BC003D27_A2346TipoOblSoloDescu = new boolean[] {false} ;
      BC003D27_A1161EmbargaSec = new short[1] ;
      BC003D27_n1161EmbargaSec = new boolean[] {false} ;
      BC003D28_A3CliCod = new int[1] ;
      BC003D28_A1EmpCod = new short[1] ;
      BC003D28_A6LegNumero = new int[1] ;
      BC003D28_A1172OblSecuencial = new short[1] ;
      BC003D28_A1184LiqOblAltaNro = new int[1] ;
      BC003D28_A1185LiqOblNuevaNro = new int[1] ;
      BC003D29_A250LegIdNomApe = new String[] {""} ;
      BC003D29_A1172OblSecuencial = new short[1] ;
      BC003D29_A2345OblTipoMov = new String[] {""} ;
      BC003D29_A1165TipoOblDescrip = new String[] {""} ;
      BC003D29_A1164TipoOblCodigo = new String[] {""} ;
      BC003D29_A1173OblEstado = new byte[1] ;
      BC003D29_A1174OblObs = new String[] {""} ;
      BC003D29_A1175OblOriPer = new byte[1] ;
      BC003D29_A1168TipoOblTotTipo = new byte[1] ;
      BC003D29_A1176OblTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC003D29_A1177OblCanCuo = new short[1] ;
      BC003D29_A1178OblImpFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC003D29_A1179OblPorc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC003D29_A1181OblNoRemu = new boolean[] {false} ;
      BC003D29_A1182OblDescu = new boolean[] {false} ;
      BC003D29_A1196OblAntiRelaLiq = new boolean[] {false} ;
      BC003D29_A2346TipoOblSoloDescu = new boolean[] {false} ;
      BC003D29_A251LegNombre = new String[] {""} ;
      BC003D29_A230LegApellido = new String[] {""} ;
      BC003D29_A93LegId = new String[] {""} ;
      BC003D29_n93LegId = new boolean[] {false} ;
      BC003D29_A3CliCod = new int[1] ;
      BC003D29_A2343OblConcepto = new String[] {""} ;
      BC003D29_A1EmpCod = new short[1] ;
      BC003D29_A6LegNumero = new int[1] ;
      BC003D29_A1195OblLiqNro = new int[1] ;
      BC003D29_n1195OblLiqNro = new boolean[] {false} ;
      BC003D29_A1169OblConCodigo = new String[] {""} ;
      BC003D29_n1169OblConCodigo = new boolean[] {false} ;
      BC003D29_A1163TipoOblSec = new short[1] ;
      BC003D29_A1161EmbargaSec = new short[1] ;
      BC003D29_n1161EmbargaSec = new boolean[] {false} ;
      Z1183OblExcTipo = "" ;
      A1183OblExcTipo = "" ;
      Z1170OblExcConCOdigo = "" ;
      A1170OblExcConCOdigo = "" ;
      BC003D30_A1183OblExcTipo = new String[] {""} ;
      BC003D30_A3CliCod = new int[1] ;
      BC003D30_A1170OblExcConCOdigo = new String[] {""} ;
      BC003D30_A1EmpCod = new short[1] ;
      BC003D30_A6LegNumero = new int[1] ;
      BC003D30_A1172OblSecuencial = new short[1] ;
      BC003D31_A3CliCod = new int[1] ;
      BC003D32_A3CliCod = new int[1] ;
      BC003D32_A1EmpCod = new short[1] ;
      BC003D32_A6LegNumero = new int[1] ;
      BC003D32_A1172OblSecuencial = new short[1] ;
      BC003D32_A1170OblExcConCOdigo = new String[] {""} ;
      BC003D33_A1183OblExcTipo = new String[] {""} ;
      BC003D33_A3CliCod = new int[1] ;
      BC003D33_A1170OblExcConCOdigo = new String[] {""} ;
      BC003D33_A1EmpCod = new short[1] ;
      BC003D33_A6LegNumero = new int[1] ;
      BC003D33_A1172OblSecuencial = new short[1] ;
      sMode138 = "" ;
      BC003D34_A1183OblExcTipo = new String[] {""} ;
      BC003D34_A3CliCod = new int[1] ;
      BC003D34_A1170OblExcConCOdigo = new String[] {""} ;
      BC003D34_A1EmpCod = new short[1] ;
      BC003D34_A6LegNumero = new int[1] ;
      BC003D34_A1172OblSecuencial = new short[1] ;
      BC003D38_A1183OblExcTipo = new String[] {""} ;
      BC003D38_A3CliCod = new int[1] ;
      BC003D38_A1170OblExcConCOdigo = new String[] {""} ;
      BC003D38_A1EmpCod = new short[1] ;
      BC003D38_A6LegNumero = new int[1] ;
      BC003D38_A1172OblSecuencial = new short[1] ;
      N2345OblTipoMov = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC003D39_A250LegIdNomApe = new String[] {""} ;
      BC003D39_A251LegNombre = new String[] {""} ;
      BC003D39_A230LegApellido = new String[] {""} ;
      BC003D39_A93LegId = new String[] {""} ;
      BC003D39_n93LegId = new boolean[] {false} ;
      BC003D40_A250LegIdNomApe = new String[] {""} ;
      BC003D40_A251LegNombre = new String[] {""} ;
      BC003D40_A230LegApellido = new String[] {""} ;
      BC003D40_A93LegId = new String[] {""} ;
      BC003D40_n93LegId = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obligacion_bc__default(),
         new Object[] {
             new Object[] {
            BC003D2_A1183OblExcTipo, BC003D2_A3CliCod, BC003D2_A1170OblExcConCOdigo, BC003D2_A1EmpCod, BC003D2_A6LegNumero, BC003D2_A1172OblSecuencial
            }
            , new Object[] {
            BC003D3_A1183OblExcTipo, BC003D3_A3CliCod, BC003D3_A1170OblExcConCOdigo, BC003D3_A1EmpCod, BC003D3_A6LegNumero, BC003D3_A1172OblSecuencial
            }
            , new Object[] {
            BC003D4_A3CliCod
            }
            , new Object[] {
            BC003D5_A1172OblSecuencial, BC003D5_A2345OblTipoMov, BC003D5_A1173OblEstado, BC003D5_A1174OblObs, BC003D5_A1175OblOriPer, BC003D5_A1176OblTotal, BC003D5_A1177OblCanCuo, BC003D5_A1178OblImpFij, BC003D5_A1179OblPorc, BC003D5_A1181OblNoRemu,
            BC003D5_A1182OblDescu, BC003D5_A1196OblAntiRelaLiq, BC003D5_A3CliCod, BC003D5_A2343OblConcepto, BC003D5_A1EmpCod, BC003D5_A6LegNumero, BC003D5_A1195OblLiqNro, BC003D5_n1195OblLiqNro, BC003D5_A1169OblConCodigo, BC003D5_n1169OblConCodigo,
            BC003D5_A1163TipoOblSec
            }
            , new Object[] {
            BC003D6_A1172OblSecuencial, BC003D6_A2345OblTipoMov, BC003D6_A1173OblEstado, BC003D6_A1174OblObs, BC003D6_A1175OblOriPer, BC003D6_A1176OblTotal, BC003D6_A1177OblCanCuo, BC003D6_A1178OblImpFij, BC003D6_A1179OblPorc, BC003D6_A1181OblNoRemu,
            BC003D6_A1182OblDescu, BC003D6_A1196OblAntiRelaLiq, BC003D6_A3CliCod, BC003D6_A2343OblConcepto, BC003D6_A1EmpCod, BC003D6_A6LegNumero, BC003D6_A1195OblLiqNro, BC003D6_n1195OblLiqNro, BC003D6_A1169OblConCodigo, BC003D6_n1169OblConCodigo,
            BC003D6_A1163TipoOblSec
            }
            , new Object[] {
            BC003D7_A3CliCod
            }
            , new Object[] {
            BC003D8_A250LegIdNomApe, BC003D8_A251LegNombre, BC003D8_A230LegApellido, BC003D8_A93LegId, BC003D8_n93LegId
            }
            , new Object[] {
            BC003D9_A3CliCod
            }
            , new Object[] {
            BC003D10_A31LiqNro
            }
            , new Object[] {
            BC003D11_A3CliCod
            }
            , new Object[] {
            BC003D12_A1165TipoOblDescrip, BC003D12_A1164TipoOblCodigo, BC003D12_A1168TipoOblTotTipo, BC003D12_A2346TipoOblSoloDescu, BC003D12_A1161EmbargaSec, BC003D12_n1161EmbargaSec
            }
            , new Object[] {
            BC003D13_A250LegIdNomApe, BC003D13_A1172OblSecuencial, BC003D13_A2345OblTipoMov, BC003D13_A1165TipoOblDescrip, BC003D13_A1164TipoOblCodigo, BC003D13_A1173OblEstado, BC003D13_A1174OblObs, BC003D13_A1175OblOriPer, BC003D13_A1168TipoOblTotTipo, BC003D13_A1176OblTotal,
            BC003D13_A1177OblCanCuo, BC003D13_A1178OblImpFij, BC003D13_A1179OblPorc, BC003D13_A1181OblNoRemu, BC003D13_A1182OblDescu, BC003D13_A1196OblAntiRelaLiq, BC003D13_A2346TipoOblSoloDescu, BC003D13_A251LegNombre, BC003D13_A230LegApellido, BC003D13_A93LegId,
            BC003D13_n93LegId, BC003D13_A3CliCod, BC003D13_A2343OblConcepto, BC003D13_A1EmpCod, BC003D13_A6LegNumero, BC003D13_A1195OblLiqNro, BC003D13_n1195OblLiqNro, BC003D13_A1169OblConCodigo, BC003D13_n1169OblConCodigo, BC003D13_A1163TipoOblSec,
            BC003D13_A1161EmbargaSec, BC003D13_n1161EmbargaSec
            }
            , new Object[] {
            BC003D14_A3CliCod
            }
            , new Object[] {
            BC003D15_A3CliCod
            }
            , new Object[] {
            BC003D16_A3CliCod
            }
            , new Object[] {
            BC003D17_A250LegIdNomApe, BC003D17_A251LegNombre, BC003D17_A230LegApellido, BC003D17_A93LegId, BC003D17_n93LegId
            }
            , new Object[] {
            BC003D18_A31LiqNro
            }
            , new Object[] {
            BC003D19_A1165TipoOblDescrip, BC003D19_A1164TipoOblCodigo, BC003D19_A1168TipoOblTotTipo, BC003D19_A2346TipoOblSoloDescu, BC003D19_A1161EmbargaSec, BC003D19_n1161EmbargaSec
            }
            , new Object[] {
            BC003D20_A3CliCod, BC003D20_A1EmpCod, BC003D20_A6LegNumero, BC003D20_A1172OblSecuencial
            }
            , new Object[] {
            BC003D21_A1172OblSecuencial, BC003D21_A2345OblTipoMov, BC003D21_A1173OblEstado, BC003D21_A1174OblObs, BC003D21_A1175OblOriPer, BC003D21_A1176OblTotal, BC003D21_A1177OblCanCuo, BC003D21_A1178OblImpFij, BC003D21_A1179OblPorc, BC003D21_A1181OblNoRemu,
            BC003D21_A1182OblDescu, BC003D21_A1196OblAntiRelaLiq, BC003D21_A3CliCod, BC003D21_A2343OblConcepto, BC003D21_A1EmpCod, BC003D21_A6LegNumero, BC003D21_A1195OblLiqNro, BC003D21_n1195OblLiqNro, BC003D21_A1169OblConCodigo, BC003D21_n1169OblConCodigo,
            BC003D21_A1163TipoOblSec
            }
            , new Object[] {
            BC003D22_A1172OblSecuencial, BC003D22_A2345OblTipoMov, BC003D22_A1173OblEstado, BC003D22_A1174OblObs, BC003D22_A1175OblOriPer, BC003D22_A1176OblTotal, BC003D22_A1177OblCanCuo, BC003D22_A1178OblImpFij, BC003D22_A1179OblPorc, BC003D22_A1181OblNoRemu,
            BC003D22_A1182OblDescu, BC003D22_A1196OblAntiRelaLiq, BC003D22_A3CliCod, BC003D22_A2343OblConcepto, BC003D22_A1EmpCod, BC003D22_A6LegNumero, BC003D22_A1195OblLiqNro, BC003D22_n1195OblLiqNro, BC003D22_A1169OblConCodigo, BC003D22_n1169OblConCodigo,
            BC003D22_A1163TipoOblSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC003D26_A250LegIdNomApe, BC003D26_A251LegNombre, BC003D26_A230LegApellido, BC003D26_A93LegId, BC003D26_n93LegId
            }
            , new Object[] {
            BC003D27_A1165TipoOblDescrip, BC003D27_A1164TipoOblCodigo, BC003D27_A1168TipoOblTotTipo, BC003D27_A2346TipoOblSoloDescu, BC003D27_A1161EmbargaSec, BC003D27_n1161EmbargaSec
            }
            , new Object[] {
            BC003D28_A3CliCod, BC003D28_A1EmpCod, BC003D28_A6LegNumero, BC003D28_A1172OblSecuencial, BC003D28_A1184LiqOblAltaNro, BC003D28_A1185LiqOblNuevaNro
            }
            , new Object[] {
            BC003D29_A250LegIdNomApe, BC003D29_A1172OblSecuencial, BC003D29_A2345OblTipoMov, BC003D29_A1165TipoOblDescrip, BC003D29_A1164TipoOblCodigo, BC003D29_A1173OblEstado, BC003D29_A1174OblObs, BC003D29_A1175OblOriPer, BC003D29_A1168TipoOblTotTipo, BC003D29_A1176OblTotal,
            BC003D29_A1177OblCanCuo, BC003D29_A1178OblImpFij, BC003D29_A1179OblPorc, BC003D29_A1181OblNoRemu, BC003D29_A1182OblDescu, BC003D29_A1196OblAntiRelaLiq, BC003D29_A2346TipoOblSoloDescu, BC003D29_A251LegNombre, BC003D29_A230LegApellido, BC003D29_A93LegId,
            BC003D29_n93LegId, BC003D29_A3CliCod, BC003D29_A2343OblConcepto, BC003D29_A1EmpCod, BC003D29_A6LegNumero, BC003D29_A1195OblLiqNro, BC003D29_n1195OblLiqNro, BC003D29_A1169OblConCodigo, BC003D29_n1169OblConCodigo, BC003D29_A1163TipoOblSec,
            BC003D29_A1161EmbargaSec, BC003D29_n1161EmbargaSec
            }
            , new Object[] {
            BC003D30_A1183OblExcTipo, BC003D30_A3CliCod, BC003D30_A1170OblExcConCOdigo, BC003D30_A1EmpCod, BC003D30_A6LegNumero, BC003D30_A1172OblSecuencial
            }
            , new Object[] {
            BC003D31_A3CliCod
            }
            , new Object[] {
            BC003D32_A3CliCod, BC003D32_A1EmpCod, BC003D32_A6LegNumero, BC003D32_A1172OblSecuencial, BC003D32_A1170OblExcConCOdigo
            }
            , new Object[] {
            BC003D33_A1183OblExcTipo, BC003D33_A3CliCod, BC003D33_A1170OblExcConCOdigo, BC003D33_A1EmpCod, BC003D33_A6LegNumero, BC003D33_A1172OblSecuencial
            }
            , new Object[] {
            BC003D34_A1183OblExcTipo, BC003D34_A3CliCod, BC003D34_A1170OblExcConCOdigo, BC003D34_A1EmpCod, BC003D34_A6LegNumero, BC003D34_A1172OblSecuencial
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC003D38_A1183OblExcTipo, BC003D38_A3CliCod, BC003D38_A1170OblExcConCOdigo, BC003D38_A1EmpCod, BC003D38_A6LegNumero, BC003D38_A1172OblSecuencial
            }
            , new Object[] {
            BC003D39_A250LegIdNomApe, BC003D39_A251LegNombre, BC003D39_A230LegApellido, BC003D39_A93LegId, BC003D39_n93LegId
            }
            , new Object[] {
            BC003D40_A250LegIdNomApe, BC003D40_A251LegNombre, BC003D40_A230LegApellido, BC003D40_A93LegId, BC003D40_n93LegId
            }
         }
      );
      AV52Pgmname = "Obligacion_BC" ;
      Z2345OblTipoMov = "Descuento" ;
      A2345OblTipoMov = "Descuento" ;
      N2345OblTipoMov = "Descuento" ;
      Z1173OblEstado = (byte)(1) ;
      A1173OblEstado = (byte)(1) ;
      i1173OblEstado = (byte)(1) ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e123D2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Z1173OblEstado ;
   private byte A1173OblEstado ;
   private byte Z1175OblOriPer ;
   private byte A1175OblOriPer ;
   private byte Z1168TipoOblTotTipo ;
   private byte A1168TipoOblTotTipo ;
   private byte Gx_BScreen ;
   private byte Gxremove138 ;
   private byte i1173OblEstado ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short Z1172OblSecuencial ;
   private short A1172OblSecuencial ;
   private short nIsMod_138 ;
   private short RcdFound138 ;
   private short AV16Insert_TipoOblSec ;
   private short AV36PaiCod ;
   private short AV42anticipoTipoOblSec ;
   private short GXt_int4 ;
   private short GXv_int5[] ;
   private short AV8EmpCod ;
   private short Z1177OblCanCuo ;
   private short A1177OblCanCuo ;
   private short Z1163TipoOblSec ;
   private short A1163TipoOblSec ;
   private short Z1161EmbargaSec ;
   private short A1161EmbargaSec ;
   private short RcdFound134 ;
   private short nIsDirty_134 ;
   private short nRcdExists_138 ;
   private short nIsDirty_138 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int Z6LegNumero ;
   private int A6LegNumero ;
   private int nGXsfl_138_idx=1 ;
   private int AV53GXV1 ;
   private int AV35Insert_OblLiqNro ;
   private int AV7CliCod ;
   private int GX_JID ;
   private int Z1195OblLiqNro ;
   private int A1195OblLiqNro ;
   private int GXt_int8 ;
   private int GXv_int9[] ;
   private int A31LiqNro ;
   private java.math.BigDecimal Z1176OblTotal ;
   private java.math.BigDecimal A1176OblTotal ;
   private java.math.BigDecimal Z1178OblImpFij ;
   private java.math.BigDecimal A1178OblImpFij ;
   private java.math.BigDecimal Z1179OblPorc ;
   private java.math.BigDecimal A1179OblPorc ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode134 ;
   private String AV52Pgmname ;
   private String AV17Insert_OblConCodigo ;
   private String AV46Insert_OblConcepto ;
   private String AV43anticipoSubTipoConCod1 ;
   private String AV44desdeDTipoConCod ;
   private String AV45hastaDTipoConCod ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String Z2345OblTipoMov ;
   private String A2345OblTipoMov ;
   private String Z2343OblConcepto ;
   private String A2343OblConcepto ;
   private String Z1169OblConCodigo ;
   private String A1169OblConCodigo ;
   private String Z93LegId ;
   private String A93LegId ;
   private String Z1164TipoOblCodigo ;
   private String A1164TipoOblCodigo ;
   private String Z1183OblExcTipo ;
   private String A1183OblExcTipo ;
   private String Z1170OblExcConCOdigo ;
   private String A1170OblExcConCOdigo ;
   private String sMode138 ;
   private String N2345OblTipoMov ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z1181OblNoRemu ;
   private boolean A1181OblNoRemu ;
   private boolean Z1182OblDescu ;
   private boolean A1182OblDescu ;
   private boolean Z1196OblAntiRelaLiq ;
   private boolean A1196OblAntiRelaLiq ;
   private boolean Z2346TipoOblSoloDescu ;
   private boolean A2346TipoOblSoloDescu ;
   private boolean n93LegId ;
   private boolean n1195OblLiqNro ;
   private boolean n1169OblConCodigo ;
   private boolean n1161EmbargaSec ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z1174OblObs ;
   private String A1174OblObs ;
   private String Z250LegIdNomApe ;
   private String A250LegIdNomApe ;
   private String Z251LegNombre ;
   private String A251LegNombre ;
   private String Z230LegApellido ;
   private String A230LegApellido ;
   private String Z1165TipoOblDescrip ;
   private String A1165TipoOblDescrip ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private web.SdtObligacion bcObligacion ;
   private IDataStoreProvider pr_default ;
   private String[] BC003D13_A250LegIdNomApe ;
   private short[] BC003D13_A1172OblSecuencial ;
   private String[] BC003D13_A2345OblTipoMov ;
   private String[] BC003D13_A1165TipoOblDescrip ;
   private String[] BC003D13_A1164TipoOblCodigo ;
   private byte[] BC003D13_A1173OblEstado ;
   private String[] BC003D13_A1174OblObs ;
   private byte[] BC003D13_A1175OblOriPer ;
   private byte[] BC003D13_A1168TipoOblTotTipo ;
   private java.math.BigDecimal[] BC003D13_A1176OblTotal ;
   private short[] BC003D13_A1177OblCanCuo ;
   private java.math.BigDecimal[] BC003D13_A1178OblImpFij ;
   private java.math.BigDecimal[] BC003D13_A1179OblPorc ;
   private boolean[] BC003D13_A1181OblNoRemu ;
   private boolean[] BC003D13_A1182OblDescu ;
   private boolean[] BC003D13_A1196OblAntiRelaLiq ;
   private boolean[] BC003D13_A2346TipoOblSoloDescu ;
   private String[] BC003D13_A251LegNombre ;
   private String[] BC003D13_A230LegApellido ;
   private String[] BC003D13_A93LegId ;
   private boolean[] BC003D13_n93LegId ;
   private int[] BC003D13_A3CliCod ;
   private String[] BC003D13_A2343OblConcepto ;
   private short[] BC003D13_A1EmpCod ;
   private int[] BC003D13_A6LegNumero ;
   private int[] BC003D13_A1195OblLiqNro ;
   private boolean[] BC003D13_n1195OblLiqNro ;
   private String[] BC003D13_A1169OblConCodigo ;
   private boolean[] BC003D13_n1169OblConCodigo ;
   private short[] BC003D13_A1163TipoOblSec ;
   private short[] BC003D13_A1161EmbargaSec ;
   private boolean[] BC003D13_n1161EmbargaSec ;
   private int[] BC003D14_A3CliCod ;
   private int[] BC003D15_A3CliCod ;
   private int[] BC003D16_A3CliCod ;
   private String[] BC003D17_A250LegIdNomApe ;
   private String[] BC003D17_A251LegNombre ;
   private String[] BC003D17_A230LegApellido ;
   private String[] BC003D17_A93LegId ;
   private boolean[] BC003D17_n93LegId ;
   private int[] BC003D18_A31LiqNro ;
   private String[] BC003D19_A1165TipoOblDescrip ;
   private String[] BC003D19_A1164TipoOblCodigo ;
   private byte[] BC003D19_A1168TipoOblTotTipo ;
   private boolean[] BC003D19_A2346TipoOblSoloDescu ;
   private short[] BC003D19_A1161EmbargaSec ;
   private boolean[] BC003D19_n1161EmbargaSec ;
   private int[] BC003D20_A3CliCod ;
   private short[] BC003D20_A1EmpCod ;
   private int[] BC003D20_A6LegNumero ;
   private short[] BC003D20_A1172OblSecuencial ;
   private short[] BC003D21_A1172OblSecuencial ;
   private String[] BC003D21_A2345OblTipoMov ;
   private byte[] BC003D21_A1173OblEstado ;
   private String[] BC003D21_A1174OblObs ;
   private byte[] BC003D21_A1175OblOriPer ;
   private java.math.BigDecimal[] BC003D21_A1176OblTotal ;
   private short[] BC003D21_A1177OblCanCuo ;
   private java.math.BigDecimal[] BC003D21_A1178OblImpFij ;
   private java.math.BigDecimal[] BC003D21_A1179OblPorc ;
   private boolean[] BC003D21_A1181OblNoRemu ;
   private boolean[] BC003D21_A1182OblDescu ;
   private boolean[] BC003D21_A1196OblAntiRelaLiq ;
   private int[] BC003D21_A3CliCod ;
   private String[] BC003D21_A2343OblConcepto ;
   private short[] BC003D21_A1EmpCod ;
   private int[] BC003D21_A6LegNumero ;
   private int[] BC003D21_A1195OblLiqNro ;
   private boolean[] BC003D21_n1195OblLiqNro ;
   private String[] BC003D21_A1169OblConCodigo ;
   private boolean[] BC003D21_n1169OblConCodigo ;
   private short[] BC003D21_A1163TipoOblSec ;
   private short[] BC003D22_A1172OblSecuencial ;
   private String[] BC003D22_A2345OblTipoMov ;
   private byte[] BC003D22_A1173OblEstado ;
   private String[] BC003D22_A1174OblObs ;
   private byte[] BC003D22_A1175OblOriPer ;
   private java.math.BigDecimal[] BC003D22_A1176OblTotal ;
   private short[] BC003D22_A1177OblCanCuo ;
   private java.math.BigDecimal[] BC003D22_A1178OblImpFij ;
   private java.math.BigDecimal[] BC003D22_A1179OblPorc ;
   private boolean[] BC003D22_A1181OblNoRemu ;
   private boolean[] BC003D22_A1182OblDescu ;
   private boolean[] BC003D22_A1196OblAntiRelaLiq ;
   private int[] BC003D22_A3CliCod ;
   private String[] BC003D22_A2343OblConcepto ;
   private short[] BC003D22_A1EmpCod ;
   private int[] BC003D22_A6LegNumero ;
   private int[] BC003D22_A1195OblLiqNro ;
   private boolean[] BC003D22_n1195OblLiqNro ;
   private String[] BC003D22_A1169OblConCodigo ;
   private boolean[] BC003D22_n1169OblConCodigo ;
   private short[] BC003D22_A1163TipoOblSec ;
   private String[] BC003D26_A250LegIdNomApe ;
   private String[] BC003D26_A251LegNombre ;
   private String[] BC003D26_A230LegApellido ;
   private String[] BC003D26_A93LegId ;
   private boolean[] BC003D26_n93LegId ;
   private String[] BC003D27_A1165TipoOblDescrip ;
   private String[] BC003D27_A1164TipoOblCodigo ;
   private byte[] BC003D27_A1168TipoOblTotTipo ;
   private boolean[] BC003D27_A2346TipoOblSoloDescu ;
   private short[] BC003D27_A1161EmbargaSec ;
   private boolean[] BC003D27_n1161EmbargaSec ;
   private int[] BC003D28_A3CliCod ;
   private short[] BC003D28_A1EmpCod ;
   private int[] BC003D28_A6LegNumero ;
   private short[] BC003D28_A1172OblSecuencial ;
   private int[] BC003D28_A1184LiqOblAltaNro ;
   private int[] BC003D28_A1185LiqOblNuevaNro ;
   private String[] BC003D29_A250LegIdNomApe ;
   private short[] BC003D29_A1172OblSecuencial ;
   private String[] BC003D29_A2345OblTipoMov ;
   private String[] BC003D29_A1165TipoOblDescrip ;
   private String[] BC003D29_A1164TipoOblCodigo ;
   private byte[] BC003D29_A1173OblEstado ;
   private String[] BC003D29_A1174OblObs ;
   private byte[] BC003D29_A1175OblOriPer ;
   private byte[] BC003D29_A1168TipoOblTotTipo ;
   private java.math.BigDecimal[] BC003D29_A1176OblTotal ;
   private short[] BC003D29_A1177OblCanCuo ;
   private java.math.BigDecimal[] BC003D29_A1178OblImpFij ;
   private java.math.BigDecimal[] BC003D29_A1179OblPorc ;
   private boolean[] BC003D29_A1181OblNoRemu ;
   private boolean[] BC003D29_A1182OblDescu ;
   private boolean[] BC003D29_A1196OblAntiRelaLiq ;
   private boolean[] BC003D29_A2346TipoOblSoloDescu ;
   private String[] BC003D29_A251LegNombre ;
   private String[] BC003D29_A230LegApellido ;
   private String[] BC003D29_A93LegId ;
   private boolean[] BC003D29_n93LegId ;
   private int[] BC003D29_A3CliCod ;
   private String[] BC003D29_A2343OblConcepto ;
   private short[] BC003D29_A1EmpCod ;
   private int[] BC003D29_A6LegNumero ;
   private int[] BC003D29_A1195OblLiqNro ;
   private boolean[] BC003D29_n1195OblLiqNro ;
   private String[] BC003D29_A1169OblConCodigo ;
   private boolean[] BC003D29_n1169OblConCodigo ;
   private short[] BC003D29_A1163TipoOblSec ;
   private short[] BC003D29_A1161EmbargaSec ;
   private boolean[] BC003D29_n1161EmbargaSec ;
   private String[] BC003D30_A1183OblExcTipo ;
   private int[] BC003D30_A3CliCod ;
   private String[] BC003D30_A1170OblExcConCOdigo ;
   private short[] BC003D30_A1EmpCod ;
   private int[] BC003D30_A6LegNumero ;
   private short[] BC003D30_A1172OblSecuencial ;
   private int[] BC003D31_A3CliCod ;
   private int[] BC003D32_A3CliCod ;
   private short[] BC003D32_A1EmpCod ;
   private int[] BC003D32_A6LegNumero ;
   private short[] BC003D32_A1172OblSecuencial ;
   private String[] BC003D32_A1170OblExcConCOdigo ;
   private String[] BC003D33_A1183OblExcTipo ;
   private int[] BC003D33_A3CliCod ;
   private String[] BC003D33_A1170OblExcConCOdigo ;
   private short[] BC003D33_A1EmpCod ;
   private int[] BC003D33_A6LegNumero ;
   private short[] BC003D33_A1172OblSecuencial ;
   private String[] BC003D34_A1183OblExcTipo ;
   private int[] BC003D34_A3CliCod ;
   private String[] BC003D34_A1170OblExcConCOdigo ;
   private short[] BC003D34_A1EmpCod ;
   private int[] BC003D34_A6LegNumero ;
   private short[] BC003D34_A1172OblSecuencial ;
   private String[] BC003D38_A1183OblExcTipo ;
   private int[] BC003D38_A3CliCod ;
   private String[] BC003D38_A1170OblExcConCOdigo ;
   private short[] BC003D38_A1EmpCod ;
   private int[] BC003D38_A6LegNumero ;
   private short[] BC003D38_A1172OblSecuencial ;
   private String[] BC003D39_A250LegIdNomApe ;
   private String[] BC003D39_A251LegNombre ;
   private String[] BC003D39_A230LegApellido ;
   private String[] BC003D39_A93LegId ;
   private boolean[] BC003D39_n93LegId ;
   private String[] BC003D40_A250LegIdNomApe ;
   private String[] BC003D40_A251LegNombre ;
   private String[] BC003D40_A230LegApellido ;
   private String[] BC003D40_A93LegId ;
   private boolean[] BC003D40_n93LegId ;
   private String[] BC003D2_A1183OblExcTipo ;
   private int[] BC003D2_A3CliCod ;
   private String[] BC003D2_A1170OblExcConCOdigo ;
   private short[] BC003D2_A1EmpCod ;
   private int[] BC003D2_A6LegNumero ;
   private short[] BC003D2_A1172OblSecuencial ;
   private String[] BC003D3_A1183OblExcTipo ;
   private int[] BC003D3_A3CliCod ;
   private String[] BC003D3_A1170OblExcConCOdigo ;
   private short[] BC003D3_A1EmpCod ;
   private int[] BC003D3_A6LegNumero ;
   private short[] BC003D3_A1172OblSecuencial ;
   private int[] BC003D4_A3CliCod ;
   private short[] BC003D5_A1172OblSecuencial ;
   private String[] BC003D5_A2345OblTipoMov ;
   private byte[] BC003D5_A1173OblEstado ;
   private String[] BC003D5_A1174OblObs ;
   private byte[] BC003D5_A1175OblOriPer ;
   private java.math.BigDecimal[] BC003D5_A1176OblTotal ;
   private short[] BC003D5_A1177OblCanCuo ;
   private java.math.BigDecimal[] BC003D5_A1178OblImpFij ;
   private java.math.BigDecimal[] BC003D5_A1179OblPorc ;
   private boolean[] BC003D5_A1181OblNoRemu ;
   private boolean[] BC003D5_A1182OblDescu ;
   private boolean[] BC003D5_A1196OblAntiRelaLiq ;
   private int[] BC003D5_A3CliCod ;
   private String[] BC003D5_A2343OblConcepto ;
   private short[] BC003D5_A1EmpCod ;
   private int[] BC003D5_A6LegNumero ;
   private int[] BC003D5_A1195OblLiqNro ;
   private String[] BC003D5_A1169OblConCodigo ;
   private short[] BC003D5_A1163TipoOblSec ;
   private short[] BC003D6_A1172OblSecuencial ;
   private String[] BC003D6_A2345OblTipoMov ;
   private byte[] BC003D6_A1173OblEstado ;
   private String[] BC003D6_A1174OblObs ;
   private byte[] BC003D6_A1175OblOriPer ;
   private java.math.BigDecimal[] BC003D6_A1176OblTotal ;
   private short[] BC003D6_A1177OblCanCuo ;
   private java.math.BigDecimal[] BC003D6_A1178OblImpFij ;
   private java.math.BigDecimal[] BC003D6_A1179OblPorc ;
   private boolean[] BC003D6_A1181OblNoRemu ;
   private boolean[] BC003D6_A1182OblDescu ;
   private boolean[] BC003D6_A1196OblAntiRelaLiq ;
   private int[] BC003D6_A3CliCod ;
   private String[] BC003D6_A2343OblConcepto ;
   private short[] BC003D6_A1EmpCod ;
   private int[] BC003D6_A6LegNumero ;
   private int[] BC003D6_A1195OblLiqNro ;
   private String[] BC003D6_A1169OblConCodigo ;
   private short[] BC003D6_A1163TipoOblSec ;
   private int[] BC003D7_A3CliCod ;
   private String[] BC003D8_A250LegIdNomApe ;
   private String[] BC003D8_A251LegNombre ;
   private String[] BC003D8_A230LegApellido ;
   private String[] BC003D8_A93LegId ;
   private int[] BC003D9_A3CliCod ;
   private int[] BC003D10_A31LiqNro ;
   private int[] BC003D11_A3CliCod ;
   private String[] BC003D12_A1165TipoOblDescrip ;
   private String[] BC003D12_A1164TipoOblCodigo ;
   private byte[] BC003D12_A1168TipoOblTotTipo ;
   private boolean[] BC003D12_A2346TipoOblSoloDescu ;
   private short[] BC003D12_A1161EmbargaSec ;
   private boolean[] BC003D5_n1195OblLiqNro ;
   private boolean[] BC003D5_n1169OblConCodigo ;
   private boolean[] BC003D6_n1195OblLiqNro ;
   private boolean[] BC003D6_n1169OblConCodigo ;
   private boolean[] BC003D8_n93LegId ;
   private boolean[] BC003D12_n1161EmbargaSec ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV18TrnContextAtt ;
}

final  class obligacion_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC003D2", "SELECT OblExcTipo, CliCod, OblExcConCOdigo, EmpCod, LegNumero, OblSecuencial FROM ObligacionExcepciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND OblExcConCOdigo = ?  FOR UPDATE OF ObligacionExcepciones",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D3", "SELECT OblExcTipo, CliCod, OblExcConCOdigo, EmpCod, LegNumero, OblSecuencial FROM ObligacionExcepciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND OblExcConCOdigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D4", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D5", "SELECT OblSecuencial, OblTipoMov, OblEstado, OblObs, OblOriPer, OblTotal, OblCanCuo, OblImpFij, OblPorc, OblNoRemu, OblDescu, OblAntiRelaLiq, CliCod, OblConcepto, EmpCod, LegNumero, OblLiqNro, OblConCodigo, TipoOblSec FROM Obligacion WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ?  FOR UPDATE OF Obligacion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D6", "SELECT OblSecuencial, OblTipoMov, OblEstado, OblObs, OblOriPer, OblTotal, OblCanCuo, OblImpFij, OblPorc, OblNoRemu, OblDescu, OblAntiRelaLiq, CliCod, OblConcepto, EmpCod, LegNumero, OblLiqNro, OblConCodigo, TipoOblSec FROM Obligacion WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D7", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D8", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D9", "SELECT CliCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D10", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D11", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D12", "SELECT TipoOblDescrip, TipoOblCodigo, TipoOblTotTipo, TipoOblSoloDescu, EmbargaSec FROM tipo_obligacion WHERE TipoOblSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D13", "SELECT T2.LegIdNomApe, TM1.OblSecuencial, TM1.OblTipoMov, T3.TipoOblDescrip, T3.TipoOblCodigo, TM1.OblEstado, TM1.OblObs, TM1.OblOriPer, T3.TipoOblTotTipo, TM1.OblTotal, TM1.OblCanCuo, TM1.OblImpFij, TM1.OblPorc, TM1.OblNoRemu, TM1.OblDescu, TM1.OblAntiRelaLiq, T3.TipoOblSoloDescu, T2.LegNombre, T2.LegApellido, T2.LegId, TM1.CliCod, TM1.OblConcepto AS OblConcepto, TM1.EmpCod, TM1.LegNumero, TM1.OblLiqNro AS OblLiqNro, TM1.OblConCodigo AS OblConCodigo, TM1.TipoOblSec, T3.EmbargaSec FROM ((Obligacion TM1 INNER JOIN Legajo T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod AND T2.LegNumero = TM1.LegNumero) INNER JOIN tipo_obligacion T3 ON T3.TipoOblSec = TM1.TipoOblSec) WHERE TM1.OblSecuencial = ? and TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.OblSecuencial ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D14", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D15", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D16", "SELECT CliCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D17", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D18", "SELECT LiqNro FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D19", "SELECT TipoOblDescrip, TipoOblCodigo, TipoOblTotTipo, TipoOblSoloDescu, EmbargaSec FROM tipo_obligacion WHERE TipoOblSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D20", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial FROM Obligacion WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D21", "SELECT OblSecuencial, OblTipoMov, OblEstado, OblObs, OblOriPer, OblTotal, OblCanCuo, OblImpFij, OblPorc, OblNoRemu, OblDescu, OblAntiRelaLiq, CliCod, OblConcepto, EmpCod, LegNumero, OblLiqNro, OblConCodigo, TipoOblSec FROM Obligacion WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D22", "SELECT OblSecuencial, OblTipoMov, OblEstado, OblObs, OblOriPer, OblTotal, OblCanCuo, OblImpFij, OblPorc, OblNoRemu, OblDescu, OblAntiRelaLiq, CliCod, OblConcepto, EmpCod, LegNumero, OblLiqNro, OblConCodigo, TipoOblSec FROM Obligacion WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ?  FOR UPDATE OF Obligacion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC003D23", "SAVEPOINT gxupdate;INSERT INTO Obligacion(OblSecuencial, OblTipoMov, OblEstado, OblObs, OblOriPer, OblTotal, OblCanCuo, OblImpFij, OblPorc, OblNoRemu, OblDescu, OblAntiRelaLiq, CliCod, OblConcepto, EmpCod, LegNumero, OblLiqNro, OblConCodigo, TipoOblSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC003D24", "SAVEPOINT gxupdate;UPDATE Obligacion SET OblTipoMov=?, OblEstado=?, OblObs=?, OblOriPer=?, OblTotal=?, OblCanCuo=?, OblImpFij=?, OblPorc=?, OblNoRemu=?, OblDescu=?, OblAntiRelaLiq=?, OblConcepto=?, OblLiqNro=?, OblConCodigo=?, TipoOblSec=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC003D25", "SAVEPOINT gxupdate;DELETE FROM Obligacion  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC003D26", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D27", "SELECT TipoOblDescrip, TipoOblCodigo, TipoOblTotTipo, TipoOblSoloDescu, EmbargaSec FROM tipo_obligacion WHERE TipoOblSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D28", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro FROM LiqLegObligacionCuenta WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC003D29", "SELECT T2.LegIdNomApe, TM1.OblSecuencial, TM1.OblTipoMov, T3.TipoOblDescrip, T3.TipoOblCodigo, TM1.OblEstado, TM1.OblObs, TM1.OblOriPer, T3.TipoOblTotTipo, TM1.OblTotal, TM1.OblCanCuo, TM1.OblImpFij, TM1.OblPorc, TM1.OblNoRemu, TM1.OblDescu, TM1.OblAntiRelaLiq, T3.TipoOblSoloDescu, T2.LegNombre, T2.LegApellido, T2.LegId, TM1.CliCod, TM1.OblConcepto AS OblConcepto, TM1.EmpCod, TM1.LegNumero, TM1.OblLiqNro AS OblLiqNro, TM1.OblConCodigo AS OblConCodigo, TM1.TipoOblSec, T3.EmbargaSec FROM ((Obligacion TM1 INNER JOIN Legajo T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod AND T2.LegNumero = TM1.LegNumero) INNER JOIN tipo_obligacion T3 ON T3.TipoOblSec = TM1.TipoOblSec) WHERE TM1.OblSecuencial = ? and TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.OblSecuencial ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D30", "SELECT OblExcTipo, CliCod, OblExcConCOdigo, EmpCod, LegNumero, OblSecuencial FROM ObligacionExcepciones WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and OblSecuencial = ? and OblExcConCOdigo = ( ?) ORDER BY CliCod, EmpCod, LegNumero, OblSecuencial, OblExcConCOdigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D31", "SELECT CliCod FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D32", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, OblExcConCOdigo FROM ObligacionExcepciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND OblExcConCOdigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D33", "SELECT OblExcTipo, CliCod, OblExcConCOdigo, EmpCod, LegNumero, OblSecuencial FROM ObligacionExcepciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND OblExcConCOdigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D34", "SELECT OblExcTipo, CliCod, OblExcConCOdigo, EmpCod, LegNumero, OblSecuencial FROM ObligacionExcepciones WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND OblExcConCOdigo = ?  FOR UPDATE OF ObligacionExcepciones",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC003D35", "SAVEPOINT gxupdate;INSERT INTO ObligacionExcepciones(OblExcTipo, CliCod, OblExcConCOdigo, EmpCod, LegNumero, OblSecuencial) VALUES(?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC003D36", "SAVEPOINT gxupdate;UPDATE ObligacionExcepciones SET OblExcTipo=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND OblExcConCOdigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC003D37", "SAVEPOINT gxupdate;DELETE FROM ObligacionExcepciones  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND OblExcConCOdigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC003D38", "SELECT OblExcTipo, CliCod, OblExcConCOdigo, EmpCod, LegNumero, OblSecuencial FROM ObligacionExcepciones WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and OblSecuencial = ? ORDER BY CliCod, EmpCod, LegNumero, OblSecuencial, OblExcConCOdigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D39", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003D40", "SELECT LegIdNomApe, LegNombre, LegApellido, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,4);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 10);
               ((short[]) buf[14])[0] = rslt.getShort(15);
               ((int[]) buf[15])[0] = rslt.getInt(16);
               ((int[]) buf[16])[0] = rslt.getInt(17);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(18, 10);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((short[]) buf[20])[0] = rslt.getShort(19);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,4);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 10);
               ((short[]) buf[14])[0] = rslt.getShort(15);
               ((int[]) buf[15])[0] = rslt.getInt(16);
               ((int[]) buf[16])[0] = rslt.getInt(17);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(18, 10);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((short[]) buf[20])[0] = rslt.getShort(19);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,4);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getString(20, 20);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((int[]) buf[21])[0] = rslt.getInt(21);
               ((String[]) buf[22])[0] = rslt.getString(22, 10);
               ((short[]) buf[23])[0] = rslt.getShort(23);
               ((int[]) buf[24])[0] = rslt.getInt(24);
               ((int[]) buf[25])[0] = rslt.getInt(25);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((String[]) buf[27])[0] = rslt.getString(26, 10);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((short[]) buf[29])[0] = rslt.getShort(27);
               ((short[]) buf[30])[0] = rslt.getShort(28);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,4);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 10);
               ((short[]) buf[14])[0] = rslt.getShort(15);
               ((int[]) buf[15])[0] = rslt.getInt(16);
               ((int[]) buf[16])[0] = rslt.getInt(17);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(18, 10);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((short[]) buf[20])[0] = rslt.getShort(19);
               return;
            case 20 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,4);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 10);
               ((short[]) buf[14])[0] = rslt.getShort(15);
               ((int[]) buf[15])[0] = rslt.getInt(16);
               ((int[]) buf[16])[0] = rslt.getInt(17);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(18, 10);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((short[]) buf[20])[0] = rslt.getShort(19);
               return;
            case 24 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 25 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 27 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,4);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getString(20, 20);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((int[]) buf[21])[0] = rslt.getInt(21);
               ((String[]) buf[22])[0] = rslt.getString(22, 10);
               ((short[]) buf[23])[0] = rslt.getShort(23);
               ((int[]) buf[24])[0] = rslt.getInt(24);
               ((int[]) buf[25])[0] = rslt.getInt(25);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((String[]) buf[27])[0] = rslt.getString(26, 10);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((short[]) buf[29])[0] = rslt.getShort(27);
               ((short[]) buf[30])[0] = rslt.getShort(28);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               return;
            case 28 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 31 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 32 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 36 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 37 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 38 :
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
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
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               stmt.setInt(4, ((Number) parms[4]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 10);
               }
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 10);
               }
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               stmt.setInt(4, ((Number) parms[4]).intValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 21 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setNLongVarchar(4, (String)parms[3], false);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 2);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 4);
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setBoolean(11, ((Boolean) parms[10]).booleanValue());
               stmt.setBoolean(12, ((Boolean) parms[11]).booleanValue());
               stmt.setInt(13, ((Number) parms[12]).intValue());
               stmt.setString(14, (String)parms[13], 10);
               stmt.setShort(15, ((Number) parms[14]).shortValue());
               stmt.setInt(16, ((Number) parms[15]).intValue());
               if ( ((Boolean) parms[16]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(17, ((Number) parms[17]).intValue());
               }
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(18, (String)parms[19], 10);
               }
               stmt.setShort(19, ((Number) parms[20]).shortValue());
               return;
            case 22 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 2);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 4);
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setBoolean(11, ((Boolean) parms[10]).booleanValue());
               stmt.setString(12, (String)parms[11], 10);
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(13, ((Number) parms[13]).intValue());
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(14, (String)parms[15], 10);
               }
               stmt.setShort(15, ((Number) parms[16]).shortValue());
               stmt.setInt(16, ((Number) parms[17]).intValue());
               stmt.setShort(17, ((Number) parms[18]).shortValue());
               stmt.setInt(18, ((Number) parms[19]).intValue());
               stmt.setShort(19, ((Number) parms[20]).shortValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 25 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 27 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 32 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 33 :
               stmt.setString(1, (String)parms[0], 1);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 34 :
               stmt.setString(1, (String)parms[0], 1);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 10);
               return;
            case 35 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 36 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 37 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 38 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

