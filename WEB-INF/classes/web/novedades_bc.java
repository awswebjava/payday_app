package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class novedades_bc extends GXWebPanel implements IGxSilentTrn
{
   public novedades_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public novedades_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( novedades_bc.class ));
   }

   public novedades_bc( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1U3( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1U3( ) ;
      standaloneModal( ) ;
      addRow1U3( ) ;
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
         e111U2 ();
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

   public void confirm_1U0( )
   {
      beforeValidate1U3( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1U3( ) ;
         }
         else
         {
            checkExtendedTable1U3( ) ;
            if ( AnyError == 0 )
            {
               zm1U3( 18) ;
               zm1U3( 19) ;
               zm1U3( 20) ;
            }
            closeExtendedTableCursors1U3( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e121U2( )
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedades_Insert", GXv_boolean3) ;
         novedades_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV22IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV22IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedades_Update", GXv_boolean3) ;
         novedades_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV22IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV22IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedades_Delete", GXv_boolean3) ;
         novedades_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV22IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV22IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV32Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV32Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV33GXV1 = 1 ;
         while ( AV33GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV33GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConCodigo") == 0 )
            {
               AV13Insert_ConCodigo = AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "AgeLiqNro") == 0 )
            {
               AV30Insert_AgeLiqNro = (int)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            AV33GXV1 = (int)(AV33GXV1+1) ;
         }
      }
      GXv_char4[0] = AV26cantidadAgenda ;
      new web.codigoopeformula(remoteHandle, context).execute( AV21CliCod, "[novedad_cantidad]", false, true, GXv_char4) ;
      novedades_bc.this.AV26cantidadAgenda = GXv_char4[0] ;
      GXv_char4[0] = AV27importeAgenda ;
      new web.codigoopeformula(remoteHandle, context).execute( AV21CliCod, "[novedad_importe]", false, true, GXv_char4) ;
      novedades_bc.this.AV27importeAgenda = GXv_char4[0] ;
   }

   public void e111U2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.recalcularlegsuelbasicaporlegupd(remoteHandle, context).execute( (short)(0), AV21CliCod, AV7EmpCod, AV8LegNumero, httpContext.getMessage( "NOVEDADES", "")) ;
   }

   public void e131U2( )
   {
      /* 'DoVolver' Routine */
      returnInSub = false ;
      GXv_char4[0] = AV26cantidadAgenda ;
      new web.codigoopeformula(remoteHandle, context).execute( AV21CliCod, "[novedad_cantidad]", false, true, GXv_char4) ;
      novedades_bc.this.AV26cantidadAgenda = GXv_char4[0] ;
      GXv_char4[0] = AV27importeAgenda ;
      new web.codigoopeformula(remoteHandle, context).execute( AV21CliCod, "[novedad_importe]", false, true, GXv_char4) ;
      novedades_bc.this.AV27importeAgenda = GXv_char4[0] ;
      /*  Sending Event outputs  */
   }

   public void zm1U3( int GX_JID )
   {
      if ( ( GX_JID == 17 ) || ( GX_JID == 0 ) )
      {
         Z110AgeCanti = A110AgeCanti ;
         Z115AgeVUnit = A115AgeVUnit ;
         Z113AgeImporte = A113AgeImporte ;
         Z1254AgeLiqNro = A1254AgeLiqNro ;
         Z111AgeFecDes = A111AgeFecDes ;
         Z112AgeFecHas = A112AgeFecHas ;
         Z2159AgePerDescrip = A2159AgePerDescrip ;
         Z26ConCodigo = A26ConCodigo ;
         Z114AgeLegActivo = A114AgeLegActivo ;
         Z1133AgePrevCalc = A1133AgePrevCalc ;
      }
      if ( ( GX_JID == 18 ) || ( GX_JID == 0 ) )
      {
         Z2EmpNom = A2EmpNom ;
         Z114AgeLegActivo = A114AgeLegActivo ;
         Z1133AgePrevCalc = A1133AgePrevCalc ;
      }
      if ( ( GX_JID == 19 ) || ( GX_JID == 0 ) )
      {
         Z250LegIdNomApe = A250LegIdNomApe ;
         Z591LegNomApe = A591LegNomApe ;
         Z230LegApellido = A230LegApellido ;
         Z251LegNombre = A251LegNombre ;
         Z244LegFecEgreso = A244LegFecEgreso ;
         Z93LegId = A93LegId ;
         Z239LegCUIL = A239LegCUIL ;
         Z114AgeLegActivo = A114AgeLegActivo ;
         Z1133AgePrevCalc = A1133AgePrevCalc ;
      }
      if ( ( GX_JID == 20 ) || ( GX_JID == 0 ) )
      {
         Z42ConCodYDesc = A42ConCodYDesc ;
         Z41ConDescrip = A41ConDescrip ;
         Z114AgeLegActivo = A114AgeLegActivo ;
         Z1133AgePrevCalc = A1133AgePrevCalc ;
      }
      if ( GX_JID == -17 )
      {
         Z25AgeOrden = A25AgeOrden ;
         Z110AgeCanti = A110AgeCanti ;
         Z115AgeVUnit = A115AgeVUnit ;
         Z113AgeImporte = A113AgeImporte ;
         Z1254AgeLiqNro = A1254AgeLiqNro ;
         Z111AgeFecDes = A111AgeFecDes ;
         Z112AgeFecHas = A112AgeFecHas ;
         Z2159AgePerDescrip = A2159AgePerDescrip ;
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
         Z239LegCUIL = A239LegCUIL ;
         Z42ConCodYDesc = A42ConCodYDesc ;
         Z41ConDescrip = A41ConDescrip ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int5 = A3CliCod ;
         GXv_int6[0] = GXt_int5 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int6) ;
         novedades_bc.this.GXt_int5 = GXv_int6[0] ;
         A3CliCod = GXt_int5 ;
      }
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      A114AgeLegActivo = false ;
      if ( isIns( )  )
      {
         A1254AgeLiqNro = 0 ;
         n1254AgeLiqNro = false ;
         n1254AgeLiqNro = true ;
      }
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
         AV32Pgmname = "Novedades_BC" ;
      }
   }

   public void load1U3( )
   {
      /* Using cursor BC001U7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A25AgeOrden), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A42ConCodYDesc = BC001U7_A42ConCodYDesc[0] ;
         n42ConCodYDesc = BC001U7_n42ConCodYDesc[0] ;
         A250LegIdNomApe = BC001U7_A250LegIdNomApe[0] ;
         A591LegNomApe = BC001U7_A591LegNomApe[0] ;
         A2EmpNom = BC001U7_A2EmpNom[0] ;
         A230LegApellido = BC001U7_A230LegApellido[0] ;
         A251LegNombre = BC001U7_A251LegNombre[0] ;
         A244LegFecEgreso = BC001U7_A244LegFecEgreso[0] ;
         n244LegFecEgreso = BC001U7_n244LegFecEgreso[0] ;
         A41ConDescrip = BC001U7_A41ConDescrip[0] ;
         A110AgeCanti = BC001U7_A110AgeCanti[0] ;
         n110AgeCanti = BC001U7_n110AgeCanti[0] ;
         A115AgeVUnit = BC001U7_A115AgeVUnit[0] ;
         n115AgeVUnit = BC001U7_n115AgeVUnit[0] ;
         A113AgeImporte = BC001U7_A113AgeImporte[0] ;
         n113AgeImporte = BC001U7_n113AgeImporte[0] ;
         A1254AgeLiqNro = BC001U7_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = BC001U7_n1254AgeLiqNro[0] ;
         A111AgeFecDes = BC001U7_A111AgeFecDes[0] ;
         n111AgeFecDes = BC001U7_n111AgeFecDes[0] ;
         A112AgeFecHas = BC001U7_A112AgeFecHas[0] ;
         n112AgeFecHas = BC001U7_n112AgeFecHas[0] ;
         A93LegId = BC001U7_A93LegId[0] ;
         n93LegId = BC001U7_n93LegId[0] ;
         A239LegCUIL = BC001U7_A239LegCUIL[0] ;
         A2159AgePerDescrip = BC001U7_A2159AgePerDescrip[0] ;
         A26ConCodigo = BC001U7_A26ConCodigo[0] ;
         zm1U3( -17) ;
      }
      pr_default.close(5);
      onLoadActions1U3( ) ;
   }

   public void onLoadActions1U3( )
   {
      AV32Pgmname = "Novedades_BC" ;
      GXt_char7 = A1133AgePrevCalc ;
      GXv_decimal8[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char4[0] = "" ;
      GXv_decimal9[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char10[0] = GXt_char7 ;
      new web.previsualizacionnovedad(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas, true, GXv_decimal8, GXv_char4, GXv_decimal9, GXv_char10) ;
      novedades_bc.this.GXt_char7 = GXv_char10[0] ;
      A1133AgePrevCalc = GXt_char7 ;
      GXt_char7 = A1132AgePrevis ;
      GXv_decimal9[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char10[0] = "" ;
      GXv_decimal8[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char4[0] = GXt_char7 ;
      new web.previsualizacionnovedad(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas, false, GXv_decimal9, GXv_char10, GXv_decimal8, GXv_char4) ;
      novedades_bc.this.GXt_char7 = GXv_char4[0] ;
      A1132AgePrevis = GXt_char7 ;
   }

   public void checkExtendedTable1U3( )
   {
      nIsDirty_3 = (short)(0) ;
      standaloneModal( ) ;
      AV32Pgmname = "Novedades_BC" ;
      /* Using cursor BC001U8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Concepto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONCODIGO");
         AnyError = (short)(1) ;
      }
      A42ConCodYDesc = BC001U8_A42ConCodYDesc[0] ;
      n42ConCodYDesc = BC001U8_n42ConCodYDesc[0] ;
      A41ConDescrip = BC001U8_A41ConDescrip[0] ;
      pr_default.close(6);
      /* Using cursor BC001U9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
      }
      A2EmpNom = BC001U9_A2EmpNom[0] ;
      pr_default.close(7);
      /* Using cursor BC001U10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
      }
      A250LegIdNomApe = BC001U10_A250LegIdNomApe[0] ;
      A591LegNomApe = BC001U10_A591LegNomApe[0] ;
      A230LegApellido = BC001U10_A230LegApellido[0] ;
      A251LegNombre = BC001U10_A251LegNombre[0] ;
      A244LegFecEgreso = BC001U10_A244LegFecEgreso[0] ;
      n244LegFecEgreso = BC001U10_n244LegFecEgreso[0] ;
      A93LegId = BC001U10_A93LegId[0] ;
      n93LegId = BC001U10_n93LegId[0] ;
      A239LegCUIL = BC001U10_A239LegCUIL[0] ;
      pr_default.close(8);
      nIsDirty_3 = (short)(1) ;
      GXt_char7 = A1133AgePrevCalc ;
      GXv_decimal9[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char10[0] = "" ;
      GXv_decimal8[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char4[0] = GXt_char7 ;
      new web.previsualizacionnovedad(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas, true, GXv_decimal9, GXv_char10, GXv_decimal8, GXv_char4) ;
      novedades_bc.this.GXt_char7 = GXv_char4[0] ;
      A1133AgePrevCalc = GXt_char7 ;
      nIsDirty_3 = (short)(1) ;
      GXt_char7 = A1132AgePrevis ;
      GXv_decimal9[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char10[0] = "" ;
      GXv_decimal8[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char4[0] = GXt_char7 ;
      new web.previsualizacionnovedad(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas, false, GXv_decimal9, GXv_char10, GXv_decimal8, GXv_char4) ;
      novedades_bc.this.GXt_char7 = GXv_char4[0] ;
      A1132AgePrevis = GXt_char7 ;
      if ( (0==A6LegNumero) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
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

   public void closeExtendedTableCursors1U3( )
   {
      pr_default.close(6);
      pr_default.close(7);
      pr_default.close(8);
   }

   public void enableDisable( )
   {
   }

   public void getKey1U3( )
   {
      /* Using cursor BC001U11 */
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
      /* Using cursor BC001U12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A25AgeOrden)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         zm1U3( 17) ;
         RcdFound3 = (short)(1) ;
         A25AgeOrden = BC001U12_A25AgeOrden[0] ;
         A110AgeCanti = BC001U12_A110AgeCanti[0] ;
         n110AgeCanti = BC001U12_n110AgeCanti[0] ;
         A115AgeVUnit = BC001U12_A115AgeVUnit[0] ;
         n115AgeVUnit = BC001U12_n115AgeVUnit[0] ;
         A113AgeImporte = BC001U12_A113AgeImporte[0] ;
         n113AgeImporte = BC001U12_n113AgeImporte[0] ;
         A1254AgeLiqNro = BC001U12_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = BC001U12_n1254AgeLiqNro[0] ;
         A111AgeFecDes = BC001U12_A111AgeFecDes[0] ;
         n111AgeFecDes = BC001U12_n111AgeFecDes[0] ;
         A112AgeFecHas = BC001U12_A112AgeFecHas[0] ;
         n112AgeFecHas = BC001U12_n112AgeFecHas[0] ;
         A2159AgePerDescrip = BC001U12_A2159AgePerDescrip[0] ;
         A3CliCod = BC001U12_A3CliCod[0] ;
         A1EmpCod = BC001U12_A1EmpCod[0] ;
         A6LegNumero = BC001U12_A6LegNumero[0] ;
         A26ConCodigo = BC001U12_A26ConCodigo[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z25AgeOrden = A25AgeOrden ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         load1U3( ) ;
         if ( AnyError == 1 )
         {
            RcdFound3 = (short)(0) ;
            initializeNonKey1U3( ) ;
         }
         Gx_mode = sMode3 ;
      }
      else
      {
         RcdFound3 = (short)(0) ;
         initializeNonKey1U3( ) ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode3 ;
      }
      pr_default.close(10);
   }

   public void getEqualNoModal( )
   {
      getKey1U3( ) ;
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
      confirm_1U0( ) ;
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

   public void checkOptimisticConcurrency1U3( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001U13 */
         pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A25AgeOrden)});
         if ( (pr_default.getStatus(11) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"AgendaNovedades"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(11) == 101) || ( DecimalUtil.compareTo(Z110AgeCanti, BC001U13_A110AgeCanti[0]) != 0 ) || ( DecimalUtil.compareTo(Z115AgeVUnit, BC001U13_A115AgeVUnit[0]) != 0 ) || ( DecimalUtil.compareTo(Z113AgeImporte, BC001U13_A113AgeImporte[0]) != 0 ) || ( Z1254AgeLiqNro != BC001U13_A1254AgeLiqNro[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z111AgeFecDes), GXutil.resetTime(BC001U13_A111AgeFecDes[0])) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z112AgeFecHas), GXutil.resetTime(BC001U13_A112AgeFecHas[0])) ) || ( GXutil.strcmp(Z2159AgePerDescrip, BC001U13_A2159AgePerDescrip[0]) != 0 ) || ( GXutil.strcmp(Z26ConCodigo, BC001U13_A26ConCodigo[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"AgendaNovedades"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1U3( )
   {
      beforeValidate1U3( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1U3( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1U3( 0) ;
         checkOptimisticConcurrency1U3( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1U3( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1U3( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001U14 */
                  pr_default.execute(12, new Object[] {Short.valueOf(A25AgeOrden), Boolean.valueOf(n110AgeCanti), A110AgeCanti, Boolean.valueOf(n115AgeVUnit), A115AgeVUnit, Boolean.valueOf(n113AgeImporte), A113AgeImporte, Boolean.valueOf(n1254AgeLiqNro), Integer.valueOf(A1254AgeLiqNro), Boolean.valueOf(n111AgeFecDes), A111AgeFecDes, Boolean.valueOf(n112AgeFecHas), A112AgeFecHas, A2159AgePerDescrip, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A26ConCodigo});
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
            load1U3( ) ;
         }
         endLevel1U3( ) ;
      }
      closeExtendedTableCursors1U3( ) ;
   }

   public void update1U3( )
   {
      beforeValidate1U3( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1U3( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1U3( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1U3( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1U3( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001U15 */
                  pr_default.execute(13, new Object[] {Boolean.valueOf(n110AgeCanti), A110AgeCanti, Boolean.valueOf(n115AgeVUnit), A115AgeVUnit, Boolean.valueOf(n113AgeImporte), A113AgeImporte, Boolean.valueOf(n1254AgeLiqNro), Integer.valueOf(A1254AgeLiqNro), Boolean.valueOf(n111AgeFecDes), A111AgeFecDes, Boolean.valueOf(n112AgeFecHas), A112AgeFecHas, A2159AgePerDescrip, A26ConCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A25AgeOrden)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("AgendaNovedades");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"AgendaNovedades"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1U3( ) ;
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
         endLevel1U3( ) ;
      }
      closeExtendedTableCursors1U3( ) ;
   }

   public void deferredUpdate1U3( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1U3( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1U3( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1U3( ) ;
         afterConfirm1U3( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1U3( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001U16 */
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
      endLevel1U3( ) ;
      Gx_mode = sMode3 ;
   }

   public void onDeleteControls1U3( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV32Pgmname = "Novedades_BC" ;
         /* Using cursor BC001U17 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         A2EmpNom = BC001U17_A2EmpNom[0] ;
         pr_default.close(15);
         /* Using cursor BC001U18 */
         pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         A250LegIdNomApe = BC001U18_A250LegIdNomApe[0] ;
         A591LegNomApe = BC001U18_A591LegNomApe[0] ;
         A230LegApellido = BC001U18_A230LegApellido[0] ;
         A251LegNombre = BC001U18_A251LegNombre[0] ;
         A244LegFecEgreso = BC001U18_A244LegFecEgreso[0] ;
         n244LegFecEgreso = BC001U18_n244LegFecEgreso[0] ;
         A93LegId = BC001U18_A93LegId[0] ;
         n93LegId = BC001U18_n93LegId[0] ;
         A239LegCUIL = BC001U18_A239LegCUIL[0] ;
         pr_default.close(16);
         /* Using cursor BC001U19 */
         pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo});
         A42ConCodYDesc = BC001U19_A42ConCodYDesc[0] ;
         n42ConCodYDesc = BC001U19_n42ConCodYDesc[0] ;
         A41ConDescrip = BC001U19_A41ConDescrip[0] ;
         pr_default.close(17);
         GXt_char7 = A1133AgePrevCalc ;
         GXv_decimal9[0] = DecimalUtil.doubleToDec(0) ;
         GXv_char10[0] = "" ;
         GXv_decimal8[0] = DecimalUtil.doubleToDec(0) ;
         GXv_char4[0] = GXt_char7 ;
         new web.previsualizacionnovedad(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas, true, GXv_decimal9, GXv_char10, GXv_decimal8, GXv_char4) ;
         novedades_bc.this.GXt_char7 = GXv_char4[0] ;
         A1133AgePrevCalc = GXt_char7 ;
         GXt_char7 = A1132AgePrevis ;
         GXv_decimal9[0] = DecimalUtil.doubleToDec(0) ;
         GXv_char10[0] = "" ;
         GXv_decimal8[0] = DecimalUtil.doubleToDec(0) ;
         GXv_char4[0] = GXt_char7 ;
         new web.previsualizacionnovedad(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A26ConCodigo, A110AgeCanti, A113AgeImporte, A111AgeFecDes, A112AgeFecHas, false, GXv_decimal9, GXv_char10, GXv_decimal8, GXv_char4) ;
         novedades_bc.this.GXt_char7 = GXv_char4[0] ;
         A1132AgePrevis = GXt_char7 ;
      }
   }

   public void endLevel1U3( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(11);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1U3( ) ;
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

   public void scanKeyStart1U3( )
   {
      /* Scan By routine */
      /* Using cursor BC001U20 */
      pr_default.execute(18, new Object[] {Short.valueOf(A25AgeOrden), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      RcdFound3 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A42ConCodYDesc = BC001U20_A42ConCodYDesc[0] ;
         n42ConCodYDesc = BC001U20_n42ConCodYDesc[0] ;
         A250LegIdNomApe = BC001U20_A250LegIdNomApe[0] ;
         A591LegNomApe = BC001U20_A591LegNomApe[0] ;
         A25AgeOrden = BC001U20_A25AgeOrden[0] ;
         A2EmpNom = BC001U20_A2EmpNom[0] ;
         A230LegApellido = BC001U20_A230LegApellido[0] ;
         A251LegNombre = BC001U20_A251LegNombre[0] ;
         A244LegFecEgreso = BC001U20_A244LegFecEgreso[0] ;
         n244LegFecEgreso = BC001U20_n244LegFecEgreso[0] ;
         A41ConDescrip = BC001U20_A41ConDescrip[0] ;
         A110AgeCanti = BC001U20_A110AgeCanti[0] ;
         n110AgeCanti = BC001U20_n110AgeCanti[0] ;
         A115AgeVUnit = BC001U20_A115AgeVUnit[0] ;
         n115AgeVUnit = BC001U20_n115AgeVUnit[0] ;
         A113AgeImporte = BC001U20_A113AgeImporte[0] ;
         n113AgeImporte = BC001U20_n113AgeImporte[0] ;
         A1254AgeLiqNro = BC001U20_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = BC001U20_n1254AgeLiqNro[0] ;
         A111AgeFecDes = BC001U20_A111AgeFecDes[0] ;
         n111AgeFecDes = BC001U20_n111AgeFecDes[0] ;
         A112AgeFecHas = BC001U20_A112AgeFecHas[0] ;
         n112AgeFecHas = BC001U20_n112AgeFecHas[0] ;
         A93LegId = BC001U20_A93LegId[0] ;
         n93LegId = BC001U20_n93LegId[0] ;
         A239LegCUIL = BC001U20_A239LegCUIL[0] ;
         A2159AgePerDescrip = BC001U20_A2159AgePerDescrip[0] ;
         A3CliCod = BC001U20_A3CliCod[0] ;
         A1EmpCod = BC001U20_A1EmpCod[0] ;
         A6LegNumero = BC001U20_A6LegNumero[0] ;
         A26ConCodigo = BC001U20_A26ConCodigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1U3( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound3 = (short)(0) ;
      scanKeyLoad1U3( ) ;
   }

   public void scanKeyLoad1U3( )
   {
      sMode3 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A42ConCodYDesc = BC001U20_A42ConCodYDesc[0] ;
         n42ConCodYDesc = BC001U20_n42ConCodYDesc[0] ;
         A250LegIdNomApe = BC001U20_A250LegIdNomApe[0] ;
         A591LegNomApe = BC001U20_A591LegNomApe[0] ;
         A25AgeOrden = BC001U20_A25AgeOrden[0] ;
         A2EmpNom = BC001U20_A2EmpNom[0] ;
         A230LegApellido = BC001U20_A230LegApellido[0] ;
         A251LegNombre = BC001U20_A251LegNombre[0] ;
         A244LegFecEgreso = BC001U20_A244LegFecEgreso[0] ;
         n244LegFecEgreso = BC001U20_n244LegFecEgreso[0] ;
         A41ConDescrip = BC001U20_A41ConDescrip[0] ;
         A110AgeCanti = BC001U20_A110AgeCanti[0] ;
         n110AgeCanti = BC001U20_n110AgeCanti[0] ;
         A115AgeVUnit = BC001U20_A115AgeVUnit[0] ;
         n115AgeVUnit = BC001U20_n115AgeVUnit[0] ;
         A113AgeImporte = BC001U20_A113AgeImporte[0] ;
         n113AgeImporte = BC001U20_n113AgeImporte[0] ;
         A1254AgeLiqNro = BC001U20_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = BC001U20_n1254AgeLiqNro[0] ;
         A111AgeFecDes = BC001U20_A111AgeFecDes[0] ;
         n111AgeFecDes = BC001U20_n111AgeFecDes[0] ;
         A112AgeFecHas = BC001U20_A112AgeFecHas[0] ;
         n112AgeFecHas = BC001U20_n112AgeFecHas[0] ;
         A93LegId = BC001U20_A93LegId[0] ;
         n93LegId = BC001U20_n93LegId[0] ;
         A239LegCUIL = BC001U20_A239LegCUIL[0] ;
         A2159AgePerDescrip = BC001U20_A2159AgePerDescrip[0] ;
         A3CliCod = BC001U20_A3CliCod[0] ;
         A1EmpCod = BC001U20_A1EmpCod[0] ;
         A6LegNumero = BC001U20_A6LegNumero[0] ;
         A26ConCodigo = BC001U20_A26ConCodigo[0] ;
      }
      Gx_mode = sMode3 ;
   }

   public void scanKeyEnd1U3( )
   {
      pr_default.close(18);
   }

   public void afterConfirm1U3( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1U3( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1U3( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1U3( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1U3( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1U3( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1U3( )
   {
   }

   public void send_integrity_lvl_hashes1U3( )
   {
   }

   public void addRow1U3( )
   {
      VarsToRow3( bcNovedades) ;
   }

   public void readRow1U3( )
   {
      RowToVars3( bcNovedades, 1) ;
   }

   public void initializeNonKey1U3( )
   {
      A114AgeLegActivo = false ;
      A42ConCodYDesc = "" ;
      n42ConCodYDesc = false ;
      A250LegIdNomApe = "" ;
      A591LegNomApe = "" ;
      A1132AgePrevis = "" ;
      A1133AgePrevCalc = "" ;
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
      A1254AgeLiqNro = 0 ;
      n1254AgeLiqNro = false ;
      A111AgeFecDes = localUtil.ymdtod( 2023, 1, 1) ;
      n111AgeFecDes = false ;
      A93LegId = "" ;
      n93LegId = false ;
      A239LegCUIL = 0 ;
      A2159AgePerDescrip = "" ;
      A110AgeCanti = DecimalUtil.doubleToDec(1) ;
      n110AgeCanti = false ;
      A112AgeFecHas = localUtil.ymdtod( 2023, 1, 15) ;
      n112AgeFecHas = false ;
      Z110AgeCanti = DecimalUtil.ZERO ;
      Z115AgeVUnit = DecimalUtil.ZERO ;
      Z113AgeImporte = DecimalUtil.ZERO ;
      Z1254AgeLiqNro = 0 ;
      Z111AgeFecDes = GXutil.nullDate() ;
      Z112AgeFecHas = GXutil.nullDate() ;
      Z2159AgePerDescrip = "" ;
      Z26ConCodigo = "" ;
   }

   public void initAll1U3( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A6LegNumero = 0 ;
      A25AgeOrden = (short)(0) ;
      initializeNonKey1U3( ) ;
   }

   public void standaloneModalInsert( )
   {
      A114AgeLegActivo = i114AgeLegActivo ;
      A1254AgeLiqNro = i1254AgeLiqNro ;
      n1254AgeLiqNro = false ;
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

   public void VarsToRow3( web.SdtNovedades obj3 )
   {
      obj3.setgxTv_SdtNovedades_Mode( Gx_mode );
      obj3.setgxTv_SdtNovedades_Agelegactivo( A114AgeLegActivo );
      obj3.setgxTv_SdtNovedades_Ageprevis( A1132AgePrevis );
      obj3.setgxTv_SdtNovedades_Ageprevcalc( A1133AgePrevCalc );
      obj3.setgxTv_SdtNovedades_Empnom( A2EmpNom );
      obj3.setgxTv_SdtNovedades_Legapellido( A230LegApellido );
      obj3.setgxTv_SdtNovedades_Legnombre( A251LegNombre );
      obj3.setgxTv_SdtNovedades_Legfecegreso( A244LegFecEgreso );
      obj3.setgxTv_SdtNovedades_Concodigo( A26ConCodigo );
      obj3.setgxTv_SdtNovedades_Condescrip( A41ConDescrip );
      obj3.setgxTv_SdtNovedades_Agevunit( A115AgeVUnit );
      obj3.setgxTv_SdtNovedades_Ageimporte( A113AgeImporte );
      obj3.setgxTv_SdtNovedades_Ageliqnro( A1254AgeLiqNro );
      obj3.setgxTv_SdtNovedades_Agefecdes( A111AgeFecDes );
      obj3.setgxTv_SdtNovedades_Legid( A93LegId );
      obj3.setgxTv_SdtNovedades_Legcuil( A239LegCUIL );
      obj3.setgxTv_SdtNovedades_Ageperdescrip( A2159AgePerDescrip );
      obj3.setgxTv_SdtNovedades_Agecanti( A110AgeCanti );
      obj3.setgxTv_SdtNovedades_Agefechas( A112AgeFecHas );
      obj3.setgxTv_SdtNovedades_Clicod( A3CliCod );
      obj3.setgxTv_SdtNovedades_Empcod( A1EmpCod );
      obj3.setgxTv_SdtNovedades_Legnumero( A6LegNumero );
      obj3.setgxTv_SdtNovedades_Ageorden( A25AgeOrden );
      obj3.setgxTv_SdtNovedades_Clicod_Z( Z3CliCod );
      obj3.setgxTv_SdtNovedades_Empcod_Z( Z1EmpCod );
      obj3.setgxTv_SdtNovedades_Empnom_Z( Z2EmpNom );
      obj3.setgxTv_SdtNovedades_Legnumero_Z( Z6LegNumero );
      obj3.setgxTv_SdtNovedades_Legapellido_Z( Z230LegApellido );
      obj3.setgxTv_SdtNovedades_Legnombre_Z( Z251LegNombre );
      obj3.setgxTv_SdtNovedades_Legfecegreso_Z( Z244LegFecEgreso );
      obj3.setgxTv_SdtNovedades_Ageorden_Z( Z25AgeOrden );
      obj3.setgxTv_SdtNovedades_Concodigo_Z( Z26ConCodigo );
      obj3.setgxTv_SdtNovedades_Condescrip_Z( Z41ConDescrip );
      obj3.setgxTv_SdtNovedades_Agecanti_Z( Z110AgeCanti );
      obj3.setgxTv_SdtNovedades_Agevunit_Z( Z115AgeVUnit );
      obj3.setgxTv_SdtNovedades_Ageimporte_Z( Z113AgeImporte );
      obj3.setgxTv_SdtNovedades_Ageliqnro_Z( Z1254AgeLiqNro );
      obj3.setgxTv_SdtNovedades_Agefecdes_Z( Z111AgeFecDes );
      obj3.setgxTv_SdtNovedades_Agefechas_Z( Z112AgeFecHas );
      obj3.setgxTv_SdtNovedades_Agelegactivo_Z( Z114AgeLegActivo );
      obj3.setgxTv_SdtNovedades_Legid_Z( Z93LegId );
      obj3.setgxTv_SdtNovedades_Ageprevcalc_Z( Z1133AgePrevCalc );
      obj3.setgxTv_SdtNovedades_Legcuil_Z( Z239LegCUIL );
      obj3.setgxTv_SdtNovedades_Ageperdescrip_Z( Z2159AgePerDescrip );
      obj3.setgxTv_SdtNovedades_Legfecegreso_N( (byte)((byte)((n244LegFecEgreso)?1:0)) );
      obj3.setgxTv_SdtNovedades_Agecanti_N( (byte)((byte)((n110AgeCanti)?1:0)) );
      obj3.setgxTv_SdtNovedades_Agevunit_N( (byte)((byte)((n115AgeVUnit)?1:0)) );
      obj3.setgxTv_SdtNovedades_Ageimporte_N( (byte)((byte)((n113AgeImporte)?1:0)) );
      obj3.setgxTv_SdtNovedades_Ageliqnro_N( (byte)((byte)((n1254AgeLiqNro)?1:0)) );
      obj3.setgxTv_SdtNovedades_Agefecdes_N( (byte)((byte)((n111AgeFecDes)?1:0)) );
      obj3.setgxTv_SdtNovedades_Agefechas_N( (byte)((byte)((n112AgeFecHas)?1:0)) );
      obj3.setgxTv_SdtNovedades_Legid_N( (byte)((byte)((n93LegId)?1:0)) );
      obj3.setgxTv_SdtNovedades_Mode( Gx_mode );
   }

   public void KeyVarsToRow3( web.SdtNovedades obj3 )
   {
      obj3.setgxTv_SdtNovedades_Clicod( A3CliCod );
      obj3.setgxTv_SdtNovedades_Empcod( A1EmpCod );
      obj3.setgxTv_SdtNovedades_Legnumero( A6LegNumero );
      obj3.setgxTv_SdtNovedades_Ageorden( A25AgeOrden );
   }

   public void RowToVars3( web.SdtNovedades obj3 ,
                           int forceLoad )
   {
      Gx_mode = obj3.getgxTv_SdtNovedades_Mode() ;
      A114AgeLegActivo = obj3.getgxTv_SdtNovedades_Agelegactivo() ;
      A1132AgePrevis = obj3.getgxTv_SdtNovedades_Ageprevis() ;
      A1133AgePrevCalc = obj3.getgxTv_SdtNovedades_Ageprevcalc() ;
      A2EmpNom = obj3.getgxTv_SdtNovedades_Empnom() ;
      A230LegApellido = obj3.getgxTv_SdtNovedades_Legapellido() ;
      A251LegNombre = obj3.getgxTv_SdtNovedades_Legnombre() ;
      A244LegFecEgreso = obj3.getgxTv_SdtNovedades_Legfecegreso() ;
      n244LegFecEgreso = false ;
      if ( ! ( isUpd( )  ) || ( forceLoad == 1 ) )
      {
         A26ConCodigo = obj3.getgxTv_SdtNovedades_Concodigo() ;
      }
      A41ConDescrip = obj3.getgxTv_SdtNovedades_Condescrip() ;
      A115AgeVUnit = obj3.getgxTv_SdtNovedades_Agevunit() ;
      n115AgeVUnit = false ;
      A113AgeImporte = obj3.getgxTv_SdtNovedades_Ageimporte() ;
      n113AgeImporte = false ;
      A1254AgeLiqNro = obj3.getgxTv_SdtNovedades_Ageliqnro() ;
      n1254AgeLiqNro = false ;
      A111AgeFecDes = obj3.getgxTv_SdtNovedades_Agefecdes() ;
      n111AgeFecDes = false ;
      A93LegId = obj3.getgxTv_SdtNovedades_Legid() ;
      n93LegId = false ;
      A239LegCUIL = obj3.getgxTv_SdtNovedades_Legcuil() ;
      A2159AgePerDescrip = obj3.getgxTv_SdtNovedades_Ageperdescrip() ;
      A110AgeCanti = obj3.getgxTv_SdtNovedades_Agecanti() ;
      n110AgeCanti = false ;
      A112AgeFecHas = obj3.getgxTv_SdtNovedades_Agefechas() ;
      n112AgeFecHas = false ;
      A3CliCod = obj3.getgxTv_SdtNovedades_Clicod() ;
      A1EmpCod = obj3.getgxTv_SdtNovedades_Empcod() ;
      A6LegNumero = obj3.getgxTv_SdtNovedades_Legnumero() ;
      A25AgeOrden = obj3.getgxTv_SdtNovedades_Ageorden() ;
      Z3CliCod = obj3.getgxTv_SdtNovedades_Clicod_Z() ;
      Z1EmpCod = obj3.getgxTv_SdtNovedades_Empcod_Z() ;
      Z2EmpNom = obj3.getgxTv_SdtNovedades_Empnom_Z() ;
      Z6LegNumero = obj3.getgxTv_SdtNovedades_Legnumero_Z() ;
      Z230LegApellido = obj3.getgxTv_SdtNovedades_Legapellido_Z() ;
      Z251LegNombre = obj3.getgxTv_SdtNovedades_Legnombre_Z() ;
      Z244LegFecEgreso = obj3.getgxTv_SdtNovedades_Legfecegreso_Z() ;
      Z25AgeOrden = obj3.getgxTv_SdtNovedades_Ageorden_Z() ;
      Z26ConCodigo = obj3.getgxTv_SdtNovedades_Concodigo_Z() ;
      Z41ConDescrip = obj3.getgxTv_SdtNovedades_Condescrip_Z() ;
      Z110AgeCanti = obj3.getgxTv_SdtNovedades_Agecanti_Z() ;
      Z115AgeVUnit = obj3.getgxTv_SdtNovedades_Agevunit_Z() ;
      Z113AgeImporte = obj3.getgxTv_SdtNovedades_Ageimporte_Z() ;
      Z1254AgeLiqNro = obj3.getgxTv_SdtNovedades_Ageliqnro_Z() ;
      Z111AgeFecDes = obj3.getgxTv_SdtNovedades_Agefecdes_Z() ;
      Z112AgeFecHas = obj3.getgxTv_SdtNovedades_Agefechas_Z() ;
      Z114AgeLegActivo = obj3.getgxTv_SdtNovedades_Agelegactivo_Z() ;
      Z93LegId = obj3.getgxTv_SdtNovedades_Legid_Z() ;
      Z1133AgePrevCalc = obj3.getgxTv_SdtNovedades_Ageprevcalc_Z() ;
      Z239LegCUIL = obj3.getgxTv_SdtNovedades_Legcuil_Z() ;
      Z2159AgePerDescrip = obj3.getgxTv_SdtNovedades_Ageperdescrip_Z() ;
      n244LegFecEgreso = (boolean)((obj3.getgxTv_SdtNovedades_Legfecegreso_N()==0)?false:true) ;
      n110AgeCanti = (boolean)((obj3.getgxTv_SdtNovedades_Agecanti_N()==0)?false:true) ;
      n115AgeVUnit = (boolean)((obj3.getgxTv_SdtNovedades_Agevunit_N()==0)?false:true) ;
      n113AgeImporte = (boolean)((obj3.getgxTv_SdtNovedades_Ageimporte_N()==0)?false:true) ;
      n1254AgeLiqNro = (boolean)((obj3.getgxTv_SdtNovedades_Ageliqnro_N()==0)?false:true) ;
      n111AgeFecDes = (boolean)((obj3.getgxTv_SdtNovedades_Agefecdes_N()==0)?false:true) ;
      n112AgeFecHas = (boolean)((obj3.getgxTv_SdtNovedades_Agefechas_N()==0)?false:true) ;
      n93LegId = (boolean)((obj3.getgxTv_SdtNovedades_Legid_N()==0)?false:true) ;
      Gx_mode = obj3.getgxTv_SdtNovedades_Mode() ;
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
      initializeNonKey1U3( ) ;
      scanKeyStart1U3( ) ;
      if ( RcdFound3 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC001U21 */
         pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(19) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         A2EmpNom = BC001U21_A2EmpNom[0] ;
         pr_default.close(19);
         /* Using cursor BC001U22 */
         pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(20) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
         }
         A250LegIdNomApe = BC001U22_A250LegIdNomApe[0] ;
         A591LegNomApe = BC001U22_A591LegNomApe[0] ;
         A230LegApellido = BC001U22_A230LegApellido[0] ;
         A251LegNombre = BC001U22_A251LegNombre[0] ;
         A244LegFecEgreso = BC001U22_A244LegFecEgreso[0] ;
         n244LegFecEgreso = BC001U22_n244LegFecEgreso[0] ;
         A93LegId = BC001U22_A93LegId[0] ;
         n93LegId = BC001U22_n93LegId[0] ;
         A239LegCUIL = BC001U22_A239LegCUIL[0] ;
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
      zm1U3( -17) ;
      onLoadActions1U3( ) ;
      addRow1U3( ) ;
      scanKeyEnd1U3( ) ;
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
      RowToVars3( bcNovedades, 0) ;
      scanKeyStart1U3( ) ;
      if ( RcdFound3 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC001U23 */
         pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(21) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         A2EmpNom = BC001U23_A2EmpNom[0] ;
         pr_default.close(21);
         /* Using cursor BC001U24 */
         pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(22) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
         }
         A250LegIdNomApe = BC001U24_A250LegIdNomApe[0] ;
         A591LegNomApe = BC001U24_A591LegNomApe[0] ;
         A230LegApellido = BC001U24_A230LegApellido[0] ;
         A251LegNombre = BC001U24_A251LegNombre[0] ;
         A244LegFecEgreso = BC001U24_A244LegFecEgreso[0] ;
         n244LegFecEgreso = BC001U24_n244LegFecEgreso[0] ;
         A93LegId = BC001U24_A93LegId[0] ;
         n93LegId = BC001U24_n93LegId[0] ;
         A239LegCUIL = BC001U24_A239LegCUIL[0] ;
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
      zm1U3( -17) ;
      onLoadActions1U3( ) ;
      addRow1U3( ) ;
      scanKeyEnd1U3( ) ;
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
      getKey1U3( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1U3( ) ;
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
               update1U3( ) ;
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
                     insert1U3( ) ;
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
                     insert1U3( ) ;
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
      RowToVars3( bcNovedades, 1) ;
      saveImpl( ) ;
      VarsToRow3( bcNovedades) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars3( bcNovedades, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1U3( ) ;
      afterTrn( ) ;
      VarsToRow3( bcNovedades) ;
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
         web.SdtNovedades auxBC = new web.SdtNovedades( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A6LegNumero, A25AgeOrden);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcNovedades);
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
      RowToVars3( bcNovedades, 1) ;
      updateImpl( ) ;
      VarsToRow3( bcNovedades) ;
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
      RowToVars3( bcNovedades, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1U3( ) ;
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
      VarsToRow3( bcNovedades) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars3( bcNovedades, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1U3( ) ;
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "novedades_bc");
      VarsToRow3( bcNovedades) ;
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
      Gx_mode = bcNovedades.getgxTv_SdtNovedades_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcNovedades.setgxTv_SdtNovedades_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtNovedades sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcNovedades )
      {
         bcNovedades = sdt ;
         if ( GXutil.strcmp(bcNovedades.getgxTv_SdtNovedades_Mode(), "") == 0 )
         {
            bcNovedades.setgxTv_SdtNovedades_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow3( bcNovedades) ;
         }
         else
         {
            RowToVars3( bcNovedades, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcNovedades.getgxTv_SdtNovedades_Mode(), "") == 0 )
         {
            bcNovedades.setgxTv_SdtNovedades_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars3( bcNovedades, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtNovedades getNovedades_BC( )
   {
      return bcNovedades ;
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
      AV32Pgmname = "" ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV13Insert_ConCodigo = "" ;
      AV26cantidadAgenda = "" ;
      AV27importeAgenda = "" ;
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
      Z2159AgePerDescrip = "" ;
      A2159AgePerDescrip = "" ;
      Z26ConCodigo = "" ;
      A26ConCodigo = "" ;
      Z1133AgePrevCalc = "" ;
      A1133AgePrevCalc = "" ;
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
      GXv_int6 = new int[1] ;
      BC001U7_A42ConCodYDesc = new String[] {""} ;
      BC001U7_n42ConCodYDesc = new boolean[] {false} ;
      BC001U7_A250LegIdNomApe = new String[] {""} ;
      BC001U7_A591LegNomApe = new String[] {""} ;
      BC001U7_A25AgeOrden = new short[1] ;
      BC001U7_A2EmpNom = new String[] {""} ;
      BC001U7_A230LegApellido = new String[] {""} ;
      BC001U7_A251LegNombre = new String[] {""} ;
      BC001U7_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC001U7_n244LegFecEgreso = new boolean[] {false} ;
      BC001U7_A41ConDescrip = new String[] {""} ;
      BC001U7_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001U7_n110AgeCanti = new boolean[] {false} ;
      BC001U7_A115AgeVUnit = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001U7_n115AgeVUnit = new boolean[] {false} ;
      BC001U7_A113AgeImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001U7_n113AgeImporte = new boolean[] {false} ;
      BC001U7_A1254AgeLiqNro = new int[1] ;
      BC001U7_n1254AgeLiqNro = new boolean[] {false} ;
      BC001U7_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      BC001U7_n111AgeFecDes = new boolean[] {false} ;
      BC001U7_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      BC001U7_n112AgeFecHas = new boolean[] {false} ;
      BC001U7_A93LegId = new String[] {""} ;
      BC001U7_n93LegId = new boolean[] {false} ;
      BC001U7_A239LegCUIL = new long[1] ;
      BC001U7_A2159AgePerDescrip = new String[] {""} ;
      BC001U7_A3CliCod = new int[1] ;
      BC001U7_A1EmpCod = new short[1] ;
      BC001U7_A6LegNumero = new int[1] ;
      BC001U7_A26ConCodigo = new String[] {""} ;
      A1132AgePrevis = "" ;
      BC001U8_A42ConCodYDesc = new String[] {""} ;
      BC001U8_n42ConCodYDesc = new boolean[] {false} ;
      BC001U8_A41ConDescrip = new String[] {""} ;
      BC001U9_A2EmpNom = new String[] {""} ;
      BC001U10_A250LegIdNomApe = new String[] {""} ;
      BC001U10_A591LegNomApe = new String[] {""} ;
      BC001U10_A230LegApellido = new String[] {""} ;
      BC001U10_A251LegNombre = new String[] {""} ;
      BC001U10_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC001U10_n244LegFecEgreso = new boolean[] {false} ;
      BC001U10_A93LegId = new String[] {""} ;
      BC001U10_n93LegId = new boolean[] {false} ;
      BC001U10_A239LegCUIL = new long[1] ;
      BC001U11_A3CliCod = new int[1] ;
      BC001U11_A1EmpCod = new short[1] ;
      BC001U11_A6LegNumero = new int[1] ;
      BC001U11_A25AgeOrden = new short[1] ;
      BC001U12_A25AgeOrden = new short[1] ;
      BC001U12_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001U12_n110AgeCanti = new boolean[] {false} ;
      BC001U12_A115AgeVUnit = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001U12_n115AgeVUnit = new boolean[] {false} ;
      BC001U12_A113AgeImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001U12_n113AgeImporte = new boolean[] {false} ;
      BC001U12_A1254AgeLiqNro = new int[1] ;
      BC001U12_n1254AgeLiqNro = new boolean[] {false} ;
      BC001U12_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      BC001U12_n111AgeFecDes = new boolean[] {false} ;
      BC001U12_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      BC001U12_n112AgeFecHas = new boolean[] {false} ;
      BC001U12_A2159AgePerDescrip = new String[] {""} ;
      BC001U12_A3CliCod = new int[1] ;
      BC001U12_A1EmpCod = new short[1] ;
      BC001U12_A6LegNumero = new int[1] ;
      BC001U12_A26ConCodigo = new String[] {""} ;
      sMode3 = "" ;
      BC001U13_A25AgeOrden = new short[1] ;
      BC001U13_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001U13_n110AgeCanti = new boolean[] {false} ;
      BC001U13_A115AgeVUnit = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001U13_n115AgeVUnit = new boolean[] {false} ;
      BC001U13_A113AgeImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001U13_n113AgeImporte = new boolean[] {false} ;
      BC001U13_A1254AgeLiqNro = new int[1] ;
      BC001U13_n1254AgeLiqNro = new boolean[] {false} ;
      BC001U13_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      BC001U13_n111AgeFecDes = new boolean[] {false} ;
      BC001U13_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      BC001U13_n112AgeFecHas = new boolean[] {false} ;
      BC001U13_A2159AgePerDescrip = new String[] {""} ;
      BC001U13_A3CliCod = new int[1] ;
      BC001U13_A1EmpCod = new short[1] ;
      BC001U13_A6LegNumero = new int[1] ;
      BC001U13_A26ConCodigo = new String[] {""} ;
      BC001U17_A2EmpNom = new String[] {""} ;
      BC001U18_A250LegIdNomApe = new String[] {""} ;
      BC001U18_A591LegNomApe = new String[] {""} ;
      BC001U18_A230LegApellido = new String[] {""} ;
      BC001U18_A251LegNombre = new String[] {""} ;
      BC001U18_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC001U18_n244LegFecEgreso = new boolean[] {false} ;
      BC001U18_A93LegId = new String[] {""} ;
      BC001U18_n93LegId = new boolean[] {false} ;
      BC001U18_A239LegCUIL = new long[1] ;
      BC001U19_A42ConCodYDesc = new String[] {""} ;
      BC001U19_n42ConCodYDesc = new boolean[] {false} ;
      BC001U19_A41ConDescrip = new String[] {""} ;
      GXt_char7 = "" ;
      GXv_decimal9 = new java.math.BigDecimal[1] ;
      GXv_char10 = new String[1] ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_char4 = new String[1] ;
      BC001U20_A42ConCodYDesc = new String[] {""} ;
      BC001U20_n42ConCodYDesc = new boolean[] {false} ;
      BC001U20_A250LegIdNomApe = new String[] {""} ;
      BC001U20_A591LegNomApe = new String[] {""} ;
      BC001U20_A25AgeOrden = new short[1] ;
      BC001U20_A2EmpNom = new String[] {""} ;
      BC001U20_A230LegApellido = new String[] {""} ;
      BC001U20_A251LegNombre = new String[] {""} ;
      BC001U20_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC001U20_n244LegFecEgreso = new boolean[] {false} ;
      BC001U20_A41ConDescrip = new String[] {""} ;
      BC001U20_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001U20_n110AgeCanti = new boolean[] {false} ;
      BC001U20_A115AgeVUnit = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001U20_n115AgeVUnit = new boolean[] {false} ;
      BC001U20_A113AgeImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001U20_n113AgeImporte = new boolean[] {false} ;
      BC001U20_A1254AgeLiqNro = new int[1] ;
      BC001U20_n1254AgeLiqNro = new boolean[] {false} ;
      BC001U20_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      BC001U20_n111AgeFecDes = new boolean[] {false} ;
      BC001U20_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      BC001U20_n112AgeFecHas = new boolean[] {false} ;
      BC001U20_A93LegId = new String[] {""} ;
      BC001U20_n93LegId = new boolean[] {false} ;
      BC001U20_A239LegCUIL = new long[1] ;
      BC001U20_A2159AgePerDescrip = new String[] {""} ;
      BC001U20_A3CliCod = new int[1] ;
      BC001U20_A1EmpCod = new short[1] ;
      BC001U20_A6LegNumero = new int[1] ;
      BC001U20_A26ConCodigo = new String[] {""} ;
      i111AgeFecDes = GXutil.nullDate() ;
      i110AgeCanti = DecimalUtil.ZERO ;
      i112AgeFecHas = GXutil.nullDate() ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC001U21_A2EmpNom = new String[] {""} ;
      BC001U22_A250LegIdNomApe = new String[] {""} ;
      BC001U22_A591LegNomApe = new String[] {""} ;
      BC001U22_A230LegApellido = new String[] {""} ;
      BC001U22_A251LegNombre = new String[] {""} ;
      BC001U22_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC001U22_n244LegFecEgreso = new boolean[] {false} ;
      BC001U22_A93LegId = new String[] {""} ;
      BC001U22_n93LegId = new boolean[] {false} ;
      BC001U22_A239LegCUIL = new long[1] ;
      BC001U23_A2EmpNom = new String[] {""} ;
      BC001U24_A250LegIdNomApe = new String[] {""} ;
      BC001U24_A591LegNomApe = new String[] {""} ;
      BC001U24_A230LegApellido = new String[] {""} ;
      BC001U24_A251LegNombre = new String[] {""} ;
      BC001U24_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      BC001U24_n244LegFecEgreso = new boolean[] {false} ;
      BC001U24_A93LegId = new String[] {""} ;
      BC001U24_n93LegId = new boolean[] {false} ;
      BC001U24_A239LegCUIL = new long[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.novedades_bc__default(),
         new Object[] {
             new Object[] {
            BC001U2_A25AgeOrden, BC001U2_A110AgeCanti, BC001U2_n110AgeCanti, BC001U2_A115AgeVUnit, BC001U2_n115AgeVUnit, BC001U2_A113AgeImporte, BC001U2_n113AgeImporte, BC001U2_A1254AgeLiqNro, BC001U2_n1254AgeLiqNro, BC001U2_A111AgeFecDes,
            BC001U2_n111AgeFecDes, BC001U2_A112AgeFecHas, BC001U2_n112AgeFecHas, BC001U2_A2159AgePerDescrip, BC001U2_A3CliCod, BC001U2_A1EmpCod, BC001U2_A6LegNumero, BC001U2_A26ConCodigo
            }
            , new Object[] {
            BC001U3_A25AgeOrden, BC001U3_A110AgeCanti, BC001U3_n110AgeCanti, BC001U3_A115AgeVUnit, BC001U3_n115AgeVUnit, BC001U3_A113AgeImporte, BC001U3_n113AgeImporte, BC001U3_A1254AgeLiqNro, BC001U3_n1254AgeLiqNro, BC001U3_A111AgeFecDes,
            BC001U3_n111AgeFecDes, BC001U3_A112AgeFecHas, BC001U3_n112AgeFecHas, BC001U3_A2159AgePerDescrip, BC001U3_A3CliCod, BC001U3_A1EmpCod, BC001U3_A6LegNumero, BC001U3_A26ConCodigo
            }
            , new Object[] {
            BC001U4_A2EmpNom
            }
            , new Object[] {
            BC001U5_A250LegIdNomApe, BC001U5_A591LegNomApe, BC001U5_A230LegApellido, BC001U5_A251LegNombre, BC001U5_A244LegFecEgreso, BC001U5_n244LegFecEgreso, BC001U5_A93LegId, BC001U5_n93LegId, BC001U5_A239LegCUIL
            }
            , new Object[] {
            BC001U6_A42ConCodYDesc, BC001U6_n42ConCodYDesc, BC001U6_A41ConDescrip
            }
            , new Object[] {
            BC001U7_A42ConCodYDesc, BC001U7_n42ConCodYDesc, BC001U7_A250LegIdNomApe, BC001U7_A591LegNomApe, BC001U7_A25AgeOrden, BC001U7_A2EmpNom, BC001U7_A230LegApellido, BC001U7_A251LegNombre, BC001U7_A244LegFecEgreso, BC001U7_n244LegFecEgreso,
            BC001U7_A41ConDescrip, BC001U7_A110AgeCanti, BC001U7_n110AgeCanti, BC001U7_A115AgeVUnit, BC001U7_n115AgeVUnit, BC001U7_A113AgeImporte, BC001U7_n113AgeImporte, BC001U7_A1254AgeLiqNro, BC001U7_n1254AgeLiqNro, BC001U7_A111AgeFecDes,
            BC001U7_n111AgeFecDes, BC001U7_A112AgeFecHas, BC001U7_n112AgeFecHas, BC001U7_A93LegId, BC001U7_n93LegId, BC001U7_A239LegCUIL, BC001U7_A2159AgePerDescrip, BC001U7_A3CliCod, BC001U7_A1EmpCod, BC001U7_A6LegNumero,
            BC001U7_A26ConCodigo
            }
            , new Object[] {
            BC001U8_A42ConCodYDesc, BC001U8_n42ConCodYDesc, BC001U8_A41ConDescrip
            }
            , new Object[] {
            BC001U9_A2EmpNom
            }
            , new Object[] {
            BC001U10_A250LegIdNomApe, BC001U10_A591LegNomApe, BC001U10_A230LegApellido, BC001U10_A251LegNombre, BC001U10_A244LegFecEgreso, BC001U10_n244LegFecEgreso, BC001U10_A93LegId, BC001U10_n93LegId, BC001U10_A239LegCUIL
            }
            , new Object[] {
            BC001U11_A3CliCod, BC001U11_A1EmpCod, BC001U11_A6LegNumero, BC001U11_A25AgeOrden
            }
            , new Object[] {
            BC001U12_A25AgeOrden, BC001U12_A110AgeCanti, BC001U12_n110AgeCanti, BC001U12_A115AgeVUnit, BC001U12_n115AgeVUnit, BC001U12_A113AgeImporte, BC001U12_n113AgeImporte, BC001U12_A1254AgeLiqNro, BC001U12_n1254AgeLiqNro, BC001U12_A111AgeFecDes,
            BC001U12_n111AgeFecDes, BC001U12_A112AgeFecHas, BC001U12_n112AgeFecHas, BC001U12_A2159AgePerDescrip, BC001U12_A3CliCod, BC001U12_A1EmpCod, BC001U12_A6LegNumero, BC001U12_A26ConCodigo
            }
            , new Object[] {
            BC001U13_A25AgeOrden, BC001U13_A110AgeCanti, BC001U13_n110AgeCanti, BC001U13_A115AgeVUnit, BC001U13_n115AgeVUnit, BC001U13_A113AgeImporte, BC001U13_n113AgeImporte, BC001U13_A1254AgeLiqNro, BC001U13_n1254AgeLiqNro, BC001U13_A111AgeFecDes,
            BC001U13_n111AgeFecDes, BC001U13_A112AgeFecHas, BC001U13_n112AgeFecHas, BC001U13_A2159AgePerDescrip, BC001U13_A3CliCod, BC001U13_A1EmpCod, BC001U13_A6LegNumero, BC001U13_A26ConCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001U17_A2EmpNom
            }
            , new Object[] {
            BC001U18_A250LegIdNomApe, BC001U18_A591LegNomApe, BC001U18_A230LegApellido, BC001U18_A251LegNombre, BC001U18_A244LegFecEgreso, BC001U18_n244LegFecEgreso, BC001U18_A93LegId, BC001U18_n93LegId, BC001U18_A239LegCUIL
            }
            , new Object[] {
            BC001U19_A42ConCodYDesc, BC001U19_n42ConCodYDesc, BC001U19_A41ConDescrip
            }
            , new Object[] {
            BC001U20_A42ConCodYDesc, BC001U20_n42ConCodYDesc, BC001U20_A250LegIdNomApe, BC001U20_A591LegNomApe, BC001U20_A25AgeOrden, BC001U20_A2EmpNom, BC001U20_A230LegApellido, BC001U20_A251LegNombre, BC001U20_A244LegFecEgreso, BC001U20_n244LegFecEgreso,
            BC001U20_A41ConDescrip, BC001U20_A110AgeCanti, BC001U20_n110AgeCanti, BC001U20_A115AgeVUnit, BC001U20_n115AgeVUnit, BC001U20_A113AgeImporte, BC001U20_n113AgeImporte, BC001U20_A1254AgeLiqNro, BC001U20_n1254AgeLiqNro, BC001U20_A111AgeFecDes,
            BC001U20_n111AgeFecDes, BC001U20_A112AgeFecHas, BC001U20_n112AgeFecHas, BC001U20_A93LegId, BC001U20_n93LegId, BC001U20_A239LegCUIL, BC001U20_A2159AgePerDescrip, BC001U20_A3CliCod, BC001U20_A1EmpCod, BC001U20_A6LegNumero,
            BC001U20_A26ConCodigo
            }
            , new Object[] {
            BC001U21_A2EmpNom
            }
            , new Object[] {
            BC001U22_A250LegIdNomApe, BC001U22_A591LegNomApe, BC001U22_A230LegApellido, BC001U22_A251LegNombre, BC001U22_A244LegFecEgreso, BC001U22_n244LegFecEgreso, BC001U22_A93LegId, BC001U22_n93LegId, BC001U22_A239LegCUIL
            }
            , new Object[] {
            BC001U23_A2EmpNom
            }
            , new Object[] {
            BC001U24_A250LegIdNomApe, BC001U24_A591LegNomApe, BC001U24_A230LegApellido, BC001U24_A251LegNombre, BC001U24_A244LegFecEgreso, BC001U24_n244LegFecEgreso, BC001U24_A93LegId, BC001U24_n93LegId, BC001U24_A239LegCUIL
            }
         }
      );
      AV32Pgmname = "Novedades_BC" ;
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
      e121U2 ();
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
   private short AV7EmpCod ;
   private short RcdFound3 ;
   private short nIsDirty_3 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int Z6LegNumero ;
   private int A6LegNumero ;
   private int AV33GXV1 ;
   private int AV30Insert_AgeLiqNro ;
   private int AV21CliCod ;
   private int AV8LegNumero ;
   private int GX_JID ;
   private int Z1254AgeLiqNro ;
   private int A1254AgeLiqNro ;
   private int GXt_int5 ;
   private int GXv_int6[] ;
   private int i1254AgeLiqNro ;
   private long Z239LegCUIL ;
   private long A239LegCUIL ;
   private java.math.BigDecimal Z110AgeCanti ;
   private java.math.BigDecimal A110AgeCanti ;
   private java.math.BigDecimal Z115AgeVUnit ;
   private java.math.BigDecimal A115AgeVUnit ;
   private java.math.BigDecimal Z113AgeImporte ;
   private java.math.BigDecimal A113AgeImporte ;
   private java.math.BigDecimal GXv_decimal9[] ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal i110AgeCanti ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV32Pgmname ;
   private String AV13Insert_ConCodigo ;
   private String AV26cantidadAgenda ;
   private String AV27importeAgenda ;
   private String Z26ConCodigo ;
   private String A26ConCodigo ;
   private String Z1133AgePrevCalc ;
   private String A1133AgePrevCalc ;
   private String Z93LegId ;
   private String A93LegId ;
   private String sMode3 ;
   private String GXt_char7 ;
   private String GXv_char10[] ;
   private String GXv_char4[] ;
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
   private boolean n1254AgeLiqNro ;
   private boolean n111AgeFecDes ;
   private boolean n110AgeCanti ;
   private boolean n112AgeFecHas ;
   private boolean n42ConCodYDesc ;
   private boolean n244LegFecEgreso ;
   private boolean n115AgeVUnit ;
   private boolean n113AgeImporte ;
   private boolean n93LegId ;
   private boolean Gx_longc ;
   private boolean i114AgeLegActivo ;
   private boolean mustCommit ;
   private String A1132AgePrevis ;
   private String Z2159AgePerDescrip ;
   private String A2159AgePerDescrip ;
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
   private web.SdtNovedades bcNovedades ;
   private IDataStoreProvider pr_default ;
   private String[] BC001U7_A42ConCodYDesc ;
   private boolean[] BC001U7_n42ConCodYDesc ;
   private String[] BC001U7_A250LegIdNomApe ;
   private String[] BC001U7_A591LegNomApe ;
   private short[] BC001U7_A25AgeOrden ;
   private String[] BC001U7_A2EmpNom ;
   private String[] BC001U7_A230LegApellido ;
   private String[] BC001U7_A251LegNombre ;
   private java.util.Date[] BC001U7_A244LegFecEgreso ;
   private boolean[] BC001U7_n244LegFecEgreso ;
   private String[] BC001U7_A41ConDescrip ;
   private java.math.BigDecimal[] BC001U7_A110AgeCanti ;
   private boolean[] BC001U7_n110AgeCanti ;
   private java.math.BigDecimal[] BC001U7_A115AgeVUnit ;
   private boolean[] BC001U7_n115AgeVUnit ;
   private java.math.BigDecimal[] BC001U7_A113AgeImporte ;
   private boolean[] BC001U7_n113AgeImporte ;
   private int[] BC001U7_A1254AgeLiqNro ;
   private boolean[] BC001U7_n1254AgeLiqNro ;
   private java.util.Date[] BC001U7_A111AgeFecDes ;
   private boolean[] BC001U7_n111AgeFecDes ;
   private java.util.Date[] BC001U7_A112AgeFecHas ;
   private boolean[] BC001U7_n112AgeFecHas ;
   private String[] BC001U7_A93LegId ;
   private boolean[] BC001U7_n93LegId ;
   private long[] BC001U7_A239LegCUIL ;
   private String[] BC001U7_A2159AgePerDescrip ;
   private int[] BC001U7_A3CliCod ;
   private short[] BC001U7_A1EmpCod ;
   private int[] BC001U7_A6LegNumero ;
   private String[] BC001U7_A26ConCodigo ;
   private String[] BC001U8_A42ConCodYDesc ;
   private boolean[] BC001U8_n42ConCodYDesc ;
   private String[] BC001U8_A41ConDescrip ;
   private String[] BC001U9_A2EmpNom ;
   private String[] BC001U10_A250LegIdNomApe ;
   private String[] BC001U10_A591LegNomApe ;
   private String[] BC001U10_A230LegApellido ;
   private String[] BC001U10_A251LegNombre ;
   private java.util.Date[] BC001U10_A244LegFecEgreso ;
   private boolean[] BC001U10_n244LegFecEgreso ;
   private String[] BC001U10_A93LegId ;
   private boolean[] BC001U10_n93LegId ;
   private long[] BC001U10_A239LegCUIL ;
   private int[] BC001U11_A3CliCod ;
   private short[] BC001U11_A1EmpCod ;
   private int[] BC001U11_A6LegNumero ;
   private short[] BC001U11_A25AgeOrden ;
   private short[] BC001U12_A25AgeOrden ;
   private java.math.BigDecimal[] BC001U12_A110AgeCanti ;
   private boolean[] BC001U12_n110AgeCanti ;
   private java.math.BigDecimal[] BC001U12_A115AgeVUnit ;
   private boolean[] BC001U12_n115AgeVUnit ;
   private java.math.BigDecimal[] BC001U12_A113AgeImporte ;
   private boolean[] BC001U12_n113AgeImporte ;
   private int[] BC001U12_A1254AgeLiqNro ;
   private boolean[] BC001U12_n1254AgeLiqNro ;
   private java.util.Date[] BC001U12_A111AgeFecDes ;
   private boolean[] BC001U12_n111AgeFecDes ;
   private java.util.Date[] BC001U12_A112AgeFecHas ;
   private boolean[] BC001U12_n112AgeFecHas ;
   private String[] BC001U12_A2159AgePerDescrip ;
   private int[] BC001U12_A3CliCod ;
   private short[] BC001U12_A1EmpCod ;
   private int[] BC001U12_A6LegNumero ;
   private String[] BC001U12_A26ConCodigo ;
   private short[] BC001U13_A25AgeOrden ;
   private java.math.BigDecimal[] BC001U13_A110AgeCanti ;
   private boolean[] BC001U13_n110AgeCanti ;
   private java.math.BigDecimal[] BC001U13_A115AgeVUnit ;
   private boolean[] BC001U13_n115AgeVUnit ;
   private java.math.BigDecimal[] BC001U13_A113AgeImporte ;
   private boolean[] BC001U13_n113AgeImporte ;
   private int[] BC001U13_A1254AgeLiqNro ;
   private boolean[] BC001U13_n1254AgeLiqNro ;
   private java.util.Date[] BC001U13_A111AgeFecDes ;
   private boolean[] BC001U13_n111AgeFecDes ;
   private java.util.Date[] BC001U13_A112AgeFecHas ;
   private boolean[] BC001U13_n112AgeFecHas ;
   private String[] BC001U13_A2159AgePerDescrip ;
   private int[] BC001U13_A3CliCod ;
   private short[] BC001U13_A1EmpCod ;
   private int[] BC001U13_A6LegNumero ;
   private String[] BC001U13_A26ConCodigo ;
   private String[] BC001U17_A2EmpNom ;
   private String[] BC001U18_A250LegIdNomApe ;
   private String[] BC001U18_A591LegNomApe ;
   private String[] BC001U18_A230LegApellido ;
   private String[] BC001U18_A251LegNombre ;
   private java.util.Date[] BC001U18_A244LegFecEgreso ;
   private boolean[] BC001U18_n244LegFecEgreso ;
   private String[] BC001U18_A93LegId ;
   private boolean[] BC001U18_n93LegId ;
   private long[] BC001U18_A239LegCUIL ;
   private String[] BC001U19_A42ConCodYDesc ;
   private boolean[] BC001U19_n42ConCodYDesc ;
   private String[] BC001U19_A41ConDescrip ;
   private String[] BC001U20_A42ConCodYDesc ;
   private boolean[] BC001U20_n42ConCodYDesc ;
   private String[] BC001U20_A250LegIdNomApe ;
   private String[] BC001U20_A591LegNomApe ;
   private short[] BC001U20_A25AgeOrden ;
   private String[] BC001U20_A2EmpNom ;
   private String[] BC001U20_A230LegApellido ;
   private String[] BC001U20_A251LegNombre ;
   private java.util.Date[] BC001U20_A244LegFecEgreso ;
   private boolean[] BC001U20_n244LegFecEgreso ;
   private String[] BC001U20_A41ConDescrip ;
   private java.math.BigDecimal[] BC001U20_A110AgeCanti ;
   private boolean[] BC001U20_n110AgeCanti ;
   private java.math.BigDecimal[] BC001U20_A115AgeVUnit ;
   private boolean[] BC001U20_n115AgeVUnit ;
   private java.math.BigDecimal[] BC001U20_A113AgeImporte ;
   private boolean[] BC001U20_n113AgeImporte ;
   private int[] BC001U20_A1254AgeLiqNro ;
   private boolean[] BC001U20_n1254AgeLiqNro ;
   private java.util.Date[] BC001U20_A111AgeFecDes ;
   private boolean[] BC001U20_n111AgeFecDes ;
   private java.util.Date[] BC001U20_A112AgeFecHas ;
   private boolean[] BC001U20_n112AgeFecHas ;
   private String[] BC001U20_A93LegId ;
   private boolean[] BC001U20_n93LegId ;
   private long[] BC001U20_A239LegCUIL ;
   private String[] BC001U20_A2159AgePerDescrip ;
   private int[] BC001U20_A3CliCod ;
   private short[] BC001U20_A1EmpCod ;
   private int[] BC001U20_A6LegNumero ;
   private String[] BC001U20_A26ConCodigo ;
   private String[] BC001U21_A2EmpNom ;
   private String[] BC001U22_A250LegIdNomApe ;
   private String[] BC001U22_A591LegNomApe ;
   private String[] BC001U22_A230LegApellido ;
   private String[] BC001U22_A251LegNombre ;
   private java.util.Date[] BC001U22_A244LegFecEgreso ;
   private boolean[] BC001U22_n244LegFecEgreso ;
   private String[] BC001U22_A93LegId ;
   private boolean[] BC001U22_n93LegId ;
   private long[] BC001U22_A239LegCUIL ;
   private String[] BC001U23_A2EmpNom ;
   private String[] BC001U24_A250LegIdNomApe ;
   private String[] BC001U24_A591LegNomApe ;
   private String[] BC001U24_A230LegApellido ;
   private String[] BC001U24_A251LegNombre ;
   private java.util.Date[] BC001U24_A244LegFecEgreso ;
   private boolean[] BC001U24_n244LegFecEgreso ;
   private String[] BC001U24_A93LegId ;
   private boolean[] BC001U24_n93LegId ;
   private long[] BC001U24_A239LegCUIL ;
   private short[] BC001U2_A25AgeOrden ;
   private java.math.BigDecimal[] BC001U2_A110AgeCanti ;
   private java.math.BigDecimal[] BC001U2_A115AgeVUnit ;
   private java.math.BigDecimal[] BC001U2_A113AgeImporte ;
   private int[] BC001U2_A1254AgeLiqNro ;
   private java.util.Date[] BC001U2_A111AgeFecDes ;
   private java.util.Date[] BC001U2_A112AgeFecHas ;
   private String[] BC001U2_A2159AgePerDescrip ;
   private int[] BC001U2_A3CliCod ;
   private short[] BC001U2_A1EmpCod ;
   private int[] BC001U2_A6LegNumero ;
   private String[] BC001U2_A26ConCodigo ;
   private short[] BC001U3_A25AgeOrden ;
   private java.math.BigDecimal[] BC001U3_A110AgeCanti ;
   private java.math.BigDecimal[] BC001U3_A115AgeVUnit ;
   private java.math.BigDecimal[] BC001U3_A113AgeImporte ;
   private int[] BC001U3_A1254AgeLiqNro ;
   private java.util.Date[] BC001U3_A111AgeFecDes ;
   private java.util.Date[] BC001U3_A112AgeFecHas ;
   private String[] BC001U3_A2159AgePerDescrip ;
   private int[] BC001U3_A3CliCod ;
   private short[] BC001U3_A1EmpCod ;
   private int[] BC001U3_A6LegNumero ;
   private String[] BC001U3_A26ConCodigo ;
   private String[] BC001U4_A2EmpNom ;
   private String[] BC001U5_A250LegIdNomApe ;
   private String[] BC001U5_A591LegNomApe ;
   private String[] BC001U5_A230LegApellido ;
   private String[] BC001U5_A251LegNombre ;
   private java.util.Date[] BC001U5_A244LegFecEgreso ;
   private String[] BC001U5_A93LegId ;
   private long[] BC001U5_A239LegCUIL ;
   private String[] BC001U6_A42ConCodYDesc ;
   private String[] BC001U6_A41ConDescrip ;
   private boolean[] BC001U2_n110AgeCanti ;
   private boolean[] BC001U2_n115AgeVUnit ;
   private boolean[] BC001U2_n113AgeImporte ;
   private boolean[] BC001U2_n1254AgeLiqNro ;
   private boolean[] BC001U2_n111AgeFecDes ;
   private boolean[] BC001U2_n112AgeFecHas ;
   private boolean[] BC001U3_n110AgeCanti ;
   private boolean[] BC001U3_n115AgeVUnit ;
   private boolean[] BC001U3_n113AgeImporte ;
   private boolean[] BC001U3_n1254AgeLiqNro ;
   private boolean[] BC001U3_n111AgeFecDes ;
   private boolean[] BC001U3_n112AgeFecHas ;
   private boolean[] BC001U5_n244LegFecEgreso ;
   private boolean[] BC001U5_n93LegId ;
   private boolean[] BC001U6_n42ConCodYDesc ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
}

final  class novedades_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC001U2", "SELECT AgeOrden, AgeCanti, AgeVUnit, AgeImporte, AgeLiqNro, AgeFecDes, AgeFecHas, AgePerDescrip, CliCod, EmpCod, LegNumero, ConCodigo FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ?  FOR UPDATE OF AgendaNovedades",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001U3", "SELECT AgeOrden, AgeCanti, AgeVUnit, AgeImporte, AgeLiqNro, AgeFecDes, AgeFecHas, AgePerDescrip, CliCod, EmpCod, LegNumero, ConCodigo FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001U4", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001U5", "SELECT LegIdNomApe, LegNomApe, LegApellido, LegNombre, LegFecEgreso, LegId, LegCUIL FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001U6", "SELECT ConCodYDesc, ConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001U7", "SELECT T4.ConCodYDesc, T3.LegIdNomApe, T3.LegNomApe, TM1.AgeOrden, T2.EmpNom, T3.LegApellido, T3.LegNombre, T3.LegFecEgreso, T4.ConDescrip, TM1.AgeCanti, TM1.AgeVUnit, TM1.AgeImporte, TM1.AgeLiqNro, TM1.AgeFecDes, TM1.AgeFecHas, T3.LegId, T3.LegCUIL, TM1.AgePerDescrip, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.ConCodigo FROM (((AgendaNovedades TM1 INNER JOIN Empresa T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod) INNER JOIN Legajo T3 ON T3.CliCod = TM1.CliCod AND T3.EmpCod = TM1.EmpCod AND T3.LegNumero = TM1.LegNumero) INNER JOIN Concepto T4 ON T4.CliCod = TM1.CliCod AND T4.ConCodigo = TM1.ConCodigo) WHERE TM1.AgeOrden = ? and TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.AgeOrden ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001U8", "SELECT ConCodYDesc, ConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001U9", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001U10", "SELECT LegIdNomApe, LegNomApe, LegApellido, LegNombre, LegFecEgreso, LegId, LegCUIL FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001U11", "SELECT CliCod, EmpCod, LegNumero, AgeOrden FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001U12", "SELECT AgeOrden, AgeCanti, AgeVUnit, AgeImporte, AgeLiqNro, AgeFecDes, AgeFecHas, AgePerDescrip, CliCod, EmpCod, LegNumero, ConCodigo FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001U13", "SELECT AgeOrden, AgeCanti, AgeVUnit, AgeImporte, AgeLiqNro, AgeFecDes, AgeFecHas, AgePerDescrip, CliCod, EmpCod, LegNumero, ConCodigo FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ?  FOR UPDATE OF AgendaNovedades",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001U14", "SAVEPOINT gxupdate;INSERT INTO AgendaNovedades(AgeOrden, AgeCanti, AgeVUnit, AgeImporte, AgeLiqNro, AgeFecDes, AgeFecHas, AgePerDescrip, CliCod, EmpCod, LegNumero, ConCodigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001U15", "SAVEPOINT gxupdate;UPDATE AgendaNovedades SET AgeCanti=?, AgeVUnit=?, AgeImporte=?, AgeLiqNro=?, AgeFecDes=?, AgeFecHas=?, AgePerDescrip=?, ConCodigo=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001U16", "SAVEPOINT gxupdate;DELETE FROM AgendaNovedades  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001U17", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001U18", "SELECT LegIdNomApe, LegNomApe, LegApellido, LegNombre, LegFecEgreso, LegId, LegCUIL FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001U19", "SELECT ConCodYDesc, ConDescrip FROM Concepto WHERE CliCod = ? AND ConCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001U20", "SELECT T4.ConCodYDesc, T3.LegIdNomApe, T3.LegNomApe, TM1.AgeOrden, T2.EmpNom, T3.LegApellido, T3.LegNombre, T3.LegFecEgreso, T4.ConDescrip, TM1.AgeCanti, TM1.AgeVUnit, TM1.AgeImporte, TM1.AgeLiqNro, TM1.AgeFecDes, TM1.AgeFecHas, T3.LegId, T3.LegCUIL, TM1.AgePerDescrip, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.ConCodigo FROM (((AgendaNovedades TM1 INNER JOIN Empresa T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod) INNER JOIN Legajo T3 ON T3.CliCod = TM1.CliCod AND T3.EmpCod = TM1.EmpCod AND T3.LegNumero = TM1.LegNumero) INNER JOIN Concepto T4 ON T4.CliCod = TM1.CliCod AND T4.ConCodigo = TM1.ConCodigo) WHERE TM1.AgeOrden = ? and TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.AgeOrden ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001U21", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001U22", "SELECT LegIdNomApe, LegNomApe, LegApellido, LegNombre, LegFecEgreso, LegId, LegCUIL FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001U23", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001U24", "SELECT LegIdNomApe, LegNomApe, LegApellido, LegNombre, LegFecEgreso, LegId, LegCUIL FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[7])[0] = rslt.getInt(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(8);
               ((int[]) buf[14])[0] = rslt.getInt(9);
               ((short[]) buf[15])[0] = rslt.getShort(10);
               ((int[]) buf[16])[0] = rslt.getInt(11);
               ((String[]) buf[17])[0] = rslt.getString(12, 10);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((int[]) buf[7])[0] = rslt.getInt(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(8);
               ((int[]) buf[14])[0] = rslt.getInt(9);
               ((short[]) buf[15])[0] = rslt.getShort(10);
               ((int[]) buf[16])[0] = rslt.getInt(11);
               ((String[]) buf[17])[0] = rslt.getString(12, 10);
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
               ((long[]) buf[8])[0] = rslt.getLong(7);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
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
               ((int[]) buf[17])[0] = rslt.getInt(13);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(14);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[21])[0] = rslt.getGXDate(15);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getString(16, 20);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((long[]) buf[25])[0] = rslt.getLong(17);
               ((String[]) buf[26])[0] = rslt.getVarchar(18);
               ((int[]) buf[27])[0] = rslt.getInt(19);
               ((short[]) buf[28])[0] = rslt.getShort(20);
               ((int[]) buf[29])[0] = rslt.getInt(21);
               ((String[]) buf[30])[0] = rslt.getString(22, 10);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
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
               ((long[]) buf[8])[0] = rslt.getLong(7);
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
               ((int[]) buf[7])[0] = rslt.getInt(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(8);
               ((int[]) buf[14])[0] = rslt.getInt(9);
               ((short[]) buf[15])[0] = rslt.getShort(10);
               ((int[]) buf[16])[0] = rslt.getInt(11);
               ((String[]) buf[17])[0] = rslt.getString(12, 10);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((int[]) buf[7])[0] = rslt.getInt(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDate(7);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(8);
               ((int[]) buf[14])[0] = rslt.getInt(9);
               ((short[]) buf[15])[0] = rslt.getShort(10);
               ((int[]) buf[16])[0] = rslt.getInt(11);
               ((String[]) buf[17])[0] = rslt.getString(12, 10);
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
               ((long[]) buf[8])[0] = rslt.getLong(7);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
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
               ((int[]) buf[17])[0] = rslt.getInt(13);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(14);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[21])[0] = rslt.getGXDate(15);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getString(16, 20);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((long[]) buf[25])[0] = rslt.getLong(17);
               ((String[]) buf[26])[0] = rslt.getVarchar(18);
               ((int[]) buf[27])[0] = rslt.getInt(19);
               ((short[]) buf[28])[0] = rslt.getShort(20);
               ((int[]) buf[29])[0] = rslt.getInt(21);
               ((String[]) buf[30])[0] = rslt.getString(22, 10);
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
               ((long[]) buf[8])[0] = rslt.getLong(7);
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
               ((long[]) buf[8])[0] = rslt.getLong(7);
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
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(5, ((Number) parms[8]).intValue());
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
                  stmt.setNull( 7 , Types.DATE );
               }
               else
               {
                  stmt.setDate(7, (java.util.Date)parms[12]);
               }
               stmt.setVarchar(8, (String)parms[13], 400, false);
               stmt.setInt(9, ((Number) parms[14]).intValue());
               stmt.setShort(10, ((Number) parms[15]).shortValue());
               stmt.setInt(11, ((Number) parms[16]).intValue());
               stmt.setString(12, (String)parms[17], 10);
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
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(4, ((Number) parms[7]).intValue());
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
                  stmt.setNull( 6 , Types.DATE );
               }
               else
               {
                  stmt.setDate(6, (java.util.Date)parms[11]);
               }
               stmt.setVarchar(7, (String)parms[12], 400, false);
               stmt.setString(8, (String)parms[13], 10);
               stmt.setInt(9, ((Number) parms[14]).intValue());
               stmt.setShort(10, ((Number) parms[15]).shortValue());
               stmt.setInt(11, ((Number) parms[16]).intValue());
               stmt.setShort(12, ((Number) parms[17]).shortValue());
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

