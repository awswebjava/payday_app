package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class agendanovedades_bc extends GXWebPanel implements IGxSilentTrn
{
   public agendanovedades_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public agendanovedades_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( agendanovedades_bc.class ));
   }

   public agendanovedades_bc( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow063( ) ;
      standaloneNotModal( ) ;
      initializeNonKey063( ) ;
      standaloneModal( ) ;
      addRow063( ) ;
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
         e11062 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z6LegNumero = A6LegNumero ;
            Z25AgeOrden = A25AgeOrden ;
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

   public void confirm_060( )
   {
      beforeValidate063( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls063( ) ;
         }
         else
         {
            checkExtendedTable063( ) ;
            if ( AnyError == 0 )
            {
               zm063( 14) ;
               zm063( 15) ;
               zm063( 16) ;
            }
            closeExtendedTableCursors063( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e12062( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext1[0] = AV10WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV10WWPContext = GXv_SdtWWPContext1[0] ;
      AV22IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV22IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWAgendaNovedades_Insert", GXv_boolean3) ;
         agendanovedades_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV22IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV22IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWAgendaNovedades_Update", GXv_boolean3) ;
         agendanovedades_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV22IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV22IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWAgendaNovedades_Delete", GXv_boolean3) ;
         agendanovedades_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV22IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV22IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV29Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV29Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV30GXV1 = 1 ;
         while ( AV30GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV30GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConCodigo") == 0 )
            {
               AV13Insert_ConCodigo = AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "AgeLiqNro") == 0 )
            {
               AV27Insert_AgeLiqNro = (int)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            AV30GXV1 = (int)(AV30GXV1+1) ;
         }
      }
   }

   public void e11062( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm063( int GX_JID )
   {
      if ( ( GX_JID == 13 ) || ( GX_JID == 0 ) )
      {
         Z110AgeCanti = A110AgeCanti ;
         Z115AgeVUnit = A115AgeVUnit ;
         Z113AgeImporte = A113AgeImporte ;
         Z111AgeFecDes = A111AgeFecDes ;
         Z112AgeFecHas = A112AgeFecHas ;
         Z1254AgeLiqNro = A1254AgeLiqNro ;
         Z26ConCodigo = A26ConCodigo ;
         Z114AgeLegActivo = A114AgeLegActivo ;
      }
      if ( ( GX_JID == 14 ) || ( GX_JID == 0 ) )
      {
         Z2EmpNom = A2EmpNom ;
         Z114AgeLegActivo = A114AgeLegActivo ;
      }
      if ( ( GX_JID == 15 ) || ( GX_JID == 0 ) )
      {
         Z250LegIdNomApe = A250LegIdNomApe ;
         Z591LegNomApe = A591LegNomApe ;
         Z230LegApellido = A230LegApellido ;
         Z251LegNombre = A251LegNombre ;
         Z244LegFecEgreso = A244LegFecEgreso ;
         Z93LegId = A93LegId ;
         Z114AgeLegActivo = A114AgeLegActivo ;
      }
      if ( ( GX_JID == 16 ) || ( GX_JID == 0 ) )
      {
         Z42ConCodYDesc = A42ConCodYDesc ;
         Z41ConDescrip = A41ConDescrip ;
         Z143ConCanti = A143ConCanti ;
         Z158ConValUni = A158ConValUni ;
         Z152ConImporte = A152ConImporte ;
         Z114AgeLegActivo = A114AgeLegActivo ;
      }
      if ( GX_JID == -13 )
      {
         Z25AgeOrden = A25AgeOrden ;
         Z110AgeCanti = A110AgeCanti ;
         Z115AgeVUnit = A115AgeVUnit ;
         Z113AgeImporte = A113AgeImporte ;
         Z111AgeFecDes = A111AgeFecDes ;
         Z112AgeFecHas = A112AgeFecHas ;
         Z1254AgeLiqNro = A1254AgeLiqNro ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z26ConCodigo = A26ConCodigo ;
         Z2EmpNom = A2EmpNom ;
         Z250LegIdNomApe = A250LegIdNomApe ;
         Z591LegNomApe = A591LegNomApe ;
         Z230LegApellido = A230LegApellido ;
         Z251LegNombre = A251LegNombre ;
         Z244LegFecEgreso = A244LegFecEgreso ;
         Z93LegId = A93LegId ;
         Z42ConCodYDesc = A42ConCodYDesc ;
         Z41ConDescrip = A41ConDescrip ;
         Z143ConCanti = A143ConCanti ;
         Z158ConValUni = A158ConValUni ;
         Z152ConImporte = A152ConImporte ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int4 = A3CliCod ;
         GXv_int5[0] = GXt_int4 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
         agendanovedades_bc.this.GXt_int4 = GXv_int5[0] ;
         A3CliCod = GXt_int4 ;
      }
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      A114AgeLegActivo = false ;
      if ( isIns( )  && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A111AgeFecDes)) && ( Gx_BScreen == 0 ) )
      {
         A111AgeFecDes = localUtil.ymdtod( GXutil.year( GXutil.serverDate( context, remoteHandle, pr_default)), GXutil.month( GXutil.serverDate( context, remoteHandle, pr_default)), 1) ;
         n111AgeFecDes = false ;
      }
      else
      {
         if ( isIns( )  && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A111AgeFecDes)) && ( Gx_BScreen == 0 ) )
         {
            A111AgeFecDes = localUtil.ymdtod( 2023, 1, 1) ;
            n111AgeFecDes = false ;
         }
      }
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A110AgeCanti)==0) && ( Gx_BScreen == 0 ) )
      {
         A110AgeCanti = DecimalUtil.doubleToDec(1) ;
         n110AgeCanti = false ;
      }
      if ( isIns( )  && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A112AgeFecHas)) && ( Gx_BScreen == 0 ) )
      {
         A112AgeFecHas = localUtil.ymdtod( 2023, 1, 15) ;
         n112AgeFecHas = false ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV29Pgmname = "AgendaNovedades_BC" ;
      }
   }

   public void load063( )
   {
      /* Using cursor BC00067 */
      pr_default.execute(5, new Object[] {Short.valueOf(A25AgeOrden), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A42ConCodYDesc = BC00067_A42ConCodYDesc[0] ;
         n42ConCodYDesc = BC00067_n42ConCodYDesc[0] ;
         A250LegIdNomApe = BC00067_A250LegIdNomApe[0] ;
         A591LegNomApe = BC00067_A591LegNomApe[0] ;
         A2EmpNom = BC00067_A2EmpNom[0] ;
         A230LegApellido = BC00067_A230LegApellido[0] ;
         A251LegNombre = BC00067_A251LegNombre[0] ;
         A244LegFecEgreso = BC00067_A244LegFecEgreso[0] ;
         n244LegFecEgreso = BC00067_n244LegFecEgreso[0] ;
         A41ConDescrip = BC00067_A41ConDescrip[0] ;
         A110AgeCanti = BC00067_A110AgeCanti[0] ;
         n110AgeCanti = BC00067_n110AgeCanti[0] ;
         A115AgeVUnit = BC00067_A115AgeVUnit[0] ;
         n115AgeVUnit = BC00067_n115AgeVUnit[0] ;
         A113AgeImporte = BC00067_A113AgeImporte[0] ;
         n113AgeImporte = BC00067_n113AgeImporte[0] ;
         A111AgeFecDes = BC00067_A111AgeFecDes[0] ;
         n111AgeFecDes = BC00067_n111AgeFecDes[0] ;
         A112AgeFecHas = BC00067_A112AgeFecHas[0] ;
         n112AgeFecHas = BC00067_n112AgeFecHas[0] ;
         A93LegId = BC00067_A93LegId[0] ;
         n93LegId = BC00067_n93LegId[0] ;
         A143ConCanti = BC00067_A143ConCanti[0] ;
         A158ConValUni = BC00067_A158ConValUni[0] ;
         A152ConImporte = BC00067_A152ConImporte[0] ;
         A1254AgeLiqNro = BC00067_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = BC00067_n1254AgeLiqNro[0] ;
         A26ConCodigo = BC00067_A26ConCodigo[0] ;
         zm063( -13) ;
      }
      pr_default.close(5);
      onLoadActions063( ) ;
   }

   public void onLoadActions063( )
   {
      AV29Pgmname = "AgendaNovedades_BC" ;
   }

   public void checkExtendedTable063( )
   {
      nIsDirty_3 = (short)(0) ;
      standaloneModal( ) ;
      AV29Pgmname = "AgendaNovedades_BC" ;
      /* Using cursor BC00068 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
      }
      A42ConCodYDesc = BC00068_A42ConCodYDesc[0] ;
      n42ConCodYDesc = BC00068_n42ConCodYDesc[0] ;
      A41ConDescrip = BC00068_A41ConDescrip[0] ;
      A143ConCanti = BC00068_A143ConCanti[0] ;
      A158ConValUni = BC00068_A158ConValUni[0] ;
      A152ConImporte = BC00068_A152ConImporte[0] ;
      pr_default.close(6);
      /* Using cursor BC00069 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
      }
      A2EmpNom = BC00069_A2EmpNom[0] ;
      pr_default.close(7);
      /* Using cursor BC000610 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
      }
      A250LegIdNomApe = BC000610_A250LegIdNomApe[0] ;
      A591LegNomApe = BC000610_A591LegNomApe[0] ;
      A230LegApellido = BC000610_A230LegApellido[0] ;
      A251LegNombre = BC000610_A251LegNombre[0] ;
      A244LegFecEgreso = BC000610_A244LegFecEgreso[0] ;
      n244LegFecEgreso = BC000610_n244LegFecEgreso[0] ;
      A93LegId = BC000610_A93LegId[0] ;
      n93LegId = BC000610_n93LegId[0] ;
      pr_default.close(8);
      if ( (GXutil.strcmp("", A26ConCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Código", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, A110AgeCanti)==0) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "La cantidad debe ser mayor a cero", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A111AgeFecDes)) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Desde", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A112AgeFecHas)) && GXutil.resetTime(A111AgeFecDes).after( GXutil.resetTime( A112AgeFecHas )) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "La fecha hasta debe ser posterior a la fecha desde", ""), 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors063( )
   {
      pr_default.close(6);
      pr_default.close(7);
      pr_default.close(8);
   }

   public void enableDisable( )
   {
   }

   public void getKey063( )
   {
      /* Using cursor BC000611 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A25AgeOrden)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound3 = (short)(1) ;
      }
      else
      {
         RcdFound3 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000612 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A25AgeOrden)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         zm063( 13) ;
         RcdFound3 = (short)(1) ;
         A25AgeOrden = BC000612_A25AgeOrden[0] ;
         A110AgeCanti = BC000612_A110AgeCanti[0] ;
         n110AgeCanti = BC000612_n110AgeCanti[0] ;
         A115AgeVUnit = BC000612_A115AgeVUnit[0] ;
         n115AgeVUnit = BC000612_n115AgeVUnit[0] ;
         A113AgeImporte = BC000612_A113AgeImporte[0] ;
         n113AgeImporte = BC000612_n113AgeImporte[0] ;
         A111AgeFecDes = BC000612_A111AgeFecDes[0] ;
         n111AgeFecDes = BC000612_n111AgeFecDes[0] ;
         A112AgeFecHas = BC000612_A112AgeFecHas[0] ;
         n112AgeFecHas = BC000612_n112AgeFecHas[0] ;
         A1254AgeLiqNro = BC000612_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = BC000612_n1254AgeLiqNro[0] ;
         A3CliCod = BC000612_A3CliCod[0] ;
         A1EmpCod = BC000612_A1EmpCod[0] ;
         A6LegNumero = BC000612_A6LegNumero[0] ;
         A26ConCodigo = BC000612_A26ConCodigo[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z25AgeOrden = A25AgeOrden ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         load063( ) ;
         if ( AnyError == 1 )
         {
            RcdFound3 = (short)(0) ;
            initializeNonKey063( ) ;
         }
         Gx_mode = sMode3 ;
      }
      else
      {
         RcdFound3 = (short)(0) ;
         initializeNonKey063( ) ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode3 ;
      }
      pr_default.close(10);
   }

   public void getEqualNoModal( )
   {
      getKey063( ) ;
      if ( RcdFound3 == 0 )
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
      confirm_060( ) ;
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

   public void checkOptimisticConcurrency063( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000613 */
         pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A25AgeOrden)});
         if ( (pr_default.getStatus(11) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"AgendaNovedades"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(11) == 101) || ( DecimalUtil.compareTo(Z110AgeCanti, BC000613_A110AgeCanti[0]) != 0 ) || ( DecimalUtil.compareTo(Z115AgeVUnit, BC000613_A115AgeVUnit[0]) != 0 ) || ( DecimalUtil.compareTo(Z113AgeImporte, BC000613_A113AgeImporte[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z111AgeFecDes), GXutil.resetTime(BC000613_A111AgeFecDes[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z112AgeFecHas), GXutil.resetTime(BC000613_A112AgeFecHas[0])) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1254AgeLiqNro != BC000613_A1254AgeLiqNro[0] ) || ( GXutil.strcmp(Z26ConCodigo, BC000613_A26ConCodigo[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"AgendaNovedades"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert063( )
   {
      beforeValidate063( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable063( ) ;
      }
      if ( AnyError == 0 )
      {
         zm063( 0) ;
         checkOptimisticConcurrency063( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm063( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert063( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000614 */
                  pr_default.execute(12, new Object[] {Short.valueOf(A25AgeOrden), Boolean.valueOf(n110AgeCanti), A110AgeCanti, Boolean.valueOf(n115AgeVUnit), A115AgeVUnit, Boolean.valueOf(n113AgeImporte), A113AgeImporte, Boolean.valueOf(n111AgeFecDes), A111AgeFecDes, Boolean.valueOf(n112AgeFecHas), A112AgeFecHas, Boolean.valueOf(n1254AgeLiqNro), Integer.valueOf(A1254AgeLiqNro), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A26ConCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("AgendaNovedades");
                  if ( (pr_default.getStatus(12) == 1) )
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
            load063( ) ;
         }
         endLevel063( ) ;
      }
      closeExtendedTableCursors063( ) ;
   }

   public void update063( )
   {
      beforeValidate063( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable063( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency063( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm063( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate063( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000615 */
                  pr_default.execute(13, new Object[] {Boolean.valueOf(n110AgeCanti), A110AgeCanti, Boolean.valueOf(n115AgeVUnit), A115AgeVUnit, Boolean.valueOf(n113AgeImporte), A113AgeImporte, Boolean.valueOf(n111AgeFecDes), A111AgeFecDes, Boolean.valueOf(n112AgeFecHas), A112AgeFecHas, Boolean.valueOf(n1254AgeLiqNro), Integer.valueOf(A1254AgeLiqNro), A26ConCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A25AgeOrden)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("AgendaNovedades");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"AgendaNovedades"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate063( ) ;
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
         endLevel063( ) ;
      }
      closeExtendedTableCursors063( ) ;
   }

   public void deferredUpdate063( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate063( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency063( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls063( ) ;
         afterConfirm063( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete063( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000616 */
               pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A25AgeOrden)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("AgendaNovedades");
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
      sMode3 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel063( ) ;
      Gx_mode = sMode3 ;
   }

   public void onDeleteControls063( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV29Pgmname = "AgendaNovedades_BC" ;
         /* Using cursor BC000617 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         A2EmpNom = BC000617_A2EmpNom[0] ;
         pr_default.close(15);
         /* Using cursor BC000618 */
         pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         A250LegIdNomApe = BC000618_A250LegIdNomApe[0] ;
         A591LegNomApe = BC000618_A591LegNomApe[0] ;
         A230LegApellido = BC000618_A230LegApellido[0] ;
         A251LegNombre = BC000618_A251LegNombre[0] ;
         A244LegFecEgreso = BC000618_A244LegFecEgreso[0] ;
         n244LegFecEgreso = BC000618_n244LegFecEgreso[0] ;
         A93LegId = BC000618_A93LegId[0] ;
         n93LegId = BC000618_n93LegId[0] ;
         pr_default.close(16);
         /* Using cursor BC000619 */
         pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         A42ConCodYDesc = BC000619_A42ConCodYDesc[0] ;
         n42ConCodYDesc = BC000619_n42ConCodYDesc[0] ;
         A41ConDescrip = BC000619_A41ConDescrip[0] ;
         A143ConCanti = BC000619_A143ConCanti[0] ;
         A158ConValUni = BC000619_A158ConValUni[0] ;
         A152ConImporte = BC000619_A152ConImporte[0] ;
         pr_default.close(17);
      }
   }

   public void endLevel063( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(11);
      }
      if ( AnyError == 0 )
      {
         beforeComplete063( ) ;
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

   public void scanKeyStart063( )
   {
      /* Scan By routine */
      /* Using cursor BC000620 */
      pr_default.execute(18, new Object[] {Short.valueOf(A25AgeOrden), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      RcdFound3 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A42ConCodYDesc = BC000620_A42ConCodYDesc[0] ;
         n42ConCodYDesc = BC000620_n42ConCodYDesc[0] ;
         A250LegIdNomApe = BC000620_A250LegIdNomApe[0] ;
         A591LegNomApe = BC000620_A591LegNomApe[0] ;
         A25AgeOrden = BC000620_A25AgeOrden[0] ;
         A2EmpNom = BC000620_A2EmpNom[0] ;
         A230LegApellido = BC000620_A230LegApellido[0] ;
         A251LegNombre = BC000620_A251LegNombre[0] ;
         A244LegFecEgreso = BC000620_A244LegFecEgreso[0] ;
         n244LegFecEgreso = BC000620_n244LegFecEgreso[0] ;
         A41ConDescrip = BC000620_A41ConDescrip[0] ;
         A110AgeCanti = BC000620_A110AgeCanti[0] ;
         n110AgeCanti = BC000620_n110AgeCanti[0] ;
         A115AgeVUnit = BC000620_A115AgeVUnit[0] ;
         n115AgeVUnit = BC000620_n115AgeVUnit[0] ;
         A113AgeImporte = BC000620_A113AgeImporte[0] ;
         n113AgeImporte = BC000620_n113AgeImporte[0] ;
         A111AgeFecDes = BC000620_A111AgeFecDes[0] ;
         n111AgeFecDes = BC000620_n111AgeFecDes[0] ;
         A112AgeFecHas = BC000620_A112AgeFecHas[0] ;
         n112AgeFecHas = BC000620_n112AgeFecHas[0] ;
         A93LegId = BC000620_A93LegId[0] ;
         n93LegId = BC000620_n93LegId[0] ;
         A143ConCanti = BC000620_A143ConCanti[0] ;
         A158ConValUni = BC000620_A158ConValUni[0] ;
         A152ConImporte = BC000620_A152ConImporte[0] ;
         A1254AgeLiqNro = BC000620_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = BC000620_n1254AgeLiqNro[0] ;
         A3CliCod = BC000620_A3CliCod[0] ;
         A1EmpCod = BC000620_A1EmpCod[0] ;
         A6LegNumero = BC000620_A6LegNumero[0] ;
         A26ConCodigo = BC000620_A26ConCodigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext063( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound3 = (short)(0) ;
      scanKeyLoad063( ) ;
   }

   public void scanKeyLoad063( )
   {
      sMode3 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A42ConCodYDesc = BC000620_A42ConCodYDesc[0] ;
         n42ConCodYDesc = BC000620_n42ConCodYDesc[0] ;
         A250LegIdNomApe = BC000620_A250LegIdNomApe[0] ;
         A591LegNomApe = BC000620_A591LegNomApe[0] ;
         A25AgeOrden = BC000620_A25AgeOrden[0] ;
         A2EmpNom = BC000620_A2EmpNom[0] ;
         A230LegApellido = BC000620_A230LegApellido[0] ;
         A251LegNombre = BC000620_A251LegNombre[0] ;
         A244LegFecEgreso = BC000620_A244LegFecEgreso[0] ;
         n244LegFecEgreso = BC000620_n244LegFecEgreso[0] ;
         A41ConDescrip = BC000620_A41ConDescrip[0] ;
         A110AgeCanti = BC000620_A110AgeCanti[0] ;
         n110AgeCanti = BC000620_n110AgeCanti[0] ;
         A115AgeVUnit = BC000620_A115AgeVUnit[0] ;
         n115AgeVUnit = BC000620_n115AgeVUnit[0] ;
         A113AgeImporte = BC000620_A113AgeImporte[0] ;
         n113AgeImporte = BC000620_n113AgeImporte[0] ;
         A111AgeFecDes = BC000620_A111AgeFecDes[0] ;
         n111AgeFecDes = BC000620_n111AgeFecDes[0] ;
         A112AgeFecHas = BC000620_A112AgeFecHas[0] ;
         n112AgeFecHas = BC000620_n112AgeFecHas[0] ;
         A93LegId = BC000620_A93LegId[0] ;
         n93LegId = BC000620_n93LegId[0] ;
         A143ConCanti = BC000620_A143ConCanti[0] ;
         A158ConValUni = BC000620_A158ConValUni[0] ;
         A152ConImporte = BC000620_A152ConImporte[0] ;
         A1254AgeLiqNro = BC000620_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = BC000620_n1254AgeLiqNro[0] ;
         A3CliCod = BC000620_A3CliCod[0] ;
         A1EmpCod = BC000620_A1EmpCod[0] ;
         A6LegNumero = BC000620_A6LegNumero[0] ;
         A26ConCodigo = BC000620_A26ConCodigo[0] ;
      }
      Gx_mode = sMode3 ;
   }

   public void scanKeyEnd063( )
   {
      pr_default.close(18);
   }

   public void afterConfirm063( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert063( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate063( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete063( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete063( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate063( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes063( )
   {
   }

   public void send_integrity_lvl_hashes063( )
   {
   }

   public void addRow063( )
   {
      VarsToRow3( bcAgendaNovedades) ;
   }

   public void readRow063( )
   {
      RowToVars3( bcAgendaNovedades, 1) ;
   }

   public void initializeNonKey063( )
   {
      A114AgeLegActivo = false ;
      A42ConCodYDesc = "" ;
      n42ConCodYDesc = false ;
      A250LegIdNomApe = "" ;
      A591LegNomApe = "" ;
      A2EmpNom = "" ;
      A230LegApellido = "" ;
      A251LegNombre = "" ;
      A244LegFecEgreso = GXutil.nullDate() ;
      n244LegFecEgreso = false ;
      A26ConCodigo = "" ;
      A41ConDescrip = "" ;
      A115AgeVUnit = DecimalUtil.ZERO ;
      n115AgeVUnit = false ;
      A113AgeImporte = DecimalUtil.ZERO ;
      n113AgeImporte = false ;
      A111AgeFecDes = localUtil.ymdtod( 2023, 1, 1) ;
      n111AgeFecDes = false ;
      A93LegId = "" ;
      n93LegId = false ;
      A143ConCanti = false ;
      A158ConValUni = false ;
      A152ConImporte = false ;
      A1254AgeLiqNro = 0 ;
      n1254AgeLiqNro = false ;
      A110AgeCanti = DecimalUtil.doubleToDec(1) ;
      n110AgeCanti = false ;
      A112AgeFecHas = localUtil.ymdtod( 2023, 1, 15) ;
      n112AgeFecHas = false ;
      Z110AgeCanti = DecimalUtil.ZERO ;
      Z115AgeVUnit = DecimalUtil.ZERO ;
      Z113AgeImporte = DecimalUtil.ZERO ;
      Z111AgeFecDes = GXutil.nullDate() ;
      Z112AgeFecHas = GXutil.nullDate() ;
      Z1254AgeLiqNro = 0 ;
      Z26ConCodigo = "" ;
   }

   public void initAll063( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A6LegNumero = 0 ;
      A25AgeOrden = (short)(0) ;
      initializeNonKey063( ) ;
   }

   public void standaloneModalInsert( )
   {
      A114AgeLegActivo = i114AgeLegActivo ;
      A111AgeFecDes = i111AgeFecDes ;
      n111AgeFecDes = false ;
      A110AgeCanti = i110AgeCanti ;
      n110AgeCanti = false ;
      A112AgeFecHas = i112AgeFecHas ;
      n112AgeFecHas = false ;
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

   public void VarsToRow3( web.SdtAgendaNovedades obj3 )
   {
      obj3.setgxTv_SdtAgendaNovedades_Mode( Gx_mode );
      obj3.setgxTv_SdtAgendaNovedades_Agelegactivo( A114AgeLegActivo );
      obj3.setgxTv_SdtAgendaNovedades_Empnom( A2EmpNom );
      obj3.setgxTv_SdtAgendaNovedades_Legapellido( A230LegApellido );
      obj3.setgxTv_SdtAgendaNovedades_Legnombre( A251LegNombre );
      obj3.setgxTv_SdtAgendaNovedades_Legfecegreso( A244LegFecEgreso );
      obj3.setgxTv_SdtAgendaNovedades_Concodigo( A26ConCodigo );
      obj3.setgxTv_SdtAgendaNovedades_Condescrip( A41ConDescrip );
      obj3.setgxTv_SdtAgendaNovedades_Agevunit( A115AgeVUnit );
      obj3.setgxTv_SdtAgendaNovedades_Ageimporte( A113AgeImporte );
      obj3.setgxTv_SdtAgendaNovedades_Agefecdes( A111AgeFecDes );
      obj3.setgxTv_SdtAgendaNovedades_Legid( A93LegId );
      obj3.setgxTv_SdtAgendaNovedades_Concanti( A143ConCanti );
      obj3.setgxTv_SdtAgendaNovedades_Convaluni( A158ConValUni );
      obj3.setgxTv_SdtAgendaNovedades_Conimporte( A152ConImporte );
      obj3.setgxTv_SdtAgendaNovedades_Ageliqnro( A1254AgeLiqNro );
      obj3.setgxTv_SdtAgendaNovedades_Agecanti( A110AgeCanti );
      obj3.setgxTv_SdtAgendaNovedades_Agefechas( A112AgeFecHas );
      obj3.setgxTv_SdtAgendaNovedades_Clicod( A3CliCod );
      obj3.setgxTv_SdtAgendaNovedades_Empcod( A1EmpCod );
      obj3.setgxTv_SdtAgendaNovedades_Legnumero( A6LegNumero );
      obj3.setgxTv_SdtAgendaNovedades_Ageorden( A25AgeOrden );
      obj3.setgxTv_SdtAgendaNovedades_Clicod_Z( Z3CliCod );
      obj3.setgxTv_SdtAgendaNovedades_Empcod_Z( Z1EmpCod );
      obj3.setgxTv_SdtAgendaNovedades_Empnom_Z( Z2EmpNom );
      obj3.setgxTv_SdtAgendaNovedades_Legnumero_Z( Z6LegNumero );
      obj3.setgxTv_SdtAgendaNovedades_Legapellido_Z( Z230LegApellido );
      obj3.setgxTv_SdtAgendaNovedades_Legnombre_Z( Z251LegNombre );
      obj3.setgxTv_SdtAgendaNovedades_Legfecegreso_Z( Z244LegFecEgreso );
      obj3.setgxTv_SdtAgendaNovedades_Ageorden_Z( Z25AgeOrden );
      obj3.setgxTv_SdtAgendaNovedades_Concodigo_Z( Z26ConCodigo );
      obj3.setgxTv_SdtAgendaNovedades_Condescrip_Z( Z41ConDescrip );
      obj3.setgxTv_SdtAgendaNovedades_Agecanti_Z( Z110AgeCanti );
      obj3.setgxTv_SdtAgendaNovedades_Agevunit_Z( Z115AgeVUnit );
      obj3.setgxTv_SdtAgendaNovedades_Ageimporte_Z( Z113AgeImporte );
      obj3.setgxTv_SdtAgendaNovedades_Agefecdes_Z( Z111AgeFecDes );
      obj3.setgxTv_SdtAgendaNovedades_Agefechas_Z( Z112AgeFecHas );
      obj3.setgxTv_SdtAgendaNovedades_Agelegactivo_Z( Z114AgeLegActivo );
      obj3.setgxTv_SdtAgendaNovedades_Legid_Z( Z93LegId );
      obj3.setgxTv_SdtAgendaNovedades_Concanti_Z( Z143ConCanti );
      obj3.setgxTv_SdtAgendaNovedades_Convaluni_Z( Z158ConValUni );
      obj3.setgxTv_SdtAgendaNovedades_Conimporte_Z( Z152ConImporte );
      obj3.setgxTv_SdtAgendaNovedades_Ageliqnro_Z( Z1254AgeLiqNro );
      obj3.setgxTv_SdtAgendaNovedades_Legfecegreso_N( (byte)((byte)((n244LegFecEgreso)?1:0)) );
      obj3.setgxTv_SdtAgendaNovedades_Agecanti_N( (byte)((byte)((n110AgeCanti)?1:0)) );
      obj3.setgxTv_SdtAgendaNovedades_Agevunit_N( (byte)((byte)((n115AgeVUnit)?1:0)) );
      obj3.setgxTv_SdtAgendaNovedades_Ageimporte_N( (byte)((byte)((n113AgeImporte)?1:0)) );
      obj3.setgxTv_SdtAgendaNovedades_Agefecdes_N( (byte)((byte)((n111AgeFecDes)?1:0)) );
      obj3.setgxTv_SdtAgendaNovedades_Agefechas_N( (byte)((byte)((n112AgeFecHas)?1:0)) );
      obj3.setgxTv_SdtAgendaNovedades_Legid_N( (byte)((byte)((n93LegId)?1:0)) );
      obj3.setgxTv_SdtAgendaNovedades_Ageliqnro_N( (byte)((byte)((n1254AgeLiqNro)?1:0)) );
      obj3.setgxTv_SdtAgendaNovedades_Mode( Gx_mode );
   }

   public void KeyVarsToRow3( web.SdtAgendaNovedades obj3 )
   {
      obj3.setgxTv_SdtAgendaNovedades_Clicod( A3CliCod );
      obj3.setgxTv_SdtAgendaNovedades_Empcod( A1EmpCod );
      obj3.setgxTv_SdtAgendaNovedades_Legnumero( A6LegNumero );
      obj3.setgxTv_SdtAgendaNovedades_Ageorden( A25AgeOrden );
   }

   public void RowToVars3( web.SdtAgendaNovedades obj3 ,
                           int forceLoad )
   {
      Gx_mode = obj3.getgxTv_SdtAgendaNovedades_Mode() ;
      A114AgeLegActivo = obj3.getgxTv_SdtAgendaNovedades_Agelegactivo() ;
      A2EmpNom = obj3.getgxTv_SdtAgendaNovedades_Empnom() ;
      A230LegApellido = obj3.getgxTv_SdtAgendaNovedades_Legapellido() ;
      A251LegNombre = obj3.getgxTv_SdtAgendaNovedades_Legnombre() ;
      A244LegFecEgreso = obj3.getgxTv_SdtAgendaNovedades_Legfecegreso() ;
      n244LegFecEgreso = false ;
      if ( ! ( isUpd( )  ) || ( forceLoad == 1 ) )
      {
         A26ConCodigo = obj3.getgxTv_SdtAgendaNovedades_Concodigo() ;
      }
      A41ConDescrip = obj3.getgxTv_SdtAgendaNovedades_Condescrip() ;
      A115AgeVUnit = obj3.getgxTv_SdtAgendaNovedades_Agevunit() ;
      n115AgeVUnit = false ;
      A113AgeImporte = obj3.getgxTv_SdtAgendaNovedades_Ageimporte() ;
      n113AgeImporte = false ;
      A111AgeFecDes = obj3.getgxTv_SdtAgendaNovedades_Agefecdes() ;
      n111AgeFecDes = false ;
      A93LegId = obj3.getgxTv_SdtAgendaNovedades_Legid() ;
      n93LegId = false ;
      A143ConCanti = obj3.getgxTv_SdtAgendaNovedades_Concanti() ;
      A158ConValUni = obj3.getgxTv_SdtAgendaNovedades_Convaluni() ;
      A152ConImporte = obj3.getgxTv_SdtAgendaNovedades_Conimporte() ;
      A1254AgeLiqNro = obj3.getgxTv_SdtAgendaNovedades_Ageliqnro() ;
      n1254AgeLiqNro = false ;
      A110AgeCanti = obj3.getgxTv_SdtAgendaNovedades_Agecanti() ;
      n110AgeCanti = false ;
      A112AgeFecHas = obj3.getgxTv_SdtAgendaNovedades_Agefechas() ;
      n112AgeFecHas = false ;
      A3CliCod = obj3.getgxTv_SdtAgendaNovedades_Clicod() ;
      A1EmpCod = obj3.getgxTv_SdtAgendaNovedades_Empcod() ;
      A6LegNumero = obj3.getgxTv_SdtAgendaNovedades_Legnumero() ;
      A25AgeOrden = obj3.getgxTv_SdtAgendaNovedades_Ageorden() ;
      Z3CliCod = obj3.getgxTv_SdtAgendaNovedades_Clicod_Z() ;
      Z1EmpCod = obj3.getgxTv_SdtAgendaNovedades_Empcod_Z() ;
      Z2EmpNom = obj3.getgxTv_SdtAgendaNovedades_Empnom_Z() ;
      Z6LegNumero = obj3.getgxTv_SdtAgendaNovedades_Legnumero_Z() ;
      Z230LegApellido = obj3.getgxTv_SdtAgendaNovedades_Legapellido_Z() ;
      Z251LegNombre = obj3.getgxTv_SdtAgendaNovedades_Legnombre_Z() ;
      Z244LegFecEgreso = obj3.getgxTv_SdtAgendaNovedades_Legfecegreso_Z() ;
      Z25AgeOrden = obj3.getgxTv_SdtAgendaNovedades_Ageorden_Z() ;
      Z26ConCodigo = obj3.getgxTv_SdtAgendaNovedades_Concodigo_Z() ;
      Z41ConDescrip = obj3.getgxTv_SdtAgendaNovedades_Condescrip_Z() ;
      Z110AgeCanti = obj3.getgxTv_SdtAgendaNovedades_Agecanti_Z() ;
      Z115AgeVUnit = obj3.getgxTv_SdtAgendaNovedades_Agevunit_Z() ;
      Z113AgeImporte = obj3.getgxTv_SdtAgendaNovedades_Ageimporte_Z() ;
      Z111AgeFecDes = obj3.getgxTv_SdtAgendaNovedades_Agefecdes_Z() ;
      Z112AgeFecHas = obj3.getgxTv_SdtAgendaNovedades_Agefechas_Z() ;
      Z114AgeLegActivo = obj3.getgxTv_SdtAgendaNovedades_Agelegactivo_Z() ;
      Z93LegId = obj3.getgxTv_SdtAgendaNovedades_Legid_Z() ;
      Z143ConCanti = obj3.getgxTv_SdtAgendaNovedades_Concanti_Z() ;
      Z158ConValUni = obj3.getgxTv_SdtAgendaNovedades_Convaluni_Z() ;
      Z152ConImporte = obj3.getgxTv_SdtAgendaNovedades_Conimporte_Z() ;
      Z1254AgeLiqNro = obj3.getgxTv_SdtAgendaNovedades_Ageliqnro_Z() ;
      n244LegFecEgreso = (boolean)((obj3.getgxTv_SdtAgendaNovedades_Legfecegreso_N()==0)?false:true) ;
      n110AgeCanti = (boolean)((obj3.getgxTv_SdtAgendaNovedades_Agecanti_N()==0)?false:true) ;
      n115AgeVUnit = (boolean)((obj3.getgxTv_SdtAgendaNovedades_Agevunit_N()==0)?false:true) ;
      n113AgeImporte = (boolean)((obj3.getgxTv_SdtAgendaNovedades_Ageimporte_N()==0)?false:true) ;
      n111AgeFecDes = (boolean)((obj3.getgxTv_SdtAgendaNovedades_Agefecdes_N()==0)?false:true) ;
      n112AgeFecHas = (boolean)((obj3.getgxTv_SdtAgendaNovedades_Agefechas_N()==0)?false:true) ;
      n93LegId = (boolean)((obj3.getgxTv_SdtAgendaNovedades_Legid_N()==0)?false:true) ;
      n1254AgeLiqNro = (boolean)((obj3.getgxTv_SdtAgendaNovedades_Ageliqnro_N()==0)?false:true) ;
      Gx_mode = obj3.getgxTv_SdtAgendaNovedades_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A6LegNumero = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.INT)).intValue() ;
      A25AgeOrden = ((Number) GXutil.testNumericType( getParm(obj,3), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey063( ) ;
      scanKeyStart063( ) ;
      if ( RcdFound3 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000621 */
         pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(19) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         A2EmpNom = BC000621_A2EmpNom[0] ;
         pr_default.close(19);
         /* Using cursor BC000622 */
         pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(20) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
         }
         A250LegIdNomApe = BC000622_A250LegIdNomApe[0] ;
         A591LegNomApe = BC000622_A591LegNomApe[0] ;
         A230LegApellido = BC000622_A230LegApellido[0] ;
         A251LegNombre = BC000622_A251LegNombre[0] ;
         A244LegFecEgreso = BC000622_A244LegFecEgreso[0] ;
         n244LegFecEgreso = BC000622_n244LegFecEgreso[0] ;
         A93LegId = BC000622_A93LegId[0] ;
         n93LegId = BC000622_n93LegId[0] ;
         pr_default.close(20);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z25AgeOrden = A25AgeOrden ;
      }
      zm063( -13) ;
      onLoadActions063( ) ;
      addRow063( ) ;
      scanKeyEnd063( ) ;
      if ( RcdFound3 == 0 )
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
      RowToVars3( bcAgendaNovedades, 0) ;
      scanKeyStart063( ) ;
      if ( RcdFound3 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000623 */
         pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(21) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         A2EmpNom = BC000623_A2EmpNom[0] ;
         pr_default.close(21);
         /* Using cursor BC000624 */
         pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(22) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
         }
         A250LegIdNomApe = BC000624_A250LegIdNomApe[0] ;
         A591LegNomApe = BC000624_A591LegNomApe[0] ;
         A230LegApellido = BC000624_A230LegApellido[0] ;
         A251LegNombre = BC000624_A251LegNombre[0] ;
         A244LegFecEgreso = BC000624_A244LegFecEgreso[0] ;
         n244LegFecEgreso = BC000624_n244LegFecEgreso[0] ;
         A93LegId = BC000624_A93LegId[0] ;
         n93LegId = BC000624_n93LegId[0] ;
         pr_default.close(22);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z25AgeOrden = A25AgeOrden ;
      }
      zm063( -13) ;
      onLoadActions063( ) ;
      addRow063( ) ;
      scanKeyEnd063( ) ;
      if ( RcdFound3 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey063( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert063( ) ;
      }
      else
      {
         if ( RcdFound3 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A25AgeOrden != Z25AgeOrden ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A6LegNumero = Z6LegNumero ;
               A25AgeOrden = Z25AgeOrden ;
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
               update063( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A25AgeOrden != Z25AgeOrden ) )
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
                     insert063( ) ;
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
                     insert063( ) ;
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
      RowToVars3( bcAgendaNovedades, 1) ;
      saveImpl( ) ;
      VarsToRow3( bcAgendaNovedades) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars3( bcAgendaNovedades, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert063( ) ;
      afterTrn( ) ;
      VarsToRow3( bcAgendaNovedades) ;
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
         web.SdtAgendaNovedades auxBC = new web.SdtAgendaNovedades( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A6LegNumero, A25AgeOrden);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcAgendaNovedades);
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
      RowToVars3( bcAgendaNovedades, 1) ;
      updateImpl( ) ;
      VarsToRow3( bcAgendaNovedades) ;
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
      RowToVars3( bcAgendaNovedades, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert063( ) ;
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
      VarsToRow3( bcAgendaNovedades) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars3( bcAgendaNovedades, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey063( ) ;
      if ( RcdFound3 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A25AgeOrden != Z25AgeOrden ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A6LegNumero = Z6LegNumero ;
            A25AgeOrden = Z25AgeOrden ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A25AgeOrden != Z25AgeOrden ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "agendanovedades_bc");
      VarsToRow3( bcAgendaNovedades) ;
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
      Gx_mode = bcAgendaNovedades.getgxTv_SdtAgendaNovedades_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcAgendaNovedades.setgxTv_SdtAgendaNovedades_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtAgendaNovedades sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcAgendaNovedades )
      {
         bcAgendaNovedades = sdt ;
         if ( GXutil.strcmp(bcAgendaNovedades.getgxTv_SdtAgendaNovedades_Mode(), "") == 0 )
         {
            bcAgendaNovedades.setgxTv_SdtAgendaNovedades_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow3( bcAgendaNovedades) ;
         }
         else
         {
            RowToVars3( bcAgendaNovedades, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcAgendaNovedades.getgxTv_SdtAgendaNovedades_Mode(), "") == 0 )
         {
            bcAgendaNovedades.setgxTv_SdtAgendaNovedades_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars3( bcAgendaNovedades, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtAgendaNovedades getAgendaNovedades_BC( )
   {
      return bcAgendaNovedades ;
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
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV29Pgmname = "" ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV13Insert_ConCodigo = "" ;
      Z110AgeCanti = DecimalUtil.ZERO ;
      A110AgeCanti = DecimalUtil.ZERO ;
      Z115AgeVUnit = DecimalUtil.ZERO ;
      A115AgeVUnit = DecimalUtil.ZERO ;
      Z113AgeImporte = DecimalUtil.ZERO ;
      A113AgeImporte = DecimalUtil.ZERO ;
      Z111AgeFecDes = GXutil.nullDate() ;
      A111AgeFecDes = GXutil.nullDate() ;
      Z112AgeFecHas = GXutil.nullDate() ;
      A112AgeFecHas = GXutil.nullDate() ;
      Z26ConCodigo = "" ;
      A26ConCodigo = "" ;
      Z2EmpNom = "" ;
      A2EmpNom = "" ;
      Z250LegIdNomApe = "" ;
      A250LegIdNomApe = "" ;
      Z591LegNomApe = "" ;
      A591LegNomApe = "" ;
      Z230LegApellido = "" ;
      A230LegApellido = "" ;
      Z251LegNombre = "" ;
      A251LegNombre = "" ;
      Z244LegFecEgreso = GXutil.nullDate() ;
      A244LegFecEgreso = GXutil.nullDate() ;
      Z93LegId = "" ;
      A93LegId = "" ;
      Z42ConCodYDesc = "" ;
      A42ConCodYDesc = "" ;
      Z41ConDescrip = "" ;
      A41ConDescrip = "" ;
      GXv_int5 = new int[1] ;
      BC00067_A42ConCodYDesc = new String[] {""} ;
      BC00067_n42ConCodYDesc = new boolean[] {false} ;
      BC00067_A250LegIdNomApe = new String[] {""} ;
      BC00067_A591LegNomApe = new String[] {""} ;
      BC00067_A25AgeOrden = new short[1] ;
      BC00067_A2EmpNom = new String[] {""} ;
      BC00067_A230LegApellido = new String[] {""} ;
      BC00067_A251LegNombre = new String[] {""} ;
      BC00067_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC00067_n244LegFecEgreso = new boolean[] {false} ;
      BC00067_A41ConDescrip = new String[] {""} ;
      BC00067_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC00067_n110AgeCanti = new boolean[] {false} ;
      BC00067_A115AgeVUnit = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC00067_n115AgeVUnit = new boolean[] {false} ;
      BC00067_A113AgeImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC00067_n113AgeImporte = new boolean[] {false} ;
      BC00067_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      BC00067_n111AgeFecDes = new boolean[] {false} ;
      BC00067_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      BC00067_n112AgeFecHas = new boolean[] {false} ;
      BC00067_A93LegId = new String[] {""} ;
      BC00067_n93LegId = new boolean[] {false} ;
      BC00067_A143ConCanti = new boolean[] {false} ;
      BC00067_A158ConValUni = new boolean[] {false} ;
      BC00067_A152ConImporte = new boolean[] {false} ;
      BC00067_A1254AgeLiqNro = new int[1] ;
      BC00067_n1254AgeLiqNro = new boolean[] {false} ;
      BC00067_A3CliCod = new int[1] ;
      BC00067_A1EmpCod = new short[1] ;
      BC00067_A6LegNumero = new int[1] ;
      BC00067_A26ConCodigo = new String[] {""} ;
      BC00068_A42ConCodYDesc = new String[] {""} ;
      BC00068_n42ConCodYDesc = new boolean[] {false} ;
      BC00068_A41ConDescrip = new String[] {""} ;
      BC00068_A143ConCanti = new boolean[] {false} ;
      BC00068_A158ConValUni = new boolean[] {false} ;
      BC00068_A152ConImporte = new boolean[] {false} ;
      BC00069_A2EmpNom = new String[] {""} ;
      BC000610_A250LegIdNomApe = new String[] {""} ;
      BC000610_A591LegNomApe = new String[] {""} ;
      BC000610_A230LegApellido = new String[] {""} ;
      BC000610_A251LegNombre = new String[] {""} ;
      BC000610_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000610_n244LegFecEgreso = new boolean[] {false} ;
      BC000610_A93LegId = new String[] {""} ;
      BC000610_n93LegId = new boolean[] {false} ;
      BC000611_A3CliCod = new int[1] ;
      BC000611_A1EmpCod = new short[1] ;
      BC000611_A6LegNumero = new int[1] ;
      BC000611_A25AgeOrden = new short[1] ;
      BC000612_A25AgeOrden = new short[1] ;
      BC000612_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000612_n110AgeCanti = new boolean[] {false} ;
      BC000612_A115AgeVUnit = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000612_n115AgeVUnit = new boolean[] {false} ;
      BC000612_A113AgeImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000612_n113AgeImporte = new boolean[] {false} ;
      BC000612_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      BC000612_n111AgeFecDes = new boolean[] {false} ;
      BC000612_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      BC000612_n112AgeFecHas = new boolean[] {false} ;
      BC000612_A1254AgeLiqNro = new int[1] ;
      BC000612_n1254AgeLiqNro = new boolean[] {false} ;
      BC000612_A3CliCod = new int[1] ;
      BC000612_A1EmpCod = new short[1] ;
      BC000612_A6LegNumero = new int[1] ;
      BC000612_A26ConCodigo = new String[] {""} ;
      sMode3 = "" ;
      BC000613_A25AgeOrden = new short[1] ;
      BC000613_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000613_n110AgeCanti = new boolean[] {false} ;
      BC000613_A115AgeVUnit = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000613_n115AgeVUnit = new boolean[] {false} ;
      BC000613_A113AgeImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000613_n113AgeImporte = new boolean[] {false} ;
      BC000613_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      BC000613_n111AgeFecDes = new boolean[] {false} ;
      BC000613_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      BC000613_n112AgeFecHas = new boolean[] {false} ;
      BC000613_A1254AgeLiqNro = new int[1] ;
      BC000613_n1254AgeLiqNro = new boolean[] {false} ;
      BC000613_A3CliCod = new int[1] ;
      BC000613_A1EmpCod = new short[1] ;
      BC000613_A6LegNumero = new int[1] ;
      BC000613_A26ConCodigo = new String[] {""} ;
      BC000617_A2EmpNom = new String[] {""} ;
      BC000618_A250LegIdNomApe = new String[] {""} ;
      BC000618_A591LegNomApe = new String[] {""} ;
      BC000618_A230LegApellido = new String[] {""} ;
      BC000618_A251LegNombre = new String[] {""} ;
      BC000618_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000618_n244LegFecEgreso = new boolean[] {false} ;
      BC000618_A93LegId = new String[] {""} ;
      BC000618_n93LegId = new boolean[] {false} ;
      BC000619_A42ConCodYDesc = new String[] {""} ;
      BC000619_n42ConCodYDesc = new boolean[] {false} ;
      BC000619_A41ConDescrip = new String[] {""} ;
      BC000619_A143ConCanti = new boolean[] {false} ;
      BC000619_A158ConValUni = new boolean[] {false} ;
      BC000619_A152ConImporte = new boolean[] {false} ;
      BC000620_A42ConCodYDesc = new String[] {""} ;
      BC000620_n42ConCodYDesc = new boolean[] {false} ;
      BC000620_A250LegIdNomApe = new String[] {""} ;
      BC000620_A591LegNomApe = new String[] {""} ;
      BC000620_A25AgeOrden = new short[1] ;
      BC000620_A2EmpNom = new String[] {""} ;
      BC000620_A230LegApellido = new String[] {""} ;
      BC000620_A251LegNombre = new String[] {""} ;
      BC000620_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000620_n244LegFecEgreso = new boolean[] {false} ;
      BC000620_A41ConDescrip = new String[] {""} ;
      BC000620_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000620_n110AgeCanti = new boolean[] {false} ;
      BC000620_A115AgeVUnit = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000620_n115AgeVUnit = new boolean[] {false} ;
      BC000620_A113AgeImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000620_n113AgeImporte = new boolean[] {false} ;
      BC000620_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      BC000620_n111AgeFecDes = new boolean[] {false} ;
      BC000620_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      BC000620_n112AgeFecHas = new boolean[] {false} ;
      BC000620_A93LegId = new String[] {""} ;
      BC000620_n93LegId = new boolean[] {false} ;
      BC000620_A143ConCanti = new boolean[] {false} ;
      BC000620_A158ConValUni = new boolean[] {false} ;
      BC000620_A152ConImporte = new boolean[] {false} ;
      BC000620_A1254AgeLiqNro = new int[1] ;
      BC000620_n1254AgeLiqNro = new boolean[] {false} ;
      BC000620_A3CliCod = new int[1] ;
      BC000620_A1EmpCod = new short[1] ;
      BC000620_A6LegNumero = new int[1] ;
      BC000620_A26ConCodigo = new String[] {""} ;
      i111AgeFecDes = GXutil.nullDate() ;
      i110AgeCanti = DecimalUtil.ZERO ;
      i112AgeFecHas = GXutil.nullDate() ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC000621_A2EmpNom = new String[] {""} ;
      BC000622_A250LegIdNomApe = new String[] {""} ;
      BC000622_A591LegNomApe = new String[] {""} ;
      BC000622_A230LegApellido = new String[] {""} ;
      BC000622_A251LegNombre = new String[] {""} ;
      BC000622_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000622_n244LegFecEgreso = new boolean[] {false} ;
      BC000622_A93LegId = new String[] {""} ;
      BC000622_n93LegId = new boolean[] {false} ;
      BC000623_A2EmpNom = new String[] {""} ;
      BC000624_A250LegIdNomApe = new String[] {""} ;
      BC000624_A591LegNomApe = new String[] {""} ;
      BC000624_A230LegApellido = new String[] {""} ;
      BC000624_A251LegNombre = new String[] {""} ;
      BC000624_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC000624_n244LegFecEgreso = new boolean[] {false} ;
      BC000624_A93LegId = new String[] {""} ;
      BC000624_n93LegId = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.agendanovedades_bc__default(),
         new Object[] {
             new Object[] {
            BC00062_A25AgeOrden, BC00062_A110AgeCanti, BC00062_n110AgeCanti, BC00062_A115AgeVUnit, BC00062_n115AgeVUnit, BC00062_A113AgeImporte, BC00062_n113AgeImporte, BC00062_A111AgeFecDes, BC00062_n111AgeFecDes, BC00062_A112AgeFecHas,
            BC00062_n112AgeFecHas, BC00062_A1254AgeLiqNro, BC00062_n1254AgeLiqNro, BC00062_A3CliCod, BC00062_A1EmpCod, BC00062_A6LegNumero, BC00062_A26ConCodigo
            }
            , new Object[] {
            BC00063_A25AgeOrden, BC00063_A110AgeCanti, BC00063_n110AgeCanti, BC00063_A115AgeVUnit, BC00063_n115AgeVUnit, BC00063_A113AgeImporte, BC00063_n113AgeImporte, BC00063_A111AgeFecDes, BC00063_n111AgeFecDes, BC00063_A112AgeFecHas,
            BC00063_n112AgeFecHas, BC00063_A1254AgeLiqNro, BC00063_n1254AgeLiqNro, BC00063_A3CliCod, BC00063_A1EmpCod, BC00063_A6LegNumero, BC00063_A26ConCodigo
            }
            , new Object[] {
            BC00064_A2EmpNom
            }
            , new Object[] {
            BC00065_A250LegIdNomApe, BC00065_A591LegNomApe, BC00065_A230LegApellido, BC00065_A251LegNombre, BC00065_A244LegFecEgreso, BC00065_n244LegFecEgreso, BC00065_A93LegId, BC00065_n93LegId
            }
            , new Object[] {
            BC00066_A42ConCodYDesc, BC00066_n42ConCodYDesc, BC00066_A41ConDescrip, BC00066_A143ConCanti, BC00066_A158ConValUni, BC00066_A152ConImporte
            }
            , new Object[] {
            BC00067_A42ConCodYDesc, BC00067_n42ConCodYDesc, BC00067_A250LegIdNomApe, BC00067_A591LegNomApe, BC00067_A25AgeOrden, BC00067_A2EmpNom, BC00067_A230LegApellido, BC00067_A251LegNombre, BC00067_A244LegFecEgreso, BC00067_n244LegFecEgreso,
            BC00067_A41ConDescrip, BC00067_A110AgeCanti, BC00067_n110AgeCanti, BC00067_A115AgeVUnit, BC00067_n115AgeVUnit, BC00067_A113AgeImporte, BC00067_n113AgeImporte, BC00067_A111AgeFecDes, BC00067_n111AgeFecDes, BC00067_A112AgeFecHas,
            BC00067_n112AgeFecHas, BC00067_A93LegId, BC00067_n93LegId, BC00067_A143ConCanti, BC00067_A158ConValUni, BC00067_A152ConImporte, BC00067_A1254AgeLiqNro, BC00067_n1254AgeLiqNro, BC00067_A3CliCod, BC00067_A1EmpCod,
            BC00067_A6LegNumero, BC00067_A26ConCodigo
            }
            , new Object[] {
            BC00068_A42ConCodYDesc, BC00068_n42ConCodYDesc, BC00068_A41ConDescrip, BC00068_A143ConCanti, BC00068_A158ConValUni, BC00068_A152ConImporte
            }
            , new Object[] {
            BC00069_A2EmpNom
            }
            , new Object[] {
            BC000610_A250LegIdNomApe, BC000610_A591LegNomApe, BC000610_A230LegApellido, BC000610_A251LegNombre, BC000610_A244LegFecEgreso, BC000610_n244LegFecEgreso, BC000610_A93LegId, BC000610_n93LegId
            }
            , new Object[] {
            BC000611_A3CliCod, BC000611_A1EmpCod, BC000611_A6LegNumero, BC000611_A25AgeOrden
            }
            , new Object[] {
            BC000612_A25AgeOrden, BC000612_A110AgeCanti, BC000612_n110AgeCanti, BC000612_A115AgeVUnit, BC000612_n115AgeVUnit, BC000612_A113AgeImporte, BC000612_n113AgeImporte, BC000612_A111AgeFecDes, BC000612_n111AgeFecDes, BC000612_A112AgeFecHas,
            BC000612_n112AgeFecHas, BC000612_A1254AgeLiqNro, BC000612_n1254AgeLiqNro, BC000612_A3CliCod, BC000612_A1EmpCod, BC000612_A6LegNumero, BC000612_A26ConCodigo
            }
            , new Object[] {
            BC000613_A25AgeOrden, BC000613_A110AgeCanti, BC000613_n110AgeCanti, BC000613_A115AgeVUnit, BC000613_n115AgeVUnit, BC000613_A113AgeImporte, BC000613_n113AgeImporte, BC000613_A111AgeFecDes, BC000613_n111AgeFecDes, BC000613_A112AgeFecHas,
            BC000613_n112AgeFecHas, BC000613_A1254AgeLiqNro, BC000613_n1254AgeLiqNro, BC000613_A3CliCod, BC000613_A1EmpCod, BC000613_A6LegNumero, BC000613_A26ConCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000617_A2EmpNom
            }
            , new Object[] {
            BC000618_A250LegIdNomApe, BC000618_A591LegNomApe, BC000618_A230LegApellido, BC000618_A251LegNombre, BC000618_A244LegFecEgreso, BC000618_n244LegFecEgreso, BC000618_A93LegId, BC000618_n93LegId
            }
            , new Object[] {
            BC000619_A42ConCodYDesc, BC000619_n42ConCodYDesc, BC000619_A41ConDescrip, BC000619_A143ConCanti, BC000619_A158ConValUni, BC000619_A152ConImporte
            }
            , new Object[] {
            BC000620_A42ConCodYDesc, BC000620_n42ConCodYDesc, BC000620_A250LegIdNomApe, BC000620_A591LegNomApe, BC000620_A25AgeOrden, BC000620_A2EmpNom, BC000620_A230LegApellido, BC000620_A251LegNombre, BC000620_A244LegFecEgreso, BC000620_n244LegFecEgreso,
            BC000620_A41ConDescrip, BC000620_A110AgeCanti, BC000620_n110AgeCanti, BC000620_A115AgeVUnit, BC000620_n115AgeVUnit, BC000620_A113AgeImporte, BC000620_n113AgeImporte, BC000620_A111AgeFecDes, BC000620_n111AgeFecDes, BC000620_A112AgeFecHas,
            BC000620_n112AgeFecHas, BC000620_A93LegId, BC000620_n93LegId, BC000620_A143ConCanti, BC000620_A158ConValUni, BC000620_A152ConImporte, BC000620_A1254AgeLiqNro, BC000620_n1254AgeLiqNro, BC000620_A3CliCod, BC000620_A1EmpCod,
            BC000620_A6LegNumero, BC000620_A26ConCodigo
            }
            , new Object[] {
            BC000621_A2EmpNom
            }
            , new Object[] {
            BC000622_A250LegIdNomApe, BC000622_A591LegNomApe, BC000622_A230LegApellido, BC000622_A251LegNombre, BC000622_A244LegFecEgreso, BC000622_n244LegFecEgreso, BC000622_A93LegId, BC000622_n93LegId
            }
            , new Object[] {
            BC000623_A2EmpNom
            }
            , new Object[] {
            BC000624_A250LegIdNomApe, BC000624_A591LegNomApe, BC000624_A230LegApellido, BC000624_A251LegNombre, BC000624_A244LegFecEgreso, BC000624_n244LegFecEgreso, BC000624_A93LegId, BC000624_n93LegId
            }
         }
      );
      AV29Pgmname = "AgendaNovedades_BC" ;
      Z112AgeFecHas = localUtil.ymdtod( 2023, 1, 15) ;
      n112AgeFecHas = false ;
      A112AgeFecHas = localUtil.ymdtod( 2023, 1, 15) ;
      n112AgeFecHas = false ;
      i112AgeFecHas = localUtil.ymdtod( 2023, 1, 15) ;
      n112AgeFecHas = false ;
      Z111AgeFecDes = localUtil.ymdtod( 2023, 1, 1) ;
      n111AgeFecDes = false ;
      A111AgeFecDes = localUtil.ymdtod( 2023, 1, 1) ;
      n111AgeFecDes = false ;
      i111AgeFecDes = localUtil.ymdtod( 2023, 1, 1) ;
      n111AgeFecDes = false ;
      Z110AgeCanti = DecimalUtil.doubleToDec(1) ;
      n110AgeCanti = false ;
      A110AgeCanti = DecimalUtil.doubleToDec(1) ;
      n110AgeCanti = false ;
      i110AgeCanti = DecimalUtil.doubleToDec(1) ;
      n110AgeCanti = false ;
      Z111AgeFecDes = localUtil.ymdtod( 2023, 1, 1) ;
      n111AgeFecDes = false ;
      A111AgeFecDes = localUtil.ymdtod( 2023, 1, 1) ;
      n111AgeFecDes = false ;
      i111AgeFecDes = localUtil.ymdtod( 2023, 1, 1) ;
      n111AgeFecDes = false ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12062 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short Z25AgeOrden ;
   private short A25AgeOrden ;
   private short RcdFound3 ;
   private short nIsDirty_3 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int Z6LegNumero ;
   private int A6LegNumero ;
   private int AV30GXV1 ;
   private int AV27Insert_AgeLiqNro ;
   private int GX_JID ;
   private int Z1254AgeLiqNro ;
   private int A1254AgeLiqNro ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private java.math.BigDecimal Z110AgeCanti ;
   private java.math.BigDecimal A110AgeCanti ;
   private java.math.BigDecimal Z115AgeVUnit ;
   private java.math.BigDecimal A115AgeVUnit ;
   private java.math.BigDecimal Z113AgeImporte ;
   private java.math.BigDecimal A113AgeImporte ;
   private java.math.BigDecimal i110AgeCanti ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV29Pgmname ;
   private String AV13Insert_ConCodigo ;
   private String Z26ConCodigo ;
   private String A26ConCodigo ;
   private String Z93LegId ;
   private String A93LegId ;
   private String sMode3 ;
   private java.util.Date Z111AgeFecDes ;
   private java.util.Date A111AgeFecDes ;
   private java.util.Date Z112AgeFecHas ;
   private java.util.Date A112AgeFecHas ;
   private java.util.Date Z244LegFecEgreso ;
   private java.util.Date A244LegFecEgreso ;
   private java.util.Date i111AgeFecDes ;
   private java.util.Date i112AgeFecHas ;
   private boolean returnInSub ;
   private boolean AV22IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z114AgeLegActivo ;
   private boolean A114AgeLegActivo ;
   private boolean Z143ConCanti ;
   private boolean A143ConCanti ;
   private boolean Z158ConValUni ;
   private boolean A158ConValUni ;
   private boolean Z152ConImporte ;
   private boolean A152ConImporte ;
   private boolean n111AgeFecDes ;
   private boolean n110AgeCanti ;
   private boolean n112AgeFecHas ;
   private boolean n42ConCodYDesc ;
   private boolean n244LegFecEgreso ;
   private boolean n115AgeVUnit ;
   private boolean n113AgeImporte ;
   private boolean n93LegId ;
   private boolean n1254AgeLiqNro ;
   private boolean Gx_longc ;
   private boolean i114AgeLegActivo ;
   private boolean mustCommit ;
   private String Z2EmpNom ;
   private String A2EmpNom ;
   private String Z250LegIdNomApe ;
   private String A250LegIdNomApe ;
   private String Z591LegNomApe ;
   private String A591LegNomApe ;
   private String Z230LegApellido ;
   private String A230LegApellido ;
   private String Z251LegNombre ;
   private String A251LegNombre ;
   private String Z42ConCodYDesc ;
   private String A42ConCodYDesc ;
   private String Z41ConDescrip ;
   private String A41ConDescrip ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private web.SdtAgendaNovedades bcAgendaNovedades ;
   private IDataStoreProvider pr_default ;
   private String[] BC00067_A42ConCodYDesc ;
   private boolean[] BC00067_n42ConCodYDesc ;
   private String[] BC00067_A250LegIdNomApe ;
   private String[] BC00067_A591LegNomApe ;
   private short[] BC00067_A25AgeOrden ;
   private String[] BC00067_A2EmpNom ;
   private String[] BC00067_A230LegApellido ;
   private String[] BC00067_A251LegNombre ;
   private java.util.Date[] BC00067_A244LegFecEgreso ;
   private boolean[] BC00067_n244LegFecEgreso ;
   private String[] BC00067_A41ConDescrip ;
   private java.math.BigDecimal[] BC00067_A110AgeCanti ;
   private boolean[] BC00067_n110AgeCanti ;
   private java.math.BigDecimal[] BC00067_A115AgeVUnit ;
   private boolean[] BC00067_n115AgeVUnit ;
   private java.math.BigDecimal[] BC00067_A113AgeImporte ;
   private boolean[] BC00067_n113AgeImporte ;
   private java.util.Date[] BC00067_A111AgeFecDes ;
   private boolean[] BC00067_n111AgeFecDes ;
   private java.util.Date[] BC00067_A112AgeFecHas ;
   private boolean[] BC00067_n112AgeFecHas ;
   private String[] BC00067_A93LegId ;
   private boolean[] BC00067_n93LegId ;
   private boolean[] BC00067_A143ConCanti ;
   private boolean[] BC00067_A158ConValUni ;
   private boolean[] BC00067_A152ConImporte ;
   private int[] BC00067_A1254AgeLiqNro ;
   private boolean[] BC00067_n1254AgeLiqNro ;
   private int[] BC00067_A3CliCod ;
   private short[] BC00067_A1EmpCod ;
   private int[] BC00067_A6LegNumero ;
   private String[] BC00067_A26ConCodigo ;
   private String[] BC00068_A42ConCodYDesc ;
   private boolean[] BC00068_n42ConCodYDesc ;
   private String[] BC00068_A41ConDescrip ;
   private boolean[] BC00068_A143ConCanti ;
   private boolean[] BC00068_A158ConValUni ;
   private boolean[] BC00068_A152ConImporte ;
   private String[] BC00069_A2EmpNom ;
   private String[] BC000610_A250LegIdNomApe ;
   private String[] BC000610_A591LegNomApe ;
   private String[] BC000610_A230LegApellido ;
   private String[] BC000610_A251LegNombre ;
   private java.util.Date[] BC000610_A244LegFecEgreso ;
   private boolean[] BC000610_n244LegFecEgreso ;
   private String[] BC000610_A93LegId ;
   private boolean[] BC000610_n93LegId ;
   private int[] BC000611_A3CliCod ;
   private short[] BC000611_A1EmpCod ;
   private int[] BC000611_A6LegNumero ;
   private short[] BC000611_A25AgeOrden ;
   private short[] BC000612_A25AgeOrden ;
   private java.math.BigDecimal[] BC000612_A110AgeCanti ;
   private boolean[] BC000612_n110AgeCanti ;
   private java.math.BigDecimal[] BC000612_A115AgeVUnit ;
   private boolean[] BC000612_n115AgeVUnit ;
   private java.math.BigDecimal[] BC000612_A113AgeImporte ;
   private boolean[] BC000612_n113AgeImporte ;
   private java.util.Date[] BC000612_A111AgeFecDes ;
   private boolean[] BC000612_n111AgeFecDes ;
   private java.util.Date[] BC000612_A112AgeFecHas ;
   private boolean[] BC000612_n112AgeFecHas ;
   private int[] BC000612_A1254AgeLiqNro ;
   private boolean[] BC000612_n1254AgeLiqNro ;
   private int[] BC000612_A3CliCod ;
   private short[] BC000612_A1EmpCod ;
   private int[] BC000612_A6LegNumero ;
   private String[] BC000612_A26ConCodigo ;
   private short[] BC000613_A25AgeOrden ;
   private java.math.BigDecimal[] BC000613_A110AgeCanti ;
   private boolean[] BC000613_n110AgeCanti ;
   private java.math.BigDecimal[] BC000613_A115AgeVUnit ;
   private boolean[] BC000613_n115AgeVUnit ;
   private java.math.BigDecimal[] BC000613_A113AgeImporte ;
   private boolean[] BC000613_n113AgeImporte ;
   private java.util.Date[] BC000613_A111AgeFecDes ;
   private boolean[] BC000613_n111AgeFecDes ;
   private java.util.Date[] BC000613_A112AgeFecHas ;
   private boolean[] BC000613_n112AgeFecHas ;
   private int[] BC000613_A1254AgeLiqNro ;
   private boolean[] BC000613_n1254AgeLiqNro ;
   private int[] BC000613_A3CliCod ;
   private short[] BC000613_A1EmpCod ;
   private int[] BC000613_A6LegNumero ;
   private String[] BC000613_A26ConCodigo ;
   private String[] BC000617_A2EmpNom ;
   private String[] BC000618_A250LegIdNomApe ;
   private String[] BC000618_A591LegNomApe ;
   private String[] BC000618_A230LegApellido ;
   private String[] BC000618_A251LegNombre ;
   private java.util.Date[] BC000618_A244LegFecEgreso ;
   private boolean[] BC000618_n244LegFecEgreso ;
   private String[] BC000618_A93LegId ;
   private boolean[] BC000618_n93LegId ;
   private String[] BC000619_A42ConCodYDesc ;
   private boolean[] BC000619_n42ConCodYDesc ;
   private String[] BC000619_A41ConDescrip ;
   private boolean[] BC000619_A143ConCanti ;
   private boolean[] BC000619_A158ConValUni ;
   private boolean[] BC000619_A152ConImporte ;
   private String[] BC000620_A42ConCodYDesc ;
   private boolean[] BC000620_n42ConCodYDesc ;
   private String[] BC000620_A250LegIdNomApe ;
   private String[] BC000620_A591LegNomApe ;
   private short[] BC000620_A25AgeOrden ;
   private String[] BC000620_A2EmpNom ;
   private String[] BC000620_A230LegApellido ;
   private String[] BC000620_A251LegNombre ;
   private java.util.Date[] BC000620_A244LegFecEgreso ;
   private boolean[] BC000620_n244LegFecEgreso ;
   private String[] BC000620_A41ConDescrip ;
   private java.math.BigDecimal[] BC000620_A110AgeCanti ;
   private boolean[] BC000620_n110AgeCanti ;
   private java.math.BigDecimal[] BC000620_A115AgeVUnit ;
   private boolean[] BC000620_n115AgeVUnit ;
   private java.math.BigDecimal[] BC000620_A113AgeImporte ;
   private boolean[] BC000620_n113AgeImporte ;
   private java.util.Date[] BC000620_A111AgeFecDes ;
   private boolean[] BC000620_n111AgeFecDes ;
   private java.util.Date[] BC000620_A112AgeFecHas ;
   private boolean[] BC000620_n112AgeFecHas ;
   private String[] BC000620_A93LegId ;
   private boolean[] BC000620_n93LegId ;
   private boolean[] BC000620_A143ConCanti ;
   private boolean[] BC000620_A158ConValUni ;
   private boolean[] BC000620_A152ConImporte ;
   private int[] BC000620_A1254AgeLiqNro ;
   private boolean[] BC000620_n1254AgeLiqNro ;
   private int[] BC000620_A3CliCod ;
   private short[] BC000620_A1EmpCod ;
   private int[] BC000620_A6LegNumero ;
   private String[] BC000620_A26ConCodigo ;
   private String[] BC000621_A2EmpNom ;
   private String[] BC000622_A250LegIdNomApe ;
   private String[] BC000622_A591LegNomApe ;
   private String[] BC000622_A230LegApellido ;
   private String[] BC000622_A251LegNombre ;
   private java.util.Date[] BC000622_A244LegFecEgreso ;
   private boolean[] BC000622_n244LegFecEgreso ;
   private String[] BC000622_A93LegId ;
   private boolean[] BC000622_n93LegId ;
   private String[] BC000623_A2EmpNom ;
   private String[] BC000624_A250LegIdNomApe ;
   private String[] BC000624_A591LegNomApe ;
   private String[] BC000624_A230LegApellido ;
   private String[] BC000624_A251LegNombre ;
   private java.util.Date[] BC000624_A244LegFecEgreso ;
   private boolean[] BC000624_n244LegFecEgreso ;
   private String[] BC000624_A93LegId ;
   private boolean[] BC000624_n93LegId ;
   private short[] BC00062_A25AgeOrden ;
   private java.math.BigDecimal[] BC00062_A110AgeCanti ;
   private java.math.BigDecimal[] BC00062_A115AgeVUnit ;
   private java.math.BigDecimal[] BC00062_A113AgeImporte ;
   private java.util.Date[] BC00062_A111AgeFecDes ;
   private java.util.Date[] BC00062_A112AgeFecHas ;
   private int[] BC00062_A1254AgeLiqNro ;
   private int[] BC00062_A3CliCod ;
   private short[] BC00062_A1EmpCod ;
   private int[] BC00062_A6LegNumero ;
   private String[] BC00062_A26ConCodigo ;
   private short[] BC00063_A25AgeOrden ;
   private java.math.BigDecimal[] BC00063_A110AgeCanti ;
   private java.math.BigDecimal[] BC00063_A115AgeVUnit ;
   private java.math.BigDecimal[] BC00063_A113AgeImporte ;
   private java.util.Date[] BC00063_A111AgeFecDes ;
   private java.util.Date[] BC00063_A112AgeFecHas ;
   private int[] BC00063_A1254AgeLiqNro ;
   private int[] BC00063_A3CliCod ;
   private short[] BC00063_A1EmpCod ;
   private int[] BC00063_A6LegNumero ;
   private String[] BC00063_A26ConCodigo ;
   private String[] BC00064_A2EmpNom ;
   private String[] BC00065_A250LegIdNomApe ;
   private String[] BC00065_A591LegNomApe ;
   private String[] BC00065_A230LegApellido ;
   private String[] BC00065_A251LegNombre ;
   private java.util.Date[] BC00065_A244LegFecEgreso ;
   private String[] BC00065_A93LegId ;
   private String[] BC00066_A42ConCodYDesc ;
   private String[] BC00066_A41ConDescrip ;
   private boolean[] BC00066_A143ConCanti ;
   private boolean[] BC00066_A158ConValUni ;
   private boolean[] BC00066_A152ConImporte ;
   private boolean[] BC00062_n110AgeCanti ;
   private boolean[] BC00062_n115AgeVUnit ;
   private boolean[] BC00062_n113AgeImporte ;
   private boolean[] BC00062_n111AgeFecDes ;
   private boolean[] BC00062_n112AgeFecHas ;
   private boolean[] BC00062_n1254AgeLiqNro ;
   private boolean[] BC00063_n110AgeCanti ;
   private boolean[] BC00063_n115AgeVUnit ;
   private boolean[] BC00063_n113AgeImporte ;
   private boolean[] BC00063_n111AgeFecDes ;
   private boolean[] BC00063_n112AgeFecHas ;
   private boolean[] BC00063_n1254AgeLiqNro ;
   private boolean[] BC00065_n244LegFecEgreso ;
   private boolean[] BC00065_n93LegId ;
   private boolean[] BC00066_n42ConCodYDesc ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
}

final  class agendanovedades_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00062", "SELECT AgeOrden, AgeCanti, AgeVUnit, AgeImporte, AgeFecDes, AgeFecHas, AgeLiqNro, CliCod, EmpCod, LegNumero, ConCodigo FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ?  FOR UPDATE OF AgendaNovedades",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00063", "SELECT AgeOrden, AgeCanti, AgeVUnit, AgeImporte, AgeFecDes, AgeFecHas, AgeLiqNro, CliCod, EmpCod, LegNumero, ConCodigo FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00064", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00065", "SELECT LegIdNomApe, LegNomApe, LegApellido, LegNombre, LegFecEgreso, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00066", "SELECT ConCodYDesc, ConDescrip, ConCanti, ConValUni, ConImporte FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00067", "SELECT T4.ConCodYDesc, T3.LegIdNomApe, T3.LegNomApe, TM1.AgeOrden, T2.EmpNom, T3.LegApellido, T3.LegNombre, T3.LegFecEgreso, T4.ConDescrip, TM1.AgeCanti, TM1.AgeVUnit, TM1.AgeImporte, TM1.AgeFecDes, TM1.AgeFecHas, T3.LegId, T4.ConCanti, T4.ConValUni, T4.ConImporte, TM1.AgeLiqNro, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.ConCodigo FROM (((AgendaNovedades TM1 INNER JOIN Empresa T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod) INNER JOIN Legajo T3 ON T3.CliCod = TM1.CliCod AND T3.EmpCod = TM1.EmpCod AND T3.LegNumero = TM1.LegNumero) INNER JOIN Concepto T4 ON T4.CliCod = TM1.CliCod AND T4.ConCodigo = TM1.ConCodigo) WHERE TM1.AgeOrden = ? and TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.AgeOrden ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00068", "SELECT ConCodYDesc, ConDescrip, ConCanti, ConValUni, ConImporte FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00069", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000610", "SELECT LegIdNomApe, LegNomApe, LegApellido, LegNombre, LegFecEgreso, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000611", "SELECT CliCod, EmpCod, LegNumero, AgeOrden FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000612", "SELECT AgeOrden, AgeCanti, AgeVUnit, AgeImporte, AgeFecDes, AgeFecHas, AgeLiqNro, CliCod, EmpCod, LegNumero, ConCodigo FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000613", "SELECT AgeOrden, AgeCanti, AgeVUnit, AgeImporte, AgeFecDes, AgeFecHas, AgeLiqNro, CliCod, EmpCod, LegNumero, ConCodigo FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ?  FOR UPDATE OF AgendaNovedades",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000614", "SAVEPOINT gxupdate;INSERT INTO AgendaNovedades(AgeOrden, AgeCanti, AgeVUnit, AgeImporte, AgeFecDes, AgeFecHas, AgeLiqNro, CliCod, EmpCod, LegNumero, ConCodigo, AgePerDescrip) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000615", "SAVEPOINT gxupdate;UPDATE AgendaNovedades SET AgeCanti=?, AgeVUnit=?, AgeImporte=?, AgeFecDes=?, AgeFecHas=?, AgeLiqNro=?, ConCodigo=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000616", "SAVEPOINT gxupdate;DELETE FROM AgendaNovedades  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000617", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000618", "SELECT LegIdNomApe, LegNomApe, LegApellido, LegNombre, LegFecEgreso, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000619", "SELECT ConCodYDesc, ConDescrip, ConCanti, ConValUni, ConImporte FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000620", "SELECT T4.ConCodYDesc, T3.LegIdNomApe, T3.LegNomApe, TM1.AgeOrden, T2.EmpNom, T3.LegApellido, T3.LegNombre, T3.LegFecEgreso, T4.ConDescrip, TM1.AgeCanti, TM1.AgeVUnit, TM1.AgeImporte, TM1.AgeFecDes, TM1.AgeFecHas, T3.LegId, T4.ConCanti, T4.ConValUni, T4.ConImporte, TM1.AgeLiqNro, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.ConCodigo FROM (((AgendaNovedades TM1 INNER JOIN Empresa T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod) INNER JOIN Legajo T3 ON T3.CliCod = TM1.CliCod AND T3.EmpCod = TM1.EmpCod AND T3.LegNumero = TM1.LegNumero) INNER JOIN Concepto T4 ON T4.CliCod = TM1.CliCod AND T4.ConCodigo = TM1.ConCodigo) WHERE TM1.AgeOrden = ? and TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.AgeOrden ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000621", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000622", "SELECT LegIdNomApe, LegNomApe, LegApellido, LegNombre, LegFecEgreso, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000623", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000624", "SELECT LegIdNomApe, LegNomApe, LegApellido, LegNombre, LegFecEgreso, LegId FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((int[]) buf[11])[0] = rslt.getInt(7);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((int[]) buf[13])[0] = rslt.getInt(8);
               ((short[]) buf[14])[0] = rslt.getShort(9);
               ((int[]) buf[15])[0] = rslt.getInt(10);
               ((String[]) buf[16])[0] = rslt.getString(11, 10);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((int[]) buf[11])[0] = rslt.getInt(7);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((int[]) buf[13])[0] = rslt.getInt(8);
               ((short[]) buf[14])[0] = rslt.getShort(9);
               ((int[]) buf[15])[0] = rslt.getInt(10);
               ((String[]) buf[16])[0] = rslt.getString(11, 10);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(12,2);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[17])[0] = rslt.getGXDate(13);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(14);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getString(15, 20);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((boolean[]) buf[23])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[24])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[25])[0] = rslt.getBoolean(18);
               ((int[]) buf[26])[0] = rslt.getInt(19);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((int[]) buf[28])[0] = rslt.getInt(20);
               ((short[]) buf[29])[0] = rslt.getShort(21);
               ((int[]) buf[30])[0] = rslt.getInt(22);
               ((String[]) buf[31])[0] = rslt.getString(23, 10);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((int[]) buf[11])[0] = rslt.getInt(7);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((int[]) buf[13])[0] = rslt.getInt(8);
               ((short[]) buf[14])[0] = rslt.getShort(9);
               ((int[]) buf[15])[0] = rslt.getInt(10);
               ((String[]) buf[16])[0] = rslt.getString(11, 10);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((int[]) buf[11])[0] = rslt.getInt(7);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((int[]) buf[13])[0] = rslt.getInt(8);
               ((short[]) buf[14])[0] = rslt.getShort(9);
               ((int[]) buf[15])[0] = rslt.getInt(10);
               ((String[]) buf[16])[0] = rslt.getString(11, 10);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(12,2);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[17])[0] = rslt.getGXDate(13);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(14);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getString(15, 20);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((boolean[]) buf[23])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[24])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[25])[0] = rslt.getBoolean(18);
               ((int[]) buf[26])[0] = rslt.getInt(19);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((int[]) buf[28])[0] = rslt.getInt(20);
               ((short[]) buf[29])[0] = rslt.getShort(21);
               ((int[]) buf[30])[0] = rslt.getInt(22);
               ((String[]) buf[31])[0] = rslt.getString(23, 10);
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 22 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(2, (java.math.BigDecimal)parms[2], 2);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(3, (java.math.BigDecimal)parms[4], 2);
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(4, (java.math.BigDecimal)parms[6], 2);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.DATE );
               }
               else
               {
                  stmt.setDate(5, (java.util.Date)parms[8]);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.DATE );
               }
               else
               {
                  stmt.setDate(6, (java.util.Date)parms[10]);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(7, ((Number) parms[12]).intValue());
               }
               stmt.setInt(8, ((Number) parms[13]).intValue());
               stmt.setShort(9, ((Number) parms[14]).shortValue());
               stmt.setInt(10, ((Number) parms[15]).intValue());
               stmt.setString(11, (String)parms[16], 10);
               return;
            case 13 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(1, (java.math.BigDecimal)parms[1], 2);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(2, (java.math.BigDecimal)parms[3], 2);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(3, (java.math.BigDecimal)parms[5], 2);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.DATE );
               }
               else
               {
                  stmt.setDate(4, (java.util.Date)parms[7]);
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.DATE );
               }
               else
               {
                  stmt.setDate(5, (java.util.Date)parms[9]);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(6, ((Number) parms[11]).intValue());
               }
               stmt.setString(7, (String)parms[12], 10);
               stmt.setInt(8, ((Number) parms[13]).intValue());
               stmt.setShort(9, ((Number) parms[14]).shortValue());
               stmt.setInt(10, ((Number) parms[15]).intValue());
               stmt.setShort(11, ((Number) parms[16]).shortValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

