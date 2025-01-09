package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pruebas_impl extends GXDataArea
{
   public pruebas_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public pruebas_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pruebas_impl.class ));
   }

   public pruebas_impl( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavEliminarliquidaciones = UIFactory.getCheckbox(this);
      chkavCorrerrelacionada = UIFactory.getCheckbox(this);
      chkavCorrersolopendientes = UIFactory.getCheckbox(this);
      chkavJorvsmen = UIFactory.getCheckbox(this);
      chkavCompensarplus = UIFactory.getCheckbox(this);
      chkTestOK = UIFactory.getCheckbox(this);
      dynavImptliqcod = new HTMLChoice();
      chkavEliminarliquidacionesreplica = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetNextPar( ) ;
         gxfirstwebparm_bkp = gxfirstwebparm ;
         gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            dyncall( httpContext.GetNextPar( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vIMPTLIQCOD") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvimptliqcodBL2( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetNextPar( ) ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetNextPar( ) ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Freestylegrid2") == 0 )
         {
            gxnrfreestylegrid2_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Freestylegrid2") == 0 )
         {
            gxgrfreestylegrid2_refresh_invoke( ) ;
            return  ;
         }
         else
         {
            if ( ! httpContext.IsValidAjaxCall( false) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = gxfirstwebparm_bkp ;
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrfreestylegrid2_newrow_invoke( )
   {
      nRC_GXsfl_63 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_63"))) ;
      nGXsfl_63_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_63_idx"))) ;
      sGXsfl_63_idx = httpContext.GetPar( "sGXsfl_63_idx") ;
      edtTestNro_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtTestNro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTestNro_Visible), 5, 0), !bGXsfl_63_Refreshing);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrfreestylegrid2_newrow( ) ;
      /* End function gxnrFreestylegrid2_newrow_invoke */
   }

   public void gxgrfreestylegrid2_refresh_invoke( )
   {
      edtTestNro_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtTestNro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTestNro_Visible), 5, 0), !bGXsfl_63_Refreshing);
      dynavImptliqcod.fromJSonString( httpContext.GetNextPar( ));
      AV114impTLiqCod = httpContext.GetPar( "impTLiqCod") ;
      AV44eliminarLiquidaciones = GXutil.strtobool( httpContext.GetPar( "eliminarLiquidaciones")) ;
      AV48correrRelacionada = GXutil.strtobool( httpContext.GetPar( "correrRelacionada")) ;
      AV68CorrerSoloPendientes = GXutil.strtobool( httpContext.GetPar( "CorrerSoloPendientes")) ;
      AV79JorVsMen = GXutil.strtobool( httpContext.GetPar( "JorVsMen")) ;
      AV80CompensarPlus = GXutil.strtobool( httpContext.GetPar( "CompensarPlus")) ;
      AV115eliminarliquidacionesreplica = GXutil.strtobool( httpContext.GetPar( "eliminarliquidacionesreplica")) ;
      AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV8EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV12anio = (short)(GXutil.lval( httpContext.GetPar( "anio"))) ;
      AV43date = localUtil.parseDateParm( httpContext.GetPar( "date")) ;
      AV128Pgmname = httpContext.GetPar( "Pgmname") ;
      AV47bonoProdConCodigo = httpContext.GetPar( "bonoProdConCodigo") ;
      AV64ConCodigo = httpContext.GetPar( "ConCodigo") ;
      AV125vaciaFecha = localUtil.parseDateParm( httpContext.GetPar( "vaciaFecha")) ;
      AV96testImportes1 = CommonUtil.decimalVal( httpContext.GetPar( "testImportes1"), ".") ;
      AV90testImportes2 = CommonUtil.decimalVal( httpContext.GetPar( "testImportes2"), ".") ;
      AV93testImportes3 = CommonUtil.decimalVal( httpContext.GetPar( "testImportes3"), ".") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrfreestylegrid2_refresh( AV114impTLiqCod, AV44eliminarLiquidaciones, AV48correrRelacionada, AV68CorrerSoloPendientes, AV79JorVsMen, AV80CompensarPlus, AV115eliminarliquidacionesreplica, AV7CliCod, AV8EmpCod, AV12anio, AV43date, AV128Pgmname, AV47bonoProdConCodigo, AV64ConCodigo, AV125vaciaFecha, AV96testImportes1, AV90testImportes2, AV93testImportes3) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrFreestylegrid2_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.newmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public byte executeStartEvent( )
   {
      paBL2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startBL2( ) ;
      }
      return gxajaxcallmode ;
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
      httpContext.writeTextNL( "</title>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( GXutil.len( sDynURL) > 0 )
      {
         httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
      }
      define_styles( ) ;
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.pruebas", new String[] {}, new String[] {}) +"\">") ;
         web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      }
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vANIO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV12anio), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDATE", getSecureSignedToken( "", AV43date));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV128Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vBONOPRODCONCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV47bonoProdConCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV64ConCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vVACIAFECHA", getSecureSignedToken( "", AV125vaciaFecha));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"Pruebas");
      forbiddenHiddens.add("testImportes1", localUtil.format( AV96testImportes1, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("testImportes2", localUtil.format( AV90testImportes2, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("testImportes3", localUtil.format( AV93testImportes3, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("pruebas:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_63", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_63, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "TESTNOMBRE", GXutil.rtrim( A1086TestNombre));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vANIO", GXutil.ltrim( localUtil.ntoc( AV12anio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vANIO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV12anio), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vDATE", localUtil.dtoc( AV43date, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDATE", getSecureSignedToken( "", AV43date));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vTESTOK", AV63TestOK);
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV13LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV128Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV128Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEG1_LEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV56leg1_LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEG2_LEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV55leg2_LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTESTNRO", AV49TestNro);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTESTNRO", AV49TestNro);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vCOMPARAR", GXutil.rtrim( AV75comparar));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vPLUS", AV78plus);
      web.GxWebStd.gx_hidden_field( httpContext, "vADICIONALCONCODIGO", GXutil.rtrim( AV69adicionalConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "vBONOPRODCONCODIGO", GXutil.rtrim( AV47bonoProdConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vBONOPRODCONCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV47bonoProdConCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONCODIGO", GXutil.rtrim( AV64ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV64ConCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMES", GXutil.ltrim( localUtil.ntoc( AV46Mes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTLIQCOD", GXutil.rtrim( AV45TLiqCod));
      web.GxWebStd.gx_hidden_field( httpContext, "vVACIAFECHA", localUtil.dtoc( AV125vaciaFecha, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vVACIAFECHA", getSecureSignedToken( "", AV125vaciaFecha));
      web.GxWebStd.gx_hidden_field( httpContext, "TESTNRO_Visible", GXutil.ltrim( localUtil.ntoc( edtTestNro_Visible, (byte)(5), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "</form>") ;
      }
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
      httpContext.writeText( "<script type=\"text/javascript\">") ;
      httpContext.writeText( "gx.setLanguageCode(\""+httpContext.getLanguageProperty( "code")+"\");") ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         httpContext.writeText( "gx.setDateFormat(\""+httpContext.getLanguageProperty( "date_fmt")+"\");") ;
         httpContext.writeText( "gx.setTimeFormat("+httpContext.getLanguageProperty( "time_fmt")+");") ;
         httpContext.writeText( "gx.setCenturyFirstYear("+40+");") ;
         httpContext.writeText( "gx.setDecimalPoint(\""+httpContext.getLanguageProperty( "decimal_point")+"\");") ;
         httpContext.writeText( "gx.setThousandSeparator(\""+httpContext.getLanguageProperty( "thousand_sep")+"\");") ;
         httpContext.writeText( "gx.StorageTimeZone = "+1+";") ;
      }
      httpContext.writeText( "</script>") ;
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         weBL2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtBL2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.pruebas", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "Pruebas" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Pruebas", "") ;
   }

   public void wbBL0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
         }
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 12,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnini_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "Ini", ""), bttBtnini_Jsonclick, 5, httpContext.getMessage( "Ini", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINI\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAuxcantmeses_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavAuxcantmeses_Internalname, httpContext.getMessage( "auxiliar cantidad meses", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 17,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavAuxcantmeses_Internalname, GXutil.ltrim( localUtil.ntoc( AV42auxCantMeses, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavAuxcantmeses_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV42auxCantMeses), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV42auxCantMeses), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,17);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAuxcantmeses_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavAuxcantmeses_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavEliminarliquidaciones.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavEliminarliquidaciones.getInternalname(), httpContext.getMessage( "eliminar Liquidaciones", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEliminarliquidaciones.getInternalname(), GXutil.booltostr( AV44eliminarLiquidaciones), "", httpContext.getMessage( "eliminar Liquidaciones", ""), 1, chkavEliminarliquidaciones.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(22, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,22);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavCorrerrelacionada.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavCorrerrelacionada.getInternalname(), httpContext.getMessage( "correr Relacionada", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavCorrerrelacionada.getInternalname(), GXutil.booltostr( AV48correrRelacionada), "", httpContext.getMessage( "correr Relacionada", ""), 1, chkavCorrerrelacionada.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(27, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,27);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPararenerror_Internalname+"\"", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavPararenerror_Internalname, GXutil.booltostr( AV66pararEnError), GXutil.booltostr( AV66pararEnError), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPararenerror_Jsonclick, 0, "AttributeCheckBox", "", "", "", "", 1, edtavPararenerror_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavCorrersolopendientes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavCorrersolopendientes.getInternalname(), httpContext.getMessage( "Correr solo pendientes", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavCorrersolopendientes.getInternalname(), GXutil.booltostr( AV68CorrerSoloPendientes), "", httpContext.getMessage( "Correr solo pendientes", ""), 1, chkavCorrersolopendientes.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(37, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,37);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavJorvsmen.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavJorvsmen.getInternalname(), httpContext.getMessage( "Comparar jornal vs mensual en todas", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavJorvsmen.getInternalname(), GXutil.booltostr( AV79JorVsMen), "", httpContext.getMessage( "Comparar jornal vs mensual en todas", ""), 1, chkavJorvsmen.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(42, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,42);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavCompensarplus.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, chkavCompensarplus.getInternalname(), httpContext.getMessage( "CompensarPlusConAdicional (tildar cuando se liquidan feriados)", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavCompensarplus.getInternalname(), GXutil.booltostr( AV80CompensarPlus), "", httpContext.getMessage( "CompensarPlusConAdicional (tildar cuando se liquidan feriados)", ""), 1, chkavCompensarplus.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(47, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,47);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSueldomensuales_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSueldomensuales_Internalname, httpContext.getMessage( "Sueldo mensuales", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSueldomensuales_Internalname, GXutil.ltrim( localUtil.ntoc( AV100sueldoMensuales, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavSueldomensuales_Enabled!=0) ? localUtil.format( AV100sueldoMensuales, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV100sueldoMensuales, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSueldomensuales_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavSueldomensuales_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavValorhorajor_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavValorhorajor_Internalname, httpContext.getMessage( "Valor hora jornales", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavValorhorajor_Internalname, GXutil.ltrim( localUtil.ntoc( AV101valorHoraJor, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavValorhorajor_Enabled!=0) ? localUtil.format( AV101valorHoraJor, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV101valorHoraJor, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,57);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavValorhorajor_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavValorhorajor_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         Freestylegrid2Container.SetIsFreestyle(true);
         Freestylegrid2Container.SetWrapped(nGXWrapped);
         startgridcontrol63( ) ;
      }
      if ( wbEnd == 63 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_63 = (int)(nGXsfl_63_idx-1) ;
         if ( Freestylegrid2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Freestylegrid2Container"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Freestylegrid2", Freestylegrid2Container, subFreestylegrid2_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Freestylegrid2ContainerData", Freestylegrid2Container.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Freestylegrid2ContainerData"+"V", Freestylegrid2Container.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Freestylegrid2ContainerData"+"V"+"\" value='"+Freestylegrid2Container.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 100,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnprobartodos_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "Probar todos", ""), bttBtnprobartodos_Jsonclick, 5, httpContext.getMessage( "Probar todos", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOPROBARTODOS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 103,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtniniapl_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "Ini Apl", ""), bttBtniniapl_Jsonclick, 5, httpContext.getMessage( "Ini Apl", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINIAPL\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 106,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncorregircorhetesconcpeot_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "Corregir corchetes conceptos", ""), bttBtncorregircorhetesconcpeot_Jsonclick, 5, httpContext.getMessage( "Corregir corchetes conceptos", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOCORREGIRCORHETESCONCPEOT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnactualizartopes_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "actualizartopes", ""), bttBtnactualizartopes_Jsonclick, 5, httpContext.getMessage( "actualizartopes", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOACTUALIZARTOPES\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 112,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncrearfulanos_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "Crear Fulanos", ""), bttBtncrearfulanos_Jsonclick, 5, httpContext.getMessage( "Crear Fulanos", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOCREARFULANOS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table1_115_BL2( true) ;
      }
      else
      {
         wb_table1_115_BL2( false) ;
      }
      return  ;
   }

   public void wb_table1_115_BL2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table2_139_BL2( true) ;
      }
      else
      {
         wb_table2_139_BL2( false) ;
      }
      return  ;
   }

   public void wb_table2_139_BL2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table3_163_BL2( true) ;
      }
      else
      {
         wb_table3_163_BL2( false) ;
      }
      return  ;
   }

   public void wb_table3_163_BL2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table4_189_BL2( true) ;
      }
      else
      {
         wb_table4_189_BL2( false) ;
      }
      return  ;
   }

   public void wb_table4_189_BL2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 199,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnduplicarlegajo_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "multiplicarLegajo", ""), bttBtnduplicarlegajo_Jsonclick, 5, httpContext.getMessage( "multiplicarLegajo", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DODUPLICARLEGAJO\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavMultilegnumero_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavMultilegnumero_Internalname, httpContext.getMessage( "Legajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 204,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavMultilegnumero_Internalname, GXutil.ltrim( localUtil.ntoc( AV102multiLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavMultilegnumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV102multiLegNumero), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV102multiLegNumero), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,204);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavMultilegnumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavMultilegnumero_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavMulticant_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavMulticant_Internalname, httpContext.getMessage( "cantidad", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 209,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavMulticant_Internalname, GXutil.ltrim( localUtil.ntoc( AV103multiCant, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavMulticant_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV103multiCant), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV103multiCant), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,209);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavMulticant_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavMulticant_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 212,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnfixescalasnoviembre_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "fix escalas noviembre", ""), bttBtnfixescalasnoviembre_Jsonclick, 5, httpContext.getMessage( "fix escalas noviembre", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOFIXESCALASNOVIEMBRE\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 215,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnpreliquidaciones_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "Preliquidaciones", ""), bttBtnpreliquidaciones_Jsonclick, 7, httpContext.getMessage( "Preliquidaciones", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e11bl1_client"+"'", TempTags, "", 2, "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblAyuda_Internalname, httpContext.getMessage( "<svg width=\"32\" height=\"32\" viewBox=\"0 0 32 32\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><g id=\"help-circle-outline\"><g id=\"Group 120\"><path id=\"Vector\" d=\"M16.0591 5C13.8916 5 11.7727 5.64514 9.97041 6.85383C8.16815 8.06253 6.76346 9.7805 5.93397 11.7905C5.10448 13.8005 4.88745 16.0122 5.31032 18.146C5.73319 20.2798 6.77697 22.2398 8.30966 23.7782C9.84236 25.3166 11.7951 26.3642 13.921 26.7886C16.047 27.2131 18.2505 26.9952 20.2531 26.1627C22.2557 25.3301 23.9673 23.9202 25.1715 22.1113C26.3757 20.3023 27.0185 18.1756 27.0185 16C27.0185 13.0826 25.8639 10.2847 23.8086 8.22183C21.7533 6.15893 18.9657 5 16.0591 5Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.8\" stroke-miterlimit=\"10\"/><path id=\"Vector_2\" d=\"M12.871 13.0086C12.871 13.0086 12.9233 11.9148 14.0896 10.973C14.7814 10.4136 15.6108 10.2517 16.358 10.2405C17.0386 10.2317 17.6464 10.3448 18.01 10.5186C18.6327 10.8161 19.8451 11.5423 19.8451 13.0867C19.8451 14.7117 18.7865 15.4498 17.5804 16.2617C16.3742 17.0736 16.0467 17.9548 16.0467 18.8655\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.8\" stroke-miterlimit=\"10\" stroke-linecap=\"round\"/><path id=\"Vector_3\" d=\"M15.9529 23.2533C16.4812 23.2533 16.9094 22.8235 16.9094 22.2933C16.9094 21.7631 16.4812 21.3333 15.9529 21.3333C15.4247 21.3333 14.9965 21.7631 14.9965 22.2933C14.9965 22.8235 15.4247 23.2533 15.9529 23.2533Z\" fill=\"var(--colors_gray08)\"/></g></g></svg>", ""), "", "", lblAyuda_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSvgvalor_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSvgvalor_Internalname, httpContext.getMessage( "svgvalor", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 223,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavSvgvalor_Internalname, AV109SVGValor, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,223);\"", (short)(0), 1, edtavSvgvalor_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTestsvg_Internalname, lblTestsvg_Caption, "", "", lblTestsvg_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 229,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnuseraction5_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "UserAction5", ""), bttBtnuseraction5_Jsonclick, 7, httpContext.getMessage( "UserAction5", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e12bl1_client"+"'", TempTags, "", 2, "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 232,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnformula_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "formula", ""), bttBtnformula_Jsonclick, 7, httpContext.getMessage( "formula", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e13bl1_client"+"'", TempTags, "", 2, "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavExpresion_Internalname+"\"", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 237,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavExpresion_Internalname, GXutil.rtrim( AV111expresion), GXutil.rtrim( localUtil.format( AV111expresion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,237);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavExpresion_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavExpresion_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPalabraaaaamm_Internalname+"\"", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 242,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavPalabraaaaamm_Internalname, GXutil.rtrim( AV110palabraAAAAMM), GXutil.rtrim( localUtil.format( AV110palabraAAAAMM, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,242);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPalabraaaaamm_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavPalabraaaaamm_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 245,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnregex_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "reg ex", ""), bttBtnregex_Jsonclick, 5, httpContext.getMessage( "reg ex", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOREGEX\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 248,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnimportartodosproa_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "Importar todos proa", ""), bttBtnimportartodosproa_Jsonclick, 5, httpContext.getMessage( "Importar todos proa", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOIMPORTARTODOSPROA\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavMesnro_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavMesnro_Internalname, httpContext.getMessage( "mes", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 253,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavMesnro_Internalname, GXutil.ltrim( localUtil.ntoc( AV124mesNro, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavMesnro_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV124mesNro), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV124mesNro), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,253);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavMesnro_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavMesnro_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 256,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnimportartodoslsdproa_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "Importar todos LSD proa", ""), bttBtnimportartodoslsdproa_Jsonclick, 5, httpContext.getMessage( "Importar todos LSD proa", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOIMPORTARTODOSLSDPROA\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOtraempcod_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavOtraempcod_Internalname, httpContext.getMessage( "Empresa", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 261,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavOtraempcod_Internalname, GXutil.ltrim( localUtil.ntoc( AV112otraEmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavOtraempcod_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV112otraEmpCod), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV112otraEmpCod), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,261);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOtraempcod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavOtraempcod_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavImpliqperiodo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavImpliqperiodo_Internalname, httpContext.getMessage( "Periodo liquidado", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 266,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavImpliqperiodo_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavImpliqperiodo_Internalname, localUtil.format(AV113impLiqPeriodo, "99/99/9999"), localUtil.format( AV113impLiqPeriodo, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,266);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavImpliqperiodo_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavImpliqperiodo_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavImpliqperiodo_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavImpliqperiodo_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Pruebas.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavImptliqcod.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavImptliqcod.getInternalname(), httpContext.getMessage( "Tipo de Liquidación", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 271,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavImptliqcod, dynavImptliqcod.getInternalname(), GXutil.rtrim( AV114impTLiqCod), 1, dynavImptliqcod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynavImptliqcod.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,271);\"", "", true, (byte)(0), "HLP_Pruebas.htm");
         dynavImptliqcod.setValue( GXutil.rtrim( AV114impTLiqCod) );
         httpContext.ajax_rsp_assign_prop("", false, dynavImptliqcod.getInternalname(), "Values", dynavImptliqcod.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavEliminarliquidacionesreplica.getInternalname()+"\"", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 276,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         web.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEliminarliquidacionesreplica.getInternalname(), GXutil.booltostr( AV115eliminarliquidacionesreplica), "", "", 1, chkavEliminarliquidacionesreplica.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(276, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,276);\"");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 279,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnreplicarimportadas_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "Replicar importadas", ""), bttBtnreplicarimportadas_Jsonclick, 5, httpContext.getMessage( "Replicar importadas", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOREPLICARIMPORTADAS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 282,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnhttp_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "http", ""), bttBtnhttp_Jsonclick, 7, httpContext.getMessage( "http", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e14bl1_client"+"'", TempTags, "", 2, "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 285,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncalccontr_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "Calc. Contr.", ""), bttBtncalccontr_Jsonclick, 5, httpContext.getMessage( "Calc. Contr.", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOCALCCONTR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 288,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninimenuusu_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "Inii menu usu", ""), bttBtninimenuusu_Jsonclick, 5, httpContext.getMessage( "Inii menu usu", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINIMENUUSU\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 291,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtndeletecuentas_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "delete cuenta corriente lic", ""), bttBtndeletecuentas_Jsonclick, 5, httpContext.getMessage( "delete cuenta corriente lic", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DODELETECUENTAS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 294,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninipermas_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "ini permanencias", ""), bttBtninipermas_Jsonclick, 5, httpContext.getMessage( "ini permanencias", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINIPERMAS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 297,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtneliminadup_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "Elimina liqs imp duplicadas", ""), bttBtneliminadup_Jsonclick, 5, httpContext.getMessage( "Elimina liqs imp duplicadas", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOELIMINADUP\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavDliqperiodo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavDliqperiodo_Internalname, httpContext.getMessage( "Periodo", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 302,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavDliqperiodo_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDliqperiodo_Internalname, localUtil.format(AV123DLiqPeriodo, "99/99/99"), localUtil.format( AV123DLiqPeriodo, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,302);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDliqperiodo_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavDliqperiodo_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_bitmap( httpContext, edtavDliqperiodo_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavDliqperiodo_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Pruebas.htm");
         httpContext.writeTextNL( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 305,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtngeneraauxfaltantes_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "Generar auxiliares faltantes importacion", ""), bttBtngeneraauxfaltantes_Jsonclick, 5, httpContext.getMessage( "Generar auxiliares faltantes importacion", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOGENERAAUXFALTANTES\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 308,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncorrigeimp_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "Corrige importadas", ""), bttBtncorrigeimp_Jsonclick, 5, httpContext.getMessage( "Corrige importadas", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOCORRIGEIMP\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 311,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtninisueldoslegajos_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "Ini Legajo sueldos", ""), bttBtninisueldoslegajos_Jsonclick, 5, httpContext.getMessage( "Ini Legajo sueldos", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOINISUELDOSLEGAJOS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 314,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnuseraction6_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "ini permisos", ""), bttBtnuseraction6_Jsonclick, 5, httpContext.getMessage( "ini permisos", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOUSERACTION6\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 317,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnuseraction7_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "ini tliqdescaux", ""), bttBtnuseraction7_Jsonclick, 5, httpContext.getMessage( "ini tliqdescaux", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOUSERACTION7\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 320,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnuseraction8_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "Inicializar LegSuelVto", ""), bttBtnuseraction8_Jsonclick, 5, httpContext.getMessage( "Inicializar LegSuelVto", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOUSERACTION8\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 323,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnuseraction9_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "hash", ""), bttBtnuseraction9_Jsonclick, 5, httpContext.getMessage( "hash", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOUSERACTION9\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 63 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Freestylegrid2Container.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Freestylegrid2Container"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Freestylegrid2", Freestylegrid2Container, subFreestylegrid2_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Freestylegrid2ContainerData", Freestylegrid2Container.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Freestylegrid2ContainerData"+"V", Freestylegrid2Container.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Freestylegrid2ContainerData"+"V"+"\" value='"+Freestylegrid2Container.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void startBL2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Pruebas", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupBL0( ) ;
   }

   public void wsBL2( )
   {
      startBL2( ) ;
      evtBL2( ) ;
   }

   public void evtBL2( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            sEvt = httpContext.cgiGet( "_EventName") ;
            EvtGridId = httpContext.cgiGet( "_EventGridId") ;
            EvtRowId = httpContext.cgiGet( "_EventRowId") ;
            if ( GXutil.len( sEvt) > 0 )
            {
               sEvtType = GXutil.left( sEvt, 1) ;
               sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
               if ( GXutil.strcmp(sEvtType, "M") != 0 )
               {
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINI'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoIni' */
                           e15BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOPROBARTODOS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoProbarTodos' */
                           e16BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINIAPL'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoIniApl' */
                           e17BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCORREGIRCORHETESCONCPEOT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoCorregirCorhetesconcpeot' */
                           e18BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOACTUALIZARTOPES'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Doactualizartopes' */
                           e19BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCREARFULANOS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoCrearFulanos' */
                           e20BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DODUPLICARLEGAJO'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoduplicarLegajo' */
                           e21BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOFIXESCALASNOVIEMBRE'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DofixEscalasNoviembre' */
                           e22BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOREGEX'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Doregex' */
                           e23BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOIMPORTARTODOSPROA'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoImportarTodosProa' */
                           e24BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOIMPORTARTODOSLSDPROA'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoImportarTodoslsdProa' */
                           e25BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOREPLICARIMPORTADAS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoReplicarimportadas' */
                           e26BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCALCCONTR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoCalcContr' */
                           e27BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINIMENUUSU'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoIniMenuUsu' */
                           e28BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DODELETECUENTAS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DodeleteCuentas' */
                           e29BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINIPERMAS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoiniPermas' */
                           e30BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOELIMINADUP'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoEliminaDup' */
                           e31BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOGENERAAUXFALTANTES'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoGeneraAuxFaltantes' */
                           e32BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCORRIGEIMP'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoCorrigeImp' */
                           e33BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINISUELDOSLEGAJOS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoIniSueldosLegajos' */
                           e34BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOUSERACTION6'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoUserAction6' */
                           e35BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOUSERACTION7'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoUserAction7' */
                           e36BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOUSERACTION8'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoUserAction8' */
                           e37BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOUSERACTION9'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoUserAction9' */
                           e38BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOUSERACTION4'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoUserAction4' */
                           e39BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOUSERACTION3'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoUserAction3' */
                           e40BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOUSERACTION2CONCEPTOS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoUserAction2Conceptos' */
                           e41BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOUSERACTION2'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoUserAction2' */
                           e42BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOUSERACTION1'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoUserAction1' */
                           e43BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'BOTONPRUEBA'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'BotonPrueba' */
                           e44BL2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 19), "FREESTYLEGRID2.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "'BOTONPRUEBA'") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_63_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_63_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_63_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_632( ) ;
                           A1091TestError = httpContext.cgiGet( edtTestError_Internalname) ;
                           A1092TestNeto = localUtil.ctond( httpContext.cgiGet( edtTestNeto_Internalname)) ;
                           A1087TestDescripcion = httpContext.cgiGet( edtTestDescripcion_Internalname) ;
                           A1084TestOK = GXutil.strtobool( httpContext.cgiGet( chkTestOK.getInternalname())) ;
                           A1088TestSegLiq = (short)(localUtil.ctol( httpContext.cgiGet( edtTestSegLiq_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1090TestVueltas = (short)(localUtil.ctol( httpContext.cgiGet( edtTestVueltas_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1083TestNro = (short)(localUtil.ctol( httpContext.cgiGet( edtTestNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e45BL2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "FREESTYLEGRID2.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e46BL2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e47BL2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "'BOTONPRUEBA'") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: 'BotonPrueba' */
                                 e44BL2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    if ( ! Rfr0gs )
                                    {
                                    }
                                    dynload_actions( ) ;
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void weBL2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void paBL2( )
   {
      if ( nDonePA == 0 )
      {
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         init_web_controls( ) ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = edtavAuxcantmeses_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlvvimptliqcodBL2( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvimptliqcod_dataBL2( ) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvvimptliqcod_htmlBL2( )
   {
      String gxdynajaxvalue;
      gxdlvvimptliqcod_dataBL2( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavImptliqcod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavImptliqcod.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvimptliqcod_dataBL2( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H00BL2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( H00BL2_A32TLiqCod[0]));
         gxdynajaxctrldescr.add(H00BL2_A340TliqDesc[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxnrfreestylegrid2_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_632( ) ;
      while ( nGXsfl_63_idx <= nRC_GXsfl_63 )
      {
         sendrow_632( ) ;
         nGXsfl_63_idx = ((subFreestylegrid2_Islastpage==1)&&(nGXsfl_63_idx+1>subfreestylegrid2_fnc_recordsperpage( )) ? 1 : nGXsfl_63_idx+1) ;
         sGXsfl_63_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_63_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_632( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Freestylegrid2Container)) ;
      /* End function gxnrFreestylegrid2_newrow */
   }

   public void gxgrfreestylegrid2_refresh( String AV114impTLiqCod ,
                                           boolean AV44eliminarLiquidaciones ,
                                           boolean AV48correrRelacionada ,
                                           boolean AV68CorrerSoloPendientes ,
                                           boolean AV79JorVsMen ,
                                           boolean AV80CompensarPlus ,
                                           boolean AV115eliminarliquidacionesreplica ,
                                           int AV7CliCod ,
                                           short AV8EmpCod ,
                                           short AV12anio ,
                                           java.util.Date AV43date ,
                                           String AV128Pgmname ,
                                           String AV47bonoProdConCodigo ,
                                           String AV64ConCodigo ,
                                           java.util.Date AV125vaciaFecha ,
                                           java.math.BigDecimal AV96testImportes1 ,
                                           java.math.BigDecimal AV90testImportes2 ,
                                           java.math.BigDecimal AV93testImportes3 )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e47BL2 ();
      FREESTYLEGRID2_nCurrentRecord = 0 ;
      rfBL2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"Pruebas");
      forbiddenHiddens.add("testImportes1", localUtil.format( AV96testImportes1, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("testImportes2", localUtil.format( AV90testImportes2, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      forbiddenHiddens.add("testImportes3", localUtil.format( AV93testImportes3, "ZZ,ZZZ,ZZZ,ZZ9.99"));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("pruebas:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
      /* End function gxgrFreestylegrid2_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_TESTNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A1083TestNro), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "TESTNRO", GXutil.ltrim( localUtil.ntoc( A1083TestNro, (byte)(4), (byte)(0), ".", "")));
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         gxvvimptliqcod_htmlBL2( ) ;
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      AV44eliminarLiquidaciones = GXutil.strtobool( GXutil.booltostr( AV44eliminarLiquidaciones)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44eliminarLiquidaciones", AV44eliminarLiquidaciones);
      AV48correrRelacionada = GXutil.strtobool( GXutil.booltostr( AV48correrRelacionada)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48correrRelacionada", AV48correrRelacionada);
      AV68CorrerSoloPendientes = GXutil.strtobool( GXutil.booltostr( AV68CorrerSoloPendientes)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV68CorrerSoloPendientes", AV68CorrerSoloPendientes);
      AV79JorVsMen = GXutil.strtobool( GXutil.booltostr( AV79JorVsMen)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79JorVsMen", AV79JorVsMen);
      AV80CompensarPlus = GXutil.strtobool( GXutil.booltostr( AV80CompensarPlus)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV80CompensarPlus", AV80CompensarPlus);
      if ( dynavImptliqcod.getItemCount() > 0 )
      {
         AV114impTLiqCod = dynavImptliqcod.getValidValue(AV114impTLiqCod) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV114impTLiqCod", AV114impTLiqCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavImptliqcod.setValue( GXutil.rtrim( AV114impTLiqCod) );
         httpContext.ajax_rsp_assign_prop("", false, dynavImptliqcod.getInternalname(), "Values", dynavImptliqcod.ToJavascriptSource(), true);
      }
      AV115eliminarliquidacionesreplica = GXutil.strtobool( GXutil.booltostr( AV115eliminarliquidacionesreplica)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV115eliminarliquidacionesreplica", AV115eliminarliquidacionesreplica);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfBL2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV128Pgmname = "Pruebas" ;
      Gx_err = (short)(0) ;
      edtavTestimportes1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTestimportes1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTestimportes1_Enabled), 5, 0), true);
      edtavTestimportes1b_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTestimportes1b_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTestimportes1b_Enabled), 5, 0), true);
      edtavDiferencia1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDiferencia1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDiferencia1_Enabled), 5, 0), true);
      edtavTestimportes2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTestimportes2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTestimportes2_Enabled), 5, 0), true);
      edtavTestimportes2b_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTestimportes2b_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTestimportes2b_Enabled), 5, 0), true);
      edtavDiferencia2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDiferencia2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDiferencia2_Enabled), 5, 0), true);
      edtavTestimportes3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTestimportes3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTestimportes3_Enabled), 5, 0), true);
      edtavTestimportes3b_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTestimportes3b_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTestimportes3b_Enabled), 5, 0), true);
      edtavDiferencia3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDiferencia3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDiferencia3_Enabled), 5, 0), true);
   }

   public void rfBL2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Freestylegrid2Container.ClearRows();
      }
      wbStart = (short)(63) ;
      /* Execute user event: Refresh */
      e47BL2 ();
      nGXsfl_63_idx = 1 ;
      sGXsfl_63_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_63_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_632( ) ;
      bGXsfl_63_Refreshing = true ;
      Freestylegrid2Container.AddObjectProperty("GridName", "Freestylegrid2");
      Freestylegrid2Container.AddObjectProperty("CmpContext", "");
      Freestylegrid2Container.AddObjectProperty("InMasterPage", "false");
      Freestylegrid2Container.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      Freestylegrid2Container.AddObjectProperty("Class", "FreeStyleGrid");
      Freestylegrid2Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Freestylegrid2Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Freestylegrid2Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFreestylegrid2_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Freestylegrid2Container.setPageSize( subfreestylegrid2_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_632( ) ;
         /* Using cursor H00BL3 */
         pr_default.execute(1);
         while ( (pr_default.getStatus(1) != 101) )
         {
            A1086TestNombre = H00BL3_A1086TestNombre[0] ;
            A1083TestNro = H00BL3_A1083TestNro[0] ;
            A1090TestVueltas = H00BL3_A1090TestVueltas[0] ;
            A1088TestSegLiq = H00BL3_A1088TestSegLiq[0] ;
            A1084TestOK = H00BL3_A1084TestOK[0] ;
            A1087TestDescripcion = H00BL3_A1087TestDescripcion[0] ;
            A1092TestNeto = H00BL3_A1092TestNeto[0] ;
            A1091TestError = H00BL3_A1091TestError[0] ;
            e46BL2 ();
            pr_default.readNext(1);
         }
         pr_default.close(1);
         wbEnd = (short)(63) ;
         wbBL0( ) ;
      }
      bGXsfl_63_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesBL2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vANIO", GXutil.ltrim( localUtil.ntoc( AV12anio, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vANIO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV12anio), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vDATE", localUtil.dtoc( AV43date, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDATE", getSecureSignedToken( "", AV43date));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV128Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV128Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vBONOPRODCONCODIGO", GXutil.rtrim( AV47bonoProdConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vBONOPRODCONCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV47bonoProdConCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONCODIGO", GXutil.rtrim( AV64ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV64ConCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vVACIAFECHA", localUtil.dtoc( AV125vaciaFecha, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vVACIAFECHA", getSecureSignedToken( "", AV125vaciaFecha));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_TESTNRO"+"_"+sGXsfl_63_idx, getSecureSignedToken( sGXsfl_63_idx, localUtil.format( DecimalUtil.doubleToDec(A1083TestNro), "ZZZ9")));
   }

   public int subfreestylegrid2_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subfreestylegrid2_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subfreestylegrid2_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subfreestylegrid2_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      AV128Pgmname = "Pruebas" ;
      Gx_err = (short)(0) ;
      edtavTestimportes1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTestimportes1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTestimportes1_Enabled), 5, 0), true);
      edtavTestimportes1b_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTestimportes1b_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTestimportes1b_Enabled), 5, 0), true);
      edtavDiferencia1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDiferencia1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDiferencia1_Enabled), 5, 0), true);
      edtavTestimportes2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTestimportes2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTestimportes2_Enabled), 5, 0), true);
      edtavTestimportes2b_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTestimportes2b_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTestimportes2b_Enabled), 5, 0), true);
      edtavDiferencia2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDiferencia2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDiferencia2_Enabled), 5, 0), true);
      edtavTestimportes3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTestimportes3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTestimportes3_Enabled), 5, 0), true);
      edtavTestimportes3b_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTestimportes3b_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTestimportes3b_Enabled), 5, 0), true);
      edtavDiferencia3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDiferencia3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDiferencia3_Enabled), 5, 0), true);
      gxvvimptliqcod_htmlBL2( ) ;
      fix_multi_value_controls( ) ;
   }

   public void strupBL0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e45BL2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_63 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_63"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavAuxcantmeses_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavAuxcantmeses_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vAUXCANTMESES");
            GX_FocusControl = edtavAuxcantmeses_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV42auxCantMeses = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42auxCantMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42auxCantMeses), 4, 0));
         }
         else
         {
            AV42auxCantMeses = (short)(localUtil.ctol( httpContext.cgiGet( edtavAuxcantmeses_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV42auxCantMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42auxCantMeses), 4, 0));
         }
         AV44eliminarLiquidaciones = GXutil.strtobool( httpContext.cgiGet( chkavEliminarliquidaciones.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV44eliminarLiquidaciones", AV44eliminarLiquidaciones);
         AV48correrRelacionada = GXutil.strtobool( httpContext.cgiGet( chkavCorrerrelacionada.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48correrRelacionada", AV48correrRelacionada);
         AV66pararEnError = GXutil.strtobool( httpContext.cgiGet( edtavPararenerror_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV66pararEnError", AV66pararEnError);
         AV68CorrerSoloPendientes = GXutil.strtobool( httpContext.cgiGet( chkavCorrersolopendientes.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV68CorrerSoloPendientes", AV68CorrerSoloPendientes);
         AV79JorVsMen = GXutil.strtobool( httpContext.cgiGet( chkavJorvsmen.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV79JorVsMen", AV79JorVsMen);
         AV80CompensarPlus = GXutil.strtobool( httpContext.cgiGet( chkavCompensarplus.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV80CompensarPlus", AV80CompensarPlus);
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavSueldomensuales_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavSueldomensuales_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vSUELDOMENSUALES");
            GX_FocusControl = edtavSueldomensuales_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV100sueldoMensuales = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV100sueldoMensuales", GXutil.ltrimstr( AV100sueldoMensuales, 14, 2));
         }
         else
         {
            AV100sueldoMensuales = localUtil.ctond( httpContext.cgiGet( edtavSueldomensuales_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV100sueldoMensuales", GXutil.ltrimstr( AV100sueldoMensuales, 14, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavValorhorajor_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavValorhorajor_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vVALORHORAJOR");
            GX_FocusControl = edtavValorhorajor_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV101valorHoraJor = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV101valorHoraJor", GXutil.ltrimstr( AV101valorHoraJor, 14, 2));
         }
         else
         {
            AV101valorHoraJor = localUtil.ctond( httpContext.cgiGet( edtavValorhorajor_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV101valorHoraJor", GXutil.ltrimstr( AV101valorHoraJor, 14, 2));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavTestsuellegnumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavTestsuellegnumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTESTSUELLEGNUMERO");
            GX_FocusControl = edtavTestsuellegnumero_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV81testSuelLegNumero = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81testSuelLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV81testSuelLegNumero), 8, 0));
         }
         else
         {
            AV81testSuelLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtavTestsuellegnumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81testSuelLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV81testSuelLegNumero), 8, 0));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavTestimportes1_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavTestimportes1_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTESTIMPORTES1");
            GX_FocusControl = edtavTestimportes1_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV96testImportes1 = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV96testImportes1", GXutil.ltrimstr( AV96testImportes1, 14, 2));
         }
         else
         {
            AV96testImportes1 = localUtil.ctond( httpContext.cgiGet( edtavTestimportes1_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV96testImportes1", GXutil.ltrimstr( AV96testImportes1, 14, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavTestimportes1b_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavTestimportes1b_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTESTIMPORTES1B");
            GX_FocusControl = edtavTestimportes1b_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV97testImportes1B = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV97testImportes1B", GXutil.ltrimstr( AV97testImportes1B, 14, 2));
         }
         else
         {
            AV97testImportes1B = localUtil.ctond( httpContext.cgiGet( edtavTestimportes1b_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV97testImportes1B", GXutil.ltrimstr( AV97testImportes1B, 14, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavDiferencia1_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavDiferencia1_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vDIFERENCIA1");
            GX_FocusControl = edtavDiferencia1_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV98diferencia1 = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV98diferencia1", GXutil.ltrimstr( AV98diferencia1, 14, 2));
         }
         else
         {
            AV98diferencia1 = localUtil.ctond( httpContext.cgiGet( edtavDiferencia1_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV98diferencia1", GXutil.ltrimstr( AV98diferencia1, 14, 2));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavTestsuellegnumero2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavTestsuellegnumero2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTESTSUELLEGNUMERO2");
            GX_FocusControl = edtavTestsuellegnumero2_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV84testSuelLegNumero2 = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV84testSuelLegNumero2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV84testSuelLegNumero2), 8, 0));
         }
         else
         {
            AV84testSuelLegNumero2 = (int)(localUtil.ctol( httpContext.cgiGet( edtavTestsuellegnumero2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV84testSuelLegNumero2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV84testSuelLegNumero2), 8, 0));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavTestimportes2_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavTestimportes2_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTESTIMPORTES2");
            GX_FocusControl = edtavTestimportes2_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV90testImportes2 = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV90testImportes2", GXutil.ltrimstr( AV90testImportes2, 14, 2));
         }
         else
         {
            AV90testImportes2 = localUtil.ctond( httpContext.cgiGet( edtavTestimportes2_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV90testImportes2", GXutil.ltrimstr( AV90testImportes2, 14, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavTestimportes2b_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavTestimportes2b_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTESTIMPORTES2B");
            GX_FocusControl = edtavTestimportes2b_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV91testImportes2B = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV91testImportes2B", GXutil.ltrimstr( AV91testImportes2B, 14, 2));
         }
         else
         {
            AV91testImportes2B = localUtil.ctond( httpContext.cgiGet( edtavTestimportes2b_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV91testImportes2B", GXutil.ltrimstr( AV91testImportes2B, 14, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavDiferencia2_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavDiferencia2_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vDIFERENCIA2");
            GX_FocusControl = edtavDiferencia2_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV92diferencia2 = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV92diferencia2", GXutil.ltrimstr( AV92diferencia2, 14, 2));
         }
         else
         {
            AV92diferencia2 = localUtil.ctond( httpContext.cgiGet( edtavDiferencia2_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV92diferencia2", GXutil.ltrimstr( AV92diferencia2, 14, 2));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavTestsuellegnumero3_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavTestsuellegnumero3_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTESTSUELLEGNUMERO3");
            GX_FocusControl = edtavTestsuellegnumero3_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV86testSuelLegNumero3 = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV86testSuelLegNumero3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV86testSuelLegNumero3), 8, 0));
         }
         else
         {
            AV86testSuelLegNumero3 = (int)(localUtil.ctol( httpContext.cgiGet( edtavTestsuellegnumero3_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV86testSuelLegNumero3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV86testSuelLegNumero3), 8, 0));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavTestimportes3_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavTestimportes3_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTESTIMPORTES3");
            GX_FocusControl = edtavTestimportes3_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV93testImportes3 = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV93testImportes3", GXutil.ltrimstr( AV93testImportes3, 14, 2));
         }
         else
         {
            AV93testImportes3 = localUtil.ctond( httpContext.cgiGet( edtavTestimportes3_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV93testImportes3", GXutil.ltrimstr( AV93testImportes3, 14, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavTestimportes3b_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavTestimportes3b_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTESTIMPORTES3B");
            GX_FocusControl = edtavTestimportes3b_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV94testImportes3B = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV94testImportes3B", GXutil.ltrimstr( AV94testImportes3B, 14, 2));
         }
         else
         {
            AV94testImportes3B = localUtil.ctond( httpContext.cgiGet( edtavTestimportes3b_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV94testImportes3B", GXutil.ltrimstr( AV94testImportes3B, 14, 2));
         }
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavDiferencia3_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavDiferencia3_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vDIFERENCIA3");
            GX_FocusControl = edtavDiferencia3_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV95diferencia3 = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV95diferencia3", GXutil.ltrimstr( AV95diferencia3, 14, 2));
         }
         else
         {
            AV95diferencia3 = localUtil.ctond( httpContext.cgiGet( edtavDiferencia3_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV95diferencia3", GXutil.ltrimstr( AV95diferencia3, 14, 2));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavTestsuellegnumero4_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavTestsuellegnumero4_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTESTSUELLEGNUMERO4");
            GX_FocusControl = edtavTestsuellegnumero4_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV99testSuelLegNumero4 = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV99testSuelLegNumero4", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV99testSuelLegNumero4), 8, 0));
         }
         else
         {
            AV99testSuelLegNumero4 = (int)(localUtil.ctol( httpContext.cgiGet( edtavTestsuellegnumero4_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV99testSuelLegNumero4", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV99testSuelLegNumero4), 8, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavMultilegnumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavMultilegnumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vMULTILEGNUMERO");
            GX_FocusControl = edtavMultilegnumero_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV102multiLegNumero = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV102multiLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV102multiLegNumero), 8, 0));
         }
         else
         {
            AV102multiLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtavMultilegnumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV102multiLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV102multiLegNumero), 8, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavMulticant_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavMulticant_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vMULTICANT");
            GX_FocusControl = edtavMulticant_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV103multiCant = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV103multiCant", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV103multiCant), 4, 0));
         }
         else
         {
            AV103multiCant = (short)(localUtil.ctol( httpContext.cgiGet( edtavMulticant_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV103multiCant", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV103multiCant), 4, 0));
         }
         AV109SVGValor = httpContext.cgiGet( edtavSvgvalor_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV109SVGValor", AV109SVGValor);
         AV111expresion = httpContext.cgiGet( edtavExpresion_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV111expresion", AV111expresion);
         AV110palabraAAAAMM = httpContext.cgiGet( edtavPalabraaaaamm_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV110palabraAAAAMM", AV110palabraAAAAMM);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavMesnro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavMesnro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vMESNRO");
            GX_FocusControl = edtavMesnro_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV124mesNro = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV124mesNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV124mesNro), 4, 0));
         }
         else
         {
            AV124mesNro = (short)(localUtil.ctol( httpContext.cgiGet( edtavMesnro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV124mesNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV124mesNro), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavOtraempcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavOtraempcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vOTRAEMPCOD");
            GX_FocusControl = edtavOtraempcod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV112otraEmpCod = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV112otraEmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV112otraEmpCod), 4, 0));
         }
         else
         {
            AV112otraEmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtavOtraempcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV112otraEmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV112otraEmpCod), 4, 0));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavImpliqperiodo_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vIMPLIQPERIODO");
            GX_FocusControl = edtavImpliqperiodo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV113impLiqPeriodo = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV113impLiqPeriodo", localUtil.format(AV113impLiqPeriodo, "99/99/9999"));
         }
         else
         {
            AV113impLiqPeriodo = localUtil.ctod( httpContext.cgiGet( edtavImpliqperiodo_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV113impLiqPeriodo", localUtil.format(AV113impLiqPeriodo, "99/99/9999"));
         }
         dynavImptliqcod.setName( dynavImptliqcod.getInternalname() );
         dynavImptliqcod.setValue( httpContext.cgiGet( dynavImptliqcod.getInternalname()) );
         AV114impTLiqCod = httpContext.cgiGet( dynavImptliqcod.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV114impTLiqCod", AV114impTLiqCod);
         AV115eliminarliquidacionesreplica = GXutil.strtobool( httpContext.cgiGet( chkavEliminarliquidacionesreplica.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV115eliminarliquidacionesreplica", AV115eliminarliquidacionesreplica);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavDliqperiodo_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vDLIQPERIODO");
            GX_FocusControl = edtavDliqperiodo_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV123DLiqPeriodo = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV123DLiqPeriodo", localUtil.format(AV123DLiqPeriodo, "99/99/99"));
         }
         else
         {
            AV123DLiqPeriodo = localUtil.ctod( httpContext.cgiGet( edtavDliqperiodo_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV123DLiqPeriodo", localUtil.format(AV123DLiqPeriodo, "99/99/99"));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", "hsh"+"Pruebas");
         AV96testImportes1 = localUtil.ctond( httpContext.cgiGet( edtavTestimportes1_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV96testImportes1", GXutil.ltrimstr( AV96testImportes1, 14, 2));
         forbiddenHiddens.add("testImportes1", localUtil.format( AV96testImportes1, "ZZ,ZZZ,ZZZ,ZZ9.99"));
         AV90testImportes2 = localUtil.ctond( httpContext.cgiGet( edtavTestimportes2_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV90testImportes2", GXutil.ltrimstr( AV90testImportes2, 14, 2));
         forbiddenHiddens.add("testImportes2", localUtil.format( AV90testImportes2, "ZZ,ZZZ,ZZZ,ZZ9.99"));
         AV93testImportes3 = localUtil.ctond( httpContext.cgiGet( edtavTestimportes3_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV93testImportes3", GXutil.ltrimstr( AV93testImportes3, 14, 2));
         forbiddenHiddens.add("testImportes3", localUtil.format( AV93testImportes3, "ZZ,ZZZ,ZZZ,ZZ9.99"));
         hsh = httpContext.cgiGet( "hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("pruebas:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
            GxWebError = (byte)(1) ;
            httpContext.sendError( 403 );
            GXutil.writeLog("send_http_error_code 403");
            return  ;
         }
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e45BL2 ();
      if (returnInSub) return;
   }

   public void e45BL2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV124mesNro = (short)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV124mesNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV124mesNro), 4, 0));
      AV115eliminarliquidacionesreplica = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV115eliminarliquidacionesreplica", AV115eliminarliquidacionesreplica);
      AV113impLiqPeriodo = localUtil.ymdtod( 2024, 1, 1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV113impLiqPeriodo", localUtil.format(AV113impLiqPeriodo, "99/99/9999"));
      AV112otraEmpCod = (short)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV112otraEmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV112otraEmpCod), 4, 0));
      AV114impTLiqCod = httpContext.getMessage( "MENSUAL", "") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV114impTLiqCod", AV114impTLiqCod);
      AV100sueldoMensuales = DecimalUtil.doubleToDec(1000000) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV100sueldoMensuales", GXutil.ltrimstr( AV100sueldoMensuales, 14, 2));
      AV101valorHoraJor = DecimalUtil.doubleToDec(5000) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV101valorHoraJor", GXutil.ltrimstr( AV101valorHoraJor, 14, 2));
      AV96testImportes1 = DecimalUtil.stringToDec("3984052.74") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV96testImportes1", GXutil.ltrimstr( AV96testImportes1, 14, 2));
      AV90testImportes2 = DecimalUtil.stringToDec("2614060.77") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV90testImportes2", GXutil.ltrimstr( AV90testImportes2, 14, 2));
      AV93testImportes3 = DecimalUtil.stringToDec("4478510.50") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV93testImportes3", GXutil.ltrimstr( AV93testImportes3, 14, 2));
      GXt_int1 = AV8EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      pruebas_impl.this.GXt_int1 = GXv_int2[0] ;
      AV8EmpCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      GXt_int3 = AV7CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      pruebas_impl.this.GXt_int3 = GXv_int4[0] ;
      AV7CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      edtTestNro_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTestNro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTestNro_Visible), 5, 0), !bGXsfl_63_Refreshing);
      GXv_int4[0] = AV81testSuelLegNumero ;
      GXv_char5[0] = "" ;
      new web.getlegnumeroynomidporcuil(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, 20311763823L, GXv_int4, GXv_char5) ;
      pruebas_impl.this.AV81testSuelLegNumero = GXv_int4[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV81testSuelLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV81testSuelLegNumero), 8, 0));
      GXv_int4[0] = AV84testSuelLegNumero2 ;
      GXv_char5[0] = "" ;
      new web.getlegnumeroynomidporcuil(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, 20428306105L, GXv_int4, GXv_char5) ;
      pruebas_impl.this.AV84testSuelLegNumero2 = GXv_int4[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV84testSuelLegNumero2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV84testSuelLegNumero2), 8, 0));
      GXv_int4[0] = AV86testSuelLegNumero3 ;
      GXv_char5[0] = "" ;
      new web.getlegnumeroynomidporcuil(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, 20143326250L, GXv_int4, GXv_char5) ;
      pruebas_impl.this.AV86testSuelLegNumero3 = GXv_int4[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV86testSuelLegNumero3", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV86testSuelLegNumero3), 8, 0));
      AV48correrRelacionada = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48correrRelacionada", AV48correrRelacionada);
      AV44eliminarLiquidaciones = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44eliminarLiquidaciones", AV44eliminarLiquidaciones);
      AV12anio = (short)(2023) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12anio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12anio), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vANIO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV12anio), "ZZZ9")));
      AV42auxCantMeses = (short)(12) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42auxCantMeses", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV42auxCantMeses), 4, 0));
      AV66pararEnError = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66pararEnError", AV66pararEnError);
      GXv_char5[0] = AV47bonoProdConCodigo ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "BONO POR PRODUCTIVIDAD", ""), GXv_char5) ;
      pruebas_impl.this.AV47bonoProdConCodigo = GXv_char5[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47bonoProdConCodigo", AV47bonoProdConCodigo);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vBONOPRODCONCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV47bonoProdConCodigo, ""))));
      AV68CorrerSoloPendientes = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV68CorrerSoloPendientes", AV68CorrerSoloPendientes);
      lblTestsvg_Caption = httpContext.getMessage( "<svg width=\"30\" height=\"26.44\" viewBox=\"0 0 27 25\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\"><g clip-path=\"url(#clip0_775_1393)\"><path d=\"M20.9849 1.59473H5.74294C4.19494 1.59473 3.18278 2.45266 2.88508 4.04596L0.979839 13.3606V20.2241C0.982038 21.0035 1.28384 21.7504 1.81932 22.3015C2.35479 22.8527 3.08043 23.1633 3.8377 23.1656H22.8901C23.6474 23.1633 24.373 22.8527 24.9085 22.3015C25.444 21.7504 25.7458 21.0035 25.748 20.2241V13.3606L23.8427 4.04596C23.5451 2.39138 22.4734 1.59473 20.9849 1.59473Z\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.8\" stroke-linejoin=\"round\"/><path d=\"M0.979839 13.4376H9.55343C9.55343 14.5032 9.95489 15.5252 10.6695 16.2788C11.3841 17.0323 12.3533 17.4557 13.3639 17.4557C14.3745 17.4557 15.3437 17.0323 16.0583 16.2788C16.7729 15.5252 17.1744 14.5032 17.1744 13.4376H25.748M6.69557 5.40137H20.0323M5.74294 9.41947H20.9849\" stroke=\"var(--colors_gray08)\" stroke-width=\"1.8\" stroke-linecap=\"round\" stroke-linejoin=\"round\"/></g><defs><clipPath id=\"clip0_775_1393\"><rect width=\"27\" height=\"24.2541\" fill=\"white\" transform=\"translate(0 0.214355)\"/></clipPath></defs></svg>", "") ;
      httpContext.ajax_rsp_assign_prop("", false, lblTestsvg_Internalname, "Caption", lblTestsvg_Caption, true);
   }

   private void e46BL2( )
   {
      /* Freestylegrid2_Load Routine */
      returnInSub = false ;
      bttBotonprueba_Caption = GXutil.trim( A1086TestNombre) ;
      httpContext.ajax_rsp_assign_prop("", false, bttBotonprueba_Internalname, "Caption", bttBotonprueba_Caption, !bGXsfl_63_Refreshing);
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(63) ;
      }
      sendrow_632( ) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_63_Refreshing )
      {
         httpContext.doAjaxLoad(63, Freestylegrid2Row);
      }
      /*  Sending Event outputs  */
   }

   public void e15BL2( )
   {
      /* 'DoIni' Routine */
      returnInSub = false ;
      new web.initests(remoteHandle, context).execute( ) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
   }

   public void e16BL2( )
   {
      /* 'DoProbarTodos' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'DEFAULTS' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'RESETEAR' */
      S122 ();
      if (returnInSub) return;
      AV63TestOK = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63TestOK", AV63TestOK);
      /* Execute user subroutine: 'PRUEBA 1 CONJUNTA' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'RESETEAR' */
      S122 ();
      if (returnInSub) return;
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 3 CONJUNTA' */
         S142 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 5 CONJUNTA' */
         S152 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( AV79JorVsMen )
      {
         /* Execute user subroutine: 'PRUEBA 6 CONJUNTA' */
         S162 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( AV79JorVsMen )
      {
         /* Execute user subroutine: 'PRUEBA 7 CONJUNTA' */
         S172 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 9 CONJUNTA' */
         S182 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 10 CONJUNTA' */
         S192 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 12 CONJUNTA' */
         S202 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 13 CONJUNTA' */
         S212 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 14 CONJUNTA' */
         S222 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 15 CONJUNTA' */
         S232 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 16 CONJUNTA' */
         S242 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 17 CONJUNTA' */
         S252 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 18 CONJUNTA' */
         S262 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 19 CONJUNTA' */
         S272 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 20 CONJUNTA' */
         S282 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 22 CONJUNTA' */
         S292 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 24 CONJUNTA' */
         S302 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 26 CONJUNTA' */
         S312 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) && ( AV81testSuelLegNumero == 1000000 ) )
      {
         /* Execute user subroutine: 'PRUEBA 28 CONJUNTA' */
         S322 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) && ( AV81testSuelLegNumero == 1000000 ) )
      {
         /* Execute user subroutine: 'PRUEBA 29 CONJUNTA' */
         S332 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 31 CONJUNTA' */
         S342 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 32 CONJUNTA' */
         S352 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 33 CONJUNTA' */
         S362 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 34 CONJUNTA' */
         S372 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 35 CONJUNTA' */
         S382 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 36 CONJUNTA' */
         S392 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 37 CONJUNTA' */
         S402 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 38 CONJUNTA' */
         S412 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 39 CONJUNTA' */
         S422 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 40 CONJUNTA' */
         S432 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 41 CONJUNTA' */
         S442 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 42 CONJUNTA' */
         S452 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      if ( ! AV66pararEnError || ( AV63TestOK ) )
      {
         /* Execute user subroutine: 'PRUEBA 43 CONJUNTA' */
         S462 ();
         if (returnInSub) return;
         /* Execute user subroutine: 'RESETEAR' */
         S122 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV49TestNro", AV49TestNro);
   }

   public void e17BL2( )
   {
      /* 'DoIniApl' Routine */
      returnInSub = false ;
      new web.ini_conceptos_apliigg(remoteHandle, context).execute( 1) ;
   }

   public void e18BL2( )
   {
      /* 'DoCorregirCorhetesconcpeot' Routine */
      returnInSub = false ;
      new web.corregircorchetesconceptos(remoteHandle, context).execute( AV7CliCod) ;
   }

   public void e19BL2( )
   {
      /* 'Doactualizartopes' Routine */
      returnInSub = false ;
      new web.calcular_tope_default(remoteHandle, context).execute( AV7CliCod) ;
   }

   public void e20BL2( )
   {
      /* 'DoCrearFulanos' Routine */
      returnInSub = false ;
      new web.crearlegajofulanos(remoteHandle, context).execute( AV7CliCod, AV8EmpCod) ;
   }

   public void e21BL2( )
   {
      /* 'DoduplicarLegajo' Routine */
      returnInSub = false ;
      new web.duplicarlegajo(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV102multiLegNumero, AV103multiCant) ;
   }

   public void e22BL2( )
   {
      /* 'DofixEscalasNoviembre' Routine */
      returnInSub = false ;
      new web.fix_escalas_noviembre(remoteHandle, context).execute( ) ;
   }

   public void e23BL2( )
   {
      /* 'Doregex' Routine */
      returnInSub = false ;
      if ( ! GxRegex.IsMatch(GXutil.trim( AV111expresion),GXutil.trim( AV110palabraAAAAMM)) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "MAL", ""));
      }
      else
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "BIEN", ""));
      }
   }

   public void e24BL2( )
   {
      /* 'DoImportarTodosProa' Routine */
      returnInSub = false ;
      new web.importartodoslsd_test2(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, (short)(99), httpContext.getMessage( "LEGAJOS", ""), (short)(0)) ;
   }

   public void e25BL2( )
   {
      /* 'DoImportarTodoslsdProa' Routine */
      returnInSub = false ;
      new web.importartodoslsd_test2(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, (short)(1), httpContext.getMessage( "LIQUIDACIONES", ""), AV124mesNro) ;
   }

   public void e26BL2( )
   {
      /* 'DoReplicarimportadas' Routine */
      returnInSub = false ;
      if ( AV8EmpCod == AV112otraEmpCod )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "error misma empresa", ""));
      }
      else
      {
         new web.replicarimportadastest(remoteHandle, context).execute( AV7CliCod, AV112otraEmpCod, AV8EmpCod, AV113impLiqPeriodo, AV114impTLiqCod, AV115eliminarliquidacionesreplica) ;
      }
   }

   public void e27BL2( )
   {
      /* 'DoCalcContr' Routine */
      returnInSub = false ;
      new web.liqsumarcontribuciones(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, 1) ;
   }

   public void e28BL2( )
   {
      /* 'DoIniMenuUsu' Routine */
      returnInSub = false ;
      new web.inimenuitemsusuario(remoteHandle, context).execute( ) ;
      new web.inimenuusuario(remoteHandle, context).execute( (byte)(1)) ;
      new web.inimenuusuario(remoteHandle, context).execute( (byte)(2)) ;
      new web.ini_rest_locations(remoteHandle, context).execute( AV7CliCod) ;
   }

   public void e29BL2( )
   {
      /* 'DodeleteCuentas' Routine */
      returnInSub = false ;
      new web.deletecclicenciastodas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, 0, "Vacaciones", (short)(0)) ;
   }

   public void e30BL2( )
   {
      /* 'DoiniPermas' Routine */
      returnInSub = false ;
      new web.inipermanencias(remoteHandle, context).execute( AV7CliCod, AV8EmpCod) ;
   }

   public void e31BL2( )
   {
      /* 'DoEliminaDup' Routine */
      returnInSub = false ;
      new web.eliminarliqsimpdup(remoteHandle, context).execute( AV7CliCod, AV8EmpCod) ;
   }

   public void e32BL2( )
   {
      /* 'DoGeneraAuxFaltantes' Routine */
      returnInSub = false ;
      new web.generarconcauxfaltantes(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV123DLiqPeriodo) ;
   }

   public void e33BL2( )
   {
      /* 'DoCorrigeImp' Routine */
      returnInSub = false ;
      new web.corrigeliqimportadas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod) ;
   }

   public void e34BL2( )
   {
      /* 'DoIniSueldosLegajos' Routine */
      returnInSub = false ;
      new web.inicializarsueldoconceptos(remoteHandle, context).execute( AV7CliCod, AV125vaciaFecha, AV125vaciaFecha) ;
   }

   public void e35BL2( )
   {
      /* 'DoUserAction6' Routine */
      returnInSub = false ;
      new web.inipermisos(remoteHandle, context).execute( ) ;
   }

   public void e36BL2( )
   {
      /* 'DoUserAction7' Routine */
      returnInSub = false ;
      new web.initliqdescaux(remoteHandle, context).execute( ) ;
   }

   public void e37BL2( )
   {
      /* 'DoUserAction8' Routine */
      returnInSub = false ;
      new web.inicializarlegsuelvto(remoteHandle, context).execute( ) ;
   }

   public void e38BL2( )
   {
      /* 'DoUserAction9' Routine */
      returnInSub = false ;
      GXv_char5[0] = "" ;
      GXv_char6[0] = "" ;
      new web.createhashforpsw(remoteHandle, context).execute( httpContext.getMessage( "hola mundo", ""), "", GXv_char5, GXv_char6) ;
   }

   public void e39BL2( )
   {
      /* 'DoUserAction4' Routine */
      returnInSub = false ;
      new web.cambiarbasecalculopres(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "REM009", ""), (byte)(0)) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV99testSuelLegNumero4, localUtil.ymdtod( 2023, 1, 3), localUtil.ymdtod( 2023, 1, 7), new web.codigodesituacionenfermedad(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Licencia por enfermedad", ""), httpContext.getMessage( "Licencia por enfermedad", ""), false) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV99testSuelLegNumero4, localUtil.ymdtod( 2023, 1, 19), localUtil.ymdtod( 2023, 1, 31), new web.codigodesituacioniltempresa(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "ILT primeros 10 días", ""), httpContext.getMessage( "ILT primeros 10 días", ""), false) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV99testSuelLegNumero4, localUtil.ymdtod( 2023, 2, 1), localUtil.ymdtod( 2023, 2, 1), new web.codigodesituacioniltempresa(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "ILT primeros 10 días", ""), httpContext.getMessage( "ILT primeros 10 días", ""), false) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV99testSuelLegNumero4, localUtil.ymdtod( 2023, 2, 2), localUtil.ymdtod( 2023, 4, 5), new web.codigodesituacioniltart(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "ILT días 11 y siguientes", ""), httpContext.getMessage( "ILT días 11 y siguientes", ""), false) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV99testSuelLegNumero4, localUtil.ymdtod( 2023, 4, 17), localUtil.ymdtod( 2023, 4, 26), new web.codigodesituacionenfermedad(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Licencia por enfermedad", ""), httpContext.getMessage( "Licencia por enfermedad", ""), false) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV99testSuelLegNumero4, localUtil.ymdtod( 2023, 5, 2), localUtil.ymdtod( 2023, 5, 5), new web.codigodesituacionenfermedad(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Licencia por enfermedad", ""), httpContext.getMessage( "Licencia por enfermedad", ""), false) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV99testSuelLegNumero4, localUtil.ymdtod( 2023, 5, 17), localUtil.ymdtod( 2023, 5, 22), new web.codigodesituacioniltart(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "ILT días 11 y siguientes", ""), httpContext.getMessage( "ILT días 11 y siguientes", ""), false) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV99testSuelLegNumero4, localUtil.ymdtod( 2023, 7, 17), localUtil.ymdtod( 2023, 7, 18), new web.codigodesituacionenfermedad(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Licencia por enfermedad", ""), httpContext.getMessage( "Licencia por enfermedad", ""), false) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV99testSuelLegNumero4, localUtil.ymdtod( 2023, 8, 17), localUtil.ymdtod( 2023, 8, 18), new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV99testSuelLegNumero4, localUtil.ymdtod( 2023, 8, 17), localUtil.ymdtod( 2023, 8, 18), new web.codigodesituacionenfermedad(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Licencia por enfermedad", ""), httpContext.getMessage( "Licencia por enfermedad", ""), false) ;
      GXv_int2[0] = (short)(11) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV99testSuelLegNumero4, (short)(2022), (short)(2), (byte)(1), GXv_int2, false) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV99testSuelLegNumero4, AV12anio, (short)(9), (byte)(1), GXv_int2, false) ;
      new web.cambiarbasecalculopres(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "REM009", ""), (byte)(2)) ;
   }

   public void e40BL2( )
   {
      /* 'DoUserAction3' Routine */
      returnInSub = false ;
      GXv_int2[0] = AV85paicod ;
      new web.clientegetpais(remoteHandle, context).execute( AV7CliCod, GXv_int2) ;
      pruebas_impl.this.AV85paicod = GXv_int2[0] ;
      GXv_int4[0] = AV87convenioCliCod ;
      new web.getversiondeconvenio(remoteHandle, context).execute( AV7CliCod, AV85paicod, new web.conveniouecara(remoteHandle, context).executeUdp( ), GXv_int4) ;
      pruebas_impl.this.AV87convenioCliCod = GXv_int4[0] ;
      new web.uecaraanalistaadm2022(remoteHandle, context).execute( AV87convenioCliCod, AV85paicod) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV86testSuelLegNumero3, localUtil.ymdtod( 2023, 3, 2), localUtil.ymdtod( 2023, 3, 8), new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV86testSuelLegNumero3, localUtil.ymdtod( 2023, 4, 2), localUtil.ymdtod( 2023, 4, 2), new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV86testSuelLegNumero3, localUtil.ymdtod( 2023, 5, 2), localUtil.ymdtod( 2023, 5, 3), new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV86testSuelLegNumero3, localUtil.ymdtod( 2023, 6, 2), localUtil.ymdtod( 2023, 6, 8), new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV86testSuelLegNumero3, localUtil.ymdtod( 2023, 8, 2), localUtil.ymdtod( 2023, 8, 3), new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      GXv_int2[0] = (short)(9) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV86testSuelLegNumero3, (short)(2022), (short)(4), (byte)(0), GXv_int2, false) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV86testSuelLegNumero3, AV12anio, (short)(12), (byte)(0), GXv_int2, false) ;
      GXv_decimal7[0] = AV94testImportes3B ;
      new web.testsumatodo(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV86testSuelLegNumero3, GXv_decimal7) ;
      pruebas_impl.this.AV94testImportes3B = GXv_decimal7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV94testImportes3B", GXutil.ltrimstr( AV94testImportes3B, 14, 2));
      AV95diferencia3 = AV93testImportes3.subtract(AV94testImportes3B) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV95diferencia3", GXutil.ltrimstr( AV95diferencia3, 14, 2));
      /*  Sending Event outputs  */
   }

   public void e41BL2( )
   {
      /* 'DoUserAction2Conceptos' Routine */
      returnInSub = false ;
      new web.crearconceptosauxiliares(remoteHandle, context).execute( AV7CliCod, false, true) ;
   }

   public void e42BL2( )
   {
      /* 'DoUserAction2' Routine */
      returnInSub = false ;
      new web.cambiarbasecalculopres(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "REM009", ""), (byte)(0)) ;
      GXv_int2[0] = AV85paicod ;
      new web.clientegetpais(remoteHandle, context).execute( AV7CliCod, GXv_int2) ;
      pruebas_impl.this.AV85paicod = GXv_int2[0] ;
      new web.actualizarconvenioycatlegajo(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV84testSuelLegNumero2, AV85paicod, new web.conveniouocra(remoteHandle, context).executeUdp( ), httpContext.getMessage( "MEDIO_OFI_A", "")) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV84testSuelLegNumero2, localUtil.ymdtod( 2023, 5, 2), localUtil.ymdtod( 2023, 5, 3), new web.codigodesituacionenfermedad(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Licencia por enfermedad", ""), httpContext.getMessage( "Licencia por enfermedad", ""), false) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV84testSuelLegNumero2, localUtil.ymdtod( 2023, 8, 17), localUtil.ymdtod( 2023, 8, 17), new web.codigodesituacionenfermedad(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Licencia por enfermedad", ""), httpContext.getMessage( "Licencia por enfermedad", ""), false) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV128Pgmname, httpContext.getMessage( "asdf", "")) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV84testSuelLegNumero2, AV12anio, (short)(9), (byte)(1), GXv_int2, false) ;
      new web.cambiarbasecalculopres(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "REM009", ""), (byte)(2)) ;
      GXv_int2[0] = (short)(10) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV84testSuelLegNumero2, AV12anio, (short)(1), (byte)(1), GXv_int2, false) ;
      GXv_decimal7[0] = AV91testImportes2B ;
      new web.testsumatodo(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV84testSuelLegNumero2, GXv_decimal7) ;
      pruebas_impl.this.AV91testImportes2B = GXv_decimal7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV91testImportes2B", GXutil.ltrimstr( AV91testImportes2B, 14, 2));
      AV92diferencia2 = AV90testImportes2.subtract(AV91testImportes2B) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV92diferencia2", GXutil.ltrimstr( AV92diferencia2, 14, 2));
      /*  Sending Event outputs  */
   }

   public void e43BL2( )
   {
      /* 'DoUserAction1' Routine */
      returnInSub = false ;
      AV82LegSuelFecha.clear();
      AV83LegSuelImporte.clear();
      AV82LegSuelFecha.add(localUtil.ymdtod( 2023, 1, 1), 0);
      AV83LegSuelImporte.add(DecimalUtil.stringToDec("240963.86"), 0);
      AV82LegSuelFecha.add(localUtil.ymdtod( 2023, 4, 1), 0);
      AV83LegSuelImporte.add(DecimalUtil.stringToDec("289156.63"), 0);
      AV82LegSuelFecha.add(localUtil.ymdtod( 2023, 7, 1), 0);
      AV83LegSuelImporte.add(DecimalUtil.stringToDec("375903.62"), 0);
      AV82LegSuelFecha.add(localUtil.ymdtod( 2023, 10, 1), 0);
      AV83LegSuelImporte.add(DecimalUtil.stringToDec("526265.06"), 0);
      new web.test_sueldos_1(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV81testSuelLegNumero, AV82LegSuelFecha, AV83LegSuelImporte) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV81testSuelLegNumero, localUtil.ymdtod( 2023, 1, 2), localUtil.ymdtod( 2023, 1, 2), new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV81testSuelLegNumero, localUtil.ymdtod( 2023, 2, 1), localUtil.ymdtod( 2023, 2, 6), new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV81testSuelLegNumero, localUtil.ymdtod( 2023, 7, 1), localUtil.ymdtod( 2023, 7, 1), new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV81testSuelLegNumero, localUtil.ymdtod( 2023, 9, 1), localUtil.ymdtod( 2023, 9, 1), new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV81testSuelLegNumero, AV12anio, (short)(11), (byte)(0), GXv_int2, false) ;
      GXv_decimal7[0] = AV97testImportes1B ;
      new web.testsumatodo(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV81testSuelLegNumero, GXv_decimal7) ;
      pruebas_impl.this.AV97testImportes1B = GXv_decimal7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV97testImportes1B", GXutil.ltrimstr( AV97testImportes1B, 14, 2));
      AV98diferencia1 = AV96testImportes1.subtract(AV97testImportes1B) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV98diferencia1", GXutil.ltrimstr( AV98diferencia1, 14, 2));
      /*  Sending Event outputs  */
   }

   public void e47BL2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV8EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      pruebas_impl.this.GXt_int1 = GXv_int2[0] ;
      AV8EmpCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      GXt_int3 = AV7CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      pruebas_impl.this.GXt_int3 = GXv_int4[0] ;
      AV7CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      /*  Sending Event outputs  */
   }

   public void e44BL2( )
   {
      /* 'BotonPrueba' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'DEFAULTS' */
      S112 ();
      if (returnInSub) return;
      if ( AV44eliminarLiquidaciones )
      {
         new web.eliminaliquidacion(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, 0) ;
      }
      if ( A1083TestNro == 1 )
      {
         /* Execute user subroutine: 'PRUEBA 1 CONJUNTA' */
         S132 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 2 )
      {
         /* Execute user subroutine: 'PRUEBA 2 CONJUNTA' */
         S472 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 3 )
      {
         /* Execute user subroutine: 'PRUEBA 3 CONJUNTA' */
         S142 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 4 )
      {
         /* Execute user subroutine: 'PRUEBA 4 CONJUNTA' */
         S482 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 5 )
      {
         /* Execute user subroutine: 'PRUEBA 5 CONJUNTA' */
         S152 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 6 )
      {
         /* Execute user subroutine: 'PRUEBA 6 CONJUNTA' */
         S162 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 7 )
      {
         /* Execute user subroutine: 'PRUEBA 7 CONJUNTA' */
         S172 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 8 )
      {
         /* Execute user subroutine: 'PRUEBA 8 CONJUNTA' */
         S492 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 9 )
      {
         /* Execute user subroutine: 'PRUEBA 9 CONJUNTA' */
         S182 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 10 )
      {
         /* Execute user subroutine: 'PRUEBA 10 CONJUNTA' */
         S192 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 11 )
      {
         /* Execute user subroutine: 'PRUEBA 11 CONJUNTA' */
         S502 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 12 )
      {
         /* Execute user subroutine: 'PRUEBA 12 CONJUNTA' */
         S202 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 13 )
      {
         /* Execute user subroutine: 'PRUEBA 13 CONJUNTA' */
         S212 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 14 )
      {
         /* Execute user subroutine: 'PRUEBA 14 CONJUNTA' */
         S222 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 15 )
      {
         /* Execute user subroutine: 'PRUEBA 15 CONJUNTA' */
         S232 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 16 )
      {
         /* Execute user subroutine: 'PRUEBA 16 CONJUNTA' */
         S242 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 17 )
      {
         /* Execute user subroutine: 'PRUEBA 17 CONJUNTA' */
         S252 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 18 )
      {
         /* Execute user subroutine: 'PRUEBA 18 CONJUNTA' */
         S262 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 19 )
      {
         /* Execute user subroutine: 'PRUEBA 19 CONJUNTA' */
         S272 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 20 )
      {
         /* Execute user subroutine: 'PRUEBA 20 CONJUNTA' */
         S282 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 21 )
      {
         /* Execute user subroutine: 'PRUEBA 21 CONJUNTA' */
         S512 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 22 )
      {
         /* Execute user subroutine: 'PRUEBA 22 CONJUNTA' */
         S292 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 23 )
      {
         /* Execute user subroutine: 'PRUEBA 23 CONJUNTA' */
         S522 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 24 )
      {
         /* Execute user subroutine: 'PRUEBA 24 CONJUNTA' */
         S302 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 25 )
      {
         /* Execute user subroutine: 'PRUEBA 25 CONJUNTA' */
         S532 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 26 )
      {
         /* Execute user subroutine: 'PRUEBA 26 CONJUNTA' */
         S312 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 27 )
      {
         /* Execute user subroutine: 'PRUEBA 27 CONJUNTA' */
         S542 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 28 )
      {
         /* Execute user subroutine: 'PRUEBA 28 CONJUNTA' */
         S322 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 29 )
      {
         /* Execute user subroutine: 'PRUEBA 29 CONJUNTA' */
         S332 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 30 )
      {
         /* Execute user subroutine: 'PRUEBA 30 CONJUNTA' */
         S552 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 31 )
      {
         /* Execute user subroutine: 'PRUEBA 31 CONJUNTA' */
         S342 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 32 )
      {
         /* Execute user subroutine: 'PRUEBA 32 CONJUNTA' */
         S352 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 33 )
      {
         /* Execute user subroutine: 'PRUEBA 33 CONJUNTA' */
         S362 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 34 )
      {
         /* Execute user subroutine: 'PRUEBA 34 CONJUNTA' */
         S372 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 35 )
      {
         /* Execute user subroutine: 'PRUEBA 35 CONJUNTA' */
         S382 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 36 )
      {
         /* Execute user subroutine: 'PRUEBA 36 CONJUNTA' */
         S392 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 37 )
      {
         /* Execute user subroutine: 'PRUEBA 37 CONJUNTA' */
         S402 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 38 )
      {
         /* Execute user subroutine: 'PRUEBA 38 CONJUNTA' */
         S412 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 39 )
      {
         /* Execute user subroutine: 'PRUEBA 39 CONJUNTA' */
         S422 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 40 )
      {
         /* Execute user subroutine: 'PRUEBA 40 CONJUNTA' */
         S432 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 41 )
      {
         /* Execute user subroutine: 'PRUEBA 41 CONJUNTA' */
         S442 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 42 )
      {
         /* Execute user subroutine: 'PRUEBA 42 CONJUNTA' */
         S452 ();
         if (returnInSub) return;
      }
      else if ( A1083TestNro == 43 )
      {
         /* Execute user subroutine: 'PRUEBA 43 CONJUNTA' */
         S462 ();
         if (returnInSub) return;
      }
      httpContext.GX_msglist.addItem(httpContext.getMessage( "terminó", ""));
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV49TestNro", AV49TestNro);
   }

   public void S562( )
   {
      /* 'NUEVA LIQUIDACION' Routine */
      returnInSub = false ;
      AV39collectionLegNumero.clear();
      AV39collectionLegNumero.add((int)(AV13LegNumero), 0);
      GXt_int3 = AV20LiqNro ;
      GXv_int4[0] = GXt_int3 ;
      new web.obtnumliquidacion(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, GXv_int4) ;
      pruebas_impl.this.GXt_int3 = GXv_int4[0] ;
      AV20LiqNro = GXt_int3 ;
      AV116LiqPeriodo = localUtil.ymdtod( AV12anio, AV46Mes, 1) ;
      GXv_int8[0] = (byte)(AV117liquidaSac) ;
      GXv_char6[0] = AV118LiqSacLog ;
      new web.liquidar_sac(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, 0, AV45TLiqCod, AV116LiqPeriodo, GXv_int8, GXv_char6) ;
      pruebas_impl.this.AV117liquidaSac = GXv_int8[0] ;
      pruebas_impl.this.AV118LiqSacLog = GXv_char6[0] ;
      if ( AV117liquidaSac == 1 )
      {
         AV119LiqSac = true ;
      }
      else
      {
         AV119LiqSac = false ;
      }
      AV31x = (short)(0) ;
      AV32estado = (byte)(1) ;
      while ( AV32estado == 1 )
      {
         AV33sleep = GXutil.sleep( 1) ;
         GXv_int8[0] = AV32estado ;
         new web.getliqestado(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV20LiqNro, GXv_int8) ;
         pruebas_impl.this.AV32estado = GXv_int8[0] ;
         AV31x = (short)(AV31x+1) ;
      }
   }

   public void S572( )
   {
      /* 'PRUEBA 1' Routine */
      returnInSub = false ;
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 5, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 5, 14) ;
      AV13LegNumero = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      GXt_char9 = AV14adelVacMesProxConCodigo ;
      GXt_char10 = AV14adelVacMesProxConCodigo ;
      GXv_char6[0] = GXt_char10 ;
      new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char10 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char9 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char10, GXv_char5) ;
      pruebas_impl.this.GXt_char9 = GXv_char5[0] ;
      AV14adelVacMesProxConCodigo = GXt_char9 ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 4, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV14adelVacMesProxConCodigo, (byte)(0), DecimalUtil.doubleToDec(14), DecimalUtil.doubleToDec(0), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(5), (byte)(0), GXv_int2, false) ;
   }

   public void S582( )
   {
      /* 'PRUEBA 33' Routine */
      returnInSub = false ;
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 5, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 5, 14) ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      GXt_char10 = AV14adelVacMesProxConCodigo ;
      GXt_char9 = AV14adelVacMesProxConCodigo ;
      GXv_char6[0] = GXt_char9 ;
      new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV14adelVacMesProxConCodigo = GXt_char10 ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 4, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV14adelVacMesProxConCodigo, (byte)(0), DecimalUtil.doubleToDec(7), DecimalUtil.doubleToDec(0), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(5), (byte)(0), GXv_int2, false) ;
   }

   public void S592( )
   {
      /* 'PRUEBA 20' Routine */
      returnInSub = false ;
      AV13LegNumero = 2 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 2, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 2, 15) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), false) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV101valorHoraJor, AV43date) ;
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(100), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV40eneroFecha, GXutil.eomdate( AV40eneroFecha), true, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      AV60febreroFecha = localUtil.ymdtod( AV12anio, 2, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(100), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV60febreroFecha, GXutil.eomdate( AV60febreroFecha), false, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(100), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), localUtil.ymdtod( AV12anio, 3, 1), localUtil.ymdtod( AV12anio, 6, 30), true, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(1), (byte)(1), GXv_int2, false) ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(2) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
      GXv_int2[0] = (short)(2) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(5), (byte)(1), GXv_int2, false) ;
   }

   public void S602( )
   {
      /* 'PRUEBA 36' Routine */
      returnInSub = false ;
      AV13LegNumero = 2 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 3, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 3, 14) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), false) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV101valorHoraJor, AV43date) ;
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      AV76marzoFecha = localUtil.ymdtod( AV12anio, 3, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(100), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV40eneroFecha, GXutil.eomdate( AV76marzoFecha), true, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_char6[0] = AV77auxConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, new web.conceptohorasextras50_codigoparam(remoteHandle, context).executeUdp( ), GXv_char6) ;
      pruebas_impl.this.AV77auxConCodigo = GXv_char6[0] ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV77auxConCodigo, (byte)(0), DecimalUtil.doubleToDec(15), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV40eneroFecha, GXutil.eomdate( AV40eneroFecha), true, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      AV60febreroFecha = localUtil.ymdtod( AV12anio, 2, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV77auxConCodigo, (byte)(0), DecimalUtil.doubleToDec(10), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV60febreroFecha, AV60febreroFecha, false, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(3), (byte)(1), GXv_int2, false) ;
   }

   public void S612( )
   {
      /* 'PRUEBA 21' Routine */
      returnInSub = false ;
      AV13LegNumero = 4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 2, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 2, 15) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), false) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV101valorHoraJor, AV43date) ;
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(100), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV40eneroFecha, GXutil.eomdate( AV40eneroFecha), true, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      AV60febreroFecha = localUtil.ymdtod( AV12anio, 2, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(100), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV60febreroFecha, GXutil.eomdate( AV60febreroFecha), false, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(100), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), localUtil.ymdtod( AV12anio, 3, 1), localUtil.ymdtod( AV12anio, 6, 30), true, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(6), (byte)(1), GXv_int2, false) ;
   }

   public void S622( )
   {
      /* 'PRUEBA 2' Routine */
      returnInSub = false ;
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 5, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 5, 14) ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(4), (byte)(0), GXv_int2, false) ;
      GXt_char10 = AV14adelVacMesProxConCodigo ;
      GXt_char9 = AV14adelVacMesProxConCodigo ;
      GXv_char6[0] = GXt_char9 ;
      new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV14adelVacMesProxConCodigo = GXt_char10 ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 4, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV14adelVacMesProxConCodigo, (byte)(0), DecimalUtil.doubleToDec(14), DecimalUtil.doubleToDec(0), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(4) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
      GXv_int2[0] = (short)(5) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(1), (byte)(0), GXv_int2, false) ;
   }

   public void S632( )
   {
      /* 'PRUEBA 34' Routine */
      returnInSub = false ;
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 5, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 5, 14) ;
      AV13LegNumero = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(4), (byte)(0), GXv_int2, false) ;
      GXt_char10 = AV14adelVacMesProxConCodigo ;
      GXt_char9 = AV14adelVacMesProxConCodigo ;
      GXv_char6[0] = GXt_char9 ;
      new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV14adelVacMesProxConCodigo = GXt_char10 ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 4, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV14adelVacMesProxConCodigo, (byte)(0), DecimalUtil.doubleToDec(7), DecimalUtil.doubleToDec(0), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(4) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
      GXv_int2[0] = (short)(5) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(1), (byte)(0), GXv_int2, false) ;
   }

   public void S642( )
   {
      /* 'VALIDAR' Routine */
      returnInSub = false ;
      if ( AV48correrRelacionada )
      {
         GXv_boolean12[0] = AV63TestOK ;
         new web.validartest(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV56leg1_LegNumero, AV55leg2_LegNumero, AV49TestNro, AV75comparar, GXv_boolean12) ;
         pruebas_impl.this.AV63TestOK = GXv_boolean12[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV63TestOK", AV63TestOK);
         httpContext.doAjaxRefresh();
      }
   }

   public void S652( )
   {
      /* 'PRUEBA 3' Routine */
      returnInSub = false ;
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 5, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 5, 14) ;
      AV13LegNumero = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      GXt_char10 = AV14adelVacMesProxConCodigo ;
      GXt_char9 = AV14adelVacMesProxConCodigo ;
      GXv_char6[0] = GXt_char9 ;
      new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV14adelVacMesProxConCodigo = GXt_char10 ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 4, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV14adelVacMesProxConCodigo, (byte)(0), DecimalUtil.doubleToDec(14), DecimalUtil.doubleToDec(0), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(6), (byte)(0), GXv_int2, false) ;
   }

   public void S662( )
   {
      /* 'PRUEBA 4' Routine */
      returnInSub = false ;
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 5, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 5, 14) ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(4), (byte)(0), GXv_int2, false) ;
      GXt_char10 = AV14adelVacMesProxConCodigo ;
      GXt_char9 = AV14adelVacMesProxConCodigo ;
      GXv_char6[0] = GXt_char9 ;
      new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV14adelVacMesProxConCodigo = GXt_char10 ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 4, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV14adelVacMesProxConCodigo, (byte)(0), DecimalUtil.doubleToDec(14), DecimalUtil.doubleToDec(0), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(4) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
      new web.msgdebug_prod(remoteHandle, context).execute( AV128Pgmname, httpContext.getMessage( "llama a crear las 2 ultimas", "")) ;
      GXv_int2[0] = (short)(5) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(2), (byte)(0), GXv_int2, false) ;
   }

   public void S672( )
   {
      /* 'PRUEBA 7' Routine */
      returnInSub = false ;
      AV13LegNumero = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, AV42auxCantMeses, (byte)(0), GXv_int2, false) ;
   }

   public void S682( )
   {
      /* 'PRUEBA 8' Routine */
      returnInSub = false ;
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      AV41diciembreFecha = localUtil.ymdtod( AV12anio, 12, 1) ;
      AV13LegNumero = 2 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", DecimalUtil.doubleToDec(100000), AV43date) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(5), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV40eneroFecha, AV41diciembreFecha, true, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      if ( AV17errores.size() > 0 )
      {
         AV65i = (short)(1) ;
         while ( AV65i <= AV17errores.size() )
         {
            new web.alert(remoteHandle, context).execute( "error", (String)AV17errores.elementAt(-1+AV65i)) ;
            AV65i = (short)(AV65i+1) ;
         }
      }
      else
      {
         GXv_int2[0] = (short)(1) ;
         new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, AV42auxCantMeses, (byte)(1), GXv_int2, false) ;
      }
   }

   public void S692( )
   {
      /* 'PRUEBA 9' Routine */
      returnInSub = false ;
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 5, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 5, 14) ;
      AV13LegNumero = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      GXt_char10 = AV14adelVacMesProxConCodigo ;
      GXt_char9 = AV14adelVacMesProxConCodigo ;
      GXv_char6[0] = GXt_char9 ;
      new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV14adelVacMesProxConCodigo = GXt_char10 ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 4, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV14adelVacMesProxConCodigo, (byte)(0), DecimalUtil.doubleToDec(14), DecimalUtil.doubleToDec(0), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(5), (byte)(0), GXv_int2, false) ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(6) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
      GXv_int2[0] = (short)(6) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(1), (byte)(0), GXv_int2, false) ;
   }

   public void S702( )
   {
      /* 'PRUEBA 10' Routine */
      returnInSub = false ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, "808124.73", 0, 0) ;
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 5, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 5, 14) ;
      AV13LegNumero = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      GXt_char10 = AV14adelVacMesProxConCodigo ;
      GXt_char9 = AV14adelVacMesProxConCodigo ;
      GXv_char6[0] = GXt_char9 ;
      new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV14adelVacMesProxConCodigo = GXt_char10 ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 4, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV14adelVacMesProxConCodigo, (byte)(0), DecimalUtil.doubleToDec(14), DecimalUtil.doubleToDec(0), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(5), (byte)(0), GXv_int2, false) ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(6) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", DecimalUtil.doubleToDec(1500000), AV43date) ;
      GXv_int2[0] = (short)(6) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(1), (byte)(0), GXv_int2, false) ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 6, 1) ;
      AV16adelantoHastaFecha = AV15adelantoIniFecha ;
      if ( AV48correrRelacionada )
      {
         /* Execute user subroutine: 'CREAR CONCEPTO ADICIONAL' */
         S712 ();
         if (returnInSub) return;
         AV77auxConCodigo = AV69adicionalConCodigo ;
      }
      else
      {
         AV77auxConCodigo = AV47bonoProdConCodigo ;
      }
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV77auxConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV128Pgmname, httpContext.getMessage( "&CompensarPlus ", "")+GXutil.trim( GXutil.booltostr( AV80CompensarPlus))) ;
      if ( AV80CompensarPlus )
      {
         AV15adelantoIniFecha = GXutil.dadd( AV15adelantoIniFecha, (1)) ;
         AV16adelantoHastaFecha = AV15adelantoIniFecha ;
         GXv_objcol_svchar11[0] = AV17errores ;
         new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV69adicionalConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(12000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
         AV17errores = GXv_objcol_svchar11[0] ;
      }
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqvarios_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(6) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(6) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", DecimalUtil.doubleToDec(2400000), AV43date) ;
      GXv_int2[0] = (short)(7) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(6), (byte)(0), GXv_int2, false) ;
   }

   public void S722( )
   {
      /* 'PRUEBA 26' Routine */
      returnInSub = false ;
      AV13LegNumero = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, "3000000", 0, 0) ;
      AV61OpeCliId = "[mni]" ;
      new web.deleteopeclivalor(remoteHandle, context).execute( AV7CliCod, AV61OpeCliId) ;
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, AV61OpeCliId, AV40eneroFecha, AV43date, false, "1000000", 0, 0) ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 2, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV47bonoProdConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(3), (byte)(0), GXv_int2, false) ;
      AV61OpeCliId = "[mni]" ;
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      AV57abrilFecha = localUtil.ymdtod( AV12anio, 4, 1) ;
      AV41diciembreFecha = localUtil.ymdtod( AV12anio, 12, 1) ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, AV61OpeCliId, AV41diciembreFecha, AV40eneroFecha, true, "2000000", 0, 0) ;
      GXv_int2[0] = (short)(4) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(9), (byte)(0), GXv_int2, true) ;
   }

   public void S732( )
   {
      /* 'PRUEBA 27' Routine */
      returnInSub = false ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, "3000000", 0, 0) ;
      AV61OpeCliId = "[mni]" ;
      new web.deleteopeclivalor(remoteHandle, context).execute( AV7CliCod, AV61OpeCliId) ;
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, AV61OpeCliId, AV40eneroFecha, AV43date, false, "2000000", 0, 0) ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 2, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV47bonoProdConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(12), (byte)(0), GXv_int2, false) ;
   }

   public void S742( )
   {
      /* 'PRUEBA 13' Routine */
      returnInSub = false ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, httpContext.getMessage( "&sueldoMensuales0", ""), 0, 0) ;
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 5, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 5, 14) ;
      AV13LegNumero = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      GXt_char10 = AV14adelVacMesProxConCodigo ;
      GXt_char9 = AV14adelVacMesProxConCodigo ;
      GXv_char6[0] = GXt_char9 ;
      new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV14adelVacMesProxConCodigo = GXt_char10 ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 4, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV14adelVacMesProxConCodigo, (byte)(0), DecimalUtil.doubleToDec(14), DecimalUtil.doubleToDec(0), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(5), (byte)(0), GXv_int2, false) ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(6) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", DecimalUtil.doubleToDec(1500000), AV43date) ;
      GXv_int2[0] = (short)(6) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(1), (byte)(0), GXv_int2, false) ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 6, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV47bonoProdConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqvarios_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(6) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(6) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", DecimalUtil.doubleToDec(2400000), AV43date) ;
      GXv_int2[0] = (short)(7) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(6), (byte)(0), GXv_int2, false) ;
   }

   public void S752( )
   {
      /* 'PRUEBA 22' Routine */
      returnInSub = false ;
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      AV60febreroFecha = localUtil.ymdtod( AV12anio, 2, 1) ;
      AV41diciembreFecha = localUtil.ymdtod( AV12anio, 12, 1) ;
      AV13LegNumero = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.setlegrecalcularliq(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, true) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      AV61OpeCliId = "[mni]" ;
      new web.deleteopeclivalor(remoteHandle, context).execute( AV7CliCod, AV61OpeCliId) ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, AV61OpeCliId, AV40eneroFecha, AV43date, false, "200000", 0, 0) ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, AV61OpeCliId, AV41diciembreFecha, AV43date, false, "400000", 0, 0) ;
      new web.deletededucciones(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio) ;
      AV62domesticaConCodigo = httpContext.getMessage( "DED008", "") ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(12), (byte)(0), GXv_int2, false) ;
   }

   public void S762( )
   {
      /* 'PRUEBA 37' Routine */
      returnInSub = false ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 1, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 1, 3) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionenfermedad(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Licencia por enfermedad", ""), httpContext.getMessage( "Licencia por enfermedad", ""), false) ;
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 2, 15) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 2, 25) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacioniltempresa(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "ILT primeros 10 dias", ""), httpContext.getMessage( "ILT primeros 10 dias", ""), false) ;
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 4, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 4, 20) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacioniltart(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "ILT ART", ""), httpContext.getMessage( "ILT ART", ""), false) ;
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 5, 10) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 8, 10) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionmaternidad(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "licencia por maternidad", ""), httpContext.getMessage( "licencia por maternidad", ""), false) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(12), (byte)(0), GXv_int2, false) ;
   }

   public void S772( )
   {
      /* 'PRUEBA 35' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV128Pgmname, "3") ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.deletededucciones(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio) ;
      GXt_char10 = AV70otrConCodigo ;
      GXt_char9 = AV70otrConCodigo ;
      GXv_char6[0] = GXt_char9 ;
      new web.otroemplgananciabruta_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV70otrConCodigo = GXt_char10 ;
      GXt_char10 = AV72otrSACConCodigo ;
      GXt_char9 = AV72otrSACConCodigo ;
      GXv_char6[0] = GXt_char9 ;
      new web.otroemplsac_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV72otrSACConCodigo = GXt_char10 ;
      GXt_char10 = AV73otrOSConCodigo ;
      GXt_char9 = AV73otrOSConCodigo ;
      GXv_char6[0] = GXt_char9 ;
      new web.otroemplos_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV73otrOSConCodigo = GXt_char10 ;
      GXt_char10 = AV74otrSegSocConCodigo ;
      GXt_char9 = AV74otrSegSocConCodigo ;
      GXv_char6[0] = GXt_char9 ;
      new web.otroemplsegsoc_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV74otrSegSocConCodigo = GXt_char10 ;
      AV65i = (short)(1) ;
      while ( AV65i <= 12 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV128Pgmname, "4") ;
         AV71fecha = localUtil.ymdtod( AV12anio, AV65i, 1) ;
         if ( ( AV65i == 6 ) || ( AV65i == 12 ) )
         {
         }
         AV65i = (short)(AV65i+1) ;
      }
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", DecimalUtil.doubleToDec(900000), AV43date) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, AV42auxCantMeses, (byte)(0), GXv_int2, false) ;
   }

   public void S782( )
   {
      /* 'PRUEBA 23' Routine */
      returnInSub = false ;
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      AV60febreroFecha = localUtil.ymdtod( AV12anio, 2, 1) ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.setlegrecalcularliq(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, true) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      AV61OpeCliId = "[mni]" ;
      new web.deleteopeclivalor(remoteHandle, context).execute( AV7CliCod, AV61OpeCliId) ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, AV61OpeCliId, AV40eneroFecha, AV43date, false, "200000", 0, 0) ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, AV61OpeCliId, AV60febreroFecha, AV43date, false, "400000", 0, 0) ;
      new web.deletededucciones(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio) ;
      AV62domesticaConCodigo = httpContext.getMessage( "DED008", "") ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(12), (byte)(0), GXv_int2, false) ;
   }

   public void S792( )
   {
      /* 'PRUEBA 24' Routine */
      returnInSub = false ;
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      AV60febreroFecha = localUtil.ymdtod( AV12anio, 2, 1) ;
      AV13LegNumero = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.setlegrecalcularliq(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, true) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      AV61OpeCliId = "[mni]" ;
      new web.deleteopeclivalor(remoteHandle, context).execute( AV7CliCod, AV61OpeCliId) ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, AV61OpeCliId, AV40eneroFecha, AV43date, false, "200000", 0, 0) ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, AV61OpeCliId, AV60febreroFecha, AV40eneroFecha, true, "400000", 0, 0) ;
      new web.deletededucciones(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio) ;
      AV62domesticaConCodigo = httpContext.getMessage( "DED008", "") ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(2), (byte)(0), GXv_int2, true) ;
   }

   public void S802( )
   {
      /* 'PRUEBA 25' Routine */
      returnInSub = false ;
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      AV60febreroFecha = localUtil.ymdtod( AV12anio, 2, 1) ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.setlegrecalcularliq(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, true) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      AV61OpeCliId = "[mni]" ;
      new web.deleteopeclivalor(remoteHandle, context).execute( AV7CliCod, AV61OpeCliId) ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, AV61OpeCliId, AV40eneroFecha, AV43date, false, "400000", 0, 0) ;
      new web.deletededucciones(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio) ;
      AV62domesticaConCodigo = httpContext.getMessage( "DED008", "") ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(2), (byte)(0), GXv_int2, false) ;
   }

   public void S812( )
   {
      /* 'PRUEBA 11' Routine */
      returnInSub = false ;
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 5, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 5, 14) ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(5), (byte)(0), GXv_int2, false) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", DecimalUtil.doubleToDec(2400000), AV43date) ;
      GXv_int2[0] = (short)(6) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(7), (byte)(0), GXv_int2, false) ;
   }

   public void S822( )
   {
      /* 'PRUEBA 14' Routine */
      returnInSub = false ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, "808124.73", 0, 0) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(5), (byte)(0), GXv_int2, false) ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 6, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV47bonoProdConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(6) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(7), (byte)(0), GXv_int2, false) ;
   }

   public void S832( )
   {
      /* 'PRUEBA 18' Routine */
      returnInSub = false ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, "808124.73", 0, 0) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(5), (byte)(0), GXv_int2, false) ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 6, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV47bonoProdConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(6) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(2), (byte)(0), GXv_int2, false) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, localUtil.ymdtod( 2023, 7, 31)) ;
      new web.setearlegajopruebaegreso(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, localUtil.ymdtod( 2023, 7, 31), httpContext.getMessage( "REN", ""), AV43date) ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(8) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
   }

   public void S842( )
   {
      /* 'PRUEBA 38' Routine */
      returnInSub = false ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, "808124.73", 0, 0) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(5), (byte)(0), GXv_int2, false) ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 6, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV47bonoProdConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(6) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(2), (byte)(0), GXv_int2, false) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, localUtil.ymdtod( 2023, 7, 31)) ;
      new web.setearlegajopruebaegreso(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, localUtil.ymdtod( 2023, 7, 31), httpContext.getMessage( "DES1", ""), AV43date) ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(8) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
   }

   public void S852( )
   {
      /* 'PRUEBA 39' Routine */
      returnInSub = false ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, "808124.73", 0, 0) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(5), (byte)(0), GXv_int2, false) ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 6, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV47bonoProdConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(6) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(2), (byte)(0), GXv_int2, false) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, localUtil.ymdtod( 2023, 7, 31)) ;
      new web.setearlegajopruebaegreso(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, localUtil.ymdtod( 2023, 7, 31), httpContext.getMessage( "DES2", ""), localUtil.ymdtod( 2023, 1, 31)) ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(8) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
   }

   public void S862( )
   {
      /* 'PRUEBA 40' Routine */
      returnInSub = false ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, "808124.73", 0, 0) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(5), (byte)(0), GXv_int2, false) ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 6, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV47bonoProdConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(6) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(2), (byte)(0), GXv_int2, false) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, localUtil.ymdtod( 2023, 7, 31)) ;
      new web.setearlegajopruebaegreso(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, localUtil.ymdtod( 2023, 7, 31), httpContext.getMessage( "DES2", ""), AV43date) ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(8) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
   }

   public void S872( )
   {
      /* 'PRUEBA 41' Routine */
      returnInSub = false ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, "808124.73", 0, 0) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(5), (byte)(0), GXv_int2, false) ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 6, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV47bonoProdConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(6) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(4), (byte)(0), GXv_int2, false) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, localUtil.ymdtod( 2023, 7, 31)) ;
      new web.setearlegajopruebaegreso(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, localUtil.ymdtod( 2023, 10, 28), httpContext.getMessage( "DES2", ""), AV43date) ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(10) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
   }

   public void S882( )
   {
      /* 'PRUEBA 42' Routine */
      returnInSub = false ;
      AV13LegNumero = 2 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      AV41diciembreFecha = localUtil.ymdtod( AV12anio, 12, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(100), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV40eneroFecha, GXutil.eomdate( AV41diciembreFecha), true, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, "808124.73", 0, 0) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.conveniouecara(remoteHandle, context).executeUdp( ), httpContext.getMessage( "UECARA", ""), AV100sueldoMensuales, AV43date) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(5), (byte)(1), GXv_int2, false) ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 6, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV47bonoProdConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(6) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(4), (byte)(1), GXv_int2, false) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.conveniouecara(remoteHandle, context).executeUdp( ), httpContext.getMessage( "UECARA", ""), AV100sueldoMensuales, localUtil.ymdtod( 2023, 7, 31)) ;
      new web.setearlegajopruebaegreso(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, localUtil.ymdtod( 2023, 10, 15), httpContext.getMessage( "DES2", ""), AV43date) ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(10) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
   }

   public void S892( )
   {
      /* 'PRUEBA 43' Routine */
      returnInSub = false ;
      AV13LegNumero = 2 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      AV41diciembreFecha = localUtil.ymdtod( AV12anio, 12, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(100), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV40eneroFecha, GXutil.eomdate( AV41diciembreFecha), true, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, "808124.73", 0, 0) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.conveniouocra(remoteHandle, context).executeUdp( ), httpContext.getMessage( "UOCRA", ""), AV100sueldoMensuales, AV43date) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(5), (byte)(1), GXv_int2, false) ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 6, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV47bonoProdConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(6) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(4), (byte)(1), GXv_int2, false) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.conveniouocra(remoteHandle, context).executeUdp( ), httpContext.getMessage( "UOCRA", ""), AV100sueldoMensuales, localUtil.ymdtod( 2023, 7, 31)) ;
      new web.setearlegajopruebaegreso(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, localUtil.ymdtod( 2023, 10, 15), httpContext.getMessage( "DES2", ""), AV43date) ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(10) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
   }

   public void S902( )
   {
      /* 'PRUEBA 17' Routine */
      returnInSub = false ;
      AV13LegNumero = 2 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, "808124.73", 0, 0) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", DecimalUtil.doubleToDec(100000), AV43date) ;
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      AV41diciembreFecha = localUtil.ymdtod( AV12anio, 12, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(5), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV40eneroFecha, AV41diciembreFecha, true, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 6, 1) ;
      AV16adelantoHastaFecha = localUtil.ymdtod( AV12anio, 6, 15) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV47bonoProdConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(12), (byte)(1), GXv_int2, false) ;
   }

   public void S912( )
   {
      /* 'PRUEBA 16' Routine */
      returnInSub = false ;
      AV13LegNumero = 2 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, "808124.73", 0, 0) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", DecimalUtil.doubleToDec(100000), AV43date) ;
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      AV41diciembreFecha = localUtil.ymdtod( AV12anio, 12, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(5), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV40eneroFecha, AV41diciembreFecha, true, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 6, 16) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV47bonoProdConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(12), (byte)(1), GXv_int2, false) ;
   }

   public void S922( )
   {
      /* 'PRUEBA 15' Routine */
      returnInSub = false ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, httpContext.getMessage( "&sueldoMensuales0", ""), 0, 0) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(5), (byte)(0), GXv_int2, false) ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 6, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV47bonoProdConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(6) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(7), (byte)(0), GXv_int2, false) ;
   }

   public void S932( )
   {
      /* 'PRUEBA 5' Routine */
      returnInSub = false ;
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 5, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 5, 14) ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), AV78plus) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(6), (byte)(0), GXv_int2, false) ;
   }

   public void S942( )
   {
      /* 'PRUEBA 31' Routine */
      returnInSub = false ;
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 5, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 5, 14) ;
      AV13LegNumero = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), true) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(4), (byte)(0), GXv_int2, false) ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(5) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
      GXv_int2[0] = (short)(5) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(2), (byte)(0), GXv_int2, false) ;
   }

   public void S952( )
   {
      /* 'PRUEBA 6' Routine */
      returnInSub = false ;
      AV13LegNumero = 2 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV101valorHoraJor, AV43date) ;
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      AV57abrilFecha = localUtil.ymdtod( AV12anio, 4, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(100), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV40eneroFecha, AV57abrilFecha, true, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      AV58mayoFecha = localUtil.ymdtod( AV12anio, 5, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(9), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV58mayoFecha, AV58mayoFecha, true, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      AV58mayoFecha = localUtil.ymdtod( AV12anio, 5, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(100), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV58mayoFecha, AV58mayoFecha, false, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      AV59junioFecha = localUtil.ymdtod( AV12anio, 6, 1) ;
      AV41diciembreFecha = localUtil.ymdtod( AV12anio, 12, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(100), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV59junioFecha, AV41diciembreFecha, true, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 5, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 5, 14) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), false) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(6), (byte)(1), GXv_int2, false) ;
   }

   public void S962( )
   {
      /* 'PRUEBA 32' Routine */
      returnInSub = false ;
      AV13LegNumero = 4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV101valorHoraJor, AV43date) ;
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      AV57abrilFecha = localUtil.ymdtod( AV12anio, 4, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(100), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV40eneroFecha, AV57abrilFecha, true, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      AV58mayoFecha = localUtil.ymdtod( AV12anio, 5, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(45), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV58mayoFecha, AV58mayoFecha, true, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      AV58mayoFecha = localUtil.ymdtod( AV12anio, 5, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(100), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV58mayoFecha, AV58mayoFecha, false, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      AV59junioFecha = localUtil.ymdtod( AV12anio, 6, 1) ;
      AV41diciembreFecha = localUtil.ymdtod( AV12anio, 12, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(100), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV59junioFecha, AV41diciembreFecha, true, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 5, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 5, 10) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), false) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(4), (byte)(1), GXv_int2, false) ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(5) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
      GXv_int2[0] = (short)(5) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(2), (byte)(1), GXv_int2, false) ;
   }

   public void S972( )
   {
      /* 'PRUEBA 12' Routine */
      returnInSub = false ;
      AV13LegNumero = 4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV101valorHoraJor, AV43date) ;
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      AV41diciembreFecha = localUtil.ymdtod( AV12anio, 12, 1) ;
      AV57abrilFecha = localUtil.ymdtod( AV12anio, 4, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(100), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV40eneroFecha, AV57abrilFecha, true, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      AV58mayoFecha = localUtil.ymdtod( AV12anio, 5, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(9), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV58mayoFecha, AV58mayoFecha, true, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(100), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV58mayoFecha, AV58mayoFecha, false, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      AV59junioFecha = localUtil.ymdtod( AV12anio, 6, 1) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, new web.concepto_basico_segunclase(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, AV13LegNumero), (byte)(0), DecimalUtil.doubleToDec(100), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(2), AV59junioFecha, AV41diciembreFecha, true, true, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      AV11LegLicenIni = localUtil.ymdtod( AV12anio, 5, 1) ;
      AV10LegLicenFin = localUtil.ymdtod( AV12anio, 5, 14) ;
      new web.grabanovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV11LegLicenIni, AV10LegLicenFin, new web.codigodesituacionvacaciones(remoteHandle, context).executeUdp( AV7CliCod), httpContext.getMessage( "Vacaciones", ""), httpContext.getMessage( "Vacaciones", ""), false) ;
      GXt_char10 = AV14adelVacMesProxConCodigo ;
      GXt_char9 = AV14adelVacMesProxConCodigo ;
      GXv_char6[0] = GXt_char9 ;
      new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV14adelVacMesProxConCodigo = GXt_char10 ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 4, 16) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV14adelVacMesProxConCodigo, (byte)(0), DecimalUtil.doubleToDec(14), DecimalUtil.doubleToDec(0), (byte)(2), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(6), (byte)(1), GXv_int2, false) ;
   }

   public void S132( )
   {
      /* 'PRUEBA 1 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(1)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 1 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 1' */
         S572 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 2' */
            S622 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(1), 0);
         AV49TestNro.add((short)(2), 0);
         AV56leg1_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
      httpContext.GX_msglist.addItem(httpContext.getMessage( "tengo que hacer una prueba como esta pero que el sueldo sea menor al maximo imponible", ""));
   }

   public void S362( )
   {
      /* 'PRUEBA 33 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(33)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 33 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 33' */
         S582 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 1' */
            S572 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(33), 0);
         AV49TestNro.add((short)(1), 0);
         AV56leg1_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S342( )
   {
      /* 'PRUEBA 31 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(31)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 31 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 31' */
         S942 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            AV78plus = true ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78plus", AV78plus);
            /* Execute user subroutine: 'PRUEBA 5' */
            S932 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(31), 0);
         AV49TestNro.add((short)(5), 0);
         AV56leg1_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S472( )
   {
      /* 'PRUEBA 2 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(2)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 2 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 2' */
         S622 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 1' */
            S572 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(2), 0);
         AV49TestNro.add((short)(1), 0);
         AV56leg1_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S372( )
   {
      /* 'PRUEBA 34 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(34)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 34 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 34' */
         S632 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 2' */
            S622 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(34), 0);
         AV49TestNro.add((short)(2), 0);
         AV56leg1_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S382( )
   {
      /* 'PRUEBA 35 CONJUNTA' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV128Pgmname, "1") ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(35)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 35 conjunta", "")) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV128Pgmname, "2") ;
         /* Execute user subroutine: 'PRUEBA 35' */
         S772 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 7' */
            S672 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(35), 0);
         AV49TestNro.add((short)(7), 0);
         AV56leg1_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "GANANCIAS", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S402( )
   {
      /* 'PRUEBA 37 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(37)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 37 conjunta", "")) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV128Pgmname, "2") ;
         /* Execute user subroutine: 'PRUEBA 37' */
         S762 ();
         if (returnInSub) return;
         new web.cambiarestadotest(remoteHandle, context).execute( (short)(37), true) ;
      }
   }

   public void S392( )
   {
      /* 'PRUEBA 36 CONJUNTA' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV128Pgmname, "1") ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(36)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 36 conjunta", "")) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV128Pgmname, "2") ;
         /* Execute user subroutine: 'PRUEBA 36' */
         S602 ();
         if (returnInSub) return;
         new web.cambiarestadotest(remoteHandle, context).execute( (short)(36), true) ;
      }
   }

   public void S142( )
   {
      /* 'PRUEBA 3 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(3)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 3 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 3' */
         S652 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 4' */
            S662 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(3), 0);
         AV49TestNro.add((short)(4), 0);
         AV56leg1_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S482( )
   {
      /* 'PRUEBA 4 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(4)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 4 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 4' */
         S662 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 3' */
            S652 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(4), 0);
         AV49TestNro.add((short)(3), 0);
         AV56leg1_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S152( )
   {
      /* 'PRUEBA 5 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(5)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 5 conjunta", "")) ;
         AV78plus = true ;
         httpContext.ajax_rsp_assign_attri("", false, "AV78plus", AV78plus);
         /* Execute user subroutine: 'PRUEBA 5' */
         S932 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 3' */
            S652 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(5), 0);
         AV49TestNro.add((short)(3), 0);
         AV56leg1_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S162( )
   {
      /* 'PRUEBA 6 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(6)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 6 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 6' */
         S952 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            AV78plus = true ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78plus", AV78plus);
            /* Execute user subroutine: 'PRUEBA 5' */
            S932 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(6), 0);
         AV49TestNro.add((short)(5), 0);
         AV56leg1_LegNumero = 2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S352( )
   {
      /* 'PRUEBA 32 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(32)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 32 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 32' */
         S962 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 6' */
            S952 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(32), 0);
         AV49TestNro.add((short)(6), 0);
         AV56leg1_LegNumero = 4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S172( )
   {
      /* 'PRUEBA 7 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(7)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 7 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 7' */
         S672 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 8' */
            S682 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(7), 0);
         AV49TestNro.add((short)(8), 0);
         AV56leg1_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S492( )
   {
      /* 'PRUEBA 8 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(8)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 8 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 8' */
         S682 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 7' */
            S672 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(7), 0);
         AV49TestNro.add((short)(8), 0);
         AV56leg1_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S182( )
   {
      /* 'PRUEBA 9 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(9)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 9 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 9' */
         S692 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 4' */
            S662 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(9), 0);
         AV49TestNro.add((short)(4), 0);
         AV56leg1_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S192( )
   {
      /* 'PRUEBA 10 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(10)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 10 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 10' */
         S702 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 11' */
            S812 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(10), 0);
         AV49TestNro.add((short)(11), 0);
         AV56leg1_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S212( )
   {
      /* 'PRUEBA 13 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(13)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 13 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 13' */
         S742 ();
         if (returnInSub) return;
         new web.validartestbonos(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, (short)(13)) ;
      }
   }

   public void S222( )
   {
      /* 'PRUEBA 14 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(14)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 14 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 14' */
         S822 ();
         if (returnInSub) return;
         new web.validartestbonos(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, (short)(14)) ;
      }
   }

   public void S282( )
   {
      /* 'PRUEBA 20 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(20)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 20 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 20' */
         S592 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 21' */
            S612 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(20), 0);
         AV49TestNro.add((short)(21), 0);
         AV56leg1_LegNumero = 2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S292( )
   {
      /* 'PRUEBA 22 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(22)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 22 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 22' */
         S752 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 23' */
            S782 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(22), 0);
         AV49TestNro.add((short)(23), 0);
         AV56leg1_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S522( )
   {
      /* 'PRUEBA 23 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(23)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 23 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 23' */
         S782 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 22' */
            S752 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(23), 0);
         AV49TestNro.add((short)(22), 0);
         AV56leg1_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S302( )
   {
      /* 'PRUEBA 24 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(24)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 24 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 24' */
         S792 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 25' */
            S802 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(24), 0);
         AV49TestNro.add((short)(25), 0);
         AV56leg1_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S312( )
   {
      /* 'PRUEBA 26 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(26)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 26 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 26' */
         S722 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 27' */
            S732 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(26), 0);
         AV49TestNro.add((short)(27), 0);
         AV56leg1_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
         if ( AV63TestOK )
         {
            new web.validartestbonos(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, (short)(26)) ;
         }
      }
   }

   public void S322( )
   {
      /* 'PRUEBA 28 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(28)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 28 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 28' */
         S982 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 19' */
            S992 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(28), 0);
         AV49TestNro.add((short)(19), 0);
         AV56leg1_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
         if ( AV63TestOK )
         {
            new web.validartestbonos(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, (short)(28)) ;
         }
      }
   }

   public void S332( )
   {
      /* 'PRUEBA 29 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(29)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 29 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 29' */
         S1002 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 30' */
            S1012 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(29), 0);
         AV49TestNro.add((short)(30), 0);
         AV56leg1_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S552( )
   {
      /* 'PRUEBA 30 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(30)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 30 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 30' */
         S1012 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 29' */
            S1002 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(30), 0);
         AV49TestNro.add((short)(29), 0);
         AV56leg1_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S542( )
   {
      /* 'PRUEBA 27 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(27)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 27 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 27' */
         S732 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 26' */
            S722 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(27), 0);
         AV49TestNro.add((short)(26), 0);
         AV56leg1_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
         if ( AV63TestOK )
         {
            new web.validartestbonos(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, (short)(27)) ;
         }
      }
   }

   public void S532( )
   {
      /* 'PRUEBA 25 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(25)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 25 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 25' */
         S802 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 24' */
            S792 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(25), 0);
         AV49TestNro.add((short)(24), 0);
         AV56leg1_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S512( )
   {
      /* 'PRUEBA 21 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(21)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 21 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 21' */
         S612 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 20' */
            S592 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(20), 0);
         AV49TestNro.add((short)(21), 0);
         AV56leg1_LegNumero = 4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S232( )
   {
      /* 'PRUEBA 15 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(15)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 15 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 15' */
         S922 ();
         if (returnInSub) return;
         new web.validartestbonos(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, (short)(15)) ;
      }
   }

   public void S242( )
   {
      /* 'PRUEBA 16 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(16)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 16 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 16' */
         S912 ();
         if (returnInSub) return;
         new web.validartestbonos(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, (short)(16)) ;
      }
   }

   public void S252( )
   {
      /* 'PRUEBA 17 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(17)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 17 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 17' */
         S902 ();
         if (returnInSub) return;
         new web.validartestbonos(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, (short)(17)) ;
      }
   }

   public void S262( )
   {
      /* 'PRUEBA 18 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(18)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 18 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 18' */
         S832 ();
         if (returnInSub) return;
         new web.validartestbonos(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, (short)(18)) ;
      }
   }

   public void S412( )
   {
      /* 'PRUEBA 38 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(38)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 38 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 38' */
         S842 ();
         if (returnInSub) return;
      }
   }

   public void S422( )
   {
      /* 'PRUEBA 39 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(39)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 39 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 39' */
         S852 ();
         if (returnInSub) return;
      }
   }

   public void S432( )
   {
      /* 'PRUEBA 40 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(40)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 40 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 40' */
         S862 ();
         if (returnInSub) return;
      }
   }

   public void S442( )
   {
      /* 'PRUEBA 41 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(41)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 41 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 41' */
         S872 ();
         if (returnInSub) return;
      }
   }

   public void S452( )
   {
      /* 'PRUEBA 42 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(42)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 42 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 42' */
         S882 ();
         if (returnInSub) return;
      }
   }

   public void S462( )
   {
      /* 'PRUEBA 43 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(43)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 43 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 43' */
         S892 ();
         if (returnInSub) return;
      }
   }

   public void S272( )
   {
      /* 'PRUEBA 19 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(19)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 19 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 19' */
         S992 ();
         if (returnInSub) return;
         new web.validartestbonos(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, (short)(19)) ;
      }
   }

   public void S502( )
   {
      /* 'PRUEBA 11 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(11)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 11 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 11' */
         S812 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 10' */
            S702 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(10), 0);
         AV49TestNro.add((short)(11), 0);
         AV56leg1_LegNumero = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S202( )
   {
      /* 'PRUEBA 12 CONJUNTA' Routine */
      returnInSub = false ;
      if ( ! AV68CorrerSoloPendientes || ! new web.gettestok(remoteHandle, context).executeUdp( (short)(12)) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "info", httpContext.getMessage( "prueba 12 conjunta", "")) ;
         /* Execute user subroutine: 'PRUEBA 12' */
         S972 ();
         if (returnInSub) return;
         if ( AV48correrRelacionada )
         {
            /* Execute user subroutine: 'PRUEBA 6' */
            S952 ();
            if (returnInSub) return;
         }
         AV49TestNro.clear();
         AV49TestNro.add((short)(12), 0);
         AV49TestNro.add((short)(6), 0);
         AV56leg1_LegNumero = 4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56leg1_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56leg1_LegNumero), 8, 0));
         AV55leg2_LegNumero = 2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55leg2_LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55leg2_LegNumero), 8, 0));
         AV75comparar = httpContext.getMessage( "NETO", "") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75comparar", AV75comparar);
         /* Execute user subroutine: 'VALIDAR' */
         S642 ();
         if (returnInSub) return;
      }
   }

   public void S122( )
   {
      /* 'RESETEAR' Routine */
      returnInSub = false ;
      if ( AV63TestOK )
      {
         AV13LegNumero = 0 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
         if ( AV44eliminarLiquidaciones )
         {
            new web.eliminaliquidacion(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, 0) ;
         }
         new web.eliminarnovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, 0, (short)(0)) ;
         new web.eliminarnovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, 0, AV43date) ;
         new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, 1, "", "", AV100sueldoMensuales, AV43date) ;
         new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, 3, "", "", AV100sueldoMensuales, AV43date) ;
      }
   }

   public void S992( )
   {
      /* 'PRUEBA 19' Routine */
      returnInSub = false ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, "808124.73", 0, 0) ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 4, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV47bonoProdConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 9, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV47bonoProdConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(12), (byte)(0), GXv_int2, false) ;
   }

   public void S982( )
   {
      /* 'PRUEBA 28' Routine */
      returnInSub = false ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, "808124.73", 0, 0) ;
      AV13LegNumero = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV47bonoProdConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_char6[0] = AV67bonoProdConCodigo2 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "bono 2", ""), GXv_char6) ;
      pruebas_impl.this.AV67bonoProdConCodigo2 = GXv_char6[0] ;
      if ( (GXutil.strcmp("", AV67bonoProdConCodigo2)==0) )
      {
         GXv_char6[0] = AV67bonoProdConCodigo2 ;
         new web.proximoconcodigo(remoteHandle, context).execute( AV7CliCod, "REM_ARG", GXv_char6) ;
         pruebas_impl.this.AV67bonoProdConCodigo2 = GXv_char6[0] ;
         new web.newconcepto(remoteHandle, context).execute( AV7CliCod, AV67bonoProdConCodigo2, httpContext.getMessage( "bono 2", ""), (byte)(0), false, (byte)(1), false, "", DecimalUtil.doubleToDec(0), "", true, false, "REM_ARG", new web.subtipopremio(remoteHandle, context).executeUdp( ), "", "", AV64ConCodigo, 0, true, "N", GXutil.toBoolean( 0), false, false) ;
         new web.testgrabatipoliqs(remoteHandle, context).execute( AV7CliCod, AV67bonoProdConCodigo2) ;
         new web.inicializarconceptosafipdefault(remoteHandle, context).execute( AV7CliCod, AV67bonoProdConCodigo2) ;
      }
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV67bonoProdConCodigo2, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(900000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(12), (byte)(0), GXv_int2, false) ;
   }

   public void S1002( )
   {
      /* 'PRUEBA 29' Routine */
      returnInSub = false ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, "808124.73", 0, 0) ;
      AV13LegNumero = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(6), (byte)(0), GXv_int2, false) ;
   }

   public void S1012( )
   {
      /* 'PRUEBA 30' Routine */
      returnInSub = false ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, "[tope_bonos]", localUtil.ymdtod( 2023, 1, 1), AV43date, false, "808124.73", 0, 0) ;
      AV13LegNumero = 3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13LegNumero), 8, 0));
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      GXv_int2[0] = (short)(1) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(4), (byte)(0), GXv_int2, false) ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 5, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      /* Execute user subroutine: 'CREAR CONCEPTO ADICIONAL' */
      S712 ();
      if (returnInSub) return;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV69adicionalConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(250000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqvarios_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(5) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", DecimalUtil.doubleToDec(250000), AV43date) ;
      GXv_int2[0] = (short)(5) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(1), (byte)(0), GXv_int2, false) ;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 5, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV69adicionalConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(250000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqvarios_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(5) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
      AV15adelantoIniFecha = localUtil.ymdtod( AV12anio, 5, 1) ;
      AV16adelantoHastaFecha = GXutil.eomdate( AV15adelantoIniFecha) ;
      GXv_objcol_svchar11[0] = AV17errores ;
      new web.grabanovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV69adicionalConCodigo, (byte)(0), DecimalUtil.doubleToDec(1), DecimalUtil.doubleToDec(250000), (byte)(1), "E", (byte)(1), AV15adelantoIniFecha, AV16adelantoHastaFecha, false, false, GXv_objcol_svchar11) ;
      AV17errores = GXv_objcol_svchar11[0] ;
      GXt_char10 = AV45TLiqCod ;
      GXt_char9 = AV45TLiqCod ;
      GXv_char6[0] = GXt_char9 ;
      new web.tipoliqvarios_codigoparam(remoteHandle, context).execute( GXv_char6) ;
      pruebas_impl.this.GXt_char9 = GXv_char6[0] ;
      GXv_char5[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV7CliCod, GXt_char9, GXv_char5) ;
      pruebas_impl.this.GXt_char10 = GXv_char5[0] ;
      AV45TLiqCod = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45TLiqCod", AV45TLiqCod);
      AV46Mes = (byte)(5) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46Mes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46Mes), 2, 0));
      /* Execute user subroutine: 'NUEVA LIQUIDACION' */
      S562 ();
      if (returnInSub) return;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, "", "", AV100sueldoMensuales, AV43date) ;
      GXv_int2[0] = (short)(6) ;
      new web.crear12liquidacionesmensuales(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV13LegNumero, AV12anio, (short)(1), (byte)(0), GXv_int2, true) ;
   }

   public void S112( )
   {
      /* 'DEFAULTS' Routine */
      returnInSub = false ;
      new web.deletededucciones(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, 0, AV12anio) ;
      AV61OpeCliId = "[mni]" ;
      new web.deleteopeclivalor(remoteHandle, context).execute( AV7CliCod, AV61OpeCliId) ;
      AV40eneroFecha = localUtil.ymdtod( AV12anio, 1, 1) ;
      new web.grabaopeclivalor(remoteHandle, context).execute( AV7CliCod, AV61OpeCliId, AV40eneroFecha, AV43date, false, "451683.19", 0, 0) ;
      new web.eliminarnovedadconcepto(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, 0, (short)(0)) ;
      new web.eliminarnovedadevento(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, 0, AV43date) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, 1, "", "", AV100sueldoMensuales, AV43date) ;
      new web.setearporpruebas(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, 3, "", "", AV100sueldoMensuales, AV43date) ;
   }

   public void S712( )
   {
      /* 'CREAR CONCEPTO ADICIONAL' Routine */
      returnInSub = false ;
      GXv_char6[0] = AV69adicionalConCodigo ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV7CliCod, httpContext.getMessage( "ADICIONAL", ""), GXv_char6) ;
      pruebas_impl.this.AV69adicionalConCodigo = GXv_char6[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV69adicionalConCodigo", AV69adicionalConCodigo);
      if ( (GXutil.strcmp("", AV69adicionalConCodigo)==0) )
      {
         GXv_char6[0] = AV69adicionalConCodigo ;
         new web.proximoconcodigo(remoteHandle, context).execute( AV7CliCod, "REM_ARG", GXv_char6) ;
         pruebas_impl.this.AV69adicionalConCodigo = GXv_char6[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV69adicionalConCodigo", AV69adicionalConCodigo);
         new web.newconcepto(remoteHandle, context).execute( AV7CliCod, AV69adicionalConCodigo, httpContext.getMessage( "ADICIONAL", ""), (byte)(0), false, (byte)(1), false, "", DecimalUtil.doubleToDec(0), "", false, false, "REM_ARG", new web.subtipopremio(remoteHandle, context).executeUdp( ), "", "", AV64ConCodigo, 0, true, "N", GXutil.toBoolean( 0), false, false) ;
         new web.testgrabatipoliqs(remoteHandle, context).execute( AV7CliCod, AV69adicionalConCodigo) ;
         new web.inicializarconceptosafipdefault(remoteHandle, context).execute( AV7CliCod, AV69adicionalConCodigo) ;
      }
   }

   public void wb_table4_189_BL2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable4_Internalname, tblUnnamedtable4_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavTestsuellegnumero4_Internalname+"\"", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 194,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavTestsuellegnumero4_Internalname, GXutil.ltrim( localUtil.ntoc( AV99testSuelLegNumero4, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavTestsuellegnumero4_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV99testSuelLegNumero4), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV99testSuelLegNumero4), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,194);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTestsuellegnumero4_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavTestsuellegnumero4_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 196,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnuseraction4_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "UserAction4", ""), bttBtnuseraction4_Jsonclick, 5, httpContext.getMessage( "UserAction4", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOUSERACTION4\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_189_BL2e( true) ;
      }
      else
      {
         wb_table4_189_BL2e( false) ;
      }
   }

   public void wb_table3_163_BL2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable3_Internalname, tblUnnamedtable3_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavTestsuellegnumero3_Internalname+"\"", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 168,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavTestsuellegnumero3_Internalname, GXutil.ltrim( localUtil.ntoc( AV86testSuelLegNumero3, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavTestsuellegnumero3_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV86testSuelLegNumero3), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV86testSuelLegNumero3), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,168);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTestsuellegnumero3_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavTestsuellegnumero3_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 170,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnuseraction3_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "UserAction3", ""), bttBtnuseraction3_Jsonclick, 5, httpContext.getMessage( "UserAction3", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOUSERACTION3\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavTestimportes3_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavTestimportes3_Internalname, httpContext.getMessage( "testImportes3", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 175,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavTestimportes3_Internalname, GXutil.ltrim( localUtil.ntoc( AV93testImportes3, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavTestimportes3_Enabled!=0) ? localUtil.format( AV93testImportes3, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV93testImportes3, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,175);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTestimportes3_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavTestimportes3_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavTestimportes3b_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavTestimportes3b_Internalname, httpContext.getMessage( "testImportes3B", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 179,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavTestimportes3b_Internalname, GXutil.ltrim( localUtil.ntoc( AV94testImportes3B, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavTestimportes3b_Enabled!=0) ? localUtil.format( AV94testImportes3B, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV94testImportes3B, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,179);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTestimportes3b_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavTestimportes3b_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavDiferencia3_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavDiferencia3_Internalname, httpContext.getMessage( "diferencia3", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 184,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDiferencia3_Internalname, GXutil.ltrim( localUtil.ntoc( AV95diferencia3, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavDiferencia3_Enabled!=0) ? localUtil.format( AV95diferencia3, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV95diferencia3, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,184);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDiferencia3_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavDiferencia3_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 186,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnuseraction2conceptos_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "UserAction2Conceptos", ""), bttBtnuseraction2conceptos_Jsonclick, 5, httpContext.getMessage( "UserAction2Conceptos", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOUSERACTION2CONCEPTOS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_163_BL2e( true) ;
      }
      else
      {
         wb_table3_163_BL2e( false) ;
      }
   }

   public void wb_table2_139_BL2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable2_Internalname, tblUnnamedtable2_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavTestsuellegnumero2_Internalname+"\"", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 144,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavTestsuellegnumero2_Internalname, GXutil.ltrim( localUtil.ntoc( AV84testSuelLegNumero2, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavTestsuellegnumero2_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV84testSuelLegNumero2), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV84testSuelLegNumero2), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,144);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTestsuellegnumero2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavTestsuellegnumero2_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 146,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnuseraction2_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "UserAction2", ""), bttBtnuseraction2_Jsonclick, 5, httpContext.getMessage( "UserAction2", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOUSERACTION2\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavTestimportes2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavTestimportes2_Internalname, httpContext.getMessage( "testImportes2", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 151,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavTestimportes2_Internalname, GXutil.ltrim( localUtil.ntoc( AV90testImportes2, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavTestimportes2_Enabled!=0) ? localUtil.format( AV90testImportes2, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV90testImportes2, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,151);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTestimportes2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavTestimportes2_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavTestimportes2b_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavTestimportes2b_Internalname, httpContext.getMessage( "testImportes2B", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 155,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavTestimportes2b_Internalname, GXutil.ltrim( localUtil.ntoc( AV91testImportes2B, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavTestimportes2b_Enabled!=0) ? localUtil.format( AV91testImportes2B, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV91testImportes2B, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,155);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTestimportes2b_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavTestimportes2b_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavDiferencia2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavDiferencia2_Internalname, httpContext.getMessage( "diferencia2", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 160,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDiferencia2_Internalname, GXutil.ltrim( localUtil.ntoc( AV92diferencia2, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavDiferencia2_Enabled!=0) ? localUtil.format( AV92diferencia2, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV92diferencia2, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,160);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDiferencia2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavDiferencia2_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_139_BL2e( true) ;
      }
      else
      {
         wb_table2_139_BL2e( false) ;
      }
   }

   public void wb_table1_115_BL2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavTestsuellegnumero_Internalname+"\"", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 120,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavTestsuellegnumero_Internalname, GXutil.ltrim( localUtil.ntoc( AV81testSuelLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavTestsuellegnumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV81testSuelLegNumero), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV81testSuelLegNumero), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,120);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTestsuellegnumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavTestsuellegnumero_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 122,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnuseraction1_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", httpContext.getMessage( "UserAction1", ""), bttBtnuseraction1_Jsonclick, 5, httpContext.getMessage( "UserAction1", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOUSERACTION1\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pruebas.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavTestimportes1_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavTestimportes1_Internalname, httpContext.getMessage( "testImportes1", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 127,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavTestimportes1_Internalname, GXutil.ltrim( localUtil.ntoc( AV96testImportes1, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavTestimportes1_Enabled!=0) ? localUtil.format( AV96testImportes1, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV96testImportes1, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,127);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTestimportes1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavTestimportes1_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavTestimportes1b_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavTestimportes1b_Internalname, httpContext.getMessage( "testImportes1B", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 131,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavTestimportes1b_Internalname, GXutil.ltrim( localUtil.ntoc( AV97testImportes1B, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavTestimportes1b_Enabled!=0) ? localUtil.format( AV97testImportes1B, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV97testImportes1B, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,131);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTestimportes1b_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavTestimportes1b_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavDiferencia1_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavDiferencia1_Internalname, httpContext.getMessage( "diferencia1", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 136,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavDiferencia1_Internalname, GXutil.ltrim( localUtil.ntoc( AV98diferencia1, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavDiferencia1_Enabled!=0) ? localUtil.format( AV98diferencia1, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV98diferencia1, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,136);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDiferencia1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavDiferencia1_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_Pruebas.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_115_BL2e( true) ;
      }
      else
      {
         wb_table1_115_BL2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      paBL2( ) ;
      wsBL2( ) ;
      weBL2( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
      httpContext.setWrapped(false);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713581325", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
         httpContext.AddJavascriptSource("pruebas.js", "?20251713581326", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_632( )
   {
      edtTestError_Internalname = "TESTERROR_"+sGXsfl_63_idx ;
      edtTestNeto_Internalname = "TESTNETO_"+sGXsfl_63_idx ;
      edtTestDescripcion_Internalname = "TESTDESCRIPCION_"+sGXsfl_63_idx ;
      chkTestOK.setInternalname( "TESTOK_"+sGXsfl_63_idx );
      edtTestSegLiq_Internalname = "TESTSEGLIQ_"+sGXsfl_63_idx ;
      edtTestVueltas_Internalname = "TESTVUELTAS_"+sGXsfl_63_idx ;
      edtTestNro_Internalname = "TESTNRO_"+sGXsfl_63_idx ;
   }

   public void subsflControlProps_fel_632( )
   {
      edtTestError_Internalname = "TESTERROR_"+sGXsfl_63_fel_idx ;
      edtTestNeto_Internalname = "TESTNETO_"+sGXsfl_63_fel_idx ;
      edtTestDescripcion_Internalname = "TESTDESCRIPCION_"+sGXsfl_63_fel_idx ;
      chkTestOK.setInternalname( "TESTOK_"+sGXsfl_63_fel_idx );
      edtTestSegLiq_Internalname = "TESTSEGLIQ_"+sGXsfl_63_fel_idx ;
      edtTestVueltas_Internalname = "TESTVUELTAS_"+sGXsfl_63_fel_idx ;
      edtTestNro_Internalname = "TESTNRO_"+sGXsfl_63_fel_idx ;
   }

   public void sendrow_632( )
   {
      subsflControlProps_632( ) ;
      wbBL0( ) ;
      Freestylegrid2Row = GXWebRow.GetNew(context,Freestylegrid2Container) ;
      if ( subFreestylegrid2_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subFreestylegrid2_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subFreestylegrid2_Class, "") != 0 )
         {
            subFreestylegrid2_Linesclass = subFreestylegrid2_Class+"Odd" ;
         }
      }
      else if ( subFreestylegrid2_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subFreestylegrid2_Backstyle = (byte)(0) ;
         subFreestylegrid2_Backcolor = subFreestylegrid2_Allbackcolor ;
         if ( GXutil.strcmp(subFreestylegrid2_Class, "") != 0 )
         {
            subFreestylegrid2_Linesclass = subFreestylegrid2_Class+"Uniform" ;
         }
      }
      else if ( subFreestylegrid2_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subFreestylegrid2_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subFreestylegrid2_Class, "") != 0 )
         {
            subFreestylegrid2_Linesclass = subFreestylegrid2_Class+"Odd" ;
         }
         subFreestylegrid2_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subFreestylegrid2_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subFreestylegrid2_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_63_idx) % (2))) == 0 )
         {
            subFreestylegrid2_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subFreestylegrid2_Class, "") != 0 )
            {
               subFreestylegrid2_Linesclass = subFreestylegrid2_Class+"Even" ;
            }
         }
         else
         {
            subFreestylegrid2_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subFreestylegrid2_Class, "") != 0 )
            {
               subFreestylegrid2_Linesclass = subFreestylegrid2_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subFreestylegrid2_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_63_idx+"\">") ;
      }
      /* Table start */
      Freestylegrid2Row.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblFreestylegrid2layouttable_Internalname+"_"+sGXsfl_63_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      Freestylegrid2Row.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylegrid2Row.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      Freestylegrid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Freestylegrid2Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtTestError_Internalname,httpContext.getMessage( "Test Error", ""),"gx-form-item AttributeWeightBoldLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Multiple line edit */
      ClassString = "AttributeWeightBold" ;
      StyleString = "" ;
      ClassString = "AttributeWeightBold" ;
      StyleString = "" ;
      Freestylegrid2Row.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtTestError_Internalname,A1091TestError,"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(5),"row",Integer.valueOf(0),StyleString,ClassString,"","","400",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"error","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      Freestylegrid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         Freestylegrid2Container.CloseTag("cell");
      }
      Freestylegrid2Row.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      Freestylegrid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group gx-default-form-group","left","top",""+" data-gx-for=\""+edtTestNeto_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Freestylegrid2Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtTestNeto_Internalname,httpContext.getMessage( "Neto", ""),"gx-form-item AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),"width: 25%;"});
      /* Div Control */
      Freestylegrid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(75),"%",Integer.valueOf(0),"px","gx-form-item gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Freestylegrid2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTestNeto_Internalname,GXutil.ltrim( localUtil.ntoc( A1092TestNeto, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A1092TestNeto, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTestNeto_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(17),"chr",Integer.valueOf(1),"row",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(63),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
      Freestylegrid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Freestylegrid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         Freestylegrid2Container.CloseTag("cell");
      }
      Freestylegrid2Row.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      Freestylegrid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Freestylegrid2Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtTestDescripcion_Internalname,httpContext.getMessage( "Test Descripcion", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      Freestylegrid2Row.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtTestDescripcion_Internalname,A1087TestDescripcion,"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(10),"row",Integer.valueOf(0),StyleString,ClassString,"","","1000",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      Freestylegrid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         Freestylegrid2Container.CloseTag("cell");
      }
      Freestylegrid2Row.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      Freestylegrid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Freestylegrid2Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {chkTestOK.getInternalname(),httpContext.getMessage( "Test OK", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Check box */
      ClassString = "Attribute" ;
      StyleString = "" ;
      GXCCtl = "TESTOK_" + sGXsfl_63_idx ;
      chkTestOK.setName( GXCCtl );
      chkTestOK.setWebtags( "" );
      chkTestOK.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkTestOK.getInternalname(), "TitleCaption", chkTestOK.getCaption(), !bGXsfl_63_Refreshing);
      chkTestOK.setCheckedValue( "false" );
      A1084TestOK = GXutil.strtobool( GXutil.booltostr( A1084TestOK)) ;
      Freestylegrid2Row.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkTestOK.getInternalname(),GXutil.booltostr( A1084TestOK),"",httpContext.getMessage( "Test OK", ""),Integer.valueOf(1),Integer.valueOf(0),"true","",StyleString,ClassString,"","",""});
      Freestylegrid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         Freestylegrid2Container.CloseTag("cell");
      }
      Freestylegrid2Row.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      Freestylegrid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Freestylegrid2Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtTestSegLiq_Internalname,httpContext.getMessage( "Test Seg Liq", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Freestylegrid2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTestSegLiq_Internalname,GXutil.ltrim( localUtil.ntoc( A1088TestSegLiq, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1088TestSegLiq), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTestSegLiq_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(63),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Freestylegrid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         Freestylegrid2Container.CloseTag("cell");
      }
      Freestylegrid2Row.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      Freestylegrid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Freestylegrid2Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtTestVueltas_Internalname,httpContext.getMessage( "Test Vueltas", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Freestylegrid2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTestVueltas_Internalname,GXutil.ltrim( localUtil.ntoc( A1090TestVueltas, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1090TestVueltas), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTestVueltas_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(63),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Freestylegrid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         Freestylegrid2Container.CloseTag("cell");
      }
      Freestylegrid2Row.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Table start */
      Freestylegrid2Row.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUsertable2_Internalname+"_"+sGXsfl_63_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      Freestylegrid2Row.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylegrid2Row.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         Freestylegrid2Container.CloseTag("cell");
      }
      Freestylegrid2Row.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 90,'',false,'',0)\"" ;
      ClassString = "Button" ;
      StyleString = "" ;
      Freestylegrid2Row.AddColumnProperties("button", 2, isAjaxCallMode( ), new Object[] {bttBotonprueba_Internalname+"_"+sGXsfl_63_idx,"gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");",bttBotonprueba_Caption,bttBotonprueba_Jsonclick,Integer.valueOf(5),httpContext.getMessage( "Boton Prueba", ""),"",StyleString,ClassString,Integer.valueOf(1),Integer.valueOf(1),"standard","'"+""+"'"+",false,"+"'"+"E\\'BOTONPRUEBA\\'."+"'",TempTags,"",httpContext.getButtonType( )});
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         Freestylegrid2Container.CloseTag("cell");
      }
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         Freestylegrid2Container.CloseTag("row");
      }
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         Freestylegrid2Container.CloseTag("table");
      }
      /* End of table */
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         Freestylegrid2Container.CloseTag("cell");
      }
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         Freestylegrid2Container.CloseTag("row");
      }
      Freestylegrid2Row.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      Freestylegrid2Row.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","","Invisible"});
      /* Table start */
      Freestylegrid2Row.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablecontentfsfreestylegrid2_Internalname+"_"+sGXsfl_63_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      Freestylegrid2Row.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      sendrow_63230( ) ;
   }

   public void sendrow_63230( )
   {
      Freestylegrid2Row.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      Freestylegrid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Freestylegrid2Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtTestNro_Internalname,httpContext.getMessage( "Test Nro", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Freestylegrid2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTestNro_Internalname,GXutil.ltrim( localUtil.ntoc( A1083TestNro, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1083TestNro), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTestNro_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(edtTestNro_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(63),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Freestylegrid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         Freestylegrid2Container.CloseTag("cell");
      }
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         Freestylegrid2Container.CloseTag("row");
      }
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         Freestylegrid2Container.CloseTag("table");
      }
      /* End of table */
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         Freestylegrid2Container.CloseTag("cell");
      }
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         Freestylegrid2Container.CloseTag("row");
      }
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         Freestylegrid2Container.CloseTag("table");
      }
      /* End of table */
      send_integrity_lvl_hashesBL2( ) ;
      /* End of Columns property logic. */
      Freestylegrid2Container.AddRow(Freestylegrid2Row);
      nGXsfl_63_idx = ((subFreestylegrid2_Islastpage==1)&&(nGXsfl_63_idx+1>subfreestylegrid2_fnc_recordsperpage( )) ? 1 : nGXsfl_63_idx+1) ;
      sGXsfl_63_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_63_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_632( ) ;
      /* End function sendrow_632 */
   }

   public void startgridcontrol63( )
   {
      if ( Freestylegrid2Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Freestylegrid2Container"+"DivS\" data-gxgridid=\"63\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subFreestylegrid2_Internalname, subFreestylegrid2_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         Freestylegrid2Container.AddObjectProperty("GridName", "Freestylegrid2");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            Freestylegrid2Container = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            Freestylegrid2Container.Clear();
         }
         Freestylegrid2Container.SetIsFreestyle(true);
         Freestylegrid2Container.SetWrapped(nGXWrapped);
         Freestylegrid2Container.AddObjectProperty("GridName", "Freestylegrid2");
         Freestylegrid2Container.AddObjectProperty("Header", subFreestylegrid2_Header);
         Freestylegrid2Container.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         Freestylegrid2Container.AddObjectProperty("Class", "FreeStyleGrid");
         Freestylegrid2Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Freestylegrid2Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Freestylegrid2Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subFreestylegrid2_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Freestylegrid2Container.AddObjectProperty("CmpContext", "");
         Freestylegrid2Container.AddObjectProperty("InMasterPage", "false");
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Column.AddObjectProperty("Value", A1091TestError);
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1092TestNeto, (byte)(17), (byte)(2), ".", "")));
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Column.AddObjectProperty("Value", A1087TestDescripcion);
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Column.AddObjectProperty("Value", GXutil.booltostr( A1084TestOK));
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1088TestSegLiq, (byte)(4), (byte)(0), ".", "")));
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1090TestVueltas, (byte)(4), (byte)(0), ".", "")));
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Freestylegrid2Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1083TestNro, (byte)(4), (byte)(0), ".", "")));
         Freestylegrid2Column.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtTestNro_Visible, (byte)(5), (byte)(0), ".", "")));
         Freestylegrid2Container.AddColumnProperties(Freestylegrid2Column);
         Freestylegrid2Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subFreestylegrid2_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Freestylegrid2Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subFreestylegrid2_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Freestylegrid2Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subFreestylegrid2_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Freestylegrid2Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subFreestylegrid2_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Freestylegrid2Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subFreestylegrid2_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Freestylegrid2Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subFreestylegrid2_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Freestylegrid2Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subFreestylegrid2_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      bttBtnini_Internalname = "BTNINI" ;
      edtavAuxcantmeses_Internalname = "vAUXCANTMESES" ;
      chkavEliminarliquidaciones.setInternalname( "vELIMINARLIQUIDACIONES" );
      chkavCorrerrelacionada.setInternalname( "vCORRERRELACIONADA" );
      edtavPararenerror_Internalname = "vPARARENERROR" ;
      chkavCorrersolopendientes.setInternalname( "vCORRERSOLOPENDIENTES" );
      chkavJorvsmen.setInternalname( "vJORVSMEN" );
      chkavCompensarplus.setInternalname( "vCOMPENSARPLUS" );
      edtavSueldomensuales_Internalname = "vSUELDOMENSUALES" ;
      edtavValorhorajor_Internalname = "vVALORHORAJOR" ;
      edtTestError_Internalname = "TESTERROR" ;
      edtTestNeto_Internalname = "TESTNETO" ;
      edtTestDescripcion_Internalname = "TESTDESCRIPCION" ;
      chkTestOK.setInternalname( "TESTOK" );
      edtTestSegLiq_Internalname = "TESTSEGLIQ" ;
      edtTestVueltas_Internalname = "TESTVUELTAS" ;
      bttBotonprueba_Internalname = "BOTONPRUEBA" ;
      tblUsertable2_Internalname = "USERTABLE2" ;
      edtTestNro_Internalname = "TESTNRO" ;
      tblUnnamedtablecontentfsfreestylegrid2_Internalname = "UNNAMEDTABLECONTENTFSFREESTYLEGRID2" ;
      tblFreestylegrid2layouttable_Internalname = "FREESTYLEGRID2LAYOUTTABLE" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnprobartodos_Internalname = "BTNPROBARTODOS" ;
      bttBtniniapl_Internalname = "BTNINIAPL" ;
      bttBtncorregircorhetesconcpeot_Internalname = "BTNCORREGIRCORHETESCONCPEOT" ;
      bttBtnactualizartopes_Internalname = "BTNACTUALIZARTOPES" ;
      bttBtncrearfulanos_Internalname = "BTNCREARFULANOS" ;
      edtavTestsuellegnumero_Internalname = "vTESTSUELLEGNUMERO" ;
      bttBtnuseraction1_Internalname = "BTNUSERACTION1" ;
      edtavTestimportes1_Internalname = "vTESTIMPORTES1" ;
      edtavTestimportes1b_Internalname = "vTESTIMPORTES1B" ;
      edtavDiferencia1_Internalname = "vDIFERENCIA1" ;
      tblUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      edtavTestsuellegnumero2_Internalname = "vTESTSUELLEGNUMERO2" ;
      bttBtnuseraction2_Internalname = "BTNUSERACTION2" ;
      edtavTestimportes2_Internalname = "vTESTIMPORTES2" ;
      edtavTestimportes2b_Internalname = "vTESTIMPORTES2B" ;
      edtavDiferencia2_Internalname = "vDIFERENCIA2" ;
      tblUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      edtavTestsuellegnumero3_Internalname = "vTESTSUELLEGNUMERO3" ;
      bttBtnuseraction3_Internalname = "BTNUSERACTION3" ;
      edtavTestimportes3_Internalname = "vTESTIMPORTES3" ;
      edtavTestimportes3b_Internalname = "vTESTIMPORTES3B" ;
      edtavDiferencia3_Internalname = "vDIFERENCIA3" ;
      bttBtnuseraction2conceptos_Internalname = "BTNUSERACTION2CONCEPTOS" ;
      tblUnnamedtable3_Internalname = "UNNAMEDTABLE3" ;
      edtavTestsuellegnumero4_Internalname = "vTESTSUELLEGNUMERO4" ;
      bttBtnuseraction4_Internalname = "BTNUSERACTION4" ;
      tblUnnamedtable4_Internalname = "UNNAMEDTABLE4" ;
      bttBtnduplicarlegajo_Internalname = "BTNDUPLICARLEGAJO" ;
      edtavMultilegnumero_Internalname = "vMULTILEGNUMERO" ;
      edtavMulticant_Internalname = "vMULTICANT" ;
      bttBtnfixescalasnoviembre_Internalname = "BTNFIXESCALASNOVIEMBRE" ;
      bttBtnpreliquidaciones_Internalname = "BTNPRELIQUIDACIONES" ;
      lblAyuda_Internalname = "AYUDA" ;
      edtavSvgvalor_Internalname = "vSVGVALOR" ;
      lblTestsvg_Internalname = "TESTSVG" ;
      bttBtnuseraction5_Internalname = "BTNUSERACTION5" ;
      bttBtnformula_Internalname = "BTNFORMULA" ;
      edtavExpresion_Internalname = "vEXPRESION" ;
      edtavPalabraaaaamm_Internalname = "vPALABRAAAAAMM" ;
      bttBtnregex_Internalname = "BTNREGEX" ;
      bttBtnimportartodosproa_Internalname = "BTNIMPORTARTODOSPROA" ;
      edtavMesnro_Internalname = "vMESNRO" ;
      bttBtnimportartodoslsdproa_Internalname = "BTNIMPORTARTODOSLSDPROA" ;
      edtavOtraempcod_Internalname = "vOTRAEMPCOD" ;
      edtavImpliqperiodo_Internalname = "vIMPLIQPERIODO" ;
      dynavImptliqcod.setInternalname( "vIMPTLIQCOD" );
      chkavEliminarliquidacionesreplica.setInternalname( "vELIMINARLIQUIDACIONESREPLICA" );
      bttBtnreplicarimportadas_Internalname = "BTNREPLICARIMPORTADAS" ;
      bttBtnhttp_Internalname = "BTNHTTP" ;
      bttBtncalccontr_Internalname = "BTNCALCCONTR" ;
      bttBtninimenuusu_Internalname = "BTNINIMENUUSU" ;
      bttBtndeletecuentas_Internalname = "BTNDELETECUENTAS" ;
      bttBtninipermas_Internalname = "BTNINIPERMAS" ;
      bttBtneliminadup_Internalname = "BTNELIMINADUP" ;
      edtavDliqperiodo_Internalname = "vDLIQPERIODO" ;
      bttBtngeneraauxfaltantes_Internalname = "BTNGENERAAUXFALTANTES" ;
      bttBtncorrigeimp_Internalname = "BTNCORRIGEIMP" ;
      bttBtninisueldoslegajos_Internalname = "BTNINISUELDOSLEGAJOS" ;
      bttBtnuseraction6_Internalname = "BTNUSERACTION6" ;
      bttBtnuseraction7_Internalname = "BTNUSERACTION7" ;
      bttBtnuseraction8_Internalname = "BTNUSERACTION8" ;
      bttBtnuseraction9_Internalname = "BTNUSERACTION9" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subFreestylegrid2_Internalname = "FREESTYLEGRID2" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      subFreestylegrid2_Allowcollapsing = (byte)(0) ;
      edtTestNro_Jsonclick = "" ;
      edtTestVueltas_Jsonclick = "" ;
      edtTestSegLiq_Jsonclick = "" ;
      chkTestOK.setCaption( httpContext.getMessage( "Test OK", "") );
      edtTestNeto_Jsonclick = "" ;
      subFreestylegrid2_Class = "FreeStyleGrid" ;
      edtavDiferencia1_Jsonclick = "" ;
      edtavDiferencia1_Enabled = 1 ;
      edtavTestimportes1b_Jsonclick = "" ;
      edtavTestimportes1b_Enabled = 1 ;
      edtavTestimportes1_Jsonclick = "" ;
      edtavTestimportes1_Enabled = 1 ;
      edtavTestsuellegnumero_Jsonclick = "" ;
      edtavTestsuellegnumero_Enabled = 1 ;
      edtavDiferencia2_Jsonclick = "" ;
      edtavDiferencia2_Enabled = 1 ;
      edtavTestimportes2b_Jsonclick = "" ;
      edtavTestimportes2b_Enabled = 1 ;
      edtavTestimportes2_Jsonclick = "" ;
      edtavTestimportes2_Enabled = 1 ;
      edtavTestsuellegnumero2_Jsonclick = "" ;
      edtavTestsuellegnumero2_Enabled = 1 ;
      edtavDiferencia3_Jsonclick = "" ;
      edtavDiferencia3_Enabled = 1 ;
      edtavTestimportes3b_Jsonclick = "" ;
      edtavTestimportes3b_Enabled = 1 ;
      edtavTestimportes3_Jsonclick = "" ;
      edtavTestimportes3_Enabled = 1 ;
      edtavTestsuellegnumero3_Jsonclick = "" ;
      edtavTestsuellegnumero3_Enabled = 1 ;
      edtavTestsuellegnumero4_Jsonclick = "" ;
      edtavTestsuellegnumero4_Enabled = 1 ;
      bttBotonprueba_Caption = httpContext.getMessage( "Boton Prueba", "") ;
      subFreestylegrid2_Backcolorstyle = (byte)(0) ;
      edtavDliqperiodo_Jsonclick = "" ;
      edtavDliqperiodo_Enabled = 1 ;
      chkavEliminarliquidacionesreplica.setEnabled( 1 );
      dynavImptliqcod.setJsonclick( "" );
      dynavImptliqcod.setEnabled( 1 );
      edtavImpliqperiodo_Jsonclick = "" ;
      edtavImpliqperiodo_Enabled = 1 ;
      edtavOtraempcod_Jsonclick = "" ;
      edtavOtraempcod_Enabled = 1 ;
      edtavMesnro_Jsonclick = "" ;
      edtavMesnro_Enabled = 1 ;
      edtavPalabraaaaamm_Jsonclick = "" ;
      edtavPalabraaaaamm_Enabled = 1 ;
      edtavExpresion_Jsonclick = "" ;
      edtavExpresion_Enabled = 1 ;
      lblTestsvg_Caption = httpContext.getMessage( "testSVG", "") ;
      edtavSvgvalor_Enabled = 1 ;
      edtavMulticant_Jsonclick = "" ;
      edtavMulticant_Enabled = 1 ;
      edtavMultilegnumero_Jsonclick = "" ;
      edtavMultilegnumero_Enabled = 1 ;
      edtavValorhorajor_Jsonclick = "" ;
      edtavValorhorajor_Enabled = 1 ;
      edtavSueldomensuales_Jsonclick = "" ;
      edtavSueldomensuales_Enabled = 1 ;
      chkavCompensarplus.setEnabled( 1 );
      chkavJorvsmen.setEnabled( 1 );
      chkavCorrersolopendientes.setEnabled( 1 );
      edtavPararenerror_Jsonclick = "" ;
      edtavPararenerror_Enabled = 1 ;
      chkavCorrerrelacionada.setEnabled( 1 );
      chkavEliminarliquidaciones.setEnabled( 1 );
      edtavAuxcantmeses_Jsonclick = "" ;
      edtavAuxcantmeses_Enabled = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Pruebas", "") );
      edtTestNro_Visible = 1 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      chkavEliminarliquidaciones.setName( "vELIMINARLIQUIDACIONES" );
      chkavEliminarliquidaciones.setWebtags( "" );
      chkavEliminarliquidaciones.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavEliminarliquidaciones.getInternalname(), "TitleCaption", chkavEliminarliquidaciones.getCaption(), true);
      chkavEliminarliquidaciones.setCheckedValue( "false" );
      AV44eliminarLiquidaciones = GXutil.strtobool( GXutil.booltostr( AV44eliminarLiquidaciones)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44eliminarLiquidaciones", AV44eliminarLiquidaciones);
      chkavCorrerrelacionada.setName( "vCORRERRELACIONADA" );
      chkavCorrerrelacionada.setWebtags( "" );
      chkavCorrerrelacionada.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavCorrerrelacionada.getInternalname(), "TitleCaption", chkavCorrerrelacionada.getCaption(), true);
      chkavCorrerrelacionada.setCheckedValue( "false" );
      AV48correrRelacionada = GXutil.strtobool( GXutil.booltostr( AV48correrRelacionada)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48correrRelacionada", AV48correrRelacionada);
      chkavCorrersolopendientes.setName( "vCORRERSOLOPENDIENTES" );
      chkavCorrersolopendientes.setWebtags( "" );
      chkavCorrersolopendientes.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavCorrersolopendientes.getInternalname(), "TitleCaption", chkavCorrersolopendientes.getCaption(), true);
      chkavCorrersolopendientes.setCheckedValue( "false" );
      AV68CorrerSoloPendientes = GXutil.strtobool( GXutil.booltostr( AV68CorrerSoloPendientes)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV68CorrerSoloPendientes", AV68CorrerSoloPendientes);
      chkavJorvsmen.setName( "vJORVSMEN" );
      chkavJorvsmen.setWebtags( "" );
      chkavJorvsmen.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavJorvsmen.getInternalname(), "TitleCaption", chkavJorvsmen.getCaption(), true);
      chkavJorvsmen.setCheckedValue( "false" );
      AV79JorVsMen = GXutil.strtobool( GXutil.booltostr( AV79JorVsMen)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79JorVsMen", AV79JorVsMen);
      chkavCompensarplus.setName( "vCOMPENSARPLUS" );
      chkavCompensarplus.setWebtags( "" );
      chkavCompensarplus.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavCompensarplus.getInternalname(), "TitleCaption", chkavCompensarplus.getCaption(), true);
      chkavCompensarplus.setCheckedValue( "false" );
      AV80CompensarPlus = GXutil.strtobool( GXutil.booltostr( AV80CompensarPlus)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV80CompensarPlus", AV80CompensarPlus);
      GXCCtl = "TESTOK_" + sGXsfl_63_idx ;
      chkTestOK.setName( GXCCtl );
      chkTestOK.setWebtags( "" );
      chkTestOK.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkTestOK.getInternalname(), "TitleCaption", chkTestOK.getCaption(), !bGXsfl_63_Refreshing);
      chkTestOK.setCheckedValue( "false" );
      A1084TestOK = GXutil.strtobool( GXutil.booltostr( A1084TestOK)) ;
      dynavImptliqcod.setName( "vIMPTLIQCOD" );
      dynavImptliqcod.setWebtags( "" );
      chkavEliminarliquidacionesreplica.setName( "vELIMINARLIQUIDACIONESREPLICA" );
      chkavEliminarliquidacionesreplica.setWebtags( "" );
      chkavEliminarliquidacionesreplica.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavEliminarliquidacionesreplica.getInternalname(), "TitleCaption", chkavEliminarliquidacionesreplica.getCaption(), true);
      chkavEliminarliquidacionesreplica.setCheckedValue( "false" );
      AV115eliminarliquidacionesreplica = GXutil.strtobool( GXutil.booltostr( AV115eliminarliquidacionesreplica)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV115eliminarliquidacionesreplica", AV115eliminarliquidacionesreplica);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'FREESTYLEGRID2_nFirstRecordOnPage'},{av:'FREESTYLEGRID2_nEOF'},{av:'edtTestNro_Visible',ctrl:'TESTNRO',prop:'Visible'},{av:'dynavImptliqcod'},{av:'AV114impTLiqCod',fld:'vIMPTLIQCOD',pic:''},{av:'AV44eliminarLiquidaciones',fld:'vELIMINARLIQUIDACIONES',pic:''},{av:'AV48correrRelacionada',fld:'vCORRERRELACIONADA',pic:''},{av:'AV68CorrerSoloPendientes',fld:'vCORRERSOLOPENDIENTES',pic:''},{av:'AV79JorVsMen',fld:'vJORVSMEN',pic:''},{av:'AV80CompensarPlus',fld:'vCOMPENSARPLUS',pic:''},{av:'AV115eliminarliquidacionesreplica',fld:'vELIMINARLIQUIDACIONESREPLICA',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV12anio',fld:'vANIO',pic:'ZZZ9',hsh:true},{av:'AV43date',fld:'vDATE',pic:'',hsh:true},{av:'AV128Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV47bonoProdConCodigo',fld:'vBONOPRODCONCODIGO',pic:'',hsh:true},{av:'AV64ConCodigo',fld:'vCONCODIGO',pic:'',hsh:true},{av:'AV125vaciaFecha',fld:'vVACIAFECHA',pic:'',hsh:true},{av:'AV96testImportes1',fld:'vTESTIMPORTES1',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV90testImportes2',fld:'vTESTIMPORTES2',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV93testImportes3',fld:'vTESTIMPORTES3',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("FREESTYLEGRID2.LOAD","{handler:'e46BL2',iparms:[{av:'A1086TestNombre',fld:'TESTNOMBRE',pic:''}]");
      setEventMetadata("FREESTYLEGRID2.LOAD",",oparms:[{ctrl:'BOTONPRUEBA',prop:'Caption'}]}");
      setEventMetadata("'DOINI'","{handler:'e15BL2',iparms:[{av:'FREESTYLEGRID2_nFirstRecordOnPage'},{av:'FREESTYLEGRID2_nEOF'},{av:'edtTestNro_Visible',ctrl:'TESTNRO',prop:'Visible'},{av:'dynavImptliqcod'},{av:'AV114impTLiqCod',fld:'vIMPTLIQCOD',pic:''},{av:'AV44eliminarLiquidaciones',fld:'vELIMINARLIQUIDACIONES',pic:''},{av:'AV48correrRelacionada',fld:'vCORRERRELACIONADA',pic:''},{av:'AV68CorrerSoloPendientes',fld:'vCORRERSOLOPENDIENTES',pic:''},{av:'AV79JorVsMen',fld:'vJORVSMEN',pic:''},{av:'AV80CompensarPlus',fld:'vCOMPENSARPLUS',pic:''},{av:'AV115eliminarliquidacionesreplica',fld:'vELIMINARLIQUIDACIONESREPLICA',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV12anio',fld:'vANIO',pic:'ZZZ9',hsh:true},{av:'AV43date',fld:'vDATE',pic:'',hsh:true},{av:'AV128Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV47bonoProdConCodigo',fld:'vBONOPRODCONCODIGO',pic:'',hsh:true},{av:'AV64ConCodigo',fld:'vCONCODIGO',pic:'',hsh:true},{av:'AV125vaciaFecha',fld:'vVACIAFECHA',pic:'',hsh:true},{av:'AV96testImportes1',fld:'vTESTIMPORTES1',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV90testImportes2',fld:'vTESTIMPORTES2',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV93testImportes3',fld:'vTESTIMPORTES3',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("'DOINI'",",oparms:[{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("'DOPROBARTODOS'","{handler:'e16BL2',iparms:[{av:'AV66pararEnError',fld:'vPARARENERROR',pic:''},{av:'AV79JorVsMen',fld:'vJORVSMEN',pic:''},{av:'AV81testSuelLegNumero',fld:'vTESTSUELLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV12anio',fld:'vANIO',pic:'ZZZ9',hsh:true},{av:'AV43date',fld:'vDATE',pic:'',hsh:true},{av:'AV100sueldoMensuales',fld:'vSUELDOMENSUALES',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV63TestOK',fld:'vTESTOK',pic:''},{av:'AV44eliminarLiquidaciones',fld:'vELIMINARLIQUIDACIONES',pic:''},{av:'AV68CorrerSoloPendientes',fld:'vCORRERSOLOPENDIENTES',pic:''},{av:'AV48correrRelacionada',fld:'vCORRERRELACIONADA',pic:''},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV128Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'FREESTYLEGRID2_nFirstRecordOnPage'},{av:'FREESTYLEGRID2_nEOF'},{av:'edtTestNro_Visible',ctrl:'TESTNRO',prop:'Visible'},{av:'dynavImptliqcod'},{av:'AV114impTLiqCod',fld:'vIMPTLIQCOD',pic:''},{av:'AV80CompensarPlus',fld:'vCOMPENSARPLUS',pic:''},{av:'AV115eliminarliquidacionesreplica',fld:'vELIMINARLIQUIDACIONESREPLICA',pic:''},{av:'AV47bonoProdConCodigo',fld:'vBONOPRODCONCODIGO',pic:'',hsh:true},{av:'AV64ConCodigo',fld:'vCONCODIGO',pic:'',hsh:true},{av:'AV125vaciaFecha',fld:'vVACIAFECHA',pic:'',hsh:true},{av:'AV96testImportes1',fld:'vTESTIMPORTES1',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV90testImportes2',fld:'vTESTIMPORTES2',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV93testImportes3',fld:'vTESTIMPORTES3',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV56leg1_LegNumero',fld:'vLEG1_LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV55leg2_LegNumero',fld:'vLEG2_LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV49TestNro',fld:'vTESTNRO',pic:''},{av:'AV75comparar',fld:'vCOMPARAR',pic:''},{av:'AV78plus',fld:'vPLUS',pic:''},{av:'AV101valorHoraJor',fld:'vVALORHORAJOR',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV42auxCantMeses',fld:'vAUXCANTMESES',pic:'ZZZ9'},{av:'AV69adicionalConCodigo',fld:'vADICIONALCONCODIGO',pic:''},{av:'AV46Mes',fld:'vMES',pic:'Z9'},{av:'AV45TLiqCod',fld:'vTLIQCOD',pic:''}]");
      setEventMetadata("'DOPROBARTODOS'",",oparms:[{av:'AV63TestOK',fld:'vTESTOK',pic:''},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV49TestNro',fld:'vTESTNRO',pic:''},{av:'AV56leg1_LegNumero',fld:'vLEG1_LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV55leg2_LegNumero',fld:'vLEG2_LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV75comparar',fld:'vCOMPARAR',pic:''},{av:'AV78plus',fld:'vPLUS',pic:''},{av:'AV45TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV46Mes',fld:'vMES',pic:'Z9'},{av:'AV69adicionalConCodigo',fld:'vADICIONALCONCODIGO',pic:''},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("'DOINIAPL'","{handler:'e17BL2',iparms:[]");
      setEventMetadata("'DOINIAPL'",",oparms:[]}");
      setEventMetadata("'DOCORREGIRCORHETESCONCPEOT'","{handler:'e18BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("'DOCORREGIRCORHETESCONCPEOT'",",oparms:[]}");
      setEventMetadata("'DOACTUALIZARTOPES'","{handler:'e19BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("'DOACTUALIZARTOPES'",",oparms:[]}");
      setEventMetadata("'DOCREARFULANOS'","{handler:'e20BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOCREARFULANOS'",",oparms:[]}");
      setEventMetadata("'DODUPLICARLEGAJO'","{handler:'e21BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV102multiLegNumero',fld:'vMULTILEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV103multiCant',fld:'vMULTICANT',pic:'ZZZ9'}]");
      setEventMetadata("'DODUPLICARLEGAJO'",",oparms:[]}");
      setEventMetadata("'DOFIXESCALASNOVIEMBRE'","{handler:'e22BL2',iparms:[]");
      setEventMetadata("'DOFIXESCALASNOVIEMBRE'",",oparms:[]}");
      setEventMetadata("'DOPRELIQUIDACIONES'","{handler:'e11BL1',iparms:[]");
      setEventMetadata("'DOPRELIQUIDACIONES'",",oparms:[]}");
      setEventMetadata("'DOUSERACTION5'","{handler:'e12BL1',iparms:[{av:'AV109SVGValor',fld:'vSVGVALOR',pic:''}]");
      setEventMetadata("'DOUSERACTION5'",",oparms:[{av:'lblTestsvg_Caption',ctrl:'TESTSVG',prop:'Caption'}]}");
      setEventMetadata("'DOFORMULA'","{handler:'e13BL1',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOFORMULA'",",oparms:[]}");
      setEventMetadata("'DOREGEX'","{handler:'e23BL2',iparms:[{av:'AV110palabraAAAAMM',fld:'vPALABRAAAAAMM',pic:''}]");
      setEventMetadata("'DOREGEX'",",oparms:[]}");
      setEventMetadata("'DOIMPORTARTODOSPROA'","{handler:'e24BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOIMPORTARTODOSPROA'",",oparms:[]}");
      setEventMetadata("'DOIMPORTARTODOSLSDPROA'","{handler:'e25BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV124mesNro',fld:'vMESNRO',pic:'ZZZ9'}]");
      setEventMetadata("'DOIMPORTARTODOSLSDPROA'",",oparms:[]}");
      setEventMetadata("'DOREPLICARIMPORTADAS'","{handler:'e26BL2',iparms:[{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV112otraEmpCod',fld:'vOTRAEMPCOD',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV113impLiqPeriodo',fld:'vIMPLIQPERIODO',pic:''},{av:'dynavImptliqcod'},{av:'AV114impTLiqCod',fld:'vIMPTLIQCOD',pic:''},{av:'AV115eliminarliquidacionesreplica',fld:'vELIMINARLIQUIDACIONESREPLICA',pic:''}]");
      setEventMetadata("'DOREPLICARIMPORTADAS'",",oparms:[]}");
      setEventMetadata("'DOHTTP'","{handler:'e14BL1',iparms:[]");
      setEventMetadata("'DOHTTP'",",oparms:[]}");
      setEventMetadata("'DOCALCCONTR'","{handler:'e27BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOCALCCONTR'",",oparms:[]}");
      setEventMetadata("'DOINIMENUUSU'","{handler:'e28BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("'DOINIMENUUSU'",",oparms:[]}");
      setEventMetadata("'DODELETECUENTAS'","{handler:'e29BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DODELETECUENTAS'",",oparms:[]}");
      setEventMetadata("'DOINIPERMAS'","{handler:'e30BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOINIPERMAS'",",oparms:[]}");
      setEventMetadata("'DOELIMINADUP'","{handler:'e31BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOELIMINADUP'",",oparms:[]}");
      setEventMetadata("'DOGENERAAUXFALTANTES'","{handler:'e32BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV123DLiqPeriodo',fld:'vDLIQPERIODO',pic:''}]");
      setEventMetadata("'DOGENERAAUXFALTANTES'",",oparms:[]}");
      setEventMetadata("'DOCORRIGEIMP'","{handler:'e33BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOCORRIGEIMP'",",oparms:[]}");
      setEventMetadata("'DOINISUELDOSLEGAJOS'","{handler:'e34BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV125vaciaFecha',fld:'vVACIAFECHA',pic:'',hsh:true}]");
      setEventMetadata("'DOINISUELDOSLEGAJOS'",",oparms:[]}");
      setEventMetadata("'DOUSERACTION6'","{handler:'e35BL2',iparms:[]");
      setEventMetadata("'DOUSERACTION6'",",oparms:[]}");
      setEventMetadata("'DOUSERACTION7'","{handler:'e36BL2',iparms:[]");
      setEventMetadata("'DOUSERACTION7'",",oparms:[]}");
      setEventMetadata("'DOUSERACTION8'","{handler:'e37BL2',iparms:[]");
      setEventMetadata("'DOUSERACTION8'",",oparms:[]}");
      setEventMetadata("'DOUSERACTION9'","{handler:'e38BL2',iparms:[]");
      setEventMetadata("'DOUSERACTION9'",",oparms:[]}");
      setEventMetadata("'DOUSERACTION4'","{handler:'e39BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV99testSuelLegNumero4',fld:'vTESTSUELLEGNUMERO4',pic:'ZZZZZZZ9'},{av:'AV12anio',fld:'vANIO',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("'DOUSERACTION4'",",oparms:[]}");
      setEventMetadata("'DOUSERACTION3'","{handler:'e40BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV86testSuelLegNumero3',fld:'vTESTSUELLEGNUMERO3',pic:'ZZZZZZZ9'},{av:'AV12anio',fld:'vANIO',pic:'ZZZ9',hsh:true},{av:'AV93testImportes3',fld:'vTESTIMPORTES3',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("'DOUSERACTION3'",",oparms:[{av:'AV94testImportes3B',fld:'vTESTIMPORTES3B',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV95diferencia3',fld:'vDIFERENCIA3',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]}");
      setEventMetadata("'DOUSERACTION2CONCEPTOS'","{handler:'e41BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("'DOUSERACTION2CONCEPTOS'",",oparms:[]}");
      setEventMetadata("'DOUSERACTION2'","{handler:'e42BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV84testSuelLegNumero2',fld:'vTESTSUELLEGNUMERO2',pic:'ZZZZZZZ9'},{av:'AV128Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV12anio',fld:'vANIO',pic:'ZZZ9',hsh:true},{av:'AV90testImportes2',fld:'vTESTIMPORTES2',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("'DOUSERACTION2'",",oparms:[{av:'AV91testImportes2B',fld:'vTESTIMPORTES2B',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV92diferencia2',fld:'vDIFERENCIA2',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]}");
      setEventMetadata("'DOUSERACTION1'","{handler:'e43BL2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV81testSuelLegNumero',fld:'vTESTSUELLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV12anio',fld:'vANIO',pic:'ZZZ9',hsh:true},{av:'AV96testImportes1',fld:'vTESTIMPORTES1',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("'DOUSERACTION1'",",oparms:[{av:'AV97testImportes1B',fld:'vTESTIMPORTES1B',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV98diferencia1',fld:'vDIFERENCIA1',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'}]}");
      setEventMetadata("'BOTONPRUEBA'","{handler:'e44BL2',iparms:[{av:'AV44eliminarLiquidaciones',fld:'vELIMINARLIQUIDACIONES',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'A1083TestNro',fld:'TESTNRO',pic:'ZZZ9',hsh:true},{av:'AV12anio',fld:'vANIO',pic:'ZZZ9',hsh:true},{av:'AV43date',fld:'vDATE',pic:'',hsh:true},{av:'AV100sueldoMensuales',fld:'vSUELDOMENSUALES',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV68CorrerSoloPendientes',fld:'vCORRERSOLOPENDIENTES',pic:''},{av:'AV48correrRelacionada',fld:'vCORRERRELACIONADA',pic:''},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV63TestOK',fld:'vTESTOK',pic:''},{av:'AV128Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'FREESTYLEGRID2_nFirstRecordOnPage'},{av:'FREESTYLEGRID2_nEOF'},{av:'edtTestNro_Visible',ctrl:'TESTNRO',prop:'Visible'},{av:'dynavImptliqcod'},{av:'AV114impTLiqCod',fld:'vIMPTLIQCOD',pic:''},{av:'AV79JorVsMen',fld:'vJORVSMEN',pic:''},{av:'AV80CompensarPlus',fld:'vCOMPENSARPLUS',pic:''},{av:'AV115eliminarliquidacionesreplica',fld:'vELIMINARLIQUIDACIONESREPLICA',pic:''},{av:'AV47bonoProdConCodigo',fld:'vBONOPRODCONCODIGO',pic:'',hsh:true},{av:'AV64ConCodigo',fld:'vCONCODIGO',pic:'',hsh:true},{av:'AV125vaciaFecha',fld:'vVACIAFECHA',pic:'',hsh:true},{av:'AV96testImportes1',fld:'vTESTIMPORTES1',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV90testImportes2',fld:'vTESTIMPORTES2',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV93testImportes3',fld:'vTESTIMPORTES3',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV56leg1_LegNumero',fld:'vLEG1_LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV55leg2_LegNumero',fld:'vLEG2_LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV49TestNro',fld:'vTESTNRO',pic:''},{av:'AV75comparar',fld:'vCOMPARAR',pic:''},{av:'AV78plus',fld:'vPLUS',pic:''},{av:'AV101valorHoraJor',fld:'vVALORHORAJOR',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV42auxCantMeses',fld:'vAUXCANTMESES',pic:'ZZZ9'},{av:'AV69adicionalConCodigo',fld:'vADICIONALCONCODIGO',pic:''},{av:'AV46Mes',fld:'vMES',pic:'Z9'},{av:'AV45TLiqCod',fld:'vTLIQCOD',pic:''}]");
      setEventMetadata("'BOTONPRUEBA'",",oparms:[{av:'AV49TestNro',fld:'vTESTNRO',pic:''},{av:'AV56leg1_LegNumero',fld:'vLEG1_LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV55leg2_LegNumero',fld:'vLEG2_LEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV75comparar',fld:'vCOMPARAR',pic:''},{av:'AV78plus',fld:'vPLUS',pic:''},{av:'AV13LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV45TLiqCod',fld:'vTLIQCOD',pic:''},{av:'AV46Mes',fld:'vMES',pic:'Z9'},{av:'AV63TestOK',fld:'vTESTOK',pic:''},{av:'AV69adicionalConCodigo',fld:'vADICIONALCONCODIGO',pic:''},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true}]}");
      setEventMetadata("NULL","{handler:'valid_Testnro',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
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
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV114impTLiqCod = "" ;
      AV43date = GXutil.nullDate() ;
      AV128Pgmname = "" ;
      AV47bonoProdConCodigo = "" ;
      AV64ConCodigo = "" ;
      AV125vaciaFecha = GXutil.nullDate() ;
      AV96testImportes1 = DecimalUtil.ZERO ;
      AV90testImportes2 = DecimalUtil.ZERO ;
      AV93testImportes3 = DecimalUtil.ZERO ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      A1086TestNombre = "" ;
      AV49TestNro = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV75comparar = "" ;
      AV69adicionalConCodigo = "" ;
      AV45TLiqCod = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtnini_Jsonclick = "" ;
      AV100sueldoMensuales = DecimalUtil.ZERO ;
      AV101valorHoraJor = DecimalUtil.ZERO ;
      Freestylegrid2Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      bttBtnprobartodos_Jsonclick = "" ;
      bttBtniniapl_Jsonclick = "" ;
      bttBtncorregircorhetesconcpeot_Jsonclick = "" ;
      bttBtnactualizartopes_Jsonclick = "" ;
      bttBtncrearfulanos_Jsonclick = "" ;
      bttBtnduplicarlegajo_Jsonclick = "" ;
      bttBtnfixescalasnoviembre_Jsonclick = "" ;
      bttBtnpreliquidaciones_Jsonclick = "" ;
      lblAyuda_Jsonclick = "" ;
      AV109SVGValor = "" ;
      lblTestsvg_Jsonclick = "" ;
      bttBtnuseraction5_Jsonclick = "" ;
      bttBtnformula_Jsonclick = "" ;
      AV111expresion = "" ;
      AV110palabraAAAAMM = "" ;
      bttBtnregex_Jsonclick = "" ;
      bttBtnimportartodosproa_Jsonclick = "" ;
      bttBtnimportartodoslsdproa_Jsonclick = "" ;
      AV113impLiqPeriodo = GXutil.nullDate() ;
      bttBtnreplicarimportadas_Jsonclick = "" ;
      bttBtnhttp_Jsonclick = "" ;
      bttBtncalccontr_Jsonclick = "" ;
      bttBtninimenuusu_Jsonclick = "" ;
      bttBtndeletecuentas_Jsonclick = "" ;
      bttBtninipermas_Jsonclick = "" ;
      bttBtneliminadup_Jsonclick = "" ;
      AV123DLiqPeriodo = GXutil.nullDate() ;
      bttBtngeneraauxfaltantes_Jsonclick = "" ;
      bttBtncorrigeimp_Jsonclick = "" ;
      bttBtninisueldoslegajos_Jsonclick = "" ;
      bttBtnuseraction6_Jsonclick = "" ;
      bttBtnuseraction7_Jsonclick = "" ;
      bttBtnuseraction8_Jsonclick = "" ;
      bttBtnuseraction9_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A1091TestError = "" ;
      A1092TestNeto = DecimalUtil.ZERO ;
      A1087TestDescripcion = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H00BL2_A3CliCod = new int[1] ;
      H00BL2_A32TLiqCod = new String[] {""} ;
      H00BL2_A340TliqDesc = new String[] {""} ;
      H00BL3_A1086TestNombre = new String[] {""} ;
      H00BL3_A1083TestNro = new short[1] ;
      H00BL3_A1090TestVueltas = new short[1] ;
      H00BL3_A1088TestSegLiq = new short[1] ;
      H00BL3_A1084TestOK = new boolean[] {false} ;
      H00BL3_A1087TestDescripcion = new String[] {""} ;
      H00BL3_A1092TestNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00BL3_A1091TestError = new String[] {""} ;
      AV97testImportes1B = DecimalUtil.ZERO ;
      AV98diferencia1 = DecimalUtil.ZERO ;
      AV91testImportes2B = DecimalUtil.ZERO ;
      AV92diferencia2 = DecimalUtil.ZERO ;
      AV94testImportes3B = DecimalUtil.ZERO ;
      AV95diferencia3 = DecimalUtil.ZERO ;
      hsh = "" ;
      Freestylegrid2Row = new com.genexus.webpanels.GXWebRow();
      AV82LegSuelFecha = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      AV83LegSuelImporte = new GXSimpleCollection<java.math.BigDecimal>(java.math.BigDecimal.class, "internal", "");
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      AV39collectionLegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      GXv_int4 = new int[1] ;
      AV116LiqPeriodo = GXutil.nullDate() ;
      AV118LiqSacLog = "" ;
      GXv_int8 = new byte[1] ;
      AV11LegLicenIni = GXutil.nullDate() ;
      AV10LegLicenFin = GXutil.nullDate() ;
      AV14adelVacMesProxConCodigo = "" ;
      AV15adelantoIniFecha = GXutil.nullDate() ;
      AV16adelantoHastaFecha = GXutil.nullDate() ;
      AV17errores = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40eneroFecha = GXutil.nullDate() ;
      AV60febreroFecha = GXutil.nullDate() ;
      AV76marzoFecha = GXutil.nullDate() ;
      AV77auxConCodigo = "" ;
      GXv_boolean12 = new boolean[1] ;
      AV41diciembreFecha = GXutil.nullDate() ;
      AV61OpeCliId = "" ;
      AV57abrilFecha = GXutil.nullDate() ;
      AV62domesticaConCodigo = "" ;
      AV70otrConCodigo = "" ;
      AV72otrSACConCodigo = "" ;
      AV73otrOSConCodigo = "" ;
      AV74otrSegSocConCodigo = "" ;
      AV71fecha = GXutil.nullDate() ;
      AV58mayoFecha = GXutil.nullDate() ;
      AV59junioFecha = GXutil.nullDate() ;
      AV67bonoProdConCodigo2 = "" ;
      GXv_objcol_svchar11 = new GXSimpleCollection[1] ;
      GXt_char10 = "" ;
      GXt_char9 = "" ;
      GXv_char5 = new String[1] ;
      GXv_int2 = new short[1] ;
      GXv_char6 = new String[1] ;
      bttBtnuseraction4_Jsonclick = "" ;
      bttBtnuseraction3_Jsonclick = "" ;
      bttBtnuseraction2conceptos_Jsonclick = "" ;
      bttBtnuseraction2_Jsonclick = "" ;
      bttBtnuseraction1_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subFreestylegrid2_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      bttBotonprueba_Jsonclick = "" ;
      subFreestylegrid2_Header = "" ;
      Freestylegrid2Column = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.pruebas__default(),
         new Object[] {
             new Object[] {
            H00BL2_A3CliCod, H00BL2_A32TLiqCod, H00BL2_A340TliqDesc
            }
            , new Object[] {
            H00BL3_A1086TestNombre, H00BL3_A1083TestNro, H00BL3_A1090TestVueltas, H00BL3_A1088TestSegLiq, H00BL3_A1084TestOK, H00BL3_A1087TestDescripcion, H00BL3_A1092TestNeto, H00BL3_A1091TestError
            }
         }
      );
      AV128Pgmname = "Pruebas" ;
      /* GeneXus formulas. */
      AV128Pgmname = "Pruebas" ;
      Gx_err = (short)(0) ;
      edtavTestimportes1_Enabled = 0 ;
      edtavTestimportes1b_Enabled = 0 ;
      edtavDiferencia1_Enabled = 0 ;
      edtavTestimportes2_Enabled = 0 ;
      edtavTestimportes2b_Enabled = 0 ;
      edtavDiferencia2_Enabled = 0 ;
      edtavTestimportes3_Enabled = 0 ;
      edtavTestimportes3b_Enabled = 0 ;
      edtavDiferencia3_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte AV46Mes ;
   private byte nDonePA ;
   private byte subFreestylegrid2_Backcolorstyle ;
   private byte FREESTYLEGRID2_nEOF ;
   private byte AV32estado ;
   private byte GXv_int8[] ;
   private byte subFreestylegrid2_Backstyle ;
   private byte subFreestylegrid2_Allowselection ;
   private byte subFreestylegrid2_Allowhovering ;
   private byte subFreestylegrid2_Allowcollapsing ;
   private byte subFreestylegrid2_Collapsed ;
   private short AV8EmpCod ;
   private short AV12anio ;
   private short wbEnd ;
   private short wbStart ;
   private short AV42auxCantMeses ;
   private short AV103multiCant ;
   private short AV124mesNro ;
   private short AV112otraEmpCod ;
   private short A1088TestSegLiq ;
   private short A1090TestVueltas ;
   private short A1083TestNro ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV85paicod ;
   private short GXt_int1 ;
   private short AV117liquidaSac ;
   private short AV31x ;
   private short AV33sleep ;
   private short AV65i ;
   private short GXv_int2[] ;
   private int edtTestNro_Visible ;
   private int nRC_GXsfl_63 ;
   private int nGXsfl_63_idx=1 ;
   private int AV7CliCod ;
   private int AV13LegNumero ;
   private int AV56leg1_LegNumero ;
   private int AV55leg2_LegNumero ;
   private int edtavAuxcantmeses_Enabled ;
   private int edtavPararenerror_Enabled ;
   private int edtavSueldomensuales_Enabled ;
   private int edtavValorhorajor_Enabled ;
   private int AV102multiLegNumero ;
   private int edtavMultilegnumero_Enabled ;
   private int edtavMulticant_Enabled ;
   private int edtavSvgvalor_Enabled ;
   private int edtavExpresion_Enabled ;
   private int edtavPalabraaaaamm_Enabled ;
   private int edtavMesnro_Enabled ;
   private int edtavOtraempcod_Enabled ;
   private int edtavImpliqperiodo_Enabled ;
   private int edtavDliqperiodo_Enabled ;
   private int gxdynajaxindex ;
   private int subFreestylegrid2_Islastpage ;
   private int edtavTestimportes1_Enabled ;
   private int edtavTestimportes1b_Enabled ;
   private int edtavDiferencia1_Enabled ;
   private int edtavTestimportes2_Enabled ;
   private int edtavTestimportes2b_Enabled ;
   private int edtavDiferencia2_Enabled ;
   private int edtavTestimportes3_Enabled ;
   private int edtavTestimportes3b_Enabled ;
   private int edtavDiferencia3_Enabled ;
   private int AV81testSuelLegNumero ;
   private int AV84testSuelLegNumero2 ;
   private int AV86testSuelLegNumero3 ;
   private int AV99testSuelLegNumero4 ;
   private int AV87convenioCliCod ;
   private int AV20LiqNro ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int edtavTestsuellegnumero4_Enabled ;
   private int edtavTestsuellegnumero3_Enabled ;
   private int edtavTestsuellegnumero2_Enabled ;
   private int edtavTestsuellegnumero_Enabled ;
   private int idxLst ;
   private int subFreestylegrid2_Backcolor ;
   private int subFreestylegrid2_Allbackcolor ;
   private int subFreestylegrid2_Selectedindex ;
   private int subFreestylegrid2_Selectioncolor ;
   private int subFreestylegrid2_Hoveringcolor ;
   private long FREESTYLEGRID2_nCurrentRecord ;
   private long FREESTYLEGRID2_nFirstRecordOnPage ;
   private java.math.BigDecimal AV96testImportes1 ;
   private java.math.BigDecimal AV90testImportes2 ;
   private java.math.BigDecimal AV93testImportes3 ;
   private java.math.BigDecimal AV100sueldoMensuales ;
   private java.math.BigDecimal AV101valorHoraJor ;
   private java.math.BigDecimal A1092TestNeto ;
   private java.math.BigDecimal AV97testImportes1B ;
   private java.math.BigDecimal AV98diferencia1 ;
   private java.math.BigDecimal AV91testImportes2B ;
   private java.math.BigDecimal AV92diferencia2 ;
   private java.math.BigDecimal AV94testImportes3B ;
   private java.math.BigDecimal AV95diferencia3 ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_63_idx="0001" ;
   private String edtTestNro_Internalname ;
   private String AV114impTLiqCod ;
   private String AV128Pgmname ;
   private String AV47bonoProdConCodigo ;
   private String AV64ConCodigo ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String A1086TestNombre ;
   private String AV75comparar ;
   private String AV69adicionalConCodigo ;
   private String AV45TLiqCod ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String TempTags ;
   private String bttBtnini_Internalname ;
   private String bttBtnini_Jsonclick ;
   private String edtavAuxcantmeses_Internalname ;
   private String edtavAuxcantmeses_Jsonclick ;
   private String edtavPararenerror_Internalname ;
   private String edtavPararenerror_Jsonclick ;
   private String edtavSueldomensuales_Internalname ;
   private String edtavSueldomensuales_Jsonclick ;
   private String edtavValorhorajor_Internalname ;
   private String edtavValorhorajor_Jsonclick ;
   private String divTablecontent_Internalname ;
   private String sStyleString ;
   private String subFreestylegrid2_Internalname ;
   private String bttBtnprobartodos_Internalname ;
   private String bttBtnprobartodos_Jsonclick ;
   private String bttBtniniapl_Internalname ;
   private String bttBtniniapl_Jsonclick ;
   private String bttBtncorregircorhetesconcpeot_Internalname ;
   private String bttBtncorregircorhetesconcpeot_Jsonclick ;
   private String bttBtnactualizartopes_Internalname ;
   private String bttBtnactualizartopes_Jsonclick ;
   private String bttBtncrearfulanos_Internalname ;
   private String bttBtncrearfulanos_Jsonclick ;
   private String bttBtnduplicarlegajo_Internalname ;
   private String bttBtnduplicarlegajo_Jsonclick ;
   private String edtavMultilegnumero_Internalname ;
   private String edtavMultilegnumero_Jsonclick ;
   private String edtavMulticant_Internalname ;
   private String edtavMulticant_Jsonclick ;
   private String bttBtnfixescalasnoviembre_Internalname ;
   private String bttBtnfixescalasnoviembre_Jsonclick ;
   private String bttBtnpreliquidaciones_Internalname ;
   private String bttBtnpreliquidaciones_Jsonclick ;
   private String lblAyuda_Internalname ;
   private String lblAyuda_Jsonclick ;
   private String edtavSvgvalor_Internalname ;
   private String lblTestsvg_Internalname ;
   private String lblTestsvg_Caption ;
   private String lblTestsvg_Jsonclick ;
   private String bttBtnuseraction5_Internalname ;
   private String bttBtnuseraction5_Jsonclick ;
   private String bttBtnformula_Internalname ;
   private String bttBtnformula_Jsonclick ;
   private String edtavExpresion_Internalname ;
   private String AV111expresion ;
   private String edtavExpresion_Jsonclick ;
   private String edtavPalabraaaaamm_Internalname ;
   private String AV110palabraAAAAMM ;
   private String edtavPalabraaaaamm_Jsonclick ;
   private String bttBtnregex_Internalname ;
   private String bttBtnregex_Jsonclick ;
   private String bttBtnimportartodosproa_Internalname ;
   private String bttBtnimportartodosproa_Jsonclick ;
   private String edtavMesnro_Internalname ;
   private String edtavMesnro_Jsonclick ;
   private String bttBtnimportartodoslsdproa_Internalname ;
   private String bttBtnimportartodoslsdproa_Jsonclick ;
   private String edtavOtraempcod_Internalname ;
   private String edtavOtraempcod_Jsonclick ;
   private String edtavImpliqperiodo_Internalname ;
   private String edtavImpliqperiodo_Jsonclick ;
   private String bttBtnreplicarimportadas_Internalname ;
   private String bttBtnreplicarimportadas_Jsonclick ;
   private String bttBtnhttp_Internalname ;
   private String bttBtnhttp_Jsonclick ;
   private String bttBtncalccontr_Internalname ;
   private String bttBtncalccontr_Jsonclick ;
   private String bttBtninimenuusu_Internalname ;
   private String bttBtninimenuusu_Jsonclick ;
   private String bttBtndeletecuentas_Internalname ;
   private String bttBtndeletecuentas_Jsonclick ;
   private String bttBtninipermas_Internalname ;
   private String bttBtninipermas_Jsonclick ;
   private String bttBtneliminadup_Internalname ;
   private String bttBtneliminadup_Jsonclick ;
   private String edtavDliqperiodo_Internalname ;
   private String edtavDliqperiodo_Jsonclick ;
   private String bttBtngeneraauxfaltantes_Internalname ;
   private String bttBtngeneraauxfaltantes_Jsonclick ;
   private String bttBtncorrigeimp_Internalname ;
   private String bttBtncorrigeimp_Jsonclick ;
   private String bttBtninisueldoslegajos_Internalname ;
   private String bttBtninisueldoslegajos_Jsonclick ;
   private String bttBtnuseraction6_Internalname ;
   private String bttBtnuseraction6_Jsonclick ;
   private String bttBtnuseraction7_Internalname ;
   private String bttBtnuseraction7_Jsonclick ;
   private String bttBtnuseraction8_Internalname ;
   private String bttBtnuseraction8_Jsonclick ;
   private String bttBtnuseraction9_Internalname ;
   private String bttBtnuseraction9_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtTestError_Internalname ;
   private String edtTestNeto_Internalname ;
   private String edtTestDescripcion_Internalname ;
   private String edtTestSegLiq_Internalname ;
   private String edtTestVueltas_Internalname ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String edtavTestimportes1_Internalname ;
   private String edtavTestimportes1b_Internalname ;
   private String edtavDiferencia1_Internalname ;
   private String edtavTestimportes2_Internalname ;
   private String edtavTestimportes2b_Internalname ;
   private String edtavDiferencia2_Internalname ;
   private String edtavTestimportes3_Internalname ;
   private String edtavTestimportes3b_Internalname ;
   private String edtavDiferencia3_Internalname ;
   private String edtavTestsuellegnumero_Internalname ;
   private String edtavTestsuellegnumero2_Internalname ;
   private String edtavTestsuellegnumero3_Internalname ;
   private String edtavTestsuellegnumero4_Internalname ;
   private String hsh ;
   private String bttBotonprueba_Caption ;
   private String bttBotonprueba_Internalname ;
   private String AV14adelVacMesProxConCodigo ;
   private String AV77auxConCodigo ;
   private String AV61OpeCliId ;
   private String AV62domesticaConCodigo ;
   private String AV70otrConCodigo ;
   private String AV72otrSACConCodigo ;
   private String AV73otrOSConCodigo ;
   private String AV74otrSegSocConCodigo ;
   private String AV67bonoProdConCodigo2 ;
   private String GXt_char10 ;
   private String GXt_char9 ;
   private String GXv_char5[] ;
   private String GXv_char6[] ;
   private String tblUnnamedtable4_Internalname ;
   private String edtavTestsuellegnumero4_Jsonclick ;
   private String bttBtnuseraction4_Internalname ;
   private String bttBtnuseraction4_Jsonclick ;
   private String tblUnnamedtable3_Internalname ;
   private String edtavTestsuellegnumero3_Jsonclick ;
   private String bttBtnuseraction3_Internalname ;
   private String bttBtnuseraction3_Jsonclick ;
   private String edtavTestimportes3_Jsonclick ;
   private String edtavTestimportes3b_Jsonclick ;
   private String edtavDiferencia3_Jsonclick ;
   private String bttBtnuseraction2conceptos_Internalname ;
   private String bttBtnuseraction2conceptos_Jsonclick ;
   private String tblUnnamedtable2_Internalname ;
   private String edtavTestsuellegnumero2_Jsonclick ;
   private String bttBtnuseraction2_Internalname ;
   private String bttBtnuseraction2_Jsonclick ;
   private String edtavTestimportes2_Jsonclick ;
   private String edtavTestimportes2b_Jsonclick ;
   private String edtavDiferencia2_Jsonclick ;
   private String tblUnnamedtable1_Internalname ;
   private String edtavTestsuellegnumero_Jsonclick ;
   private String bttBtnuseraction1_Internalname ;
   private String bttBtnuseraction1_Jsonclick ;
   private String edtavTestimportes1_Jsonclick ;
   private String edtavTestimportes1b_Jsonclick ;
   private String edtavDiferencia1_Jsonclick ;
   private String sGXsfl_63_fel_idx="0001" ;
   private String subFreestylegrid2_Class ;
   private String subFreestylegrid2_Linesclass ;
   private String tblFreestylegrid2layouttable_Internalname ;
   private String ROClassString ;
   private String edtTestNeto_Jsonclick ;
   private String GXCCtl ;
   private String edtTestSegLiq_Jsonclick ;
   private String edtTestVueltas_Jsonclick ;
   private String tblUsertable2_Internalname ;
   private String bttBotonprueba_Jsonclick ;
   private String tblUnnamedtablecontentfsfreestylegrid2_Internalname ;
   private String edtTestNro_Jsonclick ;
   private String subFreestylegrid2_Header ;
   private java.util.Date AV43date ;
   private java.util.Date AV125vaciaFecha ;
   private java.util.Date AV113impLiqPeriodo ;
   private java.util.Date AV123DLiqPeriodo ;
   private java.util.Date AV116LiqPeriodo ;
   private java.util.Date AV11LegLicenIni ;
   private java.util.Date AV10LegLicenFin ;
   private java.util.Date AV15adelantoIniFecha ;
   private java.util.Date AV16adelantoHastaFecha ;
   private java.util.Date AV40eneroFecha ;
   private java.util.Date AV60febreroFecha ;
   private java.util.Date AV76marzoFecha ;
   private java.util.Date AV41diciembreFecha ;
   private java.util.Date AV57abrilFecha ;
   private java.util.Date AV71fecha ;
   private java.util.Date AV58mayoFecha ;
   private java.util.Date AV59junioFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_63_Refreshing=false ;
   private boolean AV44eliminarLiquidaciones ;
   private boolean AV48correrRelacionada ;
   private boolean AV68CorrerSoloPendientes ;
   private boolean AV79JorVsMen ;
   private boolean AV80CompensarPlus ;
   private boolean AV115eliminarliquidacionesreplica ;
   private boolean AV63TestOK ;
   private boolean AV78plus ;
   private boolean wbLoad ;
   private boolean AV66pararEnError ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean A1084TestOK ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV119LiqSac ;
   private boolean GXv_boolean12[] ;
   private boolean Cond_result ;
   private String AV109SVGValor ;
   private String A1091TestError ;
   private String A1087TestDescripcion ;
   private String AV118LiqSacLog ;
   private GXSimpleCollection<Short> AV49TestNro ;
   private GXSimpleCollection<Integer> AV39collectionLegNumero ;
   private com.genexus.webpanels.GXWebGrid Freestylegrid2Container ;
   private com.genexus.webpanels.GXWebRow Freestylegrid2Row ;
   private com.genexus.webpanels.GXWebColumn Freestylegrid2Column ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkavEliminarliquidaciones ;
   private ICheckbox chkavCorrerrelacionada ;
   private ICheckbox chkavCorrersolopendientes ;
   private ICheckbox chkavJorvsmen ;
   private ICheckbox chkavCompensarplus ;
   private ICheckbox chkTestOK ;
   private HTMLChoice dynavImptliqcod ;
   private ICheckbox chkavEliminarliquidacionesreplica ;
   private IDataStoreProvider pr_default ;
   private int[] H00BL2_A3CliCod ;
   private String[] H00BL2_A32TLiqCod ;
   private String[] H00BL2_A340TliqDesc ;
   private String[] H00BL3_A1086TestNombre ;
   private short[] H00BL3_A1083TestNro ;
   private short[] H00BL3_A1090TestVueltas ;
   private short[] H00BL3_A1088TestSegLiq ;
   private boolean[] H00BL3_A1084TestOK ;
   private String[] H00BL3_A1087TestDescripcion ;
   private java.math.BigDecimal[] H00BL3_A1092TestNeto ;
   private String[] H00BL3_A1091TestError ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<java.math.BigDecimal> AV83LegSuelImporte ;
   private GXSimpleCollection<String> AV17errores ;
   private GXSimpleCollection<String> GXv_objcol_svchar11[] ;
   private GXSimpleCollection<java.util.Date> AV82LegSuelFecha ;
}

final  class pruebas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00BL2", "SELECT CliCod, TLiqCod, TliqDesc FROM TipoLiquidacion ORDER BY TliqDesc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00BL3", "SELECT TestNombre, TestNro, TestVueltas, TestSegLiq, TestOK, TestDescripcion, TestNeto, TestError FROM Test ORDER BY TestNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

