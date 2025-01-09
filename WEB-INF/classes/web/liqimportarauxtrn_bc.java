package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class liqimportarauxtrn_bc extends GXWebPanel implements IGxSilentTrn
{
   public liqimportarauxtrn_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public liqimportarauxtrn_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liqimportarauxtrn_bc.class ));
   }

   public liqimportarauxtrn_bc( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow2B13( ) ;
      standaloneNotModal( ) ;
      initializeNonKey2B13( ) ;
      standaloneModal( ) ;
      addRow2B13( ) ;
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
         e112B2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
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

   public void confirm_2B0( )
   {
      beforeValidate2B13( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls2B13( ) ;
         }
         else
         {
            checkExtendedTable2B13( ) ;
            if ( AnyError == 0 )
            {
               zm2B13( 6) ;
               zm2B13( 7) ;
               zm2B13( 8) ;
               zm2B13( 9) ;
               zm2B13( 10) ;
               zm2B13( 11) ;
               zm2B13( 12) ;
            }
            closeExtendedTableCursors2B13( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e122B2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV31IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV31IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiqImportarAuxTrn_Insert", GXv_boolean3) ;
         liqimportarauxtrn_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV31IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV31IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiqImportarAuxTrn_Update", GXv_boolean3) ;
         liqimportarauxtrn_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV31IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV31IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiqImportarAuxTrn_Delete", GXv_boolean3) ;
         liqimportarauxtrn_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV31IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV31IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV45Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV9TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV45Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV46GXV1 = 1 ;
         while ( AV46GXV1 <= AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV15TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV46GXV1));
            if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "PaiCod") == 0 )
            {
               AV11Insert_PaiCod = (short)(GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ProvCod") == 0 )
            {
               AV12Insert_ProvCod = (short)(GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LocCod") == 0 )
            {
               AV13Insert_LocCod = (short)(GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ActCodigo") == 0 )
            {
               AV14Insert_ActCodigo = AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "TipEmpleCod") == 0 )
            {
               AV40Insert_TipEmpleCod = AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EmpZonCod") == 0 )
            {
               AV36Insert_EmpZonCod = AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            AV46GXV1 = (int)(AV46GXV1+1) ;
         }
      }
   }

   public void e112B2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      GXv_int4[0] = 0 ;
      GXv_date5[0] = AV33Date ;
      GXv_boolean3[0] = AV34CliMultiEmp ;
      GXv_char6[0] = "" ;
      new web.getdatoscliente(remoteHandle, context).execute( AV30CliCod, GXv_int4, GXv_date5, GXv_boolean3, GXv_char6) ;
      liqimportarauxtrn_bc.this.AV33Date = GXv_date5[0] ;
      liqimportarauxtrn_bc.this.AV34CliMultiEmp = GXv_boolean3[0] ;
      if ( AV34CliMultiEmp )
      {
      }
      else
      {
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         GXEncryptionTmp = "web.listmoduleitems"+GXutil.URLEncode(GXutil.rtrim(GXutil.trim( AV35Session.getValue(httpContext.getMessage( "ModuleDescription", ""))))) ;
         callWebObject(formatLink("web.listmoduleitems") + "?" + com.genexus.util.Encryption.uriencrypt64( GXEncryptionTmp+com.genexus.util.Encryption.checksum( GXEncryptionTmp, 6), GXKey));
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
   }

   public void zm2B13( int GX_JID )
   {
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         Z2EmpNom = A2EmpNom ;
         Z177EmpCUIT = A177EmpCUIT ;
         Z125CatIvaCod = A125CatIvaCod ;
         Z126CatIvaDesc = A126CatIvaDesc ;
         Z178EmpDir = A178EmpDir ;
         Z180EmpTel = A180EmpTel ;
         Z176EmpCP = A176EmpCP ;
         Z532EmpReducc = A532EmpReducc ;
         Z46PaiCod = A46PaiCod ;
         Z47ProvCod = A47ProvCod ;
         Z48LocCod = A48LocCod ;
         Z43ActCodigo = A43ActCodigo ;
         Z45TipEmpleCod = A45TipEmpleCod ;
         Z44EmpZonCod = A44EmpZonCod ;
      }
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         Z312PaiNom = A312PaiNom ;
      }
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
         Z322ProvNom = A322ProvNom ;
      }
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         Z286LocNom = A286LocNom ;
      }
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         Z683ActDescripSinAc = A683ActDescripSinAc ;
         Z108ActDescrip = A108ActDescrip ;
      }
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
         Z530TipEmpleDefIns = A530TipEmpleDefIns ;
      }
      if ( ( GX_JID == 12 ) || ( GX_JID == 0 ) )
      {
         Z518EmpZonDescrip = A518EmpZonDescrip ;
      }
      if ( GX_JID == -5 )
      {
         Z1EmpCod = A1EmpCod ;
         Z2EmpNom = A2EmpNom ;
         Z177EmpCUIT = A177EmpCUIT ;
         Z125CatIvaCod = A125CatIvaCod ;
         Z126CatIvaDesc = A126CatIvaDesc ;
         Z178EmpDir = A178EmpDir ;
         Z180EmpTel = A180EmpTel ;
         Z176EmpCP = A176EmpCP ;
         Z532EmpReducc = A532EmpReducc ;
         Z46PaiCod = A46PaiCod ;
         Z47ProvCod = A47ProvCod ;
         Z48LocCod = A48LocCod ;
         Z3CliCod = A3CliCod ;
         Z43ActCodigo = A43ActCodigo ;
         Z45TipEmpleCod = A45TipEmpleCod ;
         Z44EmpZonCod = A44EmpZonCod ;
         Z312PaiNom = A312PaiNom ;
         Z322ProvNom = A322ProvNom ;
         Z286LocNom = A286LocNom ;
         Z683ActDescripSinAc = A683ActDescripSinAc ;
         Z108ActDescrip = A108ActDescrip ;
         Z530TipEmpleDefIns = A530TipEmpleDefIns ;
         Z518EmpZonDescrip = A518EmpZonDescrip ;
      }
   }

   public void standaloneNotModal( )
   {
      httpContext.GX_msglist.addItem(httpContext.getMessage( "Debe ingresar un valor entre 0 y 1 en Alícuota Contribución ART", ""), 1, "");
      AnyError = (short)(1) ;
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV45Pgmname = "LiqImportarAuxTrn_BC" ;
      }
   }

   public void load2B13( )
   {
      /* Using cursor BC002B11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A683ActDescripSinAc = BC002B11_A683ActDescripSinAc[0] ;
         A2EmpNom = BC002B11_A2EmpNom[0] ;
         A177EmpCUIT = BC002B11_A177EmpCUIT[0] ;
         A125CatIvaCod = BC002B11_A125CatIvaCod[0] ;
         n125CatIvaCod = BC002B11_n125CatIvaCod[0] ;
         A126CatIvaDesc = BC002B11_A126CatIvaDesc[0] ;
         n126CatIvaDesc = BC002B11_n126CatIvaDesc[0] ;
         A178EmpDir = BC002B11_A178EmpDir[0] ;
         A180EmpTel = BC002B11_A180EmpTel[0] ;
         n180EmpTel = BC002B11_n180EmpTel[0] ;
         A176EmpCP = BC002B11_A176EmpCP[0] ;
         n176EmpCP = BC002B11_n176EmpCP[0] ;
         A312PaiNom = BC002B11_A312PaiNom[0] ;
         A322ProvNom = BC002B11_A322ProvNom[0] ;
         A286LocNom = BC002B11_A286LocNom[0] ;
         A108ActDescrip = BC002B11_A108ActDescrip[0] ;
         A518EmpZonDescrip = BC002B11_A518EmpZonDescrip[0] ;
         A532EmpReducc = BC002B11_A532EmpReducc[0] ;
         A530TipEmpleDefIns = BC002B11_A530TipEmpleDefIns[0] ;
         A46PaiCod = BC002B11_A46PaiCod[0] ;
         n46PaiCod = BC002B11_n46PaiCod[0] ;
         A47ProvCod = BC002B11_A47ProvCod[0] ;
         n47ProvCod = BC002B11_n47ProvCod[0] ;
         A48LocCod = BC002B11_A48LocCod[0] ;
         n48LocCod = BC002B11_n48LocCod[0] ;
         A43ActCodigo = BC002B11_A43ActCodigo[0] ;
         n43ActCodigo = BC002B11_n43ActCodigo[0] ;
         A45TipEmpleCod = BC002B11_A45TipEmpleCod[0] ;
         n45TipEmpleCod = BC002B11_n45TipEmpleCod[0] ;
         A44EmpZonCod = BC002B11_A44EmpZonCod[0] ;
         n44EmpZonCod = BC002B11_n44EmpZonCod[0] ;
         zm2B13( -5) ;
      }
      pr_default.close(9);
      onLoadActions2B13( ) ;
   }

   public void onLoadActions2B13( )
   {
      AV45Pgmname = "LiqImportarAuxTrn_BC" ;
   }

   public void checkExtendedTable2B13( )
   {
      nIsDirty_13 = (short)(0) ;
      standaloneModal( ) ;
      AV45Pgmname = "LiqImportarAuxTrn_BC" ;
      /* Using cursor BC002B12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(10);
      /* Using cursor BC002B13 */
      pr_default.execute(11, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         if ( ! ( (0==A46PaiCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
            AnyError = (short)(1) ;
         }
      }
      A312PaiNom = BC002B13_A312PaiNom[0] ;
      pr_default.close(11);
      /* Using cursor BC002B14 */
      pr_default.execute(12, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (0==A47ProvCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Provincia", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PROVCOD");
            AnyError = (short)(1) ;
         }
      }
      A322ProvNom = BC002B14_A322ProvNom[0] ;
      pr_default.close(12);
      /* Using cursor BC002B15 */
      pr_default.execute(13, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (0==A47ProvCod) || (0==A48LocCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Localidad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LOCCOD");
            AnyError = (short)(1) ;
         }
      }
      A286LocNom = BC002B15_A286LocNom[0] ;
      pr_default.close(13);
      /* Using cursor BC002B16 */
      pr_default.execute(14, new Object[] {Boolean.valueOf(n43ActCodigo), A43ActCodigo});
      if ( (pr_default.getStatus(14) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A43ActCodigo)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Actividad", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ACTCODIGO");
            AnyError = (short)(1) ;
         }
      }
      A683ActDescripSinAc = BC002B16_A683ActDescripSinAc[0] ;
      A108ActDescrip = BC002B16_A108ActDescrip[0] ;
      pr_default.close(14);
      /* Using cursor BC002B17 */
      pr_default.execute(15, new Object[] {Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod});
      if ( (pr_default.getStatus(15) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A45TipEmpleCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Empleador", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPEMPLECOD");
            AnyError = (short)(1) ;
         }
      }
      A530TipEmpleDefIns = BC002B17_A530TipEmpleDefIns[0] ;
      pr_default.close(15);
      /* Using cursor BC002B18 */
      pr_default.execute(16, new Object[] {Boolean.valueOf(n44EmpZonCod), A44EmpZonCod});
      if ( (pr_default.getStatus(16) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A44EmpZonCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa Zona", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPZONCOD");
            AnyError = (short)(1) ;
         }
      }
      A518EmpZonDescrip = BC002B18_A518EmpZonDescrip[0] ;
      pr_default.close(16);
   }

   public void closeExtendedTableCursors2B13( )
   {
      pr_default.close(10);
      pr_default.close(11);
      pr_default.close(12);
      pr_default.close(13);
      pr_default.close(14);
      pr_default.close(15);
      pr_default.close(16);
   }

   public void enableDisable( )
   {
   }

   public void getKey2B13( )
   {
      /* Using cursor BC002B19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound13 = (short)(1) ;
      }
      else
      {
         RcdFound13 = (short)(0) ;
      }
      pr_default.close(17);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC002B20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(18) != 101) )
      {
         zm2B13( 5) ;
         RcdFound13 = (short)(1) ;
         A1EmpCod = BC002B20_A1EmpCod[0] ;
         A2EmpNom = BC002B20_A2EmpNom[0] ;
         A177EmpCUIT = BC002B20_A177EmpCUIT[0] ;
         A125CatIvaCod = BC002B20_A125CatIvaCod[0] ;
         n125CatIvaCod = BC002B20_n125CatIvaCod[0] ;
         A126CatIvaDesc = BC002B20_A126CatIvaDesc[0] ;
         n126CatIvaDesc = BC002B20_n126CatIvaDesc[0] ;
         A178EmpDir = BC002B20_A178EmpDir[0] ;
         A180EmpTel = BC002B20_A180EmpTel[0] ;
         n180EmpTel = BC002B20_n180EmpTel[0] ;
         A176EmpCP = BC002B20_A176EmpCP[0] ;
         n176EmpCP = BC002B20_n176EmpCP[0] ;
         A532EmpReducc = BC002B20_A532EmpReducc[0] ;
         A46PaiCod = BC002B20_A46PaiCod[0] ;
         n46PaiCod = BC002B20_n46PaiCod[0] ;
         A47ProvCod = BC002B20_A47ProvCod[0] ;
         n47ProvCod = BC002B20_n47ProvCod[0] ;
         A48LocCod = BC002B20_A48LocCod[0] ;
         n48LocCod = BC002B20_n48LocCod[0] ;
         A3CliCod = BC002B20_A3CliCod[0] ;
         A43ActCodigo = BC002B20_A43ActCodigo[0] ;
         n43ActCodigo = BC002B20_n43ActCodigo[0] ;
         A45TipEmpleCod = BC002B20_A45TipEmpleCod[0] ;
         n45TipEmpleCod = BC002B20_n45TipEmpleCod[0] ;
         A44EmpZonCod = BC002B20_A44EmpZonCod[0] ;
         n44EmpZonCod = BC002B20_n44EmpZonCod[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         sMode13 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load2B13( ) ;
         if ( AnyError == 1 )
         {
            RcdFound13 = (short)(0) ;
            initializeNonKey2B13( ) ;
         }
         Gx_mode = sMode13 ;
      }
      else
      {
         RcdFound13 = (short)(0) ;
         initializeNonKey2B13( ) ;
         sMode13 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode13 ;
      }
      pr_default.close(18);
   }

   public void getEqualNoModal( )
   {
      getKey2B13( ) ;
      if ( RcdFound13 == 0 )
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
      confirm_2B0( ) ;
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

   public void checkOptimisticConcurrency2B13( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC002B21 */
         pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(19) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresa"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(19) == 101) || ( GXutil.strcmp(Z2EmpNom, BC002B21_A2EmpNom[0]) != 0 ) || ( Z177EmpCUIT != BC002B21_A177EmpCUIT[0] ) || ( Z125CatIvaCod != BC002B21_A125CatIvaCod[0] ) || ( GXutil.strcmp(Z126CatIvaDesc, BC002B21_A126CatIvaDesc[0]) != 0 ) || ( GXutil.strcmp(Z178EmpDir, BC002B21_A178EmpDir[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z180EmpTel, BC002B21_A180EmpTel[0]) != 0 ) || ( GXutil.strcmp(Z176EmpCP, BC002B21_A176EmpCP[0]) != 0 ) || ( Z532EmpReducc != BC002B21_A532EmpReducc[0] ) || ( Z46PaiCod != BC002B21_A46PaiCod[0] ) || ( Z47ProvCod != BC002B21_A47ProvCod[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z48LocCod != BC002B21_A48LocCod[0] ) || ( GXutil.strcmp(Z43ActCodigo, BC002B21_A43ActCodigo[0]) != 0 ) || ( GXutil.strcmp(Z45TipEmpleCod, BC002B21_A45TipEmpleCod[0]) != 0 ) || ( GXutil.strcmp(Z44EmpZonCod, BC002B21_A44EmpZonCod[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresa"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2B13( )
   {
      beforeValidate2B13( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2B13( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2B13( 0) ;
         checkOptimisticConcurrency2B13( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2B13( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2B13( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002B22 */
                  pr_default.execute(20, new Object[] {Short.valueOf(A1EmpCod), A2EmpNom, Long.valueOf(A177EmpCUIT), Boolean.valueOf(n125CatIvaCod), Short.valueOf(A125CatIvaCod), Boolean.valueOf(n126CatIvaDesc), A126CatIvaDesc, A178EmpDir, Boolean.valueOf(n180EmpTel), A180EmpTel, Boolean.valueOf(n176EmpCP), A176EmpCP, Boolean.valueOf(A532EmpReducc), Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod), Integer.valueOf(A3CliCod), Boolean.valueOf(n43ActCodigo), A43ActCodigo, Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod, Boolean.valueOf(n44EmpZonCod), A44EmpZonCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
                  if ( (pr_default.getStatus(20) == 1) )
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
            load2B13( ) ;
         }
         endLevel2B13( ) ;
      }
      closeExtendedTableCursors2B13( ) ;
   }

   public void update2B13( )
   {
      beforeValidate2B13( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2B13( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2B13( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2B13( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2B13( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002B23 */
                  pr_default.execute(21, new Object[] {A2EmpNom, Long.valueOf(A177EmpCUIT), Boolean.valueOf(n125CatIvaCod), Short.valueOf(A125CatIvaCod), Boolean.valueOf(n126CatIvaDesc), A126CatIvaDesc, A178EmpDir, Boolean.valueOf(n180EmpTel), A180EmpTel, Boolean.valueOf(n176EmpCP), A176EmpCP, Boolean.valueOf(A532EmpReducc), Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod), Boolean.valueOf(n43ActCodigo), A43ActCodigo, Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod, Boolean.valueOf(n44EmpZonCod), A44EmpZonCod, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
                  if ( (pr_default.getStatus(21) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresa"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2B13( ) ;
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
         endLevel2B13( ) ;
      }
      closeExtendedTableCursors2B13( ) ;
   }

   public void deferredUpdate2B13( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate2B13( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2B13( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2B13( ) ;
         afterConfirm2B13( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2B13( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC002B24 */
               pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresa");
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
      sMode13 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel2B13( ) ;
      Gx_mode = sMode13 ;
   }

   public void onDeleteControls2B13( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV45Pgmname = "LiqImportarAuxTrn_BC" ;
         /* Using cursor BC002B25 */
         pr_default.execute(23, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod)});
         A312PaiNom = BC002B25_A312PaiNom[0] ;
         pr_default.close(23);
         /* Using cursor BC002B26 */
         pr_default.execute(24, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod)});
         A322ProvNom = BC002B26_A322ProvNom[0] ;
         pr_default.close(24);
         /* Using cursor BC002B27 */
         pr_default.execute(25, new Object[] {Boolean.valueOf(n46PaiCod), Short.valueOf(A46PaiCod), Boolean.valueOf(n47ProvCod), Short.valueOf(A47ProvCod), Boolean.valueOf(n48LocCod), Short.valueOf(A48LocCod)});
         A286LocNom = BC002B27_A286LocNom[0] ;
         pr_default.close(25);
         /* Using cursor BC002B28 */
         pr_default.execute(26, new Object[] {Boolean.valueOf(n43ActCodigo), A43ActCodigo});
         A683ActDescripSinAc = BC002B28_A683ActDescripSinAc[0] ;
         A108ActDescrip = BC002B28_A108ActDescrip[0] ;
         pr_default.close(26);
         /* Using cursor BC002B29 */
         pr_default.execute(27, new Object[] {Boolean.valueOf(n45TipEmpleCod), A45TipEmpleCod});
         A530TipEmpleDefIns = BC002B29_A530TipEmpleDefIns[0] ;
         pr_default.close(27);
         /* Using cursor BC002B30 */
         pr_default.execute(28, new Object[] {Boolean.valueOf(n44EmpZonCod), A44EmpZonCod});
         A518EmpZonDescrip = BC002B30_A518EmpZonDescrip[0] ;
         pr_default.close(28);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC002B31 */
         pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(29) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "banda_salarial", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(29);
         /* Using cursor BC002B32 */
         pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(30) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(30);
         /* Using cursor BC002B33 */
         pr_default.execute(31, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(31) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionLotes3", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(31);
         /* Using cursor BC002B34 */
         pr_default.execute(32, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(32) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(32);
         /* Using cursor BC002B35 */
         pr_default.execute(33, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(33) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionLegajoLinkPdf", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(33);
         /* Using cursor BC002B36 */
         pr_default.execute(34, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(34) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionSucursal", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(34);
         /* Using cursor BC002B37 */
         pr_default.execute(35, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(35) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionArea", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(35);
         /* Using cursor BC002B38 */
         pr_default.execute(36, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(36) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionConvenio", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(36);
         /* Using cursor BC002B39 */
         pr_default.execute(37, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(37) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "EmpresaBancos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(37);
         /* Using cursor BC002B40 */
         pr_default.execute(38, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(38) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Periodo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(38);
         /* Using cursor BC002B41 */
         pr_default.execute(39, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(39) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LSD_reg1", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(39);
         /* Using cursor BC002B42 */
         pr_default.execute(40, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(40) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(40);
         /* Using cursor BC002B43 */
         pr_default.execute(41, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(41) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(41);
         /* Using cursor BC002B44 */
         pr_default.execute(42, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(42) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(42);
         /* Using cursor BC002B45 */
         pr_default.execute(43, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(43) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(43);
         /* Using cursor BC002B46 */
         pr_default.execute(44, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(44) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(44);
         /* Using cursor BC002B47 */
         pr_default.execute(45, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(45) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(45);
         /* Using cursor BC002B48 */
         pr_default.execute(46, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(46) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(46);
         /* Using cursor BC002B49 */
         pr_default.execute(47, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(47) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(47);
         /* Using cursor BC002B50 */
         pr_default.execute(48, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(48) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(48);
         /* Using cursor BC002B51 */
         pr_default.execute(49, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(49) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(49);
         /* Using cursor BC002B52 */
         pr_default.execute(50, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(50) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(50);
         /* Using cursor BC002B53 */
         pr_default.execute(51, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(51) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(51);
         /* Using cursor BC002B54 */
         pr_default.execute(52, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(52) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(52);
         /* Using cursor BC002B55 */
         pr_default.execute(53, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(53) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(53);
         /* Using cursor BC002B56 */
         pr_default.execute(54, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(54) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(54);
         /* Using cursor BC002B57 */
         pr_default.execute(55, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(55) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(55);
         /* Using cursor BC002B58 */
         pr_default.execute(56, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(56) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(56);
         /* Using cursor BC002B59 */
         pr_default.execute(57, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(57) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(57);
         /* Using cursor BC002B60 */
         pr_default.execute(58, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(58) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(58);
         /* Using cursor BC002B61 */
         pr_default.execute(59, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(59) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(59);
         /* Using cursor BC002B62 */
         pr_default.execute(60, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(60) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(60);
         /* Using cursor BC002B63 */
         pr_default.execute(61, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(61) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(61);
         /* Using cursor BC002B64 */
         pr_default.execute(62, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(62) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(62);
         /* Using cursor BC002B65 */
         pr_default.execute(63, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(63) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(63);
         /* Using cursor BC002B66 */
         pr_default.execute(64, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(64) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(64);
         /* Using cursor BC002B67 */
         pr_default.execute(65, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(65) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(65);
         /* Using cursor BC002B68 */
         pr_default.execute(66, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(66) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(66);
         /* Using cursor BC002B69 */
         pr_default.execute(67, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(67) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(67);
         /* Using cursor BC002B70 */
         pr_default.execute(68, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(68) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(68);
         /* Using cursor BC002B71 */
         pr_default.execute(69, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(69) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(69);
         /* Using cursor BC002B72 */
         pr_default.execute(70, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(70) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(70);
         /* Using cursor BC002B73 */
         pr_default.execute(71, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(71) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(71);
         /* Using cursor BC002B74 */
         pr_default.execute(72, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(72) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(72);
         /* Using cursor BC002B75 */
         pr_default.execute(73, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(73) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(73);
         /* Using cursor BC002B76 */
         pr_default.execute(74, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(74) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(74);
         /* Using cursor BC002B77 */
         pr_default.execute(75, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(75) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(75);
         /* Using cursor BC002B78 */
         pr_default.execute(76, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(76) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(76);
         /* Using cursor BC002B79 */
         pr_default.execute(77, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(77) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(77);
         /* Using cursor BC002B80 */
         pr_default.execute(78, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(78) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(78);
         /* Using cursor BC002B81 */
         pr_default.execute(79, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(79) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(79);
         /* Using cursor BC002B82 */
         pr_default.execute(80, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(80) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(80);
         /* Using cursor BC002B83 */
         pr_default.execute(81, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(81) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(81);
         /* Using cursor BC002B84 */
         pr_default.execute(82, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(82) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(82);
         /* Using cursor BC002B85 */
         pr_default.execute(83, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(83) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(83);
         /* Using cursor BC002B86 */
         pr_default.execute(84, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(84) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(84);
         /* Using cursor BC002B87 */
         pr_default.execute(85, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(85) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(85);
         /* Using cursor BC002B88 */
         pr_default.execute(86, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(86) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(86);
         /* Using cursor BC002B89 */
         pr_default.execute(87, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(87) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(87);
         /* Using cursor BC002B90 */
         pr_default.execute(88, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(88) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(88);
         /* Using cursor BC002B91 */
         pr_default.execute(89, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(89) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(89);
         /* Using cursor BC002B92 */
         pr_default.execute(90, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(90) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(90);
         /* Using cursor BC002B93 */
         pr_default.execute(91, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(91) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(91);
         /* Using cursor BC002B94 */
         pr_default.execute(92, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(92) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(92);
         /* Using cursor BC002B95 */
         pr_default.execute(93, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(93) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(93);
         /* Using cursor BC002B96 */
         pr_default.execute(94, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(94) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(94);
         /* Using cursor BC002B97 */
         pr_default.execute(95, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(95) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(95);
         /* Using cursor BC002B98 */
         pr_default.execute(96, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(96) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Guarderias", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(96);
         /* Using cursor BC002B99 */
         pr_default.execute(97, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(97) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "base_calculo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(97);
         /* Using cursor BC002B100 */
         pr_default.execute(98, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(98) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Promedio para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(98);
         /* Using cursor BC002B101 */
         pr_default.execute(99, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(99) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para jornalizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(99);
         /* Using cursor BC002B102 */
         pr_default.execute(100, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(100) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Conceptos para base de cálculo de hora normal para mensualizados", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(100);
         /* Using cursor BC002B103 */
         pr_default.execute(101, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(101) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "horasextras_por Limite", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(101);
         /* Using cursor BC002B104 */
         pr_default.execute(102, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(102) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "horasextras_pordia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(102);
         /* Using cursor BC002B105 */
         pr_default.execute(103, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(103) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Sucursal", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(103);
         /* Using cursor BC002B106 */
         pr_default.execute(104, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(104) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "nolaborables_religion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(104);
         /* Using cursor BC002B107 */
         pr_default.execute(105, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(105) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "nolaborables_origen", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(105);
         /* Using cursor BC002B108 */
         pr_default.execute(106, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(106) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "nolaborables_convenio", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(106);
         /* Using cursor BC002B109 */
         pr_default.execute(107, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(107) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Formulario F1357", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(107);
         /* Using cursor BC002B110 */
         pr_default.execute(108, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(108) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "importacion_liquidaciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(108);
         /* Using cursor BC002B111 */
         pr_default.execute(109, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(109) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "importacion_legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(109);
         /* Using cursor BC002B112 */
         pr_default.execute(110, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(110) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Template Recibo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(110);
         /* Using cursor BC002B113 */
         pr_default.execute(111, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(111) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "archivo_siradig", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(111);
         /* Using cursor BC002B114 */
         pr_default.execute(112, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(112) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Asiento Cab", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(112);
         /* Using cursor BC002B115 */
         pr_default.execute(113, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(113) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cuenta Contable", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(113);
         /* Using cursor BC002B116 */
         pr_default.execute(114, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(114) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Centro De Costo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(114);
         /* Using cursor BC002B117 */
         pr_default.execute(115, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(115) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion Lugar Pago", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(115);
         /* Using cursor BC002B118 */
         pr_default.execute(116, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(116) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(116);
      }
   }

   public void endLevel2B13( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(19);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2B13( ) ;
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

   public void scanKeyStart2B13( )
   {
      /* Scan By routine */
      /* Using cursor BC002B119 */
      pr_default.execute(117, new Object[] {Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod)});
      RcdFound13 = (short)(0) ;
      if ( (pr_default.getStatus(117) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A683ActDescripSinAc = BC002B119_A683ActDescripSinAc[0] ;
         A1EmpCod = BC002B119_A1EmpCod[0] ;
         A2EmpNom = BC002B119_A2EmpNom[0] ;
         A177EmpCUIT = BC002B119_A177EmpCUIT[0] ;
         A125CatIvaCod = BC002B119_A125CatIvaCod[0] ;
         n125CatIvaCod = BC002B119_n125CatIvaCod[0] ;
         A126CatIvaDesc = BC002B119_A126CatIvaDesc[0] ;
         n126CatIvaDesc = BC002B119_n126CatIvaDesc[0] ;
         A178EmpDir = BC002B119_A178EmpDir[0] ;
         A180EmpTel = BC002B119_A180EmpTel[0] ;
         n180EmpTel = BC002B119_n180EmpTel[0] ;
         A176EmpCP = BC002B119_A176EmpCP[0] ;
         n176EmpCP = BC002B119_n176EmpCP[0] ;
         A312PaiNom = BC002B119_A312PaiNom[0] ;
         A322ProvNom = BC002B119_A322ProvNom[0] ;
         A286LocNom = BC002B119_A286LocNom[0] ;
         A108ActDescrip = BC002B119_A108ActDescrip[0] ;
         A518EmpZonDescrip = BC002B119_A518EmpZonDescrip[0] ;
         A532EmpReducc = BC002B119_A532EmpReducc[0] ;
         A530TipEmpleDefIns = BC002B119_A530TipEmpleDefIns[0] ;
         A46PaiCod = BC002B119_A46PaiCod[0] ;
         n46PaiCod = BC002B119_n46PaiCod[0] ;
         A47ProvCod = BC002B119_A47ProvCod[0] ;
         n47ProvCod = BC002B119_n47ProvCod[0] ;
         A48LocCod = BC002B119_A48LocCod[0] ;
         n48LocCod = BC002B119_n48LocCod[0] ;
         A3CliCod = BC002B119_A3CliCod[0] ;
         A43ActCodigo = BC002B119_A43ActCodigo[0] ;
         n43ActCodigo = BC002B119_n43ActCodigo[0] ;
         A45TipEmpleCod = BC002B119_A45TipEmpleCod[0] ;
         n45TipEmpleCod = BC002B119_n45TipEmpleCod[0] ;
         A44EmpZonCod = BC002B119_A44EmpZonCod[0] ;
         n44EmpZonCod = BC002B119_n44EmpZonCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext2B13( )
   {
      /* Scan next routine */
      pr_default.readNext(117);
      RcdFound13 = (short)(0) ;
      scanKeyLoad2B13( ) ;
   }

   public void scanKeyLoad2B13( )
   {
      sMode13 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(117) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A683ActDescripSinAc = BC002B119_A683ActDescripSinAc[0] ;
         A1EmpCod = BC002B119_A1EmpCod[0] ;
         A2EmpNom = BC002B119_A2EmpNom[0] ;
         A177EmpCUIT = BC002B119_A177EmpCUIT[0] ;
         A125CatIvaCod = BC002B119_A125CatIvaCod[0] ;
         n125CatIvaCod = BC002B119_n125CatIvaCod[0] ;
         A126CatIvaDesc = BC002B119_A126CatIvaDesc[0] ;
         n126CatIvaDesc = BC002B119_n126CatIvaDesc[0] ;
         A178EmpDir = BC002B119_A178EmpDir[0] ;
         A180EmpTel = BC002B119_A180EmpTel[0] ;
         n180EmpTel = BC002B119_n180EmpTel[0] ;
         A176EmpCP = BC002B119_A176EmpCP[0] ;
         n176EmpCP = BC002B119_n176EmpCP[0] ;
         A312PaiNom = BC002B119_A312PaiNom[0] ;
         A322ProvNom = BC002B119_A322ProvNom[0] ;
         A286LocNom = BC002B119_A286LocNom[0] ;
         A108ActDescrip = BC002B119_A108ActDescrip[0] ;
         A518EmpZonDescrip = BC002B119_A518EmpZonDescrip[0] ;
         A532EmpReducc = BC002B119_A532EmpReducc[0] ;
         A530TipEmpleDefIns = BC002B119_A530TipEmpleDefIns[0] ;
         A46PaiCod = BC002B119_A46PaiCod[0] ;
         n46PaiCod = BC002B119_n46PaiCod[0] ;
         A47ProvCod = BC002B119_A47ProvCod[0] ;
         n47ProvCod = BC002B119_n47ProvCod[0] ;
         A48LocCod = BC002B119_A48LocCod[0] ;
         n48LocCod = BC002B119_n48LocCod[0] ;
         A3CliCod = BC002B119_A3CliCod[0] ;
         A43ActCodigo = BC002B119_A43ActCodigo[0] ;
         n43ActCodigo = BC002B119_n43ActCodigo[0] ;
         A45TipEmpleCod = BC002B119_A45TipEmpleCod[0] ;
         n45TipEmpleCod = BC002B119_n45TipEmpleCod[0] ;
         A44EmpZonCod = BC002B119_A44EmpZonCod[0] ;
         n44EmpZonCod = BC002B119_n44EmpZonCod[0] ;
      }
      Gx_mode = sMode13 ;
   }

   public void scanKeyEnd2B13( )
   {
      pr_default.close(117);
   }

   public void afterConfirm2B13( )
   {
      /* After Confirm Rules */
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int7 = A1EmpCod ;
         GXv_int8[0] = GXt_int7 ;
         new web.getnextemp(remoteHandle, context).execute( A3CliCod, GXv_int8) ;
         liqimportarauxtrn_bc.this.GXt_int7 = GXv_int8[0] ;
         A1EmpCod = GXt_int7 ;
      }
   }

   public void beforeInsert2B13( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2B13( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2B13( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2B13( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2B13( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2B13( )
   {
   }

   public void send_integrity_lvl_hashes2B13( )
   {
   }

   public void addRow2B13( )
   {
      VarsToRow13( bcLiqImportarAuxTrn) ;
   }

   public void readRow2B13( )
   {
      RowToVars13( bcLiqImportarAuxTrn, 1) ;
   }

   public void initializeNonKey2B13( )
   {
      A683ActDescripSinAc = "" ;
      A2EmpNom = "" ;
      A177EmpCUIT = 0 ;
      A125CatIvaCod = (short)(0) ;
      n125CatIvaCod = false ;
      A126CatIvaDesc = "" ;
      n126CatIvaDesc = false ;
      A178EmpDir = "" ;
      A180EmpTel = "" ;
      n180EmpTel = false ;
      A176EmpCP = "" ;
      n176EmpCP = false ;
      A46PaiCod = (short)(0) ;
      n46PaiCod = false ;
      A312PaiNom = "" ;
      A47ProvCod = (short)(0) ;
      n47ProvCod = false ;
      A322ProvNom = "" ;
      A48LocCod = (short)(0) ;
      n48LocCod = false ;
      A286LocNom = "" ;
      A43ActCodigo = "" ;
      n43ActCodigo = false ;
      A108ActDescrip = "" ;
      A45TipEmpleCod = "" ;
      n45TipEmpleCod = false ;
      A44EmpZonCod = "" ;
      n44EmpZonCod = false ;
      A518EmpZonDescrip = "" ;
      A532EmpReducc = false ;
      A530TipEmpleDefIns = "" ;
      Z2EmpNom = "" ;
      Z177EmpCUIT = 0 ;
      Z125CatIvaCod = (short)(0) ;
      Z126CatIvaDesc = "" ;
      Z178EmpDir = "" ;
      Z180EmpTel = "" ;
      Z176EmpCP = "" ;
      Z532EmpReducc = false ;
      Z46PaiCod = (short)(0) ;
      Z47ProvCod = (short)(0) ;
      Z48LocCod = (short)(0) ;
      Z43ActCodigo = "" ;
      Z45TipEmpleCod = "" ;
      Z44EmpZonCod = "" ;
   }

   public void initAll2B13( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      initializeNonKey2B13( ) ;
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

   public void VarsToRow13( web.SdtLiqImportarAuxTrn obj13 )
   {
      obj13.setgxTv_SdtLiqImportarAuxTrn_Mode( Gx_mode );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empnom( A2EmpNom );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empcuit( A177EmpCUIT );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Cativacod( A125CatIvaCod );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Cativadesc( A126CatIvaDesc );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empdir( A178EmpDir );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Emptel( A180EmpTel );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empcp( A176EmpCP );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Paicod( A46PaiCod );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Painom( A312PaiNom );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Provcod( A47ProvCod );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Provnom( A322ProvNom );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Loccod( A48LocCod );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Locnom( A286LocNom );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Actcodigo( A43ActCodigo );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Actdescrip( A108ActDescrip );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Tipemplecod( A45TipEmpleCod );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empzoncod( A44EmpZonCod );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empzondescrip( A518EmpZonDescrip );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empreducc( A532EmpReducc );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Tipempledefins( A530TipEmpleDefIns );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Clicod( A3CliCod );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empcod( A1EmpCod );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Clicod_Z( Z3CliCod );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empcod_Z( Z1EmpCod );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empnom_Z( Z2EmpNom );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empcuit_Z( Z177EmpCUIT );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Cativacod_Z( Z125CatIvaCod );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Cativadesc_Z( Z126CatIvaDesc );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empdir_Z( Z178EmpDir );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Emptel_Z( Z180EmpTel );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empcp_Z( Z176EmpCP );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Paicod_Z( Z46PaiCod );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Painom_Z( Z312PaiNom );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Provcod_Z( Z47ProvCod );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Provnom_Z( Z322ProvNom );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Loccod_Z( Z48LocCod );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Locnom_Z( Z286LocNom );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Actcodigo_Z( Z43ActCodigo );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Actdescrip_Z( Z108ActDescrip );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z( Z45TipEmpleCod );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empzoncod_Z( Z44EmpZonCod );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z( Z518EmpZonDescrip );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empreducc_Z( Z532EmpReducc );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z( Z530TipEmpleDefIns );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Cativacod_N( (byte)((byte)((n125CatIvaCod)?1:0)) );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Cativadesc_N( (byte)((byte)((n126CatIvaDesc)?1:0)) );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Emptel_N( (byte)((byte)((n180EmpTel)?1:0)) );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empcp_N( (byte)((byte)((n176EmpCP)?1:0)) );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Paicod_N( (byte)((byte)((n46PaiCod)?1:0)) );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Provcod_N( (byte)((byte)((n47ProvCod)?1:0)) );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Loccod_N( (byte)((byte)((n48LocCod)?1:0)) );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Actcodigo_N( (byte)((byte)((n43ActCodigo)?1:0)) );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Tipemplecod_N( (byte)((byte)((n45TipEmpleCod)?1:0)) );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empzoncod_N( (byte)((byte)((n44EmpZonCod)?1:0)) );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Mode( Gx_mode );
   }

   public void KeyVarsToRow13( web.SdtLiqImportarAuxTrn obj13 )
   {
      obj13.setgxTv_SdtLiqImportarAuxTrn_Clicod( A3CliCod );
      obj13.setgxTv_SdtLiqImportarAuxTrn_Empcod( A1EmpCod );
   }

   public void RowToVars13( web.SdtLiqImportarAuxTrn obj13 ,
                            int forceLoad )
   {
      Gx_mode = obj13.getgxTv_SdtLiqImportarAuxTrn_Mode() ;
      A2EmpNom = obj13.getgxTv_SdtLiqImportarAuxTrn_Empnom() ;
      A177EmpCUIT = obj13.getgxTv_SdtLiqImportarAuxTrn_Empcuit() ;
      A125CatIvaCod = obj13.getgxTv_SdtLiqImportarAuxTrn_Cativacod() ;
      n125CatIvaCod = false ;
      A126CatIvaDesc = obj13.getgxTv_SdtLiqImportarAuxTrn_Cativadesc() ;
      n126CatIvaDesc = false ;
      A178EmpDir = obj13.getgxTv_SdtLiqImportarAuxTrn_Empdir() ;
      A180EmpTel = obj13.getgxTv_SdtLiqImportarAuxTrn_Emptel() ;
      n180EmpTel = false ;
      A176EmpCP = obj13.getgxTv_SdtLiqImportarAuxTrn_Empcp() ;
      n176EmpCP = false ;
      A46PaiCod = obj13.getgxTv_SdtLiqImportarAuxTrn_Paicod() ;
      n46PaiCod = false ;
      A312PaiNom = obj13.getgxTv_SdtLiqImportarAuxTrn_Painom() ;
      A47ProvCod = obj13.getgxTv_SdtLiqImportarAuxTrn_Provcod() ;
      n47ProvCod = false ;
      A322ProvNom = obj13.getgxTv_SdtLiqImportarAuxTrn_Provnom() ;
      A48LocCod = obj13.getgxTv_SdtLiqImportarAuxTrn_Loccod() ;
      n48LocCod = false ;
      A286LocNom = obj13.getgxTv_SdtLiqImportarAuxTrn_Locnom() ;
      A43ActCodigo = obj13.getgxTv_SdtLiqImportarAuxTrn_Actcodigo() ;
      n43ActCodigo = false ;
      A108ActDescrip = obj13.getgxTv_SdtLiqImportarAuxTrn_Actdescrip() ;
      A45TipEmpleCod = obj13.getgxTv_SdtLiqImportarAuxTrn_Tipemplecod() ;
      n45TipEmpleCod = false ;
      A44EmpZonCod = obj13.getgxTv_SdtLiqImportarAuxTrn_Empzoncod() ;
      n44EmpZonCod = false ;
      A518EmpZonDescrip = obj13.getgxTv_SdtLiqImportarAuxTrn_Empzondescrip() ;
      A532EmpReducc = obj13.getgxTv_SdtLiqImportarAuxTrn_Empreducc() ;
      A530TipEmpleDefIns = obj13.getgxTv_SdtLiqImportarAuxTrn_Tipempledefins() ;
      A3CliCod = obj13.getgxTv_SdtLiqImportarAuxTrn_Clicod() ;
      A1EmpCod = obj13.getgxTv_SdtLiqImportarAuxTrn_Empcod() ;
      Z3CliCod = obj13.getgxTv_SdtLiqImportarAuxTrn_Clicod_Z() ;
      Z1EmpCod = obj13.getgxTv_SdtLiqImportarAuxTrn_Empcod_Z() ;
      Z2EmpNom = obj13.getgxTv_SdtLiqImportarAuxTrn_Empnom_Z() ;
      Z177EmpCUIT = obj13.getgxTv_SdtLiqImportarAuxTrn_Empcuit_Z() ;
      Z125CatIvaCod = obj13.getgxTv_SdtLiqImportarAuxTrn_Cativacod_Z() ;
      Z126CatIvaDesc = obj13.getgxTv_SdtLiqImportarAuxTrn_Cativadesc_Z() ;
      Z178EmpDir = obj13.getgxTv_SdtLiqImportarAuxTrn_Empdir_Z() ;
      Z180EmpTel = obj13.getgxTv_SdtLiqImportarAuxTrn_Emptel_Z() ;
      Z176EmpCP = obj13.getgxTv_SdtLiqImportarAuxTrn_Empcp_Z() ;
      Z46PaiCod = obj13.getgxTv_SdtLiqImportarAuxTrn_Paicod_Z() ;
      Z312PaiNom = obj13.getgxTv_SdtLiqImportarAuxTrn_Painom_Z() ;
      Z47ProvCod = obj13.getgxTv_SdtLiqImportarAuxTrn_Provcod_Z() ;
      Z322ProvNom = obj13.getgxTv_SdtLiqImportarAuxTrn_Provnom_Z() ;
      Z48LocCod = obj13.getgxTv_SdtLiqImportarAuxTrn_Loccod_Z() ;
      Z286LocNom = obj13.getgxTv_SdtLiqImportarAuxTrn_Locnom_Z() ;
      Z43ActCodigo = obj13.getgxTv_SdtLiqImportarAuxTrn_Actcodigo_Z() ;
      Z108ActDescrip = obj13.getgxTv_SdtLiqImportarAuxTrn_Actdescrip_Z() ;
      Z45TipEmpleCod = obj13.getgxTv_SdtLiqImportarAuxTrn_Tipemplecod_Z() ;
      Z44EmpZonCod = obj13.getgxTv_SdtLiqImportarAuxTrn_Empzoncod_Z() ;
      Z518EmpZonDescrip = obj13.getgxTv_SdtLiqImportarAuxTrn_Empzondescrip_Z() ;
      Z532EmpReducc = obj13.getgxTv_SdtLiqImportarAuxTrn_Empreducc_Z() ;
      Z530TipEmpleDefIns = obj13.getgxTv_SdtLiqImportarAuxTrn_Tipempledefins_Z() ;
      n125CatIvaCod = (boolean)((obj13.getgxTv_SdtLiqImportarAuxTrn_Cativacod_N()==0)?false:true) ;
      n126CatIvaDesc = (boolean)((obj13.getgxTv_SdtLiqImportarAuxTrn_Cativadesc_N()==0)?false:true) ;
      n180EmpTel = (boolean)((obj13.getgxTv_SdtLiqImportarAuxTrn_Emptel_N()==0)?false:true) ;
      n176EmpCP = (boolean)((obj13.getgxTv_SdtLiqImportarAuxTrn_Empcp_N()==0)?false:true) ;
      n46PaiCod = (boolean)((obj13.getgxTv_SdtLiqImportarAuxTrn_Paicod_N()==0)?false:true) ;
      n47ProvCod = (boolean)((obj13.getgxTv_SdtLiqImportarAuxTrn_Provcod_N()==0)?false:true) ;
      n48LocCod = (boolean)((obj13.getgxTv_SdtLiqImportarAuxTrn_Loccod_N()==0)?false:true) ;
      n43ActCodigo = (boolean)((obj13.getgxTv_SdtLiqImportarAuxTrn_Actcodigo_N()==0)?false:true) ;
      n45TipEmpleCod = (boolean)((obj13.getgxTv_SdtLiqImportarAuxTrn_Tipemplecod_N()==0)?false:true) ;
      n44EmpZonCod = (boolean)((obj13.getgxTv_SdtLiqImportarAuxTrn_Empzoncod_N()==0)?false:true) ;
      Gx_mode = obj13.getgxTv_SdtLiqImportarAuxTrn_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey2B13( ) ;
      scanKeyStart2B13( ) ;
      if ( RcdFound13 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC002B120 */
         pr_default.execute(118, new Object[] {Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(118) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(118);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
      }
      zm2B13( -5) ;
      onLoadActions2B13( ) ;
      addRow2B13( ) ;
      scanKeyEnd2B13( ) ;
      if ( RcdFound13 == 0 )
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
      RowToVars13( bcLiqImportarAuxTrn, 0) ;
      scanKeyStart2B13( ) ;
      if ( RcdFound13 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC002B121 */
         pr_default.execute(119, new Object[] {Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(119) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(119);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
      }
      zm2B13( -5) ;
      onLoadActions2B13( ) ;
      addRow2B13( ) ;
      scanKeyEnd2B13( ) ;
      if ( RcdFound13 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2B13( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert2B13( ) ;
      }
      else
      {
         if ( RcdFound13 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
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
               update2B13( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) )
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
                     insert2B13( ) ;
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
                     insert2B13( ) ;
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
      RowToVars13( bcLiqImportarAuxTrn, 1) ;
      saveImpl( ) ;
      VarsToRow13( bcLiqImportarAuxTrn) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars13( bcLiqImportarAuxTrn, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert2B13( ) ;
      afterTrn( ) ;
      VarsToRow13( bcLiqImportarAuxTrn) ;
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
         web.SdtLiqImportarAuxTrn auxBC = new web.SdtLiqImportarAuxTrn( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcLiqImportarAuxTrn);
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
      RowToVars13( bcLiqImportarAuxTrn, 1) ;
      updateImpl( ) ;
      VarsToRow13( bcLiqImportarAuxTrn) ;
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
      RowToVars13( bcLiqImportarAuxTrn, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert2B13( ) ;
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
      VarsToRow13( bcLiqImportarAuxTrn) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars13( bcLiqImportarAuxTrn, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey2B13( ) ;
      if ( RcdFound13 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "liqimportarauxtrn_bc");
      VarsToRow13( bcLiqImportarAuxTrn) ;
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
      Gx_mode = bcLiqImportarAuxTrn.getgxTv_SdtLiqImportarAuxTrn_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcLiqImportarAuxTrn.setgxTv_SdtLiqImportarAuxTrn_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtLiqImportarAuxTrn sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcLiqImportarAuxTrn )
      {
         bcLiqImportarAuxTrn = sdt ;
         if ( GXutil.strcmp(bcLiqImportarAuxTrn.getgxTv_SdtLiqImportarAuxTrn_Mode(), "") == 0 )
         {
            bcLiqImportarAuxTrn.setgxTv_SdtLiqImportarAuxTrn_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow13( bcLiqImportarAuxTrn) ;
         }
         else
         {
            RowToVars13( bcLiqImportarAuxTrn, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcLiqImportarAuxTrn.getgxTv_SdtLiqImportarAuxTrn_Mode(), "") == 0 )
         {
            bcLiqImportarAuxTrn.setgxTv_SdtLiqImportarAuxTrn_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars13( bcLiqImportarAuxTrn, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtLiqImportarAuxTrn getLiqImportarAuxTrn_BC( )
   {
      return bcLiqImportarAuxTrn ;
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
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV45Pgmname = "" ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      AV15TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV14Insert_ActCodigo = "" ;
      AV40Insert_TipEmpleCod = "" ;
      AV36Insert_EmpZonCod = "" ;
      GXv_int4 = new long[1] ;
      AV33Date = GXutil.nullDate() ;
      GXv_date5 = new java.util.Date[1] ;
      GXv_boolean3 = new boolean[1] ;
      GXv_char6 = new String[1] ;
      AV35Session = httpContext.getWebSession();
      GXKey = "" ;
      GXEncryptionTmp = "" ;
      Z2EmpNom = "" ;
      A2EmpNom = "" ;
      Z126CatIvaDesc = "" ;
      A126CatIvaDesc = "" ;
      Z178EmpDir = "" ;
      A178EmpDir = "" ;
      Z180EmpTel = "" ;
      A180EmpTel = "" ;
      Z176EmpCP = "" ;
      A176EmpCP = "" ;
      Z43ActCodigo = "" ;
      A43ActCodigo = "" ;
      Z45TipEmpleCod = "" ;
      A45TipEmpleCod = "" ;
      Z44EmpZonCod = "" ;
      A44EmpZonCod = "" ;
      Z312PaiNom = "" ;
      A312PaiNom = "" ;
      Z322ProvNom = "" ;
      A322ProvNom = "" ;
      Z286LocNom = "" ;
      A286LocNom = "" ;
      Z683ActDescripSinAc = "" ;
      A683ActDescripSinAc = "" ;
      Z108ActDescrip = "" ;
      A108ActDescrip = "" ;
      Z530TipEmpleDefIns = "" ;
      A530TipEmpleDefIns = "" ;
      Z518EmpZonDescrip = "" ;
      A518EmpZonDescrip = "" ;
      BC002B11_A683ActDescripSinAc = new String[] {""} ;
      BC002B11_A1EmpCod = new short[1] ;
      BC002B11_A2EmpNom = new String[] {""} ;
      BC002B11_A177EmpCUIT = new long[1] ;
      BC002B11_A125CatIvaCod = new short[1] ;
      BC002B11_n125CatIvaCod = new boolean[] {false} ;
      BC002B11_A126CatIvaDesc = new String[] {""} ;
      BC002B11_n126CatIvaDesc = new boolean[] {false} ;
      BC002B11_A178EmpDir = new String[] {""} ;
      BC002B11_A180EmpTel = new String[] {""} ;
      BC002B11_n180EmpTel = new boolean[] {false} ;
      BC002B11_A176EmpCP = new String[] {""} ;
      BC002B11_n176EmpCP = new boolean[] {false} ;
      BC002B11_A312PaiNom = new String[] {""} ;
      BC002B11_A322ProvNom = new String[] {""} ;
      BC002B11_A286LocNom = new String[] {""} ;
      BC002B11_A108ActDescrip = new String[] {""} ;
      BC002B11_A518EmpZonDescrip = new String[] {""} ;
      BC002B11_A532EmpReducc = new boolean[] {false} ;
      BC002B11_A530TipEmpleDefIns = new String[] {""} ;
      BC002B11_A46PaiCod = new short[1] ;
      BC002B11_n46PaiCod = new boolean[] {false} ;
      BC002B11_A47ProvCod = new short[1] ;
      BC002B11_n47ProvCod = new boolean[] {false} ;
      BC002B11_A48LocCod = new short[1] ;
      BC002B11_n48LocCod = new boolean[] {false} ;
      BC002B11_A3CliCod = new int[1] ;
      BC002B11_A43ActCodigo = new String[] {""} ;
      BC002B11_n43ActCodigo = new boolean[] {false} ;
      BC002B11_A45TipEmpleCod = new String[] {""} ;
      BC002B11_n45TipEmpleCod = new boolean[] {false} ;
      BC002B11_A44EmpZonCod = new String[] {""} ;
      BC002B11_n44EmpZonCod = new boolean[] {false} ;
      BC002B12_A3CliCod = new int[1] ;
      BC002B13_A312PaiNom = new String[] {""} ;
      BC002B14_A322ProvNom = new String[] {""} ;
      BC002B15_A286LocNom = new String[] {""} ;
      BC002B16_A683ActDescripSinAc = new String[] {""} ;
      BC002B16_A108ActDescrip = new String[] {""} ;
      BC002B17_A530TipEmpleDefIns = new String[] {""} ;
      BC002B18_A518EmpZonDescrip = new String[] {""} ;
      BC002B19_A3CliCod = new int[1] ;
      BC002B19_A1EmpCod = new short[1] ;
      BC002B20_A1EmpCod = new short[1] ;
      BC002B20_A2EmpNom = new String[] {""} ;
      BC002B20_A177EmpCUIT = new long[1] ;
      BC002B20_A125CatIvaCod = new short[1] ;
      BC002B20_n125CatIvaCod = new boolean[] {false} ;
      BC002B20_A126CatIvaDesc = new String[] {""} ;
      BC002B20_n126CatIvaDesc = new boolean[] {false} ;
      BC002B20_A178EmpDir = new String[] {""} ;
      BC002B20_A180EmpTel = new String[] {""} ;
      BC002B20_n180EmpTel = new boolean[] {false} ;
      BC002B20_A176EmpCP = new String[] {""} ;
      BC002B20_n176EmpCP = new boolean[] {false} ;
      BC002B20_A532EmpReducc = new boolean[] {false} ;
      BC002B20_A46PaiCod = new short[1] ;
      BC002B20_n46PaiCod = new boolean[] {false} ;
      BC002B20_A47ProvCod = new short[1] ;
      BC002B20_n47ProvCod = new boolean[] {false} ;
      BC002B20_A48LocCod = new short[1] ;
      BC002B20_n48LocCod = new boolean[] {false} ;
      BC002B20_A3CliCod = new int[1] ;
      BC002B20_A43ActCodigo = new String[] {""} ;
      BC002B20_n43ActCodigo = new boolean[] {false} ;
      BC002B20_A45TipEmpleCod = new String[] {""} ;
      BC002B20_n45TipEmpleCod = new boolean[] {false} ;
      BC002B20_A44EmpZonCod = new String[] {""} ;
      BC002B20_n44EmpZonCod = new boolean[] {false} ;
      sMode13 = "" ;
      BC002B21_A1EmpCod = new short[1] ;
      BC002B21_A2EmpNom = new String[] {""} ;
      BC002B21_A177EmpCUIT = new long[1] ;
      BC002B21_A125CatIvaCod = new short[1] ;
      BC002B21_n125CatIvaCod = new boolean[] {false} ;
      BC002B21_A126CatIvaDesc = new String[] {""} ;
      BC002B21_n126CatIvaDesc = new boolean[] {false} ;
      BC002B21_A178EmpDir = new String[] {""} ;
      BC002B21_A180EmpTel = new String[] {""} ;
      BC002B21_n180EmpTel = new boolean[] {false} ;
      BC002B21_A176EmpCP = new String[] {""} ;
      BC002B21_n176EmpCP = new boolean[] {false} ;
      BC002B21_A532EmpReducc = new boolean[] {false} ;
      BC002B21_A46PaiCod = new short[1] ;
      BC002B21_n46PaiCod = new boolean[] {false} ;
      BC002B21_A47ProvCod = new short[1] ;
      BC002B21_n47ProvCod = new boolean[] {false} ;
      BC002B21_A48LocCod = new short[1] ;
      BC002B21_n48LocCod = new boolean[] {false} ;
      BC002B21_A3CliCod = new int[1] ;
      BC002B21_A43ActCodigo = new String[] {""} ;
      BC002B21_n43ActCodigo = new boolean[] {false} ;
      BC002B21_A45TipEmpleCod = new String[] {""} ;
      BC002B21_n45TipEmpleCod = new boolean[] {false} ;
      BC002B21_A44EmpZonCod = new String[] {""} ;
      BC002B21_n44EmpZonCod = new boolean[] {false} ;
      BC002B25_A312PaiNom = new String[] {""} ;
      BC002B26_A322ProvNom = new String[] {""} ;
      BC002B27_A286LocNom = new String[] {""} ;
      BC002B28_A683ActDescripSinAc = new String[] {""} ;
      BC002B28_A108ActDescrip = new String[] {""} ;
      BC002B29_A530TipEmpleDefIns = new String[] {""} ;
      BC002B30_A518EmpZonDescrip = new String[] {""} ;
      BC002B31_A3CliCod = new int[1] ;
      BC002B31_A1EmpCod = new short[1] ;
      BC002B31_A2418BanSalCod = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC002B32_A3CliCod = new int[1] ;
      BC002B32_A1EmpCod = new short[1] ;
      BC002B32_A2380ColaUUID = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      BC002B33_A3CliCod = new int[1] ;
      BC002B33_A1EmpCod = new short[1] ;
      BC002B33_A2371LiqBatchLiqNro = new int[1] ;
      BC002B33_A2372LiqBatchCod = new String[] {""} ;
      BC002B33_A2373LiqBatchSeccion = new String[] {""} ;
      BC002B34_A3CliCod = new int[1] ;
      BC002B34_A1EmpCod = new short[1] ;
      BC002B34_A2370LiqLoteLiqNro = new int[1] ;
      BC002B34_A2269LiqLote = new String[] {""} ;
      BC002B35_A3CliCod = new int[1] ;
      BC002B35_A1EmpCod = new short[1] ;
      BC002B35_A31LiqNro = new int[1] ;
      BC002B35_A2285LinkLegNumero = new int[1] ;
      BC002B35_A2277LegLinkTiporec = new String[] {""} ;
      BC002B36_A3CliCod = new int[1] ;
      BC002B36_A1EmpCod = new short[1] ;
      BC002B36_A31LiqNro = new int[1] ;
      BC002B36_A2183LiqSuc = new String[] {""} ;
      BC002B37_A3CliCod = new int[1] ;
      BC002B37_A1EmpCod = new short[1] ;
      BC002B37_A31LiqNro = new int[1] ;
      BC002B37_A2145LiqArea = new String[] {""} ;
      BC002B38_A3CliCod = new int[1] ;
      BC002B38_A1EmpCod = new short[1] ;
      BC002B38_A31LiqNro = new int[1] ;
      BC002B38_A2142LiqPaiConve = new short[1] ;
      BC002B38_A2143LiqConvenio = new String[] {""} ;
      BC002B39_A3CliCod = new int[1] ;
      BC002B39_A1EmpCod = new short[1] ;
      BC002B39_A1966EmpBanCod = new String[] {""} ;
      BC002B40_A3CliCod = new int[1] ;
      BC002B40_A1EmpCod = new short[1] ;
      BC002B40_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      BC002B41_A3CliCod = new int[1] ;
      BC002B41_A1EmpCod = new short[1] ;
      BC002B41_A1649LSDSec = new int[1] ;
      BC002B42_A3CliCod = new int[1] ;
      BC002B42_A1EmpCod = new short[1] ;
      BC002B42_A1562EmpConvePai = new short[1] ;
      BC002B42_A1561EmpConveCod = new String[] {""} ;
      BC002B43_A3CliCod = new int[1] ;
      BC002B43_A1EmpCod = new short[1] ;
      BC002B43_A1562EmpConvePai = new short[1] ;
      BC002B43_A1561EmpConveCod = new String[] {""} ;
      BC002B44_A3CliCod = new int[1] ;
      BC002B44_A1EmpCod = new short[1] ;
      BC002B44_A1562EmpConvePai = new short[1] ;
      BC002B44_A1561EmpConveCod = new String[] {""} ;
      BC002B45_A3CliCod = new int[1] ;
      BC002B45_A1EmpCod = new short[1] ;
      BC002B45_A1562EmpConvePai = new short[1] ;
      BC002B45_A1561EmpConveCod = new String[] {""} ;
      BC002B46_A3CliCod = new int[1] ;
      BC002B46_A1EmpCod = new short[1] ;
      BC002B46_A1562EmpConvePai = new short[1] ;
      BC002B46_A1561EmpConveCod = new String[] {""} ;
      BC002B47_A3CliCod = new int[1] ;
      BC002B47_A1EmpCod = new short[1] ;
      BC002B47_A1562EmpConvePai = new short[1] ;
      BC002B47_A1561EmpConveCod = new String[] {""} ;
      BC002B48_A3CliCod = new int[1] ;
      BC002B48_A1EmpCod = new short[1] ;
      BC002B48_A1562EmpConvePai = new short[1] ;
      BC002B48_A1561EmpConveCod = new String[] {""} ;
      BC002B49_A3CliCod = new int[1] ;
      BC002B49_A1EmpCod = new short[1] ;
      BC002B49_A1562EmpConvePai = new short[1] ;
      BC002B49_A1561EmpConveCod = new String[] {""} ;
      BC002B50_A3CliCod = new int[1] ;
      BC002B50_A1EmpCod = new short[1] ;
      BC002B50_A1562EmpConvePai = new short[1] ;
      BC002B50_A1561EmpConveCod = new String[] {""} ;
      BC002B51_A3CliCod = new int[1] ;
      BC002B51_A1EmpCod = new short[1] ;
      BC002B51_A1562EmpConvePai = new short[1] ;
      BC002B51_A1561EmpConveCod = new String[] {""} ;
      BC002B52_A3CliCod = new int[1] ;
      BC002B52_A1EmpCod = new short[1] ;
      BC002B52_A1562EmpConvePai = new short[1] ;
      BC002B52_A1561EmpConveCod = new String[] {""} ;
      BC002B53_A3CliCod = new int[1] ;
      BC002B53_A1EmpCod = new short[1] ;
      BC002B53_A1562EmpConvePai = new short[1] ;
      BC002B53_A1561EmpConveCod = new String[] {""} ;
      BC002B54_A3CliCod = new int[1] ;
      BC002B54_A1EmpCod = new short[1] ;
      BC002B54_A1562EmpConvePai = new short[1] ;
      BC002B54_A1561EmpConveCod = new String[] {""} ;
      BC002B55_A3CliCod = new int[1] ;
      BC002B55_A1EmpCod = new short[1] ;
      BC002B55_A1562EmpConvePai = new short[1] ;
      BC002B55_A1561EmpConveCod = new String[] {""} ;
      BC002B56_A3CliCod = new int[1] ;
      BC002B56_A1EmpCod = new short[1] ;
      BC002B56_A1562EmpConvePai = new short[1] ;
      BC002B56_A1561EmpConveCod = new String[] {""} ;
      BC002B57_A3CliCod = new int[1] ;
      BC002B57_A1EmpCod = new short[1] ;
      BC002B57_A1562EmpConvePai = new short[1] ;
      BC002B57_A1561EmpConveCod = new String[] {""} ;
      BC002B58_A3CliCod = new int[1] ;
      BC002B58_A1EmpCod = new short[1] ;
      BC002B58_A1562EmpConvePai = new short[1] ;
      BC002B58_A1561EmpConveCod = new String[] {""} ;
      BC002B59_A3CliCod = new int[1] ;
      BC002B59_A1EmpCod = new short[1] ;
      BC002B59_A1562EmpConvePai = new short[1] ;
      BC002B59_A1561EmpConveCod = new String[] {""} ;
      BC002B60_A3CliCod = new int[1] ;
      BC002B60_A1EmpCod = new short[1] ;
      BC002B60_A1562EmpConvePai = new short[1] ;
      BC002B60_A1561EmpConveCod = new String[] {""} ;
      BC002B61_A3CliCod = new int[1] ;
      BC002B61_A1EmpCod = new short[1] ;
      BC002B61_A1562EmpConvePai = new short[1] ;
      BC002B61_A1561EmpConveCod = new String[] {""} ;
      BC002B62_A3CliCod = new int[1] ;
      BC002B62_A1EmpCod = new short[1] ;
      BC002B62_A1562EmpConvePai = new short[1] ;
      BC002B62_A1561EmpConveCod = new String[] {""} ;
      BC002B63_A3CliCod = new int[1] ;
      BC002B63_A1EmpCod = new short[1] ;
      BC002B63_A1562EmpConvePai = new short[1] ;
      BC002B63_A1561EmpConveCod = new String[] {""} ;
      BC002B64_A3CliCod = new int[1] ;
      BC002B64_A1EmpCod = new short[1] ;
      BC002B64_A1562EmpConvePai = new short[1] ;
      BC002B64_A1561EmpConveCod = new String[] {""} ;
      BC002B65_A3CliCod = new int[1] ;
      BC002B65_A1EmpCod = new short[1] ;
      BC002B65_A1562EmpConvePai = new short[1] ;
      BC002B65_A1561EmpConveCod = new String[] {""} ;
      BC002B66_A3CliCod = new int[1] ;
      BC002B66_A1EmpCod = new short[1] ;
      BC002B66_A1562EmpConvePai = new short[1] ;
      BC002B66_A1561EmpConveCod = new String[] {""} ;
      BC002B67_A3CliCod = new int[1] ;
      BC002B67_A1EmpCod = new short[1] ;
      BC002B67_A1562EmpConvePai = new short[1] ;
      BC002B67_A1561EmpConveCod = new String[] {""} ;
      BC002B68_A3CliCod = new int[1] ;
      BC002B68_A1EmpCod = new short[1] ;
      BC002B68_A1562EmpConvePai = new short[1] ;
      BC002B68_A1561EmpConveCod = new String[] {""} ;
      BC002B69_A3CliCod = new int[1] ;
      BC002B69_A1EmpCod = new short[1] ;
      BC002B69_A1562EmpConvePai = new short[1] ;
      BC002B69_A1561EmpConveCod = new String[] {""} ;
      BC002B70_A3CliCod = new int[1] ;
      BC002B70_A1EmpCod = new short[1] ;
      BC002B70_A1562EmpConvePai = new short[1] ;
      BC002B70_A1561EmpConveCod = new String[] {""} ;
      BC002B71_A3CliCod = new int[1] ;
      BC002B71_A1EmpCod = new short[1] ;
      BC002B71_A1562EmpConvePai = new short[1] ;
      BC002B71_A1561EmpConveCod = new String[] {""} ;
      BC002B72_A3CliCod = new int[1] ;
      BC002B72_A1EmpCod = new short[1] ;
      BC002B72_A1562EmpConvePai = new short[1] ;
      BC002B72_A1561EmpConveCod = new String[] {""} ;
      BC002B73_A3CliCod = new int[1] ;
      BC002B73_A1EmpCod = new short[1] ;
      BC002B73_A1562EmpConvePai = new short[1] ;
      BC002B73_A1561EmpConveCod = new String[] {""} ;
      BC002B74_A3CliCod = new int[1] ;
      BC002B74_A1EmpCod = new short[1] ;
      BC002B74_A1562EmpConvePai = new short[1] ;
      BC002B74_A1561EmpConveCod = new String[] {""} ;
      BC002B75_A3CliCod = new int[1] ;
      BC002B75_A1EmpCod = new short[1] ;
      BC002B75_A1562EmpConvePai = new short[1] ;
      BC002B75_A1561EmpConveCod = new String[] {""} ;
      BC002B76_A3CliCod = new int[1] ;
      BC002B76_A1EmpCod = new short[1] ;
      BC002B76_A1562EmpConvePai = new short[1] ;
      BC002B76_A1561EmpConveCod = new String[] {""} ;
      BC002B77_A3CliCod = new int[1] ;
      BC002B77_A1EmpCod = new short[1] ;
      BC002B77_A1562EmpConvePai = new short[1] ;
      BC002B77_A1561EmpConveCod = new String[] {""} ;
      BC002B78_A3CliCod = new int[1] ;
      BC002B78_A1EmpCod = new short[1] ;
      BC002B78_A1562EmpConvePai = new short[1] ;
      BC002B78_A1561EmpConveCod = new String[] {""} ;
      BC002B79_A3CliCod = new int[1] ;
      BC002B79_A1EmpCod = new short[1] ;
      BC002B79_A1562EmpConvePai = new short[1] ;
      BC002B79_A1561EmpConveCod = new String[] {""} ;
      BC002B80_A3CliCod = new int[1] ;
      BC002B80_A1EmpCod = new short[1] ;
      BC002B80_A1562EmpConvePai = new short[1] ;
      BC002B80_A1561EmpConveCod = new String[] {""} ;
      BC002B81_A3CliCod = new int[1] ;
      BC002B81_A1EmpCod = new short[1] ;
      BC002B81_A1562EmpConvePai = new short[1] ;
      BC002B81_A1561EmpConveCod = new String[] {""} ;
      BC002B82_A3CliCod = new int[1] ;
      BC002B82_A1EmpCod = new short[1] ;
      BC002B82_A1562EmpConvePai = new short[1] ;
      BC002B82_A1561EmpConveCod = new String[] {""} ;
      BC002B83_A3CliCod = new int[1] ;
      BC002B83_A1EmpCod = new short[1] ;
      BC002B83_A1562EmpConvePai = new short[1] ;
      BC002B83_A1561EmpConveCod = new String[] {""} ;
      BC002B84_A3CliCod = new int[1] ;
      BC002B84_A1EmpCod = new short[1] ;
      BC002B84_A1562EmpConvePai = new short[1] ;
      BC002B84_A1561EmpConveCod = new String[] {""} ;
      BC002B85_A3CliCod = new int[1] ;
      BC002B85_A1EmpCod = new short[1] ;
      BC002B85_A1562EmpConvePai = new short[1] ;
      BC002B85_A1561EmpConveCod = new String[] {""} ;
      BC002B86_A3CliCod = new int[1] ;
      BC002B86_A1EmpCod = new short[1] ;
      BC002B86_A1562EmpConvePai = new short[1] ;
      BC002B86_A1561EmpConveCod = new String[] {""} ;
      BC002B87_A3CliCod = new int[1] ;
      BC002B87_A1EmpCod = new short[1] ;
      BC002B87_A1562EmpConvePai = new short[1] ;
      BC002B87_A1561EmpConveCod = new String[] {""} ;
      BC002B88_A3CliCod = new int[1] ;
      BC002B88_A1EmpCod = new short[1] ;
      BC002B88_A1562EmpConvePai = new short[1] ;
      BC002B88_A1561EmpConveCod = new String[] {""} ;
      BC002B89_A3CliCod = new int[1] ;
      BC002B89_A1EmpCod = new short[1] ;
      BC002B89_A1562EmpConvePai = new short[1] ;
      BC002B89_A1561EmpConveCod = new String[] {""} ;
      BC002B90_A3CliCod = new int[1] ;
      BC002B90_A1EmpCod = new short[1] ;
      BC002B90_A1562EmpConvePai = new short[1] ;
      BC002B90_A1561EmpConveCod = new String[] {""} ;
      BC002B91_A3CliCod = new int[1] ;
      BC002B91_A1EmpCod = new short[1] ;
      BC002B91_A1562EmpConvePai = new short[1] ;
      BC002B91_A1561EmpConveCod = new String[] {""} ;
      BC002B92_A3CliCod = new int[1] ;
      BC002B92_A1EmpCod = new short[1] ;
      BC002B92_A1562EmpConvePai = new short[1] ;
      BC002B92_A1561EmpConveCod = new String[] {""} ;
      BC002B93_A3CliCod = new int[1] ;
      BC002B93_A1EmpCod = new short[1] ;
      BC002B93_A1562EmpConvePai = new short[1] ;
      BC002B93_A1561EmpConveCod = new String[] {""} ;
      BC002B94_A3CliCod = new int[1] ;
      BC002B94_A1EmpCod = new short[1] ;
      BC002B94_A1562EmpConvePai = new short[1] ;
      BC002B94_A1561EmpConveCod = new String[] {""} ;
      BC002B95_A3CliCod = new int[1] ;
      BC002B95_A1EmpCod = new short[1] ;
      BC002B95_A1562EmpConvePai = new short[1] ;
      BC002B95_A1561EmpConveCod = new String[] {""} ;
      BC002B96_A3CliCod = new int[1] ;
      BC002B96_A1EmpCod = new short[1] ;
      BC002B96_A1562EmpConvePai = new short[1] ;
      BC002B96_A1561EmpConveCod = new String[] {""} ;
      BC002B97_A3CliCod = new int[1] ;
      BC002B97_A1EmpCod = new short[1] ;
      BC002B97_A1562EmpConvePai = new short[1] ;
      BC002B97_A1561EmpConveCod = new String[] {""} ;
      BC002B98_A3CliCod = new int[1] ;
      BC002B98_A1EmpCod = new short[1] ;
      BC002B98_A1547GuarCod = new short[1] ;
      BC002B99_A3CliCod = new int[1] ;
      BC002B99_A1EmpCod = new short[1] ;
      BC002B99_A1427EmpBaseClaseLeg = new byte[1] ;
      BC002B99_A1429EmpBaseTipo = new String[] {""} ;
      BC002B99_A1430EmpBaseCod1 = new String[] {""} ;
      BC002B99_A1431EmpBaseCod2 = new String[] {""} ;
      BC002B100_A3CliCod = new int[1] ;
      BC002B100_A1EmpCod = new short[1] ;
      BC002B100_A37TipoConCod = new String[] {""} ;
      BC002B100_A1371EmpPromFijVar = new String[] {""} ;
      BC002B101_A3CliCod = new int[1] ;
      BC002B101_A1EmpCod = new short[1] ;
      BC002B101_A1366EmpJorConCodigo = new String[] {""} ;
      BC002B102_A3CliCod = new int[1] ;
      BC002B102_A1EmpCod = new short[1] ;
      BC002B102_A1368EmpMenConCodigo = new String[] {""} ;
      BC002B103_A3CliCod = new int[1] ;
      BC002B103_A1EmpCod = new short[1] ;
      BC002B103_A1294PaiTipoTraId = new String[] {""} ;
      BC002B104_A3CliCod = new int[1] ;
      BC002B104_A1EmpCod = new short[1] ;
      BC002B104_A1340EmpHsExSec = new short[1] ;
      BC002B105_A3CliCod = new int[1] ;
      BC002B105_A1EmpCod = new short[1] ;
      BC002B105_A1243SucCodigo = new String[] {""} ;
      BC002B106_A3CliCod = new int[1] ;
      BC002B106_A1EmpCod = new short[1] ;
      BC002B106_A1237EmpReligion = new String[] {""} ;
      BC002B107_A3CliCod = new int[1] ;
      BC002B107_A1EmpCod = new short[1] ;
      BC002B107_A1238EmpOrigen = new String[] {""} ;
      BC002B108_A3CliCod = new int[1] ;
      BC002B108_A1EmpCod = new short[1] ;
      BC002B108_A1239EmpConvenio = new String[] {""} ;
      BC002B109_A3CliCod = new int[1] ;
      BC002B109_A1EmpCod = new short[1] ;
      BC002B109_A784F1357CTipoPre = new byte[1] ;
      BC002B109_A777F1357CPer = new String[] {""} ;
      BC002B109_A778F1357CSec = new byte[1] ;
      BC002B110_A3CliCod = new int[1] ;
      BC002B110_A1EmpCod = new short[1] ;
      BC002B110_A88ImpLiqSec = new short[1] ;
      BC002B111_A3CliCod = new int[1] ;
      BC002B111_A1EmpCod = new short[1] ;
      BC002B111_A87MigrLegNumero = new int[1] ;
      BC002B112_A3CliCod = new int[1] ;
      BC002B112_A1EmpCod = new short[1] ;
      BC002B112_A86TempRecSec = new short[1] ;
      BC002B113_A3CliCod = new int[1] ;
      BC002B113_A1EmpCod = new short[1] ;
      BC002B113_A85ArchSiradigFec = new java.util.Date[] {GXutil.nullDate()} ;
      BC002B114_A3CliCod = new int[1] ;
      BC002B114_A1EmpCod = new short[1] ;
      BC002B114_A79AsientoCNum = new int[1] ;
      BC002B115_A3CliCod = new int[1] ;
      BC002B115_A1EmpCod = new short[1] ;
      BC002B115_A78CuenCodigo = new String[] {""} ;
      BC002B116_A3CliCod = new int[1] ;
      BC002B116_A1EmpCod = new short[1] ;
      BC002B116_A77CenCodigo = new short[1] ;
      BC002B117_A3CliCod = new int[1] ;
      BC002B117_A1EmpCod = new short[1] ;
      BC002B117_A31LiqNro = new int[1] ;
      BC002B117_A10LpgCodigo = new String[] {""} ;
      BC002B118_A3CliCod = new int[1] ;
      BC002B118_A1EmpCod = new short[1] ;
      BC002B118_A6LegNumero = new int[1] ;
      BC002B119_A683ActDescripSinAc = new String[] {""} ;
      BC002B119_A1EmpCod = new short[1] ;
      BC002B119_A2EmpNom = new String[] {""} ;
      BC002B119_A177EmpCUIT = new long[1] ;
      BC002B119_A125CatIvaCod = new short[1] ;
      BC002B119_n125CatIvaCod = new boolean[] {false} ;
      BC002B119_A126CatIvaDesc = new String[] {""} ;
      BC002B119_n126CatIvaDesc = new boolean[] {false} ;
      BC002B119_A178EmpDir = new String[] {""} ;
      BC002B119_A180EmpTel = new String[] {""} ;
      BC002B119_n180EmpTel = new boolean[] {false} ;
      BC002B119_A176EmpCP = new String[] {""} ;
      BC002B119_n176EmpCP = new boolean[] {false} ;
      BC002B119_A312PaiNom = new String[] {""} ;
      BC002B119_A322ProvNom = new String[] {""} ;
      BC002B119_A286LocNom = new String[] {""} ;
      BC002B119_A108ActDescrip = new String[] {""} ;
      BC002B119_A518EmpZonDescrip = new String[] {""} ;
      BC002B119_A532EmpReducc = new boolean[] {false} ;
      BC002B119_A530TipEmpleDefIns = new String[] {""} ;
      BC002B119_A46PaiCod = new short[1] ;
      BC002B119_n46PaiCod = new boolean[] {false} ;
      BC002B119_A47ProvCod = new short[1] ;
      BC002B119_n47ProvCod = new boolean[] {false} ;
      BC002B119_A48LocCod = new short[1] ;
      BC002B119_n48LocCod = new boolean[] {false} ;
      BC002B119_A3CliCod = new int[1] ;
      BC002B119_A43ActCodigo = new String[] {""} ;
      BC002B119_n43ActCodigo = new boolean[] {false} ;
      BC002B119_A45TipEmpleCod = new String[] {""} ;
      BC002B119_n45TipEmpleCod = new boolean[] {false} ;
      BC002B119_A44EmpZonCod = new String[] {""} ;
      BC002B119_n44EmpZonCod = new boolean[] {false} ;
      GXv_int8 = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC002B120_A3CliCod = new int[1] ;
      BC002B121_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liqimportarauxtrn_bc__default(),
         new Object[] {
             new Object[] {
            BC002B2_A1EmpCod, BC002B2_A2EmpNom, BC002B2_A177EmpCUIT, BC002B2_A125CatIvaCod, BC002B2_n125CatIvaCod, BC002B2_A126CatIvaDesc, BC002B2_n126CatIvaDesc, BC002B2_A178EmpDir, BC002B2_A180EmpTel, BC002B2_n180EmpTel,
            BC002B2_A176EmpCP, BC002B2_n176EmpCP, BC002B2_A532EmpReducc, BC002B2_A46PaiCod, BC002B2_n46PaiCod, BC002B2_A47ProvCod, BC002B2_n47ProvCod, BC002B2_A48LocCod, BC002B2_n48LocCod, BC002B2_A3CliCod,
            BC002B2_A43ActCodigo, BC002B2_n43ActCodigo, BC002B2_A45TipEmpleCod, BC002B2_n45TipEmpleCod, BC002B2_A44EmpZonCod, BC002B2_n44EmpZonCod
            }
            , new Object[] {
            BC002B3_A1EmpCod, BC002B3_A2EmpNom, BC002B3_A177EmpCUIT, BC002B3_A125CatIvaCod, BC002B3_n125CatIvaCod, BC002B3_A126CatIvaDesc, BC002B3_n126CatIvaDesc, BC002B3_A178EmpDir, BC002B3_A180EmpTel, BC002B3_n180EmpTel,
            BC002B3_A176EmpCP, BC002B3_n176EmpCP, BC002B3_A532EmpReducc, BC002B3_A46PaiCod, BC002B3_n46PaiCod, BC002B3_A47ProvCod, BC002B3_n47ProvCod, BC002B3_A48LocCod, BC002B3_n48LocCod, BC002B3_A3CliCod,
            BC002B3_A43ActCodigo, BC002B3_n43ActCodigo, BC002B3_A45TipEmpleCod, BC002B3_n45TipEmpleCod, BC002B3_A44EmpZonCod, BC002B3_n44EmpZonCod
            }
            , new Object[] {
            BC002B4_A312PaiNom
            }
            , new Object[] {
            BC002B5_A322ProvNom
            }
            , new Object[] {
            BC002B6_A286LocNom
            }
            , new Object[] {
            BC002B7_A3CliCod
            }
            , new Object[] {
            BC002B8_A683ActDescripSinAc, BC002B8_A108ActDescrip
            }
            , new Object[] {
            BC002B9_A530TipEmpleDefIns
            }
            , new Object[] {
            BC002B10_A518EmpZonDescrip
            }
            , new Object[] {
            BC002B11_A683ActDescripSinAc, BC002B11_A1EmpCod, BC002B11_A2EmpNom, BC002B11_A177EmpCUIT, BC002B11_A125CatIvaCod, BC002B11_n125CatIvaCod, BC002B11_A126CatIvaDesc, BC002B11_n126CatIvaDesc, BC002B11_A178EmpDir, BC002B11_A180EmpTel,
            BC002B11_n180EmpTel, BC002B11_A176EmpCP, BC002B11_n176EmpCP, BC002B11_A312PaiNom, BC002B11_A322ProvNom, BC002B11_A286LocNom, BC002B11_A108ActDescrip, BC002B11_A518EmpZonDescrip, BC002B11_A532EmpReducc, BC002B11_A530TipEmpleDefIns,
            BC002B11_A46PaiCod, BC002B11_n46PaiCod, BC002B11_A47ProvCod, BC002B11_n47ProvCod, BC002B11_A48LocCod, BC002B11_n48LocCod, BC002B11_A3CliCod, BC002B11_A43ActCodigo, BC002B11_n43ActCodigo, BC002B11_A45TipEmpleCod,
            BC002B11_n45TipEmpleCod, BC002B11_A44EmpZonCod, BC002B11_n44EmpZonCod
            }
            , new Object[] {
            BC002B12_A3CliCod
            }
            , new Object[] {
            BC002B13_A312PaiNom
            }
            , new Object[] {
            BC002B14_A322ProvNom
            }
            , new Object[] {
            BC002B15_A286LocNom
            }
            , new Object[] {
            BC002B16_A683ActDescripSinAc, BC002B16_A108ActDescrip
            }
            , new Object[] {
            BC002B17_A530TipEmpleDefIns
            }
            , new Object[] {
            BC002B18_A518EmpZonDescrip
            }
            , new Object[] {
            BC002B19_A3CliCod, BC002B19_A1EmpCod
            }
            , new Object[] {
            BC002B20_A1EmpCod, BC002B20_A2EmpNom, BC002B20_A177EmpCUIT, BC002B20_A125CatIvaCod, BC002B20_n125CatIvaCod, BC002B20_A126CatIvaDesc, BC002B20_n126CatIvaDesc, BC002B20_A178EmpDir, BC002B20_A180EmpTel, BC002B20_n180EmpTel,
            BC002B20_A176EmpCP, BC002B20_n176EmpCP, BC002B20_A532EmpReducc, BC002B20_A46PaiCod, BC002B20_n46PaiCod, BC002B20_A47ProvCod, BC002B20_n47ProvCod, BC002B20_A48LocCod, BC002B20_n48LocCod, BC002B20_A3CliCod,
            BC002B20_A43ActCodigo, BC002B20_n43ActCodigo, BC002B20_A45TipEmpleCod, BC002B20_n45TipEmpleCod, BC002B20_A44EmpZonCod, BC002B20_n44EmpZonCod
            }
            , new Object[] {
            BC002B21_A1EmpCod, BC002B21_A2EmpNom, BC002B21_A177EmpCUIT, BC002B21_A125CatIvaCod, BC002B21_n125CatIvaCod, BC002B21_A126CatIvaDesc, BC002B21_n126CatIvaDesc, BC002B21_A178EmpDir, BC002B21_A180EmpTel, BC002B21_n180EmpTel,
            BC002B21_A176EmpCP, BC002B21_n176EmpCP, BC002B21_A532EmpReducc, BC002B21_A46PaiCod, BC002B21_n46PaiCod, BC002B21_A47ProvCod, BC002B21_n47ProvCod, BC002B21_A48LocCod, BC002B21_n48LocCod, BC002B21_A3CliCod,
            BC002B21_A43ActCodigo, BC002B21_n43ActCodigo, BC002B21_A45TipEmpleCod, BC002B21_n45TipEmpleCod, BC002B21_A44EmpZonCod, BC002B21_n44EmpZonCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC002B25_A312PaiNom
            }
            , new Object[] {
            BC002B26_A322ProvNom
            }
            , new Object[] {
            BC002B27_A286LocNom
            }
            , new Object[] {
            BC002B28_A683ActDescripSinAc, BC002B28_A108ActDescrip
            }
            , new Object[] {
            BC002B29_A530TipEmpleDefIns
            }
            , new Object[] {
            BC002B30_A518EmpZonDescrip
            }
            , new Object[] {
            BC002B31_A3CliCod, BC002B31_A1EmpCod, BC002B31_A2418BanSalCod
            }
            , new Object[] {
            BC002B32_A3CliCod, BC002B32_A1EmpCod, BC002B32_A2380ColaUUID
            }
            , new Object[] {
            BC002B33_A3CliCod, BC002B33_A1EmpCod, BC002B33_A2371LiqBatchLiqNro, BC002B33_A2372LiqBatchCod, BC002B33_A2373LiqBatchSeccion
            }
            , new Object[] {
            BC002B34_A3CliCod, BC002B34_A1EmpCod, BC002B34_A2370LiqLoteLiqNro, BC002B34_A2269LiqLote
            }
            , new Object[] {
            BC002B35_A3CliCod, BC002B35_A1EmpCod, BC002B35_A31LiqNro, BC002B35_A2285LinkLegNumero, BC002B35_A2277LegLinkTiporec
            }
            , new Object[] {
            BC002B36_A3CliCod, BC002B36_A1EmpCod, BC002B36_A31LiqNro, BC002B36_A2183LiqSuc
            }
            , new Object[] {
            BC002B37_A3CliCod, BC002B37_A1EmpCod, BC002B37_A31LiqNro, BC002B37_A2145LiqArea
            }
            , new Object[] {
            BC002B38_A3CliCod, BC002B38_A1EmpCod, BC002B38_A31LiqNro, BC002B38_A2142LiqPaiConve, BC002B38_A2143LiqConvenio
            }
            , new Object[] {
            BC002B39_A3CliCod, BC002B39_A1EmpCod, BC002B39_A1966EmpBanCod
            }
            , new Object[] {
            BC002B40_A3CliCod, BC002B40_A1EmpCod, BC002B40_A1729PeriodoLiq
            }
            , new Object[] {
            BC002B41_A3CliCod, BC002B41_A1EmpCod, BC002B41_A1649LSDSec
            }
            , new Object[] {
            BC002B42_A3CliCod, BC002B42_A1EmpCod, BC002B42_A1562EmpConvePai, BC002B42_A1561EmpConveCod
            }
            , new Object[] {
            BC002B43_A3CliCod, BC002B43_A1EmpCod, BC002B43_A1562EmpConvePai, BC002B43_A1561EmpConveCod
            }
            , new Object[] {
            BC002B44_A3CliCod, BC002B44_A1EmpCod, BC002B44_A1562EmpConvePai, BC002B44_A1561EmpConveCod
            }
            , new Object[] {
            BC002B45_A3CliCod, BC002B45_A1EmpCod, BC002B45_A1562EmpConvePai, BC002B45_A1561EmpConveCod
            }
            , new Object[] {
            BC002B46_A3CliCod, BC002B46_A1EmpCod, BC002B46_A1562EmpConvePai, BC002B46_A1561EmpConveCod
            }
            , new Object[] {
            BC002B47_A3CliCod, BC002B47_A1EmpCod, BC002B47_A1562EmpConvePai, BC002B47_A1561EmpConveCod
            }
            , new Object[] {
            BC002B48_A3CliCod, BC002B48_A1EmpCod, BC002B48_A1562EmpConvePai, BC002B48_A1561EmpConveCod
            }
            , new Object[] {
            BC002B49_A3CliCod, BC002B49_A1EmpCod, BC002B49_A1562EmpConvePai, BC002B49_A1561EmpConveCod
            }
            , new Object[] {
            BC002B50_A3CliCod, BC002B50_A1EmpCod, BC002B50_A1562EmpConvePai, BC002B50_A1561EmpConveCod
            }
            , new Object[] {
            BC002B51_A3CliCod, BC002B51_A1EmpCod, BC002B51_A1562EmpConvePai, BC002B51_A1561EmpConveCod
            }
            , new Object[] {
            BC002B52_A3CliCod, BC002B52_A1EmpCod, BC002B52_A1562EmpConvePai, BC002B52_A1561EmpConveCod
            }
            , new Object[] {
            BC002B53_A3CliCod, BC002B53_A1EmpCod, BC002B53_A1562EmpConvePai, BC002B53_A1561EmpConveCod
            }
            , new Object[] {
            BC002B54_A3CliCod, BC002B54_A1EmpCod, BC002B54_A1562EmpConvePai, BC002B54_A1561EmpConveCod
            }
            , new Object[] {
            BC002B55_A3CliCod, BC002B55_A1EmpCod, BC002B55_A1562EmpConvePai, BC002B55_A1561EmpConveCod
            }
            , new Object[] {
            BC002B56_A3CliCod, BC002B56_A1EmpCod, BC002B56_A1562EmpConvePai, BC002B56_A1561EmpConveCod
            }
            , new Object[] {
            BC002B57_A3CliCod, BC002B57_A1EmpCod, BC002B57_A1562EmpConvePai, BC002B57_A1561EmpConveCod
            }
            , new Object[] {
            BC002B58_A3CliCod, BC002B58_A1EmpCod, BC002B58_A1562EmpConvePai, BC002B58_A1561EmpConveCod
            }
            , new Object[] {
            BC002B59_A3CliCod, BC002B59_A1EmpCod, BC002B59_A1562EmpConvePai, BC002B59_A1561EmpConveCod
            }
            , new Object[] {
            BC002B60_A3CliCod, BC002B60_A1EmpCod, BC002B60_A1562EmpConvePai, BC002B60_A1561EmpConveCod
            }
            , new Object[] {
            BC002B61_A3CliCod, BC002B61_A1EmpCod, BC002B61_A1562EmpConvePai, BC002B61_A1561EmpConveCod
            }
            , new Object[] {
            BC002B62_A3CliCod, BC002B62_A1EmpCod, BC002B62_A1562EmpConvePai, BC002B62_A1561EmpConveCod
            }
            , new Object[] {
            BC002B63_A3CliCod, BC002B63_A1EmpCod, BC002B63_A1562EmpConvePai, BC002B63_A1561EmpConveCod
            }
            , new Object[] {
            BC002B64_A3CliCod, BC002B64_A1EmpCod, BC002B64_A1562EmpConvePai, BC002B64_A1561EmpConveCod
            }
            , new Object[] {
            BC002B65_A3CliCod, BC002B65_A1EmpCod, BC002B65_A1562EmpConvePai, BC002B65_A1561EmpConveCod
            }
            , new Object[] {
            BC002B66_A3CliCod, BC002B66_A1EmpCod, BC002B66_A1562EmpConvePai, BC002B66_A1561EmpConveCod
            }
            , new Object[] {
            BC002B67_A3CliCod, BC002B67_A1EmpCod, BC002B67_A1562EmpConvePai, BC002B67_A1561EmpConveCod
            }
            , new Object[] {
            BC002B68_A3CliCod, BC002B68_A1EmpCod, BC002B68_A1562EmpConvePai, BC002B68_A1561EmpConveCod
            }
            , new Object[] {
            BC002B69_A3CliCod, BC002B69_A1EmpCod, BC002B69_A1562EmpConvePai, BC002B69_A1561EmpConveCod
            }
            , new Object[] {
            BC002B70_A3CliCod, BC002B70_A1EmpCod, BC002B70_A1562EmpConvePai, BC002B70_A1561EmpConveCod
            }
            , new Object[] {
            BC002B71_A3CliCod, BC002B71_A1EmpCod, BC002B71_A1562EmpConvePai, BC002B71_A1561EmpConveCod
            }
            , new Object[] {
            BC002B72_A3CliCod, BC002B72_A1EmpCod, BC002B72_A1562EmpConvePai, BC002B72_A1561EmpConveCod
            }
            , new Object[] {
            BC002B73_A3CliCod, BC002B73_A1EmpCod, BC002B73_A1562EmpConvePai, BC002B73_A1561EmpConveCod
            }
            , new Object[] {
            BC002B74_A3CliCod, BC002B74_A1EmpCod, BC002B74_A1562EmpConvePai, BC002B74_A1561EmpConveCod
            }
            , new Object[] {
            BC002B75_A3CliCod, BC002B75_A1EmpCod, BC002B75_A1562EmpConvePai, BC002B75_A1561EmpConveCod
            }
            , new Object[] {
            BC002B76_A3CliCod, BC002B76_A1EmpCod, BC002B76_A1562EmpConvePai, BC002B76_A1561EmpConveCod
            }
            , new Object[] {
            BC002B77_A3CliCod, BC002B77_A1EmpCod, BC002B77_A1562EmpConvePai, BC002B77_A1561EmpConveCod
            }
            , new Object[] {
            BC002B78_A3CliCod, BC002B78_A1EmpCod, BC002B78_A1562EmpConvePai, BC002B78_A1561EmpConveCod
            }
            , new Object[] {
            BC002B79_A3CliCod, BC002B79_A1EmpCod, BC002B79_A1562EmpConvePai, BC002B79_A1561EmpConveCod
            }
            , new Object[] {
            BC002B80_A3CliCod, BC002B80_A1EmpCod, BC002B80_A1562EmpConvePai, BC002B80_A1561EmpConveCod
            }
            , new Object[] {
            BC002B81_A3CliCod, BC002B81_A1EmpCod, BC002B81_A1562EmpConvePai, BC002B81_A1561EmpConveCod
            }
            , new Object[] {
            BC002B82_A3CliCod, BC002B82_A1EmpCod, BC002B82_A1562EmpConvePai, BC002B82_A1561EmpConveCod
            }
            , new Object[] {
            BC002B83_A3CliCod, BC002B83_A1EmpCod, BC002B83_A1562EmpConvePai, BC002B83_A1561EmpConveCod
            }
            , new Object[] {
            BC002B84_A3CliCod, BC002B84_A1EmpCod, BC002B84_A1562EmpConvePai, BC002B84_A1561EmpConveCod
            }
            , new Object[] {
            BC002B85_A3CliCod, BC002B85_A1EmpCod, BC002B85_A1562EmpConvePai, BC002B85_A1561EmpConveCod
            }
            , new Object[] {
            BC002B86_A3CliCod, BC002B86_A1EmpCod, BC002B86_A1562EmpConvePai, BC002B86_A1561EmpConveCod
            }
            , new Object[] {
            BC002B87_A3CliCod, BC002B87_A1EmpCod, BC002B87_A1562EmpConvePai, BC002B87_A1561EmpConveCod
            }
            , new Object[] {
            BC002B88_A3CliCod, BC002B88_A1EmpCod, BC002B88_A1562EmpConvePai, BC002B88_A1561EmpConveCod
            }
            , new Object[] {
            BC002B89_A3CliCod, BC002B89_A1EmpCod, BC002B89_A1562EmpConvePai, BC002B89_A1561EmpConveCod
            }
            , new Object[] {
            BC002B90_A3CliCod, BC002B90_A1EmpCod, BC002B90_A1562EmpConvePai, BC002B90_A1561EmpConveCod
            }
            , new Object[] {
            BC002B91_A3CliCod, BC002B91_A1EmpCod, BC002B91_A1562EmpConvePai, BC002B91_A1561EmpConveCod
            }
            , new Object[] {
            BC002B92_A3CliCod, BC002B92_A1EmpCod, BC002B92_A1562EmpConvePai, BC002B92_A1561EmpConveCod
            }
            , new Object[] {
            BC002B93_A3CliCod, BC002B93_A1EmpCod, BC002B93_A1562EmpConvePai, BC002B93_A1561EmpConveCod
            }
            , new Object[] {
            BC002B94_A3CliCod, BC002B94_A1EmpCod, BC002B94_A1562EmpConvePai, BC002B94_A1561EmpConveCod
            }
            , new Object[] {
            BC002B95_A3CliCod, BC002B95_A1EmpCod, BC002B95_A1562EmpConvePai, BC002B95_A1561EmpConveCod
            }
            , new Object[] {
            BC002B96_A3CliCod, BC002B96_A1EmpCod, BC002B96_A1562EmpConvePai, BC002B96_A1561EmpConveCod
            }
            , new Object[] {
            BC002B97_A3CliCod, BC002B97_A1EmpCod, BC002B97_A1562EmpConvePai, BC002B97_A1561EmpConveCod
            }
            , new Object[] {
            BC002B98_A3CliCod, BC002B98_A1EmpCod, BC002B98_A1547GuarCod
            }
            , new Object[] {
            BC002B99_A3CliCod, BC002B99_A1EmpCod, BC002B99_A1427EmpBaseClaseLeg, BC002B99_A1429EmpBaseTipo, BC002B99_A1430EmpBaseCod1, BC002B99_A1431EmpBaseCod2
            }
            , new Object[] {
            BC002B100_A3CliCod, BC002B100_A1EmpCod, BC002B100_A37TipoConCod, BC002B100_A1371EmpPromFijVar
            }
            , new Object[] {
            BC002B101_A3CliCod, BC002B101_A1EmpCod, BC002B101_A1366EmpJorConCodigo
            }
            , new Object[] {
            BC002B102_A3CliCod, BC002B102_A1EmpCod, BC002B102_A1368EmpMenConCodigo
            }
            , new Object[] {
            BC002B103_A3CliCod, BC002B103_A1EmpCod, BC002B103_A1294PaiTipoTraId
            }
            , new Object[] {
            BC002B104_A3CliCod, BC002B104_A1EmpCod, BC002B104_A1340EmpHsExSec
            }
            , new Object[] {
            BC002B105_A3CliCod, BC002B105_A1EmpCod, BC002B105_A1243SucCodigo
            }
            , new Object[] {
            BC002B106_A3CliCod, BC002B106_A1EmpCod, BC002B106_A1237EmpReligion
            }
            , new Object[] {
            BC002B107_A3CliCod, BC002B107_A1EmpCod, BC002B107_A1238EmpOrigen
            }
            , new Object[] {
            BC002B108_A3CliCod, BC002B108_A1EmpCod, BC002B108_A1239EmpConvenio
            }
            , new Object[] {
            BC002B109_A3CliCod, BC002B109_A1EmpCod, BC002B109_A784F1357CTipoPre, BC002B109_A777F1357CPer, BC002B109_A778F1357CSec
            }
            , new Object[] {
            BC002B110_A3CliCod, BC002B110_A1EmpCod, BC002B110_A88ImpLiqSec
            }
            , new Object[] {
            BC002B111_A3CliCod, BC002B111_A1EmpCod, BC002B111_A87MigrLegNumero
            }
            , new Object[] {
            BC002B112_A3CliCod, BC002B112_A1EmpCod, BC002B112_A86TempRecSec
            }
            , new Object[] {
            BC002B113_A3CliCod, BC002B113_A1EmpCod, BC002B113_A85ArchSiradigFec
            }
            , new Object[] {
            BC002B114_A3CliCod, BC002B114_A1EmpCod, BC002B114_A79AsientoCNum
            }
            , new Object[] {
            BC002B115_A3CliCod, BC002B115_A1EmpCod, BC002B115_A78CuenCodigo
            }
            , new Object[] {
            BC002B116_A3CliCod, BC002B116_A1EmpCod, BC002B116_A77CenCodigo
            }
            , new Object[] {
            BC002B117_A3CliCod, BC002B117_A1EmpCod, BC002B117_A31LiqNro, BC002B117_A10LpgCodigo
            }
            , new Object[] {
            BC002B118_A3CliCod, BC002B118_A1EmpCod, BC002B118_A6LegNumero
            }
            , new Object[] {
            BC002B119_A683ActDescripSinAc, BC002B119_A1EmpCod, BC002B119_A2EmpNom, BC002B119_A177EmpCUIT, BC002B119_A125CatIvaCod, BC002B119_n125CatIvaCod, BC002B119_A126CatIvaDesc, BC002B119_n126CatIvaDesc, BC002B119_A178EmpDir, BC002B119_A180EmpTel,
            BC002B119_n180EmpTel, BC002B119_A176EmpCP, BC002B119_n176EmpCP, BC002B119_A312PaiNom, BC002B119_A322ProvNom, BC002B119_A286LocNom, BC002B119_A108ActDescrip, BC002B119_A518EmpZonDescrip, BC002B119_A532EmpReducc, BC002B119_A530TipEmpleDefIns,
            BC002B119_A46PaiCod, BC002B119_n46PaiCod, BC002B119_A47ProvCod, BC002B119_n47ProvCod, BC002B119_A48LocCod, BC002B119_n48LocCod, BC002B119_A3CliCod, BC002B119_A43ActCodigo, BC002B119_n43ActCodigo, BC002B119_A45TipEmpleCod,
            BC002B119_n45TipEmpleCod, BC002B119_A44EmpZonCod, BC002B119_n44EmpZonCod
            }
            , new Object[] {
            BC002B120_A3CliCod
            }
            , new Object[] {
            BC002B121_A3CliCod
            }
         }
      );
      AV45Pgmname = "LiqImportarAuxTrn_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e122B2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short AV11Insert_PaiCod ;
   private short AV12Insert_ProvCod ;
   private short AV13Insert_LocCod ;
   private short gxcookieaux ;
   private short Z125CatIvaCod ;
   private short A125CatIvaCod ;
   private short Z46PaiCod ;
   private short A46PaiCod ;
   private short Z47ProvCod ;
   private short A47ProvCod ;
   private short Z48LocCod ;
   private short A48LocCod ;
   private short RcdFound13 ;
   private short nIsDirty_13 ;
   private short GXt_int7 ;
   private short GXv_int8[] ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int AV46GXV1 ;
   private int AV30CliCod ;
   private int GX_JID ;
   private long GXv_int4[] ;
   private long Z177EmpCUIT ;
   private long A177EmpCUIT ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV45Pgmname ;
   private String AV14Insert_ActCodigo ;
   private String AV40Insert_TipEmpleCod ;
   private String AV36Insert_EmpZonCod ;
   private String GXv_char6[] ;
   private String GXKey ;
   private String GXEncryptionTmp ;
   private String Z176EmpCP ;
   private String A176EmpCP ;
   private String Z43ActCodigo ;
   private String A43ActCodigo ;
   private String Z45TipEmpleCod ;
   private String A45TipEmpleCod ;
   private String Z44EmpZonCod ;
   private String A44EmpZonCod ;
   private String Z530TipEmpleDefIns ;
   private String A530TipEmpleDefIns ;
   private String sMode13 ;
   private java.util.Date AV33Date ;
   private java.util.Date GXv_date5[] ;
   private boolean returnInSub ;
   private boolean AV31IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean AV34CliMultiEmp ;
   private boolean GXv_boolean3[] ;
   private boolean Z532EmpReducc ;
   private boolean A532EmpReducc ;
   private boolean n125CatIvaCod ;
   private boolean n126CatIvaDesc ;
   private boolean n180EmpTel ;
   private boolean n176EmpCP ;
   private boolean n46PaiCod ;
   private boolean n47ProvCod ;
   private boolean n48LocCod ;
   private boolean n43ActCodigo ;
   private boolean n45TipEmpleCod ;
   private boolean n44EmpZonCod ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z2EmpNom ;
   private String A2EmpNom ;
   private String Z126CatIvaDesc ;
   private String A126CatIvaDesc ;
   private String Z178EmpDir ;
   private String A178EmpDir ;
   private String Z180EmpTel ;
   private String A180EmpTel ;
   private String Z312PaiNom ;
   private String A312PaiNom ;
   private String Z322ProvNom ;
   private String A322ProvNom ;
   private String Z286LocNom ;
   private String A286LocNom ;
   private String Z683ActDescripSinAc ;
   private String A683ActDescripSinAc ;
   private String Z108ActDescrip ;
   private String A108ActDescrip ;
   private String Z518EmpZonDescrip ;
   private String A518EmpZonDescrip ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.webpanels.WebSession AV35Session ;
   private web.SdtLiqImportarAuxTrn bcLiqImportarAuxTrn ;
   private IDataStoreProvider pr_default ;
   private String[] BC002B11_A683ActDescripSinAc ;
   private short[] BC002B11_A1EmpCod ;
   private String[] BC002B11_A2EmpNom ;
   private long[] BC002B11_A177EmpCUIT ;
   private short[] BC002B11_A125CatIvaCod ;
   private boolean[] BC002B11_n125CatIvaCod ;
   private String[] BC002B11_A126CatIvaDesc ;
   private boolean[] BC002B11_n126CatIvaDesc ;
   private String[] BC002B11_A178EmpDir ;
   private String[] BC002B11_A180EmpTel ;
   private boolean[] BC002B11_n180EmpTel ;
   private String[] BC002B11_A176EmpCP ;
   private boolean[] BC002B11_n176EmpCP ;
   private String[] BC002B11_A312PaiNom ;
   private String[] BC002B11_A322ProvNom ;
   private String[] BC002B11_A286LocNom ;
   private String[] BC002B11_A108ActDescrip ;
   private String[] BC002B11_A518EmpZonDescrip ;
   private boolean[] BC002B11_A532EmpReducc ;
   private String[] BC002B11_A530TipEmpleDefIns ;
   private short[] BC002B11_A46PaiCod ;
   private boolean[] BC002B11_n46PaiCod ;
   private short[] BC002B11_A47ProvCod ;
   private boolean[] BC002B11_n47ProvCod ;
   private short[] BC002B11_A48LocCod ;
   private boolean[] BC002B11_n48LocCod ;
   private int[] BC002B11_A3CliCod ;
   private String[] BC002B11_A43ActCodigo ;
   private boolean[] BC002B11_n43ActCodigo ;
   private String[] BC002B11_A45TipEmpleCod ;
   private boolean[] BC002B11_n45TipEmpleCod ;
   private String[] BC002B11_A44EmpZonCod ;
   private boolean[] BC002B11_n44EmpZonCod ;
   private int[] BC002B12_A3CliCod ;
   private String[] BC002B13_A312PaiNom ;
   private String[] BC002B14_A322ProvNom ;
   private String[] BC002B15_A286LocNom ;
   private String[] BC002B16_A683ActDescripSinAc ;
   private String[] BC002B16_A108ActDescrip ;
   private String[] BC002B17_A530TipEmpleDefIns ;
   private String[] BC002B18_A518EmpZonDescrip ;
   private int[] BC002B19_A3CliCod ;
   private short[] BC002B19_A1EmpCod ;
   private short[] BC002B20_A1EmpCod ;
   private String[] BC002B20_A2EmpNom ;
   private long[] BC002B20_A177EmpCUIT ;
   private short[] BC002B20_A125CatIvaCod ;
   private boolean[] BC002B20_n125CatIvaCod ;
   private String[] BC002B20_A126CatIvaDesc ;
   private boolean[] BC002B20_n126CatIvaDesc ;
   private String[] BC002B20_A178EmpDir ;
   private String[] BC002B20_A180EmpTel ;
   private boolean[] BC002B20_n180EmpTel ;
   private String[] BC002B20_A176EmpCP ;
   private boolean[] BC002B20_n176EmpCP ;
   private boolean[] BC002B20_A532EmpReducc ;
   private short[] BC002B20_A46PaiCod ;
   private boolean[] BC002B20_n46PaiCod ;
   private short[] BC002B20_A47ProvCod ;
   private boolean[] BC002B20_n47ProvCod ;
   private short[] BC002B20_A48LocCod ;
   private boolean[] BC002B20_n48LocCod ;
   private int[] BC002B20_A3CliCod ;
   private String[] BC002B20_A43ActCodigo ;
   private boolean[] BC002B20_n43ActCodigo ;
   private String[] BC002B20_A45TipEmpleCod ;
   private boolean[] BC002B20_n45TipEmpleCod ;
   private String[] BC002B20_A44EmpZonCod ;
   private boolean[] BC002B20_n44EmpZonCod ;
   private short[] BC002B21_A1EmpCod ;
   private String[] BC002B21_A2EmpNom ;
   private long[] BC002B21_A177EmpCUIT ;
   private short[] BC002B21_A125CatIvaCod ;
   private boolean[] BC002B21_n125CatIvaCod ;
   private String[] BC002B21_A126CatIvaDesc ;
   private boolean[] BC002B21_n126CatIvaDesc ;
   private String[] BC002B21_A178EmpDir ;
   private String[] BC002B21_A180EmpTel ;
   private boolean[] BC002B21_n180EmpTel ;
   private String[] BC002B21_A176EmpCP ;
   private boolean[] BC002B21_n176EmpCP ;
   private boolean[] BC002B21_A532EmpReducc ;
   private short[] BC002B21_A46PaiCod ;
   private boolean[] BC002B21_n46PaiCod ;
   private short[] BC002B21_A47ProvCod ;
   private boolean[] BC002B21_n47ProvCod ;
   private short[] BC002B21_A48LocCod ;
   private boolean[] BC002B21_n48LocCod ;
   private int[] BC002B21_A3CliCod ;
   private String[] BC002B21_A43ActCodigo ;
   private boolean[] BC002B21_n43ActCodigo ;
   private String[] BC002B21_A45TipEmpleCod ;
   private boolean[] BC002B21_n45TipEmpleCod ;
   private String[] BC002B21_A44EmpZonCod ;
   private boolean[] BC002B21_n44EmpZonCod ;
   private String[] BC002B25_A312PaiNom ;
   private String[] BC002B26_A322ProvNom ;
   private String[] BC002B27_A286LocNom ;
   private String[] BC002B28_A683ActDescripSinAc ;
   private String[] BC002B28_A108ActDescrip ;
   private String[] BC002B29_A530TipEmpleDefIns ;
   private String[] BC002B30_A518EmpZonDescrip ;
   private int[] BC002B31_A3CliCod ;
   private short[] BC002B31_A1EmpCod ;
   private java.util.UUID[] BC002B31_A2418BanSalCod ;
   private int[] BC002B32_A3CliCod ;
   private short[] BC002B32_A1EmpCod ;
   private java.util.UUID[] BC002B32_A2380ColaUUID ;
   private int[] BC002B33_A3CliCod ;
   private short[] BC002B33_A1EmpCod ;
   private int[] BC002B33_A2371LiqBatchLiqNro ;
   private String[] BC002B33_A2372LiqBatchCod ;
   private String[] BC002B33_A2373LiqBatchSeccion ;
   private int[] BC002B34_A3CliCod ;
   private short[] BC002B34_A1EmpCod ;
   private int[] BC002B34_A2370LiqLoteLiqNro ;
   private String[] BC002B34_A2269LiqLote ;
   private int[] BC002B35_A3CliCod ;
   private short[] BC002B35_A1EmpCod ;
   private int[] BC002B35_A31LiqNro ;
   private int[] BC002B35_A2285LinkLegNumero ;
   private String[] BC002B35_A2277LegLinkTiporec ;
   private int[] BC002B36_A3CliCod ;
   private short[] BC002B36_A1EmpCod ;
   private int[] BC002B36_A31LiqNro ;
   private String[] BC002B36_A2183LiqSuc ;
   private int[] BC002B37_A3CliCod ;
   private short[] BC002B37_A1EmpCod ;
   private int[] BC002B37_A31LiqNro ;
   private String[] BC002B37_A2145LiqArea ;
   private int[] BC002B38_A3CliCod ;
   private short[] BC002B38_A1EmpCod ;
   private int[] BC002B38_A31LiqNro ;
   private short[] BC002B38_A2142LiqPaiConve ;
   private String[] BC002B38_A2143LiqConvenio ;
   private int[] BC002B39_A3CliCod ;
   private short[] BC002B39_A1EmpCod ;
   private String[] BC002B39_A1966EmpBanCod ;
   private int[] BC002B40_A3CliCod ;
   private short[] BC002B40_A1EmpCod ;
   private java.util.Date[] BC002B40_A1729PeriodoLiq ;
   private int[] BC002B41_A3CliCod ;
   private short[] BC002B41_A1EmpCod ;
   private int[] BC002B41_A1649LSDSec ;
   private int[] BC002B42_A3CliCod ;
   private short[] BC002B42_A1EmpCod ;
   private short[] BC002B42_A1562EmpConvePai ;
   private String[] BC002B42_A1561EmpConveCod ;
   private int[] BC002B43_A3CliCod ;
   private short[] BC002B43_A1EmpCod ;
   private short[] BC002B43_A1562EmpConvePai ;
   private String[] BC002B43_A1561EmpConveCod ;
   private int[] BC002B44_A3CliCod ;
   private short[] BC002B44_A1EmpCod ;
   private short[] BC002B44_A1562EmpConvePai ;
   private String[] BC002B44_A1561EmpConveCod ;
   private int[] BC002B45_A3CliCod ;
   private short[] BC002B45_A1EmpCod ;
   private short[] BC002B45_A1562EmpConvePai ;
   private String[] BC002B45_A1561EmpConveCod ;
   private int[] BC002B46_A3CliCod ;
   private short[] BC002B46_A1EmpCod ;
   private short[] BC002B46_A1562EmpConvePai ;
   private String[] BC002B46_A1561EmpConveCod ;
   private int[] BC002B47_A3CliCod ;
   private short[] BC002B47_A1EmpCod ;
   private short[] BC002B47_A1562EmpConvePai ;
   private String[] BC002B47_A1561EmpConveCod ;
   private int[] BC002B48_A3CliCod ;
   private short[] BC002B48_A1EmpCod ;
   private short[] BC002B48_A1562EmpConvePai ;
   private String[] BC002B48_A1561EmpConveCod ;
   private int[] BC002B49_A3CliCod ;
   private short[] BC002B49_A1EmpCod ;
   private short[] BC002B49_A1562EmpConvePai ;
   private String[] BC002B49_A1561EmpConveCod ;
   private int[] BC002B50_A3CliCod ;
   private short[] BC002B50_A1EmpCod ;
   private short[] BC002B50_A1562EmpConvePai ;
   private String[] BC002B50_A1561EmpConveCod ;
   private int[] BC002B51_A3CliCod ;
   private short[] BC002B51_A1EmpCod ;
   private short[] BC002B51_A1562EmpConvePai ;
   private String[] BC002B51_A1561EmpConveCod ;
   private int[] BC002B52_A3CliCod ;
   private short[] BC002B52_A1EmpCod ;
   private short[] BC002B52_A1562EmpConvePai ;
   private String[] BC002B52_A1561EmpConveCod ;
   private int[] BC002B53_A3CliCod ;
   private short[] BC002B53_A1EmpCod ;
   private short[] BC002B53_A1562EmpConvePai ;
   private String[] BC002B53_A1561EmpConveCod ;
   private int[] BC002B54_A3CliCod ;
   private short[] BC002B54_A1EmpCod ;
   private short[] BC002B54_A1562EmpConvePai ;
   private String[] BC002B54_A1561EmpConveCod ;
   private int[] BC002B55_A3CliCod ;
   private short[] BC002B55_A1EmpCod ;
   private short[] BC002B55_A1562EmpConvePai ;
   private String[] BC002B55_A1561EmpConveCod ;
   private int[] BC002B56_A3CliCod ;
   private short[] BC002B56_A1EmpCod ;
   private short[] BC002B56_A1562EmpConvePai ;
   private String[] BC002B56_A1561EmpConveCod ;
   private int[] BC002B57_A3CliCod ;
   private short[] BC002B57_A1EmpCod ;
   private short[] BC002B57_A1562EmpConvePai ;
   private String[] BC002B57_A1561EmpConveCod ;
   private int[] BC002B58_A3CliCod ;
   private short[] BC002B58_A1EmpCod ;
   private short[] BC002B58_A1562EmpConvePai ;
   private String[] BC002B58_A1561EmpConveCod ;
   private int[] BC002B59_A3CliCod ;
   private short[] BC002B59_A1EmpCod ;
   private short[] BC002B59_A1562EmpConvePai ;
   private String[] BC002B59_A1561EmpConveCod ;
   private int[] BC002B60_A3CliCod ;
   private short[] BC002B60_A1EmpCod ;
   private short[] BC002B60_A1562EmpConvePai ;
   private String[] BC002B60_A1561EmpConveCod ;
   private int[] BC002B61_A3CliCod ;
   private short[] BC002B61_A1EmpCod ;
   private short[] BC002B61_A1562EmpConvePai ;
   private String[] BC002B61_A1561EmpConveCod ;
   private int[] BC002B62_A3CliCod ;
   private short[] BC002B62_A1EmpCod ;
   private short[] BC002B62_A1562EmpConvePai ;
   private String[] BC002B62_A1561EmpConveCod ;
   private int[] BC002B63_A3CliCod ;
   private short[] BC002B63_A1EmpCod ;
   private short[] BC002B63_A1562EmpConvePai ;
   private String[] BC002B63_A1561EmpConveCod ;
   private int[] BC002B64_A3CliCod ;
   private short[] BC002B64_A1EmpCod ;
   private short[] BC002B64_A1562EmpConvePai ;
   private String[] BC002B64_A1561EmpConveCod ;
   private int[] BC002B65_A3CliCod ;
   private short[] BC002B65_A1EmpCod ;
   private short[] BC002B65_A1562EmpConvePai ;
   private String[] BC002B65_A1561EmpConveCod ;
   private int[] BC002B66_A3CliCod ;
   private short[] BC002B66_A1EmpCod ;
   private short[] BC002B66_A1562EmpConvePai ;
   private String[] BC002B66_A1561EmpConveCod ;
   private int[] BC002B67_A3CliCod ;
   private short[] BC002B67_A1EmpCod ;
   private short[] BC002B67_A1562EmpConvePai ;
   private String[] BC002B67_A1561EmpConveCod ;
   private int[] BC002B68_A3CliCod ;
   private short[] BC002B68_A1EmpCod ;
   private short[] BC002B68_A1562EmpConvePai ;
   private String[] BC002B68_A1561EmpConveCod ;
   private int[] BC002B69_A3CliCod ;
   private short[] BC002B69_A1EmpCod ;
   private short[] BC002B69_A1562EmpConvePai ;
   private String[] BC002B69_A1561EmpConveCod ;
   private int[] BC002B70_A3CliCod ;
   private short[] BC002B70_A1EmpCod ;
   private short[] BC002B70_A1562EmpConvePai ;
   private String[] BC002B70_A1561EmpConveCod ;
   private int[] BC002B71_A3CliCod ;
   private short[] BC002B71_A1EmpCod ;
   private short[] BC002B71_A1562EmpConvePai ;
   private String[] BC002B71_A1561EmpConveCod ;
   private int[] BC002B72_A3CliCod ;
   private short[] BC002B72_A1EmpCod ;
   private short[] BC002B72_A1562EmpConvePai ;
   private String[] BC002B72_A1561EmpConveCod ;
   private int[] BC002B73_A3CliCod ;
   private short[] BC002B73_A1EmpCod ;
   private short[] BC002B73_A1562EmpConvePai ;
   private String[] BC002B73_A1561EmpConveCod ;
   private int[] BC002B74_A3CliCod ;
   private short[] BC002B74_A1EmpCod ;
   private short[] BC002B74_A1562EmpConvePai ;
   private String[] BC002B74_A1561EmpConveCod ;
   private int[] BC002B75_A3CliCod ;
   private short[] BC002B75_A1EmpCod ;
   private short[] BC002B75_A1562EmpConvePai ;
   private String[] BC002B75_A1561EmpConveCod ;
   private int[] BC002B76_A3CliCod ;
   private short[] BC002B76_A1EmpCod ;
   private short[] BC002B76_A1562EmpConvePai ;
   private String[] BC002B76_A1561EmpConveCod ;
   private int[] BC002B77_A3CliCod ;
   private short[] BC002B77_A1EmpCod ;
   private short[] BC002B77_A1562EmpConvePai ;
   private String[] BC002B77_A1561EmpConveCod ;
   private int[] BC002B78_A3CliCod ;
   private short[] BC002B78_A1EmpCod ;
   private short[] BC002B78_A1562EmpConvePai ;
   private String[] BC002B78_A1561EmpConveCod ;
   private int[] BC002B79_A3CliCod ;
   private short[] BC002B79_A1EmpCod ;
   private short[] BC002B79_A1562EmpConvePai ;
   private String[] BC002B79_A1561EmpConveCod ;
   private int[] BC002B80_A3CliCod ;
   private short[] BC002B80_A1EmpCod ;
   private short[] BC002B80_A1562EmpConvePai ;
   private String[] BC002B80_A1561EmpConveCod ;
   private int[] BC002B81_A3CliCod ;
   private short[] BC002B81_A1EmpCod ;
   private short[] BC002B81_A1562EmpConvePai ;
   private String[] BC002B81_A1561EmpConveCod ;
   private int[] BC002B82_A3CliCod ;
   private short[] BC002B82_A1EmpCod ;
   private short[] BC002B82_A1562EmpConvePai ;
   private String[] BC002B82_A1561EmpConveCod ;
   private int[] BC002B83_A3CliCod ;
   private short[] BC002B83_A1EmpCod ;
   private short[] BC002B83_A1562EmpConvePai ;
   private String[] BC002B83_A1561EmpConveCod ;
   private int[] BC002B84_A3CliCod ;
   private short[] BC002B84_A1EmpCod ;
   private short[] BC002B84_A1562EmpConvePai ;
   private String[] BC002B84_A1561EmpConveCod ;
   private int[] BC002B85_A3CliCod ;
   private short[] BC002B85_A1EmpCod ;
   private short[] BC002B85_A1562EmpConvePai ;
   private String[] BC002B85_A1561EmpConveCod ;
   private int[] BC002B86_A3CliCod ;
   private short[] BC002B86_A1EmpCod ;
   private short[] BC002B86_A1562EmpConvePai ;
   private String[] BC002B86_A1561EmpConveCod ;
   private int[] BC002B87_A3CliCod ;
   private short[] BC002B87_A1EmpCod ;
   private short[] BC002B87_A1562EmpConvePai ;
   private String[] BC002B87_A1561EmpConveCod ;
   private int[] BC002B88_A3CliCod ;
   private short[] BC002B88_A1EmpCod ;
   private short[] BC002B88_A1562EmpConvePai ;
   private String[] BC002B88_A1561EmpConveCod ;
   private int[] BC002B89_A3CliCod ;
   private short[] BC002B89_A1EmpCod ;
   private short[] BC002B89_A1562EmpConvePai ;
   private String[] BC002B89_A1561EmpConveCod ;
   private int[] BC002B90_A3CliCod ;
   private short[] BC002B90_A1EmpCod ;
   private short[] BC002B90_A1562EmpConvePai ;
   private String[] BC002B90_A1561EmpConveCod ;
   private int[] BC002B91_A3CliCod ;
   private short[] BC002B91_A1EmpCod ;
   private short[] BC002B91_A1562EmpConvePai ;
   private String[] BC002B91_A1561EmpConveCod ;
   private int[] BC002B92_A3CliCod ;
   private short[] BC002B92_A1EmpCod ;
   private short[] BC002B92_A1562EmpConvePai ;
   private String[] BC002B92_A1561EmpConveCod ;
   private int[] BC002B93_A3CliCod ;
   private short[] BC002B93_A1EmpCod ;
   private short[] BC002B93_A1562EmpConvePai ;
   private String[] BC002B93_A1561EmpConveCod ;
   private int[] BC002B94_A3CliCod ;
   private short[] BC002B94_A1EmpCod ;
   private short[] BC002B94_A1562EmpConvePai ;
   private String[] BC002B94_A1561EmpConveCod ;
   private int[] BC002B95_A3CliCod ;
   private short[] BC002B95_A1EmpCod ;
   private short[] BC002B95_A1562EmpConvePai ;
   private String[] BC002B95_A1561EmpConveCod ;
   private int[] BC002B96_A3CliCod ;
   private short[] BC002B96_A1EmpCod ;
   private short[] BC002B96_A1562EmpConvePai ;
   private String[] BC002B96_A1561EmpConveCod ;
   private int[] BC002B97_A3CliCod ;
   private short[] BC002B97_A1EmpCod ;
   private short[] BC002B97_A1562EmpConvePai ;
   private String[] BC002B97_A1561EmpConveCod ;
   private int[] BC002B98_A3CliCod ;
   private short[] BC002B98_A1EmpCod ;
   private short[] BC002B98_A1547GuarCod ;
   private int[] BC002B99_A3CliCod ;
   private short[] BC002B99_A1EmpCod ;
   private byte[] BC002B99_A1427EmpBaseClaseLeg ;
   private String[] BC002B99_A1429EmpBaseTipo ;
   private String[] BC002B99_A1430EmpBaseCod1 ;
   private String[] BC002B99_A1431EmpBaseCod2 ;
   private int[] BC002B100_A3CliCod ;
   private short[] BC002B100_A1EmpCod ;
   private String[] BC002B100_A37TipoConCod ;
   private String[] BC002B100_A1371EmpPromFijVar ;
   private int[] BC002B101_A3CliCod ;
   private short[] BC002B101_A1EmpCod ;
   private String[] BC002B101_A1366EmpJorConCodigo ;
   private int[] BC002B102_A3CliCod ;
   private short[] BC002B102_A1EmpCod ;
   private String[] BC002B102_A1368EmpMenConCodigo ;
   private int[] BC002B103_A3CliCod ;
   private short[] BC002B103_A1EmpCod ;
   private String[] BC002B103_A1294PaiTipoTraId ;
   private int[] BC002B104_A3CliCod ;
   private short[] BC002B104_A1EmpCod ;
   private short[] BC002B104_A1340EmpHsExSec ;
   private int[] BC002B105_A3CliCod ;
   private short[] BC002B105_A1EmpCod ;
   private String[] BC002B105_A1243SucCodigo ;
   private int[] BC002B106_A3CliCod ;
   private short[] BC002B106_A1EmpCod ;
   private String[] BC002B106_A1237EmpReligion ;
   private int[] BC002B107_A3CliCod ;
   private short[] BC002B107_A1EmpCod ;
   private String[] BC002B107_A1238EmpOrigen ;
   private int[] BC002B108_A3CliCod ;
   private short[] BC002B108_A1EmpCod ;
   private String[] BC002B108_A1239EmpConvenio ;
   private int[] BC002B109_A3CliCod ;
   private short[] BC002B109_A1EmpCod ;
   private byte[] BC002B109_A784F1357CTipoPre ;
   private String[] BC002B109_A777F1357CPer ;
   private byte[] BC002B109_A778F1357CSec ;
   private int[] BC002B110_A3CliCod ;
   private short[] BC002B110_A1EmpCod ;
   private short[] BC002B110_A88ImpLiqSec ;
   private int[] BC002B111_A3CliCod ;
   private short[] BC002B111_A1EmpCod ;
   private int[] BC002B111_A87MigrLegNumero ;
   private int[] BC002B112_A3CliCod ;
   private short[] BC002B112_A1EmpCod ;
   private short[] BC002B112_A86TempRecSec ;
   private int[] BC002B113_A3CliCod ;
   private short[] BC002B113_A1EmpCod ;
   private java.util.Date[] BC002B113_A85ArchSiradigFec ;
   private int[] BC002B114_A3CliCod ;
   private short[] BC002B114_A1EmpCod ;
   private int[] BC002B114_A79AsientoCNum ;
   private int[] BC002B115_A3CliCod ;
   private short[] BC002B115_A1EmpCod ;
   private String[] BC002B115_A78CuenCodigo ;
   private int[] BC002B116_A3CliCod ;
   private short[] BC002B116_A1EmpCod ;
   private short[] BC002B116_A77CenCodigo ;
   private int[] BC002B117_A3CliCod ;
   private short[] BC002B117_A1EmpCod ;
   private int[] BC002B117_A31LiqNro ;
   private String[] BC002B117_A10LpgCodigo ;
   private int[] BC002B118_A3CliCod ;
   private short[] BC002B118_A1EmpCod ;
   private int[] BC002B118_A6LegNumero ;
   private String[] BC002B119_A683ActDescripSinAc ;
   private short[] BC002B119_A1EmpCod ;
   private String[] BC002B119_A2EmpNom ;
   private long[] BC002B119_A177EmpCUIT ;
   private short[] BC002B119_A125CatIvaCod ;
   private boolean[] BC002B119_n125CatIvaCod ;
   private String[] BC002B119_A126CatIvaDesc ;
   private boolean[] BC002B119_n126CatIvaDesc ;
   private String[] BC002B119_A178EmpDir ;
   private String[] BC002B119_A180EmpTel ;
   private boolean[] BC002B119_n180EmpTel ;
   private String[] BC002B119_A176EmpCP ;
   private boolean[] BC002B119_n176EmpCP ;
   private String[] BC002B119_A312PaiNom ;
   private String[] BC002B119_A322ProvNom ;
   private String[] BC002B119_A286LocNom ;
   private String[] BC002B119_A108ActDescrip ;
   private String[] BC002B119_A518EmpZonDescrip ;
   private boolean[] BC002B119_A532EmpReducc ;
   private String[] BC002B119_A530TipEmpleDefIns ;
   private short[] BC002B119_A46PaiCod ;
   private boolean[] BC002B119_n46PaiCod ;
   private short[] BC002B119_A47ProvCod ;
   private boolean[] BC002B119_n47ProvCod ;
   private short[] BC002B119_A48LocCod ;
   private boolean[] BC002B119_n48LocCod ;
   private int[] BC002B119_A3CliCod ;
   private String[] BC002B119_A43ActCodigo ;
   private boolean[] BC002B119_n43ActCodigo ;
   private String[] BC002B119_A45TipEmpleCod ;
   private boolean[] BC002B119_n45TipEmpleCod ;
   private String[] BC002B119_A44EmpZonCod ;
   private boolean[] BC002B119_n44EmpZonCod ;
   private int[] BC002B120_A3CliCod ;
   private int[] BC002B121_A3CliCod ;
   private short[] BC002B2_A1EmpCod ;
   private String[] BC002B2_A2EmpNom ;
   private long[] BC002B2_A177EmpCUIT ;
   private short[] BC002B2_A125CatIvaCod ;
   private String[] BC002B2_A126CatIvaDesc ;
   private String[] BC002B2_A178EmpDir ;
   private String[] BC002B2_A180EmpTel ;
   private String[] BC002B2_A176EmpCP ;
   private boolean[] BC002B2_A532EmpReducc ;
   private short[] BC002B2_A46PaiCod ;
   private short[] BC002B2_A47ProvCod ;
   private short[] BC002B2_A48LocCod ;
   private int[] BC002B2_A3CliCod ;
   private String[] BC002B2_A43ActCodigo ;
   private String[] BC002B2_A45TipEmpleCod ;
   private String[] BC002B2_A44EmpZonCod ;
   private short[] BC002B3_A1EmpCod ;
   private String[] BC002B3_A2EmpNom ;
   private long[] BC002B3_A177EmpCUIT ;
   private short[] BC002B3_A125CatIvaCod ;
   private String[] BC002B3_A126CatIvaDesc ;
   private String[] BC002B3_A178EmpDir ;
   private String[] BC002B3_A180EmpTel ;
   private String[] BC002B3_A176EmpCP ;
   private boolean[] BC002B3_A532EmpReducc ;
   private short[] BC002B3_A46PaiCod ;
   private short[] BC002B3_A47ProvCod ;
   private short[] BC002B3_A48LocCod ;
   private int[] BC002B3_A3CliCod ;
   private String[] BC002B3_A43ActCodigo ;
   private String[] BC002B3_A45TipEmpleCod ;
   private String[] BC002B3_A44EmpZonCod ;
   private String[] BC002B4_A312PaiNom ;
   private String[] BC002B5_A322ProvNom ;
   private String[] BC002B6_A286LocNom ;
   private int[] BC002B7_A3CliCod ;
   private String[] BC002B8_A683ActDescripSinAc ;
   private String[] BC002B8_A108ActDescrip ;
   private String[] BC002B9_A530TipEmpleDefIns ;
   private String[] BC002B10_A518EmpZonDescrip ;
   private boolean[] BC002B2_n125CatIvaCod ;
   private boolean[] BC002B2_n126CatIvaDesc ;
   private boolean[] BC002B2_n180EmpTel ;
   private boolean[] BC002B2_n176EmpCP ;
   private boolean[] BC002B2_n46PaiCod ;
   private boolean[] BC002B2_n47ProvCod ;
   private boolean[] BC002B2_n48LocCod ;
   private boolean[] BC002B2_n43ActCodigo ;
   private boolean[] BC002B2_n45TipEmpleCod ;
   private boolean[] BC002B2_n44EmpZonCod ;
   private boolean[] BC002B3_n125CatIvaCod ;
   private boolean[] BC002B3_n126CatIvaDesc ;
   private boolean[] BC002B3_n180EmpTel ;
   private boolean[] BC002B3_n176EmpCP ;
   private boolean[] BC002B3_n46PaiCod ;
   private boolean[] BC002B3_n47ProvCod ;
   private boolean[] BC002B3_n48LocCod ;
   private boolean[] BC002B3_n43ActCodigo ;
   private boolean[] BC002B3_n45TipEmpleCod ;
   private boolean[] BC002B3_n44EmpZonCod ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV15TrnContextAtt ;
}

final  class liqimportarauxtrn_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC002B2", "SELECT EmpCod, EmpNom, EmpCUIT, CatIvaCod, CatIvaDesc, EmpDir, EmpTel, EmpCP, EmpReducc, PaiCod, ProvCod, LocCod, CliCod, ActCodigo, TipEmpleCod, EmpZonCod FROM Empresa WHERE CliCod = ? AND EmpCod = ?  FOR UPDATE OF Empresa",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B3", "SELECT EmpCod, EmpNom, EmpCUIT, CatIvaCod, CatIvaDesc, EmpDir, EmpTel, EmpCP, EmpReducc, PaiCod, ProvCod, LocCod, CliCod, ActCodigo, TipEmpleCod, EmpZonCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B4", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B5", "SELECT ProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B6", "SELECT LocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B7", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B8", "SELECT ActDescripSinAc, ActDescrip FROM Actividad WHERE ActCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B9", "SELECT TipEmpleDefIns FROM TipoEmpleador WHERE TipEmpleCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B10", "SELECT ZonDescrip AS EmpZonDescrip FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B11", "SELECT T5.ActDescripSinAc, TM1.EmpCod, TM1.EmpNom, TM1.EmpCUIT, TM1.CatIvaCod, TM1.CatIvaDesc, TM1.EmpDir, TM1.EmpTel, TM1.EmpCP, T2.PaiNom, T3.ProvNom, T4.LocNom, T5.ActDescrip, T7.ZonDescrip AS EmpZonDescrip, TM1.EmpReducc, T6.TipEmpleDefIns, TM1.PaiCod, TM1.ProvCod, TM1.LocCod, TM1.CliCod, TM1.ActCodigo, TM1.TipEmpleCod, TM1.EmpZonCod AS EmpZonCod FROM ((((((Empresa TM1 LEFT JOIN Pais T2 ON T2.PaiCod = TM1.PaiCod) LEFT JOIN Provincia T3 ON T3.PaiCod = TM1.PaiCod AND T3.ProvCod = TM1.ProvCod) LEFT JOIN Localidad T4 ON T4.PaiCod = TM1.PaiCod AND T4.ProvCod = TM1.ProvCod AND T4.LocCod = TM1.LocCod) LEFT JOIN Actividad T5 ON T5.ActCodigo = TM1.ActCodigo) LEFT JOIN TipoEmpleador T6 ON T6.TipEmpleCod = TM1.TipEmpleCod) LEFT JOIN Zona T7 ON T7.ZonCod = TM1.EmpZonCod) WHERE TM1.EmpCod = ? and TM1.CliCod = ? ORDER BY TM1.CliCod, TM1.EmpCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B12", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B13", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B14", "SELECT ProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B15", "SELECT LocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B16", "SELECT ActDescripSinAc, ActDescrip FROM Actividad WHERE ActCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B17", "SELECT TipEmpleDefIns FROM TipoEmpleador WHERE TipEmpleCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B18", "SELECT ZonDescrip AS EmpZonDescrip FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B19", "SELECT CliCod, EmpCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B20", "SELECT EmpCod, EmpNom, EmpCUIT, CatIvaCod, CatIvaDesc, EmpDir, EmpTel, EmpCP, EmpReducc, PaiCod, ProvCod, LocCod, CliCod, ActCodigo, TipEmpleCod, EmpZonCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B21", "SELECT EmpCod, EmpNom, EmpCUIT, CatIvaCod, CatIvaDesc, EmpDir, EmpTel, EmpCP, EmpReducc, PaiCod, ProvCod, LocCod, CliCod, ActCodigo, TipEmpleCod, EmpZonCod FROM Empresa WHERE CliCod = ? AND EmpCod = ?  FOR UPDATE OF Empresa",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC002B22", "SAVEPOINT gxupdate;INSERT INTO Empresa(EmpCod, EmpNom, EmpCUIT, CatIvaCod, CatIvaDesc, EmpDir, EmpTel, EmpCP, EmpReducc, PaiCod, ProvCod, LocCod, CliCod, ActCodigo, TipEmpleCod, EmpZonCod, EmpLogo, EmpLogoNom, EmpLogoExt, EmpFirma, EmpFirmaNom, EmpFirmaExt, EmpAntiguedad, EmpPresentismo, ARTSec, EmpMesHsPExt, EmpDiaHsPExt, EmpLiqFer, EmpActComercial, EmpGuarEdadMin, EmpGuarEdadMax, ActComCodigo, EmpLiqFerJor, EmpLiqGan, EmpTipoExp, EmpPromDesde, EmpPerVacDes, EmpPerVacHas, EmpFracVacAnt, EmpOsoCod, EmpUltSexoIng, EmpCondiCod, EmpVacExpLim, EmpVacExpTie, EmpVacDisMax, EmpModTra, EmpModEmpl, EmpModAuto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', '', '', '', '', '', 0, 0, 0, 0, '', FALSE, '', 0, 0, '', FALSE, FALSE, 0, '', 0, 0, 0, '', 0, 0, FALSE, 0, 0, '', FALSE, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002B23", "SAVEPOINT gxupdate;UPDATE Empresa SET EmpNom=?, EmpCUIT=?, CatIvaCod=?, CatIvaDesc=?, EmpDir=?, EmpTel=?, EmpCP=?, EmpReducc=?, PaiCod=?, ProvCod=?, LocCod=?, ActCodigo=?, TipEmpleCod=?, EmpZonCod=?  WHERE CliCod = ? AND EmpCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002B24", "SAVEPOINT gxupdate;DELETE FROM Empresa  WHERE CliCod = ? AND EmpCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC002B25", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B26", "SELECT ProvNom FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B27", "SELECT LocNom FROM Localidad WHERE PaiCod = ? AND ProvCod = ? AND LocCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B28", "SELECT ActDescripSinAc, ActDescrip FROM Actividad WHERE ActCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B29", "SELECT TipEmpleDefIns FROM TipoEmpleador WHERE TipEmpleCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B30", "SELECT ZonDescrip AS EmpZonDescrip FROM Zona WHERE ZonCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B31", "SELECT CliCod, EmpCod, BanSalCod FROM banda_salarial WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B32", "SELECT CliCod, EmpCod, ColaUUID FROM Cola WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B33", "SELECT CliCod, EmpCod, LiqBatchLiqNro, LiqBatchCod, LiqBatchSeccion FROM LiquidacionLotes3 WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B34", "SELECT CliCod, EmpCod, LiqLoteLiqNro, LiqLote FROM LiquidacionLotes2 WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B35", "SELECT CliCod, EmpCod, LiqNro, LinkLegNumero, LegLinkTiporec FROM LiquidacionLegajoLinkPdf WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B36", "SELECT CliCod, EmpCod, LiqNro, LiqSuc FROM LiquidacionSucursal WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B37", "SELECT CliCod, EmpCod, LiqNro, LiqArea FROM LiquidacionArea WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B38", "SELECT CliCod, EmpCod, LiqNro, LiqPaiConve, LiqConvenio FROM LiquidacionConvenio WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B39", "SELECT CliCod, EmpCod, EmpBanCod FROM EmpresaBancos WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B40", "SELECT CliCod, EmpCod, PeriodoLiq FROM Periodo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B41", "SELECT CliCod, EmpCod, LSDSec FROM LSD_reg1 WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B42", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE EmpConveVer = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B43", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B44", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B45", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B46", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B47", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B48", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B49", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B50", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B51", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B52", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B53", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B54", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B55", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B56", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B57", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B58", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B59", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B60", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B61", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B62", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B63", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B64", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B65", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B66", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B67", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B68", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B69", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B70", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B71", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B72", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B73", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B74", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B75", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B76", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B77", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B78", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B79", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B80", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B81", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B82", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B83", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B84", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B85", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B86", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B87", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B88", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B89", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B90", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B91", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B92", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B93", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B94", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B95", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B96", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B97", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B98", "SELECT CliCod, EmpCod, GuarCod FROM EmpresaGuarderias WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B99", "SELECT CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2 FROM Empresabase_calculo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B100", "SELECT CliCod, EmpCod, TipoConCod, EmpPromFijVar FROM Empresapromedio_horanormal_mensualizados WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B101", "SELECT CliCod, EmpCod, EmpJorConCodigo FROM Empresaconceptos_horanormal_jornalizados WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B102", "SELECT CliCod, EmpCod, EmpMenConCodigo FROM Empresaconceptos_horanormal_mensualizado WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B103", "SELECT CliCod, EmpCod, PaiTipoTraId FROM Empresatipo_trabajo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B104", "SELECT CliCod, EmpCod, EmpHsExSec FROM Empresahorasextras_pordia WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B105", "SELECT CliCod, EmpCod, SucCodigo FROM Sucursal WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B106", "SELECT CliCod, EmpCod, EmpReligion FROM Empresanolaborables_religion WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B107", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B108", "SELECT CliCod, EmpCod, EmpConvenio FROM Empresanolaborables_convenio WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B109", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec FROM F1357Cab WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B110", "SELECT CliCod, EmpCod, ImpLiqSec FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B111", "SELECT CliCod, EmpCod, MigrLegNumero FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B112", "SELECT CliCod, EmpCod, TempRecSec FROM TemplateRecibo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B113", "SELECT CliCod, EmpCod, ArchSiradigFec FROM archivo_siradig WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B114", "SELECT CliCod, EmpCod, AsientoCNum FROM AsientoCab WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B115", "SELECT CliCod, EmpCod, CuenCodigo FROM CuentaContable WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B116", "SELECT CliCod, EmpCod, CenCodigo FROM CentroDeCosto WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B117", "SELECT CliCod, EmpCod, LiqNro, LpgCodigo FROM LiquidacionLugarPago WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B118", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? AND EmpCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC002B119", "SELECT T5.ActDescripSinAc, TM1.EmpCod, TM1.EmpNom, TM1.EmpCUIT, TM1.CatIvaCod, TM1.CatIvaDesc, TM1.EmpDir, TM1.EmpTel, TM1.EmpCP, T2.PaiNom, T3.ProvNom, T4.LocNom, T5.ActDescrip, T7.ZonDescrip AS EmpZonDescrip, TM1.EmpReducc, T6.TipEmpleDefIns, TM1.PaiCod, TM1.ProvCod, TM1.LocCod, TM1.CliCod, TM1.ActCodigo, TM1.TipEmpleCod, TM1.EmpZonCod AS EmpZonCod FROM ((((((Empresa TM1 LEFT JOIN Pais T2 ON T2.PaiCod = TM1.PaiCod) LEFT JOIN Provincia T3 ON T3.PaiCod = TM1.PaiCod AND T3.ProvCod = TM1.ProvCod) LEFT JOIN Localidad T4 ON T4.PaiCod = TM1.PaiCod AND T4.ProvCod = TM1.ProvCod AND T4.LocCod = TM1.LocCod) LEFT JOIN Actividad T5 ON T5.ActCodigo = TM1.ActCodigo) LEFT JOIN TipoEmpleador T6 ON T6.TipEmpleCod = TM1.TipEmpleCod) LEFT JOIN Zona T7 ON T7.ZonCod = TM1.EmpZonCod) WHERE TM1.EmpCod = ? and TM1.CliCod = ? ORDER BY TM1.CliCod, TM1.EmpCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B120", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002B121", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((boolean[]) buf[12])[0] = rslt.getBoolean(9);
               ((short[]) buf[13])[0] = rslt.getShort(10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((short[]) buf[17])[0] = rslt.getShort(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((int[]) buf[19])[0] = rslt.getInt(13);
               ((String[]) buf[20])[0] = rslt.getString(14, 8);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getString(15, 4);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(16, 20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((boolean[]) buf[12])[0] = rslt.getBoolean(9);
               ((short[]) buf[13])[0] = rslt.getShort(10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((short[]) buf[17])[0] = rslt.getShort(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((int[]) buf[19])[0] = rslt.getInt(13);
               ((String[]) buf[20])[0] = rslt.getString(14, 8);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getString(15, 4);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(16, 20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(10);
               ((String[]) buf[14])[0] = rslt.getVarchar(11);
               ((String[]) buf[15])[0] = rslt.getVarchar(12);
               ((String[]) buf[16])[0] = rslt.getVarchar(13);
               ((String[]) buf[17])[0] = rslt.getVarchar(14);
               ((boolean[]) buf[18])[0] = rslt.getBoolean(15);
               ((String[]) buf[19])[0] = rslt.getString(16, 1);
               ((short[]) buf[20])[0] = rslt.getShort(17);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((short[]) buf[22])[0] = rslt.getShort(18);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((short[]) buf[24])[0] = rslt.getShort(19);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((int[]) buf[26])[0] = rslt.getInt(20);
               ((String[]) buf[27])[0] = rslt.getString(21, 8);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getString(22, 4);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((String[]) buf[31])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 18 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((boolean[]) buf[12])[0] = rslt.getBoolean(9);
               ((short[]) buf[13])[0] = rslt.getShort(10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((short[]) buf[17])[0] = rslt.getShort(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((int[]) buf[19])[0] = rslt.getInt(13);
               ((String[]) buf[20])[0] = rslt.getString(14, 8);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getString(15, 4);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(16, 20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((boolean[]) buf[12])[0] = rslt.getBoolean(9);
               ((short[]) buf[13])[0] = rslt.getShort(10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((short[]) buf[17])[0] = rslt.getShort(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((int[]) buf[19])[0] = rslt.getInt(13);
               ((String[]) buf[20])[0] = rslt.getString(14, 8);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getString(15, 4);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(16, 20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               return;
            case 23 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 24 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 25 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 26 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 27 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               return;
            case 28 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.UUID[]) buf[2])[0] = rslt.getGUID(3);
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
               ((java.util.UUID[]) buf[2])[0] = rslt.getGUID(3);
               return;
            case 31 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 32 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 33 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 34 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 35 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 36 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 37 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               return;
            case 38 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               return;
            case 39 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 40 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 41 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 42 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 43 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 44 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 45 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 46 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 47 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 48 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 49 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 50 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 51 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 52 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 53 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 54 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 55 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 56 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 57 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 58 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 59 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
      }
      getresults60( cursor, rslt, buf) ;
   }

   public void getresults60( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 60 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 61 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 62 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 63 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 64 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 65 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 66 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 67 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 68 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 69 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 70 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 71 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 72 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 73 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 74 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 75 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 76 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 77 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 78 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 79 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 80 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 81 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 82 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 83 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 84 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 85 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 86 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 87 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 88 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 89 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
      }
      getresults90( cursor, rslt, buf) ;
   }

   public void getresults90( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 90 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 91 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 92 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 93 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 94 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 95 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 96 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 97 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 98 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 99 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 100 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 101 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 102 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 103 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 104 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 105 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 106 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 107 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 108 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 109 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 110 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 111 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               return;
            case 112 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 113 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 114 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 115 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 116 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 117 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(10);
               ((String[]) buf[14])[0] = rslt.getVarchar(11);
               ((String[]) buf[15])[0] = rslt.getVarchar(12);
               ((String[]) buf[16])[0] = rslt.getVarchar(13);
               ((String[]) buf[17])[0] = rslt.getVarchar(14);
               ((boolean[]) buf[18])[0] = rslt.getBoolean(15);
               ((String[]) buf[19])[0] = rslt.getString(16, 1);
               ((short[]) buf[20])[0] = rslt.getShort(17);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((short[]) buf[22])[0] = rslt.getShort(18);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((short[]) buf[24])[0] = rslt.getShort(19);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((int[]) buf[26])[0] = rslt.getInt(20);
               ((String[]) buf[27])[0] = rslt.getString(21, 8);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getString(22, 4);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((String[]) buf[31])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               return;
            case 118 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 119 :
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 8);
               }
               return;
            case 7 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 13 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 14 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 8);
               }
               return;
            case 15 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 16 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setLong(3, ((Number) parms[2]).longValue());
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(4, ((Number) parms[4]).shortValue());
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(5, (String)parms[6], 30);
               }
               stmt.setVarchar(6, (String)parms[7], 40, false);
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(7, (String)parms[9], 30);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[11], 20);
               }
               stmt.setBoolean(9, ((Boolean) parms[12]).booleanValue());
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(10, ((Number) parms[14]).shortValue());
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(11, ((Number) parms[16]).shortValue());
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(12, ((Number) parms[18]).shortValue());
               }
               stmt.setInt(13, ((Number) parms[19]).intValue());
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(14, (String)parms[21], 8);
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(15, (String)parms[23], 4);
               }
               if ( ((Boolean) parms[24]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(16, (String)parms[25], 20);
               }
               return;
            case 21 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(4, (String)parms[5], 30);
               }
               stmt.setVarchar(5, (String)parms[6], 40, false);
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(6, (String)parms[8], 30);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[10], 20);
               }
               stmt.setBoolean(8, ((Boolean) parms[11]).booleanValue());
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(9, ((Number) parms[13]).shortValue());
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(10, ((Number) parms[15]).shortValue());
               }
               if ( ((Boolean) parms[16]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(11, ((Number) parms[17]).shortValue());
               }
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(12, (String)parms[19], 8);
               }
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(13, (String)parms[21], 4);
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(14, (String)parms[23], 20);
               }
               stmt.setInt(15, ((Number) parms[24]).intValue());
               stmt.setShort(16, ((Number) parms[25]).shortValue());
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 23 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 24 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               return;
            case 25 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[5]).shortValue());
               }
               return;
            case 26 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 8);
               }
               return;
            case 27 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 28 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
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
               return;
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 32 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 33 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 34 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 35 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 36 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 37 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 38 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 39 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 40 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 41 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 42 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 43 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 44 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 45 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 46 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 47 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 48 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 49 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 50 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 51 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 52 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 53 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 54 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 55 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 56 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 57 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 58 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 59 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
      setparameters60( cursor, stmt, parms) ;
   }

   public void setparameters60( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 60 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 61 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 62 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 63 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 64 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 65 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 66 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 67 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 68 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 69 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 70 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 71 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 72 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 73 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 74 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 75 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 76 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 77 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 78 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 79 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 80 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 81 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 82 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 83 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 84 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 85 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 86 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 87 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 88 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 89 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
      setparameters90( cursor, stmt, parms) ;
   }

   public void setparameters90( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 90 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 91 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 92 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 93 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 94 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 95 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 96 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 97 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 98 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 99 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 100 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 101 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 102 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 103 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 104 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 105 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 106 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 107 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 108 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 109 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 110 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 111 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 112 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 113 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 114 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 115 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 116 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 117 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 118 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 119 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

